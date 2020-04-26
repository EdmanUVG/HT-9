

public class Association<K extends Comparable<K>,V> implements Comparable<Association<K,V>>{

    // Key = english
    private final K key;
    // Value = espanol
    private V value;

    /**
     * Constructs a new Asociation with an specific key and value
     * @param key Palabra en ingles
     * @param value Palabra en espanol 
     */
    public Association(final K key, final V value){
        this.key = key;
        this.value = value;
    }

    /**
     * Obtiene la key de la asociacion.
     * @return Obtiene la palabra en ingles
     */
    public Object getKey() {
        return key;
    }

    /**
     * Obtiene el valor de la asociacion.
     * @return palabra en espanol
     */
    public Object getValue() {
        return value;
    }

    /**
     * Define un valor especifico para la asociacion. 
     * @param el valor de la asociacion.
     * @return el valor que se encuentra. 
     */
    public Object setValue(final Object value) {
        final V val = (V) value;
        return this.value = val;
    }

    @Override
    public int compareTo(final Association<K, V> o) {
        final Association ob = (Association) o;
        return key.toString().compareToIgnoreCase(ob.key.toString());
    }
}
