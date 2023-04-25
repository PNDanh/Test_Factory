package com.example.bai_test.service.imp;

import com.example.bai_test.response.StatusResponse;
import com.example.bai_test.entity.Status;
import com.example.bai_test.config.mapper.StatusMapper;
import com.example.bai_test.repository.StatusRepository;
import com.example.bai_test.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusServiceImp implements StatusService {

    @Autowired
    private StatusMapper statusMapper;
    @Autowired
    private StatusRepository statusRepository;


    @Override
    public List<StatusResponse> getAll() {
//        TypeToken<StatusDTO> statusDTOTypeToken = new TypeToken<>() {};
//        List<StatusDTO> statusDTOS = modelMapper.map(statusRepository.findAll(), statusDTOTypeToken.getType());
        List<StatusResponse> statusResponses = new ArrayList<>();
        for (Status st : statusRepository.findAll()) {
            statusResponses.add(statusMapper.convertToDTO(st));
        }
        return statusResponses;
    }
}
