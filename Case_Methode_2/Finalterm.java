package Case_Methode_2;

class Finalterm {

}

class Pasien {
    String nama;
    String nik;
    String keluhan;

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

    TransaksiLayanan(String pasien, String Dokter, int durasi) {
        this.pasien = pasien;
        this.dokter = Dokter;
        this.durasiLayanan = durasi;

    }

    void tampilkanInformasiTransaksi() {
        System.out.println("Pasien: " + pasien);
        System.out.println("Dokter: " + dokter);
        System.out.println("Durasi Layanan: " + durasiLayanan + " menit");
        System.out.println("Biaya: Rp" + biaya);
    }

    void hitungBiaya() {
        if (durasiLayanan <= 60) {
            biaya = 50000;
        } else if (durasiLayanan <= 120) {
            biaya = 100000;
        } else {
            biaya = 150000;
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

}
