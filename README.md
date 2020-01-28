# Samples
## Reactor
e.g. First argument in flux size, 2nd argument is concurrency.
```
./gradlew reactor:runSampleApp --args="499499 8"
```
Output prints usage by thread. For instance:
```
12:53:24.425 [SampleApp-10] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-9 : 3.67% (18322)
12:53:24.425 [SampleApp-10] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-8 : 10.81% (53998)
12:53:24.425 [SampleApp-10] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-7 : 2.78% (13887)
12:53:24.425 [SampleApp-10] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-6 : 31.76% (158616)
12:53:24.425 [SampleApp-10] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-11 : 0.00% (16)
12:53:24.425 [SampleApp-10] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-10 : 8.42% (42038)
12:53:24.426 [SampleApp-10] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-5 : 9.01% (45013)
12:53:24.426 [SampleApp-10] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-4 : 15.21% (75992)
12:53:24.426 [SampleApp-10] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-3 : 11.89% (59374)
12:53:24.426 [SampleApp-10] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-2 : 6.46% (32243)
12:53:24.426 [SampleApp-10] INFO com.vnet.samples.reactor.SampleApp - Done
```
