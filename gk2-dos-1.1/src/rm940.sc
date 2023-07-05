;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 940)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use Actor)

(public
	rm940 0
)

(instance rm940 of ExitRoom ; "Neuschwanstein: Chapel"
	(properties
		noun 16
		picture 9401
		south 920 ; rm920
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		)
		(super init: &rest)
		(painting init:)
		(windws init:)
		(cross init:)
		(blackMad init:)
	)
)

(instance painting of GKFeature
	(properties
		x 158
		y 48
		nextRoomNum 9440 ; neuChapPic
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 316 0 313 84 -1 80 1 0 yourself:)
		)
		(super init: &rest)
	)
)

(instance windws of GKFeature
	(properties
		x 525
		y 133
		nextRoomNum 9441 ; neuChapelWin
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 442 -2 437 237 611 269 613 -2
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance cross of GKFeature
	(properties
		x 158
		y 153
		nextRoomNum 9442 ; neuChapCross
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 111 101 109 120 145 137 145 224 179 224 179 137 208 121 204 102 177 94 173 82 154 82 140 100
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance blackMad of GKFeature
	(properties
		x 357
		y 158
		nextRoomNum 9443 ; rm9443
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 356 87 328 131 328 229 386 229 386 128
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tourTapeButton of Prop
	(properties
		noun 1
		modNum 940
		x 10
		y 290
		view 141
		loop 5
	)

	(method (cue)
		(gGame changeScore: 990)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 584)
			(gMessager say: noun 62 0 1 self modNum) ; "This is Ludwig's private chapel. The king was a devout Catholic, as were all of the Wittelsbacher rulers. They supported the Roman church, even when other European countries were dominated by Protestantism."
		else
			(super doVerb: theVerb)
		)
	)
)

