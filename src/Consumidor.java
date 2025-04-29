public class Consumidor extends Thread{

    Lista lista;

    public Consumidor(Lista lista) {
        this.lista = lista;
    }

    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                final int valor;
                valor = lista.getOneLista();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(currentThread().getName() + " terminou");
    }
}
