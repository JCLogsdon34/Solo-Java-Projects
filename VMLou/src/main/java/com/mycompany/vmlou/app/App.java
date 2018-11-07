package com.mycompany.vmlou.app;

import com.mycompany.vmlou.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author JCLog
 */
public class App {
    public static void main(String[] args){
        /*
        UserIO myIo = new UserIOImpl();
        View myView = new View(myIo);
        VMLouDao myDao = new VMLouDaoImpl();
        AuditDao myAuditDao = new AuditDaoImpl();
        ServiceLayer service = new ServiceLayerImpl(myDao, myAuditDao);
        Controller controller
                = new Controller(service, myView);
        controller.run();   
*/
        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller controller = 
           ctx.getBean("controller", Controller.class);
        controller.run();
    }
}
