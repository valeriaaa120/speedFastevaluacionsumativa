package cl.duoc.model;
import java.util.ArrayList;
import java.util.List;


public class ZonaDeCarga {

    private List <Pedido> pedidos;

    public ZonaDeCarga() {
        pedidos = new ArrayList<>();
    }

        //synchronized para asegurar que no haya problemas de concurrencia
        public synchronized void agregarPedido(Pedido p) {
            pedidos.add(p);
            System.out.println("Pedido agregado a la zona de carga: " + p.getId());
        }


    public synchronized Pedido retirarPedido() {

        for (Pedido pedido : pedidos) {

            if (pedido.getEstado() == EstadoPedido.PENDIENTE) {

                pedido.setEstado(EstadoPedido.EN_REPARTO);
                pedidos.remove(pedido);

                return pedido;
            }
        }

        return null;
    }
    }

