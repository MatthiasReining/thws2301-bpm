package de.thws.bpm;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


@Named
@RequestScoped
public class SuperCalculation implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        System.out.println("super calculation in progress..");

        Integer in = (Integer) execution.getVariable("in");
        if  (in == null) in = 0;

        Integer result = in * 42;

        System.out.println("result: " + result);

        execution.setVariable("result", result);
    }
    
}
