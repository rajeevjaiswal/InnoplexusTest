package com.rajeevjaiswal.innoplexustest.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.rajeevjaiswal.innoplexustest.model.Geo;

public class Address implements Parcelable {
	private String zipcode;
	private Geo geo;
	private String suite;
	private String city;
	private String street;

	public void setZipcode(String zipcode){
		this.zipcode = zipcode;
	}

	public String getZipcode(){
		return zipcode;
	}

	public void setGeo(Geo geo){
		this.geo = geo;
	}

	public Geo getGeo(){
		return geo;
	}

	public void setSuite(String suite){
		this.suite = suite;
	}

	public String getSuite(){
		return suite;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setStreet(String street){
		this.street = street;
	}

	public String getStreet(){
		return street;
	}

	@Override
 	public String toString(){
		return 
			"Address{" + 
			"zipcode = '" + zipcode + '\'' + 
			",geo = '" + geo + '\'' + 
			",suite = '" + suite + '\'' + 
			",city = '" + city + '\'' + 
			",street = '" + street + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.zipcode);
		dest.writeParcelable(this.geo, flags);
		dest.writeString(this.suite);
		dest.writeString(this.city);
		dest.writeString(this.street);
	}

	public Address() {
	}

	protected Address(Parcel in) {
		this.zipcode = in.readString();
		this.geo = in.readParcelable(Geo.class.getClassLoader());
		this.suite = in.readString();
		this.city = in.readString();
		this.street = in.readString();
	}

	public static final Parcelable.Creator<Address> CREATOR = new Parcelable.Creator<Address>() {
		@Override
		public Address createFromParcel(Parcel source) {
			return new Address(source);
		}

		@Override
		public Address[] newArray(int size) {
			return new Address[size];
		}
	};
}
