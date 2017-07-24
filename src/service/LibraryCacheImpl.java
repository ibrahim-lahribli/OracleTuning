package service;

import dao.LibraryCacheDAO;
import model.LibraryCache;

public class LibraryCacheImpl {
LibraryCacheDAO lbd = new LibraryCacheDAO();

	public LibraryCache getR() {
		return lbd.getR();
		
		
	}

	public void setSize(int size) {
		// TODO Auto-generated method stub
		lbd.setSize(size);
	

}
}
