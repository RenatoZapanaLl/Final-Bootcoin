package com.example.MSBootcoin.Repository;

import com.example.MSBootcoin.Controller.BootcoinController;
import com.example.MSBootcoin.Domain.Bootcoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.UUID;

@Repository
public class BootcoinRepository implements RedisRepository {
    private  static final String KEY = "Bootcoin";

    @Autowired
    private RedisTemplate<String,Bootcoin> redisTemplate;
    private HashOperations hashOperations;

    public BootcoinRepository(RedisTemplate<String, Bootcoin> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private  void  init(){
        hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public Map<String, Bootcoin> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public Bootcoin findById(String id) {
        return (Bootcoin) hashOperations.get(KEY,id);
    }

    @Override
    public void save(Bootcoin bootcoin) {
        hashOperations.put(KEY, UUID.randomUUID().toString(),bootcoin);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY,id);
    }
}
