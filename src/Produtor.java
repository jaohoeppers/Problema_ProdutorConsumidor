import java.util.ArrayList;

public class Produtor extends Thread {

    Lista lista;

    public Produtor(Lista lista) {
        this.lista = lista;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
//            System.out.println(currentThread().getName() + " adicionando " + i + " na lista");
            try {
                lista.addLista(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(currentThread().getName() + " terminou");
    }

}
