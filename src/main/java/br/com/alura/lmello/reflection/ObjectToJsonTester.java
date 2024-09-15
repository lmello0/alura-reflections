package br.com.alura.lmello.reflection;

import br.com.alura.lmello.Pessoa;

public class ObjectToJsonTester {
    public static void main(String[] args) {
        Pessoa p = new Pessoa(1, "Lucas", "1234");
        ObjectToJson objectToJson = new ObjectToJson();

        System.out.println(objectToJson.transform(p));
    }
}
