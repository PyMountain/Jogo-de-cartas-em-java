public class Personagem {
    private int energia; 
    private int habilidade; 
    private int velocidade;
    private int resistencia; 
    private TipoPersonagem tipo;
    
    public Personagem(int energia, int habilidade, int velocidade, int resistencia, TipoPersonagem tipo){
        this.energia = energia;
        this.habilidade = habilidade;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.tipo = tipo;
    }
    
    public int getEnergia(){
        return this.energia;
    }
    
    public int getHabilidade(){
        return this.habilidade;
    }
    
    public int getVelocidade(){
        return this.velocidade;
    }
    
    public int getResistencia(){
        return this.resistencia;
    }
    
    public TipoPersonagem getTipo(){
        return this.tipo;
    }
    
    public int somaAtributos(){
        int soma = energia;
        soma += habilidade;
        soma += velocidade;
        soma += resistencia;
        return soma;
    }	 	  	  	 	   	      	   	    	    	     	 	
}