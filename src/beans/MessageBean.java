package beans;

public class MessageBean {

	private String userName;
	private String content;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MessageBean(String userName, String content) {
		super();
		this.userName = userName;
		this.content = content;
	}

	public MessageBean() {
		super();
	}

}
