package uk.ac.ebi.uniprot.openapi.mavenplugin;

import org.junit.Test;

public class MultiPackageResourceTest extends BaseAnnotationTest {
    @Test
    public void testGenerateOpenAPIMultiplePackage() throws Exception {
        // generate OAS for the given package
        generateOAS3( "multi-package-oas.yaml",
                "uk.ac.ebi.uniprot.openapi.mavenplugin.swagger.requestbody.general",
                "uk.ac.ebi.uniprot.openapi.mavenplugin.swagger.petstore");

        // compare the result
        compareYamlFiles("multi-package-oas.yaml");
    }
}
