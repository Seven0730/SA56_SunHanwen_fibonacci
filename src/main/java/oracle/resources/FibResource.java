package oracle.resources;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonProperty;
import oracle.pojo.Fib;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Path("/fibonacci")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FibResource {

    @POST
    public Response getFib(@Valid Fib fib){
        List<BigInteger> fibonacci = calculate(fib.getElement()-1);
        List<BigInteger> sorted = sortFib(fibonacci);
        Fib response = new Fib(fibonacci, sorted);
        return Response.ok(response).build();
    }
    public static List<BigInteger> calculate(int n){
        List<BigInteger> fibonacci = new ArrayList<>();
        BigInteger[] dp = new BigInteger[n + 2];

        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        for (int i = 0; i <= n; i++) {
            fibonacci.add(dp[i]);
        }
        return fibonacci;
    }

    public static List<BigInteger> sortFib(List<BigInteger> fib){
        List<BigInteger> result = new ArrayList<>();
        int flag = 0;
        for (BigInteger num : fib) {
            if (num.testBit(0)) {
                result.add(flag , num);
            } else {
                result.add(0 , num);
                flag++;
            }
        }
        return result;
    }
}


