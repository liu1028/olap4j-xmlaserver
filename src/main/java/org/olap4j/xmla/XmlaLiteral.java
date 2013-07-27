package org.olap4j.xmla;

import java.util.List;

/**
 * XML for Analysis entity representing a Literal.
 *
 * <p>Corresponds to the XML/A {@code DISCOVER_LITERALS} method.</p>
*/
public class XmlaLiteral extends Entity {
    public static final XmlaLiteral INSTANCE =
        new XmlaLiteral();

    public RowsetDefinition def() {
        return RowsetDefinition.DISCOVER_LITERALS;
    }

    List<Column> columns() {
        return list(
            LiteralName,
            LiteralValue,
            LiteralInvalidChars,
            LiteralInvalidStartingChars,
            LiteralMaxLength);
    }

    List<Column> sortColumns() {
        return list(); // not sorted
    }

    public final Column LiteralName =
        new Column(
            "LiteralName",
            XmlaType.StringSometimesArray,
            null,
            Column.RESTRICTION,
            Column.REQUIRED,
            "The name of the literal described in the row.\n"
            + "Example: DBLITERAL_LIKE_PERCENT");
    public final Column LiteralValue =
        new Column(
            "LiteralValue",
            XmlaType.String,
            null,
            Column.NOT_RESTRICTION,
            Column.OPTIONAL,
            "Contains the actual literal value.\n"
            + "Example, if LiteralName is DBLITERAL_LIKE_PERCENT and the "
            + "percent character (%) is used to match zero or more "
            + "characters in a LIKE clause, this column's value would be "
            + "\"%\".");
    public final Column LiteralInvalidChars =
        new Column(
            "LiteralInvalidChars",
            XmlaType.String,
            null,
            Column.NOT_RESTRICTION,
            Column.OPTIONAL,
            "The characters, in the literal, that are not valid.\n"
            + "For example, if table names can contain anything other than "
            + "a numeric character, this string would be \"0123456789\".");

    public final Column LiteralInvalidStartingChars =
        new Column(
            "LiteralInvalidStartingChars",
            XmlaType.String,
            null,
            Column.NOT_RESTRICTION,
            Column.OPTIONAL,
            "The characters that are not valid as the first character of "
            + "the literal. If the literal can start with any valid "
            + "character, this is null.");

    public final Column LiteralMaxLength =
        new Column(
            "LiteralMaxLength",
            XmlaType.Integer,
            null,
            Column.NOT_RESTRICTION,
            Column.OPTIONAL,
            "The maximum number of characters in the literal. If there is "
            + "no maximum or the maximum is unknown, the value is ?1.");
}

// End XmlaLiteral.java
