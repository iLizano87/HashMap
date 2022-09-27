package HashMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class HashMap1 {
	public static HashMap<String, String> diccionario = new HashMap<String, String>();

	public static void main(String[] args) {

		System.out.println("1>Castellano 2>English ");
		Scanner menu = new Scanner(System.in);
		int lang = menu.nextInt();
		while (lang != 1 && lang != 2) {
			System.err.println("1>Castellano 2>English");
			lang = menu.nextInt();
		}

		if (lang == 1) {
			diccionario = cargaDiccionarioEspIng(diccionario);
		} else if (lang == 2) {
			diccionario = cargaDiccionarioIngEsp(diccionario);
		}

		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion; // Guardaremos la opcion del usuario
		do {
			if (lang == 1) {
				menuEspanol();
			} else if (lang == 2) {
				menuEnglish();
			}
			try {
				System.out.println("Introduce una de las opciones");
				opcion = sn.nextInt();
				switch (opcion) {
				case 1:

					Scanner traduce = new Scanner(System.in);
					String palabra = traduce.nextLine();
					if (!diccionario.containsKey(palabra)) {
						System.out.println("ERROR");
						break;
					}
					System.out.println(diccionario.get(palabra));
					break;
				case 2:

					Scanner add = new Scanner(System.in);
					String palabra1 = add.nextLine();
					if (diccionario.containsKey(palabra1)) {
						System.out.println("ERROR");
						break;
					}
					if (lang == 1) {
						introTradEsp();
					} else if (lang == 2) {
						introTradEng();
					}
					String palabra2 = add.nextLine();
					diccionario.put(palabra1, palabra2);
					break;
				case 3:

					if (lang == 1) {
						introEsp();
					} else if (lang == 2) {
						introEng();
					}
					Scanner add2 = new Scanner(System.in);
					String palabraA = add2.nextLine();
					if (diccionario.containsKey(palabraA)) {
						if (lang == 1) {
							introTradEsp();
						} else if (lang == 2) {
							introTradEng();
						}
						String palabraB = add2.nextLine();
						diccionario.put(palabraA, palabraB);
						break;
					} else {
						if (lang == 1) {
							errorEspanol();
							break;
						} else if (lang == 2) {
							errorEnglish();
							break;
						}
					}
				case 4:
					for (String key : diccionario.keySet()) {
						System.out.println(key + " = " + diccionario.get(key));// keySet() se utiliza para recoger todas																				// las claves y crear un conjunto
					}
					Scanner eliminar = new Scanner(System.in);
					if (lang == 1) {
						introEsp();
					} else if (lang == 2) {
						introEng();
					}
					String seleccion = eliminar.nextLine();
					if (!diccionario.containsKey(seleccion)) {
						if (lang == 1) {
							errorEspanol();
							break;
						} else if (lang == 2) {
							errorEnglish();
							break;
						}
					}
					diccionario.remove(seleccion);
					break;
				case 5:

					if (lang == 1) {
						introEsp();
					} else if (lang == 2) {
						introEng();
					}
					Scanner buscar = new Scanner(System.in);
					String buscaPalabra = buscar.nextLine();
					for (String key : diccionario.keySet()) {
						if (key.toUpperCase().startsWith(buscaPalabra.toUpperCase())) {
							System.out.println(key + " = " + diccionario.get(key));
						}
					}
					break;
				case 6:
					int contador = 0;
					if (lang == 1) {
						pruebaESP();
					} else if (lang == 2) {
						pruebaING();
					}
					contador = contador + traducePrueba();
					contador = contador + traducePrueba();
					contador = contador + traducePrueba();
					contador = contador + traducePrueba();
					contador = contador + traducePrueba();
					System.out.println("TEST: " + contador + "/5");
					break;
				case 0:
					salir = true;
					break;
				default:
					if (lang == 1) {
						errorMenuEsp();
					} else if (lang == 2) {
						errorMenuEng();
					}
				}

			} catch (InputMismatchException e) {
				if (lang == 1) {
					errorExcEsp();
				} else if (lang == 2) {
					errorExcEng();
				}
				sn.next();
			}
		} while (!salir);

	}

	public static HashMap<String, String> cargaDiccionarioEspIng(HashMap<String, String> diccionario) {
		diccionario.put("Hola", "Hello");
		diccionario.put("Coche", "Car");
		diccionario.put("Ordenador", "Computer");
		diccionario.put("Boligrafo", "Pen");
		diccionario.put("Papel", "Paper");
		diccionario.put("Memoria", "Memory");
		diccionario.put("Luz", "Light");
		diccionario.put("Sonido", "Sound");
		diccionario.put("Telefono", "Phone");
		diccionario.put("Tijeras", "Scissors");
		diccionario.put("Tarjeta grafica", "Graphic Card");
		diccionario.put("Casa", "House");
		diccionario.put("Sol", "Sun");
		diccionario.put("Luna", "Moon");
		diccionario.put("Estrella", "Star");
		diccionario.put("Altavoz", "Speaker");
		diccionario.put("Microfono", "Microphone");
		diccionario.put("Camara web", "Webcam");
		diccionario.put("Ordenador portatil", "Laptop");
		diccionario.put("Consola", "Console");
		return diccionario;
	}

	public static HashMap<String, String> cargaDiccionarioIngEsp(HashMap<String, String> diccionario) {
		diccionario.put("Hello", "Hola");
		diccionario.put("Car", "Coche");
		diccionario.put("Computer", "Ordenador");
		diccionario.put("Pen", "Boligrafo");
		diccionario.put("Paper", "Papel");
		diccionario.put("Memory", "Memoria");
		diccionario.put("Light", "Luz");
		diccionario.put("Sound", "Sonido");
		diccionario.put("Phone", "Telefono");
		diccionario.put("Scissors", "Tijeras");
		diccionario.put("Graphic Card", "Tarjeta Grafica");
		diccionario.put("House", "Casa");
		diccionario.put("Sun", "Sol");
		diccionario.put("Moon", "Luna");
		diccionario.put("Star", "Estrella");
		diccionario.put("Speaker", "Altavoz");
		diccionario.put("Microphone", "Microfono");
		diccionario.put("Webcam", "Camara web");
		diccionario.put("Laptop", "Ordenador portatil");
		diccionario.put("Console", "Consola");
		return diccionario;
	}

	public static void menuEspanol() {
		System.out.println("1 - Traducir palabra");
		System.out.println("2 - Añadir palabra");
		System.out.println("3 - Modificar palabra");
		System.out.println("4 - Eliminar palabra");
		System.out.println("5 - Buscar palabra");
		System.out.println("6 - Examen");
		System.out.println("0 - SALIR");
	}

	public static void menuEnglish() {
		System.out.println("1 - Traduce word");
		System.out.println("2 - Add word");
		System.out.println("3 - Modify word");
		System.out.println("4 - Remove word");
		System.out.println("5 - Search word");
		System.out.println("6 - Exam");
		System.out.println("0 - EXIT");
	}

	public static void errorEspanol() {
		System.err.println("Esa palabra no se encuentra");
	}

	public static void errorEnglish() {
		System.err.println("Word not found");
	}

	public static void introEsp() {
		System.out.println("Introduce Palabra:");
	}

	public static void introEng() {
		System.out.println("Insert Word:");
	}

	public static void introTradEsp() {
		System.out.println("Introduce Traduccion:");
	}

	public static void introTradEng() {
		System.out.println("Insert Translate:");
	}

	public static void errorEspanol2() {
		System.err.println("Palabra existe en base de datos");
	}

	public static void errorEnglish2() {
		System.err.println("Word exists in database");
	}

	public static void errorMenuEsp() {
		System.err.println("Introduce numero del 1 al 5");
	}

	public static void errorMenuEng() {
		System.err.println("Insert number 1 to 5");
	}

	public static void errorExcEsp() {
		System.err.println("SOLO NUMEROS");
	}

	public static void errorExcEng() {
		System.err.println("ONLY NUMBERS");
	}

	public static void pruebaESP() {
		System.out.println("Traduce: ");
	}

	public static void pruebaING() {
		System.out.println("Translate: ");
	}

	public static int traducePrueba() {
		Set<String> keySet = diccionario.keySet();
		ArrayList<String> listaKeys = new ArrayList<String>(keySet);
		Collection<String> values = diccionario.values();
		ArrayList<String> listaValues = new ArrayList<String>(values);
		Scanner traduce1 = new Scanner(System.in);

		Random aleatorio = new Random();
		int id = aleatorio.nextInt(listaKeys.size());
		System.out.println(listaKeys.get(id));
		String palabra_1 = traduce1.nextLine();

		if (palabra_1.equals(listaValues.get(id))) {
			System.out.println("OK");
			listaKeys.remove(id);
			listaValues.remove(id);
			return 1;
		} else {
			System.out.println("ERROR");
			listaKeys.remove(id);
			listaValues.remove(id);
			return 0;
		}
	}
}
