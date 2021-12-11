package com.benz.zuul.edge.api.log;


import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

//@Component
public class LogManagment {

    final private static Logger LOGGER= LogManager.getLogger(LogManagment.class);


    @Autowired
    private AmazonS3Client amazonS3Client;

    @Value("${local.log.dir}")
    private String logFilePath;

    @Value("${amazon.bucket.name}")
    private String bucketName;

    @Scheduled(cron = "0 0/5 * * * *") // schedule the job every 5 minutes
    public void moveLogsFromEC2ToS3() {
        File logsDir = new File(logFilePath);
        try {
            for (File logFile : logsDir.listFiles()) {
                String fileName = logFile.getName();
                System.out.println(fileName);
                if (fileName.endsWith(".log"))
                    amazonS3Client.putObject(new PutObjectRequest(bucketName, fileName, logFile));
            }
        } catch (Exception e) {
        LOGGER.error("Error in moving log files! : {}", e);
       }

    }


}
