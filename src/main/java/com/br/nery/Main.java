package com.br.nery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

	public static void main(String[] args) {
		Route route = new Route(getInitialCities("dj38"));

		System.out.println(getHead(route));

		HillClimbing.findShortestRoute(route);
	}

	private static String getHead(Route route) {
		StringBuffer sb = new StringBuffer("");

		int routeLength = route.toString().length();

		int partialLength = (routeLength - 28) / 2;
		for (int x = 0; x < partialLength; x++) {
			sb.append(" ");
		}

		sb.append("Route");

		for (int x = 0; x < partialLength; x++) {
			sb.append(" ");
		}

		sb.append(" |      Distance      |      Status");

		return sb.toString();
	}

	private static ArrayList<City> getInitialCities(String fileName) {
		ArrayList<City> initialCities = new ArrayList<>();

		ClassLoader classLoader = new Main().getClass().getClassLoader();

		URL resource = classLoader
				.getResource("com/br/nery/" + fileName + ".tsp");

		File file = new File(resource.getFile());

		try (FileReader reader = new FileReader(file);
				BufferedReader br = new BufferedReader(reader)) {
			boolean startCities = false;
			String line;
			while (((line = br.readLine()) != null)
					&& !Objects.equals(line, "EOF")) {
				if (Objects.equals(line, "NODE_COORD_SECTION")) {
					startCities = true;
					continue;
				}

				if (startCities) {
					String[] split = line.split(" ");
					String lat = new StringBuffer(
							split[1].split("\\.")[0] + split[1].split("\\.")[1])
									.insert(2, '.').toString();
					String lgn = new StringBuffer(
							split[2].split("\\.")[0] + split[2].split("\\.")[1])
									.insert(2, '.').toString();
					initialCities.add(new City(split[0], Double.valueOf(lat),
							Double.valueOf(lgn)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return initialCities;
	}

}