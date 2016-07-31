GreenDAO 框架
========================
> 之前上传项目总是失败，是因为把本地项目与远程项目关联时出错了，正确的关联命令是：git remote add origin https://git.coding.net/bruceyu1994/GreenDAOFramework.git, 这与在github上的可能有点不同，之前一直用github上的方式关联。

### Question
* Android Studio Error—Gradle: 错误: 编码GBK的不可映射字符
  解决方案：在build.gradle中添加如下代码:
  
  ```android
  tasks.withType(Compile) {  
    options.encoding = "UTF-8"
  }
  ```