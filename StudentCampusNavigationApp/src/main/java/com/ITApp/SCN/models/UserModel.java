package com.ITApp.SCN.models;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class UserModel {

    @Id
    @Column(name = "UserID")

    @GeneratedValue(strategy = GenerationType.AUTO )
    private long Id;

    @Column(name = "Password")
    private String Password;

    @Column(name = "Name")
    private String Name;
    
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleModel> roles;

    
    public long getUserId(){return Id;}
    public void setUserId(long id){this.Id = Id;}

    public String getUserPassword(){return Password;}
    public void setUserPassword(String Password){this.Password = Password;}

    public String getUserName(){return Name;}
    public void setUserName(String Name){this.Name = Name;}
    
    public Set<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleModel> roles) {
        this.roles = roles;
    }

}