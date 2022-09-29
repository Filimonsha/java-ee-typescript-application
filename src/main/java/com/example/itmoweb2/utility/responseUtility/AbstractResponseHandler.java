package com.example.itmoweb2.utility.responseUtility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public class AbstractResponseHandler<T> implements ResponseHandler<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    protected Class<T> returnedSubjectClass;

    public AbstractResponseHandler(Class<T> returnedSubjectClass){
        this.returnedSubjectClass = returnedSubjectClass;
    }

    @Override
    public void returnOneEntity(Optional<T> returnedSubject, PrintWriter returningPrintWriter) {
        if (returnedSubject.isPresent()) {
            try {
                objectMapper.writeValue(returningPrintWriter, returnedSubject.get());
                returningPrintWriter.print(objectMapper.writeValueAsString(returnedSubject.get()));
                System.out.println("Отправляемые данные: " + objectMapper.writeValueAsString(returnedSubject.get()));
                returningPrintWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void returnAllEntity(List<T> returnedSubjectList, PrintWriter returningPrintWriter) {
        try {
            objectMapper.writeValue(returningPrintWriter, returnedSubjectList);
            returningPrintWriter.print(objectMapper.writeValueAsString(returnedSubjectList));
            System.out.println("Отправляемые данные: " + objectMapper.writeValueAsString(returnedSubjectList));
            returningPrintWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
