import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class Room {
	private String description; // 이 Room에 대한 설명.
	private Map<String, Room> exits;
	private Item item;
	
	/**
	 * "description" 설명에 해당하는 Room을 구성한다. 초기에는 exit을 갖지 않는다. "description"은 가령
	 * "과사무실", "실습실", "동아리방" 같은 것이다.
	 * 
	 * @param description 이 방에 관한 설명.
	 */
	public Room(String description) {
		this.description = description;
		exits = new HashMap<String, Room>();
	}
	
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * 지정된 방향으로 나가려고 할 때 연결되는 Room을 알려준다.
	 * @param direction 나가려고 하는 방향 "north", "east", "south", "west"
	 * @return 나가려고 하는 방향으로 연결된 Room, 그 방향으로 출구가 없으면 null
	 */
	public Room getExit(String direction) {
		return exits.get(direction);
			
	}
	
	/**
	 * 방의 출구들을 알려주는 문자열을 반환한다.
	 * 문자열 예: "Exits: north west".
	 * @return 출구가 있는 방향들을 알려주는 문자열
	 */
	public String getExitString() {
		StringBuilder s = new StringBuilder("Exits: ");
		
		//Map에 있는 key들을 모두 읽어냄.
		Set<String> keys = exits.keySet();
				
		//Set에 들어 있는 문자열들을 읽어냄.
		Iterator<String> it = keys.iterator();
		
		while (it.hasNext())
			s.append(it.next() + " "); //s.append(it.next()).append(" ");
		s.deleteCharAt(s.length() - 1);
		
		return s.toString();
	}
	
	/**
	 * 이 Room의 출구들 중 하나를 정해준다.
	 * @param direction 출구 방향
	 * @param neighbor 지정된 방향의 출구에 연결된 Room.
	 */
	public void setExit(String direction, Room neighbor) {
		//neighbor이 null일 때는 map에 넣지 않고 무시한다.
		if (neighbor != null)
			exits.put(direction, neighbor);
	}

	/**
	 * @return The description of the room.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @return Room의 상세한 정보를 모두 모아 문자열로 반환한다.
	 */
	public String getLongDescription() {
		StringBuilder s = new StringBuilder();
		s.append(description + ".\n");
		s.append(getExitString());
		if (item != null) {
			s.append("\n<Item>");
			s.append("\n" + item.getLongDescription());
		}
		return s.toString();
	}

}
