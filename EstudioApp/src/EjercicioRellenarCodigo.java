import java.util.List;
import java.util.Map;

public class EjercicioRellenarCodigo extends ItemEstudio {
    private String codigoConHuecos;
    private List<String> elementosSugeridos;
    private Map<Integer, String> soluciones; // Clave: número de hueco, Valor: palabra correcta

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
        // Primero, verifica si el número de respuestas proporcionadas coincide con el número de soluciones esperadas.
        // Esto podría ser opcional si permites respuestas parciales, pero para una verificación completa es útil.
        // if (respuestasUsuario.size() != soluciones.size()) {
        // return false;
        // }

        for (Map.Entry<Integer, String> solucionEntry : soluciones.entrySet()) {
            Integer numeroHueco = solucionEntry.getKey();
            String respuestaCorrecta = solucionEntry.getValue();
            String respuestaUsuario = respuestasUsuario.get(numeroHueco);

            // Si no hay respuesta para un hueco o la respuesta no coincide (ignorando mayúsculas/minúsculas y espacios)
            if (respuestaUsuario == null || !respuestaCorrecta.trim().equalsIgnoreCase(respuestaUsuario.trim())) {
                return false;
            }
        }
        return true; // Todas las respuestas proporcionadas coinciden con las soluciones
    }
}