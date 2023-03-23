package ejercicios.integrador;

import java.util.ArrayList;

public class Ronda {
    private int nro;
    private ArrayList<Partido> partidos;

    public Ronda(int nro, ArrayList<Partido> partidos) {
        this.nro = nro;
        this.partidos = partidos;
    }

    public int puntos(Equipo equipo1) {
        int puntos = 0;
        for (Partido partido : partidos) {
            if (partido.resultado(equipo1) == ResultadoEnum.GANADOR) {
                puntos += 3;
            } else if (partido.resultado(equipo1) == ResultadoEnum.EMPATE) {
                puntos += 1;
            }
        }
        return puntos;
    }
}

