Ce fichier contiendra les nouvelles du cours. Un mail sera envoyé quand le fichier est mis à jour.
# 7/09/2021 (bis) Problème d'installation d'Eclipse sous Ubuntu au Nautibus

L'installation d'Eclipse au Nautibus a l'air cassée. Ne l'utilisez pas. Je vais
essayer de corriger, vous serez prévenu quand ce sera le cas.

# 7/09/2021 Corrections dans le squelette

Il y a deux corrections mineures dans le squelette de code fourni :

- Quelques lignes qui n'auraient pas du être là dans `pom.xml`
- Une section `pages:` qui n'aurait pas du être là non plus dans `.gitlab-ci.yml`

Vous pouvez récupérer ces modifications comme ceci :

```
git remote add moy https://forge.univ-lyon1.fr/matthieu.moy/mif01-2021.git
git pull moy master
```

Si vous avez encore des erreurs liées à "pages" ou "deploy" dans Gitlab-CI, allez dans votre projet sur la forge, barre latérale « Settings », « General », « Project features », et désactivez « pages ».

