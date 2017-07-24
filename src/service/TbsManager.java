package service;

import java.util.List;

import model.Dbf;
import model.tableSpaceFactory.TableSpace;

public interface TbsManager {
	
	public void addTbs(TableSpace tableSpace, Dbf dbf);
	public TableSpace findOne(String name);
	public List<TableSpace> findAll();
	public void setDefaultTableSpace(TableSpace tableSpace, String user);
	public void editSize(TableSpace tableSpace, String dataFile, Long size);
	public void editThreshold(TableSpace tableSpace, Long threshold);
	public void activerTbs(TableSpace tableSpace);
	public void desactiverTbs(TableSpace tableSpace);
	public double getFreeSpace(TableSpace tableSpace);
	public void replaceCurrentUndoTbs(TableSpace tableSpace);
	public void addDbfToTbs(TableSpace tableSpace,Dbf dbf);
	
}
