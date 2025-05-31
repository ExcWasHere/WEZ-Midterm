package Case_Methode_2;
import java.util.Scanner;

class Patient {
    String name;
    String idNumber;
    String complaint;
    Patient next;

    public Patient(String name, String idNumber, String complaint) {
        this.name = name;
        this.idNumber = idNumber;
        this.complaint = complaint;
    }

    void displayInformation() {
        System.out.println("Patient Name: " + name);
        System.out.println("ID Number: " + idNumber);
        System.out.println("Complaint: " + complaint);
    }
}

class Doctor {
    String doctorId;
    String doctorName;

    void displayDoctorInformation() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Doctor Name: " + doctorName);
    }
}

class ServiceTransaction {
    int serviceDuration, cost;
    String patient, doctor;

    double serviceCost;
    ServiceTransaction(String patient, String idNumber, String complaint, String doctorId, String doctorName, double duration) {
        this.patient = patient;
        this.doctor = doctorName;
        this.serviceDuration = (int) (duration * 60);
        this.serviceCost = duration * 50000;
    }

    void displayTransactionInformation() {
        System.out.println("Patient: " + patient);
        System.out.println("Doctor: " + doctor);
        System.out.println("Service Duration: " + serviceDuration + " minutes");
        System.out.println("Cost: Rp" + serviceCost);
    }

    class PatientQueue {
        Patient head;
        Patient tail;
        int patientCount;

        public PatientQueue() {
            this.head = null;
            this.tail = null;
            this.patientCount = 0;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int remainingPatients() {
            return patientCount;
        }

        public void addPatient(String name, String idNumber, String complaint) {
            Patient newPatient = new Patient(name, idNumber, complaint);
            if (head == null) {
                head = newPatient;
                tail = newPatient;
                newPatient.next = null;
            } else {
                tail.next = newPatient;
                tail = newPatient;
                newPatient.next = null;
            }
            patientCount++;
            System.out.println("Patient " + name + " has been added to the queue.");
        }

        public void displayQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }

            System.out.println("\n=== PATIENT QUEUE LIST ===");
            Patient current = head;
            int number = 1;

            do {
                System.out.print(number + ". ");
                current.displayInformation();
                current = current.next;
                number++;
            } while (current != head);

            System.out.println("Total patients in queue: " + patientCount);
        }

        public Patient servePatient() {
            if (isEmpty()) {
                System.out.println("No patients in queue.");
                return null;
            }

            Patient servedPatient = head;

            if (patientCount == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }

            patientCount--;
            System.out.println("Serving patient: " + servedPatient.name);
            return servedPatient;
        }
    }

    public class Transaction {
        int size, front, rear, maxSize;
        ServiceTransaction[] queue;

        public Transaction(int maxSize) {
            this.maxSize = maxSize;
            this.queue = new ServiceTransaction[maxSize];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }

        public void enqueue(ServiceTransaction transaction) {
            boolean isFull = true;

            if (isFull) {
                System.out.println("Queue is full, sorry.");
                return;
            }

            rear = (rear + 1) % maxSize;
            queue[rear] = transaction;
            size++;
        }

        public boolean isFull() {
            return size == maxSize;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        void displayHistory() {
            boolean isEmpty = true;

            if (isEmpty) {
                System.out.println("No transactions.");
                return;

            }
            System.out.println("=== SERVICE TRANSACTION HISTORY ===");
            int index = front;
            for (int i = 0; i < size; i++)
                ;
            System.out.println("Transaction " + (index + 1) + ":");
            queue[index].displayTransactionInformation();
            index = (index + 1) % maxSize;
        }

    }

    class ClinicSystem {
        PatientQueue patientQueue;
        Transaction transactionQueue;
        Scanner scanner;

        public ClinicSystem() {
            this.patientQueue = new PatientQueue();
            this.transactionQueue = new Transaction(100); // Maximum 100 transactions
            this.scanner = new Scanner(System.in);
        }

        public void displayMenu() {
            System.out.println("\n=== CLINIC PATIENT QUEUE SYSTEM ===");
            System.out.println("1. Add Patient to Queue");
            System.out.println("2. Display Patient Queue List");
            System.out.println("3. Serve Patient");
            System.out.println("4. Check Remaining Patients in Queue");
            System.out.println("5. Display Transaction History");
            System.out.println("6. Exit");
            System.out.print("Select menu option: ");
        }

        public void addPatientMenu() {
            System.out.println("\n=== ADD PATIENT TO QUEUE ===");
            System.out.print("Enter patient name: ");
            String name = scanner.nextLine();
            System.out.print("Enter patient ID Number: ");
            String idNumber = scanner.nextLine();
            System.out.print("Enter patient complaint: ");
            String complaint = scanner.nextLine();

            patientQueue.addPatient(name, idNumber, complaint);
        }

        public void servePatientMenu() {
            System.out.println("\n=== SERVE PATIENT ===");
            Patient servedPatient = patientQueue.servePatient();

            if (servedPatient != null) {
                System.out.println("\nEnter doctor data who serves:");
                System.out.print("Doctor ID: ");
                String doctorId = scanner.nextLine();
                System.out.print("Doctor Name: ");
                String doctorName = scanner.nextLine();
                System.out.print("Service duration (hours): ");
                double duration = scanner.nextDouble();
                scanner.nextLine();

                ServiceTransaction transaction = new ServiceTransaction(
                        servedPatient.name,
                        servedPatient.idNumber,
                        servedPatient.complaint,
                        doctorId,
                        doctorName,
                        duration);

                transactionQueue.enqueue(transaction);

                System.out.println("\nTransaction recorded successfully:");
                System.out.println("Service cost: Rp " + String.format("%.0f", transaction.serviceCost));
            }
        }

        public void checkRemainingPatientsMenu() {
            System.out.println("\n=== CHECK REMAINING PATIENTS ===");
            int remaining = patientQueue.remainingPatients();
            System.out.println("Remaining patients in queue: " + remaining);

            if (remaining > 0) {
                System.out.println("Next patient to be served:");
                patientQueue.head.displayInformation();
            }
        }

        public void run() {
            int choice;

            do {
                displayMenu();
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        addPatientMenu();
                        break;
                    case 2:
                        patientQueue.displayQueue();
                        break;
                    case 3:
                        servePatientMenu();
                        break;
                    case 4:
                        checkRemainingPatientsMenu();
                        break;
                    case 5:
                        transactionQueue.displayHistory();
                        break;
                    case 6:
                        System.out.println("Thank you for using the clinic queue system!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }

                if (choice != 6) {
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                }

            } while (choice != 6);
        }
    }

    public class WahyuExcellZakyClinic {
        public static void main(String[] args) {
            ClinicSystem system = new ClinicSystem();
            system.run();
        }
    }
}
