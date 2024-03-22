package com.example.jounralApp.controller;

import com.example.jounralApp.entity.JouneralEntry;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/jounral")
public class JounralEntryController {

    //TODO[kuldeep][01/12/2023] give the proper message for user after create update and deleting the record


    public Map<Long, JouneralEntry> jouneralEnteries = new HashMap<>();

    @GetMapping("/test")
    public String getChecking(){
        return "Hello good morning";
    }

    @GetMapping
    public List<JouneralEntry> getAll(){

        
        return new ArrayList<>(jouneralEnteries.values());
    }

    @PostMapping
    public String createEntery(@RequestBody JouneralEntry myEntery){
            jouneralEnteries.put(myEntery.getId(), myEntery);
            return "Entery Created";
    }

   // @GetMapping("id/{myId}")
   // public JouneralEntry getjounralEnteryById(@PathVariable Long myId){
    //    return jouneralEnteries.get(myId);
   // }

    @GetMapping("id/{myId}")
    public ResponseEntity<JouneralEntry> getJournalEntryById(@PathVariable Long myId) {
        JouneralEntry entry = jouneralEnteries.get(myId);
        if (entry != null) {
            return ResponseEntity.ok(entry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<String> deletejounralEnteryById(@PathVariable Long myId){
        JouneralEntry removedEntry = jouneralEnteries.remove(myId);
        if (removedEntry != null) {
            String message = "Journal entry with ID " + myId + " deleted successfully";
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(message);
        } else {
            String message = "Journal entry with ID " + myId + " not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
    @PutMapping("id/{Id}")
//    public JouneralEntry updatejounralEnteryById(@PathVariable Long Id, @RequestBody JouneralEntry myEntery){
//        return jouneralEnteries.put(Id, myEntery);

    public ResponseEntity<String> updateJournalEntryById(@PathVariable Long Id, @RequestBody JouneralEntry updatedEntry) {
        JouneralEntry existingEntry = jouneralEnteries.get(Id);
        if (existingEntry != null) {
            jouneralEnteries.put(Id, updatedEntry);
            return ResponseEntity.ok("Journal entry with ID " + Id + " updated successfully");
        } else {
            String message = "Journal entry with ID " + Id + " not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
