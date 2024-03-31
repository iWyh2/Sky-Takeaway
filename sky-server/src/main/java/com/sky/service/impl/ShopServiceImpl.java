package com.sky.service.impl;

import com.sky.constant.MessageConstant;
import com.sky.exception.RedisException;
import com.sky.service.ShopService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShopServiceImpl implements ShopService {
    public static final String KEY = "SHOP_STATUS";
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void setStatus(Integer status) {
        // 将值存入redis
        stringRedisTemplate.opsForValue().set(KEY, String.valueOf(status));
    }

    @Override
    public Integer getStatus() {
        // 从redis取值
        String status = stringRedisTemplate.opsForValue().get(KEY);
        if (status != null) {
            return Integer.parseInt(status);
        } else {
            throw new RedisException(MessageConstant.REDIS_NOT_FOUND);
        }
    }
}
