package br.com.alg_crpt;

public enum Operations {
	
	ADICAO(0),
	SUBTRACAO(1),
	MULTIPLICACAO(2);
    private final int value;

    private Operations(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
