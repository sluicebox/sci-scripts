;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use invSetupCode)
(use System)

(public
	loadCode4 0
)

(instance loadCode4 of Code
	(properties)

	(method (init)
		((ScriptID 99 0) doit: 81) ; invSetupCode
		(gInventory add: goldenBlossom mazeNecklace)
	)

	(method (dispose)
		(gInventory delete: goldenBlossom mazeNecklace)
		(DisposeScript 93)
	)
)

(instance goldenBlossom of EcoInvI
	(properties
		loop 2
		cel 5
		message 27
		noun 26
		flag 8
	)
)

(instance mazeNecklace of EcoInvI
	(properties
		loop 6
		cel 1
		message 56
		noun 57
		flag 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; magnifier
				(gGame handsOff:)
				(if (not (IsFlag 13))
					(SetFlag 13)
					(gGame points: 5)
				)
				(gInventory hide:)
				(gCurRoom setInset: (ScriptID 12 0)) ; magMap
			)
			(1 ; Look
				(cond
					((not (IsFlag 13))
						(super doVerb: theVerb &rest)
					)
					((!= gCurRoomNum 820)
						(gMessager say: 57 1 5 0 0 99) ; "The map won't help you here."
					)
					(else
						(gTheIconBar disable: 6 5)
						(gInventory hide:)
						(gCurRoom setInset: (ScriptID 12 1)) ; bigMap
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

