/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservantion;

public class Rooms {

    private int numero;
    private String tipo;
    private double precoPorDia;
    private String status;

    public Rooms(int numero, String tipo, double precoPorDia, String status) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoPorDia = precoPorDia;
        this.status = status;
    }

    public int getNumber() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecoPorDia() {
        return precoPorDia;
    }

    public void setPrecoPorDia(double precoPorDia) {
        this.precoPorDia = precoPorDia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void defenirstatus(String novoStatus) {
        this.status = novoStatus;
    }

    public double calcularPreco(int dias) {
        return this.precoPorDia * dias;
    }
}
