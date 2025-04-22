public class Consumidor extends Thread{

    Lista lista;

    public Consumidor(Lista lista) {
        this.lista = lista;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                final int valor;
                valor = lista.getOneLista();
//                System.out.println(currentThread().getName() + " retirou valor: "+ valor + " da lista");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(currentThread().getName() + " terminou");
    }
}
