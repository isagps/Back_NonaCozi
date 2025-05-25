package org.nonacozi.exception.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EntidadeNaoEncontradaException extends RuntimeException {
    public EntidadeNaoEncontradaException() {
        super("Objeto não encontrada.");
        log.warn("Objeto não encontrada.");
    }

    public EntidadeNaoEncontradaException(String message) {
        super(message);
        log.warn(message);
    }
}