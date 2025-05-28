import java.util.Scanner;
import java.util.InputMismatchException;

public class LectureMain {
    public static void main(String[] args) {
        Lecture[] lectureList = {
            new Lecture("D001", "Imam Fahrur Rozi"),
            new Lecture("D002", "Afif Hendrawan"),
            new Lecture("D003", "Roby Putranto"),
            new Lecture("D004", "Atiqah Nurul Asri"),
            new Lecture("D005", "Adevian Fairuz")
        };

        Course[] mkList = {
            new Course("MK001", "Data Structure", 3),
            new Course("MK002", "Java Programming", 3),
            new Course("MK003", "Database", 3),
            new Course("MK004", "Algorithm and Programming", 2),
            new Course("MK005", "Math Diskrit", 2),
            new Course("MK006", "Computer Network", 3),
            new Course("MK007", "Web Programming", 3)
        };

        Schedule[] scheduleList = {
            new Schedule(lectureList[0], mkList[0], "Monday", "08:00"),
            new Schedule(lectureList[1], mkList[1], "Tuesday", "10:00"),
            new Schedule(lectureList[2], mkList[2], "Wednesday", "09:00"),
            new Schedule(lectureList[0], mkList[3], "Thursday", "13:00"),
            new Schedule(lectureList[3], mkList[4], "Friday", "07:00"),
            new Schedule(lectureList[4], mkList[5], "Monday", "11:00"),
            new Schedule(lectureList[1], mkList[6], "Wednesday", "14:00")
        };
        
        Scanner sc = new Scanner(System.in);
        int choose = -1;
        
        while (choose != 0) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Show Lecturer Data");
            System.out.println("2. Show Course Data");
            System.out.println("3. Show Schedule Data");
            System.out.println("4. Sort Schedule Data");
            System.out.println("5. Search Schedule Data by Lecturer Name");
            System.out.println("6. Total Teach Duration");
            System.out.println("7. Average Duration");
            System.out.println("0. Exit Please");
            System.out.print("Choose: ");
            
            try {
                choose = sc.nextInt();
                
                switch (choose) {
                    case 1:
                        System.out.println("\n=== DATA LECTURE ===");
                        for (int i = 0; i < lectureList.length; i++) {
                            lectureList[i].PrintData();
                        }
                        break;
                    case 2:
                        System.out.println("\n=== DATA COURSE ===");
                        for (int i = 0; i < mkList.length; i++) {
                            mkList[i].PrintData();
                        }
                        break;
                    case 3:
                        System.out.println("\n=== DATA SCHEDULE ===");
                        for (int i = 0; i < scheduleList.length; i++) {
                            scheduleList[i].showData();
                        }
                        break;
                    case 4:
                        bubbleSort(scheduleList);
                        System.out.println("\n=== SORT SCHEDULE ===");
                        for (int i = 0; i < scheduleList.length; i++) {
                            System.out.println(scheduleList[i].day + " - " + scheduleList[i].hour + " | " + scheduleList[i].lecture.nameLecturer + " - " + scheduleList[i].course.NameMK);
                        }
                        break;
                    case 5:
                        System.out.print("Input Lecture Name: ");
                        sc.nextLine(); 
                        String nameFound = sc.nextLine();
                        boolean found = false;
                        System.out.println("\n=== SEARCH SCHEDULE RESULT ===");
                        for (int i = 0; i < scheduleList.length; i++) {
                            if (scheduleList[i].lecture.nameLecturer.equalsIgnoreCase(nameFound)) {
                                scheduleList[i].showData();
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Lecturer data with name \"" + nameFound + "\" Not Found.");
                        }
                        break;
                    case 6:
                    int total = 0;
                    System.out.print("Input Lecture Name: ");
                    sc.nextLine();
                    String lecturerName = sc.nextLine();
                    total = 0;
                    found = false;
                    for (int i = 0; i < scheduleList.length; i++) {
                        if (scheduleList[i].lecture.nameLecturer.equalsIgnoreCase(lecturerName)) {
                            total += scheduleList[i].countMinute();
                            found = true;
                        }
                    }
                    if (found) {
                        System.out.println("Total Duration for " + lecturerName + ": " + total + " minutes");
                    } else {
                        System.out.println("Lecturer " + lecturerName + " not found!");
                    }
                        break;
                    case 7:
                    System.out.print("Input Lecture Name: ");
                    sc.nextLine();
                    String lectureName = sc.nextLine();
                    total = 0;
                    int count = 0;
                    found = false;
                    for (int i = 0; i < scheduleList.length; i++) {
                        if (scheduleList[i].lecture.nameLecturer.equalsIgnoreCase(lectureName)) {
                            total += scheduleList[i].countMinute();
                            count++;
                            found = true;
                        }
                    }
                    if (found) {
                        int average = total / count;
                        System.out.println("Average Duration for " + lectureName + ": " + average + " minutes");
                    } else {
                        System.out.println("Lecturer " + lectureName + " not found!");
                    }
                    break;
                    case 0:
                        System.out.println("Thankyou!");
                        break;
                    default:
                        System.out.println("Menu option not found! Please select a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n======= ERROR =======");
                System.out.println("Please enter a number, not letters or other characters!");
                sc.nextLine(); 
            }
        }
    }

    static String readInput(Scanner scanner) {
        return scanner.nextLine().trim();
    }

    static void bubbleSort(Schedule[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (compareSchedule(data[j], data[j + 1]) > 0) {
                    Schedule temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    static int compareSchedule(Schedule a, Schedule b) {
        String[] sortDay = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        int indexDayA = searchIndexDay(sortDay, a.day);
        int indexDayB = searchIndexDay(sortDay, b.day);

        if (indexDayA != indexDayB) {
            return indexDayA - indexDayB;
        } else {
            return a.hour.compareTo(b.hour);
        }
    }

    static int searchIndexDay(String[] day, String target) {
        for (int i = 0; i < day.length; i++) {
            if (day[i].equalsIgnoreCase(target)) return i;
        }
        return 7; 
    }
}