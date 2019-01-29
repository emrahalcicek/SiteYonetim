package service;

// Site Yönetimi
import com.google.gson.Gson;
import dao.UserData;
import dto.User;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//  SİTE YÖNETİMİ
@Path("/service")
public class InsertService {

    //kullanici girişi servis
    @POST
    @Path("/kullanicigirisi")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")

    public Response KullaniciGirisi(@FormParam("kullanici_adi") String kullanici_adi, @FormParam("parola") String parola, @Context HttpServletRequest request) throws SQLException {

        User user = new User();

        user.setKullanici_adi(kullanici_adi);
        user.setParola(parola);

        if (UserData.KullaniciKontrol(kullanici_adi, parola) == true) {
            HttpSession session = request.getSession();
            session.setAttribute("kullanici_adi", kullanici_adi);
            return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Bilgiler Hatalı!").build();
        }
    }

    @GET
    @Path("/getKullanici")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response getKullanici(@Context HttpServletRequest request) {

        HttpSession session = request.getSession();

        String kullanici_adi = (String) session.getAttribute("kullanici_adi");

        return Response.ok(kullanici_adi).header("Access-Control-Allow-Origin", "*").build();

    }

    //Kullanıcı Çıkış
    @POST
    @Path("/cikis")
    @Consumes("application/x-www-form-urlencoded")
    public Response Cikis(@Context HttpServletRequest request) throws URISyntaxException, IOException {

        HttpSession session = request.getSession();

      //  session.invalidate(); // if bloğundaki işlemle aynı görevi yapıyor.
      if(session.getAttribute("kullanici_adi") != null){
            session.removeAttribute("kullanici_adi");
        }

        return Response.ok().header("Access-Control-Allow-Origin", "*").build();

    }

    // Site Kaydet
    @POST
    @Path("/sitekaydet")
    @Produces("application/json")
    public Response InsertService(@FormParam("ad") String ad, @FormParam("adres") String adres,
            @FormParam("blok_sayi") String blok_sayi, @FormParam("telefon") String telefon, @FormParam("eposta") String eposta) throws SQLException {

        //  System.out.println(ad);
        User user = new User();
        List<User> List = new ArrayList<User>();

        user.setSite_adi(ad);
        user.setSite_adresi(adres);
        user.setSite_bloksayisi(blok_sayi);
        user.setSite_telefon(telefon);
        user.setSite_email(eposta);
        List.add(user);

        UserData ud = new UserData();

        if (emailKontrol(eposta) == true) {
            ud.siteKaydet(List);
            return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();
        }

    }

    public boolean emailKontrol(String email) {
        if (email.matches("^\\w[\\w\\.-]*@([\\w\\-]+\\.)+[a-z]{2,6}$")) {
            return true;
        } else {

            return false;
        }
    }

    // SİTE GUNCELLE
    @POST
    @Path("/siteguncelle")
    @Produces("application/json")
    public Response siteguncelle(@FormParam("id") String id, @FormParam("ad") String ad, @FormParam("adres") String adres,
            @FormParam("blok_sayi") String blok_sayi, @FormParam("telefon") String telefon, @FormParam("eposta") String eposta) throws SQLException {

        //  System.out.println(ad);
        User user = new User();
        List<User> List = new ArrayList<User>();
        user.setSite_id(id);
        user.setSite_adi(ad);
        user.setSite_adresi(adres);
        user.setSite_bloksayisi(blok_sayi);
        user.setSite_telefon(telefon);
        user.setSite_email(eposta);
        List.add(user);

        UserData ud = new UserData();

        if (emailGuncelle(eposta) == true) {
            ud.siteGuncelle(List);
            return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Hata!").build();
        }

    }

    public boolean emailGuncelle(String email) {
        if (email.matches("^\\w[\\w\\.-]*@([\\w\\-]+\\.)+[a-z]{2,6}$")) {
            return true;
        } else {

            return false;
        }
    }

//blok kaydet
    @POST
    @Path("/blokkaydet")
    @Produces("application/json")
    public Response BlokKaydet(@FormParam("b_ad") String b_ad, @FormParam("kat_sayisi") String kat_sayisi, @FormParam("daire_sayisi") String daire_sayisi,
            @FormParam("asansor_sayi") String asansor_sayi, @FormParam("jenerator_sayi") String jenerator_sayi) throws SQLException {

        User user = new User();
        List<User> List = new ArrayList<User>();

        user.setBlok_adi(b_ad);
        user.setKatsayisi(kat_sayisi);
        user.setDaire_sayisi(daire_sayisi);
        user.setAsansor_sayisi(asansor_sayi);
        user.setJenerator_sayisi(jenerator_sayi);

        List.add(user);

        UserData ud = new UserData();
        ud.blokKaydet(List);
        return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

    }
// Blok Guncelle

    @POST
    @Path("/blokguncelle")
    @Produces("application/json")
    public Response BlokGuncelle(@FormParam("b_id") String b_id, @FormParam("b_ad") String b_ad, @FormParam("kat_sayisi") String kat_sayisi, @FormParam("daire_sayisi") String daire_sayisi,
            @FormParam("asansor_sayi") String asansor_sayi, @FormParam("jenerator_sayi") String jenerator_sayi) throws SQLException {

        User user = new User();
        List<User> List = new ArrayList<User>();

        user.setBlok_id(b_id);
        user.setBlok_adi(b_ad);
        user.setKatsayisi(kat_sayisi);
        user.setDaire_sayisi(daire_sayisi);
        user.setAsansor_sayisi(asansor_sayi);
        user.setJenerator_sayisi(jenerator_sayi);

        //  System.out.println(b_ad);
        List.add(user);

        UserData ud = new UserData();
        ud.blokGuncelle(List);
        return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

    }

    // blok ozellik kaydet
    @POST
    @Path("/blokozellikkaydet")
    @Produces("application/json")
    public Response BlokOzellikKaydet(@FormParam("blok_isim") String blok_isim, @FormParam("ozellik_isim") String ozellik_isim) throws SQLException {

        User user = new User();
        List<User> List = new ArrayList<User>();

        user.setBlok_ozellik_isim(blok_isim);
        user.setOzellik(ozellik_isim);

        List.add(user);

        UserData ud = new UserData();
        ud.blokOzellikKaydet(List);
        return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

    }
// daire kaydet

    @POST
    @Path("/dairekaydet")
    @Produces("application/json")
    public Response DaireKaydet(@FormParam("daireblok_adi") String daireblok_adi, @FormParam("dairekat_adi") String dairekat_adi, @FormParam("daireno_adi") String daireno_adi,
            @FormParam("daire_tipi") String daire_tipi, @FormParam("daire_durumu_adi") String daire_durumu_adi) throws SQLException {

        User user = new User();
        List<User> List = new ArrayList<User>();

        user.setDaireblokadi_id(daireblok_adi);
        user.setDairekatno(dairekat_adi);
        user.setDaireno(daireno_adi);
        user.setDaire_tipi_id(daire_tipi);
        user.setDaire_durumu_id(daire_durumu_adi);

        System.out.println(daireblok_adi);
        System.out.println(dairekat_adi);
        System.out.println(daireno_adi);
        System.out.println(daire_tipi);
        System.out.println(daire_durumu_adi);

        List.add(user);

        UserData ud = new UserData();
        ud.daireKaydet(List);
        return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

    }
//daire guncelle

    @POST
    @Path("/daireguncelle")
    @Produces("application/json")
    public Response DaireGuncelle(@FormParam("id_daire") String id_daire, @FormParam("daireblok_adi") String daireblok_adi, @FormParam("dairekat_adi") String dairekat_adi,
            @FormParam("daireno_adi") String daireno_adi, @FormParam("dairetipi_adi") String dairetipi_adi, @FormParam("dairedurumu_adi") String dairedurumu_adi) throws SQLException {

        User user = new User();
        List<User> List = new ArrayList<User>();

        user.setDaireler_id(id_daire);
        user.setDaireblokadi_id(daireblok_adi);
        user.setDairekatno(dairekat_adi);
        user.setDaireno(daireno_adi);
        user.setDaire_tipi_id(dairetipi_adi);
        user.setDaire_durumu_id(dairedurumu_adi);

        List.add(user);

        UserData ud = new UserData();
        ud.daireGuncelle(List);
        return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

    }

    // Site Sakinleri Kaydet
    @POST
    @Path("/siteSakinlerikaydet")
    @Produces("application/json")
    public Response OturanKaydet(@FormParam("adi") String adi, @FormParam("soyad") String soyad, @FormParam("telefon_no") String telefon_no,
            @FormParam("oturan_turu") String oturan_turu, @FormParam("blokad") String blokad, @FormParam("daire_numarasi") String daire_numarasi) throws SQLException {

        User user = new User();
        List<User> List = new ArrayList<User>();

        user.setOturan_ad(adi);
        user.setOturan_soyad(soyad);
        user.setOturan_telefon(telefon_no);
        user.setBlok_id(blokad); // ?? blok_id
        user.setDaire_id(daire_numarasi);
        user.setOturan_turu_id(oturan_turu);

        List.add(user);

        UserData ud = new UserData();
        ud.siteSakinleriKaydet(List);
        return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

    }

    // Site Sakinleri Güncelle
    @POST
    @Path("/siteSakinleriGuncelle")
    @Produces("application/json")
    public Response OturanGuncelle(@FormParam("oturan_id") String oturan_id, @FormParam("adi") String adi, @FormParam("soyad") String soyad, @FormParam("telefon_no") String telefon_no,
            @FormParam("oturan_turu") String oturan_turu, @FormParam("blokad") String blokad, @FormParam("daire_numarasi") String daire_numarasi) throws SQLException {

        //  System.out.println(oturan_id);
        User user = new User();
        List<User> List = new ArrayList<User>();
        user.setOturan_id(oturan_id);
        user.setOturan_ad(adi);
        user.setOturan_soyad(soyad);
        user.setOturan_telefon(telefon_no);
        user.setBlok_id(blokad); // ?? blok_id
        user.setDaire_id(daire_numarasi);
        user.setOturan_turu_id(oturan_turu);

        List.add(user);

        UserData ud = new UserData();
        ud.siteSakinleriGuncelle(List);
        return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

    }

    // aidat kaydet
    @POST
    @Path("/aidatkaydet")
    @Produces("application/json")
    public Response AidatKaydet(@FormParam("tutar") String tutar, @FormParam("verilis_tarihi") String verilis_tarihi, @FormParam("gecikme_zami") String gecikme_zami,
            @FormParam("blok_numara") String blok_numara, @FormParam("daire_num") String daire_num) throws SQLException {

        User user = new User();
        List<User> List = new ArrayList<User>();

        user.setTutar(tutar);
        user.setVerilis_tarihi(verilis_tarihi);
        user.setGecikme_zami(gecikme_zami);
        user.setBlok_id(blok_numara);
        user.setDaire_id(daire_num);

        List.add(user);

        UserData ud = new UserData();
        ud.aidatKaydet(List);
        return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

    }

    // AİDAT GÜNCELLE
    @POST
    @Path("/aidatguncelle")
    @Produces("application/json")
    public Response AidatGuncelleme(@FormParam("aidat_id") String aidat_id, @FormParam("tutar") String tutar, @FormParam("verilis_tarihi") String verilis_tarihi, @FormParam("gecikme_zami") String gecikme_zami,
            @FormParam("blok_numara") String blok_numara, @FormParam("daire_num") String daire_num) throws SQLException {

        User user = new User();
        List<User> List = new ArrayList<User>();

        user.setAidat_id(aidat_id);
        user.setTutar(tutar);
        user.setVerilis_tarihi(verilis_tarihi);
        user.setGecikme_zami(gecikme_zami);
        user.setBlok_id(blok_numara);
        user.setDaire_id(daire_num);

        List.add(user);

        UserData ud = new UserData();
        ud.AidatGuncelle(List);

        return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

    }

    // kira kaydet
    @POST
    @Path("/kirakaydet")
    @Produces("application/json")
    public Response KiraKaydet(@FormParam("kira_tutari") String kira_tutari, @FormParam("odeme_tarihi") String odeme_tarihi,
            @FormParam("daire_sakinler") String daire_sakinler) throws SQLException {

        User user = new User();
        List<User> List = new ArrayList<User>();

        user.setKira_tutari(kira_tutari);
        user.setVerilis_tarihi(odeme_tarihi);
        user.setOturan_turu_id(daire_sakinler);

        List.add(user);

        UserData ud = new UserData();
        ud.kiraKaydet(List);
        return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

    }

// Kira Guncelle
    @POST
    @Path("/kiraguncelle")
    @Produces("application/json")
    public Response KiraGuncelleme(@FormParam("kira_id") String kira_id, @FormParam("kira_tutari") String kira_tutari, @FormParam("odeme_tarihi") String odeme_tarihi,
            @FormParam("daire_sakinler") String daire_sakinler) throws SQLException {

        User user = new User();
        List<User> List = new ArrayList<User>();

        user.setKira_id(kira_id);
        user.setKira_tutari(kira_tutari);
        user.setVerilis_tarihi(odeme_tarihi);
        user.setOturan_id(daire_sakinler);

        List.add(user);

        UserData ud = new UserData();
        ud.KiraGuncelle(List);
        return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();
    }

    // gorevli kaydet
    @POST
    @Path("/gorevlikaydet")
    @Produces("application/json")
    public Response GorevliKaydet(@FormParam("gorevli_adi") String gorevli_adi, @FormParam("gorevli_soyadi") String gorevli_soyadi,
            @FormParam("gorev_turu") String gorev_turu, @FormParam("gorevli_tel") String gorevli_tel, @FormParam("maas") String maas,
            @FormParam("gorevli_blok") String gorevli_blok) throws SQLException {

        User user = new User();
        List<User> List = new ArrayList<User>();

        user.setGorevli_adi(gorevli_adi);
        user.setGorevli_soyadi(gorevli_soyadi);
        user.setGorevli_tur_id(gorev_turu);
        user.setGorevli_tel(gorevli_tel);
        user.setMaas(maas);
        user.setBlok_id(gorevli_blok);

        List.add(user);

        UserData ud = new UserData();
        ud.gorevliKaydet(List);
        return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

    }

    // gorevli guncelle
    @POST
    @Path("/gorevliguncelle")
    @Produces("application/json")
    public Response GorevliGuncelle(@FormParam("gorevli_id") String gorevli_id, @FormParam("gorevli_adi") String gorevli_adi, @FormParam("gorevli_soyadi") String gorevli_soyadi,
            @FormParam("gorev_turu") String gorev_turu, @FormParam("gorevli_tel") String gorevli_tel, @FormParam("maas") String maas,
            @FormParam("gorevli_blok") String gorevli_blok) throws SQLException {

        User user = new User();
        List<User> List = new ArrayList<User>();
        user.setGorevli_id(gorevli_id);
        user.setGorevli_adi(gorevli_adi);
        user.setGorevli_soyadi(gorevli_soyadi);
        user.setGorevli_tur_id(gorev_turu);
        user.setGorevli_tel(gorevli_tel);
        user.setMaas(maas);
        user.setBlok_id(gorevli_blok);

        List.add(user);

        UserData ud = new UserData();
        ud.gorevliGuncelle(List);
        return Response.ok("Basariyla Kaydedildi!", MediaType.TEXT_PLAIN).build();

    }

    //SİTE BİLGİLERİ
    @GET
    @Produces("application/json")
    @Path("/sitebilgilerigetir")
    public Response SiteBilgileri() throws SQLException {
        String site_bilgileri = null;
        List<User> userList = new ArrayList<User>();
        try {
            userList = new UserData().SiteBilgilerim();
            Gson gson = new Gson();
            site_bilgileri = gson.toJson(userList);
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
        }

        return Response.ok(site_bilgileri).header("Access-Control-Allow-Origin", "*").build();
    }

//BLOK BİLGİLERİM
    @GET
    @Produces("application/json")
    @Path("/blokbilgilerigetir")
    public Response BlokBilgileri() throws SQLException {
        String blok_bilgileri = null;
        List<User> userList = new ArrayList<User>();
        try {
            userList = new UserData().blokBilgilerim();
            Gson gson = new Gson();
            blok_bilgileri = gson.toJson(userList);
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
        }

        return Response.ok(blok_bilgileri).header("Access-Control-Allow-Origin", "*").build();
    }
// BLOK-OZELLİK BİLGİLERİM

    @GET
    @Produces("application/json")
    @Path("/blokozellikgetir")
    public Response BlokOzellikgetir() throws SQLException {
        String blok_ozellik = null;
        List<User> userList = new ArrayList<User>();
        try {
            userList = new UserData().blokOzellikBilgilerim();
            Gson gson = new Gson();
            blok_ozellik = gson.toJson(userList);
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
        }

        return Response.ok(blok_ozellik).header("Access-Control-Allow-Origin", "*").build();
    }
// DAIRE TİPİ(ODA SAYISI) 

    @GET
    @Produces("application/json")
    @Path("/dairetipigetir")
    public Response DaireTipigetir() throws SQLException {
        String daire_tipi = null;
        List<User> userList = new ArrayList<User>();
        try {
            userList = new UserData().dairetipi();
            Gson gson = new Gson();
            daire_tipi = gson.toJson(userList);
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
        }

        return Response.ok(daire_tipi).header("Access-Control-Allow-Origin", "*").build();
    }
//DAİRE DURUMU (BOS -DOLU)

    @GET
    @Produces("application/json")
    @Path("/dairedurumugetir")
    public Response DaireDurumugetir() throws SQLException {
        String daire_durumu = null;
        List<User> userList = new ArrayList<User>();
        try {
            userList = new UserData().dairedurumu();
            Gson gson = new Gson();
            daire_durumu = gson.toJson(userList);
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
        }

        return Response.ok(daire_durumu).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Produces("application/json")
    @Path("/oturanturgetir")
    public Response oturanTurgetir() throws SQLException {
        String oturan_turu = null;
        List<User> userList = new ArrayList<User>();
        try {
            userList = new UserData().OturanTur();
            Gson gson = new Gson();
            oturan_turu = gson.toJson(userList);
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
        }

        return Response.ok(oturan_turu).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Produces("application/json")
    @Path("/blokgetir")
    public Response Blokgetir() throws SQLException {
        String blok = null;
        List<User> userList = new ArrayList<User>();
        try {
            userList = new UserData().Blok();
            Gson gson = new Gson();
            blok = gson.toJson(userList);
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
        }

        return Response.ok(blok).header("Access-Control-Allow-Origin", "*").build();
    }
// DAİRE GETİR

    @GET
    @Produces("application/json")
    @Path("/dairegetir")
    public Response Dairegetir() throws SQLException {
        String oturan_turu = null;
        List<User> userList = new ArrayList<User>();
        try {
            userList = new UserData().Daire();
            Gson gson = new Gson();
            oturan_turu = gson.toJson(userList);
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
        }

        return Response.ok(oturan_turu).header("Access-Control-Allow-Origin", "*").build();
    }
// DAİRE BİLGİLERİ GETİR

    @GET
    @Produces("application/json")
    @Path("/dairebilgilerigetir")
    public Response DaireBilgilerigetir() throws SQLException {
        String daire_bilgi = null;
        List<User> userList = new ArrayList<User>();
        try {
            userList = new UserData().daireBilgilerim();
            Gson gson = new Gson();
            daire_bilgi = gson.toJson(userList);
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
        }

        return Response.ok(daire_bilgi).header("Access-Control-Allow-Origin", "*").build();
    }

    //daire sakinleri
    @GET
    @Produces("application/json")
    @Path("/dairesakinlerigetir")
    public Response DaireSakinlerigetir() throws SQLException {
        String d_sakini = null;
        List<User> userList = new ArrayList<User>();
        try {
            userList = new UserData().daireSakinleri();
            Gson gson = new Gson();
            d_sakini = gson.toJson(userList);
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
        }

        return Response.ok(d_sakini).header("Access-Control-Allow-Origin", "*").build();
    }

    // GOREVLİ TURU
    @GET
    @Produces("application/json")
    @Path("/gorevliturgetir")
    public Response GorevliTurgetir() throws SQLException {
        String gorevli_tur = null;
        List<User> userList = new ArrayList<User>();
        try {
            userList = new UserData().gorevliTur();
            Gson gson = new Gson();
            gorevli_tur = gson.toJson(userList);
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
        }

        return Response.ok(gorevli_tur).header("Access-Control-Allow-Origin", "*").build();
    }

    // site sakinleri bilgileri getir
    @GET
    @Produces("application/json")
    @Path("/sitesakinlerigetir")
    public Response SiteSakinlerim() throws SQLException {
        String site_oturanlar = null;
        List<User> userList = new ArrayList<User>();
        try {
            userList = new UserData().OturanBilgilerim();
            Gson gson = new Gson();
            site_oturanlar = gson.toJson(userList);
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
        }

        return Response.ok(site_oturanlar).header("Access-Control-Allow-Origin", "*").build();
    }

    // AİDAT BİLGİLERİ GETİR
    @GET
    @Produces("application/json")
    @Path("/aidatbilgilerigetir")
    public Response Aidatlarim() throws SQLException {
        String aidat = null;
        List<User> userList = new ArrayList<User>();
        try {
            userList = new UserData().AidatBilgilerim();
            Gson gson = new Gson();
            aidat = gson.toJson(userList);
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
        }

        return Response.ok(aidat).header("Access-Control-Allow-Origin", "*").build();
    }

// KİRA BİLGİLERİNİ GETİR
    @GET
    @Produces("application/json")
    @Path("/kirabilgilerigetir")
    public Response Kiralarim() throws SQLException {
        String kira = null;
        List<User> userList = new ArrayList<User>();
        try {
            userList = new UserData().KiraBilgilerim();
            Gson gson = new Gson();
            kira = gson.toJson(userList);
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
        }

        return Response.ok(kira).header("Access-Control-Allow-Origin", "*").build();
    }

    //GOREVLİ BİLGİLERİ GETİR
    @GET
    @Produces("application/json")
    @Path("/gorevlibilgilerigetir")
    public Response Gorevlilerim() throws SQLException {
        String gorevli = null;
        List<User> userList = new ArrayList<User>();
        try {
            userList = new UserData().GorevliBilgilerim();
            Gson gson = new Gson();
            gorevli = gson.toJson(userList);
        } catch (Exception e) {

            return Response.status(Response.Status.BAD_REQUEST).entity("Bir sorun olustu!").build();
        }

        return Response.ok(gorevli).header("Access-Control-Allow-Origin", "*").build();
    }
}
