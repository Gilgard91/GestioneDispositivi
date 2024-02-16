package be.epicode.GestioneDispositivi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "dipendenti")
public class Dipendente {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String avatarUrl;

    public Dipendente(String username, String nome, String cognome, String email, String avatarUrl) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.avatarUrl = avatarUrl;
    }
}
