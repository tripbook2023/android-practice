package com.example.toyproject1.data

import com.example.toyproject1.data.model.ItemEntity
import com.example.toyproject1.domain.Item

// UI(Domain) <-> Data 간의 Model 데이터 변환

// Data -> Domain 모델로 변환
fun mapperToDomain(itemEntities: List<ItemEntity>): List<Item>{
    return listOf(Item())
}

// Domain -> Data 모델로 변환
fun mapperToData(){

}