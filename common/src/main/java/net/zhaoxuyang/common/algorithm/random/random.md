## 随机化算法

随机化算法分类：
- 数值随机化算法：在原理上可能就不存在精确解，或者无法在可行时间内求得，因此用该算法得到相当满意的解。
- 蒙特卡罗算法：能求得问题的一个解，但这个解未必是正确的。
- 拉斯维加斯算法：绝不返回错误的解，但有时可能找不到解。
- 舍伍德算法：当一个确定性算法在最坏与平均情况时间复杂度相差较大时，引入随机性来降低最坏情况出现的概率，不会改变结果。

随机数发生器：
a<sub>0</sub> = d
a<sub>n</sub> = (ba<sub>n-1</sub> mod m) , n = 1,2,...

```
#define m 65536L
#define b 1194211693L 
#define c 12345L
class RandomNumber {
    private:
        unsigned long d;
    public:
        RandomNumber(unsigned long s = 0);
        unsigned short random(unsigned long n);
        double fRandom(void);
};

//产生种子
RandomNumber::RandomNumber(unsigned long s){
    if(s == 0){
        d = time(0);
    } else {
        d = s;
    }
}
//产生0:n-1之间的随机整数
unsigned short RandomNumber::random(unsigned long n){
    d = b * d + c;
    return (unsigned short)((d>>16) % n);
}
//产生随机实数
double Number::fRandom(void){
    return random(m)/double(m);
}

```