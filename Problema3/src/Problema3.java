import java.util.Scanner;

public class Problema3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese una palabra: ");
		String cadena;
		cadena = sc.nextLine();
		String[] partes = cadena.split("");   
		if (encontrarMayusculas(cadena)||encontraNumeros(cadena)||encontrarCarcteres(partes)||
				encontrarEspacio(partes)) {
				if (tamCadena(cadena)) {
					System.out.println("Contraseña valida "+cadena);
				}
						
			
		} 
		
		
		
	}//main
	////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////
	public static boolean encontrarMayusculas(String cadena) {
		String minusculas=cadena.toLowerCase(); 
		String minusPartes[]=minusculas.split("");
		String partes[]=cadena.split("");
		Byte cont=0;
		boolean may=true;
		for (int i = 0; i < cadena.length(); i++) {
			if (minusPartes[i].equals(partes[i])) {
				
			}else {
				cont++;
			}
				
		}
		
		if (cont<2) {
			System.out.println("La contraseña debe de tener al menos 2 Mayúsculas");
			may=false;
		} 
		
		return may;
	}///////
	public static boolean encontraNumeros(String cadena) {
		char partes[]=cadena.toCharArray();
		Byte cont=0;
		boolean num=true;
		for (int i = 0; i < partes.length; i++) {
			
			if (Character.isDigit(partes[i]) ) {
				for (int j = 0; j < partes.length; j++) {
					if (partes[i]==partes[j]&&i!=j) {
						System.out.println("No se puede ingresar números repetidos");
						num= false;
						i=partes.length;
					}
				}
				cont++;
			}
		}
		if (cont<3) {
			System.out.println("La contraseña debe de tener 3 números");
			num =false;
			
		}
		return num;
		
	}/////////////
	public static boolean encontrarCarcteres(String partes[]) {
		String caracteres[]= {"*","_","-","¿","¡","?","#","$"};
		Byte cont=0;
		boolean car =true;
		for (int i = 0; i < partes.length; i++) {
			for (int j = 0; j < caracteres.length; j++) {
				if (partes[i].equals(caracteres[j])) {
					cont++;
				} 
			}
		}
		if (cont<1) {
			System.out.println("La contraseña dede de tener al menos un carcter especial * _ - ¿ ¡ ? # $");
			car=false;
		}
		return car;
	}//////
	
	public static boolean encontrarEspacio(String partes[]) {
		boolean esp =true;
		for (int i = 0; i < partes.length; i++) {
		if (partes[i].equals(" ")) {
			System.out.println("laContraseña no puede tener espacios en blanco");
			esp=false;
		}	
		}
		
		
		
		return esp;
	}
	
	public static boolean tamCadena(String cadena) {
		boolean tam=false;
		System.out.println("tamaño de la cadena "+ cadena.length());
		if (cadena.length()-1>8&&cadena.length()<15) {
			tam=true;
			
		}
		System.out.println("la contraseña debe tenerser de entre 8 y 15 caracteres");
		return tam;
	}

}
	
