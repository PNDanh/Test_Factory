package com.example.bai_test.config.mapper;

import com.example.bai_test.response.StatusResponse;
import com.example.bai_test.entity.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Status convertToEntity(StatusResponse statusResponse){
        Status status = modelMapper.map(statusResponse,Status.class);
        return status;
    }

    public StatusResponse convertToDTO(Status status){
        StatusResponse statusResponse = modelMapper.map(status, StatusResponse.class);
        return statusResponse;
    }
}
