package pacotehotel;

import java.util.Date;

public class Reserva {
    private String nomeHospede;
    private Date checkIn;
    private Date checkOut;
    private Quarto quarto;

    public Reserva(String nomeHospede, Date checkIn, Date checkOut, Quarto quarto) {
        this.nomeHospede = nomeHospede;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.quarto = quarto;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public String toString() {
        return "Reserva: " + nomeHospede + ", Check-in: " + checkIn + ", Check-out: " + checkOut + ", Quarto: " + quarto.getNumero();
    }
}