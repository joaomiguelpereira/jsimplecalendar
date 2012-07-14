package eu.jpereira.jsimplecalendar.datetime.containers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DayInWeekContainerTest {

	private DayInWeekContainer containerUT = DayInWeekContainer.emptyContainer();
	
	
	/** Creational behavior **/
	@Test
	public void containerIsCreatedEmpty() {
		assertEquals(0, this.containerUT.getComponentCount());
		assertEquals(0, this.containerUT.getExclusions().size());
	}

}
