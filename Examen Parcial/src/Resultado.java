import java.util.Map;

public class Resultado {
    private Map<Participante, Integer> posiciones;

    public Resultado(Map<Participante, Integer> posiciones) {
        this.posiciones = posiciones;
    }

    public Map<Participante, Integer> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(Map<Participante, Integer> posiciones) {
        this.posiciones = posiciones;
    }
}
