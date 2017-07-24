package service;

import java.util.List;

import model.RedoFile;

public interface RedoFileManager {
	
	public void addFile(String path, int size);
	public void removeFile(int group);
	public void switchLogFile();
	public List<RedoFile> RedoFilesInfo();

}

