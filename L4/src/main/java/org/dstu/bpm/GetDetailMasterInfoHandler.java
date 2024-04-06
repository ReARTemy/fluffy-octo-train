package org.dstu.bpm;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;


@Component
@ExternalTaskSubscription("master-detail")
public class GetDetailMasterInfoHandler implements ExternalTaskHandler {
    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        Logger.getLogger("master-detail").log(Level.INFO, "Here is detail info my friend");

//        RestTemplate rt = new RestTemplate();
//        Object response = rt.getForObject("http://localhost:8082/JavaRest/rest/master/1", Object.class);
//        System.out.println(response);

        externalTaskService.complete(externalTask);
    }
}
