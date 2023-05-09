# BRXJ-PARENT

## 项目简介

BRXJ-PARENT 是一个基于 Spring Boot 的 Java 开发框架，为 Spring Boot 及 Spring Cloud 项目提供统一的依赖管理及解决方案。

## 如何使用

### 环境要求

- `JDK` 17或以上版本

### Maven依赖

- `brxj-parent` 父模块

作为父模块引入

```xml

<parent>
    <groupId>com.brxj</groupId>
    <artifactId>brxj-parent</artifactId>
    <version>x.x.x</version>
</parent>
```

- `brxj-base` **基础模块**

公共模块引入

```xml

<dependency>
    <groupId>com.brxj</groupId>
    <artifactId>brxj-base</artifactId>
    <optional>true</optional>
</dependency>
```

- `brxj-consumer` **消费者模块**

消费者模块引入

```xml

<dependency>
    <groupId>com.brxj</groupId>
    <artifactId>brxj-consumer</artifactId>
</dependency>
```

- `brxj-provider` **提供者模块**

提供者模块引入

```xml

<dependency>
    <groupId>com.brxj</groupId>
    <artifactId>brxj-provider</artifactId>
</dependency>
```

**<font size=1>注：`brxj-consumer` 及 `brxj-provider` 模块中已引入 `brxj-base`模块，
无需重复引入</font>**