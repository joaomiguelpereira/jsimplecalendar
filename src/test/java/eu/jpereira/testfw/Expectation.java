package eu.jpereira.testfw;

public interface Expectation {
	
	Comparsion greater();

	Comparsion less();

	Comparsion equals();


	Comparsion different();

}
