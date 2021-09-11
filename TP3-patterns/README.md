# TP3 - Design patterns

## Objectifs

Il vous est demandé d’effectuer une ré-ingénierie d’un code existant en mettant en œuvre les patrons de conception vus en cours.

Ceci devrait vous prendre 2 ou 3 séances.

### Déroulement

Ce TP est organisé en deux étapes :

- une ré-ingénierie (refactoring) du code utilisé dans les premiers TP afin de mieux structurer le projet et de le rendre plus modulaire,
- l’extension des fonctionnalités pour réaliser un programme plus complet.

Le plus simple est de partir répertoire `cv-search` fourni dans votre archive. Si vous le souhaitez, vous pouvez aussi repartir d'un répertoire vierge, mais attention à ne rien oublier au passage !

### Ressources

- [Cours (et pointeurs à la fin du cours) sur les Design patterns](https://perso.liris.cnrs.fr/lionel.medini/enseignement/M1IF01/CM-patterns.pdf)
- [Aide à la mise en place du pattern MVC pour ce TP](./mvc.md)

## Consignes

Il est demandé de travailler en binômes.

Penser à remplir dès à présent TOMUSS pour indiquer votre dépôt forge.
*Cf*. instructions dans [../projet-note.md](../projet-note.md).

### Outils

Il est conseillé d'utiliser un IDE capable __a minima__ de générer des diagrammes UML à partir du code, ou mieux, de faire du __round-trip engineering__ (prendre en compte les modifications du code dans les schémas et inversement). C'est le cas avec IntelliJ, et Eclipse avec un plugin comme [Object Aid](https://www.objectaid.com/) (explications rapides en vidéo [ici](https://www.youtube.com/watch?v=0Zlh56mTS6c)).

Il est aussi possible de [générer un diagramme de classe via JavaDoc](http://gochev.blogspot.com/2011/03/generate-javadoc-with-uml-diagrams.html).

### Qualité du code

Le but de ce cours en général est de vous apprendre à écrire du code propre (irréprochable ?). 
On accordera une attention particulière à la qualité du code à tous les niveaux (style, indentation, architecture...). 
Privilégiez la qualité du code à la quantité de fonctionnalités.

## Partie 1 : Ré-ingénierie

Le code fourni lors de la première séance est ensemble de classes
relativement fouillis (nous en avons déjà parlé dans
[architecture-et-dependances.md](../TP1-java/architecture-et-dependances.md)).
En particulier les couches graphique et métier ne sont pas séparées.
Il va vous falloir réorganiser le code en appliquant les patrons de conception adéquats.

### Pattern Modèle-Vue-Contrôleur

Vous allez maintenant redéfinir la structure de base de l’application.
Mettez en place un pattern MVC pour :

- séparer le métier (la logique de l'application) et l’affichage
  des éléments (boutons et champs textes),

- propager les changements du modèle métier (statut des utilisateurs, ...) dans la vue,

- répercuter les entrées utilisateur (clic sur un bouton, validation
  d'un champ texte avec la touche « entrée »...) sous la forme
  adéquate dans le modèle métier.

Pour vous aider, vous pouvez utiliser les slides du cours sur les patterns contrôleur et MVC, ainsi que le document [Mettre en place le pattern MVC](mvc.md). Ce document propose des questions pertinentes à se poser, ainsi que quelques éléments de réponses, mais ce ne sont ni les seules questions ni les seules réponses pertinentes.

**Pour chacun des patterns implémentés à partir de cette partie, vous décrirez (en 1 ou 2 paragraphes) pourquoi vous avez choisi de l'utiliser, et vous fournirez dans votre rapport un/des diagramme(s) UML illustrant comment vous l'avez mis en œuvre.**

#### Flexibilité du modèle MVC

Une des propriétés du MVC est qu'on peut avoir un nombre quelconque de vues, identiques ou non, d'un modèle donné.
On peut vérifier simplement que notre MVC vérifie cette propriété en ajoutant quelque chose comme ceci dans le programme principal :

```java
        // First view, provided in skeleton
        new JfxView(c, stage, 600, 600);

        // Second view
        new JfxView(c, new Stage(), 400, 400);
```

Vous devriez voir une deuxième fenêtre, de taille différente, qui affiche
l'interface graphique. Les deux fenêtres doivent être synchronisées : toutes les
actions importantes faite dans l'une est répercutée immédiatement dans l'autre
(bien sûr, il y a aussi des choses qui restent locales à la vue, par exemple
quand on entre une compétence dans le champ texte, le texte entré n'est propagé
vers le modèle et les autres vues qu'au moment où on valide avec le bouton « add
skill »).

Remarque : si la deuxième fenêtre vous gêne, mettez en commentaire le
morceau de code concerné, mais conservez-le obligatoirement et vérifiez qu'il marche
toujours au moment du rendu.

### Autres patterns

Reprenez les transparents du cours et parcourez la liste des patterns GRASP, des patterns de création, de structure, des principes SOLID, et posez-vous la question de leur applicabilité sur votre projet.
Appliquez ceux qui vous semblent pertinents, et de la même façon que précédemment, documentez cela dans votre rapport (si possible, en suivant la progression du cours : GRASP, création, structure...).

Vous devrez avoir au moins 3 patterns autres que MVC appliqués dans votre projet et décrits dans votre rapport.

### Anticiper sur le TP 5 "test"

Avant d'aller plus loin sur les extensions, c'est une bonne idée de progresser en tests : nous serons plus en sécurité pour continuer le refactoring et les extensions avec une bonne base de tests. 
Allez jeter un œil au [TP "Test"](../TP4-tests/README.md) (en particulier la section sur le TDD), et revenez pour la suite de ce TP après.
À vous de voir dans quel ordre vous voulez avancer précisément.

## Partie 2 : Extension

Dans toute cette partie, l'ajout de fonctionnalité est un prétexte pour se servir de design patterns. Dans la vraie vie, bien sûr, c'est au client ou à l'expert métier de décider des fonctionnalités pertinentes, mais exceptionnellement dans ce projet un peu artificiel on peut s'autoriser à choisir une fonctionnalité parce qu'elle sera intéressante à implémenter.
Ajoutez chaque fonctionnalité en appliquant les principes et patterns vus en cours, et justifiez-la dans le rapport.

### Stratégie de base sélection des CV

Pour rappel, vous devez fournir au moins 3 stratégies de sélection de
CV (cf. [lab1-java/README.md](../lab1-java/README.md)) : « tout >=
50% », « tout >= 60% », « moyenne >= 50% ».

### Autres stratégies de sélection de CV

Ajoutez au moins une autre stratégie qui vous paraît pertinente pour
éliminer les mauvais candidats et ne pas rater les perles rares.
Attention bien sûr à maintenir votre code factorisé au maximum : pas
de duplication de code d'une stratégie à l'autre !

Si vous êtes tentés d'écrire du code de la forme

```java
if (strategie == 1) { // NON
    ...
} else {
    ...
}
```

Relisez votre cours sur les design-patterns, il y a plus propre et extensible ...

### Prise en compte de l'expérience professionnelle

Les exemples de CV fournis contiennent une section « expérience
professionnelle », par exemple :

```
experience:
  Google:
    start: 2005
    end: 2010
    keywords:
      - c
      - c++
      - java
  Facebook:
    start: 2010
    end: 2021
    keywords:
      - Python
      - PHP
```

Qu'il faut lire « le candidat a travaillé de 2005 à 2010 chez Google
où il a pratiqué C, C++ et Java, puis de 2010 à 2021 chez Facebook où
il a pratiqué Python et PHP ». Proposez un ou plusieurs moyens
pertinents de prendre en compte à la fois les compétences déclarées
et l'expérience professionnelle. N'hésitez pas à ajouter des CV à la
base en créant d'autres fichiers `.yaml` dans votre projet.

### Modification de l'interface

L'interface proposée n'est pas très intuitive, par exemple la liste
des compétences est une liste de boutons et il faut cliquer sur un
bouton pour le faire disparaître.

Modifiez l'interface pour que la liste des compétences apparaisse avec
le nom de chaque compétence et un bouton explicite pour la supprimer à
côté, par exemple comme ceci :

![Liste de compétences](img/list-skills.png)

Cette copie d'écran a été obtenue avec le code ci-dessous dont vous
pouvez vous inspirer :

```java
final HBox box = new HBox();
final Label labelContact = new Label(
    i.getKey().getName() + ": " + i.getValue().toString() + " ");
final Button b = new Button("x");
b.setOnMouseClicked(event -> ...);
box.setStyle("-fx-padding: 2;" + "-fx-border-style: solid inside;"
    + "-fx-border-width: 1;" + "-fx-border-insets: 5;"
    + "-fx-border-radius: 5;" + "-fx-border-color: black;");
box.setAlignment(Pos.BASELINE_CENTER);
box.getChildren().addAll(labelContact, b);
```

Cette modification devrait être purement locale à la vue. Si vous avez
dû modifier le modèle ou le contrôleur, revoyez votre MVC !

### Affichage et tri de la liste 

Dans le code fourni, on n'affiche que les noms des candidats. Vous devez déjà
avoir ajouté la note moyenne de chaque candidat. Ajoutez un peu d'information à
la liste, comme un résumé des compétences clé, ou un score obtenu par rapport
aux compétences recherchées. Triez la liste par note moyenne : le premier
candidat sera celui ayant la meilleure note.

### Autre chose ?

Vous n'en avez pas assez ? Vous voulez ajouter un import de CV en
PDF ? Un tri par réseau de neurones ? À vous de jouer ;-) ! (Mais
seulement si toutes les fonctionnalités imposées sont codées de manière
irréprochables)

## Rendu du TP / projet

Voir les consignes **À RESPECTER IMPÉRATIVEMENT** dans
[../projet-note.md](../projet-note.md).
