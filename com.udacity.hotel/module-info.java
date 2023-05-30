module com.udacity.hotel {
	// Add your code here
    exports com.udacity.hotel.model;
    exports com.udacity.hotel.search;
    // without this java.lang.reflect.InaccessibleObjectException
    opens com.udacity.hotel.model to com.udacity.packagesearch;

}