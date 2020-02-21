# Pyramid Words

## Definition
A word whose letter counts exactly form the integer progression (arithmetic progression starting at one)
and whose common difference is 1. Examples:
- `eve` is one because `v` count is one and `e` count is 2
- `eke` is another one
- `seeded` is one because `s` count is 1, `d` count is 2 and `e` count is 3
- More: `deemed`, `needed`
- `seed` is not because both `s` and `d` appear exactly once. 

## Comments
- These words have got to be rather rare. `1 2 3` words are not that easy to find. Let alone a `1 2 3 4`.
- How often do you even find a word with 4 repeating letters? voodoo, what else? Taramasalata has 6 a's. 
- The english language seems to have a few `1 2` words : `ill all eke eve boo coo moo`

## Necessary condition
We can notice that if `L` is the length of pyramid word, then there must be an integer `n` that satisfies
```
L = 1 + 2 + 3 + .... + n = n*(n+1)/2 
```
Therefore, we only need to look at words whose length can be expressed as a sum of the first `n `integers.
This condition is necessary but of course not sufficient (e.g `bad` is not a pyramid word).

Which also means that `n` is the number of distinct letters in word of length `L` : if you establish a map
whose keys are the distinct letters and whose value is the letter frequency, then the number of map entries must
the number of distinct letters. If not, the word is noy a pyramid word. 

## Assumptions for this exercise
- Case insensitive
- We stick to English with words of `foreign` origin written **without** accents.
- The longest english word is [here](https://en.wikipedia.org/wiki/Pneumonoultramicroscopicsilicovolcanoconiosis) :
it has less than **50** letters.
- Therefore, if `MAX` is assumed to be the maximum word length, we only need to consider numbers `n` where `n*(n+1)/2`
yields a length value lower than `MAX`

## Try It
- Service is defined [here](../apps/words/src/main/java/com/vnet/apps/words/Controller.java)
- Pyramid Word Logic is defined [here](../apps/words/src/main/java/com/vnet/apps/words/pyramid/PyramidFinder.java)
- Clone [java-samples](https://github.com/sfogo/java-samples)
- Start Service
```
./gradlew apps:words:bootRun
```

```
curl http://localhost:8080/words/pyramids/deemed
{"d":2,"e":3,"m":1}
```

```
curl http://localhost:8080/words/pyramids/banana
{"a":3,"b":1,"n":2}
```

```
curl http://localhost:8080/words/pyramids/abcde
{"error":"Word of length 5 cannot be a pyramid"}
```

```
curl http://localhost:8080/words/pyramids/doomed
{"error":"doomed is not a pyramid word. Most frequent character after e(1) is m(1)"}
```
