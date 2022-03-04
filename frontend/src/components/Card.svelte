<script lang="ts">
  import Box from "./Box.svelte";

  export let title: string;
  export let value: string;
</script>

<Box title={title}>
  <div class="value">{value}</div>
</Box>
