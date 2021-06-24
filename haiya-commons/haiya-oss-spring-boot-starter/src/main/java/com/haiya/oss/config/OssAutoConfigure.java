package com.haiya.oss.config;

import com.haiya.oss.properties.FileServerProperties;
import com.haiya.oss.template.FdfsTemplate;
import com.haiya.oss.template.S3Template;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

/**
 * @author qiaoguoqiang
 */
@EnableConfigurationProperties(FileServerProperties.class)
@Import({FdfsTemplate.class, S3Template.class})
public class OssAutoConfigure {

}
