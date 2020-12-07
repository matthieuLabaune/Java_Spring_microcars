# Java Spring Microcars (module Java Avancé)

Application qui permet l’affichage d’une liste et l'ajout d'une nouvelle voiture à la liste de modèles de voitures.

# Glossaire SpringBoot Framework
```java
@Auteur : Matthieu Labaune
@Date de création : 07-12-2020
@Date de mise à jour : 07-12-2020
```

## 1 · Annotations générales

### 1.1 · @EnableAutoConfiguration

L'annotation ***```@EnableAutoConfiguration```*** fait deviner à Spring la configuration basée sur les fichiers JAR disponibles sur le classpath. Il peut savoir quelles bibliothèques vous utilisez et préconfigurer leurs composants sans que vous ayez à lever le petit doigt. C'est ainsi que fonctionnent toutes les bibliothèques de Spring Starter. Cela signifie que c'est un atout majeur, aussi bien lorsque vous commencez à travailler avec une bibliothèque que lorsque vous savez que la configuration par défaut est raisonnable.

### 1.2 · @Autowired

Pour relier les parties de l'application entre elles, utilisez le ***```@Autowired```*** sur les champs, les constructeurs ou les méthodes d'un composant. Le mécanisme d'injection de la dépendance du ressort permet de câbler les "***beans***" (*dépendances*) appropriés dans les membres de la classe marqués d'un ***```@Autowired```***.

##### Exemple
    
```java 
    @Autowired
    private CarDao carDao;
```

## 2 · Annotations Web

### 2.1 · @Controller
***```@Controller```*** marque la classe comme un contrôleur web, capable de traiter les requêtes HTTP. Spring examinera les méthodes de la classe marquée par l'annotation ***```@Controller```*** et établira la table de routage pour savoir quelles méthodes servent quels points terminaux.

##### Exemple

```java
@Controller
public class MainController {
  // Méthodes du controller
 //...
}
```

## 2.2 · @ResponseBody
Le ***```@ResponseBody```*** est une annotation qui fait que Spring lie la valeur de retour d'une méthode au corps de réponse HTTP. Lors de la construction d'un terminal JSON, c'est une façon étonnante de convertir magiquement vos objets en JSON pour une utilisation plus facile.


## 2.3 · @RestController
L'annotation ***```@RestController```*** une syntaxe de commodité pour @Controller et @ResponseBody ensemble. Cela signifie que toutes les méthodes d'action dans la classe marquée retourneront la réponse JSON.

##### Exemple

```java
@RestController
public class CarController {
  // Méthodes du controller
 //...
}
```

## 2.4 · @RequestMapping
L'annotation ***```@RequestMapping(method = RequestMethod.GET, value = "/path")```*** spécifie une méthode dans le contrôleur qui devrait être responsable de servir la requête HTTP vers le chemin donné. Spring travaillera sur les détails de la mise en œuvre de cette méthode. Il vous suffit de spécifier la valeur du chemin sur l'annotation et Spring acheminera les requêtes vers les méthodes d'action correctes.

##### Exemple

```java
@RequestMapping(value = { "/carList" }, method = RequestMethod.GET)
//Puis une méthode (ici carList qui retourne une liste de voitures)
    public String carList(Model model) {
        model.addAttribute("cars", cars);
        return "carList";
    }
```

## 2.5 · @RequestParam
Bien entendu, les méthodes de traitement des demandes peuvent être paramétrées. Pour vous aider à lier les paramètres HTTP dans les arguments des méthodes d'action, vous pouvez utiliser l'annotation ***```@RequestParam(value="name", defaultValue="World")```***. Spring analysera les paramètres de la requête et mettra les paramètres appropriés dans les arguments de votre méthode.

## 2.6 · @PathVariable
Une autre façon courante de fournir des informations au backend est de les coder dans l'URL. Vous pouvez ensuite utiliser l'annotation ***```@PathVariable("placeholderName")```*** pour amener les valeurs de l'URL aux arguments de la méthode. 

##### Exemple

```java
// Ici, on passe l'id (int) comme information via l'url via la méthode showCar
public Car showCar(@PathVariable int id) {
        Car car = new Car(id, "Honda", "Jazz");
        return car;
    }
```
       

