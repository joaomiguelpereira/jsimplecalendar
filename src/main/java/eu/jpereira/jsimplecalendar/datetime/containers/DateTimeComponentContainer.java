package eu.jpereira.jsimplecalendar.datetime.containers;


import java.util.List;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;
import eu.jpereira.jsimplecalendar.datetime.containers.exclusions.DateTimeComponentExclusion;

public interface DateTimeComponentContainer<T extends DateTimeComponent, E extends DateTimeComponentExclusion> {

    boolean contains(T dateTimeComponent);
    int  getComponentCount();
    List<E> getExclusions();
    void removeExclusion(String exclusionName);
}
