# ShoppingBag

## Components used in the project
- MVVM architecture with LiveData
- Retrofit for Network operations
- Dagger for dependency Injections
- Room for Db management & DbCache
- OkHttp for DataCache
- Junit & mockito for Unit Tests

### `scenario_1_api_request`
For the API integration the approach followed is MVVM architecture with retrofit library.

### `scenario_2_caching`
Data caching was implemented in 2 scenarios
- OkHttp Cache with remote configuration
- RoomData base for data persistance

### `scenario_3_mvvm`
Applied MVVM architecture with databinding to populate the views

### `scenario_4_testing`
Developed Unit tests for Repository class and API integration with coroutines.
