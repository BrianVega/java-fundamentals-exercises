package com.bobocode.fp;

import com.bobocode.util.ExerciseNotCompletedException;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Map;
import java.util.function.*;

/**
 * {@link CrazyLambdas} is an exercise class. Each method returns a functional interface and it should be implemented
 * using either lambda or a method reference. Every method that is not implemented yet throws
 * {@link ExerciseNotCompletedException}.
 * <p>
 * TODO: remove exception and implement each method of this class using lambda or method reference
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com">visit our website</a></strong>
 * <p>
 *
 * @author Taras Boychuk
 */
public class CrazyLambdas {

    /**
     * Returns {@link Supplier} that always supply "Hello"
     *
     * @return a string supplier
     */
    public static Supplier<String> helloSupplier() {
//        return () -> "Hello";
        return new Supplier<String>() {
            @Override
            public String get() {
                return "Hello";
            }
        };
//        throw new ExerciseNotCompletedException();
    }

    /**
     * Returns a {@link Predicate} of string that checks if string is empty
     *
     * @return a string predicate
     */
    public static Predicate<String> isEmptyPredicate() {
//        return String::isEmpty;
        return new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
        //throw new ExerciseNotCompletedException();
    }

    /**
     * Return a {@link Function} that accepts {@link String} and returns that string repeated n time, where n is passed
     * as function argument
     *
     * @return function that repeats Strings
     */
    public static BiFunction<String, Integer, String> stringMultiplier() {
//        return String::repeat;
        return new BiFunction<>() {
            @Override
            public String apply(String s, Integer integer) {
                StringBuilder sb = new StringBuilder();
                for(int idx = 0; idx < integer; idx++) {
                    sb.append(s);
                }
                return sb.toString();
            }
        };
//        throw new ExerciseNotCompletedException();
    }

    /**
     * Returns a {@link Function} that converts a {@link BigDecimal} number into a {@link String} that start with
     * a dollar sign and then gets a value
     *
     * @return function that converts adds dollar sign
     */
    public static Function<BigDecimal, String> toDollarStringFunction() {
        return new Function<>() {
            @Override
            public String apply(BigDecimal bigDecimal) {
                return "$" + bigDecimal.toPlainString();
            }
        };
//        throw new ExerciseNotCompletedException();
    }

    /**
     * Receives two parameter that represent a range and returns a {@link Predicate<String>} that verifies if string
     * length is in the specified range. E.g. min <= length < max
     *
     * @param min min length
     * @param max max length
     * @return a string predicate
     */
    public static Predicate<String> lengthInRangePredicate(int min, int max) {
        //return s -> s.length() >= min && s.length() <= max;
        return new Predicate<>() {
            @Override
            public boolean test(String s) {
                return s.length() >= min && s.length() <= max;
            }
        };
        //throw new ExerciseNotCompletedException();
    }

    /**
     * Returns a {@link Supplier} of random integers
     *
     * @return int supplier
     */
    public static IntSupplier randomIntSupplier() {
        return new IntSupplier() {
            @Override
            public int getAsInt() {
//                return Math.random(0) + 1;
                return (int) (Math.random() * 100000);
            }
        };
        //throw new ExerciseNotCompletedException();
    }


    /**
     * Returns an {@link IntUnaryOperator} that receives an int as a bound parameter, and returns a random int
     *
     * @return int operation
     */
    public static IntUnaryOperator boundedRandomIntSupplier() {
        //throw new ExerciseNotCompletedException();
        return new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return (int) (Math.random() * operand);
            }
        };
    }

    /**
     * Returns {@link IntUnaryOperator} that calculates an integer square
     *
     * @return square operation
     */
    public static IntUnaryOperator intSquareOperation() {
        //throw new ExerciseNotCompletedException();
        return new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand * operand;
            }
        };
    }

    /**
     * Returns a {@link LongBinaryOperator} sum operation.
     *
     * @return binary sum operation
     */
    public static LongBinaryOperator longSumOperation() {
        return new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                return left + right;
            }
        };
//        throw new ExerciseNotCompletedException();
    }

    /**
     * Returns a {@link ToIntFunction<String>} that converts string to integer.
     *
     * @return string to int converter
     */
    public static ToIntFunction<String> stringToIntConverter() {
//        throw new ExerciseNotCompletedException();
        return new ToIntFunction<>() {
            @Override
            public int applyAsInt(String value) {
                return Integer.parseInt(value);
            }
        };
    }

    /**
     * Receives int parameter n, and returns a {@link Supplier} that supplies {@link IntUnaryOperator}
     * that is a function f(x) = n * x
     *
     * @param n a multiplier
     * @return a function supplier
     */
    public static Supplier<IntUnaryOperator> nMultiplyFunctionSupplier(int n) {
        //throw new ExerciseNotCompletedException();
        return new Supplier<>() {
            @Override
            public IntUnaryOperator get() {
                return new IntUnaryOperator() {
                    @Override
                    public int applyAsInt(int operand) {
                        return n * operand;
                    }
                };
            }
        };
    }

    /**
     * Returns a {@link UnaryOperator} that accepts str to str function and returns the same function composed with trim
     *
     * @return function that composes functions with trim() function
     */
    public static UnaryOperator<Function<String, String>> composeWithTrimFunction() {
//        throw new ExerciseNotCompletedException();
        return new UnaryOperator<>() {
            @Override
            public Function<String, String> apply(Function<String, String> stringStringFunction) {
                return new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.trim();
                    }
                };
            }
        };
    }

    /**
     * Receives a {@link Runnable} parameter, and returns a {@link Supplier<Thread>}. The thread will be started only
     * when you call supplier method {@link Supplier#get()}
     *
     * @param runnable the code you want to tun in new thread
     * @return a thread supplier
     */
    public static Supplier<Thread> runningThreadSupplier(Runnable runnable) {
//        throw new ExerciseNotCompletedException();
        return new Supplier<>() {
            @Override
            public Thread get() {
                runnable.run();
                Thread thread = new Thread(runnable);
                thread.start();
                return thread;
            }
        };
    }

    /**
     * Returns a {@link Consumer} that accepts {@link Runnable} as a parameter and runs in a new thread.
     *
     * @return a runnable consumer
     */
    public static Consumer<Runnable> newThreadRunnableConsumer() {
        //throw new ExerciseNotCompletedException();
        return new Consumer<Runnable>() {
            @Override
            public void accept(Runnable runnable) {
                runnable.run();
            }
        };
    }

    /**
     * Returns a {@link Function} that accepts an instance of {@link Runnable} and returns a {@link Supplier} of a
     * started {@link Thread} that is created from a given {@link Runnable}
     *
     * @return a function that transforms runnable into a thread supplier
     */
    public static Function<Runnable, Supplier<Thread>> runnableToThreadSupplierFunction() {
        //throw new ExerciseNotCompletedException();
        return new Function<>() {
            @Override
            public Supplier<Thread> apply(Runnable runnable) {
                return new Supplier<>() {
                    @Override
                    public Thread get() {
                        Thread t = new Thread(runnable);
                        t.start();
                        return t;
                    }
                };
            }
        };
    }

    /**
     * Returns a {@link BiFunction} that has two parameters. First is {@link IntUnaryOperator} which is some integer function.
     * Second is {@link IntPredicate} which is some integer condition. And the third is {@link IntUnaryOperator} which is
     * a new composed function that uses provided predicate (second parameter of binary function) to verify its input
     * parameter. If predicate returns {@code true} it applies a provided integer function
     * (first parameter of binary function) and returns a result value, otherwise it returns an element itself.
     *
     * @return a binary function that receiver predicate and function and compose them to create a new function
     */
    public static BiFunction<IntUnaryOperator, IntPredicate, IntUnaryOperator> functionToConditionalFunction() {
//        throw new ExerciseNotCompletedException();
        return new BiFunction<>() {
            @Override
            public IntUnaryOperator apply(IntUnaryOperator intUnaryOperator, IntPredicate intPredicate) {
                return new IntUnaryOperator() {
                    @Override
                    public int applyAsInt(int operand) {
                        return operand;
                    }
                };
            }
        };
    }

    /**
     * Returns a {@link BiFunction} which first parameter is a {@link Map} where key is a function name, and value is some
     * {@link IntUnaryOperator}, and second parameter is a {@link String} which is a function name. If the map contains a
     * function by a given name then it is returned by high order function otherwise an identity() is returned.
     *
     * @return a high-order function that fetches a function from a function map by a given name or returns identity()
     */
    public static BiFunction<Map<String, IntUnaryOperator>, String, IntUnaryOperator> functionLoader() {
        throw new ExerciseNotCompletedException();
    }

    /**
     * Returns a comparator of type T that is comparing values extracted using the provided mapper function.
     * <p>
     * E.g. imagine you need to compare accounts by their balance values.
     * <pre>{@code
     * Comparator<Account> balanceComparator = comparing(Account::getBalance);
     * }</pre>
     * <p>
     * PLEASE NOTE, that @{@link Comparator} is a functional interface, and you should manually write a lambda expression
     * to implement it.
     *
     * @param mapper a mapper function that allows to map an object to a comparable value
     * @return a comparator instance
     */
    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T, ? extends U> mapper) {
        throw new ExerciseNotCompletedException();
    }

    /**
     * Returns a comparator of type T that uses a provided comparator to compare objects, and only if they are equal
     * it's comparing values extracted using the provided mapper function.
     * <p>
     * E.g. suppose you want to compare accounts by balance, but in case two people have the same balance you want to
     * compare their first names:
     * <pre>{@code
     * Comparator<Account> accountComparator = thenComparing(balanceComparator, Account::getFirstName);
     * }</pre>
     * <p>
     *
     * @param comparator an initial comparator
     * @param mapper     a mapper function that is used to extract values when initial comparator returns zero
     * @return a comparator instance
     */
    public static <T, U extends Comparable<? super U>> Comparator<T> thenComparing(
            Comparator<? super T> comparator, Function<? super T, ? extends U> mapper) {
        throw new ExerciseNotCompletedException();
    }

    /**
     * Returns {@link Supplier} of {@link Supplier} of {@link Supplier} of {@link String} "WELL DONE!".
     *
     * @return a supplier instance
     */
    public static Supplier<Supplier<Supplier<String>>> trickyWellDoneSupplier() {
        return new Supplier<>() {
            @Override
            public Supplier<Supplier<String>> get() {
                return new Supplier<>() {
                    @Override
                    public Supplier<String> get() {
                        return "WELL DONE!";
                    }
                };
            }
        };
        //throw new ExerciseNotCompletedException();
    }
}

