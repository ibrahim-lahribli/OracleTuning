package model.tableSpaceFactory;

public class TableSpaceFactory {
	
	public TableSpace create(String type, String name, Long size, String status){
		
		switch (type.toLowerCase()) {
		
		case "permanent":
			return new TableSpacePermanent(name, size, status);			

		case "temporary":
			return new TableSpaceTemporary(name, size, status);	
			
		case "undo":
			return new TableSpaceUndo(name, size, status);	
			
		default:
			return null;
		}
	}
	
}
