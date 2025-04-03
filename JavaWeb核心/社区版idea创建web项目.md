这是转载于两篇文章：

一、二是IDEA社区版直接创建WEB项目，
https://xie.infoq.cn/article/e2a24ab42bdef9fa7dd9a8c43

三是IDEA社区版首先创建Java普通项目，再转化为WEB项目
https://blog.csdn[.net](https://so.csdn.net/so/search?q=.net&spm=1001.2101.3001.7020)/xiaoxibiande/article/details/125016219

## 一、说明

Idea Community 社区版不兼容 Tomcat ，因此，不能像 Ultimate 那样可以直接使用插件创建 Web 项目。因此，如果不了解社区版的巧妙方式，可能会比较麻烦。

这里就以 Idea 的 Community 2019.3.4 作为集成开发环境，介绍如何创建一个 Web 项目。

## 二、步骤

### 1、创建 Maven 项目

首先，打开 Idea，选择创建新项目。

![img](https://i-blog.csdnimg.cn/blog_migrate/24343059c7ddf8e9e10102c34f1de527.png)

在弹出的 New Project 窗口中，选择 Maven。

然后，选择相应版本的 Project SDK，这里选择 Java 11。接着，勾选 Create from archetype，在窗口中间的包中，选择 maven-archetype-webapp，点击 Next 下一步。

![img](https://i-blog.csdnimg.cn/blog_migrate/96776361c72040f3540aa9e7e806789e.png)

在下一个页面，给“项目命名”和“设置项目文件位置”，这个因需求而异。这里就以 web-project 作为项目名称，项目文件位置存在 C 盘上。

![img](https://i-blog.csdnimg.cn/blog_migrate/dd61b85b715b0b767dc7ab4078bb5d01.png)

接下来的新页面，除了设置好 Maven home directory 路径，其他默认就行，然后点击 finish 即可。

![img](https://i-blog.csdnimg.cn/blog_migrate/bb962bb4c70e4bd2c272858885383279.png)

随后，Idea 会自动生成项目文件，弹出的新的窗口，右下角有一个 Maven projects need to be imported ，这里选择 import Changes ，以便更新包。

![img](https://i-blog.csdnimg.cn/blog_migrate/f9efa20c21fa3d973282c2fbdf8578e8.png)

我们可以仔细看下文件目录，会发现，项目已经是传统 Web 项目的风格，main 下有 webapp 目录，然后在 webapp 下又有 index.jsp 和 WEB-INF，最后就是 WEB-INF 下有 web.xml 文件。这些就是一个 Web 项目最基本的文件结构。

![img](https://i-blog.csdnimg.cn/blog_migrate/f001992f64ec1d0879bf653457802238.png)

### 2、使用 Smart Tomcat 插件

以上步骤已经把 JDK 和 Maven 配置好了，项目文件也创建好了，自然，我们就需要配置 Tomcat 容器，以便可以启动项目。

由于社区版去掉了支持 Tomcat 的功能部分，因此，我们可以使用 Smart Tomcat 插件来代替。

首先，需要添加 Smart Tomcat 插件，点击 File，选择 Settings。

![img](https://i-blog.csdnimg.cn/blog_migrate/c1219fc0b53121daa3b9cb66aca3bf6e.png)

弹出的窗口，选择 Plugins，而后在搜索栏中输入 Smart Tomcat。

![img](https://i-blog.csdnimg.cn/blog_migrate/74b6f23f04d54e6e735fb1ff0d3b613f.png)

如果搜索不出来，我们可以接着选择下面的 Search in Marketplace 选项。

![img](https://i-blog.csdnimg.cn/blog_migrate/5b7f50afc6015873ef0dd01926ad524a.png)

搜索出来后，选择 install 安装，而后重新启动 Idea 即可。

![img](https://i-blog.csdnimg.cn/blog_migrate/7b66a40c336e2f0ffdaaaa5c63116abf.png)

### 3、配置 Smart Tomcat 模板

选好了 Smart Tomcat 插件，接下来就需要配置模板。

点击 Idea 右上角的 Add Configuration。

![img](https://i-blog.csdnimg.cn/blog_migrate/36f06f56db1fdad8e29d5e8d160a39dd.png)

弹出的窗口，在 Templates 下选择 Smart Tomcat。由于没有可选的 Tomcat server 服务器，因此需要配置，故而点击 Configure。

![img](https://i-blog.csdnimg.cn/blog_migrate/121c205ec2e932d80d4c04c94e592c7b.png)

弹出窗口，选择 Tomcat Server，而后，选择符号“+”。接着，弹出窗口 Select Tomcat Server，选择本地 Tomcat 路径即可。

![img](https://i-blog.csdnimg.cn/blog_migrate/c1e3f5d425835b938224b5f5e8cfa78b.png)

接下来，可以修改 Name，这里选择默认。而后，点击 Apply 和 OK 即可。

![img](https://i-blog.csdnimg.cn/blog_migrate/75ea2776ee1327390fc695181b70e231.png)

接下来，就回到之前的窗口，设置 Smart Tomcat 信息。其中，主要配置 Tomcat server、Deployment directory、Context path。

Tomcat server，选择之前配置的本地 Tomcat 即可；

Deployment directory，选择项目的部署目录，也就是 webapp 目录；

Context path，访问路径填写除了服务器域名和端口以外的内容，这里选择默认的访问路径“/”。

其他的内容，默认就可以了，而后点击 Apply。

![img](https://i-blog.csdnimg.cn/blog_migrate/51a31521604bd15ba1386272cf07bacc.png)

虽然点击了 Apply，但是，事情还没有结束，因此不能马上点击 OK。这里是配置了通用的 Smart Tomcat 模板，这样做可以方便其他的项目使用这个通用的配置。

为了针对本项目的启动，还需要再添加一个具体的针对本项目运行的配置。在 Run/Debug Configuration 窗口，选择符号“+”。接着，选择 Smart Tomcat。

![img](https://i-blog.csdnimg.cn/blog_migrate/1da00f66824eeee397a7b180490cd59c.png)

新弹出的窗口，由于该配置已经借鉴引用了之前的通用配置，故而不需要大的调整了，这里修改一下 Name 名称就可以。当然，如果有变得的话，也可以调整一下配置的其他属性信息。最后，点击 Apply 和 OK 即可。

![img](https://i-blog.csdnimg.cn/blog_migrate/e88304f2df7aea95fb993ab349bba900.png)

到了这里，就完成了整体的基本配置工作了。

### 4、启动 Tomcat

最后，我们启动一下 Tomcat，看下能够把程序跑起来。点击 Idea 右上角的绿色三角，该三角表示运行。

![img](https://i-blog.csdnimg.cn/blog_migrate/bb4640e6034c25159c98bcb84089f9f4.png)

然后，就会在 Idea 窗口下半部分，Console 打印出日志出来，显示项目启动的情况。

![img](https://i-blog.csdnimg.cn/blog_migrate/de9ffcc667c62079d9b6e9042ba6d848.png)

我们可以通过浏览器输入链接：http://localhost:8080，访问站点。

![img](https://i-blog.csdnimg.cn/blog_migrate/ee0d7abfb2622046ddcf45df00851f8c.png)

到这里，就算是整个 Web 项目创建成功了。剩下的，就是根据实际需要，不填调整项目的内容了。

版权声明: 本文为 InfoQ 作者【Andy】的原创文章。

原文链接:【https://xie.infoq.cn/article/e2a24ab42bdef9fa7dd9a8c43】。

本文遵守【CC-BY 4.0】协议，转载请保留原文出处及本版权声明。

## 三.配置开发[JavaWeb项目](https://so.csdn.net/so/search?q=JavaWeb项目&spm=1001.2101.3001.7020)

1.补全JavawWeb项目的文件结构

![img](https://i-blog.csdnimg.cn/blog_migrate/b412e83a22d60d936caf5ec76b813bed.png)

```
     idea社区版的新建文件选项没有xml，jsp等格式，我们可以点击“文件”，之后在输入文件名的时候输入后缀名：
1
```

![img](https://i-blog.csdnimg.cn/blog_migrate/de85d0de9dd7572eb7fdda7369af4960.png)

```
     其中的web.xml内容为：
1
```

<?xml version="1.0" encoding="UTF-8"?>


xss

index.html


作为初学者，不需要完全弄懂，只需要知道这个是web项目的配置文件，里面的前半部分是固定的。而welcome-file是指这个web项目一运行就会显示的页面。知道这些足矣。

```html
     这是我的index.html内容，大家也可以自己修改：
     <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>这是一个标题</title>
</head>
<body>
hello world
</body>
</html>
1234567891011
```

hello world （经典的hello world） 2.配置tomcat 1.在设置中配置tomcat 选择“设置”：

![img](https://i-blog.csdnimg.cn/blog_migrate/1b1738137ecda64eb08f509c3a4d6f59.png)

选择“tomcat server”：

![img](https://i-blog.csdnimg.cn/blog_migrate/111481525b8909ade7469b5a122f5a37.png)

点击加号，添加本地下载好的tomcat：

![img](https://i-blog.csdnimg.cn/blog_migrate/85329a5d2d1c65ca6be54d639e808632.png)

添加之后，会自动填充：

![img](https://i-blog.csdnimg.cn/blog_migrate/0f043cd78fc279313a87a0c2c57ab9a9.png)

点击“应用”，之后点击确定，结束。

2.在运行中配置tomcat
点击顶部菜单栏的“运行”，选择“编辑配置”：

![img](https://i-blog.csdnimg.cn/blog_migrate/1c6637411f5f42475ff235d24c4e9e17.png)

点击加号：

![img](https://i-blog.csdnimg.cn/blog_migrate/daf7be6d79229ded5505b5d2d8e472d5.png)

选择“Smart Tomcat”：

![img](https://i-blog.csdnimg.cn/blog_migrate/61270c520f2cfb5686b857d3b93dec95.png)

什么都不用修改，直接应用后确定，结束。

![img](https://i-blog.csdnimg.cn/blog_migrate/6c1a5145b6dcbadda553633193da850f.png)

3.在项目中添加tomcat
点击“文件”，选择项目结构：

![img](https://i-blog.csdnimg.cn/blog_migrate/eacec4198e8360cba4dc8fbc54e54897.png)

选择“库”，点击加号，选择java：

![img](https://i-blog.csdnimg.cn/blog_migrate/1bc342b02eafb2d7240e887d5e3200a7.png)

将本地tomcat的lib文件夹选中，点击确定：

![img](https://i-blog.csdnimg.cn/blog_migrate/89031312456784ee464b113ba282b146.png)

搞定之后的样子：

![img](https://i-blog.csdnimg.cn/blog_migrate/b0677db5bd5757fac8a5268d5a3c254d.png)

在右侧选项选择“模块”，将出现的“lib”勾选，点击应用，确定。

![img](https://i-blog.csdnimg.cn/blog_migrate/0d0ebf59f94c492a1fedc874e78b0cc0.png)

尝试运行
点击三角形运行符号：

![img](https://i-blog.csdnimg.cn/blog_migrate/a134722f23d1bbdb91434bdc39c72c4f.png)

点击出现的链接：

![img](https://i-blog.csdnimg.cn/blog_migrate/e68c6707a476dd937ca474dd571d49c4.png)

浏览器出现index.html页面，表示我们的JavaWeb项目成功啦！

![img](https://i-blog.csdnimg.cn/blog_migrate/82a25d812497c755bab9c9cdcec4222c.png)

————————————————
版权声明：本文为CSDN博主「赵问潮」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。

![img](https://i-blog.csdnimg.cn/blog_migrate/a134722f23d1bbdb91434bdc39c72c4f.png)

点击出现的链接：

![img](https://i-blog.csdnimg.cn/blog_migrate/e68c6707a476dd937ca474dd571d49c4.png)

浏览器出现index.html页面，表示我们的JavaWeb项目成功啦！

![img](https://i-blog.csdnimg.cn/blog_migrate/82a25d812497c755bab9c9cdcec4222c.png)

