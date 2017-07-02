package service;

import model.RedoFile;

public interface RedoFileManager {
	
	public void addFile(RedoFile redoFile);
	public void removeFile(RedoFile redoFile);
	public void setSize(RedoFile redoFile, int size);

}
