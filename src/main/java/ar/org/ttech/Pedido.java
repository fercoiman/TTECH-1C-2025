package ar.org.ttech;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private String idPedido;
    private String cliente;
    private LocalDateTime fecha;
    private List<LineaPedido> lineas;
    private EstadoPedido estado;

    public Pedido(String idPedido, String cliente) {
        this.idPedido = Objects.requireNonNull(idPedido);
        this.cliente = Objects.requireNonNull(cliente);
        this.fecha = LocalDateTime.now();
        this.lineas = new ArrayList<>();
        this.estado = EstadoPedido.PENDIENTE;
    }

    public void agregarArticulo(Articulo articulo, int cantidad) {
        Objects.requireNonNull(articulo, "El artículo no puede ser nulo");

        // Buscar si ya existe el artículo en el pedido
        for (LineaPedido linea : lineas) {
            if (linea.getArticulo().equals(articulo)) {
                linea.setCantidad(linea.getCantidad() + cantidad);
                return;
            }
        }

        // Si no existe, agregar nueva línea
        lineas.add(new LineaPedido(articulo, cantidad));
    }

    public void eliminarArticulo(String idArticulo) {
        lineas.removeIf(linea -> linea.getArticulo().getId().equals(idArticulo));
    }

    public double calcularTotal() {
        return lineas.stream()
                .mapToDouble(LineaPedido::calcularSubtotal)
                .sum();
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        this.estado = Objects.requireNonNull(nuevoEstado);
    }

    // Getters
    public String getIdPedido() {
        return idPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public List<LineaPedido> getLineas() {
        return new ArrayList<>(lineas);
    } // Defensive copy

    public EstadoPedido getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Pedido #%s - Cliente: %s\n", idPedido, cliente));
        sb.append(String.format("Fecha: %s - Estado: %s\n", fecha, estado));
        sb.append("Artículos:\n");
        lineas.forEach(linea -> sb.append("  ").append(linea).append("\n"));
        sb.append(String.format("TOTAL: $%.2f", calcularTotal()));
        return sb.toString();
    }
}

enum EstadoPedido {
    PENDIENTE,
    PROCESANDO,
    ENVIADO,
    ENTREGADO,
    CANCELADO
}