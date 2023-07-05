;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 160)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Docks)
(use Talker)
(use Scaler)
(use ROsc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm160 0
	Bandanna_Man 1
	Small_Man 2
)

(local
	local0 = 1
	local1
	local2
)

(instance rm160 of Eco2Room
	(properties
		noun 16
		picture 160
		style 12
		west 100
		picAngle 45
		vanishingY 28
		tpX 15
		tpY 128
	)

	(method (init)
		(LoadMany rsVIEW 162 130 161 104 140 164)
		(gEgo
			init:
			normalize: 0
			setScale: Scaler 98 51 165 80
			scaleSignal: 5
		)
		(if (!= gPrevRoomNum 100)
			(= style 10)
		)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: -5 134 42 150 143 149 188 139 177 128 142 140 138 138 183 120 270 168 302 131 274 117 209 125 167 98 147 98 177 117 132 134 128 129 153 118 128 98 121 94 121 82 132 77 -5 82
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: -5 158 7 169 16 158 -5 154
					yourself:
				)
		)
		(if (not (gCurrentRegionFlags test: 8))
			(thug1 init: approachVerbs: 2 setScript: (sTurnPages new:)) ; Talk
			(thug2 approachVerbs: 2 addToPic:) ; Talk
		)
		(craneNet init: stopUpd:)
		(craneArm init: stopUpd:)
		(gonzales
			cycleSpeed: 10
			init:
			approachVerbs: 2 ; Talk
			approachX: (if (gCurrentRegionFlags test: 10) 168 else 253)
			approachY: (if (gCurrentRegionFlags test: 10) 139 else 152)
			setScript: ((sTurnPages new:) yourself:)
		)
		(if (gCurrentRegionFlags test: 14)
			(if (not (gCurrentRegionFlags test: 16))
				(litterer setLoop: (Random 0 2) init: setScript: sTakePics)
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 50 106 85 83 110 88 121 134 96 143 87 143 74 135 44 133 32 132 18 117
							yourself:
						)
				)
			else
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 50 106 85 83 110 88 121 134 74 135 44 133 32 132 18 117
							yourself:
						)
				)
			)
			(gCurrentRegionFlags clear: 14)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 50 106 85 83 110 88 121 134 74 135 44 133 32 132 18 117
						yourself:
					)
			)
			(gCurrentRegionFlags set: 14)
		)
		(if (gCurrentRegionFlags test: 11)
			(grandpa addToPic:)
		else
			(grandpa init:)
		)
		(oilPouringOut init: setCycle: Fwd)
		(waterRipple1 setCycle: Fwd init:)
		(waterRipple2 setCycle: Fwd init:)
		(waterRipple3 setCycle: Fwd init:)
		(waterRipple4 setCycle: Fwd init:)
		(waterRipple5 setCycle: Fwd init:)
		(waterRipple6 setCycle: Fwd init:)
		(waterRipple7 setCycle: Fwd init:)
		(oilSpill setCycle: Fwd init:)
		(grandLegs addToPic:)
		(bucket addToPic:)
		(launch init: setOnMeCheck: 1 4)
		(loading init: setOnMeCheck: 1 128)
		(crates approachVerbs: 4 init: setOnMeCheck: 1 4096) ; Do
		(pier init: setOnMeCheck: 1 2048)
		(water init: setOnMeCheck: 1 8)
		(steps init:)
		(logging init: setOnMeCheck: 1 64)
		(logging2 init: setOnMeCheck: 1 16384)
		(shack init: setOnMeCheck: 1 16)
		(supplies init:)
		(theHorizon init:)
		(sky init: setOnMeCheck: 1 8192)
		(fish init: setOnMeCheck: 1 32)
		(westExit init:)
		(westExit2 init:)
		(if (not (gCurrentRegionFlags test: 6))
			(gCurrentRegionFlags set: 6)
			(Docks docksTimer: 90)
			(self setScript: sSlaughterYelling)
		)
		(gGameSound1 number: 164 loop: -1 play: 127)
		(if (not script)
			(gGame handsOn:)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (pier onMe: gEgo) (not (gCurrentRegionFlags test: 5)))
			(gCurrentRegionFlags set: 5)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0080)
				(gEgo inRect: 145 118 178 135)
				(gCurrentRegionFlags test: 10)
				(not (gEgo script:))
			)
			(gEgo setScript: sNoMoreLaunch)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0002)
				(not local1)
				(gCurrentRegionFlags test: 14)
				(not (gCurrentRegionFlags test: 13))
				(not (gCurRoom script:))
				(not (gEgo script:))
			)
			(gEgo setScript: sMeetPeddler)
		)
	)

	(method (dispose)
		(DisposeScript 938)
		(super dispose:)
	)

	(method (notify)
		(if (gCurrentRegionFlags test: 8)
			(gCurrentRegionFlags set: 3)
		else
			(self setScript: sThugsLeave)
		)
	)
)

(instance sThugYellsAdam of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(thug1 setScript: 0 setLoop: 2 setCel: 0)
				(gEgo setHeading: 315 self)
			)
			(1
				(if (gCurrentRegionFlags test: 9)
					(gMessager say: 17 2 4 1 self) ; "I said, GET OUTTA MY FACE!"
				else
					(gMessager say: 17 2 0 1 self) ; "Beat it, kid! This is private!"
				)
			)
			(2
				(gCurrentRegionFlags set: 9)
				(thug1 setLoop: 0 setScript: (sTurnPages new:))
				(gEgo normalize: 0 7)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoBagTrash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurrentRegionFlags set: 16)
				(gEgo setMotion: PolyPath 125 119 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gEgo view: 5 loop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(3
				(kodakBox dispose:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo normalize: 0 2)
				(= cycles 1)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThrowTrash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(litterer setLoop: 3 setCel: 0 setCycle: CT 5 1 self)
			)
			(1
				(kodakBox
					init:
					setPri: 15
					setCycle: Walk
					setMotion: JumpTo 124 120 self
				)
				(litterer setCycle: End self)
			)
			(2)
			(3
				(kodakBox setPri: 1)
				(litterer setLoop: 2 setCel: 0 setCycle: CT 2 1 self)
			)
			(4
				(= ticks 180)
			)
			(5
				(litterer setCycle: End self)
			)
			(6
				(litterer setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance sTakePics of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(== (Random 1 5) 4)
						(not (gCurrentRegionFlags test: 16))
						(not (gCast contains: kodakBox))
					)
					(self setScript: sThrowTrash self)
				else
					(litterer stopUpd:)
					(= cycles 1)
				)
			)
			(1
				(if (>= (gGame detailLevel:) (litterer detailLevel:))
					(++ state)
					(litterer setCycle: CT 2 1 self)
				else
					(litterer stopUpd:)
					(= cycles 1)
				)
			)
			(2
				(self init:)
			)
			(3
				(= ticks 180)
			)
			(4
				(sLocalSnd2 number: 165 loop: 1 play: 127)
				(litterer setCycle: End self)
			)
			(5
				(litterer setCel: 0)
				(= seconds (Random 5 7))
			)
			(6
				(litterer stopUpd:)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sAdamClimbsCrates of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 104
					posn: 38 132
					setScale: 0
					loop: 0
					cel: 0
					setPri: 15
					setCycle: End self
				)
			)
			(1
				(gEgo posn: 58 118 loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(gEgo posn: 30 118 loop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(gEgo setScript: sThugsTalk)
				(self dispose:)
			)
		)
	)
)

(instance sThugsTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurrentRegionFlags set: 7)
				(gGame handsOff:)
				(gMessager say: 16 0 9 0 self) ; "I'm tellin' ya, man, it's a good deal. Come aboard with Cibola and they'll take care of you."
			)
			(1
				(gEgo setCycle: CT 0 -1 self)
			)
			(2
				(gEgo posn: 58 118 loop: 1 cel: 7 setCycle: Beg self)
			)
			(3
				(gEgo posn: 38 132 loop: 0 cel: 7 setCycle: Beg self)
			)
			(4
				(gEgo
					setPri: -1
					normalize: 0
					posn: 44 131
					setScale: Scaler 98 51 165 80
				)
				(= cycles 1)
			)
			(5
				(gGame handsOn:)
				(gCurRoom setScript: sThugsLeave)
				(self dispose:)
			)
		)
	)
)

(instance sThugsLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gCurrentRegionFlags test: 8))
					(gCurrentRegionFlags set: 8)
					(Docks docksTimer: 90)
				)
				(self dispose:)
			)
		)
	)
)

(instance sSlaughterYelling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gonzales setScript: 0)
				((ScriptID 1049) setupTalker: 8) ; Gonzales
				((ScriptID 1039) setupTalker: 2) ; Slaughter
				(= seconds 2)
			)
			(1
				(slaughter
					posn: 330 52
					setLoop: 1
					init:
					setCycle: Walk
					setMotion: MoveTo 283 52 self
				)
			)
			(2
				(slaughter setLoop: 2 setCel: 3)
				(= cycles 1)
			)
			(3
				(slaughter setCel: 4)
				(= cycles 1)
			)
			(4
				(slaughter setCel: 1)
				(= cycles 1)
			)
			(5
				(= ticks 120)
			)
			(6
				(slaughter view: 166 loop: 0 setCycle: RandCycle)
				(= ticks 60)
			)
			(7
				(gMessager say: 16 0 7 1 self) ; "Get a move on, Gonzales! I want to get to camp in this lifetime."
			)
			(8
				(slaughter view: 167 loop: 2 cel: 1 setCycle: 0)
				(= ticks 120)
			)
			(9
				(gonzales setLoop: 1 setCel: 2 setCycle: End self)
			)
			(10
				(= ticks 60)
			)
			(11
				(gMessager say: 16 0 7 2 self) ; "Huh?"
			)
			(12
				(= ticks 60)
			)
			(13
				(slaughter view: 166 loop: 1 setSpeed: 9 setCycle: RandCycle)
				(= ticks 120)
			)
			(14
				(gMessager say: 16 0 7 3 self) ; "I'll say it slow -- get the stuff loaded and let's get out of here!"
			)
			(15
				(slaughter view: 167 loop: 2 cel: 1 setSpeed: 6 setCycle: 0)
				(= ticks 60)
			)
			(16
				(gonzales setCycle: Beg self)
			)
			(17
				(gMessager say: 16 0 7 4 self) ; "Yessir. DIDJA HEAR THAT? EVERYBODY HURRY UP OR YOU WON'T GET PAID!"
			)
			(18
				(slaughter setCel: 2)
				(= ticks 6)
			)
			(19
				(slaughter setCel: 0)
				(= ticks 6)
			)
			(20
				(gGame handsOn:)
				(slaughter
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 330 52 self
				)
				(gonzales setCycle: CT 2 1)
			)
			(21
				(gonzales setLoop: 0 setCel: 0 cycleSpeed: 10)
				(= cycles 1)
			)
			(22
				(craneNet setScript: sNetSwingsUp)
				(gonzales setScript: (sTurnPages new:))
				(slaughter dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sNetSwingsUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(craneArm stopUpd:)
				(craneNet stopUpd:)
				(= seconds (Random 20 40))
			)
			(1
				(= local0 0)
				(sLocalSnd1 number: 161 loop: -1 play: 127)
				(craneNet
					startUpd:
					posn: 247 103
					view: 161
					setLoop: 2
					cel: 6
					setCycle: Beg self
				)
			)
			(2
				(craneNet
					setLoop: 1
					posn: 264 85
					setCel: 11
					setCycle: CT 8 -1 self
				)
			)
			(3
				(sLocalSnd1 number: 160 loop: -1 play: 127)
				(craneNet setCycle: Beg)
				(craneArm startUpd: view: 161 cel: 8 setCycle: Beg)
				(= ticks 120)
			)
			(4
				(sLocalSnd1 stop:)
				(craneNet view: 165)
				(craneArm view: 165)
				(= cycles 1)
			)
			(5
				(craneNet stopUpd:)
				(craneArm stopUpd:)
				(= cycles 1)
			)
			(6
				(craneNet setScript: sNetSwingsDown)
				(self dispose:)
			)
		)
	)
)

(instance sNetSwingsDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(craneArm stopUpd:)
				(craneNet stopUpd:)
				(= seconds (Random 20 40))
			)
			(1
				(if (gEgo inRect: 226 118 282 143)
					(= state -1)
				)
				(= cycles 1)
			)
			(2
				(sLocalSnd1 number: 160 loop: -1 play: 127)
				(craneNet startUpd: view: 161 loop: 1 cel: 0 setCycle: End)
				(craneArm startUpd: view: 161 loop: 0 cel: 0 setCycle: End)
				(= ticks 120)
			)
			(3
				(sLocalSnd1 number: 161 loop: -1 play: 127)
				(craneArm view: 165 cel: 1)
				(= cycles 1)
			)
			(4
				(craneNet posn: 247 103 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(5
				(sLocalSnd1 stop:)
				(craneNet view: 165 cel: 1)
				(= cycles 1)
			)
			(6
				(= local0 1)
				(= seconds 15)
			)
			(7
				(craneNet stopUpd:)
				(craneArm stopUpd:)
				(= cycles 1)
			)
			(8
				(craneNet setScript: sNetSwingsUp)
				(self dispose:)
			)
		)
	)
)

(instance sAdamCaughtInNet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurrentRegionFlags set: 10)
				(gonzales setScript: 0 approachX: 168 approachY: 139)
				(gEgo setMotion: PolyPath 251 132 self)
			)
			(1
				(gEgo hide:)
				(sLocalSnd1 number: 161 loop: -1 play: 127)
				(craneNet
					startUpd:
					posn: 247 103
					view: 161
					setLoop: 3
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(sLocalSnd1 stop:)
				(gMessager say: 16 0 5 1 self) ; "Whoa! Put me down!"
			)
			(3
				(gonzales
					setLoop: 1
					setCel: 2
					cycleSpeed: 2
					setCycle: CT 4 1 self
				)
			)
			(4
				(gMessager say: 16 0 5 2 4 self) ; "It's a kid! Get outta there, kid!"
			)
			(5
				(= ticks 90)
			)
			(6
				(sLocalSnd1 number: 161 loop: -1 play: 127)
				(craneNet setCycle: Beg self)
			)
			(7
				(sLocalSnd1 stop:)
				(gEgo show:)
				(craneNet posn: 247 103 view: 165 setLoop: 2 setCel: 1)
				(= cycles 1)
			)
			(8
				(gMessager say: 16 0 6 1 self) ; "You got no business here, sonny. Scram or I'll take you to see Mr. Slaughter. He'll fix you good!"
			)
			(9
				(craneNet stopUpd:)
				(craneArm stopUpd:)
				(gonzales setCycle: CT 2 -1 self)
				(gEgo setMotion: PolyPath 124 133 self)
			)
			(10)
			(11
				(gonzales setCycle: Beg self)
			)
			(12
				(= ticks 60)
			)
			(13
				(gonzales setCycle: CT 2 1 self)
			)
			(14
				(gonzales setLoop: 0 setCel: 0 cycleSpeed: 10)
				(= cycles 1)
			)
			(15
				(gonzales setScript: (sTurnPages new:))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sNoMoreLaunch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gonzales setScript: 0)
				(= cycles 1)
			)
			(1
				(gonzales setLoop: 1 setCel: 2 setCycle: Beg self)
			)
			(2
				(gMessager say: 16 0 6 1 self) ; "You got no business here, sonny. Scram or I'll take you to see Mr. Slaughter. He'll fix you good!"
			)
			(3
				(gEgo normalize: 0 setMotion: PolyPath 124 133 self)
			)
			(4
				(= ticks 120)
			)
			(5
				(gonzales setCycle: CT 2 1 self)
			)
			(6
				(gonzales setLoop: 0 setCel: 0 cycleSpeed: 10)
				(= cycles 1)
			)
			(7
				(gonzales setScript: (sTurnPages new:))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkWithOldMan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 6 2 3 1 self) ; "Are you catching anything?"
			)
			(1
				(grandpa setLoop: 1 setCycle: End self)
			)
			(2
				(= ticks 6)
			)
			(3
				(gMessager say: 6 2 3 2 self) ; "Only these ones. I do not like the looks of them."
			)
			(4
				(= ticks 30)
			)
			(5
				(grandpa setCycle: Beg self)
			)
			(6
				(= ticks 30)
			)
			(7
				(grandpa setLoop: 0 setCycle: End self)
			)
			(8
				(gMessager say: 6 2 3 3 self) ; "Still, I live near here. I can't get around very well anymore."
			)
			(9
				(= ticks 6)
			)
			(10
				(grandpa setCycle: Beg self)
			)
			(11
				(gMessager say: 6 2 3 4 7 self) ; "My grandfather likes to fish, too. I used to go fishing with him when I was little."
			)
			(12
				(grandpa stopUpd:)
				(gCurrentRegionFlags set: 11)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMeetPeddler of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(gGame handsOff:)
				(gMessager say: 19 2 3 1 self) ; "Hey kid, hold up a second!"
			)
			(1
				(gEgo setMotion: PolyPath 67 149 self)
			)
			(2
				(gEgo setHeading: 270 self)
			)
			(3
				(gEgo setCycle: 0 view: 140 setLoop: 7 setCel: 0)
				(= cycles 1)
			)
			(4
				(parrotPeddler
					view: 141
					setLoop: 0
					init:
					setSpeed: 0
					ignoreActors:
					setScale: Scaler 98 51 165 80
					setCycle: Walk
					setMotion: MoveTo (- (gEgo x:) 31) (gEgo y:) self
				)
			)
			(5
				(parrotPeddler
					view: 140
					setLoop: 3
					setSpeed: 6
					setCycle: RandCycle
				)
				(= cycles 1)
			)
			(6
				(= ticks 120)
			)
			(7
				(if (gCurrentRegionFlags test: 12)
					(gMessager say: 16 0 15 0 self) ; "Ah, you have come back! Perhaps because you admire my parrot. Do you wish to buy him?"
				else
					(gCurrentRegionFlags set: 12)
					(gMessager say: 16 0 14 0 self) ; "Good day, my young friend. I see you are just off the boat."
				)
			)
			(8
				(= ticks 15)
			)
			(9
				(= local2 1)
				(parrotPeddler setCycle: 0 setCel: 0)
				(gEgo normalize: 0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBuyTheBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo put: 0 setCycle: 0 view: 140 loop: 7 cel: 0) ; buckazoid
				(gCurrentRegionFlags set: 13)
				(gMessager say: 19 7 10 0 self) ; "What a coincidence! Exactly the right amount. Are you a mind reader, kid?"
			)
			(1
				(parrotPeddler setCycle: End)
				(= ticks 45)
			)
			(2
				(sLocalSnd2 number: 166 loop: 1 play: 127 self)
			)
			(3
				(parrotPeddler setLoop: 4 cel: 0 setCycle: CT 2 1 self)
			)
			(4
				(sLocalSnd2 number: 167 loop: 1 play: 127)
				(parrotPeddler setCycle: End self)
			)
			(5
				(= ticks 10)
			)
			(6
				(gMessager say: 19 7 11 0 self) ; "Why, you miserable lump of feathers! I should have eaten you!"
			)
			(7
				(parrotPeddler setLoop: 5 cel: 0 setCycle: CT 1 1)
				(gEgo view: 140 loop: 7 cel: 1 setCycle: End self)
			)
			(8
				(sLocalSnd2 number: 166 loop: 1 play: 127 self)
			)
			(9
				(gMessager say: 19 7 12 0 self) ; "Never mind him! Fly home!"
			)
			(10
				(gEgo cel: 5 setCycle: CT 2 -1 self)
				(parrotPeddler setCycle: CT 3 1 self)
			)
			(11)
			(12
				(bird
					posn: (gEgo x:) (gEgo y:)
					init:
					setPri: -1
					setSpeed: 0
					setStep: 5 5
					ignoreActors:
					ignoreHorizon:
					setLoop: 8
					setCycle: Fwd
					setMotion: MoveTo 241 -10 self
				)
				(gEgo cel: 1 setCycle: CT 0 -1)
				(parrotPeddler cel: 4)
			)
			(13
				(bird dispose:)
				(gMessager say: 19 7 13 0 self) ; "You crazy kid! Do you know how hard it is to catch those?"
			)
			(14
				(= local2 0)
				(gEgo normalize: 0 1)
				(parrotPeddler setLoop: 6 setCycle: ROsc -1 0 2)
				(= seconds 2)
			)
			(15
				(parrotPeddler
					view: 141
					setLoop: 2
					setSpeed: 0
					setCycle: Walk
					setSpeed: 0
					setMotion: MoveTo -15 132 self
				)
			)
			(16
				(parrotPeddler dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDontBuyTheBird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 0)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gMessager say: 16 0 17 0 self) ; "A pity! However, perhaps we can do business later."
			)
			(1
				(parrotPeddler
					view: 141
					loop: 1
					setSpeed: 0
					setCycle: Walk
					setMotion: MoveTo -15 132 self
				)
			)
			(2
				(parrotPeddler dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTurnPages of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gGame detailLevel:) (client detailLevel:))
					(++ state)
					(client startUpd: setCycle: End self)
				else
					(client stopUpd:)
					(= cycles 1)
				)
			)
			(1
				(self init:)
			)
			(2
				(client setCel: 0)
				(= cycles 1)
			)
			(3
				(client stopUpd:)
				(= cycles 1)
			)
			(4
				(= seconds (Random 15 30))
			)
			(5
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance parrotPeddler of Actor
	(properties
		x -15
		y 132
		noun 19
		view 140
		signal 20480
		scaleSignal 1
		scaleX 111
		scaleY 111
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; buckazoid
				(if local2
					(gGame points: 5)
					(gEgo setScript: sBuyTheBird)
				else
					0
				)
			)
			(2 ; Talk
				(if local2
					(gMessager say: 19 2 0 0) ; "Where did you get the parrot, anyway?"
				else
					0
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and local2 (not (gCurrentRegionFlags test: 13)) (gEgo mover:))
			(self setScript: sDontBuyTheBird)
		)
	)
)

(instance bird of Actor
	(properties
		x 155
		y 145
		noun 20
		view 140
		loop 8
		priority 9
		signal 24592
		illegalBits 0
	)
)

(instance slaughter of Actor
	(properties
		x 283
		y 52
		view 167
		loop 2
		cel 1
		signal 16400
		scaleSignal 1
		scaleX 99
		scaleY 99
	)
)

(instance kodakBox of Actor
	(properties
		x 85
		y 102
		noun 9
		view 164
		loop 4
		priority 1
		signal 16400
	)

	(method (doit)
		(super doit: &rest)
		(if (not (IsEcorderFlag 47))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 47))
			(cond
				((pier onMe: gEgo)
					(if (OneOf theVerb 53 1 4) ; Recycle, Look, Do
						(gMessager say: 9 theVerb 25)
					else
						(super doVerb: theVerb)
					)
				)
				((== theVerb 53) ; Recycle
					(gGame points: 5)
					(gEgo setScript: sGoBagTrash)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance craneNet of Prop
	(properties
		x 247
		y 103
		noun 23
		view 165
		loop 2
		cel 1
		signal 20480
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(cond
				((gCurrentRegionFlags test: 10)
					(gMessager say: 10 4 22 1) ; "No one allowed up here, kid. Get lost."
				)
				((pier onMe: gEgo) 0)
				(local0
					(craneNet setScript: 0)
					(gEgo setScript: sAdamCaughtInNet)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not (gCurrentRegionFlags test: 10))
				(gEgo inRect: 236 119 275 137)
				local0
				(!= (gEgo script:) sAdamCaughtInNet)
			)
			(craneNet setScript: 0)
			(gEgo setScript: sAdamCaughtInNet)
		)
	)
)

(instance thug1 of Prop
	(properties
		x 90
		y 92
		noun 17
		approachX 114
		approachY 137
		view 163
		signal 20480
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(if (not (pier onMe: gEgo))
				(gEgo setScript: sThugYellsAdam)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance thug2 of Prop
	(properties
		x 90
		y 127
		noun 18
		approachX 114
		approachY 137
		view 163
		loop 1
		priority 6
		signal 20497
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(if (not (pier onMe: gEgo))
				(if (gCurrentRegionFlags test: 9)
					(gMessager say: 18 2 4 1) ; "The small man eyes Adam nervously but doesn't answer."
				else
					(gMessager say: 18 2 0 1) ; "The small man is too busy listening to his buddy."
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance craneArm of Prop
	(properties
		x 314
		y 53
		noun 23
		view 165
		cel 1
		signal 20480
	)
)

(instance gonzales of Prop
	(properties
		x 290
		y 176
		noun 29
		view 162
		priority 15
		signal 20496
		detailLevel 2
	)
)

(instance litterer of Prop
	(properties
		x 93
		y 136
		noun 8
		view 164
		loop 2
		cel 1
		signal 20480
		scaleSignal 1
		scaleX 96
		scaleY 96
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(if (not (gCurrentRegionFlags test: 15))
				(gGame points: 1)
				(gCurrentRegionFlags set: 15)
			)
			(gMessager say: 8 2 0 0) ; "Hey, there...Hello?"
		else
			(super doVerb: theVerb)
		)
	)
)

(instance grandpa of Prop
	(properties
		x 23
		y 173
		z 10
		noun 6
		view 130
		priority 15
		signal 20497
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(if (pier onMe: gEgo)
				(if (gCurrentRegionFlags test: 11)
					(gMessager say: 6 2 4) ; "The old man is lost in thought. He seems to have nothing more to say."
				else
					(gGame points: 1)
					(gEgo setScript: sTalkWithOldMan)
				)
			else
				(gMessager say: 6 2 8) ; "Ugh! Did you catch those smelly fish?"
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance oilPouringOut of Prop
	(properties
		x 301
		y 112
		noun 2
		view 160
		cel 3
		signal 16384
		detailLevel 2
	)

	(method (doit)
		(if (not (IsEcorderFlag 46))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 46))
			(super doVerb: theVerb)
		else
			(gGame points: 9)
		)
	)
)

(instance waterRipple1 of Prop
	(properties
		x 15
		y 187
		noun 7
		view 160
		loop 1
		cel 3
		priority 1
		signal 16400
		detailLevel 2
	)
)

(instance waterRipple2 of Prop
	(properties
		x 46
		y 179
		noun 7
		view 160
		loop 2
		cel 1
		priority 1
		signal 16400
		detailLevel 2
	)
)

(instance waterRipple3 of Prop
	(properties
		x 215
		y 151
		noun 7
		view 160
		loop 3
		cel 1
		priority 1
		signal 16400
		detailLevel 2
	)
)

(instance waterRipple4 of Prop
	(properties
		x 233
		y 167
		noun 7
		view 160
		loop 4
		cel 2
		priority 1
		signal 16400
		detailLevel 2
	)
)

(instance waterRipple5 of Prop
	(properties
		x 254
		y 184
		noun 7
		view 160
		loop 5
		cel 1
		priority 1
		signal 16400
		detailLevel 2
	)
)

(instance waterRipple6 of Prop
	(properties
		x 232
		y 105
		noun 7
		view 160
		loop 6
		cel 3
		priority 1
		signal 16400
		detailLevel 2
	)
)

(instance waterRipple7 of Prop
	(properties
		x 257
		y 101
		noun 7
		view 160
		loop 7
		priority 1
		signal 16400
		detailLevel 2
	)
)

(instance oilSpill of Prop
	(properties
		x 218
		y 168
		noun 2
		view 160
		loop 8
		signal 16384
		cycleSpeed 20
		detailLevel 2
	)
)

(instance bucket of View
	(properties
		x 10
		y 177
		z 10
		noun 6
		view 130
		loop 2
		priority 14
		signal 20497
	)
)

(instance grandLegs of View
	(properties
		x 25
		y 161
		noun 6
		view 130
		loop 3
		signal 20481
	)
)

(instance launch of Feature
	(properties
		x 311
		y 28
		noun 1
		onMeCheck 4
		approachX 285
		approachY 78
	)
)

(instance loading of Feature
	(properties
		x 287
		y 84
		noun 3
		onMeCheck 128
		approachX 245
		approachY 137
	)
)

(instance crates of Feature
	(properties
		x 54
		y 110
		noun 4
		onMeCheck 4096
		approachX 44
		approachY 131
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(cond
				(
					(or
						(gCurrentRegionFlags test: 7)
						(and
							(not (gCast contains: thug1))
							(not (gAddToPics contains: thug1))
						)
					)
					(gMessager say: 4 4 2 1) ; "Climbing the crates would serve no purpose."
				)
				((pier onMe: gEgo) 0)
				(else
					(gGame points: 5)
					(gEgo setScript: sAdamClimbsCrates)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pier of Feature
	(properties
		x 29
		y 170
		noun 5
		onMeCheck 2048
		approachX 29
		approachY 170
	)
)

(instance water of Feature
	(properties
		x 278
		y 99
		noun 7
		onMeCheck 8
		approachX 190
		approachY 179
	)
)

(instance steps of Feature
	(properties
		x 165
		y 121
		noun 10
		nsTop 116
		nsLeft 151
		nsBottom 127
		nsRight 179
		approachX 165
		approachY 121
	)
)

(instance logging of Feature
	(properties
		x 46
		y 46
		noun 11
		onMeCheck 64
		approachX 46
		approachY 46
	)
)

(instance logging2 of Feature
	(properties
		x 111
		y 50
		noun 11
		onMeCheck 16384
	)
)

(instance shack of Feature
	(properties
		x 184
		y 51
		noun 12
		onMeCheck 16
		approachX 184
		approachY 51
	)
)

(instance supplies of Feature
	(properties
		x 210
		y 92
		noun 13
		nsTop 73
		nsLeft 183
		nsBottom 111
		nsRight 238
		approachX 210
		approachY 92
	)
)

(instance theHorizon of Feature
	(properties
		x 36
		y 12
		noun 14
		nsBottom 25
		nsRight 72
		approachX 36
		approachY 12
	)
)

(instance sky of Feature
	(properties
		x 197
		y 14
		noun 15
		onMeCheck 8192
		approachX 197
		approachY 14
	)
)

(instance fish of Feature
	(properties
		x 49
		y 160
		noun 30
		onMeCheck 32
		approachX 41
		approachY 145
	)
)

(instance westExit of ExitFeature
	(properties
		nsTop 82
		nsBottom 134
		nsRight 10
		cursor 12
		exitDir 4
	)
)

(instance westExit2 of ExitFeature
	(properties
		nsTop 154
		nsBottom 158
		nsRight 5
		cursor 12
		exitDir 4
	)
)

(instance Bandanna_Man of Narrator
	(properties
		name {Bandanna Man}
		back 19
	)

	(method (init)
		(self x: 20 y: 40 font: gUserFont keepWindow: 1)
		(super init:)
	)
)

(instance Small_Man of Narrator
	(properties
		name {Small Man}
		back 19
	)

	(method (init)
		(self x: 150 y: 40 font: gUserFont keepWindow: 1)
		(super init:)
	)
)

(instance sLocalSnd1 of Sound
	(properties)
)

(instance sLocalSnd2 of Sound
	(properties)
)

