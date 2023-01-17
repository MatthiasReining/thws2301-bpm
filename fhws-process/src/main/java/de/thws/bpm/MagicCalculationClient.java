package de.thws.bpm;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.ClientBuilder;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
@RequestScoped
public class MagicCalculationClient implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        System.out.println("magic calc in prgoress...");

        Integer in = (Integer) execution.getVariable("in");
        if (in == null)
            in = 0;

        Integer out = ClientBuilder.newClient()
                .target("http://host.docker.internal:8082/calc")
                .queryParam("in", in)
                .request()
                .get(Integer.class);

        execution.setVariable("result", out);

    }

}
