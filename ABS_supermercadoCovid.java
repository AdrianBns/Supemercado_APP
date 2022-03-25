package beca_eoi2022;

import java.util.Scanner;

public class ABS_supermercadoCovid {

	static byte compras = 0;
	static String[] productos = new String[5];
	static int[] productosCantidad = new int[5];
	float[] precios;

	public static void main(String[] args) {

	
		
		tienda();
		
	

	}
	public static void tienda() {
		System.out.print("SUPERMERCADO COVID-19/20/21/22 \n" + "1.- Comprar producto (IVA Superreducido 4%) \n"
				+ "2.- Comprar producto (IVA Reducido 10%) \n" + "3.- Comprar producto (IVA Tipo General 21%) \n"
				+ "4.- Cobrar \n");

		Scanner sc = new Scanner(System.in);

		byte choose = sc.nextByte();

		switch (choose) {
		case 1:
			ivaSuperreducido();
			break;
		case 2:
			ivaReducido();
			break;
		case 3:
			tipoGeneral();
			break;
		case 4:
			pagar();
			break;
		}

	}

	public static void ivaSuperreducido() {

		boolean onoff = true;

		do {

			if (compras == 5) {

				System.out.print("No te puede llevá más ná pisha, paga ya arfavó. \n");
				pagar();

			}

			Scanner sc = new Scanner(System.in);

			System.out.print("¿Qué desea comprar?: \n" + "- Alimentos frescos \n" + "- Pan \n" + "- Medicamentos \n"
					+ "- Libros \n" + "- Periódicos \n" + "- Una VPO, junto a la fruta \n" + "\n" + "*Salir \n");

			String productChoose = sc.nextLine();

			if (productChoose == "Salir" || productChoose == "Sali" || productChoose == "salir") {

				onoff = false;
				
			} else {
				productos[compras] = productChoose;

				System.out.print("¿Qué cantidad?: \n");

				int productQuantity = sc.nextInt();

				productosCantidad[compras] = productQuantity;

				compras++;

				System.out.println("¡Añadido! \n");

				
			}

			
		} while (onoff = true);
		
		tienda ();

	}

	public static void ivaReducido() {

		boolean onoff = true;

		do {

			if (compras == 5) {

				System.out.print("No te puede llevá más ná pisha, paga ya arfavó. \n");
				pagar();

			}

			Scanner sc = new Scanner(System.in);

			System.out.print("¿Qué desea comprar?: \n" + "- Alimentos Elaborados \n" + "- Agua \n"
					+ "- Vivienda nueva, junto a la verdura \n" + "- Tickets transporte \n"
					+ "- Productos farmacéuticos \n" + "- Higiene íntima  \n" + "\n" + "*Salir \n");

			String productChoose = sc.nextLine();

			if (productChoose == "Salir" || productChoose == "Sali" || productChoose == "salir") {

				onoff = false;
			}

			productos[compras] = productChoose;

			System.out.print("¿Qué cantidad?: \n");

			int productQuantity = sc.nextInt();

			productosCantidad[compras] = productQuantity;

			compras++;

			System.out.println("¡Añadido! \n");

		} while (onoff = true);

	}

	public static void tipoGeneral() {

		boolean onoff = true;

		do {

			if (compras == 5) {

				System.out.print("No te puede llevá más ná pisha, paga ya arfavó. \n");
				pagar();

			}

			Scanner sc = new Scanner(System.in);

			System.out
					.print("¿Qué desea comprar?: \n" + "- Ropa \n" + "- Coches \n" + "- Contratar luz o gas natural \n"
							+ "- Entradas \n" + "- Telefonía \n " + "- Gasolina  \n" + "\n" + "*Salir \n");

			String productChoose = sc.nextLine();

			if (productChoose == "Salir" || productChoose == "Sali" || productChoose == "salir") {

				onoff = false;
			}

			productos[compras] = productChoose;

			System.out.print("¿Qué cantidad?: \n");

			int productQuantity = sc.nextInt();

			productosCantidad[compras] = productQuantity;

			compras++;

			System.out.println("¡Añadido! \n");

		} while (onoff = true);

	}

	public static void pagar() {

	}

}
