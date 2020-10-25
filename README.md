# Découverte de Vaadin

Vaadin est un framework Java permettant de créer facilement des PWA (Progressive Web App).

## Installation

Nous vous recommandons d'utiliser soit Eclipse ou Intellij. Ces IDE ont accès à des plugins facilitant la compilation et le développement de Vaadin.

### Eclipse 

Il faut installer le plugin *Vaadin Plug-in for Eclipse* ***(et seulement celui-ci !)***.

Pour ce faire, il faut aller dans l'onglet *Help* -> *Install New Software* -> *Add*. Entrez Vaadin dans le nom et https://vaadin.com/eclipse dans la "location", cliquez sur *Add* et sélectionnez **Vaadin Plug-in for Eclipse**.

Il suffira ensuite de "run" la classe Application

### Intellij

Pas besoin de plug-in en particulier, l'utilisation de maven suffit.

## TP - Quizz App

Dans l'application, vous pourrez retrouver l'ensemble de la partie Live Coding de la présentation.

Votre but, lors de ce TP, est de continuer l'application pour avoir une partie Quizz. Il sera possible de sélectionner le nombre de questions via une pop-up sur l'accueil de l'application.
Nous aurons ensuite une page dédiée avec la question et les réponses (sous forme de boutons ou autre).
Il existe deux types de questions : True/False ou QCM.
Il sera ensuite possible de visualiser son score à la fin de l'ensemble des questions.

L'ensemble des fonctionnalités pour récupérer les questions sont déjà fournies. Vous pouvez vous concentrer uniquement sur la partie "front" de l'application.

Les questions sont récupérées depuis cette API : https://opentdb.com/api_config.php

Nous avons pris le parti de vous laisser entièrement libre sur ce TP.
Vous êtes totalement libre de faire ressembler votre application comme vous le souhaitez !
Cela explique pourquoi ce TP est très peu guidé. A la fin, vous pourrez comparer votre application avec celle des autres pour voir l'ensemble des possibilités de Vaadin et de votre créativité.
Nous vous indiquons tout de même l'ensemble des tâches à réaliser (avec l'ordre recommandé) pour avoir une application fonctionnelle.

**Surtout n'hésitez pas à perdre du temps à explorer les possibilités de Vaadin via la documentation (bien fournie sur le site officiel). Avec une plus grande curiosité, votre application sera plus originale !**

Nous vous laissons quand même des conseils pour développer facilement sur Vaadin !

## Étapes à suivre

- Pop-up pour renseigner le nombre de questions et navigation vers la page de quizz
- Affichage des questions et des réponses
- Gestion des réponses utilisateurs
- Système pour le passage à la question suivante après la réponse utilisateur
- Afficher le score de l'utilisateur à la fin des questions

## Note sur les fichiers 

Pour rappel vous trouvez dans ce projet les ressources du live coding. Vous pouvez donc vous en inspirer. 

C'est dans le MainView que vous allez retrouver la page pour le quizz. Le HomeView est la page d'accueil dans laquelle
vous devez faire la première étape. 

Le QuestionService sera le service qui va nous permettre de récupérer les questions. La méthode getQuestion va vous 
retourner un objet du type ReponseApi, nous vous conseillons de consulter le contenu de cet objet afin de l'exploiter.

## Conseils pour développer facilement et rapidement

- Google est votre ami, vous pouvez trouver l'ensemble des "widgets/composants" et leurs fonctionnalités sur Internet.
- La documentation officielle de Vaadin est votre meilleur ami, vous pouvez visualiser l'ensemble des possibilités : https://vaadin.com/components
- L'autocomplétion des IDE vous permet de trouver plus facilement les fonctions à utiliser. 
Par exemple, vous souhaitez gérer la largeur d'un élément, il suffit de faire <nom_element>. , taper width et vous avez l'autocomplétion qui indique l'ensemble des fonctions gérant la largeur de l'élément.
- Nous sommes là pour vous aider, n'hésitez surtout pas à nous interpeller !

