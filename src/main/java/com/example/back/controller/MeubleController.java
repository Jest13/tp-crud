package com.example.back.controller;


import com.example.back.exception.ResourceNotFoundException;
import com.example.back.model.Meuble;
import com.example.back.repository.MeubleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class MeubleController {

    @Autowired
    private MeubleRepository meubleRepository;

    @CrossOrigin( origins = "*")
    @GetMapping("/meubles")
    public List<Meuble> getAllMeuble(){
        return meubleRepository.findAll();
    }
    @CrossOrigin( origins = "*")
    @PostMapping("/meubles")
    public Meuble createMeuble(@RequestBody Meuble meuble) {
        return meubleRepository.save(meuble);

    }

    @GetMapping("/meubles/{id}")
    public  ResponseEntity<Meuble>  getMeubleId(@PathVariable Long id){
        Meuble meuble = meubleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Le meuble: " + id + " n'existe pas"));
        return ResponseEntity.ok(meuble);
    }

    @PutMapping("/meubles/{id}")
    public ResponseEntity<Meuble> updateMeuble(@PathVariable Long id, @RequestBody Meuble meubleDetails){
        Meuble meuble = meubleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Le meuble: " + id + " n'existe pas"));
        meuble.setMeuble_name(meubleDetails.getMeuble_name());
        meuble.setMeuble_prix(meubleDetails.getMeuble_prix());
        meuble.setMeuble_info(meubleDetails.getMeuble_info());
        meuble.setMeuble_short_info(meubleDetails.getMeuble_short_info());
        meuble.setMeuble_type(meubleDetails.getMeuble_type());
        meuble.setMeuble_stock(meubleDetails.getMeuble_stock());

        Meuble updateMeuble = meubleRepository.save(meuble);

    }
}
