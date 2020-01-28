# Samples
## Reactor
e.g. First argument in flux size, 2nd argument is concurrency.
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
