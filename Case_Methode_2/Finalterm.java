package Case_Methode_2;

class Finalterm {

    
}

class Pasien {
String nama;
String nik;
String keluhan;
}

class Dokter {
String idDokter;
String namaDokter;
}

class TransaksiLayanan {
    int durasiLayanan, biaya;
    String pasien, dokter;
    TransaksiLayanan(String pasien, String Dokter){
    this.pasien = pasien;
    this.dokter = Dokter;
    }


}