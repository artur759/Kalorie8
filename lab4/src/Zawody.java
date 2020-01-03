public class Zawody {
    private String  zawody;
    private String data;

    private void rozegrajZawody()throws InterruptedException {
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
    public static void main(String[] args) {
        Zawody z = new Zawody();
        z.zawody= "Puchar sol=łtysa";
        z.data= "Poniedziałek";

        try{
            z.rozegrajZawody();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
}
