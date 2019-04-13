package Model;

import java.util.Date;

public class Ocupar {

    private int idOcupar;
    private int idVeiculo;
    private int idVaga;
    private Date dataIni;
    private Date dataFim;
    private float precoTotal;

    public int getIdOcupar() {
        return idOcupar;
    }

    public void setIdOcupar(int idOcupar) {
        this.idOcupar = idOcupar;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    public Date getDataIni() {
        return dataIni;
    }

    public void setDataIni(Date dataIni) {
    	
        this.dataIni = dataIni;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }
}
