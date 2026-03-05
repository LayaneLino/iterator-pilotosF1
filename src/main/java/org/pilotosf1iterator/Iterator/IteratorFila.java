package org.pilotosf1iterator.Iterator;

import org.pilotosf1iterator.Model.Piloto;
import java.util.Iterator;
import java.util.LinkedList;

public class IteratorFila implements Iterator<Piloto> {
    private final LinkedList<Piloto> dados;
    private int pos;

    public IteratorFila(LinkedList<Piloto> dados) {
        this.dados = dados;
        this.pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < dados.size();
    }

    @Override
    public Piloto next() {
        if (!hasNext()) throw new java.util.NoSuchElementException();
        return dados.get(pos++);
    }

}

