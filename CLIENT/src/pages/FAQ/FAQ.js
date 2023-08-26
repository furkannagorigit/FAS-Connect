import React from 'react';
import "./FAQ.css";

const FAQ = () => {
  const faqData = [
    {
      question: 'What is the course duration?',
      answer: 'The course duration is 6 months.',
    },
    {
      question: 'Who are the instructors?',
      answer: 'The course is taught by experienced faculty members.',
    },
    {
      question: 'Is there any prerequisite for the course?',
      answer: 'No, there are no prerequisites for this course.',
    },
    // Add more FAQ items as needed
  ];

  return (
    <div className="col-md-7" style={{ flex: '1' }}>
      <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
      <div className="container" style={{ flex: '1' }}>
        <div className="row">
          <div id="content">
            <div className="container mt-5">
              <h2>Frequently Asked Questions</h2>
              <div className="faq-list">
                {faqData.map((item, index) => (
                  <div className="faq-item" key={index}>
                    <h5 className="faq-question">{item.question}</h5>
                    <p className="faq-answer">{item.answer}</p>
                  </div>
                ))}
              </div>
            </div>
          </div>
        </div>
      </div>
      <div className="contact-section-container">
        <div className="content contact-section">
          <div>
            <div className="contact-content">
              <h1>Contact Institute</h1>
              <p>Feel free to get in touch with your Institute</p>
            </div>
            <div className="contact-details">
              <div className="contact-detail">
                <i className="fas fa-user"></i>
                <div className="contact-info">
                  <span className="contact-label">Email:</span>
                  <a href="mailto:Institute@example.com">Institute@example.com</a>
                </div>
                <div className="contact-info">
                  <span className="contact-label">Number:</span>
                  <span>0123456789</span>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div className="content contact-section">
          <div >
            <div className="contact-content">
              <h1>Contact Us</h1>
              <p>Feel free to get in touch with us...</p>
            </div>
            <div className="contact-details">
              <div className="contact-detail">
                <i className="fas fa-user"></i>
                <div className="contact-info">
                  <span className="contact-label">Email:</span>
                  <a href="mailto:fas.connect3@gmail.com">fas.connect3@gmail.com</a>
                </div>
                <div className="contact-info">
                  <span className="contact-label">GitHub:</span>
                  <a href="https://github.com/FAS-Connect/FAS-Connect">GitHub Profile</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default FAQ;
