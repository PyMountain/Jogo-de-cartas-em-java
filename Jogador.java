import java.util.ArrayList;
import java.util.Random;

public class Jogador implements IJogador {
    
    private ArrayList<Carta> cartasMaoJogador;
    private String nome;
    
    public Jogador(String nome){
        cartasMaoJogador = new ArrayList();
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * Retira uma das cartas do Jogador. Esta operacao eh utilizada para realizar uma jogada (baixar uma carta na mesa)
     * A carta sai da mao (ou seja, a carta sai da lista das cartas que o jogador possui)
     * @return Retorna a Carta qiue foi retirada da mao do jogador (lista das cartas que ele possui)
     */
    public Carta baixaCartaDaMao(){
        if(!cartasMaoJogador.isEmpty()){
            Random gerador = new Random();
            return cartasMaoJogador.get(gerador.nextInt(cartasMaoJogador.size()));
        } else {
            return null;
        }
    }

    /**
     *
     * @return Retorna a mao atual do jogador (lista das cartas que ele possui)
     */
    public ArrayList<Carta> getMao(){	 	  	  	 	   	      	   	    	    	     	 	
        return this.cartasMaoJogador;
    }

    /**
     * Inclui na mao do jogador a carta passada como parametro
     * @param carta Carta que sera incluida na mao do jogador
     */
    public void incluiCartaNaMao(Carta carta){
        cartasMaoJogador.add(carta);
    }

    /**
     * Retira da mao do jogador a carta passada como parametro.
     * @param carta Carta que sera retirada da mao do jogador (lista das cartas que ele possui)
     */
    public void removeCartaNaMao(Carta carta){
        if(!cartasMaoJogador.isEmpty()){
            cartasMaoJogador.remove(carta);
        }
    }
    
    
}