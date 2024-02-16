package be.epicode.GestioneDispositivi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

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

    @OneToMany(mappedBy = "dipendente", cascade = CascadeType.ALL)
    Set<Dispositivo> dispositivi;

    public Dipendente(String username, String nome, String cognome, String email, String avatarUrl) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.avatarUrl = avatarUrl;
    }
}
