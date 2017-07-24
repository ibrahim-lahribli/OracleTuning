package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import service.RedoFileManager;
import model.RedoFile;
import model.tableSpaceFactory.TableSpace;
import model.tableSpaceFactory.TableSpaceFactory;

public  class RedoFileDao implements RedoFileManager{
	@Override
	public void addFile(String path, int size) {
		// TODO Auto-generated method stub
		 try {
	            
	            DbConfig.Connect();
	            String sql="alter database add LOGFILE('"+path+"') SIZE "+size+"M";
	            DbConfig.pst= DbConfig.con.prepareStatement(sql);
	            DbConfig.pst.executeUpdate(sql);
	            DbConfig.disconnect();
	            
	           
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
	        }
		
	}

	@Override
	public void removeFile(int group) {
		// TODO Auto-generated method stub
		 try {
	            
	            DbConfig.Connect();
	            String sql="alter database drop LOGFILE GROUP "+group+" ";
	            DbConfig.pst= DbConfig.con.prepareStatement(sql);
	            DbConfig.pst.executeUpdate(sql);
	            DbConfig.disconnect();
	            
	           
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
	        }
		
	}

	
		
	

	public List<RedoFile> RedoFilesInfo() {
		// TODO Auto-generated method stub
		List<RedoFile> redoFiles = new ArrayList<RedoFile>();
		RedoFile redoFile=null;
		  try {
	            
	            DbConfig.Connect();
	            String sql="SELECT * FROM v$logfile ";
	            DbConfig.pst= DbConfig.con.prepareStatement(sql);
	            DbConfig.rs= DbConfig.pst.executeQuery(sql);
	            while (DbConfig.rs.next()) {
					int group = DbConfig.rs.getInt("GROUP#");
					String status = DbConfig.rs.getString("STATUS");
					String member = DbConfig.rs.getString("MEMBER");
					redoFile = new RedoFile(group, status, member);
					redoFiles.add(redoFile);
				}
	          
	        } catch (SQLException ex) {
	             JOptionPane.showMessageDialog(null, ex);
	            
	        }
	      
		return redoFiles;
		
	}

	@Override
	public void switchLogFile() {
		// TODO Auto-generated method stub
		
		try {
            
            DbConfig.Connect();
            String sql="alter system switch logfile ";
            DbConfig.pst= DbConfig.con.prepareStatement(sql);
            DbConfig.pst.executeUpdate(sql);
            DbConfig.disconnect();
            
           
            
        } catch (SQLException ex) {
            Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}
}
