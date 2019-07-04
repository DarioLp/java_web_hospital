package com.guilder.hospital.controllers;

import com.guilder.hospital.exceptions.TurnNotFoundException;
import com.guilder.hospital.models.Turn;
import com.guilder.hospital.repositories.TurnRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TurnController {

    private final TurnRepository turnRepository;

    public TurnController(TurnRepository turnRepository){
        this.turnRepository = turnRepository;
    }


    @GetMapping ("/api/v1/turns")
    List <Turn> all(){
        List<Turn> turns = turnRepository.findAll();
        System.out.println(turns);
        return turns;
    }

    @GetMapping ("/api/v1/turns_available")
    List <Turn> availableTurns(){
        return turnRepository.findAll();
    }

    @PostMapping("/api/v1/turns")
    Turn newTurn(@RequestBody Turn newTurn) {
        return turnRepository.save(newTurn);
    }


    @GetMapping("/api/v1/turns/{id}")
    Turn one(@PathVariable Long id) {

        return turnRepository.findById(id)
                .orElseThrow(() -> new TurnNotFoundException(id));
    }

    @PutMapping("/api/v1/turns/{id}")
    Turn replaceTurn(@RequestBody Turn newTurn, @PathVariable Long id) {

        return turnRepository.findById(id)
                .map(turn -> {
                    turn.setAttended(newTurn.isAttended());
                    turn.setDate(newTurn.getDate());
                    turn.setDoctor(newTurn.getDoctor());
                    turn.setUser(newTurn.getUser());
                    return turnRepository.save(turn);
                })
                .orElseGet(() -> {
                    newTurn.setId(id);
                    return turnRepository.save(newTurn);
                });
    }

    @DeleteMapping("/api/v1/turns/{id}")
    void deleteTurn(@PathVariable Long id) {
        turnRepository.deleteById(id);
    }

}
