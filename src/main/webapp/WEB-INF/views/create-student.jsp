<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
  <style>
    /* Styl dla całego formularza */
    form {
      max-width: 400px;
      margin: 0 auto;
      padding: 20px;
      background-color: #f7f7f7;
      border: 1px solid #ccc;
      border-radius: 5px;
    }

    /* Styl dla etykiet (label) */
    label {
      display: block;
      font-weight: bold;
      margin-top: 10px;
    }

    /* Styl dla inputów i textarea */
    input[type="text"],
    textarea {
      width: 100%;
      padding: 10px;
      margin-top: 5px;
      border: 1px solid #ccc;
      border-radius: 3px;
    }

    /* Styl dla radiobuttonów i checkboxów */
    input[type="radio"],
    input[type="checkbox"] {
      margin-right: 5px;
    }

    /* Styl dla przycisku */
    button[type="submit"] {
      background-color: #007bff;
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 3px;
      cursor: pointer;
      margin-top: 10px;
    }

    /* Dodatkowy styl dla listy rozwijanej (select) */
    select {
      width: 100%;
      padding: 10px;
      margin-top: 5px;
      border: 1px solid #ccc;
      border-radius: 3px;
    }

    /* Styl dla checkboxes (dla wielu opcji) */
    .checkbox-group {
      display: flex;
      flex-wrap: wrap;
      margin-top: 5px;
    }

    .checkbox-group label {
      flex: 1;
      margin-right: 10px;
    }

    /* Dodatkowy styl dla textarea */
    textarea {
      height: 100px;
    }

    /* Styl dla wiadomości o błędach */
    .error-message {
      color: #ff0000;
      font-size: 14px;
      margin-top: 5px;
    }
  </style>
</head>
<body>

<form:form method="post" modelAttribute="student">
  <div>
    First Name: <form:input path="firstName" />
  </div>
  <div>
    Last Name: <form:input path="lastName" />
  </div>
  <div>
    Male: <form:radiobutton path="gender" value="M"/>
    Female: <form:radiobutton path="gender" value="F"/>
  </div>
  <div>
    Country: <form:select path="country" items="${countries}"/>
  </div>
  <div>
    Notes: <form:textarea path="notes"/>
  </div>
  <div>
    Mailing list: <form:checkbox path="mailingList"/>
  </div>
  <div>
    Programming skills: <form:select path="programmingSkills" items="${programmingSkills}" multiple="true"/>
  </div>
  <div>
    Hobbies: <form:select path="hobbies" items="${hobbies}" multiple="true"/>
  </div>

  <div>
    <form:button type="submit">Dodaj</form:button>
  </div>
</form:form>

</body>
</html>
