package com.mno.model;

import java.sql.Timestamp;

/**
 * 学生对象
 * 〈〉
 *
 * @author mao
 * @create 2020-01-02
 * @since 1.0.0
 */
public class Student {
    private Integer id;
    private Integer mathScore;
    private Integer englishScore;
    private Integer majorScore;
    private Integer rank;
    private Integer counter;
    private Integer totalScore;
    private Integer userId;
    private Timestamp insertTime;
    private Timestamp updateTime;

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMathScore() {
        return mathScore;
    }

    public void setMathScore(Integer mathScore) {
        this.mathScore = mathScore;
    }

    public Integer getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(Integer englishScore) {
        this.englishScore = englishScore;
    }

    public Integer getMajorScore() {
        return majorScore;
    }

    public void setMajorScore(Integer majorScore) {
        this.majorScore = majorScore;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
