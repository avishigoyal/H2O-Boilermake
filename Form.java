import java.io.File;

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
    public static String bathShowerCalc(String bs, String showerDur) {
        // 2.5 gallons per minute
        double min;
        double max;
        String range = "";
        if (bs.equals("1")) {
            min = 40.0;
            max = 40.0;
            range = String.format(min + "-" + max);
        } else if (bs.equals("2")) {
            if (showerDur.equals("1")) {
                // 0-10 mins
                min = 0;
                max = 2.5 * 10 * 7;
                range = String.format(min + "-" + max);
            } else if (showerDur.equals("2")) {
                // 11-20 mins
                min = 2.5 * 11 * 7;
                max = 2.5 * 20 * 7;
                range = String.format(min + "-" + max);
            } else if (showerDur.equals("3")) {
                // 21+ mins
                min = 2.5 * 21 * 7;
                max = 2.5 * 21 * 7;
                range = String.format(min + "-" + max);
            }
        }
        return range;
    }
    //teeth
    public static String teethCalc(String teeth) {
        // 0.25 gallons per brush
        double gal;
        String range = "";
        if (teeth.equals("1")) {
            // 1 time
            gal = 0.25 * 1 * 7;
            range = String.format(gal + "-gallons");
        } else if (teeth.equals("2")) {
            // 2 times
            gal = 0.25 * 2 * 7;
            range = String.format(gal + "-gallons");
        } else if (teeth.equals("3")) {
            // 7+ times
            gal = 0.25 * 3 * 7;
            range = String.format(gal + "-gallons");
        }

        return range;
    }
    //toilet
    public static String toiletCalc(String toilet) {
        // 1.6 gallons per flush
        double min;
        double max;
        String range = "";
        if (toilet.equals("1")) {
            // 0-2 times
            min = 0;
            max = 1.6 * 2 * 7;
            range = String.format(min + "-" + max);
        } else if (toilet.equals("2")) {
            // 3-6 times
            min = 1.6 * 3 * 7;
            max = 1.6 * 6 * 7;
            range = String.format(min + "-" + max);
        } else if (toilet.equals("3")) {
            // 7+ times
            min = 1.6 * 7 * 7;
            max = 1.6 * 7 * 7;
            range = String.format(min + "-" + max);
        }

        return range;
    }
    //hands
    public static String handsCalc(String hands) {
        // 0.75 gallons per wash (20 secs)
        double min;
        double max;
        String range = "";
        if (hands.equals("1")) {
            // 0-4 times
            min = 0;
            max = 0.75 * 4 * 7;
            range = String.format(min + "-" + max);
        } else if (hands.equals("2")) {
            // 5-10 times
            min = 0.75 * 5 * 7;
            max = 0.75 * 10 * 7;
            range = String.format(min + "-" + max);
        } else if (hands.equals("3")) {
            // 11+ times
            min = 0.75 * 11 * 7;
            max = 0.75 * 11 * 7;
            range = String.format(min + "-" + max);
        }

        return range;
    }
    //clothes
    public static String clothesCalc(String clothes) {
        // 19 gallons per load
        double min;
        double max;
        String range = "";
        if (clothes.equals("1")) {
            // 0-1 times
            min = 0;
            max = 19 * 1;
            range = String.format(min + "-" + max);
        } else if (clothes.equals("2")) {
            // 2-4 times
            min = 19 * 2;
            max = 19 * 4;
            range = String.format(min + "-" + max);
        } else if (clothes.equals("3")) {
            // 5+ times
            min = 19 * 5;
            max = 19 * 5;
            range = String.format(min + "-" + max);
        }

        return range;
    }
    //cook
    public static String cookCalc(String cook) {
        // 0.25 gallons per meal
        double min;
        double max;
        String range = "";
        if (cook.equals("1")) {
            /// 0-4 times
            min = 0;
            max = 0.25 * 4;
            range = String.format(min + "-" + max);
        } else if (cook.equals("2")) {
            // 5-10 times
            min = 0.25 * 5;
            max = 0.25 * 10;
            range = String.format(min + "-" + max);
        } else if (cook.equals("3")) {
            min = 0.25 * 11;
            max = 0.25 * 11;
            range = String.format(min + "-" + max);
        }

        return range;
    }
    //dishwasher
    public static String dishwashCalc(String dd, String dishwash, String handwash) {
        // 4 gallons per load
        double min;
        double max;
        String range = "";
        if (dd.equals("1")) {
            if (dishwash.equals("1")) {
                // 0-4 times
                min = 0;
                max = 4 * 4;
                range = String.format(min + "-" + max);
            } else if (dishwash.equals("2")) {
                // 5-10 times
                min = 4 * 5;
                max = 4 * 10;
                range = String.format(min + "-" + max);
            } else if (dishwash.equals("3")) {
                // 11+ times
                min = 4 * 11;
                max = 4 * 11;
                range = String.format(min + "-" + max);
            }
        } else if (dd.equals("2")) {
            if (handwash.equals("1")) {
                // 0-4 times
                min = 0;
                max = 27 * 4;
                range = String.format(min + "-" + max);
            } else if (handwash.equals("2")) {
                // 5-10 times
                min = 27 * 5;
                max = 27 * 10;
                range = String.format(min + "-" + max);
            } else if (handwash.equals("3")) {
                // 11+ times
                min = 27 * 11;
                max = 27 * 11;
                range = String.format(min + "-" + max);
            }
        }

        return range;
    }
    //watering can
    public static String waterPlantCalc(String yn, String ws, String watercan, String sprinkle) {
        // 50 gallons per day
        double min;
        double max;
        String range = "";
        if (yn.equals("1")) {
            if (ws.equals("1")) {
                if (watercan.equals("1")) {
                    // 0-2 times
                    min = 0;
                    max = 50 * 2;
                    range = String.format(min + "-" + max);
                } else if (watercan.equals("2")) {
                    // 3-5 times
                    min = 50 * 3;
                    max = 50 * 5;
                    range = String.format(min + "-" + max);
                } else if (watercan.equals("3")) {
                    // 6+ times
                    min = 50 * 6;
                    max = 50 * 6;
                    range = String.format(min + "-" + max);
                }
            } else if (ws.equals("2")) {
                if (sprinkle.equals("1")) {
                    // 0-2 times
                    min = 0;
                    max = 2000 * 2;
                    range = String.format(min + "-" + max);
                } else if (sprinkle.equals("2")) {
                    // 3-5 times
                    min = 2000 * 3;
                    max = 2000 * 5;
                    range = String.format(min + "-" + max);
                } else if (sprinkle.equals("3")) {
                    // 6+ times
                    min = 2000 * 6;
                    max = 2000 * 6;
                    range = String.format(min + "-" + max);
                }
            }
        } else if (yn.equals("2")) {
            min = 0.00;
            max = 0.00;
            range = String.format(min + "-" + max);
        }

        return range;
    }

    //total consumption
    public static String totalConsumption(String bs, String showerDur, String teeth, String toilet, String washHands,
                                          String clothes, String cook, String dd, String dishwash, String handwash,
                                          String yn, String ws, String watercan, String sprinkle) {
        String s = bathShowerCalc(bs, showerDur);
        double showerMin = Double.parseDouble(s.substring(0, s.indexOf("-")));
        double showerMax = Double.parseDouble(s.substring(s.indexOf("-") + 1));
        String te = teethCalc(teeth);
        double teethVal = Double.parseDouble(te.substring(0, te.indexOf("-")));
        String toi = toiletCalc(toilet);
        double toiletMin = Double.parseDouble(toi.substring(0, toi.indexOf("-")));
        double toiletMax = Double.parseDouble(toi.substring(toi.indexOf("-") + 1));
        String wh = handsCalc(washHands);
        double handWashMin = Double.parseDouble(wh.substring(0, wh.indexOf("-")));
        double handWashMax = Double.parseDouble(wh.substring(wh.indexOf("-") + 1));
        String c = clothesCalc(clothes);
        double clothesMin = Double.parseDouble(c.substring(0, c.indexOf("-")));
        double clothesMax = Double.parseDouble(c.substring(c.indexOf("-") + 1));
        String coo = cookCalc(cook);
        double cookMin = Double.parseDouble(coo.substring(0, coo.indexOf("-")));
        double cookMax = Double.parseDouble(coo.substring(coo.indexOf("-") + 1));
        String dw = dishwashCalc(dd, dishwash, handwash);
        double dishwashMin = Double.parseDouble(dw.substring(0, dw.indexOf("-")));
        double dishwashMax = Double.parseDouble(dw.substring(dw.indexOf("-") + 1));
        String wc = waterPlantCalc(yn, ws, watercan, sprinkle);
        double waterPlantMin = Double.parseDouble(wc.substring(0, wc.indexOf("-")));
        double waterPlantMax = Double.parseDouble(wc.substring(wc.indexOf("-") + 1));

        double mins = showerMin + teethVal + toiletMin + handWashMin + clothesMin + cookMin + dishwashMin +
                waterPlantMin;
        double maxs = showerMax + teethVal + toiletMax + handWashMax + clothesMax + cookMax + dishwashMax +
                waterPlantMax;
        String range = String.format(mins + "-" + maxs);
        return range;
    }

    //comparison - 138 gallons per household per day
    public static String compareDroughtWithPlant(User user, String bs, String showerDur, String teeth, String toilet,
                                                 String washHands, String clothes, String cook, String dd,
                                                 String dishwash, String handwash, String yn, String ws,
                                                 String watercan, String sprinkle) {
        String comparison = "";
        String classification = FileUtils.CSVDroughtStats(user);
        String total = totalConsumption(bs, showerDur, teeth, toilet, washHands, clothes, cook, dd, dishwash, handwash,
                yn, ws, watercan, sprinkle);
        comparison += "Your total water consumption per week is " + total + " gallons.\n";
        double houseAvg = 138.0 * 7;
        if (classification.contains("D4")) {
            comparison += classification + "You are in an area of Exceptional Drought. Please look for ways to reduce " +
                    "your water consumption.\n";
        } else if (classification.contains("D3")) {
            comparison += classification + "You are in an area of Extreme Drought. Please look for ways to reduce " +
                    "your water consumption.\n";
        } else if (classification.contains("D2")) {
            comparison += classification + "You are in an area of Severe Drought. Please look for ways to reduce " +
                    "your water consumption.\n";
        } else if (classification.contains("D1")) {
            comparison += classification + "You are in an area of Moderate Drought. Begin considering ways to reduce " +
                    "your water consumption and save water.\n";
        } else if (classification.contains("D0")) {
            comparison += classification + "You are in an area that is Abnormally Dry. Begin considering ways to reduce " +
                    "your water consumption and save water.\n";
        } else if (classification.contains("None")) {
            comparison += classification + "You are in an area of low/no drought risk. Start looking for resources to " +
                    "gain more awareness of the water crisis and how you can educate yourself and others on how to save " +
                    "water.\n";
        }
        double mins = Double.parseDouble(total.substring(0, total.indexOf("-")));
        double maxs = Double.parseDouble(total.substring(total.indexOf("-")));
        if (maxs < houseAvg) {
            comparison += "Your household water consumption is excellent! " +
                    "Your maximum usage is below the national average per household per week.\n";
        } else if (maxs >= houseAvg && mins < houseAvg) {
            comparison += "Your household water consumption is average. Your maximum usage is greater than/equal to " +
                    "the national average per household per week and your minimum usage is below the national " +
                    "average.\n";
        } else if (mins > houseAvg) {
            comparison += "Your household water consumption needs improvement. Your minimum usage is greater than the "
                    + "national average per household per week.\n";
        }
        return comparison;
    }
}
