package service;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.DbConfig;
import model.LogBuffer;

public class LogBfManagerImpl  implements LogBfManager{

	

	@Override
	public LogBuffer getLogBuffer() {
		// TODO Auto-generated method stub
		LogBuffer lg=null;
		  try {
	            
	            DbConfig.Connect();
	            String sql="show parameter LOG_BUFFER ";
	            DbConfig.pst= DbConfig.con.prepareStatement(sql);
	            DbConfig.rs= DbConfig.pst.executeQuery(sql);

	        } catch (SQLException ex) {
	             JOptionPane.showMessageDialog(null, ex);
	            
	        }
	      
		 return lg;
	            
	        
	}

	@Override
	public void increaseSize(int percent) {
		// TODO Auto-generated method stub
		try{
		DbConfig.Connect();
        String sql="update v$sysstat set value='"+(getLogBuffer().getValue()*1.05)+"'";
        DbConfig.update(sql);
        DbConfig.disconnect();
		
		
	 } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, ex);
        
    }
  
		
}

	@Override
	public void decreaseSize(int percent) {
		// TODO Auto-generated method stub
		try{
			DbConfig.Connect();
	        String sql="update v$sysstat set value='"+(getLogBuffer().getValue()*0.95)+"'";
	        DbConfig.update(sql);
	        DbConfig.disconnect();
			
			
		 } catch (SQLException ex) {
	         JOptionPane.showMessageDialog(null, ex);
	        
	    }
	}

	@Override
	public void setSize(int size) {
		// TODO Auto-generated method stub
		
		try{
			DbConfig.Connect();
	        String sql="ALTER SYSTEM SET LOG_BUFFER ='"+getLogBuffer().getValue()+"'";
	        DbConfig.update(sql);
	        DbConfig.disconnect();
			
			
		 } catch (SQLException ex) {
	         JOptionPane.showMessageDialog(null, ex);
	        
	    }
		
	}



}
