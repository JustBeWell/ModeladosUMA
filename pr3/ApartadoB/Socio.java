/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author byani
 */

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Socio {
    private int ID;
    private Date fecha;
    private final Refugio r;
    private boolean esDonante;
    private boolean esVoluntario;
    private boolean esAdoptante;
    private List<Donacion> donaciones = new ArrayList<>();
    private List<Adopcion> tramites = new ArrayList<>();
    private List<Adopcion> adopciones = new ArrayList<>();

    //Constructor de Socio. Al instanciar el objeto podemos elegir qué roles tiene. Lo podemos cambiar también de manera dinámica.
    public Socio(int ID, Date fecha, Refugio r, boolean esVoluntario, boolean esAdoptante) {
        this.ID = ID;
        this.fecha = fecha;
        this.r = r;
        this.esDonante = false; //Solo podrá ser donante si dona en algún momento.
        this.esVoluntario = esVoluntario;
        this.esAdoptante = esAdoptante;
    }

    //
    public int getID(){ return ID;}
    private void setID(int ID){
        this.ID = ID;
    }
    public Date getDate() {
        return this.fecha;
    }
    public void setDate(Date fecha) {
        this.fecha = fecha;
    }
    public Refugio getRefugio() {
        return this.r;
    }

    // Métodos para consultar o cambiar los roles
    public boolean esDonante() {
        return esDonante;
    }

    public void setDonante(boolean esDonante) {
        this.esDonante = esDonante;
    }

    public boolean esVoluntario() {
        return esVoluntario;
    }

    public void setVoluntario(boolean esVoluntario) {
        this.esVoluntario = esVoluntario;
    }

    public boolean esAdoptante() {
        return esAdoptante;
    }

    public void esAdoptante(boolean esAdoptante) {
        this.esAdoptante = esAdoptante;
    }

    //Métodos de la clase hija Donaciones
    public void donar(Double cantidad){
        if (donaciones.isEmpty() || esDonante) { //Puede donar si nunca ha donado y quiere ser donante y dona. Una vez ya haya donado, puede donar.
            if(cantidad > 0) {
                this.setDonante(true);
                LocalDate fechaDonacion = LocalDate.now();
                Donacion d = new Donacion(cantidad,  Date.from(fechaDonacion.atStartOfDay(ZoneId.systemDefault()).toInstant()), this);
                donaciones.add(d);
                r.setLiquidez(r.getLiquidez() + cantidad);
                if (!Collections.list(r.getDonantes()).contains(d)) r.addDonante(this);
            }else{
                System.out.println("La cantidad donada tiene que ser mayor que cero");
            }
        } else {
            System.out.println(this + " no tiene el rol de Donante.");
        }
    }

    public Enumeration<Donacion> getDonaciones(){
        return Collections.enumeration(this.donaciones);
    }

    //Métodos de la clase hija Voluntario
    public void tramitarAdopcion(Animal a, Socio ad){
        if(this.esVoluntario && ad.esAdoptante){
            LocalDate fechaAdopcion = LocalDate.now();
            // Añadimos una nuevo tramite del animal al adoptante con la fecha actual.
            Adopcion adopcion = new Adopcion(a, ad, this, Date.from(fechaAdopcion.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            this.addTramite(adopcion);
            ad.addAdopcion(adopcion);
        }
    }
    public void registrar(Animal a){
        if(this.esVoluntario){
            Refugio r = this.getRefugio();
            // Un animal se añade al refugio con el estado disponible
            a.setEstadoAnimal(EstadoAnimal.DISPONIBLE);
            r.addAnimalesRefugiados(a);
        }
    }

    public Enumeration<Adopcion> getTramites(){
        return Collections.enumeration(tramites);
    }
    private void addTramite(Adopcion d){
        if(this.esVoluntario){
            if(!tramites.contains(d)){
                tramites.add(d);
            }else System.out.println("Este voluntario ya ha realizado este trámite");
        }
    }

    //Métodos de la clase hija Adoptante
    public void adoptar(Animal a, Socio v) {
        if(this.esAdoptante && v.esVoluntario){
            v.tramitarAdopcion(a, this);
        }
    }

    public void addAdopcion(Adopcion a){
        if(this.esAdoptante){
            if (!adopciones.contains(a)) adopciones.add(a);
            else System.out.println("Este animal ya está adoptado");
        }
    }

    public void removeAdopcion(Adopcion a){
        if(this.esAdoptante){
            if (!adopciones.contains(a)) adopciones.add(a);
            else System.out.println("Este animal ya no está asociado al adoptante");
        }
    }
    public Enumeration<Adopcion> getAdopciones(){
        return Collections.enumeration(adopciones);
    }
}