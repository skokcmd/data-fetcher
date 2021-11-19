## Test data fetch
- program přijímá jako jediný vstupní parametr cestu k souboru (např. D:\vzorek_dat.xlsx)
- z .xlsx souboru jsou získávána data ze sloupce B, podle jeho indexu
- funkce, která získává tyto data ignoruje všechna decimální čísla
- dochází také k validaci, zda buňka obsahuje pouze čísla (nikoliv znaky) a taky zda jsou tyto čísla kladná

### Testování
Pro integrační testy jsem použil knihovnu JUnit
