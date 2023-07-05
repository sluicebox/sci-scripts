;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4047)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm4047 0
)

(instance rm4047 of ExitRoom ; "Marienplatz"
	(properties
		modNum 400
		noun 10
		picture 4047
		south 400 ; marienRm
	)

	(method (init)
		(super init: &rest)
		(fWindow init:)
		(gGame handsOn:)
	)
)

(instance fWindow of Feature
	(properties
		modNum 400
	)

	(method (init)
		(self createPoly: 58 -1 575 -1 575 320 57 322)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 442)
					(gMessager say: 25 62 0 0 0 400) ; "(TRY TO BUY WATCH IN SHOP WINDOW, DRY AT END)I'd buy one, but I can't stand anythin' on my wrist. I have a similar problem with wedding rings."
				else
					(SetFlag 442)
					(gMessager say: 24 62 0 0 0 400) ; "(LOOK IN JEWELRY SHOP WINDOW)Swiss and German watches."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

