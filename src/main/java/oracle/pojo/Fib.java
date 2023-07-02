package oracle.pojo;



import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.List;

public class Fib {

    @JsonProperty("elements")
    private int element;

    private List<BigInteger> fibonacci;

    private List<BigInteger> sortedfib;

    public Fib() {

    }
    public Fib(List<BigInteger> fibonacci, List<BigInteger> sortedfib) {
        this.fibonacci = fibonacci;
        this.sortedfib = sortedfib;
    }

    @JsonProperty
    public List<BigInteger> getFibonacci() {
        return fibonacci;
    }
    @JsonProperty
    public List<BigInteger> getSortedfib() {
        return sortedfib;
    }

    public int getElement() {
        return element;
    }
}
