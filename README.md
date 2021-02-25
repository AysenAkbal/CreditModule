# CreditModule
Spring Boot - PostgreSQL - Restful
Loan Module for Turkcell. A new demo for Turkcell's corporate application portfolio Loan Module is requested.

Müşteri veri modeli
 Tckimlikno, ad/soyad, MSISDN (10 haneli gsmNo), adres, doğum tarihi, müşteri tipi
(postpaid/prepaid), abonelik tarihi, kredi bilgisi (tarih, tutar), kredi limiti (sistem parametresinde
tutulabilir-ayrı bir tablo düşünülebilir)
Müşteri Turkcell abonesi değilse &gt; yeni tesis + kredi giriş ilemi yapılır (tckimlik üzerinden mevcut
müşteri kontrolü yapılabilir)
Müşteri Turkcell abonesi ise &gt; kredi limitleri kontrol edilir, uygunsa kredi girişi yapılır
 Yeni tesis için, müşteri kimlik bilgileri ve kimlik belgesi örneğinin(pdf, jpeg) sisteme girilmesi
gerekir 
 Kredi girişi için, kredi evrağı örneğinin(pdf,jpeg) sisteme girilmesi gerekir 
Kredi limitleri müşteri bazında belli kriterlerle yönetilir
 Tek seferde alınabilecek max X TL (müşterilerin Turkcell’deki fatura ödeme sadakati, abonelik yılı
baz alınarak limitler belirlenir)
 Ayda max 1 kredi
 Bir yılda toplam tutar max Y TL
 Müşteri kara listede olmamalı (kredi borcunu geciktiren, ödemeyen müşteriler kara listeye alınır,
bu liste önceden örnek olarak girilebilir.)
 Daha önce bir yasal takibe maruz kalmamış olmalı
Onay mekanizması:
 Girilen krediler yetkili onayına düşer, kredi tutarına göre bir üst yetkili onayına da düşebilir.
 Onay ekranında girilen dökümanlar ekranda gösterilmeli 
 Onaylanması durumunda işlem devam eder
 Red durumunda gerekçe ile müşteriye bilgilendirme yapılır
