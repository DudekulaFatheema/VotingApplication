package com.voter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name = "voter")
	public class Voter {
		
		@Id
		@GeneratedValue
		private int voterId;
		
		private String name;
		
		private String gender;
		
		private int age;
		
		
		
		private long phoneNumber;

		private String userName;
		
		
		private String passWord;
		
		private String candId;
		
		
		public Voter() {
			super();
			// TODO Auto-generated constructor stub
		}


		

		public Voter(int voterId, String name, String gender, int age, long phoneNumber, String userName, String passWord,
				String candId) {
			super();
			this.voterId = voterId;
			this.name = name;
			this.gender = gender;
			this.age = age;
			this.phoneNumber = phoneNumber;
			this.userName = userName;
			this.passWord = passWord;
			this.candId = candId;
		}




		public int getVoterId() {
			return voterId;
		}




		public void setVoterId(int voterId) {
			this.voterId = voterId;
		}




		public String getName() {
			return name;
		}




		public void setName(String name) {
			this.name = name;
		}




		public String getGender() {
			return gender;
		}




		public void setGender(String gender) {
			this.gender = gender;
		}




		public int getAge() {
			return age;
		}




		public void setAge(int age) {
			this.age = age;
		}




		public long getPhoneNumber() {
			return phoneNumber;
		}




		public void setPhoneNumber(long phoneNumber) {
			this.phoneNumber = phoneNumber;
		}




		public String getUserName() {
			return userName;
		}




		public void setUserName(String userName) {
			this.userName = userName;
		}




		public String getPassWord() {
			return passWord;
		}




		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}




		public String getCandId() {
			return candId;
		}




		public void setCandId(String candId) {
			this.candId = candId;
		}




		@Override
		public String toString() {
			return "Voter [voterId=" + voterId + ", name=" + name + ", gender=" + gender + ", age=" + age + ", phoneNumber="
					+ phoneNumber + ", userName=" + userName + ", passWord=" + passWord + ", candId=" + candId + "]";
		}

	}


		


