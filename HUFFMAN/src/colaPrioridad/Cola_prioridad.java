package colaPrioridad;

public class Cola_prioridad{
	
	private class NodoPrioridad{
		int info;
		int prioridad;
		NodoPrioridad sig;
	}
	
    NodoPrioridad mayorPrioridad;

    public void InicializarCola() {
        // Inicializa la cola de prioridad
        mayorPrioridad = null;
    }

    public void AcolarPrioridad(int x, int prioridad) {
        // Crea el nuevo nodo que se va a acolar
        NodoPrioridad nuevo = new NodoPrioridad();
        nuevo.info = x;
        nuevo.prioridad = prioridad;

        // Si la cola está vacía o el nuevo nodo tiene mayor prioridad
        // que el primero, lo inserta al principio
        if (mayorPrioridad == null || prioridad > mayorPrioridad.prioridad) {
            nuevo.sig = mayorPrioridad;
            mayorPrioridad = nuevo;
        } else {
            // Sabemos que mayorPrioridad no es null
            NodoPrioridad aux = mayorPrioridad;
            
            // Busca la posición correcta según la prioridad
            while (aux.sig != null && aux.sig.prioridad >= prioridad) {
                aux = aux.sig;
            }
            
            // Inserta el nuevo nodo en la posición adecuada
            nuevo.sig = aux.sig;
            aux.sig = nuevo;
        }
    }

    public void Desacolar() {
        // Elimina el nodo con mayor prioridad (el primero)
        mayorPrioridad = mayorPrioridad.sig;
    }

    public int Primero() {
        // Devuelve la información del nodo con mayor prioridad
        return mayorPrioridad.info;
    }

    public boolean ColaVacia() {
        // Devuelve true si la cola está vacía
        return (mayorPrioridad == null);
    }

    public int Prioridad() {
        // Devuelve la prioridad del nodo con mayor prioridad
        return mayorPrioridad.prioridad;
    }
}
