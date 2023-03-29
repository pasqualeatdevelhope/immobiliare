package org.example.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class PromotionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataRichiesta = new Date();

    private Date dataApprovazzione;

    private Utente approvatore;

    @OneToOne
    private Utente utente;

    public PromotionRequest(Long id, Date dataRichiesta, Date dataApprovazzione, Utente approvatore, Utente utente) {
        this.id = id;
        this.dataRichiesta = dataRichiesta;
        this.dataApprovazzione = dataApprovazzione;
        this.approvatore = approvatore;
        this.utente = utente;
    }

    public PromotionRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(Date dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public Date getDataApprovazzione() {
        return dataApprovazzione;
    }

    public void setDataApprovazzione(Date dataApprovazzione) {
        this.dataApprovazzione = dataApprovazzione;
    }

    public Utente getApprovatore() {
        return approvatore;
    }

    public void setApprovatore(Utente approvatore) {
        this.approvatore = approvatore;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
