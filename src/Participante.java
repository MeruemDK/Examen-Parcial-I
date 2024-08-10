import java.util.HashSet;
import java.util.Set;

public class Participante extends Persona {
    private Set<Evento> eventos;

    public Participante(String nombre, String id) {
        super(nombre, id);
        this.eventos = new HashSet<>();
    }

    // El método getNombre() es heredado de Persona
    public String getNombre() {
        return super.getNombre();  // Llama al método de la clase base
    }

    // El método getId() es heredado de Persona
    public String getId() {
        return super.getId();  // Llama al método de la clase base
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public Set<Evento> getEventos() {
        return eventos;
    }
}
