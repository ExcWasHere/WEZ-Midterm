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

    TransaksiLayanan(String pasien, String Dokter) {
        this.pasien = pasien;
        this.dokter = Dokter;

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
}