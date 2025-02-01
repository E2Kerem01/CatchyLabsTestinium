CatchyLabs Cases
=====================
Created by kmeti on 1.02.2025

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

Basarili Login Senaryosu
----------------
Scenario: Kullanıcı başarılı login olur.
  * Kullanici giris ekranina gider ve Login sayfasinin açıldıgı görülür
  * Kullanıcı e-posta olarak "kerem.metin" ve şifre olarak "E2Kerem01." girer.
  * Kullanıcı giriş butonuna tıklar
  * Başarılı login sonrası Open Money butonun geldiği görülür.


Basarisiz Sifre Login Senaryosu
----------------
Scenario: Kullanıcı başarılı login olur.
  * Kullanici giris ekranina gider ve Login sayfasinin açıldıgı görülür
  * Kullanıcı e-posta olarak "kerem.metin" ve şifre olarak "E2Kerem01.." girer.
  * Kullanıcı giriş butonuna tıklar
  * Başarısız login sonrası hata mesajının geldiği görülür.


Basarisiz Kullanici Adi Login Senaryosu
----------------
Scenario: Kullanıcı başarılı login olur.
  * Kullanici giris ekranina gider ve Login sayfasinin açıldıgı görülür
  * Kullanıcı e-posta olarak "kerem.metinn" ve şifre olarak "E2Kerem01." girer.
  * Kullanıcı giriş butonuna tıklar
  * Başarısız login sonrası hata mesajının geldiği görülür.


Hesap Ismi Guncelleme Senaryosu
----------------
Scenario: Hesap İsimlerini Geçerli Veriler ile Düzenleme
  * Başarılı Login Olunur.
  * Kullanici giris ekranina gider ve Hesap sayfasının açıldığını görür.
  * Kullanıcı hesap ismi olarak "AliVeli" girer.


Sayisal Karakterlerle Hesap Ismi Guncelleme Senaryosu
----------------
Scenario: Hesap İsimlerini Sayısal Veriler ile Düzenleme
  * Başarılı login sonrası Open Money butonun geldiği görülür.
  * Open Money butonuna tıklanır.
  * Kullanici giris ekranina gider ve Hesap sayfasının açıldığını görür.
  * Geçersiz Kullanıcı hesap ismi olarak "1234" girer.


Gecersiz Karakterlerle Hesap Ismi Guncelleme Senaryosu
----------------
Scenario: Hesap İsimlerini Geçersiz Karater Veriler ile Düzenleme
  * Başarılı login sonrası Open Money butonun geldiği görülür.
  * Open Money butonuna tıklanır.
  * Kullanici giris ekranina gider ve Hesap sayfasının açıldığını görür.
  * Geçersiz karaterlerle Kullanıcı hesap ismi olarak "////" girer.


Hesaplar Arası Başarılı Para Transferi
---------------------------
  * Başarılı login sonrası Open Money butonun geldiği görülür.
  * Open Money butonuna tıklanır.
  * Kullanici giris ekranina gider ve Hesap sayfasının açıldığını görür.
  * Kullanıcı hesap ismi olarak "Kerem" girer.
  * Kullanıcı Hesap sayfasının açıldığı görülür.
  * "1000" Tl tutarı girilerek para transferi yapılır.


Hesaplar Arası Eksi Tutarla Para Transferi
---------------------------
  * Başarılı login sonrası Open Money butonun geldiği görülür.
  * Open Money butonuna tıklanır.
  * Kullanici giris ekranina gider ve Hesap sayfasının açıldığını görür.
  * Kullanıcı Hesap sayfasının açıldığı görülür.
  * Kullanıcı Hesap sayfasında başka bir kullanıcı seçilir.
  * "1000" Tl tutarı girilerek para transferi yapılır.


Kredi Kartıyla Başarılı Para Yatırma
------------------------------------------
  * Başarılı login sonrası Open Money butonun geldiği görülür.
  * Open Money butonuna tıklanır.
  * Kullanici giris ekranina gider ve Hesap sayfasının açıldığını görür.
  * Para Ekleme Kısmından "1500" tutarında ekleme yapılır.