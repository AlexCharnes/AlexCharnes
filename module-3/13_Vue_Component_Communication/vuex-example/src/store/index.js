import { createStore as _createStore } from 'vuex';


export function createStore() {
  return _createStore({
    state: {
      inventory: {
        tvs: 5
      }
    },
    mutations: {
      REMOVE_TVS_FROM_INVENTORY(state, amount) {
        if (state.inventory.tvs > 0) {
          state.inventory.tvs -= amount;
        }
      }
    },
    getters: {
      currentTvInventory(state) {
        return state.inventory.tvs;
      }
    },
    actions: {
    },
    modules: {
    },
    // Strict should not be used in production code. It is used here as a
    // learning aid to warn you if state is modified without using a mutation.
    strict: true
  });
}
