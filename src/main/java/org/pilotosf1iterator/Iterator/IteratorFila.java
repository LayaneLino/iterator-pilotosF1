package org.pilotosf1iterator.Iterator;

import org.pilotosf1iterator.Model.Piloto;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorFila implements Iterator<Piloto> {
    private final Iterator<Piloto> iterator;

    public IteratorFila(LinkedList<Piloto> fila) {
        this.iterator = fila.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Piloto next() {
        return iterator.next();
    }

}

