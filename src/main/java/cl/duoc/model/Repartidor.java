package cl.duoc.model;

import java.lang.Runnable;

public class Repartidor implements Runnable {
    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ZonaDeCarga getZonaDeCarga() {
        return zonaDeCarga;
    }

    public void setZonaDeCarga(ZonaDeCarga zonaDeCarga) {
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {

        while (true) {

            Pedido pedido = zonaDeCarga.retirarPedido();

            if (pedido == null) {
                break;
            }

            System.out.println(
                    nombre + " retiró el pedido " + pedido.getId() + " y está EN_REPARTO."
            );

            try {
                // Simula el tiempo de entrega
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            pedido.setEstado(EstadoPedido.ENTREGADO);

            System.out.println(
                    nombre + " entregó el pedido "
                            + pedido.getId()
                            + " en "
                            + pedido.getDireccionEntrega()
                            + ". Estado: "
                            + pedido.getEstado()
            );
        }

        System.out.println(nombre + " no tiene más pedidos.");
    }
}

