# QuickLook Backend

## Description

This repository holds the backend code for the QuickLook project. It is built using [SpringBoot](https://spring.io/projects/spring-boot).
This project has some notable packages including Phrase, PhraseSet, and User, which are specified below. 
Each of these packages has typical Service, Controller, and Repository beans that you would see in a Spring project.
As of now the only Config class being used is the WebConfig class for CORS.
The classes above are mapped to a PostgreSQL database using [Spring Data JPA](https://spring.io/projects/spring-data-jpa).


## Beans


### Phrase 

The Phrase class holds properties for a single phrase and the associated summary that is generated using the [OpenAI API](https://platform.openai.com/).
Some notable properties: 

```java
@Id
@SequenceGenerator(name = "phrase_sequence", sequenceName = "phrase_sequence", allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phrase_sequence")
private Long id;

private String phrase;

@Column(length = 2048)
private String summary;


private Date dateAdded;


@ManyToOne
@JoinColumn(name = "user_id", nullable = false)
@JsonIgnore // Prevent serialization of the user field to avoid cyclic references
private User user;
```

Note that the ```user``` and ```phraseSet``` properties are joined to another table by a ```user_id``` and ```phrase_set_id``` property found in the ```User``` and ```PhraseSet``` classes, respectively.

### PhraseSet

The PhraseSet class holds properties associated with an entire set of phrases.
Some notable properties: 

```java
    private Long phraseSetId;

    private String phraseSetName;
    
    private Date dateAdded;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    @JsonIgnore
    private User user;
    
    @OneToMany(mappedBy = "phraseSet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phrase> phrases;
```

Note that the ```user``` property is joined to another table by a ```user_id``` property found in the ```User``` class.

### User 

The User class holds properties associated with a single QuickLook user. 
Some notable properties:

```java
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @OneToMany( 
            mappedBy = "user",  
            cascade = CascadeType.ALL, 
            orphanRemoval = true 
    )
    private List<PhraseSet> phraseSets;
```
