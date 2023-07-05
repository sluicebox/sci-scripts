;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11511)
(include sci.sh)
(use Main)
(use GabeEgo)
(use n011)
(use northExit)
(use Feature)
(use Actor)

(public
	rm11511 0
)

(instance rm11511 of ExitRoom
	(properties
		picture 11511
		east 1150 ; backStageRm
		south 1150 ; backStageRm
		west 1150 ; backStageRm
	)

	(method (init)
		(super init: &rest)
		(if (or (== gEgo GabeEgo) (and (IsFlag 752) (== gEgo GraceEgo)))
			(pulley init:)
		)
		(if (not (IsFlag 752))
			(rope init:)
		)
		(if (and (not (IsFlag 772)) (== gEgo GabeEgo))
			(tape init:)
		)
	)
)

(instance pulley of GKFeature
	(properties
		modNum 1150
		nsLeft 130
		nsTop 23
		nsRight 321
		nsBottom 227
		sightAngle 360
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((and (== gEgo GraceEgo) (IsFlag 752))
						(gMessager say: 8 62 0 0 0 modNum) ; "(CONFIDENT)They'll find something else to use with the pulley."
					)
					((and (== gEgo GabeEgo) (IsFlag 772))
						(gMessager say: 10 62 0 0 0 modNum) ; "(SARCASTIC, AFTER TAKING TAPE)Serves them right. They should have used rope."
					)
					(else
						(gMessager say: 9 62 0 0 0 modNum) ; "(MILDLY CURIOUS)Wonder if this pulley is being used for anything?"
					)
				)
			)
			(22 ; invRope
				(gMessager say: 5 22 0 0 0 modNum) ; "(TRY TO RETURN ROPE TO PULLEY)It wouldn't do much good to put it back now."
			)
			(35 ; invRollOfTape
				(gMessager say: 6 35 0 0 0 modNum) ; "(TRY TO RETURN TAPE TO PULLEY)Nah. They'll find something else."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rope of View
	(properties
		modNum 1150
		x 475
		y 132
		view 30874
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 773)
					(SetFlag 752)
					(gEgo get: 69) ; invTheaterRope
					(PlayScene 877 0 1150) ; backStageRm
				else
					(SetFlag 773)
					(gMessager say: 11 62 0 0 0 modNum) ; "(THOUGHTFUL)That rope might come in handy."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tape of View
	(properties
		modNum 1150
		x 497
		y 121
		view 30874
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 774)
					(SetFlag 772)
					(gEgo get: 83) ; invRollOfTape
					(PlayScene 878 0 1150) ; backStageRm
				else
					(SetFlag 774)
					(gMessager say: 12 62 0 0 0 modNum) ; "(SNEAKY)That roll of tape might be useful."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

