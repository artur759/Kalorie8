public class Silnik extends Komponent {

    private final float maxObroty = 6000;
    private final float minObroty = 1000;
    private float obroty = 1000;

    public void uruchom(){
        obroty = minObroty;
    }

    public void zatrzymaj(){
        obroty = 0;
    }

    public void zwiekszObroty(){
        obroty += 1000;
        if(obroty > maxObroty) obroty = maxObroty;
    }

    public void zmniejszObroty(){
        obroty -= 1000;
        if(obroty < minObroty) obroty = minObroty;
    }

    public float getObroty() {
        return obroty;
    }

    public Silnik(String nazwa, float waga, float cena) {
        super(nazwa, waga, cena);
    }
}