package br.com.alura.lmello;

import br.com.alura.lmello.reflection.Transformator;

import java.lang.reflect.InvocationTargetException;

public class PessoaService {

    public PessoaDTO list() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoa = new PessoaRepository().list();

        PessoaDTO pessoaDTO = new Transformator().transform(pessoa);

        return pessoaDTO;
    }
}
