import React, { useState, useRef } from "react";
import { useHistory } from "react-router-dom/cjs/react-router-dom";
import "../Admin/AddStudent.css";
import { createUrl } from "../../Utils/utils";
import axios from "axios";
import * as XLSX from "xlsx";
import { toast } from "react-toastify";

function CourseCard(props) {
  const [isFileSelected, setIsFileSelected] = useState(false);
  const fileInputRef = useRef(null);

  const bearerToken = sessionStorage.getItem("jwt");

  const handleSubmit = async () => {
    const file = fileInputRef.current.files[0];

    if (file) {
      try {
        const reader = new FileReader();
        reader.onload = (event) => {
          const data = new Uint8Array(event.target.result);
          const workbook = XLSX.read(data, { type: "array", cellDates: true });

          const sheetName = workbook.SheetNames[0];
          const sheet = workbook.Sheets[sheetName];
          const jsonResult = XLSX.utils.sheet_to_json(sheet, { raw: false });

          if (jsonResult) {
            const transformedData = jsonResult.map((student) => ({
              rollNo: student.rollNo,
              user: {
                firstName: student.firstName,
                lastName: student.lastName,
                dateOfBirth: student.dateOfBirth,
                gender: student.gender,
                role: student.role,
                mobile: student.mobile,
                email: student.email,
                password: student.password,
              },
            }));

            const url = createUrl(`/users/addStudents/${props.course.id}`);
            axios
              .post(url, transformedData, {
                headers: {
                  Authorization: `Bearer ${bearerToken}`
                }})
              .then((response) => {
                console.log("Response from server:", response.data);
                toast.success("Students added to: ",props.course.courseName)
              })
              .catch((error) => {
                console.error("Error sending POST request:", error);
                toast.error("Could not add students to: ", props.course.courseName)
              });
          }
        };

        reader.readAsArrayBuffer(file);
      } catch (error) {
        console.error("Error converting the file to JSON:", error);
      }
    }
  };

  return (
    <>
      <div className="col-md-4" >
        <div className="card">
          <center>
            <img
              src={
                process.env.PUBLIC_URL +
                "/data/CourseImages/" +
                props.course.courseName +
                ".png"
              }
              style={{ height: 100 }}
              alt="course image"
            />
          </center>
          <div className="card-body">
            <h3 className="card-title">{props.course.courseName}</h3>
            <div className="card-text" style={{ height: 100 }}>
              <h5>{props.course.courseDetails}</h5>
            </div>
            <input
              type="file"
              accept=".ods"
              id="fileInput"
              ref={fileInputRef}
              onChange={() => setIsFileSelected(true)}
            />
            {isFileSelected && (
              <button className="btn btn-primary" type="button" onClick={handleSubmit}>
                Submit
              </button>
            )}
          </div>
        </div>
      </div>
    </>
  );
}

export default CourseCard;
