package annotations;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

public class CovertingJavaToXml {
    public static void main(String[] args)
    {
        try {
            DependencyAttribute depedency= new DependencyAttribute();
            depedency.setUp();
            depedency.openApplication();
            depedency.signIN();
            depedency.searchCustomer();
            depedency.searchProduct();
            depedency.signOut();
            depedency.tearDown();
            JAXBContext jaxbContext = JAXBContext.newInstance(DependencyAttribute.class);
            Marshaller marshaler = jaxbContext.createMarshaller();

            File file=new File("C:\\Users\\PMonaheng\\IdeaProjects\\FirstTestNGProject\\src\\annotations\\dependency.xml");
            marshaler.marshal(depedency,file);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
