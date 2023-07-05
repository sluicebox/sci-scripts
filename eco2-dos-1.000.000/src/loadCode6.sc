;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use Main)
(use invSetupCode)
(use System)

(public
	loadCode6 0
)

(instance loadCode6 of Code
	(properties)

	(method (init)
		((ScriptID 99 0) doit: 81) ; invSetupCode
		(gInventory add: whistle)
	)

	(method (dispose)
		(gInventory delete: whistle)
		(DisposeScript 95)
	)
)

(instance whistle of EcoInvI
	(properties
		loop 4
		cel 11
		message 45
		noun 44
		flag 38
	)
)

