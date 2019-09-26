### Single Thread Exception 模式


#### FlightSecurity 实例
采用排他式的操作保证在同一时刻只能有一个线程取访问共享资源。
在 `pass` 方法上加 `synchronized` 是实现该模式的核心。

#### 哲学家就餐问题
`EatNoodleThreadTest` 中引发交叉锁。

解决：新增`TablewarePair` ，避免 `synchronized` 重入锁，
参见 `EatNoodleThread2Test` 。