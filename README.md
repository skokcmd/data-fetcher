## Vypracované zadání
K vypracování zadání jsem použil Javu 16, společně s knihovnou Apache POI, kterou jsem uvedl jako maven dependency. Celé zadání i s testy mi zabralo cca 3-4h.
- program přijímá jako jediný vstupní parametr cestu k souboru (např. D:\vzorek_dat.xlsx)
- z .xlsx souboru jsou získávána data ze sloupce B, podle jeho indexu
- funkce, která získává tyto data ignoruje všechna decimální čísla, která nemají hodnotu za desetinou čárkou 0 (např. 7.0)
- dochází také k validaci, zda buňka obsahuje pouze čísla a taky zda jsou tyto čísla kladná

### Testování
Pro integrační testy jsem použil knihovnu JUnit
