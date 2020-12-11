---
* [1 · Annotations générales](#1--annotations-gnrales)
    * [1.1 · @EnableAutoConfiguration](#11--enableautoconfiguration)
    * [1.2 · @Autowired](#12--autowired)
    * [1.3 · @Repository](#13--repository)
    
---

## 1 · Annotations générales

### 1.1 · @EnableAutoConfiguration

L'annotation ***```@EnableAutoConfiguration```*** fait deviner à Spring la configuration basée sur les fichiers JAR
disponibles sur le classpath. Il peut savoir quelles bibliothèques vous utilisez et préconfigurer leurs composants sans
que vous ayez à lever le petit doigt.

### 1.2 · @Autowired

Pour relier les parties de l'application entre elles, on utilise le ***```@Autowired```*** sur les champs, les
constructeurs ou les méthodes d'un composant. ***```@Autowired```***.

##### Exemple

```java 
    @Autowired
    private CarDao carDao;
```

### 1.3 · @Repository

***```@Repository```*** est une annotation qui indique que la classe associée est un dépôt. Un dépôt est un mécanisme
d'encapsulation du stockage, de la récupération et du comportement de recherche qui émule une collection d'objets. On se
sert de ***```@Repository```*** pour tout ce qui touche à la gestion des données. Le Repository va contenir les méthodes
qui permettent d'accéder et de modifier les données.

```java 
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
     List<Car> findAll();
     Car findById(int id);
     Car save(Car car);
     Car deleteById(int id);
}
```
