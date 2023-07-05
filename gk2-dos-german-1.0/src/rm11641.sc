;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11641)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use dressingRm)
(use Polygon)
(use Feature)
(use Actor)

(public
	rm11641 0
)

(instance rm11641 of ExitRoom
	(properties
		picture 11641
		east 1160 ; dressingRm
		south 1160 ; dressingRm
		west 1160 ; dressingRm
	)

	(method (init)
		(self setRegions: 1030) ; dressRegion
		(super init: &rest)
		(= global145 0)
		(mirror init:)
		(if (not (gEgo has: 84)) ; invPowder
			(powder init:)
		)
	)

	(method (notify)
		(SetFlag 784)
		(gCurRoom newRoom: 1160) ; dressingRm
	)
)

(instance powder of View
	(properties
		modNum 1160
		x 2
		y 283
		view 30888
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 6 201 49 183 92 191 164 214 167 258 119 281 6 254
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 778)
					(Lock 140 1104 0) ; WAVE
					(gGk2Music fade: 0 20 10 1)
					(gEgo get: 84) ; invPowder
					(SetFlag 779)
					(= global145 889)
					(proc1160_1 889 0 1160)
				else
					(= global145 888)
					(proc1160_1 888 0 1160)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mirror of GKFeature
	(properties
		modNum 1160
		x 178
		y 85
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 25 0 331 0 327 115 53 170
					yourself:
				)
		)
		(super init: &rest)
		(mirror2 init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((and (not (IsFlag 780)) (not (IsFlag 778)))
						(= global145 890)
						(proc1160_1 890 0 1160)
					)
					((not (IsFlag 780))
						(proc1160_1 891 0 1160)
					)
					((IsFlag 779)
						(gMessager say: 5 62 0 0 0 modNum) ; "(HURRIED)There's no time to check my hair now!"
					)
					(else
						(gMessager say: 6 62 0 0 0 modNum) ; "(CLICK ON MIRROR WHEN ENGLEHART IS HERE)Someone else is usin' it at the moment."
					)
				)
			)
			(36 ; invPowder
				(if (IsFlag 780)
					(gMessager say: 7 62 0 0 0 modNum) ; MISSING MESSAGE
				else
					(gEgo put: 84) ; invPowder
					(SetFlag 782)
					(proc1160_1 892 0 1160)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mirror2 of GKFeature
	(properties
		modNum 1160
		x 178
		y 85
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 369 0 586 1 578 46 551 53 547 71 372 106 384 87 368 72
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(mirror doVerb: theVerb)
	)
)

