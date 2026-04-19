# 🤖 AI Chatbot Backend (Java)

🚀 This project demonstrates how to build an AI Chatbot using **Google Gemini (Model: gemini-3-flash-preview)** in a Java application.

---

## 🌿 Branches

This project contains **two separate implementations in different branches**:

- 🔹 **resttemplate** → Uses RestTemplate (manual API integration)  
- 🔹 **sdk** → Uses Google Gemini SDK (simplified integration)  

👉 You can switch between branches to understand both approaches.

---

## 🚀 Build AI Chatbot (Using RestTemplate)

### 1️⃣ User Input  
We take input from the user (`userMessage`).

---

### 2️⃣ Calling External API  
Use **RestTemplate** to call the Google Gemini API.

**Required:**
- API Key  
- Endpoint URL  

---

### 3️⃣ Convert Message to JSON  
The API expects data in JSON format.  
So we convert `userMessage` into a structured JSON request body.

---

### 4️⃣ HttpHeaders  
Used to send metadata about the request.

Example:

Content-Type: application/json


👉 Tells the API the format of data being sent.

---

### 5️⃣ HttpEntity  
Combines:
- Request Body (JSON)  
- Headers  

👉 Acts as a single request packet sent to the API.

---

### 6️⃣ Sending Request  

ResponseEntity<String> response =
restTemplate.postForEntity(url, entity, String.class);


- `url` → API endpoint  
- `entity` → request body + headers  
- `String.class` → expected response type  

---

### 7️⃣ Getting Response  

response.getBody();


👉 Returns raw JSON response from the API.

---

### 8️⃣ Extract Required Data (ObjectMapper)  
We use ObjectMapper to extract only required data (text).

- ❌ Full JSON response  
- ✅ Clean readable AI text  

---

## 🔥 Final Flow


User → Controller → Service → RestTemplate → Gemini API
↓
JSON Response
↓
ObjectMapper extracts text
↓
Return to User


---

## ⚡ Using SDK (Software Development Kit) – Google Gemini

### 1️⃣ Add Dependency  
Add Google Gemini SDK dependency.

---

### 2️⃣ Create Client Object  
The client automatically reads API key from environment variable.

👉 **Environment variable name must be:**

GOOGLE_API_KEY


---

### 3️⃣ Generate Content Response  


GenerateContentResponse response = client.models.generateContent(
"gemini-3-flash-preview",
userMessage,
config
);


**Pass:**
- model  
- user message  
- config (optional → pass null if not required)

---

### 4️⃣ Configuration (Optional)

- `temperature` → range **0 to 1**
  - `0` → predictable output  
  - `1` → creative/random output  

- `maxOutputTokens` → controls response length  

---

### 5️⃣ Get Response Text  


response.text();


👉 Returns only the **text output** from the model

---

## 🎯 Simple Summary

- Set API key → `GOOGLE_API_KEY`  
- Create client  
- Call generate content  
- Use config if needed  
- Get output using `response.text()`  

---

## 🛠️ Tech Stack

- Java  
- Spring Boot  
- RestTemplate  
- Google Gemini API  
- JSON (ObjectMapper)  
- Maven  

---

## 📌 Features

- AI Chatbot Backend  
- Two approaches (REST & SDK)  
- Clean architecture  
- Beginner-friendly  

---

## 👨‍💻 Author

**Srinivas Dappu**  
📞 +91-6303666197  
🔗 https://www.linkedin.com/in/dappusrinivas/
