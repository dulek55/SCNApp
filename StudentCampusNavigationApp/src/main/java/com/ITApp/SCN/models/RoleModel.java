package com.ITApp.SCN.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Roles")
public class RoleModel {
	
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;
    
    @Column(name = "name")
	private String name;
    
    @ManyToMany(mappedBy = "roles")
    @Column(name = "users")
	private Set<UserModel> users;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
    public Set<UserModel> getUsers() {
        return users;
    }

    public void setUsers(Set<UserModel> users) {
        this.users = users;
    }
    
	
}
