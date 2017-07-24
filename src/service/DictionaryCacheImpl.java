package service;


import dao.DictionaryCacheDAO;
import model.DictionaryCache;

public class DictionaryCacheImpl {
DictionaryCacheDAO dcd = new DictionaryCacheDAO();

	public DictionaryCache getR() {
		// TODO Auto-generated method stub
		return dcd.getR();
	}


	public void setSize(int size) {
		// TODO Auto-generated method stub
		
		dcd.setSize(size);
	}

}
