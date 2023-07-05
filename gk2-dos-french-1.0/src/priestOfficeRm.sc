;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1020)
(include sci.sh)
(use Main)
(use GK2Ego)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Polygon)
(use Feature)
(use Actor)

(public
	priestOfficeRm 0
)

(local
	local0
)

(instance priestOfficeRm of ExitRoom ; "Alt\99tting: Priest's Office"
	(properties
		noun 3
		picture 10201
	)

	(method (init)
		(if (and (gEgo has: 58) (IsFlag 705) (IsFlag 385) (IsFlag 387)) ; invOperaAct3, "Our Plan" in smithTopicCh6, "Von Glower's Letter" in smithTopicCh6
			(= local0 1)
		else
			(= local0 0)
		)
		(Lock 140 (gGk2Music number:) 0) ; WAVE
		(if local0
			(gGk2Music fade: 0 10 10 1 0)
		else
			(Lock 140 1020 1) ; WAVE
			(gGk2Music number: 1020 setLoop: -1 play:)
		)
		(if (== gEgo GraceEgo)
			(gEgo posn: 500 318 setScaler: Scaler 83 70 322 292)
		else
			(gEgo posn: 450 313 setScaler: Scaler 100 81 342 292)
		)
		(gEgo heading: 225 normalize: init:)
		(super init: &rest)
		(if (not (IsFlag 714))
			(SetFlag 708)
			(vPriest init:)
		)
		(if (== gPrevRoomNum 10002)
			(PlayScene 789)
		)
		(if local0
			(churchDoorExit init:)
		else
			(churchDoorGK init:)
		)
		(waterBasket init:)
		(exterior init:)
	)
)

(instance vPriest of Prop
	(properties
		sightAngle 360
		x 199
		y 332
		view 20102
	)

	(method (init)
		(super init: &rest)
		(self setScript: FidgetScript)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 709)
					(gMessager say: 1 62 0 0 0 1020) ; "(PICKUP, NEED A BIT NICER, ALTOTTING PRIEST'S OFFICE, CLICK ON PRIEST AFTER FIRST CONVERSATION)I'm not making myself understood."
				else
					(SetFlag 709)
					(PlayScene 793)
					(gEgo get: 64) ; invPriestCard
				)
			)
			(102 ; invPriestCard
				(if (and (not local0) (IsFlag 785))
					(gMessager say: 2 0 0 0 0 1020) ; "(TRY TO GET PRIEST TO TAKE YOU TO SHRINE)He won't take me into the shrine until the service is over."
				else
					(SetFlag 785)
					(if local0
						(SetFlag 713)
						(PlayScene 795 0 10102) ; rm10102
					else
						(PlayScene 797)
					)
				)
			)
			(101 ; invSilverHeart
				(if (and (not local0) (IsFlag 785))
					(gMessager say: 2 0 0 0 0 1020) ; "(TRY TO GET PRIEST TO TAKE YOU TO SHRINE)He won't take me into the shrine until the service is over."
				else
					(SetFlag 785)
					(if local0
						(SetFlag 713)
						(PlayScene 794 0 10102) ; rm10102
					else
						(PlayScene 796)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance waterBasket of GKFeature
	(properties
		sightAngle 40
		approachX 320
		approachY 324
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 191 157 237 155 239 183 257 179 352 188 358 160 407 162 401 271 377 290 349 277 321 306 233 300 193 261
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 1142))
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 1142)
					(gMessager say: 4 10 0 0 0 1020) ; "(CLICK ON WATER BOTTLES AFTER GETTING ONE)I don't need another bottle."
				else
					(gCurRoom newRoom: 10211)
				)
			)
			(10 ; invGraceWallet
				(if (IsFlag 1142)
					(gMessager say: 4 10 0 0 0 1020) ; "(CLICK ON WATER BOTTLES AFTER GETTING ONE)I don't need another bottle."
				else
					(PlayScene 1792)
					(gEgo get: 62) ; invBottleOfWater
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance churchDoorExit of ExitFeature
	(properties
		sightAngle 40
		x 139
		y 166
		exitDir 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 136 277 13 298 9 9 139 27
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(PlayScene 792 0 1010) ; altChapelRm
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance churchDoorGK of GKFeature
	(properties
		sightAngle 40
		x 139
		y 166
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 136 277 13 298 9 9 139 27
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(PlayScene 791)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exterior of ExitFeature
	(properties
		sightAngle 40
		x 573
		y 166
		exitDir 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 533 0 614 0 614 332 533 332
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 10002)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

