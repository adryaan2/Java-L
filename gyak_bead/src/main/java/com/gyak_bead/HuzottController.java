package com.gyak_bead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HuzottController {
    @Autowired
    private final  Huzottrepo repo;

    public HuzottController(Huzottrepo repo) {
        this.repo = repo;
    }
    @GetMapping("/huzott")
    Iterable<Huzott> olvasMind() //végig lehet rajta menni
    {
        return repo.findAll();
    }
    @GetMapping("/huzott/{id}")
    Huzott olvasEgy(@PathVariable int id) {
        return repo.findById(id)
                .orElseThrow(() -> new HuzottNotFoundException(id));
    }
    @PostMapping("/huzott")
    Huzott huzottFeltolt(@RequestBody Huzott ujHuzott)
    {
        return repo.save(ujHuzott);
    }
    @PutMapping("/huzott/{id}")
    Huzott huzottModosit(@RequestBody Huzott ujHuzott, @PathVariable int id) {
        return repo.findById(id)
                .map(a -> {
                    a.setId( ujHuzott.getId());
                    a.setHuzasid(ujHuzott.getHuzasid());
                    a.setSzam(ujHuzott.getSzam());
                    return repo.save(a);
                })
                .orElseGet(() -> {
                    ujHuzott.setId( id);
                    return repo.save(ujHuzott);
                });
    }
    @DeleteMapping("/huzott/{id}")
    public ResponseEntity<Void> torolHuzott(@PathVariable int id)

    {
        //repo.deleteHuzottById(id);
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
