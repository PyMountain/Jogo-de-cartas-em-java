public class Carta implements ICarta {
    
    private Personagem personagem;
    
    
    public Carta(Personagem personagem){
        this.personagem = personagem;
    }
    
    /**
     * Soma e retorna todos os valores dos atributos do personagem da Carta
     * @return Retorna o somatorio de todos os atributos do personagem da Carta
     */
    public int getValorTotalCarta(){
        return personagem.somaAtributos();
    }

    public void setPersonagem(Personagem personagem){
        this.personagem = personagem;
    }
    
    public Personagem getPersonagem(){
        return this.personagem;
    }
    
}	 	  	  	 	   	      	   	    	    	     	 	
