package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SopaDeLetras {

	private int n;
	private char[][] matriz;
	
	
	
	public SopaDeLetras(int n) throws IllegalArgumentException {
		super();
		if (n <= 0) {
            throw new IllegalArgumentException("El tamaño debe de ser mayor que cero");
        }
		this.n = n;
		this.matriz = new char[n][n];
		 inicializarMatriz();
    }

    private void inicializarMatriz() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = '*';
            }
        }
    }
    
    public void colocarPalabraHorizontal(String palabra, Coordenada coordenada) throws IllegalArgumentException {
    	if(palabra.length()+coordenada.getColumna()>this.n) {
    		throw new IllegalArgumentException("La palabra es demasiado grande para caber en la sopa de letras");
    	}
    	if(coordenada.getColumna()<0 || coordenada.getFila()<0) {
    		throw new IllegalArgumentException("las coordenadas deben ser mayores que 0");
    	}
    	if(coordenada.getColumna()>n || coordenada.getFila()>n) {
    		throw new IllegalArgumentException("las coordenadas son mayores que la matriz");
    	}
    	for (int i = 0; i < palabra.length(); i++) {
            matriz[coordenada.getFila()][coordenada.getColumna() + i] = palabra.charAt(i);
        }
    }
    public void colocarPalabraVertical(String palabra, Coordenada coordenada) throws IllegalArgumentException {
    	if(palabra.length()+coordenada.getFila()>this.n) {
    		throw new IllegalArgumentException("La palabra es demasiado grande para caber en la sopa de letras");
    	}
    	if(coordenada.getFila()<0 || coordenada.getColumna()<0) {
    		throw new IllegalArgumentException("las coordenadas deben ser mayores que 0");
    	}
    	if(coordenada.getFila()>n || coordenada.getColumna()>n) {
    		throw new IllegalArgumentException("las coordenadas son mayores que la matriz");
    	}
    	for (int i = 0; i < palabra.length(); i++) {
            matriz[coordenada.getFila()+i][coordenada.getColumna()] = palabra.charAt(i);
        }
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matriz[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    
    
	 public Map<Character, Integer> mostrarResumenDeLetras() {
	        Map<Character, Integer> repeticionLetras = new HashMap<>();
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                char letra = matriz[i][j];
	                if (letra != '*') {
	                    repeticionLetras.put(letra, repeticionLetras.getOrDefault(letra, 0) + 1);
	                }
	            }
	        }
	        return repeticionLetras;
	    }
	 
	 public void enviarDatosAFichero() throws IOException {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("partida.txt"))) {
	            for (int i = 0; i < n; i++) {
	                for (int j = 0; j < n; j++) {
	                    writer.write(matriz[i][j]);
	                    if (j < n - 1) writer.write(" ");
	                }
	                writer.newLine();
	            }
	        }
	    }

	    public void cargarDatosDeFichero() throws IOException {
	        try (BufferedReader reader = new BufferedReader(new FileReader("partida.txt"))) {
	            String linea;
	            int fila = 0;
	            while ((linea = reader.readLine()) != null && fila < n) {
	                String[] letras = linea.split(" ");
	                for (int j = 0; j < letras.length; j++) {
	                    matriz[fila][j] = letras[j].charAt(0);
	                }
	                fila++;
	            }
	        }
	    }
	 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        SopaDeLetras sopa = null;
        String mensaje="Primero se debe crear la sopa de letras";

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Crear sopa de letras");
            System.out.println("2. Colocar palabra en horizontal");
            System.out.println("3. Colocar palabra en vertical");
            System.out.println("4. Mostrar sopa de letras");
            System.out.println("5. Mostrar resumen de letras");
            System.out.println("6. Guardar sopa de letras en archivo");
            System.out.println("7. Cargar sopa de letras desde archivo");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el tamaño de la sopa de letras ");
                    int n = sc.nextInt();
                    try {
                        sopa = new SopaDeLetras(n);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    if (sopa != null) {
                        System.out.println("Ingrese la palabra a colocar");
                        String palabra = sc.next();
                        System.out.println("¿En que fila debe estar la palabra?");
                        int fila = sc.nextInt();
                        System.out.println("¿En que columna debe empezar la palabra?");
                        int columna = sc.nextInt();
                        try {
                            sopa.colocarPalabraHorizontal(palabra, new Coordenada(fila, columna));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println(mensaje);
                    }
                    break;

                case 3:
                    if (sopa != null) {
                        System.out.println("Ingrese la palabra a colocar: ");
                        String palabra = sc.next();
                        System.out.println("¿En que fila debe empezar la palabra?");
                        int fila = sc.nextInt();
                        System.out.println("¿En que columna debe estar la palabra?");
                        int columna = sc.nextInt();
                        try {
                            sopa.colocarPalabraVertical(palabra, new Coordenada(fila, columna));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println(mensaje);
                    }
                    break;

                case 4:
                    if (sopa != null) {
                        System.out.println(sopa);
                    } else {
                        System.out.println(mensaje);
                    }
                    break;

                case 5:
                    if (sopa != null) {
                        Map<Character, Integer> resumen = sopa.mostrarResumenDeLetras();
                        System.out.println(resumen);
                    } else {
                        System.out.println(mensaje);
                    }
                    break;

                case 6:
                    if (sopa != null) {
                        try {
                            sopa.enviarDatosAFichero();
                            System.out.println("Sopa de letras guardada en archivo.");
                        } catch (IOException e) {
                            System.out.println("Error al guardar en archivo: " + e.getMessage());
                        }
                    } else {
                        System.out.println(mensaje);
                    }
                    break;

                case 7:
                    if (sopa != null) {
                        try {
                            sopa.cargarDatosDeFichero();
                            System.out.println("Sopa de letras cargada desde archivo.");
                        } catch (IOException e) {
                            System.out.println("Error al cargar desde archivo: " + e.getMessage());
                        }
                    } else {
                        System.out.println(mensaje);
                    }
                    break;

                case 0:
                    System.out.println("Game over");
                    sc.close();
                    return;

                default:
                    System.out.println("Seleccione una de las opciones anteriores");
            }
        }
    }
}
