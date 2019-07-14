package com.impurityonline.osrs.service.impl;

import com.impurityonline.osrs.client.OsrsClient;
import com.impurityonline.osrs.client.response.OsrsApiItemResponse;
import com.impurityonline.osrs.domain.Item;
import com.impurityonline.osrs.exception.ItemNotFoundException;
import com.impurityonline.osrs.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author impurity
 */
@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private OsrsClient osrsClient;

    @Override
    public Item getItem(Long itemId) {
        ResponseEntity<OsrsApiItemResponse> responseEntity = osrsClient.getItem(itemId);

        OsrsApiItemResponse osrsApiItemResponse = Optional
                .ofNullable(responseEntity.getBody())
                .orElseThrow(() -> new ItemNotFoundException("No item body found"));

        return Optional
                .ofNullable(osrsApiItemResponse.getItem())
                .orElseThrow(() -> new ItemNotFoundException("No item found"));
    }
}
