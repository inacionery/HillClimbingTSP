package com.br.nery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Route {
	private ArrayList<City> _cities = new ArrayList<>();

	public Route(ArrayList<City> cities) {
		_cities.addAll(cities);

		Collections.shuffle(_cities);
	}

	public Route(Route route) {
		route._cities.stream().forEach(city -> _cities.add(city));
	}

	public ArrayList<City> getCities() {
		return _cities;
	}

	public double getTotalDistance() {
		double totalDistance = 0D;

		for (int i = 0; i < (_cities.size() - 1); i++) {
			totalDistance += _cities.get(i).measureDistance(_cities.get(i + 1));
		}

		return totalDistance + _cities.get(_cities.size() - 1)
				.measureDistance(_cities.get(0));
	}

	public String getTotalDistanceString() {
		StringBuffer sb = new StringBuffer(" |");

		String totalDistanceString = String.format("%.0f km",
				getTotalDistance() * 1000);

		int partialLength = (20 - totalDistanceString.length()) / 2;

		for (int x = 0; x < partialLength; x++) {
			sb.append(" ");
		}

		sb.append(totalDistanceString);

		for (int x = 0; x < partialLength; x++) {
			sb.append(" ");
		}

		if ((totalDistanceString.length() % 2) != 0) {
			sb.append(" ");
		}

		sb.append("| ");

		return sb.toString();
	}

	@Override
	public String toString() {
		return Arrays.toString(_cities.toArray()) + getTotalDistanceString();
	}
}