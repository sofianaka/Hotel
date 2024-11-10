/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservantion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mayum
 */
public class GestaoHospedes {

    private List<Hospede> hospedes;

// construtor inicializando a lista de hospedes
    public GestaoHospedes() {
        this.hospedes = new ArrayList<>();
    }

    public void registrarHospede(String nome, int id, String cpf) {
        Hospede hospede = new Hospede(nome, id, cpf);
        hospedes.add(hospede);
        System.out.println("Hospede Registrado :" + hospede);
    }

    public boolean removerHospede(int id) {
        for (Hospede hospede : hospedes) {
            if (hospede.getId() == id) {
                hospedes.remove(hospede);
                System.out.println("Hospede deletado :" + hospede);
                return true;
            }
        }
        System.out.println("O Hospede com o Id " + id + "nao foi encontrado");
        return false;
    }

    public void listarHospedes() {
        System.out.println("Lista dos Hospedes Registrados :");
        for (Hospede hospede : hospedes) {
            System.out.println(hospede);
        }
    }
      public List<Hospede> getHospedes() {
        return hospedes; 
    }
}
