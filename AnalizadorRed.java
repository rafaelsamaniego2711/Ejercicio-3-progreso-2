public class AnalizadorRed {
    private EquipoRed[] equipos;

    public AnalizadorRed(EquipoRed[] equipos) {
        this.equipos = equipos;
    }

    public String listarEquipos() {
        String resultado = "";
        if (equipos == null) {
            return resultado;
        }
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null) {
                resultado += equipos[i].mostrarInformacion() + "\n";
            }
        }
        return resultado;
    }

    public int contarActivos() {
        int contador = 0;
        if (equipos == null) {
            return contador;
        }
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null && equipos[i].isActivo()) {
                contador++;
            }
        }
        return contador;
    }

    public double calcularVelocidadPromedio() {
        if (equipos == null) {
            return 0.0;
        }
        double suma = 0.0;
        int validos = 0;
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null) {
                suma += equipos[i].getVelocidadMbps();
                validos++;
            }
        }
        return validos > 0 ? suma / validos : 0.0;
    }

    public EquipoRed buscarPorIP(String direccionIP) {
        if (equipos == null || direccionIP == null) {
            return null;
        }
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null && direccionIP.equals(equipos[i].getDireccionIP())) {
                return equipos[i];
            }
        }
        return null;
    }

    public EquipoRed obtenerEquipoMasRapido() {
        if (equipos == null) {
            return null;
        }
        EquipoRed masRapido = null;
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null) {
                if (masRapido == null || equipos[i].getVelocidadMbps() > masRapido.getVelocidadMbps()) {
                    masRapido = equipos[i];
                }
            }
        }
        return masRapido;
    }
}
