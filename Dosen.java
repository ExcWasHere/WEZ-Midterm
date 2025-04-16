class Dosen {
    String nidn, namaDosen;

    Dosen(String nidn, String namaDosen) {
        this.nidn = nidn;
        this.namaDosen = namaDosen;
    }

    void tampilData() {
        System.out.println("NIDN: " + nidn);
        System.out.println("Nama: " + namaDosen);
        System.out.println();
    }
}

class MataKuliah {
    String kodeMK, namaMK;
    int sks;

    MataKuliah(String kodeMK, String namaMK, int sks) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
    }

    void tampilData() {
        System.out.println("Kode MK: " + kodeMK);
        System.out.println("Nama Mata Kuliah: " + namaMK);
        System.out.println("SKS: " + sks);
        System.out.println();
    }
}

class Jadwal {
    Dosen dosen;
    MataKuliah mataKuliah;
    String hari, jam;

    Jadwal(Dosen dosen, MataKuliah mataKuliah, String hari, String jam) {
        this.dosen = dosen;
        this.mataKuliah = mataKuliah;
        this.hari = hari;
        this.jam = jam;
    }

    int hitungMenit() {
        return mataKuliah.sks * 50;
    }

    void tampilData() {
        System.out.println("Dosen       : " + dosen.namaDosen);
        System.out.println("Mata Kuliah : " + mataKuliah.namaMK);
        System.out.println("SKS         : " + mataKuliah.sks);
        System.out.println("Hari        : " + hari);
        System.out.println("Jam         : " + jam);
        System.out.println("Durasi      : " + hitungMenit() + " menit");
        System.out.println();

       
    }
}