import java.io.*;
import java.util.Scanner;

/**
 * 1.-  Crear un menú con las siguientes opciones
 * 1. Crear un fichero texto (con el nombre que tú quieras) en el que indiques en cada línea separados por un espacio: (para esto podrás pedir por teclado)
 * Tu Nombre.
 * Tu Edad.
 * Tu Ciudad de Nacimiento.
 * 2. Mostrar por pantalla el contenido del fichero de texto creado.
 * 3. Salir del Programa.
 */

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner entrada = new Scanner(System.in);
        boolean seguir = true;
        int opcion = 0;

        System.out.println("*****************************************************************");
        System.out.println("** Menú de Opciones.                                           **");
        System.out.println("** Opción 1: Crear Fichero de Datoss Personales.               **");
        System.out.println("** Opción 2: Mostrar por Pantalla el Contenido del Fichero.    **");
        System.out.println("** Opción 3 Salir del Programa.                                **");
        System.out.println("*****************************************************************");

        while (seguir) {
            System.out.print("Ingrese una Opción: ");
            opcion = entrada.nextInt();
            if (opcion == 1) {
                System.out.print("Ingrese Nombre: ");
                String nombre = entrada.next();
                System.out.print("Ingrese Edad: ");
                String edad = entrada.next();
                System.out.print("Ingresa la Ciudad de Nacimiento: ");
                String ciudadNacimiento = entrada.next();
                String datosPersonales = nombre + " " + edad + " " + ciudadNacimiento + "\n";

                File archivo = new File("datos.txt");
                try {
                    BufferedWriter br = new BufferedWriter(new FileWriter(archivo, true));
                    br.write(datosPersonales);
                    br.close();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


            } else if (opcion == 2) {

                File archivo = new File("datos.txt");
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String dato = br.readLine();

                while (dato != null) {
                    System.out.println(dato);
                    dato = br.readLine();
                }
                br.close();

            } else if (opcion == 3) {
                System.out.println("Programa Finalizado!");
                seguir = false;
            } else {
                System.out.println("Opción Inválida!");
            }

        }


    }
}