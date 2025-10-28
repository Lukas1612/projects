/*
 * Copyright 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.home_screen


import com.explore_gorzow.feature.home_screen.R
import com.google.samples.apps.nowinandroid.core.database.model.sight.SightTypeName
import com.google.samples.apps.nowinandroid.core.model.data.sight.Sight

object InitialData {

    fun buildData(): List<Sight> = listOf(
        Sight(
            id = "1",
            imageResId = R.drawable.katedra,
            name = "Katedra Wniebowzięcia Najświętszej Maryi Panny w Gorzowie Wielkopolskim",
            description = "Katedra pw. Wniebowzięcia Najświętszej Maryi Panny w Gorzowie Wielkopolskim – najstarsza świątynia w mieście, wzniesiona jako miejski kościół parafialny pod koniec XIII w. na planie pseudobazylikowego korpusu trzynawowego z wieżą przy elewacji zachodniej oraz zakrystią w kształcie prostokąta przy elewacji północnej.\n"
                + "Pierwotnie kościół był pod wezwaniem Maryi Panny i Jedenastu Tysięcy Świętych Dziewic. Początkowo patronat nad kościołem sprawowało miasto, od 1299 kapituła kolegiaty w Myśliborzu, a następnie zakon krzyżacki oraz elektorzy brandenburscy. Od 1537 do 1945 roku świątynia była kościołem ewangelickim.\n"
                + "Zgodnie z założeniami tradycji chrześcijańskiej prezbiterium jest zwrócone ku wschodowi, skąd w dniu Sądu ostatecznego przybędzie Chrystus, główne wejście natomiast znajduje się zawsze od zachodu, naprzeciw ołtarza głównego.\n"
                + "Pierwotny kształt korpusu kościoła z końca XIII wieku zmienił się w nieznaczny sposób. W 1489 roku dobudowano prezbiterium, a w 1621 roku nadbudowano wieżę i otrzymała hełm w stylu barokowym[2]. Bardziej znaczące zmiany w strukturze świątyni miały miejsce w jej wnętrzu. Pierwotnie liczba ołtarzy w świątyni wynosiła siedemnaście. Postulaty zwolenników reformacji doprowadziły do likwidacji szesnastu z nich. Z czasów średniowiecznych pozostały zaledwie nieliczne rzeźby. Ponieważ od końca XVI w. kościół był świątynią luterańską, jej wnętrze uległo znacznej transformacji. W latach 1953–1956 ponownie dostosowano go do potrzeb liturgii katolickiej.\n"
                + "Kościół ustanowiono katedrą 12 grudnia 1945 i zaczął pełnić rolę martyrium. Znajdują się tam groby m.in. biskupów Wilhelma Pluty i Teodora Benscha. \n"
                + "W roku 1982 katedra stanowiła centrum wydarzeń Gorzowskiego Sierpnia. \n"
                + "W 1997 wizytę w katedrze złożył Jan Paweł II. Modlił się wówczas przy grobie bpa Wilhelma Pluty. \n"
                + "1 lipca 2017 w wieży katedralnej wybuchł pożar. Tymczasowo ściągnięto iglicę i hełm. W wyniku pożaru na czas remontu świątynia została zamknięta dla wiernych. 1 lutego 2021 bp Tadeusz Lityński przewodniczył w budynku katedry gorzowskiej pierwszej mszy świętej po pożarze.",
            yearOfCreation = "koniec XIII w",
            type = SightTypeName.MONUMENTS,
            latitude = 52.73086227516991,
            longitude = 15.23909736781273
        ),
        Sight(
            id = "2",
            imageResId = R.drawable.pajak,
            name = "Dominanta (wieża widokowa)",
            description = "Dominanta, także Info Glob (zapis stylistyczny: infoGLOB) – wieża widokowa wraz z mini pasażem handlowym w Gorzowie Wielkopolskim, znajdująca się na rondzie Świętego Jerzego.\n"
                + "Wieża Dominanta składa się z ażurowej kuli (postawiona 16 lipca 2007 roku) otoczonej tarasem widokowym (który został oddany dla turystów w połowie lipca 2007 roku), szklanego walca ze spiralnymi schodami prowadzącymi z podziemnego holu na taras oraz osiemnastu giętych podpór. Ściany pokryte są nazwami różnych miast ze wskazaniem ich odległości od Dominanty oraz nazwami miast partnerskich współpracujących z Gorzowem Wielkopolskim[1]. Ma wysokość 20 metrów[2]. Na budynku zainstalowana została trzymetrowa elektroniczna tablica wyświetlająca wiadomości z Gorzowa Wielkopolskiego, temperaturę, zapowiedzi imprez masowych itd. Do wieży prowadzą dwa zejścia podziemne: od ulicy Przemysłowej i Grobla.\n"
                + "Konstrukcja została przystosowana do roli galerii handlowej, na którą jest przeznaczone 10 pomieszczeń. Na środku holu zamontowano kulistą fontannę ustawioną na mozaice przedstawiającej różę wiatrów.\n"
                + "W pobliżu Info Globu znajduje się centrum handlowe NoVa Park.",
            yearOfCreation = "16 lipca 2007",
            type = SightTypeName.POST_WAR_ARCHITECTURE,
            latitude = 52.7283637320949,
            longitude = 15.241152938976184,
        ),
        Sight(
            id = "3",
            imageResId = R.drawable.fontanna_pauckscha,
            name = "Fontanna Pauckscha",
            description = "W 1896 roku gorzowski przedsiębiorca Hermann Paucksch (właściciel firmy: Maschinenbauanstalt und Dampfkesselfabrik H. Paucksch AG) ufundował nazwaną jego imieniem fontannę uruchomioną w 1897 roku. Rzeźbiarz Cuno von Uechtritz-Steinkirch stworzył w basenie smukły kamienny słup, na którym umieścił brązową figurę silnej kobiety. Nosiwoda, zwana potocznie Bamberką, niesie na ramionach koromysło, na którego łańcuchach zawieszone są wiadra. Postać symbolizuje pracowitość gorzowian i życiodajność Warty. U stóp kobiety siedzą trzy figury dzieci, które symbolizują ówczesne podstawy gospodarki miasta. Chłopiec z młotem i kołem zębatym symbolizuje przemysł, dziewczynka z wędką rybołówstwo, a dziewczynka z siecią i statkiem, płynącym w zbiorniku u stóp głównej figury żeglugę.\n"
                + "Fontanna znajduje się na Starym Rynku obok Katedry Wniebowzięcia Najświętszej Marii Panny. Obecna rzeźba jest wierną rekonstrukcją oryginału, który pod koniec II wojny światowej został zdemontowany i przetopiony na cele wojenne przez Niemców.\n"
                + "W drugiej połowie lat 70. XX wieku na fontannie umieszczono „Prządki” – rzeźbę autorstwa gorzowskiej artystki Zofii Bilińskiej.\n"
                + "W latach 90. XX wieku Bilińska przygotowała wierną kopię przedwojennego oryginału trzech figur umieszczonych na fontannie. Zrekonstruowane przez rzeźbiarkę sylwetki zaakceptowała specjalna komisja składająca się z byłych niemieckich mieszkańców Landsberga, rzeczoznawców Ministerstwa Kultury i Dziedzictwa Narodowego oraz przedstawicieli władz Gorzowa Wielkopolskiego.\n"
                + "2 lipca 1997 roku na 740-lecie Gorzowa Wielkopolskiego w obecności Eberharda i Wolfharta Paukschów, wnuka i prawnuk fundatora fontanny, dokonano uroczystego odsłonięcia rzeźb.\n"
                + "W lipcu 2007 roku Gorzów Wielkopolski świętował 750-lecie istnienia miasta. Z tej okazji Poczta Polska wydała okolicznościowy znaczek pocztowy ukazujący fontannę.",
            yearOfCreation = "20 czerwca 1897",
            type = SightTypeName.MONUMENTS,
            latitude = 52.73123732876235,
            longitude = 15.240512411994871
        ),
        Sight(
            id = "4",
            imageResId = R.drawable.janusz,
            name = "Janusz Gorzowski",
            description = "Na gorzowskim bulwarze od 2015 roku króluje wyjątkowy mieszkaniec – Janusz, czyli Mistrz Plażingu Bulwarowego. To nie jest zwykły pomnik – to hiperrealistyczna rzeźba mężczyzny w klapkach, z gazetą, w czapeczce i z wąsikiem, która doskonale oddaje ducha wakacyjnego luzu. \n"
                + "Autorkami Janusza są Ewa Kozubal i Ewa Bone, absolwentki poznańskiej ASP, które stworzyły rzeźbę na wzór ojca jednej z nich – pana Bogdana. Dzięki temu realizm postaci jest tak duży, że wielu spacerowiczów myli ją z prawdziwym człowiekiem.\n"
                + "Choć początkowo Janusz budził kontrowersje, dziś jest jednym z symboli Gorzowa. Turyści chętnie robią sobie z nim zdjęcia, a w mediach społecznościowych działa jego profil „Janusz Gorzowski – Mistrz Plażingu Bulwarowego”, na którym komentuje bieżące wydarzenia i żartuje z życia miasta.\n"
                + "Dla mieszkańców to już nie tylko rzeźba, ale swojski symbol luzu i dystansu, pokazujący, że sztuka może bawić i jednoczyć. Jak mówią gorzowianie – każdy ma w sobie trochę Janusza.",
            yearOfCreation = "2015r",
            type = SightTypeName.MEMORIALS,
            latitude = 52.730468100658726,
            longitude = 15.242939138976244
        ),
        Sight(
            id = "5",
            imageResId = R.drawable.mury,
            name = "Mury Obronne",
            description = "Budowę murowanych murów obronnych rozpoczęto prawdopodobnie w latach 20. XIV wieku. Wcześniej miasto otaczały drewniano-ziemne umocnienia, o których wspomina dokument z 1257 roku. Wynika z niego, że Gorzów miał wtedy palisadę i bramy wjazdowe. Przebudowa fortyfikacji na murowane trwała wiele lat. \n"
                + "Nowe mury wzniesiono z kamieni polnych, a ich górne części wykonano z cegły. Po północnej stronie, między bramami Młyńską i Santocką, zbudowano 21 baszt obronnych. Były to tzw. baszty łupinowe – wysunięte na zewnątrz murów i otwarte od strony miasta. \n"
                + "Południowa część obwarowań, znajdująca się przy rzece Warcie, nie miała baszt. Chronił ją pojedynczy mur, a dodatkową ochronę zapewniała sama rzeka. W południowo-wschodniej części miasta stał zamek krzyżacki z własnymi umocnieniami."
                + "W górnych częściach murów znajdowały się otwory strzelnicze, a obrońcy poruszali się po drewnianym ganku. Wzdłuż murów od strony miasta biegła wąska uliczka, która ułatwiała dostęp do obwarowań. Z zewnątrz natomiast miasto chroniły rzeka, stawy, strumienie oraz fosa. Do Gorzowa można było wjechać trzema bramami: Santocką od wschodu, Młyńską od zachodu i Mostową od południa.",
            yearOfCreation = "lata 20. XIV w.",
            type = SightTypeName.MONUMENTS,
            latitude = 52.732807461335184,
            longitude = 15.239270756097694,
        ),
        Sight(
            id = "6",
            imageResId = R.drawable.okraglak, // Replace with actual drawable
            name = "Okraglak",
            description = "Przez wiele lat popularny „Okrąglak” w Gorzowie był tętniącym życiem miejscem. Dziś jednak budynek stoi pusty – po wielu latach wyprowadził się z niego bank Credit Agricole.\n"
                + "Okrąglak, położony u zbiegu ulic Pocztowej i Sikorskiego, to bez wątpienia jeden z najbardziej rozpoznawalnych obiektów w mieście. Powstał na początku lat 60., a otwarto go w 1963 roku. Początkowo działał tu bar Express trzeciej kategorii, choć mieszkańcy od zawsze mówili na niego po prostu „Okrąglak”.\n"
                + "Z czasem miejsce zyskało status kultowego – przez lata funkcjonowała tu kawiarnia znana z kolorowych galaretek i słynnych deserów. To właśnie tu wielu gorzowian po raz pierwszy spróbowało lodów cassate.\n"
                + "W ostatnich kilkunastu latach w budynku mieściła się siedziba banku Credit Agricole. Kilka dni temu bank zakończył działalność w tym miejscu, a 17 grudnia wieczorem trwały jeszcze prace związane z jego wyprowadzką.\n"
                + "Co stanie się teraz z Okrąglakiem? Na razie nie wiadomo. Pracownicy, którzy zajmowali się opróżnianiem budynku, nie mieli żadnych informacji na ten temat. Urzędnicy miejscy również nie potwierdzili, by zgłoszono nowe przeznaczenie obiektu. Wiadomo jedynie, że Okrąglak jest własnością prywatną.",
            yearOfCreation = "początek lat 60",
            type = SightTypeName.POST_WAR_ARCHITECTURE,
            latitude = 52.73064472399646,
            longitude = 15.23594998130346
        ),
        Sight(
            id = "7",
            imageResId = R.drawable.plac_grunwaldzki, // Replace with actual drawable
            name = "Plac Grunwaldzki",
            description = "Plac na Nowym Mieście, otoczony ulicami Mieszka I, Juliusza Słowackiego, Jarosława Dąbrowskiego i Kazimierza Jagiellończyka, to dziś miejsce, gdzie znajdują się Pomnik Niepodległości, Dzwon Pokoju oraz Kapsuła Czasu.\n"
                + "Pierwotnie teren ten stanowiły łąki należące do majątku Schönhof, na których odbywały się zabawy ludowe. W 1890 roku wytyczono tu plac przeznaczony do ćwiczeń artylerzystów z pobliskich koszar wojskowych. W tamtym czasie nazywano go Musterplatz, a od 1935 roku — Platz der SA, od nazwy oddziałów szturmowych NSDAP. Odbywały się tu wówczas parady wojskowe i wiece nazistowskie.\n"
                + "Po zakończeniu II wojny światowej, od 1945 roku, plac nosi nazwę Plac Grunwaldzki. W powojennym Gorzowie był on miejscem licznych wieców i uroczystości wojskowych. W latach 60. pełnił funkcję targowiska, a później służył jako teren giełdy samochodowej.\n"
                + "W latach 1973–1975 plac został przebudowany. W lipcu 1975 roku odsłonięto tu Pomnik Braterstwa Broni (obecnie Pomnik Niepodległości), autorstwa zielonogórskiego rzeźbiarza Leszka Krzyszowskiego. W tym samym czasie wzniesiono również budynek szaletu miejskiego, który jednak nigdy nie został uruchomiony.\n"
                + "Kolejna modernizacja miała miejsce w latach 2006–2007. Wówczas obok pomnika zbudowano dzwonnicę z Dzwonem Pokoju, usunięto nieczynny szalet i uruchomiono fontannę. W 2007 roku, z okazji 750-lecia miasta, w plac wmurowano Kapsułę Czasu, którą planuje się otworzyć po stu latach.\n"
                + "Plac Grunwaldzki otacza aleja platanów uznanych za pomniki przyrody.",
            yearOfCreation = "1890",
            type = SightTypeName.PARKS_AND_PLACES,
            latitude = 52.73944214699128,
            longitude = 15.233390651881002
        ),
        Sight(
            id = "8",
            imageResId = R.drawable.poczta, // Replace with actual drawable
            name = "Stara poczta",
            description = "Jednym z najbardziej rozpoznawalnych budynków w Gorzowie Wielkopolskim jest dawna siedziba poczty przy ul. Pocztowej. Wzniesiona w 1890 roku jako Cesarski Urząd Pocztowy, wyróżnia się czerwoną cegłą i bogatymi detalami architektonicznymi nawiązującymi do gotyku, baroku i klasycyzmu. Co ciekawe, obiekt przetrwał II wojnę światową bez zniszczeń, dzięki czemu do dziś zachował swój historyczny charakter.\n"
                + "Przez dziesięciolecia mieściła się tu główna siedziba Poczty Polskiej w mieście – to właśnie stąd wysyłano telegramy, listy i zamawiano rozmowy telefoniczne. Choć współcześnie korzystamy z nowoczesnych form komunikacji, w zabytkowych murach wciąż działa urząd pocztowy.\n"
                + "Budynek, należący obecnie do firmy Orange, został wystawiony na sprzedaż. Niezależnie jednak od przyszłego właściciela, działalność poczty pozostanie w tym miejscu – zgodnie z obowiązującą umową.",
            yearOfCreation = "1890 ",
            type = SightTypeName.MONUMENTS,
            latitude = 52.73080450574992,
            longitude = 15.23546056794348
        ),
        Sight(
            id = "9",
            imageResId = R.drawable.pomnik_2_armii_wojska_polskiego, // Replace with actual drawable
            name = "POMNIK 2. ARMII WOJSKA POLSKIEGO",
            description = "Monument autorstwa gorzowskiego rzeźbiarza Jerzego Koczewskiego został ustawiony w 1978 roku na placu Nieznanego Żołnierza, z okazji 35. rocznicy powstania Ludowego Wojska Polskiego.\n"
                + "Rzeźba wykonana z białego sztucznego kamienia przedstawia dwie dłonie uniesione ku górze, które podtrzymują piastowskiego orła – symbol siły i wolności. Na bocznej ścianie pomnika umieszczono napis:\n \"Żołnierzom 5. Dywizji Piechoty II Armii Wojska Polskiego z okazji 35. rocznicy LWP – społeczeństwo Gorzowa\" \n"
                + "Podczas remontu placu w 2008 roku oraz jego przebudowy w 2017 roku pojawiały się propozycje przeniesienia pomnika w inne miejsce. Pomysł ten jednak spotkał się ze sprzeciwem mieszkańców, którzy uznali monument za ważny element miejskiego krajobrazu.",
            yearOfCreation = "1978",
            type = SightTypeName.MEMORIALS,
            latitude = 52.73560289655179,
            longitude = 15.235268358739802
        ),

        Sight(
            id = "10",
            imageResId = R.drawable.spichlerz, // Replace with actual drawable
            name = "Spichlerz",
            description = "Spichlerz, należący obecnie do Muzeum Lubuskiego im. Jana Dekerta, to jeden z najcenniejszych zabytków Gorzowa Wielkopolskiego. Ten XVIII-wieczny szachulcowy magazyn zbożowy stoi na lewym brzegu Warty.\n"
                + "Dokładna data jego budowy nie jest znana, powstał jednak po 1763 roku na miejscu reduty, która broniła przeprawy mostowej. W XIX wieku pełnił funkcję magazynu wojskowego, a po I wojnie światowej przystosowano go do celów handlowych, podobnie jak znajdujący się w centrum miasta Arsenał.\n"
                + "Po wojnie spichlerz wykorzystywany był jako magazyn GS Samopomoc Chłopska. W 1980 roku przeszedł gruntowny remont i przeszedł na własność muzeum. Uroczyste otwarcie po modernizacji nastąpiło w 1989 roku, a kolejna renowacja miała miejsce w latach 2010–2011.",
            yearOfCreation = "XVIII w",
            type = SightTypeName.MONUMENTS,
            latitude = 52.72801491203236,
            longitude = 15.240166554321807
        ),

        Sight(
            id = "11",
            imageResId = R.drawable.studnia, // Replace with actual drawable
            name = "Studnia Czarownic",
            description = "W 1924 roku na dziedzińcu nowego Ratusza Miejskiego przy dzisiejszej ul. Obotryckiej ustawiono symboliczną Studnię Czarownic z figurką kobiety na miotle. Miała ona upamiętnić tragiczne wydarzenia sprzed wieków – spalenia mieszkanek miasta, oskarżonych o czary, które odbywały się na tzw. Górze Szubienicznej (dziś wzgórze nad ul. Asnyka).\n" +
                "Czarownice wierzono, że potrafią psuć piwo, kontrolować pogodę, niszczyć plony, a także sprawiać, że krowy przestawały dawać mleko, a konie i bydło ginęły. W latach 1525–1708 w dawnym Landsbergu (dzisiejszym Gorzowie) co najmniej 19 kobiet zostało oskarżonych o czary. Pięć z nich spalono na stosie, jedna zmarła w więzieniu, kilka innych uniewinniono lub skazano na wygnanie, a w przypadku pięciu wyrok pozostaje nieznany. Plotki i pomówienia wystarczały, by kobiety zostały oskarżone, a po torturach przyznawały się do winy.\n" +
                "O czarownicach z dawnego Gorzowa krążą też legendy. Jedna z nich opowiada o żonie aptekarza oskarżonej w 1564 roku, która wskazała na trzy sąsiadki, które następnie spłonęły na stosie. Inna historia dotyczy trzech sióstr – najstarsza zajmowała się ogrodem, średnia prowadziła dom, a najmłodsza szyła. Spotykały się przy studni, ciesząc się wspólnym zadaniem. Starszy, zgorzkniały kawaler, oczarowany ich urodą, chciał jedną z nich za żonę. Kiedy odrzuciły jego propozycję, rozpuścił plotkę, że władają czarną magią. Oskarżone siostry zostały spalone na stosie, a ich matka popełniła samobójstwo, rzucając się do studni – tak narodziła się legenda Studni Czarownic.\n"
                + "W 1997 roku, na Wełnianym Rynku, ustawiono zrekonstruowaną studnię (prawdopodobnie oryginał z 1924 roku został zniszczony w 1945 roku). Według miejskiej legendy, wrzucając do niej monetę, można zobaczyć trzy twarze niezwykle pięknych kobiet.",
            yearOfCreation = "1997",
            type = SightTypeName.MEMORIALS,
            latitude = 52.732246862458275,
            longitude = 15.239475873315016
        )
        )

}