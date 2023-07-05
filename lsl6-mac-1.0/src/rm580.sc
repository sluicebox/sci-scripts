;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 580)
(include sci.sh)
(use Main)
(use n079)
(use LarryRoom)
(use PolyFeature)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm580 0
)

(local
	local0
	local1
)

(instance rm580 of LarryRoom
	(properties
		noun 1
		picture 580
		horizon 0
		south 305
	)

	(method (init)
		(= global173 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 71 121 68 128 56 128 61 119 46 119 26 141 131 141 200 141 310 141 294 123 277 124 283 130 274 132 266 124 254 123 239 112 226 124 211 124 212 131 203 131 200 124 179 124 170 115 162 123 139 122 139 129 129 129 129 122 113 122 103 115 92 121
					yourself:
				)
		)
		(super init: &rest)
		(gEgo normalize: 900 8 init:)
		(switch gPrevRoomNum
			(590
				(gEgo posn: (shablee approachX:) (shablee approachY:) cel: 6)
				(gGame handsOn:)
			)
			(else
				(self setScript: enterScr)
			)
		)
		(if (not (IsFlag 24))
			(shablee init: approachVerbs: 2 1 18 4 5 setScript: shableeScr) ; Talk, Look, gown, Do, Take
			(row1girl1 init: setScript: (girlScr new:))
			(row1girl3 init: setScript: (girlScr new:))
			(row2girl1 init: setScript: (girlScr new:))
			(if (>= (gGame detailLevel:) 3)
				(row2girl2 init: setScript: (girlScr new:))
				(row2girl3 init: stopUpd:)
				(row2girl4 init: stopUpd:)
				(row3girl1 init: stopUpd:)
			)
			(row3girl2 init: setScript: (girlScr new:))
			(if (>= (gGame detailLevel:) 3)
				(row3girl3 init: setScript: (girlScr new:))
				(row3girl4 init: setScript: (girlScr new:))
			)
			(if (>= (gGame detailLevel:) 3)
				(row4girl1 init: setScript: (girlScr new:))
				(row4girl4 init: setScript: (girlScr new:))
				(row4girl3 init: stopUpd:)
			)
			(row4girl2 init: setScript: (girlScr new:))
			(monitor1 setCycle: Fwd init:)
			(monitor2 setCycle: Fwd init:)
			(monitor3 setCycle: Fwd init:)
			(monitor4 setCycle: Fwd init:)
		)
		(desks init:)
		(deskWithCord init:)
		(shableesDesk init:)
		(monitors init:)
		(brush init:)
		(lipStick init:)
		(eyeLiner init:)
		(cord init:)
		(= local1 (== ((gInventory at: 17) owner:) 590)) ; gown
		(gGlobalSound1 number: 580 loop: -1 play:)
	)

	(method (doVerb theVerb)
		(return
			(if (IsFlag 24)
				(gMessager say: noun 0 2) ; "The Make-Up Classroom is really boring with no class in it."
				1
			else
				(super doVerb: theVerb)
			)
		)
	)

	(method (edgeToRoom param1)
		(if (== param1 3)
			(self setScript: exitScr)
		)
		(return 0)
	)

	(method (dispose)
		(gGlobalSound1 fade:)
		(super dispose:)
	)
)

(instance girlScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 90 360))
			)
			(1
				(client cel: 0 setCycle: End self)
			)
			(2
				(client cel: 0)
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance shableeScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(shablee loop: (Random 0 3) cel: 0 setCycle: End self)
			)
			(2
				(= state 0)
				(= ticks (Random 40 360))
			)
		)
	)
)

(instance enterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 265 186)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 250 137 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						MoveTo
						(+ (gEgo x:) 15)
						(+ (gEgo y:) 50)
						self
				)
			)
			(1
				(gCurRoom newRoom: 305)
			)
		)
	)
)

(instance shableesDesk of Feature
	(properties
		x 249
		y 54
		noun 4
		approachX 241
		approachY 115
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					init: 244 110 246 87 256 83 262 83 270 73 283 71 291 79 299 100 292 120 258 123
					yourself:
				)
		)
		(if (gCast contains: shablee)
			(self approachVerbs: 2 1 18 4 5) ; Talk, Look, gown, Do, Take
		)
	)

	(method (doVerb theVerb)
		(if (gCast contains: shablee)
			(shablee doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance desks of PolyFeature
	(properties
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			addPolygon:
				((Polygon new:)
					init: 97 85 100 89 99 106 94 114 84 119 70 119 64 128 60 128 61 119 48 116 47 101 50 90 54 88 57 78 65 72 79 72 85 78 88 84
					yourself:
				)
				((Polygon new:)
					init: 190 77 200 70 215 72 221 80 223 85 233 92 232 112 227 122 210 121 210 129 203 128 201 121 185 119 180 115 179 97 180 86 188 85
					yourself:
				)
				((Polygon new:)
					init: 90 58 94 56 95 47 104 46 114 47 114 53 124 54 125 61 121 73 114 76 103 75 100 82 96 81 97 75 89 72
					yourself:
				)
				((Polygon new:)
					init: 132 76 131 62 134 53 138 53 139 46 150 45 159 46 160 53 165 54 166 68 163 75 150 76
					yourself:
				)
				((Polygon new:)
					init: 178 74 176 58 182 52 182 45 205 45 206 52 211 57 210 75
					yourself:
				)
				((Polygon new:)
					init: 223 72 219 64 223 53 230 52 232 46 250 46 254 58 249 76 230 76
					yourself:
				)
				((Polygon new:)
					init: 114 38 122 36 125 31 130 36 138 36 136 47 124 50 116 47
					yourself:
				)
				((Polygon new:)
					init: 144 36 155 30 167 37 167 48 144 48
					yourself:
				)
				((Polygon new:)
					init: 189 29 199 36 199 49 181 49 176 47 176 36
					yourself:
				)
				((Polygon new:)
					init: 230 36 229 47 214 50 208 46 208 36 219 31
					yourself:
				)
				((Polygon new:)
					init: 130 25 136 19 144 23 143 32 130 32
					yourself:
				)
				((Polygon new:)
					init: 151 26 159 19 168 25 168 33 151 33
					yourself:
				)
				((Polygon new:)
					init: 192 24 192 32 174 32 175 25 184 18
					yourself:
				)
				((Polygon new:)
					init: 216 25 215 33 201 33 200 26 208 17
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (IsFlag 24)
			(gMessager say: noun 0 2) ; "Class must be over, as the room is empty."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lipStick of Feature
	(properties
		noun 12
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					init: 0 51 11 34 16 35 42 13 53 12 59 15 63 21 60 27 39 47 41 51 23 74 16 96 6 110 0 114
					yourself:
				)
		)
	)
)

(instance brush of Feature
	(properties
		noun 11
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					init: 41 14 44 1 47 0 70 0 88 7 101 11 124 14 124 17 93 20 69 28 58 33 56 32 64 21 61 16 52 11
					yourself:
				)
		)
	)
)

(instance eyeLiner of PolyFeature
	(properties
		noun 10
	)

	(method (init)
		(super init: &rest)
		(self
			addPolygon:
				((Polygon new:) init: 168 0 168 5 130 5 128 0 yourself:)
				((Polygon new:)
					init: 214 0 213 9 185 9 184 7 171 6 171 0
					yourself:
				)
		)
	)
)

(instance monitors of PolyFeature
	(properties
		noun 13
		variableX 1
		variableY 1
	)

	(method (init)
		(super init: &rest)
		(self
			addPolygon:
				((Polygon new:)
					init: 45 54 62 36 72 36 79 40 79 54 68 62 51 61
					yourself:
				)
				((Polygon new:)
					init: 83 36 83 31 100 23 101 24 110 14 117 13 120 16 120 28 107 31 103 27 103 38 90 45
					yourself:
				)
				((Polygon new:)
					init: 235 14 252 22 248 31 226 26 228 16
					yourself:
				)
				((Polygon new:)
					init: 272 33 281 44 278 54 267 54 257 43 258 34
					yourself:
				)
				((Polygon new:)
					init: 315 44 319 60 314 76 301 72 291 63 293 46
					yourself:
				)
				((Polygon new:) init: 135 138 140 130 192 130 195 138 yourself:)
		)
	)
)

(instance shablee of Actor
	(properties
		x 249
		y 54
		noun 2
		approachX 241
		approachY 115
		view 582
		signal 4096
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 4 5) ; Do, Take
				(gMessager say: noun theVerb (if local1 5 else 6))
			)
			((OneOf theVerb 1 2) ; Look, Talk
				(cond
					(local1
						(gMessager say: noun theVerb 5)
					)
					((IsFlag 278)
						(gCurRoom newRoom: 590)
					)
					(else
						(self setScript: toInsetScr 0 theVerb)
					)
				)
			)
			((== theVerb 18) ; gown
				(= global173 18)
				(if (IsFlag 278)
					(gCurRoom newRoom: 590)
				else
					(self setScript: toInsetScr)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance toInsetScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(gMessager say: 2 register 6 0 self)
				else
					(= cycles 2)
				)
			)
			(1
				(gEgo view: 582 loop: 4 cel: 0 setSpeed: 8 setPri: 12)
				(= cycles 2)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(gGame changeScore: 2 278)
				(= ticks 45)
			)
			(4
				(gCurRoom newRoom: 590)
			)
		)
	)
)

(instance takeCordScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 901
					loop: 5
					cel: 0
					setSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(1
				(gGame changeScore: 6 224)
				(gEgo get: 9) ; cord
				(cord loop: 0 noun: 0)
				(= cycles 2)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager say: 6 5 0 0 self) ; "Could this be "The Missing C(h)ord?""
			)
			(5
				(gEgo normalize: 900 8 cel: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cord of View
	(properties
		x 135
		y 136
		noun 6
		approachX 154
		approachY 123
		view 580
		priority 7
		signal 16
	)

	(method (onMe param1)
		(return (if (and (super onMe: param1) (!= noun 0)) 1 else 0))
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					init: 125 127 135 120 153 122 154 132 132 134
					yourself:
				)
		)
		(if (!= ((gInventory at: 9) owner:) gCurRoomNum) ; cord
			(= noun 0)
		else
			(= loop 1)
			(self approachVerbs: 5 4) ; Take, Do
		)
	)

	(method (doVerb theVerb)
		(cond
			((not noun)
				(deskWithCord doVerb: theVerb)
			)
			((== theVerb 5) ; Take
				(gCurRoom setScript: takeCordScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance deskWithCord of Feature
	(properties
		x 136
		y 115
		noun 5
		sightAngle 40
		approachX 154
		approachY 123
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 117 85 122 74 132 71 143 70 151 78 152 84 161 86 163 93 160 118 151 120 145 120 141 117 128 117 125 120 114 119 110 115 109 95
					yourself:
				)
			approachVerbs: 4 ; Do
		)
	)

	(method (doVerb theVerb)
		(if (IsFlag 24)
			(gMessager say: noun 0 2) ; "Class must be over, as the room is empty."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance row1girl1 of Prop
	(properties
		x 76
		y 59
		noun 3
		view 583
		loop 2
		priority 3
		signal 16
	)
)

(instance row1girl3 of Prop
	(properties
		x 180
		y 59
		noun 3
		view 583
		loop 1
		cel 9
		priority 3
		signal 16
		cycleSpeed 9
	)
)

(instance row2girl1 of Prop
	(properties
		x 97
		y 28
		noun 3
		view 583
		loop 2
		scaleSignal 1
		scaleX 120
		scaleY 120
	)
)

(instance row2girl2 of Prop
	(properties
		x 133
		y 26
		noun 3
		view 583
		cel 13
		priority 2
		signal 16
		scaleSignal 1
		scaleX 120
		scaleY 120
	)
)

(instance row2girl3 of Prop
	(properties
		x 218
		y 29
		noun 3
		view 583
		loop 3
		cel 1
		priority 2
		signal 16
		scaleSignal 1
		scaleX 119
		scaleY 119
		cycleSpeed 9
	)
)

(instance row2girl4 of Prop
	(properties
		x 177
		y 31
		noun 3
		view 583
		loop 3
		priority 2
		signal 16
	)
)

(instance row3girl1 of Prop
	(properties
		x 120
		y 20
		noun 3
		view 583
		loop 3
		cel 1
		priority 1
		signal 16
		scaleSignal 1
		scaleX 72
		scaleY 72
	)
)

(instance row3girl2 of Prop
	(properties
		x 155
		y 20
		noun 3
		view 583
		loop 2
		cel 15
		priority 1
		signal 16400
		scaleSignal 1
		scaleX 72
		scaleY 72
	)
)

(instance row3girl3 of Prop
	(properties
		x 173
		y 21
		noun 3
		view 583
		loop 1
		cel 15
		priority 1
		signal 16
		scaleSignal 1
		scaleX 72
		scaleY 72
	)
)

(instance row3girl4 of Prop
	(properties
		x 207
		y 20
		noun 3
		view 583
		cel 13
		priority 1
		signal 16400
		scaleSignal 1
		scaleX 72
		scaleY 72
	)
)

(instance row4girl1 of Prop
	(properties
		x 131
		y 13
		noun 3
		view 583
		loop 1
		cel 15
		scaleSignal 1
		scaleX 56
		scaleY 56
	)
)

(instance row4girl2 of Prop
	(properties
		x 153
		y 12
		noun 3
		view 583
		cel 13
		signal 16384
		scaleSignal 1
		scaleX 57
		scaleY 57
	)
)

(instance row4girl3 of Prop
	(properties
		x 180
		y 14
		noun 3
		view 583
		loop 3
		signal 16384
		scaleSignal 1
		scaleX 58
		scaleY 58
	)
)

(instance row4girl4 of Prop
	(properties
		x 199
		y 13
		noun 3
		view 583
		loop 2
		cel 15
		scaleSignal 1
		scaleX 57
		scaleY 57
	)
)

(instance monitor1 of Prop
	(properties
		x 79
		y 52
		noun 13
		view 584
		cel 4
		signal 16384
		detailLevel 2
	)
)

(instance monitor2 of Prop
	(properties
		x 103
		y 35
		noun 13
		view 584
		loop 1
		cel 4
		signal 16384
		detailLevel 2
	)
)

(instance monitor3 of Prop
	(properties
		x 121
		y 23
		noun 13
		view 584
		loop 2
		cel 1
		signal 16384
		detailLevel 2
	)
)

(instance monitor4 of Prop
	(properties
		x 288
		y 46
		noun 13
		view 584
		loop 3
		cel 1
		signal 16384
		detailLevel 2
	)
)

(instance monitor5 of Prop ; UNUSED
	(properties
		x 257
		y 37
		noun 13
		view 584
		loop 4
		cel 1
		signal 16384
		detailLevel 2
	)
)

(instance monitor6 of Prop ; UNUSED
	(properties
		x 230
		y 21
		noun 13
		view 584
		loop 5
		cel 7
		signal 16384
		detailLevel 2
	)
)

(instance monitor7 of Prop ; UNUSED
	(properties
		x 140
		y 131
		noun 13
		view 584
		loop 6
		cel 4
		priority 14
		signal 16400
		detailLevel 2
	)
)

