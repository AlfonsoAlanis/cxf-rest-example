package ro.ieugen.demo.cxf.model;

import static org.fest.assertions.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class FileMarshalingTest {

    private static final Logger LOG = LoggerFactory.getLogger(FileMarshalingTest.class);
    private JAXBContext context;

    @Before
    public void setUp() throws Exception {
        context = JAXBContext.newInstance(MyFile.class);
    }

    @Test
    public void testMarshalAndUnmarshall() throws Exception {
        MyFile myFile = new MyFile();
        myFile.setName("simple");
        myFile.setFileSizeBytes(10);
        long timestamp = System.currentTimeMillis();
        myFile.setModifiedDate(timestamp);

        StringWriter writer = new StringWriter();

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(myFile, writer);

        LOG.info("Result is \n{}", writer.toString());
        assertThat(writer.toString()).startsWith("<?xml")
                .contains(String.valueOf(timestamp))
                .contains("<name>simple</name>")
                .contains("simple")
                .endsWith("</myFile>\n");
    }
}
