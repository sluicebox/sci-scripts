;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Cibola)
(use Scaler)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use ScaleTo)
(use Grooper)
(use Sight)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm530 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(gCurRoom setScript: 0)
)

(procedure (localproc_1)
	(switch (Cibola monitorOne:)
		(1
			(gCurRoom setScript: sReadingBook)
		)
		(2
			(gCurRoom setScript: sPickVeggies)
		)
		(3
			(gCurRoom setScript: sChopVeggies)
		)
		(4
			(gCurRoom setScript: sThrowVeggies)
		)
		(5
			(gCurRoom setScript: sChopWood)
		)
		(6
			(gCurRoom setScript: sThrowWood)
		)
		(7
			(gCurRoom setScript: sCussAtBirds)
		)
	)
)

(instance rm530 of Eco2Room
	(properties
		noun 13
		picture 530
		style 10
		east 560
	)

	(method (init)
		(LoadMany rsVIEW 40 530 560 531 534)
		(if (not (gCurrentRegionFlags test: 16))
			(Load rsSOUND 530)
		)
		(gEgo
			init:
			normalize: (if (gCurrentRegionFlags test: 16) 0 else 531)
			loop: 8
			cel: 2
			setScale: Scaler 102 33 189 59
		)
		(if (== gPrevRoomNum 560)
			(= style 11)
		else
			(gGameSound1 fade:)
			(gGameSound2 fade:)
		)
		(super init:)
		(if (gCurrentRegionFlags test: 10)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 321 84 321 96 318 96 318 84
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 95 94 98 102 119 101 118 95 156 103 148 107 129 112 79 102
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 162 88 162 93 143 93 143 88
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 159 106 183 106 183 111 159 111
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 193 125 205 115 238 115 251 123 234 132 205 132
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 204 88 210 88 210 91 204 91
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 280 82 280 91 271 91 271 82
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 251 100 251 104 244 104 244 100
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 307 92 315 92 315 96 306 96
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 272 124 319 115 319 138 272 128
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 66 149 122 168 67 181 14 166
						yourself:
					)
					((Polygon new:)
						type: PContainedAccess
						init: 48 64 61 67 105 59 82 57
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 139 164 180 164 180 172 139 172
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 106 135 137 135 137 140 106 140
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 265 151 265 147 292 147 316 147 316 157 288 170 280 164 240 178 220 166 229 154 243 147
						yourself:
					)
					(changePoly
						init: 319 188 319 189 0 189 0 0 319 0 319 57 190 61 146 75 98 75 3 114 5 187
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 213 65 243 74 249 74 282 70 277 68 262 64 261 69 244 71 220 64
						yourself:
					)
			)
		)
		(if (gCurrentRegionFlags test: 14)
			(paquita init:)
		)
		(smoke setCycle: Fwd init:)
		(fire setCycle: Fwd init:)
		(waterWheel setCycle: Fwd init:)
		(steam setCycle: Fwd init:)
		(alarm setCycle: (if (gCurrentRegionFlags test: 15) 0 else Fwd) init:)
		(breakingRungs
			setCel:
				(if (and (not (gEgo has: 19)) (not (gCurrentRegionFlags test: 24)))
					0
				else
					(breakingRungs lastCel:)
				)
			init:
			stopUpd:
		)
		(socks setCycle: Fwd init:)
		(if (and (not (gEgo has: 19)) (not (gCurrentRegionFlags test: 24)))
			(crudVac init: stopUpd:)
		)
		(seedBag addToPic: approachVerbs: 4) ; Do
		(crates addToPic:)
		(basket addToPic:)
		(cookbook addToPic:)
		(shadow addToPic:)
		(hook
			setCel: (if (or (gEgo has: 19) (gCurrentRegionFlags test: 24)) 1 else 0)
			noun: (if (or (gEgo has: 19) (gCurrentRegionFlags test: 24)) 38 else 32)
			addToPic:
		)
		(clothesline addToPic:)
		(boxers addToPic:)
		(platform init: setOnMeCheck: 1 256)
		(dish init: setOnMeCheck: 1 4)
		(barrel1 init:)
		(barrel2 init:)
		(barrel3 init:)
		(barrel4 init:)
		(garden init: setOnMeCheck: 1 16384)
		(island init:)
		(machine init: setOnMeCheck: 1 8)
		(shack init: setOnMeCheck: 1 2)
		(stilt init: setOnMeCheck: 1 512)
		(rungs init: approachVerbs: 4 setOnMeCheck: 1 128) ; Do
		(refuse init: setOnMeCheck: 1 64)
		(bag init: approachVerbs: 4) ; Do
		(door init:)
		(mud init:)
		(river init: setOnMeCheck: 1 2048)
		(exiteast init:)
		(exiteast2 init:)
		(exiteast3 init:)
		(switch gPrevRoomNum
			(560
				(rope addToPic: approachVerbs: 4) ; Do
				(switch (Cibola monitorOne:)
					(1
						(gonzales
							view: 534
							loop: 0
							heading: 180
							posn: 292 147
							setPri: 15
							init:
						)
						(self setScript: sReadingBook)
					)
					(2
						(gonzales
							view: 534
							loop: 2
							heading: 225
							posn: 201 158
							setPri: -1
							init:
						)
						(self setScript: sPickVeggies)
					)
					(3
						(self setScript: sChopVeggies)
					)
					(4
						(gonzales
							view: 534
							loop: 4
							heading: 225
							posn: 241 118
							setPri: -1
							init:
						)
						(self setScript: sThrowVeggies)
					)
					(5
						(self setScript: sChopWood)
					)
					(6
						(gonzales
							view: 534
							loop: 3
							heading: 270
							posn: 239 120
							init:
						)
						(self setScript: sThrowWood)
					)
					(7
						(self setScript: sCussAtBirds)
					)
				)
			)
			(500
				(if (gCurrentRegionFlags test: 10)
					(rope addToPic: approachVerbs: 4) ; Do
					(gEgo
						posn: 262 86
						setCel: 2
						normalize: (if (gCurrentRegionFlags test: 16) 0 else 531) 2
					)
					(if (not (gCurrentRegionFlags test: 16))
						(if (gCurrentRegionFlags test: 19)
							(gonzales
								view: 534
								loop: 0
								heading: 180
								posn: 292 147
								setPri: 15
								init:
							)
							(Cibola monitorOne: 1)
							(gCurRoom setScript: sReadingBook)
						else
							(gonzales
								view: 40
								loop: 0
								heading: 90
								posn: 243 147
								init:
							)
							(gCurRoom setScript: sCountdown)
						)
					)
				else
					(if (gCurrentRegionFlags test: 9)
						(rope addToPic: approachVerbs: 4) ; Do
					)
					(gEgo normalize: 0 2 setPri: 5 posn: 264 70)
					(if (not (gCurrentRegionFlags test: 16))
						(gonzales view: 40 loop: 8 cel: 3 init: posn: 292 147)
						(self setScript: sCatchAdam)
					)
				)
			)
			(else
				(gEgo setPri: 15 posn: 264 70)
				(if (not (gCurrentRegionFlags test: 16))
					(gonzales view: 40 loop: 8 cel: 3 init: posn: 292 147)
					(self setScript: sCatchAdam)
				)
			)
		)
		(= local1
			(if (and (Cibola monitorOne:) (Cibola monitorTwo:))
				(Cibola monitorTwo:)
			else
				0
			)
		)
		(if (gCurrentRegionFlags test: 19)
			(gGameSound1 number: 536 loop: -1 play: 127)
		)
		(if (and (not (gCurrentRegionFlags test: 16)) (gCurrentRegionFlags test: 19))
			(gGameSound2 number: 530 loop: -1 play: 127)
		)
		(gGame handsOn:)
	)

	(method (doit)
		(super doit:)
		(if (and (> (gGame detailLevel:) 2) (not (IsFlag 5)))
			(Palette palANIMATE 72 77 10 78 83 10)
		)
		(if
			(and
				(not (gCurrentRegionFlags test: 10))
				(== (gEgo x:) 262)
				(== (gEgo y:) 64)
			)
			(gCurRoom newRoom: 500)
		)
		(cond
			(
				(or
					(gEgo inRect: 140 84 156 90)
					(gEgo inRect: 159 100 175 108)
					(gEgo inRect: 104 131 121 137)
					(gEgo inRect: 134 167 159 185)
					(gEgo inRect: 100 96 117 102)
				)
				(if (not local0)
					(= local0 1)
				)
			)
			(local0
				(= local0 0)
			)
		)
		(if
			(and
				(gEgo edgeHit:)
				(OneOf
					(gCurRoom script:)
					sChopVeggies
					sChopWood
					sReadingBook
					sPickVeggies
					sThrowWood
					sCussAtBirds
					sThrowVeggies
				)
			)
			(Cibola monitorTwo: ((gCurRoom script:) seconds:))
			(gCurRoom setScript: 0)
		)
	)

	(method (dispose)
		(DisposeScript 938)
		(DisposeScript 505)
		(sLocalSnd dispose:)
		(sLocalSnd2 dispose:)
		(super dispose:)
	)
)

(instance sFlyAroundCamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(paquita posn: 335 30 setMotion: MoveTo 156 50 self)
			)
			(1
				(-- state)
				(paquita
					setLoop: Grooper
					setMotion:
						DPath
						225
						40
						300
						30
						225
						20
						156
						10
						75
						20
						20
						30
						75
						40
						156
						50
						self
				)
			)
		)
	)
)

(instance sCountdown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(gCurRoom setScript: sGonzalesDances)
				(self dispose:)
			)
		)
	)
)

(instance sGonzalesDances of Script
	(properties)

	(method (cue &tmp temp0)
		(switch (= temp0 (gGameSound2 prevSignal:))
			(10
				(= state 1)
			)
			(5
				(= state 2)
			)
			(20
				(= state 4)
			)
			(15
				(= state 5)
			)
			(25
				(= state 6)
			)
			(30
				(= state 7)
			)
		)
		(gGameSound2 prevSignal: 0)
		(super cue: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGameSound2
					number: 545
					loop: 1
					flags: (& (gGameSound2 flags:) $fffe)
					play: self
				)
			)
			(1
				(gonzales
					view: 40
					loop: 0
					setLoop: Grooper
					setCycle: Walk
					setHeading: 270 self
				)
			)
			(2
				(gonzales
					view: 40
					loop: 0
					setCycle: Walk
					setLoop: Grooper
					setMotion: MoveTo 149 147
				)
			)
			(3
				(gonzales setCycle: 0 setMotion: 0 view: 535 loop: 0 cel: 2)
			)
			(4
				(gonzales
					view: 40
					loop: 1
					setLoop: Grooper
					setCycle: Walk
					setHeading: 90 self
				)
			)
			(5
				(gonzales
					view: 40
					loop: 1
					setCycle: Walk
					setLoop: Grooper
					setMotion: MoveTo 253 147
				)
			)
			(6
				(gonzales setCycle: 0 setMotion: 0 view: 535 loop: 0 cel: 1)
			)
			(7
				(gonzales setCycle: 0 setMotion: 0 view: 535 loop: 0 cel: 0)
			)
			(8
				(gGameSound1 number: 536 loop: -1 play: 127)
				(gonzales
					view: 40
					loop: 2
					setLoop: Grooper
					setCycle: Walk
					setMotion: MoveTo 292 147 self
				)
			)
			(9
				(gonzales setHeading: 180 self)
			)
			(10
				(gonzales
					view: 534
					loop: 0
					heading: 180
					posn: 292 147
					setPri: 15
				)
				(= cycles 1)
			)
			(11
				(gGameSound2
					number: 530
					loop: -1
					flags: (| (gGameSound2 flags:) $0001)
					play: 127
				)
				(Cibola monitorOne: 1)
				(gCurrentRegionFlags set: 19)
				(gGame handsOn:)
				(gCurRoom setScript: sReadingBook)
				(self dispose:)
			)
		)
	)
)

(instance sRunHide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setSpeed: 0
					setStep: 5 5
					setMotion:
						PolyPath
						(register approachX:)
						(register approachY:)
						self
				)
			)
			(1
				(gEgo normalize: 531 setHeading: 180 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetGrain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 154 173 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo view: 533 loop: 5 setSpeed: 6 setCycle: End self)
			)
			(3
				(gMessager say: 16 68 0 1 self) ; "The grain slides into the crudsucker."
			)
			(4
				(gGame points: 5)
				(gEgo normalize: 531 0)
				(gCurrentRegionFlags set: 18)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbRungs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCast contains: gonzales)
					(client setScript: sCatchAdam)
				else
					(changePoly dispose:)
					(localproc_0)
					(gEgo view: 0 loop: 8 cel: 6 setPri: 13 setScale: 0)
					(gCurrentRegionFlags set: 17)
					(= cycles 1)
				)
			)
			(1
				(gCurRoom
					addObstacle:
						(changePoly
							init: 319 188 319 189 0 189 0 98 319 14 319 57 190 61 146 75 98 75 3 114 5 187
							yourself:
						)
				)
				(gEgo
					view: 532
					setSpeed: 6
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo posn: 39 128 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo posn: 43 86 loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(gEgo
					posn: 48 69
					normalize: 0 6
					setPri: 15
					setMotion: MoveTo 58 67 self
				)
			)
			(5
				(gGame handsOn:)
				(if (not (gCurrentRegionFlags test: 15))
					(gEgo setScript: sAlarmWillSound)
				)
				(self dispose:)
			)
		)
	)
)

(instance sClimbDownRungs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 13 setMotion: MoveTo 48 69 self)
			)
			(1
				(changePoly dispose:)
				(gEgo
					view: 532
					setSpeed: 6
					loop: 2
					cel: (gEgo lastCel:)
					posn: 43 86
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					posn: 39 128
					loop: 1
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(3
				(gCurRoom
					addObstacle:
						(changePoly
							init: 319 188 319 189 0 189 0 0 319 0 319 57 190 61 146 75 98 75 3 114 5 187
							yourself:
						)
				)
				(gEgo
					posn: 39 179
					loop: 0
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(4
				(gEgo normalize: 0 6)
				(= cycles 1)
			)
			(5
				(gEgo normalize: 531 6 setScale: Scaler 102 33 189 59)
				(= cycles 1)
			)
			(6
				(gGame handsOn:)
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance sGetVacuum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 15 setMotion: PolyPath 80 64 self)
			)
			(1
				(gEgo get: 19 view: 5 loop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(crudVac dispose:)
				(gGame points: 5)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo normalize: 0 0 setPri: 15)
				(sLocalSnd number: 534 loop: 1 play: 127)
				(breakingRungs setCycle: End self)
			)
			(4
				(gEgo setHeading: 270 self)
			)
			(5
				(gMessager say: 14 1 10 1 self) ; "Oops! The rungs broke!"
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetSuspenders of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 15 setMotion: PolyPath 93 60 self)
			)
			(1
				(gEgo get: 20 view: 533 loop: 3 cel: 0 setCycle: End self)
			)
			(2
				(gGame points: 3)
				(gEgo setCycle: CT 5 -1 self)
			)
			(3
				(gMessager say: 31 4 15 1 self) ; "Adam promptly puts a pair of purple suspenders in his pocket."
			)
			(4
				(gEgo normalize: 0 3 setPri: 15)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHookAndJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setPri: 15 setMotion: PolyPath 75 65 self)
			)
			(1
				(gGame points: 5)
				(gEgo
					put: 20
					setSpeed: 6
					posn: 63 37
					view: 533
					loop: 4
					cel: 0
					setCycle: End self
				)
				(Load rsSOUND 540)
			)
			(2
				(gEgo
					view: 532
					loop: 3
					cel: 0
					setPri: 15
					setCycle: CT 8 1 self
				)
			)
			(3
				(sLocalSnd number: 540 loop: 1 play: 127)
				(gEgo setCycle: CT 12 1 self)
			)
			(4
				(gEgo setCycle: CT 10 -1 self)
			)
			(5
				(changePoly dispose:)
				(gEgo setCycle: End self)
				(hook dispose:)
			)
			(6
				(gCurRoom
					addObstacle:
						(changePoly
							init: 319 188 319 189 0 189 0 0 319 0 319 57 190 61 146 75 98 75 3 114 5 187
							yourself:
						)
				)
				(sLocalSnd number: 542 loop: 1 play: 127)
				(gEgo
					view: 0
					loop: 8
					cel: 4
					posn: 94 182
					normalize: (if (gCurrentRegionFlags test: 16) 0 else 531)
					setScale: Scaler 102 33 189 59
				)
				(hook signal: 20496 loop: 5 cel: 1 noun: 38 init:)
				(= cycles 1)
			)
			(7
				(hook stopUpd:)
				(gGame handsOn:)
				(localproc_1)
				(self dispose:)
			)
		)
	)
)

(instance sCycling of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= (gGame detailLevel:) (client detailLevel:))
					(client startUpd:)
					(++ state)
				)
				(= cycles 1)
			)
			(1
				(= state 0)
				(= cycles 1)
			)
			(2
				(= seconds (Random 3 5))
			)
			(3
				(client setCycle: End self)
			)
			(4
				(client setCel: 0 setCycle: Fwd stopUpd:)
				(= seconds (Random 10 15))
			)
			(5
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sTurnPages of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 5))
			)
			(1
				(sLocalSnd2 number: 532 loop: 1 play: 127)
				(client cel: 0 setCycle: End self)
			)
			(2
				(client setCel: 0 setScript: self)
			)
		)
	)
)

(instance sReadingBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (Cibola monitorOne:) 1)
					(gonzales
						view: 40
						posn: 329 156
						init:
						setLoop: Grooper
						setCycle: Walk
						setMotion: PolyPath 292 147 self
					)
					(Cibola monitorOne: 1)
				else
					(++ state)
					(self cue:)
				)
			)
			(1
				(gonzales setHeading: 180 self)
			)
			(2
				(gonzales
					view: 534
					loop: 0
					heading: 180
					setPri: 15
					setScript: sTurnPages
				)
				(= cycles 1)
			)
			(3
				(= seconds (if local1 local1 else 30))
				(= local1 (if local1 0))
			)
			(4
				(gonzales setScript: 0 setSpeed: 6)
				(gCurRoom setScript: sPickVeggies)
				(self dispose:)
			)
		)
	)
)

(instance sPickVeggies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (Cibola monitorOne:) 2)
					(gonzales
						view: 40
						setPri: -1
						setLoop: Grooper
						setCycle: Walk
						setMotion: PolyPath 201 158 self
					)
					(Cibola monitorOne: 2)
				else
					(++ state)
					(self cue:)
				)
			)
			(1
				(gonzales setHeading: 225 self)
			)
			(2
				(gonzales
					view: 534
					loop: 2
					heading: 225
					setPri: -1
					setCycle: Fwd
				)
				(= cycles 1)
			)
			(3
				(= seconds (if local1 local1 else 15))
				(= local1 (if local1 0))
			)
			(4
				(gonzales view: 40 loop: 5)
				(= cycles 1)
			)
			(5
				(= ticks 10)
			)
			(6
				(gCurRoom setScript: sChopVeggies)
				(self dispose:)
			)
		)
	)
)

(instance sChopVeggies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (Cibola monitorOne:) 3)
					(Cibola monitorOne: 3)
					(gonzales
						view: 40
						setLoop: Grooper
						setCycle: Walk
						setMotion: PolyPath 329 156 self
					)
				else
					(++ state)
					(self cue:)
				)
			)
			(1
				(gonzales dispose:)
				(= cycles 1)
			)
			(2
				(if (not (gCast contains: vegChip))
					(vegChip init:)
				)
				(= seconds (if local1 local1 else 30))
				(= local1 (if local1 0))
			)
			(3
				(vegChip dispose:)
				(gCurRoom setScript: sThrowVeggies)
			)
		)
	)
)

(instance sThrowVeggies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (Cibola monitorOne:) 4)
					(gonzales
						view: 40
						posn: 329 156
						init:
						setScale: Scaler 100 84 146 130
						setPri: -1
						setLoop: Grooper
						setCycle: Walk
						setMotion: PolyPath 241 118 self
					)
					(Cibola monitorOne: 4)
				else
					(++ state)
					(self cue:)
				)
			)
			(1
				(gonzales setHeading: 225 self)
			)
			(2
				(gonzales
					view: 534
					loop: 4
					setScale: 0
					heading: 225
					setPri: -1
					setCycle: Fwd
				)
				(= cycles 1)
			)
			(3
				(= seconds (if local1 local1 else 15))
				(= local1 (if local1 0))
			)
			(4
				(gonzales view: 40 setScale: Scaler 100 84 146 130 loop: 5)
				(= cycles 1)
			)
			(5
				(= ticks 10)
			)
			(6
				(gCurRoom setScript: sChopWood)
				(self dispose:)
			)
		)
	)
)

(instance sChopWood of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (Cibola monitorOne:) 5)
					(Cibola monitorOne: 5)
					(gonzales
						setScale: Scaler 100 80 146 130
						view: 40
						setLoop: Grooper
						setCycle: Walk
						setMotion: PolyPath 329 156 self
					)
				else
					(++ state)
					(self cue:)
				)
			)
			(1
				(gonzales dispose:)
				(= cycles 1)
			)
			(2
				(= seconds (if local1 local1 else 30))
				(= local1 (if local1 0))
			)
			(3
				(gCurRoom setScript: sThrowWood)
				(self dispose:)
			)
		)
	)
)

(instance sThrowWood of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (Cibola monitorOne:) 6)
					(Cibola monitorOne: 6)
					(gonzales
						view: 534
						posn: 329 156
						init:
						setLoop: 1
						setCycle: Walk
						setMotion: PolyPath 253 125 self
					)
				else
					(self cue:)
				)
			)
			(1
				(gonzales
					view: 534
					posn: 248 125
					heading: 270
					setLoop: -1
					loop: 3
					setScale: 0
					setCycle: End self
				)
			)
			(2
				(gonzales view: 534 setCycle: ROsc -1 6 9)
				(= cycles 1)
			)
			(3
				(= seconds (if local1 local1 else 30))
				(= local1 (if local1 0))
			)
			(4
				(gCurRoom setScript: sCussAtBirds)
				(self dispose:)
			)
		)
	)
)

(instance sCussAtBirds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(squawk init: setScale: ScaleTo 385 50 self)
				(sLocalSnd2 number: 166 loop: 1 play: 127)
			)
			(1
				(= seconds 3)
			)
			(2
				(squawk dispose:)
				(if (!= (Cibola monitorOne:) 7)
					(Cibola monitorOne: 7)
					(gonzales
						view: 40
						posn: 253 125
						setScale: Scaler 100 80 146 130
						setLoop: Grooper
						setCycle: Walk
						setMotion: PolyPath 329 156 self
					)
				else
					(++ state)
					(self cue:)
				)
			)
			(3
				(gonzales dispose:)
				(= cycles 1)
			)
			(4
				(= seconds (if local1 local1 else 5))
				(= local1 (if local1 0))
			)
			(5
				(gCurRoom setScript: sReadingBook)
				(self dispose:)
			)
		)
	)
)

(instance sTurnOffAlarm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 5)
				(alarm loop: 1 cel: 0 setCycle: 0)
				(= cycles 1)
			)
			(1
				(gMessager say: 27 4 9 1 self) ; "The alarm is disabled."
			)
			(2
				(gCurrentRegionFlags set: 15)
				(self dispose:)
			)
		)
	)
)

(instance sAlarmWillSound of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(alarm loop: 3 cel: 0)
				(= cycles 1)
			)
			(1
				(if (not (HaveMouse))
					(= seconds 15)
				else
					(= seconds 5)
				)
			)
			(2
				(if (and client (!= (gEgo script:) sTurnOffAlarm))
					(gGame handsOff:)
					(gGameSound2 stop:)
					(alarm loop: 2)
					(sLocalSnd number: 546 loop: -1 play: 127)
					(= cycles 1)
				)
			)
			(3
				(gMessager say: 13 0 16 0 self) ; "Oh no! The alarm!"
			)
			(4
				(if (not (gCurrentRegionFlags test: 16))
					(gCurRoom setScript: sCatchAdam)
				)
				(self dispose:)
			)
		)
	)
)

(instance sCatchAdam of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (gCast contains: gonzales))
					(if (gCast contains: vegChip)
						(vegChip dispose:)
					)
					(gonzales
						view: 40
						posn: 329 156
						setLoop: Grooper
						setCycle: Walk
						setSpeed: 2
						init:
						setMotion: PolyPath 275 162 self
					)
				else
					(= ticks 120)
				)
			)
			(1
				(gMessager say: 13 0 7 0 self) ; "HOLD IT, YOU LITTLE TERMITE!"
			)
			(2
				(gCurrentRegionFlags clear: 2)
				(gCurrentRegionFlags clear: 4)
				(gCurrentRegionFlags set: 23)
				(Cibola monitorOne: 0)
				(Cibola monitorTwo: 0)
				(gCurRoom newRoom: 501)
			)
		)
	)
)

(instance sEnterShackBedroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance gonzales of Actor
	(properties
		x 292
		y 149
		heading 180
		noun 19
		view 534
		loop 1
		signal 16384
		scaleSignal 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager
					say:
						19
						1
						(switch (Cibola monitorOne:)
							(1 11)
							(2 12)
							(4 14)
							(6 13)
						)
				)
			)
			(55 ; E-corder
				(if (and (== (self x:) 201) (== (self y:) 158))
					(if (not (self perform: gWriteEcorderData theVerb 52))
						(super doVerb: theVerb)
					)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(super init:)
		(self setScale: Scaler 100 80 146 130)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not local0)
				(not
					(OneOf
						(gCurRoom script:)
						sCatchAdam
						sCountdown
						sGonzalesDances
					)
				)
				(not (CantBeSeen gEgo gonzales 135))
			)
			(gCurRoom setScript: sCatchAdam)
		)
	)
)

(instance paquita of Actor
	(properties
		x 156
		y 50
		noun 37
		view 50
		loop 2
		cel 3
		priority 15
		signal 28688
		scaleSignal 5
		scaleX 93
		scaleY 93
		illegalBits 0
		moveSpeed 2
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd setScript: sFlyAroundCamp)
	)
)

(instance smoke of Prop
	(properties
		x 165
		y 47
		noun 10
		view 530
		loop 12
		cel 4
		signal 16384
		cycleSpeed 24
		detailLevel 2
	)

	(method (doit)
		(if (not (IsEcorderFlag 50))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 50))
			(super doVerb: theVerb)
		)
	)
)

(instance fire of Prop
	(properties
		x 229
		y 124
		noun 26
		view 530
		loop 9
		cel 6
		signal 16384
		cycleSpeed 10
		detailLevel 2
	)
)

(instance waterWheel of Prop
	(properties
		x 149
		y 53
		noun 10
		view 530
		loop 11
		signal 16384
		cycleSpeed 24
		detailLevel 2
	)

	(method (doit)
		(if (not (IsEcorderFlag 50))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 50))
			(super doVerb: theVerb)
		)
	)
)

(instance steam of Prop
	(properties
		x 219
		y 114
		noun 26
		view 530
		loop 8
		cel 2
		signal 16384
		cycleSpeed 12
		detailLevel 2
	)
)

(instance alarm of Prop
	(properties
		x 63
		y 42
		noun 27
		view 530
		loop 1
		priority 13
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (or (proc0_1 gEgo 256) (proc0_1 gEgo 2))
					(if (gCurrentRegionFlags test: 15)
						(gMessager say: 27 4 4 1 self) ; "There's no reason to arm the alarm."
					else
						(gEgo setScript: sTurnOffAlarm)
					)
				else
					(gMessager say: 3 4 1 1) ; "Adam can't reach that from here."
				)
			)
			(71 ; suspenders
				(hook doVerb: 71)
			)
			(1 ; Look
				(if (gCurrentRegionFlags test: 15)
					(gMessager say: 27 1 4) ; "The alarm is shut off."
				else
					(gMessager say: 27 1 3) ; "The alarm is armed!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance breakingRungs of Prop
	(properties
		x 34
		y 78
		noun 14
		view 530
		loop 4
		priority 12
		signal 16400
	)
)

(instance vegChip of Prop
	(properties
		x 322
		y 115
		view 530
		loop 7
		signal 16384
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance socks of Prop
	(properties
		x 14
		y 47
		noun 33
		view 530
		loop 5
		cel 9
		priority 10
		signal 16
		detailLevel 2
	)
)

(instance crudVac of View
	(properties
		x 86
		y 72
		z 20
		noun 34
		view 530
		loop 6
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (or (proc0_1 gEgo 256) (proc0_1 gEgo 2))
				(if (gCurrentRegionFlags test: 15)
					(gEgo setScript: sGetVacuum)
				else
					(gCurRoom setScript: sCatchAdam)
				)
			else
				(gMessager say: 3 4 1 1) ; "Adam can't reach that from here."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance rope of View
	(properties
		x 255
		y 80
		noun 17
		approachX 249
		approachY 94
		view 536
		loop 1
		signal 16385
		scaleSignal 1
		scaleX 72
		scaleY 72
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (and (not (proc0_1 gEgo 256)) (not (proc0_1 gEgo 2)))
				(gCurRoom setScript: sEnterShackBedroom)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance squawk of Prop
	(properties
		x 242
		y 109
		view 562
		priority 15
		signal 24592
		scaleSignal 1
		scaleX 11
		scaleY 11
	)
)

(instance seedBag of View
	(properties
		x 214
		y 152
		noun 16
		approachX 228
		approachY 186
		view 536
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurrentRegionFlags test: 16))
					(gCurRoom setScript: sCatchAdam)
				)
			)
			(68 ; dustBuster
				(if
					(and
						(not (proc0_1 gEgo 256))
						(not (proc0_1 gEgo 2))
						(not (gCurrentRegionFlags test: 18))
					)
					(gEgo setScript: sGetGrain)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance crates of View
	(properties
		x 266
		y 130
		noun 36
		approachX 284
		approachY 165
		view 536
		loop 2
		cel 1
		priority 11
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if
				(and
					(not (gCurrentRegionFlags test: 16))
					(not (proc0_1 gEgo 256))
					(not (proc0_1 gEgo 2))
				)
				(gEgo setScript: sRunHide 0 self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance basket of View
	(properties
		x 100
		y 36
		z -21
		noun 31
		view 536
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (or (proc0_1 gEgo 256) (proc0_1 gEgo 2))
				(if (gCurrentRegionFlags test: 15)
					(if (or (gEgo has: 19) (gCurrentRegionFlags test: 24))
						(if (gEgo has: 20)
							(gMessager say: 31 4 6 1) ; "Only old underwear is left in the basket."
						else
							(gEgo setScript: sGetSuspenders)
						)
					else
						(gMessager say: 31 4 5 1) ; "Adam doesn't want to trip over the thing in front of the basket."
					)
				else
					(gCurRoom setScript: sCatchAdam)
				)
			else
				(gMessager say: 3 4 1 1) ; "Adam can't reach that from here."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance shadow of View
	(properties
		x 313
		y 170
		noun 36
		view 536
		loop 2
		cel 2
		priority 1
		signal 16401
	)
)

(instance cookbook of View
	(properties
		x 284
		y 132
		noun 9
		view 536
		loop 2
		cel 3
		priority 11
		signal 16401
	)
)

(instance hook of View
	(properties
		x 63
		y 34
		noun 32
		view 536
		loop 5
		priority 14
		signal 20496
	)

	(method (doVerb theVerb)
		(if (== theVerb 71) ; suspenders
			(gEgo setScript: sHookAndJump)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance clothesline of View
	(properties
		x 65
		y 39
		noun 4
		view 536
		loop 3
		priority 10
		signal 20496
	)
)

(instance boxers of View
	(properties
		x 148
		y 52
		noun 35
		view 536
		loop 4
		priority 15
		signal 20496
	)
)

(instance platform of Feature
	(properties
		x 63
		y 64
		noun 2
		onMeCheck 256
		approachX 63
		approachY 64
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (or (proc0_1 gEgo 256) (proc0_1 gEgo 2))
				(gMessager say: 2 4 2 1) ; "The platform is rickety. It wouldn't be good to pull up any boards."
			else
				(gMessager say: 2 4 1 1) ; "Adam doesn't have wings."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance dish of Feature
	(properties
		x 53
		y 29
		noun 3
		onMeCheck 4
		approachX 53
		approachY 29
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (or (proc0_1 gEgo 256) (proc0_1 gEgo 2))
					(if (gCurrentRegionFlags test: 15)
						(gMessager say: 3 0 0 1) ; "That can't be moved."
					else
						(gCurRoom setScript: sCatchAdam)
					)
				else
					(gMessager say: 3 1 0 1) ; "A portable satellite dish is carefully aimed."
				)
			)
			(71 ; suspenders
				(hook doVerb: 71)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance barrel1 of Feature
	(properties
		x 152
		y 84
		noun 6
		nsTop 77
		nsLeft 145
		nsBottom 92
		nsRight 159
		approachX 141
		approachY 89
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if
				(and
					(not (gCurrentRegionFlags test: 16))
					(not (proc0_1 gEgo 256))
					(not (proc0_1 gEgo 2))
				)
				(gEgo setScript: sRunHide 0 self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance barrel2 of Feature
	(properties
		x 172
		y 100
		noun 6
		nsTop 91
		nsLeft 164
		nsBottom 110
		nsRight 180
		approachX 165
		approachY 104
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if
				(and
					(not (gCurrentRegionFlags test: 16))
					(not (proc0_1 gEgo 256))
					(not (proc0_1 gEgo 2))
				)
				(gEgo setScript: sRunHide 0 self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance barrel3 of Feature
	(properties
		x 122
		y 127
		noun 6
		nsTop 115
		nsLeft 112
		nsBottom 140
		nsRight 133
		approachX 107
		approachY 136
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if
				(and
					(not (gCurrentRegionFlags test: 16))
					(not (proc0_1 gEgo 256))
					(not (proc0_1 gEgo 2))
				)
				(gEgo setScript: sRunHide 0 self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance barrel4 of Feature
	(properties
		x 159
		y 156
		noun 6
		nsTop 140
		nsLeft 145
		nsBottom 172
		nsRight 174
		approachX 155
		approachY 180
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if
				(and
					(not (gCurrentRegionFlags test: 16))
					(not (proc0_1 gEgo 256))
					(not (proc0_1 gEgo 2))
				)
				(gEgo setScript: sRunHide 0 self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance garden of Feature
	(properties
		x 184
		y 130
		noun 7
		onMeCheck 16384
		approachX 196
		approachY 152
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 52))
			(super doVerb: theVerb)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 52))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance island of Feature
	(properties
		x 299
		y 118
		noun 8
		nsTop 102
		nsLeft 279
		nsBottom 134
		nsRight 319
		approachX 299
		approachY 118
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 50))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 50))
			(super doVerb: theVerb)
		)
	)
)

(instance machine of Feature
	(properties
		x 156
		y 50
		noun 10
		onMeCheck 8
		approachX 156
		approachY 54
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 50))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 50))
			(super doVerb: theVerb)
		)
	)
)

(instance shack of Feature
	(properties
		x 263
		y 36
		noun 11
		onMeCheck 2
		approachX 263
		approachY 36
	)
)

(instance stilt of Feature
	(properties
		x 279
		y 88
		noun 12
		onMeCheck 512
		approachX 279
		approachY 88
	)
)

(instance rungs of Feature
	(properties
		x 49
		y 131
		noun 14
		onMeCheck 128
		approachX 39
		approachY 179
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((or (proc0_1 gEgo 256) (proc0_1 gEgo 2))
						(if (or (gEgo has: 19) (gCurrentRegionFlags test: 24))
							(gMessager say: 14 4 6) ; "Adam can't get down that way."
						else
							(gEgo setScript: sClimbDownRungs)
						)
					)
					((or (gEgo has: 19) (gCurrentRegionFlags test: 24))
						(gMessager say: 14 1 6) ; "The rotten wood has split and the ladder is broken."
					)
					(else
						(gEgo setScript: sClimbRungs)
					)
				)
			)
			(1 ; Look
				(if (or (gEgo has: 19) (gCurrentRegionFlags test: 24))
					(gMessager say: 14 1 6) ; "The rotten wood has split and the ladder is broken."
				else
					(gMessager say: 14 1 0) ; "The rung ladder was repaired by Harry Homemaker, ie., Gonzales."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance refuse of Feature
	(properties
		x 116
		y 95
		noun 15
		onMeCheck 64
		approachX 102
		approachY 98
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 50))
			(if (== theVerb 4) ; Do
				(if
					(and
						(not (gCurrentRegionFlags test: 16))
						(not (proc0_1 gEgo 256))
						(not (proc0_1 gEgo 2))
					)
					(gEgo setScript: sRunHide 0 self)
				)
			else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 50))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance bag of Feature
	(properties
		x 139
		y 118
		noun 16
		nsTop 113
		nsLeft 129
		nsBottom 124
		nsRight 149
		approachX 145
		approachY 109
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 50))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 50))
			(super doVerb: theVerb)
		)
	)
)

(instance door of Feature
	(properties
		x 265
		y 62
		noun 18
		nsTop 53
		nsLeft 258
		nsBottom 71
		nsRight 273
		approachX 265
		approachY 62
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (gCurrentRegionFlags test: 10)
				(gMessager say: 18 4 1 1) ; "That's a little out of reach, isn't it?"
			else
				(gEgo setMotion: PolyPath 262 64)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance mud of Feature
	(properties
		x 287
		y 158
		noun 5
		nsTop 138
		nsLeft 255
		nsBottom 178
		nsRight 319
		approachX 287
		approachY 158
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 50))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 50))
			(super doVerb: theVerb)
		)
	)
)

(instance river of Feature
	(properties
		x 125
		y 57
		noun 21
		onMeCheck 2048
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 51))
			(super doVerb: theVerb)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 51))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance exiteast of ExitFeature
	(properties
		nsTop 137
		nsLeft 309
		nsBottom 181
		nsRight 319
		cursor 11
		exitDir 2
	)
)

(instance exiteast3 of ExitFeature
	(properties
		nsTop 57
		nsLeft 309
		nsBottom 84
		nsRight 319
		cursor 11
		exitDir 2
	)
)

(instance exiteast2 of ExitFeature
	(properties
		nsTop 96
		nsLeft 309
		nsBottom 102
		nsRight 319
		cursor 11
		exitDir 2
	)
)

(instance changePoly of Polygon
	(properties
		type PBarredAccess
	)

	(method (dispose)
		((gCurRoom obstacles:) delete: self)
		(super dispose:)
	)
)

(instance sLocalSnd of Sound
	(properties)
)

(instance sLocalSnd2 of Sound
	(properties)
)

