public class Game {
	private Parser parser;
	private Player player;
	private Room hall, lectureRoom, computerRoom, office, dongBang, cellar;
	
	/**
	 * Create the game and initialise its internal map.
	 */
	public Game() {
		createRooms();
		player = new Player(hall);
		parser = new Parser();
	}

	/**
	 * Create all the rooms and link their exits together. 방들을 만들고 방의 출구들을 서로 엮어준다.
	 */
	private void createRooms() {

		// create the rooms
		hall = new Room("Hall");
		lectureRoom = new Room("Lecture room");
		dongBang = new Room("Dongari room");
		computerRoom = new Room("Computer room");
		office = new Room("Office");
		cellar = new Room("Cellar");

		// initialise room exits
		hall.setExit("east", lectureRoom);
		hall.setExit("south", computerRoom);
		hall.setExit("west", dongBang);
		
		lectureRoom.setExit("west", hall);
		
		dongBang.setExit("east", hall);
		
		computerRoom.setExit("north", hall);
		computerRoom.setExit("east", office);
		computerRoom.setExit("down", cellar);
		
		cellar.setExit("up", computerRoom);
		
		office.setExit("west", computerRoom);

		computerRoom.addItem(new Item("book", "오래된 마법서", 10));
		dongBang.addItem(new Item("portion", "체력을 5만큼 올려주는 묘약", 5));
		dongBang.addItem(new Item("book", "AI tech book", 7));
		
	}

	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		printWelcome();

		// Enter the main command loop. Here we repeatedly read commands and
		// execute them until the game is over.
		// 명령을 처리하는 주 반복문.
		// 게임이 끝날 때까지 명령을 읽고 명령을 수행하는 일을 반복한다.

		boolean finished = false;
		while (!finished) {
			Command command = parser.getCommand(); // 파싱 후 Command 객체를 반환함에 유의!
			finished = processCommand(command);
		}
		System.out.println("Thank you for playing.  Good bye.");
	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome() {
		System.out.println();
		System.out.println("Welcome to the World of Zuul!");
		System.out.println("World of Zuul is a new, incredibly boring adventure game.");
		System.out.println("Type 'help' if you need help.");
		System.out.println();

		
		printLocationInfo(player.getCurrentRoom());
	}

	/**
	 * 주어진 방에 관한 정보를 출력한다.
	 * @param room 정보를 출력할 방
	 */
	private void printLocationInfo(Room room) {
		// 현재 있는 방에 대한 정보 출력
		System.out.println("Location: " + room.getLongDescription());
	}
	/**
	 * Given a command, process (that is: execute) the command.
	 * 
	 * @param command 처리할 명령.
	 * @return true (게임을 끝내는 명령인 경우), false (그렇지 않은 경우)
	 */
	private boolean processCommand(Command command) {
		boolean wantToQuit = false;

		if (command.isUnknown()) {
			System.out.println("Unknown command...");
			return false;
		}

		// Command 객체는 commandWord와 secondWord를 필드로 갖는다.
		// 모든 Command에는 commandWord가 들어 있다(필수).
		// secondWord는 있을 수도 있고 없을 수도 있다(옵션).
		// 없는 경우 null.
		String commandWord = command.getCommandWord();
		if (commandWord.equals("help")) {
			printHelp();
		} else if (commandWord.equals("go")) {
			goRoom(command);
		} else if (commandWord.equals("look")) {
			look();
		} else if (commandWord.equals("eat")) {
			eat();
		} else if (commandWord.equals("back")) {
			back(command);
		}else if (commandWord.equals("quit")) {
			wantToQuit = quit(command);
		}

		return wantToQuit;
	}

	// implementations of user commands:

	/*
	 * Print out some help information. Here we print some stupid, cryptic message
	 * and a list of the command words.
	 */
	private void printHelp() {
		System.out.println("Commands: " + parser.getCommandList());
	}

	/**
	 * 현재 방의 상세 정보를 출력한다.
	 */
	private void look() {
		printLocationInfo(player.getCurrentRoom());
	}
	
	private void eat() {
		System.out.println("Delicious!");
	}
	
	private void back(Command command) {
		if (command.hasSecondWord()) {
			System.out.println("한 단계 전으로만 돌아갈 수 있습니다.");
			System.out.println("back 명령어는 두 번째 단어를 가질 수 없습니다.");
			return;
		}
		
		player.back();
		printLocationInfo(player.getCurrentRoom());
	}
	
	/*
	 * go 명령일 때 이 메소드가 실행된다. "두번째단어"로 옮겨갈 방향이 주어져야 한다. 
	 * 주어진 방향으로의 이동을 시도한다. 
	 * 그 방향으로 방이 연결되어 있지 않은 경우에는 에러 메세지를 출력한다.
	 */
	private void goRoom(Command command) {
		if (!command.hasSecondWord()) {
			// Command에 second word가 없는 경우
			System.out.println("Where to go?");
			return;
		}

		String direction = command.getSecondWord();
		//지정된 방향으로 이동한다.
		if (player.moveTo(direction) == -1)
			System.out.println("그쪽으로는 출구가 없습니다."); //실패한 경우
		else
			printLocationInfo(player.getCurrentRoom()); //성공한 경우
	}

	/*
	 * "Quit" was entered. Check the rest of the command to see whether we really
	 * quit the game.
	 * 
	 * @return true, if this command quits the game, false otherwise.
	 */
	private boolean quit(Command command) {
		// quit 명령어는 second word를 갖지 말아야 한다.
		if (command.hasSecondWord()) {
			System.out.println("Quit what?");
			return false;
		} else {
			return true; // signal that we want to quit
		}
	}

	public static void main(String[] args) {
		(new Game()).play();
	}
}
