# Samples
- [Reactor](docs/REACTOR.md)

# Problems
- **North East Paths** on a rectangular grid : count the number of possible paths from bottom left to top right knowing you can only go up or right.
  - Count [them](problems/src/main/java/com/vnet/problems/NorthEastPaths.java). If the grid size is x by y, see [here](docs/north-east-paths.md)
why this is the same as C(x+y,x) or C(x+y,y) **combinations**. See tests [here](problems/src/test/java/com/vnet/problems/NorthEastPathsTest.java).
  - List [them](problems/src/main/java/com/vnet/problems/NEPaths.java) as Grid is recursively traversed.
  - North East Paths [service](http://app137.herokuapp.com/things/paths/?w=3&h=2) deployed on [Heroku](https://www.heroku.com) free tier
(_it may take a few seconds to wake up since Heroku free tier pauses unused services_.)
  - [Two.js](https://two.js.org/) grid traverse [animation](https://app137.herokuapp.com/north-east-paths.html).
  - [Two.js](https://two.js.org/) grid traverse [animation](https://app137.herokuapp.com/north-east-paths-counters.html)
   that shows how many times each grid point gets visited. See doc [here](docs/north-east-paths.md#how-many-paths-visit-a-given-point-in-the-grid).
- Largest Contiguous Sum ([Code](problems/src/main/java/com/vnet/problems/LargestContiguousSum.java), [Doc](docs/largest-contiguous-sum.md))
- Sorted Array Finder (Find any occurrence, first occurrence, last occurrence in sorted array). [Code](problems/src/main/java/com/vnet/problems/SAFinder.java)
- Array Peak Finder. [Code](problems/src/main/java/com/vnet/problems/PeakFinder.java)
- Array Max Finder. [Code](problems/src/main/java/com/vnet/problems/MaxFinder.java)
- Tree things : traverse, height, collect all paths. [Code](problems/src/main/java/com/vnet/problems/Node.java) and [tests](problems/src/test/java/com/vnet/problems/NodeTest.java)
- Pyramid Words. See documentation [here](docs/PYRAMID.md). Pyramid logic is [here](apps/words/src/main/java/com/vnet/apps/words/pyramid/PyramidFinder.java).
- Block Letters (or cubes with 6 letters). Given a set of cubes, pick cubes to make a word. It actually does not matter
how many letters each block has. It could be 12-letter blocks or even differently sized blocks.
Here is a possible [solution](problems/src/main/java/com/vnet/problems/BlockLetters.java) where you may have to swap already selected blocks.
