/**
 * Fragmento principal que muestra la lista de jugos y permite agregar, editar o eliminar.
 */
class TrackerFragment : Fragment() {

    private val viewModel by viewModels<TrackerViewModel> { AppViewModelProvider.Factory }

    // Adaptador de la lista de jugos
    private val adapter = JuiceListAdapter(
        onEdit = { drink ->
            findNavController().navigate(
                TrackerFragmentDirections.actionTrackerFragmentToEntryDialogFragment(drink.id)
            )
        },
        onDelete = { drink ->
            viewModel.deleteJuice(drink)
        }
    )

    override fun onCreateView(...) =
        FragmentTrackerBinding.inflate(inflater, container, false).root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentTrackerBinding.bind(view)

        // Asocia el RecyclerView con el adaptador
        binding.recyclerView.adapter = adapter

        // Botón flotante (FAB) para agregar una nueva entrada
        binding.fab.setOnClickListener { fabView ->
            fabView.findNavController().navigate(
                TrackerFragmentDirections.actionTrackerFragmentToEntryDialogFragment()
            )
        }

        // Observa el flujo de jugos y actualiza la lista
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.juicesStream.collect {
                    adapter.submitList(it)
                }
            }
        }
    }
}