package be.epicode.GestioneDispositivi.controllers;

import be.epicode.GestioneDispositivi.entities.Dipendente;
import be.epicode.GestioneDispositivi.exceptions.BadRequestException;
import be.epicode.GestioneDispositivi.payloads.NewDipendentePayload;
import be.epicode.GestioneDispositivi.services.DipendentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {

    @Autowired
    DipendentiService dipendentiService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente saveDipendente(@RequestBody @Validated NewDipendentePayload body, BindingResult validation){
        if(validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        }
        return this.dipendentiService.save(body);
    }

    @GetMapping("")
    public Page<Dipendente> getAllDipendenti(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "5") int size,
                                             @RequestParam(defaultValue = "nome") String orderBy) {
        return this.dipendentiService.getDipendenti(page, size, orderBy);
    }

    @GetMapping("/{dipendenteId}")
    public Dipendente findById(@PathVariable int dipendenteId){
        return dipendentiService.findById(dipendenteId);
    }

    @PutMapping("/{dipendenteId}")
    public Dipendente findAndUpdate(@PathVariable int dipendenteId, @RequestBody NewDipendentePayload body){
        return dipendentiService.findByIdAndUpdate(dipendenteId, body);
    }

    @DeleteMapping("/{dipendenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable int dipendenteId){
        dipendentiService.findByIdAndDelete(dipendenteId);
    }

    @PostMapping("/upload")
    public String uploadAvatar(@RequestParam("avatar") MultipartFile img) throws IOException {
        return this.dipendentiService.uploadImg(img);
    }
}
