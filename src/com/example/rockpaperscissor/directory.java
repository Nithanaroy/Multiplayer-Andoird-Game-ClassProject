package com.example.rockpaperscissor;

public class directory {

	private String u_name;
	private String u_age;
	private String u_sex;
	private int u_win;
	private int u_loss;
	
	
	public directory () {
		
	}
	
	public directory (String u_name, String u_age, String u_sex, int u_win, int u_loss) {
		this.u_name = u_name;
		this.u_age = u_age;
		this.u_sex = u_sex;
		this.u_win = u_win;
		this.u_loss = u_loss;
	}
	
	
	public String get_name() {
		return this.u_name;
	}
	
	public String get_age() {
		return this.u_age;
	}
	
	public String get_sex() {
		return this.u_sex;
	}
	
	public int get_win() {
		return this.u_win;
	}
	
	public int get_loss() {
		return this.u_loss;
	}
	
	public void set_name(String u_name) {
		this.u_name = u_name;
	}
	
	public void set_age(String u_age) {
		this.u_age = u_age;
	}
	
	public void set_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	
	public void set_win(int u_win) {
		this.u_win = u_win;
	}
	
	public void set_loss(int u_loss) {
		this.u_loss = u_loss;
	}
	
}
