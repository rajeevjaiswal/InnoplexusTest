package com.rajeevjaiswal.innoplexustest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Company implements Parcelable {
	private String bs;
	private String catchPhrase;
	private String name;

	public void setBs(String bs){
		this.bs = bs;
	}

	public String getBs(){
		return bs;
	}

	public void setCatchPhrase(String catchPhrase){
		this.catchPhrase = catchPhrase;
	}

	public String getCatchPhrase(){
		return catchPhrase;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"Company{" + 
			"bs = '" + bs + '\'' + 
			",catchPhrase = '" + catchPhrase + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.bs);
		dest.writeString(this.catchPhrase);
		dest.writeString(this.name);
	}

	public Company() {
	}

	protected Company(Parcel in) {
		this.bs = in.readString();
		this.catchPhrase = in.readString();
		this.name = in.readString();
	}

	public static final Parcelable.Creator<Company> CREATOR = new Parcelable.Creator<Company>() {
		@Override
		public Company createFromParcel(Parcel source) {
			return new Company(source);
		}

		@Override
		public Company[] newArray(int size) {
			return new Company[size];
		}
	};
}
