package tp1;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class GestorEquipos {
	private LinkedList<Equipo> equipos = new LinkedList<Equipo>();
	private LinkedList<Partido> partidos = new LinkedList<Partido>();
	private LinkedList<Equipo> semifinalistas = new  LinkedList<Equipo> ();
	private LinkedList<Equipo> finalistas = new  LinkedList<Equipo> ();

	public GestorEquipos() {
		// TODO Auto-generated constructor stub
	}
	
	public LinkedList<Equipo> getSemifinalistas() {
		return semifinalistas;
	}


	public void setSemifinalistas(LinkedList<Equipo> semifinalistas) {
		this.semifinalistas = semifinalistas;
	}


	public LinkedList<Equipo> getFinalistas() {
		return finalistas;
	}


	public void setFinalistas(LinkedList<Equipo> finalistas) {
		this.finalistas = finalistas;
	}


	public LinkedList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(LinkedList<Partido> partidos) {
		this.partidos = partidos;
	}

	public GestorEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}


	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(LinkedList<Equipo> equipos) {
		this.equipos = equipos;
	}

	@Override
	public String toString() {
		return "GestorEquipos equipos=" + equipos;
	}
	// FUNCIONES

	public void agregarEquipo(Equipo equipo) {
		equipos.add(equipo);
	}

	public void eliminarEquipo(String nombre) {
		for (int i = 0; i < equipos.size(); i++) {
			if (equipos.get(i).getNombre().equals(nombre)) {
				equipos.remove(i);
				JOptionPane.showMessageDialog(null, "El equipo " + nombre + " fue borrado en la lista");
				break;
			}
		}
	}

	public void buscarNombreEquipo(String nombre) {
		boolean flag = false;
		for (Equipo equipo : equipos) {
			if (equipo.getNombre().equals(nombre)) {
				JOptionPane.showMessageDialog(null, "El equipo esta en la lista y es: " + equipo.getNombre());
				flag = true;
				break;
			}
		}
		if (!flag) {
			JOptionPane.showMessageDialog(null, "El equipo no está en la lista");
		}
	}

	public int totalEquipos() {
		return equipos.size();
	}

	public LinkedList<Equipo> listaEquipos() {
		return equipos;
	}
	// CALCULAR EDAD --- CAMBIAR LA EDAD JUGADOR DE INT A LOCALDATE
//	public int calcularEdad(LocalDate fechaNacimiento) {
//		LocalDate hoy = LocalDate.now();
//		Period periodo = Period.between(fechaNacimiento, hoy);
//		return periodo.getYears();
//	}

	public Partido jugarPartido(Equipo equipo1, Equipo equipo2) {
		// QUE NO SEAN EL MISMO EQUIPO
		if (equipo1.equals(equipo2)) {
			JOptionPane.showMessageDialog(null, "Los equipos deben ser diferentes");
			return null;
		}
		// EL EQUIPO TENGA MAS DE 7 JUGADORES
		if (equipo1.getJugadores().size() <= 7 && equipo2.getJugadores().size() <= 7) {
			JOptionPane.showMessageDialog(null, "Los equipos deben tener 7 jugadores como minimo");
			return null;
		}
		// VERIFICA SI SON +16
		LinkedList<Equipo> equiposTemporales = new LinkedList<Equipo>();
		equiposTemporales.add(equipo1);
		equiposTemporales.add(equipo2);
		for (Equipo equipo : equiposTemporales) {
			for (Jugador jugador : equipo.listaJugadores()) {
				if (jugador.getEdad() < 16) {
					JOptionPane.showMessageDialog(null, "Los jugadores deben tener 16 o mas para jugar");
					return null;
				}
			}
		}
		// CREAMOS LOS GOLES RANDOM

		int golesEquipo1Ida = (int) (Math.random() * 5);
		int golesEquipo2Ida = (int) (Math.random() * 5);
		int golesEquipo1Vuelta = (int) (Math.random() * 5);
		int golesEquipo2Vuelta = (int) (Math.random() * 5);

		int totalGolesE1 = golesEquipo1Ida + golesEquipo1Vuelta;
		int totalGolesE2 = golesEquipo2Ida + golesEquipo2Vuelta;
		if (totalGolesE1 > totalGolesE2) {
			return new Partido(equipo1, equipo2, totalGolesE1, totalGolesE2);
		} else if (totalGolesE2 > totalGolesE1) {
			return new Partido(equipo1, equipo2, totalGolesE1, totalGolesE2);
		} else {
			JOptionPane.showMessageDialog(null, "Hay penales");
			int golesPenalesEquipo1 = 0;
			int golesPenalesEquipo2 = 0;
			do {
				int resultadoPenalEquipo1 = (int) (Math.random() * 2); // 0 para erro el penal, 1 para gol
				if (resultadoPenalEquipo1 == 1) {
					golesPenalesEquipo1++;
				}
				int resultadoPenalEquipo2 = (int) (Math.random() * 2); 
				if (resultadoPenalEquipo2 == 1) {
					golesPenalesEquipo2++;
				}
				// Verificamos quien gano
				if (golesPenalesEquipo1 > golesPenalesEquipo2) {
					return new Partido(equipo1, equipo2, golesPenalesEquipo1, golesPenalesEquipo2);
				} else if (golesPenalesEquipo1 < golesPenalesEquipo2) {
					return new Partido(equipo1, equipo2, golesPenalesEquipo1, golesPenalesEquipo2);
				}
			} while (golesPenalesEquipo1 == golesPenalesEquipo2 && golesPenalesEquipo1 < 3 && golesPenalesEquipo2 < 3);

			if (totalGolesE1 > totalGolesE2) {
				return new Partido(equipo1, equipo2, totalGolesE1, totalGolesE2);
			} else {
				return new Partido(equipo1, equipo2, totalGolesE1, totalGolesE2);
			}
		}

	}

	public Equipo seleccionarEquipo(LinkedList<Equipo> equipos) {
		String[] equiposarray = new String[equipos.size()];
		for (int i = 0; i < equipos.size(); i++) {
			equiposarray[i] = equipos.get(i).getNombre();
		}
		int opcion = JOptionPane.showOptionDialog(null, 
				"Seleccione equipo", null, 0, 0, null, equiposarray, equiposarray[0]);
		Equipo seleccionado = equipos.get(opcion);
		equipos.remove(opcion);
		return seleccionado;
	}
	
	public void rellenarEquipos(GestorEquipos gestor) {
		for (Equipo equipo : gestor.getEquipos()) {
			equipo.agregarJugadoresRandom(23);
		}
	}
	public Equipo elegirEquipo(LinkedList<Equipo> equipos) {
		String[] equiposarray = new String[equipos.size()];
		for (int i = 0; i < equipos.size(); i++) {
			equiposarray[i] = equipos.get(i).getNombre();
		}
		int opcion = JOptionPane.showOptionDialog(null, 
				"Seleccione equipo", null, 0, 0, null, equiposarray, equiposarray[0]);
		Equipo seleccionado = equipos.get(opcion);	
		return seleccionado;
	}
	
}
