package web;

public abstract class Model {

	private long id;
	
	public Model(String id) {
		
		if(id != null) {
			this.id = Long.valueOf(id);	
		}
		
	}
	
	public Model() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

}
