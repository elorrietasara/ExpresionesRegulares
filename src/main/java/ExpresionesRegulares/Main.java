package ExpresionesRegulares;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean error = true;
		String cadena;
		String expresion;
		Scanner reader = new Scanner(System.in);
		while (error) {

			System.out.println("Ejemplo texto: hol3aAa");

			System.out.print("Introduzca una cadena por teclado:");
			cadena = reader.next();
			System.out.println("Ejemplo: >1-|A|Z;|a|z;|0|9@l3a");
			System.out.print("Introduzca la expresión regular:");
			expresion = reader.next();

			try {

				if (Regla.Validar(cadena, expresion)) {
					System.out.println("Valido");
				}
				else
				{
					System.out.println("No valido");
				}

			}

			catch (Exception ex) {
				System.err.println("La expresion regular no es valida");
				System.err.println("Ejemplo texto: hol3aAa");
				System.err.println("Ejemplo regex: >1-|A|Z;|a|z;|0|9@l3a");
			}
			error = false;
		}
	}

}
