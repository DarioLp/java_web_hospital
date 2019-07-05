package com.guilder.hospital.controllers;

import com.guilder.hospital.exceptions.DiagnosticNotFoundException;
import com.guilder.hospital.exceptions.UserNotFoundException;
import com.guilder.hospital.models.Diagnostic;
import com.guilder.hospital.repositories.DiagnosticRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DiagnosticController {

    private final DiagnosticRepository repository;

    public DiagnosticController(DiagnosticRepository diagnosticRepository){
        this.repository = diagnosticRepository;
    }

    @GetMapping("/api/v1/diagnostic")
    List<Diagnostic> findAllByUser(@RequestParam(required = true)Long idUser) {
        return repository.findDiagnosticsByUser(idUser);
    }

    @PostMapping("/api/v1/diagnostic")
    Diagnostic newDiagnostic(@RequestBody Diagnostic diagnostic) {
        return repository.save(diagnostic);
    }


    @GetMapping("/api/v1/diagnostic/{id}")
    Diagnostic one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new DiagnosticNotFoundException(id));
    }

    @PutMapping("/api/v1/diagnostic/{id}")
    Diagnostic replaceDiagnostic(@RequestBody Diagnostic newDiagnostic, @PathVariable Long id) {

        return repository.findById(id)
                .map(diagnostic -> {
                    if (newDiagnostic.getDescription() != null)diagnostic.setDescription(newDiagnostic.getDescription());
                    if (newDiagnostic.getTurn() != null) diagnostic.setTurn(newDiagnostic.getTurn());
                    return repository.save(diagnostic);
                })
                .orElseGet(() -> {
                    newDiagnostic.setId(id);
                    return repository.save(newDiagnostic);
                });
    }

    @DeleteMapping("/api/v1/diagnostic/{id}")
    void deleteDiagnostic(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
