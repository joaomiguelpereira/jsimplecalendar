package eu.jpereira.jsimplecalendar.testing;

public interface ObjectShouldOverrideEqualsAndHashCodeMethod {

	/**
	 * It is reflexive: For any reference value x, x.equals(x) must return true.
	 */
	public void shouldHaveTheReflexivePropertyOfEquality();

	/**
	 * It is symmetric: For any reference values x and y, x.equals(y) must
	 * return true if and only if y.equals(x) returns true.
	 */
	public void shouldHaveTheSymetricPropertyOfEquality();

	/**
	 * It is transitive: For any reference values x, y, and z, if x.equals(y)
	 * returns true and y.equals(z) returns true, then x.equals(z) must return
	 * true.
	 */
	public void shouldHaveTheTransitivePropertyOfEquality();

	/**
	 * It is consistent: For any reference values x and y, multiple invocations
	 * of x.equals(y) consistently return true or consistently return false,
	 * provided no information used in equals comparisons on the object is
	 * modified.
	 */
	public void shouldFollowConsitentyContractOfEquality();

	/**
	 * For any non-null reference value x, x.equals(null) must return false.
	 */
	public void shouldFollwoNonNullWithNulRespondeFalseContractOfEquality();

	/**
	 * If a is instance of A and b instance of B, then objects are different.
	 * See http://www.artima.com/intv/bloch17.html about using instanceof and
	 * getClass() strategies
	 */
	public void shouldRespondFalseForDifferentTypes();

	/**
	 * If a is same instance of b, but b contains different state that
	 * contributes to equality calculation, then should respond false
	 */
	public void shouldRespondFalseForDifferentValues();

	/**
	 * If a != b and b!= c, then a!=c
	 */
	public void shouldHaveTheTransitivePropertyOfInequality();

	/**
	 * if a.equals(b) then a.hashCode() == b.hashCode()
	 */
	public void shouldRespondWithSameHashCodeIfObjectsAreEquals();

	/**
	 * If !a.equals(b) the a.hashCode() ! b.hashCode()
	 */
	public void shouldRespondDifferentHashCodesIfObjectAreNotEquals();
}
