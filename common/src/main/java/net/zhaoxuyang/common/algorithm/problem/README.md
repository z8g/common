
#### 深度优先搜索

```c++
bool Visited[n + 1];
for(int i = 1; i <= n; i++){
    Visited[i] = 0;
}

//从顶点k出发进行深度优先搜索
void Dfsk(int k){
    Visited[k] = 1;
    for(int j = 1; j <= n; j++){
        if(c[k][j] == 1 && Visited[j] == 0){
            Dfsk(j);
        }
    }
}

//深度优先搜索整个图
void Dfs(){
    for(int i = 1; i <= n; i++){
        if(Visited[i] == 0){
            Dfsk(i);
        }
    }
}

```

#### 回溯法

##### 回溯法的算法框架
为定义搜索范围，应明确以下几个方面：
1. 问题解的形式：表示成一个n元组的形式`(x[0],x[1],...,x[n-1])`
2. 显约束：对分量`x[i]`的取值范围限定。
3. 隐约束：为满足问题的解而对不同分量之间施加的约束。
4. 解空间：对于问题的一个实例，解向量满足显约束的所有n元组构成了该实例的一个解空间。

----

在搜索的过程中，应了解几个名词：
1. 扩展结点：一个正在生成孩子的结点。
2. 活结点：一个自身已生成但其孩子还没有全部生成的结点。
3. 死结点：一个所有孩子已生成的结点。

----

求解过程：
1. 定义问题的解空间。
2. 确定空间的组织结构。
3. 搜索解空间：
    - 确定约束条件
    - 确定限界条件
    - 搜索过程

----

算法描述：

(1)递归形式

```
// t为扩展节点在树中所处的层次
void Backtrack(int t){
    if(t > n){
        //搜索层次大于解空间的树的深度，说明找到了叶子结点，即找到了问题的一个解
        output(x);
    } else {
        for (int i = s(n, t); i <= e(n, t); i++){
            x[t] = d(i);
            if(constraint(t) && bound(t)){
                Backtrack(t + 1);
            }
        }
    }
}
```

(2)非递归形式

```
void NBacktrack(){
    int t = 1;
    while(t > 0){
        if(s(n,t) <= e(n, t)){
            for(int i = s(n, t); i <= e(n,t); i++){
                x[t] = d(i);
                if(constraint(t) && bound(t)){
                    if(t > n){
                        output(x);
                    } else {
                        t++;
                    }
                }
            }
        } else {
            t--;
        }
    }
}
```

##### 子集树

> 当所给问题是从n个元素组成的集合S中找出满足某一性质的一个子集时，相应的解空间树称为子集树。
- 0-1 背包问题
- 子集和问题
- 装载问题
- 最大团问题

算法描述：

```
//x用来存放当前解，constraint()为约束函数，bound()为限界函数
void Backtrack(int t){
    if(t > n){
        output(x);
    }
    //判断能否沿着扩展结点的左分支进行扩展
    if(constraint(t)){
        //做相关标识
        Backtrack(t + 1);
        //做相关标识的反操作
    }
    //判断能否沿着扩展结点的右分支进行扩展
    if(bount(t)){
        //做相关标识
        Backstrack(t + 1);
        //做相关标识的反操作
    }
}
```

##### 排列树

> 当所给的问题是从n个元素的排列中找出满足某种性质的一个排列时，相应的解空间称为排列树。
- n皇后问题
- 旅行商问题
- 批处理作业调度问题
- 圆排列问题
- 电路板排序问题

算法描述：

```
void Backtrack(int t){
    if(t > n){
        output(x);
    } else {
        for(int i = t; i <= n; i++){
            swap(x[t], x[i]);
            if(constraint(t) && bound(t)){
                Backtrack(t + 1);
            }
            swap(x[t], x[i]);
        }
    }
}
```

##### 满m叉树(组合树)
> 当所给问题的n个元素中每一个元素均有m种选择，要求确定其中的一种选择，
使得对这n个元素的选择结果组成的向量满足某种性质，即寻找满足某种特性的n个元素取值的一个组合。
这类问题的解空间称为满m叉树。
- n皇后问题
- 图的m着色问题
- 最小机器设计问题

算法描述：

```
void Backtrack(int t){
    if(t > n) {
        output(x);
    } else {
        for (int i = 1; i <= m; i++) {
            if (constraint(t) && bound(t)) {
                x[t] = i;
                //做其他相关标识
                Backtrack(t + 1);
                //做其他相关标识的反操作，退出相关标识
            }
        }
    }
}
```

#### 广度优先搜索

算法描述：

```
bool Visited[n + 1];
for(int i = 1; i <= n; i++){
    Visited[i] = 0;
}
void BFSVO(int v0){
    int w;
    visit(v0);
    Visited[v0] = 1;
    InitQueue(&Q);
    InsertQueue(&Q, v0);
    while(!Empty(Q)){
        DeleteQueue(&Q, &v);
        for(int i = 1; i <= n; i++) {
            if(g[v][i] != 0){
                w = i;
            }
            if(!Visited(w)){
                visit(w);
                Visited[w] = 1;
                InsertQueue(&Q, w);
            }
        }
    }
}
BFS(){
    for(int i = 1; i <= n; i++) {
        if(Visited[i] = 0){
            BFSVO(i);
        }
    }
}

```

#### 分支限界法
> 分支限界发先将根结点加入活结点表，接着从活结点表中取出根结点，使其成为当前扩展结点，
一次性生成所有孩子结点，判断孩子结点是舍弃还是保留，舍弃那些导致可行解或者导致非最优解的孩子结点，
其余的被保留在活结点表中。
再从活结点表中取出一个活结点，重复上述过程。

解题步骤：
1. 定义问题的解空间
2. 确定问题的解空间组织结构(树或图)
3. 搜索解空间。搜索要定义判断标准(约束函数或限界函数)，如果选用优先队列，需确定优先级。

