package com.teachplus.Controller;

import com.teachplus.Entity.Message;
import com.teachplus.Entity.MessageWrapper;
import com.teachplus.Entity.Note;
import com.teachplus.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping(produces = { "application/json" })
    public ResponseEntity getAllMessages(@RequestParam("userId") Long userId, @RequestParam("groupId") Long[] groupIds) {
        List<Message> messages = messageService.getAllMessagesForUser(userId, groupIds);
        if (messages == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(messages);
    }


    @PostMapping(consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity addMessage(@RequestBody Message message) {
        Message newMessage = messageService.addMessage(message);
        return ResponseEntity.ok().body(newMessage);
    }

}
