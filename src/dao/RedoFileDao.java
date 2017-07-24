package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import service.RedoFileManager;
import model.RedoFile;

public  class RedoFileDao implements RedoFileManager{
	@Override
	public void addFile(String path, int size) {
		// TODO Auto-generated method stub
		 try {
	            
	            DbConfig.Connect();
	            String sql="alter database add LOGFILE('"+path+"') SIZE'"+path+"'";
	            DbConfig.update(sql);
	            DbConfig.disconnect();
	            
	           
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
	        }
		
	}

	@Override
	public void removeFile(String path) {
		// TODO Auto-generated method stub
		 try {
	            
	            DbConfig.Connect();
	            String sql="alter database drop LOGFILE MEMBER '"+path+"'";
	            DbConfig.update(sql);
	            DbConfig.disconnect();
	            
	           
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(RedoFile.class.getName()).log(Level.SEVERE, null, ex);
	        }
		
	}

	@Override
	public void setSize(String path, int size) {
		// TODO Auto-generated method stub
		try{
			DbConfig.Connect();
	        String sql="alter database modify LOGFILE MEMBER '"+path+"' '"+size+"'";
	        DbConfig.update(sql);
	        DbConfig.disconnect();
			
			
		 } catch (SQLException ex) {
	         JOptionPane.showMessageDialog(null, ex);
	        
	    }
		
	}

	public List<RedoFile> AllRedoFiles() {
		// TODO Auto-generated method stub
		RedoFile rf=null;
		  try {
	            
	            DbConfig.Connect();
	            String sql="SELECT * FROM v$logfile ";
	            DbConfig.pst= DbConfig.con.prepareStatement(sql);
	            DbConfig.rs= DbConfig.pst.executeQuery(sql);

	        } catch (SQLException ex) {
	             JOptionPane.showMessageDialog(null, ex);
	            
	        }
	      
		 return (List<RedoFile>) rf;
		
	}
}
