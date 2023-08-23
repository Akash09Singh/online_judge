package com.spoj.online_judge.Models;

public class SubmitProblem {
    int userId;
    int problemId;
    int contestId;
    String code;

    String lang;

    public SubmitProblem() {
    }

    public SubmitProblem(int userId, int problemId, int contestId, String code, String lang) {
        this.userId = userId;
        this.problemId = problemId;
        this.contestId = contestId;
        this.code = code;
        this.lang = lang;
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

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
