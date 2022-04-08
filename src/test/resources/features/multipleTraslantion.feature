Feature: Multiple Translation

  @req @positive @wip
  Scenario:Adding new parameters to the admin panel CGB-458(addNewTranslationKey)
    When User send request for addnig new parameters (unique key, status Active-passive)
    Then Translation key should be added.