;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use invSetupCode)
(use System)

(public
	loadCode3 0
)

(instance loadCode3 of Code
	(properties)

	(method (init)
		((ScriptID 99 0) doit: 81) ; invSetupCode
		(gInventory add: leaf vine)
	)

	(method (dispose)
		(gInventory delete: leaf vine)
		(DisposeScript 92)
	)
)

(instance vine of EcoInvI
	(properties
		cel 6
		message 14
		noun 14
		flag 4
	)
)

(instance leaf of EcoInvI
	(properties
		cel 8
		message 15
		noun 15
		flag 5
	)
)

