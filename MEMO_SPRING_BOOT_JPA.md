-------------------------------------
* [3 · JPA et MariaDB](#3--jpa-et-mariadb)
    * [3.1 · Configuration générale](#31--configuration-générale)
    * [3.2 · Annotations JPA](#32--annotations-jpa)
    * [3.2.1 · @Entity](#321--entity)
    * [3.2.2 · @Id](#322--id)
    * [3.2.3 · @GeneratedValue](#323--generatedvalue)
    * [3.2.4 · @Temporal](#324--temporal)
  
-------------------------------------

## 3 · JPA et MariaDB

### 3.1 · Configuration générale

La Java Persistence API repose essentiellement sur l'utilisation des annotations, comme pour SpringBoot. Elles
permettent de définir facilement des objets métier, qui pourront servir d'interface entre la base de données et l'
application, dans le cadre d'un mapping objet-relationnel. Pour pouvoir utiliser l'interface JPA (*Java Persistence
API*), il faut importer le package correspondant avec Maven dans le pom.xml. Il faut également ajouter une dépendance
pour le type de Système de DB utilisé. Ici on utilise MariaDB par facilité car déjà installé.

```java
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
<groupId>org.mariadb.jdbc</groupId>
<artifactId>mariadb-java-client</artifactId>
</dependency>
```

Ensuite, il faut configurer cela dans l'application (dans *application.properties*).

```java
#DATABASE CONFIGURATION
        spring.datasource.url=jdbc:mariadb://localhost:3306/VehiculeRentale
        spring.datasource.username=user
        spring.datasource.password=hardtofind
        spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
        spring.jpa.hibernate.ddl-auto=create-drop
```

On ajoute donc un nom pour la DB "*VehiculeRentale*". On renseigne l'utilisateur et le password pour accéder à notre DB.
On ajoute évidement le driver mariadb et on indique par *"create-drop"* que la base sera créée lors du lancement de
l'application et détruite lors de son arrêt.

### 3.2 · Annotations JPA

Comme pour SpringBoot, il existe différentes annotations pour JPA afin de pouvoir l'utiliser.

##### Exemple

```java
package com.ecars.microcars.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity 
public class Car {
    
    //ID
    @Id
    @GeneratedValue
    private int id;

    //TIMESTAMP
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
```
#### 3.2.1 · @Entity
@Entity nous indique que cette classe est une classe persistante. Elle représente une table de la DB.
Elle peut prendre un attribut name, qui fixe le nom de cette entité. Par défaut, le nom d'une entité est le nom complet de sa classe.
Les attributs de la classe sont donc les colonnes de la future table de la DB.

#### 3.2.2 · @Id
Associe un champ de la table à la propriété en tant que clé primaire.

#### 3.2.3 · @GeneratedValue
Demande la génération automatique de la clé primaire au besoin.

#### 3.2.4 · @Temporal

Pour préciser le type SQL temporel avec lequel on veut stocker ces champs, on dispose d'une annotation spécifique : @Temporal. Cette annotation prend un unique attribut, qui peut prendre les valeurs TemporalType.DATE, TemporalType.TIME ou TemporalType.TIMESTAMP.
* TemporalType.DATE : enregistre les dates en temps que jour / mois / année ;
* TemporalType.TIME : enregistre les dates en temps que heure / minute / seconde ;
* TemporalType.TIMESTAMP : enregistre les deux informations de date et d'heure dans la jouenée.
