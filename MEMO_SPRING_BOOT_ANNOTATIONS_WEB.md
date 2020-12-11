-------------------------------------
* [2 · Annotations Web](#2--annotations-web)
    * [2.1 · @Controller](#21--controller)
    * [2.2 · @ResponseBody](#22--responsebody)
    * [2.3 · @RestController](#23--restcontroller)
    * [2.4 · @RequestMapping](#24--requestmapping)
    * [2.5 · @PathVariable](#25--pathvariable)
    * [2.6 · CRUD Annotations](#26--crud-annotations)
-------------------------------------
## 2 · Annotations Web

### 2.1 · @Controller

***```@Controller```*** marque la classe comme un contrôleur web, capable de traiter les requêtes HTTP. Spring examinera
les méthodes de la classe marquée par l'annotation ***```@Controller```*** et établira la table de routage pour savoir
quelles méthodes servent quels points terminaux.

##### Exemple

```java

@Controller
public class MainController {
    // Méthodes du controller CRUD par exemple GET, POST, PUT, DELETE.
    //...
}
```

### 2.2 · @ResponseBody

Le ***```@ResponseBody```*** est une annotation qui fait que Spring lie la valeur de retour d'une méthode au corps de
réponse HTTP. Lors de la construction d'un terminal JSON, c'est une façon étonnante de convertir "*magiquement*" des
objets en JSON pour une utilisation plus facile.

### 2.3 · @RestController

L'annotation ***```@RestController```*** une syntaxe de commodité pour @Controller et @ResponseBody ensemble. Cela
signifie que toutes les méthodes d'action dans la classe marquée retourneront la réponse JSON.

##### Exemple

```java

@RestController
public class CarController {
    // Méthodes du controller
    //...
}
```

### 2.4 · @RequestMapping

L'annotation ***```@RequestMapping(method = RequestMethod.GET, value = "/path")```*** spécifie une méthode dans le
contrôleur qui devrait être responsable de servir la requête HTTP vers le chemin donné. Spring travaillera sur les
détails de la mise en œuvre de cette méthode. Il suffit de spécifier la valeur du chemin sur l'annotation et Spring
acheminera les requêtes vers les méthodes d'action correctes.

##### Exemple

```java
@RequestMapping(value = {"/carList"}, method = RequestMethod.GET)
//Puis une méthode (ici carList qui retourne une liste de voitures)
public String carList(Model model){
        model.addAttribute("cars",cars);
        return"carList";
        }
```


### 2.5 · @PathVariable

Une façon courante de fournir des informations au backend est de les coder dans l'URL. Pour cela, on
utilise l'annotation ***```@PathVariable("placeholderName")```*** pour amener les valeurs de l'URL aux arguments de la
méthode.

##### Exemple

```java
 //SHOW BY ID => /cars/{id}
@GetMapping(value = "cars/{id}") //GET Mapping pour l'uri pour retourner une voiture par l'id
public Car showCar(@PathVariable int id) {// Va chercher le paramètre id dans l'url et le passe à notre méthode
        return carRepository.findById(id);
        }
```

### 2.6 · CRUD Annotations

Pour construire un CRUD on peut utiliser les annotations correspondant aux requêtes HTTP, à savoir :

1. GET : @GetMapping(value = "cars"),
2. POST : @PostMapping(value = "cars/store"),
3. PUT : @PutMapping(value = "/cars/{id}/update"),
4. DELETE : @DeleteMapping (value = "/cars/{id}/destroy").
