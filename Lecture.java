class Lecture {
    String nidn, nameLecturer;

    Lecture(String nidn, String nameLecture) {
        this.nidn = nidn;
        this.nameLecturer = nameLecture;
    }

    void PrintData() {
        System.out.println("NIDN: " + nidn);
        System.out.println("Name: " + nameLecturer);
        System.out.println();
    }
}

class Course {
    String CodeMK, NameMK;
    int sks;

    Course(String codeMK, String nameMK, int sks) {
        this.CodeMK = codeMK;
        this.NameMK = nameMK;
        this.sks = sks;
    }

    void PrintData() {
        System.out.println("Code MK: " + CodeMK);
        System.out.println("course Name: " + NameMK);
        System.out.println("SKS: " + sks);
        System.out.println();
    }
}

class Schedule {
    Lecture lecture;
    Course course;
    String day, hour;

    Schedule(Lecture lecture, Course Course, String day, String hour) {
        this.lecture = lecture;
        this.course = Course;
        this.day = day;
        this.hour = hour;
    }

    int countMinute() {
        return course.sks * 50;
    }

    void showData() {
        System.out.println("Lecture     : " + lecture.nameLecturer);
        System.out.println("Course      : " + course.NameMK);
        System.out.println("SKS         : " + course.sks);
        System.out.println("Day         : " + day);
        System.out.println("Hour        : " + hour);
        System.out.println("Duration    : " + countMinute() + " minute");
        System.out.println();

       
    }
}