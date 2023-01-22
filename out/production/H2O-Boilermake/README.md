# WaterLog

## About the App
WaterLog is an application that strives to increase awareness on water consumption and the water crisis. It includes a 
quiz, which takes in inputs from the user regarding their average water consumption and provides personalized 
information on their weekly average water usage and the drought status in their county. Users create an account using 
a unique username and password and input other information, including email, state, and county.

## Features of the App
<<<<<<< HEAD


=======
>>>>>>> ae340da312c1c63ba1d49aa1199d017c35a6cfe4
### Password Hash
In an attempt to keep passwords somewhat confidential, we convert inputted passwords to a hash and store the hash 
instead of the password itself. We also use the hash for logging in instead of the actual password. The hash of the 
inputted password and the hash of the stored password have to match in order for the user to log in successfully.

### Personalized Drought Status
We used the "United States Droughts by County" dataset on Kaggle, which is linked in the Research Resources section. 
We filtered the dataset for the user based on year, state, and county in order to retrieve most recent drought 
information of the user's county. According to the county's drought status, the user is given an estimate of how 
much water user's should be using weekly to help the growing water crisis.

### Total Water Usage per Week
We used the 


## Research Resources
"United States Droughts by County" dataset on Kaggle:
https://www.kaggle.com/datasets/us-drought-monitor/united-states-droughts-by-county?resource=download&select=us-droughts.csv

"How We Use Water" on 
