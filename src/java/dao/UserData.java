package dao;

import dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// SERVİCE İŞLEMLERİ
// INSERT UPDATE İŞLEMLERİ
public class UserData {

    Database db = new Database();

    public boolean siteKaydet(List<User> userList) throws SQLException {

        PreparedStatement stmt = null;
        Connection con = Database.getConnection();
        Iterator<User> iterate = userList.iterator();

        try {

            while (iterate.hasNext()) {

                User u = iterate.next();

                String query = " INSERT INTO SITE2 (AD,ADRES, BLOK_SAYISI,TELEFON,EPOSTA) VALUES (?,?,?,?,?)";
                stmt = con.prepareStatement(query);
                stmt.setString(1, u.getSite_adi());
                stmt.setString(2, u.getSite_adresi());
                stmt.setString(3, u.getSite_bloksayisi());
                stmt.setString(4, u.getSite_telefon());
                stmt.setString(5, u.getSite_email());
                stmt.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }
        return true;
    }
// site bilgilerini guncelle

    public boolean siteGuncelle(List<User> userList) throws SQLException {

        PreparedStatement stmt = null;
        Connection con = Database.getConnection();
        Iterator<User> iterate = userList.iterator();

        try {

            while (iterate.hasNext()) {

                User u = iterate.next();

                String query = " UPDATE  SITE2 SET AD=?,ADRES=?,BLOK_SAYISI=?,TELEFON=?,EPOSTA=?  WHERE ID=?";
                stmt = con.prepareStatement(query);

                stmt.setString(1, u.getSite_adi());
                stmt.setString(2, u.getSite_adresi());
                stmt.setString(3, u.getSite_bloksayisi());
                stmt.setString(4, u.getSite_telefon());
                stmt.setString(5, u.getSite_email());
                stmt.setString(6, u.getSite_id());
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }
        return true;
    }
//blok kaydet

    public void blokKaydet(List<User> userList) throws SQLException {

        PreparedStatement stmt = null;
        Connection con = Database.getConnection();
        Iterator<User> iterate = userList.iterator();

        try {

            while (iterate.hasNext()) {

                User u = iterate.next();

                String query = " INSERT INTO BLOK2 (BLOK_AD,KAT_SAYISI,DAIRE_SAYISI,ASANSOR_SAYISI,JENERATOR_SAYISI) VALUES (?,?,?,?,?)";
                stmt = con.prepareStatement(query);

                stmt.setString(1, u.getBlok_adi());
                stmt.setString(2, u.getKatsayisi());
                stmt.setString(3, u.getDaire_sayisi());
                stmt.setString(4, u.getAsansor_sayisi());
                stmt.setString(5, u.getJenerator_sayisi());
                stmt.execute();

                // System.out.println(u.getDaire_id());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

    }
//Blok Guncelle

    public void blokGuncelle(List<User> userList) throws SQLException {

        PreparedStatement stmt = null;
        Connection con = Database.getConnection();
        Iterator<User> iterate = userList.iterator();

        try {

            while (iterate.hasNext()) {

                User u = iterate.next();

                String query = " UPDATE  BLOK2 SET BLOK_AD=?,KAT_SAYISI=?,DAIRE_SAYISI=?,ASANSOR_SAYISI=?,JENERATOR_SAYISI=? WHERE ID=?";
                stmt = con.prepareStatement(query);

                stmt.setString(1, u.getBlok_adi());
                stmt.setString(2, u.getKatsayisi());
                stmt.setString(3, u.getDaire_sayisi());
                stmt.setString(4, u.getAsansor_sayisi());
                stmt.setString(5, u.getJenerator_sayisi());
                stmt.setString(6, u.getBlok_id());
                stmt.executeUpdate();

                System.out.println(u.getBlok_adi());
                System.out.println(u.getBlok_id());
                System.out.println(u.getKatsayisi());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

    }
    //blok-ozellik kaydet

    public void blokOzellikKaydet(List<User> userList) throws SQLException {

        PreparedStatement stmt = null;
        Connection con = Database.getConnection();
        Iterator<User> iterate = userList.iterator();

        try {

            while (iterate.hasNext()) {

                User u = iterate.next();

                String query = " INSERT INTO BLOK_OZELLIK (BLOK_ID,OZELLIK) VALUES (?,?)";
                stmt = con.prepareStatement(query);

                stmt.setString(1, u.getBlok_ozellik_isim());
                stmt.setString(2, u.getOzellik());

                stmt.execute();

                // System.out.println(u.getDaire_id());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

    }
    //Daire Kaydet

    public void daireKaydet(List<User> userList) throws SQLException {

        PreparedStatement stmt = null;
        Connection con = Database.getConnection();
        Iterator<User> iterate = userList.iterator();

        try {

            while (iterate.hasNext()) {

                User u = iterate.next();

                String query = " INSERT INTO DAIRE (KAT_NO,DAIRE_NO,TUR_ID,DAIRE_DURUM_ID,BLOK_ID ) VALUES (?,?,?,?,?)";
                stmt = con.prepareStatement(query);
                stmt.setString(1, u.getDairekatno());
                stmt.setString(2, u.getDaireno());
                stmt.setString(3, u.getDaire_tipi_id());
                stmt.setString(4, u.getDaire_durumu_id());
                stmt.setString(5, u.getDaireblokadi_id());
                stmt.execute();

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

    }
//daire guncelle

    public void daireGuncelle(List<User> userList) throws SQLException {

        PreparedStatement stmt = null;
        Connection con = Database.getConnection();
        Iterator<User> iterate = userList.iterator();

        try {

            while (iterate.hasNext()) {

                User u = iterate.next();

                String query = " UPDATE DAIRE SET KAT_NO=?,DAIRE_NO=?,TUR_ID=?,BLOK_ID=?,DAIRE_DURUM_ID=? WHERE ID=?";
                stmt = con.prepareStatement(query);
                stmt.setString(1, u.getDairekatno());
                stmt.setString(2, u.getDaireno());
                stmt.setString(3, u.getDaire_tipi_id());
                stmt.setString(4, u.getDaireblokadi_id());
                stmt.setString(5, u.getDaire_durumu_id());
                stmt.setString(6, u.getDaireler_id());
                stmt.executeUpdate();

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

    }

    // Site Sakinleri kaydet
    public void siteSakinleriKaydet(List<User> userList) throws SQLException {

        PreparedStatement stmt = null;
        Connection con = Database.getConnection();
        Iterator<User> iterate = userList.iterator();

        try {

            while (iterate.hasNext()) {

                User u = iterate.next();
                u.getOturan_ad();
                u.getOturan_soyad();
                u.getOturan_telefon();
                u.getOturan_turu_id();
                u.getBlok_id();
                u.getDaire_id();

                String query = " INSERT INTO DAIRE_SAKINLERI3 (AD,SOYAD,TELEFON_NO,TURU_ID,BLOK_ID,DAIRE_ID) VALUES (?,?,?,?,?,?)";
                stmt = con.prepareStatement(query);
                stmt.setString(1, u.getOturan_ad());
                stmt.setString(2, u.getOturan_soyad());
                stmt.setString(3, u.getOturan_telefon());
                stmt.setString(4, u.getOturan_turu_id());
                stmt.setString(5, u.getBlok_id());
                stmt.setString(6, u.getDaire_id());
                stmt.execute();

                // System.out.println(u.getDaire_id());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

    }

    // Site Sakinleri Güncelle
    public void siteSakinleriGuncelle(List<User> userList) throws SQLException {

        PreparedStatement stmt = null;
        Connection con = Database.getConnection();
        Iterator<User> iterate = userList.iterator();

        try {

            while (iterate.hasNext()) {

                User u = iterate.next();
                u.getOturan_id();
                u.getOturan_ad();
                u.getOturan_soyad();
                u.getOturan_telefon();
                u.getOturan_turu_id();
                u.getBlok_id();
                u.getDaire_id();

                String query = " UPDATE DAIRE_SAKINLERI3 SET AD=?,SOYAD=?,TELEFON_NO=?,TURU_ID=?,BLOK_ID=?,DAIRE_ID=? WHERE ID=?";
                stmt = con.prepareStatement(query);
                stmt.setString(1, u.getOturan_ad());
                stmt.setString(2, u.getOturan_soyad());
                stmt.setString(3, u.getOturan_telefon());
                stmt.setString(4, u.getOturan_turu_id());
                stmt.setString(5, u.getBlok_id());
                stmt.setString(6, u.getDaire_id());
                stmt.setString(7, u.getOturan_id());
                stmt.executeUpdate();

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

    }

    /// aidat kaydet
    public void aidatKaydet(List<User> userList) throws SQLException {

        PreparedStatement stmt = null;
        Connection con = Database.getConnection();
        Iterator<User> iterate = userList.iterator();

        try {

            while (iterate.hasNext()) {

                User u = iterate.next();
                u.getTutar();
                u.getVerilis_tarihi();
                u.getGecikme_zami();
                u.getBlok_id();
                u.getDaire_id();

                String query = " INSERT INTO AIDAT2 (TUTAR,VERILIS_TARIHI,GECIKME_ZAMI,BLOK_ID,DAIRE_ID) VALUES (?,?,?,?,?)";
                stmt = con.prepareStatement(query);
                stmt.setString(1, u.getTutar());
                stmt.setString(2, u.getVerilis_tarihi());
                stmt.setString(3, u.getGecikme_zami());
                stmt.setString(4, u.getBlok_id());
                stmt.setString(5, u.getDaire_id());
                stmt.execute();

                //System.out.println(u.getOturan_soyad());
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

    }

    // aidat  bilgilerini guncelle
    public void AidatGuncelle(List<User> userList) throws SQLException {

        PreparedStatement stmt = null;
        Connection con = Database.getConnection();
        Iterator<User> iterate = userList.iterator();

        try {

            while (iterate.hasNext()) {

                User u = iterate.next();
                u.getAidat_id();
                u.getTutar();
                u.getVerilis_tarihi();
                u.getGecikme_zami();
                u.getBlok_id();
                u.getDaire_id();

                String query = " UPDATE AIDAT2 SET TUTAR=?,VERILIS_TARIHI=?,GECIKME_ZAMI=?,BLOK_ID=?,DAIRE_ID=? WHERE ID=?";
                stmt = con.prepareStatement(query);

                stmt.setString(1, u.getTutar());
                stmt.setString(2, u.getVerilis_tarihi());
                stmt.setString(3, u.getGecikme_zami());
                stmt.setString(4, u.getBlok_id());
                stmt.setString(5, u.getDaire_id());
                stmt.setString(6, u.getAidat_id());

                stmt.executeUpdate();

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

    }

    // Kira kaydet
    public void kiraKaydet(List<User> userList) throws SQLException {

        PreparedStatement stmt = null;
        Connection con = Database.getConnection();
        Iterator<User> iterate = userList.iterator();

        try {

            while (iterate.hasNext()) {

                User u = iterate.next();
                u.getKira_tutari();
                u.getVerilis_tarihi();
                u.getOturan_turu_id();

                String query = " INSERT INTO KIRA3 (KIRA_TUTAR,ODEME_TARIHI,DAIRE_SAKINLERI_ID) VALUES (?,?,?)";
                stmt = con.prepareStatement(query);
                stmt.setString(1, u.getKira_tutari());
                stmt.setString(2, u.getVerilis_tarihi());
                stmt.setString(3, u.getOturan_turu_id()); //Oturan_turu_id ??
                stmt.execute();

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

    }
// KİRA GUNCELLE

    public void KiraGuncelle(List<User> userList) throws SQLException {

        PreparedStatement stmt = null;
        Connection con = Database.getConnection();
        Iterator<User> iterate = userList.iterator();

        try {

            while (iterate.hasNext()) {

                User u = iterate.next();
                u.getKira_id();
                u.getKira_tutari();
                u.getVerilis_tarihi();
                u.getOturan_turu_id();

                String query = " UPDATE KIRA3 SET KIRA_TUTAR=?,ODEME_TARIHI=?,DAIRE_SAKINLERI_ID=? WHERE ID=?";
                stmt = con.prepareStatement(query);

                stmt.setString(1, u.getKira_tutari());
                stmt.setString(2, u.getVerilis_tarihi());
                stmt.setString(3, u.getOturan_id());
                stmt.setString(4, u.getKira_id());
                stmt.executeUpdate();

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

    }

    // GOREVLİ KAYDET
    public void gorevliKaydet(List<User> userList) throws SQLException {

        PreparedStatement stmt = null;
        Connection con = Database.getConnection();
        Iterator<User> iterate = userList.iterator();

        try {

            while (iterate.hasNext()) {

                User u = iterate.next();
                u.getGorevli_adi();
                u.getGorevli_soyadi();
                u.getGorevli_tur_id();
                u.getMaas();
                u.getGorevli_tel();
                u.getBlok_id();

                String query = " INSERT INTO GOREVLI2 (GOREVLI_ADI,GOREVLI_SOYADI,TUR_ID,TELEFON,MAAS,BLOK_ID) VALUES (?,?,?,?,?,?)";
                stmt = con.prepareStatement(query);
                stmt.setString(1, u.getGorevli_adi());
                stmt.setString(2, u.getGorevli_soyadi());
                stmt.setString(3, u.getGorevli_tur_id());
                stmt.setString(4, u.getGorevli_tel());
                stmt.setString(5, u.getMaas());
                stmt.setString(6, u.getBlok_id());

                stmt.execute();

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

    }

    //GOREVLİ GUNCELLE
    public void gorevliGuncelle(List<User> userList) throws SQLException {

        PreparedStatement stmt = null;
        Connection con = Database.getConnection();
        Iterator<User> iterate = userList.iterator();

        try {

            while (iterate.hasNext()) {

                User u = iterate.next();
                u.getGorevli_adi();
                u.getGorevli_soyadi();
                u.getGorevli_tur_id();
                u.getMaas();
                u.getGorevli_tel();
                u.getBlok_id();

                String query = " UPDATE  GOREVLI2 SET GOREVLI_ADI=?,GOREVLI_SOYADI=?,TUR_ID=?,TELEFON=?,MAAS=?,BLOK_ID=? WHERE ID=? ";
                stmt = con.prepareStatement(query);
                stmt.setString(1, u.getGorevli_adi());
                stmt.setString(2, u.getGorevli_soyadi());
                stmt.setString(3, u.getGorevli_tur_id());
                stmt.setString(4, u.getGorevli_tel());
                stmt.setString(5, u.getMaas());
                stmt.setString(6, u.getBlok_id());
                stmt.setString(7, u.getGorevli_id());
                stmt.executeUpdate();

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

    }

    // ------- SELECT İŞLEMLERİ  ------
    
// Kullanıcı Girişi
   public static boolean KullaniciKontrol(String kullanici_adi, String parola) throws SQLException {
       
        Connection con = Database.getConnection();
        PreparedStatement prstmt = con.prepareStatement("select * from kullanicilar where kullanici_adi='"
                + kullanici_adi
                + "' AND parola='"
                + parola
                + "'");
        ResultSet rs = prstmt.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }
   
   
   
   
    //site bilgileri çekme
    public List<User> SiteBilgilerim() throws SQLException {

        Connection con = Database.getConnection();

        List<User> pList = new ArrayList<User>();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {

            stmt = con.prepareStatement("SELECT * FROM SITE2 ");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User p = new User();
                p.setSite_id(resultSet.getString("ID"));
                p.setSite_adi(resultSet.getString("AD")); // VERİTABANI KOLON ADI
                p.setSite_adresi(resultSet.getString("ADRES"));
                p.setSite_bloksayisi(resultSet.getString("BLOK_SAYISI"));
                p.setSite_telefon(resultSet.getString("TELEFON"));
                p.setSite_email(resultSet.getString("EPOSTA"));
                pList.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

        return pList;
    }
// BLOK BİLGİLERİNİ ÇEKME

    public List<User> blokBilgilerim() throws SQLException {

        Connection con = Database.getConnection();

        List<User> pList = new ArrayList<User>();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {

            stmt = con.prepareStatement("SELECT * FROM BLOK2 ");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User p = new User();
                p.setBlok_id(resultSet.getString("ID"));
                p.setBlok_adi(resultSet.getString("BLOK_AD")); // VERİTABANI KOLON ADI
                p.setKatsayisi(resultSet.getString("KAT_SAYISI"));
                p.setDaire_sayisi(resultSet.getString("DAIRE_SAYISI"));
                p.setAsansor_sayisi(resultSet.getString("ASANSOR_SAYISI"));
                p.setJenerator_sayisi(resultSet.getString("JENERATOR_SAYISI"));
                pList.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

        return pList;
    }

//blok ozellik çekme
    public List<User> blokOzellikBilgilerim() throws SQLException {

        Connection con = Database.getConnection();

        List<User> pList = new ArrayList<User>();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {

            stmt = con.prepareStatement("SELECT * FROM VW_BLOK_OZELLIK");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User p = new User();
                p.setBlok_ozellik_id(resultSet.getString("ID"));
                p.setBlok_ozellik_isim(resultSet.getString("BLOK_AD")); // VERİTABANI KOLON ADI
                p.setOzellik(resultSet.getString("OZELLIK"));

                pList.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

        return pList;
    }

    // daire tipi çekme(oda sayısı)
    public List<User> dairetipi() throws SQLException {

        Connection con = Database.getConnection();

        List<User> pList = new ArrayList<User>();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {

            stmt = con.prepareStatement("SELECT * FROM DAIRE_TUR2");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User p = new User();
                p.setDaire_tipi_id(resultSet.getString("ID"));
                p.setDaire_tipi(resultSet.getString("DAIRE_TIPI")); // VERİTABANI KOLON ADI

                pList.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

        return pList;
    }

// daire durumu (boş dolu) çekme
    public List<User> dairedurumu() throws SQLException {

        Connection con = Database.getConnection();

        List<User> pList = new ArrayList<User>();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {

            stmt = con.prepareStatement("SELECT * FROM DAIRE_DURUM2");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User p = new User();
                p.setDaire_durumu_id(resultSet.getString("ID"));
                p.setDaire_durumu_adi(resultSet.getString("DAIRE_DURUMU")); // VERİTABANI KOLON ADI

                pList.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

        return pList;
    }
// daire bilgilerini çekme

    public List<User> daireBilgilerim() throws SQLException {

        Connection con = Database.getConnection();

        List<User> pList = new ArrayList<User>();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {

            stmt = con.prepareStatement("SELECT * FROM VW_DAIRELER");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User p = new User();
                p.setDaireler_id(resultSet.getString("ID"));
                p.setDaireblokadi_id(resultSet.getString("BLOK_AD")); // VERİTABANI KOLON ADI
                p.setDairekatno(resultSet.getString("KAT_NO"));
                p.setDaireno(resultSet.getString("DAIRE_NO"));
                p.setDaire_tipi(resultSet.getString("DAIRE_TIPI"));
                p.setDaire_durumu_adi(resultSet.getString("DAIRE_DURUMU"));

                pList.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

        return pList;
    }

    // site sakinleri bilgileri çekme
    public List<User> OturanBilgilerim() throws SQLException {

        Connection con = Database.getConnection();

        List<User> pList = new ArrayList<User>();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {

            stmt = con.prepareStatement("SELECT * FROM VW_OTURANLAR");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User p = new User();
                p.setOturan_id(resultSet.getString("ID"));
                p.setOturan_ad(resultSet.getString("AD")); // VERİTABANI KOLON ADI
                p.setOturan_soyad(resultSet.getString("SOYAD"));
                p.setOturan_telefon(resultSet.getString("TELEFON_NO"));
                p.setOturan_tur(resultSet.getString("TURU"));    ///Oturan_tur onceki değer
                p.setBlok_ad(resultSet.getString("BLOK_AD"));       /// Blok_ad
                p.setDaire_numarasi(resultSet.getString("DAIRE_NO"));   // Daire_numarasi
                pList.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

        return pList;
    }

    // Aidat Verilerini çekme
    public List<User> AidatBilgilerim() throws SQLException {

        Connection con = Database.getConnection();

        List<User> pList = new ArrayList<User>();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {

            stmt = con.prepareStatement("SELECT * FROM VW_AIDAT");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User p = new User();
                p.setAidat_id(resultSet.getString("ID"));
                p.setTutar(resultSet.getString("TUTAR")); // VERİTABANI KOLON ADI
                p.setVerilis_tarihi(resultSet.getString("VERILIS_TARIHI"));
                p.setGecikme_zami(resultSet.getString("GECIKME_ZAMI"));
                p.setBlok_ad(resultSet.getString("BLOK_AD"));       /// Blok_ad
                p.setDaire_numarasi(resultSet.getString("DAIRE_NO"));   // Daire_numarasi
                pList.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

        return pList;
    }

//kira verilerini çekme
    public List<User> KiraBilgilerim() throws SQLException {

        Connection con = Database.getConnection();

        List<User> pList = new ArrayList<User>();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {

            stmt = con.prepareStatement("SELECT * FROM VW_KIRA");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User p = new User();
                p.setKira_id(resultSet.getString("ID"));
                p.setKira_tutari(resultSet.getString("KIRA_TUTAR")); // VERİTABANI KOLON ADI
                p.setVerilis_tarihi(resultSet.getString("ODEME_TARIHI"));
                p.setOturan_id(resultSet.getString("ADSOYAD"));

                pList.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

        return pList;
    }

    //GOREVLİ VERİLERİNİ ÇEKME
    public List<User> GorevliBilgilerim() throws SQLException {

        Connection con = Database.getConnection();

        List<User> pList = new ArrayList<User>();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {

            stmt = con.prepareStatement("SELECT * FROM VW_GOREVLI");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User p = new User();
                p.setGorevli_id(resultSet.getString("ID"));
                p.setGorevli_adi(resultSet.getString("GOREVLI_ADI")); // VERİTABANI KOLON ADI
                p.setGorevli_soyadi(resultSet.getString("GOREVLI_SOYADI"));
                p.setGorevli_tur_ad(resultSet.getString("TUR"));
                p.setGorevli_tel(resultSet.getString("TELEFON"));
                p.setMaas(resultSet.getString("MAAS"));
                p.setBlok_ad(resultSet.getString("BLOK_AD"));
                pList.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

        return pList;
    }

    public List<User> OturanTur() throws SQLException {

        Connection con = Database.getConnection();

        List<User> pList = new ArrayList<User>();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {

            stmt = con.prepareStatement("SELECT * FROM DAIRE_SAKINLERI_TUR2 ");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User p = new User();

                p.setOturan_turu_id(resultSet.getString("ID")); // VERİTABANI KOLON ADI
                p.setOturan_tur(resultSet.getString("TURU"));
                pList.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

        return pList;
    }

    public List<User> Blok() throws SQLException {

        Connection con = Database.getConnection();

        List<User> pList = new ArrayList<User>();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {

            stmt = con.prepareStatement("SELECT * FROM BLOK2 ");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User p = new User();

                p.setBlok_id(resultSet.getString("ID")); // VERİTABANI KOLON ADI
                p.setBlok_ad(resultSet.getString("BLOK_AD"));
                pList.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

        return pList;
    }

    public List<User> Daire() throws SQLException {

        Connection con = Database.getConnection();

        List<User> pList = new ArrayList<User>();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {

            stmt = con.prepareStatement("SELECT * FROM DAIRE ");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User p = new User();

                p.setDaire_id(resultSet.getString("ID")); // VERİTABANI KOLON ADI
                p.setDaire_numarasi(resultSet.getString("DAIRE_NO"));
                pList.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

        return pList;
    }

    // DAİRE SAKİNLERİ ÇEKME
    public List<User> daireSakinleri() throws SQLException {

        Connection con = Database.getConnection();

        List<User> pList = new ArrayList<User>();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {

            stmt = con.prepareStatement("select ID, (AD || ' ' || SOYAD) As ADSOYAD\n"
                    + "from daire_sakinleri3 ");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User p = new User();

                p.setOturan_id(resultSet.getString("ID")); // VERİTABANI KOLON ADI
                p.setOturan_ad(resultSet.getString("ADSOYAD"));

                pList.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

        return pList;
    }

    //GOREVLİ TÜR 
    public List<User> gorevliTur() throws SQLException {

        Connection con = Database.getConnection();

        List<User> pList = new ArrayList<User>();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {

            stmt = con.prepareStatement("SELECT * FROM GOREV_TUR2");
            resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User p = new User();

                p.setGorevli_tur_id(resultSet.getString("ID")); // VERİTABANI KOLON ADI
                p.setGorevli_tur_ad(resultSet.getString("TUR"));

                pList.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException logOrIgnore) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException logOrIgnore) {
                }
            }
        }

        return pList;
    }
}
