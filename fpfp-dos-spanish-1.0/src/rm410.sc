;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use eRS)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Timer)
(use RegionPath)
(use Motion)
(use Actor)
(use System)

(public
	rm410 0
)

(local
	local0
	[local1 13] = [32767 410 181 114 225 115 32767 410 225 115 181 114 -32768]
	[local14 19] = [32767 410 76 162 8 188 32767 410 8 188 84 189 32767 410 84 189 76 162 -32768]
	local33
)

(instance rm410 of FPRoom
	(properties
		noun 8
		picture 410
		south 400
	)

	(method (init)
		(LoadMany rsSCRIPT 984)
		(gEgo init: normalize: setScale: Scaler 64 67 187 108)
		(switch gPrevRoomNum
			(south
				(gEgo edgeHit: EDGE_BOTTOM x: 233)
				(gGame handsOn:)
			)
			(else
				(= style 100)
				(gEgo x: 200 y: 180)
				(gGame handsOn:)
			)
		)
		(super init:)
		(if (== gCurPuzzle 22)
			(gGameMusic1 number: 410 flags: 1 loop: -1 play:)
		else
			(gGameMusic1 fade: 127 25 10 0)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 59 98 123 114 124 146 87 161 87 184 209 184 209 189 0 189 0 0 319 0 319 189 269 189 260 151 266 138 253 138 237 149 213 137 230 122 198 117 186 126 155 128 130 117 129 110 69 93
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 217 144 219 154 165 182 122 176 122 161 171 138
					yourself:
				)
		)
		(anteroom init: setOnMeCheck: 1 2)
		(cabinet init: setOnMeCheck: 1 4)
		(candles init: setOnMeCheck: 1 8)
		(chair1 init: setOnMeCheck: 1 16)
		(chair2 init: setOnMeCheck: 1 16)
		(chandelier init: setOnMeCheck: 1 32)
		(clock init:)
		(table init: setOnMeCheck: 1 64)
		(couch init: setOnMeCheck: 1 128)
		(curtain1 init: setOnMeCheck: 1 256)
		(curtain2 init: setOnMeCheck: 1 256)
		(frameCurtain init: setOnMeCheck: 1 512)
		(frameRail init: setOnMeCheck: 1 1024)
		(lamp1 init: setOnMeCheck: 1 2048)
		(lamp2 init: setOnMeCheck: 1 2048)
		(lamp3 init: setOnMeCheck: 1 2048)
		(leftStatue init: setOnMeCheck: 1 4096)
		(painting init: setOnMeCheck: 1 16384)
		(rug init: setOnMeCheck: 1 8192)
		(teaSet init: setOnMeCheck: 1 4)
		(spittoon init: setOnMeCheck: 1 8)
		(stairs init: setOnMeCheck: 1 16)
		(statuettes init: setOnMeCheck: 1 32)
		(brothelWindow init: setOnMeCheck: 1 64)
		(wine init: setOnMeCheck: 1 128)
		(pendulum setCycle: Fwd init:)
		(if (== gCurPuzzle 15)
			(chastityTimer setReal: chastity 30)
			(madameTimer setReal: madameO 60)
			(virtuePath endType: (Random 0 2))
			(sheepPath endType: (Random 0 1))
			(sheep
				setCycle: Walk
				setMotion: sheepPath sheep
				init:
				setScale: Scaler 64 67 187 108
				approachVerbs: 4 2 ; Do, Talk
			)
			(purity
				init:
				setScale: Scaler 64 67 187 108
				stopUpd:
				approachVerbs: 4 2 ; Do, Talk
			)
			(virtue
				setCycle: StopWalk -1
				setMotion: virtuePath virtue
				init:
				setScale: Scaler 64 67 187 108
				approachVerbs: 4 2 ; Do, Talk
			)
			(chastity
				init:
				stopUpd:
				setScale: Scaler 64 67 187 108
				setPri: 10
				approachVerbs: 4 2 ; Do, Talk
			)
		)
		(if (not (IsFlag 107))
			(postcards init: setPri: 12 stopUpd: approachVerbs: 4 ignoreActors:) ; Do
		)
		(Animate (gCast elements:) 1)
		(proc0_15 0 16)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 1)
					(gMessager say: noun theVerb 1) ; "The room is a riot of plush red velvet. The girls are impatiently waiting for customers so that they can go upstairs and lie down awhile."
				else
					(gMessager say: noun theVerb 2) ; "The room is a riot of plush red velvet. The girls are upstairs, lying down."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(gEgo setHeading: 270)
	)

	(method (doit)
		(super doit:)
		(Palette palANIMATE 80 83 6)
		(Palette palANIMATE 86 94 4)
		(Palette palANIMATE 97 100 8)
	)

	(method (dispose)
		(LoadMany 0 984)
		(if (== gCurPuzzle 22)
			(gGameMusic1 fade: 0 30 12 1)
		else
			(gGameMusic1 fade: 100 25 10 0)
		)
		(if (== gNewRoomNum 400)
			(proc0_15 1 16)
		)
		(sheepTimer dispose: delete:)
		(virtueTimer dispose: delete:)
		(madameTimer dispose: delete:)
		(chastityTimer dispose: delete:)
		(super dispose:)
	)
)

(instance sKiss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 411)
				(Load rsSOUND 2950)
				(chastityTimer seconds: 2000)
				(madameTimer seconds: 2000)
				(gEgo setPri: 12 setMotion: MoveTo 251 138 self)
			)
			(1
				(Face gEgo chastity)
				(= cycles 2)
			)
			(2
				(= local33 (gEgo moveSpeed:))
				(chastity hide:)
				(gEgo
					view: 411
					loop: 0
					cel: 0
					x: 244
					y: 138
					setSpeed: 12
					setCycle: CT 5 1 self
				)
			)
			(3
				(gGameMusic2 number: 2950 flags: 1 loop: 1 play:)
				(gEgo setCycle: CT 10 1 self)
			)
			(4
				(= ticks 30)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(gEgo
					normalize:
					setPri: 12
					posn: 251 138
					loop: 1
					setSpeed: local33
					setMotion: MoveTo 254 153 self
				)
				(chastity posn: (chastity x:) (- (chastity y:) 5) show:)
			)
			(7
				(gEgo setPri: -1)
				(Face gEgo chastity)
				(= cycles 5)
			)
			(8
				(gMessager say: 31 0 0 0 self) ; "Wow, Chastity! You sure know how to kiss!"
			)
			(9
				(gGame handsOn:)
				(UnLoad 128 411)
				(UnLoad 132 2950)
				(chastity ignoreActors: 0)
				(self dispose:)
				(chastityTimer seconds: 1)
				(madameTimer seconds: 30)
				(= local0 1)
			)
		)
	)
)

(instance sSitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chastity
					view: 413
					setCel: 0
					setLoop: (chastity loop:)
					setCycle: End self
				)
				(= local0 1)
			)
			(1
				(chastity view: 410 setLoop: 3 setCel: 1 stopUpd:)
				(UnLoad 128 413)
				(self dispose:)
			)
		)
	)
)

(instance sMadameEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= gCurPuzzle 16)
				(= gAct 3)
				(ClearFlag 1)
				(proc0_9 26)
				(virtue setMotion: 0 view: 410 setLoop: 4 setCel: 0 stopUpd:)
				(UnLoad 128 823)
				(madameO
					init:
					stopUpd:
					setScale: -1 gEgo
					ignoreActors:
					setCycle: StopWalk -1
				)
				(if (and (< (gEgo x:) 150) (< (gEgo y:) 136))
					(gEgo setMotion: PolyPath 150 136 gCurRoom)
				)
				(= cycles 2)
			)
			(1
				(madameO setMotion: PolyPath 120 135 self)
			)
			(2
				(if (!= (gEgo cel:) 1)
					(Face gEgo madameO)
				)
				(= cycles 2)
			)
			(3
				(= cycles 3)
			)
			(4
				(gMessager say: 6 0 3 0 self) ; "Hey, big boy. It's about time you showed up. Shall we take that pharmacy bill out in trade?"
			)
			(5
				(Face madameO gEgo)
				(gEgo setMotion: PolyPath 139 130 self)
			)
			(6
				(Face gEgo madameO)
				(Load rsSOUND 2950)
				(= seconds 2)
			)
			(7
				(= local33 (gEgo moveSpeed:))
				(madameO hide:)
				(gEgo
					view: 411
					loop: 1
					cel: 0
					x: 133
					y: 130
					setSpeed: 12
					setCycle: CT 4 1 self
				)
			)
			(8
				(gGameMusic2 number: 2950 flags: 1 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(9
				(gEgo
					normalize:
					posn: 139 130
					setSpeed: local33
					ignoreActors:
					setMotion: PolyPath 76 99
				)
				(madameO show: setMotion: PolyPath 76 99 self)
			)
			(10
				(gCurRoom newRoom: 420)
				(self dispose:)
			)
		)
	)
)

(instance madameO of Actor
	(properties
		x 76
		y 99
		yStep 3
		view 803
		loop 2
		scaleSignal 4
		xStep 6
	)

	(method (cue)
		(gCurRoom setScript: sMadameEnters)
	)
)

(instance pendulum of Prop
	(properties
		x 257
		y 56
		noun 16
		view 410
		loop 1
		detailLevel 2
	)
)

(instance virtue of Actor
	(properties
		x 76
		y 162
		noun 5
		approachX 113
		approachY 167
		view 823
		scaleSignal 4
		cycleSpeed 15
		xStep 5
		moveSpeed 15
	)

	(method (cue)
		(virtueTimer setTicks: (Random 30 240) virtueTimer)
	)
)

(instance sheep of Actor
	(properties
		x 181
		y 114
		noun 7
		approachX 204
		approachY 127
		view 412
		scaleSignal 4
		cycleSpeed 15
		xStep 5
		moveSpeed 15
	)

	(method (cue)
		(sheepTimer setTicks: (Random 30 240) sheepTimer)
	)
)

(instance chastity of Actor
	(properties
		x 234
		y 140
		noun 3
		approachX 254
		approachY 153
		view 410
		loop 3
		signal 16384
		scaleSignal 4
		cycleSpeed 15
		xStep 5
		moveSpeed 15
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not local0)
					(self setScript: sKiss)
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
		(self setScript: sSitDown)
	)
)

(instance purity of Actor
	(properties
		x 271
		y 140
		noun 4
		approachX 257
		approachY 147
		view 410
		loop 2
		priority 9
		signal 16400
		scaleSignal 4
		cycleSpeed 15
		xStep 5
		moveSpeed 15
	)
)

(instance postcards of View
	(properties
		x 159
		y 153
		noun 29
		approachX 186
		approachY 178
		view 410
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo get: 45 self) ; Post_Cards
				(SetFlag 107)
				(gGame points: 1)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance anteroom of Feature
	(properties
		x 120
		y 89
		noun 30
		sightAngle 40
		approachX 120
		approachY 89
	)
)

(instance cabinet of Feature
	(properties
		x 296
		y 83
		noun 27
		sightAngle 40
		approachX 296
		approachY 83
	)
)

(instance candles of Feature
	(properties
		x 118
		y 81
		noun 25
		sightAngle 40
		approachX 118
		approachY 81
	)
)

(instance chair1 of Feature
	(properties
		x 164
		y 103
		noun 13
		sightAngle 40
		approachX 164
		approachY 103
	)
)

(instance chair2 of Feature
	(properties
		x 243
		y 112
		noun 13
		sightAngle 40
		approachX 243
		approachY 112
	)
)

(instance chandelier of Feature
	(properties
		x 168
		y 28
		noun 11
		sightAngle 40
		approachX 168
		approachY 28
	)
)

(instance clock of Feature
	(properties
		x 258
		y 59
		noun 16
		nsTop 39
		nsLeft 251
		nsBottom 80
		nsRight 265
		sightAngle 40
		approachX 258
		approachY 59
	)
)

(instance table of Feature
	(properties
		x 173
		y 150
		noun 22
		nsTop 135
		nsLeft 143
		nsBottom 166
		nsRight 203
		sightAngle 40
		approachX 173
		approachY 150
	)
)

(instance couch of Feature
	(properties
		x 78
		y 133
		noun 12
		sightAngle 40
		approachX 78
		approachY 133
	)
)

(instance curtain1 of Feature
	(properties
		x 101
		y 49
		noun 14
		sightAngle 40
		approachX 101
		approachY 49
	)
)

(instance curtain2 of Feature
	(properties
		x 206
		y 51
		noun 14
		sightAngle 40
		approachX 206
		approachY 51
	)
)

(instance frameCurtain of Feature
	(properties
		x 21
		y 94
		noun 9
		sightAngle 40
		approachX 21
		approachY 94
	)
)

(instance frameRail of Feature
	(properties
		x 105
		y 172
		noun 10
		sightAngle 40
		approachX 105
		approachY 172
	)
)

(instance lamp1 of Feature
	(properties
		x 100
		y 98
		noun 28
		sightAngle 40
		approachX 100
		approachY 98
	)
)

(instance lamp2 of Feature
	(properties
		x 236
		y 80
		noun 28
		sightAngle 40
		approachX 236
		approachY 80
	)
)

(instance lamp3 of Feature
	(properties
		x 308
		y 134
		noun 28
		sightAngle 40
		approachX 308
		approachY 134
	)
)

(instance leftStatue of Feature
	(properties
		x 76
		y 82
		noun 26
		sightAngle 40
		approachX 76
		approachY 82
	)
)

(instance painting of Feature
	(properties
		x 45
		y 87
		noun 24
		sightAngle 40
		approachX 45
		approachY 87
	)
)

(instance rug of Feature
	(properties
		x 184
		y 159
		noun 23
		sightAngle 40
		approachX 184
		approachY 159
	)
)

(instance teaSet of Feature
	(properties
		x 182
		y 135
		noun 15
		nsTop 121
		nsLeft 163
		nsBottom 148
		nsRight 192
		sightAngle 40
		approachX 182
		approachY 135
	)
)

(instance spittoon of Feature
	(properties
		x 262
		y 127
		noun 19
		nsTop 121
		nsLeft 256
		nsBottom 133
		nsRight 268
		sightAngle 40
		approachX 262
		approachY 127
	)
)

(instance stairs of Feature
	(properties
		x 300
		y 116
		noun 20
		nsTop 108
		nsLeft 281
		nsBottom 124
		nsRight 319
		sightAngle 40
		approachX 300
		approachY 116
	)
)

(instance statuettes of Feature
	(properties
		x 288
		y 92
		noun 17
		nsTop 78
		nsLeft 276
		nsBottom 107
		nsRight 300
		sightAngle 40
		approachX 288
		approachY 92
	)
)

(instance brothelWindow of Feature
	(properties
		x 207
		y 70
		noun 18
		sightAngle 40
		approachX 207
		approachY 70
	)
)

(instance wine of Feature
	(properties
		x 298
		y 152
		noun 21
		nsTop 138
		nsLeft 290
		nsBottom 167
		nsRight 306
		sightAngle 40
		approachX 298
		approachY 152
	)
)

(instance madameTimer of Timer
	(properties)
)

(instance chastityTimer of Timer
	(properties)
)

(instance virtueTimer of Timer
	(properties)

	(method (cue)
		(virtuePath endType: (Random 0 2))
		(virtue setMotion: virtuePath)
	)
)

(instance sheepTimer of Timer
	(properties)

	(method (cue)
		(sheepPath endType: (Random 0 1))
		(sheep setMotion: sheepPath)
	)
)

(instance sheepPath of RegionPath
	(properties
		theRegion 410
	)

	(method (at param1)
		(return [local1 param1])
	)
)

(instance virtuePath of RegionPath
	(properties
		theRegion 410
	)

	(method (at param1)
		(return [local14 param1])
	)
)

