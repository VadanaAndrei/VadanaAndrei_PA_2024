    package org.example.compulsory.models;

    import jakarta.persistence.*;
    import lombok.*;

    @Entity
    @Table(name = "authors")
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode
    public class Author {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column
        private String name;

        public Author(String name)
        {
            this.name = name;
        }
    }
