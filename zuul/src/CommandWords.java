public class CommandWords {
	// 유효한 명령어들을 가지고 있는 상수 배열.
	private static final String[] validCommands = { "go", "quit", "help", "look", "eat" };

	/**
	 * Constructor - initialise the command words.
	 */
	public CommandWords() {
		// nothing to do at the moment...
	}

	/**
	 * 명령어들을 화면에 출력한다.
	 */
	public String getCommandList() {
		StringBuilder sb = new StringBuilder();
		for (String command : validCommands)
			sb.append(command + " ");
		sb.deleteCharAt(sb.length() - 1); //마지막 공백문자 삭제
		return sb.toString();
	}
	
	/**
	 * Check whether a given String is a valid command word. 주어진 문자열이 유효한 명령어인지
	 * 판별한다.
	 * 
	 * @param aString 주어진 문자열.
	 * @return true, if a given string is a valid command, false, if it isn't.
	 */
	public boolean isCommand(String aString) {
		for (int i = 0; i < validCommands.length; i++) {
			if (validCommands[i].equals(aString))
				return true;
		}
		// 이곳에 도달했다면 validCommands에서 sString을 찾지 못한 것이다.
		return false;
	}
}
