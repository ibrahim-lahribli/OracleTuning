package model;

public class LibraryCache {
	 private int pins ;//  Number of times a PIN was requested for objects of this namespace
	    private int reloads ;// Any PIN of an object that is not the first PIN performed since the object handle was created, and which requires loading the object from disk
	    double R ; // coeficient calculer pour savoir si on augment ou pas la share pool size 
	   
	    
	    public LibraryCache() {
	    }

	    
	  

		public LibraryCache( int pins, int reloads, double R ) {
	        
	        this.pins = pins;
	        this.reloads = reloads;
	        this.R=R;
	    }

	   

	    public int getPins() {
	        return pins;
	    }

	    public void setPins(int pins) {
	        this.pins = pins;
	    }

	    public int getReloads() {
	        return reloads;
	    }

	    public void setReloads(int reloads) {
	        this.reloads = reloads;
	    }

}
