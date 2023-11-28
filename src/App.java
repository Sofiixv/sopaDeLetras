import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    static String[][] sopa = {
            { "A", "E", "Y", "I", "V", "Y", "S", "A", "U", "R", "C", "W", "N", "M", "N", "N", "I", "H" },
            { "X", "H", "C", "N", "B", "X", "D", "D", "W", "M", "A", "H", "H", "D", "U", "R", "B", "J" },
            { "J", "K", "X", "I", "G", "E", "Z", "B", "Y", "K", "K", "O", "R", "E", "V", "K", "C", "V" },
            { "S", "O", "A", "V", "O", "J", "L", "U", "G", "L", "C", "O", "Q", "F", "W", "W", "T", "Y" },
            { "Q", "F", "L", "E", "L", "N", "F", "L", "D", "R", "Q", "R", "Y", "I", "W", "R", "K", "Q" },
            { "D", "F", "D", "N", "B", "H", "O", "B", "S", "C", "I", "T", "O", "I", "G", "E", "B", "O" },
            { "W", "I", "D", "U", "A", "Z", "O", "A", "M", "P", "I", "M", "B", "B", "C", "H", "Y", "B" },
            { "M", "N", "X", "S", "T", "Z", "U", "S", "Q", "J", "R", "U", "E", "A", "A", "Q", "C", "Z" },
            { "J", "G", "N", "A", "N", "O", "D", "A", "O", "F", "D", "O", "F", "R", "U", "T", "Y", "V" },
            { "X", "H", "T", "U", "G", "A", "R", "U", "J", "H", "P", "N", "U", "G", "R", "H", "E", "C" },
            { "C", "Z", "X", "R", "Q", "E", "B", "R", "Z", "U", "B", "A", "T", "T", "R", "J", "Z", "K" },
            { "J", "S", "H", "Z", "U", "Y", "U", "D", "Z", "C", "D", "W", "R", "P", "L", "K", "Y", "B" } };

    static String[] palabras = { "BELLSPROUT", "BULBASAUR", "CROBAT", "GOLBAT", "GRIMER", "IVYSAUR", "KOFFING", "MUK",
            "VENUSAUR", "ZUBAT" };

    // colores
    static String green = "\033[32m";
    static String red = "\033[31m";
    static String yellow = "\033[33m";
    static String cyan = "\033[36m";
    static String purple = "\033[35m";
    static String white = "\033[37m";

    public static void main(String[] args) throws Exception {
        int eleccion = menuPalabra();
        recorrerVertical(eleccion);

    }

    public static int menuPalabra() {
        int palabraElegida = 0;
        System.out.println("Selecciona una palabra de la lista");
        for (int i = 0; i < palabras.length; i++) {
            System.out.print(i + 1 + " ");
            System.out.println(palabras[i]);
        }
        System.out.print("Palabra: ");
        palabraElegida = sc.nextInt();
        palabraElegida = palabraElegida - 1;
        System.out.println(palabras[palabraElegida]);
        return palabraElegida;
    }

    public static void recorrerVertical(int palabraElegida) {
        String palabraEleccion = palabras[palabraElegida];
        boolean palabraEncontrada = false;
        boolean palabraMostrada = false;
        String palabraConcatencada = "";
        int contadorPalabra = 0;

        String primeraLetra = String.valueOf(palabraEleccion.charAt(0));
        System.out.println(primeraLetra);

        for (int i = 0; i < sopa.length; i++) { // estas son las filas
            System.out.println("");
            for (int K = 0; K < 18; K++) { // estas son las columnas
               if (18-K >= palabraEleccion.length()) {
                
                    if (!palabraMostrada) {
                        if (primeraLetra.equals(sopa[i][K])) {
                            for (int j = K; contadorPalabra < palabraEleccion.length(); j++) { // mirar si la j tiene que
                                                                                            // empezar en 0 o en 1
                                contadorPalabra++;
                                palabraConcatencada += sopa[i][j];
                            }
                            // System.out.println(palabraConcatencada);
                            contadorPalabra = 0;
                            if (palabraConcatencada.equals(palabraEleccion)) {
                                palabraEncontrada = true;
                                if (palabraEncontrada) {
                                    for (int l = K; contadorPalabra < palabraConcatencada.length(); l++) {
                                        contadorPalabra++;
                                        System.out.print(red + sopa[i][l] + " ");
                                        K++;
                                    }
                                    // K+=palabraConcatencada.length();
                                    palabraMostrada = true;
                                }
                            } else {
                                palabraConcatencada = "";
                            }

                        }

                    }
                } 



                System.out.print(white + sopa[i][K] + " ");

            }

        }
    }

}
