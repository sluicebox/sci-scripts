;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use Inset)
(use Polygon)
(use Feature)
(use Actor)

(public
	trunkInset 0
)

(instance trunkInset of Inset
	(properties
		picture 440
		disposeNotOnMe 1
		modNum 28
		noun 3
	)

	(method (init)
		(gGame doRemap: 0 254)
		(gGame fade: 100 0 10)
		(cond
			((gPqFlags test: 29)
				(PalVary 8 441) ; PalVaryNewSource
			)
			((gPqFlags test: 27)
				(PalVary 8 440) ; PalVaryNewSource
			)
		)
		(super init: &rest)
		(gTheIconBar disable: 0 3 7 6 show: 0)
		(FrameOut)
		(gGame fade: 0 100 10)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (drawInset)
		(super drawInset:)
		(sGun init:)
		(homBox init:)
		(shells init:)
		(bannerTape init:)
	)

	(method (onMe param1)
		(return (and (<= 50 (param1 x:) 280) (<= 0 (param1 y:) 190)))
	)

	(method (dispose)
		(gTheIconBar enable: 0 3 7)
		(if (not (gPqFlags test: 1))
			(gTheIconBar enable: 6)
		)
		(gGame fade: 100 0 10)
		(super dispose:)
		(if (and (== gCurRoomNum 170) (gPqFlags test: 27))
			(PalVary 3) ; PalVaryKill
		)
		(FrameOut)
		(gGame fade: 0 100 10)
		(gGame doRemap: 2 254 75)
	)
)

(instance shells of Feature
	(properties
		noun 2
		modNum 28
		nsLeft 56
		nsTop 71
		nsRight 76
		nsBottom 84
		sightAngle 40
		approachX 70
		approachY 79
		approachDist 0
		x 66
		y 77
	)

	(method (init)
		(if (or (gEgo has: 12) (== ((gInventory at: 12) owner:) 580)) ; shotgun, shotgun
			(return)
		else
			(super init:)
			(= onMeCheck
				((Polygon new:) type: PTotalAccess init: 58 80 68 67 75 76 65 89 yourself:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (!= gCurRoomNum 170)
					(gMessager say: 2 4 3 1 0 28) ; "These 12 gauge shotgun shells are not needed at this time."
				else
					(sGun doVerb: theVerb)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else
				(sGun doVerb: theVerb)
			)
		)
	)
)

(instance sGun of View
	(properties
		noun 1
		modNum 28
		x 132
		y 1
		view 441
		signal 4096
	)

	(method (init)
		(if (or (gEgo has: 12) (== ((gInventory at: 12) owner:) 580)) ; shotgun, shotgun
			(return)
		else
			(super init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(46 ; keys
				(cond
					((!= gCurRoomNum 170)
						(gMessager say: 1 46 1 1 0 28) ; "Deadly use of force is unnecessary at this time."
					)
					((gPqFlags test: 147)
						(gMessager say: 1 46 4 1 0 28) ; "The shotgun is already unlocked."
					)
					(else
						(gPqFlags set: 147)
						(gGame points: 3)
						(gMessager say: 1 46 2 1 0 28) ; "You unlock the shotgun."
					)
				)
			)
			(4 ; Do
				(cond
					((!= gCurRoomNum 170)
						(gMessager say: 1 4 1 1 0 28) ; "Use of force to this degree is unnecessary at this time."
					)
					((gPqFlags test: 147)
						(gGame points: 2)
						(gPqFlags clear: 147)
						(gEgo get: 12) ; shotgun
						(gEgo get: 15) ; shells
						(shells dispose:)
						(self dispose:)
					)
					(else
						(gMessager say: 1 4 5 1 0 28) ; "The shotgun is locked."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance homBox of View
	(properties
		noun 4
		modNum 28
		x 162
		y 140
		view 441
		cel 1
		signal 4096
	)

	(method (init)
		(if (gEgo has: 3) ; evidenceCase
			(return)
		else
			(super init:)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gEgo get: 3) ; evidenceCase
			(gGame points: 2 108)
			(self dispose:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance bannerTape of Feature
	(properties
		noun 5
		modNum 28
		x 175
		y 65
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 165 40 173 36 203 42 205 57 202 64 195 64 193 62 186 62 175 65 165 65
					yourself:
				)
		)
	)
)

