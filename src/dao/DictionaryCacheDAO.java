package dao;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.DictionaryCache;
import service.DictionaryCacheManager;

public class DictionaryCacheDAO implements DictionaryCacheManager {
	@Override
	public DictionaryCache getR() {
		// TODO Auto-generated method stub
		DictionaryCache dc=null;
		  try {
	            
	            DbConfig.Connect();
	            String sql="select sum(gets) , sum(getmisses)  , sum(getmisses)/(sum(gets)+sum(getmisses))*100 as R from v$rowcache ";
	            DbConfig.pst= DbConfig.con.prepareStatement(sql);
	            DbConfig.rs= DbConfig.pst.executeQuery(sql);

	        } catch (SQLException ex) {
	             JOptionPane.showMessageDialog(null, ex);
	            
	        }
	      
		 return dc;
	}

	@Override
	public void setSize(int size) {
		// TODO Auto-generated method stub
		try{
			DbConfig.Connect();
	        String sql="ALTER SYSTEM SET SHARED_POOL_SIZE ='"+size+"'";
	        DbConfig.update(sql);
	        DbConfig.disconnect();
			
			
		 } catch (SQLException ex) {
	         JOptionPane.showMessageDialog(null, ex);
	        
	    }
		
	}

}
