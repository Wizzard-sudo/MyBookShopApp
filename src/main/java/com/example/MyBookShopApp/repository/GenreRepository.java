package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.dto.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    public List<Genre> findGenreByParentId(Integer parentId);

    public Genre findGenreBySlug(@NotNull String slug);
}
