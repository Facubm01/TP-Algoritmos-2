public interface ConjuntoTDA {
    void InicializarConjunto();  //sin precondiciones
    void Agregar(int x);        //conjunto inicializado
    int Elegir();               //conjunto inicializado y no vacio
    boolean ConjuntoVacio();    //conjunto inicializaod
    void Sacar(int x);               //conjunto inicializado
    boolean Pertenece(int x);        //cola inicializada
}
