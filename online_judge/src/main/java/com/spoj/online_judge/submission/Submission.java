package com.spoj.online_judge.submission;

import com.spoj.online_judge.Problem.Entity.Problem;
import com.spoj.online_judge.User.entity.User;
import jakarta.persistence.*;

@Entity
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submission_id")
    private int submissionId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "problem_id")
    private int problemId;
    @Column(name = "code")
    private String code;
    @Column(name = "status")
    private String status; // Accepted, Rejected, etc.

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "problem_id", referencedColumnName = "id")
//    private Problem problem;



    public Submission(){}

    public Submission(int userId, int problemId, String code, String status, User user, Problem problem) {
        this.userId = userId;
        this.problemId = problemId;
        this.code = code;
        this.status = status;
//        this.user = user;
//        this.problem = problem;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Problem getProblem() {
//        return problem;
//    }
//
//    public void setProblem(Problem problem) {
//        this.problem = problem;
//    }

    public int getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(int submissionId) {
        this.submissionId = submissionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Submission{" +
                "submissionId=" + submissionId +
                ", userId=" + userId +
                ", problemId=" + problemId +
                ", code='" + code + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
