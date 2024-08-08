# Buffering iterator
**Input:** iterator over type ```T``` and integer ```N```  

**Task:** Implement an iterator, which takes iterator over type ```T``` and 
integer ```N``` as a parameter and returns ```List<T>```
elements of the input iterator in batches of size ```N```. 
If there are not enough elements in the input iterator to complete a 
batch of size ```N```, return a smaller batch. 
Test the implementation with unit tests.


### Creation:
````
Iterator<List<Integer>> iter = new BufferingIterator<>(
List.of(1, 2, 3, 4, 5).iterator(),
3  // groups of size 3
);
````


### Usage:

````
while (iter.hasNext()) {
List<Integer> batch = iter.next();
System.out.println(batch);
}

// prints numbers grouped in batches
// [1, 2, 3]
// [4, 5]
````
