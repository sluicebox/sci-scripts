;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use enterScript)
(use Talker)
(use Polygon)
(use System)

(public
	rm220 0
)

(instance rm220 of ApartmentRoom
	(properties
		picture 220
		style -32761
		east 200
		south 200
	)

	(method (init)
		(self
			setRegions: 51 ; bubblesRegion
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: -100 -70 419 -70 419 178 319 178 281 145 285 106 306 64 283 26 223 11 116 15 37 50 28 113 61 151 167 170 248 189 248 259 -100 259
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (notify)
		(EcoNarrator init: 1 0 0 1) ; "Apparently, no one lives in this apartment."
		(HandsOn)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(EcoNarrator store: 5 init: 1 0 0 4) ; "This apartment perhaps once belonged to one of Flesh-Eater's victims or an Elurian killed by the effects of pollution."
			)
			(4 ; Do
				(EcoNarrator init: 1 0 0 2) ; "There's nothing to do here. The apartment is empty."
			)
			(44 ; Inventory
				(EcoNarrator init: 1 0 0 2) ; "There's nothing to do here. The apartment is empty."
			)
			(2 ; Talk
				(EcoNarrator init: 1 0 0 3) ; "There is no response. The apartment is unoccupied."
			)
			(6 ; Recycle
				(EcoNarrator init: 1 0 0 6) ; "There is no trash in the empty apartment."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

