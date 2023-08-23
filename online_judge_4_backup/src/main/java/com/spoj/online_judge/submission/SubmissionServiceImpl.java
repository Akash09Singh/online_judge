package com.spoj.online_judge.submission;

import com.spoj.online_judge.Models.SubmitProblem;
import com.spoj.online_judge.Problem.Entity.Problem;
import com.spoj.online_judge.Problem.Service.ProblemService;
import com.spoj.online_judge.TestCase.Entity.Testcase;
import com.spoj.online_judge.TestCase.Repository.TestcaseRepository;
import com.spoj.online_judge.TestCase.Service.TestcaseService;
import com.spoj.online_judge.submission.pojo.ApiResponse;
import com.spoj.online_judge.submission.pojo.UserSubmission;
//import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;


//import static jdk.internal.org.jline.utils.Log.error;

@Service
//@Slf4j
public class SubmissionServiceImpl implements SubmissionService {

    private static final String url = "https://code-compiler10.p.rapidapi.com/";
    private static final String xRapidApiKey = "497db9c8bamsh59562a9c7b35789p1c8294jsn2b471b7c33e0";
    private static final String xRapidApiHost =  "code-compiler10.p.rapidapi.com";

    private static final List<String> langEnum = new ArrayList<>(Arrays.asList("php", "python", "c", "c_cpp", "csharp", "kotlin", "golang",
            "r", "java", "typescript", "nodejs", "ruby", "perl", "swift", "fortran", "bash"));



    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private TestcaseService testcaseService;

    @Autowired
    private ProblemService problemService;



    @Override
    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    public List<Submission> getSubmissionsByUserId(int userId) {
        return submissionRepository.findByUserId(userId);
    }

    @Override
    public List<Submission> getSubmissionsByProblemId(int problemId) {
        return submissionRepository.findByProblemId(problemId);
    }
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<ApiResponse> executeCode(Submission submission) {
        //do preprocessing
        Problem problem  = problemService.getProblemById(submission.getProblemId());
        List<Testcase> testcases = testcaseService.getTestcasesByProblemId(submission.getProblemId());
        UserSubmission userSubmission = new UserSubmission();
        userSubmission.setLangEnum(langEnum);
        userSubmission.setCode(submission.getCode());
        createCppFile(submission.getCode());
        saveTestcaseToFile(testcases);
        userSubmission.setLang("c_cpp");
        System.out.println(problem.getBoiler_code_python());
        try{
            //set headers
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("content-type", "application/json");
            httpHeaders.set("x-compile", "rapidapi");
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("X-RapidAPI-Key", xRapidApiKey);
            httpHeaders.set("X-RapidAPI-Host", xRapidApiHost);
            List<ApiResponse> apiResponses= new ArrayList<>();

            //run request for each testcases
//            for(Testcase testcase:testcases){
//                userSubmission.setInput(testcase.getInput());
//                ResponseEntity<ApiResponse> apiResponse = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(userSubmission,httpHeaders), ApiResponse.class);
//                apiResponses.add(apiResponse.getBody());
//
//            }
            return apiResponses;
        }catch (Exception e){
            System.out.println("exception while calling rapid api");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "exception while calling rapid api", e);
        }
    }





    // Implement other methods as needed
    public String createCppFile(String code){
        try{
        String filepath = "C:\\Users\\ASUS\\Desktop\\online_judge\\online_judge_4\\src\\main\\java\\com\\spoj\\online_judge\\code\\code.cpp";
        FileWriter writer = new FileWriter(filepath);
        writer.write(code);
        writer.close();
        return "file created Successfully";

        }
        catch (IOException e){
            e.printStackTrace();
            return "error creating file";

        }

    }

    public String saveTestcaseToFile(List<Testcase> testcases){
        try{
            String inputFilepath = "C:\\Users\\ASUS\\Desktop\\online_judge\\online_judge_4\\src\\main\\java\\com\\spoj\\online_judge\\code\\input.txt";
            FileWriter inputWriter = new FileWriter(inputFilepath);
            String outputFilepath = "C:\\Users\\ASUS\\Desktop\\online_judge\\online_judge_4\\src\\main\\java\\com\\spoj\\online_judge\\code\\output.txt";
            FileWriter outputWriter = new FileWriter(outputFilepath);
            for(Testcase testcase:testcases){
                String[] tc = testcase.getInput().split("\n");
                for(String in:tc){
                    inputWriter.write(in+"\n");
                }
                outputWriter.write(testcase.getExpectedOutput()+"\n");
            }
            inputWriter.close();
            outputWriter.close();
            return "input and outfile created successfully";
        }catch (IOException e){
            e.printStackTrace();
            return "error  creating testcase file ";
        }
    }

}
