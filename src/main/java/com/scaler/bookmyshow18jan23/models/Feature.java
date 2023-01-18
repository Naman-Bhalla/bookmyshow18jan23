package com.scaler.bookmyshow18jan23.models;

public enum Feature {
    THREE_D, // 1
    TWO_D,  // 2
    DOLBY, // 3
}

// movie -> |id| name| ....| -> Still there
// features -> | id | value| -> NOT THERE
// movie_feature -> Still there
// 1:m
//  m:1
