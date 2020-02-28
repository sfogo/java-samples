# Stairs
## Number of ways to climb n steps
There are n steps to climb. How many different ways are there to climb n steps
knowing that you can only climb one step at a time or two steps at a time?
![IMG-2643](https://user-images.githubusercontent.com/13286393/75496903-66450100-5977-11ea-9fb7-0c5dbca20d71.jpg)
- Let's call `f(n)` the number of ways to climb n steps.
- There are 2 ways to finish climbing to `n+1`
  - One step from `n`,  which you can reach in `f(n)` different ways
  - Two steps from `n-1`, which you can reach in `f(n-1)` different ways 
- Therefore:
```
f(n+1) = f(n) + f(n-1)
```
- That is the [Fibonacci](https://en.wikipedia.org/wiki/Fibonacci_number) sequence.
- Obviously:
  - `f(1) = 1`
  - `f(2) = 2`