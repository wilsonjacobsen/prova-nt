package com.wilson.ProcessFile.process;

import com.wilson.ProcessFile.model.Result;
import com.wilson.ProcessFile.service.ClientService;
import com.wilson.ProcessFile.service.SaleService;
import com.wilson.ProcessFile.service.SalesmanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Component
public class BatchProcess {

    private final Logger log = LoggerFactory.getLogger(BatchProcess.class);

    @Value("${config.dataIn}")
    private String inDir;

    @Value("${config.dataOut}")
    private String outDir;

    @Autowired
    private SaleService saleService;
    @Autowired
    private SalesmanService salesmanService;
    @Autowired
    private ClientService clientService;

    @Scheduled(cron = "0 */2 * * * ?")
    public void startProcessFile() throws IOException {
        Set<String> dirs = listFilesUsingDirectoryStream(inDir);
        dirs.parallelStream()
                .filter(fileName -> !Files.isRegularFile(Paths.get(outDir + "/" + fileName)))
                .forEach(nameFile -> createProcessedFile(nameFile));
    }

    private void createProcessedFile(String nameFile) {
        final String outFileName = outDir + "/" + nameFile;
        log.info("Process file: {}", outFileName);
        try {
            Files.writeString(
                    Files.createFile(Paths.get(outFileName)),
                    Result.builder()
                            .coutSalesman(salesmanService.countSalesman(readFIleStream(nameFile)))
                            .coutUser(clientService.countClient(readFIleStream(nameFile)))
                            .idMaxSale(saleService.idMaxSaleFiles(readFIleStream(nameFile)))
                            .idMinSalesman(salesmanService.nameMinSalesman(readFIleStream(nameFile)))
                            .build()
                            .toString()
            );
        } catch (IOException e) {
            log.error("Error saving file: {} Error: {}", outFileName, e.getMessage());
            return;
        }

    }

    private Stream<String> readFIleStream(String s) {
        final String fileName = inDir + "/" + s;
        try {
            return Files.lines(Paths.get(fileName));
        } catch (IOException e) {
            log.error("Error opening file: {} error: {}", fileName, e.getMessage());
            return Stream.<String>builder().build();
        }
    }


    public Set<String> listFilesUsingDirectoryStream(String dir) {
        Set<String> fileList = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.getFileName()
                            .toString());
                }
            }
        } catch (IOException e) {
            log.error("Error opening file: {} error: {}", dir, e.getMessage());
        }
        return fileList;
    }


}