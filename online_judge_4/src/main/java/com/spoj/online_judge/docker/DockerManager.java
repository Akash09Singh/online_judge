package com.spoj.online_judge.docker;

import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.transport.DockerHttpClient;
import com.github.dockerjava.zerodep.ZerodepDockerHttpClient;
import org.springframework.stereotype.Service;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.BuildImageResultCallback;
import com.github.dockerjava.core.DockerClientBuilder;



import java.io.File;
import java.io.IOException;
import java.time.Duration;


@Service
public class DockerManager {

    public void buildCppDocker(){


        //build cpp environment image
        try {
            // Define the batch command to be executed
            String command = "test.bat"; // Example: "dir" is the command to list files in the current directory

            // Create a ProcessBuilder instance with the command
            ProcessBuilder processBuilder = new ProcessBuilder("C:\\Users\\ASUS\\Desktop\\online_judge\\online_judge_4\\src\\main\\java\\com\\spoj\\online_judge\\docker\\test.bat");

            // Redirect error stream to output stream
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output of the process
            java.io.InputStream inputStream = process.getInputStream();
            java.util.Scanner scanner = new java.util.Scanner(inputStream).useDelimiter("\\A");
            String output = scanner.hasNext() ? scanner.next() : "";

            // Print the output
            System.out.println(output);

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
