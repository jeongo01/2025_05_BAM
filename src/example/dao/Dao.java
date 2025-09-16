package example.dao;

public class Dao {
	public int lastId;              // 초기값이 0인상태
	
	public int getLastId() {
		return this.lastId + 1;
	}
}