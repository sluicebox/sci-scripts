;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm280 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm280 of GloryRm
	(properties
		picture 280
		horizon 90
		north 250
		south 270
		west 260
		topX 128
	)

	(method (init)
		(= local3
			(cond
				((== global414 0) 1)
				((and (>= gDay (+ global414 1)) (not (IsFlag 46))) 2)
				((and (>= gDay (+ global414 1)) (IsFlag 46)) 3)
				(else 0)
			)
		)
		(ClearFlag 26)
		(if (not (OneOf gPrevRoomNum 250 260))
			(gLongSong number: 250 setLoop: -1 play:)
		)
		(gEgo init: normalize: setScaler: Scaler 122 50 189 87)
		(switch gPrevRoomNum
			(250
				(gEgo posn: 121 90)
				(= local0 125)
				(= local1 98)
			)
			(260
				(gEgo x: 8)
				(= local0 (+ (gEgo x:) 20))
				(= local1 (gEgo y:))
			)
			(270
				(gEgo posn: 92 240)
				(= local0 92)
				(= local1 175)
			)
			(380
				(gEgo loop: 5 posn: 260 115 setPri: 0)
			)
			(390
				(= local4 (gEgo cycleSpeed:))
				(gEgo
					view: 7
					setLoop: 3 1
					cel: 0
					posn: 72 90
					setSpeed: 15
					setScaler: Scaler 122 83 189 126
					setCycle: Walk
				)
			)
			(else
				(gEgo posn: 87 165)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 122 0 123 113 82 124 66 124 54 127 75 127 75 146 24 151 0 160
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 619 189 163 189 163 176 278 176 289 143 260 143 260 132 244 132 244 124 237 124 237 131 216 131 148 123 148 115 165 115 128 87 128 0 619 0
					yourself:
				)
		)
		(self
			addPoly:
				((Polygon new:)
					init: 97 87 137 87 180 104 175 120 82 120 103 113
					yourself:
				)
				50
				((Polygon new:)
					init: 319 130 319 189 102 189 155 182 209 141 256 149 303 130
					yourself:
				)
				75
				((Polygon new:)
					init: 205 128 288 131 275 139 214 139 161 150 70 188 24 169 126 136
					yourself:
				)
				120
		)
		(lowWall init:)
		(rope init: setPri: 34 approachVerbs: 4) ; Do
		(oldManDoor init: setPri: 17 approachVerbs: 4 42 28) ; Do, theToolkit, theLockpick
		(oldManWin init: approachVerbs: 4) ; Do
		(oldManBrick init: approachVerbs: 4) ; Do
		(craniumDoor init: setPri: 17 approachVerbs: 4 42 28) ; Do, theToolkit, theLockpick
		(craniumWin1 init: approachVerbs: 4) ; Do
		(craniumWin2 init:)
		(craniumSign init:)
		(nose init:)
		(mustache init:)
		(lantern1 init:)
		(lantern2 init:)
		(tree init:)
		(archWay init:)
		(if gNight
			(lamp1 init:)
			(lamp2 init:)
		)
		(if (and (not (IsFlag 45)) (!= gPrevRoomNum 390) (<= gTime 3))
			((ScriptID 84 0) ; oldMan
				init:
				approachVerbs: 4 2 ; Do, Talk
				setScaler: Scaler 111 75 189 108
				setScript: (ScriptID 84 1) ; sOldManWalk
			)
			(heroTeller
				init:
					gEgo
					280
					13
					128
					(switch local3
						(1 14)
						(2 15)
						(else 16)
					)
			)
			(oldManTeller
				init:
					(ScriptID 84 0) ; oldMan
					280
					13
					136
					(switch local3
						(1 14)
						(2 15)
						(else 16)
					)
			)
		)
		(super init: &rest)
		(cond
			((== gPrevRoomNum 380)
				(self setScript: sOutCraniumDoor)
			)
			((== gPrevRoomNum 390)
				(self setScript: sClimbOutOldMans)
			)
			((OneOf gPrevRoomNum 250 260 270)
				(self setScript: sEnterScr)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (== (gCurRoom script:) (ScriptID 31 1)) ; sLevitate
			(gEgo setScaler: Scaler 122 83 189 126)
			(Palette 2 66 85 100) ; PalIntensity
			(if (>= (gEgo z:) 20)
				(self setScript: sLevIntoOldMans)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(89 ; levitateSpell
				(if
					(and
						(>= gTime 4)
						(not (gCast contains: (ScriptID 84 0))) ; oldMan
					)
					((ScriptID 31 0) init: 96 120 100 0) ; leviCode
				else
					(gMessager say: 12 6 34) ; "You'd better not try that right now; you never know when someone might wander by."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (OneOf newRoomNumber 390 370 270)
			(gLongSong fade: 0)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(DisposeScript 82)
		(DisposeScript 84)
		(super dispose: &rest)
	)
)

(instance sEnterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath local0 local1 self)
			)
			(1
				(switch local3
					(2
						(SetFlag 46)
						(= cycles 1)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOutCraniumDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 2)
			)
			(1
				(gLongSong2 number: 960 loop: 1 play:)
				(craniumDoor setCycle: End self)
			)
			(2
				(gEgo setPri: -1 setMotion: MoveTo 230 137 self)
			)
			(3
				(craniumDoor setCycle: Beg self)
			)
			(4
				(gLongSong2 number: 961 loop: 1 play:)
				(= seconds 2)
			)
			(5
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoBellPuzzle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				((ScriptID 82 0) init: show: dispose:) ; bellPuzzle
				(DisposeScript 82)
				(= cycles 3)
			)
			(1
				1
				(gGlory handsOff:)
				(if (IsFlag 26)
					(gLongSong2 number: 960 loop: 1 play:)
					(craniumDoor setCycle: End self)
				else
					(= state 5)
					(gEgo setPri: -1 setMotion: MoveTo 230 137 self)
				)
			)
			(2
				2
				(gEgo setPri: 51 setMotion: MoveTo 260 115 self)
			)
			(3
				3
				(gEgo setPri: 0)
				(craniumDoor setCycle: Beg self)
			)
			(4
				4
				(gLongSong2 number: 961 loop: 1 play:)
				(= seconds 2)
			)
			(5
				5
				(gCurRoom newRoom: 380)
			)
			(6
				6
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sNaughtyFlash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(naughtyProp init: setCycle: End self)
			)
			(1
				(naughtyProp setCycle: Beg self)
			)
			(2
				(naughtyProp dispose:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHandOnBrick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 87 124 self)
			)
			(1
				(gEgo loop: 7)
				(= cycles 1)
			)
			(2
				(oldManBrick setCycle: End self)
			)
			(3
				(gMessager say: 12 6 39 0 self) ; "Maggots and weevils scurry about trying to find a new hiding place."
			)
			(4
				(oldManBrick setCycle: Beg self)
			)
			(5
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTellOfAnna of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init:
								(- (gEgo x:) 7)
								(- (gEgo y:) 5)
								(+ (gEgo x:) 7)
								(- (gEgo y:) 5)
								(+ (gEgo x:) 7)
								(+ (gEgo y:) 5)
								(- (gEgo x:) 7)
								(+ (gEgo y:) 5)
							yourself:
						)
				)
				(= cycles 2)
			)
			(1
				(gMessager say: 13 128 17 0 self) ; "You start to tell the old man about the ghost you met in the forest."
			)
			(2
				(if (gEgo actions:)
					((gEgo actions:) dispose:)
				)
				(SetFlag 45)
				((ScriptID 84 0) ; oldMan
					setScript: 0
					view: 284
					setLoop: -1
					setCycle: Walk
					ignoreActors: 1
					setMotion: PolyPath 100 195 self
				)
			)
			(3
				((ScriptID 84 0) setMotion: MoveTo 100 252 self) ; oldMan
			)
			(4
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(= cycles 2)
			)
			(5
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 122 0 123 113 82 124 66 124 54 127 75 127 75 146 24 151 0 160
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 319 189 163 189 163 176 278 176 289 143 260 143 260 132 244 132 244 124 237 124 237 131 216 131 148 123 148 115 165 115 128 87 128 0 319 0
							yourself:
						)
				)
				((ScriptID 84 0) hide:) ; oldMan
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbInOldMans of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local4 (gEgo cycleSpeed:))
				(gEgo
					view: 7
					setLoop: 3
					cel: 0
					setSpeed: 15
					setScaler: Scaler 122 83 189 126
					setCycle: Walk
					setMotion: MoveTo 72 90 self
				)
			)
			(1
				(SetFlag 70)
				(gMessager say: 13 134 5 0 self) ; "You carefully open the window and enter the darkened upstairs bedroom."
			)
			(2
				(gEgo setSpeed: local4)
				(gCurRoom newRoom: 390)
			)
		)
	)
)

(instance sClimbOutOldMans of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo 75 127 self)
			)
			(1
				(ClearFlag 70)
				(gEgo
					normalize: 3
					setSpeed: local4
					setMotion: MoveTo 99 135 self
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLevIntoOldMans of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo y: (- (gEgo y:) 20))
				(SetFlag 70)
				(gCurRoom north: 0)
				(= cycles 2)
			)
			(1
				(gCurRoom newRoom: 390)
			)
		)
	)
)

(instance heroTeller of Teller
	(properties)

	(method (respond)
		(super respond: &rest)
		(if (or (not iconValue) (== iconValue -999))
			(= global414 gDay)
		)
		(return 1)
	)

	(method (showCases)
		(super showCases: 17 (IsFlag 339)) ; Tell About Ghost Wife
	)

	(method (sayMessage)
		(if (== iconValue 17) ; Tell About Ghost Wife
			(self clean:)
			(gCurRoom setScript: sTellOfAnna)
		else
			(super sayMessage: &rest)
		)
	)
)

(instance oldManTeller of Teller
	(properties
		title 1
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 64 0)) ; oldmanTalker
	)

	(method (respond)
		(super respond: &rest)
		(if (or (not iconValue) (== iconValue -999))
			(= global414 gDay)
		)
		(return 1)
	)
)

(instance doorTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super
			showCases:
				35 ; Pick Lock
				(and
					(or (gEgo has: 24) (gEgo has: 13)) ; theToolkit, theLockpick
					(or (gCast contains: (ScriptID 84 0)) (<= gTime 3)) ; oldMan
				)
				36 ; Pick Lock
				(and
					(or (gEgo has: 24) (gEgo has: 13)) ; theToolkit, theLockpick
					(not (gCast contains: (ScriptID 84 0))) ; oldMan
					(>= gTime 4)
				)
		)
	)

	(method (sayMessage)
		(switch iconValue
			(36 ; Pick Lock
				(if (== (gEgo trySkill: 9 250) 1) ; pick locks
					(super sayMessage: 12 6 38 &rest) ; The lock clicks open, but now the door is jammed! Maybe you should try to get in some other way.
				else
					(super sayMessage: &rest) ; You lack the luck to lick this lock.
				)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance rope of View
	(properties
		noun 18
		sightAngle 180
		approachX 240
		approachY 125
		x 233
		y 124
		view 280
		loop 6
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sDoBellPuzzle)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lamp1 of View
	(properties
		sightAngle 180
		x 201
		y 79
		view 280
		loop 7
		signal 16384
	)
)

(instance lamp2 of View
	(properties
		sightAngle 180
		x 289
		y 72
		view 280
		loop 8
		signal 16384
	)
)

(instance oldManDoor of Prop
	(properties
		noun 2
		sightAngle 180
		approachX 64
		approachY 127
		x 43
		y 73
		view 280
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(doorTeller init: self 280 13 133)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 28 42) ; theLockpick, theToolkit
			(cond
				((IsFlag 45)
					(gMessager say: 2 42 8) ; "You hear the satisfying "Snick!" of a job well done."
				)
				((or (gCast contains: (ScriptID 84 0)) (not gNight)) ; oldMan
					(gMessager say: 2 42 1) ; "Dr. Cranium's eyes are watching. You'd best leave this sort of activity until nighttime."
				)
				(else
					(gMessager say: 2 42 2) ; "As you start to open the door, you hear footsteps inside. Someone's awake in there!"
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance oldManWin of Prop
	(properties
		noun 3
		sightAngle 180
		approachX 75
		approachY 127
		x 78
		y 47
		fixPriority 1
		view 280
		loop 1
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if
					(or
						(and (IsFlag 45) gNight)
						(and
							gNight
							(not (gCast contains: (ScriptID 84 0))) ; oldMan
						)
					)
					(if (== (gEgo trySkill: 11 225) 1) ; climbing
						(gCurRoom setScript: sClimbInOldMans)
					else
						(gMessager say: 12 6 9) ; "That window is higher than it looks."
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance craniumDoor of Prop
	(properties
		noun 4
		sightAngle 180
		x 235
		y 69
		view 280
		loop 3
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 397)
					(SetFlag 26)
					(sDoBellPuzzle start: 1)
					(gCurRoom setScript: sDoBellPuzzle)
				else
					(gCurRoom setScript: sDoBellPuzzle)
				)
			)
			(28 ; theLockpick
				(self setScript: sNaughtyFlash)
			)
			(42 ; theToolkit
				(self setScript: sNaughtyFlash)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance naughtyProp of Prop
	(properties
		x 205
		y 51
		fixPriority 1
		view 280
		loop 4
		signal 16385
	)
)

(instance oldManBrick of Prop
	(properties
		sightAngle 180
		x 69
		y 91
		fixPriority 1
		view 280
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self setScript: sHandOnBrick)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance craniumWin1 of Prop
	(properties
		noun 8
		sightAngle 180
		approachX 185
		approachY 127
		x 182
		y 41
		fixPriority 1
		view 280
		loop 5
		signal 16385
	)
)

(instance craniumWin2 of Feature
	(properties
		noun 8
		nsLeft 290
		nsTop 14
		nsRight 319
		nsBottom 42
		sightAngle 180
		approachX 288
		approachY 144
		x 304
		y 28
	)

	(method (doVerb theVerb)
		(craniumWin1 doVerb: theVerb &rest)
	)
)

(instance craniumSign of Feature
	(properties
		noun 9
		nsLeft 204
		nsTop 1
		nsRight 236
		nsBottom 27
		sightAngle 180
		x 220
		y 14
	)
)

(instance lowWall of Feature
	(properties
		noun 1
		nsLeft 192
		nsTop 157
		nsRight 319
		nsBottom 189
		sightAngle 180
		x 255
		y 173
	)
)

(instance nose of Feature
	(properties
		noun 5
		nsLeft 210
		nsTop 31
		nsRight 238
		nsBottom 51
		sightAngle 180
		x 224
		y 41
	)
)

(instance mustache of Feature
	(properties
		noun 6
		nsLeft 204
		nsTop 57
		nsRight 274
		nsBottom 71
		sightAngle 180
		x 239
		y 64
	)
)

(instance lantern1 of Feature
	(properties
		noun 7
		nsLeft 194
		nsTop 63
		nsRight 206
		nsBottom 80
		sightAngle 180
		x 200
		y 71
	)
)

(instance lantern2 of Feature
	(properties
		noun 7
		nsLeft 281
		nsTop 51
		nsRight 296
		nsBottom 73
		sightAngle 180
		x 288
		y 62
	)
)

(instance tree of Feature
	(properties
		noun 10
		nsTop -1
		nsRight 54
		nsBottom 145
		sightAngle 180
		x 27
		y 72
	)
)

(instance archWay of Feature
	(properties
		noun 11
		nsLeft 107
		nsTop 29
		nsRight 161
		nsBottom 102
		sightAngle 180
		x 134
		y 65
	)
)

