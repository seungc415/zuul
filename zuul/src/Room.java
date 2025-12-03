
public class Room {
	public String description; // 이 Room에 대한 설명.
	public Room northExit; // 북쪽 방향으로 이웃한 Room을 가리키는 참조변수.
	public Room southExit;
	public Room eastExit;
	public Room westExit;

	/**
	 * "description" 설명에 해당하는 Room을 구성한다. 초기에는 exit을 갖지 않는다. "description"은 가령
	 * "과사무실", "실습실", "동아리방" 같은 것이다.
	 * 
	 * @param description 이 방에 관한 설명.
	 */
	public Room(String description) {
		this.description = description;
	}

	/**
	 * 이 방의 출구들을 설정해 준다. 각 방향은 다른 방일 수도 있고 null일 수도 있다(다른 방으로 연결되지 않는 경우).
	 * 
	 * @param north The north exit.
	 * @param east  The east east.
	 * @param south The south exit.
	 * @param west  The west exit.
	 */
	public void setExits(Room north, Room east, Room south, Room west) {
		if (north != null)
			northExit = north;
		if (east != null)
			eastExit = east;
		if (south != null)
			southExit = south;
		if (west != null)
			westExit = west;
	}

	/**
	 * @return The description of the room.
	 */
	public String getDescription() {
		return description;
	}

}
