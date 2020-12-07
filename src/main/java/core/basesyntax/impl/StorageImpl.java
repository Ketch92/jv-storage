package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int SIZE = 10;
    private V[] values;
    private K[] keys;

    public StorageImpl() {
        keys = (K[]) new Object[SIZE];
        values = (V[]) new Object[SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < SIZE; i++) {
            if (keys[i] == null && values[i] == null
                    || key == keys[i]) {
                keys[i] = key;
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < SIZE; i++) {
            if (key == null && keys[i] == null
                    || key != null && keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }
}
