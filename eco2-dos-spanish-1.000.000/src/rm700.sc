;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Scaler)
(use Polygon)
(use Feature)
(use StopWalk)
(use ScaleTo)
(use Sound)
(use Jump)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm700 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm700 of Eco2Room
	(properties
		noun 9
		picture 700
		style 10
		east 701
		south 702
	)

	(method (init)
		(if (== gPrevRoomNum 701)
			(= style 11)
			(gEgo x: 310)
		else
			(gEgo y: 180)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 130 115 130 124 93 124 93 115
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 79 92 79 100 57 100 57 92
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 150 92 150 104 122 104 122 92
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 186 84 186 94 164 94 164 84
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 275 107 275 113 220 113 220 100 268 100
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 305 97 305 106 277 106 272 101 272 91 299 91
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 80 4 80 4 119 49 119 49 133 4 133 4 189 0 189
					yourself:
				)
		)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(tree4 init:)
		(tree5 init:)
		(tree6 init:)
		(tree7 init:)
		(roots1 init:)
		(roots2 init:)
		(roots3 init:)
		(roots4 init:)
		(water init:)
		(exiteast init:)
		(exitsouth init:)
		(if (not (gCurrentRegionFlags test: 2))
			(gCurrentRegionFlags set: 2)
			(gEgo
				view: 703
				loop: 5
				cel: 0
				x: 183
				y: 81
				setScale: Scaler 100 35 189 80
				init:
			)
			(self setScript: firstEntrance)
			((= local0 (Actor new:))
				view: 700
				loop: 3
				cel: 1
				x: 101
				y: 61
				origStep: 1285
				scaleSignal: 5
				moveSpeed: 3
				scaleX: 73
				scaleY: 73
				signal: 16400
				priority: 8
				init:
			)
			((= local1 (Actor new:))
				view: 700
				loop: 3
				cel: 1
				x: 33
				y: 67
				origStep: 1285
				scaleSignal: 5
				moveSpeed: 3
				scaleX: 93
				scaleY: 93
				signal: 16400
				priority: 10
				init:
			)
			((= local2 (Actor new:))
				view: 700
				loop: 3
				cel: 1
				x: 107
				y: 74
				origStep: 1285
				scaleSignal: 5
				moveSpeed: 3
				scaleX: 93
				scaleY: 93
				signal: 16400
				priority: 10
				init:
			)
			((= local3 (Actor new:))
				view: 700
				loop: 3
				cel: 1
				x: 20
				y: 66
				origStep: 1285
				scaleSignal: 5
				moveSpeed: 3
				scaleX: 93
				scaleY: 93
				signal: 16400
				priority: 10
				init:
			)
		else
			(gEgo init: setScale: Scaler 100 35 189 80 normalize:)
			(if (== (gEgo view:) 10)
				(gEgo setCycle: StopWalk 13)
			)
			(gGame handsOn:)
		)
		((= local0 (Actor new:))
			view: 700
			loop: 3
			cel: 1
			x: 101
			y: 61
			origStep: 1285
			scaleSignal: 5
			moveSpeed: 3
			scaleX: 73
			scaleY: 73
			init:
		)
		(cBalls init: addToPic:)
		(cBalls2 init: addToPic:)
		(super init:)
	)

	(method (doit)
		(if
			(and
				(not local6)
				(OneOf gPrevRoomNum 700 701 702 730)
				(> (Random 0 1000) 999)
			)
			(= local6 1)
			(= local4 (+ (gEgo x:) (if (Random 0 1) 40 else -40)))
			(= local5 (+ (gEgo y:) 40))
			(local0 setScript: splash 0 local0)
		)
		(super doit:)
	)
)

(instance exiteast of ExitFeature
	(properties
		nsTop 75
		nsLeft 310
		nsBottom 184
		nsRight 319
		cursor 11
		exitDir 2
	)

	(method (handleEvent)
		(= toX 319)
		(= toY ((User curEvent:) y:))
		(super handleEvent: &rest)
	)
)

(instance exitsouth of ExitFeature
	(properties
		nsTop 185
		nsBottom 189
		nsRight 319
		cursor 10
		exitDir 3
	)
)

(instance tree1 of Feature
	(properties
		x 28
		y 69
		noun 1
		nsTop 14
		nsLeft 17
		nsBottom 104
		nsRight 40
		sightAngle 40
		approachX 28
		approachY 59
	)
)

(instance tree2 of Feature
	(properties
		x 65
		y 69
		noun 1
		nsTop 37
		nsLeft 56
		nsBottom 85
		nsRight 74
		sightAngle 40
		approachX 65
		approachY 61
	)
)

(instance tree3 of Feature
	(properties
		x 111
		y 69
		noun 1
		nsTop 14
		nsLeft 100
		nsBottom 106
		nsRight 122
		sightAngle 40
		approachX 111
		approachY 60
	)
)

(instance tree4 of Feature
	(properties
		x 138
		y 69
		noun 1
		nsTop 40
		nsLeft 133
		nsBottom 88
		nsRight 144
		sightAngle 40
		approachX 138
		approachY 64
	)
)

(instance tree5 of Feature
	(properties
		x 174
		y 69
		noun 1
		nsTop 44
		nsLeft 168
		nsBottom 80
		nsRight 181
		sightAngle 40
		approachX 174
		approachY 62
	)
)

(instance tree6 of Feature
	(properties
		x 244
		y 59
		noun 1
		nsTop 6
		nsLeft 224
		nsBottom 98
		nsRight 264
		sightAngle 40
		approachX 244
		approachY 52
	)
)

(instance tree7 of Feature
	(properties
		x 285
		y 69
		noun 1
		nsTop 24
		nsLeft 275
		nsBottom 84
		nsRight 295
		sightAngle 40
		approachX 285
		approachY 54
	)
)

(instance roots1 of Feature
	(properties
		x 28
		y 115
		noun 2
		nsTop 105
		nsLeft 14
		nsBottom 126
		nsRight 42
		sightAngle 40
		approachX 28
		approachY 115
	)
)

(instance roots2 of Feature
	(properties
		x 110
		y 116
		noun 2
		nsTop 107
		nsLeft 98
		nsBottom 125
		nsRight 123
		sightAngle 40
		approachX 110
		approachY 116
	)
)

(instance roots3 of Feature
	(properties
		x 246
		y 105
		noun 2
		nsTop 98
		nsLeft 224
		nsBottom 112
		nsRight 268
		sightAngle 40
		approachX 246
		approachY 105
	)
)

(instance roots4 of Feature
	(properties
		x 287
		y 94
		noun 2
		nsTop 85
		nsLeft 274
		nsBottom 103
		nsRight 301
		sightAngle 40
		approachX 287
		approachY 94
	)
)

(instance water of Feature
	(properties
		x 159
		y 5
		z 169
		noun 3
		nsTop 80
		nsBottom 189
		nsRight 319
		sightAngle 360
		approachX 159
		approachY 169
	)

	(method (doit)
		(if (not (IsEcorderFlag 14))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 14))
			(super doVerb: theVerb &rest)
		)
	)
)

(instance cBalls of View
	(properties
		x 96
		y 79
		z 20
		noun 4
		view 700
		loop 3
		priority 8
		signal 16400
		scaleSignal 1
		scaleX 96
		scaleY 96
	)

	(method (init)
		(if (not (IsEcorderFlag 15))
			(gTheDoits add: self)
		)
		(super init:)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 15))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 15))
			(super doVerb: theVerb &rest)
		)
	)
)

(instance cBalls2 of View
	(properties
		x 14
		y 79
		z 20
		noun 4
		view 700
		loop 3
		priority 9
		signal 16400
		scaleSignal 1
		scaleX 89
		scaleY 89
	)

	(method (init)
		(if (not (IsEcorderFlag 15))
			(gTheDoits add: self)
		)
		(super init:)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 15))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 15))
			(super doVerb: theVerb &rest)
		)
	)
)

(instance splash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFX number: 711 setLoop: 1 play:)
				(register setMotion: JumpTo local4 local5 self)
			)
			(1
				(sFX number: 869 setLoop: 1 play:)
				(register view: 703 loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(register dispose:)
			)
		)
	)
)

(instance sinkTheBoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFX number: 711 setLoop: 1 play:)
				(local3 setMotion: JumpTo 134 124 self)
			)
			(1
				(local3 dispose:)
			)
		)
	)
)

(instance firstEntrance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable:)
				(gGameSound2 number: 713 setLoop: 1 play:)
				(gCurrentRegionFlags set: 12)
				(= local6 1)
				(= cycles 1)
			)
			(1
				(gEgo
					signal: (| (gEgo signal:) $0800)
					setSpeed: 8
					setCycle: Fwd
					setPri: 2
					setMotion: MoveTo 194 87 self
				)
			)
			(2
				(= local4 230)
				(= local5 83)
				(local0 setScale: ScaleTo 43 5 setScript: splash self local0)
				(gEgo setMotion: MoveTo 196 88)
			)
			(3
				(gMessager say: 4 0 1 0 self) ; "Missed me!"
			)
			(4
				(gEgo loop: 7 cel: 2 setPri: -1 setCycle: Beg self)
			)
			(5
				(gEgo
					loop: 6
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 178 98 self
				)
			)
			(6
				(= local4 146)
				(= local5 106)
				(local1 setScale: ScaleTo 53 5 setScript: splash self local1)
				(gEgo setMotion: MoveTo 174 102)
			)
			(7
				(gMessager say: 4 0 2 0 self) ; "Missed me again!"
			)
			(8
				(gEgo loop: 7 cel: 0 setCycle: End self)
			)
			(9
				(gEgo
					loop: 5
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 208 118 self
				)
			)
			(10
				(= local4 250)
				(= local5 126)
				(local2 setScale: ScaleTo 63 5 setScript: splash self local2)
				(gEgo setMotion: MoveTo 212 122)
			)
			(11
				(gMessager say: 4 0 3 0 self) ; "Ha! That wasn't even close!"
			)
			(12
				(gEgo loop: 7 cel: 2 setCycle: Beg self)
			)
			(13
				(gEgo
					loop: 6
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 146 149 self
				)
			)
			(14
				(local3 setScript: sinkTheBoat self)
				(gEgo setMotion: MoveTo 143 152)
			)
			(15
				(sFX number: 869 setLoop: 1 play:)
				(gEgo loop: 3 cel: 1 setCycle: End self)
			)
			(16
				(sFX number: 700 setLoop: -1 play:)
				(gEgo loop: 4 cel: 0 setCycle: CT 2 1 self)
			)
			(17
				(gMessager say: 4 0 4 0 self) ; "Bummer!"
			)
			(18
				(sFX fade: 0 30 20 1)
				(gEgo setCycle: End self)
			)
			(19
				(gEgo view: 701 loop: 3 cel: 3 setCycle: Beg self)
			)
			(20
				(gGameSound2 fade: 0 120 20 1)
				(gGameSound1
					number: 200
					setLoop: -1
					setVol: 0
					play:
					fade: 127 120 20 0
				)
				(gEgo
					view: 10
					setSpeed: global136
					heading: 180
					normalize:
					loop: 1
					setCycle: StopWalk 13
				)
				(gTheIconBar enable:)
				(gGame handsOn:)
				(gCurrentRegionFlags clear: 12)
				(self dispose:)
			)
		)
	)
)

(instance sFX of Sound
	(properties)
)

