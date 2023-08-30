package com.example.TechItEasy.Controllers;
import com.example.TechItEasy.Exeptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TelevisionControllers {
    private List<Television> tv = new ArrayList<>();

    public TelevisionControllers() {
        Television tvname = new Television("Samsung 2023", 600, "Samsung");
        tv.add(tvname);
    }




    @GetMapping("/televisions/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable int id){

        if (id >= 0 && id < tv.size()){
            Television t = tv.get(id);
            return new ResponseEntity<>(t, HttpStatus.OK);
        } else{
            throw new RecordNotFoundException( "Television with id: " + id + " does not exist");
        }
    }

    @GetMapping("/allTelevisions")
    public ResponseEntity<List<Television>> getAllTelevisions(){
        return new ResponseEntity<>(tv, HttpStatus.OK);
    }

    @PostMapping("/addTelevision")
    public ResponseEntity<Television> addTelevision(@RequestBody Television television){
        tv.add(television);
        return new ResponseEntity<>(television, HttpStatus.CREATED);
    }


    @PutMapping("/changeTelevision/{id}")
    public ResponseEntity<Television> changeTelevision(@PathVariable int id, @RequestBody Television television){
        if (id >= 0 && id < tv.size()){
            tv.set(id, television);
            return new ResponseEntity<>(television, HttpStatus.I_AM_A_TEAPOT);
        } else{
            throw new RecordNotFoundException( "Television with id: " + id + " cannot be changed");
        }
    }


    @DeleteMapping("/deleteTelevision/{id}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable int id){
        if (id >= 0 && id < tv.size()){
            tv.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new RecordNotFoundException( "Television with id: " + id + " cannot be found");
        }
    }

}
