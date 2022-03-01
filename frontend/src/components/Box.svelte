<script lang="ts">
  export let title: string;
</script>

<h3>{title}</h3>
<slot />

<style>
  h3 {
    font-size: 1.3em;
    font-weight: normal;
    margin: 0 0 1em 0;
  }
</style>
