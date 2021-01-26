import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Radio radio = new Radio();
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenidos");
        int opcion = 0;
        radio.onOff();

        while(opcion != 1) {
            boolean validar_opcion = false;

            while(validar_opcion == false) {
                /*
                * Presentamos el menú        
                */
                System.out.println("Seleccione una opcion: \n1. Encender/Apagar\n2. Cambiar Frecuencia\n3. Cambiar Emisora\n4. Guardar Emisora\n5. Seleccionar emisora guardada");
                    try {
                        /*
                        * Opetenemos la opción.
                        */
                        opcion = Integer.parseInt(sc.next());
                        if(opcion < 6 && opcion > 0)
                            validar_opcion = true;
                        else
                            System.out.println("Ingrese una opción válida\n");
                    } catch(Exception e) {
                        System.out.println("Ingrese un número válido\n");
                    }
            }

            validar_opcion = false;

            if(opcion == 1) {
                radio.onOff();
                /*
                * Salimos del sistema
                */
                System.out.println("Gracias, vuelva pronto.");
                System.out.println("-----------------------------------------------------------------");
                System.exit(0);
            } else if(opcion == 2) {
                System.out.println(radio.changeFrecuency());   
            } else if (opcion == 3) {
                int opcion1 = 0;
                while(validar_opcion == false) {
                    /*
                    * Presentamos el menú        
                    */
                    System.out.println("Seleccione una opcion: \n1. Adelantar\n2. Retroceder");
                        try {
                            /*
                            * Opetenemos la opción.
                            */
                            opcion1 = Integer.parseInt(sc.next());
                            if(opcion1 < 3 && opcion1 > 0)
                                validar_opcion = true;
                            else
                                System.out.println("Ingrese una opción válida\n");
                        } catch(Exception e) {
                            System.out.println("Ingrese un número válido\n");
                        }
                }

                System.out.println(radio.moveDial(opcion1));

            } else if (opcion == 4) {
                int opcion2 = 0;
                while(validar_opcion == false) {
                    /*
                    * Presentamos el menú        
                    */
                    System.out.println("Seleccione una opcion del 1 al 12: ");
                        try {
                            /*
                            * Opetenemos la opción.
                            */
                            opcion2 = Integer.parseInt(sc.next());
                            if(opcion2 < 13 && opcion2 > 0)
                                validar_opcion = true;
                            else
                                System.out.println("Ingrese una opción válida\n");
                        } catch(Exception e) {
                            System.out.println("Ingrese un número válido\n");
                        }
                }

                System.out.println(radio.saveStation(opcion2 - 1));
            } else if (opcion == 5) {
                int opcion3 = 0;
                while(validar_opcion == false) {
                    /*
                    * Presentamos el menú        
                    */
                    System.out.println(radio.checkFavs());
                    System.out.println("Seleccione una opcion del 1 al 12: ");
                        try {
                            /*
                            * Opetenemos la opción.
                            */
                            opcion3 = Integer.parseInt(sc.next());
                            if(opcion3 < 13 && opcion3 > 0)
                                validar_opcion = true;
                            else
                                System.out.println("Ingrese una opción válida\n");
                        } catch(Exception e) {
                            System.out.println("Ingrese un número válido\n");
                        }
                }

                System.out.println(radio.selectStation(opcion3 - 1));
            }

        }

    }

}