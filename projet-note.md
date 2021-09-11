# Rendu du Mini Projet "CV Search"

**Votre travail devra être rendu sous forme d’un projet déposé sur la Forge Lyon 1, au plus tard le dimanche 7 novembre 2021 à 23h59.**

Le mini-projet noté est le fil rouge de tous les TPs. Vous commencez à
travailler sur la base de code au [lab1](TP1-java/), et vous ajoutez
des fonctionnalités tout en améliorant la qualité du code dans la
suite.

Les consignes ci-dessous sont à respecter **impérativement** pour le rendu.

## Rapport

Votre rendu inclura un rapport, au format PDF, qui doit comprendre
obligatoirement :

- une présentation globale du projet (rapide : ne répétez pas
  l'énoncé),

- Une section « design patterns », donnant une motivation des choix
  d’architecture (et des patterns choisis), et leur explication en s’aidant de
  diagrammes appropriés et adaptés au degré de précision et au type
  d’explication. Donc des diagrammes de classe, mais pas que cela, et pas de
  plats de spaghettis générés automatiquement représentant tout le code.
  
* Une section « éthique » où vous expliquerez les choix que vous avez
  fait en termes de stratégie de sélection de CV : comment vous
  assurez-vous que vous choisissez les bons CV, et que vous ne ratez
  pas de candidat intéressant (en particulier, pourrait-on accuser
  votre algorithme de discrimination ?) ? L'algorithme peut-il être
  mis en défaut dans des cas où un humain aurait fait un meilleur
  travail ? Si oui, donnez des exemples et justifiez.
  
  Idéalement, appuyez vos réflexions et affirmations sur des cas
  concrets en citant vos sources. L'outil de sélection de CV que nous
  avons écrit est un jouet, mais les outils de gestion de CV assistés
  par ordinateurs sont une réalité, en particulier dans les grandes
  entreprises et les cabinets de recrutement (pensez à Google qui
  reçoit 75000 CV par semaine ...). L'exercice n'est donc pas si
  artificiel qu'il en a l'air.
  
* Une section « tests » où vous décrirez les tests manuels que vous
  avez réalisés.

## Qualité du code

### Style

Assurez-vous que votre programme respecte toujours le style imposé
(`mvn test`, qui doit lancer checkstyle).

Bien sûr, respecter le style doit se faire en corrigeant (si besoin)
votre code, mais *pas* en modifiant le fichier de configuration de
checkstyle.

### Design-pattern

Assurez-vous d'avoir appliqué toutes les consignes du
[lab3](TP3-patterns/).

### Tests et intégration continue

Vérifiez que l'intégration continue mise en place au
[lab2](TP2-outils/) fonctionne toujours.

Les tests automatisés tels que décrits au [lab5](TP4-tests/) doivent
être lancés automatiquement par `mvn tests`, et doivent tous passer
avec succès.

### Portabilité

Clonez, compilez et exécutez votre code **sur une machine vierge**
(c'est-à-dire sur laquelle vous n'avez installé aucune dépendance, ni
configuré le compte utilisateur de façon particulière). Une grande
partie du barème est liée à l'exécution de votre travail. Il est
important que nous arrivions à l'exécuter **directement**. "Ça marche
chez moi" n'est pas une excuse et une démo *a posteriori* ne permet
pas de remonter une note de TP.

## Projet Forge et TOMUSS

Les projets seront rendus en binômes. La date limite est indiquée sur
la page d'accueil du cours.

**Ajoutez les utilisateurs @matthieu.moy, @LIONEL.MEDINI,
@paul.iannetta, @EMMANUEL.COQUERY, @vac_lucien.ndjie, @vac_nicolas.levy avec le niveau de privilège
"reporter" (ou plus, mais *pas* "guest") à votre projet sur la forge**

Dans la feuille TOMUSS M1 Informatique, indiquez l'URL de votre projet dans la case URL_Projet_MIF01 (l'URL doit ressembler à
`https://forge.univ-lyon1.fr/<login>/mif01-2021`). Il faut impérativement
**que la commande `git clone <url>` fonctionne, et que cette commande récupère la dernière version de votre projet.**
Autrement dit la branche par défaut doit contenir la dernière version du projet si vous avez
plusieurs branches. Tous les membres du binôme doivent entrer **exactement** la même URL (au caractère près).

Pensez à remplir dès à présent TOMUSS indiquant votre URL.
Le dépôt ne sera relevé qu’après la date de rendu.

Votre dépôt sur la Forge devra contenir :

- un répertoire `cv-search/` (le répertoire doit impérativement avoir exactement ce nom)
- un fichier maven (`cv-search/pom.xml`) pour le build du projet
- les sources (fichiers Java)
- les fichiers natifs de votre modélisation UML (indiquez quel outil a été utilisé)
- le rapport en PDF (6 pages maximum, format libre. La limitation de pages est indicative, si vous avez vraiment besoin de plus vous pouvez dépasser un peu mais restez raisonnables et concis), dans un fichier qui doit impérativement s'appeler `rapport.pdf` à la racine du dépôt Git.

## Barème indicatif (le barème sera ramené à 20), à utiliser comme checklist pour vérifier que vous avez tout fait

- Réalisation et exécution :
  - En cas de non-respect des consignes, malus sur la note pour chaque consigne non-respectée :
    - `git clone` qui ne fonctionne pas pour les correcteurs (mauvaise URL dans TOMUSS, mauvais droits sur la forge)
    - Projet public (et non privé) sur la forge
    - Non-respect des consignes de rendu via TOMUSS
    - Absence de fichier pom.xml ou .gitlab-ci.yml
    - Retard : -2 points par jour de retard (arrondi supérieur)
    - Mauvais nommage des fichiers (`rapport.pdf` ou répertoire `cv-search`) : -1 par fichier mal nommé.
    - Étudiant en monôme (sauf justification auprès du responsable d'UE avant le 10 septembre) : -1
  - Compilation Maven sans erreur (1 pts)
  - Code qui tourne directement sur l’ordinateur de l’évaluateur (1 pts)
  - Aucun warning checkstyle (2 pts)
  - Qualité et structure globale du code, utilisation de Packages (1 pt)
  - Fichier .gitignore correct (aucun fichier "untracked" après un "mvn test") (1 pts)
  - Au moins une "pull-request" intégrée dans master (1 pt)
  - Au moins une "issue" fermée sur le projet (1 pt)
  - Interface (UI) propre (1 pts)
  - Extensions obligatoires (cf. [TP3-patterns/](TP3-patterns/)) :
    - Stratégies de sélection des candidats « tout >= 50% », « tout >= 60% », « moyenne >= 50% » (1 pt)
    - Au moins une autre stratégie de sélection (1 pt)
    - Prise en compte de l'expérience professionnelle (2 pts)
    - Modification de l'interface (bouton pour supprimer une compétence de la liste) (1 pt)
    - Affichage de la liste avec affichage d'autre chose que le nom du candidat (1 pt)
    - Tri de la liste des candidats (1 pt)
  - Autres extensions (3 pts)
  - Modification de l'interface utilisateur (1 pt)
  - Tests automatiques (3 pts)
  - Intégration continue opérationnelle (gitlab affiche "Commit: passed" sur le dernier commit) (1 pt)
  - Principes GRASP bien appliqués (1 pt)
  - Mise en place du MVC (3pts)
  - Possibilité d'avoir une deuxième vue (activée par défaut, ou en commentaire dans le code) (1 pt)
  - Design-patterns (création, structure, SOLID, ...) (5 pts)
- Rapport et modélisation :
  - Partie « design patterns » (6pts)
  - Partie « éthique » (3pts)
  - Partie « tests » (1pts)
  - Qualité globale des explications (3pts)
  - Les points suivants entraînent des malus (jusqu’à -5 pts)
    - Contenu et forme (voir ci-dessus)
    - Orthographe
