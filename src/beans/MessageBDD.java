package beans;

import java.util.ArrayList;

public class MessageBDD implements MessageStoreI {

	static ArrayList<MessageBean> messages = new ArrayList<>();

	public static void addMessage(String userName, String message) {
		messages.add(new MessageBean(userName, message));
	}

	public static void addMessage(MessageBean message) {
		messages.add(message);
	}

	public static ArrayList<MessageBean> getMessage() {

		return messages;
	}

	public static void main(String[] args) {
		addMessage("sam", "Hello world");
		addMessage("world", "Hello Sam");

		for (MessageBean m : messages) {
			System.out.println(m.getUserName() + "\t:\t" + m.getContent());
		}

	}

}
