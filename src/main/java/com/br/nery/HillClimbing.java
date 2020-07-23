package com.br.nery;

import java.util.Collections;

public class HillClimbing {

	private static final Window _window = new Window();

	public static Route findShortestRoute(Route route) {
		_window.printRoute(route);

		System.out.println(route + "start route");

		int interactions = 0;

		Route changeRoute;

		int citiesTotal = route.getCities().size();

		while (true) {
			interactions++;
			boolean changed = false;

			for (int i = 0; i < (citiesTotal - 1); i++) {
				if (changed) {
					break;
				}
				for (int j = i + 1; j < citiesTotal; j++) {
					if (changed) {
						break;
					}
					changeRoute = new Route(route);

					Collections.swap(changeRoute.getCities(), i, j);

					if (changeRoute.getTotalDistance() < route
							.getTotalDistance()) {
						route = new Route(changeRoute);

						_window.printRoute(route);

						System.out.println(route + "new route");

						changed = true;
					}
				}
			}

			if (!changed) {
				break;
			}
		}

		_window.printRoute(route);

		System.out.println(route + "end route interactions " + interactions);

		return route;
	}
}