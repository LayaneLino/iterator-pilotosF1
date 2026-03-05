package org.pilotosf1iterator.Iterator;

import org.pilotosf1iterator.Model.Piloto;
import java.util.Iterator;
import java.util.Stack;

public class IteratorPilha implements Iterator<Piloto> {
    private final Stack<Piloto> pilha;
    private int pos;

    public IteratorPilha(Stack<Piloto> pilha){
        this.pilha = pilha;
        this.pos = pilha.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return pos >= 0;
    }

    @Override
    public Piloto next() {
        if (!hasNext()) throw new java.util.NoSuchElementException();
        return pilha.get(pos--);
    }
}
