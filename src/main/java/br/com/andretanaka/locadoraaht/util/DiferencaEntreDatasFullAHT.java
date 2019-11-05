package br.com.andretanaka.locadoraaht.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * by Andre Hiroshi Tanaka
 * andrehtgti2@gmail.com
 * www.andretanaka.com.br
 * 
 */

public class DiferencaEntreDatasFullAHT {
	

	public enum TipoDeResultadoDaComparacaoDeData{RESULTADO_EM_DIAS, RESULTADO_EM_HORAS, RESULTADO_EM_MINUTOS, RESULTADO_EM_SEGUNDOS, RESULTADO_EM_MILISSEGUNDOS};
	
	
	public static SimpleDateFormat simpleDateFormatData = new SimpleDateFormat("dd/MM/yyyy");
	public static SimpleDateFormat simpleDateFormatDataHoraDoisPontos = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	public static SimpleDateFormat simpleDateFormatDataHoraHM = new SimpleDateFormat("dd/MM/yyyy HH'h'mm'm'");
	
//##########################################################################################################################################
	public static final String getStringDataAtual(){
		return simpleDateFormatData.format(new Date());
	}
//##########################################################################################################################################	
	public static final String getStringDataHoraAtual(){
		return simpleDateFormatDataHoraDoisPontos.format(new Date());
	}	
//##########################################################################################################################################
	/**
	* by Andre Hiroshi Tanaka
	* Tanaka Tecnologia da Informacao LTDA
	* www.andretanaka.com.br
	* andrehtgti2@gmail.com
	*/
//##########################################################################################################################################
	public static ValueObjectDateAHT calculaDiferencaCompletaEntreDatasAHT(Date data1, Date data2){
		boolean DEBUG_MODE = false;
		return calculaDiferencaCompletaEntreDatasAHT(data1, data2, DEBUG_MODE);
	}
//##########################################################################################################################################
/*
 */
//##########################################################################################################################################	
	public static ValueObjectDateAHT calculaDiferencaCompletaEntreDatasAHT(Date data1, Date data2, boolean DEBUG_MODE){
		Calendar dataFuturo = Calendar.getInstance();
		Calendar dataPassado = Calendar.getInstance();
		int difDias;
		int difMeses;
		int difAnos;
		int difHora;
		int difMin;
		int difSeg;
		int difMiliSeg;
		int[] monthDay = new int[] { 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int increment;
		boolean decrementaDia = false;
		boolean decrementaMes = false;
		boolean decrementaAno = false;
		
		if(data1.after(data2)){
			dataFuturo.setTime(data1);
			dataPassado.setTime(data2);			
		}else{
			dataFuturo.setTime(data2);
			dataPassado.setTime(data1);
		}
		System.out.println("#########################################");
		if(DEBUG_MODE){
			System.out.println("Data Passado = " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataPassado.getTime()));
			System.out.println("=>dataPassado.get(Calendar.DATE)=" + dataPassado.get(Calendar.DATE));
			System.out.println("=>dataPassado.get(Calendar.MONTH)=" + dataPassado.get(Calendar.MONTH));
			System.out.println("=>dataPassado.get(Calendar.YEAR)=" + dataPassado.get(Calendar.YEAR));
			System.out.println("=>dataPassado.get(Calendar.HOUR)=" + dataPassado.get(Calendar.HOUR));
			System.out.println("=>dataPassado.get(Calendar.MINUTE)=" + dataPassado.get(Calendar.MINUTE));
			System.out.println("=>dataPassado.get(Calendar.SECOND)=" + dataPassado.get(Calendar.SECOND));
			System.out.println("=>dataPassado.get(Calendar.MILLISECOND)=" + dataPassado.get(Calendar.MILLISECOND));
			System.out.println("----------------------------------------");
			System.out.println("Data Futuro = " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataFuturo.getTime()));
			System.out.println("=>dataFuturo.get(Calendar.DATE)=" + dataFuturo.get(Calendar.DATE));
			System.out.println("=>dataFuturo.get(Calendar.MONTH)=" + dataFuturo.get(Calendar.MONTH));
			System.out.println("=>dataFuturo.get(Calendar.YEAR)=" + dataFuturo.get(Calendar.YEAR));
			System.out.println("=>dataFuturo.get(Calendar.HOUR)=" + dataFuturo.get(Calendar.HOUR));
			System.out.println("=>dataFuturo.get(Calendar.MINUTE)=" + dataFuturo.get(Calendar.MINUTE));
			System.out.println("=>dataFuturo.get(Calendar.SECOND)=" + dataFuturo.get(Calendar.SECOND));
			System.out.println("=>dataFuturo.get(Calendar.MILLISECOND)=" + dataFuturo.get(Calendar.MILLISECOND));
			System.out.println("----------------------------------------");
		}
		
//--------------------------------------------------------------------------------------------------------------------------------------				
//CALCULANDO HORA MINUTO SEGUNDO
		Calendar horaFuturoIgualadoData = Calendar.getInstance();
		Calendar horaPassadoIgualadoData = Calendar.getInstance();
		if(data1.after(data2)){
			horaFuturoIgualadoData.setTime(data1);
			horaPassadoIgualadoData.setTime(data2);			
		}else{
			horaFuturoIgualadoData.setTime(data2);
			horaPassadoIgualadoData.setTime(data1);
		}
		horaFuturoIgualadoData.set(2017, 8, 18);
		horaPassadoIgualadoData.set(2017, 8, 18);
		
		if(horaPassadoIgualadoData.after(horaFuturoIgualadoData)){
			horaFuturoIgualadoData.set(2017, 8, 19);
			decrementaDia = true;
		}
		
		double result = 0;
		long diferencaEmMilisegundos = horaFuturoIgualadoData.getTimeInMillis() - horaPassadoIgualadoData.getTimeInMillis();
        double diferencaEmSegundos = (diferencaEmMilisegundos /1000); 			//resultado eh diferen�a entre as datas em segundos  
        double diferencaEmMinutos = (diferencaEmMilisegundos /1000) / 60; 		//resultado eh diferen�a entre as datas em minutos  
        double diferencaEmHoras = (diferencaEmMilisegundos /1000) / 60 /60;		//resultado eh diferen�a entre as datas em horas
        
        int diferencaEmDias = (int)diferencaEmHoras/24;
        double diferenteEmMiliSegundosMenosOsDias = diferencaEmMilisegundos - (diferencaEmDias*(24*60*60*1000) );
        
        int diferenteEmHorasMenosOsDias = (int) diferenteEmMiliSegundosMenosOsDias/1000/60/60;
        int diferenteEmMinutosMenosOsDias = (int) ( (diferenteEmMiliSegundosMenosOsDias/1000/60) - (diferenteEmHorasMenosOsDias*60) );
        
        int diferenteEmSegundosMenosOsDias = (int) ((diferenteEmMiliSegundosMenosOsDias/1000) - ((diferenteEmMinutosMenosOsDias*60) + (diferenteEmHorasMenosOsDias*60*60))  );
        
        int diferenteEmMilisegundosMenosOsDias = (int) ((diferenteEmMiliSegundosMenosOsDias) - ((diferenteEmMinutosMenosOsDias*60*1000) + (diferenteEmHorasMenosOsDias*60*60*1000) + (diferenteEmSegundosMenosOsDias*1000)) );
        
        difHora = diferenteEmHorasMenosOsDias;
        difMin = diferenteEmMinutosMenosOsDias;
        difSeg = diferenteEmSegundosMenosOsDias;
        difMiliSeg = diferenteEmMilisegundosMenosOsDias;
        
		

//--------------------------------------------------------------------------------------------------------------------------------------		
//CALCULANDO DIAS
		increment = 0;
		
		if(dataPassado.get(Calendar.DATE) > dataFuturo.get(Calendar.DATE)){
			if(DEBUG_MODE){
				System.out.println("...incrementa dia do futuro, DIA DO PASSADO EH MAIOR QUE O DIA DO FUTURO");
			}
			increment = monthDay[(dataPassado.get(Calendar.MONTH)+1) - 1];
		}
		
		//SE EH FEVEREIRO
		if(increment == -1){
			if(isAnoBissexto(dataPassado.get(Calendar.YEAR))){
				increment = 29;
			}else{
				increment = 28;
			}
		}
		
		if(increment != 0){//SE DIA DO PASSADO EH MAIOR QUE O DIA DO FUTURO (APENAS O DIA, NAO COMPARANDO O MES E ANO, APENAS COMPARANDO O NUMERO DIA), incrementa dia do futuro e seta para incrementar mes do futuro
			if(DEBUG_MODE){
				System.out.println("...incrementa mes do futuro, DIA DO PASSADO EH MAIOR QUE O DIA DO FUTURO");
			}
			difDias = (dataFuturo.get(Calendar.DATE) + increment) - dataPassado.get(Calendar.DATE);
			increment = 1;
		}else{//SE O DIA DO PASSADO EH MENOR QUE O DIA DO FUTURO  (APENAS O DIA, NAO COMPARANDO O MES E ANO, APENAS COMPARANDO O NUMERO DIA)
			difDias = dataFuturo.get(Calendar.DATE) - dataPassado.get(Calendar.DATE);
			//increment = 0; JAH ESTA IMPLICITO ISSO
		}
		if(decrementaDia){
			if(DEBUG_MODE){
				System.out.println("...decrementado diferenca entre dias, DIA DO PASSADO EH MAIOR QUE DIA DO FUTURO");
			}
			difDias = difDias - 1;
			if(difDias<0){
				difDias = 0;
				decrementaMes = true;
			}
				
		}
		
		
//--------------------------------------------------------------------------------------------------------------------------------------		
//CALCULANDO MES
		
		//SE O MES DO PASSADO JAH DECRESCIDO DO INCREMENTO ANTERIOR FOR MAIOR QUE O MES DO FUTURO
		if(((dataPassado.get(Calendar.MONTH)+1) + increment) > (dataFuturo.get(Calendar.MONTH))+1){
			if(DEBUG_MODE){
				System.out.println("...incrementa ano do fututo, MES DO PASSADO EH MAIOR QUE O MES DO FUTURO");
			}
			difMeses = ((dataFuturo.get(Calendar.MONTH)+1) + 12) - ((dataPassado.get(Calendar.MONTH)+1) + increment);
			increment = 1;
		}else{//SE O MES DO PASSADO JAH DECRESCIDO DO INCREMENTO ANTERIOR FOR MENOR QUE O MES DO FUTURO
			difMeses = (dataFuturo.get(Calendar.MONTH)+1) - ((dataPassado.get(Calendar.MONTH)+1) + increment);
			increment = 0;
		}
		if(decrementaMes){
			if(DEBUG_MODE){
				System.out.println("...decrementado mes");
			}
			difMeses = difMeses - 1;
			if(difMeses<0){
				difMeses = 0;
				decrementaAno = true;
			}
		}
		
		
//--------------------------------------------------------------------------------------------------------------------------------------		
//CALCULANDO ANO
		
		difAnos = dataFuturo.get(Calendar.YEAR) - (dataPassado.get(Calendar.YEAR) + increment);
		if(decrementaAno){
			if(DEBUG_MODE){
				System.out.println("...decrementado ano");
			}
			difAnos = difAnos - 1;
			if(difAnos<0){
				difAnos = 0;
			}
		}
		
//--------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------		
		
		System.out.println("----------------------------------------");
		System.out.println("Data Passado = " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataPassado.getTime()));
		System.out.println("Data Futuro = " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataFuturo.getTime()));
		System.out.println("----------------------------------------");
		System.out.println("Dif anos = " + difAnos + " anos " );
		System.out.println("Dif meses = " + difMeses + " meses " );
		System.out.println("Dif dias = " + difDias + " dias " );
		System.out.println("Dif horas = " + difHora + " horas ");
		System.out.println("Dif minutos = " + difMin + " minutos ");
		System.out.println("Dif segundos = " + difSeg + " segundos ");
		System.out.println("Dif milissegundos = " + difMiliSeg + " milissegundos ");
		System.out.println("#########################################");
		
		return new ValueObjectDateAHT(
										dataFuturo.getTime(),	//Date dataFuturo,  
										dataPassado.getTime(),	//Date dataPassado, 
										difDias,				//int difDias, 
										difMeses,				//int difMeses, 
										difAnos,				//int difAnos, 
										difHora,				//int difHoras, 
										difMin,					//int difMinutos,
										difSeg,					//int difSegundos
										difMiliSeg				//int difMilissegundos
		);
	}

//##########################################################################################################################################
//##########################################################################################################################################
//##########################################################################################################################################	
	

	public static boolean isAnoBissexto(int ano) {  
        if ( ( ano % 4 == 0 && ano % 100 != 0 ) || ( ano % 400 == 0 ) ){  
            return true;  
        }  
        else{  
            return false;  
        }  
	}  
	
//##########################################################################################################################################
//##########################################################################################################################################
//##########################################################################################################################################
	
	
	
//##########################################################################################################################################
	
	public static double calculaQuantidadeEntreDatas(Date data1, Date data2, TipoDeResultadoDaComparacaoDeData tipoDeResultado){
		Calendar dataFuturo = Calendar.getInstance();
		Calendar dataPassado = Calendar.getInstance();
		if(data1.after(data2)){
			dataFuturo.setTime(data1);
			dataPassado.setTime(data2);			
		}else{
			dataFuturo.setTime(data2);
			dataPassado.setTime(data1);
		}
		//System.out.println("#########################################");
		double result = 0;
		long diferenca = dataFuturo.getTimeInMillis() - dataPassado.getTimeInMillis();
		if(tipoDeResultado == TipoDeResultadoDaComparacaoDeData.RESULTADO_EM_DIAS){
	        double diferencaEmDias = (diferenca /1000) / 60 / 60 /24; 	//resultado eh diferen�a entre as datas em dias  
	        long horasRestantes = (diferenca /1000) / 60 / 60 %24; 		//calcula as horas restantes  
	        result = diferencaEmDias + (horasRestantes /24d); 			//transforma as horas restantes em fra��o de dias	        
	        return Math.floor(result);
		}
		if(tipoDeResultado == TipoDeResultadoDaComparacaoDeData.RESULTADO_EM_HORAS){
	        long diferencaEmHoras = (diferenca /1000) / 60 / 60;  		//resultado eh diferen�a entre as datas em horas
	        long minutosRestantes = (diferenca / 1000)/60 %60;  		//calcula os minutos restantes
	        double horasRestantes = minutosRestantes / 60d;  			//transforma os minutos restantes em fracao de horas
	        result = diferencaEmHoras + (horasRestantes);  	          
	        return result;
		}	
		if(tipoDeResultado == TipoDeResultadoDaComparacaoDeData.RESULTADO_EM_MINUTOS){
	        double diferencaEmMinutos = (diferenca /1000) / 60; 		//resultado eh diferen�a entre as datas em minutos  
	        long segundosRestantes = (diferenca / 1000)%60; 			//calcula os segundos restantes  
	        result = diferencaEmMinutos + (segundosRestantes /60d); 	//transforma os segundos restantes em fracao de minutos  	      
	        return result; 
		}
		if(tipoDeResultado == TipoDeResultadoDaComparacaoDeData.RESULTADO_EM_SEGUNDOS){
			double diferencaEmSegundos = (diferenca /1000);
			return diferencaEmSegundos;
		}
		if(tipoDeResultado == TipoDeResultadoDaComparacaoDeData.RESULTADO_EM_MILISSEGUNDOS){
			return diferenca;
		}
		return 0;
		
	}
	
	
	
	public static String getStringDiferencaHoraMinuto(Date hora1, Date hora2){
		double difMinutos = DiferencaEntreDatasFullAHT.calculaQuantidadeEntreDatas(hora1, hora2, TipoDeResultadoDaComparacaoDeData.RESULTADO_EM_MINUTOS);
		int hora = 0;
		int minutos = 0;
		String msgHoraDiferencaEntreHoras = "";
		if(difMinutos>=60){
			hora = ((int)(difMinutos/60));
			minutos = ((int)difMinutos) - (hora*60);
			msgHoraDiferencaEntreHoras = hora + " hora(s) e " + minutos + " minuto(s)";
		}else{
			minutos = (int)difMinutos;
			msgHoraDiferencaEntreHoras = minutos + " minuto(s)";
		}
		return msgHoraDiferencaEntreHoras;
	}
	
	
//##########################################################################################################################################
	
	public static String getStringDiferencaHoraMinutoSegundo(Date hora1, Date hora2){
		double difSegundos = DiferencaEntreDatasFullAHT.calculaQuantidadeEntreDatas(hora1, hora2, TipoDeResultadoDaComparacaoDeData.RESULTADO_EM_SEGUNDOS);
		int hora = 0;
		int minutos = 0;
		int segundos = 0;
		String msgHoraDiferencaEntreHoras = "";
		
		if(difSegundos < 60){
			segundos = (int) (difSegundos);
			msgHoraDiferencaEntreHoras = segundos + " segundo(s)";
		}else{
			minutos = (int) (difSegundos/60);
			if(minutos<60){
				segundos = (int) (difSegundos - (minutos*60));
				msgHoraDiferencaEntreHoras = minutos + " minuto(s) e " + segundos + " segundo(s)";
			}else{
				hora = ((int)(minutos/60));
				minutos = ((int)minutos) - (hora*60);
				segundos = (int) (difSegundos - (hora*60*60 + minutos*60));
				msgHoraDiferencaEntreHoras = hora + " hora(s) e " + minutos + " minuto(s) e " + segundos + " segundo(s)";
			}
		}
		
		
		return msgHoraDiferencaEntreHoras;
	}
}
