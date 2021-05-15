# JeroScaffold

#### 介绍
JeroScaffold是一套基于kotlin+viewBinding+viewModel的Android快速开发模板

#### 软件架构

- scaffold-core：快速开发的基础脚手架，由ScaffoldActivity、ScaffoldFragment、ScaffoldViewModel组成
- scaffold-ext：一些常用的扩展库
- scaffold-ui：一些ui相关的的扩展库

#### 安装教程

- 1. 项目根目录的build.gradle中添加maven仓库源
```groovy
allprojects {
    repositories {
        // ...
        mavenCentral()
        maven {
            url 'https://repo1.maven.org/maven2/'
        }
    }
}
```
- 2. 在主module的build.gradle中添加需要用到的依赖，
```groovy
dependencies {
    implementation "com.gitee.ijero:scaffold-core:0.0.2-alpha" // 基础脚手架
    implementation "com.gitee.ijero:scaffold-ext:0.0.2-alpha" // 常用的扩展库
    implementation "com.gitee.ijero:scaffold-ui:0.0.2-alpha" // ui相关的的扩展库
}
```

#### 使用说明

还没时间完善demo，请先看app中的例子
更多使用方法请等待补充。。。

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request
