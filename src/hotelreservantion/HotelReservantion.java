/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelreservantion;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class HotelReservantion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestaoHospedes gestaoHospedes = new GestaoHospedes();
        List<Rooms> roomsList = new ArrayList<>();

        int opcao;
        do {
            System.out.println("=====Sistema de Reserva do Hotel=====");
            System.out.println("Escolha uma opcaoo");
            System.out.println("1-Registrar Hospede");
            System.out.println("2-Registrar Quarto");
            System.out.println("3-Fazer reserva");
            System.out.println("4-Listar Hospedes");
            System.out.println("5-Listar Quartos");
            System.out.println("6-Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do hospede: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CPF do hospede: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Digite o ID do hospede: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    gestaoHospedes.registrarHospede(nome, id, cpf);
                    break;
                case 2:
                    System.out.print("Digite o numero do quarto: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o tipo do quarto (ex: Simples, Duplo, Luxo): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Digite o preco por dia do quarto: ");
                    double precoPorDia = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Digite o status inicial do quarto (ex: Disponivel, Ocupado): ");
                    String status = scanner.nextLine();

                    Rooms room = new Rooms(numero, tipo, precoPorDia, status);
                    roomsList.add(room);
                    System.out.println("Quarto registrado com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite o ID do hospede para a reserva: ");
                    int idHospede = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    System.out.println("Quartos disponiveis:");
                    for (Rooms r : roomsList) {
                        if (r.getStatus().equals("Disponivel")) {
                            System.out.println("Quarto " + r.getNumber() + " - " + r.getTipo() + " - R$ " + r.getPrecoPorDia() + " por diária");
                        }
                    }
                    System.out.print("Escolha o numero do quarto: ");
                    int numeroQuarto = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    System.out.print("Digite a data de check-in (yyyy-MM-dd): ");
                    String checkInString = scanner.nextLine();
                    LocalDate dataCheckIn = LocalDate.parse(checkInString);

                    System.out.print("Digite a data de check-out (yyyy-MM-dd): ");
                    String checkOutString = scanner.nextLine();
                    LocalDate dataCheckOut = LocalDate.parse(checkOutString);

                    // Encontrar o hóspede pelo ID
                    Hospede hospedeReserva = null;
                    for (Hospede h : gestaoHospedes.getHospedes()) {
                        if (h.getId() == idHospede) {
                            hospedeReserva = h;
                            break;
                        }
                    }

                    if (hospedeReserva != null) {
                        // Encontrar o quarto selecionado
                        Rooms roomReserva = null;
                        for (Rooms r : roomsList) {
                            if (r.getNumber() == numeroQuarto && r.getStatus().equals("Disponivel")) {
                                roomReserva = r;
                                r.defenirstatus("Ocupado");  // Marcar como ocupado
                                break;
                            }
                        }
                        if (roomReserva != null) {
                            // Criando a reserva
                            Reserva reserva = new Reserva(1, hospedeReserva, roomReserva, dataCheckIn, dataCheckOut, "Confirmada");

                            reserva.comfirmarReserva();
                            System.out.println("Valor total da reserva: R$ " + reserva.valorTotal());
                        } else {
                            System.out.println("Quarto nao disponivel ou invalido.");
                        }
                    } else {
                        System.out.println("Hóspede não encontrado.");
                    }
                    break;
                case 4:
                    gestaoHospedes.listarHospedes();
                    break;
                case 5:
                    System.out.println("Lista de Quartos:");
                    for (Rooms r : roomsList) {
                        System.out.println("Número do Quarto: " + r.getNumber() + ", Tipo: " + r.getTipo() + ", Status: " + r.getStatus());
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        } while (opcao != 6);
    }
}
