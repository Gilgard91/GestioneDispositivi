package be.epicode.GestioneDispositivi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "dispositivi")
public class Dispositivo {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "tipologia_dispositivo")
    @Enumerated(EnumType.STRING)
    private TipologiaDispositivo tipologiaDispositivo;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    public Dispositivo(TipologiaDispositivo tipologiaDispositivo, Dipendente dipendente) {
        this.tipologiaDispositivo = tipologiaDispositivo;
        this.dipendente = dipendente;
    }
}
