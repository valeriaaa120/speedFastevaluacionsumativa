package cl.duoc.app;


import cl.duoc.model.EstadoPedido;
import cl.duoc.model.Pedido;
import cl.duoc.model.Repartidor;
import cl.duoc.model.ZonaDeCarga;

public class Main {
    public static void main(String[] args) {

                ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

                // agregar pedidos
                zonaDeCarga.agregarPedido(
                        new Pedido(1, "Av. siempre viva 123", EstadoPedido.PENDIENTE)
                );

                zonaDeCarga.agregarPedido(
                        new Pedido(2, "Brasil 456", EstadoPedido.PENDIENTE)
                );

                zonaDeCarga.agregarPedido(
                        new Pedido(3, "Av. España 789", EstadoPedido.PENDIENTE)
                );

                zonaDeCarga.agregarPedido(
                        new Pedido(4, "Calle Independencia 321", EstadoPedido.PENDIENTE)
                );

                zonaDeCarga.agregarPedido(
                        new Pedido(5, "Av. Argentina 654", EstadoPedido.PENDIENTE)
                );

                // Crear repartidores
                Thread repartidor1 = new Thread(
                        new Repartidor("Roberta Gonzales", zonaDeCarga)
                );

                Thread repartidor2 = new Thread(
                        new Repartidor("María Trujillo", zonaDeCarga)
                );

                Thread repartidor3 = new Thread(
                        new Repartidor("Agustina Cáceres", zonaDeCarga)
                );

                // iniciar los hilos
                repartidor1.start();
                repartidor2.start();
                repartidor3.start();

                // Esperar a que terminen
                try {
                    repartidor1.join();
                    repartidor2.join();
                    repartidor3.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println(
                        "Todos los pedidos han sido entregados correctamente"
                );
            }

}
