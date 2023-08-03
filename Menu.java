package grafos;
import java.util.List;
import java.util.Scanner;
public class Menu {
    int contV= 0; 
    String nombre;
    //--------------------------------------------------------
    //Método de la clase Menu, que me permite ejecutar el menú de opciones para 
    //usar sus operaciones básicas
    //--------------------------------------------------------
    public void menu(GrafoMatriz grafo) {
        Scanner leer = new Scanner(System.in);
        menuInfo();
        int opcion = leer.nextInt();
        leer.nextLine();
        switch (opcion) {
            case 1:
                System.out.println("------------------------------------------------");
                System.out.println("          Creacion de vertices (nodos)");
                System.out.println("------------------------------------------------");
                System.out.println("Ingrese cuantos vertices va a crear:");
                int nVertices = leer.nextInt();
                leer.nextLine(); // Consumimos el salto de línea después de leer el entero.
                int totalVertices = nVertices + contV;
                if (nVertices < 1) {
                    System.out.println("Lo sentimos no puede ingresar un numero negativo:");                    
                } else {
                    if (totalVertices > 20) {
                        System.out.println("Lo sentimos, la cantidad que usted ingresa sobrepasa los vertices totales permitidos");                       
                    } else {
                        for (int i = 0; i < nVertices; i++) {
                            System.out.println("------------------------------------------------");
                            System.out.println("            Creacion del grafo numero ");
                            System.out.println("------------------------------------------------");
                            System.out.println("Ingrese el nombre de referencia para el vertice:");
                            nombre = leer.nextLine();
                            grafo.nuevoVertice(nombre.trim());
                            System.out.println("-----------------Se creo correctamente-----------");
                            contV = contV + 1;
                        }                        
                    }
                }
                menu(grafo);
                break;
            case 2:
                System.out.println("------------------------------------------------");
                System.out.println("            Conectar vertices ");
                System.out.println("------------------------------------------------");
                System.out.println("Ingrese el nombre del vertice a conectar:");
                String vertice1 = leer.nextLine();
                System.out.println("Ingrese el nombre del vertice a conectar con " + vertice1);
                String vertice2 = leer.nextLine();
                try {
                    grafo.nuevoArco(vertice1, vertice2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                menu(grafo);
                break;
            case 3:
                System.out.println("------------------------------------------------");
                System.out.println("      Ver si un vertice es adyacente con otro");
                System.out.println("------------------------------------------------");
                System.out.println("Ingrese el nombre del vertice a verificar:");
                String vertice = leer.nextLine();
                System.out.println("Ingrese el nombre del vertice a verificar con:" + vertice);
                String verticeVerificar = leer.nextLine();
                try {
                    System.out.println(grafo.adyacente(vertice, verticeVerificar));                  
                } catch (Exception e) {
                    e.printStackTrace();
                }
                menu(grafo);
                break;
            case 4:
                System.out.println("------------------------------------------------");
                System.out.println("     Mostrar las adyacencias de un vertice");
                System.out.println("------------------------------------------------");
                System.out.println("Ingrese el nombre del vertice a buscar sus adyacencias:");
                String verticeBuscar = leer.nextLine();
                try {
                    List<Vertice> nodosConectadosA = grafo.nodosConectados(verticeBuscar);
                    System.out.println("Nodos conectados a ("+verticeBuscar+")");
                    for (Vertice v : nodosConectadosA) {
                        System.out.println(v.nomVertice());
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
                menu(grafo);
            	break;
            case 5:
            	System.out.println("------------------------------------------------");
                System.out.println("  		Recorrer el grafo por Anchura			");
                System.out.println("------------------------------------------------");
                System.out.println("Ingrese el nombre del vertice para empezar el recorrido: ");
                String inicio = leer.nextLine();
                try {
                		grafo.recorAnchur(inicio);
                	System.out.println("------------------------------------------------");
                }catch(Exception e) {
                	e.printStackTrace();
                }
                menu(grafo);
            	break;
            case 6:
            	System.out.println("------------------------------------------------");
                System.out.println("  		Recorrer el grafo por Profundidad		");
                System.out.println("------------------------------------------------");
                System.out.println("Ingrese el nombre del vertice para empezar el recorrido: ");
                String verticeInicioDFS = leer.nextLine();
                try {
                    grafo.recorProf(verticeInicioDFS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                menu(grafo);
            	break;
            case 7:
                System.out.println("------------------------------------------------");
                System.out.println("           Muchas gracias por su visita");
                System.out.println("------------------------------------------------");
            	break;
        }
    }
    public void menuInfo () {
        System.out.println("------------------------------------------------");
        System.out.println("            Menu principal de grafos");
        System.out.println("------------------------------------------------");
        System.out.println("Ingrese 1 Ingresar nodos nuevos ( Max 20 )");
        System.out.println("Ingrese 2 Conectar 2 vertices");
        System.out.println("Ingrese 3 Ver si un vertice es adyacente con otro");
        System.out.println("Ingrese 4 Mostrar las adyacencias de un vertice");        
        System.out.println("Ingrese 5 Recorrido en Anchura");
        System.out.println("Ingrese 6 Recorrido en Profundidad");
        System.out.println("Ingrese 7 Salir");
        System.out.println("------------------------------------------------");
    }
}
