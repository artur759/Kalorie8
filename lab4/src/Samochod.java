public class Samochod extends Thread{

    private boolean stanWlaczenia = false;

    public String getNrRejest() {
        return nrRejest;
    }

    private String nrRejest;

    public SkrzyniaBiegow getSkrzyniaBiegow() {
        return skrzyniaBiegow;
    }

    private String model;
    private double predkoscMax;

    public String getModel() {
        return model;
    }

    private double predkosc = 0;
    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;
    private Pozycja aktualnaPozycja = new Pozycja(0,0);
    private final double Kolo= 0.02;
    private Pozycja cel = new Pozycja(0,0);
    private SkrzyniaBiegow skrzyniaBiegow;
    public void setAktualnaPozycja(Pozycja aktualnaPozycja) {
        this.aktualnaPozycja = aktualnaPozycja;
    }
    public Silnik getSilnik() {
        return silnik;
    }

    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }

    public void wlacz(){
        if(stanWlaczenia= false) {
            silnik.uruchom();
            stanWlaczenia = true;
        }
    }

    public void wylacz(){
        if(stanWlaczenia = true ) {
            silnik.zatrzymaj();
            stanWlaczenia = false;
        }
    }


    public void pozycja(Pozycja cel){
        this.cel = cel;
    }

    public void jedzDo(double dt){
        double x = cel.getX()-aktualnaPozycja.getX();
        double y = cel.getY()-aktualnaPozycja.getY();
        double odleglosc = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        double X = aktualnaPozycja.getX() + getAktPredkosc()*dt*(x/odleglosc);
        double Y = aktualnaPozycja.getY() + getAktPredkosc()*dt*(y/odleglosc);

        if(X>=cel.getX() && Y>=cel.getY()) {
            aktualnaPozycja.setPozycja(cel);
            System.out.println(model+" -  DOJECHAŁ!");
        }
        else{
            aktualnaPozycja.setPozycja(X,Y);
        }
    }



    public float getWaga(){
        return (silnik.getWaga()+ skrzynia.getWaga());
    }

    public double getAktPredkosc(){
        predkosc = skrzynia.getAktPrzelozenie()*silnik.getObroty()*Kolo;
        return predkosc;
    }

    public Pozycja getAktPozycja(){
        return aktualnaPozycja;
    }



    public Samochod(String nrRejest, String model, float predkoscMax, Silnik silnik, SkrzyniaBiegow skrzynia) {
        this.nrRejest = nrRejest;
        this.model = model;
        this.predkoscMax = predkoscMax;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.start();
    }

    public void run(){
        while(true){
            if(aktualnaPozycja.getX()!=cel.getX() && aktualnaPozycja.getY()!=cel.getY()) {
                jedzDo(0.2);
                System.out.println(model);
                aktualnaPozycja.wyswietlPozycje();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
    
}