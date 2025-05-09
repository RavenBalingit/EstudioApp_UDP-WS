import java.util.List;
import java.util.Map;

public class EjercicioRellenarCodigo extends ItemEstudio {
    private String codigoConHuecos;
    private List<String> elementosSugeridos;
    private Map<Integer, String> soluciones;

    public EjercicioRellenarCodigo(String enunciado, String codigoConHuecos, List<String> elementosSugeridos, Map<Integer, String> soluciones) {
        super(enunciado);
        this.codigoConHuecos = codigoConHuecos;
        this.elementosSugeridos = elementosSugeridos;
        this.soluciones = soluciones;
    }

    public String getCodigoConHuecos() {
        return codigoConHuecos;
    }

    public List<String> getElementosSugeridos() {
        return elementosSugeridos;
    }

    public Map<Integer, String> getSoluciones() {
        return soluciones;
    }

    public int getNumeroDeHuecos() {
        return soluciones.size();
    }

    public boolean verificarRespuestas(Map<Integer, String> respuestasUsuario) {

        for (Map.Entry<Integer, String> solucionEntry : soluciones.entrySet()) {
            Integer numeroHueco = solucionEntry.getKey();
            String respuestaCorrecta = solucionEntry.getValue();
            String respuestaUsuario = respuestasUsuario.get(numeroHueco);

            if (respuestaUsuario == null || !respuestaCorrecta.trim().equalsIgnoreCase(respuestaUsuario.trim())) {
                return false;
            }
        }
        return true; 
    }
}