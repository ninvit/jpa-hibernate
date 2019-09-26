package model;

import javax.persistence.Entity;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class DiaTrabalhado extends AbstractEntity {
    private LocalDate data;
    private Instant entrar;
    private Instant comer;
    private Instant voltar;
    private Instant sair;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiaTrabalhado that = (DiaTrabalhado) o;
        return Objects.equals(data, that.data) &&
                Objects.equals(entrar, that.entrar) &&
                Objects.equals(comer, that.comer) &&
                Objects.equals(voltar, that.voltar) &&
                Objects.equals(sair, that.sair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), data, entrar, comer, voltar, sair);
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Instant getEntrar() {
        return entrar;
    }

    public void setEntrar(Instant entrar) {
        this.entrar = entrar;
    }

    public Instant getComer() {
        return comer;
    }

    public void setComer(Instant comer) {
        this.comer = comer;
    }

    public Instant getVoltar() {
        return voltar;
    }

    public void setVoltar(Instant voltar) {
        this.voltar = voltar;
    }

    public Instant getSair() {
        return sair;
    }

    public void setSair(Instant sair) {
        this.sair = sair;
    }
}