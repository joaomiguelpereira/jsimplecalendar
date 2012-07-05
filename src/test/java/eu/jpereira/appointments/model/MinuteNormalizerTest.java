package eu.jpereira.appointments.model;

import static org.junit.Assert.*;

import org.junit.Test;

import eu.jpereira.appointments.model.strategies.MinuteNormalizer;
public class MinuteNormalizerTest {

    
    @Test
    public void canNormalize() {
        assertEquals(MinuteNormalizer.normalize(0,30), 30);
        assertEquals(MinuteNormalizer.normalize(1,30), 90);
        assertEquals(MinuteNormalizer.normalize(2,0), 120);
        assertEquals(MinuteNormalizer.normalize(0,30), 30);
        
    }
}
