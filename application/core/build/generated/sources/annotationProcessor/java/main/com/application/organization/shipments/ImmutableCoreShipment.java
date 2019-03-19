package com.application.organization.shipments;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link CoreShipment}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCoreShipment.builder()}.
 */
@Generated(from = "CoreShipment", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableCoreShipment implements CoreShipment {
  private final String destination;

  private ImmutableCoreShipment(String destination) {
    this.destination = destination;
  }

  /**
   * @return The value of the {@code destination} attribute
   */
  @Override
  public String destination() {
    return destination;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CoreShipment#destination() destination} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for destination
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCoreShipment withDestination(String value) {
    String newValue = Objects.requireNonNull(value, "destination");
    if (this.destination.equals(newValue)) return this;
    return new ImmutableCoreShipment(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCoreShipment} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCoreShipment
        && equalTo((ImmutableCoreShipment) another);
  }

  private boolean equalTo(ImmutableCoreShipment another) {
    return destination.equals(another.destination);
  }

  /**
   * Computes a hash code from attributes: {@code destination}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + destination.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code CoreShipment} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "CoreShipment{"
        + "destination=" + destination
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link CoreShipment} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CoreShipment instance
   */
  public static ImmutableCoreShipment copyOf(CoreShipment instance) {
    if (instance instanceof ImmutableCoreShipment) {
      return (ImmutableCoreShipment) instance;
    }
    return ImmutableCoreShipment.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCoreShipment ImmutableCoreShipment}.
   * <pre>
   * ImmutableCoreShipment.builder()
   *    .destination(String) // required {@link CoreShipment#destination() destination}
   *    .build();
   * </pre>
   * @return A new ImmutableCoreShipment builder
   */
  public static ImmutableCoreShipment.Builder builder() {
    return new ImmutableCoreShipment.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCoreShipment ImmutableCoreShipment}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "CoreShipment", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_DESTINATION = 0x1L;
    private long initBits = 0x1L;

    private String destination;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code CoreShipment} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CoreShipment instance) {
      Objects.requireNonNull(instance, "instance");
      destination(instance.destination());
      return this;
    }

    /**
     * Initializes the value for the {@link CoreShipment#destination() destination} attribute.
     * @param destination The value for destination 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder destination(String destination) {
      this.destination = Objects.requireNonNull(destination, "destination");
      initBits &= ~INIT_BIT_DESTINATION;
      return this;
    }

    /**
     * Builds a new {@link ImmutableCoreShipment ImmutableCoreShipment}.
     * @return An immutable instance of CoreShipment
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCoreShipment build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableCoreShipment(destination);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_DESTINATION) != 0) attributes.add("destination");
      return "Cannot build CoreShipment, some of required attributes are not set " + attributes;
    }
  }
}
