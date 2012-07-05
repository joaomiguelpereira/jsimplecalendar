package eu.jpereira.appointments.model;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import eu.jpereira.appointments.model.data.AppointmentSpecification;
import eu.jpereira.testfw.DateUtils;


public class AppointmentTest {

	@Test
	public void appointmentIsNow() {
		// Current Hour is?
		Calendar calendar = Calendar.getInstance();

		int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
		int currentMinute = calendar.get(Calendar.MINUTE);

		AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), currentHour, currentMinute-15, 30);		
		Appointment appointment = FixtureAppointmentFactory.getAppointment(spec);

		System.out.println(appointment);
		assertTrue(appointment.isNow());
		assertFalse(appointment.isPast());
		assertFalse(appointment.isInFuture());

	}
	
	@Test
	public void appointmentIsPastToday() {
		// Current Hour is?
		Calendar calendar = Calendar.getInstance();

		int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
		int currentMinute = calendar.get(Calendar.MINUTE);

        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), currentHour, currentMinute-34, 30);      
        Appointment appointment = FixtureAppointmentFactory.getAppointment(spec);

        
		assertTrue(appointment.isPast());
		assertFalse(appointment.isInFuture());
		assertFalse(appointment.isNow());
	}


    @Test
    public void appointmentIsPast() {
        
        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getYesterday()), 0, 0, 30);      
        Appointment appointment = FixtureAppointmentFactory.getAppointment(spec);

        assertTrue(appointment.isPast());
        assertFalse(appointment.isInFuture());
        assertFalse(appointment.isNow());
    }

	@Test
	public void appointmentElapsedMinutesSinceStart() {

		
		// Current Hour is?
		Calendar calendar = Calendar.getInstance();

		int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
		int currentMinute = calendar.get(Calendar.MINUTE);


        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), currentHour, currentMinute-30, 30);      
        Appointment appointment = FixtureAppointmentFactory.getAppointment(spec);

        
		assertEquals(30, appointment.getElapsedMinutesSinceStart());

	}

	@Test
	public void appointmentElapsedMinutesSinceEnd() {

		
		// Current Hour is?
		Calendar calendar = Calendar.getInstance();

		int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
		int currentMinute = calendar.get(Calendar.MINUTE);
		

        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getToday()), currentHour, currentMinute-120, 30);      
        Appointment appointment = FixtureAppointmentFactory.getAppointment(spec);

        
		assertEquals(90, appointment.getElapsedMinutesSinceEnd());

	}

	@Test
	public void appointmentIsFuture() {

		// Current Hour is?
		Calendar calendar = Calendar.getInstance();

		int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
		int currentMinute = calendar.get(Calendar.MINUTE);
		

        AppointmentSpecification spec = new AppointmentSpecification(new AppointmentDate(DateUtils.getTomorrow()), currentHour, currentMinute, 30);      
        Appointment appointment = FixtureAppointmentFactory.getAppointment(spec);
		
		assertTrue(appointment.isInFuture());
		assertFalse(appointment.isNow());
		assertFalse(appointment.isPast());
	}

}
