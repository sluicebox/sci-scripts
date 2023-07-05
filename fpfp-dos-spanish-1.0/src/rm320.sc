;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use Inset)
(use Scaler)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm320 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10 = 1
	local11
	[local12 40]
)

(instance rm320 of FPRoom
	(properties
		noun 11
		picture 320
		style 100
		south 260
		west 310
	)

	(method (init)
		(if (IsFlag 1)
			(= south 265)
		else
			(= south 260)
		)
		(gEgo init: setScale: Scaler 75 48 182 41 normalize:)
		(switch gPrevRoomNum
			(west
				(= style 12)
				(gGame handsOn:)
			)
			(south
				(gEgo x: 278)
				(if
					(and
						(== gPrevRoomNum 265)
						(or (== gCurPuzzle 14) (== gCurPuzzle 15))
					)
					(gCurRoom setScript: sEnterFromFire)
				else
					(gGame handsOn:)
				)
			)
			(640
				(gCurRoom setScript: sEnterFrom640)
			)
			(680
				(gGame handsOn:)
			)
			(else
				(gEgo x: 278 y: 175)
				(gGame handsOn:)
			)
		)
		(super init:)
		(gCurRoom
			addObstacle:
				(if (== gCurPuzzle 13)
					(= local1
						((Polygon new:)
							type: PBarredAccess
							init: 319 189 307 189 307 175 260 148 305 133 266 116 259 118 261 130 232 138 153 119 91 113 88 103 92 98 129 98 128 90 101 93 89 93 67 108 0 109 0 0 319 0
							yourself:
						)
					)
				else
					(= local1
						((Polygon new:)
							type: PBarredAccess
							init: 319 189 309 189 309 174 263 151 305 133 266 116 259 118 261 130 232 138 141 111 176 92 140 84 112 94 73 109 0 109 0 0 319 0
							yourself:
						)
					)
				)
				(= local3
					((Polygon new:)
						type: PBarredAccess
						init: 172 189 0 189 0 142 118 141 173 161
						yourself:
					)
				)
				(= local2
					((Polygon new:)
						type: PBarredAccess
						init: 180 189 180 159 243 159 279 189
						yourself:
					)
				)
		)
		(if (IsFlag 16)
			(lowerLadder init: approachVerbs: 4 3) ; Do, ???
		)
		(if (IsFlag 22)
			(rope init: stopUpd:)
		)
		(outhouseDoor init: approachVerbs: 4) ; Do
		(if (IsFlag 31)
			(shingle setCel: (shingle lastCel:) init: stopUpd:)
		else
			(shingle init: stopUpd:)
		)
		(waterTower init: approachVerbs: 36 setOnMeCheck: 1 8) ; Ladder
		(waterTowerTop approachVerbs: 36 init: setOnMeCheck: 1 4) ; Ladder
		(outhouse init: setOnMeCheck: 1 16)
		(topBuilding init: setOnMeCheck: 1 32)
		(bottomBuilding init: setOnMeCheck: 1 64)
		(eastBuilding init: setOnMeCheck: 1 128)
		(wagon init: setOnMeCheck: 1 256)
		(windMill init: setOnMeCheck: 1 512)
		(waterTowerRoof init: setOnMeCheck: 1 16384)
		(house1 init: setOnMeCheck: 1 -32768)
		(mine init: setOnMeCheck: 1 8192)
		(machines init: setOnMeCheck: 1 4096)
		(house2 init: setOnMeCheck: 1 1024)
		(pulley init: setOnMeCheck: 1 256)
		(towerTop init: setOnMeCheck: 26505)
		(shingle1 init: setOnMeCheck: 26505)
		(spigot setOnMeCheck: 26505 approachVerbs: 4 34 init:) ; Do, Empty_Bottles
		(waterDrop hide: setScript: sWaterDripping init:)
		(windMillBlades cel: global129 setCycle: Fwd init:)
		(gGameMusic2 number: 2325 flags: 1 loop: -1 play:)
		(cond
			((== gCurPuzzle 13)
				(gGameMusic1 number: 324 loop: -1 play:)
				(peopleInLine stopUpd: init:)
				(person1 stopUpd: init:)
				(person2 stopUpd: init:)
				(person3 stopUpd: init:)
				(if (not (IsFlag 86))
					(shingle setScript: sFirstTimeComtaminated)
				)
			)
			((IsFlag 1)
				(= local7 1)
			)
			(else
				(= local7 (Random 0 2))
			)
		)
		(gWalkHandler add: self)
		(if (IsFlag 52)
			(dummyCredits init: setScript: (ScriptID 32 0)) ; sOpeningCredits
		)
		(if (IsFlag 74)
			(gCurRoom setScript: sWaterSampleJoke)
		)
		(ClearFlag 94)
	)

	(method (handleEvent event &tmp [temp0 20])
		(if (& (event type:) evMOVE)
			(if (IsFlag 45)
				(gMessager say: 26 0 0) ; "You can't walk that way. It's too treacherous!"
				(event claimed: 1)
			else
				(return 0)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((proc0_1 gEgo 2)
				(gCurRoom setScript: sExitTo640)
			)
		)
	)

	(method (notify)
		(= local11 1)
		(gCurRoom setScript: sWaterSampleJoke)
	)

	(method (dispose)
		(if (!= gCurPuzzle 14)
			(gGameMusic1 fade: 0 30 12 1)
		)
		(if (and (!= gNewRoomNum 310) (!= gCurPuzzle 14))
			(gGameMusic2 fade:)
		)
		(= global129 (windMillBlades cel:))
		(gWalkHandler delete: lowerLadder)
		(gWalkHandler delete: highLadder)
		(gWalkHandler delete: self)
		(DisposeScript 32)
		(super dispose:)
	)
)

(instance sEnterFromFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
				(gEgo posn: 278 240)
			)
			(1
				(proc0_15 0 16)
				(gEgo setMotion: MoveTo 278 181 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFrom640 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 173 y: 200 setMotion: MoveTo 173 155 self)
			)
			(1
				(= cycles 3)
			)
			(2
				(if (IsFlag 1)
					(gMessager say: 25 0 10) ; "The back door to the Barbershop is currently locked."
				)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitTo640 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 191 225 self)
			)
			(1
				(if (IsFlag 1)
					(gCurRoom setScript: sEnterFrom640)
				else
					(gCurRoom newRoom: 640)
				)
			)
		)
	)
)

(instance sWaterDripping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCel: 0)
				(= seconds (Random 3 10))
			)
			(1
				(client show:)
				(client setCycle: End self cycleSpeed: 1)
				(if (== local10 1)
					(dripSound number: 2321 loop: 1 play:)
				)
			)
			(2
				(client hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance sLafferReading of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(= cycles 30)
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(client setLoop: 0 setCel: 0 setCycle: End self)
			)
			(5
				((ScriptID 1816 52) y: 85 textY: 50) ; Jim_Laffer
				(gMessager say: 18 0 1 0 self) ; "Pardon me, this stall is occupewed."
			)
			(6
				(client setCycle: Beg self)
			)
			(7
				(inLafferFrame dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sJudgeCrapping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(windMillBlades stopUpd:)
				(= cycles 10)
			)
			(1
				(switch local9
					(0
						(gMessager say: 44 0 19 0 self) ; "Excuse me VERY MUCH! I believe this stall is taken."
						(++ local9)
					)
					(1
						(gMessager say: 44 0 21 0 self) ; "Hey! Didn't we talk about this? You're really upsetting my concentration."
						(++ local9)
					)
					(2
						(gMessager say: 44 0 22 0 self) ; "Judge, I was just wondering..."
					)
				)
			)
			(2
				(windMillBlades startUpd:)
				(outhouseDoor doVerb: 4)
				(self dispose:)
			)
		)
	)
)

(instance sEnterOuthouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 117 84 self)
				(= local10 0)
			)
			(1
				(localSound number: 2147 loop: 1 play:)
				(outhouseDoor setCycle: Beg self)
			)
			(2
				(localSound number: 2946 loop: 1 play: self)
			)
			(3
				(gMessager say: 19 0 1 0 self) ; "Those damn kids! Don't they have anything better to do than hide joy buzzers under the outhouse seat?"
			)
			(4
				(localSound number: 2146 loop: 1 play:)
				(outhouseDoor setCycle: End self)
			)
			(5
				(gEgo setMotion: MoveTo 125 90 self)
			)
			(6
				(localSound number: 2147 loop: 1 play:)
				(outhouseDoor setCycle: Beg self)
			)
			(7
				(= local10 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPourSolution of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 (gEgo moveSpeed:))
				(gEgo setMotion: PolyPath 221 16 self)
			)
			(1
				(= local10 0)
				(gEgo
					view: 322
					loop: 3
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
				(localSound number: 2813 loop: -1 play:)
			)
			(2
				(gEgo setCycle: ROsc 3 2 6 self)
			)
			(3
				(localSound stop:)
				(gEgo put: 47) ; Pure_Solution
				(gCast eachElementDo: #dispose)
				(gCurRoom style: 10 drawPic: 780)
				(= seconds 2)
			)
			(4
				(gGame points: 10)
				(gMessager say: 5 39 5 0 self) ; "You carefully pour the purification solution into the town's water supply."
			)
			(5
				(gEgo cycleSpeed: local8 moveSpeed: local8)
				(= gCurPuzzle 14)
				(ClearFlag 20)
				(ClearFlag 21)
				(ClearFlag 45)
				(gTimers delete: (ScriptID 0 13)) ; deathTimer
				(gCurRoom newRoom: 630)
				(self dispose:)
			)
		)
	)
)

(instance sOpenHatch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local8 (gEgo moveSpeed:))
				(if (IsFlag 31)
					(gEgo
						view: 322
						loop: 2
						cel: 6
						cycleSpeed: 10
						setCycle: CT (gEgo lastCel:) 1 self
					)
				else
					(gEgo
						view: 322
						loop: 2
						cel: 0
						cycleSpeed: 10
						setCycle: CT 5 1 self
					)
				)
			)
			(1
				(if (IsFlag 31)
					(shingle setCycle: Beg)
					(gEgo setCycle: Beg self)
					(ClearFlag 31)
				else
					(shingle setCycle: End)
					(gEgo setCycle: End self)
					(SetFlag 31)
				)
				(localSound number: 2700 loop: 1 play:)
			)
			(2
				(shingle stopUpd:)
				(gEgo
					view: 322
					loop: 0
					cel: 0
					cycleSpeed: local8
					moveSpeed: local8
					setCycle: Walk
					setMotion: MoveTo (- (gEgo x:) 10) (gEgo y:) self
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sGottaGoPee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 7))
			)
			(1
				(client setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(= seconds (Random 2 5))
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(client stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance sWaterSampleJoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					(local11 0)
					((OneOf gPrevRoomNum 310 300)
						(gEgo x: 5 y: 131)
					)
					((IsFlag 74)
						(gEgo x: 300 y: 235)
					)
				)
				(= cycles 1)
			)
			(1
				(if (IsFlag 74)
					(proc0_15 0 5 self)
				else
					(= cycles 1)
				)
			)
			(2
				(cond
					((OneOf gPrevRoomNum 310 300)
						(= cycles 1)
					)
					((IsFlag 74)
						(gEgo setMotion: MoveTo 300 185 self)
					)
					(else
						(ClearFlag 74)
						(= cycles 1)
					)
				)
			)
			(3
				(gEgo setMotion: PolyPath 125 100 self)
			)
			(4
				(gEgo setHeading: 315)
				(windMillBlades stopUpd:)
				(= cycles 10)
			)
			(5
				(if (== gCurPuzzle 13)
					(gMessager say: 28 0 0 0 self) ; "|c2|"Hey, buddy, no cutting!"|c|"
				else
					(= cycles 1)
				)
			)
			(6
				(localSound number: 2146 loop: 1 play:)
				(outhouseDoor setCycle: End self)
			)
			(7
				(gEgo setMotion: MoveTo 117 84 self)
			)
			(8
				(gEgo setHeading: 135)
				(= cycles 10)
			)
			(9
				(localSound number: 2147 loop: 1 play:)
				(outhouseDoor setCycle: Beg self)
			)
			(10
				(if (== gCurPuzzle 13)
					(gMessager say: 27 0 0 0 self) ; "Well, howdy, Mr. Pharkas! Er...I wuz just leavin', I swear. Gimme one more minute."
				else
					(gMessager say: 43 0 0 0 self) ; "The water, obviously contaminated, has really "opened up the sluices." You spend a few minutes in extreme discomfort."
				)
			)
			(11
				(localSound number: 2146 loop: 1 play:)
				(outhouseDoor setCycle: End self)
			)
			(12
				(gEgo setMotion: MoveTo 125 100 self)
			)
			(13
				(gEgo setHeading: 315)
				(= cycles 10)
			)
			(14
				(localSound number: 2147 loop: 1 play:)
				(outhouseDoor setCycle: Beg self)
			)
			(15
				(gMessager say: 29 0 0 0 self) ; "A few moments later, you emerge feeling refreshed."
			)
			(16
				(gGame handsOn:)
				(windMillBlades startUpd:)
				(ClearFlag 74)
				(self dispose:)
			)
		)
	)
)

(instance sFirstTimeComtaminated of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= seconds 5)
			)
			(2
				(SetFlag 86)
				(gMessager say: 38 0 0) ; "Holy cow, you've never seen such a long line at the outhouse!"
				(self dispose:)
			)
		)
	)
)

(instance sRopeMiss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 (gEgo moveSpeed:))
				(= cycles 1)
			)
			(1
				(gEgo
					view: 321
					setHeading: 45
					loop: 0
					cel: 3
					scaleSignal: 0
					cycleSpeed: 9
					moveSpeed: 9
					setCycle: Fwd
				)
				(localSound number: 2148 loop: -1 play:)
				(= cycles 40)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(localSound number: 2149 loop: 1 play:)
				(gEgo setLoop: 2 setCycle: End self)
			)
			(4
				(gEgo
					view: 800
					loop: 3
					scaleSignal: 1
					cycleSpeed: local8
					moveSpeed: local8
					setMotion: 0
					setCycle: StopWalk -1
					setPri:
						(if (or (IsFlag 21) (IsFlag 20) (IsFlag 45))
							9
						else
							-1
						)
				)
				(= cycles 1)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRopeTowerTop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: 29) ; Lasso
				(= local8 (gEgo moveSpeed:))
				(= cycles 1)
			)
			(1
				(gEgo
					view: 321
					setHeading: 45
					setLoop: 0
					setCel: 3
					scaleSignal: 0
					cycleSpeed: 9
					moveSpeed: 9
					setCycle: Fwd
				)
				(localSound number: 2148 loop: -1 play:)
				(= cycles 40)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(localSound number: 2149 loop: 1 play:)
				(gEgo setLoop: 1 setCycle: End self)
			)
			(4
				(rope init: stopUpd:)
				(SetFlag 22)
				(gEgo
					view: 800
					loop: 3
					scaleSignal: 1
					cycleSpeed: local8
					moveSpeed: local8
					setMotion: 0
					setCycle: StopWalk -1
					setPri: 9
					put: 29 ; Lasso
				)
				(= cycles 5)
			)
			(5
				(gGame points: 5 138)
				(if (== gCurPuzzle 13)
					(gMessager say: 40 0 0) ; "Your snare the tower top! The crowd eats it up!"
				else
					(gMessager say: 40 0 17) ; "Hot dog, you roped the top of the water tower!"
				)
				(= cycles 1)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRopeClimbUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 (gEgo moveSpeed:))
				(gEgo
					view: 321
					loop: 5
					cel: 0
					x: 201
					y: 59
					scaleSignal: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(gEgo
					view: 322
					x: 214
					y: 24
					cycleSpeed: local8
					moveSpeed: local8
					setCycle: Walk
				)
				(= cycles 3)
			)
			(2
				(gEgo stopUpd:)
				(= cycles 3)
			)
			(3
				(ClearFlag 45)
				(SetFlag 21)
				(shingle approachVerbs: 4 39) ; Do, Pure_Solution
				(shingle1 approachVerbs: 4 39) ; Do, Pure_Solution
				(cond
					((and (not (IsFlag 96)) (== gCurPuzzle 13))
						(gMessager say: 39 0 0) ; "When you reach the top of the water tower, the crowd cheers!"
					)
					((not (IsFlag 96))
						(gMessager say: 39 0 17) ; "You reached the top."
					)
				)
				(= cycles 1)
			)
			(4
				(if (and (not (IsFlag 96)) (== gCurPuzzle 13))
					(Message msgGET 320 42 0 18 1 @local12) ; "Plug-O-Meter\05"
					(gNarrator name: @local12 showTitle: 1)
					(gMessager say: 42 0 0) ; "Boi-oi-oing! That one hit a 9.0 on the Free Plug-O-Meter!"
				)
				(= cycles 1)
			)
			(5
				(if (and (not (IsFlag 96)) (== gCurPuzzle 13))
					(SetFlag 96)
					(gNarrator showTitle: 0)
				)
				(= cycles 1)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRopeClimbDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 (gEgo moveSpeed:))
				(gEgo setMotion: MoveTo 214 24 self)
			)
			(1
				(gEgo
					view: 321
					loop: 5
					cel: (gEgo lastCel:)
					x: 201
					y: 59
					cycleSpeed: 12
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					view: 800
					loop: 3
					x: 201
					y: 59
					cycleSpeed: local8
					moveSpeed: local8
					scaleSignal: 1
					setCycle: StopWalk -1
				)
				(= cycles 1)
			)
			(3
				(ClearFlag 21)
				(SetFlag 45)
				(shingle approachVerbs: 0)
				(shingle1 approachVerbs: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUpLowerLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 (gEgo moveSpeed:))
				(gEgo setMotion: PolyPath 271 113 self)
			)
			(1
				(gEgo
					view: 321
					loop: 4
					cel: 0
					x: 271
					y: 113
					setScale: 0
					scaleSignal: 0
					setPri: 9
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 800
					loop: 7
					x: 235
					y: 72
					scaleSignal: 1
					scaleX: 80
					scaleY: 80
					cycleSpeed: local8
					moveSpeed: local8
					setPri: 9
					setCycle: StopWalk -1
				)
				(= cycles 1)
			)
			(3
				(SetFlag 20)
				(waterTower approachX: 240 approachY: 70)
				(lowerLadder approachX: 240 approachY: 70)
				(spigot approachVerbs: 0)
				(runningH2O approachVerbs: 0)
				(outhouseDoor approachVerbs: 0)
				((gCurRoom obstacles:) delete: local1)
				((gCurRoom obstacles:) delete: local2)
				((gCurRoom obstacles:) delete: local3)
				(local1 dispose:)
				(local2 dispose:)
				(local3 dispose:)
				(= cycles 1)
			)
			(4
				(gEgo setMotion: MoveTo 226 74 self)
			)
			(5
				(gEgo setHeading: 180 self)
			)
			(6
				(gCurRoom
					addObstacle:
						(= local4
							((Polygon new:)
								type: PContainedAccess
								init: 271 65 257 63 241 70 230 72 201 72 165 62 148 64 214 80
								yourself:
							)
						)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDownLowerLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 241 71 self)
			)
			(1
				(gEgo
					view: 321
					loop: 4
					cel: (gEgo lastCel:)
					x: 271
					y: 113
					scaleSignal: 0
					setPri: 9
					cycleSpeed: 12
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					view: 800
					x: 270
					y: 118
					cycleSpeed: local8
					moveSpeed: local8
					scaleSignal: 1
					setScale: Scaler 75 48 182 41
					setPri: -1
					setCycle: StopWalk -1
					setHeading: 180
				)
				(= cycles 2)
			)
			(3
				((gCurRoom obstacles:) delete: local4)
				(local4 dispose:)
				(gCurRoom
					addObstacle:
						(if (== gCurPuzzle 13)
							(= local1
								((Polygon new:)
									type: PBarredAccess
									init: 319 189 307 189 307 175 260 148 305 133 266 116 259 118 261 130 232 138 153 119 91 113 88 103 92 98 129 98 128 90 101 93 89 93 67 108 0 109 0 0 319 0
									yourself:
								)
							)
						else
							(= local1
								((Polygon new:)
									type: PBarredAccess
									init: 319 189 309 189 309 174 263 151 305 133 266 116 259 118 261 130 232 138 141 111 176 92 140 84 112 94 73 109 0 109 0 0 319 0
									yourself:
								)
							)
						)
						(= local3
							((Polygon new:)
								type: PBarredAccess
								init: 172 189 0 189 0 142 118 141 173 161
								yourself:
							)
						)
						(= local2
							((Polygon new:)
								type: PBarredAccess
								init: 180 189 180 159 243 159 279 189
								yourself:
							)
						)
				)
				(ClearFlag 20)
				(waterTower approachX: 270 approachY: 118)
				(lowerLadder approachX: 270 approachY: 118)
				(outhouseDoor approachVerbs: 4) ; Do
				(spigot approachVerbs: 4 34) ; Do, Empty_Bottles
				(runningH2O approachVerbs: 4 34) ; Do, Empty_Bottles
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetLowerLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 (gEgo moveSpeed:))
				(gEgo
					view: 321
					loop: 3
					cel: 0
					scaleSignal: 0
					cycleSpeed: 8
					setCycle: CT 4 1 self
				)
			)
			(1
				(lowerLadder dispose:)
				(= cycles 1)
			)
			(2
				(gEgo setCycle: CT (gEgo lastCel:) 1 self)
			)
			(3
				(gEgo
					view: 800
					loop: 2
					scaleSignal: 1
					scaleX: 80
					scaleY: 80
					cycleSpeed: local8
					setCycle: StopWalk -1
					setPri: 9
				)
				(= cycles 2)
			)
			(4
				(gEgo get: 28 lowerLadder setMotion: PolyPath 226 74 self) ; Ladder
			)
			(5
				(gEgo setHeading: 180 self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPutLowerLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 (gEgo moveSpeed:))
				(gEgo
					view: 321
					loop: 3
					cel: 9
					setScale: 0
					cycleSpeed: 8
					setCycle: CT 4 -1 self
				)
			)
			(1
				(lowerLadder approachVerbs: 4 3 init:) ; Do, ???
				(= cycles 1)
			)
			(2
				(gEgo setCycle: CT 0 -1 self)
			)
			(3
				(SetFlag 16)
				(gEgo
					view: 800
					loop: 2
					put: 28 ; Ladder
					scaleSignal: 1
					scaleX: 80
					scaleY: 80
					cycleSpeed: local8
					setPri: 9
					setCycle: StopWalk -1
					setMotion: PolyPath 226 74 self
				)
			)
			(4
				(gEgo setHeading: 180 self)
			)
			(5
				(gGame handsOn:)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance sUpHighLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 197 73 self)
			)
			(1
				(gEgo setMotion: MoveTo 201 59 self)
			)
			(2
				(SetFlag 45)
				(ClearFlag 20)
				(highLadder approachVerbs: 0)
				(waterTower approachVerbs: 0)
				(waterTowerTop approachVerbs: 0)
				((gCurRoom obstacles:) delete: local4)
				(local4 dispose:)
				(gCurRoom
					addObstacle:
						(= local5
							((Polygon new:)
								type: PContainedAccess
								init: 172 19 190 24 219 24 229 24 249 20 245 18 231 21 221 17 222 11 201 11
								yourself:
							)
						)
						(= local6
							((Polygon new:)
								type: PContainedAccess
								init: 196 62 205 62 205 55 196 55
								yourself:
							)
						)
				)
				(= cycles 3)
			)
			(3
				(if (not (IsFlag 100))
					(gMessager say: 14 0 20) ; "You remember your father's words of warning about never using the topmost rungs of a ladder, so you stop just short of the ladder top."
					(SetFlag 100)
				)
				(User controls: 0)
				(gEgo setMotion: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDownHighLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((gCurRoom obstacles:) delete: local6)
				(local6 dispose:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 201 59 self)
			)
			(2
				(gEgo setMotion: PolyPath 197 73 self)
			)
			(3
				((gCurRoom obstacles:) delete: local5)
				(local5 dispose:)
				(gCurRoom
					addObstacle:
						(= local4
							((Polygon new:)
								type: PContainedAccess
								init: 271 65 257 63 241 70 230 72 201 72 165 62 148 64 214 80
								yourself:
							)
						)
				)
				(ClearFlag 45)
				(SetFlag 20)
				(highLadder approachVerbs: 4) ; Do
				(waterTower approachVerbs: 36) ; Ladder
				(waterTowerTop approachVerbs: 36) ; Ladder
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance outhouseDoor of Prop
	(properties
		x 115
		y 86
		noun 4
		approachX 125
		approachY 100
		view 320
		priority 5
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((or (IsFlag 45) (IsFlag 20) (IsFlag 21))
						(gMessager say: noun 4 2) ; "You can't reach the outhouse from up here."
					)
					((== gCurPuzzle 13)
						(switch (Random 0 1)
							(0
								(gMessager say: 4 0 3 1) ; "It may be awhile. Seems like everyone's exercising those lower abdominals!"
							)
							(1
								(gMessager say: 4 0 3 2) ; "You'll have to wait your turn. Other people want to make their deposits first."
							)
						)
					)
					((== cel 0)
						(localSound number: 2146 loop: 1 play:)
						(self setCycle: End self)
						(SetFlag 24)
					)
					(else
						(localSound number: 2147 loop: 1 play:)
						(self setCycle: Beg self)
						(ClearFlag 24)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(super cue:)
		(self stopUpd:)
		(if (SetFlag 24)
			(switch local7
				(0
					(localSound number: 323 loop: -1 play:)
					(gCurRoom setInset: inLafferFrame)
				)
				(1
					(gEgo setScript: sEnterOuthouse)
				)
				(2
					(gEgo setScript: sJudgeCrapping)
				)
			)
		)
	)
)

(instance shingle1 of Feature
	(properties
		x 229
		y 17
		noun 5
		nsTop 9
		nsLeft 225
		nsBottom 20
		nsRight 240
		approachX 215
		approachY 19
	)

	(method (doVerb theVerb)
		(shingle doVerb: theVerb)
	)
)

(instance shingle of Prop
	(properties
		x 229
		y 17
		noun 5
		approachX 215
		approachY 19
		view 320
		loop 4
		priority 8
		signal 16401
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 21)
					(gEgo setScript: sOpenHatch)
				else
					(gMessager say: noun 4 2) ; "You can't reach that hatch from down here."
				)
			)
			(39 ; Pure_Solution
				(if (IsFlag 21)
					(if (== (shingle cel:) 0)
						(gMessager say: noun 39 6) ; "Maybe you should open the hatch first."
					else
						(gCurRoom setScript: sPourSolution)
					)
				else
					(gMessager say: noun 39 2) ; "You can't pour the purification solution into the tower from down here."
				)
			)
			(38 ; Lasso
				(gEgo setScript: sRopeMiss)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance jimLaffer of Prop
	(properties
		x 139
		y 71
		view 323
		loop 1
		priority 14
		signal 16
	)

	(method (init)
		(super init:)
		(self setScript: sLafferReading)
	)
)

(instance person1 of Prop
	(properties
		x 143
		y 93
		noun 21
		view 324
		loop 1
		signal 16384
		detailLevel 2
	)

	(method (init)
		(super init:)
		(if (> (gGame detailLevel:) 2)
			(self setScript: (sGottaGoPee new:))
		)
	)
)

(instance person2 of Prop
	(properties
		x 129
		y 108
		noun 22
		view 324
		loop 2
		signal 16384
		detailLevel 2
	)

	(method (init)
		(super init:)
		(if (> (gGame detailLevel:) 2)
			(self setScript: (sGottaGoPee new:))
		)
	)
)

(instance person3 of Prop
	(properties
		x 110
		y 109
		noun 23
		view 324
		loop 3
		signal 16384
		detailLevel 2
	)

	(method (init)
		(super init:)
		(if (> (gGame detailLevel:) 2)
			(self setScript: (sGottaGoPee new:))
		)
	)
)

(instance windMillBlades of Prop
	(properties
		x 2
		y 107
		z 100
		noun 12
		view 320
		loop 2
		priority 15
		signal 16
		detailLevel 2
	)
)

(instance waterDrop of Prop
	(properties
		x 172
		y 119
		view 320
		loop 1
		priority 8
		signal 16
	)
)

(instance runningH2O of Prop
	(properties
		x 172
		y 116
		z -10
		noun 37
		approachX 162
		approachY 118
		view 320
		loop 5
		priority 7
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(34 ; Empty_Bottles
				(cond
					((or (IsFlag 45) (IsFlag 20) (IsFlag 21))
						(gMessager say: 34 0 13) ; "You just can't do that while you're up here, where the air is thin and the walking uncertain."
					)
					((< gCurPuzzle 13)
						(gMessager say: noun 34 12) ; "You don't need any water at the moment."
					)
					((and (IsFlag 94) (== gCurPuzzle 13))
						(gEgo put: 18) ; Empty_Bottles
						(gEgo get: -1 57 1) ; Tower_H20
						(gGame points: 1 135)
						(gMessager say: noun 34 0) ; "You fill one of the empty beer bottles with water from the water tower."
					)
					((== gCurPuzzle 13)
						(gMessager say: noun 34 16) ; MISSING MESSAGE
					)
					(else
						(gMessager say: noun 34 11) ; "You don't need any water right now!"
					)
				)
			)
			(4 ; Do
				(if (or (IsFlag 45) (IsFlag 20) (IsFlag 21))
					(gMessager say: 34 0 13) ; "You just can't do that while you're up here, where the air is thin and the walking uncertain."
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
		(if (IsFlag 94)
			(waterDrop dispose:)
			(dripSound number: 2947 loop: -1 play:)
			(runningH2O init: approachVerbs: 4 9 setCycle: Fwd) ; Do, Door_Key
		else
			(waterDrop init: hide: setScript: sWaterDripping)
			(dripSound stop:)
			(ClearFlag 94)
			(self setScript: 0 dispose:)
		)
	)
)

(instance dummyCredits of Prop
	(properties
		x -10
		y -10
		view 996
	)
)

(instance lowerLadder of View
	(properties
		x 258
		y 97
		noun 15
		approachX 270
		approachY 118
		view 320
		loop 3
		cel 1
		priority 8
		signal 16401
	)

	(method (doit &tmp temp0 [temp1 21])
		(= temp0 ((gUser curEvent:) new:))
		(temp0 localize:)
		(cond
			((or (gEgo script:) (gCurRoom script:)))
			(
				(and
					(gEgo inRect: 237 55 257 80)
					(== (temp0 type:) 4)
					(OneOf (temp0 message:) 20736 19712)
				)
				(gEgo setScript: sDownLowerLadder)
			)
			(
				(and
					(gEgo inRect: 256 112 277 119)
					(== (temp0 type:) 4)
					(not (IsFlag 20))
					(OneOf (temp0 message:) 18176 18432)
				)
				(gEgo setScript: sUpLowerLadder)
			)
		)
		(temp0 dispose:)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; ???
				(if (IsFlag 20)
					(gEgo setScript: sDownLowerLadder)
				else
					(gEgo setScript: sUpLowerLadder)
				)
			)
			(4 ; Do
				(if (IsFlag 20)
					(gEgo setScript: sGetLowerLadder)
				else
					(gEgo get: 28 lowerLadder 2 self) ; Ladder
					(ClearFlag 16)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(super init:)
		(gWalkHandler add: lowerLadder)
	)
)

(instance highLadder of View
	(properties
		x 201
		y 57
		noun 14
		approachX 197
		approachY 73
		view 320
		loop 3
		priority 8
		signal 16401
	)

	(method (doit &tmp temp0 [temp1 21])
		(= temp0 ((gUser curEvent:) new:))
		(temp0 localize:)
		(cond
			((or (gEgo script:) (gCurRoom script:)))
			(
				(and
					(gEgo inRect: 192 67 210 79)
					(not (IsFlag 45))
					(== (temp0 type:) 4)
					(OneOf (temp0 message:) 18432 18688)
				)
				(Printf {sUpHighLadder in highLadder doit:})
				(gEgo setScript: sUpHighLadder)
			)
			(
				(and
					(IsFlag 45)
					(== (temp0 type:) 4)
					(OneOf (temp0 message:) 20480 20224)
				)
				(Printf {sDownHighLadder in doit:})
				(gEgo setScript: sDownHighLadder)
			)
		)
		(temp0 dispose:)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; ???
				(if (not (IsFlag 21))
					(if (IsFlag 45)
						(ClearFlag 45)
						(gEgo setScript: sDownHighLadder)
					else
						(gEgo setScript: sUpHighLadder)
					)
				else
					(gMessager say: noun theVerb 0) ; "You'll have to climb back down the rope first."
				)
			)
			(4 ; Do
				(if (not (IsFlag 21))
					(if (IsFlag 45)
						(gMessager say: noun theVerb 9) ; "You can't seem to pick it up. It seems much heavier now, for some strange reason!"
					else
						(gEgo get: 28 lowerLadder) ; Ladder
						(highLadder dispose:)
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
		(gWalkHandler addToFront: highLadder)
		(super init:)
	)
)

(instance rope of View
	(properties
		x 209
		y 4
		noun 24
		view 321
		loop 6
		priority 8
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 21)
						(gEgo setScript: sRopeClimbDown)
					)
					((IsFlag 45)
						(gEgo setScript: sRopeClimbUp)
					)
					(else
						(gMessager say: noun theVerb 2) ; "You can't reach the rope from here!"
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance peopleInLine of View
	(properties
		x 132
		y 59
		noun 17
		view 324
		signal 16384
	)
)

(instance waterTower of Feature
	(properties
		x 222
		y 89
		noun 2
		approachX 270
		approachY 118
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36 ; Ladder
				(if (IsFlag 20)
					(gEgo setScript: sPutLowerLadder)
				else
					(lowerLadder approachVerbs: 4 3 init:) ; Do, ???
					(gEgo put: 28) ; Ladder
					(gGame points: 2 136)
					(SetFlag 16)
				)
			)
			(38 ; Lasso
				(if (IsFlag 45)
					(gMessager say: noun theVerb 9) ; "The lasso won't reach from down here."
				else
					(gEgo setScript: sRopeMiss)
				)
			)
			(4 ; Do
				(cond
					((and (IsFlag 20) (gCast contains: lowerLadder))
						(gEgo setScript: sDownLowerLadder)
					)
					((and (not (IsFlag 20)) (gCast contains: lowerLadder))
						(gEgo setScript: sUpLowerLadder)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance waterTowerTop of Feature
	(properties
		x 229
		y 41
		noun 1
		approachX 197
		approachY 73
	)

	(method (doVerb theVerb)
		(switch theVerb
			(36 ; Ladder
				(if (IsFlag 20)
					(highLadder approachVerbs: 4 init:) ; Do
					(gGame points: 4 137)
					(gEgo put: 28) ; Ladder
					(gTheIconBar disable: 5)
				else
					(gMessager say: noun theVerb 2) ; "The ladder doesn't quite reach far enough."
				)
			)
			(38 ; Lasso
				(gEgo setScript: sRopeMiss)
			)
			(4 ; Do
				(cond
					((and (IsFlag 45) (gCast contains: highLadder))
						(gEgo setScript: sDownHighLadder)
					)
					((and (IsFlag 20) (gCast contains: highLadder))
						(gEgo setScript: sUpHighLadder)
					)
					((and (IsFlag 20) (gCast contains: lowerLadder))
						(gEgo setScript: sDownLowerLadder)
					)
					((and (not (IsFlag 20)) (gCast contains: lowerLadder))
						(gEgo setScript: sUpLowerLadder)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance towerTop of Feature
	(properties
		x 210
		y 43
		noun 20
		nsLeft 205
		nsBottom 7
		nsRight 215
	)

	(method (doVerb theVerb)
		(switch theVerb
			(38 ; Lasso
				(if (IsFlag 45)
					(gEgo setScript: sRopeTowerTop)
				else
					(gEgo setScript: sRopeMiss)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance waterTowerRoof of Feature
	(properties
		x 229
		y 3
		noun 13
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (or (IsFlag 45) (IsFlag 21))
					(super doVerb: 4 &rest)
				else
					(gMessager say: noun 4 2) ; "You can't reach the roof of the tower from here."
				)
			)
			(38 ; Lasso
				(gEgo setScript: sRopeMiss)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance spigot of Feature
	(properties
		x 174
		y 115
		noun 16
		nsTop 105
		nsLeft 170
		nsBottom 115
		nsRight 181
		approachX 162
		approachY 118
	)

	(method (doVerb theVerb)
		(switch theVerb
			(23 ; Tower_H20
				(if (or (IsFlag 45) (IsFlag 20) (IsFlag 21))
					(gMessager say: 34 0 13) ; "You just can't do that while you're up here, where the air is thin and the walking uncertain."
				else
					(gMessager say: noun 34 7) ; MISSING MESSAGE
				)
			)
			(4 ; Do
				(cond
					((or (IsFlag 45) (IsFlag 20) (IsFlag 21))
						(gMessager say: 34 0 13) ; "You just can't do that while you're up here, where the air is thin and the walking uncertain."
					)
					((IsFlag 94)
						(ClearFlag 94)
						(gMessager say: noun theVerb 15 0 runningH2O) ; "You turn the faucet off."
					)
					((not (IsFlag 94))
						(SetFlag 94)
						(gMessager say: noun theVerb 14 0 runningH2O) ; "You turn the faucet on, and water gushes out."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pulley of Feature
	(properties
		x 278
		y 177
		noun 35
		nsTop 166
		nsLeft 262
		nsBottom 189
		nsRight 295
	)
)

(instance outhouse of Feature
	(properties
		x 120
		y 86
		noun 3
	)
)

(instance topBuilding of Feature
	(properties
		x 108
		y 150
		noun 8
	)
)

(instance bottomBuilding of Feature
	(properties
		x 135
		y 174
		noun 7
	)
)

(instance eastBuilding of Feature
	(properties
		x 309
		y 120
		noun 9
	)
)

(instance wagon of Feature
	(properties
		x 74
		y 60
		noun 6
	)
)

(instance windMill of Feature
	(properties
		x 38
		y 102
		noun 10
	)
)

(instance house1 of Feature
	(properties
		x 300
		y 1
		noun 30
	)
)

(instance mine of Feature
	(properties
		x 160
		y 1
		noun 33
	)
)

(instance machines of Feature
	(properties
		x 160
		y 1
		noun 32
	)
)

(instance house2 of Feature
	(properties
		x 160
		y 1
		noun 31
	)
)

(instance inLafferFrame of Inset
	(properties
		view 323
		loop 2
		x 96
		y 7
		priority 13
		disposeNotOnMe 1
	)

	(method (init)
		(super init: &rest)
		(gEgo stopUpd:)
		(jimLaffer setLoop: 1 init:)
	)

	(method (dispose)
		(super dispose:)
		(jimLaffer dispose:)
		(localSound fade:)
		(gEgo show:)
		(outhouseDoor doVerb: 4)
	)
)

(instance dripSound of FPSound
	(properties
		flags 1
	)
)

(instance localSound of FPSound
	(properties
		flags 1
	)
)

