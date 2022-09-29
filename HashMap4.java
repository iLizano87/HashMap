package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class HashMap4 {
	public static HashMap<String, String> lang = new HashMap<String, String>();
	public static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();

	public static void main(String[] args) {

		usuarios = users(usuarios);
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		System.out.println("ES para Español / EN for English");
		String idioma = sn.nextLine();
		if (idioma.equals("ES")) {
			lang = menuESP(lang);
		} else if (idioma.equals("EN")) {
			lang = menuENG(lang);
		} else {
			System.err.println("Introduce dato válido / Insert valid data");
		}
		do {
			Scanner sn1 = new Scanner(System.in);
			System.out.println("MENU");
			System.out.println(lang.get("InsName"));
			String nombre = sn1.nextLine();
			System.out.println(lang.get("Welc") + " " + nombre);
			System.out.println("1 - " + lang.get("Id"));
			System.out.println("2 - " + lang.get("Reg"));
			System.out.println("0 - " + lang.get("Exit"));
			int eleccion = sn1.nextInt();

			switch (eleccion) {
			case 1:
				Scanner id1 = new Scanner(System.in);
				System.out.println("1 - " + lang.get("Id"));
				System.out.println(lang.get("InsName"));
				String user1 = id1.nextLine();
				int contador1=usuarios.get(user1).getIntentos();
				
				if (usuarios.containsKey(user1) && usuarios.get(user1).getIntentos() <3) {
					System.out.println(lang.get("User") + " OK");
					System.out.println(lang.get("Pass"));
					String pass1 = id1.nextLine();																							
					if (!pass1.equals(usuarios.get(user1).getPass()) && usuarios.get(user1).getIntentos() <= 3) {
						contador1++;
						usuarios.get(user1).setIntentos(contador1);
						System.out.println(usuarios.get(user1).getIntentos() + " " + lang.get("Att"));
						System.out.println(lang.get("Err"));
						break;
					}
					System.out.println(lang.get("Entr"));
					usuarios.get(user1).setIntentos(0);
					break;
				} else {
					System.out.println(lang.get("Err"));
					break;
				}
			case 2:
				System.out.println("2 - " + lang.get("Reg"));
				Scanner intro1 = new Scanner(System.in);
				System.out.println(lang.get("InsName"));
				String nombre1 = intro1.nextLine();
				System.out.println(lang.get("Pass"));
				String pass1 = intro1.nextLine();
				Usuario Usuario1 = new Usuario(pass1, 0);
				usuarios.put(nombre1, Usuario1);
				break;
			case 0:
				System.out.println(lang.get("Exit"));
				salir = true;
			}
		} while (!salir);

	}

	public static HashMap<String, String> menuESP(HashMap<String, String> lang) {
		lang.put("Id", "Identificarse");
		lang.put("Reg", "Registrarse");
		lang.put("Welc", "Hola");
		lang.put("User", "Usuario");
		lang.put("InsName", "Inserta tu nombre: ");
		lang.put("lang", "Escoge lenguaje: ");
		lang.put("Pass", "Contraseña: ");
		lang.put("Err", "Lo siento, NO TIENE ACCESO PERMITIDO A AREA RESTRINGIDA");
		lang.put("Exit", "Salir");
		lang.put("NF", "Usuario no registrado");
		lang.put("Entr", "Acceso permitido a area restringida");
		lang.put("Att", "Intentos");
		return lang;
	}

	public static HashMap<String, String> menuENG(HashMap<String, String> lang) {
		lang.put("Id", "Identificarse");
		lang.put("Reg", "Registrarse");
		lang.put("Welc", "Hello");
		lang.put("User", "User");
		lang.put("InsName", "Insert your name: ");
		lang.put("lang", "Choose language: ");
		lang.put("Pass", "Password: ");
		lang.put("Err", "Sorry, YOU DON'T HAVE ACCESS TO ENTER TO RESTRICTED AREA");
		lang.put("Exit", "Exit");
		lang.put("NF", "User not registered");
		lang.put("Entr", "Access granted to restricted area");
		lang.put("Att", "Attempts");
		return lang;
	}

	public static HashMap<String, Usuario> users(HashMap<String, Usuario> usuarios) {
		usuarios.put("pepe", new Usuario("1111", 0));
		usuarios.put("juan", new Usuario("2222", 0));
		return usuarios;

	}

}
