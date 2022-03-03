package com.example.MSBootcoin.Controller;

import com.example.MSBootcoin.Domain.Bootcoin;
import com.example.MSBootcoin.Repository.BootcoinRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BootcoinController {
    private BootcoinRepository bootcoinRepository;

    public BootcoinController(BootcoinRepository bootcoinRepository) {
        this.bootcoinRepository = bootcoinRepository;
    }

    @GetMapping("/Bootcoin")
    public Map<String, Bootcoin> findAll() {
        return bootcoinRepository.findAll();
    }

    @GetMapping("/Bootcoin/{id}")
    public Bootcoin findById(@PathVariable String id) {
        return bootcoinRepository.findById(id);
    }

    @PostMapping("/Bootcoin")
    public void createClients(@RequestBody Bootcoin bootcoin) {
        bootcoinRepository.save(bootcoin);
    }
    @DeleteMapping("/Bootcoin/{id}")
    public void deleteClients(@PathVariable String id) {
        bootcoinRepository.delete(id);
    }
}
