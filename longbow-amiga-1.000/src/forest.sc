;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use n013)
(use n221)
(use moveBushes)
(use n228)
(use n231)
(use n233)
(use n241)
(use sweepRgn)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use FlipPoly)
(use PolyPath)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	forest 0
	forestBlown 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7 = 1
	local8 = 1
	local9
	local10
	[local11 10] = [-190 42 -150 74 -180 84 -250 105 -210 152]
	[local21 4] = [5 3 4 2]
	[local25 5] = [1220 10 1 1 0]
	[local30 8] = [-1 0 0 0 0 0 0 0]
)

(procedure (localproc_0)
	(gSFX2 number: 916 loop: 1 play:)
	(+= gScore 75)
	((ScriptID 0 1) doit:) ; statLine
)

(procedure (localproc_1)
	(if (gCurRoom obstacles:)
		((gCurRoom obstacles:) dispose:)
	)
	(gCurRoom obstacles: 0)
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1)
	(if (< (= temp1 param1) 0)
		(for ((= temp0 0)) [local11 temp0] ((+= temp0 2))
			(if (== param1 [local11 temp0])
				(= temp1 [local11 (+ temp0 1)])
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
				)
				(return temp1)
			)
		)
		(if (< temp1 0)
			(= temp1 1158)
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
	)
	(for ((= temp0 1)) (< temp0 10) ((+= temp0 2))
		(if (== temp1 [local11 temp0])
			(return [local11 (- temp0 1)])
		)
	)
	(return temp1)
)

(procedure (localproc_3 param1 param2 &tmp temp0 temp1)
	(= gForestRoomNum param1)
	(= global40 0)
	(= global104 (gEgo x:))
	(if (< (= global105 (gEgo y:)) 83)
		(= global105 85)
	)
	(cond
		((== (mod gForestRoomNum 3) 0)
			(= local8 0)
			(= local0 220)
		)
		((== (mod gForestRoomNum 3) 1)
			(= local7 0)
			(= local0 230)
		)
		((== (mod gForestRoomNum 3) 2)
			(= local8 0)
			(= local7 0)
			(= local0 240)
		)
	)
	(if local9
		(= local9 0)
		(= temp0 100)
	else
		(= temp0 [local21 (- param2 1)])
	)
	(if
		(OneOf
			gForestRoomNum
			19
			21
			23
			35
			50
			52
			65
			68
			82
			83
			85
			86
			89
			115
			121
			131
			133
			151
			154
		)
		(if (== local0 230)
			(proc233_0)
		else
			(proc228_0)
		)
	else
		(switch local0
			(220
				(proc221_0)
			)
			(230
				(proc231_0)
			)
			(240
				(proc241_0)
			)
		)
	)
	(if
		(or
			(and (== gDay 9) (not (IsFlag 36)))
			(and (== gDay 12) (not (IsFlag 38)))
		)
		(proc750_3)
	)
	(if (OneOf gForestRoomNum 21 36 37 38 50 56 67 75 98 99 103 115 119 135 167)
		(= local8 0)
		(= local7 0)
		(gCurRoom curPic: local0)
		(gCurRoom picture: local0)
		(gCurRoom drawPic: local0 (| temp0 $4000) 1 0)
		(if
			(not
				(OneOf
					gForestRoomNum
					19
					21
					23
					35
					50
					52
					65
					68
					82
					83
					85
					86
					89
					115
					121
					131
					133
					151
					154
				)
			)
			(FlipPoly)
		)
	else
		(gCurRoom style: temp0 picture: local0 curPic: local0 drawPic: local0)
	)
	(cond
		(
			(OneOf
				gForestRoomNum
				2
				3
				4
				5
				6
				7
				17
				24
				25
				26
				27
				32
				43
				48
				60
				64
				76
				81
				91
				97
				107
				113
				123
				129
				139
				146
				147
				148
				149
				156
				168
				169
				170
				171
				182
				183
			)
			(= local8 0)
			(= local7 0)
			(proc225_2)
		)
		(
			(or
				(== gForestRoomNum 116)
				(== gForestRoomNum 117)
				(== gForestRoomNum 131)
				(== gForestRoomNum 133)
				(== gForestRoomNum 154)
				(== gForestRoomNum 18)
				(== gForestRoomNum 33)
				(== gForestRoomNum 35)
				(== gForestRoomNum 52)
				(== gForestRoomNum 54)
				(== gForestRoomNum 69)
				(== gForestRoomNum 119)
				(== gForestRoomNum 121)
				(== gForestRoomNum 135)
				(== gForestRoomNum 137)
				(== gForestRoomNum 51)
				(== gForestRoomNum 65)
				(== gForestRoomNum 82)
				(== gForestRoomNum 19)
				(== gForestRoomNum 21)
				(== gForestRoomNum 36)
				(== gForestRoomNum 98)
				(== gForestRoomNum 115)
				(== gForestRoomNum 130)
				(== gForestRoomNum 23)
				(== gForestRoomNum 37)
				(== gForestRoomNum 38)
				(== gForestRoomNum 106)
				(== gForestRoomNum 138)
				(== gForestRoomNum 50)
				(== gForestRoomNum 67)
				(== gForestRoomNum 68)
				(== gForestRoomNum 72)
				(== gForestRoomNum 83)
				(== gForestRoomNum 85)
				(== gForestRoomNum 86)
				(== gForestRoomNum 89)
				(== gForestRoomNum 99)
				(== gForestRoomNum 100)
				(== gForestRoomNum 101)
				(== gForestRoomNum 104)
				(== gForestRoomNum 136)
				(== gForestRoomNum 151)
				(== gForestRoomNum 153)
				(== gForestRoomNum 167)
			)
			(proc225_1)
		)
	)
	(if
		(or
			(== gForestRoomNum 132)
			(== gForestRoomNum 155)
			(== gForestRoomNum 34)
			(== gForestRoomNum 53)
			(== gForestRoomNum 120)
			(== gForestRoomNum 66)
			(== gForestRoomNum 20)
			(== gForestRoomNum 114)
			(== gForestRoomNum 22)
			(== gForestRoomNum 122)
			(== gForestRoomNum 88)
			(== gForestRoomNum 49)
		)
		(proc225_0)
	else
		(= local8 0)
		(= local7 0)
	)
	(if
		(and
			(IsFlag 21)
			(IsFlag 199)
			(== gDay 2)
			(OneOf gForestRoomNum 19 40 52 70 82 100 106 118 130 136 151 166)
			(!= gEgoEdgeHit 3)
		)
		(forest setScript: 0)
		((ScriptID 226 0) init:) ; marian
	else
		(if
			(and
				local7
				(not (Random 0 8))
				(> gMachineSpeedZeroOrSix 4)
				(!= gDay 9)
				(!= gDay 12)
			)
			(bunny init:)
		)
		(if
			(and
				local8
				(not (Random 0 25))
				(or (== gEgoEdgeHit 2) (== gEgoEdgeHit 4))
				(> gMachineSpeedZeroOrSix 4)
				(!= gDay 9)
				(!= gDay 12)
			)
			(buck init: setScript: stampede 0 param2)
		)
		(gEgo setScript: egoEnters 0 param2)
	)
)

(instance forest of Rm
	(properties
		horizon 82
		north 220
		east 220
		south 220
		west 220
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1220 (+ 12 (- gDay 1)) 1)
			)
			(3 ; Do
				(Say 1220 25 1) ; "There's nothing I need from this part of the forest."
			)
			(5 ; Talk
				(Say 1220 26 1) ; "I talk to the trees, but they don't listen to me."
			)
			(4 ; Inventory
				(if
					(and
						(== invItem 4) ; net
						(> gMouseY (+ horizon 10))
						(not (gEgo script:))
					)
					(if
						(OneOf
							gForestRoomNum
							2
							3
							4
							5
							6
							7
							17
							24
							25
							26
							27
							32
							43
							48
							60
							64
							76
							81
							91
							97
							107
							113
							123
							129
							139
							146
							147
							148
							149
							156
							168
							169
							170
							171
							182
							183
						)
						(Say 1220 31 1) ; "I'd best not throw the net here. It may become entangled in the thorny bushes."
					else
						(gEgo setScript: (ScriptID 181 1) gMouseX gMouseY) ; tossIt
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

	(method (init &tmp temp0)
		(ScriptID 225)
		(LoadMany
			rsVIEW
			805
			792
			764
			763
			230
			231
			232
			233
			234
			235
			236
			237
			238
			(if (== gDay 2)
				214
				218
				16
				4
				5
				7
				585
			)
			(switch gDisguiseNum
				(0 ; outlaw
					0
					1
					2
				)
				(1 ; beggar
					36
					37
					38
				)
				(2 ; jewler (no rouge)
					29
					30
					31
				)
				(3 ; jewler (rouge)
					29
					30
					31
				)
				(4 ; yeoman
					33
					34
					35
				)
				(5 ; abbey monk
					23
					24
					27
				)
				(6 ; fens monk
					16
					17
					18
				)
			)
		)
		(switch gPrevRoomNum
			(100
				(= temp0 gForestRoomNum)
			)
			(110
				(gEgo posn: 1 170)
				(= temp0 (= gForestRoomNum 71))
			)
			(120
				(if
					(and
						(or
							(== gForestRoomNum 9)
							(== gForestRoomNum 25)
							(== gForestRoomNum 40)
							(== gForestRoomNum 55)
							(== gForestRoomNum 71)
							(== gForestRoomNum 87)
							(== gForestRoomNum 102)
							(== gForestRoomNum 118)
							(== gForestRoomNum 134)
							(== gForestRoomNum 150)
						)
						(== gEgoEdgeHit 4)
					)
					(-- gForestRoomNum)
				)
				(if
					(and
						(or
							(== gForestRoomNum 24)
							(== gForestRoomNum 39)
							(== gForestRoomNum 54)
							(== gForestRoomNum 70)
							(== gForestRoomNum 86)
							(== gForestRoomNum 101)
							(== gForestRoomNum 117)
							(== gForestRoomNum 133)
							(== gForestRoomNum 149)
						)
						(== gEgoEdgeHit 2)
					)
					(++ gForestRoomNum)
				)
				(= temp0 gForestRoomNum)
			)
			(else
				(= gForestRoomNum (- (= temp0 gPrevRoomNum)))
				(= temp0 (localproc_2 gForestRoomNum gEgoEdgeHit))
			)
		)
		(= local9 1)
		(HandsOn)
		(super init: &rest)
		(if (or (!= (gRgnMusic number:) 905) (not (gRgnMusic handle:)))
			(gRgnMusic number: 905 play:)
		)
		(localproc_3 temp0 gEgoEdgeHit)
	)

	(method (doit &tmp temp0)
		(cond
			((gEgo script:))
			((and global199 (not (IsFlag 129)))
				(= global199 0)
				(handSignCode doit:)
			)
			((gEgo edgeHit:)
				(= gEgoEdgeHit (gEgo edgeHit:))
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (and (< gDay 8) (not (IsFlag 118)))
					((ScriptID 185 4) doit:) ; dumpSprite
				)
				(if local6
					(AddToAddToPics funnyBunny)
					(bunny dispose:)
				)
				(gEgo setScript: walkOut 0 gEgoEdgeHit)
			)
			(else
				(super doit:)
			)
		)
	)

	(method (cue)
		(gEgo actions: forestBlown)
		(if (and (< gDay 8) (not (IsFlag 118)))
			(self setScript: PT)
		)
	)

	(method (dispose)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(= global104 (gEgo x:))
		(= global105 (gEgo y:))
		(= global111 (gEgo loop:))
		(= gPrevRoomNum gCurRoomNum)
		(LoadMany 0 223 225 226)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (and (== gDay 11) (IsFlag 64))
			(++ gRoomCount)
		)
		(localproc_1)
		(gFeatures eachElementDo: #dispose release:)
		(gAddToPics eachElementDo: #dispose release:)
		(if (not (gEgo script:))
			(HandsOn)
		)
		(cond
			((== gDeathNum 33)
				(= newRoomNumber 170) ; robinDeath
				(super newRoom: 170) ; robinDeath
			)
			(local3
				(= newRoomNumber 180)
				(super newRoom: 180)
			)
			(local1
				((ScriptID 226 14) doit:) ; dumpMarian
				(= newRoomNumber 160)
				(super newRoom: 160)
			)
			(local4
				(if (and (== gEgoEdgeHit 4) (== gForestRoomNum 71))
					(= newRoomNumber 110)
				else
					(= newRoomNumber 120)
				)
				(super newRoom: newRoomNumber)
			)
			((IsFlag 194)
				(if
					(OneOf
						gForestRoomNum
						2
						3
						4
						5
						6
						7
						17
						24
						25
						26
						27
						32
						43
						48
						60
						64
						76
						81
						91
						97
						107
						113
						123
						129
						139
						146
						147
						148
						149
						156
						168
						169
						170
						171
						182
						183
					)
					(AddToAddToPics (ScriptID 225 9)) ; dummyBush
				)
				(= newRoomNumber 170) ; robinDeath
				(super newRoom: 170) ; robinDeath
			)
			((IsFlag 176)
				(if (IsFlag 37)
					((ScriptID 185 4) doit:) ; dumpSprite
				)
				(ClearFlag 176)
				(= newRoomNumber 171) ; strat
				(super newRoom: 171) ; strat
			)
			((IsFlag 170)
				(ClearFlag 170)
				(if (< gForestSweepRoomCount 3)
					(= gForestSweepRoomCount 0)
				)
				(cond
					((and (== gDay 2) (IsFlag 182))
						(if (and (not (gEgo mover:)) (!= gDisguiseNum 1)) ; beggar
							(robinHead init:)
							(gAddToPics add: robinHead)
						)
						(robin init:)
						(gAddToPics add: robin)
						(gAddToPics doit:)
						((ScriptID 226 14) doit:) ; dumpMarian
						(= newRoomNumber 160)
					)
					((and (< gDay 8) (not (IsFlag 118)))
						(if (and (not (gEgo mover:)) (!= gDisguiseNum 1)) ; beggar
							(robinHead init:)
							(gAddToPics add: robinHead)
						)
						(robin init:)
						(gAddToPics add: robin)
						(gAddToPics doit:)
						((ScriptID 185 4) doit:) ; dumpSprite
						(= newRoomNumber 100)
					)
					(else
						(= newRoomNumber 100)
					)
				)
				((ScriptID 0 1) doit:) ; statLine
				(super newRoom: newRoomNumber)
			)
			(local5
				(= newRoomNumber 100)
				(super newRoom: 100)
			)
			(
				(<
					(= newRoomNumber
						(localproc_2 gForestRoomNum (= gEgoEdgeHit (gEgo edgeHit:)))
					)
					0
				)
				(super newRoom: (- newRoomNumber))
			)
			(else
				(if
					(OneOf
						gForestRoomNum
						2
						3
						4
						5
						6
						7
						17
						24
						25
						26
						27
						32
						43
						48
						60
						64
						76
						81
						91
						97
						107
						113
						123
						129
						139
						146
						147
						148
						149
						156
						168
						169
						170
						171
						182
						183
					)
					((ScriptID 225 4) ; liveBush
						signal: (& ((ScriptID 225 4) signal:) $ffbe) ; liveBush
						dispose:
						delete:
					)
				)
				(localproc_3 newRoomNumber gEgoEdgeHit)
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 129))
					(NormalEgo)
				)
				(switch register
					(1
						(cond
							((== local0 220)
								(cond
									(21
										36
										37
										38
										50
										56
										67
										75
										98
										99
										103
										115
										119
										135
										167
										(if
											(and
												(> (gEgo x:) 35)
												(< (gEgo x:) 150)
											)
											(= global104 155)
										)
									)
									(
										(and
											(> (gEgo x:) 170)
											(< (gEgo x:) 285)
										)
										(= global104 165)
									)
								)
							)
							((== local0 240)
								(cond
									(
										(and
											(< (gEgo x:) 160)
											(> (gEgo x:) 60)
										)
										(= global104 56)
									)
									(
										(and
											(>= (gEgo x:) 160)
											(< (gEgo x:) 260)
										)
										(= global104 264)
									)
								)
							)
						)
						(gEgo posn: global104 240 init:)
						(if (and (IsFlag 129) (> gForestSweepRoomCount 3))
							(gEgo setMotion: PolyPath 160 150 self)
						else
							(gEgo setMotion: PolyPath global104 184 self)
						)
					)
					(2
						(gEgo posn: -20 global105 init:)
						(if (and (IsFlag 129) (> gForestSweepRoomCount 3))
							(gEgo setMotion: PolyPath 160 150 self)
						else
							(gEgo setMotion: PolyPath 60 global105 self)
						)
					)
					(3
						(gEgo posn: global104 89 init:)
						(if (and (IsFlag 129) (> gForestSweepRoomCount 3))
							(gEgo setMotion: PolyPath 160 150 self)
						else
							(gEgo setMotion: PolyPath global104 110 self)
						)
					)
					(4
						(gEgo posn: 345 global105 init:)
						(if (and (IsFlag 129) (> gForestSweepRoomCount 3))
							(gEgo setMotion: PolyPath 160 150 self)
						else
							(gEgo setMotion: PolyPath 260 global105 self)
						)
					)
					(else
						(gEgo posn: 185 130 loop: 2 init:)
						(NormalEgo)
						(= ticks 12)
					)
				)
			)
			(1
				(if (IsFlag 179)
					(ClearFlag 179)
					(Converse 1 @local25 @local30 0 self) ; "Thank the Blessed Virgin! The sprite's spell has worn off!"
				else
					(self cue:)
				)
			)
			(2
				(HandsOn)
				(if (and (== gPrevRoomNum 120) global203)
					(= global203 0)
					(Say 1220 9 0) ; "For one of my reputation for daring, wit and cunning, that was a dazzling display of indecision."
				)
				(if (and (IsFlag 129) (!= gDisguiseNum 1)) ; beggar
					(gTheIconBar disable: 5)
					(proc750_2)
				else
					(gEgo actions: forestBlown)
				)
				(if
					(and
						(not
							(OneOf
								gForestRoomNum
								2
								3
								4
								5
								6
								7
								17
								24
								25
								26
								27
								32
								43
								48
								60
								64
								76
								81
								91
								97
								107
								113
								123
								129
								139
								146
								147
								148
								149
								156
								168
								169
								170
								171
								182
								183
							)
						)
						(not (IsFlag 118))
						(< gDay 8)
						(not
							(or
								(== gForestRoomNum 132)
								(== gForestRoomNum 155)
								(== gForestRoomNum 34)
								(== gForestRoomNum 53)
								(== gForestRoomNum 120)
								(== gForestRoomNum 66)
								(== gForestRoomNum 20)
								(== gForestRoomNum 114)
								(== gForestRoomNum 22)
								(== gForestRoomNum 122)
								(== gForestRoomNum 88)
								(== gForestRoomNum 49)
							)
						)
					)
					(Load rsSCRIPT 185)
					(forest setScript: PT)
				else
					(forest setScript: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(HandsOff)
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(switch register
					(3
						(= temp1 240)
					)
					(2
						(+= temp0 20)
					)
					(4
						(-= temp0 20)
					)
				)
				(if (!= register 1)
					(gEgo setMotion: PolyPath temp0 temp1 self)
				else
					(self cue:)
				)
			)
			(1
				(switch gEgoEdgeHit
					(1
						(cond
							(
								(or
									(== gForestRoomNum 59)
									(== gForestRoomNum 23)
									(== gForestRoomNum 155)
								)
								(if (> (gEgo x:) 210)
									(gEgo x: 210)
								)
								(self cue:)
							)
							((or (== gForestRoomNum 18) (== gForestRoomNum 33))
								(if (< (gEgo x:) 110)
									(gEgo x: 110)
								)
								(self cue:)
							)
							(else
								(self cue:)
							)
						)
					)
					(3
						(cond
							(
								(or
									(== gForestRoomNum 75)
									(== gForestRoomNum 155)
									(== gForestRoomNum 167)
								)
								(if (> (gEgo x:) 210)
									(gEgo x: 210)
								)
								(self cue:)
							)
							((or (== gForestRoomNum 130) (== gForestRoomNum 65))
								(if (< (gEgo x:) 110)
									(gEgo x: 110)
								)
								(self cue:)
							)
							(else
								(self cue:)
							)
						)
					)
					(else
						(if
							(and
								(or
									(== gForestRoomNum 75)
									(== gForestRoomNum 155)
									(== gForestRoomNum 167)
								)
								(> (gEgo y:) 120)
							)
							(gEgo y: 120)
						)
						(self cue:)
					)
				)
			)
			(2
				(if
					(and
						(not (IsFlag 199))
						(== gDay 2)
						(OneOf
							gForestRoomNum
							19
							40
							52
							70
							82
							100
							106
							118
							130
							136
							151
							166
						)
					)
					(SetFlag 199)
				)
				(if (< gDay 8)
					(gEgo actions: forestBlown)
					((ScriptID 185 4) doit:) ; dumpSprite
				)
				(cond
					((and (== gDay 9) (IsFlag 36))
						(gTheIconBar enable: 5)
						(gEgo actions: forestBlown)
					)
					((and (== gDay 12) (IsFlag 38))
						(gTheIconBar enable: 5)
						(gEgo actions: forestBlown)
					)
				)
				(cond
					((and (IsFlag 42) (not (IsFlag 118)))
						(= local3 1)
						(gCurRoom newRoom: 180)
					)
					((and (== gDay 2) (IsFlag 182))
						(= local1 1)
						(gCurRoom newRoom: 160)
					)
					(
						(or
							(and
								(or
									(== gForestRoomNum 24)
									(== gForestRoomNum 39)
									(== gForestRoomNum 54)
									(== gForestRoomNum 70)
									(== gForestRoomNum 86)
									(== gForestRoomNum 101)
									(== gForestRoomNum 117)
									(== gForestRoomNum 133)
									(== gForestRoomNum 149)
								)
								(== gEgoEdgeHit 2)
							)
							(and
								(or
									(== gForestRoomNum 9)
									(== gForestRoomNum 25)
									(== gForestRoomNum 40)
									(== gForestRoomNum 55)
									(== gForestRoomNum 71)
									(== gForestRoomNum 87)
									(== gForestRoomNum 102)
									(== gForestRoomNum 118)
									(== gForestRoomNum 134)
									(== gForestRoomNum 150)
								)
								(== gEgoEdgeHit 4)
							)
							(and
								(or
									(== gForestRoomNum 24)
									(== gForestRoomNum 39)
									(== gForestRoomNum 86)
								)
								(== gEgoEdgeHit 3)
							)
							(and
								(or
									(== gForestRoomNum 40)
									(== gForestRoomNum 55)
									(== gForestRoomNum 102)
								)
								(== gEgoEdgeHit 1)
							)
						)
						(= local4 1)
						(if (and (== gEgoEdgeHit 4) (== gForestRoomNum 71))
							(= temp2 110)
						else
							(= temp2 120)
						)
						(gCurRoom newRoom: temp2)
					)
					(
						(or
							(and
								(or
									(== gForestRoomNum 48)
									(== gForestRoomNum 81)
									(== gForestRoomNum 97)
									(== gForestRoomNum 113)
									(== gForestRoomNum 2)
									(== gForestRoomNum 17)
									(== gForestRoomNum 32)
									(== gForestRoomNum 64)
									(== gForestRoomNum 129)
									(== gForestRoomNum 146)
									(== gForestRoomNum 166)
									(== gForestRoomNum 182)
								)
								(== gEgoEdgeHit 4)
							)
							(and
								(or
									(== gForestRoomNum 43)
									(== gForestRoomNum 91)
									(== gForestRoomNum 107)
									(== gForestRoomNum 123)
									(== gForestRoomNum 139)
									(== gForestRoomNum 76)
									(== gForestRoomNum 171)
									(== gForestRoomNum 183)
									(== gForestRoomNum 7)
									(== gForestRoomNum 27)
									(== gForestRoomNum 60)
									(== gForestRoomNum 156)
								)
								(== gEgoEdgeHit 2)
							)
							(and
								(or
									(== gForestRoomNum 3)
									(== gForestRoomNum 4)
									(== gForestRoomNum 5)
									(== gForestRoomNum 6)
									(== gForestRoomNum 24)
									(== gForestRoomNum 25)
									(== gForestRoomNum 26)
									(== gForestRoomNum 2)
									(== gForestRoomNum 17)
									(== gForestRoomNum 32)
									(== gForestRoomNum 7)
									(== gForestRoomNum 27)
									(== gForestRoomNum 60)
								)
								(== gEgoEdgeHit 1)
							)
							(and
								(or
									(== gForestRoomNum 147)
									(== gForestRoomNum 148)
									(== gForestRoomNum 149)
									(== gForestRoomNum 168)
									(== gForestRoomNum 169)
									(== gForestRoomNum 170)
									(== gForestRoomNum 182)
									(== gForestRoomNum 64)
									(== gForestRoomNum 129)
									(== gForestRoomNum 146)
									(== gForestRoomNum 76)
									(== gForestRoomNum 171)
									(== gForestRoomNum 183)
								)
								(== gEgoEdgeHit 3)
							)
						)
						(= local5 1)
						(cond
							(
								(and
									(== gDay 9)
									(IsFlag 129)
									(not (IsFlag 36))
								)
								(gSFX fade: 0 15 16 1)
								(SetFlag 36)
								(localproc_0)
								(= gForestSweepRoomCount 0)
							)
							(
								(and
									(== gDay 12)
									(IsFlag 129)
									(not (IsFlag 38))
								)
								(gSFX fade: 0 15 16 1)
								(SetFlag 38)
								(localproc_0)
								(= gForestSweepRoomCount 0)
							)
						)
						(= temp2 100)
						(gCurRoom newRoom: 100)
					)
					(else
						(gCurRoom newRoom: 220) ; forest
					)
				)
				(forest setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance bunny of Actor
	(properties
		view 764
		signal 16384
		xStep 8
	)

	(method (init &tmp temp0)
		(super init:)
		(= local6 1)
		(= temp0 (Random 1 2))
		(gEgo signal: (| (gEgo signal:) $4000))
		(gSFX2 number: (Random 921 923) loop: 1 play:)
		(cond
			((> (gEgo x:) 185)
				(if (== temp0 2)
					(bunny
						x: -15
						y: (Random 91 101)
						setLoop: 3
						setCycle: Walk
						setMotion: PolyPath 330 (Random 91 101) self
					)
				else
					(bunny
						x: -15
						y: (Random 145 175)
						setLoop: 3
						setCycle: Walk
						setMotion: PolyPath 330 (Random 145 175) self
					)
				)
			)
			((== temp0 2)
				(bunny
					x: 330
					y: (Random 91 101)
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo -15 (Random 91 101) self
				)
			)
			(else
				(bunny
					x: 330
					y: (Random 145 175)
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo -15 (Random 145 175) self
				)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1220 0 0) ; "A cony."
			)
			(10 ; Longbow
				(Say 1220 1 0) ; "We've plenty of rabbit in the larder."
			)
			(3 ; Do
				(Say 1220 2 0) ; "I can hardly catch it with my bare hands."
			)
			(5 ; Talk
				(Say 1220 3 0) ; "The day I talk to a rabbit, I'll know I've been in the forest far too long."
			)
			(4 ; Inventory
				(if (== invItem 4) ; net
					(Say 1220 4 0) ; "I doubt I was given a magical net so that I could throw it at a mere rabbit."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(= local6 0)
		(gEgo signal: (& (gEgo signal:) $bfff))
		(self dispose:)
		(super cue:)
	)
)

(instance robin of PicView
	(properties)

	(method (init)
		(super init:)
		(self
			view: (gEgo view:)
			loop: (gEgo loop:)
			cel: (gEgo cel:)
			signal: (gEgo signal:)
			x: (gEgo x:)
			y: (gEgo y:)
		)
	)
)

(instance robinHead of PicView
	(properties)

	(method (init)
		(super init:)
		(self
			view: (gEgoHead view:)
			loop: (gEgoHead loop:)
			cel: (gEgoHead cel:)
			signal: (gEgoHead signal:)
			x: (gEgoHead x:)
			y: (gEgoHead y:)
			z: (gEgoHead z:)
		)
	)
)

(instance funnyBunny of PicView
	(properties)

	(method (init)
		(super init:)
		(self
			view: (bunny view:)
			loop: (bunny loop:)
			cel: (bunny cel:)
			x: (bunny x:)
			y: (bunny y:)
		)
	)
)

(instance buck of Actor
	(properties
		view 763
		signal 16384
		xStep 80
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1220 5 0) ; "Venison on the hoof."
			)
			(10 ; Longbow
				(Say 1220 6 0) ; "The larder is well-stocked with venison for now."
			)
			(5 ; Talk
				(Say 1220 7 0) ; "I think the hunted would have little to say to the hunter."
			)
			(4 ; Inventory
				(if (== invItem 4) ; net
					(Say 1220 8 0) ; "One doesn't catch deer with nets."
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

(instance doe1 of Actor
	(properties
		view 763
		signal 16384
		xStep 80
	)

	(method (doVerb theVerb)
		(buck doVerb: theVerb)
	)
)

(instance doe2 of Actor
	(properties
		view 763
		signal 16384
		xStep 80
	)

	(method (doVerb theVerb)
		(buck doVerb: theVerb)
	)
)

(instance stampede of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSFX2 number: (Random 897 899) loop: 1 play:)
				(if (== register 2)
					(buck
						x: -15
						y: 140
						setLoop: 3
						init:
						setCycle: Fwd
						setMotion: PolyPath 400 115 self
					)
					(doe1
						x: -30
						y: 120
						setLoop: 1
						cel: 2
						init:
						setCycle: Fwd
						setMotion: PolyPath 395 95
					)
					(doe2
						x: -25
						y: 182
						setLoop: 1
						cel: 5
						init:
						setCycle: Fwd
						setMotion: PolyPath 380 157
					)
				else
					(buck
						x: 370
						y: 120
						setLoop: 4
						init:
						setCycle: Fwd
						setMotion: PolyPath -75 160 self
					)
					(doe1
						x: 325
						y: 90
						setLoop: 2
						cel: 2
						init:
						setCycle: Fwd
						setMotion: PolyPath -70 130
					)
					(doe2
						x: 360
						y: 140
						setLoop: 2
						cel: 5
						init:
						setCycle: Fwd
						setMotion: PolyPath -55 182
					)
				)
			)
			(1
				(doe1 dispose:)
				(doe2 dispose:)
				(buck dispose:)
				(self dispose:)
			)
		)
	)
)

(instance handSignCode of Code
	(properties)

	(method (doit)
		(cond
			(
				(and
					(!= gDisguiseNum 0) ; outlaw
					(or
						(== gForestRoomNum 132)
						(== gForestRoomNum 155)
						(== gForestRoomNum 34)
						(== gForestRoomNum 53)
						(== gForestRoomNum 120)
						(== gForestRoomNum 66)
						(== gForestRoomNum 20)
						(== gForestRoomNum 114)
						(== gForestRoomNum 22)
						(== gForestRoomNum 122)
						(== gForestRoomNum 88)
						(== gForestRoomNum 49)
						(== gForestRoomNum 116)
						(== gForestRoomNum 117)
						(== gForestRoomNum 131)
						(== gForestRoomNum 133)
						(== gForestRoomNum 154)
						(== gForestRoomNum 18)
						(== gForestRoomNum 33)
						(== gForestRoomNum 35)
						(== gForestRoomNum 52)
						(== gForestRoomNum 54)
						(== gForestRoomNum 69)
						(== gForestRoomNum 119)
						(== gForestRoomNum 121)
						(== gForestRoomNum 135)
						(== gForestRoomNum 137)
						(== gForestRoomNum 51)
						(== gForestRoomNum 65)
						(== gForestRoomNum 82)
						(== gForestRoomNum 19)
						(== gForestRoomNum 21)
						(== gForestRoomNum 36)
						(== gForestRoomNum 98)
						(== gForestRoomNum 115)
						(== gForestRoomNum 130)
						(== gForestRoomNum 23)
						(== gForestRoomNum 37)
						(== gForestRoomNum 38)
						(== gForestRoomNum 106)
						(== gForestRoomNum 138)
						(== gForestRoomNum 50)
						(== gForestRoomNum 67)
						(== gForestRoomNum 68)
						(== gForestRoomNum 72)
						(== gForestRoomNum 83)
						(== gForestRoomNum 85)
						(== gForestRoomNum 86)
						(== gForestRoomNum 89)
						(== gForestRoomNum 99)
						(== gForestRoomNum 100)
						(== gForestRoomNum 101)
						(== gForestRoomNum 104)
						(== gForestRoomNum 136)
						(== gForestRoomNum 151)
						(== gForestRoomNum 153)
						(== gForestRoomNum 167)
					)
				)
				(if
					(OneOf
						gForestRoomNum
						2
						3
						4
						5
						6
						7
						17
						24
						25
						26
						27
						32
						43
						48
						60
						64
						76
						81
						91
						97
						107
						113
						123
						129
						139
						146
						147
						148
						149
						156
						168
						169
						170
						171
						182
						183
					)
					(Say 1220 29 1) ; "It would seem the bushes will not answer me in this guise."
				else
					(Say 1220 28 1) ; "It would seem the Trees will not answer me in this guise."
				)
			)
			(
				(and
					(or
						(and
							(or (== gForestRoomNum 132) (== gForestRoomNum 155))
							(== global124 0)
						)
						(and (== gForestRoomNum 34) (== global124 1))
						(and
							(or (== gForestRoomNum 53) (== gForestRoomNum 120))
							(== global124 2)
						)
						(and (== gForestRoomNum 66) (== global124 3))
						(and (== gForestRoomNum 20) (== global124 4))
						(and (== gForestRoomNum 114) (== global124 5))
						(and
							(or (== gForestRoomNum 22) (== gForestRoomNum 122))
							(== global124 6)
						)
						(and
							(or (== gForestRoomNum 88) (== gForestRoomNum 49))
							(== global124 7)
						)
						(and 1 (== global124 9))
					)
					(or
						(== gForestRoomNum 132)
						(== gForestRoomNum 155)
						(== gForestRoomNum 34)
						(== gForestRoomNum 53)
						(== gForestRoomNum 120)
						(== gForestRoomNum 66)
						(== gForestRoomNum 20)
						(== gForestRoomNum 114)
						(== gForestRoomNum 22)
						(== gForestRoomNum 122)
						(== gForestRoomNum 88)
						(== gForestRoomNum 49)
						(== gForestRoomNum 116)
						(== gForestRoomNum 117)
						(== gForestRoomNum 131)
						(== gForestRoomNum 133)
						(== gForestRoomNum 154)
						(== gForestRoomNum 18)
						(== gForestRoomNum 33)
						(== gForestRoomNum 35)
						(== gForestRoomNum 52)
						(== gForestRoomNum 54)
						(== gForestRoomNum 69)
						(== gForestRoomNum 119)
						(== gForestRoomNum 121)
						(== gForestRoomNum 135)
						(== gForestRoomNum 137)
						(== gForestRoomNum 51)
						(== gForestRoomNum 65)
						(== gForestRoomNum 82)
						(== gForestRoomNum 19)
						(== gForestRoomNum 21)
						(== gForestRoomNum 36)
						(== gForestRoomNum 98)
						(== gForestRoomNum 115)
						(== gForestRoomNum 130)
						(== gForestRoomNum 23)
						(== gForestRoomNum 37)
						(== gForestRoomNum 38)
						(== gForestRoomNum 106)
						(== gForestRoomNum 138)
						(== gForestRoomNum 50)
						(== gForestRoomNum 67)
						(== gForestRoomNum 68)
						(== gForestRoomNum 72)
						(== gForestRoomNum 83)
						(== gForestRoomNum 85)
						(== gForestRoomNum 86)
						(== gForestRoomNum 89)
						(== gForestRoomNum 99)
						(== gForestRoomNum 100)
						(== gForestRoomNum 101)
						(== gForestRoomNum 104)
						(== gForestRoomNum 136)
						(== gForestRoomNum 151)
						(== gForestRoomNum 153)
						(== gForestRoomNum 167)
					)
				)
				(gEgo setScript: (ScriptID 223 0)) ; englishTreeName
			)
			(
				(and
					(IsFlag 34)
					(not (IsFlag 35))
					(or
						(and
							(or (== gForestRoomNum 132) (== gForestRoomNum 155))
							(== global124 11)
						)
						(and (== gForestRoomNum 34) (== global124 12))
						(and
							(or (== gForestRoomNum 53) (== gForestRoomNum 120))
							(== global124 13)
						)
						(and (== gForestRoomNum 66) (== global124 14))
						(and (== gForestRoomNum 20) (== global124 15))
						(and (== gForestRoomNum 114) (== global124 16))
						(and
							(or (== gForestRoomNum 22) (== gForestRoomNum 122))
							(== global124 17)
						)
						(and
							(or (== gForestRoomNum 88) (== gForestRoomNum 49))
							(== global124 18)
						)
						(and
							(OneOf
								gForestRoomNum
								2
								3
								4
								5
								6
								7
								17
								24
								25
								26
								27
								32
								43
								48
								60
								64
								76
								81
								91
								97
								107
								113
								123
								129
								139
								146
								147
								148
								149
								156
								168
								169
								170
								171
								182
								183
							)
							(== global124 20)
						)
						(and (== gCurRoomNum 180) (== global124 18))
					)
					(or
						(== gForestRoomNum 132)
						(== gForestRoomNum 155)
						(== gForestRoomNum 34)
						(== gForestRoomNum 53)
						(== gForestRoomNum 120)
						(== gForestRoomNum 66)
						(== gForestRoomNum 20)
						(== gForestRoomNum 114)
						(== gForestRoomNum 22)
						(== gForestRoomNum 122)
						(== gForestRoomNum 88)
						(== gForestRoomNum 49)
						(== gForestRoomNum 116)
						(== gForestRoomNum 117)
						(== gForestRoomNum 131)
						(== gForestRoomNum 133)
						(== gForestRoomNum 154)
						(== gForestRoomNum 18)
						(== gForestRoomNum 33)
						(== gForestRoomNum 35)
						(== gForestRoomNum 52)
						(== gForestRoomNum 54)
						(== gForestRoomNum 69)
						(== gForestRoomNum 119)
						(== gForestRoomNum 121)
						(== gForestRoomNum 135)
						(== gForestRoomNum 137)
						(== gForestRoomNum 51)
						(== gForestRoomNum 65)
						(== gForestRoomNum 82)
						(== gForestRoomNum 19)
						(== gForestRoomNum 21)
						(== gForestRoomNum 36)
						(== gForestRoomNum 98)
						(== gForestRoomNum 115)
						(== gForestRoomNum 130)
						(== gForestRoomNum 23)
						(== gForestRoomNum 37)
						(== gForestRoomNum 38)
						(== gForestRoomNum 106)
						(== gForestRoomNum 138)
						(== gForestRoomNum 50)
						(== gForestRoomNum 67)
						(== gForestRoomNum 68)
						(== gForestRoomNum 72)
						(== gForestRoomNum 83)
						(== gForestRoomNum 85)
						(== gForestRoomNum 86)
						(== gForestRoomNum 89)
						(== gForestRoomNum 99)
						(== gForestRoomNum 100)
						(== gForestRoomNum 101)
						(== gForestRoomNum 104)
						(== gForestRoomNum 136)
						(== gForestRoomNum 151)
						(== gForestRoomNum 153)
						(== gForestRoomNum 167)
					)
				)
				(gEgo setScript: (ScriptID 223 2)) ; notBlessed
			)
			(
				(and
					(IsFlag 34)
					(IsFlag 35)
					(or
						(and
							(or (== gForestRoomNum 132) (== gForestRoomNum 155))
							(== global124 11)
						)
						(and (== gForestRoomNum 34) (== global124 12))
						(and
							(or (== gForestRoomNum 53) (== gForestRoomNum 120))
							(== global124 13)
						)
						(and (== gForestRoomNum 66) (== global124 14))
						(and (== gForestRoomNum 20) (== global124 15))
						(and (== gForestRoomNum 114) (== global124 16))
						(and
							(or (== gForestRoomNum 22) (== gForestRoomNum 122))
							(== global124 17)
						)
						(and
							(or (== gForestRoomNum 88) (== gForestRoomNum 49))
							(== global124 18)
						)
						(and
							(OneOf
								gForestRoomNum
								2
								3
								4
								5
								6
								7
								17
								24
								25
								26
								27
								32
								43
								48
								60
								64
								76
								81
								91
								97
								107
								113
								123
								129
								139
								146
								147
								148
								149
								156
								168
								169
								170
								171
								182
								183
							)
							(== global124 20)
						)
						(and (== gCurRoomNum 180) (== global124 18))
					)
					(< gForestSweepRoomCount 3)
					(not (IsFlag 129))
					(or
						(== gForestRoomNum 132)
						(== gForestRoomNum 155)
						(== gForestRoomNum 34)
						(== gForestRoomNum 53)
						(== gForestRoomNum 120)
						(== gForestRoomNum 66)
						(== gForestRoomNum 20)
						(== gForestRoomNum 114)
						(== gForestRoomNum 22)
						(== gForestRoomNum 122)
						(== gForestRoomNum 88)
						(== gForestRoomNum 49)
						(== gForestRoomNum 116)
						(== gForestRoomNum 117)
						(== gForestRoomNum 131)
						(== gForestRoomNum 133)
						(== gForestRoomNum 154)
						(== gForestRoomNum 18)
						(== gForestRoomNum 33)
						(== gForestRoomNum 35)
						(== gForestRoomNum 52)
						(== gForestRoomNum 54)
						(== gForestRoomNum 69)
						(== gForestRoomNum 119)
						(== gForestRoomNum 121)
						(== gForestRoomNum 135)
						(== gForestRoomNum 137)
						(== gForestRoomNum 51)
						(== gForestRoomNum 65)
						(== gForestRoomNum 82)
						(== gForestRoomNum 19)
						(== gForestRoomNum 21)
						(== gForestRoomNum 36)
						(== gForestRoomNum 98)
						(== gForestRoomNum 115)
						(== gForestRoomNum 130)
						(== gForestRoomNum 23)
						(== gForestRoomNum 37)
						(== gForestRoomNum 38)
						(== gForestRoomNum 106)
						(== gForestRoomNum 138)
						(== gForestRoomNum 50)
						(== gForestRoomNum 67)
						(== gForestRoomNum 68)
						(== gForestRoomNum 72)
						(== gForestRoomNum 83)
						(== gForestRoomNum 85)
						(== gForestRoomNum 86)
						(== gForestRoomNum 89)
						(== gForestRoomNum 99)
						(== gForestRoomNum 100)
						(== gForestRoomNum 101)
						(== gForestRoomNum 104)
						(== gForestRoomNum 136)
						(== gForestRoomNum 151)
						(== gForestRoomNum 153)
						(== gForestRoomNum 167)
					)
				)
				(gEgo setScript: (ScriptID 223 1)) ; notSweeping
			)
		)
	)
)

(instance forestBlown of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(and
				(== theVerb 4) ; Inventory
				(== invItem 1) ; horn
				(cond
					(
						(OneOf
							gForestRoomNum
							2
							3
							4
							5
							6
							7
							17
							24
							25
							26
							27
							32
							43
							48
							60
							64
							76
							81
							91
							97
							107
							113
							123
							129
							139
							146
							147
							148
							149
							156
							168
							169
							170
							171
							182
							183
						)
						(Say 1220 30 1) ; "I've found in the past that my men cannot hear my horn well from this part of the forest."
						1
					)
					(
						(or
							(and (== gDay 9) (IsFlag 36))
							(and (== gDay 12) (IsFlag 38))
						)
						(Say 1220 27 1) ; "I'd best not wind my horn now. There may still be Sheriff's men about."
						1
					)
					(else
						(gEgo setScript: (ScriptID 5 0)) ; blowArbitrator
						1
					)
				)
			)
		)
	)
)

(instance PT of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 6)
			)
			(1
				(cond
					((<= 1 gDay 3)
						(= ticks (Random 600 2100))
					)
					((<= 4 gDay 6)
						(= ticks (Random 1800 6000))
					)
					(else
						(= ticks (Random 60 900))
					)
				)
			)
			(2
				(if (and (not global201) (not global200))
					(forest setScript: (ScriptID 185 1)) ; runFerIt
				else
					(self dispose:)
				)
			)
		)
	)
)

