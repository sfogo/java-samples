# North East Paths
## Recursively
The rule is that you can only move up or right. Therefore, once at position `(x,y)`, you can only step to:
- `(x + 1, y)` provided that `x < X`
- `(x, y + 1)` provided that `y < Y`

Therefore the solution is to explore recursively these transitions, and count one path every time you hit `(X, Y)`.

## No coding required
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
