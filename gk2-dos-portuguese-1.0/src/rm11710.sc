;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11710)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use Actor)

(public
	rm11710 0
)

(instance rm11710 of ExitRoom
	(properties
		picture 11710
		east 1170 ; spotRm
		west 1170 ; spotRm
	)

	(method (init)
		(super init: &rest)
		(powerSwitch init:)
		(movingHandle init:)
		(southExit init:)
	)
)

(instance powerOff of View
	(properties
		x 201
		y 190
		view 30867
	)

	(method (onMe)
		(return 0)
	)
)

(instance powerSwitch of GKFeature
	(properties
		modNum 1170
		x 219
		y 125
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 164 110 207 99 212 78 258 68 277 94 283 128 274 162 224 180 193 183 155 166
					yourself:
				)
		)
		(super init: &rest)
		(if (not (IsFlag 770))
			(powerOff init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((not (IsFlag 741))
						(gMessager say: 3 62 0 0 0 1170) ; "(WORRIED)I SHOULD try to aim the spotlight, but I haven't decided where to seat von Glower yet."
					)
					((IsFlag 770)
						(ClearFlag 770)
						(powerOff init:)
						(PlayScene 867)
					)
					((IsFlag 771)
						(gMessager say: 2 62 0 0 0 1170) ; "(TRY TO TURN ON SPOTLIGHT AFTER AIMING IT)I have the spotlight aimed already. I don't want to chance burning out the light before it's time to use it."
					)
					(else
						(SetFlag 770)
						(powerOff dispose:)
						(PlayScene 866)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance movingHandle of GKFeature
	(properties
		modNum 1170
		x 77
		y 286
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 63 240 91 240 91 333 63 333
					yourself:
				)
		)
		(super init: &rest)
		(handle2 init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 771)
						(gMessager say: 4 62 0 0 0 1170) ; "I've aimed the spotlight already. I don't want to move it."
					)
					((and (IsFlag 770) (IsFlag 741))
						(PlayScene 1869 0 11752) ; rm11752
					)
					((IsFlag 770)
						(gMessager say: 3 62 0 0 0 1170) ; "(WORRIED)I SHOULD try to aim the spotlight, but I haven't decided where to seat von Glower yet."
					)
					(else
						(gMessager say: 22 62 0 0 0 modNum) ; "(TRY TO MOVE SPOTLIGHT HANDLE WHEN SPOTLIGHT IS OFF)No point in aiming it until it's on."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance handle2 of GKFeature
	(properties
		x 424
		y 202
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 251 331 551 235 572 80 597 73 569 251 323 331
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(movingHandle doVerb: theVerb)
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 225
		y 2000
		BAD_SELECTOR 4
	)

	(method (doVerb)
		(gCurRoom newRoom: 1170) ; spotRm
	)
)

