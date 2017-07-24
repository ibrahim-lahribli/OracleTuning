package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Dbf;
import model.RedoFile;
import model.tableSpaceFactory.TableSpace;
import model.tableSpaceFactory.TableSpaceFactory;

public class TbsDao {
	
	public static TableSpace findOne(String name) {
		TableSpaceFactory tableSpaceFactory= new TableSpaceFactory();		
		TableSpace tableSpace=null;
		try {
			DbConfig.Connect();	
			String sql="select b.tablespace_name,a.bytes ,b.CONTENTS,b.status from dba_data_files a ,dba_tablespaces b where a.tablespace_name=b.tablespace_name and b.TABLESPACE_NAME='"+name+"'";    
			//DbConfig.rs = DbConfig.select(sql);
			DbConfig.pst= DbConfig.con.prepareStatement(sql);
            DbConfig.rs= DbConfig.pst.executeQuery(sql);
						    
			while(DbConfig.rs.next()){
				String type=DbConfig.rs.getString("CONTENTS");
				String tbsName=DbConfig.rs.getString("tablespace_name");
				String status=DbConfig.rs.getString("status");
				Long size=DbConfig.rs.getLong("bytes");
				tableSpace=tableSpaceFactory.create(type, tbsName, size, status);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    DbConfig.disconnect();
		return tableSpace;
	}

	
	@SuppressWarnings("null")
	public static List<TableSpace> findAll() {
		TableSpaceFactory tableSpaceFactory= new TableSpaceFactory();
		List<TableSpace> tableSpaces= new ArrayList<TableSpace>();
		TableSpace tableSpace=null;
		try {
			DbConfig.Connect();	
			String sql="select b.tablespace_name,a.bytes ,b.CONTENTS,b.status from dba_data_files a ,dba_tablespaces b where a.tablespace_name=b.tablespace_name";	    
			//DbConfig.rs = DbConfig.select(sql);
			DbConfig.pst= DbConfig.con.prepareStatement(sql);
            DbConfig.rs= DbConfig.pst.executeQuery(sql);
			while(DbConfig.rs.next()){
				String type=DbConfig.rs.getString("CONTENTS");
				String name=DbConfig.rs.getString("tablespace_name");
				String status=DbConfig.rs.getString("status");
				Long size=DbConfig.rs.getLong("bytes");
				tableSpace=tableSpaceFactory.create(type, name, size, status);
				//System.out.println(tableSpace);
				tableSpaces.add(tableSpace);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    DbConfig.disconnect();
		return tableSpaces;
	}

	public static void setDefaultTableSpace(TableSpace tableSpace, String user) {
		try {

			DbConfig.Connect();
			String sql = "alter user " + user.toUpperCase() + " default tablespace " + tableSpace.getName().toUpperCase();
		//DbConfig.update(sql);
			
			DbConfig.pst= DbConfig.con.prepareStatement(sql);
            DbConfig.pst.executeUpdate(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void editSize(TableSpace tableSpace, String dataFile, Long size) {
		try {

			DbConfig.Connect();
			String sql = "ALTER DATABASE DATAFILE '"+dataFile.toUpperCase()+"' RESIZE "+size;
			DbConfig.pst= DbConfig.con.prepareStatement(sql);
            DbConfig.pst.executeUpdate(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void editThreshold(TableSpace tableSpace, Long threshold) {
		try {

			DbConfig.Connect();
			String sql = "{CALL DBMS_SERVER_ALERT.SET_THRESHOLD (Dbms_server_alert.tablespace_pct_full , Dbms_server_alert.operator_ge, 50 , Dbms_server_alert.operator_ge,"+threshold+", 1, 1, NULL ,Dbms_server_alert.object_type_tablespace, '"+tableSpace.getName().toUpperCase()+"')}";
			DbConfig.cl= DbConfig.con.prepareCall(sql);
			DbConfig.cl.execute();
			
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void addTbs(TableSpace tableSpace, Dbf dataFile) {
		try {

			DbConfig.Connect();
			String sql = "create tablespace " + tableSpace.getName() + " datafile '" + dataFile.getName()
					+ "' size 10m extent management local uniform size " + tableSpace.getSize() + "";
			DbConfig.pst= DbConfig.con.prepareStatement(sql);
            DbConfig.pst.executeUpdate(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void addUndoTbs(TableSpace tableSpace, Dbf dataFile){
		try {

			DbConfig.Connect();
			String sql = "create undo tablespace " + tableSpace.getName() + " datafile '" + dataFile.getPath()
					+ "' size 10m autoextend on";
			DbConfig.pst= DbConfig.con.prepareStatement(sql);
            DbConfig.pst.executeUpdate(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void addTemporaryTbs(TableSpace tableSpace, Dbf dataFile){
		try {

			DbConfig.Connect();
			String sql = "create temporary tablespace " + tableSpace.getName() + " datafile '" + dataFile.getPath()
					+ "' size 5m";
			DbConfig.pst= DbConfig.con.prepareStatement(sql);
            DbConfig.pst.executeUpdate(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void activerTbs(TableSpace tableSpace) {
		try {

			DbConfig.Connect();
			String sql = "alter tablespace "+tableSpace.getName()+" online";
			DbConfig.pst= DbConfig.con.prepareStatement(sql);
            DbConfig.pst.executeUpdate(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void desactiverTbs(TableSpace tableSpace) {
		try {

			DbConfig.Connect();
			String sql = "alter tablespace "+tableSpace.getName()+" offline";
			DbConfig.pst= DbConfig.con.prepareStatement(sql);
            DbConfig.pst.executeUpdate(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static double getFreeSpace(TableSpace tableSpace) {
		double freeSpace= 0;
		try {
			DbConfig.Connect();	
			String sql="select b.free_bytes from dba_data_files a, (select file_id, SUM(bytes) free_bytes from dba_free_space b group by file_id) b where a.file_id=b.file_id and a.tablespace_name ='"+tableSpace.getName().toUpperCase()+"'";	    
			//DbConfig.rs = DbConfig.select(sql);
			DbConfig.pst= DbConfig.con.prepareStatement(sql);
            DbConfig.rs= DbConfig.pst.executeQuery(sql);
			if(DbConfig.rs.next()){
				freeSpace=DbConfig.rs.getDouble("free_bytes");							
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    DbConfig.disconnect();
		return freeSpace;
	}

	public static void replaceCurrentUndoTbs(TableSpace tableSpace) {
		try {

			DbConfig.Connect();
			String sql = "alter system set undo_tablespace = "+tableSpace.getName();
			DbConfig.pst= DbConfig.con.prepareStatement(sql);
            DbConfig.pst.executeUpdate(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}


	}

	public static void addDbfToTbs(TableSpace tableSpace, Dbf dbf) {
		
		try {
			DbConfig.Connect();
			String sql = "ALTER TABLESPACE "+tableSpace.getName().toUpperCase()+" add datafile '"+dbf.getPath()+"' size 10M";
			DbConfig.pst= DbConfig.con.prepareStatement(sql);
            DbConfig.pst.executeUpdate(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
