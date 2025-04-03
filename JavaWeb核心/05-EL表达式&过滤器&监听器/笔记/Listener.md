# 3 Servlet规范中的监听器-Listener

## 3.1 观察者设计模式

观察者设计模式。因为所有的监听器都是观察者设计模式的体现。

那什么是观察者设计模式呢？

它是事件驱动的一种体现形式。就好比在做什么事情的时候被人盯着。当对应做到某件事时，触发事件。

观察者模式通常由以下三部分组成：

​        事件源：触发事件的对象。

​	事件：触发的动作，里面封装了事件源。

​	监听器：当事件源触发事件时，要做的事情。一般是一个接口，由使用者来实现。（此处的思想还涉及了一个涉及模式，我们在JDBC的第二天课程中就给同学们讲解，策略模式）



## 3.1 Servlet规范中的8个监听器简介

在程序当中，我们可以对：对象的创建销毁、域对象中属性的变化、会话相关内容进行监听

Servlet规范中共计8个监听器，监听器都是以接口形式提供，具体功能需要我们自己来完成

### 3.1.1 监听对象创建的

#### 1）ServletContextListener

ServletContextListener:用于监听ServletContext对象的创建和销毁

核心方法 

| 返回值 | 方法名                                      | 作用                 |
| ------ | ------------------------------------------- | -------------------- |
| void   | contextInitialized(ServletContextEvent sce) | 对象创建时执行该方法 |
| void   | contextDestroyed(ServletContextEvent sce)   | 对象销毁时执行该方法 |

参数:ServletContextEvent代表事件对象 事件对象中封装了事件源，也就是ServletContext 真正的事件指的是创建或销毁ServletContext对象的操作

```java
/**
 * 用于监听ServletContext对象创建和销毁的监听器
 * @since v 2.3
 */

public interface ServletContextListener extends EventListener {

    /**
     *	对象创建时执行此方法。该方法的参数是ServletContextEvent事件对象，事件是【创建对象】这个动作
     *  事件对象中封装着触发事件的来源，即事件源，就是ServletContext
     */
    public default void contextInitialized(ServletContextEvent sce) {
    }

    /**
     * 对象销毁执行此方法
     */
    public default void contextDestroyed(ServletContextEvent sce) {
    }
}
```

#### 2）HttpSessionListener

用于监听HttpSession对象的创建和销毁

核心方法：

| 返回值 | 方法名                                | 作用                 |
| ------ | ------------------------------------- | -------------------- |
| void   | sessionCreated(HttpSessionEvent se)   | 对象创建时执行该方法 |
| void   | sessionDestoryed(HttpSessionEvent se) | 对象销毁时执行该方法 |



```java
/**
 * 用于监听HttpSession对象创建和销毁的监听器
 * @since v 2.3
 */
public interface HttpSessionListener extends EventListener {

    /**
     * 对象创建时执行此方法。
     */
    public default void sessionCreated(HttpSessionEvent se) {
    }

    /**
     *  对象销毁执行此方法
     */
    public default void sessionDestroyed(HttpSessionEvent se) {
    }
}
```

#### 3）ServletRequestListener

用于监听ServletRequest对象的创建和销毁

核心方法：

| 返回值 | 方法名                                      | 作用                 |
| ------ | ------------------------------------------- | -------------------- |
| void   | requestInitialized(ServletRequestEvent sre) | 对象创建时执行该方法 |
| void   | requestDestroyed(ServletRequestEvent sre)   | 对象销毁时执行该方法 |

参数：ServletRequestEvent  代表事件对象

事件对象中封装了事件源，也就是ServletRequest

真正的事件指的是创建或销毁ServletRequest对象的额操作

```java
/**
 * 用于监听ServletRequest对象创建和销毁的监听器
 * @since Servlet 2.4
 */
public interface ServletRequestListener extends EventListener {

   	/**
     *  对象创建时执行此方法。
     */
    public default void requestInitialized (ServletRequestEvent sre) {
    }
    
    /**
     * 对象销毁执行此方法
     */
    public default void requestDestroyed (ServletRequestEvent sre) {
    } 
}
```

### 3.1.2 监听域中属性发生变化的

#### 1）ServletContextAttributeListener

用于监听ServletContext应用域中属性变化

核心方法：

| 返回值 | 方法名                                               | 作用                     |
| ------ | ---------------------------------------------------- | ------------------------ |
| void   | attributeAdded(ServletContextAttributeEvent scae)    | 域中添加属性时使用该方法 |
| void   | attributeRemoved(ServletContextAttributeEvent scae)  | 域中移除属性时使用该方法 |
| void   | attributeReplaced(ServletContextAttributeEvent scae) | 域中替换属性时使用该方法 |

参数：ServletContextAttributeEvent  代表事件对象

事件对象中封装了事件源，也就是ServletContext

真正的事件指的是添加、移除、替换应用域中属性的操作

```java
/**
 * 用于监听ServletContext域（应用域）中属性发生变化的监听器
 * @since v 2.3
 */

public interface ServletContextAttributeListener extends EventListener {
    /**
     * 域中添加了属性触发此方法。参数是ServletContextAttributeEvent事件对象，事件是【添加属性】。
     * 事件对象中封装着事件源，即ServletContext。
     * 当ServletContext执行setAttribute方法时，此方法可以知道，并执行。
     */
    public default void attributeAdded(ServletContextAttributeEvent scae) {
    }

    /**
     * 域中删除了属性触发此方法
     */
    public default void attributeRemoved(ServletContextAttributeEvent scae) {
    }

    /**
     * 域中属性发生改变触发此方法
     */
    public default void attributeReplaced(ServletContextAttributeEvent scae) {
    }
}
```

#### 2）HttpSessionAttributeListener

用于监听HttpSession会话域中属性变化

核心方法：

| 返回值 | 方法名                                        | 作用                     |
| ------ | --------------------------------------------- | ------------------------ |
| void   | attributeAdded(HttpSessionBindingEvent se)    | 域中添加属性时使用该方法 |
| void   | attributeRemoved(HttpSessionBindingEvent se)  | 域中移除属性时使用该方法 |
| void   | attributeReplaced(HttpSessionBindingEvent se) | 域中替换属性时使用该方法 |

参数：HttpSessionBindingEvent  代表事件对象

事件对象中封装了事件源，也就是HttpSession

真正的事件指的是添加、移除、替换会话域中属性的操作

```java
/**
 * 用于监听HttpSession域（会话域）中属性发生变化的监听器
 * @since v 2.3
 */
public interface HttpSessionAttributeListener extends EventListener {

    /**
     * 域中添加了属性触发此方法。
     */
    public default void attributeAdded(HttpSessionBindingEvent se) {
    }

    /**
     * 域中删除了属性触发此方法
     */
    public default void attributeRemoved(HttpSessionBindingEvent se) {
    }

    /**
     * 域中属性发生改变触发此方法
     */
    public default void attributeReplaced(HttpSessionBindingEvent se) {
    }
}
```

#### 3）ServletRequestAttributeListener

用于监听用于监听ServletRequest请求域中属性变化

核心方法：

| 返回值 | 方法名                                               | 作用                     |
| ------ | ---------------------------------------------------- | ------------------------ |
| void   | attributeAdded(ServletRequestAttributeEvent srae)    | 域中添加属性时使用该方法 |
| void   | attributeRemoved(ServletRequestAttributeEvent srae)  | 域中移除属性时使用该方法 |
| void   | attributeReplaced(ServletRequestAttributeEvent srae) | 域中替换属性时使用该方法 |

参数：ServletRequestAttributeEvent  代表事件对象

事件对象中封装了事件源，也就是ServletRequest

真正的事件指的是添加、移除、替换请求域中属性的操作

```java
/**
 * 用于监听ServletRequest域（请求域）中属性发生变化的监听器
 * @since Servlet 2.4
 */
public interface ServletRequestAttributeListener extends EventListener {
    /**
     * 域中添加了属性触发此方法。
     */
    public default void attributeAdded(ServletRequestAttributeEvent srae) {
    }

    /**
     * 域中删除了属性触发此方法
     */
    public default void attributeRemoved(ServletRequestAttributeEvent srae) {
    }

    /**
     * 域中属性发生改变触发此方法
     */
    public default void attributeReplaced(ServletRequestAttributeEvent srae) {
    }
}
```

### 3.1.3 和会话相关的两个感知型监听器

此处要跟同学们明确一下，和会话域相关的两个感知型监听器是无需配置的，直接编写代码即可。

#### 1）HttpSessionBinderListener

用于感知对象和和会话域绑定的监听器

核心方法：

| 返回值 | 方法名                                      | 作用                                       |
| ------ | ------------------------------------------- | ------------------------------------------ |
| void   | valueBound(HttpSessionBindingEvent event)   | 当数据加入会话域时，也就是绑定，此方法执行 |
| void   | valueUnbound(HttpSessionBindingEvent event) | 当从会话域移除时，也就是解绑，此方法执行   |
|        |                                             |                                            |

参数：HttpSessionBindingEvent  代表事件对象

事件对象中封装了事件源，也就是HttpSession

真正的事件指的是添加、移除会话域中属性的操作

```java
/**
 * 用于感知对象和和会话域绑定的监听器
 * 当有数据加入会话域或从会话域中移除，此监听器的两个方法会执行。
 * 加入会话域即和会话域绑定
 * 从会话域移除即从会话域解绑
 */
public interface HttpSessionBindingListener extends EventListener {

    /**
     * 当数据加入会话域时，也就是绑定，此方法执行
     */
    public default void valueBound(HttpSessionBindingEvent event) {
    }

    /**
     * 当从会话域移除时，也就是解绑，此方法执行
     */
    public default void valueUnbound(HttpSessionBindingEvent event) {
    }
}

```

#### 2）HttpSessionActivationListener

用于感知会话域中对象钝化和活化的监听器

核心方法：

| 返回值 | 方法名                                    | 作用                       |
| ------ | ----------------------------------------- | -------------------------- |
| void   | sessionWillPassivate(HttpSessionEvent se) | 会话域中数据钝化执行该方法 |
| void   | sessionDidActivate(HttpSessionEvent se)   | 会话域中数据活化执行该方法 |
|        |                                           |                            |

参数：HttpSessionEvent  代表事件对象

事件对象中封装了事件源，也就是HttpSession

真正的事件指的是会话域中数据钝化、活化的操作

```java
/**
 * 用于感知会话域中对象钝化和活化的监听器
 */
public interface HttpSessionActivationListener extends EventListener {

    /**
     * 当会话域中的数据钝化时，此方法执行
     */
    public default void sessionWillPassivate(HttpSessionEvent se) {
    }

    /**
     * 当会话域中的数据活化时（激活），此方法执行
     */
    public default void sessionDidActivate(HttpSessionEvent se) {
    }
}
```

## 3.2 监听器的使用

在实际开发中，我们可以根据具体情况来从这8个监听器中选择使用。感知型监听器由于无需配置，只需要根据实际需求编写代码，所以此处我们就不再演示了。我们在剩余6个中分别选择一个监听对象创建销毁和对象域中属性发生变化的监听器演示一下。

### 3.2.1 ServletContextListener的使用

**第一步：创建工程**

**第二步：编写监听器**

```java
/**
 * 用于监听ServletContext对象创建和销毁的监听器
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class ServletContextListenerDemo implements ServletContextListener {

    /**
     * 对象创建时，执行此方法
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听到了对象的创建");
        //1.获取事件源对象
        ServletContext servletContext = sce.getServletContext();
        System.out.println(servletContext);
    }

    /**
     * 对象销毁时，执行此方法
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听到了对象的销毁");
    }
}
```

**第三步：在web.xml中配置监听器**

```xml
<!--配置监听器-->
<listener>
    <listener-class>com.itheima.web.listener.ServletContextListenerDemo</listener-class>
</listener>
```

**第四步：测试结果**

### 3.2.2 ServletContextAttributeListener的使用

**第一步：创建工程**

沿用上一个案例的工程

**第二步：编写监听器**

```java
/**
 * 监听域中属性发生变化的监听器
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class ServletContextAttributeListenerDemo implements ServletContextAttributeListener {

    /**
     * 域中添加了数据
     * @param scae
     */
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("监听到域中加入了属性");
        /**
         * 由于除了我们往域中添加了数据外，应用在加载时还会自动往域中添加一些属性。
         * 我们可以获取域中所有名称的枚举，从而看到域中都有哪些属性
         */
        
        //1.获取事件源对象ServletContext
        ServletContext servletContext = scae.getServletContext();
        //2.获取域中所有名称的枚举
        Enumeration<String> names = servletContext.getAttributeNames();
        //3.遍历名称的枚举
        while(names.hasMoreElements()){
            //4.获取每个名称
            String name = names.nextElement();
            //5.获取值
            Object value = servletContext.getAttribute(name);
            //6.输出名称和值
            System.out.println("name is "+name+" and value is "+value);
        }
    }

    /**
     * 域中移除了数据
     * @param scae
     */
    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("监听到域中移除了属性");
    }

    /**
     * 域中属性发生了替换
     * @param scae
     */
    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("监听到域中属性发生了替换");
    }
}
```

同时，我们还需要借助第一个`ServletContextListenerDemo`监听器，往域中存入数据，替换域中的数据以及从域中移除数据，代码如下：

```java
/**
 * 用于监听ServletContext对象创建和销毁的监听器
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class ServletContextListenerDemo implements ServletContextListener {

    /**
     * 对象创建时，执行此方法
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听到了对象的创建");
        //1.获取事件源对象
        ServletContext servletContext = sce.getServletContext();
        //2.往域中加入属性
        servletContext.setAttribute("servletContext","test");
    }

    /**
     * 对象销毁时，执行此方法
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //1.取出事件源对象
        ServletContext servletContext = sce.getServletContext();
        //2.往域中加入属性，但是名称仍采用servletContext，此时就是替换
        servletContext.setAttribute("servletContext","demo");
        System.out.println("监听到了对象的销毁");
        //3.移除属性
        servletContext.removeAttribute("servletContext");
    }
}
```

**第三步：在web.xml中配置监听器**

```xml
<!--配置监听器-->
<listener>
    <listener-class>com.itheima.web.listener.ServletContextListenerDemo</listener-class>
</listener>

<!--配置监听器-->
<listener>
    <listener-class>com.itheima.web.listener.ServletContextAttributeListenerDemo</listener-class>
</listener>
```

**第四步：测试结果**

![attributelistener_demo](assets/attributelistener_demo.png)

# 4 综合案例-学生管理系统改造

## 4.1 需求说明

### 4.1.1 解决乱码问题

我们的学生管理系统中，肯定会有请求和响应的中文乱码问题。而乱码问题在学习Servlet的课程中已经讲解了如何解决了。只是在实际开发中，当有很多的Servlet时，肯定不能在每个Servlet中都编写一遍解决乱码的代码。因此，就可以利用我们今天学习的过滤器来实现统一解决请求和响应乱码的问题。

### 4.1.2 检查登录

在学生管理系统中，它包含了学生信息的录入和学生列表的查询，用户（员工）信息的录入以及查询。当然，我们实际的功能可能远远不止这些。但是就已有功能来说，也不是谁都可以通过地址栏直接输入访问的，它应该有权限的控制，只是我们课程在此处没法深入展开讲解权限，但最起码的登录，身份的认证还是必要的。

由此，就引出来一个问题，是在每次访问Servlet时，在Servlet的代码中加入是否认证过身份的判断吗？显然，是不合理的。那么，既然不是在每个Servlet中编写，就应该是统一管理和维护。此时，我们的过滤器就又可以出场了。

### 4.1.3 页面的java代码块和jsp表达式改造

我们今天除了学习了过滤器，还学习了EL表达式和JSTL标签库，它们的出现就是避免我们的JSP页面中有过多的java代码或者jsp表达式。我们要运用今天所学知识改造页面。

## 4.2 案例实现

### 4.2.1 乱码问题过滤器

创建EncodingFilter类，解决乱码

```java
package com.itheima.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    解决全局乱码问题
 */
@WebFilter("/*")
public class EncodingFilter implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        try{
            //1.将请求和响应对象转换为和HTTP协议相关
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;

            //2.设置编码格式
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            //3.放行
            filterChain.doFilter(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

```



### 4.2.2 检查登录过滤器

检查登录，创建LoginFilter 类

```java
package com.itheima.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    检查登录
 */
@WebFilter(value = {"/addStudent.jsp","/listStudentServlet"})
public class LoginFilter implements Filter{
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        try{
            //1.将请求和响应对象转换为和HTTP协议相关
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;

            //2.获取会话域对象中数据
            Object username = request.getSession().getAttribute("username");

            //3.判断用户名
            if(username == null || "".equals(username)) {
                //重定向到登录页面
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return;
            }

            //4.放行
            filterChain.doFilter(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```



### 4.2.3 jsp页面的改造 

​	1，修改`addStudent.jsp`的虚拟访问路径

```jsp
<form action="${pageContext.request.contextPath}/addStudentServlet" method="get" autocomplete="off">
    学生姓名：<input type="text" name="username"> <br>
    学生年龄：<input type="number" name="age"> <br>
    学生成绩：<input type="number" name="score"> <br>
    <button type="submit">保存</button>
</form>
```

2，修改`index.jsp`

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>学生管理系统首页</title>
</head>
<body>
    <%--
        获取会话域中的数据
        如果获取到了则显示添加和查看功能的超链接
        如果没获取到则显示登录功能的超链接
    --%>
    <c:if test="${sessionScope.username eq null}">
        <a href="${pageContext.request.contextPath}/login.jsp">请登录</a>
    </c:if>

    <c:if test="${sessionScope.username ne null}">
        <a href="${pageContext.request.contextPath}/addStudent.jsp">添加学生</a>
        <a href="${pageContext.request.contextPath}/listStudentServlet">查看学生</a>
    </c:if>

</body>
</html>

```

3，修改`listStudent.jsp`

```jsp
<%@ page import="com.itheima.bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>查看学生</title>
</head>
<body>
    <table width="600px" border="1px">
        <tr>
            <th>学生姓名</th>
            <th>学生年龄</th>
            <th>学生成绩</th>
        </tr>
        <c:forEach items="${students}" var="s">
            <tr align="center">
                <td>${s.username}</td>
                <td>${s.age}</td>
                <td>${s.score}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

```

4，修改`login.jsp`

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生登录</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/loginStudentServlet" method="get" autocomplete="off">
        姓名：<input type="text" name="username"> <br>
        密码：<input type="password" name="password"> <br>
        <button type="submit">登录</button>
    </form>
</body>
</html>

```

