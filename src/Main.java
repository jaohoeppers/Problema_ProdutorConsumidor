//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Lista lista = new Lista();

        Produtor produtor1 = new Produtor(lista);
        produtor1.setName("Produtor 1");
        Consumidor consumidor1 = new Consumidor(lista);
        consumidor1.setName("Consumidor 1");

        Produtor produtor2 = new Produtor(lista);
        produtor2.setName("Produtor 2");
        Consumidor consumidor2 = new Consumidor(lista);
        consumidor2.setName("Consumidor 2");

        produtor1.start();
        consumidor1.start();
        produtor2.start();
//        consumidor2.start();

    }
}