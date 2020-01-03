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
    /*
    public static void main(String[] args) throws Exception {

        Sprzeglo sprz1 = new Sprzeglo("clutch1",30,400);
        SkrzyniaBiegow sB1 = new SkrzyniaBiegow("gearbox1", 200, 20000, 6, sprz1);
        Silnik s1 = new Silnik("engine1", 700, 8000);
        Samochod samochod1 = new Samochod("6dsa63", "AUDI", 700, s1, sB1);

        System.out.println("Waga : " + samochod1.getWaga());

        Sprzeglo sprz2 = new Sprzeglo("clutch2",50,700);
        SkrzyniaBiegow sB2 = new SkrzyniaBiegow("gearbox2", 320, 2300, 7, sprz2);
        Silnik s2 = new Silnik("engine2", 500, 4200);
        Samochod samochod2 = new Samochod("1ad3e", "BMW", 500, s2, sB2);

        System.out.println("Waga : " + samochod2.getWaga());

        s1.uruchom();
        s2.uruchom();
        samochod1.pozycja(new Pozycja(2000,9000));
        samochod2.pozycja(new Pozycja(100,3000));

    }

     */
}