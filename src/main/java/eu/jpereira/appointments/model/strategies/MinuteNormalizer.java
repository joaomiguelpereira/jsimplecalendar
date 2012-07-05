package eu.jpereira.appointments.model.strategies;

public class MinuteNormalizer {

    public static int normalize(int hour, int minute) {
        
        return hour*60+minute;
    }

}
