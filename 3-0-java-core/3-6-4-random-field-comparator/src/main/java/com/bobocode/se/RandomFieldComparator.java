package com.bobocode.se;

import com.bobocode.util.ExerciseNotCompletedException;
import net.bytebuddy.utility.FieldComparator;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Random;

import static java.util.Objects.requireNonNull;

/**
 * A generic comparator that is comparing a random field of the given class. The field is either primitive or
 * {@link Comparable}. It is chosen during comparator instance creation and is used for all comparisons.
 * <p>
 * If no field is available to compare, the constructor throws {@link IllegalArgumentException}
 *
 * @param <T> the type of the objects that may be compared by this comparator
 *<p><p>
 *  <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com">visit our website</a></strong>
 *  <p>
 *
 * @author Stanislav Zabramnyi
 */
public class RandomFieldComparator<T> implements Comparator<T> {

    Class<T> targetType;
    Field  fieldComparator;

    public RandomFieldComparator(Class<T> targetType) {
        //throw new ExerciseNotCompletedException(); // todo: implement this constructor;
        if (targetType == null) {
            throw new NullPointerException("Target type cannot be null");
        }
        this.targetType = targetType;
        Field[] fields = targetType.getDeclaredFields();

        fieldComparator = Arrays.stream(fields)
                .filter(f -> Comparable.class.isAssignableFrom(f.getType()) || f.getType().isPrimitive())
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * Compares two objects of the class T by the value of the field that was randomly chosen. It allows null values
     * for the fields, and it treats null value greater than a non-null value.
     *
     * @param o1
     * @param o2
     * @return positive int in case of first parameter {@param o1} is greater than second one {@param o2},
     *         zero if objects are equals,
     *         negative int in case of first parameter {@param o1} is less than second one {@param o2}.
     */
    @Override
    public int compare(T o1, T o2) {
        //throw new ExerciseNotCompletedException(); // todo: implement this method;
        if (o1 == null || o2 == null) {
            throw new NullPointerException();
        }
        fieldComparator.setAccessible(true);
        try {
            return compareFields(o1, o2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private <U extends Comparable<? super U>> int compareFields(T obj1, T obj2) throws IllegalAccessException {
        U value1 = (U) fieldComparator.get(obj1);
        U value2 = (U) fieldComparator.get(obj2);
        Comparator<U> comparator = Comparator.nullsLast(Comparator.naturalOrder());
        return comparator.compare(value1, value2);
    }
    /**
     * Returns the name of the randomly-chosen comparing field.
     */
    public String getComparingFieldName() {
        //throw new ExerciseNotCompletedException(); // todo: implement this method;
        return fieldComparator.getName();
    }

    /**
     * Returns a statement "Random field comparator of class '%s' is comparing '%s'" where the first param is the name
     * of the type T, and the second parameter is the comparing field name.
     *
     * @return a predefined statement
     */
    @Override
    public String toString() {
        //throw new ExerciseNotCompletedException(); // todo: implement this method;
        return String.format("Random field comparator of class '%s' is comparing '%s'", targetType.getSimpleName(), fieldComparator.getName());
    }
}
