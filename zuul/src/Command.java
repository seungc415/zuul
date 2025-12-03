

public class Command {
	private String commandWord;
	private String secondWord;

	/**
	 * Command 객체를 구성한다. 첫 단어와 두 번째 단어가 제공되어야 한다. 두 단어 중 어느 하나가 null일 수 있으며 두 단어 모두가
	 * null일 수도 있다.
	 * 
	 * @param firstWord  명령의 첫 단어. 입력된 명령어가 유효하지 않은 경우에는 null.
	 * @param secondWord 명령의 두 번째 단어.
	 */
	public Command(String firstWord, String secondWord) {
		commandWord = firstWord;
		this.secondWord = secondWord;
	}

	/**
	 * Return the command word (the first word) of this command. If the command was
	 * not understood, the result is null.
	 * 
	 * @return The command word.
	 */
	public String getCommandWord() {
		return commandWord;
	}

	/**
	 * @return The second word of this command. Returns null if there was no second
	 *         word.
	 */
	public String getSecondWord() {
		return secondWord;
	}

	/**
	 * 올바르지(유효하지) 않은 명령어인가?
	 * 
	 * @return true if this command was not understood.
	 */
	public boolean isUnknown() {
		return (commandWord == null);
	}

	/**
	 * 이 Command가 두번째단어를 가지고 있는가?
	 * 
	 * @return true if the command has a second word.
	 */
	public boolean hasSecondWord() {
		return (secondWord != null);
	}
}
