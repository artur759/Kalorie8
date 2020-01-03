public class SkrzyniaBiegow extends Komponent {

    private int aktualnyBieg =1;
    private int iloscBiegow;
    private double aktualnePrzelozenie = 1;
    private Sprzeglo sprzeglo;

    public void zwiekszBieg(){
        if(aktualnyBieg<iloscBiegow){
            sprzeglo.wcisnij();
            aktualnyBieg++;
            sprzeglo.zwolnij();
            System.out.println("Aktualny bieg: "+aktualnyBieg);
            if (aktualnyBieg == 0){aktualnePrzelozenie=0;}
            if (aktualnyBieg == 1){aktualnePrzelozenie=1.1;}
            else{aktualnePrzelozenie += 0.2;}
        }
        else{
            System.out.println("Osiagnieto Max!");
            }
    }

    public void zmniejszBieg(){
        if(aktualnyBieg>1){
            sprzeglo.wcisnij();
            aktualnyBieg--;
            sprzeglo.zwolnij();
            System.out.println("Aktualny bieg: "+aktualnyBieg);

            if (aktualnyBieg == 0){aktualnePrzelozenie=0;}
            else{aktualnePrzelozenie -= 0.2;}
        }
        else{
            System.out.println("Osiagnieto Min!");
        }
    }

    public int getAktBieg(){ return aktualnyBieg; }
    public double getAktPrzelozenie(){ return aktualnePrzelozenie; }

    public SkrzyniaBiegow(String nazwa, float waga, float cena, int iloscBiegow, Sprzeglo sprzeglo) {
        super(nazwa, waga, cena);
        this.iloscBiegow = iloscBiegow;
        this.sprzeglo = sprzeglo;
    }

    public float getWaga(){
        return (super.getWaga() + sprzeglo.getWaga());
    }
}