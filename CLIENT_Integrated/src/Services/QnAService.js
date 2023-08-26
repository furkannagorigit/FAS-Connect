import React, { useState } from "react";
import axios from "axios";
import { createUrl, log } from "../Utils/utils";

const bearerToken = sessionStorage.getItem("jwt");

export async function AddQnA(userId, requestData)  {
    console.log(userId, requestData)
    const url = createUrl(`/api/qnas/addQnA/${userId}`)
    console.log("url: ", url)
  try {
    const response = await axios.post(url,
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

export async function getAllQnAs(){
  const url = createUrl('/api/qnas')
  try{
      const response = await axios.get(url,
          {
          headers: {
            Authorization: `Bearer ${bearerToken}`
          }})
      log(response)
      return response
  }catch (ex){
      log(ex)
      return "null"
  }
}

export async function addAnswer(qnaId, ansData){
  const url = createUrl(`/api/qnas/addAnswer/${qnaId}`)
  try{
    const response = await axios.patch(url, ansData, {
        headers: {
          Authorization: `Bearer ${bearerToken}`
        }
      })
    log(response)
    return response
  }catch (ex){
    log(ex)
    return "null"
  }
}

export async function commentQnA(requestData)  {
  console.log("requestData: ",requestData)
  try {
    const response = await axios.post(
      "http://localhost:7070/api/qnas/commentQnA/comment",
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