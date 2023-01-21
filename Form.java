public class Form {
    private String email;
    private String location;

    public Form(String email, String location) {
        this.email = email;
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    //bath - direct in Server
    //shower
    public String showerCalc(int showerDur) {
        // 2.5 gallons per minute
        double min;
        double max;
        String range = "";
        switch(showerDur) {
            case 1:
                // 0-10 mins
                min = 0;
                max = 2.5 * 10;
                range = String.format(min + "-" + max);
                break;
            case 2:
                // 11-20 mins
                min = 2.5 * 11;
                max = 2.5 * 20;
                range = String.format(min + "-" + max);
                break;
            case 3:
                // 21+ mins
                min = 2.5 * 21;
                max = 2.5 * 21;
                range = String.format(min + "-" + max);
                break;
        }
        return range;
    }
    //teeth
    public String teethCalc(int teeth) {
        // 0.25 gallons per brush
        double gal;
        String range = "";
        switch(teeth) {
            case 1:
                // 1 time
                gal = 0.25 * 1;
                range = String.format(gal + "-gallons");
                break;
            case 2:
                // 2 times
                gal = 0.25 * 2;
                range = String.format(gal + "-gallons");
                break;
            case 3:
                // 3+ times
                gal = 0.25 * 3;
                range = String.format(gal + "-gallons");
                break;
        }
        return range;
    }
    //toilet
    public String toiletCalc(int toilet) {
        // 1.6 gallons per flush
        double min;
        double max;
        String range = "";
        switch(toilet) {
            case 1:
                // 0-2 times
                min = 0;
                max = 1.6 * 2;
                range = String.format(min + "-" + max);
                break;
            case 2:
                // 3-6 times
                min = 1.6 * 3;
                max = 1.6 * 6;
                range = String.format(min + "-" + max);
                break;
            case 3:
                // 7+ times
                min = 1.6 * 7;
                max = 1.6 * 7;
                range = String.format(min + "-" + max);
                break;
        }
        return range;
    }
    //hands
    public String handsCalc(int hands) {
        // 0.75 gallons per wash (20 secs)
        double min;
        double max;
        String range = "";
        switch(hands) {
            case 1:
                // 0-4 times
                min = 0;
                max = 0.75 * 4;
                range = String.format(min + "-" + max);
                break;
            case 2:
                // 5-10 times
                min = 0.75 * 5;
                max = 0.75 * 10;
                range = String.format(min + "-" + max);
                break;
            case 3:
                // 11+ times
                min = 0.75 * 11;
                max = 0.75 * 11;
                range = String.format(min + "-" + max);
                break;
        }
        return range;
    }
    //clothes
    public String clothesCalc(int clothes) {
        // 19 gallons per load
        double min;
        double max;
        String range = "";
        switch(clothes) {
            case 1:
                // 0-1 times
                min = 0;
                max = 19 * 1;
                range = String.format(min + "-" + max);
                break;
            case 2:
                // 2-4 times
                min = 19 * 2;
                max = 19 * 4;
                range = String.format(min + "-" + max);
                break;
            case 3:
                // 5+ times
                min = 19 * 5;
                max = 19 * 5;
                range = String.format(min + "-" + max);
                break;
        }
        return range;
    }
    //cook
    public String cookCalc(int cook) {
        // 0.25 gallons per meal
        double min;
        double max;
        String range = "";
        switch(cook) {
            case 1:
                // 0-4 times
                min = 0;
                max = 0.25 * 4;
                range = String.format(min + "-" + max);
                break;
            case 2:
                // 5-10 times
                min = 0.25 * 5;
                max = 0.25 * 10;
                range = String.format(min + "-" + max);
                break;
            case 3:
                // 11+ times
                min = 0.25 * 11;
                max = 0.25 * 11;
                range = String.format(min + "-" + max);
                break;
        }
        return range;
    }
    //dishwasher
    public String dishwasherCalc(int dishwash) {
        // 4 gallons per load
        double min;
        double max;
        String range = "";
        switch(dishwash) {
            case 1:
                // 0-4 times
                min = 0;
                max = 4 * 4;
                range = String.format(min + "-" + max);
                break;
            case 2:
                // 5-10 times
                min = 4 * 5;
                max = 4 * 10;
                range = String.format(min + "-" + max);
                break;
            case 3:
                // 11+ times
                min = 4 * 11;
                max = 4 * 11;
                range = String.format(min + "-" + max);
                break;
        }
        return range;
    }
    //dishes by hand
    public String dishesHandCalc(int handwash) {
        // 27 gallons per load
        double min;
        double max;
        String range = "";
        switch(handwash) {
            case 1:
                // 0-4 times
                min = 0;
                max = 27 * 4;
                range = String.format(min + "-" + max);
                break;
            case 2:
                // 5-10 times
                min = 27 * 5;
                max = 27 * 10;
                range = String.format(min + "-" + max);
                break;
            case 3:
                // 11+ times
                min = 27 * 11;
                max = 27 * 11;
                range = String.format(min + "-" + max);
                break;
        }
        return range;
    }
    //watering can
    public String waterCanCalc(int watercan) {
        // 50 gallons per day
        double min;
        double max;
        String range = "";
        switch(watercan) {
            case 1:
                // 0-2 times
                min = 0;
                max = 50 * 2;
                range = String.format(min + "-" + max);
                break;
            case 2:
                // 3-5 times
                min = 50 * 3;
                max = 50 * 5;
                range = String.format(min + "-" + max);
                break;
            case 3:
                // 6+ times
                min = 50 * 6;
                max = 50 * 6;
                range = String.format(min + "-" + max);
                break;
        }
        return range;
    }
    //sprinklers
    public String sprinklersCalc(int sprinkle) {
        // 2000 gallons over 3 hours
        double min;
        double max;
        String range = "";
        switch(sprinkle) {
            case 1:
                // 0-2 times
                min = 0;
                max = 2000 * 2;
                range = String.format(min + "-" + max);
                break;
            case 2:
                // 3-5 times
                min = 2000 * 3;
                max = 2000 * 5;
                range = String.format(min + "-" + max);
                break;
            case 3:
                // 6+ times
                min = 2000 * 6;
                max = 2000 * 6;
                range = String.format(min + "-" + max);
                break;
        }
        return range;
    }

    //total consumption
    public String totalConsumptionWithPlant(int showerDur, int teeth, int toilet, int washHands, int clothes, int cook,
                                 int dishwash, int handwash, int watercan, int sprinkle) {
        double bath = 40.0;
        String s = showerCalc(showerDur);
        double showerMin = Double.parseDouble(s.substring(0, s.indexOf("-")));
        double showerMax = Double.parseDouble(s.substring(s.indexOf("-")));
        String te = teethCalc(teeth);
        double teethVal = Double.parseDouble(te.substring(0, te.indexOf("-")));
        String toi = toiletCalc(toilet);
        double toiletMin = Double.parseDouble(toi.substring(0, toi.indexOf("-")));
        double toiletMax = Double.parseDouble(toi.substring(toi.indexOf("-")));
        String wh = handsCalc(washHands);
        double handWashMin = Double.parseDouble(wh.substring(0, wh.indexOf("-")));
        double handWashMax = Double.parseDouble(wh.substring(wh.indexOf("-")));
        String c = clothesCalc(clothes);
        double clothesMin = Double.parseDouble(c.substring(0, c.indexOf("-")));
        double clothesMax = Double.parseDouble(c.substring(c.indexOf("-")));
        String coo = cookCalc(cook);
        double cookMin = Double.parseDouble(coo.substring(0, coo.indexOf("-")));
        double cookMax = Double.parseDouble(coo.substring(coo.indexOf("-")));
        String dw = dishwasherCalc(dishwash);
        double dishwasherMin = Double.parseDouble(dw.substring(0, dw.indexOf("-")));
        double dishwasherMax = Double.parseDouble(dw.substring(dw.indexOf("-")));
        String hd = dishesHandCalc(handwash);
        double dishHandMin = Double.parseDouble(hd.substring(0, hd.indexOf("-")));
        double dishHandMax = Double.parseDouble(hd.substring(hd.indexOf("-")));
        String wc = waterCanCalc(watercan);
        double waterCanMin = Double.parseDouble(wc.substring(0, wc.indexOf("-")));
        double waterCanMax = Double.parseDouble(wc.substring(wc.indexOf("-")));
        String sp = sprinklersCalc(sprinkle);
        double sprinklerMin = Double.parseDouble(sp.substring(0, sp.indexOf("-")));
        double sprinklerMax = Double.parseDouble(sp.substring(sp.indexOf("-")));

        double mins = bath + showerMin + teethVal + toiletMin + handWashMin + clothesMin + cookMin + dishwasherMin +
                dishHandMin + waterCanMin + sprinklerMin;
        double maxs = bath + showerMax + teethVal + toiletMax + handWashMax + clothesMax + cookMax + dishwasherMax +
                dishHandMax + waterCanMax + sprinklerMax;
        String range = String.format(mins + "-" + maxs);
        return range;
    }

    public String totalConsumptionWOPlant(int showerDur, int teeth, int toilet, int washHands, int clothes, int cook,
                                          int dishwash, int handwash) {
        double bath = 40.0;
        String s = showerCalc(showerDur);
        double showerMin = Double.parseDouble(s.substring(0, s.indexOf("-")));
        double showerMax = Double.parseDouble(s.substring(s.indexOf("-")));
        String te = teethCalc(teeth);
        double teethVal = Double.parseDouble(te.substring(0, te.indexOf("-")));
        String toi = toiletCalc(toilet);
        double toiletMin = Double.parseDouble(toi.substring(0, toi.indexOf("-")));
        double toiletMax = Double.parseDouble(toi.substring(toi.indexOf("-")));
        String wh = handsCalc(washHands);
        double handWashMin = Double.parseDouble(wh.substring(0, wh.indexOf("-")));
        double handWashMax = Double.parseDouble(wh.substring(wh.indexOf("-")));
        String c = clothesCalc(clothes);
        double clothesMin = Double.parseDouble(c.substring(0, c.indexOf("-")));
        double clothesMax = Double.parseDouble(c.substring(c.indexOf("-")));
        String coo = cookCalc(cook);
        double cookMin = Double.parseDouble(coo.substring(0, coo.indexOf("-")));
        double cookMax = Double.parseDouble(coo.substring(coo.indexOf("-")));
        String dw = dishwasherCalc(dishwash);
        double dishwasherMin = Double.parseDouble(dw.substring(0, dw.indexOf("-")));
        double dishwasherMax = Double.parseDouble(dw.substring(dw.indexOf("-")));
        String hd = dishesHandCalc(handwash);
        double dishHandMin = Double.parseDouble(hd.substring(0, hd.indexOf("-")));
        double dishHandMax = Double.parseDouble(hd.substring(hd.indexOf("-")));

        double mins = bath + showerMin + teethVal + toiletMin + handWashMin + clothesMin + cookMin + dishwasherMin +
                dishHandMin;
        double maxs = bath + showerMax + teethVal + toiletMax + handWashMax + clothesMax + cookMax + dishwasherMax +
                dishHandMax;
        String range = String.format(mins + "-" + maxs);
        return range;
    }

    //comparison
    public void compare() {

    }
    //user.getstate
    // range
    // average american family
}
