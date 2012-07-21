package eu.jpereira.jsimplecalendar.testing;

public interface ObjectShouldOverrideEqualsAndHashCodeMethod {

	/**
	 * It is reflexive: For any reference value x, x.equals(x) must return true.
	 */
	public void should_have_the_reflexive_property_of_equality();

	/**
	 * It is symmetric: For any reference values x and y, x.equals(y) must
	 * return true if and only if y.equals(x) returns true.
	 */
	public void should_have_the_symetric_property_of_equality();

	/**
	 * It is transitive: For any reference values x, y, and z, if x.equals(y)
	 * returns true and y.equals(z) returns true, then x.equals(z) must return
	 * true.
	 */
	public void should_have_the_transitive_property_of_equality();

	/**
	 * It is consistent: For any reference values x and y, multiple invocations
	 * of x.equals(y) consistently return true or consistently return false,
	 * provided no information used in equals comparisons on the object is
	 * modified.
	 */
	public void should_follow_consitenty_contract_of_equality();

	/**
	 * For any non-null reference value x, x.equals(null) must return false.
	 */
	public void should_follwo_non_null_with_null_responds_false_contract_of_equality();

	/**
	 * If a is instance of A and b instance of B, then objects are different.
	 * See http://www.artima.com/intv/bloch17.html about using instanceof and
	 * getClass() strategies
	 */
	public void should_respond_false_for_different_types();

	/**
	 * If a is same instance of b, but b contains different state that
	 * contributes to equality calculation, then should respond false
	 */
	public void should_respond_false_for_different_values();

	/**
	 * If a != b and b!= c, then a!=c
	 */
	public void should_have_the_transitive_property_of_inequality();

	/**
	 * if a.equals(b) then a.hashCode() == b.hashCode()
	 */
	public void shouldRespondWithSameHashCodeIfObjectsAreEquals();

	/**
	 * If !a.equals(b) the a.hashCode() ! b.hashCode()
	 */
	public void shouldRespondDifferentHashCodesIfObjectAreNotEquals();
}
