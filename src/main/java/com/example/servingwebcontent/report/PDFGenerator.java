package com.example.servingwebcontent.report;

import com.example.servingwebcontent.dto.ProductDto;
import com.example.servingwebcontent.dto.StockDto;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Stream;

public class PDFGenerator {
    private static BaseFont baseFont = loadBaseFont("/asset/times-roman.ttf");

    private static Font fontHeader = new Font(baseFont, 16, Font.BOLD, BaseColor.BLACK);

    private static Font fontNormal = new Font(baseFont, 14, Font.NORMAL, BaseColor.BLACK);

    private static BaseFont loadBaseFont(String fontName) {
        BaseFont baseFont= null;
        try {
            baseFont = BaseFont.createFont(fontName, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseFont;
    }

    public static ByteArrayInputStream customerPDFReport(List<ProductDto> productDtos, List<StockDto> stockDtos) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Paragraph para = new Paragraph( "Отчет по доходам", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(6);
            Stream.of("Название", "Склад", "Цена", "Расходы", "Прибыль", "Чистая прибыль")
                    .forEach(headerTitle -> {
                        PdfPCell header = new PdfPCell();
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(headerTitle, fontNormal));
                        table.addCell(header);
                    });
            DecimalFormat df = new DecimalFormat("###.##");

            for (ProductDto productDto : productDtos) {
                table.addCell(new Phrase(productDto.getNameProduct(), fontNormal));
                table.addCell(new Phrase(stockDtos.stream().filter(stock -> stock.getStockId().equals(productDto.getStockId())).findFirst().orElseThrow().getStockName(), fontNormal));
                table.addCell(String.valueOf(productDto.getPriceProduct()));
                Float costs = productDto.getPriceProduct() * (productDto.getAmountOnStock() + (productDto.getOrderedSupplier()==null?1:productDto.getOrderedSupplier()));
                table.addCell(df.format(costs));
                Float profit = productDto.getAmountOnSale() * productDto.getPriceProduct();
                table.addCell(df.format(profit));
                Float netProfit = ((productDto.getAmountOnSale() * productDto.getPriceProduct()) - (productDto.getAmountOnStock() + (productDto.getOrderedSupplier()==null?1:productDto.getOrderedSupplier())) * productDto.getPriceProduct());
                table.addCell(df.format(netProfit));
            }

            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}
