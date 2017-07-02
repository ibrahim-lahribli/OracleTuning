package service;

import java.util.List;

import model.Dbf;
import model.tableSpaceFactory.TableSpace;

public interface DbfManager {
	
	public void addDbf(TableSpace tableSpace);
	public void deleteDbf(TableSpace tableSpace);
	public Dbf findOne(String name);
	public List<Dbf> findAll(TableSpace tableSpace);
	public void editSize(Dbf dbf, Long size);
	
}
