package ebi.ac.uk.uniprot.openapi.mavenplugin.swagger.operation.server;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ebi.ac.uk.uniprot.openapi.mavenplugin.swagger.resources.model.Pet;

/**
 * Resource With a Hidden Operation
 */
@Controller
public class ServerOperationResource {
    @GetMapping("/serversoperation")
    @Operation(operationId = "Pets", description = "Pets Example",
            servers = {
                    @Server(description = "server 2", url = "http://foo2")
            }
    )
    public Pet getPet() {
        return new Pet();
    }
}