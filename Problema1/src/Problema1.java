import java.util.Arrays;
import java.util.Scanner;

public class Problema1 {
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese una palabra");
		String cadena, temp;
		Byte cont=1;
		cadena = sc.nextLine();
		cadena=cadena.toLowerCase();
		System.out.println("la palabra es: "+cadena);
		String[] partes = cadena.split("");   
		
		
		
		
		 for(int i=1;i < partes.length;i++){
	            for (int j=0 ; j < partes.length- 1; j++){
	                if (partes[j].compareTo(partes[j+1])> 0){
	                    temp = partes[j];
	                    partes[j] = partes[j+1];
	                    partes[j+1] = temp;
	                }
	            }
	        }
		 for (int i = 0; i < partes.length-1; i++) {
			 
			if (partes[i].contentEquals(partes[i+1])) {
				cont++;
			}else {
				System.out.println(partes[i]+"- > "+cont);
				cont=1;
			}
		}
		 System.out.println(Arrays.asList(partes));
	}

}
