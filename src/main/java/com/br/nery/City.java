package com.br.nery;

public class City {
	private double _latitude;
	private double _longitude;
	private String _name;

	public City(String name, double latitude, double longitude) {
		_name = name;
		_latitude = latitude;
		_longitude = longitude;
	}

	public double getLatitude() {
		return _latitude;
	}

	public double getLongitude() {
		return _longitude;
	}

	public String getName() {
		return _name;
	}

	public double measureDistance(City city) {
		double latDiff = _latitude - city.getLatitude();
		double lngDiff = _longitude - city.getLongitude();

		return Math.sqrt(Math.pow(latDiff, 2) + Math.pow(lngDiff, 2));
	}

	@Override
	public String toString() {
		return _name;
	}
}