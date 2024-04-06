package org.dstu.bpm;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@ExternalTaskSubscription("notify-no-masters")
public class NotifyNoAvailableMastersHandler implements ExternalTaskHandler {
    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        Logger.getLogger("notify-no-masters").log(Level.WARNING, "No masters my friend..");
        System.out.println("No masters my friend..");
        externalTaskService.complete(externalTask);
    }
}
