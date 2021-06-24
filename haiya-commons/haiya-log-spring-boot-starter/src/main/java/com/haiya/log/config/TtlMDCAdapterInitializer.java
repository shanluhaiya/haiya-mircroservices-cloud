package com.haiya.log.config;

import org.slf4j.TtlMDCAdapter;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 初始化TtlMDCAdapter实例，并替换MDC中的adapter对象
 * @author qiaoguoqiang
 * MDC(Mapped Diagnostic Context，映射调试上下文), 是日志系统提供的一种方便在多线程条件下记录日志的功能
 * 一个常用的场景就是Web服务器中给每个请求都给一个独特的请求id，在合理配置日志的layout之后，所有的日志都会打印这个请求id，这样一个请求下的所有日志信息都可以很方便的找到。
 *
 * 一个简单的理解可以认为是全局的marker信息，调用的时候不用类似下面的代码就可以实现所有的日志中都有marker标记
 * log.info(MARKER, "marker info");
 * log.info(MARKER, "marker info1");
 *
 * public interface MDCAdapter {
 *     void put(String var1, String var2);
 *     String get(String var1);
 *     void remove(String var1);
 *     void clear();
 *     Map<String, String> getCopyOfContextMap();
 *     void setContextMap(Map<String, String> var1);
 * }
 * MDCAdapter其实就只是一些简单的kv常见操作，也不难推测出他的功能其实也就是相当于一个缓存。
 *
 * 我们这里重写LogbackMDCAdapter，让它能搭配TransmittableThreadLocal实现父子线程之间的数据传递。
 */
public class TtlMDCAdapterInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        /**
         * 加载TtlMDCAdapter实例
         */
        TtlMDCAdapter.getInstance();
    }
}