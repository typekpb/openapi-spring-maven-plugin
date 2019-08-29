package org.uniprot.mavenplugin.swagger.requestbody.onlymethod;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uniprot.mavenplugin.swagger.resources.model.User;

/**
 * Resource with RequestBody inside Operation and another in Method
 */
@RequestMapping
public class RequestBodyMethodPriorityResource {
    @PostMapping("/requestbodymethodpriority")
    @Operation(summary = "Create user",
            description = "This can only be done by the logged in user.",
            requestBody = @RequestBody(description = "Inside Operation"))
    @RequestBody(description = "Created user object on Method", required = true,
            content = @Content(
                    schema = @Schema(implementation = User.class)))
    public ResponseEntity<User> methodWithRequestBodyAndTwoParameters(final User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
