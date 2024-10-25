package pacotehotel;
import java.util.ArrayList;
import java.util.List;
public class Hotel {
    private List<Quarto> quartos;
   
    private List<Reserva> reservas;

    public Hotel() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void cadastrarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void cadastrarReserva(Reserva reserva) {
        reservas.add(reserva);
        reserva.getQuarto().setDisponivel(false);
    }

    public void checkIn(String nomeHospede) {
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equalsIgnoreCase(nomeHospede)) {
                reserva.getQuarto().setDisponivel(false);
                System.out.println("Check-in realizado para " + nomeHospede);
                return;
            }
        }
        System.out.println("Reserva não encontrada.");
    }

    public void checkOut(String nomeHospede) {
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equalsIgnoreCase(nomeHospede)) {
                reserva.getQuarto().setDisponivel(true);
                System.out.println("Check-out realizado para " + nomeHospede);
                return;
            }
        }
        System.out.println("Reserva não encontrada.");
    }

    public void acompanharOcupacao() {
        System.out.println("Ocupação de quartos:");
        for (Quarto quarto : quartos) {
            System.out.println(quarto);
        }
    }

    public void historicoReservas(String nomeHospede) {
        System.out.println("Histórico de reservas para " + nomeHospede + ":");
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equalsIgnoreCase(nomeHospede)) {
                System.out.println(reserva);
            }
        }
    }
}