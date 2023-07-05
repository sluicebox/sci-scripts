;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2142)
(include sci.sh)
(use Main)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm2142 0
)

(instance rm2142 of ExitRoom
	(properties
		picture 2142
		south 210 ; farmIntRm
	)

	(method (init)
		(super init: &rest)
		(huberNote init:)
		(gGame handsOn:)
	)
)

(instance huberNote of GKFeature
	(properties
		x 327
		y 170
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 116 19 537 20 538 320 117 322
					yourself:
				)
		)
		(super init: &rest)
		(gGame changeScore: 825)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 21 62 0 1 0 210) ; "(READING FRAU HUBER'S NOTE)Herr Knight. The keys for the car are by the door. It is better not to drive inside Munich. Drive road 96 to Lochham. Park the car and take the U-bahn from there. Thank you for helping us. Frau Huber."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

