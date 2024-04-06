package org.donstu;

import org.donstu.async.GetMastersResponse;
import org.donstu.async.Master;
import org.donstu.async.WorkshopService;
import org.donstu.async.WorkshopService_Service;

import javax.xml.namespace.QName;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ServiceClientAsync {
    private static final QName FQDN = new QName("https://donstu.org/workshop", "WorkshopService");

    private static URL getWsdlUrl(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return url;
    }


    public void processMasters(URL url) {
        WorkshopService_Service svc = new WorkshopService_Service(url, FQDN);
        WorkshopService port = svc.getWorkshopPort();
        Response<GetMastersResponse> response = port.getMastersAsync();

        while (!response.isDone()) {
            System.out.println("Pooling the result...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            List<Master> masters = response.get().getReturn();
            masters.forEach(master -> System.out.println("Master{" +
                    "name='" + master.getName() + '\'' +
                    ", experience=" + master.getExperience() +
                    ", salary=" + master.getSalary() +
                    '}'));
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    class WorkshopAsyncHandler implements AsyncHandler<GetMastersResponse> {
        private GetMastersResponse response;

        @Override
        public void handleResponse(Response<GetMastersResponse> res) {
            System.out.println("Result is ready!");
            try {
                response = res.get();
                List<Master> masters = response.getReturn();
                masters.forEach(master -> System.out.println("Master{" +
                        "name='" + master.getName() + '\'' +
                        ", experience=" + master.getExperience() +
                        ", salary=" + master.getSalary() +
                        '}'));
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }



    public void processMastersCallback(URL url) {
        WorkshopService_Service svc = new WorkshopService_Service(url, FQDN);
        WorkshopService port = svc.getWorkshopPort();
        WorkshopAsyncHandler handler = new WorkshopAsyncHandler();
        Future<?> response = port.getMastersAsync(handler);
        try {
            Thread.sleep(5000);
            System.out.println("Waited 5s");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        URL wsdlUrl = getWsdlUrl("http://127.0.0.1:8088/workshop?wsdl");
        ServiceClientAsync client = new ServiceClientAsync();
        client.processMasters(wsdlUrl);
        client.processMastersCallback(wsdlUrl);
    }
}
