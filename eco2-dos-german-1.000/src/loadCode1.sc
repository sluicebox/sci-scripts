;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use invSetupCode)
(use System)

(public
	loadCode1 0
)

(instance loadCode1 of Code
	(properties)

	(method (init)
		((ScriptID 99 0) doit: 81) ; invSetupCode
		(gInventory add: sharpRock)
	)

	(method (dispose)
		(gInventory delete: sharpRock)
		(DisposeScript 90)
	)
)

(instance sharpRock of EcoInvI
	(properties
		loop 4
		cel 13
		message 47
		noun 55
		flag 39
	)
)

