;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3240)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm3240 0
)

(instance rm3240 of ExitRoom ; "Leber's Office"
	(properties
		modNum 320
		noun 9
		picture 3240
		south 320 ; leberRm
	)

	(method (init)
		(super init: &rest)
		(fMap init:)
		(if (IsFlag 25)
			(fGrossbergInfo init:)
		)
		(gGame handsOn:)
	)
)

(instance fGrossbergInfo of Feature
	(properties)

	(method (init)
		(self createPoly: 556 64 611 64 611 137 556 137)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 3242)
			)
			(133 ; invGabeNotebook
				(if (gEgo has: 34) ; invGrosPhoneNumber
					(gMessager say: 34 62 0 0 0 320) ; "(TRY TO WRITE DOWN GROSSBERG'S NAME AND NUMBER AGAIN)I already wrote it down."
				else
					(PlayScene 1346)
					(gEgo get: 34) ; invGrosPhoneNumber
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fMap of Feature
	(properties
		modNum 320
		nsLeft 10
		nsRight 490
		nsBottom 307
		x 240
		y 48
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 518)
					(gMessager say: 7 62 0 0 0 320) ; "(LOOKING AT CRIME LOCATION MAP, STUBBORN)I still say that the one in the middle is different."
				else
					(SetFlag 518)
					(PlayScene 347)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

