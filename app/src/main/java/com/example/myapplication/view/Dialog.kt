import com.example.myapplication.data.RepositoryClient

class Dialog {
    private var onAdd: ((Int, String, String, Int) -> Unit)? = null
    private var onUpdate: ((Int, String, String, Int) -> Unit)? = null
    private var onDelete: ((Int) -> Unit)? = null
    private var currentClientId: Int? = null

    fun setOnAddListener(listener: (Int, String, String, Int) -> Unit) {
        onAdd = listener
    }

    fun setOnUpdateListener(listener: (Int, String, String, Int) -> Unit) {
        onUpdate = listener
    }

    fun setOnDeleteListener(listener: (Int) -> Unit) {
        onDelete = listener
    }

    fun show(typeAction: Int, clientId: Int? = null) {
        currentClientId = clientId
        when (typeAction) {
            0 -> onAccept()
            1 -> currentClientId?.let {
                onUpdate?.invoke(it, "Nombre Cambiado", "Apellido Cambiado", 1324543342)
            }
            2 -> currentClientId?.let {
                onDelete?.invoke(it)
            }
        }
    }

    private fun onAccept() {
        onAdd?.invoke(RepositoryClient.incrementPrimary(), "Cliente Nuevo", "Apellido Nuevo", 1234435633)
    }
}
