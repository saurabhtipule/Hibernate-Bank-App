package com.cjc.bankApplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT_DTLS")
public class Account {

	@Id
	@GeneratedValue
	@Column(name = "ACCOUNT_NUMBER")
	private int acNo;

	@Column(name = "ACCOUNT_NAME")
	private String acName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "ADHAR_NUMBER")
	private long adharNo;

	@Column(name = "MOBILE_NUMBER")
	private long mobileNo;

	@Column(name = "PAN_NUMBER")
	private String panNo;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "BALANCE")
	private double balance;

	public int getAcNo() {
		return acNo;
	}

	public void setAcNo(int acNo) {
		this.acNo = acNo;
	}

	public String getAcName() {
		return acName;
	}

	public void setAcName(String acName) {
		this.acName = acName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return " Account Number :" + acNo + "\n Account Holder Name :" + acName + "\n Account Holder Address :" + address + "\n Account Holder AdharNo :" + adharNo
				+ "\n Account Holder MobileNo :" + mobileNo + "\n Account Holder PanNo :" + panNo + "\n Account Holder Gender :" + gender + "\n Account Holder Balance :" + balance;
	}
	
	

}
