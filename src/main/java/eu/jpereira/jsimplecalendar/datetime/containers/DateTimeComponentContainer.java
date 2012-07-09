package eu.jpereira.jsimplecalendar.datetime.containers;

import eu.jpereira.jsimplecalendar.datetime.DateTimeComponent;

public interface DateTimeComponentContainer<T extends DateTimeComponent> {

    boolean contains(T dateTimeComponent);
    int  getComponentCount();
}
