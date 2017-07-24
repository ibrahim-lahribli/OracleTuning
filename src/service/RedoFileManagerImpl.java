package service;


import java.util.List;

import dao.RedoFileDao;
import model.RedoFile;

public class RedoFileManagerImpl {

	RedoFileDao rfd=new RedoFileDao();
	public void addFile(String path, int size) {
		// TODO Auto-generated method stub
		
		rfd.addFile(path, size);
	}

	
	public void removeFile(String path) {
		// TODO Auto-generated method stub
		rfd.removeFile( path);
		
	}


	public void setSize( String path, int size) {
		// TODO Auto-generated method stub
		rfd.setSize( path,  size);
		
	}

	public List<RedoFile> AllRedoFiles() {
		// TODO Auto-generated method stub
		RedoFile rf=null;
		
		rfd.AllRedoFiles();
		
	      
		 return (List<RedoFile>) rf;
		
	}

	

}
