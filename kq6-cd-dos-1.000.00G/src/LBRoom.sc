;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use rLab)
(use KQ6Print)
(use n401)
(use n402)
(use n403)
(use n404)
(use n913)
(use Print)
(use System)

(public
	LBRoom 0
)

(local
	[local0 100]
	[local100 24] = [-430 1 -435 7 -420 20 -408 51 -425 66 -410 68 -415 71 -405 117 -406 152 -407 180 -409 181 -440 182]
)

(class LBRoom of LabRoom
	(properties)

	(method (makeDoors param1 &tmp temp0)
		(if
			(OneOf
				param1
				19
				22
				35
				38
				51
				67
				85
				87
				97
				99
				101
				103
				113
				115
				117
				146
				149
				161
				163
				165
				168
				177
				179
				184
				193
				197
				200
				209
				213
				216
				226
				228
				230
				243
			)
			((ScriptID 30 7) addToPic:) ; topDoor
		)
		(if
			(OneOf
				param1
				2
				3
				7
				20
				21
				22
				39
				66
				67
				68
				69
				82
				83
				86
				87
				113
				114
				115
				116
				117
				146
				147
				148
				149
				150
				151
				152
				177
				178
				179
				180
				184
				210
				213
				214
				215
				216
				227
				228
			)
			((ScriptID 30 5) addToPic:) ; leftDoor
			((ScriptID 30 9) addToPic:) ; leftWing
		)
		(if
			(OneOf
				param1
				1
				2
				6
				19
				20
				21
				38
				65
				66
				67
				68
				81
				82
				85
				86
				112
				113
				114
				115
				116
				145
				146
				147
				148
				149
				150
				151
				176
				177
				178
				179
				183
				209
				212
				213
				214
				215
				226
				227
			)
			((ScriptID 30 6) addToPic:) ; rightDoor
			((ScriptID 30 10) addToPic:) ; rightWing
		)
		(if
			(not
				(OneOf
					param1
					3
					6
					19
					22
					35
					51
					69
					71
					81
					83
					85
					87
					97
					99
					101
					117
					130
					133
					145
					147
					149
					152
					161
					163
					168
					177
					184
					193
					197
					200
					210
					212
					214
					227
				)
			)
			((ScriptID 30 8) addToPic:) ; bottomBlock
		)
		((ScriptID 30 3) show:) ; theTorch
	)

	(method (makePolys param1)
		(cond
			((OneOf param1 149 177)
				(proc401_4)
				((ScriptID 30 4) dispose:) ; corpseNiche
			)
			((OneOf param1 67 113 115 146 131 179 213)
				(proc403_0)
				((ScriptID 30 4) dispose:) ; corpseNiche
			)
			((OneOf param1 147 214 227)
				(proc403_1)
				((ScriptID 30 0) initCrypt: 1) ; rLab
			)
			((OneOf param1 22 87 117 184)
				(proc403_2)
				((ScriptID 30 0) initCrypt: 2) ; rLab
			)
			((OneOf param1 19 85)
				(proc403_3)
				((ScriptID 30 0) initCrypt: 4) ; rLab
			)
			((OneOf param1 35 51 97 99 101 161 163 168 193 197 200)
				(proc402_0)
				((ScriptID 30 0) initCrypt: 4) ; rLab
			)
			((OneOf param1 2 20 21 66 68 82 86 114 116 148 150 151 178 215)
				(proc402_1)
				((ScriptID 30 0) initCrypt: 1) ; rLab
			)
			((OneOf param1 216 228)
				(proc402_2)
				((ScriptID 30 0) initCrypt: 2) ; rLab
			)
			((OneOf param1 38 209 226)
				(proc402_3)
				((ScriptID 30 0) initCrypt: 4) ; rLab
			)
			((OneOf param1 3 69 83 152 210)
				(proc402_4)
				((ScriptID 30 0) initCrypt: 2) ; rLab
			)
			((OneOf param1 6 81 145 212)
				(proc402_5)
				((ScriptID 30 0) initCrypt: 4) ; rLab
			)
			(
				(OneOf
					param1
					19
					22
					35
					38
					51
					67
					85
					87
					97
					99
					101
					103
					113
					115
					117
					146
					149
					161
					163
					165
					168
					177
					179
					184
					193
					197
					200
					209
					213
					216
					226
					228
					230
					243
				)
				(proc401_0)
				((ScriptID 30 0) initCrypt: 4) ; rLab
			)
			(
				(OneOf
					param1
					3
					6
					19
					22
					35
					51
					69
					71
					81
					83
					85
					87
					97
					99
					101
					117
					130
					133
					145
					147
					149
					152
					161
					163
					168
					177
					184
					193
					197
					200
					210
					212
					214
					227
				)
				(proc401_1)
				((ScriptID 30 0) initCrypt: 2) ; rLab
			)
			(
				(OneOf
					param1
					2
					3
					7
					20
					21
					22
					39
					66
					67
					68
					69
					82
					83
					86
					87
					113
					114
					115
					116
					117
					146
					147
					148
					149
					150
					151
					152
					177
					178
					179
					180
					184
					210
					213
					214
					215
					216
					227
					228
				)
				(proc401_2)
				((ScriptID 30 0) initCrypt: 1) ; rLab
			)
			(else
				(proc401_3)
				((ScriptID 30 0) initCrypt: 4) ; rLab
			)
		)
	)

	(method (dumpPolys)
		(if (gCurRoom obstacles:)
			((gCurRoom obstacles:) dispose:)
		)
		(gCurRoom obstacles: 0)
	)

	(method (calcRoom param1 param2 &tmp temp0 temp1)
		(if (< (= temp1 param1) 0)
			(for ((= temp0 0)) [local100 temp0] ((+= temp0 2))
				(if (== param1 [local100 temp0])
					(= temp1 [local100 (+ temp0 1)])
					(switch param2
						(1
							(-= temp1 16)
						)
						(3
							(+= temp1 16)
						)
						(2
							(++ temp1)
						)
						(4
							(-- temp1)
						)
						(else
							(Prints {No oldDir coming in})
						)
					)
					((ScriptID 30 0) labCoords: temp1) ; rLab
					(return temp1)
				)
			)
			(if (< temp1 0)
				(KQ6Print
					addTextF:
						{Bad labyrinth room: room %d, direction %d}
						temp1
						param2
				)
				(= temp1 117)
				(= param2 3)
				(gEgo posn: 160 80)
			)
		)
		(switch param2
			(1
				(-= temp1 16)
			)
			(3
				(+= temp1 16)
			)
			(2
				(++ temp1)
			)
			(4
				(-- temp1)
			)
			(else
				(Prints {No oldDir going out})
			)
		)
		((ScriptID 30 0) labCoords: temp1) ; rLab
		(for ((= temp0 1)) (< temp0 24) ((+= temp0 2))
			(if (== temp1 [local100 temp0])
				(return [local100 (- temp0 1)])
			)
		)
		(if (OneOf temp1 65 103 112 130 165 183 230)
			(return -411)
		)
		(return temp1)
	)

	(method (initPseudoRoom param1)
		(if (gCast contains: (ScriptID 30 12)) ; rat
			((ScriptID 30 12) dispose:) ; rat
		)
		(if (gCast contains: (ScriptID 30 13)) ; bat
			((ScriptID 30 13) dispose:) ; bat
		)
		(if (IsFlag 48)
			(self drawPic: 98 10)
		else
			(self drawPic: 98 -32761)
		)
		(self
			setScript: (ScriptID 30 1) ; walkIn
			makePolys: param1
			makeDoors: param1
			makeCritters:
		)
		(if (== ((ScriptID 30 0) holeCoords:) ((ScriptID 30 0) labCoords:)) ; rLab, rLab
			(proc404_1)
		)
	)

	(method (init &tmp temp0)
		(super init:)
		(if (!= (gGlobalSound number:) 400)
			(gGlobalSound number: 400 setLoop: -1 play:)
		)
		(if (== gPrevRoomNum 99) ; speedRoom
			((ScriptID 30 0) prevEdgeHit: EDGE_TOP) ; rLab
			(= gPrevRoomNum 405)
		)
		(if (== gPrevRoomNum 411)
			(= temp0 ((ScriptID 30 0) labCoords:)) ; rLab
			(switch ((ScriptID 30 0) prevEdgeHit:) ; rLab
				(1
					(-= temp0 16)
				)
				(3
					(+= temp0 16)
				)
				(2
					(++ temp0)
				)
				(4
					(-- temp0)
				)
				(else
					(Prints {No oldDir coming in from 411})
				)
			)
			((ScriptID 30 0) labCoords: temp0) ; rLab
		else
			(= temp0
				(self calcRoom: (- 0 gPrevRoomNum) ((ScriptID 30 0) prevEdgeHit:)) ; rLab
			)
		)
		(self initPseudoRoom: temp0 ((ScriptID 30 0) prevEdgeHit:)) ; rLab
	)

	(method (newRoom newRoomNumber)
		(if ((ScriptID 30 0) holeIsUp:) ; rLab
			((ScriptID 30 0) holeIsUp: 0) ; rLab
			(proc404_2)
		)
		(self dumpPolys:)
		(if
			(<
				(= newRoomNumber
					(self
						calcRoom:
							((ScriptID 30 0) labCoords:) ; rLab
							((ScriptID 30 0) prevEdgeHit:) ; rLab
					)
				)
				0
			)
			(super newRoom: (- newRoomNumber))
		else
			(self initPseudoRoom: newRoomNumber ((ScriptID 30 0) prevEdgeHit:)) ; rLab
		)
	)
)

