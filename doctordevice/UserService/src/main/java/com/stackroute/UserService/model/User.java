package com.stackroute.UserService.model;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Document(collection = "user")
public class User implements Serializable {
    @Id
    private UUID id;

    @Field
    @Indexed(unique = true)
    private String email;
    private String password;
    private String userName;
    private String address;
    private List<String> gadgetList;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getGadgetList() {
        return gadgetList;
    }

    public void setGadgetList(List<String> gadgetList) {
        this.gadgetList = gadgetList;
    }

    private String hashPassword(String pwd) {
        int workload = 12;
        String salt = BCrypt.gensalt(workload);
        return BCrypt.hashpw(pwd, salt);
    }

    public boolean passwordMatches(String pwd) {
        return BCrypt.checkpw(pwd, this.password);
    }

    public User(UUID id, String email, String password, String userName, List<String> gadgetList) {
        super();
        this.id = id;
        this.email = email;
        setPassword(password);
        this.userName = userName;
        this.address = address;
        this.gadgetList = gadgetList;
    }

    public User() {
        super();
    }
}
