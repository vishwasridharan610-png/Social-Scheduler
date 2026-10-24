package assignment;
import java.time.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class User {
	private static final AtomicInteger ID_GEN = new AtomicInteger(1);
	private final int id;
	private String name;
	private String email;
	private Role role;


	public User(String name, String email, Role role) {
	this.id = ID_GEN.getAndIncrement();
	this.name = name;
	this.email = email;
	this.role = role;
	}


	public int getId() { return id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public Role getRole() { return role; }
	public void setRole(Role role) { this.role = role; }


	@Override
	public String toString() {
	return id + ": " + name + " (" + role + ")";
	}

}
