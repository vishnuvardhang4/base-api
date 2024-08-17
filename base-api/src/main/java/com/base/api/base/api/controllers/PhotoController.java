package com.base.api.base.api.controllers;

import com.base.api.base.api.models.Photos;
import com.base.api.base.api.services.PhotoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
public class PhotoController {

    private final PhotoService ps;

    public PhotoController(PhotoService ps) {
        this.ps = ps;
    }


    @GetMapping("/test")
    public String test(){
        return "API is active";
    }

    @GetMapping("/photos")
    public Iterable<Photos> get(){
        return ps.get();
    }

    @GetMapping("/photo/{id}")
    public Photos get(@PathVariable Integer id){
        return ps.get(id);
    }

    @DeleteMapping("/photo/{id}")
    public void delete(@PathVariable Integer id){
            ps.delete(id);
    }

//    Delete request on the browser developer window
//    (async function delete(id) {
//        const req = {fileName: "test1.jpg", contentType: "jpg"}
//        await fetch('http://localhost:8080/photo/' + id,{
//                method: 'DELETE',
//                headers: {
//            'Content-type': 'application/json; charset=UTF-8',
//        }
//        })
//    })()

    @PostMapping("/photo")
    public Photos create(@RequestPart("data")MultipartFile file) throws IOException {
        return ps.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }

//    Post request on the browser developer window
//    (async function post() {
//        const req = {fileName: "test1.jpg", contentType: "jpg"}
//            await fetch('http://localhost:8080/photo',{
//                method: 'POST',
//                body: JSON.stringify(req),
//                headers: {
//                    'Content-type': 'application/json; charset=UTF-8',
//                }
//        })
//    })()

}
