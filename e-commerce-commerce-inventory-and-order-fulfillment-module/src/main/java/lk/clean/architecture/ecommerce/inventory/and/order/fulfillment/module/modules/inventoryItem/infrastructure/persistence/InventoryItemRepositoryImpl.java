package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.infrastructure.persistence;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.modules.InventoryItem;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.repositories.InventoryItemRepository;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.infrastructure.persistence.entities.InventoryItemEntity;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.infrastructure.persistence.jpa.JpaInventoryItemRepository;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.infrastructure.persistence.persistenceMapper.PersistenceMapper;

import java.util.Optional;
import java.util.UUID;

public class InventoryItemRepositoryImpl implements InventoryItemRepository {

    //inject required dependencies
    private final JpaInventoryItemRepository jpaInventoryItemRepository;
    private final PersistenceMapper persistenceMapper;

    public InventoryItemRepositoryImpl(
            JpaInventoryItemRepository jpaInventoryItemRepository,
            PersistenceMapper persistenceMapper
    ) {
        this.jpaInventoryItemRepository = jpaInventoryItemRepository;
        this.persistenceMapper = persistenceMapper;
    }

    //product find by id
    @Override
    public Optional<InventoryItem> findByProductId(UUID productId) {
        return jpaInventoryItemRepository.findById(productId)
                .map(persistenceMapper::toDomainModel);
    }

    //save item
    @Override
    public InventoryItem save(InventoryItem inventoryItem) {

        InventoryItemEntity toEntity = persistenceMapper.toEntity(inventoryItem);
        InventoryItemEntity savedItem = jpaInventoryItemRepository.save(toEntity);

        return persistenceMapper.toDomainModel(savedItem);
    }
}
