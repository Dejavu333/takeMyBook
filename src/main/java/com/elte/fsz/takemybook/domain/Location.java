package com.elte.fsz.takemybook.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {
	@Id
	@GeneratedValue
	private Long id;
	private double Latitude;
	private double Longitude;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getLatitude() {
		return Latitude;
	}
	public void setLatitude(double latitude) {
		Latitude = latitude;
	}
	public double getLongitude() {
		return Longitude;
	}
	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Latitude, Longitude, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Location other = (Location) obj;
		return Double.doubleToLongBits(Latitude) == Double.doubleToLongBits(other.Latitude)
				&& Double.doubleToLongBits(Longitude) == Double.doubleToLongBits(other.Longitude)
				&& Objects.equals(id, other.id);
	}
}
