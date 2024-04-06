package org.donstu;

import org.donstu.client.Master;
import org.donstu.client.WorkshopService;
import org.donstu.client.WorkshopService_Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ServiceClient {
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
        List<Master> masters = port.getMasters();
        masters.forEach(master -> System.out.println("Master{" +
                "name='" + master.getName() + '\'' +
                ", experience=" + master.getExperience() +
                ", salary=" + master.getSalary() +
                '}'));
    }

    public static void main(String[] args) {
        URL wsdlUrl = getWsdlUrl("http://127.0.0.1:8088/workshop?wsdl");
        ServiceClient client = new ServiceClient();
        client.processMasters(wsdlUrl);
    }
}
