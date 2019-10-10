
类型:
Java Type | Type descriptor
-- | --
`boolean` | Z
`char` | C
`byte` | B
`short` | S
`int` | I
`float` | F
`long` | J
`double` | D
`Object` | Ljava/lang/Object
`int[]` | [I
`Object[][]` | [[Ljava/lang/Object

----

方法描述:
Method declaration | Method descriptor
-- | --
`void m(int i, float f)` | (IF)V
`int m(Object o)` | (Ljava/lang/Object;)I
`int[] m(int i, String s)` | (ILjava/lang/String;)[I
`Object m(int[] i)` | ([I)Ljava/lang/Object;

----

ASM通过`ClassVisitor`抽象类创建和修改Java字节码
