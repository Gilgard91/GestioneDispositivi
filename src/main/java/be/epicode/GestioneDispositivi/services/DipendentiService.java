package be.epicode.GestioneDispositivi.services;

import be.epicode.GestioneDispositivi.entities.Dipendente;
import be.epicode.GestioneDispositivi.exceptions.NotFoundException;
import be.epicode.GestioneDispositivi.payloads.NewDipendentePayload;
import be.epicode.GestioneDispositivi.repositories.DipendentiDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DipendentiService {

    @Autowired
    DipendentiDAO dipendentiDAO;

    public Dipendente save(NewDipendentePayload body){
        Dipendente newDipendente = new Dipendente();
        newDipendente.setUsername(body.getUsername());
        newDipendente.setNome(body.getNome());
        newDipendente.setCognome(body.getCognome());
        newDipendente.setEmail(body.getEmail());
        newDipendente.setAvatarUrl(body.getAvatarUrl());
        return dipendentiDAO.save(newDipendente);
    }

    public Page<Dipendente> getDipendenti(int pageNumber, int size, String orderBy){
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));
        return dipendentiDAO.findAll(pageable);
    }

    public Dipendente findById(int id){
        return dipendentiDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(int id){
        Dipendente found = this.findById(id);
        dipendentiDAO.delete(found);
    }

    public Dipendente findByIdAndUpdate(int id, NewDipendentePayload body){
        Dipendente found = this.findById(id);
        found.setUsername(body.getUsername());
        found.setEmail(body.getEmail());
        found.setAvatarUrl(body.getAvatarUrl());
        return dipendentiDAO.save(found);

    }
}
