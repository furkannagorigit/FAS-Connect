import React, { useState } from 'react';
import axios from 'axios';
import * as XLSX from 'xlsx'; 
function AddUsers() {
    const [jsonResult, setJsonResult] = useState(null);

    const handleFileChange = async (e) => {
        const file = e.target.files[0];

        if (file) {
            try {
                const reader = new FileReader();
                reader.onload = (event) => {
                    const data = new Uint8Array(event.target.result);
                    const workbook = XLSX.read(data, { type: 'array', cellDates: true });

                    const sheetName = workbook.SheetNames[0];
                    const sheet = workbook.Sheets[sheetName];
                    const jsonResult = XLSX.utils.sheet_to_json(sheet, { raw: false });

                    setJsonResult(jsonResult);
                    if (jsonResult) {

                        const transformedData = jsonResult.map(student => ({
                            rollNo: student.rollNo,
                            user: {
                              firstName: student.firstName,
                              lastName: student.lastName,
                              dateOfBirth: student.dateOfBirth,
                              gender: student.gender,
                              role: student.role,
                              mobile: student.mobile,
                              email: student.email,
                              password: student.password
                            }
                          }));

                        axios.post('http://localhost:7070/users/addStudents/1', transformedData)
                            .then(response => {
                                console.log('Response from server:', response.data);
                            })
                            .catch(error => {
                                console.error('Error sending POST request:', error);
                            });
                    }
                };

                reader.readAsArrayBuffer(file);
            } catch (error) {
                console.error('Error converting the file to JSON:', error);
            }
            
        }
    };

    return (
        <div className="col-md-7" style={{ flex: '1' }}>

            <div className="col-md-6" style={{ flex: '1' }}>

                <h1>Add Students file</h1>
                <input type="file" accept=".ods" onChange={handleFileChange} />
               
            </div>
            <h1>Add Faculty</h1>
                    
                    <button type="button" class="btn btn-primary">Add Faculty</button>
                    
                    
        </div>
    );
}

export default AddUsers;