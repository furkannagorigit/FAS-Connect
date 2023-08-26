import axios from 'axios';
import { createUrl } from '../Utils/utils';
import { log } from '../Utils/utils';
const bearerToken = sessionStorage.getItem("jwt");


export async function getFeeds(page,pageSize)  {
  try {
    const response = await axios.get(
      "http://localhost:7070/feeds",
      {
        params: {
          page: page,
          size: pageSize
        },
        headers: {
          Authorization: `Bearer ${bearerToken}`
        }
      }
    );
    console.log(response)
    return response;

  } catch (error) {
    // Handle error
    return "null";
  }

};


export async function AddFeed(userId,formData) {
  try {
    
    const response = await axios.post(
      `http://localhost:7070/feeds/upload/${userId}`,
      formData,
      {
        headers: {
          Authorization: `Bearer ${bearerToken}`,
          "Content-Type": "multipart/form-data",

        },
        // Send formData as the request data

      }
    );

    return response;

  } catch (error) {
    // Handle error
    return "null";
  }

};

export async function likeFeed(requestData)  {
  try {
    const response = await axios.post(
      "http://localhost:7070/feeds/like",
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

export async function unlikeFeed(requestData)  {
  try {
    const response = await axios.post(
      "http://localhost:7070/feeds/dislike",
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

export async function commentFeed(requestData)  {
  try {
    const response = await axios.post(
      "http://localhost:7070/feeds/comment",
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