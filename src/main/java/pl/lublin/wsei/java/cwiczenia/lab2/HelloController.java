package pl.lublin.wsei.java.cwiczenia.lab2;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {
    public Button btnOblicz;
    public TextField promien, wysokosc, grubosc;
    public Text info, ciezar, koszt, blachStal, blachNierdz;
    public TextField blachStalWaga, blachStalKoszt, blachNierdzWaga, blachNierdzKoszt;
    float r, h, g;

    public void onBtnAction(ActionEvent actionEvent) {

        // Zmiana obramowania pol TextField na czarne
        promien.setStyle("-fx-border-color: #000");
        wysokosc.setStyle("-fx-border-color: #000");
        grubosc.setStyle("-fx-border-color: #000");

        // Czeyszczenie pola info
        info.setText("");

        // Ukrywanie pól wyniku
        blachStalWaga.setVisible(false);
        blachStalKoszt.setVisible(false);
        blachNierdzWaga.setVisible(false);
        blachNierdzKoszt.setVisible(false);
        ciezar.setVisible(false);
        koszt.setVisible(false);
        blachStal.setVisible(false);
        blachNierdz.setVisible(false);

        // Sprawdzanie czy zostały podane wszystkie wartości
        if(promien.getText().length() > 0 && wysokosc.getText().length() > 0 && grubosc.getText().length() > 0) {

            // Pobranie danych z pól TextField oraz konwersja danych do typu float (W przypadku, gdy któraś z danych nie jest liczbą, wykonuje się blok catch)
            try {
                r = Float.parseFloat(promien.getText());
                h = Float.parseFloat(wysokosc.getText());
                g = Float.parseFloat(grubosc.getText());

                // Sprawdzanie czy podane dane są liczbami i czy są większe od 0
                if (r > 0 && h > 0 && g > 0) {
                    oblicz();
                } else {
                    info.setText("Podane wartości muszą być większe od 0!");
                }
            } catch (Exception ignore) {
                info.setText("Sprawdź poprawność wprowadzonych danych");
            }

        } else {
            // Zmiana koloru pola, które nie zawiera wartości
            if (promien.getText().length() <= 0) promien.setStyle("-fx-border-color: #F00");
            if (wysokosc.getText().length() <= 0) wysokosc.setStyle("-fx-border-color: #F00");
            if (grubosc.getText().length() <= 0) grubosc.setStyle("-fx-border-color: #F00");

            info.setText("Sprawdź poprawność wprowadzonych danych");
        }
    }

    private void oblicz() {

        // Wyświetlanie pól wyniku
        ciezar.setVisible(true);
        koszt.setVisible(true);
        blachStal.setVisible(true);
        blachNierdz.setVisible(true);
        blachStalWaga.setVisible(true);
        blachStalKoszt.setVisible(true);
        blachNierdzWaga.setVisible(true);
        blachNierdzKoszt.setVisible(true);

        float pole_calkowite = (float) (2 * 3.14 * r * r + 2 * 3.14 * r * h);

        // Pierwsza wartość to waga m^2 blachy o grubosci 1mm (Waga w kg)
        float waga_blachy = 7.85F * pole_calkowite * g;
        float waga_blachy_nierdz = 8F * pole_calkowite * g;

        // Pierwsza wartość to cena za kg
        float cena_blachy = 2.5F * waga_blachy;
        float cena_blachy_nierdz = 3F * waga_blachy_nierdz;


        blachStalWaga.setText(waga_blachy + " kg");
        blachStalKoszt.setText(cena_blachy + " zł");

        blachNierdzWaga.setText(waga_blachy_nierdz + " kg");
        blachNierdzKoszt.setText(cena_blachy_nierdz + " zł");
    }
}