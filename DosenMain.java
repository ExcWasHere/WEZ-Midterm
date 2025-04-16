import java.util.Scanner;
public class DosenMain {
    public static void main(String[] args) {
        Dosen[] dosenList = {
            new Dosen("D001", "Budi Hartono"),
            new Dosen("D002", "Rina Marlina"),
            new Dosen("D003", "Agus Wijaya"),
            new Dosen("D004", "Siti Aminah"),
            new Dosen("D005", "Andi Pratama")
        };

        MataKuliah[] mkList = {
            new MataKuliah("MK001", "Struktur Data", 3),
            new MataKuliah("MK002", "Pemrograman Java", 3),
            new MataKuliah("MK003", "Basis Data", 3),
            new MataKuliah("MK004", "Algoritma dan Pemrograman", 2),
            new MataKuliah("MK005", "Matematika Diskrit", 2),
            new MataKuliah("MK006", "Jaringan Komputer", 3),
            new MataKuliah("MK007", "Pemrograman Web", 3)
        };

        Jadwal[] jadwalList = {
            new Jadwal(dosenList[0], mkList[0], "Senin", "08:00"),
            new Jadwal(dosenList[1], mkList[1], "Selasa", "10:00"),
            new Jadwal(dosenList[2], mkList[2], "Rabu", "09:00"),
            new Jadwal(dosenList[0], mkList[3], "Kamis", "13:00"),
            new Jadwal(dosenList[3], mkList[4], "Jumat", "07:00"),
            new Jadwal(dosenList[4], mkList[5], "Senin", "11:00"),
            new Jadwal(dosenList[1], mkList[6], "Rabu", "14:00")
        };

        int pilihan = -1;
        while (pilihan != 0) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tampilkan Data Dosen");
            System.out.println("2. Tampilkan Data Mata Kuliah");
            System.out.println("3. Tampilkan Data Jadwal");
            System.out.println("4. Urutkan Jadwal Berdasarkan Hari & Jam");
            System.out.println("5. Cari Jadwal Berdasarkan Nama Dosen");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            Scanner sc = new Scanner(System.in);
            pilihan = sc.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.println("\n=== DATA DOSEN ===");
                    for (int i = 0; i < dosenList.length; i++) {
                        dosenList[i].tampilData();
                    }
                    break;
                case 2:
                    System.out.println("\n=== DATA MATA KULIAH ===");
                    for (int i = 0; i < mkList.length; i++) {
                        mkList[i].tampilData();
                    }
                    break;
                case 3:
                    System.out.println("\n=== DATA JADWAL KULIAH ===");
                    for (int i = 0; i < jadwalList.length; i++) {
                        jadwalList[i].tampilData();
                    }
                    break;
                case 4:
                    bubbleSort(jadwalList);
                    System.out.println("\n=== JADWAL KULIAH TERURUT ===");
                    for (int i = 0; i < jadwalList.length; i++) {
                        System.out.println(jadwalList[i].hari + " - " + jadwalList[i].jam + " | " + jadwalList[i].dosen.namaDosen + " - " + jadwalList[i].mataKuliah.namaMK);
                    }
                    break;
                    case 5:
                    System.out.print("Masukkan Nama Dosen: ");
                    sc.nextLine(); 
                    String namaCari = sc.nextLine();
                    boolean ketemu = false;
                    System.out.println("\n=== HASIL PENCARIAN JADWAL ===");
                    for (int i = 0; i < jadwalList.length; i++) {
                        if (jadwalList[i].dosen.namaDosen.equalsIgnoreCase(namaCari)) {
                            jadwalList[i].tampilData();
                            ketemu = true;
                        }
                    }
                    if (!ketemu) {
                        System.out.println("Data dosen dengan nama \"" + namaCari + "\" tidak ditemukan.");
                    }
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static String bacaInput() throws java.io.IOException {
        byte[] buf = new byte[100];
        int len = System.in.read(buf);
        return new String(buf, 0, len).trim();
    }

    static void bubbleSort(Jadwal[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (compareJadwal(data[j], data[j + 1]) > 0) {
                    Jadwal temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    static int compareJadwal(Jadwal a, Jadwal b) {
        String[] urutanHari = { "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu" };
        int indeksHariA = cariIndeksHari(urutanHari, a.hari);
        int indeksHariB = cariIndeksHari(urutanHari, b.hari);

        if (indeksHariA != indeksHariB) {
            return indeksHariA - indeksHariB;
        } else {
            return a.jam.compareTo(b.jam);
        }
    }

    static int cariIndeksHari(String[] hari, String target) {
        for (int i = 0; i < hari.length; i++) {
            if (hari[i].equalsIgnoreCase(target)) return i;
        }
        return 7; 
    }
}