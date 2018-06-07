package com.ITApp.SCN.models;


import javax.persistence.*;

@Entity
@Table(name = "Visit")
public class VisitModel {
   @Id
   @GeneratedValue
   private int Id;

   @Column(name = "Time")
   private long Time;

   //@OneToMany(mappedBy = "User")
   //private UserModel User;

   //@OneToMany(mappedBy = "Building_id")
   //private BuildingsModel Building_id;


   public int getVisitId(){return Id;}
   public void setVisitId(int id){this.Id = Id;}

   public long getVisitTime(){return Time;}
   public void setVisitId(long Time){this.Time = Time;}

   //public UserModel getVisitUser(){return User;}
   //public void setVisitUser(UserModel User){this.User = User;}

   //public BuildingsModel getVisitBuilding_id(){return Building_id;}
   //public void setVisitBuilding_id(BuildingsModel Building_id){this.Building_id = Building_id;}


}