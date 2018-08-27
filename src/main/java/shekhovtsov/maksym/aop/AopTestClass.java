package shekhovtsov.maksym.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopTestClass
{
//  @Pointcut("@annotation(AopInterface)")
//  public void pointcut(){}
//
//  @Around("pointcut()")
//  public Object loggingAdvice(ProceedingJoinPoint joinPoint) throws Throwable
//  {
//    System.out.println("aspect");
//    return joinPoint.proceed();
//  }

  @Around("@annotation(AopInterface)")
  public Object loggingAdvice(ProceedingJoinPoint joinPoint) throws Throwable
  {
    System.out.println("aspect");
    return joinPoint.proceed();
  }
}
