package ExpresionesRegulares;

import org.apache.commons.math3.geometry.spherical.oned.ArcsSet.Split;

public class Regla {

	public static void Validar(String texto, String regexSinSeparar)
	{
		String[] partesRegex=SepararRegex(regexSinSeparar);
		
		System.out.println(ValidarTamano(texto,partesRegex[0]));
		System.out.println(ValidarTextoPorLetra(texto, partesRegex[1]));
		System.out.println(ValidarLiteral(texto, partesRegex[2]));
		
	}
	
	
	
	
	private static boolean ValidarLiteral(String texto, String literal) {
		boolean valido = false;
		if(texto.indexOf(literal)>=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}




	private static boolean ValidarTamano(String texto, String tamano) {
		
		int tamnoSinSimbolo = Integer.parseInt(tamano.substring(1));
		
		if(tamano.charAt(0)==60)
		{
			if(texto.length()<=tamnoSinSimbolo)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(tamano.charAt(0)==62)
		{
			if(texto.length()>=tamnoSinSimbolo)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
		
		
	}

	private static String[] SepararRegex(String regex)
	{
		String[] parte1=regex.split("-");
		String[] parte2=parte1[1].split("@");
		String[] devolver = {parte1[0], parte1[1], parte2[1]};
		
		return devolver;
	}
	
	
	private static boolean ValidarTextoPorLetra(String texto, String regexSinSeparar)
	{
		String[] expresionesSeparadas;
		expresionesSeparadas=SepararExpresiones(regexSinSeparar);
		boolean valido = false;
		for (int i=0;i<texto.length();i++)
		{
			char letraComprar=texto.charAt(i);
			valido=false;
			for (int z = 0 ; z<expresionesSeparadas.length;z++)
			{
				
				if(ValidarLetra(letraComprar,expresionesSeparadas[z]))
				{
					valido=true;
					break;
				}
			}
			
			if(!valido)
			{
				break;
			}
		}
		return valido;
	}
	
	private static boolean ValidarLetra(char letraComprar, String expresionesSeparadas) {
		
		char rangoMin=expresionesSeparadas.charAt(1);
		char rangoMax=expresionesSeparadas.charAt(3);
		
		if(letraComprar >= rangoMin && letraComprar <= rangoMax)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private static String[] SepararExpresiones(String regex)
	{
		return regex.split(";");
	}
	
	
}
