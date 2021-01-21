package com.clown.member.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer memberId;
    private String memberName;
    private Double weight;
    private Double height;
   
    public Double getBmi() {
        return (weight / ((height/100.0)*(height/100.0)));
    }
   
    public Integer getMemberId() {
        return memberId;
    }
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public Double getHeight() {
        return height;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
   
   
}