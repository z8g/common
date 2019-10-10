## 部分抽象数据类型
#### java.lang 中标准Java系统类型
- `Integer` int 的封装类
- `Double` double的封装类
- `String` 可由索引访问的char值序列
- `StringBuilder` 字符串构造类

#### 其他Java数据类型
- `java.awt.Color` 颜色 
- `java.awt.Font` 字体 
- `java.net.URL` URL 
- `java.io.File` 文件 

#### 自定义的标准 I/O 类型
- `In` 输入流
- `Out` 输出流
- `Draw` 绘图类

#### 用于用例的面向数据的数据类型
- `Point2D` 平面上的点
- `Interval1D` 一维间隔
- `Interval2D` 二维间隔
- `Date` 日期
- `Transaction` 交易

#### 用于算法分析的数据类型
- `Counter` 计数器
- `Accumulator` 累加器
- `VisualAccumulator` 可视累加器
- `Stopwatch` 计时器

#### 集合类数据类型
- `Stack` 下压栈
- `Queue` 先进先出队列
- `Bag` 包
- `MinPQ` `MaxPQ` 优先队列
- `IndexMinPQ` `IndexMaxPQ` 索引优先队列
- `ST` 符号表
- `SET` 集合
- `StringST` 符号表（字符串键表）

#### 面向数据的图数据类型
- `Graph` 无向图
- `Digraph` 有向图
- `Edge` 边
- `EdgeWeightedGraph` 加权无向图
- `DirectedEdge` 加权边
- `EdgeWeightedDigraph` 加权有向图

#### 面向操作的图数据类型
- `UF` 动态连通性
- `DepthFirstPaths` 路径的深度优先搜索
- `CC` 连通分量
- `BreadthFirstPaths` 路径的广度优先搜索
- `DirectedDFS` 有向图路径的深度优先搜索
- `DirectedBFS` 有向图路径的广度优先搜索
- `TransitiveClosure` 所有路径
- `Topological` 拓扑排序
- `DepthFirstOrder` 深度优先搜索顶点被访问的顺序
- `DirectedCycle` 环的搜索
- `SCC` 强连通分量
- `MST` 最小生成树
- `SP` 最短路径