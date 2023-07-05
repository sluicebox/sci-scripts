;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3242)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm3242 0
)

(instance rm3242 of ExitRoom ; "Leber's Office"
	(properties
		modNum 320
		noun 9
		picture 3242
		south 3240 ; rm3240
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 25)
			(fGrossbergInfo init:)
		)
		(gGame handsOn:)
	)
)

(instance fGrossbergInfo of Feature
	(properties)

	(method (init)
		(self createPoly: 202 22 446 20 449 307 204 310)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (gEgo has: 34) ; invGrosPhoneNumber
					(gMessager say: 33 62 0 0 0 320) ; "(LOOK AT GROSSBERG'S NAME AND NUMBER ON MAP--AFTER WRITING IT DOWN)The latest victim's name and number."
				else
					(gMessager say: 8 62 0 0 0 320) ; "(THOUGHTFUL)Grossberg. Didn't Leber say that was the name of the guy who was killed last night?"
				)
			)
			(133 ; invGabeNotebook
				(if (gEgo has: 34) ; invGrosPhoneNumber
					(gMessager say: 34 62 0 0 0 320) ; "(TRY TO WRITE DOWN GROSSBERG'S NAME AND NUMBER AGAIN)I already wrote it down."
				else
					(PlayScene 1346 0 3240) ; rm3240
					(gEgo get: 34) ; invGrosPhoneNumber
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

