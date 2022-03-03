package com.eugene.spring.boot.EgWeb.impl.basecontrol;

public interface EgBaseDataImpl {
    /**
     * Controller name is unique item to identify the controller.
     * @return Controller Name
     */
    String getControllerName();
    /**
     * Service name doesn't have to be unique through the different controllers,
     * but MUST BE UNIQUE inside of same controller.
     * You can identify the service with this option.
     * @return Service Name
     */
    String getServiceName();
    /**
     * Service type is item to identify what the service type is.
     * There are sql, ftp, jwt for now.
     * @return Service Type Names
     */
    String getServiceType();
}
