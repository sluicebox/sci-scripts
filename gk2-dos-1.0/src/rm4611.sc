;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4611)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm4611 0
)

(instance rm4611 of ExitRoom ; "Hunt Club: Ritual Room"
	(properties
		modNum 460
		noun 6
		picture 4611
		south 460 ; ritualRm
	)

	(method (init)
		(super init: &rest)
		(if (and (IsFlag 525) (IsFlag 524))
			(PlayScene 333 0 460) ; ritualRm
		else
			(fPictures init:)
			(fWeapons init:)
			(gGame handsOn:)
		)
	)
)

(instance fPictures of GKFeature
	(properties
		modNum 460
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 176 94 176 227 434 227 434 94
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 4640)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fWeapons of GKFeature
	(properties
		modNum 460
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 139 -1 190 11 189 15 201 24 207 36 207 36 226 52 227 103 265 122 234 61 196 64 170 34 154 29 144
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 204 51 208 58 219 60 237 43 239 50 254 50 257 41 364 38 380 28 478 27 477 18 327 18 325 4 219 4 219 15 241 25 227 30 162 30 138 34 147 74
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 575 138 525 182 534 201 491 235 513 261 555 215 561 202 568 203 571 225 590 220 586 197 609 188 616 177 615 129 605 112
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 485 189 532 140 538 142 548 133 541 124 547 114 553 118 564 114 568 102 617 62 616 36 594 55 584 43 578 48 567 60 521 90 525 100 534 101 531 115 461 160
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 129 188 87 144 71 139 58 117 48 121 38 121 33 112 14 103 12 93 -2 83 -1 46 15 55 23 52 30 57 32 63 79 84 74 93 69 109 81 121 90 119 125 140 127 149 150 162
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 4 62 0 0 0 460) ; "(LOOK AT WEAPONS IN BASEMENT)What the hell do these guys hunt, anyway? Ninjas?"
		else
			(super doVerb: theVerb)
		)
	)
)

