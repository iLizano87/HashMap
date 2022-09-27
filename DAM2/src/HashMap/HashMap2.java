package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class HashMap2 {
	public static HashMap<String, String> lang = new HashMap<String, String>();
	public static HashMap<String, String> usuarios = new HashMap<String, String>();

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
				int contador = 0;
				Scanner id = new Scanner(System.in);
				System.out.println("1 - " + lang.get("Id"));
				System.out.println(lang.get("InsName"));
				String user = id.nextLine();
				if (comprobarUser(user)) {
					System.out.println(lang.get("User") + " OK");
					System.out.println(lang.get("Pass"));
					String pass = id.nextLine();
					if (comprobarPass(user, pass)) {
						System.out.println(lang.get("Entr"));
						break;
					} else {
						contador = contador + 1;
						System.out.println(lang.get("Pass"));
						String pass2 = id.nextLine();
						if (comprobarPass(user, pass2)) {
							System.out.println(lang.get("Entr"));
							break;
						} else {
							contador = contador + 1;
							System.out.println(lang.get("Pass"));
							String pass3 = id.nextLine();
							if (comprobarPass(user, pass3)) {
								System.out.println(lang.get("Entr"));
								break;
							} else {
								contador = contador + 1;
								System.out.println(contador + " " + lang.get("Att"));
								System.out.println(lang.get("Err"));
							}
						}
						break;
					}
				} else {
					System.out.println(lang.get("NF"));
					break;
				}
			case 2:
				System.out.println("2 - " + lang.get("Reg"));
				Scanner intro1 = new Scanner(System.in);
				System.out.println(lang.get("InsName"));
				String nombre1 = intro1.nextLine();
				System.out.println(lang.get("Pass"));
				String pass1 = intro1.nextLine();
				usuarios.put(nombre1, pass1);
				break;
			case 3:
				int contador1 = 0;
				Scanner id1 = new Scanner(System.in);
				System.out.println("1 - " + lang.get("Id"));
				System.out.println(lang.get("InsName"));
				String user1 = id1.nextLine();
				if (comprobarUser(user1)) {
					System.out.println(lang.get("User") + " OK");
					System.out.println(lang.get("Pass"));
					String pass = id1.nextLine();
					while (!comprobarPass(user1, pass)) {
						contador1 = contador1 + 1;
						System.out.println(lang.get("Pass"));
						pass = id1.nextLine();
						if (contador1 == 2) {
							System.out.println("3 " + lang.get("Att"));
							System.out.println(lang.get("Err"));
							break;
						}						
					}
					System.out.println(lang.get("Entr"));
					break;
				}			
				else {
					System.out.println(lang.get("Err"));
					break;
				}
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

	public static HashMap<String, String> users(HashMap<String, String> usuarios) {
		usuarios.put("Pepe", "1111");
		usuarios.put("Ivan", "2222");
		usuarios.put("Antonio", "abcd");
		usuarios.put("Maria", "AEIOU");
		usuarios.put("Violeta", "qwerty");
		return usuarios;

	}

	public static boolean comprobarUser(String user) {
		return usuarios.containsKey(user);
	}

	public static boolean comprobarPass(String user, String pass) {
		return pass.equals(usuarios.get(user));
	}

}
