const nodemailer = require("nodemailer")


const sendMail = (email, name)=>{
    const transport = nodemailer.createTransport({
        service:"gmail",
        auth:{
            user:"<your-emai-goes-here>",
            pass:"<your-app-passcode-goes-here>"
        }
    })

    const verificationLink = "http://localhost:5252/verify-email?token=123456";
    
    const mail =({
        from:"<your-email-goes-here>",
        to:email,
        subject:"Email Verification",
        html:`
        <body style="font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4; color: #333;">
    <div style="width: 100%; padding: 20px; text-align: center;">
        <div style="background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); max-width: 600px; margin: 0 auto;">
            <div style="font-size: 24px; font-weight: bold; color: #2c3e50; margin-bottom: 20px;">
                Dear ${name},
            </div>
            <div style="font-size: 16px; line-height: 1.6; color: #555;">
                Your account has been created successfully.<br><br>
                Please click on this link to verify your account: <br>
                <a href=${verificationLink} style="display: inline-block; background-color: #3498db; color: #ffffff; padding: 12px 24px; text-decoration: none; font-size: 16px; border-radius: 4px; margin-top: 20px;">Verify Account</a>
            </div>
            <div style="font-size: 14px; color: #999; margin-top: 30px;">
                Thanks & Regards,<br>
                Team Sec-B
            </div>
        </div>
    </div>
</body>`
    }) 
    
    transport.sendMail(mail,(err)=>{
        if(err){
            console.log("Email not sent ",err)
        }else{
            console.log("Email sent Success")
        }
    })
}

sendMail("piebytwo014@gmail.com", "Vivek")