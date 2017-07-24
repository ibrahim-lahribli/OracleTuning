package dao;

import java.sql.SQLException;
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
			String sql="select TABLESPACE_NAME, CONTENTS, STATUS, nvl(sum(b.bytes),0) as SIZE from DBA_TABLESPACES where TABLESPACE_NAME="+name;	    
			DbConfig.rs = DbConfig.select(sql);
			while(DbConfig.rs.next()){
				String type=DbConfig.rs.getString("CONTENTS");
				String tbsName=DbConfig.rs.getString("TABLESPACE_NAME");
				String status=DbConfig.rs.getString("STATUS");
				Long size=DbConfig.rs.getLong("SIZE");
				tableSpace=tableSpaceFactory.create(type, tbsName, size, status);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    DbConfig.disconnect();
		return tableSpace;
	}

	public static List<TableSpace> findAll() {
		TableSpaceFactory tableSpaceFactory= new TableSpaceFactory();
		List<TableSpace> tableSpaces= null;
		TableSpace tableSpace=null;
		try {
			DbConfig.Connect();	
			String sql="select TABLESPACE_NAME, CONTENTS, STATUS, nvl(sum(b.bytes),0) as SIZE from DBA_TABLESPACES";	    
			DbConfig.rs = DbConfig.select(sql);
			while(DbConfig.rs.next()){
				String type=DbConfig.rs.getString("CONTENTS");
				String name=DbConfig.rs.getString("TABLESPACE_NAME");
				String status=DbConfig.rs.getString("STATUS");
				Long size=DbConfig.rs.getLong("SIZE");
				tableSpace=tableSpaceFactory.create(type, name, size, status);
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
			String sql = "alter user" + user + "default tablespace" + tableSpace.getName();
			DbConfig.update(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void editSize(TableSpace tableSpace, Dbf dataFile, Long size) {
		try {

			DbConfig.Connect();
			String sql = "ALTER DATABASE DATAFILE '"+dataFile.getPath()+"' RESIZE "+size;
			DbConfig.update(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void editThreshold(TableSpace tableSpace, Long threshold) {
		try {

			DbConfig.Connect();
			String sql = "Execute dbms_server_alter.set_threshold(Dbms_server_alert.tablespace_pct_full,"
							+"Dbms_server_alert.operator_ge, 50,"
							+"Dbms_server_alert.operator_ge,"+threshold+",1,1,NULL"
							+"Dbms_server_alert.object_type_tablespace,'"+tableSpace.getName()+"'";
			DbConfig.update(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void addTbs(TableSpace tableSpace, Dbf dataFile) {
		try {

			DbConfig.Connect();
			String sql = "create tablespace " + tableSpace.getName() + " datafile " + dataFile
					+ " size 10m extent management local uniform size " + tableSpace.getSize() + "";
			DbConfig.update(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void addUndoTbs(TableSpace tableSpace, Dbf dataFile){
		try {

			DbConfig.Connect();
			String sql = "create undo tablespace " + tableSpace.getName() + " datafile " + dataFile
					+ " size 10m autoextent";
			DbConfig.update(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void addTemporaryTbs(TableSpace tableSpace, Dbf dataFile){
		try {

			DbConfig.Connect();
			String sql = "create temporary tablespace " + tableSpace.getName() + " datafile " + dataFile
					+ " size 5m";
			DbConfig.update(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void activerTbs(TableSpace tableSpace) {
		try {

			DbConfig.Connect();
			String sql = "alter tablespace "+tableSpace.getName()+"online";
			DbConfig.update(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void desactiverTbs(TableSpace tableSpace) {
		try {

			DbConfig.Connect();
			String sql = "alter tablespace "+tableSpace.getName()+"offline";
			DbConfig.update(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static double getFreeSpace(TableSpace tableSpace) {
		double freeSpace= 0;
		try {
			DbConfig.Connect();	
			String sql="select b.free_bytes from dba_data_files a, (select file_id, SUM(bytes) free_bytes from dba_free_space b group by file_id) b where a.file_id=b.file_id and a.tablespace_name ="+tableSpace.getName()+"";	    
			DbConfig.rs = DbConfig.select(sql);
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
			DbConfig.update(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}


	}

	public static void addDbfToTbs(TableSpace tableSpace, Dbf dbf) {
		
		try {
			DbConfig.Connect();
			String sql = "alter system set undo_tablespace = "+tableSpace.getName();
			DbConfig.update(sql);
			DbConfig.disconnect();

		} catch (SQLException ex) {
			Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
