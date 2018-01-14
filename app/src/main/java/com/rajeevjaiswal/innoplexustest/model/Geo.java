package com.rajeevjaiswal.innoplexustest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Geo implements Parcelable {
	private String lng;
	private String lat;

	public void setLng(String lng){
		this.lng = lng;
	}

	public String getLng(){
		return lng;
	}

	public void setLat(String lat){
		this.lat = lat;
	}

	public String getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"Geo{" + 
			"lng = '" + lng + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.lng);
		dest.writeString(this.lat);
	}

	public Geo() {
	}

	protected Geo(Parcel in) {
		this.lng = in.readString();
		this.lat = in.readString();
	}

	public static final Parcelable.Creator<Geo> CREATOR = new Parcelable.Creator<Geo>() {
		@Override
		public Geo createFromParcel(Parcel source) {
			return new Geo(source);
		}

		@Override
		public Geo[] newArray(int size) {
			return new Geo[size];
		}
	};
}
