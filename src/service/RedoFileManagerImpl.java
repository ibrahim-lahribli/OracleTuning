package service;


import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.DbConfig;
import dao.RedoFileDao;
import model.RedoFile;

public class RedoFileManagerImpl implements RedoFileManager{

	RedoFileDao rfd=new RedoFileDao();
	public void addFile(String path, int size) {
		// TODO Auto-generated method stub
		
		rfd.addFile(path, size);
		
	}

	
	public void removeFile(int group) {
		// TODO Auto-generated method stub
		rfd.removeFile(group);
		
	}

	public void switchLogFile() {
		// TODO Auto-generated method stub
		rfd.switchLogFile();
	}
		
	
	public List<RedoFile> RedoFilesInfo() {
	
		return rfd.RedoFilesInfo();

	}

	

}
