# 3 ServletContext

## 3.1 ServletContext概述

### 3.1.1 基本介绍

ServletContext对象，它是应用上下文对象。每一个应用有且只有一个ServletContext对象。它可以实现让应用中所有Servlet间的数据共享。 

### 3.1.2 生命周期

出生——活着——死亡

出生： 应用一加载，该对象就被创建出来了。一个应用只有一个实例对象。(Servlet和ServletContext都是单例的)

活着：只要应用一直提供服务，该对象就一直存在。

死亡：应用被卸载（或者服务器挂了），该对象消亡。

### 3.1.3 域对象概念

域对象的概念，它指的是对象有作用域，即有作用范围。

域对象的作用，域对象可以实现数据共享。不同作用范围的域对象，共享数据的能力不一样。

在Servlet规范中，一共有4个域对象。今天我们讲解的ServletContext就是其中一个。它也是我们接触的第一个域对象。它是web应用中最大的作用域，叫application域。每个应用只有一个application域。它可以实现整个应用间的数据共享功能。

## 3.2 ServletContext的使用



### 3.2.1 如何配置

ServletContext既然被称之为应用上下文对象，所以它的配置是针对整个应用的配置，而非某个特定Servlet的配置。它的配置被称为应用的初始化参数配置。

配置的方式，需要在`<web-app>`标签中使用`<context-param>`来配置初始化参数。具体代码如下：

```xml
<!--配置应用初始化参数-->
<context-param>
    <!--用于获取初始化参数的key-->
    <param-name>servletContextInfo</param-name>
    <!--初始化参数的值-->
    <param-value>This is application scope</param-value>
</context-param>
<!--每个应用初始化参数都需要用到context-param标签-->
<context-param>
    <param-name>globalEncoding</param-name>
    <param-value>UTF-8</param-value>
</context-param>
```

### 3.2.2 servletContext常用方法一

![image-20250307172258705](/Users/zhangjiaqi62/Library/Application Support/typora-user-images/image-20250307172258705.png)

在讲解ServletConfig对象时，我们已经看到了获取ServletContext对象的方式，它只需要调用ServletConfig对象的`getServletContext()`方法就可以了。具体代码如下：我们创建一个新的Servlet用于演示ServletContext。

```java
public class ServletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext context = getServletContext();

        //获取全局配置的globalEncoding
        String value = context.getInitParameter("globalEncoding");
        System.out.println(value);

        //获取应用的访问虚拟目录
        String contextPath = context.getContextPath();
        System.out.println(contextPath);

        //根据虚拟目录获取应用部署的磁盘绝对路径
        //获取b.txt文件的绝对路径
        String b = context.getRealPath("/b.txt");
        System.out.println(b);

        //获取c.txt文件的绝对路径
        String c = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);

        //获取a.txt文件的绝对路径
        String a = context.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(a);


        //向域对象中存储数据
        context.setAttribute("username","zhangsan");

        //移除域对象中username的数据
        //context.removeAttribute("username");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

```

### 3.2.3 servletContext常用方法二

![image-20250307172418568](/Users/zhangjiaqi62/Library/Application Support/typora-user-images/image-20250307172418568.png)
