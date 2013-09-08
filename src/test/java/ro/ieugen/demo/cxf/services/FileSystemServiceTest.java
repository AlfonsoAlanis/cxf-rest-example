package ro.ieugen.demo.cxf.services;


import com.google.common.collect.Lists;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.transport.local.LocalConduit;
import static org.fest.assertions.api.Assertions.assertThat;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Test service with in-memory local transport.
 */
public class FileSystemServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(FileSystemServiceTest.class);
    private final static String ENDPOINT_ADDRESS = "local://cxf-demo";
    private static Server server;

    @BeforeClass
    public static void initialize() throws Exception {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(FileSystemService.class);

        List<Object> providers = Lists.newArrayList();
        // add custom providers if any
        sf.setProviders(providers);

        sf.setResourceProvider(FileSystemService.class,
                new SingletonResourceProvider(new FileSystemService(), true));
        sf.setAddress(ENDPOINT_ADDRESS);

        server = sf.create();
    }

    @AfterClass
    public static void destroy() throws Exception {
        server.stop();
        server.destroy();
    }

    @Test
    public void testGetFileOrDirectory() {
        WebClient client = WebClient.create(ENDPOINT_ADDRESS);
        WebClient.getConfig(client).getRequestContext().put(LocalConduit.DIRECT_DISPATCH, Boolean.TRUE);

        client.accept("application/*");
        client.path("/fs/home/classes");
        Response response = client.get(Response.class);

        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
        LOG.info("Response is {}", response.getEntity().toString());
    }

}
