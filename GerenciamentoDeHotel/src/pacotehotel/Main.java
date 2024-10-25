package pacotehotel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("Bem-vindo ao sistema de gerenciamento de hotel!");
            System.out.println("1. Cadastrar Quarto");
            System.out.println("2. Cadastrar Reserva");
            System.out.println("3. Check-in");
            System.out.println("4. Check-out");
            System.out.println("5. Acompanhar Ocupação");
            System.out.println("6. Histórico de Reservas");
            System.out.println("7. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir o newline

            switch (opcao) {
                case 1:
                    System.out.println("Número do quarto:");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Tipo de quarto (solteiro, casal, suite):");
                    String tipo = scanner.nextLine();
                    System.out.println("Preço diário:");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    Quarto quarto = new Quarto(numero, tipo, preco);
                    hotel.cadastrarQuarto(quarto);
                    break;

                case 2:
                    System.out.println("Nome do hóspede:");
                    String nome = scanner.nextLine();
                    System.out.println("Data de check-in (dd/MM/yyyy):");
                    String dataCheckInStr = scanner.nextLine();
                    System.out.println("Data de check-out (dd/MM/yyyy):");
                    String dataCheckOutStr = scanner.nextLine();

                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date checkIn = formato.parse(dataCheckInStr);
                    Date checkOut = formato.parse(dataCheckOutStr);

                    System.out.println("Número do quarto reservado:");
                    int numeroQuarto = scanner.nextInt();
                    scanner.nextLine();

                    Quarto quartoReservado = null;
                    for (Quarto q : hotel.getQuartos()) {  // Corrigido aqui
                        if (q.getNumero() == numeroQuarto && q.isDisponivel()) {
                            quartoReservado = q;
                            break;
                        }
                    }

                    if (quartoReservado != null) {
                        Reserva reserva = new Reserva(nome, checkIn, checkOut, quartoReservado);
                        hotel.cadastrarReserva(reserva);
                    } else {
                        System.out.println("Quarto não disponível.");
                    }
                    break;

                case 3:
                    System.out.println("Nome do hóspede:");
                    String nomeHospedeCheckIn = scanner.nextLine();
                    hotel.checkIn(nomeHospedeCheckIn);
                    break;

                case 4:
                    System.out.println("Nome do hóspede:");
                    String nomeHospedeCheckOut = scanner.nextLine();
                    hotel.checkOut(nomeHospedeCheckOut);
                    break;

                case 5:
                    hotel.acompanharOcupacao();
                    break;

                case 6:
                    System.out.println("Nome do hóspede:");
                    String nomeHospedeHistorico = scanner.nextLine();
                    hotel.historicoReservas(nomeHospedeHistorico);
                    break;

                case 7:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
