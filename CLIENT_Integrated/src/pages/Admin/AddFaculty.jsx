import React, { useState } from 'react';
import axios from 'axios';
import { createUrl } from '../../Utils/utils';
import { toast } from 'react-toastify';

function AddFaculty() {
  const [facultyData, setFacultyData] = useState({
    facultyId: 'dummy', // Default faculty ID
    user: {
      firstName: '',
      lastName: '',
      dateOfBirth: '',
      gender: '',
      role: 'FACULTY',
      mobile: '',
      email: '',
      password: '',
    },
  });

  const handleSubmit = async (e) => {
    e.preventDefault();

    const { firstName, lastName, dateOfBirth, gender, mobile, email, password } = facultyData.user;

  if (!firstName) {
    toast.error('First Name is required');
    return;
  }

  if (!lastName) {
    toast.error('Last Name is required');
    return;
  }

  if (!dateOfBirth) {
    toast.error('Date of Birth is required');
    return;
  }

  if (!gender) {
    toast.error('Gender is required');
    return;
  }

  if (!mobile) {
    toast.error('Mobile is required');
    return;
  } else if (mobile.length !== 10 || !/^\d+$/.test(mobile)) {
    toast.error('Mobile must be a 10-digit number');
    return;
  }

  if (!email) {
    toast.error('Email is required');
    return;
  } else if (!/^\S+@\S+\.\S+$/.test(email)) {
    toast.error('Invalid email format');
    return;
  }

  if (!password) {
    toast.error('Password is required');
    return;
  }

    try {
        const url = createUrl('/users/addFaculty')
      const response = await axios.post(url, facultyData);
      console.log('Faculty added:', response.data);
      toast.success('faculty added successfully')
      // Reset the form after successful submission
      setFacultyData({
        facultyId: 'dummy',
        user: {
          firstName: '',
          lastName: '',
          dateOfBirth: '',
          gender: '',
          role: 'FACULTY',
          mobile: '',
          email: '',
          password: '',
        },
      });
    } catch (error) {
        toast.error('Something went wrong')
      console.error('Error adding faculty:', error);
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFacultyData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleUserChange = (e) => {
    const { name, value } = e.target;
    setFacultyData((prevData) => ({
      ...prevData,
      user: {
        ...prevData.user,
        [name]: value,
      },
    }));
  };

  return (
    <div className="col-md-7 scrollable" style={{ flex: '1' }}>
          
            <h1>Add Faculty</h1>
            <hr></hr>
    <div className="col-md-12 container">
      <form onSubmit={handleSubmit}>
        
        <div className="form-group">
          <label>First Name:</label>
          <input
            type="text"
            name="firstName"
            value={facultyData.user.firstName}
            onChange={handleUserChange}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label>Last Name:</label>
          <input
            type="text"
            name="lastName"
            value={facultyData.user.lastName}
            onChange={handleUserChange}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label>Date of Birth:</label>
          <input
            type="date"
            name="dateOfBirth"
            value={facultyData.user.dateOfBirth}
            onChange={handleUserChange}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label>Gender:</label>
          <select
            name="gender"
            value={facultyData.user.gender}
            onChange={handleUserChange}
            className="form-control"
          >
            <option value="">Select</option>
            <option value="MALE">Male</option>
            <option value="FEMALE">Female</option>
            <option value="OTHER">Other</option>
          </select>
        </div>
        <div className="form-group">
          <label>Mobile:</label>
          <input
            type="text"
            name="mobile"
            value={facultyData.user.mobile}
            onChange={handleUserChange}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label>Email:</label>
          <input
            type="email"
            name="email"
            value={facultyData.user.email}
            onChange={handleUserChange}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label>Password:</label>
          <input
            type="password"
            name="password"
            value={facultyData.user.password}
            onChange={handleUserChange}
            className="form-control"
          />
        </div>
        <button type="submit" className="btn btn-primary">Add Faculty</button>
      </form>
    </div>
    </div>
  );
}

export default AddFaculty;
