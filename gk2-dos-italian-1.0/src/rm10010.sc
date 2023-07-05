;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10010)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm10010 0
)

(local
	local0
)

(instance rm10010 of ExitRoom ; "Alt\99tting: Church Exterior"
	(properties
		modNum 1000
		noun 8
		picture 10010
		east 10002 ; rm10002
		south 10045 ; rm10045
		west 1000 ; altExtRm
	)

	(method (init)
		(if (and (gEgo has: 58) (IsFlag 705) (IsFlag 385) (IsFlag 387)) ; invOperaAct3
			(= local0 1)
		else
			(= local0 0)
		)
		(if local0
			(Lock 140 10045 1) ; WAVE
			(gGk2Music number: 10045 setLoop: -1 play: 0 0 fade: 63 10 10 0)
		else
			(Lock 140 1000 1) ; WAVE
			(gGk2Music number: 1000 setLoop: -1 play: 0 0 fade: 63 10 10 0)
		)
		(super init: &rest)
		(chapelDoors init:)
	)
)

(instance chapelDoors of GKFeature
	(properties
		sightAngle 40
		x 274
		y 158
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 389 299 166 317 157 0 392 20
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					(
						(and
							(gEgo has: 58) ; invOperaAct3
							(IsFlag 705)
							(IsFlag 385)
							(IsFlag 387)
						)
						(gGk2Music fade: 0 10 10 1 0)
						(Lock 140 (gGk2Music number:) 0) ; WAVE
						(if (== gPrevRoomNum 1000) ; altExtRm
							(PlayScene 788 0 1010) ; altChapelRm
						else
							(PlayScene 1788 0 1010) ; altChapelRm
						)
					)
					((== gPrevRoomNum 1000) ; altExtRm
						(PlayScene 787 0 10002) ; rm10002
					)
					(else
						(PlayScene 1787 0 1000) ; altExtRm
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

