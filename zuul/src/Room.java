
public class Room {
	private String description; // 이 Room에 대한 설명.
	private Room northExit; // 북쪽 방향으로 이웃한 Room을 가리키는 참조변수.
	private Room southExit;
	private Room eastExit;
	private Room westExit;

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
	 * 지정된 방향으로 나가려고 할 때 연결되는 Room을 알려준다.
	 * @param direction 나가려고 하는 방향 "north", "east", "south", "west"
	 * @return 나가려고 하는 방향으로 연결된 Room, 그 방향으로 출구가 없으면 null
	 */
	public Room getExit(String direction) {
		Room exit; //direction 방향에 있는 Room
		if("north".equals(direction))
			exit = northExit; 
		else if("east".equals(direction))
			exit = eastExit;
		else if("south".equals(direction))
			exit = southExit;
		else if("west".equals(direction))
			exit = westExit;
		else 
			exit = null;
		return exit;
			
	}
	
	/**
	 * 방의 출구들을 알려주는 문자열을 반환한다.
	 * 문자열 예: "Exits: north west".
	 * @return 출구가 있는 방향들을 알려주는 문자열
	 */
	public String getExitString() {
		StringBuilder s = new StringBuilder("Exits: ");
		if(northExit != null)
			s.append("north ");
		if(eastExit != null)
			s.append("east ");
		if(southExit != null)
			s.append("south ");
		if(westExit != null)
			s.append("west ");
		
		return s.toString();
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
