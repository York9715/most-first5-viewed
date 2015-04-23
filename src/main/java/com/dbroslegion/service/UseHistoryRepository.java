package com.dbroslegion.service;


import java.util.List;
import com.dbroslegion.models.*;

public interface UseHistoryRepository {
    List<Product> findMostViewed5th();
}
