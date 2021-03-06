/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.webtrekk.email.service.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Attachment extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8256431161845577569L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Attachment\",\"namespace\":\"com.webtrekk.email.service.avro\",\"fields\":[{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Attachment name\"},{\"name\":\"attachmentURI\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Attachment url\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Attachment> ENCODER =
      new BinaryMessageEncoder<Attachment>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Attachment> DECODER =
      new BinaryMessageDecoder<Attachment>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Attachment> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Attachment> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Attachment>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Attachment to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Attachment from a ByteBuffer. */
  public static Attachment fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Attachment name */
  @Deprecated public java.lang.String name;
  /** Attachment url */
  @Deprecated public java.lang.String attachmentURI;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Attachment() {}

  /**
   * All-args constructor.
   * @param name Attachment name
   * @param attachmentURI Attachment url
   */
  public Attachment(java.lang.String name, java.lang.String attachmentURI) {
    this.name = name;
    this.attachmentURI = attachmentURI;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return attachmentURI;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.String)value$; break;
    case 1: attachmentURI = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return Attachment name
   */
  public java.lang.String getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * Attachment name
   * @param value the value to set.
   */
  public void setName(java.lang.String value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'attachmentURI' field.
   * @return Attachment url
   */
  public java.lang.String getAttachmentURI() {
    return attachmentURI;
  }

  /**
   * Sets the value of the 'attachmentURI' field.
   * Attachment url
   * @param value the value to set.
   */
  public void setAttachmentURI(java.lang.String value) {
    this.attachmentURI = value;
  }

  /**
   * Creates a new Attachment RecordBuilder.
   * @return A new Attachment RecordBuilder
   */
  public static com.webtrekk.email.service.avro.Attachment.Builder newBuilder() {
    return new com.webtrekk.email.service.avro.Attachment.Builder();
  }

  /**
   * Creates a new Attachment RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Attachment RecordBuilder
   */
  public static com.webtrekk.email.service.avro.Attachment.Builder newBuilder(com.webtrekk.email.service.avro.Attachment.Builder other) {
    return new com.webtrekk.email.service.avro.Attachment.Builder(other);
  }

  /**
   * Creates a new Attachment RecordBuilder by copying an existing Attachment instance.
   * @param other The existing instance to copy.
   * @return A new Attachment RecordBuilder
   */
  public static com.webtrekk.email.service.avro.Attachment.Builder newBuilder(com.webtrekk.email.service.avro.Attachment other) {
    return new com.webtrekk.email.service.avro.Attachment.Builder(other);
  }

  /**
   * RecordBuilder for Attachment instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Attachment>
    implements org.apache.avro.data.RecordBuilder<Attachment> {

    /** Attachment name */
    private java.lang.String name;
    /** Attachment url */
    private java.lang.String attachmentURI;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.webtrekk.email.service.avro.Attachment.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.attachmentURI)) {
        this.attachmentURI = data().deepCopy(fields()[1].schema(), other.attachmentURI);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Attachment instance
     * @param other The existing instance to copy.
     */
    private Builder(com.webtrekk.email.service.avro.Attachment other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.attachmentURI)) {
        this.attachmentURI = data().deepCopy(fields()[1].schema(), other.attachmentURI);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * Attachment name
      * @return The value.
      */
    public java.lang.String getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * Attachment name
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.webtrekk.email.service.avro.Attachment.Builder setName(java.lang.String value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * Attachment name
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * Attachment name
      * @return This builder.
      */
    public com.webtrekk.email.service.avro.Attachment.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'attachmentURI' field.
      * Attachment url
      * @return The value.
      */
    public java.lang.String getAttachmentURI() {
      return attachmentURI;
    }

    /**
      * Sets the value of the 'attachmentURI' field.
      * Attachment url
      * @param value The value of 'attachmentURI'.
      * @return This builder.
      */
    public com.webtrekk.email.service.avro.Attachment.Builder setAttachmentURI(java.lang.String value) {
      validate(fields()[1], value);
      this.attachmentURI = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'attachmentURI' field has been set.
      * Attachment url
      * @return True if the 'attachmentURI' field has been set, false otherwise.
      */
    public boolean hasAttachmentURI() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'attachmentURI' field.
      * Attachment url
      * @return This builder.
      */
    public com.webtrekk.email.service.avro.Attachment.Builder clearAttachmentURI() {
      attachmentURI = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Attachment build() {
      try {
        Attachment record = new Attachment();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.String) defaultValue(fields()[0]);
        record.attachmentURI = fieldSetFlags()[1] ? this.attachmentURI : (java.lang.String) defaultValue(fields()[1]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Attachment>
    WRITER$ = (org.apache.avro.io.DatumWriter<Attachment>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Attachment>
    READER$ = (org.apache.avro.io.DatumReader<Attachment>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
