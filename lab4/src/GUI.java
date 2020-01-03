import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.*;
import java.sql.SQLOutput;

public class GUI {
    private JTextField AktualnaPozycjaXText;
    private JButton włączButton;
    private JButton wyłączButton;
    private JButton dodajGazuButton;
    private JTextField AktualnaPozycjaYTeXt;
    private JTextField JedzDoX;
    private JTextField JedzDoY;
    private JTextField samochodNazwa;
    private JTextField samochodRej;
    private JTextField samochodPredkosc;
    private JTextField sbNazwa;
    private JTextField sbAktualnyBieg;
    private JTextField sbAktualnePrzelozenie;
    private JButton zwiększBiegButton;
    private JButton zmniejszBiegButton;
    private JButton ujmijGazuButton;
    private JTextField silnikObroty;
    private JTextField silnikNazwa;
    private JButton JedzDoButton;
    private JComboBox smaochodcomboBox1;
    private JButton usuńButton;
    private JButton dodajButton;
    private JTextField samochódTextField;
    private JPanel mapa;
    private JPanel PrzyciskiGaz;
    private JPanel PrzyciskiSkrzyniaBiegow;
    private JPanel Silnik;
    private JPanel PasekWyboru;
    private JPanel AktualnaPozycja;
    private JPanel JedzDo;
    private JPanel PrzyciskiPozycja;
    private JPanel GłownyBezPaska;
    private JPanel Całość;
    private JPanel niepotrzebny;
    private JPanel AP;
    private JPanel Menu;
    private JLabel kursor;
    private JButton button1;
    private JRadioButton radioButton1;
 //   private int licznik = 0;
    private  static Samochod samochod;
    static Samochod samochodik[] = new  Samochod[100];
/*
    Sprzeglo clutch1 = new Sprzeglo("CLUTCH1",12,1000);
    SkrzyniaBiegow gearbox1 = new SkrzyniaBiegow("GEARBOX1",221,3232,6,clutch1);
    Silnik engine1 = new Silnik("ENGINE1",400,2123);
   // Samochod samochod1 = new Samochod("212EB", "BMW", 212,engine1,gearbox1);
    Sprzeglo clutch2 = new Sprzeglo("clutch2",31,2122);
    SkrzyniaBiegow gearbox2 = new SkrzyniaBiegow("gearbox2",242,2143,5,clutch2);
    Silnik engine2= new Silnik("engine2",324,4232);
   // Samochod samochod2 = new Samochod("DAS74","AUDI",324,engine2,gearbox2);
*/
   // public void dodajSamochod(String rejestracja, String marka, int predkosc, Silnik s, SkrzyniaBiegow sk)
 //   {
  //      samochodik[licznik] = new Samochod(rejestracja,marka,predkosc,s,sk);
  //  }

    public final void sprawdz()
    {
        for(Samochod x:samochodik) {

            if (smaochodcomboBox1.getSelectedItem().toString().equals(x.getModel()))
                samochod= x;
        }
    }


/*    public void odswiez(){

        samochodPredkosc.setText(Double.toString(samochod.getAktPredkosc()));
        samochodNazwa.setText((samochod.getModel()));
        samochodRej.setText(samochod.getNrRejest());
        silnikNazwa.setText(samochod.getSilnik().getNazwa());
        silnikObroty.setText(Double.toString(samochod.getSilnik().getObroty()));
        AktualnaPozycjaYTeXt.setText(""+0);
        AktualnaPozycjaXText.setText(""+0);
        sbNazwa.setText(samochod.getSkrzynia().getNazwa());
        sbAktualnyBieg.setText(Double.toString(samochod.getSkrzynia().getAktBieg()));
        sbAktualnePrzelozenie.setText(Double.toString(samochod.getSkrzynia().getAktPrzelozenie()));
        kursor.setLocation((int)samochod.getAktPozycja().getX(),(int)samochod.getAktPozycja().getY());
        for (Samochod x:samochodik) {
            smaochodcomboBox1.addItem(x.getModel());
        }
}*/

     public GUI() {
        /* Sprzeglo clutch1 = new Sprzeglo("CLUTCH1",12,1000);
         SkrzyniaBiegow gearbox1 = new SkrzyniaBiegow("GEARBOX1",221,3232,6,clutch1);
         Silnik engine1 = new Silnik("ENGINE1",400,2123);
         samochodik[0] = new Samochod("212EB", "BMW", 212,engine1,gearbox1);
      //   samochod = samochodik[0];
         Sprzeglo clutch2 = new Sprzeglo("clutch2",31,2122);
         SkrzyniaBiegow gearbox2 = new SkrzyniaBiegow("gearbox2",242,2143,5,clutch2);
         Silnik engine2= new Silnik("engine2",324,4232);
         samochodik[1] = new Samochod("DAS74","A6UDI",324,engine2,gearbox2);
*/
        timer.start();

        smaochodcomboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sprawdz();

            }
        });
        włączButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.wlacz();
            }
        });

        wyłączButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.wylacz();
            }
        });
        zwiększBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.getSkrzynia().zwiekszBieg();
                sbAktualnyBieg.setText(Double.toString(samochod.getSkrzynia().getAktBieg()));
                sbAktualnePrzelozenie.setText(Double.toString(samochod.getSkrzynia().getAktPrzelozenie()));
                samochodPredkosc.setText(Double.toString(samochod.getAktPredkosc()));
            }
        });
        zmniejszBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.getSkrzynia().zmniejszBieg();
                sbAktualnyBieg.setText(Double.toString(samochod.getSkrzynia().getAktBieg()));
                sbAktualnePrzelozenie.setText(Double.toString(samochod.getSkrzynia().getAktPrzelozenie()));
                samochodPredkosc.setText(Double.toString(samochod.getAktPredkosc()));
            }
        });
        dodajGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.getSilnik().zwiekszObroty();
                silnikObroty.setText(Double.toString(samochod.getSilnik().getObroty()));
                samochodPredkosc.setText(Double.toString(samochod.getAktPredkosc()));
            }
        });
        JedzDoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                samochod.setAktualnaPozycja(new Pozycja(Double.parseDouble(AktualnaPozycjaXText.getText()),Double.parseDouble(AktualnaPozycjaYTeXt.getText())));
                samochod.getSilnik().uruchom();
                samochod.pozycja(new Pozycja(Double.parseDouble(JedzDoX.getText()),Double.parseDouble(JedzDoY.getText())));
                AktualnaPozycjaXText.setText(JedzDoX.getText());
                AktualnaPozycjaYTeXt.setText(JedzDoY.getText());

            }
        });
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        usuńButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        smaochodcomboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                sprawdz();


            }
        });
        ujmijGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.getSilnik().zmniejszObroty();
                silnikObroty.setText(Double.toString(samochod.getSilnik().getObroty()));
                samochodPredkosc.setText(Double.toString(samochod.getAktPredkosc()));
            }
        });
        //odswiez();


        mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(e.getX());
                System.out.println(e.getY());
                samochod.pozycja(new Pozycja(e.getX(),e.getY()));

            }
        });
    }
    Timer timer = new Timer (100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            odswiez();
        }
    });



     public void odswiez(){

        samochodPredkosc.setText(Double.toString(samochod.getAktPredkosc()));
        samochodNazwa.setText((samochod.getModel()));
        samochodRej.setText(samochod.getNrRejest());
        silnikNazwa.setText(samochod.getSilnik().getNazwa());
        silnikObroty.setText(Double.toString(samochod.getSilnik().getObroty()));
        AktualnaPozycjaYTeXt.setText(""+0);
        AktualnaPozycjaXText.setText(""+0);
        sbNazwa.setText(samochod.getSkrzynia().getNazwa());
        sbAktualnyBieg.setText(Double.toString(samochod.getSkrzynia().getAktBieg()));
        sbAktualnePrzelozenie.setText(Double.toString(samochod.getSkrzynia().getAktPrzelozenie()));

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().Całość);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

      //  Sprzeglo clutch1 = new Sprzeglo("CLUTCH1",12,1000);
        //SkrzyniaBiegow gearbox1 = new SkrzyniaBiegow("GEARBOX1",221,3232,6,clutch1);
       // Silnik engine1 = new Silnik("ENGINE1",400,2123);
      //  samochodik[0] = new Samochod("212EB", "BMW", 212,engine1,gearbox1);

     //  Sprzeglo clutch2 = new Sprzeglo("clutch2",31,2122);
      // SkrzyniaBiegow gearbox2 = new SkrzyniaBiegow("gearbox2",242,2143,5,clutch2);
      //  Silnik engine2= new Silnik("engine2",324,4232);
      // samochodik[1] = new Samochod("DAS74","A6UDI",324,engine2,gearbox2);
      //  samochod = samochodik[0];

        Sprzeglo clutch1 = new Sprzeglo("CLUTCH1",12,1000);
        SkrzyniaBiegow gearbox1 = new SkrzyniaBiegow("GEARBOX1",221,3232,6,clutch1);
        Silnik engine1 = new Silnik("ENGINE1",400,2123);
        samochodik[0] = new Samochod("212EB", "BMW", 212,engine1,gearbox1);
        samochod = samochodik[0];
        Sprzeglo clutch2 = new Sprzeglo("clutch2",31,2122);
        SkrzyniaBiegow gearbox2 = new SkrzyniaBiegow("gearbox2",242,2143,5,clutch2);
        Silnik engine2= new Silnik("engine2",324,4232);
        samochodik[1] = new Samochod("DAS74","A6UDI",324,engine2,gearbox2);


    }


}

