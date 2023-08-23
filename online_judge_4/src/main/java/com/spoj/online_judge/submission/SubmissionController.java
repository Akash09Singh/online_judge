package com.spoj.online_judge.submission;


import com.spoj.online_judge.Models.SubmitProblem;
import com.spoj.online_judge.submission.pojo.ApiResponse;
import com.spoj.online_judge.submission.pojo.UserSubmission;
import jakarta.persistence.Table;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/submissions")
@Table(name = "submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @PostMapping
    public ResponseEntity<List<ApiResponse>> createSubmission(@RequestBody SubmitProblem submitProblem) {
//        Submission createdSubmission = submissionService.createSubmission(submission);
        Submission submission = new Submission();
        submission.setCode(submitProblem.getCode());
        submission.setUserId(submitProblem.getUserId());
        submission.setProblemId(submitProblem.getProblemId());
        List<ApiResponse> apiResponse = submissionService.executeCode(submission);


        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Submission>> getSubmissionsByUserId(@PathVariable int userId) {
        List<Submission> submissions = submissionService.getSubmissionsByUserId(userId);
        return new ResponseEntity<>(submissions, HttpStatus.OK);
    }

    @GetMapping("/problem/{problemId}")
    public ResponseEntity<List<Submission>> getSubmissionsByProblemId(@PathVariable int problemId) {
        List<Submission> submissions = submissionService.getSubmissionsByProblemId(problemId);
        return new ResponseEntity<>(submissions, HttpStatus.OK);
    }

    // Implement other endpoints for updating submissions, deleting submissions, etc. as needed.
}
