package uk.ac.ebi.uniprot.openapi;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.MojoFailureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * @author sahmad
 */
public class FileHelper {
    private static final Logger  LOGGER = LoggerFactory.getLogger(FileHelper.class);

    public static void writeToFile(String content, String directory, String fileName) throws MojoFailureException {
        File outputDir = new File(directory);

        if (outputDir.isFile()) {
            throw new MojoFailureException(String.format("OpenAPI outputDirectory [%s] must be a directory!", directory));
        }

        if (!outputDir.exists()) {
            try {
                FileUtils.forceMkdir(outputDir);
            } catch (IOException e) {
                throw new MojoFailureException(String.format("Create OpenAPI-outputDirectory[%s] failed.", directory));
            }
        }

        try {
            FileUtils.write(new File(outputDir, fileName), content, "UTF-8");
        } catch (IOException e) {
            throw new MojoFailureException("Unable to write the file", e);
        }
    }
}
