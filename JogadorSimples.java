import java.util.Random;

public class JogadorSimples extends TipodePersonagem implements AcoesExploracao {

    public JogadorSimples() {
        super(2, 6); 
    }

    @Override
    public void atacar(TipodePersonagem alvo) {
        alvo.setDef(alvo.getDef() - this.getAtk());
    }

    @Override
    public void movimentar(Setor destino) {
        this.setPosX(destino.getX());
        this.setPosY(destino.getY());
    }

    @Override
    public void procurar() {
        Random aleatorio = new Random(); 
        int num = aleatorio.nextInt(6) + 1; 
        
        if (num == 4) {
            this.setDef(this.getDef() + 1); 
        } else if (num == 5) {
            this.setDef(this.getDef() + 2);
        }
    }
}