class OutPatient extends Patient {

    private double consultationFees;
    private double treatmentCharges;

    public double getConsultationFees() {
        return consultationFees;
    }

    public void setConsultationFees(double consultationFees) {
        this.consultationFees = consultationFees;
    }

    public double getTreatmentCharges() {
        return treatmentCharges;
    }

    public void setTreatmentCharges(double treatmentCharges) {
        this.treatmentCharges = treatmentCharges;
    }

    @Override
    double calculateBill() {
        return consultationFees + treatmentCharges;
    }
}