public class Item {
	private String name;
	private String description;
	private int weight;
	
	public Item(String name, String description, int weight) {
		this.name = name;
		this.description = description;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getWeight() {
		return weight;
	}
	
	/**
	 * 이 아이템에 대한 상세한 설명을 반환한다.
	 * 
	 * @return 이 아이템에 대한 상세한 설명이 들어 있는 문자열
	 */
	public String getLongDescription() {
		return name + " (" + weight + "Kg, " + description + ")";
	}
	
}
