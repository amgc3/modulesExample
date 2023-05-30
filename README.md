# modulesExample

The task given was to fix modular project errors by updating the modue-info.java files

The modules folder contains a project that has been separated in modules, com.udacity.flight is a small module stubbing a search engine for getting flights availability, similarly com.udacity.hotel simulates a search engine for hotel availability.

com.udacity.packagesearch uses the previous two modules to get a list of available hotels and flights and show it to the user to create a package.

The project can be compiled when by running this command from the modules directory:

javac -d out --module-source-path . --module com.udacity.flight,com.udacity.hotel,com.udacity.packagesearch


Run the program with the next command:
java --module-path out --module com.udacity.packagesearch/com.udacity.packagesearch.search.Main
