/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservantion;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author mayum
 */
public class Reserva {
    private int idReserva;
    private Hospede hospede;
    private Rooms rooms;
    private LocalDate dataCheckin;
    private LocalDate dataCheckout;
    private String Status;
    
    
   public Reserva(int idReserva,Hospede hospede,Rooms rooms,LocalDate dateCheckin,LocalDate Checkout,String Status){
       this.idReserva = idReserva;
       this.hospede = hospede;
       this.rooms = rooms;
       this.dataCheckin = dataCheckin;
       this.dataCheckout = dataCheckout;
       this.Status = "Comfirmada";
   }

    /**
     * @return the idReserva
     */
    public int getIdReserva() {
        return idReserva;
    }

    /**
     * @return the hospede
     */
    public Hospede getHospede() {
        return hospede;
    }

    /**
     * @return the rooms
     */
    public Rooms getRooms() {
        return rooms;
    }

    /**
     * @return the dataCheckin
     */
    public LocalDate getDataCheckin() {
        return dataCheckin;
    }

    /**
     * @return the dataCheckout
     */
    public LocalDate getDataCheckout() {
        return dataCheckout;
    }

    /**
     * @return the Satatus
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Satatus the Satatus to set
     */
    public void setSatatus(String Satatus) {
        this.Status = Satatus;
    }
    
    public void comfirmarReserva(){
        this.Status = "Confirmada";
        System.out.print("Reserva confirmada");
    }
    
    public void cancelarReserva(){
        this.Status = "Cancelada";
    }
    
    public double valorTotal(){
        long dias = ChronoUnit.DAYS.between(dataCheckin, dataCheckout);
        double precoPorDia = rooms.getPrecoPorDia();
        return dias*precoPorDia;
    }
    
    
    @Override
    public String toString(){
        return "Reserva{"+
                "ideReserva ="+idReserva+
                "hospede = "+hospede+
                "Quarto = "+rooms+
                "dataCheckin = "+dataCheckin+
                "dataCheckout = "+dataCheckout+
                "Status = "+Status+
                "}";
    }
}
