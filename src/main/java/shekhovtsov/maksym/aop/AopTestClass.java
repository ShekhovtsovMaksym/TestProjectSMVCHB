package shekhovtsov.maksym.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopTestClass
{
  @Around("@annotation(Interface)")
  public Object loggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
  {
    System.out.println("aspect");
    return "";
  }
}
