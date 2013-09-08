package ro.ieugen.demo.cxf.services;

import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Simple file system service.
 * <p/>
 * GET      /path/to/folder             - Directory listing
 * GET      /path/to/file.txt           - Info and contents of file at path
 * POST     /path/to/newfolder          - Create a new folder
 * POST     /path/to/folder (multipart/form-data) - Upload file at folder path
 * PUT      /path/to/file.txt           - Replace contents of file at path
 * DELETE   /path/to/folder             - Delete folder at path
 */
@javax.ws.rs.Path("/fs/")
@Produces(MediaType.APPLICATION_XML)
public class FileSystemService {

    private static final Logger LOG = LoggerFactory.getLogger(FileSystemService.class);
    private final Path CHROOT;

    public FileSystemService() {
        try {
            this.CHROOT = Paths.get("target").toRealPath(LinkOption.NOFOLLOW_LINKS);
        } catch (IOException ioe) {
            LOG.error("Exception resolving root directory {}", "target");
            throw Throwables.propagate(ioe);
        }
    }

    @GET
    @javax.ws.rs.Path("/home/")
    public Response getRoot() {
        return getFile("");
    }

    @GET
    @javax.ws.rs.Path("/home/{path}")
    public Response getFile(@javax.ws.rs.PathParam("path") String path) {
        LOG.info("--- invoke getFile with {}", path);
        Path pathOnDisk = getAndValidatePath(path);
        return Response.ok(pathOnDisk.toString()).build();
    }

    private Path getAndValidatePath(String path) {
        Path localPath;
        try {
            localPath = Paths.get(CHROOT.toString(), path).toRealPath(LinkOption.NOFOLLOW_LINKS);
            LOG.info("Path is {}", localPath.toString());
            return CHROOT.relativize(localPath.toAbsolutePath());
        } catch (IOException e) {
            LOG.info("Path not found for {}", path);
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @POST
    @javax.ws.rs.Path("/home/{path}")
    public Response createPath(@javax.ws.rs.PathParam("path") String path) {
        LOG.info("--- invoke create path with {}", path);
        return Response.ok().build();
    }

    @POST
    @javax.ws.rs.Path("/home/{path}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@javax.ws.rs.PathParam("path") String path) {
        LOG.info("--- invoke upload file with {}", path);
        return Response.ok().build();
    }

    @PUT
    @javax.ws.rs.Path("/home/{path}")
    public Response createOrReplace(@javax.ws.rs.PathParam("path") String path) {
        LOG.info("--- invoke create or replace with {}", path);

        return Response.ok().build();
    }


}
