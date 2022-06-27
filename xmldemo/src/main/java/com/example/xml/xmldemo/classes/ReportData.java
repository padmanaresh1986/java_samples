package com.example.xml.xmldemo.classes;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "ReportData")
public class ReportData {
    private List<TextRow> textRow;

    public List<TextRow> getTextRow() {
        return textRow;
    }

    @XmlElement(name = "textRow")
    public void setTextRow(List<TextRow> textRow) {
        this.textRow = textRow;
    }

    @Override
    public String toString() {
        return "ReportData{" +
                "textRow=" + textRow +
                '}';
    }

    static class TextRow {
        private String rowNumber;
        private String id;
        private String name;
        private Invoice invoice;
        private SubTotal subTotal;

        public String getRowNumber() {
            return rowNumber;
        }

        @XmlAttribute(name = "rowNumber")
        public void setRowNumber(String rowNumber) {
            this.rowNumber = rowNumber;
        }

        public String getId() {
            return id;
        }

        @XmlAttribute(name = "id")
        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        @XmlAttribute(name = "name")
        public void setName(String name) {
            this.name = name;
        }


        public Invoice getInvoice() {
            return invoice;
        }

        @XmlElement(name = "invoice")
        public void setInvoice(Invoice invoice) {
            this.invoice = invoice;
        }

        public SubTotal getSubTotal() {
            return subTotal;
        }

        @XmlElement(name = "subTotal")
        public void setSubTotal(SubTotal subTotal) {
            this.subTotal = subTotal;
        }

        @Override
        public String toString() {
            return "TextRow{" +
                    "rowNumber='" + rowNumber + '\'' +
                    ", id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", invoice=" + invoice +
                    ", subTotal=" + subTotal +
                    '}';
        }

        static class Invoice{
            private String recordNo;
            private String custvendId;
            private String docno;
            private String whenCreated;
            private String total;
            private String totalDue;
            private String totalPaid;
            private String prrecordKey;
            private String paymentStatus;
            private String description;
            private String whenDue;
            private String transType;
            private String customerName;
            private String salesInvoiceBatch;

            public String getRecordNo() {
                return recordNo;
            }

            @XmlElement(name = "recordNo")
            public void setRecordNo(String recordNo) {
                this.recordNo = recordNo;
            }

            public String getCustvendId() {
                return custvendId;
            }

            @XmlElement(name = "custvendId")
            public void setCustvendId(String custvendId) {
                this.custvendId = custvendId;
            }

            public String getDocno() {
                return docno;
            }

            @XmlElement(name = "docno")
            public void setDocno(String docno) {
                this.docno = docno;
            }

            public String getWhenCreated() {
                return whenCreated;
            }

            @XmlElement(name = "whenCreated")
            public void setWhenCreated(String whenCreated) {
                this.whenCreated = whenCreated;
            }

            public String getTotal() {
                return total;
            }

            @XmlElement(name = "total")
            public void setTotal(String total) {
                this.total = total;
            }

            public String getTotalDue() {
                return totalDue;
            }

            @XmlElement(name = "totalDue")
            public void setTotalDue(String totalDue) {
                this.totalDue = totalDue;
            }

            public String getTotalPaid() {
                return totalPaid;
            }

            @XmlElement(name = "totalPaid")
            public void setTotalPaid(String totalPaid) {
                this.totalPaid = totalPaid;
            }

            public String getPrrecordKey() {
                return prrecordKey;
            }

            @XmlElement(name = "prrecordKey")
            public void setPrrecordKey(String prrecordKey) {
                this.prrecordKey = prrecordKey;
            }

            public String getPaymentStatus() {
                return paymentStatus;
            }

            @XmlElement(name = "paymentStatus")
            public void setPaymentStatus(String paymentStatus) {
                this.paymentStatus = paymentStatus;
            }

            public String getDescription() {
                return description;
            }

            @XmlElement(name = "description")
            public void setDescription(String description) {
                this.description = description;
            }

            public String getWhenDue() {
                return whenDue;
            }

            @XmlElement(name = "whenDue")
            public void setWhenDue(String whenDue) {
                this.whenDue = whenDue;
            }

            public String getTransType() {
                return transType;
            }

            @XmlElement(name = "transType")
            public void setTransType(String transType) {
                this.transType = transType;
            }

            public String getCustomerName() {
                return customerName;
            }

            @XmlElement(name = "customerName")
            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public String getSalesInvoiceBatch() {
                return salesInvoiceBatch;
            }

            @XmlElement(name = "salesInvoiceBatch")
            public void setSalesInvoiceBatch(String salesInvoiceBatch) {
                this.salesInvoiceBatch = salesInvoiceBatch;
            }

            @Override
            public String toString() {
                return "Invoice{" +
                        "recordNo='" + recordNo + '\'' +
                        ", custvendId='" + custvendId + '\'' +
                        ", docno='" + docno + '\'' +
                        ", whenCreated='" + whenCreated + '\'' +
                        ", total='" + total + '\'' +
                        ", totalDue='" + totalDue + '\'' +
                        ", totalPaid='" + totalPaid + '\'' +
                        ", prrecordKey='" + prrecordKey + '\'' +
                        ", paymentStatus='" + paymentStatus + '\'' +
                        ", description='" + description + '\'' +
                        ", whenDue='" + whenDue + '\'' +
                        ", transType='" + transType + '\'' +
                        ", customerName='" + customerName + '\'' +
                        ", salesInvoiceBatch='" + salesInvoiceBatch + '\'' +
                        '}';
            }
        }

        static class SubTotal{
            private String name;
            private String id;
            private String total;

            public String getName() {
                return name;
            }

            @XmlElement(name = "name")
            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            @XmlElement(name = "id")
            public void setId(String id) {
                this.id = id;
            }

            public String getTotal() {
                return total;
            }

            @XmlElement(name = "total")
            public void setTotal(String total) {
                this.total = total;
            }

            @Override
            public String toString() {
                return "SubTotal{" +
                        "name='" + name + '\'' +
                        ", id='" + id + '\'' +
                        ", total='" + total + '\'' +
                        '}';
            }
        }
    }
}
