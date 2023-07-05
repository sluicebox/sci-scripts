;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 560)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Cibola)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use StopWalk)
(use DPath)
(use ScaleTo)
(use Grooper)
(use Sight)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm560 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm560 of Eco2Room
	(properties
		noun 7
		picture 560
		style 10
		west 530
	)

	(method (init)
		(gEgo
			init:
			normalize: (if (gCurrentRegionFlags test: 16) 0 else 531)
			setScale: Scaler 102 33 189 59
		)
		(if (== gPrevRoomNum 530)
			(= style 12)
		else
			(gEgo posn: 120 160)
		)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 84 70 85 70 89 48 100 30 101 17 96 0 96
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 144 0 112 46 125 46 130
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 18 154 105 148 105 159 83 167 36 167
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 88 96 88 105 66 105 66 96
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 75 93 75 83 81 76 106 77 106 93
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 115 91 136 91 136 97 115 97
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 95 101 119 101 119 110 95 110
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 238 67 238 82 154 91 109 84 109 80
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 224 116 253 116 253 123 224 123
					yourself:
				)
		)
		(if (gCurrentRegionFlags test: 21)
			(self
				addObstacle:
					(changePoly
						init: 0 57 0 0 319 0 319 189 1 189 0 187 165 187 182 186 196 181 191 174 194 169 225 162 201 155 195 149 187 152 168 142 152 146 132 137 127 130 157 123 212 123 238 145 269 134 271 121 303 104 285 98 260 98 244 92 269 83 292 83 283 79 297 71 307 67 304 61 290 62 290 56 222 56 199 57
						yourself:
					)
			)
		else
			(self
				addObstacle:
					(changePoly
						init: 0 57 0 0 319 0 319 189 1 189 0 187 165 187 180 171 201 155 195 149 187 152 168 142 152 146 132 137 127 130 157 123 212 123 238 145 269 134 271 121 303 104 285 98 260 98 244 92 269 83 292 83 283 79 297 71 310 65 307 62 290 62 290 56 222 56 199 57
						yourself:
					)
			)
		)
		(oilPump0 init: stopUpd: setScript: ((sMoveAtRandom new:) yourself:))
		(oilPump1 init: stopUpd: setScript: ((sMoveAtRandom new:) yourself:))
		(cond
			((not (gCurrentRegionFlags test: 16))
				(birdsBlue
					init:
					stopUpd:
					setScript: ((sMoveAtRandom new:) yourself:)
				)
			)
			((gCurrentRegionFlags test: 14)
				(paquita init:)
			)
		)
		(cage1 setLoop: (if (gCurrentRegionFlags test: 16) 4 else 3) addToPic:)
		(cage2 setLoop: (if (gCurrentRegionFlags test: 16) 4 else 3) addToPic:)
		(boxCages addToPic:)
		(if (and (not (gEgo has: 15)) (not (gCurrentRegionFlags test: 21)))
			(axe approachVerbs: 4 init: stopUpd:) ; Do
		)
		(if (gCurrentRegionFlags test: 21)
			(logCanoe
				x: (if (gCurrentRegionFlags test: 22) 235 else 197)
				y: (if (gCurrentRegionFlags test: 22) 175 else 164)
				view: 565
				loop: 3
				approachX: 200
				approachY: 189
				approachVerbs: (if (gCurrentRegionFlags test: 22) 4 else 0)
				setPri: (if (gCurrentRegionFlags test: 22) -1 else 15)
				noun: 13
				init:
				stopUpd:
			)
		else
			(logCanoe
				posn: 197 164
				view: 560
				loop: 2
				setPri: 15
				approachX: 172
				approachY: 178
				approachVerbs: 4 40 ; Do, metalAx
				noun: 4
			)
			(if (gCurrentRegionFlags test: 16)
				(logCanoe init: stopUpd:)
			else
				(logCanoe addToPic:)
			)
		)
		(veggie0 addToPic:)
		(veggie1 addToPic:)
		(chip0 addToPic:)
		(chip1 addToPic:)
		(veg1 addToPic:)
		(veg2 addToPic:)
		(veg3 addToPic:)
		(veg4 addToPic:)
		(veg5 addToPic:)
		(veg6 addToPic:)
		(pinkDead addToPic:)
		(grnDead addToPic:)
		(blueDead addToPic:)
		(shadow addToPic:)
		(bulldozer init: setOnMeCheck: 1 16)
		(birdcages init: setOnMeCheck: 1 2)
		(river init: setOnMeCheck: 1 64)
		(smoke init: setOnMeCheck: 1 128)
		(barrel1 init:)
		(barrel2 init:)
		(barrel3 init:)
		(barrel4 init:)
		(barrel5 init:)
		(crates init: setOnMeCheck: 1 8)
		(mud init: setOnMeCheck: 1 512)
		(island init:)
		(wood init: setOnMeCheck: 1 4)
		(garbage init: setOnMeCheck: 1 256)
		(exitwest init:)
		(exitwest2 init:)
		(exitwest3 init:)
		(gCurrentRegionFlags set: 10)
		(= local3
			(if (and (Cibola monitorOne:) (Cibola monitorTwo:))
				(Cibola monitorTwo:)
			else
				0
			)
		)
		(if (!= (gGameSound1 number:) 536)
			(gGameSound1 number: 536 loop: -1 play: 127)
		)
		(if (and (not (gCurrentRegionFlags test: 16)) (!= (gGameSound2 number:) 530))
			(gGameSound2 number: 530 loop: -1 play: 127)
		)
		(= local0 1)
		(if (not (gCurrentRegionFlags test: 16))
			(switch (Cibola monitorOne:)
				(1
					(self setScript: sReadingBook)
				)
				(2
					(self setScript: sPickVeggies)
				)
				(3
					(gonzales
						view: 561
						loop: 0
						setPri: 8
						posn: 22 131
						heading: 270
						init:
					)
					(self setScript: sChopVeggies)
				)
				(4
					(self setScript: sThrowVeggies)
				)
				(5
					(gonzales
						view: 567
						loop: 1
						posn: 108 156
						heading: 180
						init:
					)
					(self setScript: sChopWood)
				)
				(6
					(self setScript: sThrowWood)
				)
				(7
					(gonzales
						posn: 156 117
						view: 561
						loop: 2
						heading: 180
						init:
					)
					(self setScript: sCussAtBirds)
				)
				(else
					(gEgo posn: 29 89)
					(Cibola monitorOne: 1)
					(self setScript: sReadingBook)
				)
			)
		)
		(gGame handsOn:)
	)

	(method (doit)
		(super doit:)
		(if (and (> (gGame detailLevel:) 2) (not (IsFlag 5)))
			(Palette palANIMATE 72 77 10 78 83 10)
		)
		(cond
			(
				(or
					(gEgo inRect: -5 78 33 90)
					(gEgo inRect: 72 96 84 102)
					(gEgo inRect: 83 88 92 89)
					(gEgo inRect: 102 101 112 105)
					(gEgo inRect: 118 87 130 94)
					(gEgo inRect: 119 56 218 81)
					(gEgo inRect: 231 113 248 119)
				)
				(if (not local0)
					(= local0 1)
					(if (gEgo inRect: 231 113 248 114)
						(= local1 1)
					)
				)
			)
			(local0
				(= local0 0)
				(= local1 0)
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

(instance sGetAxe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(1
				(gEgo
					setSpeed: 6
					view: 5
					loop: 2
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(axe dispose:)
				(gEgo get: 15 setCycle: End self)
			)
			(3
				(gEgo normalize: 0 2)
				(gGame points: 5)
				(gMessager say: 12 4 0 0 self) ; "Adam picks up the sharp ax."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFlyFly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(birdsBlue2
					setSpeed: 2
					view: 105
					setLoop: 7
					scaleSignal: 1
					scaleX: 38
					scaleY: 38
					setCycle: Fwd
					posn: 269 -6
					setMotion: MoveTo 269 30 self
				)
			)
			(1
				(birdsBlue2 setMotion: MoveTo 269 -6 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sOpenCages of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(oilPump0 setScript: 0 stopUpd:)
				(oilPump1 setScript: 0 stopUpd:)
				(gEgo
					setSpeed: 0
					setStep: 5 5
					setMotion: PolyPath 191 161 self
				)
			)
			(1
				(gEgo view: 562 loop: 2 setSpeed: 6 setCycle: End self)
			)
			(2
				(gGame points: 5)
				(gEgo
					put: 13
					normalize: 531 6
					setSpeed: 0
					setStep: 5 5
					setMotion: PolyPath 242 118 self
				)
			)
			(3
				(gEgo normalize: 531 stopUpd:)
				(= cycles 2)
			)
			(4
				(squawk init: setScale: ScaleTo 385 100 self)
				(sLocalSnd2 number: 166 loop: 1 play: 127)
			)
			(5
				(= ticks 90)
			)
			(6
				(birdsBlue setScript: 0 view: 563 setLoop: 0 detailLevel: 0)
				(birdsBlue2 init:)
				(birdsBlue3 init:)
				(birdsBlue4 init:)
				(birdsBlue5 init:)
				(birdsBlue6 init:)
				(= cycles 5)
			)
			(7
				(squawk dispose:)
				(= cycles 2)
			)
			(8
				(gCast eachElementDo: #stopUpd)
				(= cycles 5)
			)
			(9
				(birdsBlue
					setSpeed: 0
					setPri: 14
					setCycle: Fwd
					setMotion: MoveTo 322 -10 self
				)
				(birdsBlue2 setCycle: Fwd setMotion: MoveTo 200 -10 self)
				(birdsBlue3 setCycle: Fwd setMotion: MoveTo -3 -10)
				(birdsBlue4 setCycle: Fwd setMotion: MoveTo 100 -10)
				(birdsBlue5 setCycle: Fwd setMotion: MoveTo 150 -10)
				(birdsBlue6 setCycle: Fwd setMotion: MoveTo 340 40)
			)
			(10 0)
			(11
				(gonzales
					view: 40
					loop: 0
					init:
					setCycle: StopWalk -1
					setSpeed: 0
					setMotion: PolyPath 40 140 self
				)
			)
			(12
				(gonzales
					setSpeed: 6
					view: 563
					setLoop: 6
					setCel: 0
					setCycle: CT 1 1 self
				)
			)
			(13
				(= ticks 5)
			)
			(14
				(gonzales setCycle: CT 0 -1 self)
			)
			(15
				(= ticks 10)
			)
			(16
				(gonzales setCycle: CT 3 1 self)
			)
			(17
				(= ticks 10)
			)
			(18
				(gonzales setCycle: End self)
			)
			(19
				(gonzales setCel: 0)
				(= cycles 2)
			)
			(20
				(gMessager say: 7 0 3 1 self) ; "GET BACK IN THERE!!! SLAUGHTER'S GONNA KILL ME!"
			)
			(21
				(birdsBlue
					setSpeed: 7
					posn: 210 -15
					setLoop: 8
					setCycle: Fwd
					setMotion: MoveTo 210 50 self
				)
				(if (== (Random 1 500) 255)
					(birdsBlue2 setScript: sFlyFly)
				)
			)
			(22
				(birdsBlue
					setScale: Scaler 100 40 50 0
					setMotion: MoveTo 210 -15
				)
				(gonzales
					setSpeed: 0
					setLoop: 7
					setCycle: Walk
					setScale: Scaler 100 50 120 70
					setMotion: MoveTo 264 74 self
				)
			)
			(23
				(gMessager say: 7 0 3 2 self) ; "Come back birdies, nice little birdies! Slaughter's gonna kill me!"
			)
			(24
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 888 9)
				(cage1 dispose:)
				(cage2 dispose:)
				(gonzales dispose:)
				(birdsBlue dispose:)
				(birdsBlue2 dispose:)
				(birdsBlue3 dispose:)
				(birdsBlue4 dispose:)
				(birdsBlue5 dispose:)
				(birdsBlue6 dispose:)
				(logCanoe dispose:)
				(= cycles 10)
			)
			(25
				(gCurRoom drawPic: (gCurRoom picture:) 9)
				(gCast eachElementDo: #show)
				(cage1 setLoop: 4 addToPic:)
				(cage2 setLoop: 4 addToPic:)
				(veggie0 addToPic:)
				(veggie1 addToPic:)
				(chip0 addToPic:)
				(chip1 addToPic:)
				(veg1 addToPic:)
				(veg2 addToPic:)
				(veg3 addToPic:)
				(veg4 addToPic:)
				(veg5 addToPic:)
				(veg6 addToPic:)
				(pinkDead addToPic:)
				(blueDead addToPic:)
				(grnDead addToPic:)
				(shadow addToPic:)
				(boxCages addToPic:)
				(logCanoe
					signal: 20480
					view: 560
					loop: 2
					posn: 197 164
					setPri: 15
					approachX: 172
					approachY: 178
					approachVerbs: 4 40 ; Do, metalAx
					noun: 4
					init:
					stopUpd:
				)
				(Cibola monitorOne: 0)
				(Cibola monitorTwo: 0)
				(gGameSound2 fade: 30 2 2 1)
				(gCurrentRegionFlags set: 16)
				(= cycles 10)
			)
			(26
				(UnLoad 128 563)
				(UnLoad 128 40)
				(oilPump0 setScript: (sMoveAtRandom new:))
				(oilPump1 setScript: (sMoveAtRandom new:))
				(gEgo normalize: 0)
				(= cycles 1)
			)
			(27
				(gMessager say: 7 0 12 0 self) ; "He'll be busy trying to catch those birds!"
			)
			(28
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThrowSeedRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setSpeed: 0
					setStep: 5 5
					setMotion: PolyPath 242 118 self
				)
			)
			(1
				(gEgo
					posn: 238 122
					view: 562
					loop: 1
					cel: 0
					setScale: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(2
				(gGame points: 10)
				(gEgo
					put: 14
					posn: 242 118
					normalize: 531 5
					setScale: Scaler 102 33 189 59
				)
				(gCurrentRegionFlags set: 20)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThrowSeedLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setSpeed: 0
					setStep: 5 5
					setMotion: PolyPath 143 147 self
				)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo
					view: 562
					loop: 3
					cel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(3
				(gGame points: 10)
				(gEgo put: 14 normalize: 531 0)
				(gCurrentRegionFlags set: 20)
				(gGame handsOn:)
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
				(= local0 1)
				(switch register
					(barrel5
						(= local1 1)
					)
					(birdcages
						(= local2 1)
					)
				)
				(gEgo normalize: 531)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRunHideCages of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setSpeed: 0
					setMotion:
						PolyPath
						(birdcages approachX:)
						(birdcages approachY:)
						self
				)
			)
			(1
				(squawk init: setScale: ScaleTo 385 100 self)
				(sLocalSnd2 number: 166 loop: 1 play: 127)
			)
			(2
				(= ticks 90)
			)
			(3
				(squawk dispose:)
				(= cycles 1)
			)
			(4
				(= local0 1)
				(gEgo normalize: 531)
				(gCurRoom setScript: sCatchAdam 0 1)
				(self dispose:)
			)
		)
	)
)

(instance sBirdyBirdy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 112 136 self)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(gMessager say: 2 2 1 0 self) ; "Hey, I'll try to get you out!"
			)
			(3
				(gEgo setMotion: PolyPath 135 153 self)
			)
			(4
				(gEgo setHeading: 90 self)
			)
			(5
				(gMessager say: 2 2 1 0 self) ; "Hey, I'll try to get you out!"
			)
			(6
				(gEgo setMotion: PolyPath 160 155 self)
			)
			(7
				(gEgo setHeading: 90 self)
			)
			(8
				(gMessager say: 2 2 1 0 self) ; "Hey, I'll try to get you out!"
			)
			(9
				(gEgo setMotion: PolyPath 191 161 self)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance sSquawkCatch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(squawk init: setScale: ScaleTo 385 100 self)
				(sLocalSnd2 number: 166 loop: 1 play: 127)
			)
			(1
				(= ticks 60)
			)
			(2
				(squawk dispose:)
				(= cycles 1)
			)
			(3
				(gCurRoom setScript: sCatchAdam 0 1)
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
				(gEgo setMotion: 0)
				(if (not (gCast contains: gonzales))
					(gonzales
						view: 40
						loop: 0
						init:
						setCycle: Walk
						setMotion: PolyPath 10 140 self
					)
				else
					(self cue:)
				)
			)
			(1
				(if register
					(gMessager say: 7 0 11 0 self) ; "Gotcha! Hey, those hungry birds are better than a burglar alarm!"
				else
					(gMessager say: 7 0 9 0 self) ; "FREEZE, YOU LITTLE MAGGOT!"
				)
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

(instance sMakeTheCanoe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(logCanoe setPri: 12)
				(gEgo
					view: 564
					loop: 0
					posn: 170 189
					setSpeed: 0
					setCycle: Fwd
				)
				(sLocalSnd number: 573 loop: -1 play: 127)
				(= seconds 3)
			)
			(1
				(logCanoe view: 564 loop: 2 startUpd: setCycle: CT 1 1 self)
			)
			(2
				(gEgo posn: 212 163 setPri: 15)
				(= seconds 3)
			)
			(3
				(logCanoe setCycle: CT 2 1 self)
			)
			(4
				(gEgo posn: 189 179 setPri: 15)
				(= seconds 3)
			)
			(5
				(logCanoe setCycle: CT 3 1 self)
			)
			(6
				(gEgo posn: 188 183)
				(= seconds 3)
			)
			(7
				(logCanoe setCycle: CT 4 1 self)
			)
			(8
				(gCurrentRegionFlags set: 21)
				(gGame points: 5)
				(sLocalSnd stop:)
				(gEgo put: 15 posn: 166 171 normalize: 0 0)
				(logCanoe
					view: 564
					setLoop: 3
					cel: 0
					approachVerbs: 0
					noun: 13
					setPri: 15
				)
				(= cycles 1)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sKickCanoe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 166 171 self)
			)
			(1
				(changePoly dispose:)
				(= cycles 1)
			)
			(2
				(gGame points: 5)
				(gCurrentRegionFlags set: 22)
				(gEgo
					setSpeed: 6
					view: 564
					loop: 1
					cel: 0
					posn: 197 164
					setCycle: CT 5 1 self
				)
			)
			(3
				(logCanoe
					view: 564
					setLoop: 3
					setPri: 15
					setCycle: CT 2 1 self
					setMotion: MoveTo 204 165 self
				)
				(gEgo setCycle: End self)
			)
			(4)
			(5)
			(6
				(logCanoe setCycle: End self)
			)
			(7
				(logCanoe cel: 0)
				(gEgo
					posn: 166 171
					normalize: 0 0
					setMotion: MoveTo 173 172 self
				)
			)
			(8
				(gEgo
					setSpeed: 6
					view: 564
					loop: 1
					cel: 0
					posn: 204 165
					setCycle: CT 5 1 self
				)
			)
			(9
				(logCanoe setCycle: Fwd setMotion: MoveTo 235 175 self)
				(gEgo setCycle: End self)
			)
			(10
				(gCurRoom
					addObstacle:
						(changePoly
							init: 0 57 0 0 319 0 319 189 1 189 0 187 165 187 182 186 196 181 191 174 194 169 225 162 201 155 195 149 187 152 168 142 152 146 132 137 127 130 157 123 212 123 238 145 269 134 271 121 303 104 285 98 260 98 244 92 269 83 292 83 283 79 297 71 307 67 304 61 290 62 290 56 222 56 199 57
							yourself:
						)
				)
				(gEgo posn: 173 172 normalize: 0 0)
				(logCanoe
					setPri: -1
					approachX: 200
					approachY: 189
					approachVerbs: 4 ; Do
					noun: 13
					setCycle: ForwardCounter 5 self
				)
			)
			(11
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterCanoe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(logCanoe dispose:)
				(gEgo
					view: 565
					setLoop: 0
					cel: 0
					setSpeed: 6
					setPri: 15
					posn: 235 175
					setCycle: End self
				)
				(gUser canControl: 0)
			)
			(1
				(if (not (gCurrentRegionFlags test: 24))
					(gEgo put: 19 put: 21 put: 11)
					(gCurrentRegionFlags set: 24)
					(gMessager say: 7 0 5 1 self) ; "Several things fall out of Adam's pocket and sink rapidly."
				else
					(= cycles 1)
				)
			)
			(2
				(gGame handsOn:)
				(gUser canControl: 0)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sPaddleAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(PalVary pvINIT 560 7)
				(if (not (gCast contains: paquita))
					(paquita
						init:
						setScript: 0
						setSpeed: 2
						setCycle: Fwd
						setMotion: MoveTo 178 174 self
					)
				else
					(paquita setMotion: MoveTo 178 174 self)
				)
			)
			(1
				(gGame points: 5)
				(gEgo
					view: 565
					setLoop: 2
					setSpeed: 6
					setCycle: Fwd
					setMotion: MoveTo 292 144 self
				)
				(paquita
					setSpeed: (+ (gEgo moveSpeed:) 3)
					setMotion: MoveTo 285 108
				)
			)
			(2
				(PalVary pvUNINIT)
				(gCurRoom drawPic: 888 10)
				(gCast eachElementDo: #hide)
				(= cycles 5)
			)
			(3
				(gCurRoom newRoom: 580)
			)
		)
	)
)

(instance sLeaveCanoe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gUser canControl: 1)
				(logCanoe
					posn: 235 175
					view: 565
					loop: 3
					approachX: 200
					approachY: 189
					approachVerbs: 4 ; Do
					noun: 13
					init:
				)
				(gEgo setSpeed: 6 setLoop: 1 cel: 0 setCycle: End self)
			)
			(1
				(gEgo posn: 200 189 normalize: 0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sVegChopping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 3)
			)
			(1
				(gonzales cel: 0)
				(= cycles 1)
			)
			(2
				(gonzales cel: 1)
				(sLocalSnd2 number: 563 loop: 1 play: 127 self)
			)
			(3
				(gonzales setCycle: End self)
			)
			(4
				(gonzales setScript: self)
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
					(gonzales
						posn: -15 156
						init:
						setLoop: Grooper
						setCycle: Walk
						setMotion: DPath 63 133 29 119 self
					)
					(Cibola monitorOne: 3)
				else
					(++ state)
					(self cue:)
				)
			)
			(1
				(gonzales setPri: 8 setMotion: MoveTo 17 128 self)
			)
			(2
				(gonzales
					posn: 16 107
					view: 561
					setPri: 9
					heading: 180
					loop: 0
					setScript: sVegChopping
				)
				((= register (View new:))
					view: 561
					loop: 1
					cel: 0
					posn: 17 128
					signal: 16384
					setPri: 8
					init:
				)
				(= seconds (if local3 local3 else 30))
				(= local3 (if local3 0))
			)
			(3
				(register dispose:)
				(gonzales
					setScript: 0
					posn: 17 128
					view: 40
					loop: 2
					setPri: 7
					heading: 180
				)
				(= cycles 1)
			)
			(4
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
						setLoop: Grooper
						setCycle: Walk
						setPri: -1
						setMotion: DPath 29 119 63 133 -15 156 self
					)
					(Cibola monitorOne: 4)
				else
					(self cue:)
				)
			)
			(1
				(gonzales dispose:)
				(= seconds (if local3 local3 else 15))
				(= local3 (if local3 0))
			)
			(2
				(gCurRoom setScript: sChopWood)
			)
		)
	)
)

(instance sChopSound of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 3)
			)
			(1
				(gonzales cel: 0)
				(sLocalSnd2 number: 572 loop: 1 play: 127 self)
				(stump setCel: 0 setCycle: End)
			)
			(2
				(gonzales setCycle: End self)
			)
			(3
				(gonzales setScript: self)
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
					(gonzales
						view: 40
						posn: -15 156
						init:
						setLoop: Grooper
						setCycle: Walk
						setMotion: PolyPath 108 156 self
					)
					(Cibola monitorOne: 5)
				else
					(self cue:)
				)
			)
			(1
				(gonzales view: 567 setLoop: 0 setCel: 0 setCycle: CT 1 1 self)
				(axe startUpd: hide:)
			)
			(2
				(gonzales setCycle: End self)
			)
			(3
				(stump init:)
				(gonzales
					view: 567
					loop: 1
					cel: (gonzales lastCel:)
					heading: 270
					setPri: -1
					setScript: sChopSound
				)
				(= seconds (if local3 local3 else 30))
				(= local3 (if local3 0))
			)
			(4
				(stump dispose:)
				(gonzales setScript: 0)
				(axe show: stopUpd:)
				(gonzales loop: 2 setCycle: End self)
			)
			(5
				(gCurRoom setScript: sThrowWood)
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
					(gonzales
						setLoop: 3
						setCycle: Walk
						setMotion: PolyPath -15 156 self
					)
					(Cibola monitorOne: 6)
				else
					(self cue:)
				)
			)
			(1
				(gonzales setLoop: -1 dispose:)
				(= seconds (if local3 local3 else 30))
				(= local3 (if local3 0))
			)
			(2
				(gCurRoom setScript: sCussAtBirds)
			)
		)
	)
)

(instance sCussAtBirds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(squawk init: setScale: ScaleTo 385 100 self)
				(sLocalSnd2 number: 166 loop: 1 play: 127)
			)
			(1
				(= ticks 60)
			)
			(2
				(squawk dispose:)
				(if (!= (Cibola monitorOne:) 7)
					(gonzales
						view: 40
						posn: -15 156
						init:
						setLoop: Grooper
						setCycle: Walk
						setMotion: PolyPath 156 117 self
					)
					(Cibola monitorOne: 7)
				else
					(self cue:)
				)
			)
			(3
				(gonzales view: 561 loop: 2 heading: 180 setCycle: RandCycle)
				(= cycles 2)
			)
			(4
				(gMessager say: 7 0 13 (Random 1 3) self)
			)
			(5
				(= seconds (if local3 local3 else 5))
				(= local3 (if local3 0))
			)
			(6
				(gonzales view: 40 loop: 2 heading: 180)
				(gCurRoom setScript: sReadingBook)
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
						posn: 156 117
						init:
						setLoop: Grooper
						setCycle: Walk
						setMotion: PolyPath -15 156 self
					)
					(Cibola monitorOne: 1)
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
				(= seconds (if local3 local3 else 30))
				(= local3 (if local3 0))
			)
			(3
				(gCurRoom setScript: sPickVeggies)
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
					(Cibola monitorOne: 2)
				)
				(= seconds (if local3 local3 else 15))
				(= local3 (if local3 0))
			)
			(1
				(gCurRoom setScript: sChopVeggies)
			)
		)
	)
)

(instance sMoveAtRandom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (client detailLevel:) (gGame detailLevel:))
					(client startUpd: setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(1
				(client setCel: 0)
				(= cycles 1)
			)
			(2
				(client stopUpd:)
				(= state -1)
				(= seconds (Random 15 20))
			)
		)
	)
)

(instance gonzales of Actor
	(properties
		x -15
		y 140
		noun 16
		view 40
		signal 16384
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not local0)
				(!= (gCurRoom script:) (ScriptID 9 0)) ; eRS
				(!= (gCurRoom script:) sCatchAdam)
				(not (CantBeSeen gEgo gonzales 45 85))
			)
			(gCurRoom setScript: sCatchAdam)
		)
	)
)

(instance paquita of Actor
	(properties
		x -20
		y 50
		noun 15
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

(instance logCanoe of Actor
	(properties
		view 564
		signal 20480
	)

	(method (doVerb theVerb)
		(cond
			((gCurrentRegionFlags test: 21)
				(if (== theVerb 4) ; Do
					(if (gCurrentRegionFlags test: 22)
						(if (== (gEgo view:) 565)
							(gMessager say: 3 4 0) ; "Adam could never last long enough to escape in the muddy water."
						else
							(gCurRoom setScript: sEnterCanoe)
						)
					else
						(gCurRoom setScript: sKickCanoe)
					)
				else
					(super doVerb: theVerb)
				)
			)
			((== theVerb 40) ; metalAx
				(gCurRoom setScript: sMakeTheCanoe)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance oilPump0 of Prop
	(properties
		x 262
		y 46
		noun 14
		view 566
		loop 2
		cycleSpeed 30
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 54))
			(super doVerb: theVerb)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 54))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance oilPump1 of Prop
	(properties
		x 25
		y 37
		noun 14
		view 566
		loop 3
		cycleSpeed 30
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 54))
			(super doVerb: theVerb)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 54))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance birdsBlue of Actor
	(properties
		x 205
		y 129
		noun 19
		view 566
		loop 5
		signal 28672
		cycleSpeed 24
		detailLevel 2
		illegalBits 0
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if (gCurrentRegionFlags test: 20)
				(birdcages doVerb: theVerb)
			else
				(gMessager say: 19 1 0) ; "The cage is full of birds. One of them looks like the parrot in Iquitos."
			)
		else
			(birdcages doVerb: theVerb)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 53))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
		(if
			(and
				(gEgo inRect: 190 139 236 162)
				(not (gCurrentRegionFlags test: 20))
				(not (OneOf (gCurRoom script:) sSquawkCatch sCatchAdam))
			)
			(gCurRoom setScript: sSquawkCatch)
		)
	)
)

(instance birdsBlue2 of Actor
	(properties
		x 205
		y 129
		noun 19
		view 563
		loop 2
		priority 15
		signal 30736
		cycleSpeed 2
		illegalBits 0
		moveSpeed 0
	)
)

(instance birdsBlue3 of Actor
	(properties
		x 205
		y 129
		noun 19
		view 563
		loop 1
		priority 15
		signal 30736
		cycleSpeed 2
		illegalBits 0
		moveSpeed 1
	)
)

(instance birdsBlue4 of Actor
	(properties
		x 205
		y 129
		noun 19
		view 563
		loop 3
		priority 15
		signal 30736
		cycleSpeed 2
		illegalBits 0
		moveSpeed 4
	)
)

(instance birdsBlue5 of Actor
	(properties
		x 205
		y 129
		noun 19
		view 563
		loop 5
		priority 15
		signal 30736
		cycleSpeed 2
		illegalBits 0
	)
)

(instance birdsBlue6 of Actor
	(properties
		x 205
		y 129
		noun 19
		view 563
		loop 4
		priority 15
		signal 30736
		cycleSpeed 2
		illegalBits 0
	)
)

(instance stump of Prop
	(properties
		x 58
		y 147
		view 567
		loop 4
		signal 16384
	)
)

(instance cage1 of View
	(properties
		x 176
		y 92
		noun 2
		view 560
		loop 3
		priority 9
		signal 16401
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
		(if (not (IsEcorderFlag 53))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 29 1 2) ; padlockKey, Look, Talk
			(gMessager say: 2 29 14 0) ; "The birds in that cage are dead. It would be useless to release them."
		else
			(birdcages doVerb: theVerb)
		)
	)
)

(instance cage2 of View
	(properties
		x 203
		y 127
		noun 2
		view 560
		loop 3
		cel 1
		priority 10
		signal 16401
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
		(if (not (IsEcorderFlag 53))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(birdcages doVerb: theVerb)
	)
)

(instance boxCages of View
	(properties
		x 136
		y 110
		noun 2
		view 560
		loop 3
		cel 2
		priority 9
		signal 16400
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
		(if (not (IsEcorderFlag 53))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 29 1 2) ; padlockKey, Look, Talk
			(gMessager say: 2 29 14) ; "The birds in that cage are dead. It would be useless to release them."
		else
			(birdcages doVerb: theVerb)
		)
	)
)

(instance axe of View
	(properties
		x 53
		y 147
		noun 12
		approachX 62
		approachY 150
		view 566
		priority 11
		signal 20497
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (gCurrentRegionFlags test: 16)
				(gEgo setScript: sGetAxe)
			else
				(gMessager say: 12 4 10 0) ; "Gonzales would notice that is missing."
				(gCurRoom setScript: sCatchAdam)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(<= (gEgo distanceTo: self) 5)
				(not (gCurrentRegionFlags test: 16))
				(!= (gCurRoom script:) sCatchAdam)
			)
			(gCurRoom setScript: sCatchAdam)
		)
	)
)

(instance veggie0 of View
	(properties
		x 57
		y 129
		noun 9
		view 560
		priority 1
		signal 20497
	)
)

(instance veggie1 of View
	(properties
		x 46
		y 124
		noun 9
		view 560
		cel 1
		priority 1
		signal 20497
	)
)

(instance chip0 of View
	(properties
		x 44
		y 136
		noun 9
		view 560
		cel 3
		priority 1
		signal 20497
	)
)

(instance chip1 of View
	(properties
		x 71
		y 131
		noun 9
		view 560
		cel 3
		priority 1
		signal 20497
	)
)

(instance veg1 of View
	(properties
		x 3
		y 111
		noun 9
		view 560
		priority 9
		signal 16400
	)
)

(instance veg2 of View
	(properties
		x 3
		y 115
		noun 9
		view 560
		cel 1
		priority 9
		signal 16400
	)
)

(instance veg3 of View
	(properties
		x 5
		y 120
		noun 9
		view 560
		cel 2
		priority 9
		signal 16400
	)
)

(instance veg4 of View
	(properties
		x 10
		y 116
		noun 9
		view 560
		cel 3
		priority 9
		signal 16400
	)
)

(instance veg5 of View
	(properties
		x 14
		y 119
		noun 9
		view 560
		priority 9
		signal 16400
	)
)

(instance veg6 of View
	(properties
		x 20
		y 116
		noun 9
		view 560
		cel 2
		priority 9
		signal 16400
	)
)

(instance squawk of Prop
	(properties
		x 205
		y 141
		view 562
		priority 15
		signal 24592
		scaleSignal 1
		scaleX 11
		scaleY 11
	)
)

(instance pinkDead of View
	(properties
		x 179
		y 113
		noun 2
		view 560
		loop 1
		cel 1
		signal 16384
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
		(if (not (IsEcorderFlag 53))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 29 1 2) ; padlockKey, Look, Talk
			(gMessager say: 2 29 14) ; "The birds in that cage are dead. It would be useless to release them."
		else
			(birdcages doVerb: theVerb)
		)
	)
)

(instance grnDead of View
	(properties
		x 182
		y 107
		z -30
		noun 2
		view 560
		loop 1
		cel 2
		signal 16384
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
		(if (not (IsEcorderFlag 53))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 29 1 2) ; padlockKey, Look, Talk
			(gMessager say: 2 29 14) ; "The birds in that cage are dead. It would be useless to release them."
		else
			(birdcages doVerb: theVerb)
		)
	)
)

(instance blueDead of View
	(properties
		x 147
		y 109
		z -20
		noun 2
		view 560
		loop 1
		signal 16384
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
		(if (OneOf theVerb 29 1 2) ; padlockKey, Look, Talk
			(gMessager say: 2 29 14) ; "The birds in that cage are dead. It would be useless to release them."
		else
			(birdcages doVerb: theVerb)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 53))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance shadow of View
	(properties
		y 170
		view 536
		loop 2
		cel 4
		priority 1
		signal 16400
	)
)

(instance bulldozer of Feature
	(properties
		x 178
		y 67
		noun 1
		onMeCheck 16
		approachX 137
		approachY 76
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not (gCurrentRegionFlags test: 16))
				(gEgo setScript: sRunHide 0 self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance birdcages of Feature
	(properties
		x 174
		y 80
		noun 2
		onMeCheck 2
		approachX 171
		approachY 123
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
		(if (not (IsEcorderFlag 53))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 53))
			(switch theVerb
				(4 ; Do
					(cond
						((gCurrentRegionFlags test: 16)
							(gMessager say: 2 4 3) ; "Adam can't help the dead birds."
						)
						((gCurrentRegionFlags test: 20)
							(gMessager say: 2 4 2) ; "The door to the cages are locked with padlocks."
						)
						(else
							(gEgo setScript: sRunHideCages)
						)
					)
				)
				(29 ; padlockKey
					(if (gCast contains: gonzales)
						(gCurRoom setScript: sCatchAdam)
					else
						(gCurRoom setScript: sOpenCages)
					)
				)
				(39 ; birdSeed
					(if (< (gEgo x:) 160)
						(gEgo setScript: sThrowSeedLeft)
					else
						(gEgo setScript: sThrowSeedRight)
					)
				)
				(1 ; Look
					(cond
						((gCurrentRegionFlags test: 16)
							(gMessager say: 2 1 3) ; "The cages stand empty. A few dead birds remain."
						)
						((gCurrentRegionFlags test: 20)
							(gMessager say: 2 1 2) ; "The birds are frantically devouring the birdseed as if it were their last meal."
						)
						(else
							(gMessager say: 2 1 1) ; "Hungry birds are jammed into dirty cages. Many will end up in pet shops far from home. More will die from the abuse."
						)
					)
				)
				(2 ; Talk
					(cond
						((gCurrentRegionFlags test: 16)
							(gMessager say: 2 2 3) ; "The dead birds can't answer."
						)
						((gCurrentRegionFlags test: 20)
							(gMessager say: 2 2 2) ; "The birds are eating hungrily. They're not interested in talking."
						)
						(else
							(gCurRoom setScript: sBirdyBirdy)
						)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance river of Feature
	(properties
		x 283
		y 171
		noun 3
		onMeCheck 64
		approachX 283
		approachY 171
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (gEgo view:) 565)
					(gMessager say: 3 4 5) ; "The water is choked with silt. Adam will need a better paddle than his hand."
				else
					(gMessager say: 3 4 0) ; "Adam could never last long enough to escape in the muddy water."
				)
			)
			(41 ; racquet
				(if (== (gEgo view:) 565)
					(gCurRoom setScript: sPaddleAway)
				else
					(gMessager say: 3 4 0) ; "Adam could never last long enough to escape in the muddy water."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance smoke of Feature
	(properties
		x 201
		y 8
		noun 18
		onMeCheck 128
	)
)

(instance barrel1 of Feature
	(properties
		x 124
		y 87
		noun 5
		nsTop 78
		nsLeft 117
		nsBottom 95
		nsRight 132
		approachX 123
		approachY 87
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not (gCurrentRegionFlags test: 16))
				(gEgo setScript: sRunHide 0 self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance barrel2 of Feature
	(properties
		x 107
		y 98
		noun 5
		nsTop 87
		nsLeft 99
		nsBottom 106
		nsRight 115
		approachX 108
		approachY 101
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not (gCurrentRegionFlags test: 16))
				(gEgo setScript: sRunHide 0 self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance barrel3 of Feature
	(properties
		x 79
		y 96
		noun 5
		nsTop 86
		nsLeft 71
		nsBottom 103
		nsRight 86
		approachX 80
		approachY 96
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not (gCurrentRegionFlags test: 16))
				(gEgo setScript: sRunHide 0 self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance barrel4 of Feature
	(properties
		x 54
		y 89
		noun 5
		nsTop 82
		nsLeft 44
		nsBottom 92
		nsRight 68
		approachX 62
		approachY 85
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not (gCurrentRegionFlags test: 16))
				(gEgo setScript: sRunHide 0 self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance barrel5 of Feature
	(properties
		x 239
		y 108
		noun 5
		nsTop 94
		nsLeft 227
		nsBottom 122
		nsRight 251
		approachX 242
		approachY 118
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not (gCurrentRegionFlags test: 16))
				(gEgo setScript: sRunHide 0 self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance crates of Feature
	(properties
		x 12
		y 78
		noun 6
		onMeCheck 8
		approachX 29
		approachY 89
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not (gCurrentRegionFlags test: 16))
				(gEgo setScript: sRunHide 0 self)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance mud of Feature
	(properties
		x 240
		y 97
		noun 8
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== (gEgo view:) 565)
				(gCurRoom setScript: sLeaveCanoe)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance island of Feature
	(properties
		x 18
		y 119
		noun 9
		nsTop 100
		nsBottom 139
		nsRight 37
		approachX 18
		approachY 119
	)
)

(instance wood of Feature
	(properties
		x 68
		y 146
		noun 10
		onMeCheck 4
		approachX 68
		approachY 156
	)
)

(instance garbage of Feature
	(properties
		x 49
		y 185
		noun 11
		onMeCheck 256
		approachX 68
		approachY 182
	)
)

(instance exitwest of ExitFeature
	(properties
		nsTop 137
		nsBottom 181
		nsRight 11
		cursor 12
		exitDir 4
	)
)

(instance exitwest3 of ExitFeature
	(properties
		nsTop 57
		nsBottom 84
		nsRight 11
		cursor 12
		exitDir 4
	)
)

(instance exitwest2 of ExitFeature
	(properties
		nsTop 96
		nsBottom 102
		nsRight 11
		cursor 12
		exitDir 4
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

