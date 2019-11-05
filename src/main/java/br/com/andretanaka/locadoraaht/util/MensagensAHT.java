package br.com.andretanaka.locadoraaht.util;

import java.util.Locale;
import java.util.ResourceBundle;


/*
 * by Andre Hiroshi Tanaka
 * andrehtgti2@gmail.com
 * www.andretanaka.com.br
 * 
 */


public class MensagensAHT {
	
	private final String NOME_ARQUIVO_PROPERTIES = "MensagensAHT";
	
	
	
	
	
	
	
	public static final String DATA_INICIAL_POSTERIOR_A_DATA_FINAL = "DATA_INICIAL_POSTERIOR_A_DATA_FINAL";


	public static final String CLIENTE_JA_POSSUI_LOCACAO = "CLIENTE_JA_POSSUI_LOCACAO";



	
	
	
	
	
	
	
	private Locale ptBr = new Locale("pt", "BR");
	
	private static MensagensAHT mensagens;
	
	private MensagensAHT() {
	}
	
	public static MensagensAHT getInstance(){
		if(mensagens==null){
			mensagens = new MensagensAHT();
		}
		return mensagens;
	}
	

	public String getMensagem(String key){
		ResourceBundle bundle = ResourceBundle.getBundle(NOME_ARQUIVO_PROPERTIES, ptBr);
		return bundle.getString(key);
	}
	


}
