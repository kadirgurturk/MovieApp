package com.kadirgurturk.MovieApp.service;

import com.kadirgurturk.MovieApp.dto.DirectorDto;
import com.kadirgurturk.MovieApp.dto.Iterable.DirectorsDTO;
import com.kadirgurturk.MovieApp.dto.Iterable.MovieListDTO;
import com.kadirgurturk.MovieApp.dto.Save.SaveDirector;
import com.kadirgurturk.MovieApp.mapper.DirectorMapper;
import com.kadirgurturk.MovieApp.repository.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DirectorService {

    private DirectorMapper directorMapper;
    private DirectorRepository directorRepository;

    public DirectorService(DirectorMapper directorMapper, DirectorRepository directorRepository) {
        this.directorMapper = directorMapper;
        this.directorRepository = directorRepository;
    }

    public Optional<DirectorDto> findById(Long id)
    {
        return directorRepository.findById(id).map(directorMapper::toDirectorDto);
    }

    public DirectorsDTO findByName(String name)
    {
        return directorMapper.toDirectorsDTO(StreamSupport.stream(directorRepository.findByfirstName(name).spliterator(),false).map(directorMapper::toDirectorDto).collect(Collectors.toList()));
    }

    public MovieListDTO findMoviesById(Long id)
    {
        return directorMapper.toMovieListDto(StreamSupport.stream(directorRepository.findByIdWithMovies(id).spliterator(), false).toList());
    }

    public void save(SaveDirector saveDirector)
    {

        var director = directorMapper.toDirector(saveDirector);

        directorRepository.save(director);

    }
}
