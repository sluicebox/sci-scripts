;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4048)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)

(public
	rm4048 0
)

(instance rm4048 of ExitRoom ; "Marienplatz"
	(properties
		modNum 400
		noun 10
		picture 4048
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
		(self createPoly: 29 -1 616 -1 616 334 398 334 58 246)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 23 62 0 0 0 400) ; "(LOOK IN BOOK SHOP WINDOW)Lots of Neitze and Kant. I don't understand that stuff even when it's in ENGLISH."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

