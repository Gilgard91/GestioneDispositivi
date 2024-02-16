package be.epicode.GestioneDispositivi.controllers;

import be.epicode.GestioneDispositivi.entities.Dispositivo;
import be.epicode.GestioneDispositivi.exceptions.BadRequestException;
import be.epicode.GestioneDispositivi.payloads.NewDispositivoPayload;
import be.epicode.GestioneDispositivi.services.DispositiviService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dispositivi")
public class DispositiviController {

    @Autowired
    DispositiviService dispositiviService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Dispositivo saveDispositivo(@RequestBody @Validated NewDispositivoPayload body, BindingResult validation){
        if(validation.hasErrors()){
            throw new BadRequestException(validation.getAllErrors());
        }
        return this.dispositiviService.save(body);
    }

    @GetMapping("")
    public Page<Dispositivo> getAllDispositivi(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "5") int size,
                                               @RequestParam(defaultValue = "id") String orderBy) {
        return this.dispositiviService.getDispositivi(page, size, orderBy);
    }

    @GetMapping("/{dispositivoId}")
    public Dispositivo findById(@PathVariable int dispositivoId) {
        return dispositiviService.findById(dispositivoId);
    }

    @PutMapping("/{dispositivoId}")
    public Dispositivo findAndUpdate(@PathVariable int dispositivoId){
        return dispositiviService.findByIdAndUpdate(dispositivoId);
    }

    @DeleteMapping("/{dispositivoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable int dispositivoId){
        dispositiviService.findByIdAndDelete(dispositivoId);
    }
}
