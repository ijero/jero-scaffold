[![Release](https://img.shields.io/badge/JeroScaffold-0.0.7-blue)](https://gitee.com/ijero/jero-scaffold/releases/0.0.7)

# JeroScaffold

#### 介绍
JeroScaffold是一套基于kotlin+viewBinding+viewModel的Android快速开发模板

#### 软件架构

> 注意：从0.0.7版本起，scaffold-ext 已合并至 scaffold-core

- scaffold-core：快速开发的基础脚手架，由ScaffoldActivity、ScaffoldFragment、ScaffoldViewModel以及一些常用的扩展库组成
- scaffold-ui：一些ui相关的的扩展库

#### 安装教程

- 1. 项目根目录的build.gradle中添加maven仓库源
```groovy
allprojects {
    repositories {
        // ...
        mavenCentral()
        // scaffold-ui模块需要添加jitpack.io
        maven { url 'https://jitpack.io' }
        maven {
            url 'https://repo1.maven.org/maven2/'
        }
    }
}
```
- 2. 在主module的build.gradle中添加需要用到的依赖模块（按需添加）
```groovy
dependencies {
    // 基础脚手架
    implementation "com.gitee.ijero:scaffold-core:0.0.7" 
    // ui相关的的扩展库
    implementation "com.gitee.ijero:scaffold-ui:0.0.7" 
}
```
- 3. 在主module的build.gradle中添加ViewBinding支持
```groovy

android {
	// ...
    buildFeatures {
        viewBinding true
    }
	// ...
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

#### 特别鸣谢

- [ViewBindingKTX](https://github.com/DylanCaiCoding/ViewBindingKTX)
- [XPopup](https://github.com/li-xiaojun/XPopup)
- [BRVAH](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)