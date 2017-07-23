package service;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import dao.DbConfig;
import model.RedoFile;

public class RedoFileManagerImpl implements RedoFileManager{

	@Override
	public void addFile(RedoFile redoFile) {
		// TODO Auto-generated method stub
		 try {
	            
	            DbConfig.Connect();
	            String sql="alter database add LOGFILE('"+redoFile.getPath()+"') '"+redoFile.getSize()+"'";
	            DbConfig.update(sql);
	            DbConfig.disconnect();
	            
	           
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
	        }
		
	}

	@Override
	public void removeFile(RedoFile redoFile) {
		// TODO Auto-generated method stub
		 try {
	            
	            DbConfig.Connect();
	            String sql="alter database drop LOGFILE MEMBER '"+redoFile.getPath()+"'";
	            DbConfig.update(sql);
	            DbConfig.disconnect();
	            
	           
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
	        }
		
	}

	@Override
	public void setSize(RedoFile redoFile, int size) {
		// TODO Auto-generated method stub
		try{
			DbConfig.Connect();
	        String sql="alter database modify LOGFILE MEMBER '"+redoFile.getPath()+"' '"+redoFile.getSize()+"'";
	        DbConfig.update(sql);
	        DbConfig.disconnect();
			
			
		 } catch (SQLException ex) {
	         JOptionPane.showMessageDialog(null, ex);
	        
	    }
		
	}

	

}
