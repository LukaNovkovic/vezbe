INSERT INTO adresa (id, ulica, broj) VALUES (1,'Bulevar Cara Lazara', 5);
INSERT INTO adresa (id, ulica, broj) VALUES (2, 'Dalmatinska', 7);

INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga, adresa_id)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN',1);
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga, adresa_id)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK',2);
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga, adresa_id)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK',2);

INSERT INTO odeljenje (id, bonus, ime) VALUES (1, 3, 'odeljenje1');
INSERT INTO odeljenje (id, bonus, ime) VALUES (2, 4, 'odeljenje2');
INSERT INTO odeljenje (id, bonus, ime) VALUES (3, 5, 'odeljenje3');

INSERT INTO radnik (id, jmbg, ime_prezime, email, godina_staza, slobodnih_dana, odeljenje_id) VALUES (1, '1234567891234', 'Mile', 'mile@mail.net', 11, 13, 1);
INSERT INTO radnik (id, jmbg, ime_prezime, email, godina_staza, slobodnih_dana, odeljenje_id) VALUES (2, '1234567891235', 'Zika', 'zika@mail.net', 12, 6, 1);
INSERT INTO radnik (id, jmbg, ime_prezime, email, godina_staza, slobodnih_dana, odeljenje_id) VALUES (3, '1234567891236', 'Pera', 'pera@mail.net', 13, 26, 2);
INSERT INTO radnik (id, jmbg, ime_prezime, email, godina_staza, slobodnih_dana, odeljenje_id) VALUES (4, '1234567891237', 'Mita', 'mita@mail.net', 15, 27, 2);
INSERT INTO radnik (id, jmbg, ime_prezime, email, godina_staza, slobodnih_dana, odeljenje_id) VALUES (5, '1234567891238', 'Sava', 'sava@mail.net', 15, 13, 3);

INSERT INTO odsustvo (id, datum_pocetka, radnih_dana, radnik_id) VALUES (1, '2020-01-10', 5, 1);
INSERT INTO odsustvo (id, datum_pocetka, radnih_dana, radnik_id) VALUES (2, '2020-02-10', 7, 1);
INSERT INTO odsustvo (id, datum_pocetka, radnih_dana, radnik_id) VALUES (3, '2020-03-10', 9, 2);
INSERT INTO odsustvo (id, datum_pocetka, radnih_dana, radnik_id) VALUES (4, '2020-04-10', 10, 2);
INSERT INTO odsustvo (id, datum_pocetka, radnih_dana, radnik_id) VALUES (5, '2020-05-10', 15, 5);