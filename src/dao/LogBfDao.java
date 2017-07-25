package dao;



import java.sql.SQLException;

import javax.swing.JOptionPane;

import service.LogBfManager;
import model.LogBuffer;

public class LogBfDao implements LogBfManager {
	
	

	@Override
	public LogBuffer getLogBuffer() {
		// TODO Auto-generated method stub
		LogBuffer lg=null;
		  try {
	            
	            DbConfig.Connect();
	            String sql=" select name,value from v$system_parameter where name like '%log_buffer%' ";
	            
	            DbConfig.pst= DbConfig.con.prepareStatement(sql);
	            DbConfig.rs= DbConfig.pst.executeQuery(sql);
	            
	            if(DbConfig.rs.next()){
	            	lg=new LogBuffer(DbConfig.rs.getInt("value"));
	            }
	           

	        } catch (SQLException ex) {
	             JOptionPane.showMessageDialog(null, ex);
	            
	        }
	      
		 return lg;
	            
	        
	}

	@Override
	public void increaseSize(double percent) {
		// TODO Auto-generated method stub
		
		setSize((int) (getLogBuffer().getValue()*(1+percent)));
		
}

	@Override
	public void decreaseSize(double percent) {

			setSize((int) (getLogBuffer().getValue()*(1-percent)));

	}

	@Override
	public void setSize(int size) {
		// TODO Auto-generated method stub
		
		try{
			DbConfig.Connect();
	        String sql=" alter system set log_buffer="+size+" scope=spfile ";
	        DbConfig.pst= DbConfig.con.prepareStatement(sql);
            DbConfig.rs= DbConfig.pst.executeQuery(sql);
	        DbConfig.disconnect();
			
			
		 } catch (SQLException ex) {
	         JOptionPane.showMessageDialog(null, ex);
	        
	    }
		
	}

	@Override
	public int getLogbufferState() {
		
		int state=0;
		  try {
	            
	            DbConfig.Connect();
	            String sql=" select value from v$sysstat where name ='redo log space requests' ";
	            
	            DbConfig.pst= DbConfig.con.prepareStatement(sql);
	            DbConfig.rs= DbConfig.pst.executeQuery(sql);
	            
	            if(DbConfig.rs.next()){
	            	state=DbConfig.rs.getInt("value");
	            }
	           

	        } catch (SQLException ex) {
	             JOptionPane.showMessageDialog(null, ex);
	            
	        }
		return state;
	      
		 
		
		// TODO Auto-generated method stub
		
		
	}


}
