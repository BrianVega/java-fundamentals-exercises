# Infinite iterator
**Input:** some data as `java.time.LocalDate`  
**Task:** Implement an infinite iterator. It takes a date as a constructor and returns next business day (skipping Saturday and Sunday). Test the implementation with unit tests.

### Creation:
```
Iterator<LocalDate> iter = new BusinessDaysIterator(
LocalDate.of(2022, 1, 1));

// 1st Jan 2022, Saturday
```

### Usage:
```
System.out.println(iter.next());
// prints next business day
// 3rd Jan 2022, Monday

System.out.println(iter.next());
// prints next business day
// 4th Jan 2022, Tuesday
```
