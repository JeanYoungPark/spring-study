package hello.hellospring.controller;

public class MemberForm {
    private String name; //input name과 매칭되어 set된다.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
