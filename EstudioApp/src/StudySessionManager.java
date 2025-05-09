import java.util.List;

public class StudySessionManager {
    private BloqueTematico bloqueTematico;
    private TipoEjercicio tipoEjercicio;
    private BancoDeEstudio bancoDeEstudio;

    private List<PreguntaTest> preguntasTestActuales;
    private List<EjercicioRellenarCodigo> ejerciciosRellenarActuales;
    private int indiceActual;

    private int respuestasCorrectas;
    private int respuestasIncorrectas;

    public StudySessionManager(BloqueTematico bloque, TipoEjercicio tipo) {
        this.bloqueTematico = bloque;
        this.tipoEjercicio = tipo;
        this.bancoDeEstudio = new BancoDeEstudio();
        this.indiceActual = 0;
        this.respuestasCorrectas = 0;
        this.respuestasIncorrectas = 0;
        cargarEjercicios();
    }

    private void cargarEjercicios() {
        if (tipoEjercicio == TipoEjercicio.TEST) {
            preguntasTestActuales = bancoDeEstudio.getPreguntasTest(bloqueTematico);
        } else if (tipoEjercicio == TipoEjercicio.RELLENAR_CODIGO) {
            ejerciciosRellenarActuales = bancoDeEstudio.getEjerciciosRellenarCodigo(bloqueTematico);
        }
    }

    public boolean hayEjerciciosDisponibles() {
        if (tipoEjercicio == TipoEjercicio.TEST) {
            return preguntasTestActuales != null && !preguntasTestActuales.isEmpty();
        } else if (tipoEjercicio == TipoEjercicio.RELLENAR_CODIGO) {
            return ejerciciosRellenarActuales != null && !ejerciciosRellenarActuales.isEmpty();
        }
        return false;
    }

    public ItemEstudio getEjercicioActual() {
        if (tipoEjercicio == TipoEjercicio.TEST) {
            if (preguntasTestActuales != null && indiceActual < preguntasTestActuales.size()) {
                return preguntasTestActuales.get(indiceActual);
            }
        } else if (tipoEjercicio == TipoEjercicio.RELLENAR_CODIGO) {
            if (ejerciciosRellenarActuales != null && indiceActual < ejerciciosRellenarActuales.size()) {
                return ejerciciosRellenarActuales.get(indiceActual);
            }
        }
        return null;
    }

    public void avanzarSiguienteEjercicio() {
        indiceActual++;
    }

    public boolean esUltimoEjercicio() {
        if (tipoEjercicio == TipoEjercicio.TEST) {
            return indiceActual >= preguntasTestActuales.size() -1;
        } else if (tipoEjercicio == TipoEjercicio.RELLENAR_CODIGO) {
            return indiceActual >= ejerciciosRellenarActuales.size() -1;
        }
        return true;
    }

    public TipoEjercicio getTipoEjercicioActual() {
        return tipoEjercicio;
    }

     public int getNumeroTotalEjercicios() {
        if (tipoEjercicio == TipoEjercicio.TEST) {
            return preguntasTestActuales != null ? preguntasTestActuales.size() : 0;
        } else if (tipoEjercicio == TipoEjercicio.RELLENAR_CODIGO) {
            return ejerciciosRellenarActuales != null ? ejerciciosRellenarActuales.size() : 0;
        }
        return 0;
    }

    public int getIndiceEjercicioActual() {
        return indiceActual;
    }
    
    public void registrarRespuesta(boolean correcta) {
        if (correcta) {
            respuestasCorrectas++;
        } else {
            respuestasIncorrectas++;
        }
    }

    public int getRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public int getRespuestasIncorrectas() {
        return respuestasIncorrectas;
    }

    public int getTotalIntentos() {
        return respuestasCorrectas + respuestasIncorrectas;
    }

    public double getPorcentajeAciertos() {
        int totalIntentos = getTotalIntentos();
        if (totalIntentos == 0) {
            return 0.0; 
        }
        return ((double) respuestasCorrectas / totalIntentos) * 100.0;
    }
}