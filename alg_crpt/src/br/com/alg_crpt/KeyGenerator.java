package br.com.alg_crpt;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class KeyGenerator {
	
	public static final int MODULAR = 256;
	
	public static void main(String[] args) {
		
		char [] arrKey = new char [63];
		
		String fileName = "EsteEhOarquivoNomeDeleNé hahaha";
		
		for (int position = 0; position < arrKey.length; position++) {
			
			arrKey [position] = calculate(fileName); 
		}
		System.out.println(Arrays.toString(arrKey));
	}
	
	public static char calculate(String fileName) {
		
		int result = 0;
		
		for (char c : fileName.toCharArray()) {
			
			long currTimeStamp = currTimeStamp();
			
			Operations operationRandom = getOperationRandom();
			switch (operationRandom) {
				case ADICAO: //adicao
					result += (((int) currTimeStamp) + ((int) c));
					break;
				case SUBTRACAO: //subtracao
					result += (((int) currTimeStamp) - ((int) c));
					break;
				case MULTIPLICACAO: //multiplicacao
					result += (((int) currTimeStamp) * ((int) c));
					break;
				}
		}
		
		Operations operationRandom = getOperationRandom();
		switch (operationRandom) {
			case ADICAO: //adicao
				return (char) ((result + getPseduRandom()) % MODULAR);
			case SUBTRACAO: //subtracao
				return (char) ((result - getPseduRandom()) % MODULAR);
			case MULTIPLICACAO: //multiplicacao
				return (char) ((result * getPseduRandom()) % MODULAR);
				
			default:
				return (char) 0;
			}
	}
	
	public static Operations getOperationRandom() {
		int rnd = new Random().nextInt(Operations.values().length);
		return Operations.values()[rnd] ;
	}
	
	public static long getPseduRandom() {
		return (currTimeStamp() * ((int) (Math.random() * 1000)));
	}
	
	public static long currTimeStamp() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		return c.getTimeInMillis();
	}

}