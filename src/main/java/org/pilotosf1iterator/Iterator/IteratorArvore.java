package org.pilotosf1iterator.Iterator;

import org.pilotosf1iterator.Model.Piloto;

import java.util.Iterator;
import java.util.TreeSet;

public class IteratorArvore implements Iterator<Piloto> {
    private final Iterator<Piloto> iterator;

    public IteratorArvore(TreeSet<Piloto> arvore) {
        this.iterator = arvore.iterator();
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

