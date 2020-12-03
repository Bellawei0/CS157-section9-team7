# change the length of password to 100
ALTER TABLE `project157a`.`user_register`
    CHANGE COLUMN `password` `password` VARCHAR(100) NULL DEFAULT NULL ;

# changed note_id to AUTO_INCREMENT
ALTER TABLE `project157a`.`note_meta` 
CHANGE COLUMN `note_id` `note_id` INT NOT NULL AUTO_INCREMENT ;

# changed data_type from  VARCHAR to INT
ALTER TABLE `project157a`.`note_meta` 
CHANGE COLUMN `class_id` `class_id` INT(45) NOT NULL ;

ALTER TABLE `project157a`.`note_docu` 
CHANGE COLUMN `note_id` `note_id` INT NOT NULL ;

ALTER TABLE `project157a`.`note_picture` 
CHANGE COLUMN `link` `link` MEDIUMBLOB NULL DEFAULT NULL ;

UPDATE `project157a`.`learning_principle` SET `method` = 'Actively Anticipate Meeting ', `description` = 'Review schedule, notes, readings, and material from previous meeting' WHERE (`principle_id` = '1');
UPDATE `project157a`.`learning_principle` SET `method` = 'Loaned Innovation', `cycle` = 'collect', `description` = 'Information is no longer scarce, but meeting time are. Capture the knowledge from the meeting to save yourself time for the near-future' WHERE (`principle_id` = '2');
UPDATE `project157a`.`learning_principle` SET `method` = 'Salvage Concept Images', `description` = '\nMake a clear To-Do box for Visual, Verbal, Descriptive, Symbolic, Code, Algorithmic, thinks you will need to fill in\n\nMake a clear To-Do box for Visual, Verbal, Descriptive, Symbolic, Code, Algorithmic, thinks you will need to fill in\nMake a clear To-Do box for Visual, Verbal, Descriptive, Symbolic, Code, Algorithmic, thinks you will need to fill in' WHERE (`principle_id` = '3');
UPDATE `project157a`.`learning_principle` SET `method` = 'Capture Def, Thm,techniques', `cycle` = 'collect', `description` = 'Highlight the collected Examples, definitions, theorems, techniques' WHERE (`principle_id` = '4');
UPDATE `project157a`.`learning_principle` SET `method` = 'Focus on Primary Key(s)', `cycle` = 'process', `description` = 'Just because they stated facts & concept images does not mean you know it! ' WHERE (`principle_id` = '6');
UPDATE `project157a`.`learning_principle` SET `method` = 'Intentional Clue-buster', `description` = 'What clues did you hear that indicate this is important?' WHERE (`principle_id` = '5');
UPDATE `project157a`.`learning_principle` SET `method` = 'Understand the logic', `cycle` = 'process', `description` = 'Practice component skills step by step, integrate these skills into own understanding of content' WHERE (`principle_id` = '7');
UPDATE `project157a`.`learning_principle` SET `method` = 'Did you review lecture within 20 hours', `description` = 'Resist those distractions during this review!' WHERE (`principle_id` = '8');
UPDATE `project157a`.`learning_principle` SET `method` = 'Fill in missing details', `cycle` = 'process', `description` = 'Translate ideas into your own words, diagrams, and identify the significance ' WHERE (`principle_id` = '9');
UPDATE `project157a`.`learning_principle` SET `method` = 'Ask “what did I learn” when not looking at this 2nd draft of notes', `description` = 'Develop a habit of testing yourself and asking yourself questions as you process your notes' WHERE (`principle_id` = '10');
UPDATE `project157a`.`learning_principle` SET `method` = 'Ask “why is it important to collect and process”', `description` = 'This is hella time consuming and challenging, but will provide long term value' WHERE (`principle_id` = '11');
UPDATE `project157a`.`learning_principle` SET `method` = 'Ask “where I can improve on my collection and processing steps”', `description` = 'Condensing your notes in stages is a hard habit, but 1 that will condition a stronger brain!' WHERE (`principle_id` = '12');
UPDATE `project157a`.`learning_principle` SET `method` = 'Ask “how free of distractions was I during my study time”', `cycle` = 'reflect', `description` = 'Do not fracture your intellectual work' WHERE (`principle_id` = '13');
UPDATE `project157a`.`learning_principle` SET `method` = 'Ask “how do I make what I’m consuming, useful to my future self”', `description` = 'Content and Context with a birds eye view of the exams and beyond the class is key' WHERE (`principle_id` = '14');
UPDATE `project157a`.`learning_principle` SET `cycle` = 'Reflect', `description` = 'This is where you can expand on the ideas you process by connecting them with others. ' WHERE (`principle_id` = '15');

