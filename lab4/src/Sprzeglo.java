public class Sprzeglo extends Komponent {

    private boolean stanSprzegla;

    public void wcisnij() { stanSprzegla = true; }

    public void zwolnij(){ stanSprzegla = false; }

    public Sprzeglo(String nazwa, float waga, float cena) {
        super(nazwa, waga, cena);
    }
}