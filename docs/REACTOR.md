# Reactor
## Sample App
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

## Article App
This counts and orders letters occurrences in a few articles (French, Spanish, Italian) placed in resources.
```
./gradlew reactor:runArticleApp --args="it"
```
```
20:45:29.673 [main] INFO com.vnet.samples.reactor.ArticleApp - /articles/it.txt has 2479 words
20:45:29.754 [main] DEBUG reactor.util.Loggers$LoggerFactory - Using Slf4j logging framework
20:45:29.801 [main] INFO com.vnet.samples.reactor.ArticleApp - SIZE:36
20:45:29.816 [main] INFO com.vnet.samples.reactor.ArticleApp - e  12.8%  1532
20:45:29.816 [main] INFO com.vnet.samples.reactor.ArticleApp - i  10.4%  1246
20:45:29.816 [main] INFO com.vnet.samples.reactor.ArticleApp - a   9.9%  1188
20:45:29.816 [main] INFO com.vnet.samples.reactor.ArticleApp - o   9.2%  1098
20:45:29.816 [main] INFO com.vnet.samples.reactor.ArticleApp - n   6.4%   766
20:45:29.817 [main] INFO com.vnet.samples.reactor.ArticleApp - t   6.2%   743
20:45:29.817 [main] INFO com.vnet.samples.reactor.ArticleApp - r   6.1%   737
20:45:29.818 [main] INFO com.vnet.samples.reactor.ArticleApp - l   6.0%   719
20:45:29.818 [main] INFO com.vnet.samples.reactor.ArticleApp - s   5.7%   680
20:45:29.818 [main] INFO com.vnet.samples.reactor.ArticleApp - c   4.3%   517
20:45:29.819 [main] INFO com.vnet.samples.reactor.ArticleApp - d   3.9%   466
20:45:29.819 [main] INFO com.vnet.samples.reactor.ArticleApp - p   3.2%   381
20:45:29.819 [main] INFO com.vnet.samples.reactor.ArticleApp - u   2.9%   352
20:45:29.820 [main] INFO com.vnet.samples.reactor.ArticleApp - m   2.9%   343
20:45:29.820 [main] INFO com.vnet.samples.reactor.ArticleApp - v   2.0%   238
20:45:29.820 [main] INFO com.vnet.samples.reactor.ArticleApp - g   1.6%   195
20:45:29.820 [main] INFO com.vnet.samples.reactor.ArticleApp - z   1.2%   139
20:45:29.821 [main] INFO com.vnet.samples.reactor.ArticleApp - h   0.9%   110
20:45:29.821 [main] INFO com.vnet.samples.reactor.ArticleApp - f   0.9%   108
20:45:29.821 [main] INFO com.vnet.samples.reactor.ArticleApp - b   0.7%    81
20:45:29.822 [main] INFO com.vnet.samples.reactor.ArticleApp - q   0.6%    70
20:45:29.822 [main] INFO com.vnet.samples.reactor.ArticleApp - é   0.5%    65
20:45:29.822 [main] INFO com.vnet.samples.reactor.ArticleApp - à   0.5%    54
20:45:29.823 [main] INFO com.vnet.samples.reactor.ArticleApp - (   0.3%    37
20:45:29.823 [main] INFO com.vnet.samples.reactor.ArticleApp - )   0.3%    37
20:45:29.823 [main] INFO com.vnet.samples.reactor.ArticleApp - ù   0.2%    23
20:45:29.823 [main] INFO com.vnet.samples.reactor.ArticleApp - ò   0.1%    15
20:45:29.823 [main] INFO com.vnet.samples.reactor.ArticleApp - è   0.1%    13
20:45:29.823 [main] INFO com.vnet.samples.reactor.ArticleApp - ì   0.1%     9
20:45:29.824 [main] INFO com.vnet.samples.reactor.ArticleApp - k   0.0%     5
20:45:29.824 [main] INFO com.vnet.samples.reactor.ArticleApp - 1   0.0%     5
20:45:29.824 [main] INFO com.vnet.samples.reactor.ArticleApp - =   0.0%     5
20:45:29.824 [main] INFO com.vnet.samples.reactor.ArticleApp - ?   0.0%     4
20:45:29.824 [main] INFO com.vnet.samples.reactor.ArticleApp - !   0.0%     2
20:45:29.824 [main] INFO com.vnet.samples.reactor.ArticleApp - /   0.0%     2
20:45:29.824 [main] INFO com.vnet.samples.reactor.ArticleApp - x   0.0%     2
```
