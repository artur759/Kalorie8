public class Pozycja {

    private double x;
    private double y;

    public void setPozycja(double X, double Y){
        x=X;
        y=Y;
    }

    public void setPozycja(Pozycja cel){
        x = cel.getX();
        y = cel.getY();
    }

    public double getX(){ return x; }

    public double getY(){ return y; }


    public void wyswietlPozycje(){
        System.out.println("X: "+x);
        System.out.println("Y: "+y);
    }

    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }
}