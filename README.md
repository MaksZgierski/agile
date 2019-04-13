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

Pobranie wszystkich miejsc:
curl -X GET https://maks-zgierski.pl:6443/agile/places \
  -H 'cache-control: no-cache' \
  -H 'charset: utf-8' \
  -H 'content-type: application/json' \
  -H 'postman-token: 34e8d2cf-8fb9-473b-fdce-87288c0aa3c6' \
  -H 'token: aTrmXAw0AR2z0QC9BECJJ7p1xKOvF7prcV2YCSu5Ha1zdMYCEG' \
  -d '{
	"login":"test",
	"password":"password"
}'

Pobranie szczegółów miejsca:
curl -X GET https://maks-zgierski.pl:6443/agile/place_details/1 \
  -H 'cache-control: no-cache' \
  -H 'charset: utf-8' \
  -H 'content-type: application/json' \
  -H 'postman-token: 2a8b9e30-ae36-0e31-d7ec-cff817fb7e27' \
  -H 'token: aTrmXAw0AR2z0QC9BECJJ7p1xKOvF7prcV2YCSu5Ha1zdMYCEG' \
  -d '{
	"login":"test",
	"password":"password"
}'

https://maks-zgierski.pl:6443/agile/place_details/{place_id}


Dodanie nowego miejsca:
curl -X POST https://maks-zgierski.pl:6443/agile/places \
  -H 'cache-control: no-cache' \
  -H 'charset: utf-8' \
  -H 'content-type: application/json' \
  -H 'postman-token: 05f47553-2516-26a4-057e-a139d83b9e62' \
  -H 'token: h3kmnbyUgtdw8dRCnLGPK320KQybwBz3UiwiULikW1pZjQk90x' \
  -d '{
	"name":"New place",
	"placeType":1,
	"lat": 50.123,
	"lng": 50.456,
	"address":"address",
	"description":"desc",
	"conveniences":[1]
}'

Usunięcie miejsca (pod warunkiem, że jesteśmy właścicielem, czyli miejsce zostało dodane przez nas):
curl -X DELETE https://maks-zgierski.pl:6443/agile/places/3 \
  -H 'cache-control: no-cache' \
  -H 'charset: utf-8' \
  -H 'content-type: application/json' \
  -H 'postman-token: f8cfa3c7-51cc-b7e3-9229-23ab31fd2117' \
  -H 'token: h3kmnbyUgtdw8dRCnLGPK320KQybwBz3UiwiULikW1pZjQk90x'
  
https://maks-zgierski.pl:6443/agile/places/{place_id}


Dodanie komentarza do miejsca:
curl -X POST https://maks-zgierski.pl:6443/agile/opinion \
  -H 'cache-control: no-cache' \
  -H 'charset: utf-8' \
  -H 'content-type: application/json' \
  -H 'postman-token: a77e65c4-f676-7044-2dbb-802d20b247d6' \
  -H 'token: h3kmnbyUgtdw8dRCnLGPK320KQybwBz3UiwiULikW1pZjQk90x' \
  -d '{
	"placeId":1,
	"rating":5,
	"comment":"comment"
}'
