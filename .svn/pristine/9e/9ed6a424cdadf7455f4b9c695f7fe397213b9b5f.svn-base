package com.jieandata.web.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

	@Bean
	public JedisPoolConfig jedisConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		return jedisPoolConfig;
	}

	@Bean
	public JedisConnectionFactory connectionFactory(
			@Value("${spring.redis.host}")String host,
			@Value("${spring.redis.port}")int port,
			@Value("${spring.redis.password}")String password,
			JedisPoolConfig jedisPoolConfig) {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName(host);
		jedisConnectionFactory.setPort(port);
		jedisConnectionFactory.setPassword(password);
		jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
		jedisConnectionFactory.setDatabase(1);
		return jedisConnectionFactory;
	}

	@Autowired
	private Environment env;

	/*@Bean(destroyMethod = "shutdown")
	public RedissonClient redissonClient() throws IOException {
		String[] profiles = env.getActiveProfiles();
		String profile = "";
		if(profiles.length > 0) {
			profile = "-" + profiles[0];
		}
		return Redisson.create(
				Config.fromYAML(new ClassPathResource("redisson" + profile + ".yml").getInputStream())
		);
	}*/
}
