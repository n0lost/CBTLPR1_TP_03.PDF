//Gabriel Afonso dos Santos - CB3026167

import java.util.Scanner;

public class Hora {
    private int hora;
    private int min;
    private int seg;

    public Hora() {
        Scanner scanner = new Scanner(System.in);
        this.hora = solicitarValor("Coloque a hora (0-23): ", scanner, 0, 23);
        this.min = solicitarValor("Coloque os minutos (0-59): ", scanner, 0, 59);
        this.seg = solicitarValor("Coloque os segundos (0-59): ", scanner, 0, 59);
    }

    public Hora(int h, int m, int s) {
        if (!validaHora(h, m, s)) {
            throw new IllegalArgumentException("Valor invalido para hora, minutos ou segundos.");
        }
        this.hora = h;
        this.min = m;
        this.seg = s;
    }

    public void setHor(int h) {
        if (h < 0 || h >= 24) {
            throw new IllegalArgumentException("Hora invalida.");
        }
        this.hora = h;
    }

    public void setMin(int m) {
        if (m < 0 || m >= 60) {
            throw new IllegalArgumentException("Minuto invalido.");
        }
        this.min = m;
    }

    public void setSeg(int s) {
        if (s < 0 || s >= 60) {
            throw new IllegalArgumentException("Segundo invalido.");
        }
        this.seg = s;
    }

    public int getHor() {
        return this.hora;
    }

    public int getMin() {
        return this.min;
    }

    public int getSeg() {
        return this.seg;
    }

    public String getHora1() {
        return String.format("%02d:%02d:%02d", hora, min, seg);
    }

    public String getHora2() {
        String periodo = (hora < 12) ? "AM" : "PM";
        int hora12 = (hora == 0) ? 12 : (hora > 12) ? (hora - 12) : hora;
        return String.format("%02d:%02d:%02d %s", hora12, min, seg, periodo);
    }

    public int getSegundos() {
        return hora * 3600 + min * 60 + seg;
    }

    private int solicitarValor(String mensagem, Scanner scanner, int min, int max) {
        System.out.println(mensagem);
        int valor = scanner.nextInt();

        while (valor < min || valor > max) {
            System.out.println("Valor invalido. Tente novamente");
            valor = scanner.nextInt();
        }
        return valor;
    }

    private boolean validaHora(int h, int m, int s) {
        return (h >= 0 && h < 24) && (m >= 0 && m < 60) && (s >= 0 && s < 60);
    }

    public static void main(String[] args) {
        Hora h1 = new Hora();
        System.out.println("Formato 24h: " + h1.getHora1());
        System.out.println("Formato (AM/PM): " + h1.getHora2());
        System.out.println("Total segundos: " + h1.getSegundos());
    }
}
