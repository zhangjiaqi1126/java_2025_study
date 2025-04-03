# 一、IDEA接入DeepSeek

1）首先IDEA下载安装 Continue插件，如下图大概几分钟安装完成

> “Continue” 是一款专为 IntelliJ IDEA 设计的开源 AI 助手插件，利用大语言模型（例如DeepSeek 或其他模型）与代码的自然语言交互，极大地提高了开发效率。类似于 CodeGPT 和 GitHub Copilot，它可以实时生成代码、解决问题、创建单元测试等，帮助开发者更快、更准确地完成编程任务。

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-08-12-21HrrNzfoqlKXbt6G.png)

﻿ 



﻿

2）安装完成后，IDEA右边点击Continue按钮，并且Add Chat model添加模型

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-07-12-29jTvVvXF6MgxsU29p.png)

﻿ 



﻿

3）添加DeepSeek模型，填写对应api的key

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-07-12-28Tqm8hkJZV38WxOpi.png)

﻿ 



﻿

4）测试代码

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-07-12-29sFC712ynJw7OTdy43.png)

﻿ 



﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-07-15-00xh3rxOtyiOY8zPg.png)

﻿﻿



附：DeepSeek APIkey获取

1）打开deepseek官网--API开放平台

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-07-12-30Eyy3030127abqmrhRs.png)

﻿ 



﻿

2）API keys创建API key，复制对应key

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-07-12-32aXucQO32LMvCC32yL.png)

﻿ 



﻿

 

3）注册后会赠送10元，测试体验下

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-07-12-320rAHp0ROTkCsD7P.png)

﻿ 



# 二、私有化部署DeepSeek

## 1）安装Docker

docker官网：https://www.docker.com/﻿

1.根据自己电脑配置下载对应版本，下载后按照即可

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-270LIo6jZr8a8WweX.png)

﻿﻿



1.安装完成

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27bm7i9eMaFRqXKG9.png)

﻿﻿



﻿

## 2）安装ollama

Ollama 是一个开源工具，专注于在本地运行和管理大型语言模型（LLMs，Large Language Models）。它旨在简化 LLMs 的部署和使用，让开发者、研究人员和爱好者能够轻松地在本地环境中运行和实验各种语言模型（Run[Llama 3.3](https://ollama.com/library/llama3.3),[DeepSeek-R1](https://ollama.com/library/deepseek-r1),[Phi-4](https://ollama.com/library/phi4),[Mistral](https://ollama.com/library/mistral),[Gemma 2](https://ollama.com/library/gemma2), and other models, locally.）。

官方网站：https://ollama.com/﻿

1.下载并安装 Ollama 客户端

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27LRFZ7w7JcTYRyCO.png)

﻿﻿



1.根据你个人电脑的实际配置，选择合适的 DeepSeek 尺寸模型进行部署。比如推荐安装 7B/8B 尺寸模型。

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27oqrrUd27kxIq27w7.png)

﻿﻿



访问：[http://127.0.0.1:11434/ ](http://127.0.0.1:11434/)显示：

```
Ollama is running
```

## 3）私有化部署DeepSeek

1.运行命令`ollama run deepseek-r1:7b`安装 DeepSeek R1 模型。

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-277WxX68BRlg8MDBy.png)

﻿﻿



1.安装完成后，会自动运行大模型，输入“deepseek可以做什么？”测试一下：

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27fw27TcAOlrVZ47QA.png)

﻿﻿



# 三、搭建智能助手

## 1）安装 Dify

dify是开源的 LLM 应用开发平台，旨在帮助开发者轻松构建和运营生成式 AI 原生应用。提供从 Agent 构建到 AI workflow 编排、RAG 检索、模型管理等能力，轻松构建和运营生成式 AI 原生应用。比 LangChain 更易用。官方地址：http://difyai.com/﻿

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27jIlJbSCTtD90XFs.png)

﻿﻿



1）访问 Dify GitHub 项目地址，运行以下命令完成拉取代码仓库和安装流程。

```
#克隆 Dify 源代码至本地环境。
git clone https://github.com/langgenius/dify.git
# 进入dify源码docker 目录  
cd dify/docker  
# 复制并重命名配置文件  
cp .env.example .env 
# 启动 docker compose ，根据你系统上的 Docker Compose 版本，选择合适的命令来启动容器。
# 你可以通过 $ docker compose version 命令检查版本，详细说明请参考 Docker 官方文档：
docker compose up -d
```

**注意事项：**

如果git clone执行慢，也可采用download对应的zip包下载

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27fffi2wV27uAVTFd6.png)

﻿﻿



**docker 镜像下载慢，修改****Docker 配置，Apply&restart重启docker**

```
"registry-mirrors": [
    "https://registry.docker-cn.com",
    "https://dockerhub.azk8s.cn",
    "https://reg-mirror.qiniu.com",
    "https://registry-farsight.cn",
    "https://registry.hub.docker.com",
    "https://registry-mirror.github.com"
]
```

`registry-mirrors`是 Docker 镜像仓库的镜像站点，用于加速 Docker 镜像的拉取。以下是每个镜像站点的具体说明：

1.﻿[https://registry.docker-cn.com](https://registry.docker-cn.com/)﻿

◦这是 Docker 官方在中国提供的镜像站点，旨在为中国用户提供更快的 Docker 镜像下载速度。

2.﻿[https://dockerhub.azk8s.cn](https://dockerhub.azk8s.cn/)﻿

◦这是由 Azure 中国提供的 Docker Hub 镜像站点，专门为中国用户优化，加速 Docker 镜像的拉取。

3.﻿[https://reg-mirror.qiniu.com](https://reg-mirror.qiniu.com/)﻿

◦这是七牛云提供的 Docker 镜像加速服务，帮助用户更快地拉取 Docker 镜像。

4.﻿[https://registry-farsight.cn](https://registry-farsight.cn/)﻿

◦这是一个国内的 Docker 镜像加速站点，提供 Docker Hub 的镜像服务。

5.﻿[https://registry.hub.docker.com](https://registry.hub.docker.com/)﻿

◦这是 Docker 官方的镜像仓库（Docker Hub），默认的 Docker 镜像源。如果没有配置镜像加速，Docker 会直接从该地址拉取镜像。

6.﻿[https://registry-mirror.github.com](https://registry-mirror.github.com/)﻿

◦这是一个 GitHub 提供的 Docker 镜像加速服务，专门用于加速 GitHub 容器镜像库（GHCR）的镜像拉取。

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27Ar9272UegRzUAbSa.png)

﻿﻿



 

2）运行命令后，你应该会看到类似以下的输出，显示所有容器的状态和端口映射：

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27wmbnH8dy7WK47NTv.png)

﻿﻿



3）此时回到docker桌面客户端可看到，所有dify所需要的环境都已经运行起来了

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27cHzqViMvlRSFsQd.png)

﻿﻿



Dify 社区版默认使用 80 端口，点击链接`http://127.0.0.1`即可访问你的私有化 Dify 平台。

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27bxG8wOpLrch27s2V.png)

﻿﻿



## 2）将DeepSeek 接入至 Dify

> Dify 将模型分为 4 种类型，用于不同用途： **系统推理模型 (System Inference Models)**：用于聊天、名称生成、建议后续问题等任务。提供者包括 DeepSeek、OpenAI、Azure OpenAI Service、Anthropic、Hugging Face Hub、Replicate、Xinference、OpenLLM、讯飞星火、文心一言、通义、Minimax、智谱 (ChatGLM) Ollama 和 LocalAI。 **嵌入模型 (Embedding Models)**：用于在知识库中嵌入分段文档并处理用户查询。提供者包括 OpenAI、智谱 (ChatGLM) 和 Jina AI(Jina Embeddings 2)。 **重排序模型 (Rerank Models)**：增强大语言模型的搜索能力。提供者：Cohere。 **语音转文本模型 (Speech-to-Text Models)**：在对话应用程序中将语音转换为文本。提供者：OpenAI。

登录Dify后，点击右上角**头像 → 设置 → 模型供应商**，选择 Ollama，轻点“添加模型”。

> 本地部署的 DeepSeek 模型对应 Ollama 客户端。请确保 DeepSeek 模型已成功部署由 Ollama 客户端部署，详细部署说明请参考上文。 模型供应商内的 DeepSeek 对应在线 API 服务。

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27cZ6wwXCKa6dOLWp.png)

﻿﻿



选择 LLM 模型类型

•模型名称，填写具体部署的模型型号。如上文部署的模型型号为 deepseek-r1 7b，因此填写`deepseek-r1:7b`

•基础URL，填写 Ollama 客户端的运行地址，通常为`http://your_server_ip:11434`。如遇链接问题，请查看如下Docker 部署时的连接错误

当使用 Docker 部署 Dify 和 Ollama 时，可能遇到以下错误：

```
An error occurred during credentials validation: 
HTTPConnectionPool(host='127.0.0.1', port=11434): Max retries exceeded with 
url: /api/chat (Caused by NewConnectionError('<urllib3.connection.HTTPConnection 
object at 0xffff59eb5e80>: Failed to establish a new connection: [Errno 111] Connection refused'))
```

**错误原因**：此错误发生是因为 Ollama 服务在 Docker 容器中无法访问。localhost 通常指向容器本身，而不是主机或其他容器。要解决此问题，需要将 Ollama 服务暴露到网络中。

**macOS 环境配置方法：**

如果 Ollama 作为 macOS 应用运行，需要使用 launchctl 设置环境变量：

1.通过调用 `launchctl setenv` 设置环境变量：

```
launchctl setenv OLLAMA_HOST "0.0.0.0"
```

1.重启 Ollama 应用程序。

2.如果以上步骤无效，可以使用以下方法：问题是在 docker 内部，你应该连接到 `host.docker.internal`，才能访问 docker 的主机，所以将 `localhost` 替换为 `host.docker.internal` 服务就可以生效了：

```
http://host.docker.internal:11434
```

•其它选项保持默认值。根据[DeepSeek 模型说明](https://huggingface.co/deepseek-ai/DeepSeek-R1-Distill-Qwen-7B)。

配置成功后

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-279QfyuM47rQWMLFK9.png)

﻿﻿



•﻿

## 3）搭建DeepSeek AI 聊天助手

Dify 提供四种类型的应用：

•**聊天助手：基于大型语言模型构建的对话助手。**

•**文本生成：用于文本生成任务的助手，例如编写故事、文本分类、翻译等。**

•**智能体：能够进行任务分解、推理和工具调用的对话式 AI 智能体。**

•**工作流：基于流程编排定义更灵活的 LLM 工作流。**

1.点击Dify 平台首页左侧的"创建空白应用"，选择"聊天助手"类型应用并进行简单的命名。

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27GdDgK27bjt0Vz2aW.png)

﻿﻿



1.选择 Ollama 框架内的 `deepseek-r1:7b` 模型。

2.在对话框中输入内容，验证 AI 应用是否能够正常运行。

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27Q2qEMOWAY8lOVqa.png)

﻿﻿



﻿

1.点击应用右上方的发布按钮，可嵌入到网站中。

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27flTvouDh227LxMb9.png)

﻿﻿



## 4）搭建DeepSeek AI Chatflow / Workflow（进阶应用）

工作流通过将复杂的任务分解成较小的步骤（节点）降低系统复杂度，减少了对提示词技术和模型推理能力的依赖，提高了 LLM 应用面向复杂任务的性能，提升了系统的可解释性、稳定性和容错性。

Dify 工作流分为两种类型：

•**Chatflow**：面向对话类情景，包括客户服务、语义搜索、以及其他需要在构建响应时进行多步逻辑的对话式应用程序。

•**Workflow**：面向自动化和批处理情景，适合高质量翻译、数据分析、内容生成、电子邮件自动化等应用程序。

1.点击创建空白应用-Chatflow

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27gZGzmQ62tn6avdT.png)

﻿﻿



1.添加 LLM 节点，选择 Ollama 框架内的`deepseek-r1:7b`模型，并在系统提示词内添加`{{#sys.query#}}`变量以连接起始节点。

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27r6vJW2vCtyyQkwy.png)

﻿﻿



1.执行

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27OXPWJzwcWzGczRa.png)

﻿﻿



## 5）创建本地知识库

### 5.1）添加Embedding模型

1、为什么要添加Embedding模型？

添加 Embedding 模型的目的是为了将高维数据（例如文本、图像）转换为低维向量。这些向量可以有效地捕捉原始数据的语义信息，适用于各种应用场景，包括文本分类、相似性搜索、推荐系统等。

我们需要将上传的私有资料通过 Embedding 模型转换为向量数据，并存储在向量数据库中。这样，在回答问题时，我们就可以根据自然语言，准确地获取到原始数据的含义并进行召回。因此，提前将私有数据向量化并入库是非常重要的步骤。

2、下载Embedding 模型

```
ollama pull bge-m3
```

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27qIbGvlZnvL2gLLp.png)

﻿﻿



﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27vkkuyb87bj0OLQX.png)

﻿﻿



3、配置 Embedding 模型

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27zP2cRSB2zERtD8J.png)

﻿﻿



﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27g7cDzdEPXkAV9EG.png)

﻿﻿



### 5.2）创建知识库

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-279RSll2vlHZba478J.png)

﻿﻿



保存并处理

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-276B8bNYHViQuiiC9.png)

﻿﻿



知识库创建完成

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27f6NrT2wXX847XjMT.png)

﻿﻿



### 5.3）添加知识库为对话上下文

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27vqUiuM6Oarto6Aw.png)

﻿﻿



﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27axf2GhAtV6Z67cT.png)

﻿﻿



### 5.4）测试知识库

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27F8Hp0RZEIXSozkE.png)

﻿﻿



﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-277Ub27KCpe27KhA6Ct.png)

﻿﻿



﻿

如想编辑可复制mermaid，然后打开draw.io

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27eJlV8EwagYzUruk.png)

﻿﻿



﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-279dXGSBMtICBN27fp.png)

﻿﻿



﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-06-09-27nASTyHwiN8bZ9Le.png)

﻿﻿



# 四、人机共生时代的能力培养体系

> 引用自《清华大学-DeepSeek从入门到精通(20250204).pdf》

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-10-09-09TxxT8WNC0PT1LbT.png)

﻿﻿



﻿

﻿

![img](https://s3.cn-north-1.jdcloud-oss.com/shendengbucket1/2025-02-10-09-09bqo6bVyGdBVNxQz.png)

﻿﻿



更多的需要思考如何应用提升工作效率

参考资料

﻿https://github.com/langgenius/dify-docs/blob/main/zh_CN/learn-more/use-cases/private-ai-ollama-deepseek-dify.md