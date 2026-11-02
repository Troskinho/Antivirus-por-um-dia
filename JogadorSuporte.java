import java.util.Random;

public class JogadorSuporte extends TipodePersonagem implements AcoesExploracao {

    public JogadorSuporte() {
        super(1, 7);
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

    // Habilidade especial exclusiva do jogador de suporte[cite: 11, 18]
    public void recDefesa(TipodePersonagem alvo) {
        // Adiciona 2 à defesa do alvo escolhido (ele mesmo ou P1)[cite: 11, 13]
        alvo.setDef(alvo.getDef() + 2);
    }
}