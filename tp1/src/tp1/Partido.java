package tp1;

import java.time.LocalDate;

public class Partido {

	private Equipo equipo1;
	private Equipo equipo2;
	private int Goles1;	
	private int Goles2;
	private String Fase;
	private LocalDate fecha;
	private static int cantPartidos=0;
	public Partido(Equipo equipo1, Equipo equipo2, int goles1, int goles2) {
		cantPartidos++;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		Goles1 = goles1;
		Goles2 = goles2;
		Fase = generarFase() ;
		fecha = generarFecha();
	}
	

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public int getGoles1() {
		return Goles1;
	}

	public void setGoles1(int goles1) {
		Goles1 = goles1;
	}

	public int getGoles2() {
		return Goles2;
	}

	public void setGoles2(int goles2) {
		Goles2 = goles2;
	}

	public String getFase() {
		return Fase;
	}

	public void setFase(String fase) {
		Fase = fase;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public static int getCantPartidos() {
		return cantPartidos;
	}

	public static void setCantPartidos(int cantPartidos) {
		Partido.cantPartidos = cantPartidos;
	}

	@Override
	public String toString() {
		return "Partido: " + equipo1.getNombre() + 
				" Goles =" + Goles1 + " VS " +
				" " + equipo2.getNombre() + 
				" Goles=" + Goles2
				+ "Fase=" + Fase + " fecha=" + fecha + "]\n";
	}
	
	public Equipo determinarGanador() {
		if (Goles1>Goles2) {
			return equipo1;
		} else {
			return equipo2;
		}
	}
	public String generarFase() {
		if (cantPartidos<=4) {
			return "Cuartos";
			
		} else if (cantPartidos>4 && cantPartidos<7) {
			return "Semifinal";
		}else {
			return "Final";
		}
	}
	
	public LocalDate generarFecha() {
		if (cantPartidos<=4) {
			return LocalDate.now();
		} else if (cantPartidos>4 && cantPartidos<7) {
			return LocalDate.now().plusDays(3);
		} else {
			return LocalDate.now().plusDays(5);
		}
	}
}
