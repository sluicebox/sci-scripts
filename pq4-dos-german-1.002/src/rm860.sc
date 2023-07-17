;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 860)
(include sci.sh)
(use Main)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm860 0
	dannyTalker 1
)

(instance rm860 of Room
	(properties
		picture 860
		west 800
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 117 0 123 55 119 218 114 319 115 319 110 203 110 149 102 127 102 135 108 97 112
					yourself:
				)
		)
		(super init: &rest)
		(proc0_4 0)
		(gGame handsOn:)
		(grass2 init:)
		(grass init:)
		(flowerBed init:)
		(house init:)
		(palm init:)
		(puzzle init: approachVerbs: 1) ; Look
		(door init: approachVerbs: 4) ; Do
		(doorP init:)
		(if (or (== gPrevRoomNum 850) (== gPrevRoomNum 830))
			(if (gPqFlags test: 28)
				(doorP cel: 0)
				(self setScript: toss)
			else
				(doorP cel: (doorP lastCel:))
				(gEgo
					setHeading: 180
					normalize: 0
					x: 132
					y: 106
					setTalker: careyTalker
					setScaler: Scaler 80 53 125 99
					init:
					setMotion: PolyPath 132 112
				)
			)
		else
			(gEgo
				setHeading: 270
				normalize: 0
				posn: 245 112 0
				setTalker: careyTalker
				setScaler: Scaler 80 53 125 99
				init:
				setMotion: PolyPath 200 112
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo x:) 270)
			(if (gPqFlags test: 0)
				(self newRoom: 820)
			else
				(gEgo x: 270 setMotion: 0)
				(barkSnd play:)
			)
		)
	)
)

(instance palm of Feature
	(properties
		noun 6
		nsLeft 101
		nsTop 93
		nsRight 106
		nsBottom 97
		sightAngle 40
		approachX 103
		approachY 95
		approachDist 0
		x 103
		y 95
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 93 108 98 47 98 0 108 0 106 56 109 90 115 107
					yourself:
				)
		)
		(super init:)
	)
)

(instance house of Feature
	(properties
		noun 5
		nsLeft 137
		nsTop 39
		nsRight 141
		nsBottom 45
		sightAngle 40
		approachX 139
		approachY 42
		approachDist 0
		x 139
		y 42
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 319 0 319 92 269 94 269 101 153 101 153 51 116 51 116 96 103 96 87 107 0 107
					yourself:
				)
		)
		(super init:)
	)
)

(instance flowerBed of Feature
	(properties
		noun 7
		nsLeft 168
		nsTop 130
		nsRight 173
		nsBottom 134
		sightAngle 40
		approachX 170
		approachY 132
		approachDist 0
		x 170
		y 132
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 69 115 93 114 102 119 109 119 117 109 107 101 111 99 111 96 118 96 119 93 111 91 119 88 126 89 133 86 136 83 145 80 145 88 147 88 153 84 156 87 153 93 161 94 156 96 151 103 161 108 146 109 159 115 185 115 187 106 173 100 173 96 179 92 192 90 206 93 196 108 200 115 222 116 222 114 235 111 245 112 251 119 254 116 263 111 272 111 278 116 281 110 288 109 296 110 298 115 302 115 245 129 187 136 124 136 78 129 64 122
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; caseGlassJar
				(if (gEgo has: 20) ; shoe
					(super doVerb: theVerb)
				else
					(gMessager say: noun theVerb 6) ; "If you suspect hidden evidence, you'll need to look"
				)
			)
			(52 ; notebook
				(if (gEgo has: 20) ; shoe
					(gGame points: 2 90)
					(super doVerb: theVerb)
				else
					(gMessager say: noun theVerb 6) ; "What about the flower bed deserves notation?"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance grass of Feature
	(properties
		noun 3
		nsLeft 153
		nsTop 146
		nsRight 161
		nsBottom 148
		sightAngle 40
		approachX 157
		approachY 147
		approachDist 0
		x 157
		y 147
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 125 57 119 64 122 77 129 122 136 192 136 247 128 304 115 319 115 319 152 0 152
					yourself:
				)
		)
		(super init:)
	)
)

(instance grass2 of Feature
	(properties
		noun 3
		nsLeft 268
		nsTop 103
		nsRight 275
		nsBottom 106
		sightAngle 40
		approachX 271
		approachY 104
		approachDist 0
		x 271
		y 104
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 197 108 202 101 270 101 298 97 319 97 319 109
					yourself:
				)
		)
		(super init:)
	)
)

(instance barkSnd of Sound
	(properties
		number 995
	)
)

(instance doorP of Prop
	(properties
		x 138
		y 100
		view 860
	)

	(method (onMe)
		(return 0)
	)
)

(instance dannyD2 of Feature
	(properties
		noun 2
		y 150
	)

	(method (init)
		(self
			onMeCheck:
				((Polygon new:)
					type: PContainedAccess
					init: 150 23 155 13 159 11 171 9 183 16 189 24 186 32 189 42 192 43 189 55 220 62 226 70 231 93 218 114 218 135 214 141 220 151 129 151 128 112 116 97 114 85 118 69 123 62 128 60 151 56
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (> (thruDoorScr state:) 6)
			(return)
		)
		(switch theVerb
			(27 ; badge
				(thruDoorScr seconds: 0 register: 1)
				(gGame points: 2 91)
				(dannyD2F setScript: showBadge)
			)
			(2 ; Talk
				(if (gPqFlags test: 103)
					(thruDoorScr seconds: 0 register: 0)
					(gMessager say: 2 2 5 0 thruDoorScr) ; "Yo Money's busy. If you want to see him, you'll have to come back."
				else
					(thruDoorScr seconds: 0 register: 1)
					(if (gPqFlags test: 28)
						(gMessager say: 2 2 7 0 thruDoorScr) ; "I was wondering if I might speak with Yo Money once again."
					else
						(gMessager say: 2 2 0 0 thruDoorScr) ; "I was wondering if I might speak with Yo Money once again."
					)
				)
			)
			(31 ; shoe
				(gGame points: 2 92)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dannyD2F of Prop
	(properties
		x 170
		y 58
		priority 3
		view 815
		loop 1
	)

	(method (init)
		(|= signal $5000)
		(super init:)
		(= actions dannyD2)
	)

	(method (dispose)
		(= actions 0)
		(super dispose:)
	)
)

(instance bigEgo of Prop
	(properties
		x 127
		y 161
		view 9815
	)

	(method (init)
		(|= signal $5000)
		(super init:)
		(= actions gEgo)
	)

	(method (dispose)
		(= actions 0)
		(super dispose:)
	)
)

(instance bigEgoHead of Prop
	(properties
		x 125
		y 59
		view 9815
		loop 1
	)

	(method (init)
		(|= signal $5000)
		(super init:)
		(= actions gEgo)
	)

	(method (dispose)
		(= actions 0)
		(super dispose:)
	)
)

(instance dannyD of Prop ; UNUSED
	(properties
		x 45
		y 96
		priority 1
		view 810
	)

	(method (init)
		(|= signal $4000)
		(super init:)
		(= actions gEgo)
	)

	(method (dispose)
		(= actions 0)
		(super dispose:)
	)

	(method (onMe)
		(return 0)
	)
)

(instance toss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					stopView: 5
					view: 9860
					loop: 0
					cel: 0
					x: 123
					y: 116
					setTalker: careyTalker
					setScaler: Scaler 80 53 125 99
					init:
					setCycle: End self
				)
				(doorP setCycle: End)
			)
			(1
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(gEgo heading: 180 normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showBadge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(bigEgo setCycle: End self)
			)
			(1
				(bigEgo view: 9816 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 2 27 0 0 self) ; "I know you're a cop. Want do you want?"
			)
			(3
				(bigEgo setCycle: Beg self)
			)
			(4
				(bigEgo view: 9815)
				(bigEgo cel: (bigEgo lastCel:) setCycle: Beg self)
			)
			(5
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sFx of Sound
	(properties)
)

(instance knock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gEgo setCycle: CT 5 1 self)
			)
			(1
				(gEgo setCycle: End self)
				(sFx number: 998 init: setLoop: -1 play:)
			)
			(2
				(gEgo setCycle: CT 5 -1 self)
			)
			(3
				(sFx stop:)
				(self dispose:)
			)
		)
	)
)

(instance thruDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				((View new:)
					view: 9008
					loop: 1
					cel: 0
					scaleSignal: 1
					scaleX: (gEgo scaleX:)
					scaleY: (gEgo scaleY:)
					x: (gEgo x:)
					y: (gEgo y:)
					init:
				)
				(gEgo view: 9008 loop: 0 cel: 0)
				(self setScript: knock self)
			)
			(1
				1
				(gEgo setCycle: Beg self)
			)
			(2
				2
				(= ticks 80)
			)
			(3
				3
				(doorP setCycle: Beg self)
			)
			(4
				4
				(= ticks 100)
			)
			(5
				5
				(gCast eachElementDo: #dispose release:)
				(gFeatures eachElementDo: #dispose release:)
				(gCurRoom drawPic: 0 0 1)
				(FrameOut)
				(gCurRoom drawPic: 815 0 1)
				(gEgo setTalker: careyTalker)
				(dannyD2 init:)
				(dannyD2F init:)
				(bigEgo init:)
				(bigEgoHead init:)
				(FrameOut)
				(proc0_4 1)
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(= cycles 3)
			)
			(6
				6
				(gMessager say: 2 2 4) ; "Yeah, you want somethin'?"
				(= seconds 11)
			)
			(7
				7
				(if register
					(gGame handsOff:)
					(if (gPqFlags test: 0)
						(gCurRoom newRoom: 830)
					else
						(gCurRoom newRoom: 850)
					)
				else
					(gCast eachElementDo: #dispose release:)
					(gCurRoom drawPic: 0 0 1)
					(FrameOut)
					(gCurRoom drawPic: 860 0 1)
					(doorP init: setCycle: End)
					(gEgo
						setTalker: careyTalker
						normalize: 0
						setScaler: Scaler 60 55 120 103
						init:
					)
					(grass2 init:)
					(grass init:)
					(flowerBed init:)
					(house init:)
					(palm init:)
					(puzzle init: approachVerbs: 1) ; Look
					(door init: approachVerbs: 4) ; Do
					(proc0_4 0)
					(FrameOut)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance door of Feature
	(properties
		noun 1
		nsLeft 117
		nsTop 51
		nsRight 155
		nsBottom 103
		sightAngle 40
		approachX 137
		approachY 103
		approachDist 0
		x 136
		y 77
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: thruDoorScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance puzzle of Feature
	(properties
		noun 7
		nsLeft 114
		nsTop 88
		nsRight 152
		nsBottom 117
		sightAngle 40
		approachX 135
		approachY 116
		approachDist 0
		x 135
		y 140
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; caseGlassJar
				(if (gEgo has: 20) ; shoe
					(super doVerb: theVerb)
				else
					(gMessager say: noun theVerb 6) ; "If you suspect hidden evidence, you'll need to look"
				)
			)
			(52 ; notebook
				(if (gEgo has: 20) ; shoe
					(gGame points: 2 90)
					(super doVerb: theVerb)
				else
					(gMessager say: noun theVerb 6) ; "What about the flower bed deserves notation?"
				)
			)
			(1 ; Look
				(gCurRoom setInset: (ScriptID 20 0)) ; shoeInset
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance careyTalker of Narrator
	(properties
		x 46
		y 100
	)
)

(instance dannyTalker of Narrator
	(properties
		x 80
		y 80
	)
)

