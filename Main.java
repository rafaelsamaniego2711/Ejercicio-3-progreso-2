public class Main {
    public static void main(String[] args) {
        EquipoRed[] equipos = new EquipoRed[5];
        equipos[0] = new EquipoRed("RouterCentral", "192.168.1.1", "Router", 1000, true);
        equipos[1] = new EquipoRed("SwitchPiso1", "192.168.1.2", "Switch", 1000, true);
        equipos[2] = new EquipoRed("AP-Lobby", "192.168.1.10", "Access Point", 300, true);
        equipos[3] = new EquipoRed("ServidorApp", "192.168.1.50", "Servidor", 10000, true);
        equipos[4] = new EquipoRed("FirewallPerimetral", "192.168.1.254", "Firewall", 2500, false);

        AnalizadorRed analizador = new AnalizadorRed(equipos);

        System.out.println(analizador.listarEquipos());
        System.out.println("Activos: " + analizador.contarActivos());
        System.out.printf("Velocidad promedio: %.2f Mbps%n", analizador.calcularVelocidadPromedio());

        EquipoRed router = analizador.buscarPorIP("192.168.1.1");
        System.out.println("Buscar 192.168.1.1: " + (router != null ? router.mostrarInformacion() : "No encontrado"));

        EquipoRed ipFalsa = analizador.buscarPorIP("10.0.0.99");
        System.out.println("Buscar 10.0.0.99: " + (ipFalsa != null ? ipFalsa.mostrarInformacion() : "null"));

        EquipoRed masRapido = analizador.obtenerEquipoMasRapido();
        System.out.println("Más rápido: " + (masRapido != null ? masRapido.mostrarInformacion() : "Ninguno"));
    }
}
