;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11410)
(include sci.sh)
(use Main)
(use GabeEgo)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm11410 0
)

(instance rm11410 of ExitRoom
	(properties
		picture 11410
		east 1140 ; centerHallRm
		south 1140 ; centerHallRm
		west 1140 ; centerHallRm
	)

	(method (init)
		(super init: &rest)
		(handles init:)
		(lock init:)
		(if (IsFlag 762)
			(rope init:)
		)
	)
)

(instance sEndAct1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 738)
				(ClearFlag 737)
				(= gEgo GabeEgo)
				(gUser alterEgo: gEgo)
				(gEgo get: 3) ; invRitterDagger
				(Lock rsAUDIO 1103 0)
				(= cycles 1)
			)
			(1
				(gCast eachElementDo: #dispose)
				(PlayScene 851 self -1)
			)
			(2
				(gGame handsOff:)
				(gGk2Music fade: 0 20 10 1 self)
			)
			(3
				(= ticks 180)
			)
			(4
				(gGame handsOff:)
				(pActTwo init: setCycle: End self)
			)
			(5
				(= ticks 180)
			)
			(6
				(pActTwo setCycle: Beg self)
			)
			(7
				(pActTwo dispose:)
				(= ticks 60)
			)
			(8
				(Lock rsAUDIO 1104 1)
				(gGk2Music setLoop: -1 number: 1104 play:)
				(gCurRoom newRoom: 1185) ; propRm
				(self dispose:)
			)
		)
	)
)

(instance pActTwo of Prop
	(properties
		x 165
		y 120
		view 106
		loop 3
	)
)

(instance rope of View
	(properties
		modNum 1140
		x 263
		y 216
		view 11410
	)

	(method (doVerb theVerb)
		(handles doVerb: theVerb)
	)
)

(instance banner of View ; UNUSED
	(properties
		modNum 1140
		x 263
		y 216
		view 11410
		loop 1
	)

	(method (doVerb theVerb)
		(handles doVerb: theVerb)
	)
)

(instance handles of GKFeature
	(properties
		modNum 1140
		sightAngle 40
		x 307
		y 251
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 256 260 256 239 369 239 369 260
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 762)
					(gMessager say: 2 62 0 0 0 1140) ; "(WORRIED)I have to hide that rope. An usher might see it and take it off."
				else
					(gMessager say: 1 62 0 0 0 1140) ; "(PENSIVE)The handles look sturdy."
				)
			)
			(33 ; invBanner
				(if (IsFlag 762)
					(gEgo put: 68) ; invBanner
					(gCurRoom setScript: sEndAct1)
				else
					(gMessager say: 8 33 0 0 0 1140) ; "(INTERESTED BUT DOUBTFUL)Hmmm. That's an idea, but the banner alone won't block the doors. It's not strong enough."
				)
			)
			(105 ; invTheaterRope
				(cond
					((IsFlag 763)
						(SetFlag 762)
						(gEgo put: 69) ; invTheaterRope
						(PlayScene 850 0 1140) ; centerHallRm
					)
					((IsFlag 736)
						(gMessager say: 23 22 0 0 0 1140) ; "(WORRIED)I'm not even sure von Glower's IN there."
					)
					((IsFlag 741)
						(gMessager say: 21 62 0 0 0 1140) ; "(INTERESTED)That might work, but I'll have to wait until von Glower's in here."
					)
					(else
						(gMessager say: 20 62 0 0 0 1140) ; "(TRY TO USE ROPE ON DOORS BEFORE DECIDING TO SEAT VON GLOWER HERE)I'm not sure why I'd want to do that."
					)
				)
			)
			(else
				(gMessager say: 26 0 0 0 0 1140) ; "(THEATER UPSTAIRS HALL, DISAPPOINTED)That won't work."
			)
		)
	)
)

(instance lock of GKFeature
	(properties
		modNum 1140
		sightAngle 40
		x 321
		y 266
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 326 283 326 261 351 261 351 283
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 62) ; Do
				(cond
					((IsFlag 762)
						(gMessager say: 4 62 0 0 0 1140) ; "(WORRIED)That rope will have to do. I don't have the key."
					)
					((IsFlag 735)
						(gMessager say: 22 62 0 0 0 1140) ; "(THOUGHTFUL)At least there's a lock. It looks like it hasn't been used in a long time, though."
					)
					(else
						(gMessager say: 3 62 0 0 0 1140) ; "(WORRIED)I never did find the key."
					)
				)
			)
			((OneOf theVerb 112 113 52 66 37 39) ; ???, invCarKeys, invHuberKeys, invLibraryKey, invTheaterKeys, invXaverKeys
				(gMessager say: 5 0 0 0 0 1140) ; "(DISAPPOINTED)That key doesn't fit."
			)
			(else
				(gMessager say: 6 0 0 0 0 1140) ; "(THEATER UPSTAIRS HALL, DISAPPOINTED)That won't work on the lock."
			)
		)
	)
)

