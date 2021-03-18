
import java.util.Scanner;
import ListaDoble.*;
import java.util.Iterator;

public class Parcial {

    static int mx = 0, my = 0, ex = 0, ey = 0;
    static DoubleList caminoDis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del mapa, FilasxColumnas, en forma de N M: ");
        int c = sc.nextInt();
        int m = sc.nextInt();

        DoubleList mapa = tomarDatos(c, m);
        caminoDis = caminoDisponible(mapa);

        String respuesta = "[" + String.valueOf(my) + "," + String.valueOf(mx) + "]";

        int mxA = mx;
        int myA = my;

        while (mxA != ex && myA != ey) {

            if (mover(mxA, myA + 1)) { //Mover hacia arriba
                myA = myA + 1;
                respuesta += "[" + String.valueOf(myA) + "," + String.valueOf(mxA) + "]";

            } else if (mover(mxA, myA - 1)) { //Mover hacia abajo
                myA = myA - 1;
                respuesta += "[" + String.valueOf(myA) + "," + String.valueOf(mxA) + "]";

            } else if (mover(mxA + 1, myA)) { //Mover hacia la derecha
                mxA = mxA + 1;
                respuesta += "[" + String.valueOf(myA) + "," + String.valueOf(mxA) + "]";

            } else if (mover(mxA - 1, myA)) { //Mover hacia la izquierda
                mxA = mxA - 1;
                respuesta += "[" + String.valueOf(myA) + "," + String.valueOf(mxA) + "]";
            } else {
                mxA = mx;
                myA = my;
                respuesta = "";
            }
        }
        respuesta += "[" + String.valueOf(ey) + "," + String.valueOf(ex) + "]";

        System.out.println(respuesta);

    }

    public static boolean mover(int x, int y) { //Mover a m.
        for (ListNodeDouble b : caminoDis) {
            int[] c = (int[]) b.getObject();
            if ((c[0] == y) && (c[1] == x)) {
                caminoDis.remove(b);
                return true;
            }
        }
        return false;
    }

    public static DoubleList caminoDisponible(DoubleList mapa) { //Retorna una DoubleList cuyo objetos son int[2] que contienen la posición y,x de cada 0, incluyendo m y e.
        Iterator<ListNodeDouble> iterador = mapa.iterator();
        ListNodeDouble a;
        DoubleList cam = new DoubleList();
        int f = 0, col = 0;

        while ((a = iterador.next()) != null) {
            DoubleList b = (DoubleList) a.getObject();
            Iterator<ListNodeDouble> i = b.iterator();
            ListNodeDouble c;
            col = 0;
            while ((c = i.next()) != null) {
                if (c.getObject().equals("0")) {
                    int[] pos = new int[2];
                    pos[0] = f;
                    pos[1] = col;
                    cam.add(pos);
                }
                col++;
            }
            f++;
        }

        return cam;
    }

    public static DoubleList tomarDatos(int c, int m) { //Toma desde el teclado N M y el mapa y retorna una DoubleList con el mapa. 
        Scanner sc = new Scanner(System.in);          //Cada objecto es otra DoubleList que contiene los elementos de las filas.
        DoubleList mapa = new DoubleList();

        System.out.println("Ingrese el mapa: ");

        for (int i = 0; i < c; i++) {
            DoubleList filas = new DoubleList();
            for (int j = 0; j < m; j++) {
                String dato = sc.next();
                switch (dato) {
                    case "m":
                        filas.add("0");
                        my = i;
                        mx = j;
                        break;
                    case "e":
                        filas.add("0");
                        ey = i;
                        ex = j;
                        break;
                    default:
                        filas.add(dato);
                        break;
                }
            }
            mapa.add(filas);
        }
        return mapa;
    }

}
