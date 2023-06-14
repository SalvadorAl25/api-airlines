package com.airline.checkin.services;

import com.airline.checkin.models.BoardingPassEntity;
import com.airline.checkin.repositories.BoardingPassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardingPassService {

    @Autowired
    BoardingPassRepository boardingPassRepository;

    public Iterable<BoardingPassEntity> findAll() {
        return boardingPassRepository.findAll();
    }

    public Optional<BoardingPassEntity> findById(Integer boardingPassId) {
        return boardingPassRepository.findById(boardingPassId);
    }

    public void save(BoardingPassEntity boardingPass) {
        boardingPassRepository.save(boardingPass);
    }

    public void delete(BoardingPassEntity boardingPass) {
        boardingPassRepository.delete(boardingPass);
    }
}
