;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 305)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryRoom)
(use PolyFeature)
(use Polygon)
(use Feature)
(use DPath)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm305 0
	rideTram 1
)

(local
	local0
)

(instance rm305 of LarryRoom
	(properties
		noun 1
		picture 505
		style 1024
		horizon 0
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 320 101 317 95 306 91 269 91 216 100 259 34 212 34 212 102 217 104 267 95 239 122 183 98 143 102 78 101 78 95 64 94 64 100 0 101 0 141 320 139
					yourself:
				)
		)
		(if (not (IsFlag 35))
			(gEgo normalize: 900 8 ignoreActors: 0 init:)
			(gGame handsOn:)
		)
		(switch gPrevRoomNum
			(640
				(gEgo x: 12 y: (gEgo y:) edgeHit: 0 cel: 0)
			)
			(580
				(gEgo x: 218 y: 104 setLoop: 0 setPri: 30 edgeHit: 0)
				(if (not (IsFlag 35))
					(self setScript: enterFrom580Scr)
				)
			)
			(300
				(gEgo x: 310 y: (gEgo y:) edgeHit: 0 cel: 1)
			)
			(else
				(gEgo setHeading: 180 posn: 310 118)
			)
		)
		(bluesBarExitPoly init:)
		(hallDoor init:)
		(pornPic init:)
		(sculpture1 init:)
		(sculpture2 init:)
		(banister init:)
		(carpet init:)
		(windowFrame init:)
		(hallCover init: ignoreActors: 1)
		(if (IsFlag 35)
			(if (IsFlag 36)
				((ScriptID 825 1) z: 0 view: 90 posn: 0 126 init:) ; tram
			else
				((ScriptID 825 1) z: 0 view: 90 posn: 319 126 init:) ; tram
			)
			((ScriptID 825 2) play: setLoop: -1) ; tramSoundFx
			(self setScript: rideTram)
		)
		(if (not (gGlobalSound2 handle:))
			(gGlobalSound2 number: 200 play: setLoop: -1)
		)
		(super init: &rest)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script 0)
			((bluesBarExitPoly onMe: (gEgo x:) (gEgo y:))
				(self setScript: goDownStairsScr)
			)
			((gEgo inRect: 219 91 249 106)
				(if (not local0)
					(= local0 1)
					(gEgo setPri: 30)
				)
			)
			(local0
				(gEgo setPri: -1)
				(= local0 0)
			)
		)
	)

	(method (edgeToRoom param1)
		(switch param1
			(2
				(self setScript: exitEastScr)
			)
			(4
				(self setScript: exitWestScr)
			)
		)
		(return 0)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 580)
			(gGlobalSound2 fade:)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(DisposeScript 64964)
		(bluesBarExitPoly dispose:)
		(super dispose:)
	)
)

(instance rideTram of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar
					disableIcon:
						(ScriptID 0 3) ; icon0
						(ScriptID 0 5) ; icon2
						(ScriptID 0 9) ; icon6
						(ScriptID 0 6) ; icon3
					enableIcon: (ScriptID 0 4) (ScriptID 0 7) ; icon1, icon4
					show:
				)
				(if (OneOf global166 (ScriptID 0 4) (ScriptID 0 7)) ; icon1, icon4
					(gTheIconBar curIcon: global166)
				else
					(gTheIconBar curIcon: (ScriptID 0 7)) ; icon4
				)
				(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				(User canControl: 1 canInput: 1)
				(cond
					((and (IsFlag 36) (> ((ScriptID 825 1) x:) 319)) ; tram
						(self cue:)
					)
					((IsFlag 36)
						((ScriptID 825 1) ; tram
							setCycle: Walk
							setMotion: MoveTo 319 126 self
						)
					)
					((< ((ScriptID 825 1) x:) 0) ; tram
						(self cue:)
					)
					(else
						((ScriptID 825 1) ; tram
							setCycle: Walk
							setMotion: MoveTo -20 126 self
						)
					)
				)
			)
			(1
				(DisposeScript 826)
				(if (IsFlag 36)
					(gCurRoom newRoom: 300)
				else
					(gCurRoom newRoom: 640)
				)
			)
		)
	)
)

(instance goDownStairsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 10)
			)
			(1
				(gEgo setLoop: 1 setPri: 30 setMotion: MoveTo 218 104 self)
			)
			(2
				(gCurRoom newRoom: 580)
			)
		)
	)
)

(instance enterFrom580Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 224 101)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: DPath 267 91 274 90 self)
			)
			(2
				(gGame handsOn:)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromWestScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(gEgo setMotion: MoveTo 12 118 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromEastScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(gEgo setMotion: MoveTo 310 118 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitEastScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 340 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance exitWestScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -20 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 640)
			)
		)
	)
)

(instance sculpture1 of Feature
	(properties
		noun 7
		sightAngle 40
		x 9
		y 97
	)

	(method (init)
		(super init: &rest)
		(self setPolygon: (sculpturePoly1 init: yourself:))
	)
)

(instance sculpture2 of Feature
	(properties
		noun 9
		sightAngle 40
		x 114
		y 97
	)

	(method (init)
		(super init: &rest)
		(self setPolygon: (sculpturePoly2 init: yourself:))
	)
)

(instance hallDoor of Feature
	(properties
		noun 2
		modNum 205
		approachX 72
		approachY 93
		x 72
		y 90
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 4 ; Do
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 93 92 55 92 52 44 84 44 yourself:)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: (ScriptID 96 0)) ; knockOnDoorScr
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pornPic of Feature
	(properties
		noun 3
		sightAngle 40
		x 214
		y 104
		z 37
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 230 99 218 95 221 55 231 57
					yourself:
				)
		)
	)
)

(instance banister of Feature
	(properties
		noun 8
		sightAngle 40
		x 272
		y 87
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 314 59 314 73 282 73 242 84 242 70 283 59
					yourself:
				)
		)
	)
)

(instance windowFrame of PolyFeature
	(properties
		noun 5
		modNum 205
		sightAngle 40
		y 205
		variableX 1
	)

	(method (init)
		(self
			addPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 320 119 320 129 282 139 47 139 21 136 1 137 1 125 38 123 127 134 189 135 199 92 202 51 200 27 194 0 214 0 219 44 220 78 212 115 206 131 264 127
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance carpet of PolyFeature
	(properties
		noun 1
		modNum 205
		variableX 1
		variableY 1
	)

	(method (init)
		(self
			addPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 320 140 1 139 1 99 51 97 55 93 93 93 94 99 149 99 163 73 182 72 189 93 235 117 243 111 243 97 266 91 308 90 320 94
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance hallCover of View
	(properties
		x 135
		y 32
		priority 97
		fixPriority 1
		view 305
		loop 1
	)
)

(instance bluesBarExitPoly of Polygon
	(properties)

	(method (init)
		(super init: 240 89 240 107 235 111 229 109 229 89)
	)
)

(instance sculpturePoly1 of Polygon
	(properties)

	(method (init)
		(super init: 31 17 28 65 1 65 1 18)
	)
)

(instance sculpturePoly2 of Polygon
	(properties)

	(method (init)
		(super init: 133 17 134 64 101 67 93 18)
	)
)

