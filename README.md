#Aplikacja do nauki języka angielskiego
##Opis aplikacji
Jest to prosta aplikacja napisana w języku Java, która ma służyć do nauki języka angielskiego. Użytkownik będzie mógł uczyć się poprzez przez wykonywanie zadań. Aplikacja początkowo będzie skierowana do osób z mało zaawansowanym językiem angielskim, natomiast z czasem będziemy dodawać nowe zadania dla osób z wyższym poziomem języka angielskiego. W przyszłości pojawią się również inne nowe rodzaje zadań.

##Lista funkcjonalności
- Wybór trudności zadań w ustawieniach
- Rozwiązywanie zadań jednokrotnego wyboru
- Możliwość wyświetlenia podpowiedzi to zadania
- Rozwiązywanie testu z zadań, które zostały przez nas błędnie rozwiązane

##Uruchamianie aplikacji
Aplikację można uruchomić włączając plik Aplikacja_Zes3.jar

##Opis zawartości
###W katalogu **src/main/java/main** znajdują się:
- **App.java** Jest to główny plik z aplikacją, w nim jest uruchamiana aplikacja
- **Difficulty.java** W tym pliku znajduje się enum związany z poziomem trudności zadań
- **ExamHandler.java** W tym pliku znajdują się metody związane z logiką testu z błednie rozwiązanych zadań
- **ExamScreenController.java** Jest to kontroler do sceny z testem z błednie rozwiązanymi zadaniami
- **FriendsScreenController.java** Jest to kontroler do sceny zakładki "Znajomi"
- **MainScreenController.java** Jest to kontroler sceny z głównym menu aplikacji
- **QuestionHandler.java** W tym pliku znajdują się metody odpowiedzialne za zarządzanie pytaniami
- **QuestionInfo.java** W tym pliku znajduje się klasa zawierająca informacje o danym pytaniu
- **RankingScreenController.java** Jest to kontroler sceny z rankingiem użytkowników
- **SceneHandler.java** W tym pliku znajdują się metody odpowiedzialne za zarządzanie scenami
- **SceneInfo.java** W tym pliku znajduje się klasa zawierająca informacje o danej scenie
- **SettingsScreenController.java** Jest to kontroler sceny z ustawieniami aplikacji
- **SingleChoiceTaskController.java** Jest to kontroler sceny z zadaniem jednokrotnego wyboru
- **TaskControllerInterface** W tym pliku znajduje się interfejs kontrolera sceny z zadaniem

###W katalogu **src/main/resources/main** znajdują się:
- **pliki .fxml** Są to pliki w których znajdują się sceny aplikacji
- **failedQuestions.txt** W tym pliku są zapisane numery zadań które były źle rozwiązane przez użytkownika. Numery oddzielone ;
- **SingleChoiceQuestions.txt** W tym pliku są zapisane zadania jednokrotnego wyboru. Format zapisu:
numerZadania;poziomTrudności;poprawnaOdpowiedź;treśćZadania;treśćPodpowiedzi;odpowiedź1|odpowiedź2|odpowiedź3|odpowiedź4
- **styles.css** W tym pliku znajdują się wszystkie style wykorzystywane w plikach fxml


##Autorzy
- Marcin Wardak
- Marcin Komza