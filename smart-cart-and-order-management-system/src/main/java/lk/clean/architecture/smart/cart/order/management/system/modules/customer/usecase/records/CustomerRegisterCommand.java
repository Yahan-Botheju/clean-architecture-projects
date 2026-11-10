package lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase.records;

public record CustomerRegisterCommand(
        String fullName,
        String email
) {
}
