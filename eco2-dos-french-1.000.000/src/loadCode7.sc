;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use Main)
(use invSetupCode)
(use System)

(public
	loadCode7 0
)

(instance loadCode7 of Code
	(properties)

	(method (init)
		((ScriptID 99 0) doit: 81) ; invSetupCode
		(gInventory add: golden_feather)
	)

	(method (dispose)
		(gInventory delete: golden_feather)
		(DisposeScript 96)
	)
)

(instance golden_feather of EcoInvI
	(properties
		name {golden feather}
		loop 4
		cel 12
		message 46
		noun 45
		flag 37
	)
)

