package com.base.api.base.api.services;

import com.base.api.base.api.repositories.PhotoRepository;
import com.base.api.base.api.models.Photos;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    private final PhotoRepository pr;

    public PhotoService(PhotoRepository pr) {
        this.pr = pr;
    }

    public Iterable<Photos> get(){
        return pr.findAll();
    }

    public Photos get(Integer id){
        return pr.findById(id).orElse(null);
    }

    public void delete(Integer id){
        pr.deleteById(id);
    }

    public Photos save(String fileName, String contentType, byte[] data){
        Photos photo = new Photos();
        photo.setFileName(fileName);
        photo.setContentType(contentType);
        photo.setData(data);
        pr.save(photo);
        return photo;
    }
}
