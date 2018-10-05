import java.util.ArrayList;
import java.util.Random;

public class ControladorJogo implements IControladorJogo {
    
    private ArrayList<Carta> cartasDoJogo = new ArrayList();
    private ArrayList<Personagem> personagens = new ArrayList();
    private ArrayList<Jogador> jogadores = new ArrayList();
    
    /* jogadores da partida*/
    private Jogador jogador1;
    private Jogador jogador2;
    
    /**
     * Permite incluir um novo Personagem na lista de personagens do jogo
     * @param energia Energia do novo Personagem
     * @param habilidade Habilidade do novo Personagem
     * @param velocidade Velocidade do novo Personagem
     * @param resistencia Resistencia do novo Personagem
     * @param tipo TipoPersonagem (Enum) do novo Personagem. Deve ser utilizado TipoPersonagem.TIPO
     * @return Retorna o Personagem incluido na lista
     */
    public Personagem incluiPersonagemNaLista(int energia, int habilidade, int velocidade, int resistencia, TipoPersonagem tipo){
        Personagem personagemNovo = new Personagem(energia, habilidade, velocidade, resistencia, tipo);
        personagens.add(personagemNovo);
        return personagemNovo;
    }
    
    /**
     * Permite incluir uma nova Carta no baralho do jogo
     * @param personagem Personagem da nova carta que sera incluida
     * @return Retorna a Carta que foi incluida no baralho
     */
    public Carta incluiCartaNoBaralho(Personagem personagem){
        Carta cartaNova = new Carta(personagem);
        cartasDoJogo.add(cartaNova);
        return cartaNova;
    }	 	  	  	 	   	      	   	    	    	     	 	

    /**
     * Permite incluir um novo Jogador, que eh colocado na lista de jogadores
     * @param nome Nome do Jogador a ser incluido
     * @return Retorna o Jogador incluido na lista
     */
    public Jogador incluiJogador(String nome){
        Jogador jogador = new Jogador(nome);
        jogadores.add(jogador);
        return jogador;
    }

    /**
     * Inicia o jogo, incluindo os dois jogadores na partida
     * Tambem distribui aleatoriamente 5 cartas do baralho para cada jogador
     *
     * @param jogador1 Jogador 1
     * @param jogador2 Jogador 2
     */
    public void iniciaJogo(Jogador jogador1, Jogador jogador2){
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        
        for(int i = 0; i < 5; i++){
             
            Random gerador = new Random();
            jogador1.incluiCartaNaMao(cartasDoJogo.get(gerador.nextInt(cartasDoJogo.size())));
        }
        
        for(int i = 0; i < 5; i++){
            Random gerador = new Random();
            jogador2.incluiCartaNaMao(cartasDoJogo.get(gerador.nextInt(cartasDoJogo.size())));
        }
        
        
    }	 	  	  	 	   	      	   	    	    	     	 	

    /**
     * Realiza uma jogada, ou seja:
     * 1. Recebe a mesa onde estao as cartas lancadas pelo Jogador 1 e pelo Jogador 2
     * 2. Compara os valores totais das cartas dos jogadores
     * 3. Inclui na mao do Jogador vencedor a carta do perdedor
     * 4. Se o outro jogador perdedor nao tem mais cartas na mao, retorna o Jogador vencedor como vencedor da partida
     * @param mesa Mesa atual, contendo: Jogador 1, Jogador 2, Carta do Jogador 1 e Carta do Jogador 2
     * @return Retorna o Jogador vencedor como vencedor da partida. Se nenhum jogador venceu a partida, retorna NULL
     */
     
     /* perguntar */
    public Jogador jogada(Mesa mesa){

        Carta carta1 = mesa.getCartaJogador1();
        Carta carta2 = mesa.getCartaJogador2();
        Jogador jogador1 = mesa.getJogador1();
        Jogador jogador2 = mesa.getJogador2();
        
        if(carta1.getValorTotalCarta() > carta2.getValorTotalCarta()){
            jogador1.incluiCartaNaMao(carta2);
            jogador2.removeCartaNaMao(carta2);
        } else if(carta2.getValorTotalCarta() > carta1.getValorTotalCarta()){
            jogador2.incluiCartaNaMao(carta1);
            jogador1.removeCartaNaMao(carta1);
        }
        
        if(jogador1.getMao().size() == 0){
            return jogador2;
        } else if(jogador2.getMao().size() == 0){
            return jogador1;
        } else {
            return null;
        }

    }	 	  	  	 	   	      	   	    	    	     	 	
}



















