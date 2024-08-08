# Flattening Iterator
**Input:** collection of iterators of generic type ```T```  
**Task:** Implement ```FlatteningIterator``` that takes a collection of iterators as a constructor argument and returns objects of type ```T``` from input iterators preserving the initial order. Test the implementation with unit tests.

### Creation:
````
Iterator<Integer> iter = new FlatteningIterator<>(
List.of(42, 5).iterator(),
List.of(-4).iterator(),
List.of(999, 998, 997).iterator()
);
````


### Usage:

````
while (iter.hasNext()) {
System.out.println(iterator.next());
}

// prints numbers in the supplied order:
// 42 5 -4 999 998 997
````
