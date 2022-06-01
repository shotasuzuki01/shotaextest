package model;

import java.io.Serializable;

public class User implements Serializable{
	private String 名前;
	private String メール;
	private String お問い合わせ;
	public User(String 名前, String メール, String お問い合わせ) {
		super();
		this.名前 = 名前;
		this.メール = メール;
		this.お問い合わせ = お問い合わせ;
	}
	public String get名前() {
		return 名前;
	}
	public String getメール() {
		return メール;
	}
	public String getお問い合わせ() {
		return お問い合わせ;
	}

}
