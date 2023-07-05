;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Cemetery)
(use Polygon)
(use Feature)
(use Timer)
(use Motion)
(use Game)
(use System)

(public
	rm310 0
)

(local
	local0 = 1
	local1
)

(instance rm310 of Room
	(properties
		modNum 301
		noun 1
		picture 310
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(gGkMusic1 setVol: (gGkMusic1 musicVolume:))
		(gGame handsOn:)
		(fenceF init:)
		(fenceB init:)
		(plant1 init:)
		(plant2 init:)
		(vase1 init:)
		(vase2 init:)
		(cross init:)
		(face init:)
		(snakeM init:)
		(plaque1 init: approachVerbs: 7 11) ; Look, Talk
		(plaque2 init: approachVerbs: 7 11) ; Look, Talk
		(plaque3 init: approachVerbs: 7 11) ; Look, Talk
		(plaque4 init: approachVerbs: 7 11) ; Look, Talk
		(plaque5 init: approachVerbs: 7 11) ; Look, Talk
		(plaque6 init: approachVerbs: 7 11) ; Look, Talk
		(tomb1 init: approachVerbs: 7) ; Look
		(tomb2 init: approachVerbs: 7) ; Look
		(tomb3 init: approachVerbs: 7) ; Look
		(tomb4 init: approachVerbs: 7) ; Look
		(wrightTomb init: approachVerbs: 7) ; Look
		(westExit init:)
		(eastExit init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 145 268 145 268 133 319 133 319 88 263 88 250 103 221 103 183 108 157 98 152 101 123 104 113 106 130 118 78 128 47 122 18 129 0 122
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 143 104 148 108 130 110 125 106
					yourself:
				)
		)
		(if (== gCurRoomNum ((ScriptID 301 1) room:)) ; xKeeper
			((ScriptID 301 1) ignoreActors: 0 posn: 140 140 init:) ; xKeeper
			(keeperTimer2 setReal: keeperTimer2 (Random 25 40))
			(= local1
				((Polygon new:)
					type: PBarredAccess
					init: 109 143 108 130 175 132 175 144
					yourself:
				)
			)
			(gCurRoom addObstacle: local1)
		)
		(gEgo normalize: init: state: 2)
		(switch gPrevRoomNum
			(50 ; interrogation
				((ScriptID 301 1) room: 310 posn: 140 140 init:) ; xKeeper
				(gEgo posn: (- (xKeeper x:) 57) (+ (xKeeper y:) 5))
				(keeperTimer2 setReal: keeperTimer2 (Random 25 40))
				(self setScript: (ScriptID 301 4)) ; sStopTalkingToKeeper
				(gCurRoom west: 300)
				(gCurRoom east: 320)
			)
			(300
				(self setScript: sEnterFromWest)
			)
			(else
				(self setScript: sEnterFromEast)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (gEgo inRect: 314 110 319 150) (not local0))
			(= local0 1)
			(gCurRoom newRoom: 320)
		)
	)

	(method (dispose)
		(if ((gCurRoom obstacles:) contains: local1)
			((gCurRoom obstacles:) delete: local1)
			(local1 dispose:)
		)
		(keeperTimer2 dispose: delete: client: 0)
		(DisposeScript 21)
		(super dispose:)
	)
)

(instance sEnterFromWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					normalize: 1
					posn: -10 130
					state: 2
					setMotion: MoveTo 25 130 self
				)
			)
			(1
				(gCurRoom west: 300)
				(gCurRoom east: 320)
				(gGame handsOn:)
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					normalize: 1
					posn: 320 113
					state: 2
					setMotion: MoveTo 257 113 self
				)
			)
			(1
				(gCurRoom west: 300)
				(gCurRoom east: 320)
				(gGame handsOn:)
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

(instance sKeeperLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if ((gCurRoom obstacles:) contains: local1)
					((gCurRoom obstacles:) delete: local1)
					(local1 dispose:)
				)
				(gEgo setMotion: 0)
				((ScriptID 301 1) ; xKeeper
					ignoreActors: 1
					view: 304
					setCel: 0
					setLoop: 0
					setCycle: CT 4 1 self
				)
			)
			(1
				((ScriptID 301 3) dispose:) ; trashCan
				((ScriptID 301 1) setCel: 5 setCycle: End self) ; xKeeper
			)
			(2
				((ScriptID 301 1) ; xKeeper
					room: 300
					view: 306
					setSpeed: 8
					setCel: 0
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo -30 135 self
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cross of Feature
	(properties
		noun 3
		nsTop 45
		nsRight 7
		nsBottom 63
		sightAngle 20
		x 86
		y 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 80 46 80 39 76 32 71 32 71 26 81 26 81 20 90 21 90 25 99 26 99 32 91 32 91 45
					yourself:
				)
		)
		(super init:)
	)
)

(instance face of Feature
	(properties
		noun 2
		nsTop 45
		nsRight 7
		nsBottom 63
		sightAngle 20
		x 316
		y 189
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 128 313 128 296 113 292 99 294 92 292 88 293 76 287 76 288 83 281 81 279 76 284 70 301 70 310 62 319 68
					yourself:
				)
		)
		(super init:)
	)
)

(instance plaque1 of Feature
	(properties
		noun 10
		sightAngle 20
		approachX 129
		approachY 131
		x 98
		y 94
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 77 74 95 73 95 86 77 88 yourself:)
		)
		(super init:)
	)
)

(instance plaque2 of Feature
	(properties
		noun 11
		sightAngle 20
		approachX 129
		approachY 131
		x 98
		y 94
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 71 115 84 98 86 98 72
					yourself:
				)
		)
		(super init:)
	)
)

(instance plaque3 of Feature
	(properties
		noun 12
		sightAngle 20
		approachX 129
		approachY 131
		x 98
		y 94
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 78 91 95 89 95 101 78 104
					yourself:
				)
		)
		(super init:)
	)
)

(instance plaque4 of Feature
	(properties
		noun 13
		sightAngle 20
		approachX 129
		approachY 131
		x 98
		y 94
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 86 115 99 98 101 98 89
					yourself:
				)
		)
		(super init:)
	)
)

(instance plaque5 of Feature
	(properties
		noun 14
		sightAngle 20
		approachX 129
		approachY 131
		x 98
		y 94
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 78 107 96 104 96 116 79 119
					yourself:
				)
		)
		(super init:)
	)
)

(instance plaque6 of Feature
	(properties
		noun 15
		sightAngle 20
		approachX 129
		approachY 131
		x 98
		y 94
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 101 115 114 99 115 99 104
					yourself:
				)
		)
		(super init:)
	)
)

(instance tomb1 of Feature
	(properties
		noun 4
		sightAngle 20
		approachX 57
		approachY 134
		x 18
		y 94
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 79 5 79 5 66 0 66 0 60 5 60 6 53 14 53 14 59 26 60 25 66 15 66 16 78 25 78 39 90 37 92 37 124 0 130
					yourself:
				)
		)
		(super init:)
	)
)

(instance tomb2 of Feature
	(properties
		noun 5
		sightAngle 20
		approachX 158
		approachY 114
		x 127
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 120 52 111 50 110 46 67 46 71 41 133 41 149 58 149 101 120 101
					yourself:
				)
		)
		(super init:)
	)
)

(instance wrightTomb of Feature
	(properties
		noun 1
		sightAngle 20
		approachX 129
		approachY 131
		x 98
		y 93
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 36 87 16 75 17 65 23 65 24 59 17 58 16 52 26 50 29 46 108 46 111 50 119 53 119 115 73 122 36 115
					yourself:
				)
		)
		(super init:)
	)
)

(instance tomb3 of Feature
	(properties
		noun 6
		sightAngle 20
		approachX 233
		approachY 135
		x 300
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 21 319 140 269 140 268 66 265 55 303 21
					yourself:
				)
		)
		(super init:)
	)
)

(instance tomb4 of Feature
	(properties
		noun 7
		sightAngle 20
		approachX 227
		approachY 112
		x 205
		y 58
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 162 94 162 42 197 21 235 40 235 92 184 98
					yourself:
				)
		)
		(super init:)
	)
)

(instance snakeM of Feature
	(properties
		noun 9
		sightAngle 20
		x 248
		y 51
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 246 93 246 72 245 36 244 33 243 29 244 27 246 25 250 27 249 35 254 73 258 73 259 94 250 94
					yourself:
				)
		)
		(super init:)
	)
)

(instance fenceF of Feature
	(properties
		noun 2
		modNum 301
		sightAngle 20
		x 10
		y 138
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 112 12 118 24 129 29 134 101 136 103 140 103 145 0 145
					yourself:
				)
		)
		(super init:)
	)
)

(instance fenceB of Feature
	(properties
		noun 2
		modNum 301
		nsLeft 140
		nsTop 47
		nsRight 280
		nsBottom 84
		sightAngle 20
		x 210
		y 30
	)
)

(instance vase1 of Feature
	(properties
		noun 3
		modNum 301
		nsLeft 128
		nsTop 68
		nsRight 141
		nsBottom 88
		sightAngle 20
		x 134
		y 108
		z 30
	)
)

(instance plant1 of Feature
	(properties
		noun 4
		modNum 301
		nsLeft 127
		nsTop 56
		nsRight 145
		nsBottom 68
		sightAngle 20
		x 136
		y 108
		z 46
	)
)

(instance vase2 of Feature
	(properties
		noun 3
		modNum 301
		nsLeft 223
		nsTop 62
		nsRight 247
		nsBottom 79
		sightAngle 20
		x 235
		y 103
		z 33
	)
)

(instance plant2 of Feature
	(properties
		noun 4
		modNum 301
		nsLeft 224
		nsTop 51
		nsRight 251
		nsBottom 61
		sightAngle 20
		x 237
		y 102
		z 46
	)
)

(instance westExit of ExitFeature
	(properties
		nsTop 110
		nsBottom 150
		nsRight 5
		cursor 962
		exitDir 4
		eCursor 0
	)
)

(instance eastExit of ExitFeature
	(properties
		nsTop 110
		nsLeft 314
		nsBottom 150
		nsRight 319
		cursor 963
		exitDir 2
		eCursor 0
	)
)

(instance keeperTimer2 of Timer
	(properties)

	(method (cue)
		(if (== ((ScriptID 301 1) script:) (ScriptID 301 2)) ; xKeeper, sKeeperStuff
			((ScriptID 301 1) setScript: sKeeperLeaves) ; xKeeper
		else
			(self setReal: keeperTimer2 (Random 25 40))
		)
	)
)

