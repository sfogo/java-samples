# Largest Contiguous Sum (LCS)

## Examples
- LCS(-2, 1, -3, 4, -1, 2, 1, -5, 4) = (4,-1,2,1) = 6
- LCS(4,-1,2,1) = 6
- LCS(1, 2, 3, 4) = 10
- LCS(-5, -1, -2, -9) = -1

## Brute Force
- It will definitely work but you have to go through all possible contiguous sums of size 1 to N:
  - 1 sum of size N
  - 2 sums of size N-1
  - 3 sums of size N-2
  - ...
  - N sums of size 1

## Better
Traversing the list (only once), the trick is to keep track of 2 maximums:
- The overall LCS
- The current LCS (until the index of the number being examined)

This is known as [Kadane's](https://en.wikipedia.org/wiki/Maximum_subarray_problem) solution.

- Let's call `M` the overall LCS
- Let's call `m` the LCS that finishes at position `i - 1` 
<img src="https://user-images.githubusercontent.com/13286393/74181415-23a0cc00-4bf6-11ea-8369-b1a311fefa34.jpg" width="50%;">

- Traversing the list:
  - Let's call n the number being currently examined at position `i`
  - The local LCS for index `i` is the maximum of the two numbers `n` and `n + m` : update `m` with this maximum.
  - If current LCS has become strictly greater than overall LCS, update the overall LCS (`M = m`)

