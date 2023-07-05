;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use invSetupCode)
(use System)

(public
	loadCode2 0
)

(instance loadCode2 of Code
	(properties)

	(method (init)
		((ScriptID 99 0) doit: 81) ; invSetupCode
		(gInventory add: rainforest_fruit)
	)

	(method (dispose)
		(gInventory delete: rainforest_fruit)
		(DisposeScript 91)
	)
)

(instance rainforest_fruit of EcoInvI
	(properties
		name {rainforest fruit}
		cel 4
		message 65
		noun 63
		flag 11
	)
)

