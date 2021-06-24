海涯日志
-------

## 1. 简介
默认日志类型logger, 存储文本格式: {时间}|{应用名}|{类名}|{方法名}|{用户id}|{用户名}|{租户id}|{操作信息}。

## 2. 配置介绍

### 2.1 是否开启日志链路追踪
haiya.trace配置设置是否开启日志链路追踪，配置值为布尔类型。
开启链路追踪会在请求头加入一个x-traceId-header, 用于标识某个请求的追踪ID。这样可以根据这个ID来追踪特定请求的请求日志。

如果haiya.trace = false, 就不会开启链路追踪。
```java
public class WebTraceFilter extends OncePerRequestFilter {
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !traceProperties.getEnable();
    }
    // ...
}
```

我们默认提供了web日志链路最终，同时我们也提供了DubboTraceFilter, 如有需要同样可以使用，我们已经通过xml配置进去了(使用Dubbo自己的过滤器加载机制)。
最后我们还提供了Feign调用的链路追踪过滤。

### 2.2 日志类型
通过属性haiya.audit-log.log-type配置审计日志类型, 有效值logger, db,默认为logger。db类型会保存在sys_logger表中，初始化的时候如果该表不存在，会创建该表。

如果使用db记录审计日志，还需要配置数据源，通过haiya.audit-log.datasource属性进行配置。如果没有我们自定义的日志数据源，会使用Hikari数据源配置。换句话说，要么使用我们自己的数据源配置，要么必须提供Hikari数据源配置。
我们的db数据源配置完全遵照HikariConfig标准，因为就是继承它的。
```java
public class LogDbProperties extends HikariConfig {
}
```

下面是基本的配置举例:
```properties
haiya.audit-log.datasource.datasource.url=jdbc:mysql://localhost:3306/test
haiya.audit-log.datasource.datasource.username=root
haiya.audit-log.datasource.datasource.password=123456
haiya.audit-log.datasource.datasource.driver-class-name=com.mysql.jdbc.Driver
```
更详细的配置参数参照Hikari参数配置:

### 2.3 日志内容及相关配置
- applicationName: 应用名称，从spring boot配置spring.application.name获取。
- 类名和方法名: 直接从调用的方法获取。
- 用户ID: userId, 从请求头获取，请求头参数x-userid-header。
- 用户名: userName, 从请求头获取，请求头参数x-user-header。
- 租户ID: clientId, 从请求头获取，请求头参数x-tenant-header。

## 3. 其他工具介绍

1. PointUtil: 日志埋点工具类， 可以在网关过滤的时候使用它做日志埋点 PointUtil.debug()。