import java.util.Scanner;

public class Problema2 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese una palabra");
		String cadena;
		
		cadena = sc.nextLine();
		cadena =cadena.toLowerCase();
		String[] partes = cadena.split("");   
		System.out.println("la palabra es: "+cadena);
		System.out.println("Las silabas son");
		Byte cont=0;
		
		for (int i = 0; i < partes.length; i++) {
			if (partes[i].equals("a")||partes[i].equals("e")||partes[i].equals("i")||
					partes[i].equals("o")||partes[i].equals("u")) {
				cont++;
							
			}
			
			
		}//for
		
		Byte  posVocales[]= new Byte[cont];
		Byte  sepVocales[]= new Byte[cont];
		Byte contSepa=0;
		cont=0;
		for (int i = 0; i < partes.length; i++) {
			if (partes[i].equals("a")||partes[i].equals("e")||partes[i].equals("i")||
					partes[i].equals("o")||partes[i].equals("u")) {
			posVocales[cont]=(byte) i;
			sepVocales[cont]=contSepa;
			cont++;
			contSepa=0;
		
			}else {
				contSepa++;
			}
				

			
		}//for
		
		
		
		
		/*
		for (int i = 0; i < posVocales.length; i++) {
			System.out.println("posicion de la vocal "+posVocales[i]);
			System.out.println("separacion entre vocales "+sepVocales[i]);
		}*/
		separarSilabas(partes,posVocales,sepVocales);
		System.out.println();
		
	}//main
	public static String separarSilabas(String partes [],Byte posVocales[],Byte sepVocales[]) {
		String silaba="",parte="";
		byte cont=0;
		
		
		for (int i = 0; i < sepVocales.length; i++) {
			if (sepVocales[i]==0) {
				if (i!=0) {
					if (posVocales[i]-posVocales[i-1]==1) {
						
						if (sepVocales[i-1]==1) {
							silaba=partes[posVocales[i-1]-2]+partes[posVocales[i-1]-1]+partes[posVocales[i]]+partes[posVocales[i]+1];
						}else if (sepVocales[i-1]==2) {
							parte=partes[posVocales[i-1]-2]+partes[posVocales[i-1]-1];
							
							if (validarConsonanticosyFonemas(parte)) {
								silaba=partes[posVocales[i-1]-2]+partes[posVocales[i-1]-1]+partes[posVocales[i-1]]+partes[posVocales[i]];
							}else {
								if (posVocales[i]==partes.length-2) {
									silaba=partes[posVocales[i-1]-1]+partes[posVocales[i-1]]+partes[posVocales[i]]+partes[posVocales[i]+1];
								}else {
									silaba=partes[posVocales[i-1]-1]+partes[posVocales[i-1]];
								}
								
							}
							
						}else if (sepVocales[i-1]==3) { 
							silaba=partes[posVocales[i-1]-1]+partes[posVocales[i-1]]+partes[posVocales[i]];;					
						}else if (sepVocales[i-1]==4) {
							silaba=partes[posVocales[i-1]-2]+partes[posVocales[i-1]-1]+partes[posVocales[i-1]]+partes[posVocales[i]];	
						}
					}
				}else {
					if (i!=sepVocales.length-1) {
						if (sepVocales[i+1]==1) {
							silaba=partes[0];
						}else if (sepVocales[i+1]==2) {
							parte=partes[posVocales[i+1]-2]+partes[posVocales[i+1]-1];
							if (validarConsonanticosyFonemas(parte)) {
								silaba=partes[posVocales[i]];
								
							}else {
								silaba=partes[posVocales[i]]+partes[posVocales[i]+1];
							}
							
						}else if (sepVocales[i+1]==3) { 
							silaba=partes[posVocales[i]]+partes[posVocales[i]+1]+partes[posVocales[i]+2];					
						}else if (sepVocales[i+1]==4) {
							silaba=partes[posVocales[i]]+partes[posVocales[i]+1]+partes[posVocales[i]+2];	
						}
					}else {
						if (posVocales[i]==(partes.length)-2) {
							if (sepVocales[i]==1) {
								silaba=partes[partes.length]+partes[partes.length-1];
							}else if (sepVocales[i]==2) {
								silaba=partes[partes.length]+partes[partes.length-1];
							}else if (sepVocales[i]==3) { 
								silaba=partes[partes.length]+partes[partes.length-1]+partes[partes.length-2];					
							}else if (sepVocales[i]==4) {
								silaba=partes[partes.length]+partes[partes.length-1]+partes[partes.length-2];		
							}
						}
					}
				}
				
				
				
			}else if (sepVocales[i]==1) {
				if (i!=sepVocales.length-1) {
					if (sepVocales[i+1]==1) {
						silaba=partes[posVocales[i]-1]+partes[posVocales[i]];
					}else if (sepVocales[i+1]==2) {
						parte=partes[posVocales[i+1]-2]+partes[posVocales[i+1]-1];
						if (validarConsonanticosyFonemas(parte)) {
							silaba=partes[posVocales[i]-1]+partes[posVocales[i]];
						}else {
							silaba=partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1];
						}
						
					}else if (sepVocales[i+1]==3) {
						silaba=partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1]+partes[posVocales[i]+2];
					
					}else if (sepVocales[i+1]==4) {
						silaba=partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1]+partes[posVocales[i]+2];
					}
				}else {
					silaba=partes[posVocales[i]-1]+partes[posVocales[i]];
							
				}
				
				
				
			}else if (sepVocales[i]==2) {
				parte=partes[posVocales[i]-2]+partes[posVocales[i]-1];
				if (validarConsonanticosyFonemas(parte)) {
					if (sepVocales[i]==1) {
						silaba=partes[posVocales[i]-2]+partes[posVocales[i]-1]+partes[posVocales[i]];
					}else if (sepVocales[i]==2) {
						if (i!=posVocales.length-1) {
							parte=partes[posVocales[i]-2]+partes[posVocales[i]-1];
							if (validarConsonanticosyFonemas(parte)) {
								silaba=partes[posVocales[i]-2]+partes[posVocales[i]-1]+partes[posVocales[i]];
							}else {
								silaba=partes[posVocales[i]-2]+partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1];
							}
							
							
						}else {
							parte=partes[posVocales[i]-2]+partes[posVocales[i]-1];
							if (validarConsonanticosyFonemas(parte)) {
								silaba=partes[posVocales[i]-2]+partes[posVocales[i]-1]+partes[posVocales[i]];
								
							}else {
								silaba=partes[posVocales[i]-2]+partes[posVocales[i]-1]+partes[posVocales[i]];
							}
							
							
						}
							
					}else if (sepVocales[i]==3) {
						silaba=partes[posVocales[i]-2]+partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1]+partes[posVocales[i]+2];
					}else if (sepVocales[i]==4) {
						silaba=partes[posVocales[i]-2]+partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1]+partes[posVocales[i]+2];
					}
					
				}else {
					if (i!=sepVocales.length-1) {
						if (sepVocales[i+1]==1) {
							silaba=partes[posVocales[i]-2]+partes[posVocales[i]-1]+partes[posVocales[i]];
						}else if (sepVocales[i+1]==2) {
							parte=partes[posVocales[i]-2]+partes[posVocales[i]-1];
							if (validarConsonanticosyFonemas(parte)) {
								silaba=partes[posVocales[i]-2]+partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1];
							}else {
								silaba=partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1];
							}

							
						}else if (sepVocales[i+1]==3) {
							silaba=partes[posVocales[i]-2]+partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1]+partes[posVocales[i]+2];
						}else if (sepVocales[i+1]==4) {
							silaba=partes[posVocales[i]-2]+partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1]+partes[posVocales[i]+2];
						}
					}else if(posVocales[i]==(partes.length-2)) {
						silaba=partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1];
							
					}else {
						silaba=partes[posVocales[i]-1]+partes[posVocales[i]];
						
					}
				}
				
				
				
			}else if (sepVocales[i]==3) {
				if (i!=sepVocales.length-1) {
					if (sepVocales[i+1]==1) {
						silaba=partes[posVocales[i]-1]+partes[posVocales[i]];
					}else if (sepVocales[i+1]==2) {
						silaba=partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1];
					}else if (sepVocales[i+1]==3) {
						silaba=partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1]+partes[posVocales[i]+2];
					}else if (sepVocales[i+1]==4) {
						silaba=partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1]+partes[posVocales[i]+2];
					}
				}else {
					silaba=partes[posVocales[i]-1]+partes[posVocales[i]];
							
				}
											
			}else if (sepVocales[i]==4) {
				if (i!=sepVocales.length-1) {
					if (sepVocales[i+1]==1) {
						silaba=partes[posVocales[i]-2]+partes[posVocales[i]-1]+partes[posVocales[i]];
					}else if (sepVocales[i+1]==2) {
						silaba=partes[posVocales[i]-2]+partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1];
					}else if (sepVocales[i+1]==3) {
						silaba=partes[posVocales[i]-2]+partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1]+partes[posVocales[i]+2];
					}else if (sepVocales[i+1]==4) {
						silaba=partes[posVocales[i]-2]+partes[posVocales[i]-1]+partes[posVocales[i]]+partes[posVocales[i]+1]+partes[posVocales[i]+2];
					}
				}else {
					silaba=partes[posVocales[i]-2]+partes[posVocales[i]-1]+partes[posVocales[i]];
							
				}
				
				
				
			}
			System.out.println("la silaba es "+silaba);			
		}
		
		return silaba;
	}////
	public static boolean validarConsonanticosyFonemas(String parte) {
		boolean con=false;
		if (parte.equals("pr")||parte.equals("pl")||parte.equals("br")||parte.equals("bl")||parte.equals("fr")||
				parte.equals("fl")||parte.equals("tr")||parte.equals("tl")||parte.equals("dr")||parte.equals("dl")||
				parte.equals("cr")||parte.equals("cl")||parte.equals("gr")||parte.equals("ch")||parte.equals("ll")||
				parte.equals("rr")) {
			con=true;
		}
		return con;
	}

}

