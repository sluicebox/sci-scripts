;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 730)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use Scaler)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	rm730 0
)

(instance rm730 of SQRoom
	(properties
		noun 1
		picture 730
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 228 137 164 137 308 88 274 124
					yourself:
				)
		)
		(gEgo init: normalize:)
		(super init:)
		(switch gPrevRoomNum
			(735
				(gEgo
					setScaler: Scaler 100 30 138 94
					enterRoom: 308 88 290 97 self
				)
				(if (!= (gGSound1 number:) 640)
					(gGSound1 number: 640 setLoop: -1 play:)
				)
			)
			(else
				(gGSound1 number: 640 setLoop: -1 play:)
				(gCurRoom setScript: getOff)
			)
		)
		(wormF init:)
		(ileumF init:)
		(colonF init:)
		(wormHairs init: setPri: 150 cycleSpeed: 2 setCycle: Fwd)
		(exit735 init: gTheExitECursor approachVerbs: 7) ; ExitRight
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (dispose)
		(gEgo setScale: 0 normalize:)
		(super dispose:)
	)
)

(instance getOff of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 66 104 setScaler: Scaler 100 30 138 94)
				(= cycles 1)
			)
			(1
				(if (not (IsFlag 129))
					(SetFlag 129)
					(gMessager say: 0 0 1 0 self) ; "YEOW! Now that's a ride you won't take in the Magic Kingdom."
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo setMotion: MoveTo 211 126 self)
			)
			(3
				(gEgo setHeading: 180 self)
			)
			(4
				(gEgo normalize: 2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mountWorm of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 4 0 0 self) ; "So you like the worm, huh?"
			)
			(1
				(gEgo setMotion: MoveTo 113 111 self)
			)
			(2
				(proc0_7 1 1 self)
			)
			(3
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(= cycles 1)
			)
			(4
				(gGSound1 stop:)
				(proc0_7 0 1 self)
			)
			(5
				(= gAutoRobot
					((WalkieTalkie new:)
						init: 0 670 self
						x: 92
						y: 14
						priority: 200
						start:
						yourself:
					)
				)
			)
			(6
				(gCurRoom newRoom: 670)
			)
		)
	)
)

(instance wormHairs of Actor
	(properties
		noun 2
		x 166
		y 112
		view 735
		signal 20481
	)

	(method (doVerb theVerb)
		(wormF doVerb: theVerb &rest)
	)
)

(instance colonF of Feature
	(properties
		noun 3
		x 305
		y 92
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 270 64 287 52 308 48 319 57 319 86 305 93 278 92 270 85
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ileumF of Feature
	(properties
		noun 4
		x 118
		y 15
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 140 0 137 8 123 20 90 24 74 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance wormF of Feature
	(properties
		noun 2
		x 45
		y 130
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 122 20 54 31 0 57 0 129 17 138 58 138 74 135 77 138 156 138 159 132 172 132 179 126 180 114 175 95 165 89 157 92 148 82 136 77 102 77 84 82 74 94 71 100 41 102 23 98 32 72 48 60 61 45 96 36
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: mountWorm)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exit735 of ExitFeature
	(properties
		sightAngle 40
		approachX 308
		approachY 88
		nextRoom 735
		message 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 285 50 320 50 320 93 274 93 263 82 263 62
					yourself:
				)
		)
		(super init: &rest)
	)
)

