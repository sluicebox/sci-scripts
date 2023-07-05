;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use eRS)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Door)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm500 0
)

(local
	local0
	local1
	local2
)

(instance rm500 of FPRoom
	(properties
		noun 16
		picture 500
		style 10
		north 670
		south 310
	)

	(method (init)
		(LoadMany rsSOUND 502 501)
		(LoadMany rsVIEW 501 500 124)
		(gEgo init: setScale: Scaler 79 50 189 35 normalize:)
		(switch gPrevRoomNum
			(south
				(gEgo x: 160)
				(gGame handsOn:)
			)
			(230
				(gCurRoom setScript: sEnterFrom230)
			)
			(235
				(gCurRoom setScript: sEnterFrom230)
			)
			(670
				(gEgo loop: 2)
				(gEgo edgeHit: 0)
			)
			(680
				(gGame handsOn:)
			)
			(else
				(gEgo x: 160 y: 160)
				(gGame handsOn:)
			)
		)
		(super init: self)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 183 189 183 182 211 182 211 164 238 164 238 143 295 143 295 132 240 109 206 109 206 74 199 74 199 110 194 110 194 114 154 114 154 112 146 112 146 105 96 105 96 108 87 108 87 113 70 113 70 118 45 118 45 91 58 47 58 31 14 31 14 34 53 34 53 48 50 48 30 94 30 118 23 118 23 179 138 179 138 189 0 189
					yourself:
				)
		)
		(cond
			((or (IsFlag 1) (IsFlag 29))
				(= local1 1)
			)
			((not (IsFlag 14))
				(hopSingh init: setScript: sSinghShift)
			)
		)
		(if (and (not (IsFlag 1)) (< gCurPuzzle 19))
			(gGameMusic1 number: 501 loop: -1 play:)
		)
		(if (and (> gAct 2) (not (IsFlag 14)))
			(pie init: approachVerbs: 4 setCycle: Fwd) ; Do
		)
		(if (not (IsFlag 30))
			(icepick init: stopUpd: approachVerbs: 1 4) ; Look, Do
		)
		(if (not (IsFlag 65))
			(elixir init: stopUpd: approachVerbs: 1 4) ; Look, Do
		)
		(saloonBackDoor init: stopUpd:)
		(barrel init:)
		(momsWindow init:)
		(roomsSign init:)
		(roofTop init: setOnMeCheck: 1 4)
		(elixirWagon init: setOnMeCheck: 1 8)
		(trunks init: setOnMeCheck: 1 16)
		(tree init: setOnMeCheck: 1 32)
		(stairs init: setOnMeCheck: 1 64)
		(topSign init: setOnMeCheck: 1 128)
		(bottomSign init: setOnMeCheck: 1 256)
		(hotel init: setOnMeCheck: 1 512)
		(poster init: setOnMeCheck: 1 1024)
		(leaflet init: setOnMeCheck: 1 2048)
		(moms init: setOnMeCheck: 1 4096)
		(saloon init: setOnMeCheck: 1 8192)
		(if (IsFlag 52)
			(dummyCredits init: setScript: (ScriptID 32 0)) ; sOpeningCredits
		)
	)

	(method (doit &tmp [temp0 20])
		(super doit:)
		(if (and (not (IsFlag 14)) local1 (not (IsFlag 29)) (not (IsFlag 1)))
			(hopSingh init: setScript: sSinghShift)
			(= local1 0)
		)
		(cond
			(script)
			((gEgo inRect: 18 100 60 114)
				(gCurRoom setScript: sClimbStairs 0 1)
			)
			((gEgo inRect: 36 49 62 56)
				(gCurRoom setScript: sClimbStairs 0 2)
			)
			((proc0_1 gEgo 2)
				(gCurRoom setScript: sExitTo230)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 230) (OneOf gCurPuzzle 8 9 20 22))
			(= newRoomNumber 235)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(if (!= gCurPuzzle 14)
			(gGameMusic1 fade: 0 30 12 1)
		)
		(DisposeScript 32)
		(super dispose:)
	)
)

(instance sExitTo230 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 0 setMotion: PolyPath 60 33 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo setHeading: 270 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gEgo setMotion: MoveTo 40 33 self)
			)
			(5
				(gEgo setPri: -1)
				(gCurRoom newRoom: 230)
			)
		)
	)
)

(instance sEnterFrom230 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 40 33 setPri: 0)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 60 33 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo setHeading: 200 self)
			)
			(4
				(= cycles 2)
			)
			(5
				(gEgo
					setLoop: 5
					setPri: -1
					setLoop: -1
					setMotion: MoveTo 57 48 self
				)
			)
			(6
				(if (HaveMouse)
					(self setScript: sClimbStairs self 2)
				else
					(= cycles 2)
				)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch register
					(1
						(gEgo setLoop: 3 setMotion: MoveTo 42 92 self)
					)
					(2
						(++ state)
						(gEgo setPri: -1 setMotion: PolyPath 36 115 self)
					)
				)
			)
			(1
				(gEgo setMotion: PolyPath 57 48 self)
			)
			(2
				(if (and (== register 1) (HaveMouse))
					(= next sExitTo230)
				else
					(gGame handsOn:)
					(gEgo setLoop: -1)
				)
				(self dispose:)
			)
		)
	)
)

(instance sStopFreddy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable:)
				(gMessager say: 17 4 1 0 self) ; "You slyly attempt to swipe the apple pie from under Hop Singh's nose!"
			)
			(1
				(gEgo view: 124 setLoop: 2 setCel: 0 setCycle: CT 6 1 self)
				(= local2 (hopSingh cycleSpeed:))
				(hopSingh
					setLoop: 0
					setCel: 0
					setCycle: 0
					setSpeed: 10
					posn: 138 92
				)
			)
			(2
				(hopSingh setCycle: End self)
				(gGameMusic1 number: 502 loop: 1 play: self)
			)
			(3 0)
			(4
				(gGameMusic1 number: 501 loop: -1 play:)
				(gEgo setCel: 0)
				(= seconds 3)
			)
			(5
				(gEgo normalize: loop: 0)
				(hopSingh setSpeed: local2 setScript: sSinghShift)
				(gMessager say: 17 4 2 0 self) ; "Nice try, Freddy Pharkas! You want me remove your hands with Ginfu Knife? I happy to accommodate!"
			)
			(6
				(gGame handsOn:)
				(gTheIconBar enable:)
				(self dispose:)
			)
		)
	)
)

(instance sGetPie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 124 setLoop: 2 setCel: 0 setCycle: CT 6 1 self)
			)
			(1
				(pie dispose:)
				(gEgo setCycle: End self)
			)
			(2
				(gGame points: 1 0 self)
			)
			(3
				(gEgo normalize: loop: 0)
				(gEgo get: 43 pie) ; Pie
				(SetFlag 14)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSinghShift of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (if (not (Random 0 2)) 138 else 151))
				(hopSingh
					setLoop: 1
					setCycle: Fwd
					xStep: 2
					setMotion: MoveTo local0 (hopSingh y:) self
				)
			)
			(1
				(cond
					((== (hopSingh loop:) 0)
						(hopSingh
							setLoop: 1
							setMotion: MoveTo 151 (hopSingh y:) self
						)
						(-- state)
					)
					((== (hopSingh x:) 138)
						(hopSingh setLoop: 0 setCel: 0)
						(-- state)
						(= seconds (Random 2 3))
					)
					(else
						(= seconds (Random 3 7))
					)
				)
			)
			(2
				(hopSingh setLoop: 2 setMotion: MoveTo 122 (hopSingh y:) self)
			)
			(3
				(= seconds (Random 3 7))
			)
			(4
				(self changeState: 0)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance saloonBackDoor of Door
	(properties
		x 211
		y 104
		noun 3
		approachX 203
		approachY 111
		view 500
		loop 1
		entranceTo 670
		openSnd 2146
		closeSnd 2147
		openVerb 4
		moveToX 203
		moveToY 100
		enterType 0
		exitType 0
	)

	(method (createPoly)
		(super createPoly: 187 108 187 102 219 102 219 108)
	)
)

(instance pie of Prop
	(properties
		x 137
		y 98
		z 10
		noun 17
		approachX 120
		approachY 114
		view 500
		signal 16384
		cycleSpeed 12
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 29)
					(gCurRoom setScript: sGetPie)
				else
					(hopSingh setScript: 0 setMotion: 0)
					(gCurRoom setScript: sStopFreddy)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hopSingh of Actor
	(properties
		x 124
		y 96
		noun 19
		view 501
		priority 1
		signal 16400
	)
)

(instance dummyCredits of Prop
	(properties
		x -10
		y -10
		view 996
	)
)

(instance icepick of Prop
	(properties
		x 176
		y 87
		noun 18
		approachX 162
		approachY 119
		view 500
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame points: 1 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gEgo get: 24 self 2 self) ; Ice_Pick
		(SetFlag 30)
	)
)

(instance elixir of Prop
	(properties
		x 240
		y 172
		z 5
		noun 20
		approachX 195
		approachY 176
		view 500
		loop 3
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame points: 1 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gEgo get: 17 self) ; Elixir
		(SetFlag 65)
		(self dispose:)
	)
)

(instance barrel of Feature
	(properties
		x 177
		y 103
		noun 21
		nsTop 97
		nsLeft 166
		nsBottom 110
		nsRight 189
		sightAngle 40
	)
)

(instance momsWindow of Feature
	(properties
		x 137
		y 74
		noun 2
		nsTop 59
		nsLeft 127
		nsBottom 90
		nsRight 147
	)
)

(instance roomsSign of Feature
	(properties
		x 27
		y 11
		noun 1
		nsTop 3
		nsBottom 19
		nsRight 55
	)
)

(instance roofTop of Feature
	(properties
		x 57
		y 171
		noun 4
		onMeCheck 4
	)
)

(instance elixirWagon of Feature
	(properties
		x 269
		y 152
		noun 5
		onMeCheck 8
	)
)

(instance trunks of Feature
	(properties
		x 271
		y 104
		noun 6
		onMeCheck 16
	)
)

(instance tree of Feature
	(properties
		x 315
		y 56
		noun 7
		onMeCheck 32
	)
)

(instance stairs of Feature
	(properties
		x 48
		y 64
		noun 8
		onMeCheck 64
	)
)

(instance topSign of Feature
	(properties
		x 13
		y 34
		noun 9
		onMeCheck 128
	)
)

(instance bottomSign of Feature
	(properties
		x 9
		y 54
		noun 10
		onMeCheck 256
	)
)

(instance hotel of Feature
	(properties
		x 29
		y 51
		noun 11
		onMeCheck 512
	)
)

(instance poster of Feature
	(properties
		x 100
		y 79
		noun 12
		onMeCheck 1024
	)
)

(instance leaflet of Feature
	(properties
		x 85
		y 81
		noun 13
		onMeCheck 2048
	)
)

(instance moms of Feature
	(properties
		x 120
		y 100
		noun 14
		onMeCheck 4096
	)
)

(instance saloon of Feature
	(properties
		x 227
		y 72
		noun 15
		onMeCheck 8192
	)
)

