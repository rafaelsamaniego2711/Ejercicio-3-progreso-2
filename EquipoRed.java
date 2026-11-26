public class EquipoRed {
    private String nombre;
    private String direccionIP;
    private String tipo;
    private double velocidadMbps;
    private boolean activo;

    public EquipoRed(String nombre, String direccionIP, String tipo, double velocidadMbps, boolean activo) {
        this.nombre = nombre;
        this.direccionIP = direccionIP;
        this.tipo = tipo;
        this.velocidadMbps = velocidadMbps;
        this.activo = activo;
    }

    public String getDireccionIP() {
        return direccionIP;
    }

    public double getVelocidadMbps() {
        return velocidadMbps;
    }

    public boolean isActivo() {
        return activo;
    }

    public String mostrarInformacion() {
        String estado = activo ? "Activo" : "Inactivo";
        return nombre + " [" + tipo + "] - IP: " + direccionIP + " - " + velocidadMbps + " Mbps - " + estado;
    }
}
