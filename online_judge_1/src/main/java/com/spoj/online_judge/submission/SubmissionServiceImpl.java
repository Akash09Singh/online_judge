package com.spoj.online_judge.submission;

import com.spoj.online_judge.Problem.Entity.Problem;
import com.spoj.online_judge.Problem.Service.ProblemService;
import com.spoj.online_judge.submission.pojo.ApiResponse;
import com.spoj.online_judge.submission.pojo.UserSubmission;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import static jdk.internal.org.jline.utils.Log.error;

@Service
@Slf4j
public class SubmissionServiceImpl implements SubmissionService {
    private static final String url = "https://code-compiler10.p.rapidapi.com/";
    private static final String xRapidApiKey = "497db9c8bamsh59562a9c7b35789p1c8294jsn2b471b7c33e0";
    private static final String xRapidApiHost =  "code-compiler10.p.rapidapi.com";

    private static final List<String> langEnum = new ArrayList<>(Arrays.asList("php", "python", "c", "c_cpp", "csharp", "kotlin", "golang",
            "r", "java", "typescript", "nodejs", "ruby", "perl", "swift", "fortran", "bash"));



    @Autowired
    private SubmissionRepository submissionRepository;

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
    public ApiResponse executeCode(Submission submission) {
        Problem problem  = problemService.getProblemById(1);
        UserSubmission userSubmission = new UserSubmission();
        userSubmission.setLangEnum(langEnum);
        userSubmission.setCode(problem.getBoiler_code_python());
        userSubmission.setLang("python");
        userSubmission.setInput("4\n1\n2\n3\n4\n3");
        System.out.println(problem.getBoiler_code_python());
        try{
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("content-type", "application/json");
            httpHeaders.set("x-compile", "rapidapi");
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("X-RapidAPI-Key", xRapidApiKey);
            httpHeaders.set("X-RapidAPI-Host", xRapidApiHost);

            ResponseEntity<ApiResponse> apiResponse = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(userSubmission,httpHeaders), ApiResponse.class);
            System.out.println(apiResponse.getBody());
            return apiResponse.getBody();



        }catch (Exception e){
            System.out.println("exception while calling rapid api");
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "exception while calling rapid api", e);
        }
    }




    // Implement other methods as needed
}
