package Model;

public class Ocupar {

    private int idOcupar;
    private int idVeiculo;
    private int idVaga;
    private String dataIni;
    private String dataFim;
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

    public String getDataIni() {
        return dataIni;
    }

    public void setDataIni(String dataIni) {
        this.dataIni = dataIni;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }
}
