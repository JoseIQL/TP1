package tp1;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		GestorEquipos nuevo = new GestorEquipos();
		Equipo Velez = new Equipo("Vélez", "Liniers");
		Equipo Ferro = new Equipo("Ferro", "Caballito");
		nuevo.agregarEquipo(Ferro);
		nuevo.agregarEquipo(Velez);
		Velez.agregarJugadoresRandom(15);
		Ferro.agregarJugadoresRandom(15);

		// JOptionPane.showMessageDialog(null, Velez.listaJugadores());

		String[] opciones = { "Jugar partido", "Seleccionar Equipo", "Eliminar equipo", "Salir" };
		int opcion = 0;
		do {
			opcion = JOptionPane.showOptionDialog(null, "Bienvenido al Gestor de Equipos", null, opcion, opcion, null, opciones,
					opciones[0]);

			switch (opcion) {
			case 0:
				JOptionPane.showMessageDialog(null, "El ganador es: " + nuevo.jugarPartido(Velez, Ferro));
				break;
			case 1:
				int seleccionado = nuevo.seleccionarEquipo(nuevo.getEquipos());

				String[] opcionesDeEquipo = { "Crear jugador", "Buscar Jugador",
						"Rellenar equipo random", "Ver equipo", "Volver al menú principal" };
				int opcionEquipo = 0;
				do {
					opcionEquipo = JOptionPane.showOptionDialog(null, "Que desea hacer en el equipo: ", null,
							seleccionado, opcionEquipo, null, opcionesDeEquipo, opcionesDeEquipo[0]);
					switch (opcionEquipo) {
					case 0:
						nuevo.getEquipos().get(seleccionado).agregarJugador();
						;
						break;
					case 1:
						String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador que quiere buscar");
						nuevo.getEquipos().get(seleccionado).buscarNombreJugador(nombre);
						break;
					case 2:
						int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Indique la cantidad de jugadores a crear"));
						nuevo.getEquipos().get(seleccionado).agregarJugadoresRandom(cantidad);
						break;
					case 3:
						JOptionPane.showMessageDialog(null, nuevo.getEquipos().get(seleccionado));
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
				nuevo.eliminarEquipo(club);
				break;
			//case 3:
				//JOptionPane.showMessageDialog(null, "Salir");
				//break;
			default:
				break;
			}

		} while (opcion != 3);

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
