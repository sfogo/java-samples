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
- Break up a string into words found in a dictionary. One possible recursive [approach](problems/src/main/java/com/vnet/problems/WordBreaker.java) and [tests](problems/src/test/java/com/vnet/problems/WordBreakerTest.java).
- Stairs. Knowing that you can only climb one step or 2 steps at a time, how many ways are there to climb N steps? One possible recursive solution [here](problems/src/main/java/com/vnet/problems/Stairs.java) with [tests](problems/src/test/java/com/vnet/problems/StairsTest.java)
but see [here](docs/STAIRS.md) why no code is required and why this is [Fibonacci](https://en.wikipedia.org/wiki/Fibonacci_number).
- Best Buy/Sell operation ([code](problems/src/main/java/com/vnet/problems/BestBuySell.java), [tests](problems/src/test/java/com/vnet/problems/BestBuySellTest.java))
- Move all zeros (or any given value) to end of an array ([code](problems/src/main/java/com/vnet/problems/ArrayMover.java) and [tests](problems/src/test/java/com/vnet/problems/ArrayMoverTest.java))
- Leet things
  - Linked List ([code](problems/src/main/java/com/vnet/problems/LeetLinkedList.java), [tests](problems/src/test/java/com/vnet/problems/LeetLinkedListTest.java))
  - Binary Tree ([code](problems/src/main/java/com/vnet/problems/LeetTree.java), [tests](problems/src/test/java/com/vnet/problems/LeetTreeTest.java))
  - Min Stack ([code](problems/src/main/java/com/vnet/problems/LeetMinStack.java), [tests](problems/src/test/java/com/vnet/problems/LeetMinStackTest.java))
  - Miscellaneous ([code](problems/src/main/java/com/vnet/problems/LeetMiscSolutions.java), [tests](problems/src/test/java/com/vnet/problems/LeetMiscSolutionsTest.java)).
    - E.g. add 2 numbers given as lists of digits
    - Longest substring without repeating characters
    - Two array values whose sum is a given number,
    - Generate parenthesis
    - Zig zag conversion
    - Rotated digits
    - Multiply numbers given as strings without converting them
    - Valid brackets
    - Count and say ([Conway sequence](https://en.wikipedia.org/wiki/Look-and-say_sequence))
    - Is anagram
    - Odd-event list
    - Remove duplicates from sorted array