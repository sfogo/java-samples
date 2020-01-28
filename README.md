# Samples
## Reactor
e.g. First argument in flux size, 2nd argument is concurrency.
```
./gradlew reactor:runSampleApp --args="499499 8"
```
Output prints usage by thread. For instance:
```
13:48:47.751 [SampleApp-2] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-9  : 16.34% (81622)
13:48:47.752 [SampleApp-2] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-8  : 14.23% (71071)
13:48:47.752 [SampleApp-2] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-7  : 16.45% (82183)
13:48:47.752 [SampleApp-2] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-6  :  8.03% (40132)
13:48:47.753 [SampleApp-2] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-10 :  3.10% (15508)
13:48:47.753 [SampleApp-2] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-5  :  4.38% (21855)
13:48:47.754 [SampleApp-2] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-4  : 10.42% (52026)
13:48:47.754 [SampleApp-2] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-3  :  8.26% (41277)
13:48:47.755 [SampleApp-2] INFO com.vnet.samples.reactor.SampleApp - Usage SampleApp-2  : 18.78% (93825)
13:48:47.755 [SampleApp-2] INFO com.vnet.samples.reactor.SampleApp - Done
```
