import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        traductor traductor = new traductor();
        Scanner teclado = new Scanner(System.in);
        
        String menu = "----------Traductor para Inglés, Español, Francés------------\n" + 
        "1. Palabras del tradcutor\n"+
        "2. Traducción\n"+
        "3. Salir\n";
        int opcion = 0;
        Archivo palabras = new Archivo("./Traducción.txt");
        Archivo oraciones = new Archivo("./PedidoDeTraducción.txt");
        ArrayList<String> pal = palabras.leerArchivo();
        ArrayList<String> ora = oraciones.leerArchivo();
        traductor.abrirArchivo(pal);

        while (opcion >= 0 && opcion < 3) {
            try {
                System.out.println(menu);
                opcion = teclado.nextInt();
                teclado.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("Seleccione uno de los siguientes idiomas que desea visualizar:\n");
                        System.out.println("1. Inglés\n2. Español\n3. Francés");
                        int segundo = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println(traductor.palabrasEnOrden(segundo));
                        break;

                    case 2: 
                        int Origen = traductor.Tipodeidioma(ora);
                        switch (Origen) {

                            case 1:
                                System.out.println("¿A que idioma desea traducir su oración?\n");
                                System.out.println("2. Español\n3. Francés");
                                int traduccion = teclado.nextInt();
                                teclado.nextLine();
                                System.out.println(traductor.traductor(ora, Origen, traduccion));
                                break;

                            case 2:
                            System.out.println("¿A que idioma desea traducir su oración?\n");
                            System.out.println("1. Inglés\n3. Francés");
                            int otra = teclado.nextInt();
                            teclado.nextLine();
                            System.out.println(traductor.traductor(ora, Origen, otra));
                            break;

                            case 3: 
                            System.out.println("¿A que idioma desea traducir su oración?\n");
                            System.out.println("1. Inglés\n2. Español");
                            int alg = teclado.nextInt();
                            teclado.nextLine();
                            System.out.println(traductor.traductor(ora, Origen, alg));
                            break;

                            default:
                                break;
                        }
                        break;

                    case 3:
                        System.out.println("Espero le hayamos sido de utilidad, tenga un buen día.");
                        break;
                    }
                } catch (Exception e) {
                    teclado.nextLine();
                    System.out.println("\nSeleccione una opción existente.");
                    System.out.println();
                }
            }
        }
    }

