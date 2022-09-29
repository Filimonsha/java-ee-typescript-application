package com.example.itmoweb2.utility.responseUtility;

import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public interface ResponseHandler<T> {
    public void returnOneEntity(Optional<T> returnedSubject, PrintWriter returningPrintWriter);
    public void returnAllEntity(List<T> returnedSubjectList, PrintWriter returningPrintWriter);
}
