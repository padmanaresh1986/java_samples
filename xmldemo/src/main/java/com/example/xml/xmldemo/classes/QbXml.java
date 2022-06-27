package com.example.xml.xmldemo.classes;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "QBXML")
public class QbXml {
    private QbXmlMsgsRs qbXmlMsgsRs;

    public QbXmlMsgsRs getQbXmlMsgsRs() {
        return qbXmlMsgsRs;
    }
    @XmlElement(name = "QBXMLMsgsRs")
    public void setQbXmlMsgsRs(QbXmlMsgsRs qbXmlMsgsRs) {
        this.qbXmlMsgsRs = qbXmlMsgsRs;
    }

    @Override
    public String toString() {
        return "QbXml{" +
                "qbXmlMsgsRs=" + qbXmlMsgsRs +
                '}';
    }

    static class QbXmlMsgsRs{
        private GeneralDetailReportQueryRs generalDetailReportQueryRs;

        public GeneralDetailReportQueryRs getGeneralDetailReportQueryRs() {
            return generalDetailReportQueryRs;
        }

        @XmlElement(name = "GeneralDetailReportQueryRs")
        public void setGeneralDetailReportQueryRs(GeneralDetailReportQueryRs generalDetailReportQueryRs) {
            this.generalDetailReportQueryRs = generalDetailReportQueryRs;
        }

        @Override
        public String toString() {
            return "QbXmlMsgsRs{" +
                    "generalDetailReportQueryRs=" + generalDetailReportQueryRs +
                    '}';
        }

        static class GeneralDetailReportQueryRs {
            private String statusCode;
            private String statusSeverity;
            private String statusMessage;
            private ReportRet reportRet;

            public String getStatusCode() {
                return statusCode;
            }
            @XmlAttribute(name = "statusCode")
            public void setStatusCode(String statusCode) {
                this.statusCode = statusCode;
            }

            public String getStatusSeverity() {
                return statusSeverity;
            }
            @XmlAttribute(name = "statusSeverity")
            public void setStatusSeverity(String statusSeverity) {
                this.statusSeverity = statusSeverity;
            }

            public String getStatusMessage() {
                return statusMessage;
            }
            @XmlAttribute(name = "statusMessage")
            public void setStatusMessage(String statusMessage) {
                this.statusMessage = statusMessage;
            }

            public ReportRet getReportRet() {
                return reportRet;
            }
            @XmlElement(name = "ReportRet")
            public void setReportRet(ReportRet reportRet) {
                this.reportRet = reportRet;
            }

            @Override
            public String toString() {
                return "GeneralDetailReportQueryRs{" +
                        "statusCode='" + statusCode + '\'' +
                        ", statusSeverity='" + statusSeverity + '\'' +
                        ", statusMessage='" + statusMessage + '\'' +
                        ", reportRet=" + reportRet +
                        '}';
            }

            @XmlType(propOrder={"reportTitle", "reportSubtitle", "reportBasis","numRows","numColumns","numColTitleRows","colDesc","reportData"})
            static class ReportRet{
                private String reportTitle;
                private String reportSubtitle;
                private String reportBasis;
                private String numRows;
                private String numColumns;
                private String numColTitleRows;
                private List<ColDesc> colDesc;
                private ReportDataLocal reportData;

                public String getReportTitle() {
                    return reportTitle;
                }

                @XmlElement(name = "ReportTitle")
                public void setReportTitle(String reportTitle) {
                    this.reportTitle = reportTitle;
                }

                public String getReportSubtitle() {
                    return reportSubtitle;
                }

                @XmlElement(name = "ReportSubtitle")
                public void setReportSubtitle(String reportSubtitle) {
                    this.reportSubtitle = reportSubtitle;
                }

                public String getReportBasis() {
                    return reportBasis;
                }

                @XmlElement(name = "ReportBasis")
                public void setReportBasis(String reportBasis) {
                    this.reportBasis = reportBasis;
                }

                public String getNumRows() {
                    return numRows;
                }

                @XmlElement(name = "NumRows")
                public void setNumRows(String numRows) {
                    this.numRows = numRows;
                }

                public String getNumColumns() {
                    return numColumns;
                }

                @XmlElement(name = "NumColumns")
                public void setNumColumns(String numColumns) {
                    this.numColumns = numColumns;
                }

                public String getNumColTitleRows() {
                    return numColTitleRows;
                }

                @XmlElement(name = "NumColTitleRows")
                public void setNumColTitleRows(String numColTitleRows) {
                    this.numColTitleRows = numColTitleRows;
                }

                public List<ColDesc> getColDesc() {
                    return colDesc;
                }

                @XmlElement(name = "ColDesc")
                public void setColDesc(List<ColDesc> colDesc) {
                    this.colDesc = colDesc;
                }

                public ReportDataLocal getReportData() {
                    return reportData;
                }

                @XmlElement(name = "ReportData")
                public void setReportData(ReportDataLocal reportData) {
                    this.reportData = reportData;
                }

                @Override
                public String toString() {
                    return "ReportRet{" +
                            "reportTitle='" + reportTitle + '\'' +
                            ", reportSubtitle='" + reportSubtitle + '\'' +
                            ", reportBasis='" + reportBasis + '\'' +
                            ", numRows='" + numRows + '\'' +
                            ", numColumns='" + numColumns + '\'' +
                            ", numColTitleRows='" + numColTitleRows + '\'' +
                            ", colDesc=" + colDesc +
                            ", reportData=" + reportData +
                            '}';
                }

                static class ColDesc{
                    private String colID;
                    private String dataType;
                    private ColTitle colTitle;
                    private String colType;

                    public ColDesc() {
                    }

                    public ColDesc(String colID, String dataType, ColTitle colTitle, String colType) {
                        this.colID = colID;
                        this.dataType = dataType;
                        this.colTitle = colTitle;
                        this.colType = colType;
                    }

                    public String getColID() {
                        return colID;
                    }

                    @XmlAttribute(name = "colID")
                    public void setColID(String colID) {
                        this.colID = colID;
                    }

                    public String getDataType() {
                        return dataType;
                    }

                    @XmlAttribute(name = "dataType")
                    public void setDataType(String dataType) {
                        this.dataType = dataType;
                    }

                    public ColTitle getColTitle() {
                        return colTitle;
                    }

                    @XmlElement(name = "ColTitle")
                    public void setColTitle(ColTitle colTitle) {
                        this.colTitle = colTitle;
                    }

                    public String getColType() {
                        return colType;
                    }

                    @XmlElement(name = "ColType")
                    public void setColType(String colType) {
                        this.colType = colType;
                    }

                    @Override
                    public String toString() {
                        return "ColDesc{" +
                                "colID='" + colID + '\'' +
                                ", dataType='" + dataType + '\'' +
                                ", colTitle=" + colTitle +
                                ", colType='" + colType + '\'' +
                                '}';
                    }

                    static class ColTitle{
                        private String titleRow;
                        private String value;

                        public ColTitle() {
                        }

                        public ColTitle(String titleRow) {
                            this.titleRow = titleRow;
                        }

                        public ColTitle(String titleRow, String value) {
                            this.titleRow = titleRow;
                            this.value = value;
                        }

                        public String getTitleRow() {
                            return titleRow;
                        }

                        @XmlAttribute(name = "titleRow")
                        public void setTitleRow(String titleRow) {
                            this.titleRow = titleRow;
                        }

                        public String getValue() {
                            return value;
                        }

                        @XmlAttribute(name = "value")
                        public void setValue(String value) {
                            this.value = value;
                        }

                        @Override
                        public String toString() {
                            return "ColTitle{" +
                                    "titleRow='" + titleRow + '\'' +
                                    ", value='" + value + '\'' +
                                    '}';
                        }
                    }
                }
                static class ReportDataLocal{
                    private List<TextRow> textRow;
                    private List<DataRow> dataRow;
                    private List<SubtotalRow> subtotalRow;

                    public List<TextRow> getTextRow() {
                        return textRow;
                    }
                    @XmlElement(name = "TextRow")
                    public void setTextRow(List<TextRow> textRow) {
                        this.textRow = textRow;
                    }

                   public List<DataRow> getDataRow() {
                        return dataRow;
                    }
                    @XmlElement(name = "DataRow")
                    public void setDataRow(List<DataRow> dataRow) {
                        this.dataRow = dataRow;
                    }

                     public List<SubtotalRow> getSubtotalRow() {
                        return subtotalRow;
                    }
                    @XmlElement(name = "SubtotalRow")
                    public void setSubtotalRow(List<SubtotalRow> subtotalRow) {
                        this.subtotalRow = subtotalRow;
                    }

                    @Override
                    public String toString() {
                        return "ReportDataLocal{" +
                                "textRow=" + textRow +
                                ", dataRow=" + dataRow +
                                ", subtotalRow=" + subtotalRow +
                                '}';
                    }

                    static class Row{
                        private String rowNumber;

                        public Row(String rowNumber) {
                            this.rowNumber = rowNumber;
                        }

                        public String getRowNumber() {
                            return rowNumber;
                        }
                        @XmlAttribute(name = "rowNumber")
                        public void setRowNumber(String rowNumber) {
                            this.rowNumber = rowNumber;
                        }
                    }

                    static class TextRow extends Row{

                        private String value;

                        public TextRow(String rowNumber, String value) {
                            super(rowNumber);
                            this.value = value;
                        }

                        public String getValue() {
                            return value;
                        }
                        @XmlAttribute(name = "value")
                        public void setValue(String value) {
                            this.value = value;
                        }

                        @Override
                        public String toString() {
                            return "TextRow{" +
                                    "rowNumber='" + getRowNumber() + '\'' +
                                    ", value='" + value + '\'' +
                                    '}';
                        }
                    }
                    @XmlType(propOrder={"rowData", "colData"})
                    static class DataRow extends Row{
                        private RowData rowData;
                        private List<ColData> colData;

                        public DataRow(String rowNumber) {
                            super(rowNumber);
                        }

                        public RowData getRowData() {
                            return rowData;
                        }

                        @XmlElement(name = "RowData")
                        public void setRowData(RowData rowData) {
                            this.rowData = rowData;
                        }

                        public List<ColData> getColData() {
                            return colData;
                        }

                        @XmlElement(name = "ColData")
                        public void setColData(List<ColData> colData) {
                            this.colData = colData;
                        }

                        @Override
                        public String toString() {
                            return "DataRow{" +
                                    "rowNumber='" + getRowNumber() + '\'' +
                                    ", rowData=" + rowData +
                                    ", colData=" + colData +
                                    '}';
                        }

                        static class RowData{
                            private String rowType;
                            private String value;

                            public RowData(String rowType, String value) {
                                this.rowType = rowType;
                                this.value = value;
                            }

                            public String getRowType() {
                                return rowType;
                            }
                            @XmlAttribute(name = "rowType")
                            public void setRowType(String rowType) {
                                this.rowType = rowType;
                            }

                            public String getValue() {
                                return value;
                            }
                            @XmlAttribute(name = "value")
                            public void setValue(String value) {
                                this.value = value;
                            }
                        }

                        static class ColData {
                            private String colID;
                            private String value;

                            public ColData(String colID, String value) {
                                this.colID = colID;
                                this.value = value;
                            }

                            public String getColID() {
                                return colID;
                            }
                            @XmlAttribute(name = "colID")
                            public void setColID(String colID) {
                                this.colID = colID;
                            }

                            public String getValue() {
                                return value;
                            }
                            @XmlAttribute(name = "value")
                            public void setValue(String value) {
                                this.value = value;
                            }

                            @Override
                            public String toString() {
                                return "ColData{" +
                                        "colID='" + colID + '\'' +
                                        ", value='" + value + '\'' +
                                        '}';
                            }
                        }
                    }
                    @XmlType(propOrder={"rowData", "colData"})
                    static class SubtotalRow extends  Row{
                        private DataRow.RowData rowData;
                        private List<DataRow.ColData> colData;

                        public SubtotalRow(String rowNumber) {
                            super(rowNumber);
                        }

                        public DataRow.RowData getRowData() {
                            return rowData;
                        }

                        @XmlElement(name = "RowData")
                        public void setRowData(DataRow.RowData rowData) {
                            this.rowData = rowData;
                        }

                        public List<DataRow.ColData> getColData() {
                            return colData;
                        }

                        @XmlElement(name = "ColData")
                        public void setColData(List<DataRow.ColData> colData) {
                            this.colData = colData;
                        }

                        @Override
                        public String toString() {
                            return "DataRow{" +
                                    "rowNumber='" + getRowNumber() + '\'' +
                                    ", rowData=" + rowData +
                                    ", colData=" + colData +
                                    '}';
                        }

                       /* static class RowData{
                            private String rowType;
                            private String value;

                            public RowData(String rowType, String value) {
                                this.rowType = rowType;
                                this.value = value;
                            }

                            public String getRowType() {
                                return rowType;
                            }
                            @XmlAttribute(name = "rowType")
                            public void setRowType(String rowType) {
                                this.rowType = rowType;
                            }

                            public String getValue() {
                                return value;
                            }
                            @XmlAttribute(name = "value")
                            public void setValue(String value) {
                                this.value = value;
                            }
                        }

                        static class ColData {
                            private String colID;
                            private String value;

                            public ColData(String colID, String value) {
                                this.colID = colID;
                                this.value = value;
                            }

                            public String getColID() {
                                return colID;
                            }
                            @XmlAttribute(name = "colID")
                            public void setColID(String colID) {
                                this.colID = colID;
                            }

                            public String getValue() {
                                return value;
                            }
                            @XmlAttribute(name = "value")
                            public void setValue(String value) {
                                this.value = value;
                            }

                            @Override
                            public String toString() {
                                return "ColData{" +
                                        "colID='" + colID + '\'' +
                                        ", value='" + value + '\'' +
                                        '}';
                            }
                        }*/
                    }
                }
            }
        }
    }
}
