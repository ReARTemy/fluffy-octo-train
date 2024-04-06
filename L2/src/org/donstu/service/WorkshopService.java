package org.donstu.service;

import org.donstu.domain.Master;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import java.util.ArrayList;
import java.util.List;

import static javax.jws.soap.SOAPBinding.ParameterStyle.WRAPPED;
import static javax.jws.soap.SOAPBinding.Style.DOCUMENT;
import static javax.jws.soap.SOAPBinding.Use.LITERAL;

@WebService(serviceName = "WorkshopService", portName = "WorkshopPort",
    targetNamespace = "https://donstu.org/workshop")
@SOAPBinding(style = DOCUMENT, use = LITERAL, parameterStyle = WRAPPED)
public class WorkshopService {

    @WebMethod(operationName = "getMasters")
    public List<Master> getMasters() {
        List<Master> result = new ArrayList<>();
        result.add(new Master("Ivan", 5, 1000));
        result.add(new Master("Petr", 10, 2000));
        result.add(new Master("Alexey", 15, 3000));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
