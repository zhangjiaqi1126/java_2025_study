# 随机数

## 1. Random

在 Java 中，生成随机数的主要类是 `java.util.Random`。这个类提供了多种方法来生成不同类型的随机数，包括整数、浮点数、布尔值等。

### 创建 Random 对象

首先，需要创建一个 `Random` 对象。可以使用默认构造函数来创建一个新的随机数生成器：

```java
Random random = new Random();
```

或者，使用带有种子的构造函数来创建一个确定性随机数生成器：

```java
Random random = new Random(12345); // 使用固定种子
```

### 生成随机整数

要生成一个在指定范围内的随机整数，可以使用 `nextInt(int bound)` 方法。这个方法返回一个在 [0, bound) 范围内的随机整数。

例如，生成一个在 1 到 10 之间的随机整数：

```java
int randomNumber = random.nextInt(10) + 1;
```

### 生成随机浮点数

要生成一个在 0.0 和 1.0 之间的随机浮点数，可以使用 `nextDouble()` 方法。

例如，生成一个在 0.0 和 1.0 之间的随机浮点数：

```java
double randomDouble = random.nextDouble();
```

如果需要生成一个在指定范围内的随机浮点数，可以使用以下公式：

```java
double min = 0.5;
double max = 2.0;
double randomDoubleInRange = min + (max - min) * random.nextDouble();
```

### 生成随机布尔值

要生成一个随机的布尔值，可以使用 `nextBoolean()` 方法。

例如，生成一个随机的布尔值：

```java
boolean randomBoolean = random.nextBoolean();
```

### 其他方法

`Random` 类还提供了其他一些有用的方法，例如：

- `nextInt(int n)`：返回一个在 [0, n) 范围内的随机整数。
- `nextLong()`：返回一个随机的长整数。
- `nextGaussian()`：返回一个符合标准正态分布的随机浮点数。
- `nextBytes(byte[] bytes)`：将随机数填充到指定的字节数组中。

### 注意事项

使用 `Random` 类时需要注意以下几点：

1. **种子**：如果使用默认构造函数创建 `Random` 对象，每次运行程序生成的随机数序列可能会不同。如果需要在多次运行中生成相同的随机数序列，可以使用带有种子的构造函数。
2. **线程安全**：`Random` 类不是线程安全的。如果在多个线程中共享同一个 `Random` 对象，可能会出现问题。可以考虑使用 `ThreadLocalRandom` 类来生成线程安全的随机数。
3. **伪随机数**：`Random` 类生成的随机数是伪随机数，即它们是由一个确定性算法生成的，并非真正的随机数。如果需要更高质量的随机数，可以使用 `SecureRandom` 类。



## 2.`java.lang.Math`类的方法

虽然`Math`类不直接提供生成随机数的方法，但它提供了与随机数相关的其他工具，例如`Math.random()`。这个方法返回一个大于等于0.0且小于1.0的双精度浮点数。

```java
double randomValue = Math.random(); // 返回一个[0.0, 1.0)之间的随机浮点数
```

如果要生成特定范围的随机数，可以像上面使用`Random`类中的方法那样进行调整。例如，生成[a, b)之间的随机浮点数：

```java
double a = 5.0, b = 15.0;
double randomFloat = a + (b - a) * Math.random(); // 生成a到b之间的随机浮点数，不包含b
```

## 3. 使用`java.security.SecureRandom`类（更安全的随机数）

对于需要高安全性的应用（如加密），推荐使用`SecureRandom`类，它基于更强的加密算法来生成随机数。

```java
SecureRandom secureRandom = new SecureRandom();
int secureRandomInt = secureRandom.nextInt(); // 生成一个随机整数
```

### 总结

根据你的需求（如是否需要安全性、生成的数值类型等），你可以选择使用`Random`、`Math`或`SecureRandom`类来生成随机数。每种方法都有其适用场景。对于大多数应用场景，`Random`类就足够了；对于需要更高安全性的场合，则应使用`SecureRandom`。