package algoexpert.demo;

public class School {
    public void go() {
        System.out.println("Super class method is called");
    }

    public void play() {
        System.out.println("I'm super class play method");
    }
}

class PrimarySchool extends School {
    public void go() {
        System.out.println("Sub class method is called");
    }

    public void game() {
        System.out.println("I'm in game");
    }
}

class HeadMaster {
    public static void main(String[] args) {
        School school = new PrimarySchool();
        school.go();
    }
}