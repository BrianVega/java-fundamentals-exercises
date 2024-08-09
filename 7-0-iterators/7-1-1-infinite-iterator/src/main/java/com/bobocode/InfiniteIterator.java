package com.bobocode;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;


public class InfiniteIterator implements Iterator<LocalDate> {
    private LocalDate currentDate;

    public InfiniteIterator(LocalDate currentDate) {
        this.currentDate = currentDate;
        skipWeekends();
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public LocalDate next() {
        currentDate = currentDate.plusDays(1);
        skipWeekends();
        return currentDate;
    }

    @Override
    public String toString() {
        return String.format(
                "%s %s %s, %s", currentDate.getDayOfMonth(), currentDate.getMonth(), currentDate.getYear(), currentDate);
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    private void skipWeekends() {
        while(isWeekend(currentDate)) {
            currentDate = currentDate.plusDays(1);
        }
    }

    private boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}
