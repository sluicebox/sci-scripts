;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4642)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm4642 0
)

(instance rm4642 of ExitRoom
	(properties
		modNum 460
		picture 4642
		south 460 ; ritualRm
	)

	(method (init)
		(super init: &rest)
		(fBook init:)
		(gGame handsOn:)
	)

	(method (dispose)
		(if (and (IsFlag 525) (IsFlag 524))
			(PlayScene 335 0 -1)
		)
		(super dispose:)
	)
)

(instance fBook of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 -1 600 -1 614 190 615 336 0 333
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gGame changeScore: 959)
				(gMessager say: 5 62 0 0 0 460) ; "(LOOK AT VON ZELL'S LITTLE BLACK BOOK, WRY AT END)Preiss, von Aigner, Hennemann. I met them all last night. I wonder what these figures mean? Unpaid club dues?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

