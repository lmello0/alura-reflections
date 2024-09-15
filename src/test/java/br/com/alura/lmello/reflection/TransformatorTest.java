package br.com.alura.lmello.reflection;

import br.com.alura.lmello.Endereco;
import br.com.alura.lmello.Pessoa;
import br.com.alura.lmello.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class TransformatorTest {

    Pessoa pessoa = new Pessoa(1, "Lucas", "1234");
    Endereco endereco = new Endereco("Rua 10", 20);

    @Test
    public void shouldTransform() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformator transformator = new Transformator();

        PessoaDTO pessoaDTO = transformator.transform(pessoa);

        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);

        Assertions.assertAll(
                () -> Assertions.assertEquals(pessoa.getNome(), pessoaDTO.getNome()),
                () -> Assertions.assertEquals(pessoa.getCpf(), pessoaDTO.getCpf())
        );
    }

    @Test
    public void shouldNotTransform() {
        Transformator transformator = new Transformator();

        Assertions.assertThrows(ClassNotFoundException.class, () -> transformator.transform(endereco));
    }

    @Test
    public void shouldNotTransformWhenSomeFieldIsNull() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoaSemCpf = new Pessoa("Lucas");

        Transformator transformator = new Transformator();
        PessoaDTO pessoaDTOSemCpf = transformator.transform(pessoaSemCpf);

        Assertions.assertEquals(pessoaSemCpf.getNome(), pessoaDTOSemCpf.getNome());
        Assertions.assertNull(pessoaSemCpf.getCpf());
    }
}
