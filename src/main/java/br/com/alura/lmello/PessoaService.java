package br.com.alura.lmello;

public class PessoaService {

    public PessoaDTO list() {
        Pessoa pessoa = new PessoaRepository().list();

        return new PessoaDTO(pessoa.getNome(), pessoa.getCpf());
    }
}
