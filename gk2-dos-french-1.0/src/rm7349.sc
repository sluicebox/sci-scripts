;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7349)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Actor)

(public
	rm7349 0
)

(instance rm7349 of ExitRoom
	(properties
		modNum 730
		picture 7349
		south 7301 ; rm7301
	)

	(method (init)
		(if (not (IsFlag 718))
			(silverHeart init:)
		)
		(if (IsFlag 610)
			(roses init:)
		)
		(super init: &rest)
	)
)

(instance roses of View
	(properties
		modNum 730
		x 241
		y 175
		view 30461
		loop 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 610)
				(= noun 13)
			else
				(= noun 12)
			)
		)
		(super doVerb: theVerb)
	)
)

(instance silverHeart of View
	(properties
		modNum 730
		sightAngle 360
		x 190
		y 300
		view 30461
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(cond
				((IsFlag 388) ; "Silver Heart" in srHallTopicRmCh6
					(SetFlag 718)
					(gEgo get: 63) ; invSilverHeart
					(PlayScene 772 0 7301) ; rm7301
				)
				((and (not (IsFlag 719)) (not (IsFlag 607)))
					(= noun 14)
				)
				((and (not (IsFlag 698)) (IsFlag 719))
					(SetFlag 698)
					(SetFlag 717) ; enable "Silver Heart" in srHallTopicRmCh6
					(gGame changeScore: 1113 1)
					(= noun 16)
				)
				((and (not (IsFlag 719)) (IsFlag 607))
					(= noun 15)
				)
				(else
					(SetFlag 717) ; enable "Silver Heart" in srHallTopicRmCh6
					(= noun 17)
				)
			)
			(super doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

