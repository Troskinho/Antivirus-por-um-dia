//classe abstrata para representar os tipos de personagens do jogo
//responsavel por guardar atk, def e posivao (x = linha e y = coluna)

//atk eh fixo, o jogador sup nao melhora atk, aoneas recupera def
//def nao pode ser negativa

//atacar eh o metodo central, atacar = dano, que reduz a def do alvo
//p1 = mover, atacar e procurar
//p2 = 
public abstract class TipodePersonagem {
    
    private String nome;
    private final int atk;
    private int def;
    private int posX;       //linha
    private int posY;       //coluna

    protected TipodePersonagem(String nome, int atk, int def) {
        this.nome = nome;
        this.atk = atk;
        this.def = def;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        //nome nao pode ser vazio
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public int getAtk() { 
        return atk;             //n tem o setAtk pq atk eh fixo
    }

    public int getDef() { 
        return def; 
    }
    public void setDef(int def) { 
        this.def = Math.max(0, def); //def nao pode ser negativa}
    }

    public int getPosX() { 
        return posX; 
    }
    
    public int getPosY() { 
        return posY; 
    }

    public void setPosicao(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    //vivo se ainda possuir algum valor de defesa
    //se a defesa for menor ou igual a zero, personagem esta morto
    public boolean estaVivo() {
        return def > 0;
    }

    //metodo para receber dano
    //a def eh subtraida pelo valor do dano recebido
    public void receberDano(int dano) {
        setDef(def - dano);
    }

    //metodo que aumenta a defesa do personagem
    //itens ou a habilidade de recuperar defesa podem chamar esse metodo
    public void ganharDefesa(int valor) {
        def += valor;
    }

    //ataque padrao: reduz a def do alvo pelo atk do atacante
    //return eh responsavel por mostrar o dano causado (o se nao acertou o ataque)
    public int atacar(TipodePersonagem alvo) {
        if (alvo == null || !alvo.estaVivo()) {
            return 0; // ataque não é possível
        }
        int danoCausado = this.atk;
        alvo.receberDano(danoCausado);
        return danoCausado;
    }

    //acoes que o personagem pode realizar no seu turno
    public abstract Acao[] acoesDisponiveis();

    //formato de status de acordo com o enunciado
    public String resumo(){
        return atk + " " + def + " " + posX + " " + posY;
    }

}