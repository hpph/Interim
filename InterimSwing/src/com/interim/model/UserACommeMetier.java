package com.interim.model;
// default package
// Generated 06-mai-2014 5:17:18 by Hibernate Tools 4.0.0

/**
 * UserACommeMetier generated by hbm2java
 */
public class UserACommeMetier implements java.io.Serializable/*, Comparable<UserACommeMetier>*/ {

	private UserACommeMetierId id;
	private Metiers metiers;
	private Users users;
	private String cv;

	@Override
	public String toString() {
		return "UserACommeMetier [id=" + id + ", metiers=" + metiers
				+ ", cv=" + cv + "]";
	}

	public UserACommeMetier() {
	}

	public UserACommeMetier(UserACommeMetierId id, Metiers metiers,
			Users users, String cv) {
		this.id = id;
		this.metiers = metiers;
		this.users = users;
		this.cv = cv;
	}

	public UserACommeMetierId getId() {
		return this.id;
	}

	public void setId(UserACommeMetierId id) {
		this.id = id;
	}

	public Metiers getMetiers() {
		return this.metiers;
	}

	public void setMetiers(Metiers metiers) {
		this.metiers = metiers;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getCv() {
		return this.cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

/*	@Override
	public int compareTo(UserACommeMetier o) {
		// TODO Auto-generated method stub
		return this.getMetiers().getMetier().compareTo(o.getMetiers().getMetier());
	}
*/
}