package Case_Methode_2;
import java.util.Scanner;

class Pasien {
    String nama;
    String nik;
    String keluhan;
    Pasien next;

    public Pasien(String nama, String nik, String keluhan) {
        this.nama = nama;
        this.nik = nik;
        this.keluhan = keluhan;
    }

    void tampilkanInformasi() {
        System.out.println("Nama Pasien: " + nama);
        System.out.println("NIK: " + nik);
        System.out.println("Keluhan: " + keluhan);
    }
}

class Dokter {
    String idDokter;
    String namaDokter;

    void tampilkanInformasiDokter() {
        System.out.println("ID Dokter: " + idDokter);
        System.out.println("Nama Dokter: " + namaDokter);
    }
}

class TransaksiLayanan {
    int durasiLayanan, biaya;
    String pasien, dokter;

    double biayaLayanan;
    TransaksiLayanan(String pasien, String nik, String keluhan, String idDokter, String namaDokter, double durasi) {
        this.pasien = pasien;
        this.dokter = namaDokter;
        this.durasiLayanan = (int) (durasi * 60);
        this.biayaLayanan = durasi * 50000;
    }

    void tampilkanInformasiTransaksi() {
        System.out.println("Pasien: " + pasien);
        System.out.println("Dokter: " + dokter);
        System.out.println("Durasi Layanan: " + durasiLayanan + " menit");
        System.out.println("Biaya: Rp" + biaya);
    }

    class AntrianPasien {
        Pasien head;
        Pasien tail;
        int jumlahPasien;

        public AntrianPasien() {
            this.head = null;
            this.tail = null;
            this.jumlahPasien = 0;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int sisaPasien() {
            return jumlahPasien;
        }

        public void tambahPasien(String nama, String nik, String keluhan) {
            Pasien pasienBaru = new Pasien(nama, nik, keluhan);
            if (head == null) {
                head = pasienBaru;
                tail = pasienBaru;
                pasienBaru.next = null;
            } else {
                tail.next = pasienBaru;
                tail = pasienBaru;
                pasienBaru.next = null;
            }
            jumlahPasien++;
            System.out.println("Pasien " + nama + " telah ditambahkan ke antrian.");
        }

        public void tampilkanAntrian() {
            if (isEmpty()) {
                System.out.println("Antrian kosong.");
                return;
            }

            System.out.println("\n=== DAFTAR ANTRIAN PASIEN ===");
            Pasien current = head;
            int nomor = 1;

            do {
                System.out.print(nomor + ". ");
                current.tampilkanInformasi();
                current = current.next;
                nomor++;
            } while (current != head);

            System.out.println("Total pasien dalam antrian: " + jumlahPasien);
        }

        public Pasien layaniPasien() {
            if (isEmpty()) {
                System.out.println("Tidak ada pasien dalam antrian.");
                return null;
            }

            Pasien pasienDilayani = head;

            if (jumlahPasien == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }

            jumlahPasien--;
            System.out.println("Melayani pasien: " + pasienDilayani.nama);
            return pasienDilayani;
        }
    }

    public class Transaksi {
        int size, front, rear, maxSize;
        TransaksiLayanan[] queue;

        public Transaksi(int maxSize) {
            this.maxSize = maxSize;
            this.queue = new TransaksiLayanan[maxSize];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }

        public void enqueque(TransaksiLayanan transaksi) {
            boolean isFull = true;

            if (isFull) {
                System.out.println("Antrian penuhhh icibosss maff");
                return;
            }

            rear = (rear + 1) % maxSize;
            queue[rear] = transaksi;
            size++;
        }

        public boolean isFull() {
            return size == maxSize;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        void tampilkanRiwayat() {
            boolean isEmpty = true;

            if (isEmpty) {
                System.out.println("Kosong icibosss");
                return;

            }
            System.out.println("=== RIWAYAT TRANSAKSI LAYANAN ===");
            int index = front;
            for (int i = 0; i < size; i++)
                ;
            System.out.println("Transaksi" + (index + 1) + ":");
            queue[index].tampilkanInformasiTransaksi();
            index = (index + 1) % maxSize;
        }

    }

    class SistemKlinik {
        AntrianPasien antrianPasien;
        Transaksi queueTransaksi;
        Scanner scanner;

        public SistemKlinik() {
            this.antrianPasien = new AntrianPasien();
            this.queueTransaksi = new Transaksi(100); // Maksimal 100 transaksi
            this.scanner = new Scanner(System.in);
        }

        public void tampilkanMenu() {
            System.out.println("\n=== SISTEM ANTRIAN PASIEN KLINIK ===");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Tampilkan Daftar Antrian Pasien");
            System.out.println("3. Layani Pasien");
            System.out.println("4. Cek Sisa Pasien dalam Antrian");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
        }

        public void tambahPasienMenu() {
            System.out.println("\n=== TAMBAH PASIEN KE ANTRIAN ===");
            System.out.print("Masukkan nama pasien: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan No. KTP pasien: ");
            String noNIK = scanner.nextLine();
            System.out.print("Masukkan keluhan pasien: ");
            String keluhan = scanner.nextLine();

            antrianPasien.tambahPasien(nama, noNIK, keluhan);
        }

        public void layaniPasienMenu() {
            System.out.println("\n=== LAYANI PASIEN ===");
            Pasien pasienDilayani = antrianPasien.layaniPasien();

            if (pasienDilayani != null) {
                System.out.println("\nMasukkan data dokter yang melayani:");
                System.out.print("ID Dokter: ");
                String idDokter = scanner.nextLine();
                System.out.print("Nama Dokter: ");
                String namaDokter = scanner.nextLine();
                System.out.print("Durasi layanan (jam): ");
                double durasi = scanner.nextDouble();
                scanner.nextLine();

                TransaksiLayanan transaksi = new TransaksiLayanan(
                        pasienDilayani.nama,
                        pasienDilayani.nik,
                        pasienDilayani.keluhan,
                        idDokter,
                        namaDokter,
                        durasi);

                queueTransaksi.enqueque(transaksi);

                System.out.println("\nTransaksi berhasil dicatat:");
                System.out.println("Biaya layanan: Rp " + String.format("%.0f", transaksi.biayaLayanan));
            }
        }

        public void cekSisaPasienMenu() {
            System.out.println("\n=== CEK SISA PASIEN ===");
            int sisa = antrianPasien.sisaPasien();
            System.out.println("Sisa pasien dalam antrian: " + sisa);

            if (sisa > 0) {
                System.out.println("Pasien selanjutnya yang akan dilayani:");
                antrianPasien.head.tampilkanInformasi();
            }
        }

        public void jalankan() {
            int pilihan;

            do {
                tampilkanMenu();
                pilihan = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (pilihan) {
                    case 1:
                        tambahPasienMenu();
                        break;
                    case 2:
                        antrianPasien.tampilkanAntrian();
                        break;
                    case 3:
                        layaniPasienMenu();
                        break;
                    case 4:
                        cekSisaPasienMenu();
                        break;
                    case 5:
                        queueTransaksi.tampilkanRiwayat();
                        break;
                    case 6:
                        System.out.println("Terima kasih telah menggunakan sistem antrian klinik!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }

                if (pilihan != 6) {
                    System.out.println("\nTekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                }

            } while (pilihan != 6);
        }
    }

    

}
