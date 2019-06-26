package io.spring.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public Date getDataAtual() {
		
		Date hoje = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(hoje );

		return calendar.getTime();
	}
	
	


	public Date incrementaDataEmDias(Date data, int numeroDeDias) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDataAtual());
		calendar.add( Calendar.DAY_OF_MONTH , numeroDeDias);

		return calendar.getTime();
	}	
	
	


	public Date incrementaDataEmMeses(Date data, int numeroDeMeses) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDataAtual());
		calendar.add( Calendar.MONTH , numeroDeMeses );

		return calendar.getTime();
	}	
	
	

	
	
	public Date incrementaDataEmAnos(Date data, int numeroDeAnos) {

		Date hoje = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(hoje );
		calendar.add( Calendar.YEAR , numeroDeAnos );

		return calendar.getTime();
	}	
	

	
}
