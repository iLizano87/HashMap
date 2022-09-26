package HashMap;

import java.util.HashMap;

public class ejemploHashMap {


		// API: https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html
		public static void main(String[] args) {

			// Son pares clave-valor, en este caso la clave es un String y el valor es otro
			// String
			HashMap<String, String> mapa = new HashMap<String, String>();

			int tam = mapa.size();
			System.out.println(tam);

			// Se introducen los pares clave-valor (el valor puede estar duplicado, las
			// claves no)
			mapa.put("clave1", "valor1");
			mapa.put("clave2", "valor2");
			mapa.put("clave3", "valor3");

			tam = mapa.size();
			System.out.println(tam);

			String variable = "clave1";
			// Comprueba que existe o no un registro con la clave X
			if (mapa.containsKey(variable)) {
				System.out.println("Existe el registro con clave: " + variable);
			}

			if (mapa.containsValue(variable)) {
				System.out.println("Existe el registro con valor: " + variable);
			}

			String valor = mapa.get("clave1");
			System.out.println(valor);

			String dato = mapa.remove("clave1");
			System.out.println(mapa.size());

			mapa.clear();
			System.out.println(mapa.size());

		}

	}

