package model;

public class DictionaryCache {
	private int gets ; //Total number of requests for information on the data object
	private int getmisses ; //Number of data requests resulting in cache misses
	 double R ;   
	 
	public DictionaryCache(int gets, int getmisses , double R ) {
		super();
		this.gets = gets;
		this.getmisses = getmisses;
		this.R=R;
	}
	public DictionaryCache() {
		}
	public int getGets() {
		return gets;
	}
	public void setGets(int gets) {
		this.gets = gets;
	}
	public int getGetmisses() {
		return getmisses;
	}
	public void setGetmisses(int getmisses) {
		this.getmisses = getmisses;
	}

}
