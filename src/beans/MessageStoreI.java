package beans;

import java.util.ArrayList;

public interface MessageStoreI {

	static void addMessage(String string, String string2) {
	};

	static void addMessage(MessageBean message) {
	};

	static ArrayList<MessageBean> getMessage() {
		return null;
	};

}
