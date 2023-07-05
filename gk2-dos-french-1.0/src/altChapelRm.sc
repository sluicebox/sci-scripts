;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1010)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	altChapelRm 0
)

(instance altChapelRm of ExitRoom ; "Alt\99tting: Chapel"
	(properties
		noun 17
		picture 10101
	)

	(method (init)
		(if (OneOf gPrevRoomNum 1000 24) ; altExtRm, whereTo
			(gSoundManager play: 0 1011 1012 1013)
		)
		(gEgo
			posn: 97 378
			heading: 45
			normalize:
			setScaler: Scaler 100 36 417 275
			init:
		)
		(super init: &rest)
		(churchExit init:)
		(archway init:)
		(priestOffice init:)
		(wall init:)
		(if (Random 0 1)
			(piousOnes init:)
		)
		(if (Random 0 1)
			(otherPiousOnes init:)
		)
		(if (Random 0 1)
			(morePiousOnes init:)
		)
	)
)

(instance piousOnes of Prop
	(properties
		noun 18
		modNum 1010
		sightAngle 360
		x 61
		y 251
		view 20799
	)

	(method (init)
		(super init: &rest)
		(self setScript: (FidgetScript new:))
	)
)

(instance otherPiousOnes of Prop
	(properties
		noun 18
		modNum 1010
		sightAngle 360
		x 109
		y 230
		view 22799
	)

	(method (init)
		(super init: &rest)
		(self setScript: (FidgetScript new:))
	)
)

(instance morePiousOnes of Prop
	(properties
		noun 18
		modNum 1010
		sightAngle 360
		x 455
		y 223
		view 21799
	)

	(method (init)
		(super init: &rest)
		(self setScript: (FidgetScript new:))
	)
)

(instance archway of GKFeature
	(properties
		sightAngle 40
		x 228
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 178 285 170 134 197 108 229 99 249 106 271 123 278 146 279 285
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (not (IsFlag 714)))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 714)
						(gCurRoom newRoom: 10102)
					)
					((IsFlag 715)
						(gMessager say: 2 62) ; "(CLICK ON INNER SHRINE)I don't think I'm allowed back there without the priest."
					)
					(else
						(gMessager say: 1 62) ; "(ALTOTTING MAIN CHAPEL, CLICK ON INNER SHRINE)The Madonna must be in that inner shrine. I'm not sure I can go back there by myself."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance priestOffice of ExitFeature
	(properties
		sightAngle 40
		x 560
		y 170
		exitDir 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 524 59 593 7 597 333 524 333
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 721)
					(ClearFlag 721)
				)
				(gCurRoom newRoom: 1020) ; priestOfficeRm
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wall of GKFeature
	(properties
		sightAngle 360
		x 275
		y 71
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 170 127 166 15 236 -1 346 1 384 30 383 134 348 120 317 120 300 144 279 144 273 120 249 101 228 94 200 104
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(SetFlag 719)
				(gMessager say: 3 62) ; "(LOOK AT WALLS IN CHAPEL, HUSHED)The walls are covered with silver penitent offerings."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance churchExit of ExitFeature
	(properties
		sightAngle 40
		approachX 109
		approachY 600
		x 289
		y 310
		exitDir 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 433 332 140 332 140 288 438 288
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 721)
					(ClearFlag 721)
				)
				(gCurRoom newRoom: 10010)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

