package testinglombok.service;

import testinglombok.dtos.TestingRequestDto;
import testinglombok.dtos.TestingResponseDto;

import java.util.List;

public interface LombokService {
    TestingResponseDto create(TestingRequestDto dto);
    List<TestingResponseDto> getAll();
    TestingResponseDto findByName(String name);
    TestingResponseDto findById(int id);
}
