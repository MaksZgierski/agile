# Projekt back-end na Zwinne Metody Zarządzania Projektami
Projekt napisany z wykorzystaniem Spring Boot i PostgreSQL. 
Schemat bazy danych znajduje się w projekcie. 
Encje zostały wygenerowane poprzez JPA.
Po ściągnięciu projektu trzeba podać własne dane dostępu do bazy danych (application.properties)

Niestety, aktualnie mam zainstalowanego Tomcata 7 (dosyć stara wersja), więc należy korzystać z Javy w wersji 7 (lambda i Stream API odpada). Nie powinno to być jakoś bardzo uciążliwe, ponieważ nie będzie raczej żadnej skomplkowanej logiki :)

Na razie tylko taki testowy request jest obsługiwany: https://maks-zgierski.pl:6443/agile/

Rejestracja:
curl -X POST https://maks-zgierski.pl:6443/agile/register_user \
  -H 'cache-control: no-cache' \
  -H 'charset: utf-8' \
  -H 'content-type: application/json' \
  -H 'postman-token: 726d2fe8-eacb-172d-bc81-49e665ac34b9' \
  -d '{
	"login":"test",
	"password":"password",
	"name":"name"
}'

Logowanie:
curl -X POST https://maks-zgierski.pl:6443/agile/login \
  -H 'cache-control: no-cache' \
  -H 'charset: utf-8' \
  -H 'content-type: application/json' \
  -H 'postman-token: 4567d8c1-a880-25d9-f46a-a7c47d34f3cb' \
  -d '{
	"login":"test",
	"password":"password"
}'

Regulamin:
curl -X GET \
  https://maks-zgierski.pl:6443/agile/regulations \
  -H 'cache-control: no-cache' \
  -H 'charset: utf-8' \
  -H 'content-type: application/json' \
  -H 'postman-token: 3ea5a23d-a162-fd93-44bb-22cf2cf15c50'
  
Typy obiektów:
curl -X GET \
  https://maks-zgierski.pl:6443/agile/place_types \
  -H 'cache-control: no-cache' \
  -H 'charset: utf-8' \
  -H 'content-type: application/json' \
  -H 'postman-token: 8100b67f-7c73-ad84-eb85-03cc669e1905' \
  -H 'token: hM24RxQGRs3ftKSts50FYnWTdb13im1rviIctt3lxfBdt1BVYU'
