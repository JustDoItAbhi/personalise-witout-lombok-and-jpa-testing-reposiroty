package testinglombok.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testinglombok.Mapper;
import testinglombok.dtos.TestingRequestDto;
import testinglombok.dtos.TestingResponseDto;
import testinglombok.entity.TestingLombok;
import testinglombok.repository.TestingLombokRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LOmbokServiceImpl implements LombokService {
@Autowired
    private TestingLombokRepo testingLombokRepo;

    @Override
    public TestingResponseDto create(TestingRequestDto dto) {
        TestingLombok testingLombok=new TestingLombok();
        testingLombok.setId(dto.getId());
        testingLombok.setName(dto.getUserName());
        testingLombok.setAge(dto.getUserAge());
        testingLombokRepo.saveTestigLombok(testingLombok);
        return Mapper.fromEntity(testingLombok);
    }

    @Override
    public List<TestingResponseDto> getAll() {
        List<TestingLombok>testingLombokList=testingLombokRepo.getAllTestigLomboks();
        List<TestingResponseDto>responseDtos=new ArrayList<>();
        for(TestingLombok lombok:testingLombokList){
            responseDtos.add(Mapper.fromEntity(lombok));
        }

        return responseDtos;
    }

    @Override
    public TestingResponseDto findByName(String name) {
        TestingLombok lombok=testingLombokRepo.findByName(name);
        if(lombok==null){
            throw new RuntimeException("NO SUCH NAME EXISTS "+ name);
        }
        return Mapper.fromEntity(lombok);
    }

    @Override
    public TestingResponseDto findById(int id) {
        TestingLombok lombok= testingLombokRepo.findById(id);
    return Mapper.fromEntity(lombok);
    }

    @Override
    public TestingResponseDto updateStudent(TestingRequestDto dto) {
        TestingLombok lombok=testingLombokRepo.findById(dto.getId());
        if(lombok==null){
            throw new RuntimeException("NO SUCH STUDENT EXISTS "+dto.getUserName());
        }
            lombok.setAge(dto.getUserAge());
            lombok.setName(dto.getUserName());
            testingLombokRepo.updating(lombok);
        return Mapper.fromEntity(lombok);
    }

    @Override
    public boolean deleteStudent(int id) {
        testingLombokRepo.deleteTestigLombok(id);

        return true;
    }
}
