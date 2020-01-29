# Samples
## Reactor Sample App
e.g. First argument is flux size, 2nd argument is concurrency.
```
./gradlew reactor:runSampleApp --args="499499 8"
```
Output prints usage by thread. For instance:
```
14:04:16.552 [SampleApp-6] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-9  : 11.46%    57218
14:04:16.552 [SampleApp-6] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-8  :  6.97%    34817
14:04:16.553 [SampleApp-6] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-7  : 12.76%    63716
14:04:16.553 [SampleApp-6] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-6  : 11.73%    58586
14:04:16.554 [SampleApp-6] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-11 :  0.12%      582
14:04:16.554 [SampleApp-6] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-10 :  5.73%    28642
14:04:16.554 [SampleApp-6] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-5  : 21.77%   108751
14:04:16.555 [SampleApp-6] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-4  :  3.94%    19680
14:04:16.555 [SampleApp-6] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-3  : 12.80%    63943
14:04:16.555 [SampleApp-6] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-2  : 12.73%    63564
14:04:16.555 [SampleApp-6] INFO com.vnet.samples.reactor.SampleApp - Total                         499499
14:04:16.555 [SampleApp-6] INFO com.vnet.samples.reactor.SampleApp - Done

BUILD SUCCESSFUL in 2m 0s
4 actionable tasks: 1 executed, 3 up-to-date
```

## Reactor Article App
This counts and orders letters occurrences in a few articles (French, Spanish, Italian) placed in resources.
```
./gradlew reactor:runArticleApp --args="it"
```
```
17:09:05.106 [main] INFO com.vnet.samples.reactor.ArticleApp - /articles/it.txt has 2479 words
17:09:05.182 [main] DEBUG reactor.util.Loggers$LoggerFactory - Using Slf4j logging framework
17:09:05.232 [main] INFO com.vnet.samples.reactor.ArticleApp - SIZE:36
17:09:05.242 [main] INFO com.vnet.samples.reactor.ArticleApp - e : 1532
17:09:05.242 [main] INFO com.vnet.samples.reactor.ArticleApp - i : 1246
17:09:05.242 [main] INFO com.vnet.samples.reactor.ArticleApp - a : 1188
17:09:05.242 [main] INFO com.vnet.samples.reactor.ArticleApp - o : 1098
17:09:05.242 [main] INFO com.vnet.samples.reactor.ArticleApp - n : 766
17:09:05.242 [main] INFO com.vnet.samples.reactor.ArticleApp - t : 743
17:09:05.242 [main] INFO com.vnet.samples.reactor.ArticleApp - r : 737
17:09:05.242 [main] INFO com.vnet.samples.reactor.ArticleApp - l : 719
17:09:05.242 [main] INFO com.vnet.samples.reactor.ArticleApp - s : 680
17:09:05.242 [main] INFO com.vnet.samples.reactor.ArticleApp - c : 517
17:09:05.242 [main] INFO com.vnet.samples.reactor.ArticleApp - d : 466
17:09:05.242 [main] INFO com.vnet.samples.reactor.ArticleApp - p : 381
17:09:05.242 [main] INFO com.vnet.samples.reactor.ArticleApp - u : 352
17:09:05.242 [main] INFO com.vnet.samples.reactor.ArticleApp - m : 343
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - v : 238
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - g : 195
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - z : 139
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - h : 110
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - f : 108
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - b : 81
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - q : 70
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - é : 65
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - à : 54
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - ( : 37
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - ) : 37
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - ù : 23
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - ò : 15
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - è : 13
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - ì : 9
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - k : 5
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - 1 : 5
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - = : 5
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - ? : 4
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - ! : 2
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - / : 2
17:09:05.243 [main] INFO com.vnet.samples.reactor.ArticleApp - x : 2
```
