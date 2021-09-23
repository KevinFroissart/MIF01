Ce fichier contiendra les nouvelles du cours. Un mail sera envoyé quand le fichier est mis à jour.

# 17/09/2021 : Nouvelles du cours

Quelques informations importantes :

* Certains étudiants n'ont pas appliqué la mise à jour de checkstyle.xml du 10/09/2021 (cf. https://forge.univ-lyon1.fr/matthieu.moy/mif01-2021/-/blob/master/NEWS.md#10092021-mise-à-jour-de-checkstylexml-et-quelques-corrections-dans-le-code-java-checkstyle). Il est important que vous le fassiez, car la notation se fera sur les warnings trouvés avec la nouvelle configuration. Si vous avez un doute, récupérez ma version brutalement :

```
git fetch moy
git restore --source moy/master cv-search/src/main/config/checkstyle.xml

```

puis faites un commit pour enregistrer vos changements.

* Les transparents de Sandrine Gouraud sont en ligne : http://matthieu-moy.fr/cours/mif01/SandrineGouraud_16092021.pdf

* J'ai ajouté quelques précisions sur Git et les fichiers générés, car beaucoup d'entre vous avaient fait l'erreur d'ajouter des fichiers générés à Git (là aussi, attention c'est un point pris en compte dans la note) : https://forge.univ-lyon1.fr/matthieu.moy/mif01-2021/-/tree/master/TP2-outils#suppression-éventuelle-des-fichiers-qui-nauraient-jamais-du-être-là

* Il n'y a quasiment aucune question sur le tchat [mif01-2021](https://go.rocket.chat/invite?host=chat-info.univ-lyon1.fr&path=invite%2Fi5Lsmn). Soit le cours est trop facile, soit c'est vous qui faites trop les timides. Posez-vos questions ! Aidez-nous à vous aider !

# 10/09/2021 : Mise à jour de checkstyle.xml et quelques corrections dans le code Java

Le fichier `checkstyle.xml` que je fournissais n'était pas compatible avec la
dernière version du plugin checkstyle pour IntelliJ. J'ai mis à jour le fichier
de configuration, et j'ai du corriger quelques nouvelles erreurs de style dans
le code Java. Il est impératif pour vous de mettre à jour le fichier de
configuration et d'éliminer les éventuels nouveaux warnings : c'est sur la
dernière version de `checkstyle.xml` que vous serez évalué.

Le plus simple est de récupérer ces changements depuis le dépôt Git du cours. Si
vous ne l'avez pas déjà fait :

```
git remote add moy https://forge.univ-lyon1.fr/matthieu.moy/mif01-2021.git
```

Puis :

```
git pull moy master
```

Si vous ne pouvez pas utiliser cette solution, allez récupérer le fichier
`checkstyle.xml` directement dans le dépôt du cours.

# 8/09/2021 (quater) : visio pour le TD1

Certains étudiants ne peuvent pas suivre les cours en présentiel. Pour le TD1, je vous proposerai une visio en co-modal (je serai en salle de TD avec des étudiants). Les infos de connexion de la visio sont sur la page du cours (README.md, dans la section du TD correspondant).

# 8/09/2021 (ter) : Utilisation de chat-info

Je vous rappelle que j'ai créé pour vous deux canaux sur la messagerie instantanée du département :

* [mif01-2021](https://go.rocket.chat/invite?host=chat-info.univ-lyon1.fr&path=invite%2Fi5Lsmn) pour les discussions générales. Posez-y vos questions même en dehors des séances. J'ai vu des gens encore bloqués sur des questions d'installation de Java et de leur IDE ce matin par exemple : vous auriez dû poser la question bien plus tôt, on aurait sans doute pu vous aider ! Je ne répondrai pas aux questions techniques posées par message personnel par contre : utilisez le canal commun pour que tout le monde en profite. 

* [mif01-2021-cherche-binome](https://go.rocket.chat/invite?host=chat-info.univ-lyon1.fr&path=invite%2FMkmZTz) si vous cherchez encore un binôme. Si jamais vous n'avez pas accès au tchat, envoyez-moi un mail.

# 8/09/2021 (bis) : Emploi du temps et salles ce vendredi

Ce vendredi (10/9), l'emploi du temps est :

* 9h45 : TD, nous ne respectons pas les groupes de TD (il n'y a que 4 enseignants ...), votre salle est indiquée sur TOMUSS. Si vous n'avez pas d'indication sur TOMUSS, vous pouvez choisir votre salle (cf. [README.md](README.md)). Certains étudiants ne voient pas ce créneau dans ADE, si c'est le cas c'est que vous avez mal sélectionné les groupes, attention pour les prochaines fois.

* 11h30 : TP, comme d'habitude : la salle est indiquée sur la page du cours.

# 8/09/2021 : Quelques coquilles dans l'énoncé

Il restait quelques coquilles dans le barème (restes de l'an dernier). C'est corrigé sur la page du cours. Faites un `git pull moy master` (cf. ci-dessous) si vous avez l'habitude de lire les fichiers d'énoncé dans votre dépôt.

# 7/09/2021 (bis) : Problème d'installation d'Eclipse sous Ubuntu au Nautibus

L'installation d'Eclipse au Nautibus a l'air cassée. Ne l'utilisez pas. Je vais
essayer de corriger, vous serez prévenu quand ce sera le cas.

# 7/09/2021 : Corrections dans le squelette

Il y a deux corrections mineures dans le squelette de code fourni :

- Quelques lignes qui n'auraient pas dû être là dans `pom.xml`
- Une section `pages:` qui n'aurait pas dû être là non plus dans `.gitlab-ci.yml`

Vous pouvez récupérer ces modifications comme ceci :

```
git remote add moy https://forge.univ-lyon1.fr/matthieu.moy/mif01-2021.git
git pull moy master
```

Si vous avez encore des erreurs liées à "pages" ou "deploy" dans Gitlab-CI, allez dans votre projet sur la forge, barre latérale « Settings », « General », « Project features », et désactivez « pages ».

