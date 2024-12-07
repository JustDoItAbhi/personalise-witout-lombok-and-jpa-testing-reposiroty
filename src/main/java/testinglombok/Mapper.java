package testinglombok;

import testinglombok.dtos.TestingResponseDto;
import testinglombok.entity.TestingLombok;

public class Mapper {
    public static TestingResponseDto fromEntity(TestingLombok testingLombok){
        TestingResponseDto responseDto=new TestingResponseDto();
        responseDto.setName(testingLombok.getName());
        responseDto.setAge(testingLombok.getAge());
        return responseDto;
    }
}
