public class Principal {
    
    public static void main(String[] args) {
        System.out.println("\u001B[32m" + "Iniciando Antivírus por um dia..." + "\u001B[0m"); 

       Turnos jogo = new Turnos();
        jogo.iniciarJogo();
        while (!jogo.verificarFimdeJogo()) {
            
            System.out.println("\n--- Turno dos Jogadores ---");
            jogo.carregarTurnosdosPlayers(); 
            if (jogo.verificarFimdeJogo()) {
                break;
            }

            System.out.println("\n--- Turno dos Inimigos ---");
            jogo.carregarTurnosdosInimigos(); 
        }

        System.out.println("\nFim de jogo!");
    }
}