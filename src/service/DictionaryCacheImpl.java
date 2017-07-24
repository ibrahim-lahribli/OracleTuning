package service;


import dao.DictionaryCacheDAO;
import model.DictionaryCache;

public class DictionaryCacheImpl {
DictionaryCacheDAO dcd = new DictionaryCacheDAO();

	public DictionaryCache getR() {
		// TODO Auto-generated method stub
		DictionaryCache dc=null;
		 dcd.getR();
	      
		 return dc;
	}


	public void setSize(int size) {
		// TODO Auto-generated method stub
		
		dcd.setSize(size);
	}

}
