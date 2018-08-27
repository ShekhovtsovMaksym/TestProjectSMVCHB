package shekhovtsov.maksym.controller;

import org.springframework.stereotype.Component;
import com.connecture.logging.exectime.LogExecutionTime;

@Component
public class ExternalClass
{

  @LogExecutionTime
  public void testMethod()
  {
    System.out.println("lololo");
  }
}
