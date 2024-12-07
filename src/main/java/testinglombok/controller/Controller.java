package testinglombok.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testinglombok.dtos.TestingRequestDto;
import testinglombok.dtos.TestingResponseDto;
import testinglombok.service.LombokService;

import java.util.List;

@RestController
@RequestMapping("/lombok")
public class Controller {
    @Autowired
private LombokService lombokService;
@PostMapping("/add")
    public ResponseEntity<TestingResponseDto> create(@RequestBody TestingRequestDto dto){
    return ResponseEntity.ok(lombokService.create(dto));
}
@GetMapping("/")
    public ResponseEntity<List<TestingResponseDto>> getAll(){
    return ResponseEntity.ok(lombokService.getAll());
}
@GetMapping("/{id}")
    public ResponseEntity<TestingResponseDto> findById(@PathVariable ("id")int id){
    return ResponseEntity.ok(lombokService.findById(id));
}
    @GetMapping("/name/{name}")
    public ResponseEntity<TestingResponseDto> findByName(@PathVariable ("name")String name){
        return ResponseEntity.ok(lombokService.findByName(name));
    }
}
