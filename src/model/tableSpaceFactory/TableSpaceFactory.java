package model.tableSpaceFactory;

import utils.TableSpaceType;

public class TableSpaceFactory {
	
	public TableSpace create(TableSpaceType type, String name, Long size, String status, double fillingRate){
		
		switch (type) {
		
		case permanent:
			return new TableSpacePermanent(name, size, status, fillingRate);			

		case temporary:
			return new TableSpaceTemporary(name, size, status, fillingRate);	
			
		case undo:
			return new TableSpaceUndo(name, size, status, fillingRate);	
			
		default:
			return null;
		}
	}
	
}
