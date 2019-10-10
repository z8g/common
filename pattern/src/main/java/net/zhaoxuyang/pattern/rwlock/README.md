### 实现一个读写分离的锁

### StampedLock
读多写少的场景，用StamedLock（乐观锁机制）代替ReadWriteLock，性能极高。