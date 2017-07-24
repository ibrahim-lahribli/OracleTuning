package dao;

	import java.sql.SQLException;

	import javax.swing.JOptionPane;

	import dao.DbConfig;
	import model.LibraryCache;
import service.LibraryCacheManager;
public class LibraryCacheDAO implements LibraryCacheManager{

	


		@Override
		public LibraryCache getR() {
			// TODO Auto-generated method stub
			LibraryCache lc=null;
			  try {
		            
		            DbConfig.Connect();
		            String sql="select sum(pins) as Executions , sum(reloads) as Default de cache , sum(reloads)/(sum(pins)+sum(reloads))*100 as R from v$librarycache ";
		            DbConfig.pst= DbConfig.con.prepareStatement(sql);
		            DbConfig.rs= DbConfig.pst.executeQuery(sql);

		        } catch (SQLException ex) {
		             JOptionPane.showMessageDialog(null, ex);
		            
		        }
		      
			 return lc;
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

