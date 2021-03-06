package com.crud.mongo.sequence;

import java.util.Objects;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SequenceGenerator {
	
	Logger logger = LoggerFactory.getLogger(SequenceGenerator.class);
	
	@Autowired
	private MongoOperations mongoOperations;
	
	@Autowired
	public SequenceGenerator(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}
	
	public long getSequence(String seqName) {
		
		logger.info("Fetching the existing Sequence:---");
		
		DatabaseSequence counter = mongoOperations.findOne(query(where("_id").is(seqName)), 
				DatabaseSequence.class);
		
		return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}
	
	
	public long generateSequence(String seqName) {
		
		logger.info("Generating the new Sequence:---");
		
		DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)), 
				new Update().inc("seq", 1), options().returnNew(true).upsert(true), 
				DatabaseSequence.class);
		
		return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}
	
}
