package service;

import java.util.List;

import model.RedoFile;

public interface RedoFileManager {
	
	public void addFile(String path, int size);
	public void removeFile(String path);
	public void setSize(String path, int size);
	public List<RedoFile> AllRedoFiles();

}

