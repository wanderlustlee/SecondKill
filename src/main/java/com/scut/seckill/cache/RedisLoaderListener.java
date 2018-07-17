package com.scut.seckill.cache;

import com.scut.seckill.entity.Product;
import com.scut.seckill.mapper.SecKillMapper;
import com.scut.seckill.concurrent.AtomicStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import java.util.List;


@Component
public class RedisLoaderListener {

    @Autowired
    private RedisCacheHandle redisCacheHandle;

    @Autowired
    private SecKillMapper secKillMapper;

    @Autowired
    private AtomicStock atomicStock;

    @PostConstruct
    public void initRedis(){
        Jedis jedis = redisCacheHandle.getJedis();
        //清空Redis缓存
        jedis.flushDB();
        List<Product> productList = secKillMapper.getAllProduct();
        for (Product product:productList) {
            jedis.set(product.getProductName()+"_stock", String.valueOf(product.getStock()));
        }
    }

}
