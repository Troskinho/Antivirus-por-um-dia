import java.util.Random;

public class Tabuleiro {
    private Setor[][] map; //[cite: 18]
    private int fonteInfecX; //[cite: 18]
    private int fonteInfecY; //[cite: 18]

    public Tabuleiro() {
        // O cenário é formado por um tabuleiro 5x5[cite: 11]
        map = new Setor[5][5];
    }

    public void iniciarTabuleiro() {
        Random aleatorio = new Random(); //[cite: 16]
        
        // A fonte de infecção deve ser aleatoriamente posicionada, exceto no centro[cite: 11]
        do {
            fonteInfecX = aleatorio.nextInt(5);
            fonteInfecY = aleatorio.nextInt(5);
        } while (fonteInfecX == 2 && fonteInfecY == 2); // 2,2 é o centro em uma matriz 0-4

        // Aqui você instanciaria os setores normais, ocultos ou privados nas posições da matriz
    }

    public void exibirTabuleiro() {
        // Lógica para imprimir o estado atual do tabuleiro no terminal
    }
}