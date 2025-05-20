package ar.org.ttech;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {
    private int idPedido;
    private int idCliente;
    private LocalDateTime fechaPedido;
    private List<Articulo> articulos;
    private EstadoPedido estado;

    public Pedido(int idPedido, int idCliente) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.fechaPedido = LocalDateTime.now();
        this.articulos = new ArrayList<>();
        this.estado = EstadoPedido.PENDIENTE;
    }

    public void agregarArticulo(Articulo articulo, int cantidad) {
        //hacer
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public int getIdPedido() {
        return idPedido;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }
    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void agregarArticulo(Articulo articulo) {
        this.articulos.add(articulo);
    }

    public void eliminarArticulo(int idArticulo) {
        this.articulos.removeIf(a ->a.getId() == idArticulo);
    }

    public double calcularTotal() {
        double total = 0;
        for (Articulo articulo : articulos) {
            total += articulo.getPrecio();
        }
        return total;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

}

enum EstadoPedido {
    PENDIENTE,
    PROCESANDO,
    ENVIADO,
    ENTREGADO,
    CANCELADO
}
