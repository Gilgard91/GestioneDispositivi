package be.epicode.GestioneDispositivi.payloads;

import be.epicode.GestioneDispositivi.entities.TipologiaDispositivo;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class NewDispositivoPayload {
    @NotNull(message = "L'id è obbligatorio!")
    private int dipendenteId;
    private TipologiaDispositivo tipologiaDispositivo;

    public NewDispositivoPayload(int dipendenteId, TipologiaDispositivo tipologiaDispositivo) {
        this.dipendenteId = dipendenteId;
        this.tipologiaDispositivo = TipologiaDispositivo.DISPONIBILE;
    }
}
