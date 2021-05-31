# MovieMangement（电影后台管理）

**项目使用框架：Spring+SpringMVC+Mybatis**

**构建工具：Maven 3.6.3**

**IDE工具：idea**

## 项目功能

+ 用户部分：管理员登陆、修改密码
+ 电影部分：浏览电影细信息、添加电影信息、通过类型或电影名组合查询电影信息、更新电影基础信息、删除该条电影信息
+ 新闻部分：添加新闻信息、组合查询电影信息、修改电影信息、删除电影信息
+ 类型部分：添加电影或新闻类型、更新类型、删除类型

### 容错机制：

该系统具有较强的容错机制

+ 添加拦截器和过滤器防止用户未登录和输入url进入系统
+ 更新或删除类别时电影查询和新闻查询的类别下拉框同步修改后的类型
+ 添加类型时已存在的类型不能添加
+ 修改密码时，旧密码不正确或者两次密码不一样时进行相应的提示，不能修改密码

## 项目展示

登录界面

![image-20210531234826142](https://cdn.jsdelivr.net/gh/banxia-zyh/img/img/20210531234841.png)

首页控制台界面

![image-20210531235554465](https://cdn.jsdelivr.net/gh/banxia-zyh/img/img/20210531235554.png)

电影信息管理界面

![image-20210531235620233](https://cdn.jsdelivr.net/gh/banxia-zyh/img/img/20210531235620.png)

电影类别管理界面

![image-20210531235730729](https://cdn.jsdelivr.net/gh/banxia-zyh/img/img/20210531235731.png)

上传电影界面

![image-20210531235754994](https://cdn.jsdelivr.net/gh/banxia-zyh/img/img/20210531235755.png)

新闻管理界面

![image-20210531235832534](https://cdn.jsdelivr.net/gh/banxia-zyh/img/img/20210531235832.png)

新闻类别管理界面

![image-20210531235856362](https://cdn.jsdelivr.net/gh/banxia-zyh/img/img/20210531235856.png)

用户管理界面

![image-20210531235921828](https://cdn.jsdelivr.net/gh/banxia-zyh/img/img/20210531235922.png)
