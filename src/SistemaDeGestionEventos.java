import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class SistemaDeGestionEventos {
    private Map<String, Evento> eventos;
    private Map<String, Participante> participantes;

    public SistemaDeGestionEventos() {
        eventos = new HashMap<>();
        participantes = new HashMap<>();
    }

    public void registrarEvento(String nombre, String descripcion, LocalDateTime inicio, LocalDateTime fin) {
        if (inicio.isAfter(fin)) {
            throw new IllegalArgumentException("La fecha de inicio debe ser antes de la fecha de fin.");
        }
        Evento evento = new Evento(nombre, descripcion, inicio, fin);
        eventos.put(nombre, evento);
    }

    public void registrarParticipante(String nombre, String id) {
        Participante participante = new Participante(nombre, id);
        participantes.put(id, participante);
    }

    public void asignarParticipanteAEvento(String idParticipante, String nombreEvento) {
        Participante participante = participantes.get(idParticipante);
        Evento evento = eventos.get(nombreEvento);
        if (participante == null || evento == null) {
            throw new IllegalArgumentException("Participante o evento no encontrado.");
        }
        evento.agregarParticipante(participante);
    }

    public void mostrarInformacionEvento(String nombreEvento) {
        Evento evento = eventos.get(nombreEvento);
        if (evento == null) {
            System.out.println("Evento no encontrado.");
            return;
        }
        System.out.println("Nombre del Evento: " + evento.getNombre());
        System.out.println("Descripción: " + evento.getDescripcion());
        System.out.println("Fecha y Hora de Inicio: " + evento.getInicio());
        System.out.println("Fecha y Hora de Fin: " + evento.getFin());
        System.out.println("Participantes:");
        for (Participante participante : evento.getParticipantes()) {
            System.out.println(" - " + participante.getNombre() + " (ID: " + participante.getId() + ")");
        }
    }

    public void mostrarInformacionParticipante(String idParticipante) {
        Participante participante = participantes.get(idParticipante);
        if (participante == null) {
            System.out.println("Participante no encontrado.");
            return;
        }
        System.out.println("Nombre del Participante: " + participante.getNombre());
        System.out.println("ID: " + participante.getId());
        System.out.println("Eventos en los que está registrado:");
        for (Evento evento : participante.getEventos()) {
            System.out.println(" - " + evento.getNombre() + " (Fecha y Hora de Inicio: " + evento.getInicio() + ")");
        }
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar nuevo evento");
            System.out.println("2. Registrar nuevo participante");
            System.out.println("3. Asignar participante a evento");
            System.out.println("4. Mostrar información de evento");
            System.out.println("5. Mostrar información de participante");
            System.out.println("6. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    try {
                        System.out.println("Ingrese el nombre del evento:");
                        String nombreEvento = scanner.nextLine();
                        System.out.println("Ingrese la descripción del evento:");
                        String descripcionEvento = scanner.nextLine();
                        System.out.println("Ingrese la fecha y hora de inicio (yyyy-MM-dd'T'HH:mm):");
                        LocalDateTime inicioEvento = LocalDateTime.parse(scanner.nextLine());
                        System.out.println("Ingrese la fecha y hora de fin (yyyy-MM-dd'T'HH:mm):");
                        LocalDateTime finEvento = LocalDateTime.parse(scanner.nextLine());
                        registrarEvento(nombreEvento, descripcionEvento, inicioEvento, finEvento);
                    } catch (DateTimeParseException e) {
                        System.out.println("Formato de fecha y hora inválido. Asegúrese de usar el formato yyyy-MM-dd'T'HH:mm.");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del participante:");
                    String nombreParticipante = scanner.nextLine();
                    System.out.println("Ingrese el ID del participante:");
                    String idParticipante = scanner.nextLine();
                    registrarParticipante(nombreParticipante, idParticipante);
                    break;
                case 3:
                    System.out.println("Ingrese el ID del participante:");
                    String id = scanner.nextLine();
                    System.out.println("Ingrese el nombre del evento:");
                    String eventoNombre = scanner.nextLine();
                    asignarParticipanteAEvento(id, eventoNombre);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del evento:");
                    String nombreEventoConsulta = scanner.nextLine();
                    mostrarInformacionEvento(nombreEventoConsulta);
                    break;
                case 5:
                    System.out.println("Ingrese el ID del participante:");
                    String idConsulta = scanner.nextLine();
                    mostrarInformacionParticipante(idConsulta);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
