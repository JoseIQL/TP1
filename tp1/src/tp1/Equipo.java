package tp1;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Equipo {
	private String nombre;
	private String ciudad;
	private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();

	public Equipo(String nombre, String ciudad) {
		this.nombre = nombre;
		this.ciudad = ciudad;

	}

	public Equipo(String nombre, String ciudad, LinkedList<Jugador> jugadores) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.jugadores = jugadores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public LinkedList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(LinkedList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", ciudad=" + ciudad + ", jugadores=" + jugadores;
	}

	public void agregarJugador() {
		String nombre, posicion;
		int ncamiseta, edad;
		nombre = JOptionPane.showInputDialog("Ingrese nombre");
		while (nombre.trim().isEmpty()) {
			nombre=JOptionPane.showInputDialog("Por favor, ingrese su nombre");
		}
		posicion = JOptionPane.showInputDialog("Ingrese la posicion");
		while (posicion.trim().isEmpty()) {
			posicion=JOptionPane.showInputDialog("Por favor, ingrese la posicion del jugador");
		}
		String incamiseta = JOptionPane.showInputDialog("Ingrese un número de camiseta");
		while (incamiseta.trim().isEmpty() || Integer.parseInt(incamiseta) <=0) {
			incamiseta = JOptionPane.showInputDialog("Por favor, ingrese un número válido para su camiseta");
		}
		String iedad = JOptionPane.showInputDialog("Ingrese la edad");
		while (iedad.trim().isEmpty() || Integer.parseInt(iedad)<=15) {
			iedad = JOptionPane.showInputDialog("Por favor, ingrese una edad válida, la edad minima es de 16 años");
		}
		ncamiseta=Integer.parseInt(incamiseta);
		edad=Integer.parseInt(iedad);
		Jugador agregado = new Jugador(nombre, posicion, ncamiseta, edad);
		jugadores.add(agregado);
		JOptionPane.showMessageDialog(null, "el jugador "+ nombre + " fue agregado");
		
	}

	public void eliminarJugador(String nombre) {

		for (int i = 0; i < jugadores.size(); i++) {
			if (jugadores.get(i).getNombre().equals(nombre)) {
				jugadores.remove(i);
				break;
			}
		}
	}

	public void buscarNombreJugador(String nombre) {
		boolean flag = false;
		for (Jugador jugador : jugadores) {
			if (jugador.getNombre().equals(nombre)) {
				JOptionPane.showMessageDialog(null, "El jugador esta y es: " + jugador.getNombre());
				flag = true;
				break;
			}
		}
		if (!flag) {
			JOptionPane.showMessageDialog(null, "El jugador no está en la lista");
		}
	}
//	public Jugador buscarJugadorPorNombre(String nombre) {
//	    for (Jugador jugador : jugadores) {
//	        if (jugador.getNombre().equals(nombre)) {
//	            return jugador;
//	        }
//	    }
//	    return null;
//	}

	public int totalJugadores() {
		return jugadores.size();
	}

	public LinkedList<Jugador> listaJugadores() {
		return jugadores;
	}

	public void agregarJugadoresRandom(int cant) {
		
			for (int i = 0; i < cant; i++) {
				boolean flag = true;
				do {
					int camiseta = (int) (Math.random() * 99 + 1);
					for (Jugador jugador : this.getJugadores()) {
						if (jugador.getNumeroCamiseta() == camiseta) {
							flag = false;
						}
					}
					this.getJugadores().add(new Jugador("X", "Y", camiseta, 18));
					break;
				} while (flag == false);
			}
			//JOptionPane.showMessageDialog(null, "La cantidad de: "+ cant + " jugadores fueron creados");
	}

}
