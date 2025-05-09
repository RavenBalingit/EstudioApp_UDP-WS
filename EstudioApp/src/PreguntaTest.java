import java.util.List;

public class PreguntaTest extends ItemEstudio {
    private List<String> opciones;
    private String respuestaCorrecta; 

    public PreguntaTest(String enunciado, List<String> opciones, String respuestaCorrecta) {
        super(enunciado);
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public boolean verificarRespuesta(String respuestaUsuario) {
        return respuestaCorrecta.equalsIgnoreCase(respuestaUsuario.trim());
    }
}