//Atividade 1 - Gustavo Alexandre e Pedro Trentin
public class Roda{
    private boolean calibragemPneu;

    public Roda(int p){//variavel aleatoria para por se esta calibrado ou nao o pneu
        if (p%2 == 0)
            calibragemPneu = true;
        else
            calibragemPneu = false;
    }

    public void setCalibragem(boolean x){//setter de calibragem
        this.calibragemPneu = x;
    }

    public boolean getCalibragem() {//getter de calibragem
        return calibragemPneu;
    }

}
