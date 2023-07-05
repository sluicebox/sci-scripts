;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use n404)
(use KQ6Room)
(use n913)
(use RandCycle)
(use PolyPath)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rLab 0
	walkIn 1
	walkOut 2
	theTorch 3
	corpseNiche 4
	leftDoor 5
	rightDoor 6
	topDoor 7
	bottomBlock 8
	leftWing 9
	rightWing 10
	checkBody 11
	rat 12
	bat 13
)

(class rLab of Rgn
	(properties
		modNum 400
		curLabyrinthRoom 0
		labCoords 0
		prevEdgeHit 0
		timesInHoleWallRoom 0
		timesGenieHasAppeared 0
		geniePresent 0
		hiddenDoorOpen 0
		seenSecretLatch 0
		crushCeilingCel 0
		crushCeilingY 0
		corpseWall 0
		darkRoomLit 0
		msgNum 1
		holeCoords 0
		holeWall 0
		holeIsUp 0
		seenByMino 0
		scarfOnMino 0
	)

	(method (initCrypt param1)
		(self corpseWall: param1)
		(corpseNiche addToPic:)
	)

	(method (notify)
		(gFeatures add: floor eastWall northWall westWall eachElementDo: #init)
	)

	(method (cue)
		(switch gCurRoomNum
			(407
				(eastWall dispose:)
			)
			(410
				(eastWall dispose:)
				(westWall dispose:)
				(northWall dispose:)
				(if (not (IsFlag 1))
					(floor dispose:)
				)
			)
			(else
				(floor dispose:)
				(eastWall dispose:)
				(westWall dispose:)
				(northWall dispose:)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if ((ScriptID 30 0) holeIsUp:) ; rLab
			(proc404_2)
		)
		(= keep
			(OneOf
				newRoomNumber
				400 ; LBRoom
				405
				410
				415
				420
				425
				430
				435 ; trapFloor
				440
				406
				407
				408
				409
				411
			)
		)
		(= initialized 0)
		(switch gPrevRoomNum
			(407
				(eastWall init:)
			)
			(410
				(floor init:)
			)
			(420
				(gFeatures
					add: floor eastWall northWall westWall
					eachElementDo: #init
				)
			)
			(440
				(gFeatures
					add: floor eastWall northWall westWall
					eachElementDo: #init
				)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(super init: &rest)
		(cond
			((IsFlag 1)
				(= timesGenieHasAppeared 3)
				(= hiddenDoorOpen (= seenSecretLatch 1))
				(rLab darkRoomLit: 1)
			)
			((not script)
				(self setScript: minotaurTimer)
			)
		)
		(if (!= (gGlobalSound number:) 400)
			(gGlobalSound number: 400 setLoop: -1 play:)
		)
		(gFeatures add: floor eastWall northWall westWall eachElementDo: #init)
	)
)

(class LabRoom of KQ6Room
	(properties
		modNum 400
		noun 2
		picture 400
		horizon 135
		walkOffEdge 1
		autoLoad 0
	)

	(method (makeCritters &tmp temp0)
		(if (Random 0 1)
			(if (Random 0 1)
				(if (gAddToPics contains: corpseNiche)
					(switch (rLab prevEdgeHit:)
						(1
							(if
								(OneOf
									(rLab labCoords:)
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
								(switch (rLab corpseWall:)
									(4
										(gEgo setScript: rats 0 3)
									)
									(2
										(gEgo setScript: rats 0 5)
									)
								)
							)
						)
						(3
							(if
								(OneOf
									(rLab labCoords:)
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
								(switch (rLab corpseWall:)
									(4
										(gEgo setScript: rats 0 4)
									)
									(2
										(gEgo setScript: rats 0 6)
									)
								)
							)
						)
						(4
							(if
								(and
									(OneOf
										(rLab labCoords:)
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
									(== (rLab corpseWall:) 1)
								)
								(gEgo setScript: rats 0 1)
							)
						)
						(2
							(if
								(and
									(OneOf
										(rLab labCoords:)
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
									(== (rLab corpseWall:) 1)
								)
								(gEgo setScript: rats 0 2)
							)
						)
					)
				)
			else
				(switch (rLab prevEdgeHit:)
					(1
						(cond
							(
								(OneOf
									(rLab labCoords:)
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
								(gEgo setScript: bats 0 1)
							)
							(
								(and
									(OneOf
										(rLab labCoords:)
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
									(OneOf
										(rLab labCoords:)
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
								)
								(if 2
									(gEgo setScript: bats 0 4)
								else
									(gEgo setScript: bats 0 2)
								)
							)
						)
					)
					(3
						(cond
							(
								(OneOf
									(rLab labCoords:)
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
								(gEgo setScript: bats 0 3)
							)
							(
								(and
									(OneOf
										(rLab labCoords:)
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
									(OneOf
										(rLab labCoords:)
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
								)
								(if 2
									(gEgo setScript: bats 0 4)
								else
									(gEgo setScript: bats 0 2)
								)
							)
						)
					)
					(4
						(cond
							(
								(OneOf
									(rLab labCoords:)
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
								(gEgo setScript: bats 0 4)
							)
							(
								(and
									(OneOf
										(rLab labCoords:)
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
									(OneOf
										(rLab labCoords:)
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
								(if 0
									(gEgo setScript: bats 0 1)
								else
									(gEgo setScript: bats 0 3)
								)
							)
						)
					)
					(2
						(cond
							(
								(OneOf
									(rLab labCoords:)
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
								(gEgo setScript: bats 0 2)
							)
							(
								(and
									(OneOf
										(rLab labCoords:)
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
									(OneOf
										(rLab labCoords:)
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
								(if 0
									(gEgo setScript: bats 0 1)
								else
									(gEgo setScript: bats 0 3)
								)
							)
						)
					)
				)
			)
		)
	)

	(method (init)
		(if (IsFlag 48)
			(self style: 10)
		else
			(self style: -32761)
		)
		(super init:)
		(if (== (rLab holeCoords:) gCurRoomNum)
			(proc404_1)
		)
		(if (and (== gPrevRoomNum 435) (not (rLab darkRoomLit:))) ; trapFloor
			0
		else
			(theTorch init:)
		)
		(if (!= gCurRoomNum 400) ; LBRoom
			(self makeCritters:)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((gCurRoom script:))
			((== (gEgo onControl: 1) 8192)
				(rLab prevEdgeHit: EDGE_LEFT)
				(gEgo setScript: 0)
				(gCurRoom setScript: (ScriptID 30 2)) ; walkOut
			)
			(
				(or
					(== (gEgo onControl: 1) 16384)
					(== (gEgo onControl: 1) 4096)
				)
				(rLab prevEdgeHit: EDGE_RIGHT)
				(gEgo setScript: 0)
				(gCurRoom setScript: (ScriptID 30 2)) ; walkOut
			)
			((== (gEgo edgeHit:) 3)
				(rLab prevEdgeHit: EDGE_BOTTOM)
				(gEgo setScript: 0)
				(gCurRoom setScript: (ScriptID 30 2)) ; walkOut
			)
			((== (gEgo edgeHit:) 1)
				(rLab prevEdgeHit: EDGE_TOP)
				(gEgo setScript: 0)
				(gCurRoom setScript: (ScriptID 30 2)) ; walkOut
			)
		)
		(super doit:)
	)
)

(instance theTorch of Prop
	(properties
		noun 9
		modNum 400
		sightAngle 45
		view 400
		priority 1
		signal 20497
		detailLevel 3
	)

	(method (show)
		(if (mod (rLab labCoords:) 2)
			(self view: 400 x: 228 y: 141 z: 81 setLoop: 8 cel: 1 stopUpd:)
			(theFlame
				x: (+ x 4)
				y: y
				z: 106
				setLoop: 3
				show:
				setCycle: Fwd
				checkDetail:
			)
			(if (!= gCurRoomNum 406)
				(torchCycler
					x: 233
					y: 48
					loop: 7
					show:
					setCycle: RandCycle
					checkDetail:
				)
			)
		else
			(self view: 400 x: 77 y: 141 z: 71 setLoop: 8 cel: 0 stopUpd:)
			(theFlame
				x: 84
				y: 141
				z: (if (== gCurRoomNum 406) 61 else 95)
				setLoop: 2
				show:
				setCycle: Fwd
				checkDetail:
			)
			(if (!= gCurRoomNum 406)
				(torchCycler
					x: 82
					y: 50
					loop: 6
					show:
					setCycle: RandCycle
					checkDetail:
				)
			)
		)
		(super show:)
	)

	(method (init)
		(if (mod (rLab labCoords:) 2)
			(self view: 400 x: 228 y: 141 z: 81 setLoop: 8 cel: 1 stopUpd:)
			(theFlame
				x: 232
				y: 141
				z: 106
				setLoop: 3
				init:
				setCycle: Fwd
				checkDetail:
			)
			(if (!= gCurRoomNum 410)
				(torchCycler
					x: 233
					y: 48
					setLoop: 7
					init:
					setCycle: RandCycle
					checkDetail:
				)
			)
		else
			(self
				view: 400
				x: 77
				y: 141
				z:
					(switch gCurRoomNum
						(406 37)
						(410 82)
						(else 71)
					)
				setLoop: 8
				cel: 0
				stopUpd:
			)
			(theFlame
				x: 84
				y: 141
				z:
					(switch gCurRoomNum
						(406 61)
						(410 106)
						(else 95)
					)
				setLoop: 2
				init:
				setCycle: Fwd
				checkDetail:
			)
			(torchCycler
				view: (if (!= gCurRoomNum 410) 400 else 410)
				x:
					(switch gCurRoomNum
						(406 77)
						(410 85)
						(else 82)
					)
				y:
					(switch gCurRoomNum
						(406 98)
						(410 30)
						(else 50)
					)
				setLoop: (if (== gCurRoomNum 406) 9 else 6)
				init:
				setCycle: RandCycle
				checkDetail:
			)
		)
		(super init:)
	)
)

(instance rat of Actor
	(properties
		noun 20
		view 410
		signal 24576
	)
)

(instance bat of Actor
	(properties
		noun 21
		yStep 10
		view 415
		priority 15
		signal 24592
		xStep 15
	)
)

(instance theFlame of Prop
	(properties
		noun 9
		modNum 400
		sightAngle 45
		view 400
		priority 1
		signal 20496
		detailLevel 3
	)
)

(instance torchCycler of Prop
	(properties
		modNum 400
		onMeCheck 0
		view 400
		signal 16401
		cycleSpeed 9
		detailLevel 3
	)
)

(instance corpseNiche of View
	(properties
		z 30
		noun 8
		modNum 400
		sightAngle 45
		view 400
		loop 1
		signal 20496
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gCurRoom setScript: checkBody 0 self)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		(switch (rLab corpseWall:)
			(1
				(self cel: 2 x: 135 y: 139 stopUpd:)
			)
			(4
				(self cel: 0 x: 62 y: 147 setPri: 10 stopUpd:)
			)
			(2
				(self cel: 1 x: 258 y: 150 setPri: 10 stopUpd:)
			)
		)
		(super init:)
	)
)

(instance leftDoor of View
	(properties
		x 63
		y 155
		noun 4
		modNum 400
		sightAngle 45
		view 405
		cel 1
		priority 11
		signal 28688
	)
)

(instance leftWing of View
	(properties
		x 43
		y 168
		noun 4
		modNum 400
		sightAngle 45
		view 405
		priority 13
		signal 28688
	)
)

(instance rightDoor of View
	(properties
		x 246
		y 155
		noun 4
		modNum 400
		sightAngle 45
		view 407
		priority 11
		signal 28688
	)
)

(instance rightWing of View
	(properties
		x 263
		y 169
		noun 4
		modNum 400
		sightAngle 45
		view 407
		cel 1
		priority 13
		signal 28688
	)
)

(instance topDoor of View
	(properties
		x 157
		y 144
		noun 4
		modNum 400
		sightAngle 45
		view 406
		priority 8
		signal 28688
	)
)

(instance bottomBlock of View
	(properties
		x 149
		y 189
		noun 6
		modNum 400
		sightAngle 45
		view 408
		priority 15
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25 ; holeInTheWall
				(gMessager say: 6 25 9 0 0 400) ; "The hole-in-the-wall wouldn't do Alexander much good there."
			)
			(1 ; Look
				(gMessager say: 6 1 9 0 0 400) ; "The walls of the catacombs are made of massive stone tiles."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance floor of Feature
	(properties
		noun 5
		modNum 400
		sightAngle 45
		onMeCheck 2048
	)
)

(instance eastWall of Feature
	(properties
		x 255
		y 140
		noun 6
		modNum 400
		sightAngle 45
		onMeCheck 17408
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 1 8 0 0 400) ; "The walls of the catacombs are made of massive stone tiles."
			)
			(25 ; holeInTheWall
				(if
					(not
						(OneOf
							(rLab labCoords:)
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
					)
					(proc404_0 2)
				else
					(gMessager say: 6 25 5 0 0 400) ; "Alexander doesn't need to use the hole-in-the-wall on that wall--he can just walk through the door to see what's on the other side."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance northWall of Feature
	(properties
		x 160
		y 120
		noun 6
		modNum 400
		sightAngle 45
		onMeCheck 4608
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 1 6 0 0 400) ; "The walls of the catacombs are made of massive stone tiles."
			)
			(25 ; holeInTheWall
				(if
					(not
						(OneOf
							(rLab labCoords:)
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
					)
					(proc404_0 1)
				else
					(gMessager say: 6 25 5 0 0 400) ; "Alexander doesn't need to use the hole-in-the-wall on that wall--he can just walk through the door to see what's on the other side."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance westWall of Feature
	(properties
		x 60
		y 140
		noun 6
		modNum 400
		sightAngle 45
		onMeCheck 8448
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 1 7 0 0 400) ; "The walls of the catacombs are made of massive stone tiles."
			)
			(25 ; holeInTheWall
				(if
					(not
						(OneOf
							(rLab labCoords:)
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
					)
					(proc404_0 4)
				else
					(gMessager say: 6 25 5 0 0 400) ; "Alexander doesn't need to use the hole-in-the-wall on that wall--he can just walk through the door to see what's on the other side."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance minotaurTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 25)
			)
			(1
				(if (and (== gCurRoomNum 400) (not (gCurRoom script:))) ; LBRoom
					(gGlobalSound4 number: 401 setLoop: 5 play:)
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(2
				(if
					(and
						(== gCurRoomNum 400) ; LBRoom
						(not (gCurRoom script:))
						(not (gEgo script:))
					)
					(if (== (rLab msgNum:) 3)
						(rLab msgNum: 1)
					else
						(rLab msgNum: (+ (rLab msgNum:) 1))
					)
					(gMessager say: 1 0 1 (rLab msgNum:) self 400)
				else
					(self cue:)
				)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance checkBody of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((< (register x:) 90)
						(gEgo setMotion: PolyPath 68 160 self)
					)
					((< (register x:) 230)
						(gEgo setMotion: PolyPath 147 149 self)
					)
					(else
						(gEgo setMotion: PolyPath 251 156 self)
					)
				)
			)
			(1
				(cond
					((< (register x:) 90)
						(gEgo posn: 58 164 setLoop: 2)
					)
					((< (register x:) 230)
						(gEgo posn: 148 150 setLoop: 4)
					)
					(else
						(gEgo posn: 250 163 setLoop: 3)
					)
				)
				(gEgo
					view: 431
					normal: 0
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2
				(cond
					((< (register x:) 90)
						(gEgo posn: 56 164 setLoop: 0)
					)
					((< (register x:) 230)
						(gEgo posn: 149 151 setLoop: 5)
					)
					(else
						(gEgo posn: 252 164 setLoop: 1)
					)
				)
				(gEgo cycleSpeed: 18 setCycle: End self)
			)
			(3
				(cond
					((< (register x:) 90)
						(gEgo posn: 68 160 reset: 1)
					)
					((< (register x:) 230)
						(gEgo posn: 147 149 reset: 3)
					)
					(else
						(gEgo posn: 246 161 reset: 0)
					)
				)
				(= cycles 6)
			)
			(4
				(gMessager say: 8 5 0 1 self 400) ; "Alexander examines the stone shelf and the ancient bones, but finds nothing except the dust of the grave."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gCurRoomNum 400) ; LBRoom
					(if (IsFlag 48)
						(gCurRoom drawPic: 400 10)
					else
						(gCurRoom drawPic: 400 -32761)
					)
				)
				(switch (rLab prevEdgeHit:)
					(4
						(gEgo
							posn: 282 158
							init:
							ignoreHorizon:
							setMotion: PolyPath 237 158 self
						)
					)
					(2
						(gEgo
							posn: 36 158
							init:
							ignoreHorizon:
							setMotion: PolyPath 84 158 self
						)
					)
					(1
						(gEgo
							posn: 165 250
							init:
							ignoreHorizon:
							setMotion: PolyPath 165 184 self
						)
					)
					(3
						(gEgo
							posn: 165 136
							init:
							ignoreHorizon:
							setMotion: PolyPath 165 145 self
						)
					)
					(else
						(gEgo posn: 160 160 loop: 2 init: ignoreHorizon:)
						(= ticks 6)
					)
				)
			)
			(1
				(if (not (rLab geniePresent:))
					(gGame handsOn:)
				)
				(self dispose:)
				(gTheIconBar enable: 6)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar disable: 6)
				(switch (rLab prevEdgeHit:)
					(1
						(= cycles 8)
					)
					(3
						(gEgo setMotion: MoveTo (gEgo x:) 250 self)
					)
					(2
						(gEgo setMotion: MoveTo 310 (gEgo y:) self)
					)
					(4
						(gEgo setMotion: MoveTo 10 (gEgo y:) self)
					)
				)
			)
			(1
				(switch (rLab prevEdgeHit:)
					(1
						(gCurRoom newRoom: (gCurRoom north:))
					)
					(3
						(gCurRoom newRoom: (gCurRoom south:))
					)
					(2
						(gCurRoom newRoom: (gCurRoom east:))
					)
					(4
						(gCurRoom newRoom: (gCurRoom west:))
					)
				)
			)
		)
	)
)

(instance bats of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(switch register
					(1
						(= temp0 3)
						(= temp1 206)
						(= temp2 185)
						(= temp3 195)
						(= temp4 164)
					)
					(3
						(= temp0 2)
						(= temp1 159)
						(= temp2 85)
						(= temp3 248)
						(= temp4 195)
					)
					(4
						(= temp0 1)
						(= temp1 246)
						(= temp2 74)
						(= temp3 184)
						(= temp4 76)
					)
					(2
						(= temp0 0)
						(= temp1 63)
						(= temp2 87)
						(= temp3 132)
						(= temp4 82)
					)
				)
				(bat
					posn: temp1 temp2
					setLoop: temp0
					init:
					setStep: 15 12
					setCycle: Walk
					setMotion: MoveTo temp3 temp4 self
				)
			)
			(1
				(switch register
					(1
						(= temp0 6)
						(= temp1 190)
						(= temp2 157)
					)
					(4
						(= temp0 5)
						(= temp1 170)
						(= temp2 70)
					)
					(2
						(= temp0 4)
						(= temp1 144)
						(= temp2 78)
					)
				)
				(if (== register 3)
					(+= state 2)
					(self cue:)
				else
					(bat setLoop: temp0 posn: temp1 temp2 setCycle: End self)
				)
			)
			(2
				(if (== register 1)
					(bat setLoop: 5 cel: 7 posn: 179 149)
					(= cycles 4)
				else
					(self cue:)
				)
			)
			(3
				(switch register
					(1
						(= temp0 3)
						(= temp1 169)
						(= temp2 142)
						(= temp3 159)
						(= temp4 88)
					)
					(4
						(= temp0 1)
						(= temp1 155)
						(= temp2 68)
						(= temp3 62)
						(= temp4 74)
					)
					(2
						(= temp0 0)
						(= temp1 160)
						(= temp2 77)
						(= temp3 248)
						(= temp4 78)
					)
				)
				(bat
					posn: temp1 temp2
					setLoop: temp0
					setCycle: Walk
					setMotion: MoveTo temp3 temp4 self
				)
			)
			(4
				(bat dispose:)
				(self dispose:)
			)
		)
	)
)

(instance rats of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(switch (= state newState)
			(0
				(switch register
					(1
						(= temp0 2)
						(= temp1 11)
						(= temp2 127)
						(= temp3 124)
						(= temp4 121)
						(= temp5 146)
					)
					(2
						(= temp0 2)
						(= temp1 11)
						(= temp2 192)
						(= temp3 123)
						(= temp4 195)
						(= temp5 149)
					)
					(3
						(= temp0 4)
						(= temp2 72)
						(= temp3 125)
						(= temp4 85)
						(= temp5 149)
					)
					(4
						(= temp0 4)
						(= temp2 58)
						(= temp3 132)
						(= temp4 64)
						(= temp5 169)
					)
					(5
						(= temp0 5)
						(= temp2 258)
						(= temp3 131)
						(= temp4 241)
						(= temp5 155)
					)
					(6
						(= temp0 5)
						(= temp2 258)
						(= temp3 131)
						(= temp4 241)
						(= temp5 155)
					)
				)
				(rat
					posn: temp2 temp3
					setLoop: temp0
					cel: 0
					init:
					setStep: 15 11
					setCycle: 0
					setMotion: MoveTo temp4 temp5 self
				)
			)
			(1
				(switch register
					(1
						(= temp0 2)
						(= temp2 121)
						(= temp3 146)
						(= temp4 109)
						(= temp5 158)
					)
					(2
						(= temp0 2)
						(= temp2 195)
						(= temp3 149)
						(= temp4 206)
						(= temp5 161)
					)
					(3
						(= temp0 0)
						(= temp2 88)
						(= temp3 149)
						(= temp4 132)
						(= temp5 149)
					)
					(4
						(= temp0 2)
						(= temp2 64)
						(= temp3 174)
						(= temp4 65)
						(= temp5 200)
					)
					(5
						(= temp0 1)
						(= temp2 240)
						(= temp3 155)
						(= temp4 194)
						(= temp5 152)
					)
					(6
						(= temp0 2)
						(= temp2 233)
						(= temp3 159)
						(= temp4 232)
						(= temp5 200)
					)
				)
				(rat
					setLoop: temp0
					posn: temp2 temp3
					setStep: 8 5
					setCycle: Walk
					setMotion: MoveTo temp4 temp5 self
				)
			)
			(2
				(switch register
					(1
						(= temp0 1)
						(= temp2 106)
						(= temp3 157)
						(= temp4 36)
						(= temp5 157)
					)
					(2
						(= temp0 0)
						(= temp2 212)
						(= temp3 160)
						(= temp4 275)
						(= temp5 160)
					)
					(3
						(= temp0 3)
						(= temp2 138)
						(= temp3 146)
						(= temp4 135)
						(= temp5 138)
					)
					(4
						(rat dispose:)
						(self dispose:)
					)
					(5
						(= temp0 3)
						(= temp2 186)
						(= temp3 152)
						(= temp4 179)
						(= temp5 135)
					)
					(6
						(rat dispose:)
						(self dispose:)
					)
				)
				(rat
					setLoop: temp0
					posn: temp2 temp3
					setCycle: Walk
					setMotion: MoveTo temp4 temp5 self
				)
			)
			(3
				(rat dispose:)
				(self dispose:)
			)
		)
	)
)

