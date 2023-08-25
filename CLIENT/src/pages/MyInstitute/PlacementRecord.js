import React, { useState, useEffect } from 'react';
import * as XLSX from 'xlsx';
import './ExcelTable.css'; // Import your custom CSS for styling
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend } from 'recharts';

const ExcelTable = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    // Fetch the .ods file data from the public directory
    fetch('/data/Placement_Record.ods')
      .then(response => response.arrayBuffer())
      .then(buffer => {
        const data = new Uint8Array(buffer);
        const workbook = XLSX.read(data, { type: 'array' });
        const sheet = workbook.Sheets[workbook.SheetNames[0]]; // Assuming the data is in the first sheet
        const sheetData = XLSX.utils.sheet_to_json(sheet, { header: 1 });
        setData(sheetData);
      })
      .catch(error => {
        console.error('Error loading .ods file:', error);
      });
  }, []);

  const createBarChart = () => {
    if (data.length === 0) {
      return null;
    }

    // Get the column names (excluding the first column)
    const columnNames = data[0].slice(1);

    // Create the grouped bar chart data for the first 5 rows
    const chartData = data.slice(1, 6).map((row, rowIndex) => {
      const rowData = { name: row[0] }; // Use the first column's value as the name
      columnNames.forEach((columnName, columnIndex) => {
        rowData[columnName] = row[columnIndex + 1]; // Skip the first column (name)
      });
      return rowData;
    });

    return (
      <BarChart width={600} height={300} data={chartData} margin={{ top: 20, right: 30, left: 20, bottom: 5 }}>
        <CartesianGrid strokeDasharray="3 3" />
        <XAxis dataKey="name" />
        <YAxis />
        <Tooltip />
        <Legend />
        {columnNames.map((columnName, index) => (
          <Bar key={`bar-${columnName}`} dataKey={columnName} fill={`#${Math.floor(Math.random() * 16777215).toString(16)}`} />
        ))}
      </BarChart>
    );
  };

  return (
    <div className="excel-table-container">
    <h1>Placement Records of last 4 Batch</h1>
         {createBarChart()}
      <h1>Placement Records till date</h1>
      <table className="excel-table">
        <thead>
          <tr>
            {data[0] && data[0].map((header, index) => <th key={index}>{header}</th>)}
          </tr>
        </thead>
        <tbody>
          {data.slice(1).map((row, rowIndex) => (
            <tr key={rowIndex}>
              {row.map((cell, cellIndex) => (
                <td key={cellIndex}>{cell}</td>
              ))}
            </tr>
          ))}
        </tbody>
      </table>
     
    </div>
  );
};

export default ExcelTable;
