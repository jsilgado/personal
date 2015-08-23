package es.jsilgado.spring_aop_timer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

/*Lo primero que vemos en la clase es la anotacion
@Aspect que indica que la clase controla aspectos.
El unico metodo que hemos definido measureMethod tiene una anotacion, @Around.
Esta anotacion sirve para decirle que queremos que este metodo se ejecute “alrededor” de nuestro metodo,
es decir, que tenemos el control del metodo antes de su ejecucion y podemos ejecutarlo cuando queramos
o incluso no ejecutarlo, ademas de poder devolver otro valor en vez de el que nos devuelve la ejecucion de nuestro metodo
*/

@Aspect
public class FooAspect {
	@Around("execution(* es.jsilgado.spring_aop_timer.Foo.*(..))")
    public Object measureMethod(ProceedingJoinPoint pjp) throws Throwable
    {
        StopWatch sw = new StopWatch();
        Object retVal;
        try
        {
            sw.start(pjp.getTarget()+"."+pjp.getSignature());
            retVal = pjp.proceed();
        }
        catch (Throwable e)
        {
            throw e;
        }
        finally
        {
            sw.stop();
            System.out.println(sw.prettyPrint());
        }
        return retVal;
    }
}
