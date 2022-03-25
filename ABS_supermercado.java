package beca_eoi2022;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ABS_supermercado {

	private static int numArticulos;
	private static ABS_producto[] carrito;
	private static double precioTotal;
	private static double precioConIVA;
	private static double precioTotalConIVA = precioTotal + precioConIVA;
	static Scanner sc = new Scanner(System.in);
	private static int opcion = 0;
	static DecimalFormat formato = new DecimalFormat("#.00");

	// en el constructor se define el tamaño del carro, se puede pedir en el main

	public ABS_supermercado(int tamañoMaximoCarro) {

		ABS_supermercado.carrito = new ABS_producto[tamañoMaximoCarro];
		ABS_supermercado.numArticulos = 0;
	}

	public static void abrirTienda() {

		do {
			System.out.print("\n SUPERMERCADO COVID-19/20/21/22 \n" + "1.- Comprar producto (IVA Superreducido 4%) \n"
					+ "2.- Comprar producto (IVA Reducido 10%) \n" + "3.- Comprar producto (IVA Tipo General 21%) \n"
					+ "4.- Pagar \n"
					+ "5.- Salir \n");

			System.out.println("Elige una opcion: ");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				ivaSuperreducido();
				break;
			case 2:
				ivaReducido();
				break;
			case 3:
				ivaGeneral();
				break;
			case 4:
				pagar();
				System.out.println("Gracias por su compra \n");
				break;

			}
			if (opcion == 5) {
				System.out.println("¡Hasta pronto!");
			}

		} while (opcion != 5);

	}

	private static void pagar() {

		System.out.print("Como desea pagar: \n");
		System.out.print("1-Tarjeta \n");
		System.out.print("2-Efectivo \n");

		boolean salir = false;

		do {

			int pago = sc.nextInt();
			switch (pago) {
			case 1:
				System.out.println("Gracias aqui tienes su ticket");
				System.out.println("Total de articulos : " + numArticulos);
				System.out.println("Precio total de la compra (sin IVA): " + formato.format(precioTotal) + " €");
				System.out.println("Total iva: " + formato.format(precioConIVA) + " €");
				System.out.println("----------------------------------------");
				System.out.println("Articulos : ");
				for (int i = 0; i < carrito.length; i++) {
					if (carrito[i] != null) {
						System.out.println(carrito[i].getCantidad() + " x " + carrito[i].getNombre() + " : "
								+ carrito[i].getPrecio() + " €");
					}

				}
				System.out.println("Precio total compra : " + formato.format(precioTotalConIVA));
				System.out.println("Metodo de pago : Tarjeta");
				salir = true;
				opcion = 3;
				break;
			case 2:
				System.out.println("Gracias aqui tienes su ticket");
				System.out.println("Total de articulos : " + numArticulos);
				System.out.println("Precio total de la compra (sin IVA) : " + formato.format(precioTotal) + " €");
				System.out.println("Total iva: " + formato.format(precioConIVA) + " €");
				System.out.println("----------------------------------------");
				System.out.println("Articulos : ");
				for (int i = 0; i < carrito.length; i++) {
					if (carrito[i] != null) {
						System.out.println(carrito[i].getCantidad() + " x " + carrito[i].getNombre() + " = "
								+ carrito[i].getPrecio() + " €");
					}
				}
				
				System.out.println("Precio total compra : " + formato.format(precioTotalConIVA));
				System.out.println("Metodo de pago : Efectivo");
				salir = true;
				opcion = 3;
				break;
			default:
				System.out.println("Selecione 1 o 2");

			}
		} while (!salir);

	}

	private static void ivaSuperreducido() {
		boolean salir = false;

		do {

			if (numArticulos >= carrito.length) {

				System.out.print("No se puede meter mas articulos en el carro \n");
				salir = true;
				pagar();

			}

			if (!salir) {
				System.out.print("¿Qué desea comprar?: \n" + "- Alimentos frescos \n" + "- Pan \n" + "- Medicamentos \n"
						+ "- Libros \n" + "- Periódicos \n" + "- Una VPO, junto a la fruta \n" + "\n" + "*Salir \n");
				sc.nextLine();
				String nombreArticulo = sc.nextLine();

				if (nombreArticulo.equalsIgnoreCase("salir") || nombreArticulo.equalsIgnoreCase("Salir")) {

					salir = true;

				} else {

					System.out.print("¿Qué cantidad?: ");

					int cantidadArticulo = sc.nextInt();

					System.out.print("Precio: ");

					float precioArticulo = sc.nextFloat();

					ABS_producto a = new ABS_producto(nombreArticulo, cantidadArticulo, precioArticulo);

					precioTotal = precioTotal + (a.getPrecio() * a.getCantidad());
					
					precioConIVA = precioConIVA + ((a.getPrecio() * a.getCantidad()) * 4 / 100);

					carrito[numArticulos] = a;

					numArticulos++;

					System.out.println("¡Añadido: " + nombreArticulo);
				}
			}
		} while (salir == false);

	}

	private static void ivaReducido() {
		boolean salir = false;

		do {

			if (numArticulos >= carrito.length) {

				System.out.print("No se puede meter mas articulos en el carro \n");
				salir = true;
				pagar();

			}

			if (!salir) {
				System.out.print("¿Qué desea comprar?: \n" + "- Alimentos Elaborados \n" + "- Agua \n"
						+ "- Vivienda nueva, junto a la verdura \n" + "- Tickets transporte \n"
						+ "- Productos farmacéuticos \n" + "- Higiene íntima  \n" + "\n" + "*Salir \n");
				sc.nextLine();
				String nombreArticulo = sc.nextLine();

				if (nombreArticulo.equalsIgnoreCase("salir") || nombreArticulo.equalsIgnoreCase("Salir")) {

					salir = true;

				} else {

					System.out.print("¿Qué cantidad?: ");

					int cantidadArticulo = sc.nextInt();

					System.out.print("Precio: ");

					float precioArticulo = sc.nextFloat();

					ABS_producto a = new ABS_producto(nombreArticulo, cantidadArticulo, precioArticulo);
					precioTotal = precioTotal + (a.getPrecio() * a.getCantidad());
					
					precioConIVA = precioConIVA + ((a.getPrecio() * a.getCantidad()) * 10 / 100);

					carrito[numArticulos] = a;

					numArticulos++;

					System.out.println("¡Añadido: " + nombreArticulo);
				}
			}
		} while (salir == false);

	}

	private static void ivaGeneral() {
		boolean salir = false;

		do {

			if (numArticulos >= carrito.length) {

				System.out.print("No se puede meter mas articulos en el carro \n");
				salir = true;
				pagar();

			}

			if (!salir) {
				System.out.print(
						"¿Qué desea comprar?: \n" + "- Ropa \n" + "- Coches \n" + "- Contratar luz o gas natural \n"
								+ "- Entradas \n" + "- Telefonía \n" + "- Gasolina  \n" + "\n" + "*Salir \n");
				sc.nextLine();
				String nombreArticulo = sc.nextLine();

				if (nombreArticulo.equalsIgnoreCase("salir") || nombreArticulo.equalsIgnoreCase("Salir")) {

					salir = true;

				} else {

					System.out.print("¿Qué cantidad?: ");

					int cantidadArticulo = sc.nextInt();

					System.out.print("Precio: ");

                    float precioArticulo = sc.nextFloat();

                    ABS_producto a = new ABS_producto(nombreArticulo, cantidadArticulo, precioArticulo);

					precioTotal = precioTotal + (a.getPrecio() * a.getCantidad());
					
					
					precioConIVA = precioConIVA + ((a.getPrecio() * a.getCantidad()) * 21 / 100);

					carrito[numArticulos] = a;

					numArticulos++;

					System.out.println("¡Añadido: " + nombreArticulo);
				}
			}
		} while (salir == false);

	}

}