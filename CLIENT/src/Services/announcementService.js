import React, { useState } from "react";
import axios from "axios";

  
const bearerToken = sessionStorage.getItem("jwt");



export async function AddAnnouncement(userId, requestData)  {
  try {
    const response = await axios.post(
      `http://localhost:7070/api/announcements/addAnnouncement/${userId}`,
      requestData,
      {
        headers: {
          Authorization: `Bearer ${bearerToken}`
        }
      }
    );
    return response;

  } catch (error) {
    // Handle error
    return "null";
  }

};

export async function getAnnouncements()  {
  try {
    const response = await axios.get(
      "http://localhost:7070/api/announcements",
      {
        headers: {
          Authorization: `Bearer ${bearerToken}`
        }
      }
    );
    return response;

  } catch (error) {
    // Handle error
    return "null";
  }

};







