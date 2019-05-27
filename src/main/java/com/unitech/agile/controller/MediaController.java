package com.unitech.agile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.unitech.agile.manager.MediaManager;
import com.unitech.agile.model.request.AddImageRequest;

import io.swagger.annotations.ApiOperation;

@RestController
public class MediaController {	
	
	@Autowired
	MediaManager mediaManager;

    @ApiOperation(value="Add image to POI, PNG images only", tags="Agile")
	@PostMapping(value = "/images")
	public String addImage(@RequestHeader(value="token") String token, @RequestBody AddImageRequest request) {
		return mediaManager.addImage(token, request).toString();
	}
    
    @GetMapping(value = "/images/{imageId}", produces = MediaType.IMAGE_PNG_VALUE)
    public FileSystemResource getFile(@RequestHeader(value="token") String token, @PathVariable("imageId") int imageId) {
        return new FileSystemResource(mediaManager.loadImage(token, imageId)); 
    }
    
    /*
     * red image data (source image is in the project)
      iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAIAAAACUFjqAAAACXBIWXMAAC4jAAAuIwF4pT92AAAAB3RJTUUH4wUbFC4K4wF3/AAAABl0RVh0Q29tbWVudABDcmVhdGVkIHdpdGggR0lNUFeBDhcAAAASSURBVBjTYzzOgA8wMYxKYwEA/YUA23G4lo0AAAAASUVORK5CYII=
     */
}
