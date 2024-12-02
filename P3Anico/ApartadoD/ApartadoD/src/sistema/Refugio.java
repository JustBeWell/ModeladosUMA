package sistema;

import java.util.*;

public class Refugio {
    // Representa el capital financiero del refugio
    private float liquidez; //Quizás es más interesante utilizar un float, porque al estar tratando con dinero, vamos a tener un máximo de dos decimales
    //Lista para guardar a los animales registrados
    private Set<Animal> animalesRegistrados;
    //Lista para guardar los animales refugiados
    private Set<Animal> animalesRefugiados;
    // Lista para guardar a los adoptantes
    private Set<Socio> socios;
    public Refugio(float liquidez) {
        //Comprobamos que la liquidez sea valida

        assert liquidez >= 0 : "La liquidez debe ser no negativa.";
        //Asignamos las variables al refugio
        this.liquidez = liquidez;
        //Instanciamos las colecciones como hashset dado a que nos permite hacer una busqueda en tiempos de ejecucion lineales haciendo el sistema mas eficiente
        animalesRefugiados = new HashSet<>();
        animalesRegistrados = new HashSet<>();
        socios = new HashSet<>();

    }

    public float getLiquidez() {
        return liquidez;
    }
    public void setLiquidez(float liquidez) {
        assert liquidez >= 0 : "La liquidez debe ser no negativa";
        this.liquidez = liquidez;
    }
    protected void addSocio(Socio s) {
        assert s != null : "El socio no puede ser nulo.";
        /*if(!s.getRefugio().equals(this)){ //Se ha añadido está condición para evitar que un socio pertenezca varias veces a uno o varios refugios
            System.out.println("El socio ya está asociado a otro refugio.");
            return;
        }*/ //Como asumimos que solo puede haber un refugio esta comprobación deja de ser necesaria.
        if(socios.contains(s)) {
            System.out.println("El socio ya esta registrado.");
            return;
        }
        socios.add(s); //Como es un set no necesitamos comprobar que existan elementos repetidos
    }


    protected void removeSocio(Socio s) {
        assert s != null : "El socio no puede ser nulo.";
        if (socios.contains(s)) { //Comprobamos que previamente existe el socio en el sistema
            socios.remove(s);
        } else {
            System.out.println("Este socio no está registrado en el refugio.");
        }
    }

    /* CREACIÓN DE LAS LISTAS DE OBJETOS */

    public Enumeration<Animal> getAnimalesRegistrados() {
        return Collections.enumeration(animalesRegistrados);
    }
    public Enumeration<Animal> getAnimalesRefugiados() {
        return Collections.enumeration(animalesRefugiados);
    }
    public Enumeration<Socio> getSocios() {
        return Collections.enumeration(socios);
    }
    /* MÉTODOS PARA AÑADIR OBJETOS AL REFUGIO */
    public List<Adoptante> getAdoptantes() {
        List<Adoptante> adoptantes = new ArrayList<>();
        for (Socio s : socios) {
            if (s.esAdoptante()) {
                adoptantes.add(s.getAdoptante());
            }
        }
        return adoptantes;
    }

    public List<Voluntario> getVoluntarios() {
        List<Voluntario> voluntarios = new ArrayList<>();
        for (Socio s : socios) {
            if (s.esVoluntario()) {
                voluntarios.add(s.getVoluntario());
            }
        }
        return voluntarios;
    }

    public List<Donante> getDonantes() {
        List<Donante> donantes = new ArrayList<>();
        for (Socio s : socios) {
            if (s.esDonante()) {
                donantes.add(s.getDonante());
            }
        }
        return donantes;
    }

    public void registrar(Animal a){
        assert a != null : "No podemos registrar a un animal que no existe";
        this.addAnimalesRegistrados(a);
    }


    protected void addAnimalesRefugiados(Animal a){
        assert a != null : "El animal no puede ser nulo.";
        if(!animalesRefugiados.contains(a)){
            animalesRefugiados.add(a);
            this.addAnimalesRegistrados(a);
        } else System.out.println("Este animal ya está en el refugio.");
    }

    private void addAnimalesRegistrados(Animal a){
        assert a != null : "El animal no puede ser nulo.";
        if (!animalesRegistrados.contains(a)) {
            animalesRegistrados.add(a);
        } else {
            System.out.println("El animal ya está registrado.");
        }
    }

    /* MÉTODOS PARA ELIMINAR OBJETOS DEL REFUGIO */

    protected void removeAnimalesRefugiados(Animal a){
        assert a != null : "El animal no puede ser nulo.";
        if (animalesRefugiados.contains(a)) {
            animalesRefugiados.remove(a); //Si que puede haber 0 animales refugiados, pero no cero registrados
        } else {
            System.out.println("El animal no se encuentra en este Refugio.");
        }
    }

    protected void removeAnimalesRegistrados(Animal a){
        assert a != null : "El animal no puede ser nulo.";
        if (animalesRegistrados.contains(a) && animalesRegistrados.size() > 1) {
            animalesRegistrados.remove(a);
        } else if (animalesRegistrados.contains(a) && animalesRegistrados.size() == 1) {
            System.out.println("Todo refugio debe tener al menos un animal registrado, estás intentando eliminar el único animal existente");
        } else {
            System.out.println("El animal no se encuentra en este Refugio.");
        }
    }

    /* MÉTODOS AUXILIARES PARA MOSTRAR DATOS EN CONCRETO */
    public void mostrarAnimalesRefugiados(){
        System.out.println(animalesRefugiados.toString());
    }
    public void mostrarAnimalesRegistrados(){
        System.out.println(animalesRegistrados.toString());
    }
    public void mostrarSocios() {
        for (Socio s : socios) {
            System.out.println(s);
        }
    }

    public void mostrarSociosPorTipo() {
        System.out.println("Adoptantes: " + getAdoptantes());
        System.out.println("Voluntarios: " + getVoluntarios());
        System.out.println("Donantes: " + getDonantes());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Animales Registrados: ").append(animalesRegistrados).append("\n");
        sb.append("Animales Refugiados: ").append(animalesRefugiados).append("\n");
        sb.append("Socios: ").append(socios).append("\n");
        sb.append("Liquidez: ").append(liquidez);
        return sb.toString();
    }


}
