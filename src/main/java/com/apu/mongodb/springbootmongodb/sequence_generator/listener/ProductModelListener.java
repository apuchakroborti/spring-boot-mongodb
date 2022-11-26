package com.apu.mongodb.springbootmongodb.sequence_generator.listener;


import com.apu.mongodb.springbootmongodb.model.Product;
import com.apu.mongodb.springbootmongodb.sequence_generator.ISequenceGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class ProductModelListener extends AbstractMongoEventListener<Product> {
    private static final Logger logger = LoggerFactory.getLogger(ProductModelListener.class);

    private ISequenceGeneratorService sequenceGenerator;

    @Autowired
    public ProductModelListener(ISequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Product> event) {
        try {
            event.getSource().setId(sequenceGenerator.generateSequence(Product.SEQUENCE_NAME));
        } catch (InterruptedException | ExecutionException e) {
            logger.error("Error:{}", e.getMessage());
        }
    }
}