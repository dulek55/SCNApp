package com.ITApp.SCN.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITApp.SCN.models.MessageModel;
import com.ITApp.SCN.repository.MessageModelRepository;
import com.ITApp.SCN.repository.UserModelRepository;

@Service
public class MessageModelService {
	@Autowired
    private MessageModelRepository messageRepository;
    @Autowired
    private UserModelRepository userRepository;

    public void addMessage(MessageModel message) {

        messageRepository.save(message);

    }

    /*public void updateCanoe(CanoeModel canoe, int id) {
        CanoeModel currentCanoe = canoeRepository.findById(id).get();
        currentCanoe.setPhoto(canoe.getPhoto());
        currentCanoe.setCapacity(canoe.getCapacity());
        currentCanoe.setColour(canoe.getColour());

        canoeRepository.save(currentCanoe);
    }*/

    /*public void rentCanoe(int id, UserModel user) {
            CanoeModel currentCanoe = canoeRepository.findById(id).get();
        currentCanoe.setTakenBy(userRepository.findById(user.getId()).get());

        canoeRepository.save(currentCanoe);
    }*/

    /*public void returnCanoe(int id, UserModel user) {
        CanoeModel currentCanoe = canoeRepository.findById(id).get();
        currentCanoe.setTakenBy(null);

        canoeRepository.save(currentCanoe);
    }*/
}
