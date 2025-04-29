import java.util.ArrayList;

public class Lista {

    private int tamanho;
    private ArrayList<Integer> lista = new ArrayList<Integer>(tamanho);

    public Lista (int val){
        this.tamanho = val;
    }

    public synchronized boolean addLista(int valor) throws InterruptedException {
        if(lista.size() == tamanho) {
            System.out.println(Thread.currentThread().getName() + " Lista cheia");
            System.out.println(Thread.currentThread().getName() + " Aguardando vaga");
            while (lista.size() == tamanho) {
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
            System.out.println(Thread.currentThread().getName() + " Lista vazia");
            System.out.println(Thread.currentThread().getName() + " Aguardando produtor");
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
