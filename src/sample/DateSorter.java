package sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 package sample;

 import java.time.LocalDate;
 import java.util.Collection;
 import java.util.List;

 /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> sortedDates = new ArrayList<>();
        List<LocalDate> datesWithR = new ArrayList<>();
        List<LocalDate> datesWithoutR = new ArrayList<>();

        for (LocalDate unsortedDate : unsortedDates) {
            if (unsortedDate != null) {
                if (hasRInMonth(unsortedDate)) {
                    datesWithR.add(unsortedDate);
                } else {
                    datesWithoutR.add(unsortedDate);
                }
            }
        }

        Collections.sort(datesWithR);
        datesWithoutR.sort(Collections.reverseOrder());

        sortedDates.addAll(datesWithR);
        sortedDates.addAll(datesWithoutR);

        return sortedDates;
    }

    private boolean hasRInMonth(LocalDate date) {
        String month = date.getMonth().name().toLowerCase();
        return month.contains("r");
    }
}
