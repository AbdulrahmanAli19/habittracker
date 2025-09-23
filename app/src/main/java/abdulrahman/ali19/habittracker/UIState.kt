package abdulrahman.ali19.habittracker

data class UIState(
    val isPaid: Boolean,
    val text: String = "You are using",
    val isButtonEnabled: Boolean = isPaid
) {
    private val versionName = if (isPaid) "Pro" else "Free"
    val previewText =
        "$text $versionName! ${if (isPaid.not()) "Please upgrade to Pro to enable the button." else ""}"
}