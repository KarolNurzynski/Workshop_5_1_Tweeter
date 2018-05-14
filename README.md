<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

# Egzamin 6 - Spring, Hibernate.

Przed przystąpieniem do rozwiązywania zadań przeczytaj poniższe wskazówki

## Jak zacząć?

1. Stwórz [*fork*](https://guides.github.com/activities/forking/) repozytorium z zadaniami.
2. Utwórz projekt Mavena o nazwie **JEE_Exam_5** ,nazwa bazy danych to **exam5**.
3. Wykonaj poniższe polecenia:
```bash
$ cd ~/folderZprojektami/JEE_Exam_6 // użyj własnej lokalizacji
$ git init
$ git remote add origin https://github.com/CodersLab/WAR_JAVA_JEE_Exam_5.git // użyj własnego forka
$ git fetch
$ git branch master origin/master
$ git checkout master

```
**Zwróć szczególną uwagę na adres repozytorium oraz nazwę folderu.**

4. Rozwiąż zadania i skomituj zmiany do swojego repozytorium. Użyj do tego komend `git add nazwa_pliku`.
Jeżeli chcesz dodać wszystkie zmienione pliki użyj `git add .` 
Pamiętaj że kropka na końcu jest ważna!
Następnie skommituj zmiany komendą `git commit -m "nazwa_commita"`

   **Repozytorium może zawierać jedynie katalog `src`, pliki: `pom.xml`, `.gitignore`, `README.md`**
5. Wypchnij zmiany do swojego repozytorium na GitHubie.  Użyj do tego komendy `git push origin master`
6. Stwórz [*pull request*](https://help.github.com/articles/creating-a-pull-request) do oryginalnego repozytorium, gdy skończysz wszystkie zadania.


#### Pamiętaj, że pull request musi być stworzony, aby wykładowca dostał Twoje odpowiedzi.

* podczas egzaminu **możesz** korzystać z notatek, kodu napisanego wcześniej, internetu i prezentacji,
* zabroniona jest jakakolwiek komunikacja z innymi kursantami oraz osobami na zewnątrz.

**Powodzenia!**

----------------------------------------------------------------------------------------

## Zadania praktyczne
Kod wpisz w odpowiednim pliku, zgodnie z poleceniem zadania.


### Zadanie 1 (2 pkt)

1. Uzupełnij zestaw zależności odpowiedzialnych za Spring MVC.
2. Uzupełnij podstawowy zestaw zależności dla korzystania z Hibernate.
3. Uzupełnij podstawowy zestaw zależności dla korzystania z Spring Data.
4. Dodaj plik konfiguracyjny dla hibernate -  `persistence.xml`.
5. Utwórz plik konfiguracyjny aplikacji oraz niezbędne ziarna.
6. Utwórz kontroler `HomeController` a w nim akcję pod adresem `/home` wyświetlającą z widok z pliku **index.jsp**
, będzie ona zawierać linki do rozwiązań zadań.

### Zadanie 2 (2 pkt)

1. Utwórz następujące encje oraz określ walidacje:

User (nazwa tabeli `tweeter_user`):
- id - klucz główny
- firstName - pole wymagane
- lastName - pole wymagane
- email - walidacja adresu email, pole nie wymagane

Tweet (nazwa tabeli `tweeter_tweet`):
- id - klucz główny
- title - minimalna długość 5 znaków, maksymalna długość 50, pole wymagane
- tweetText - pole wymagane, maksymalna długość 160 znaków
- created (data dodania)

2. Nazwy kolumn mają pozostać domyślne.
3. Połącz te modele relacją jeden do wielu (dwukierunkową).
4. W encji User pole odnoszące się do wielu tweetów nazwij ```tweets```.
5. W encji Tweet analogicznie pole odnoszące się do jednej encji `User` nazwij ```user```.

### Zadanie 3 (4 pkt)

1. Utwórz repozytorium dla enacji `User`.
2. Utwórz repozytorium dla enacji `Tweet`
3. Utwórz metody umożliwiające pobieranie:
- Tweetów dla zadanego id użytkownika. 
Utwórz akcję wywołującą tą metodę, wyświetl tweety w widoku.
 
Akcja ma być dostępna pod adresem `/user/{id}/tweets`. Dodaj link do strony głównej. `id` - ma być parametrem adresu.

- Tweetów o tytule, który zaczyna się od ciągu znaków, np. `Programo` , posortowane od najnowszego względem daty utworzenia.
Ciąg znaków do wyszukiwania ma być określony jako parametr.

Utwórz akcję wywołującą tą metodę, wyświetl tweety w widoku.

Akcja ma być dostępna pod adresem `/user/search-tweets`. Dodaj link do strony głównej.
 

### Zadanie 4 (4 pkt)

1. Utwórz kontrolery dla enacji `User` z mapowaniem `/user`.
2. Utwórz kontrolery dla enacji `Tweet` z mapowaniem `/tweet`'
3. Utwórz akcje oraz formularz umożliwiające dodanie użytkownika, formularz ma być dostępny pod adresem `/user/add`. 
Dodaj link do strony głównej.
4. Utwórz akcje oraz formularz umożliwiające dodanie tweetu, formularz ma być dostępny pod adresem `/tweet/add` (formularz ma posiadać możliwość wybrania użytkownika).
Dodaj link do strony głównej.
4. Utwórz akcję dostępną pod adresem `/user/clear` - usuwającą wszystkich użytkowników oraz przypisane do nich tweety.
Dodaj link do strony głównej.


### Zadanie 5 (4 pkt)

1. Utwórz akcje dostępną pod adresem `/user/all` która wyświetli listę wszystkich dodanych użytkowników. Dodaj link do strony głównej.
2. Dodaj możliwość usuwania użytkowników - link do usunięcia w tabeli html dla każdego użytkownika.
3. Dodaj możliwość edycji użytkowników - link do edycji w tabeli html dla każdego użytkownika.
4. Dodaj możliwość usuwania wszystkich tweetów danego użytkownika.
5. Dodaj link do akcji z zadania 3: `/user/{id}/tweets` - Pokaż tweety.

Przykład interfejsu:

| Imię      | Nazwisko | Email                            | Akcja
| --------- |:--------:|:--------------------------------:| --------------------------------------: |
| Arek      | Józwiak  | arkadiusz.jozwiak@coderslab.pl   | Usuń, Edytuj, Usuń tweety, Pokaż tweety |
| Marek     | Marecki  |     marek.marecki@coderslab.pl   | Usuń, Edytuj, Usuń tweety, Pokaż tweety |


### Zadanie 6 (4 pkt)

1. Utwórz następujące encje oraz określ walidacje:

Tag (nazwa tabeli `tags`):
- id - klucz główny
- active - boolean 
- name - pole wymagane

Post (nazwa tabeli `posts`):
- id - klucz główny
- title - minimalna długość 5 znaków, maksymalna długość 100, pole wymagane
- description - pole wymagane, maksymalna długość 500 znaków
- content - pole tekstowe
- created (data dodania)

2. Nazwy kolumn mają pozostać domyślne.
3. Połącz encje `Post` oraz `Tag` relacją wiele do wielu (dwukierunkową - pamiętaj o odpowiednim określeniu atrybutu `mappedBy`).

4. Utwórz repozytorium dla enacji `Post`, `Tag`.
5. Utwórz metody umożliwiającą pobieranie:
- Wszystkich postów dla zadanego obiektu `Tag`.
- Wszystkich postów dla zadanej nazwy tagu - typ danych `String`.
- Wszystkich postów dla zadanej listy obiektów typu `Tag`.

