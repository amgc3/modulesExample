package com.udacity.packagesearch.search;

import com.udacity.hotel.model.Reservation;
import com.udacity.packagesearch.search.model.PackageSearch;
import com.udacity.packagesearch.search.service.PackageSearchService;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
		PackageSearchService packageSearchService = new PackageSearchService();

		LocalDate date = LocalDate.of(2020, 11, 23);
		String departure = "SFO";
		String arrival = "LAX";

		PackageSearch packageSearch = packageSearchService.packageSearch(departure, arrival, date);

		List<Reservation> availableRooms = packageSearch.getAvailableRooms();

		System.out.printf("Found %d available rooms%n", availableRooms.size());

// Uncomment this code on part 4
		Optional<Reservation> first = availableRooms.stream().findFirst();

		if (first.isPresent()) {
			Reservation reservation = first.get();

			// Reservation.class refers to the Class object representing the Reservation class.
			// the Class object contains metadata about the class (name, fields, methods, constructors)
			Field privateStringField = Reservation.class.getDeclaredField("generalManager");

			// privateStringField is a Field object representing the generalManager
			// since the generalManager is private we need to call, so we can
			// access its value with reflection
			privateStringField.setAccessible(true);

			// use the get method on the Field object to retrieve the value
			// of the generalManager field for the reservation object
			String managersName = (String) privateStringField.get(reservation);

			System.out.println(managersName);
		}

	}
}
