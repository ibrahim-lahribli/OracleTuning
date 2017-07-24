package model;

public class RedoFile {
	private String name;
	private String path;
	private int size;
	private int group;
	private String status;
	private String member;
	
	
	
	public RedoFile(int group, String status, String member) {
		super();
		this.group = group;
		this.status = status;
		this.member = member;
	}

	@Override
	public String toString() {
		return "RedoFile [group=" + group + ", status=" + status + ", member="
				+ member + "]";
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public RedoFile(String path, int size) {
		super();
		this.path = path;
		this.size = size;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}
	
	

}
