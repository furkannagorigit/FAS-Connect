package com.fas.connect.service;

import com.fas.connect.dto.AnnouncementDTO;
import com.fas.connect.dto.FeedDTO;
import com.fas.connect.dto.PostDTO;
import com.fas.connect.entity.Announcement;
import com.fas.connect.entity.Feed;
import com.fas.connect.entity.Post;
import com.fas.connect.repository.AnnouncementRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementServiceImpl implements IAnnouncementService{

    private final AnnouncementRepository announcementRepository;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }


    @Autowired
    private ModelMapper modelMapper;

    public List<AnnouncementDTO> getAllAnnouncements() {
        List<Announcement> announcements = announcementRepository.findAll();
        return announcements.stream()
            .map(post -> modelMapper.map(post, AnnouncementDTO.class))
            .collect(Collectors.toList());
    }

    public void deleteAnnouncement(Long id) {
        announcementRepository.deleteById(id);
    }

	@Override
	public AnnouncementDTO saveAnnouncement(AnnouncementDTO announcementDTO) {
	    	Announcement announcement = modelMapper.map(announcementDTO, Announcement.class);
	    	return modelMapper.map(announcementRepository.save(announcement), AnnouncementDTO.class);
	}
}
