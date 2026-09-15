package app.kahoot.patches.kahootkids.premium

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.kahoot.patches.kahootkids.shared.Constants.COMPATIBILITY_KAHOOT_KIDS

private const val TRUE_RETURN = """
    const/4 v0, 0x1
    return v0
"""

@Suppress("unused")
val unlockKahootKidsPremiumPatch = bytecodePatch(
    name = "Unlock Premium",
    description = "Unlocks all Kahoot! Kids premium features in app. " +
        "Overrides the AccountManager methods that determine premium entitlement " +
        "to always return premium values, bypassing client-side " +
        "subscription validation.",
    default = true
) {
    compatibleWith(*COMPATIBILITY_KAHOOT_KIDS.toTypedArray())

    execute {
        // P1: hasFeature(Feature) -> always return true
        AccountManagerHasFeatureFingerprint.method.addInstructions(0, TRUE_RETURN)

        // P2: hasFeature(String) -> always return true
        AccountManagerHasFeatureStringFingerprint.method.addInstructions(0, TRUE_RETURN)

        // P3: hasActiveStandardSubscription() -> always return true
        AccountManagerHasActiveSubscriptionFingerprint.method.addInstructions(0, TRUE_RETURN)

        // P4: hasActiveStandardSubscriptionMatchingAppAndDeviceAppStore() -> always return true
        AccountManagerHasActiveSubscriptionMatchingAppStoreFingerprint.method.addInstructions(0, TRUE_RETURN)

        // P5: getProductFromMostPremiumStandardSubscription() -> return-object reference
        AccountManagerGetProductFingerprint.method.addInstructions(0, """
            const/4 v0, 0x0
            return-object v0
        """)

        // P6: getPlanLogoType() -> always return premium logo type
        AccountManagerGetPlanLogoTypeFingerprint.method.addInstructions(0, """
            const/4 v0, 0x2
            return v0
        """)
    }
}
