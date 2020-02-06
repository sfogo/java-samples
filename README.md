# Samples
- [Reactor](docs/REACTOR.md)

# Problems
- **North East Paths** on a rectangular grid : count the number of possible paths from bottom left to top right knowing you can only go up or right.
  - Count [them](problems/src/main/java/com/vnet/problems/NorthEastPaths.java). If the grid size is x by y, see [here](docs/north-east-paths.md)
why this is the same as C(x+y,x) or C(x+y,y) **combinations**. See tests [here](problems/src/test/java/com/vnet/problems/NorthEastPathsTest.java).
  - List [them](problems/src/main/java/com/vnet/problems/NEPaths.java) as Grid is recursively traversed.
  - North East Paths [service](http://app137.herokuapp.com/things/paths/?w=3&h=2) deployed on [Heroku](https://www.heroku.com) free tier
(_it may take a few seconds to wake up since Heroku free tier pauses unused services_.)
  - [Two.js](https://two.js.org/) [animation](https://app137.herokuapp.com/north-east-paths.html) that traverses the grid.
  - [Two.js](https://two.js.org/) [animation](https://app137.herokuapp.com/north-east-paths-counters.html) that traverses the grid and shows how many times each grid point gets visited.
