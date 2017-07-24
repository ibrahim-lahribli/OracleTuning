package service;

import java.util.List;

import dao.TbsDao;
import model.Dbf;
import model.tableSpaceFactory.TableSpace;
import model.tableSpaceFactory.TableSpacePermanent;
import model.tableSpaceFactory.TableSpaceTemporary;
import model.tableSpaceFactory.TableSpaceUndo;

public class TbsManagerImpl implements TbsManager {

	@Override
	public TableSpace findOne(String name) {
		return TbsDao.findOne(name);
	}

	@Override
	public List<TableSpace> findAll() {
		return TbsDao.findAll();
	}

	@Override
	public void setDefaultTableSpace(TableSpace tableSpace, String user) {
		TbsDao.setDefaultTableSpace(tableSpace, user);
	}

	@Override
	public void editSize(TableSpace tableSpace, String dataFile, Long size) {
		TbsDao.editSize(tableSpace, dataFile, size);

	}

	@Override
	public void editThreshold(TableSpace tableSpace, Long threshold) {
		TbsDao.editThreshold(tableSpace, threshold);

	}

	@Override
	public void addTbs(TableSpace tableSpace, Dbf dbf) {
		if(tableSpace instanceof TableSpacePermanent)
			TbsDao.addTbs(tableSpace, dbf);
		else if(tableSpace instanceof TableSpaceTemporary)
			TbsDao.addTemporaryTbs(tableSpace, dbf);
		else if(tableSpace instanceof TableSpaceUndo)
			TbsDao.addUndoTbs(tableSpace, dbf);
	}

	@Override
	public void activerTbs(TableSpace tableSpace) {
		TbsDao.activerTbs(tableSpace);
		
	}

	@Override
	public void desactiverTbs(TableSpace tableSpace) {
		TbsDao.desactiverTbs(tableSpace);
		
	}

	@Override
	public double getFreeSpace(TableSpace tableSpace) {
		return TbsDao.getFreeSpace(tableSpace);
	}

	@Override
	public void replaceCurrentUndoTbs(TableSpace tableSpace) {
		TbsDao.replaceCurrentUndoTbs(tableSpace);
		
	}

	@Override
	public void addDbfToTbs(TableSpace tableSpace, Dbf dbf) {
		TbsDao.addDbfToTbs(tableSpace, dbf);
	}

}
