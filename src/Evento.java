import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Evento {
    private String nombre;
    private String descripcion;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private Set<Participante> participantes;
    private Resultado resultado;

    public Evento(String nombre, String descripcion, LocalDateTime inicio, LocalDateTime fin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
        this.participantes = new HashSet<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Participante> participantes) {
        this.participantes = participantes;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public void agregarParticipante(Participante participante) {
        participantes.add(participante);
        participante.agregarEvento(this);
    }

    public void registrarResultado(Resultado resultado) {
        this.resultado = resultado;
    }
}
