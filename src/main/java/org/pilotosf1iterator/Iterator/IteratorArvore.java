package org.pilotosf1iterator.Iterator;

import org.pilotosf1iterator.Model.Piloto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class IteratorArvore implements Iterator<Piloto> {
    private final List<Piloto> lista;
    private int pos;

    public IteratorArvore(TreeSet<Piloto> arvore) {
        this.lista = new ArrayList<>(arvore);
        this.pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < lista.size();
    }

    @Override
    public Piloto next() {
        if (!hasNext()) throw new java.util.NoSuchElementException();
        return lista.get(pos++);
    }
}

