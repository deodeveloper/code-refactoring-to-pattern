package com.bijay.before_refactor.avoid_duplication_constructor;

/**
 * Created by bijaydeo on 11/1/15.
 */
public class SoccerPlayer {

    private int age;
    private String name;
    private String grade;
    private PlayerType playerType;
    public enum PlayerType {FRONT, BACK, MIDDLE};


    /**
     * @apiNote  3 constuctors and duplication code. how to solve ?
     *@see com.bijay.after_refactor.avoid_duplication_constructor.SoccerPlayer
     */
    public SoccerPlayer(int age, String name) {
        this.age = age;
        this.name = name;
    }


    public SoccerPlayer(int age, String name, String grade) {
        this.age = age;
        this.name = name;
        this.grade = grade;
    }

    public SoccerPlayer(int age, String name, String grade, PlayerType playerType) {
        this.age = age;
        this.name = name;
        this.grade = grade;
        this.playerType = playerType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }





}
