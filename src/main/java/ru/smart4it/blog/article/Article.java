package ru.smart4it.blog.article;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "article")
public class Article {

    @Id
    private UUID id;

    private String title;

    private String content;

    private LocalDateTime created;

    private LocalDateTime updated;
}
