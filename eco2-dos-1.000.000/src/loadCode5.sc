;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 94)
(include sci.sh)
(use Main)
(use invSetupCode)
(use System)

(public
	loadCode5 0
)

(instance loadCode5 of Code
	(properties)

	(method (init)
		((ScriptID 99 0) doit: 81) ; invSetupCode
		(gInventory
			add:
				wallet
				photo
				slaughter_s_letter
				fax
				Princess__Mask
				password
				goldDisc
		)
	)

	(method (dispose)
		(gInventory
			delete:
				wallet
				photo
				slaughter_s_letter
				fax
				Princess__Mask
				password
				goldDisc
		)
		(DisposeScript 94)
	)
)

(instance Princess__Mask of EcoInvI
	(properties
		name {Princess' Mask}
		loop 2
		cel 8
		message 52
		noun 41
		flag 29
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (or (gEgo has: 12) (== ((gInventory at: 12) owner:) 800))
					(super doVerb: theVerb &rest)
				else
					(gGame points: 5)
					(gInventory hide:)
					(gEgo get: 12)
					(gInventory show:)
				)
			)
			(1 ; Look
				(if (or (gEgo has: 12) (== ((gInventory at: 12) owner:) 800))
					(super doVerb: theVerb &rest)
				else
					(gMessager say: noun theVerb 7 0 0 99) ; "The gold mask shows the face of a young girl. There is a funny bulge behind her eye."
				)
			)
			(10 ; magnifier
				(if (or (gEgo has: 12) (== ((gInventory at: 12) owner:) 800))
					(super doVerb: theVerb &rest)
				else
					(gMessager say: noun theVerb 7 0 0 99) ; "A gold disc is caught in the mask!"
				)
			)
		)
	)
)

(instance wallet of EcoInvI
	(properties
		loop 2
		cel 9
		message 31
		noun 30
		flag 25
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not (gEgo has: 7))
				(gInventory hide:)
				(gEgo get: 7)
				(gInventory showSelf:)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance photo of EcoInvI
	(properties
		loop 2
		cel 11
		message 34
		noun 33
		flag 26
	)
)

(instance slaughter_s_letter of EcoInvI
	(properties
		name {slaughter's letter}
		loop 2
		cel 10
		message 35
		noun 34
		flag 27
	)
)

(instance fax of EcoInvI
	(properties
		loop 2
		cel 12
		message 36
		noun 35
		flag 28
	)
)

(instance goldDisc of EcoInvI
	(properties
		loop 8
		cel 1
		message 57
		noun 58
		flag 30
	)
)

(instance password of EcoInvI
	(properties
		loop 8
		cel 6
		message 66
		noun 64
		flag 22
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 1) (not (HaveMouse))) ; Look
			(gGame setCursor: 996)
			(gMessager say: 64 1 0 1 0 99) ; "The word "RETHGUALS" is printed on the note."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

