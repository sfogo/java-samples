# North East Paths
## How many paths from bottom left to top right?
**Provided that you only move up or right**...

<img src="https://user-images.githubusercontent.com/13286393/73980710-a61f4800-48e5-11ea-9a34-5d42fc1b0bdd.jpg" width="40%;">

## Recursively
The rule is that you can only move up or right. Therefore, once at position `(x,y)`, you can only step to:
- `(x + 1, y)` provided that `x < X`
- `(x, y + 1)` provided that `y < Y`

Therefore the solution is to explore recursively these transitions, and count one path every time you hit `(X, Y)`.

## Maths only
- Whichever path you take, it takes `X + Y` steps to go from bottom left to top right.
- If you have to take a total of `X + Y` steps, there is no other way than:
  - Going up X times
  - Going right Y times

Otherwise you will never make it to the top right corner.
Therefore, the number of possible paths is the number of ways to do X steps north out of X + Y steps,
which is the number of X-size combinations in a set of size `X + Y`, which is the
same as the number of Y-size combinations in a set of size `X + Y`.

If the code is correct, it should yield:
```
C(X + Y, X) = C (X + Y, Y) = (X + Y)! / (X! * Y!)
```

- If the grid is 2x2, C(4,2) = 6
- If the grid is 3x3, C(6,3) = 20
- If the grid is 5x4, C(9,5) = C(9,4) = 126, same result if the grid is 4x5.

## How many paths visit a given point in the grid?
If P is one grid point, the number of paths that visit P is:
- the number of paths to go from bottom left to P
- **multiplied** by the number of paths that go from P to top right.

Example with a 5x4 grid. The number of paths that visit (4,2) is 45:
- The number of paths from bottom left to (4,2) is C(6,2) = C(6,4) = 15
- The number of paths that go from (4,2) to top right is the same as a (1x2) grid, which is 3
- Total is then 45 
  ![grid5x4](https://user-images.githubusercontent.com/13286393/73970838-b7ab2480-48d2-11ea-99c9-1bc15667eedb.png)

