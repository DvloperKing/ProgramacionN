/**
 * Fragmento de tipo BottomSheet que permite al usuario crear o editar una entrada de jugo.
 */
class EntryDialogFragment : BottomSheetDialogFragment() {

    // ViewModel asociado al fragmento, usando el proveedor de ViewModels de la app
    private val entryViewModel by viewModels<EntryViewModel> { AppViewModelProvider.Factory }

    // Color de jugo seleccionado, con valor inicial
    var selectedColor: JuiceColor = JuiceColor.Red

    override fun onCreateView(...) =
        FragmentEntryDialogBinding.inflate(inflater, container, false).root

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val colorLabelMap = JuiceColor.values().associateBy { getString(it.label) }
        val binding = FragmentEntryDialogBinding.bind(view)
        val args: EntryDialogFragmentArgs by navArgs()
        val juiceId = args.itemId

        // Si se recibió un ID de jugo existente, cargar sus datos
        if (juiceId > 0) {
            viewLifecycleOwner.lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    entryViewModel.getJuiceStream(juiceId).filterNotNull().collect { item ->
                        with(binding) {
                            name.setText(item.name)
                            description.setText(item.description)
                            ratingBar.rating = item.rating.toFloat()
                            colorSpinner.setSelection(findColorIndex(item.color))
                        }
                    }
                }
            }
        }

        // Habilita el botón guardar si hay texto en el campo nombre
        binding.name.doOnTextChanged { _, start, _, count ->
            binding.saveButton.isEnabled = (start + count) > 0
        }

        // Configuración del Spinner de colores
        binding.colorSpinner.adapter = ArrayAdapter(
            requireContext(),
            layout.support_simple_spinner_dropdown_item,
            colorLabelMap.map { it.key }
        )
        binding.colorSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(...) {
                val selected = parent.getItemAtPosition(pos).toString()
                selectedColor = colorLabelMap[selected] ?: selectedColor
            }

            override fun onNothingSelected(...) {
                selectedColor = JuiceColor.Red
            }
        }

        // Botón guardar: crea o actualiza el jugo
        binding.saveButton.setOnClickListener {
            entryViewModel.saveJuice(
                juiceId,
                binding.name.text.toString(),
                binding.description.text.toString(),
                selectedColor.name,
                binding.ratingBar.rating.toInt()
            )
            dismiss()
        }

        // Botón cancelar: cierra el diálogo sin guardar
        binding.cancelButton.setOnClickListener {
            dismiss()
        }
    }

    // Encuentra el índice del color seleccionado para el Spinner
    private fun findColorIndex(color: String): Int {
        val juiceColor = JuiceColor.valueOf(color)
        return JuiceColor.values().indexOf(juiceColor)
    }
}