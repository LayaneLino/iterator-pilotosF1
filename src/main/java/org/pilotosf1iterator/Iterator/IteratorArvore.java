package org.pilotosf1iterator.Iterator;

import org.pilotosf1iterator.Model.Piloto;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class IteratorArvore implements Iterator<Piloto> {
    private final LinkedList<Piloto> elementos;

    public IteratorArvore(TreeSet<Piloto> arvore) {
        this.elementos = new LinkedList<>(arvore);
    }

    @Override
    public boolean hasNext() {
        return !elementos.isEmpty();
    }

    @Override
    public Piloto next() {
        if (!hasNext()) throw new java.util.NoSuchElementException();
        return elementos.removeFirst();
    }
}

