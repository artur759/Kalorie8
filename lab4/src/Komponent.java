abstract class Komponent {

    private String nazwa;
    private float waga;
    private float cena;

    public String getNazwa(){ return nazwa; }

    public float getWaga(){ return waga; }

    public float getCena(){ return cena; }


    public Komponent(String nazwa, float waga, float cena) {
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
    }

}