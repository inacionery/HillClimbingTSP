package com.br.nery;

import java.awt.Color;
import java.util.ArrayList;

import eu.jacquet80.minigeo.MapWindow;
import eu.jacquet80.minigeo.POI;
import eu.jacquet80.minigeo.Point;
import eu.jacquet80.minigeo.Segment;

public class Window {

	private MapWindow _window = new MapWindow();

	public void printRoute(Route route) {
		_window.clear();
		_window.repaint();

		ArrayList<City> cities = route.getCities();

		for (int i = 0; i < (cities.size() - 1); i++) {
			City city1 = cities.get(i);
			City city2 = cities.get(i + 1);
			_window.addPOI(createPOI(city1));
			_window.addSegment(createSegment(city1, city2));
		}
		_window.addPOI(createPOI(cities.get(cities.size() - 1)));
		_window.addSegment(
				new Segment(createPoint(cities.get(cities.size() - 1)),
						createPoint(cities.get(0)), Color.RED));

		_window.setVisible(true);

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private POI createPOI(City city) {
		return new POI(city.getLatitude(), city.getLongitude(), city.getName());
	}

	private Point createPoint(City city) {
		return new Point(city.getLatitude(), city.getLongitude());
	}

	private Segment createSegment(City city1, City city2) {
		return new Segment(createPoint(city1), createPoint(city2), Color.RED);
	}

}
