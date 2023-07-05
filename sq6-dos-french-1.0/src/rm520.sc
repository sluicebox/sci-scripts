;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQNarrator)
(use n666)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm520 0
	sharpeiTalker 1
	Stellar 2
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
)

(instance rm520 of SQRoom
	(properties
		noun 1
		picture 520
	)

	(method (init)
		(gEgo init: normalize: 0 posn: 0 105)
		(super init:)
		(gCurRoom
			addObstacle:
				(= local5
					((Polygon new:)
						type: PContainedAccess
						init: 31 104 16 108 16 111 0 116 0 138 300 138 300 118 222 118 200 105 283 105 283 95 203 98 196 93 148 93 148 81 143 77 131 77 126 82 101 82 106 88 87 102 47 102
						yourself:
					)
				)
		)
		(medSupplies init:)
		(medUnit init:)
		(redThing init:)
		(medStand init:)
		(standHole init:)
		(redTank init:)
		(redLight init:)
		(vent init:)
		(bathroom init:)
		(cupboards init:)
		(sink init:)
		(towel init:)
		(toiletPaper init:)
		(toilet init: approachVerbs: 4) ; Do
		(medCabinet init: approachVerbs: 4) ; Do
		(bathDoor init:)
		(chandelier init:)
		(littleHole init:)
		(outlet init:)
		(waste init:)
		(bottles init:)
		(machineStack init:)
		(heartMonitor init:)
		(pacman init:)
		(veinJuicer init:)
		(dresser init:)
		(portHole init:)
		(clearThing init:)
		(scanner init:)
		(headboard init:)
		(middleCircle init:)
		(doormat init:)
		(yellowPanel init:)
		(bluePanel init:)
		(redPanel init:)
		(greenPanel init:)
		(tank1 init:)
		(tank2 init:)
		(door init: setCel: (door lastCel:) approachVerbs: 4) ; Do
		(elevLights init: approachVerbs: 4) ; Do
		(bed init:)
		(cabinet init: hide:)
		(if (== global120 1)
			(sharpei init:)
			(crapomatic init: hide: approachVerbs: 4) ; Do
			(monitors init:)
			(bucket init:)
			(mop init: approachVerbs: 4) ; Do
		else
			(bed loop: 0)
		)
		(if (== global120 1)
			(gGSound1 number: 520 loop: -1 play:)
			(sFX number: 52013 loop: -1 play:)
			(Load rsVIEW 524 527)
			(Load 140 527 52015) ; WAVE
			(gCurRoom setScript: sRogerEnters 0 1)
		else
			(gGSound1 number: 511 loop: -1 play:)
			(gCurRoom setScript: sRogerEnters)
		)
	)

	(method (newRoom)
		(RemapColors 0) ; Off
		(FrameOut)
		(super newRoom: &rest)
	)
)

(instance sRogerEnters of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 268) ; WAVE
				(= cycles 3)
			)
			(1
				(gEgo setMotion: MoveTo 45 105 self)
			)
			(2
				(gGSound2 number: 268 loop: 1 play:)
				(door setCycle: Beg self)
			)
			(3
				(= temp1 100)
				(for ((= temp0 236)) (< temp0 245) ((++ temp0))
					(RemapColors 2 temp0 (+= temp1 15)) ; ByPercent
				)
				(if register
					(gCurRoom setScript: sFirstTime)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sFirstTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sharpei setCycle: End self)
			)
			(1
				(= ticks 30)
			)
			(2
				(gMessager say: 0 0 6 1 self) ; "Janitor Second Class Roger Wilco reporting as ordered, Ma'am."
			)
			(3
				(gGSound2 number: 528 loop: 1 play:)
				(sharpei view: 522 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(bed cel: 1)
				(crapomatic show:)
				(gGSound2 stop:)
				(sharpei loop: 1 cel: 0)
				(= ticks 30)
			)
			(5
				(= local0 1)
				(= local7 1)
				(gMessager sayRange: 0 0 6 2 3 self) ; "Wilco, you say."
			)
			(6
				(= local7 0)
				(gMessager sayRange: 0 0 6 4 5 self) ; "Well, Mr. Wilco, I expected you here some time ago. I've been kept waiting for MINUTES now!"
			)
			(7
				(= local7 1)
				(gMessager sayRange: 0 0 6 6 7 self) ; "Ah, save the pathetic whimperings for your StarCon superiors, which I would expect includes everyone and everything on the food chain over there."
			)
			(8
				(= local7 0)
				(gMessager sayRange: 0 0 6 8 9 self) ; "Young man, I lack the time, and most importantly, the PATIENCE to indulge you as you whine your way from one excuse to the next. May we please just begin?"
			)
			(9
				(= local7 1)
				(gMessager sayRange: 0 0 6 10 11 self) ; "You are a janitor, Mr.Wilco! What do you THINK I want from you, a heart transplant? What has become of StarCon?"
			)
			(10
				(= local7 0)
				(gMessager say: 0 0 6 12 self) ; "But you! I pray you do not typify what might be slithering down the halls of our formerly prestigious academy. That is one thing I do not look forward to witnessing."
			)
			(11
				(= local7 1)
				(gMessager say: 0 0 6 13 self) ; "Get to work, Mr Wilco. You'll find a mop and a bucket right over there. I have no time to devote to your education. That would take a lifetime and the most copious amount of patience a universe could muster. My life is soon to expire. Please, just clean. I must rest now."
			)
			(12
				(= local7 0)
				(gGame handsOn:)
				(= ticks 3600)
			)
			(13
				(if (gTalkers isEmpty:)
					(= cycles 1)
				else
					(-- state)
					(= ticks 60)
				)
			)
			(14
				(= local7 1)
				(gMessager say: 0 0 16 0 self) ; "Ahem! ... Mr. Wilco, I asked you to mop the floors. Do I have to get Commander Kielbasa in here to get you to do your job?"
			)
			(15
				(= local7 0)
				(self changeState: (- state 3))
			)
		)
	)
)

(instance sDoTheMopThing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 0)
				(= register 2)
				(gGame points: 3)
				(gEgo
					view: 524
					loop: 0
					cel: 0
					setPri: 105
					setSpeed: 8
					setCycle: CT 3 1
				)
				(sharpei view: 525 loop: 1 cel: 0 setCycle: CT 5 1 self)
			)
			(1
				(sharpei setCycle: CT 0 1)
				(mop dispose:)
				(sharpei view: 525 loop: 1)
				(gEgo setCycle: End self)
			)
			(2
				(gGSound2 number: 52015 loop: 1 play:)
				(gEgo loop: 1 cel: 0 posn: 112 100 setCycle: End self)
			)
			(3
				(gGSound2 play:)
				(gEgo cel: 0 setCycle: End self)
			)
			(4
				(gGSound2 play:)
				(gEgo cel: 0 setCycle: End self)
			)
			(5
				(gEgo loop: 2 cel: 0 setCycle: CT 4 1 self)
			)
			(6
				(gGSound2 number: 527 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(7
				(if (-- register)
					(self changeState: 2)
				else
					(gEgo loop: 3 cel: 0)
					(= local7 1)
					(gMessager say: 0 0 7 1 self) ; "Mr. Wilco, please rattle the handle on that commode. It is positively maddening."
				)
			)
			(8
				(= local7 0)
				(gEgo loop: 0)
				(gEgo
					cel: (gEgo lastCel:)
					posn: 95 100
					setCycle: CT 3 -1 self
				)
			)
			(9
				(mop init:)
				(gEgo setCycle: Beg self)
			)
			(10
				(gEgo normalize: 1)
				(proc0_4 gEgo sharpei self)
			)
			(11
				(= local1 1)
				(gMessager sayRange: 0 0 7 2 3 self) ; "You got it, Toot ... ooh, uh, I mean, right away, Ma'am. Whatever I can do."
			)
			(12
				(gGame handsOn:)
				(= ticks 3600)
			)
			(13
				(if (gTalkers isEmpty:)
					(= cycles 1)
				else
					(-- state)
					(= ticks 60)
				)
			)
			(14
				(= local7 1)
				(gMessager say: 0 0 8 0 self) ; "Mr. Wilco, are the little voices in your head drowning me out? Get in there and take care of that toilet. My report of your performance to your commander is not looking too favorable at this time."
			)
			(15
				(= local7 0)
				(self changeState: (- state 3))
			)
		)
	)
)

(instance sDoTheToiletThing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 0)
				(gEgo setMotion: MoveTo 160 81 self)
			)
			(1
				(gGSound2 number: 526 loop: 1 play: self)
				(sharpei view: 525 loop: 2 cel: 0 setCycle: End self)
			)
			(2)
			(3
				(sFX stop:)
				(gGame points: 1)
				(gEgo setMotion: MoveTo 148 81 self)
			)
			(4
				(sharpei loop: 3 cel: 0 setCycle: End self)
				(gEgo setMotion: PolyPath 151 99 self)
			)
			(5
				(Load rsVIEW 526)
			)
			(6
				(gEgo setHeading: 135)
				(= local2 1)
				(= local7 1)
				(gMessager sayRange: 0 0 17 1 3 self) ; "Mr. Wilco, it is time for me to take my meds. Please fetch my trysonixsortium from the medicine cabinet."
			)
			(7
				(= local7 0)
				(gMessager sayRange: 0 0 17 4 5 self) ; "What was that, Janitor?!"
			)
			(8
				(gGame handsOn:)
				(= ticks 3600)
			)
			(9
				(if (gTalkers isEmpty:)
					(= cycles 1)
				else
					(-- state)
					(= ticks 60)
				)
			)
			(10
				(gMessager say: 0 0 18 0 self) ; "Wilco, did I stutter? Get my medicine -- immediately!"
			)
			(11
				(self changeState: (- state 3))
			)
		)
	)
)

(instance sDoTheMedsThing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 522) ; WAVE
				(= local2 0)
				(gEgo setHeading: 0 self)
			)
			(1
				(gGame points: 3)
				(cabinet show: cel: 0 setCycle: End)
				(gGSound2 number: 522 loop: 1 play:)
				(= cycles 1)
			)
			(2
				(Load 140 382) ; WAVE
				(sharpei view: 525 loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 17 1 19 0 self) ; "I can't find her medicine! I don't think she knows what she's talking about."
			)
			(4
				(Load 140 523) ; WAVE
				(sharpei loop: 4 cel: 0 setCycle: End self)
				(cabinet setCycle: Beg self)
			)
			(5
				(gGSound2 number: 382 loop: 1 play:)
				(= ticks 90)
			)
			(6
				(Load 140 524) ; WAVE
				(Load rsVIEW 526)
				(self setScript: sLockAndGas)
			)
			(7
				(= cycles 3)
			)
			(8
				(gEgo setMotion: PolyPath 141 100 self)
			)
			(9
				(= ticks 45)
			)
			(10
				(cabinet hide:)
				(gEgo setHeading: 270 self)
			)
			(11
				((gCurRoom obstacles:) delete: local5)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 31 104 16 108 16 111 0 116 0 138 300 138 300 118 222 118 200 105 283 105 283 95 203 98 196 93 148 93 148 81 142 80 99 80 99 86 119 86 111 107 47 102
							yourself:
						)
				)
				(sharpei case: 9)
				(gMessager say: 0 0 9 0 self) ; "Hey, what the ..."
			)
			(12
				(= local3 1)
				(gEgo setScript: sEgoCoughs)
				(gGame handsOn:)
				(= ticks 7200)
			)
			(13
				(self setScript: sAsphix self)
			)
			(14
				(gEgo setScript: sEgoCoughs normalize: 2 posn: 137 101)
				(gas dispose:)
				(elevLights cel: 0 setCycle: 0)
				(gGSound2 stop:)
				(door setScript: sLockAndGas)
				(self changeState: (- state 2))
			)
		)
	)
)

(instance sLockAndGas of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGSound2 number: 523 loop: 1 play: self)
				(elevLights setCycle: Fwd)
				(sharpei view: 525 loop: 3 cel: 0 setCycle: End)
			)
			(1
				(gGSound1 number: 521 loop: -1 play:)
				(gGSound2 number: 524 loop: -1 play:)
				(gas init: loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gas loop: 1 cel: 0 setCycle: Fwd)
				(sharpei view: 527 loop: 1 cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance sGetCrapO of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 527
					loop: 0
					cel: 0
					setSpeed: 9
					setCycle: CT 4 1 self
				)
			)
			(1
				(= ticks 30)
			)
			(2
				(gEgo setCycle: CT 6 1 self)
			)
			(3
				(= ticks 45)
			)
			(4
				(gEgo cel: 5)
				(= ticks 30)
			)
			(5
				(gEgo cel: 6)
				(= ticks 45)
			)
			(6
				(gEgo cel: 5)
				(= ticks 30)
			)
			(7
				(gEgo setCycle: CT 6 1 self)
			)
			(8
				(gEgo setCycle: End self)
				(gGSound2 number: 52010 loop: 1 play: self)
				(crapomatic dispose:)
				(sharpei
					view: 527
					loop: 1
					cel: 0
					posn: 272 86
					cycleSpeed: 8
					setCycle: End
				)
				(bed dispose:)
			)
			(9
				(gGSound2 number: 524 loop: -1 play:)
			)
			(10
				(gMessager say: 45 4 11 0 self) ; "You give the piston a yank and, sure enough, it comes loose in your hands. Perhaps it was your raw strength. More than likely, it was defective."
				(gEgo get: 22) ; Crap_O_Matic
				(gEgo normalize: 0 posn: 258 119)
				(door approachX: 25 approachY: 110 approachVerbs: 4 149) ; Do, Crap_O_Matic
			)
			(11
				(gGame points: 3 505)
				(gGame handsOn:)
				(= ticks local6)
			)
			(12
				(self setScript: sAsphix self)
			)
			(13
				(gEgo
					setScript: sEgoCoughs
					normalize: 2
					posn: 137 101
					put: 22 ; Crap_O_Matic
				)
				(bed init: cel: 1)
				(sharpei view: 525 loop: 4)
				(sharpei cel: (sharpei lastCel:))
				(crapomatic init: approachVerbs: 4) ; Do
				(gas dispose:)
				(elevLights cel: 0 setCycle: 0)
				(gGSound2 stop:)
				(door setScript: sLockAndGas)
				(sDoTheMedsThing start: 12)
				(gCurRoom setScript: sDoTheMedsThing)
			)
		)
	)
)

(instance sEgoCoughs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 52011) ; WAVE
				(= ticks 900)
			)
			(1
				(if (not (gUser canControl:))
					(-- state)
					(= ticks 60)
				else
					(gGame handsOff:)
					(cond
						((<= 0 (gEgo heading:) 130)
							(= scratch 0)
							(gEgo setHeading: 90 self)
						)
						((< 130 (gEgo heading:) 275)
							(= scratch 2)
							(gEgo setHeading: 180 self)
						)
						((<= 275 (gEgo heading:) 359)
							(= scratch 1)
							(gEgo setHeading: 270 self)
						)
					)
				)
			)
			(2
				(sFX number: 52011 loop: -1 play:)
				(gEgo
					view: 5260
					loop: scratch
					cel: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(3
				(sFX stop:)
				(gEgo cel: 2 setCycle: Beg self)
			)
			(4
				(gEgo normalize: scratch)
				(gGame handsOn:)
				(self changeState: 0)
			)
		)
	)
)

(instance sAsphix of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(Load 140 52014) ; WAVE
				(if (gTalkers isEmpty:)
					(= cycles 1)
				else
					(-- state)
					(= ticks 60)
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setScript: 0)
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(if
					(or
						(> temp0 242)
						(< temp1 95)
						(and (> temp0 141) (< 105 temp1 114))
					)
					(gEgo
						normalize: (gEgo loop:)
						setMotion: PolyPath 109 117 self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(cond
					((<= 0 (gEgo heading:) 130)
						(= scratch 0)
						(gEgo setHeading: 90 self)
					)
					((< 130 (gEgo heading:) 275)
						(= scratch 2)
						(gEgo setHeading: 180 self)
					)
					((<= 275 (gEgo heading:) 359)
						(= scratch 1)
						(gEgo setHeading: 270 self)
					)
				)
			)
			(3
				(sFX number: 52014 loop: 1 play:)
				(gEgo
					view: 5261
					loop: scratch
					cel: 0
					setSpeed: 8
					setCycle: End self
				)
			)
			(4
				(= ticks 60)
			)
			(5
				(proc666_0 8 self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance sEndCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setScript: 0
					view: 5270
					loop: 0
					cel: 0
					posn: 25 108
					setSpeed: 9
				)
				(door hide:)
				(= ticks 60)
			)
			(1
				(gEgo setCycle: CT 1 1 self)
			)
			(2
				(= ticks 70)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(= ticks 60)
			)
			(5
				(gEgo setCycle: CT 2 1 self)
			)
			(6
				(= ticks 30)
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(= ticks 20)
			)
			(9
				(gEgo setCycle: CT 12 1 self)
			)
			(10
				(door view: 528 loop: 0 cel: 0 posn: 1 42 show:)
				(gEgo setCycle: End self)
			)
			(11
				(gEgo
					put: 22 ; Crap_O_Matic
					view: 5271
					loop: 0
					cel: 0
					posn: 46 109
					setScript: sDecide
				)
				(door setScript: sStrain)
				(gMessager sayRange: 2 129 0 1 2 self) ; "Good thinking! Wedged in the door, the manual override control causes the piston to strain against the door."
			)
			(12
				(gGame points: 5 506)
				(Load rsVIEW 529)
				(= ticks 90)
			)
			(13
				(sFXBeam play:)
				(stellar init: setCycle: CT 16 1 self)
			)
			(14
				(gMessager say: 0 0 14 1) ; "(URGENTLY) Wilco!"
				(stellar setCycle: End self)
			)
			(15
				(sFXBeam stop:)
				(sDecide dispose:)
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(16
				(Load rsVIEW 5290)
				(= ticks 45)
			)
			(17
				(gMessager say: 0 0 14 2) ; "(CALMLY) Oh, hi, Stellar. What're you doing here?"
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(18
				(gEgo loop: 2 cel: 0 setCycle: End self)
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(19
				(stellar loop: 1 cel: 0 setCycle: CT 5 1 self)
			)
			(20
				(gEgo hide:)
				(stellar setCycle: End self)
			)
			(21
				(= local8 1)
				(stellar view: 5290 loop: 0 cel: 0 posn: 46 109)
				(gMessager say: 0 0 14 3 self) ; "There's no time to talk, Roger! We've got get out of here NOW!"
			)
			(22
				(= ticks 30)
			)
			(23
				(= local8 0)
				(stellar loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(24
				(gMessager say: 0 0 14 4) ; "ONE!"
				(stellar setCycle: End self)
			)
			(25
				(= cycles 10)
			)
			(26
				(stellar loop: 2 cel: 0 setCycle: End self)
			)
			(27
				(gMessager say: 0 0 14 5 self) ; "TWO!"
			)
			(28
				(= cycles 10)
			)
			(29
				(stellar loop: 2 cel: 0 setCycle: End self)
			)
			(30
				(sStrain dispose:)
				(door setCycle: End self)
			)
			(31
				(Load 140 52012) ; WAVE
				(Load rsVIEW 528)
				(= ticks 30)
			)
			(32
				(gMessager say: 0 0 14 6 self) ; "(MORE LABORED) THREE!"
				(stellar loop: 3 cel: 0 setCycle: End self)
			)
			(33)
			(34
				(gGSound2 number: 52012 loop: 1 play:)
				(door view: 528 loop: 1 cel: 0 setCycle: End self)
			)
			(35
				(= ticks 60)
			)
			(36
				(gGSound2 fade:)
				(gCurRoom newRoom: 500)
				(self dispose:)
			)
		)
	)
)

(instance sStrain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door setCycle: CT 2 1 self)
			)
			(1
				(= ticks 30)
			)
			(2
				(door setCycle: Beg self)
			)
			(3
				(= ticks 30)
			)
			(4
				(door setCycle: CT 1 1 self)
			)
			(5
				(= ticks 30)
			)
			(6
				(door setCycle: Beg self)
			)
			(7
				(self changeState: 0)
			)
		)
	)
)

(instance sDecide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: CT 2 1 self)
			)
			(1
				(= ticks 30)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(= ticks 30)
			)
			(4
				(gEgo setCycle: CT 2 -1 self)
			)
			(5
				(= ticks 30)
			)
			(6
				(self changeState: 2)
			)
		)
	)
)

(instance sRogerExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(door setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo -10 105 self)
			)
			(2
				(gCurRoom newRoom: 500)
				(self dispose:)
			)
		)
	)
)

(instance stellar of Prop
	(properties
		x 99
		y 107
		view 529
		signal 20513
		cycleSpeed 9
	)
)

(instance door of Prop
	(properties
		noun 3
		approachX 45
		approachY 105
		x 1
		y 42
		view 520
		loop 4
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(149 ; Crap_O_Matic
				(gGame handsOff:)
				(gCurRoom setScript: sEndCartoon)
			)
			(4 ; Do
				(if (== global120 1)
					(cond
						(local3
							(gMessager say: 2 4 12) ; "You realize your strength alone will be no match for the mechanized door."
						)
						(local4
							(gMessager say: 2 4 15) ; "You know, if you do what Sharpei asks, we might all get out of here a lot more quickly."
						)
						(else
							(= local4 1)
							(gMessager say: 2 4) ; "Mr. Wilco. Where DO you think you're going? I am sure my friend the Commander of StarCon intended for you to attend to me until otherwise ordered. I'd hate to have to tell him you were anything but committed to the task assigned and entrusted to you by your superiors."
						)
					)
				else
					(gCurRoom setScript: sRogerExits)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance monitors of Prop
	(properties
		x 255
		y 35
		z -13
		view 520
		loop 5
		signal 20513
		cycleSpeed 8
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance sharpei of Prop
	(properties
		noun 47
		x 272
		y 86
		priority 108
		fixPriority 1
		view 521
		loop 1
		signal 20513
		cycleSpeed 10
	)
)

(instance elevLights of Prop
	(properties
		noun 2
		approachX 45
		approachY 105
		x 37
		y 60
		view 520
		loop 6
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== global120 1)
					(cond
						(local3
							(gMessager say: 2 4 10) ; "Drats! It won't budge. I've got to get out of here somehow! No windows and the walls are solid bulkhead. And I'm too big to flush myself out of here. This is the only way. What would MacGyver do now?"
						)
						(local4
							(gMessager say: 2 4 15) ; "You know, if you do what Sharpei asks, we might all get out of here a lot more quickly."
						)
						(else
							(= local4 1)
							(gMessager say: 2 4) ; "Mr. Wilco. Where DO you think you're going? I am sure my friend the Commander of StarCon intended for you to attend to me until otherwise ordered. I'd hate to have to tell him you were anything but committed to the task assigned and entrusted to you by your superiors."
						)
					)
				else
					(gCurRoom setScript: sRogerExits)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gas of Prop
	(properties
		x 79
		y 22
		priority 102
		fixPriority 1
		view 526
		signal 20513
		cycleSpeed 7
	)
)

(instance cabinet of Prop
	(properties
		x 102
		y 38
		view 523
		signal 16417
	)
)

(instance bed of View
	(properties
		noun 32
		x 215
		y 84
		priority 107
		fixPriority 1
		view 520
		loop 1
		signal 20513
	)
)

(instance crapomatic of View
	(properties
		noun 33
		approachX 266
		approachY 119
		x 271
		y 107
		priority 109
		fixPriority 1
		view 520
		loop 2
		cel 1
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local3 1)
					(if (== (sDoTheMedsThing state:) 12)
						(= local6 (sDoTheMedsThing ticks:))
						(gCurRoom setScript: sGetCrapO)
					)
				else
					(gMessager say: 45 4) ; "While it looks like it might detach, you have no use for it. Don't be greedy."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bucket of View
	(properties
		noun 48
		x 78
		y 100
		view 520
		loop 3
		signal 20513
	)
)

(instance mop of View
	(properties
		noun 49
		approachX 95
		approachY 100
		x 67
		y 99
		priority 101
		fixPriority 1
		view 520
		loop 3
		cel 1
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local0
					(gCurRoom setScript: sDoTheMopThing)
				else
					(gMessager say: 49 4) ; "Yeah, you just can't get enough of that mopping action."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance medSupplies of Feature
	(properties
		noun 4
		sightAngle 40
		x 62
		y 89
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 70 93 52 93 54 88 58 88 58 82 64 82 64 88 70 88
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance medUnit of Feature
	(properties
		noun 5
		sightAngle 40
		x 58
		y 82
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 56 66 56 58 60 57 60 66 yourself:)
		)
		(super init: &rest)
	)
)

(instance redThing of Feature
	(properties
		noun 6
		sightAngle 40
		x 64
		y 82
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 61 67 61 60 66 60 66 67 yourself:)
		)
		(super init: &rest)
	)
)

(instance medStand of Feature
	(properties
		noun 7
		sightAngle 40
		x 62
		y 81
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 50 98 50 68 55 65 76 65 76 95 71 98
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance standHole of Feature
	(properties
		noun 1
		nsLeft 58
		nsTop 71
		nsRight 68
		nsBottom 82
		sightAngle 40
		x 63
		y 82
	)
)

(instance redTank of Feature
	(properties
		noun 8
		sightAngle 40
		x 84
		y 78
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 87 94 78 94 78 64 82 61 82 59 85 59 85 62 87 65
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance redLight of Feature
	(properties
		noun 9
		sightAngle 40
		x 87
		y 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 84 37 84 24 93 31 yourself:)
		)
		(super init: &rest)
	)
)

(instance vent of Feature
	(properties
		noun 10
		nsLeft 64
		nsTop 7
		nsRight 92
		nsBottom 23
		sightAngle 40
		x 79
		y 16
	)
)

(instance bathroom of Feature
	(properties
		noun 11
		sightAngle 40
		x 122
		y 29
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 153 89 95 89 101 39 119 39 119 25 136 31 150 41 158 49
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance cupboards of Feature
	(properties
		noun 13
		sightAngle 40
		x 108
		y 68
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 125 60 130 56 130 74 125 78 97 78 99 60
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sink of Feature
	(properties
		noun 12
		sightAngle 40
		x 109
		y 55
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 99 59 101 50 103 49 103 38 108 38 108 49 116 49 116 52 130 52 130 55 125 59
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance towel of Feature
	(properties
		noun 14
		sightAngle 40
		x 138
		y 56
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 129 50 129 47 146 47 146 50 143 50 143 63 132 63 132 50
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance toiletPaper of Feature
	(properties
		noun 15
		sightAngle 40
		x 155
		y 59
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 157 61 150 61 150 56 157 56
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance toilet of Feature
	(properties
		noun 16
		sightAngle 40
		approachX 148
		approachY 81
		x 153
		y 71
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 157 66 155 78 149 76 146 71 147 67 151 66
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local1
					(gCurRoom setScript: sDoTheToiletThing)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance medCabinet of Feature
	(properties
		noun 17
		sightAngle 40
		approachX 101
		approachY 82
		x 109
		y 32
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 112 23 118 25 118 38 102 38 104 23
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local2
					(gCurRoom setScript: sDoTheMedsThing)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bathDoor of Feature
	(properties
		noun 18
		sightAngle 40
		x 166
		y 78
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 175 91 154 90 156 71 158 50 166 60 170 69 173 80
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance chandelier of Feature
	(properties
		noun 19
		sightAngle 40
		x 167
		y 16
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 202 0 193 6 184 7 177 16 174 18 174 32 171 32 169 20 166 20 166 23 160 22 155 19 155 13 151 10 150 8 140 5 132 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance littleHole of Feature
	(properties
		noun 20
		nsLeft 182
		nsTop 43
		nsRight 189
		nsBottom 48
		sightAngle 40
		x 185
		y 45
	)
)

(instance outlet of Feature
	(properties
		noun 22
		nsLeft 185
		nsTop 78
		nsRight 190
		nsBottom 88
		sightAngle 40
		x 187
		y 83
	)
)

(instance waste of Feature
	(properties
		noun 23
		sightAngle 40
		x 209
		y 83
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 215 96 205 96 200 91 200 70 211 70 218 72 218 78 216 78 216 84 215 84
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bottles of Feature
	(properties
		noun 26
		sightAngle 40
		x 220
		y 60
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 223 65 218 65 215 62 215 55 225 55 225 62
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance machineStack of Feature
	(properties
		noun 27
		nsLeft 226
		nsTop 38
		nsRight 245
		nsBottom 65
		sightAngle 40
		x 235
		y 51
	)
)

(instance heartMonitor of Feature
	(properties
		noun 28
		nsLeft 247
		nsTop 45
		nsRight 275
		nsBottom 65
		sightAngle 40
		x 261
		y 55
	)
)

(instance pacman of Feature
	(properties
		noun 29
		nsLeft 253
		nsTop 35
		nsRight 269
		nsBottom 44
		sightAngle 40
		x 261
		y 39
	)
)

(instance veinJuicer of Feature
	(properties
		noun 30
		nsLeft 278
		nsTop 39
		nsRight 286
		nsBottom 79
		sightAngle 40
		x 282
		y 59
	)
)

(instance dresser of Feature
	(properties
		noun 31
		sightAngle 40
		x 243
		y 73
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 217 84 217 71 211 69 210 62 214 62 219 66 277 66 277 79 265 84
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance portHole of Feature
	(properties
		noun 24
		sightAngle 40
		x 247
		y 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 254 12 245 6 241 0 246 0 252 5
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance clearThing of Feature
	(properties
		noun 34
		sightAngle 40
		x 300
		y 55
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 295 47 295 34 300 31 306 34 306 47
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance scanner of Feature
	(properties
		noun 35
		sightAngle 40
		x 314
		y 55
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 51 310 49 310 41 319 43
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance headboard of Feature
	(properties
		noun 36
		sightAngle 40
		x 306
		y 54
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 62 294 55 294 46 309 46 319 49
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance middleCircle of Feature
	(properties
		noun 37
		sightAngle 40
		x 145
		y 113
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 178 113 178 113 159 118 134 119 114 116 112 112 120 109 134 107 154 107 172 109
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance doormat of Feature
	(properties
		noun 38
		sightAngle 40
		x 63
		y 110
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 105 103 115 11 115 36 105
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance yellowPanel of Feature
	(properties
		noun 39
		nsLeft 224
		nsTop 120
		nsRight 319
		nsBottom 138
		sightAngle 40
		x 271
		y 129
	)
)

(instance bluePanel of Feature
	(properties
		noun 40
		sightAngle 40
		x 175
		y 131
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 149 138 149 125 198 125 202 128 202 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance redPanel of Feature
	(properties
		noun 41
		sightAngle 40
		x 138
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 129 138 129 113 131 108 148 108 148 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance greenPanel of Feature
	(properties
		noun 42
		sightAngle 40
		x 91
		y 129
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 74 126 80 121 109 121 109 138 74 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tank1 of Feature
	(properties
		noun 43
		sightAngle 40
		x 14
		y 121
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 6 138 6 116 9 112 13 110 14 105 18 105 18 110 22 112 22 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tank2 of Feature
	(properties
		noun 44
		sightAngle 40
		x 31
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 23 138 23 114 26 111 29 110 30 108 34 108 35 111 40 115 40 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance sharpeiTalker of SmallTalker
	(properties
		talkView 522
		talkLoop 2
	)

	(method (init)
		(switch (gGame printLang:)
			(33
				(= name {Sharpie})
			)
			(else
				(= name {Sharpei})
			)
		)
		(= client sharpei)
		(if local7
			(= talkLoop 3)
		else
			(= talkLoop 2)
		)
		(super init:)
	)
)

(instance Stellar of SmallTalker
	(properties
		talkView 5290
		showTalk 0
	)

	(method (init)
		(= client stellar)
		(if local8
			(= showTalk 1)
		else
			(= showTalk 0)
		)
		(super init:)
	)
)

(instance sFX of Sound
	(properties
		number 52013
		loop -1
	)
)

(instance sFXBeam of Sound
	(properties
		number 923
	)
)

