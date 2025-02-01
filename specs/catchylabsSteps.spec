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
  * Open Money butonuna tıklanır.


Basarisiz Şifre Login Senaryosu
----------------
Scenario: Kullanıcı başarılı login olur.
  * Kullanici giris ekranina gider ve Login sayfasinin açıldıgı görülür
  * Kullanıcı e-posta olarak "kerem.metin" ve şifre olarak "E2Kerem01.." girer.
  * Kullanıcı giriş butonuna tıklar
  * Başarısız login sonrası hata mesajının geldiği görülür.


Basarisiz Kullanıcı Adı Login Senaryosu
----------------
Scenario: Kullanıcı başarılı login olur.
  * Kullanici giris ekranina gider ve Login sayfasinin açıldıgı görülür
  * Kullanıcı e-posta olarak "kerem.metinn" ve şifre olarak "E2Kerem01." girer.
  * Kullanıcı giriş butonuna tıklar
  * Başarısız login sonrası hata mesajının geldiği görülür.


Hesap Ismi Güncelleme Senaryosu
----------------
Scenario: Hesap İsimlerini Geçerli Veriler ile Düzenleme
  * Başarılı Login Olunur.
  * Kullanici giris ekranina gider ve Hesap sayfasının açıldığını görür.


