package entregas.astorecaHugo;

import java.util.Scanner;

class GestorTareas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tareas = new String[10];
        boolean[] completadas = new boolean[10];
        int numTareas = 0;

        System.out.println("Gestor de Tareas v1.0");

        String[] menu = {
            "Añadir tarea",
            "Marcar tarea",
            "Pendientes",
            "Estadísticas",
            "Salir"
        };
        while (true) {
            for (int i = 0; i < menu.length; i++) {
                System.out.println("[" + (i + 1) + "] " + menu[i]);
            }
            System.out.print("Opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                if (numTareas < 10) {
                    System.out.print("Descripcion de la nueva tarea: ");
                    tareas[numTareas] = sc.nextLine();
                    completadas[numTareas] = false;
                    numTareas++;
                    System.out.println("Tarea anadida correctamente.");
                } else {
                    System.out.println("ERROR: limite de tareas alcanzado.");
                }
            } else if (opcion == 2) {
                System.out.println("Tareas para Marcar");
                if (numTareas == 0) {
                    System.out.println("No hay tareas para marcar.");
                } else {
                    System.out.println("Tareas");
                    for (int i = 0; i < numTareas; i++) {
                        System.out.println((i + 1) + ". " + tareas[i] + " [" + (completadas[i] ? "Completada" : "Pendiente") + "]");
                    }
                    System.out.println("Número de tarea a marcar: ");
                    int num = sc.nextInt();
                    if (num >= 1 && num <= numTareas) {
                        if (!completadas[num - 1]) {
                            completadas[num - 1] = true;
                            System.out.println("Tarea marcada como completada.");
                        } else {
                            System.out.println("Esta tarea ya estaba completada.");
                        }
                    } else {
                        System.out.println("Numero de tarea invalido.");
                    }
                }
            } else if (opcion == 3) {
                System.out.println("Tareas Pendientes");
                boolean hayPendientes = false;
                for (int i = 0; i < numTareas; i++) {
                    if (!completadas[i]) {
                        System.out.println((i + 1) + ". " + tareas[i]);
                        hayPendientes = true;
                    }
                }
                if (!hayPendientes) {
                    System.out.println("No hay tareas pendientes");
                }
            } else if (opcion == 4) {
                System.out.println("Estadisticas");
                int contCompletadas = 0;
                for (int i = 0; i < numTareas; i++) {
                    if (completadas[i]) {
                        contCompletadas++;
                    }
                }
                System.out.println("Total de tareas: " + numTareas);
                System.out.println("Tareas completadas: " + contCompletadas);
                System.out.println("Tareas pendientes: " + (numTareas - contCompletadas));
                if (numTareas > 0) {
                    System.out.println("Porcentaje completado:" + (contCompletadas * 100 / numTareas) + "%");
                }
            } else if (opcion == 5) {
                System.out.println("Saliendo del gestor de tareas.");
                break;

            }
        }

        sc.close();
    }
}
