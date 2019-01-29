package dto;

//Site Yönetimi
public class User {

    private String site_id;
    private String site_adi;
    private String site_adresi;
    private String site_telefon;
    private String site_bloksayisi;
    private String site_email;

    private String oturan_turu_id; // insert yaparken dair_sakinleri tablosuna eklenecek
    private String oturan_tur;

    private String blok_ad;
    private String blok_id;

    private String daire_numarasi;
    private String daire_id;

    private String oturan_id;
    private String oturan_ad;
    private String oturan_soyad;
    private String oturan_telefon;

    private String aidat_id;
    private String tutar;
    private String gecikme_zami;
    private String verilis_tarihi;

    private String kira_id;
    private String kira_tutari;

    private String gorevli_tur_id;
    private String gorevli_tur_ad;
    
    private String gorevli_id;
    private String gorevli_adi;
    private String gorevli_soyadi;
    private String gorevli_tel;
    private String maas;
    
    private String blok_adi;
    private String katsayisi;
    private String daire_sayisi;
    private String asansor_sayisi;
    private String jenerator_sayisi;
    


    private String blok_ozellik_isim;
    private String ozellik;
    private String blok_ozellik_id;
    
    private String daire_tipi;
    private String daire_tipi_id;
    
    private String daire_durumu_id;
    private String daire_durumu_adi;
    
    private String dairekatno;
    private String daireno;
    private String daireblokadi_id;
    
    private String daireler_id;
    
    
    private String kullanici_adi;
    private String parola;

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getDaireler_id() {
        return daireler_id;
    }

    public void setDaireler_id(String daireler_id) {
        this.daireler_id = daireler_id;
    }

    public String getDaireblokadi_id() {
        return daireblokadi_id;
    }

    public void setDaireblokadi_id(String daireblokadi_id) {
        this.daireblokadi_id = daireblokadi_id;
    }

  
    
    public String getDairekatno() {
        return dairekatno;
    }

    public void setDairekatno(String dairekatno) {
        this.dairekatno = dairekatno;
    }

    public String getDaireno() {
        return daireno;
    }

    public void setDaireno(String daireno) {
        this.daireno = daireno;
    }


    public String getDaire_durumu_id() {
        return daire_durumu_id;
    }

    public void setDaire_durumu_id(String daire_durumu_id) {
        this.daire_durumu_id = daire_durumu_id;
    }

    public String getDaire_durumu_adi() {
        return daire_durumu_adi;
    }

    public void setDaire_durumu_adi(String daire_durumu_adi) {
        this.daire_durumu_adi = daire_durumu_adi;
    }

    public String getDaire_tipi_id() {
        return daire_tipi_id;
    }

    public void setDaire_tipi_id(String daire_tipi_id) {
        this.daire_tipi_id = daire_tipi_id;
    }

    public String getDaire_tipi() {
        return daire_tipi;
    }

    public void setDaire_tipi(String daire_tipi) {
        this.daire_tipi = daire_tipi;
    }

    public String getBlok_ozellik_id() {
        return blok_ozellik_id;
    }

    public void setBlok_ozellik_id(String blok_ozellik_id) {
        this.blok_ozellik_id = blok_ozellik_id;
    }

    public String getBlok_ozellik_isim() {
        return blok_ozellik_isim;
    }

    public void setBlok_ozellik_isim(String blok_ozellik_isim) {
        this.blok_ozellik_isim = blok_ozellik_isim;
    }

    public String getOzellik() {
        return ozellik;
    }

    public void setOzellik(String ozellik) {
        this.ozellik = ozellik;
    }

    public String getBlok_adi() {
        return blok_adi;
    }

    public void setBlok_adi(String blok_adi) {
        this.blok_adi = blok_adi;
    }

    public String getKatsayisi() {
        return katsayisi;
    }

    public void setKatsayisi(String katsayisi) {
        this.katsayisi = katsayisi;
    }

    public String getDaire_sayisi() {
        return daire_sayisi;
    }

    public void setDaire_sayisi(String daire_sayisi) {
        this.daire_sayisi = daire_sayisi;
    }

    public String getAsansor_sayisi() {
        return asansor_sayisi;
    }

    public void setAsansor_sayisi(String asansor_sayisi) {
        this.asansor_sayisi = asansor_sayisi;
    }

    public String getJenerator_sayisi() {
        return jenerator_sayisi;
    }

    public void setJenerator_sayisi(String jenerator_sayisi) {
        this.jenerator_sayisi = jenerator_sayisi;
    }

    public String getGorevli_id() {
        return gorevli_id;
    }

    public void setGorevli_id(String gorevli_id) {
        this.gorevli_id = gorevli_id;
    }

    public String getKira_id() {
        return kira_id;
    }

    public void setKira_id(String kira_id) {
        this.kira_id = kira_id;
    }

    public String getAidat_id() {
        return aidat_id;
    }

    public void setAidat_id(String aidat_id) {
        this.aidat_id = aidat_id;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getGorevli_adi() {
        return gorevli_adi;
    }

    public void setGorevli_adi(String gorevli_adi) {
        this.gorevli_adi = gorevli_adi;
    }

    public String getGorevli_soyadi() {
        return gorevli_soyadi;
    }

    public void setGorevli_soyadi(String gorevli_soyadi) {
        this.gorevli_soyadi = gorevli_soyadi;
    }

    public String getGorevli_tel() {
        return gorevli_tel;
    }

    public void setGorevli_tel(String gorevli_tel) {
        this.gorevli_tel = gorevli_tel;
    }

    public String getMaas() {
        return maas;
    }

    public void setMaas(String maas) {
        this.maas = maas;
    }

    public String getGorevli_tur_id() {
        return gorevli_tur_id;
    }

    public void setGorevli_tur_id(String gorevli_tur_id) {
        this.gorevli_tur_id = gorevli_tur_id;
    }

    public String getGorevli_tur_ad() {
        return gorevli_tur_ad;
    }

    public void setGorevli_tur_ad(String gorevli_tur_ad) {
        this.gorevli_tur_ad = gorevli_tur_ad;
    }

    public String getOturan_id() {
        return oturan_id;
    }

    public void setOturan_id(String oturan_id) {
        this.oturan_id = oturan_id;
    }

    public String getKira_tutari() {
        return kira_tutari;
    }

    public void setKira_tutari(String kira_tutari) {
        this.kira_tutari = kira_tutari;
    }

    public String getVerilis_tarihi() {
        return verilis_tarihi;
    }

    public void setVerilis_tarihi(String verilis_tarihi) {
        this.verilis_tarihi = verilis_tarihi;
    }

    public String getTutar() {
        return tutar;
    }

    public void setTutar(String tutar) {
        this.tutar = tutar;
    }

    public String getGecikme_zami() {
        return gecikme_zami;
    }

    public void setGecikme_zami(String gecikme_zami) {
        this.gecikme_zami = gecikme_zami;
    }

    public String getOturan_ad() {
        return oturan_ad;
    }

    public void setOturan_ad(String oturan_ad) {
        this.oturan_ad = oturan_ad;
    }

    public String getOturan_soyad() {
        return oturan_soyad;
    }

    public void setOturan_soyad(String oturan_soyad) {
        this.oturan_soyad = oturan_soyad;
    }

    public String getOturan_telefon() {
        return oturan_telefon;
    }

    public void setOturan_telefon(String oturan_telefon) {
        this.oturan_telefon = oturan_telefon;
    }

    public String getDaire_id() {
        return daire_id;
    }

    public void setDaire_id(String daire_id) {
        this.daire_id = daire_id;
    }

    public String getBlok_ad() {
        return blok_ad;
    }

    public void setBlok_ad(String blok_ad) {
        this.blok_ad = blok_ad;
    }

    public String getBlok_id() {
        return blok_id;
    }

    public void setBlok_id(String blok_id) {
        this.blok_id = blok_id;
    }

    public String getOturan_tur() {
        return oturan_tur;
    }

    public void setOturan_tur(String oturan_tur) {
        this.oturan_tur = oturan_tur;
    }

    public String getDaire_numarasi() {
        return daire_numarasi;
    }

    public void setDaire_numarasi(String daire_numarasi) {
        this.daire_numarasi = daire_numarasi;
    }

//    public String getBlok_numarasi() {
//        return blok_numarasi;
//    }
//
//    public void setBlok_numarasi(String blok_numarasi) {
//        this.blok_numarasi = blok_numarasi;
//    }
    public String getOturan_turu_id() {
        return oturan_turu_id;
    }

    public void setOturan_turu_id(String oturan_turu_id) {
        this.oturan_turu_id = oturan_turu_id;
    }

    public String getSite_adi() {
        return site_adi;
    }

    public void setSite_adi(String site_adi) {
        this.site_adi = site_adi;
    }

    public String getSite_adresi() {
        return site_adresi;
    }

    public void setSite_adresi(String site_adresi) {
        this.site_adresi = site_adresi;
    }

    public String getSite_telefon() {
        return site_telefon;
    }

    public void setSite_telefon(String site_telefon) {
        this.site_telefon = site_telefon;
    }

    public String getSite_bloksayisi() {
        return site_bloksayisi;
    }

    public void setSite_bloksayisi(String site_bloksayisi) {
        this.site_bloksayisi = site_bloksayisi;
    }

    public String getSite_email() {
        return site_email;
    }

    public void setSite_email(String site_email) {
        this.site_email = site_email;
    }
}
