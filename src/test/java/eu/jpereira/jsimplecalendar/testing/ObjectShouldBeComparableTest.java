package eu.jpereira.jsimplecalendar.testing;

public interface ObjectShouldBeComparableTest extends ObjectShouldOverrideEqualsAndHashCodeMethod{


	/**
	 * If a > b then a.compareTo(b) > 0
	 */
	public void shoulRespondGreaterThanZeroWhenComparingWithSmallerValue();

	/**
	 * If a < b then a.compareTo(b) < 0
	 */
	public void shouldRespondSmallerThanZeroWhenComparingWithBiggerValue();

	/*
	 * If a.equals(b) then a.compare(b) == 0
	 */
	public void shouldRespondZeroIfComparingWithEqualValue();
	
	/**
	 * If a < b and b < c , then a.compare(c) < 0. 
	 */
	public void should_have_first_transitive_property_of_inequality();
	

	/**
	 * If a > b and b > c , then a.compateTo(c) > 0.
	 */
	public void shouldHaveSecondTransitivePropertyOfInequality();
	

}
