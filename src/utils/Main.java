package utils;

import java.util.List;

import dao.DictionaryCacheDAO;
import dao.LibraryCacheDAO;
import dao.LogBfDao;
import dao.RedoFileDao;
import dao.TbsDao;
import model.Dbf;
import model.DictionaryCache;
import model.LibraryCache;
import model.RedoFile;
import model.tableSpaceFactory.TableSpace;
import model.tableSpaceFactory.TableSpaceFactory;
import service.DictionaryCacheManager;
import service.LibraryCacheManager;
import service.LogBfManager;
import service.LogBfManagerImpl;
import service.RedoFileManager;
import service.TbsManager;
import service.TbsManagerImpl;

public class Main {

	public static void main(String[] args) {
		
		LibraryCacheManager libM=new LibraryCacheDAO();
		DictionaryCacheManager dICM=new DictionaryCacheDAO();
		RedoFileManager rdf=new RedoFileDao();
		LogBfManager lbf=new LogBfDao();
		TbsManager tbsManager= new TbsManagerImpl();
		TableSpaceFactory tableSpaceFactory = new TableSpaceFactory();
		
//		TableSpace undoTbs = tableSpaceFactory.create(TableSpaceType.undo.toString(), "undoTbs2", 100000L, "ONLINE");
		//Dbf dbf= new Dbf("dbf7", "D:\\DATA7.DBF", 200L, tbsManager.findOne("tbsTest"));
////		
////		tbsManager.addTbs(tableSpace, dbf);
//		tbsManager.addTbs(undoTbs, dbf);
//		
		
//		tbsManager.replaceCurrentUndoTbs(tbsManager.findOne("UNDOTBS2"));
		//tbsManager.addDbfToTbs(tbsManager.findOne("USERS"), dbf);
		
		
		/*List<TableSpace> tablespaces = tbsManager.findAll();
		for (TableSpace tableSpace : tablespaces) {
			System.out.println(tableSpace);
		}
		/*TbsDao tbsDao= new TbsDao();
		List<Integer> liste=tbsDao.test();
		for (Integer integer : liste) {
			System.out.println(integer);
		}*/
		/*System.out.println("**********************");
		System.out.println(tbsManager.findOne("USERS"));*/
		
		//tbsManager.setDefaultTableSpace(tbsManager.findOne("TBS"), "US");
		//tbsManager.editSize(tbsManager.findOne("TBS"),"dbf2", 300000L);
		//tbsManager.editThreshold(tbsManager.findOne("TBS"), 95L);
		//System.out.println(lbf.getLogBuffer());
		//lbf.setSize(8000000);
		//lbf.increaseSize(0.05);
		//lbf.decreaseSize(0.45);
		//tbsManager.activerTbs(tbsManager.findOne("TBS"));
		//System.out.println((int)tbsManager.getFreeSpace(tbsManager.findOne("TBS")));
		//System.out.println(rdf.AllRedoFiles());
		
		//rdf.addFile("D:\\Redo4.rdo", 9);
		//rdf.removeFile(4);
		//List<RedoFile> redoFiles = rdf.RedoFilesInfo();
		//for (RedoFile redoFile : redoFiles) {
		//	System.out.println(redoFile);
		//}
		//rdf.switchLogFile();
		
		//libM.getR();
		//DictionaryCache DictionaryCache = dICM.getR();
		//System.out.println(DictionaryCache);
		//LibraryCache libraryCache =libM.getR();
		//System.out.println(libraryCache);
		
		//System.out.println(lbf.getLogbufferState());
		
	}
}
