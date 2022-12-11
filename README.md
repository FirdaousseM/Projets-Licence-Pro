# Lecteur de fichier

## **Membre du groupe :** 
Firdaousse M.

## **Technologie :** 
JAVA

## __Description :__ 
Le but de ce projet est de créer un chat en ligne avec plusieurs clients. Ce projet utilise les Threads afin de lancer plusieurs connexions simultanées, et permettre au serveur de recevoir des messages des clients sans être bloqué.



## __Lancement :__ 
Depuis Eclipse -> Créer un projet java. Y insérer tous les fichiers du git.

- Sélectionner Serveur.java -> run configurations -> arguments -> ajouter le numéro de port plus grand que 1024 (exemple : 4000)

- Sélectionner Client.java -> run configurations -> arguments -> ajouter une adresse, puis le numéro de port plus grand que 1024 (exemple : 127.0.0.1 4000)

- Lancer la classe Serveur. Lancer autant de classe client que l'on veut.
