package com.stackroute.ServiceCenterService.model;


//import java.util.UUID
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "user")
public class User {
	@Id
	private String id;
    private long zipCode;
    private String username;
    private String address;
    @Field
	@Indexed(unique = true)
	private String email;
    private String password;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String  password) {
		this.password=hashPassword(password);
	}

	public void setEmail(String email) {
		this.email = email;
	}
	private String hashPassword(String ps) {
		int workload =12;
		String salt=BCrypt.gensalt(workload);
		return BCrypt.hashpw(ps,salt);
	}
	public boolean passwordMatches(String ps) {
		return BCrypt.checkpw(ps,this.password);
	}

	public User() {
		super();
	}
}
