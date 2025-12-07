let userName = "Sampath";
let age = "34";
let isSubscribed = "true";

//for validation

function validateForm(){
    let userNameType = typeof userName;
    let ageType = typeof age;
    let isSubscribedType = typeof isSubscribed;

    console.log("Username: " + userName + "DataType ", userNameType);
    console.log("Age: " + age + "DataType ", ageType);
    console.log("isSubsribed: " + isSubscribed + "DataType ", isSubscribedType);
    
    //conversion
    age = Number(age);
    isSubscribed = isSubscribed ==="true";

    console.log("Age: " + age + "After conversion the Data Type is " , typeof age);
    console.log("isSubscribed: " + isSubscribed + "Data Type " , typeof isSubscribed);

}
validateForm(userName, age, isSubscribed);


