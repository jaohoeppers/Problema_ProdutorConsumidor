import java.util.ArrayList;

public class Lista {

    private ArrayList<Integer> lista = new ArrayList<Integer>(10);

    public synchronized boolean addLista(int valor) throws InterruptedException {
        if(lista.size() == 10) {
            System.out.println("Lista cheia");
            System.out.println("Aguardando vaga");
            while (lista.size() == 10) {
                this.wait();
            }
        }
        int tamanhoAntes = lista.size();

        final boolean res = lista.add(valor);

        int tamanhoDepois = lista.size();

        System.out.println(Thread.currentThread().getName() +
                " adicionou " + valor +
                " - Tamanho anterior: " + tamanhoAntes +
                " - Tamanho atual: " + tamanhoDepois);

        this.notifyAll();
        return res;
    }

    public synchronized int getOneLista() throws InterruptedException {
        if(lista.isEmpty()) {
            System.out.println("Lista vazia");
            System.out.println("Aguardando produtor");
            while (lista.isEmpty()) {
                this.wait();
            }
        }

        int tamanhoAntes = lista.size();

        final int val = lista.removeFirst();

        int tamanhoDepois = lista.size();

        System.out.println(Thread.currentThread().getName() +
                " removeu " + val +
                " - Tamanho anterior: " + tamanhoAntes +
                " - Tamanho atual: " + tamanhoDepois);

        this.notifyAll();
        return val;
    }






}
