package service;

import java.util.List;

import model.TableSpace;

public interface TbsManager {
	
	public void addTbs();
	public TableSpace findOne(String name);
	public List<TableSpace> findAll();
	public void setDefaultTableSpace(TableSpace tableSpace);
	public void editSize(TableSpace tableSpace, Long size);
	public void editThreshold(TableSpace tableSpace, Long threshold);
	
}
