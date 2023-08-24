import axios from 'axios';
import { createUrl } from '../Utils/utils';
import { log } from '../Utils/utils';
const bearerToken = sessionStorage.getItem("jwt");


export async function getAllFeed() {
  const url = createUrl('/feed')

  try {
    const response = await axios.get(url)
    console.log(response.data)
    return response.data
  } catch (ex) {
    console.log(ex)
    return null
  }
}
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