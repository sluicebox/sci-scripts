;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1185)
(include sci.sh)
(use Main)
(use GK2Ego)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	propRm 0
)

(instance propRm of ExitRoom ; "Wittelsbacher Theater: Prop Room"
	(properties
		noun 5
		picture 11851
	)

	(method (init)
		(if (== gEgo GraceEgo)
			(gEgo posn: 341 255)
		else
			(gEgo posn: 389 280)
		)
		(gEgo heading: 225 normalize: setScaler: Scaler 83 50 325 247 init:)
		(if (== gEgo GraceEgo)
			(Palette 1 (= global249 245)) ; PalLoad
			(gEgo setPri: 280)
		else
			(Palette 1 (= global249 244)) ; PalLoad
		)
		(super init: &rest)
		(cond
			((== gEgo GraceEgo)
				(openDoor init:)
				(if (not (IsFlag 790))
					(SetFlag 790)
					(PlayScene 916)
				)
			)
			((not (IsFlag 728))
				(SetFlag 728)
				(PlayScene 918)
			)
		)
		(uselessJunk init:)
		(heapOCrap init:)
		(basementExit init:)
		(cabinet init:)
	)
)

(instance openDoor of View
	(properties
		x 262
		y 263
		view 30916
	)

	(method (init)
		(super init: &rest)
		((gUser hotCursor:) delete: self)
	)

	(method (onMe)
		(return 0)
	)
)

(instance basementExit of ExitFeature
	(properties
		modNum 1185
		x 345
		y 163
		exitDir 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 272 238 267 82 417 75 424 251
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (respondsTo)
		(if (and (== gEgo GraceEgo) (== (gUser curVerb:) 62))
			(super respondsTo: &rest)
		else
			(return 0)
		)
	)

	(method (setCursor param1)
		(if (== gEgo GabeEgo)
			(super setCursor: param1)
		else
			(param1 view: 998)
			(param1 loop: 0)
			(param1 cel: exitDir)
		)
	)

	(method (handleEvent event)
		(if (== gEgo GabeEgo)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (== gEgo GraceEgo)
					(gCurRoom newRoom: 11805)
				else
					(PlayScene 919)
					(gEgo heading: 225)
				)
			)
			(37 ; invTheaterKeys
				(if (== gEgo GraceEgo)
					(if (IsFlag 744)
						(gMessager say: 2 37 0 0 0 modNum) ; "(USE KEYS ON PROP ROOM DOOR AFTER FIRST TIME)I've already tested the keys. They work."
					else
						(SetFlag 799)
						(gCurRoom setScript: sWalkOut)
					)
				else
					(gMessager say: 1 62 0 0 0 modNum) ; "(USE INVENTORY ITEMS ON DOOR, DOUBTFUL)I can't open the door with that!"
				)
			)
			(else
				(if (== gEgo GabeEgo)
					(gMessager say: 1 62 0 0 0 modNum) ; "(USE INVENTORY ITEMS ON DOOR, DOUBTFUL)I can't open the door with that!"
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance sWalkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(gCurRoom newRoom: 11805)
				(self dispose:)
			)
		)
	)
)

(instance cabinet of ExitFeature
	(properties
		sightAngle 40
		x 189
		y 166
		nextRoomNum 11853 ; rm11853
		exitDir 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 110 235 110 98 269 98 269 235
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance uselessJunk of GKFeature
	(properties
		noun 6
		modNum 1185
		nsLeft 419
		nsTop 65
		nsRight 627
		nsBottom 346
		sightAngle 360
	)

	(method (doVerb theVerb)
		(if (== gEgo GraceEgo)
			(= noun 3)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance heapOCrap of GKFeature
	(properties
		noun 6
		modNum 1185
		nsLeft 15
		nsTop 91
		nsRight 183
		nsBottom 346
		sightAngle 360
	)

	(method (doVerb theVerb)
		(if (== gEgo GraceEgo)
			(= noun 8)
		)
		(super doVerb: theVerb &rest)
	)
)

