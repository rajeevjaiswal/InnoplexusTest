package com.rajeevjaiswal.innoplexustest.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;

public class Contact implements Parcelable {
	private String website;
	private Address address;
	private String phone;
	private String name;
	private Company company;
	private int id;
	private String email;
	private String username;

	public void setWebsite(String website){
		this.website = website;
	}

	public String getWebsite(){
		return website;
	}

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return address;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCompany(Company company){
		this.company = company;
	}

	public Company getCompany(){
		return company;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public static final Comparator<Contact> BY_NAME_ALPHABETICAL = new Comparator<Contact>() {
		@Override
		public int compare(Contact movie, Contact t1) {

			return movie.name.compareTo(t1.name);
		}
	};

	@Override
 	public String toString(){
		return 
			"Contact{" +
			"website = '" + website + '\'' + 
			",address = '" + address + '\'' + 
			",phone = '" + phone + '\'' + 
			",name = '" + name + '\'' + 
			",company = '" + company + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.website);
		dest.writeParcelable(this.address, flags);
		dest.writeString(this.phone);
		dest.writeString(this.name);
		dest.writeParcelable(this.company, flags);
		dest.writeInt(this.id);
		dest.writeString(this.email);
		dest.writeString(this.username);
	}

	public Contact() {
	}

	protected Contact(Parcel in) {
		this.website = in.readString();
		this.address = in.readParcelable(Address.class.getClassLoader());
		this.phone = in.readString();
		this.name = in.readString();
		this.company = in.readParcelable(Company.class.getClassLoader());
		this.id = in.readInt();
		this.email = in.readString();
		this.username = in.readString();
	}

	public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
		@Override
		public Contact createFromParcel(Parcel source) {
			return new Contact(source);
		}

		@Override
		public Contact[] newArray(int size) {
			return new Contact[size];
		}
	};
}
