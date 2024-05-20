public class Main {
    public static void main(String[] args) {
        ColaPrioridadA0 cola = new ColaPrioridadA0();
        cola.InicializarCola();

        // Añadir 15 clientes a la cola
        int[][] clientes = {
                {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 2},
                {6, 1}, {7, 3}, {8, 2}, {9, 3}, {10, 1},
                {11, 2}, {12, 3}, {13, 1}, {14, 2}, {15, 3}
        };

        // Recorremos la matriz y acolamos cada cliente, con su id, por su prioridad
        for (int[] cliente : clientes) {
            cola.AcolarPrioridad(cliente[0], cliente[1]);
        }

        //Creamos los 3 conjuntos
        ConjuntoTA conjuntoEmpresa = new ConjuntoTA();
        ConjuntoTA conjuntoParticularCliente = new ConjuntoTA();
        ConjuntoTA conjuntoParticularNoCliente = new ConjuntoTA();
        conjuntoEmpresa.InicializarConjunto();
        conjuntoParticularCliente.InicializarConjunto();
        conjuntoParticularNoCliente.InicializarConjunto();

        // Pasamos los clientes de la cola a cada conjunto
        while (!cola.ColaVacia()) {
            int cliente = cola.Primero();
            int prioridad = cola.Prioridad();
            cola.Desacolar();

            // Clasificamos los clientes en los conjuntos correspondientes
            switch (prioridad) {
                case 1:
                    conjuntoEmpresa.Agregar(cliente);   // Cliente empresarial
                    break;
                case 2:
                    conjuntoParticularCliente.Agregar(cliente);  // Cliente particular
                    break;
                case 3:
                    conjuntoParticularNoCliente.Agregar(cliente); // No cliente particular
                    break;
            }
        }

        // Mostrar los conjuntos resultantes
        System.out.println("Conjunto Empresa: ");
        while (!conjuntoEmpresa.ConjuntoVacio()) {
            int cliente = conjuntoEmpresa.Elegir();
            conjuntoEmpresa.Sacar(cliente);
            System.out.print(cliente + " ");
        }
        System.out.println();

        System.out.println("Conjunto Particular Cliente: ");
        while (!conjuntoParticularCliente.ConjuntoVacio()) {
            int cliente = conjuntoParticularCliente.Elegir();
            conjuntoParticularCliente.Sacar(cliente);
            System.out.print(cliente + " ");
        }
        System.out.println();

        System.out.println("Conjunto Particular No Cliente: ");
        while (!conjuntoParticularNoCliente.ConjuntoVacio()) {
            int cliente = conjuntoParticularNoCliente.Elegir();
            conjuntoParticularNoCliente.Sacar(cliente);
            System.out.print(cliente + " ");
        }
    }
}
