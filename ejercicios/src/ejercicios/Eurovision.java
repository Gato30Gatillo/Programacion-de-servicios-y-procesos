package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Eurovision {

	private static final List<String> PAISES_PARTICIPANTES = Arrays.asList("Serbia", "Moldavia", "Hungría", "Ucrania",
			"Suecia", "Australia", "Noruega", "Dinamarca", "Eslovenia", "Holanda", "Albania", "República Checa",
			"Lituania", "Israel", "Estonia", "Bulgaria", "Austria", "Finlandia", "Irlanda", "Chipre", "Alemania",
			"Francia", "Italia", "España", "Reino Unido", "Portugal", "Armenia", "Azerbaiyán", "Bélgica", "Bosnia",
			"Croacia", "Georgia", "Grecia", "Islandia", "Letonia", "Malta", "Polonia", "Rumania", "Rusia", "San Marino",
			"Suiza", "Turquía", "Macedonia", "Montenegro");

	private static final List<String> PAISES_FINALISTAS = Arrays.asList("Rumania", "Moldavia", "Australia", "Rusia",
			"Hungría", "Polonia", "Georgia", "Macedonia", "Noruega", "Armenia", "Albania", "República Checa",
			"Bulgaria", "Alemania", "Estonia", "Malta", "Austria", "Finlandia", "Irlanda", "Israel", "Lituania",
			"Francia", "Italia", "España", "Reino Unido", "Portugal");

	private static final List<Integer> PUNTOS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 10, 12);

	
	public static void main(String[] args) {

		Random random = new Random();

		Map<String, Integer> puntuaciones = new HashMap<>();
		
        for (String pais : PAISES_FINALISTAS) {
            puntuaciones.put(pais, 0);
        }
		
		for (String paisVotante : PAISES_PARTICIPANTES) {
			Set<String> paisesVotados = new HashSet<>();

			while (paisesVotados.size() < 10) {
				String paisSeleccionado = PAISES_FINALISTAS.get(random.nextInt(PAISES_FINALISTAS.size()));
				if (!paisSeleccionado.equals(paisVotante) && !paisesVotados.contains(paisSeleccionado)) {
					paisesVotados.add(paisSeleccionado);
				}
			}

			int index = 0;

			for (String paisVotado : paisesVotados) {
				int puntosActuales = puntuaciones.get(paisVotado);
				puntuaciones.put(paisVotado, puntosActuales + PUNTOS.get(index));
				index++;
			}
		}

		List<String> finalistasOrdenados = new ArrayList<>(PAISES_FINALISTAS);
		Collections.sort(finalistasOrdenados);

		System.out.println("Resultados ordenados alfabeticamente ");
		for (String pais : finalistasOrdenados) {
			System.out.println(pais + " con " + puntuaciones.get(pais) + " puntos");
		}

		String paisMax = Collections.max(puntuaciones.entrySet(), Map.Entry.comparingByValue()).getKey();
		int maxPuntuacion = puntuaciones.get(paisMax);

		String paisMin = Collections.min(puntuaciones.entrySet(), Map.Entry.comparingByValue()).getKey();
		int minPuntuacion = puntuaciones.get(paisMin);

		System.out.println("Pais con la mayor puntuacion: " + paisMax + " con " + maxPuntuacion + " puntos");

		System.out.println("Pais con la menor puntuación: " + paisMin + " con " + minPuntuacion + " puntos");

	}

}
