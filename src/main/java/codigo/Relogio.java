package codigo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Relogio {

    private static Relogio instancia;

    private Timer timer;
    private LocalTime horaAtual;
    private boolean modoAutomatico;
    private final List<JLabel> labels = new ArrayList<>();

    private Relogio() {
        this.horaAtual = LocalTime.now();
        this.modoAutomatico = true;

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (modoAutomatico) {
                    horaAtual = LocalTime.now();
                } else {
                    horaAtual = horaAtual.plusSeconds(1);
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm"); // aqui da pra por segundos tbm 
                for (JLabel label : labels) {
                    label.setText(horaAtual.format(formatter));
                }
            }
        });
        timer.start();
        atualizarLabels();
    }

    public static Relogio getInstancia() {
        if (instancia == null) {
            instancia = new Relogio();
        }
        return instancia;
    }

    public void adicionarLabel(JLabel label) {
        labels.add(label);
    }

    public void setHoraManual(LocalTime hora) {
        this.horaAtual = hora;
        this.modoAutomatico = false;
    }

    public void usarHoraDoSistema() {
        this.modoAutomatico = true;
    }

    public LocalTime getHoraAtual() {
        return horaAtual;
    }

    public void parar() {
        if (timer != null) {
            timer.stop();
        }
    }
    
    private void atualizarLabels() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        for (JLabel label : labels) {
            label.setText(horaAtual.format(formatter));
        }
    }
}
