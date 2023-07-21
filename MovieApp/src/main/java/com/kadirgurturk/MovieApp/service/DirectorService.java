package com.kadirgurturk.MovieApp.service;

import com.kadirgurturk.MovieApp.dto.DirectorDto;
import com.kadirgurturk.MovieApp.dto.Iterable.DirectorsDTO;
import com.kadirgurturk.MovieApp.dto.Iterable.MovieListDTO;
import com.kadirgurturk.MovieApp.dto.Save.SaveDirector;
import com.kadirgurturk.MovieApp.mapper.DirectorMapper;
import com.kadirgurturk.MovieApp.repository.DirectorRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@CacheConfig(cacheNames = "movie")
public class DirectorService {

    private DirectorMapper directorMapper;
    private DirectorRepository directorRepository;

    public DirectorService(DirectorMapper directorMapper, DirectorRepository directorRepository) {
        this.directorMapper = directorMapper;
        this.directorRepository = directorRepository;
    }

    @Cacheable(value = "directors", key = "#id")
    public Optional<DirectorDto> findById(Long id)
    {
        return directorRepository.findById(id).map(directorMapper::toDirectorDto);
    }


    public DirectorsDTO directorPagination(int page, int size)
    {
        var pageble = PageRequest.of(page,size);

       return directorMapper.toDirectorsDTO(StreamSupport.stream(directorRepository.findAll(pageble).spliterator(),false)
               .map(directorMapper::toDirectorDto)
               .collect(Collectors.toList()));
    }

    public DirectorsDTO directorSort(String field)
    {
        return directorMapper.toDirectorsDTO(StreamSupport.stream(directorRepository.findAll(Sort.by(field)).spliterator(),false)
                .map(directorMapper::toDirectorDto)
                .collect(Collectors.toList()));
    }


    public DirectorsDTO directorsSortPage(int page, int size, String field)
    {
        var pageble = PageRequest.of(page,size);

       return directorMapper.toDirectorsDTO(StreamSupport.stream(directorRepository.findAll(pageble.withSort(Sort.by(field))).spliterator(),false)
                .map(directorMapper::toDirectorDto)
               .collect(Collectors.toList()));
    }

    public DirectorsDTO findByName(String name)
    {
        return directorMapper.toDirectorsDTO(StreamSupport.stream(directorRepository.findByfirstName(name).spliterator(),false).map(directorMapper::toDirectorDto).collect(Collectors.toList()));
    }

    @Cacheable(value = "director", key = "#id")
    public MovieListDTO findMoviesById(Long id)
    {
        return directorMapper.toMovieListDto(StreamSupport.stream(directorRepository.findByIdWithMovies(id).spliterator(), false).toList());
    }

    @CachePut(value = "directors", key = "#result.id")
    public void save(SaveDirector saveDirector)
    {

        var director = directorMapper.toDirector(saveDirector);

        directorRepository.save(director);

    }
}
