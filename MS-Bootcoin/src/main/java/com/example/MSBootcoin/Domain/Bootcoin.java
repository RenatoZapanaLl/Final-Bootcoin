package com.example.MSBootcoin.Domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("Bootcoin")
public class Bootcoin implements Serializable {
    @Id
    private  String id;
    private  Double ValorCompra;
    private  Double ValorVenta;
    private  String moneda;
}
