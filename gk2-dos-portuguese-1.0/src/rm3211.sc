;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3211)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm3211 0
)

(instance rm3211 of ExitRoom ; "Leber's Office"
	(properties
		modNum 320
		noun 9
		picture 3241
		south 320 ; leberRm
	)

	(method (init)
		(super init: &rest)
		(fPaper init:)
		(gGame handsOn:)
	)
)

(instance fPaper of GKFeature
	(properties
		modNum 320
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gEgo get: 48) ; invLedgerPage
				(SetFlag 682)
				(SetFlag 22)
				(gCurRoom newRoom: 320) ; leberRm
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

