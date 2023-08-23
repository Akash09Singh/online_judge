package com.spoj.online_judge.Problem.Controller;

import com.spoj.online_judge.Problem.Service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import com.spoj.online_judge.Problem.Entity.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/problems")
@CrossOrigin(origins = "http://localhost:4200")
public class ProblemController {
    @Autowired
    private ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping
    public ResponseEntity<List<Problem>> getAllProblem(){
        List<Problem> allProblem=problemService.getAllProblem();
        return new ResponseEntity<>(allProblem, HttpStatus.OK);
    }
    @GetMapping("/{theId}")
    public ResponseEntity<Problem> findById(@PathVariable int theId){
        Problem theProblem = problemService.getProblemById(theId);
        return new ResponseEntity<>(theProblem, HttpStatus.OK);
    }

    @GetMapping("/contests/{contestId}")
    public ResponseEntity<List<Problem>> getAllProblemByContestId(@PathVariable int contestId){
        List<Problem> allProblem=problemService.getProblemByContestId(contestId);
        return new ResponseEntity<>(allProblem, HttpStatus.OK);
   }

    @PostMapping
    public ResponseEntity<Problem> createProblem(@RequestBody Problem theProblem){
        Problem problem = problemService.addProblem(theProblem);
        return new ResponseEntity<>(problem, HttpStatus.CREATED);
    }

}
