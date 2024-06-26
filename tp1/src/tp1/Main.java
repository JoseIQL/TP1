package tp1;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		GestorEquipos nuevo = new GestorEquipos();
		Equipo Velez = new Equipo("Vélez", "Liniers");
		Equipo Ferro = new Equipo("Ferro", "Caballito");
		nuevo.agregarEquipo(Ferro);
		nuevo.agregarEquipo(Velez);
		nuevo.getEquipos().add(new Equipo("Talleres","Cordoba"));
		nuevo.getEquipos().add(new Equipo("Boca","La boca"));
		nuevo.getEquipos().add(new Equipo("River","Nuñez"));
		nuevo.getEquipos().add(new Equipo("Lanus","Lanus"));
		nuevo.getEquipos().add(new Equipo("Chacarita","Chacarita"));
		nuevo.getEquipos().add(new Equipo("Newells","Rosario"));
		//Velez.agregarJugadoresRandom(15);
		//Ferro.agregarJugadoresRandom(15);

		nuevo.rellenarEquipos(nuevo);
		// JOptionPane.showMessageDialog(null, Velez.listaJugadores());

		String[] opciones = { "Jugar partido", "Seleccionar Equipo", "Eliminar equipo", "Revisar partidos", "Ver fases","Salir" };
		int opcion = 0;
		do {
			opcion = JOptionPane.showOptionDialog(null, "Bienvenido al Gestor de Equipos", null, 0, 0, null, opciones,
					opciones[0]);

			switch (opcion) {
			case 0:
				if (Partido.getCantPartidos()<4) {
					Partido jugado = nuevo.jugarPartido(
							nuevo.seleccionarEquipo(nuevo.getEquipos()), 
							nuevo.seleccionarEquipo(nuevo.getEquipos()));
					JOptionPane.showMessageDialog(null,"Se jugo el partido " + jugado);
					JOptionPane.showMessageDialog(null,"El ganador fue: " + jugado.determinarGanador());
					nuevo.getSemifinalistas().add(jugado.determinarGanador());
					nuevo.getPartidos().add(jugado);
					
				} else if (Partido.getCantPartidos()>=4 && Partido.getCantPartidos()<6){
					Partido jugado = nuevo.jugarPartido(
							nuevo.seleccionarEquipo(nuevo.getSemifinalistas()), 
							nuevo.seleccionarEquipo(nuevo.getSemifinalistas()));
					JOptionPane.showMessageDialog(null,"Se jugo el partido " + jugado);
					JOptionPane.showMessageDialog(null,"El ganador fue: " + jugado.determinarGanador());
					nuevo.getFinalistas().add(jugado.determinarGanador());
					nuevo.getPartidos().add(jugado);
				}else if (Partido.getCantPartidos()==6) {
					Partido jugado = nuevo.jugarPartido(nuevo.getFinalistas().get(0),nuevo.getFinalistas().get(1));
					JOptionPane.showMessageDialog(null,"Se jugo el partido " + jugado);
					JOptionPane.showMessageDialog(null,"El ganador del torneo fue: " + jugado.determinarGanador());
					nuevo.getPartidos().add(jugado);
				} else {
					JOptionPane.showMessageDialog(null, "Finalizo el torneo");
				}
				
				break;
			case 1:
				Equipo seleccionado = nuevo.elegirEquipo(nuevo.getEquipos());

				String[] opcionesDeEquipo = { "Crear jugador", "Buscar Jugador",
						"Rellenar equipo random", "Ver equipo", "Volver al menú principal" };
				int opcionEquipo = 0;
				do {
					opcionEquipo = JOptionPane.showOptionDialog(null, "Que desea hacer en el equipo: ", null,
							0, 0, null, opcionesDeEquipo, opcionesDeEquipo[0]);
					switch (opcionEquipo) {
					case 0:
						seleccionado.agregarJugador();
						break;
					case 1:
						String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador que quiere buscar");
						seleccionado.buscarNombreJugador(nombre);
						break;
					case 2:
						int cantidad;
						String numero = JOptionPane.showInputDialog("Ingrese cantidad de jugadores");
				        while (numero.trim().isEmpty() || Integer.parseInt(numero) <= 0) {
				            numero = JOptionPane.showInputDialog("Por favor, ingrese un número válido");
				        }
				        cantidad=Integer.parseInt(numero);
						
						seleccionado.agregarJugadoresRandom(cantidad);
						break;
					case 3:
						JOptionPane.showMessageDialog(null, seleccionado);
						break;
					case 4:
						JOptionPane.showMessageDialog(null, "Esta regresando al menú principal");
						break;
					default:
						break;
					}
				} while (opcionEquipo != 4);
				break;

			case 2:
				String club = JOptionPane.showInputDialog("Ingrese el nombre del equipo a borrar");
				while (club.trim().isEmpty()) {
					club=JOptionPane.showInputDialog("Por favor, el nombre del equipo");
				}
				nuevo.eliminarEquipo(club);
				break;
			case 3:
				if (nuevo.getPartidos().size()>=1) {
					JOptionPane.showMessageDialog(null, nuevo.getPartidos());
				} else {
					JOptionPane.showMessageDialog(null, "Todavia no hay partidos registrados");
				}
				
				break;
			case 4:
				String[]fases = {
						"Cuartos","Semifinal","Final"
				};
				String elegido = (String)JOptionPane.showInputDialog(null, "", "", 0, null, fases, fases[0]);
				if (nuevo.getPartidos().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No se jugaron todas las fases");
				} else {
					for (Partido partido : nuevo.getPartidos()) {
						if (partido.getFase().equals(elegido)) {
							JOptionPane.showMessageDialog(null, partido);
						}
				}
				}
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Salir");
				break;
			default:
				break;
			}

		} while (opcion != 5);

//			// 	Jugadores
//        Jugador jugador1 = new Jugador("Jose", "Delantero", 9, 19);
//        Jugador jugador2 = new Jugador("Ignacio", "Defensa", 5, 23);
//
//        	// 	Equipos
//        Equipo equipoA = new Equipo("Equipo A", "Ciudad A");
//        Equipo equipoB = new Equipo("Equipo B", "Ciudad B");
//
//        	// Gestor de equipos
//        GestorEquipos gestorEquipos = new GestorEquipos();
//
//        	// Agregar equipos al gestor
//        gestorEquipos.agregarEquipo(equipoA);
//        gestorEquipos.agregarEquipo(equipoB);
//
//        	// Agregar jugadores al equipo A
//        equipoA.agregarJugador(jugador1);
//        equipoA.agregarJugador(jugador2);
//
//        	// Buscar por nombre a jugador
//        equipoA.buscarNombreJugador("Jose");
//        Jugador buscado = equipoA.buscarNombreJugador("Jose");
//        if (buscado!= null) {
//        	JOptionPane.showMessageDialog(null, "Jugador encontrado: " + buscado.getNombre());
//        } else {
//        	JOptionPane.showMessageDialog(null, "Jugador no encontrado.");
//        }
//
//        // Eliminar un equipo
//        gestorEquipos.eliminarEquipo("");
//
//        // Simular un partido
//        gestorEquipos.jugarPartido(equipoA, equipoB);
	}
}
