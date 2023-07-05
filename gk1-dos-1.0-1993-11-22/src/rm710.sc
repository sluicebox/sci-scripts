;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 710)
(include sci.sh)
(use Main)
(use n013)
(use Inset)
(use PChase)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Rev)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm710 0
)

(local
	local0 = 6
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	[local21 26] = [0 0 5 1 8 0 10 1 1 0 8 0 9 1 7 1 3 0 1 1 6 1 4 0 12 1]
	[local47 6] = [143 137 45 136 99 127]
	[local53 48] = [85 1 22 0 25 3 108 4 37 2 32 0 240 4 269 2 0 5 228 5 59 3 32 0 32 0 31 4 159 5 168 3 83 2 95 1 178 3 8 4 178 1 229 2 42 5 13 4]
)

(class rm710 of Room
	(properties
		noun 1
		picture 710
		style 14
		exitStyle 13
		whichRoom 6
	)

	(method (init)
		(super init:)
		(gGkMusic1 setLoop: -1 number: 710 play:)
		(stuffArray doit:)
		(Load rsMESSAGE 710)
		(gGame handsOff:)
		(gEgo
			normalize: 0 901
			ignoreActors:
			state: 2
			init:
			posn: 10 131
			setMotion: PolyPath 30 131 self
		)
		(gCurRoom
			addObstacle:
				(= local10
					((Polygon new:)
						type: PContainedAccess
						init: 243 145 190 121 173 121 164 110 86 110 86 101 122 101 123 92 61 92 57 110 33 116 27 116 16 123 5 145
						yourself:
					)
				)
		)
		(= local20 0)
		(mural init:)
		(tileSpot init:)
		(exitNorth init:)
		(vine1 init:)
		(vine2 init:)
		(vineFeat1 init:)
		(vineFeat2 init:)
		(vineFeat3 init:)
		(aTile init: hide:)
		(secondTile init: hide:)
		(thirdTile init: hide:)
		(guard1 init:)
		(torch2 init: setCycle: Fwd)
		(setUpRoom doit:)
	)

	(method (doit)
		(super doit: &rest)
		(++ local18)
		(if (not local2)
			(if (not local3)
				(++ local6)
				(if (== local6 3000)
					(= local6 0)
					(if (not (gTalkers size:))
						(gMessager say: 14 0 11 (Random 1 3))
					)
				)
			)
			(cond
				((gEgo inRect: 52 95 90 109)
					(= local2 1)
					(self setScript: chgRooms 0 1)
				)
				((and (> (gEgo y:) 142) (< (gEgo x:) 150))
					(= local2 1)
					(self setScript: chgRooms 0 0)
				)
				((and (> (gEgo y:) 142) (!= (gEgo script:) wolfCartoon))
					(= local2 1)
					(self setScript: chgRooms 0 0)
				)
			)
		)
	)

	(method (cue)
		(if (< (gEgo x:) 20)
			(gCurRoom newRoom: 700)
		else
			(gGame handsOn:)
		)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 11) local3) ; Talk
			(if (!= local0 7)
				(gMessager say: 1 11 4) ; "Gabriel can't catch his breath long enough to call out for help!"
			else
				(gMessager say: 1 11 28) ; "Calling out for help won't solve anything!"
			)
			(return 1)
		)
	)

	(method (dispose)
		(DisposeScript 64969)
		(DisposeScript 64935)
		(DisposeScript 64930)
		(stuffProperties doit:)
		(gGkSound1 stop:)
		(gGkSound2 stop:)
		(super dispose:)
	)
)

(instance chgRooms of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gTheIconBar disable:)
				(if (gNarrator initialized:)
					(gNarrator dispose:)
				)
				(guard1 setScript: 0)
				(gGame handsOff:)
				(thirdTile hide:)
				(secondTile hide:)
				(aTile hide:)
				(= local7 local0)
				(gCurRoom drawPic: 710 270)
				(cond
					((== register 99)
						(UnLoad 128 714)
						(= local0 7)
						(= cycles 1)
					)
					(register
						(if (> (++ local0) 12)
							(= local0 1)
						)
						(gEgo posn: 72 155 setMotion: MoveTo 75 142 self)
					)
					(else
						(if (not (-- local0))
							(= local0 12)
							(if local3
								(= register 999)
							)
						)
						(gEgo posn: 72 107 setMotion: MoveTo 75 113 self)
					)
				)
				(setUpRoom doit:)
				(rm710 whichRoom: local0)
			)
			(1
				(if (and local3 (== local7 3) (not local8))
					(= local8 1)
				)
				(if (and (!= register 99) (!= register 999))
					(gGame handsOn:)
				)
				(= register 0)
				(gTheIconBar enable:)
				(= local2 0)
			)
		)
	)
)

(instance keyWorks of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 190 132 self)
			)
			(1
				(gMessager say: 12 76 14 1) ; "!!!Blank msg"
				(gEgo setCel: 0 setLoop: 0 1 view: 7131 setCycle: End self)
			)
			(2
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(gMessager say: 12 76 14 2 self) ; "From somewhere off in the mound, Gabriel hears a soft click, then a rumble!"
				(gEgo getPoints: -999 5)
				(gEgo setCycle: Beg)
				(gGkSound2 number: 714 setLoop: 1 play:)
			)
			(3
				(ShakeScreen 5)
				(= cycles 10)
			)
			(4
				(= cycles 2)
			)
			(5
				(gEgo normalize: 0 901 posn: 186 130 ignoreActors:)
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(gMessager sayRange: 12 76 14 3 4 self) ; "(TO HIMSELF. HE'S JUST STARTED A MINOR TREMOR)Uh-oh!"
			)
			(6
				(= local3 1)
				(gGame handsOn:)
				(guard1 cycleSpeed: 20 setCycle: End self)
			)
			(7
				((gCurRoom obstacles:) delete: local9)
				(local9 dispose:)
				(guard1
					setCel: 0
					setLoop: 0
					view: 709
					setSpeed: 12
					setLoop: -1
					setLooper: Grooper
					setCycle: StopWalk -1
					setMotion: PChase gEgo 15 self
				)
			)
			(8
				(if (!= (gCurRoom script:) aDeathScript)
					(gCurRoom setScript: aDeathScript)
				)
			)
		)
	)
)

(instance vineSwing of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo getPoints: -999 2)
				(gEgo setMotion: PolyPath 94 125 self)
			)
			(1
				(= local15 1)
				(gEgo
					setCel: 0
					setLoop: 0 1
					view: 714
					setCycle: CT 11 1 self
				)
				(guard1 setMotion: 0)
				(gMessager say: 7 8 16 1) ; "(TO HIMSELF. ABOUT TO SWING ON A VINE TO KNOCK OVER A MONSTER)I can't believe I'm doing this!"
			)
			(2
				(gGkSound2 stop: setLoop: 1 number: 722 play:)
				(gEgo setCycle: End self)
				(gMessager say: 7 8 16 2) ; "(VINE BREAKS AND GABRIEL FALLS THROUGH OPEN DOOR)Whoa!"
			)
			(3
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(self cue:)
			)
			(4
				(= local2 1)
				(gCurRoom setScript: chgRooms 0 99)
			)
		)
	)
)

(instance rightWay of Script
	(properties)

	(method (doit)
		(if
			(and
				local3
				(== local0 6)
				(or
					(< (gEgo distanceTo: guard3) 20)
					(< (gEgo distanceTo: guard2) 20)
				)
				(not local15)
				(!= (gCurRoom script:) aDeathScript)
			)
			(gCurRoom setScript: aDeathScript)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(guard1 ignoreActors:)
				(switch local0
					(4
						(guard1 posn: 118 122)
					)
					(5
						(guard1 posn: 63 111)
					)
					(6
						(guard1 posn: 214 135)
						(guard2
							ignoreActors:
							setCel: 2
							setLoop: 8
							init:
							posn: 76 108
						)
						(guard3
							setCel: 0
							setLoop: 4
							ignoreActors:
							init:
							posn: 15 121
						)
						(gMessager say: 14 0 18) ; "!!!blank msg"
					)
					(8
						(= register 1)
					)
				)
				(= cycles 4)
			)
			(1
				(if (and register (!= (gCurRoom script:) aDeathScript))
					(gCurRoom setScript: aDeathScript)
				)
				(guard1 setMotion: PChase gEgo 15 self)
			)
			(2
				(if (and (not local20) (!= (gCurRoom script:) aDeathScript))
					(gCurRoom setScript: aDeathScript)
				)
			)
		)
	)
)

(instance aDeathScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= temp1
					(if (gCast contains: guard1)
						(guard1 distanceTo: gEgo)
					else
						10000
					)
				)
				(= temp2
					(if (gCast contains: guard2)
						(guard2 distanceTo: gEgo)
					else
						10000
					)
				)
				(= temp3
					(if (gCast contains: guard3)
						(guard3 distanceTo: gEgo)
					else
						10000
					)
				)
				(= register
					(cond
						((and (<= temp1 temp2) (<= temp1 temp3)) guard1)
						((and (<= temp2 temp1) (<= temp2 temp3)) guard2)
						((and (<= temp3 temp1) (<= temp3 temp2)) guard3)
					)
				)
				(= temp0 (register heading:))
				(= state
					(cond
						((<= 30 temp0 120) 4)
						((<= 120 temp0 240) 7)
						((<= 240 temp0 300) 1)
						(else 10)
					)
				)
				(-- state)
				(Face register gEgo self)
			)
			(1
				(gEgo setHeading: 135 self)
				(register
					setMotion: MoveTo (+ (gEgo x:) 9) (gEgo y:) self
				)
			)
			(2 0)
			(3
				(= state 12)
				(register hide:)
				(gEgo
					view: 740
					cel: 0
					loop: 1
					setSpeed: 10
					setCycle: End self
				)
			)
			(4
				(gEgo setHeading: 225 self)
				(register
					setMotion: MoveTo (- (gEgo x:) 9) (gEgo y:) self
				)
			)
			(5 0)
			(6
				(= state 12)
				(register hide:)
				(gEgo
					view: 740
					cel: 0
					loop: 0
					setSpeed: 10
					setCycle: End self
				)
			)
			(7
				(gEgo setHeading: 315 self)
				(register
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 6) self
				)
			)
			(8 0)
			(9
				(= state 12)
				(register hide:)
				(gEgo
					view: 740
					cel: 0
					loop: 2
					setSpeed: 10
					setCycle: End self
				)
			)
			(10
				(gEgo setHeading: 135 self)
				(register
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 6) self
				)
			)
			(11 1)
			(12
				(= state 12)
				(register hide:)
				(gEgo
					view: 741
					cel: 0
					loop: 0
					setSpeed: 10
					setCycle: End self
				)
			)
			(13
				(gGkMusic1 stop: number: 901 setLoop: 1 play:)
				(gMessager say: 14 0 15 0 self) ; "One of the mummies reaches Gabriel!"
			)
			(14
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(instance flinch of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register (Random 0 1))
				(switch register
					(0
						(guard3
							setCel: 0
							setLoop: 3
							view: 7092
							setCycle: 0
							setCycle: End self
						)
					)
					(1
						(guard1
							setCel: 1
							setLoop: 1
							view: 7092
							setCycle: 0
							setCycle: End self
						)
					)
				)
				(guard2
					setCel: 0
					setLoop: 0
					view: 7092
					setCycle: 0
					setCycle: End self
				)
			)
			(1 1)
			(2
				(= state -1)
				(switch register
					(0
						(guard3
							setCel: 0
							setLoop: 3
							view: 7091
							setCycle: 0
							setCycle: End
						)
					)
					(1
						(guard1
							setCel: 1
							setLoop: 1
							view: 7091
							setCycle: 0
							setCycle: End
						)
					)
				)
				(guard2
					setCel: 0
					setLoop: 0
					view: 7092
					setCycle: 0
					setCycle: End self
				)
			)
		)
	)
)

(instance wolfCartoon of Script
	(properties)

	(method (handleEvent event)
		(= seconds 1)
		(event claimed: 1)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= cycles 8)
				(= local13 1)
				(thirdTile hide:)
				(secondTile hide:)
				(aTile hide:)
				(gGame handsOff:)
				(passage init:)
				(passageKeyHole init:)
				(mural y: 1)
				(tileSpot y: 1)
				(client
					fixPriority: 1
					setPri: 190
					setCel: 0
					setLoop: 0
					view: 715
					posn: 189 144
					setCycle: 0
				)
				(guard1
					setCel: 0
					setLoop: 5
					view: 709
					x: 243
					y: 125
					ignoreActors:
					setPri: 3
					setCycle: StopWalk -1
					setLoop: -1
					setLooper: Grooper
					setSpeed: 14
					setMotion: PolyPath 230 131 guard1
				)
				(guard2
					setCel: 0
					setLoop: 2
					view: 709
					x: 73
					y: 104
					ignoreActors:
					setCycle: StopWalk -1
					setLoop: -1
					setLooper: Grooper
					setSpeed: 14
					setMotion: PolyPath 74 121 guard2
				)
				(guard3
					setCel: 0
					setLoop: 0
					view: 7141
					x: 77
					y: 141
					ignoreActors:
					init:
					cycleSpeed: 12
				)
			)
			(1
				(gMessager say: 14 0 20 1) ; "(FALLS INTO ROOM WITH 3 MONSTERS. TO HIMSELF)Oh, shit!"
				(guard3 setCycle: End)
				(client setCycle: End self)
			)
			(2
				(client setCel: 0 setLoop: 1 setCycle: End self)
			)
			(3
				(guard3
					setCel: 0
					setLoop: -1
					view: 709
					setCycle: StopWalk -1
					setLooper: Grooper
					setSpeed: 12
					setMotion: PolyPath 117 144 guard3
				)
				(gGkMusic1 stop: setLoop: -1 number: 720 play:)
				(wolfGang init: cycleSpeed: 6 setCycle: End self)
				(client setCel: 0 setLoop: 2 cycleSpeed: 6 setCycle: End self)
			)
			(4
				(gGkSound2 stop: number: 719 setLoop: 1 play:)
				(if (not (client cycler:))
					(client setCel: 0 setLoop: 3 setCycle: End)
				)
				(guard1 setMotion: PolyPath 230 131 guard1)
			)
			(5
				(if (not (client cycler:))
					(client setCel: 0 setLoop: 3 setCycle: End)
				)
				(wolfGang setCel: 0 setLoop: 0 view: 7161 setCycle: End self)
			)
			(6
				(wolfGang setCel: 0 setLoop: 1 setCycle: End self)
			)
			(7
				(UnLoad 128 7161)
				(wolfGang setCel: 0 setLoop: 0 view: 7162 setCycle: CT 5 1 self)
				(gGkSound2 stop: setLoop: 1 number: 724 play:)
			)
			(8
				(wolfGang setCycle: End self)
				(torch2 dispose:)
			)
			(9
				(UnLoad 128 7162)
				(wolfGang setCel: 0 setLoop: 0 view: 717 setCycle: CT 5 1 self)
				(gGkSound2 stop: setLoop: 1 number: 724 play:)
			)
			(10
				(guard1 setMotion: PolyPath 175 131 guard1)
				(= ticks 20)
			)
			(11
				(gMessager say: 14 0 20 2) ; "(WOLFGANG COMES SWINGING INTO THE ROOM ON A VINE TO RESCUE GABRIEL. THIS IS THEIR FIRST FACE-TO-FACE MEETING.)Gabriel Knight, I presume?"
				(wolfGang setCycle: End self)
			)
			(12
				(if (>= (gGame detailLevel:) 2)
					(guard1 setLoop: 1 setMotion: PolyPath 168 123)
				)
				(wolfGang setCel: 0 setLoop: 1 setCycle: CT 4 1 self)
				(gGkSound2 stop: setLoop: 1 number: 724 play:)
			)
			(13
				(guard2 setLoop: 0 setMotion: PolyPath 88 121)
				(if (>= (gGame detailLevel:) 2)
					(guard1
						setLoop: 1
						setCycle: Rev
						setMotion: PolyPath 173 129 guard1
					)
				)
				(= ticks 20)
			)
			(14
				(wolfGang setCycle: End self)
			)
			(15
				(if (>= (gGame detailLevel:) 2)
					(guard3 setLoop: 3 1 setMotion: PolyPath 117 135)
				)
				(wolfGang setCel: 0 setLoop: 2 setCycle: CT 3 1 self)
			)
			(16
				(if (>= (gGame detailLevel:) 2)
					(guard3
						setLoop: 3 1
						setCycle: Rev
						setMotion: PolyPath 117 140 guard3
					)
				)
				(= ticks 20)
			)
			(17
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(gMessager say: 14 0 20 3) ; "(SURPRISED & RELIEVED)Uncle Wolfgang?"
				(if (>= (gGame detailLevel:) 2)
					(guard2 setLoop: 0 setMotion: PolyPath 90 121)
				)
				(UnLoad 128 717)
				(gGkSound2 stop: setLoop: 1 number: 724 play:)
				(wolfGang setCel: 0 setLoop: 0 view: 718 setCycle: CT 4 1 self)
			)
			(18
				(if (>= (gGame detailLevel:) 2)
					(guard2
						setLoop: 0
						setCycle: Rev
						setMotion: PolyPath 87 121 guard2
					)
				)
				(= ticks 20)
			)
			(19
				(wolfGang setCycle: End self)
			)
			(20
				(gGkSound2 stop: setLoop: 1 number: 724 play:)
				(if (>= (gGame detailLevel:) 2)
					(guard3 setLoop: 3 1 setMotion: PolyPath 117 138)
				)
				(wolfGang setCel: 0 setLoop: 0 view: 7171 setCycle: CT 3 1 self)
			)
			(21
				(if (>= (gGame detailLevel:) 2)
					(guard3
						setLoop: 3 1
						setCycle: Rev
						setMotion: PolyPath 117 142 guard3
					)
				)
				(= ticks 20)
			)
			(22
				(wolfGang setCycle: End self)
			)
			(23
				(wolfGang
					setCel: 0
					setLoop: 1
					view: 7171
					cycleSpeed: 14
					setCycle: End self
				)
				(if (>= (gGame detailLevel:) 2)
					(guard1 setMotion: PolyPath 165 131 guard1)
				)
			)
			(24
				(gGkSound2 stop: setLoop: -1 number: 724 play:)
				(wolfGang setLoop: 2 setCel: 0 setCycle: RandCycle)
				(= ticks 100)
			)
			(25
				(if (>= (gGame detailLevel:) 2)
					(guard1 setScript: flinch)
				)
				(gMessager sayRange: 14 0 20 4 5 self) ; "(URGENT--NO TIME TO WASTE)In person! Now go to it, Boy; I can't hold these creatures for very long, and there are more on the way!"
			)
			(26
				(gEgo normalize: 8 901 ignoreActors: posn: 230 143)
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(wolfGang
					view: 718
					setLoop: 0
					setCel: 0
					cycleSpeed: 15
					setCycle: Fwd
				)
				(gMessager say: 14 0 20 6 self) ; "(URGENT, URGING)The secret panel, Boy! These creatures are only alive while it's open. Close it, Gabriel, and hurry!"
			)
			(27
				(= seconds 20)
			)
			(28
				(UnLoad 128 717)
				(UnLoad 128 718)
				(if (not local11)
					(gGame handsOff:)
					(= local12 1)
					(guard1 setScript: 0)
					(wolfGang dispose:)
					(guard2
						setSpeed: 6
						view: 742
						setLoop: 0 1
						setCel: 0
						setCycle: CT 4 1 self
					)
				)
			)
			(29
				(guard2 setCycle: End)
				(guard3
					view: 709
					setSpeed: 2
					setLoop: -1
					setLooper: Grooper
					setCycle: StopWalk -1
					setMotion: PolyPath 213 143 self
				)
			)
			(30
				(gGkMusic1 stop: number: 901 setLoop: 1 play:)
				(gMessager say: 14 0 27) ; "(WATCHING GABRIEL DIE)Gabriel, no!"
				(guard3
					view: 740
					setSpeed: 10
					posn: 233 143
					setLoop: 0 1
					setCel: 0
					setCycle: End self
				)
				(UpdateScreenItem guard3)
				(gEgo hide:)
			)
			(31
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(instance goToCeremony of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== state 6)
				(== (wolfGang cel:) 6)
				(not (gCast contains: groundTorch))
			)
			(groundTorch init: setCycle: Fwd)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo getPoints: -999 2)
				(gEgo setCel: 0 setLoop: 0 view: 719 setCycle: End self)
			)
			(1
				(gMessager say: 15 76 0 1 self) ; "(GABE FINDS MECHANISM FOR LOWERING SECRET DOOR. EXCITED)I think I found something!"
				(gEgo
					setCel: 0
					setLoop: 2
					view: 719
					posn: 233 130
					fixPriority: 1
					setPri: 59
					setCycle: End self
				)
			)
			(2 1)
			(3
				(gGkSound2 number: 715 setLoop: 1 play:)
				(secretDoor cycleSpeed: 35 setPri: 190 setCycle: CT 8 -1)
				(gEgo setLoop: 1 setCel: 0 cycleSpeed: 4 setCycle: End self)
				(gMessager say: 15 76 0 2 self) ; "(BREATHLESS--HAS BEEN FIGHTING MONSTERS. EXCITED)Very good, Gabriel! Now stand back!"
			)
			(4 1)
			(5
				(wolfGang view: 7171 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(6
				(secretDoor cycleSpeed: 35 setCycle: Beg self)
				(wolfGang
					view: 718
					setLoop: 1
					setCel: 0
					posn: 171 113
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(7 1)
			(8
				(guard1 setScript: 0 setMotion: 0 setCycle: 0)
				(guard2 setMotion: 0 setCycle: 0)
				(guard3 setMotion: 0 setCycle: 0)
				(= seconds 5)
			)
			(9
				(gCurRoom newRoom: 720)
			)
		)
	)
)

(instance wrongWay of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(guard1 ignoreActors:)
				(switch local0
					(2
						(guard1 setCel: 0 setLoop: 3 view: 709 posn: 182 138)
						(= seconds 4)
					)
					(1
						(guard1 setCel: 0 setLoop: 3 view: 709 posn: 156 136)
						(= seconds 3)
					)
					(else
						(guard1 setCel: 0 setLoop: 3 view: 709 posn: 78 127)
						(gGame handsOff:)
					)
				)
				(guard1
					setCycle: 0
					setLoop: -1
					setLooper: Grooper
					setCycle: StopWalk -1
					setMotion: PChase gEgo 15 self
				)
			)
			(1
				(cond
					(
						(or
							(not (guard1 mover:))
							(and (> local0 2) (not (guard2 mover:)))
						)
						(if (!= (gCurRoom script:) aDeathScript)
							(gCurRoom setScript: aDeathScript)
						)
					)
					((<= local0 2)
						(guard2
							setCel: 0
							setLoop: 3
							view: 709
							setCycle: StopWalk -1
							ignoreActors:
							init:
							posn: 106 100
							setLoop: -1
							setLooper: Grooper
							setMotion: PolyPath 78 105 self
						)
					)
					(else
						(= ticks 10)
					)
				)
			)
			(2
				(cond
					(
						(or
							(not (guard1 mover:))
							(and (> local0 2) (not (guard2 mover:)))
						)
						(if (!= (gCurRoom script:) aDeathScript)
							(gCurRoom setScript: aDeathScript)
						)
					)
					((and (gCast contains: guard2) (<= local0 2))
						(guard2 setMotion: PChase gEgo 15 self)
					)
				)
				(= seconds 10)
			)
			(3
				(if (not (and (guard1 mover:) (guard2 mover:)))
					(if (!= (gCurRoom script:) aDeathScript)
						(gCurRoom setScript: aDeathScript)
					)
				else
					(guard3
						setCel: 0
						setLoop: 3
						view: 709
						setCycle: StopWalk -1
						ignoreActors:
						setLoop: -1
						setLooper: Grooper
						init:
						posn: 106 100
						setMotion: PolyPath 78 105 self
					)
				)
			)
			(4
				(cond
					((not (and (guard1 mover:) (guard2 mover:)))
						(if (!= (gCurRoom script:) aDeathScript)
							(gCurRoom setScript: aDeathScript)
						)
					)
					((and (!= local0 12) (gCast contains: guard3))
						(guard3 setMotion: PChase gEgo 15 self)
					)
				)
			)
			(5
				(if (!= (gCurRoom script:) aDeathScript)
					(gCurRoom setScript: aDeathScript)
				)
			)
		)
	)
)

(instance backTrack of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (< (gEgo y:) 150)
					(guard1
						setCel: 0
						setLoop: 3
						view: 709
						posn: 55 113
						setMotion: MoveTo 70 113 self
					)
				else
					(guard1
						setCel: 0
						setLoop: 3
						view: 709
						posn: 75 130
						setMotion: MoveTo 75 137 self
					)
				)
			)
			(1
				(if (!= (gCurRoom script:) aDeathScript)
					(gCurRoom setScript: aDeathScript)
				)
			)
		)
	)
)

(instance tryKeyOnHole of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 191 130 self)
			)
			(1
				(gEgo view: 7131 setLoop: 0 setCel: 0 setCycle: End self)
				(gMessager say: 5 76 0 1) ; "(SPEAKING TO HIMSELF. THOUGHTFUL)The head of this snake rod fits perfectly into these quarter-sized holes in the wall."
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo
					normalize: 0 901
					posn: (- (gEgo x:) 3) (- (gEgo y:) 2)
					ignoreActors:
				)
				(= cycles 2)
			)
			(4
				(gGame handsOn:)
				(gMessager say: 5 76 0 2) ; "(DISAPPOINTED)Doesn't seem to do anything, though."
			)
		)
	)
)

(instance tryKeyOnTile of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 191 130 self)
			)
			(1
				(gEgo view: 7131 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(if (not local19)
					(gMessager say: 12 76 12 1 self) ; "(TO HIMSELF. THOUGHTFUL)The rod fits into the hole in the stone."
				else
					(self cue:)
				)
				(gEgo setCycle: Beg self)
			)
			(3 1)
			(4
				(gEgo normalize: 0 901)
				(gEgo ignoreActors:)
				(if (not local19)
					(if (gTalkers size:)
						(gMessager cue: 1)
					)
					(gMessager say: 12 76 12 2 self) ; "(TO HIMSELF. NEUTRAL)Nothing happens."
				else
					(self cue:)
				)
			)
			(5
				(= local19 1)
				(gGame handsOn:)
			)
		)
	)
)

(instance getRod of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 115 119 self)
			)
			(1
				(gEgo view: 713 setLoop: 1 setCel: 0 setCycle: CT 6 1 self)
			)
			(2
				(gGkSound2 number: 713 setLoop: 1 play:)
				(gMessager say: 11 12 0) ; "(PICKING UP AN ANCIENT ROD)It's shaped a little like a snake."
				(gEgo get: 60 getPoints: -999 1) ; rod
				(register dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo normalize: 0 901)
				(gEgo ignoreActors:)
				(UnLoad 128 713)
				(gGame handsOn:)
			)
		)
	)
)

(instance getTile of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= local5 1)
				(cond
					((not register)
						(gEgo setMotion: PolyPath 190 131 self)
					)
					([local21 (+ (* (register cel:) 2) 1)]
						(= local5 99)
						(gEgo setMotion: PolyPath 190 131 self)
					)
					((< (gEgo x:) (register x:))
						(gEgo
							setMotion:
								PolyPath
								(- (register x:) 43)
								(register y:)
								self
						)
					)
					(else
						(= local5 0)
						(gEgo
							setMotion:
								PolyPath
								(+ (register x:) 43)
								(register y:)
								self
						)
					)
				)
			)
			(1
				(cond
					((not register)
						(gEgo
							view: 7121
							setLoop: 2
							setCel: 0
							setCycle: End self
						)
					)
					((== local5 99)
						(gEgo
							view: 7121
							setLoop: 1
							setCel: 0
							setCycle: CT 5 1 self
						)
						(if (not local4)
							(= local4 1)
							(gMessager say: 12 12 9) ; "(PICKING UP STONE TILE. THOUGHTFUL)This stone looks interesting."
						)
					)
					(else
						(gEgo
							view: 712
							setLoop: (if local5 0 else 1)
							setCel: 0
							setCycle: CT 8 1 self
						)
						(if (not local4)
							(= local4 1)
							(gMessager say: 12 12 9) ; "(PICKING UP STONE TILE. THOUGHTFUL)This stone looks interesting."
						)
					)
				)
			)
			(2
				(gGkSound2 stop: number: 708 setLoop: 1 play:)
				(if (not register)
					(gEgo setCycle: Beg self)
				else
					(register hide:)
					(if (mod (= temp0 (register cel:)) 2)
						(= temp1 (- temp0 1))
					else
						(= temp1 (+ temp0 1))
					)
					(if (== temp0 1)
						(= temp1 1)
					)
					(gEgo get: (+ 48 temp1) setCycle: End self)
				)
			)
			(3
				(gGkSound2 stop:)
				(if (not register)
					(gMessager say: 12 12 10) ; "(TRYING TO PULL A STONE TILE OFF THE WALL IN SNAKE MOUND. THOUGHTFUL)Hmmm. It's stuck."
				else
					(= temp0 (register cel:))
					(= [local21 (* temp0 2)] 99)
					(= [local21 (+ (* temp0 2) 1)] 99)
				)
				(UnLoad 128 712)
				(UnLoad 128 7121)
				(gEgo normalize: (if local5 0 else 1) 901)
				(gEgo ignoreActors:)
				(gGame handsOn:)
			)
		)
	)
)

(instance lookAtTile of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 190 131 self)
			)
			(1
				(gMessager say: 12 7 8 0 self) ; "An etched stone is on the wall."
			)
			(2
				(gEgo setCel: 0 setLoop: 0 view: 7121 setCycle: End self)
			)
			(3
				(gGame handsOn:)
				(gTheIconBar disable: 0 1 2 4 6 7 8 9 12)
				(tileInset init: self rm710 register)
			)
			(4
				(gTheIconBar enable: 0 1 2 4 6 7 8 9 12)
				(gEgo normalize: 0 901)
				(gEgo ignoreActors:)
				(self dispose:)
			)
		)
	)
)

(instance wolfGang of Actor
	(properties
		noun 9
		sightAngle 30
		x 120
		y 114
		view 716
		illegalBits 0
	)
)

(instance guard1 of Actor
	(properties
		noun 6
		sightAngle 40
		x 231
		y 142
		view 709
		illegalBits 0
	)

	(method (doit)
		(if (and (not local13) local3 (!= moveSpeed (gEgo moveSpeed:)))
			(self setSpeed: (+ (gEgo moveSpeed:) 15))
		)
		(super doit: &rest)
	)

	(method (init)
		(|= signal $1000)
		(super init:)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 89 90 91 92 93 94 95 96 97 98 99) ; tile1, tile2, tile3, tile4, tile5, tile6, ???, tile8, tile9, tile10, tile11
			(= theVerb 88) ; tile
		)
		(if local3
			(= temp0 4)
		else
			(= temp0 3)
		)
		(cond
			((== theVerb 9) ; Move
				(if local3
					(if (== local0 6)
						(gMessager say: 6 9 26) ; "Gabriel doesn't have enough momentum to move that guard on his own!"
					else
						(gMessager say: 6 9 4) ; "(ANXIOUS)Gabriel doesn't need to get any closer to that mummy!"
					)
				else
					(gMessager say: 6 9 3) ; "Gabriel would rather not mess with that mummy."
				)
			)
			((OneOf theVerb 10 7 12 11) ; Ask, Look, Pickup, Talk
				(if (and (== theVerb 7) local3 (== local0 7)) ; Look
					(gMessager say: 6 7 30) ; "(ANXIOUS)Gabriel doesn't need to get any closer to that mummy!"
				else
					(gMessager say: 6 theVerb temp0)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(self
			setPri: -1
			setLoop: -1
			setCycle: 0
			setCycle: StopWalk -1
			setLooper: Grooper
		)
		(Face self wolfGang)
	)
)

(instance guard2 of Actor
	(properties
		noun 6
		sightAngle 40
		x 231
		y 142
		view 709
		illegalBits 0
	)

	(method (doit)
		(if (and (not local13) (!= moveSpeed (gEgo moveSpeed:)))
			(self setSpeed: (+ (gEgo moveSpeed:) 15))
		)
		(super doit: &rest)
	)

	(method (init)
		(|= signal $1000)
		(super init:)
	)

	(method (doVerb theVerb)
		(guard1 doVerb: theVerb &rest)
	)

	(method (cue)
		(self setLoop: -1 setCycle: 0 setCycle: StopWalk -1 setLooper: Grooper)
		(Face self wolfGang)
	)
)

(instance guard3 of Actor
	(properties
		noun 6
		sightAngle 40
		x 231
		y 142
		view 709
		illegalBits 0
	)

	(method (doit)
		(if (and (not local13) (!= moveSpeed (gEgo moveSpeed:)))
			(self setSpeed: (+ (gEgo moveSpeed:) 15))
		)
		(super doit: &rest)
	)

	(method (init)
		(|= signal $1000)
		(super init:)
	)

	(method (doVerb theVerb)
		(guard1 doVerb: theVerb &rest)
	)

	(method (cue)
		(self setLoop: -1 setCycle: 0 setCycle: StopWalk -1 setLooper: Grooper)
		(Face self wolfGang)
	)
)

(instance groundTorch of Prop
	(properties
		x 88
		y 111
		view 718
		loop 2
	)
)

(instance secretDoor of Prop
	(properties
		noun 8
		sightAngle 40
		x 198
		y 58
		view 711
		loop 1
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 89 90 91 92 93 94 95 96 97 98 99) ; tile1, tile2, tile3, tile4, tile5, tile6, ???, tile8, tile9, tile10, tile11
			(= theVerb 88) ; tile
		)
		(if (and (not (OneOf theVerb 8 6 9 7 13)) (!= theVerb 76)) ; Operate, Open, Move, Look, Walk, rod
			(= theVerb 0)
		)
		(if local3
			(= temp0 7)
		else
			(= temp0 6)
		)
		(gMessager say: 8 theVerb temp0)
		(return 1)
	)
)

(instance torch1 of Prop
	(properties
		noun 4
		sightAngle 40
		x 29
		y 67
		view 7102
		detailLevel 2
	)

	(method (doVerb theVerb)
		(torch2 doVerb: theVerb &rest)
	)
)

(instance torch2 of Prop
	(properties
		noun 4
		sightAngle 40
		x 176
		y 67
		view 7102
		loop 1
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 89 90 91 92 93 94 95 96 97 98 99) ; tile1, tile2, tile3, tile4, tile5, tile6, ???, tile8, tile9, tile10, tile11
			(= theVerb 88) ; tile
		)
		(if (== theVerb 12) ; Pickup
			(if local3
				(gMessager say: 4 12 4) ; "By the time Gabriel managed to get down that torch, it would be too late!"
			else
				(gMessager say: 4 12 3) ; "There's no reason to do that with the torches."
			)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance passage of View
	(properties
		noun 15
		sightAngle 40
		x 198
		y 58
		view 711
		cel 1
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 89 90 91 92 93 94 95 96 97 98 99) ; tile1, tile2, tile3, tile4, tile5, tile6, ???, tile8, tile9, tile10, tile11
			(= theVerb 88) ; tile
		)
		(super doVerb: theVerb &rest)
	)
)

(instance doorFrame of View
	(properties
		noun 8
		sightAngle 40
		x 198
		y 58
		view 711
	)

	(method (doVerb theVerb)
		(secretDoor doVerb: theVerb &rest)
	)
)

(instance outsideDoor of View
	(properties
		noun 10
		sightAngle 40
		y 41
		priority 110
		fixPriority 1
		view 702
	)

	(method (init)
		(super init:)
		(gWalkHandler add: self)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 89 90 91 92 93 94 95 96 97 98 99) ; tile1, tile2, tile3, tile4, tile5, tile6, ???, tile8, tile9, tile10, tile11
			(= theVerb 88) ; tile
		)
		(if local3
			(= temp0 4)
		else
			(= temp0 3)
		)
		(cond
			((== theVerb 13) ; Walk
				(if local3
					(gMessager say: 10 13 4) ; "The exit is blocked, and there's no time to try to unblock it!"
				else
					(gEgo setMotion: MoveTo 10 131 gCurRoom)
				)
				(return 1)
			)
			((OneOf theVerb 8 6 9 7 13) ; Operate, Open, Move, Look, Walk
				(gMessager say: 10 theVerb temp0)
				(return 1)
			)
			(else
				(gMessager say: 10 0 temp0)
				(return 1)
			)
		)
	)
)

(instance aTile of View
	(properties
		noun 12
		sightAngle 40
		x 217
		y 98
		view 710
		cel 10
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(if (OneOf theVerb 89 90 91 92 93 94 95 96 97 98 99) ; tile1, tile2, tile3, tile4, tile5, tile6, ???, tile8, tile9, tile10, tile11
			(= theVerb 88) ; tile
		)
		(= temp0 cel)
		(if (OneOf theVerb 7 6 8) ; Look, Open, Operate
			(if (not local3)
				(if [local21 (+ (* temp0 2) 1)]
					(if (== theVerb 7) ; Look
						(gEgo setScript: lookAtTile 0 temp0)
					else
						(gMessager say: 12 theVerb 8)
					)
				else
					(gMessager say: 12 theVerb 5)
				)
			else
				(gMessager say: 12 theVerb 4)
			)
			(return 1)
		else
			(switch theVerb
				(12 ; Pickup
					(cond
						(local3
							(gMessager say: 12 12 4) ; "It's too late to do anything more with the stones now!"
						)
						((or (== temp0 12) (== temp0 7))
							(gGame handsOff:)
							(gCurRoom setScript: getTile 0 0)
						)
						(else
							(if (mod temp0 2)
								(= temp1 (- temp0 1))
							else
								(= temp1 (+ temp0 1))
							)
							(if (== temp0 1)
								(= temp1 1)
							)
							(gEgo get: (+ 48 temp1))
							(gGame handsOff:)
							(Load rsVIEW 712)
							(Load rsVIEW 7121)
							(gCurRoom setScript: getTile 0 self)
						)
					)
					(return 1)
				)
				(9 ; Move
					(if (not local3)
						(gMessager say: 12 9 0) ; "If Gabriel wants to relocate that tile, he's going to have to take it first."
					else
						(gMessager say: 12 9 4) ; "It's too late to do anything more with the stones now!"
					)
					(return 1)
				)
				(76 ; rod
					(rodCode doit: temp0)
					(return 1)
				)
				(88 ; tile
					(if [local21 (+ (* cel 2) 1)]
						(gMessager say: 12 88 8) ; "There's already a stone in that spot on the wall."
					else
						(gMessager say: 12 88 5) ; "Putting the stones together on the floor doesn't seem right."
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance secondTile of View
	(properties
		noun 12
		sightAngle 40
		x 217
		y 98
		view 710
		cel 10
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(= temp0 cel)
		(switch theVerb
			(12 ; Pickup
				(cond
					(local3
						(gMessager say: 12 12 4) ; "It's too late to do anything more with the stones now!"
					)
					((or (== temp0 12) (== temp0 7))
						(gMessager say: 12 12 10) ; "(TRYING TO PULL A STONE TILE OFF THE WALL IN SNAKE MOUND. THOUGHTFUL)Hmmm. It's stuck."
					)
					(else
						(if (mod temp0 2)
							(= temp1 (- temp0 1))
						else
							(= temp1 (+ temp0 1))
						)
						(if (== temp0 1)
							(= temp1 1)
						)
						(gEgo get: (+ 48 temp1))
						(gGame handsOff:)
						(gCurRoom setScript: getTile 0 self)
					)
				)
				(return 1)
			)
			(76 ; rod
				(rodCode doit: temp0)
				(return 1)
			)
			(7 ; Look
				(if (not local3)
					(if [local21 (+ (* temp0 2) 1)]
						(if (== theVerb 7) ; Look
							(gEgo setScript: lookAtTile 0 temp0)
						else
							(gMessager say: 12 theVerb 8) ; "An etched stone is on the wall."
						)
					else
						(gMessager say: 12 theVerb 5) ; "On the floor is an etched stone."
					)
				else
					(gMessager say: 12 theVerb 4) ; "There's no time to examine the stones now!"
				)
				(return 1)
			)
			(88 ; tile
				(if [local21 (+ (* cel 2) 1)]
					(gMessager say: 12 88 8) ; "There's already a stone in that spot on the wall."
				else
					(gMessager say: 12 88 5) ; "Putting the stones together on the floor doesn't seem right."
				)
			)
			(else
				(return (aTile doVerb: theVerb &rest))
			)
		)
	)
)

(instance thirdTile of View
	(properties
		noun 12
		sightAngle 40
		x 217
		y 98
		view 710
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(= temp0 cel)
		(switch theVerb
			(12 ; Pickup
				(cond
					(local3
						(gMessager say: 12 12 4) ; "It's too late to do anything more with the stones now!"
					)
					((or (== temp0 12) (== temp0 7))
						(gMessager say: 12 12 10) ; "(TRYING TO PULL A STONE TILE OFF THE WALL IN SNAKE MOUND. THOUGHTFUL)Hmmm. It's stuck."
					)
					(else
						(if (mod temp0 2)
							(= temp1 (- temp0 1))
						else
							(= temp1 (+ temp0 1))
						)
						(if (== temp0 1)
							(= temp1 1)
						)
						(gEgo get: (+ 48 temp1))
						(gGame handsOff:)
						(gCurRoom setScript: getTile 0 self)
					)
				)
				(return 1)
			)
			(76 ; rod
				(rodCode doit: temp0)
				(return 1)
			)
			(7 ; Look
				(if (not local3)
					(if [local21 (+ (* temp0 2) 1)]
						(if (== theVerb 7) ; Look
							(gEgo setScript: lookAtTile 0 temp0)
						else
							(gMessager say: 12 theVerb 8) ; "An etched stone is on the wall."
						)
					else
						(gMessager say: 12 theVerb 5) ; "On the floor is an etched stone."
					)
				else
					(gMessager say: 12 theVerb 4) ; "There's no time to examine the stones now!"
				)
				(return 1)
			)
			(else
				(return (aTile doVerb: theVerb &rest))
			)
		)
	)
)

(instance snakeRod of View
	(properties
		noun 11
		sightAngle 40
		x 151
		y 116
		priority 108
		fixPriority 1
		view 710
		loop 2
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 89 90 91 92 93 94 95 96 97 98 99) ; tile1, tile2, tile3, tile4, tile5, tile6, ???, tile8, tile9, tile10, tile11
			(= theVerb 88) ; tile
		)
		(if (== theVerb 12) ; Pickup
			(gGame handsOff:)
			(Load rsVIEW 713)
			(gCurRoom setScript: getRod 0 self)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance vine1 of View
	(properties
		noun 7
		sightAngle 40
		z 128
		priority 189
		fixPriority 1
		view 7101
		signal 20513
	)

	(method (doVerb theVerb)
		(vineFeat1 doVerb: theVerb &rest)
	)
)

(instance vine2 of View
	(properties
		noun 7
		sightAngle 40
		z 128
		priority 189
		fixPriority 1
		view 7101
		signal 20513
	)

	(method (doVerb theVerb)
		(vineFeat1 doVerb: theVerb &rest)
	)
)

(instance passageKeyHole of Feature
	(properties
		noun 15
		nsLeft 205
		nsTop 70
		nsRight 230
		nsBottom 95
		sightAngle 40
		x 214
		y 140
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 89 90 91 92 93 94 95 96 97 98 99) ; tile1, tile2, tile3, tile4, tile5, tile6, ???, tile8, tile9, tile10, tile11
			(= theVerb 88) ; tile
		)
		(if (== theVerb 76) ; rod
			(if (not local12)
				(= local11 1)
				(gCurRoom setScript: goToCeremony)
			)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance mural of Feature
	(properties
		noun 2
		nsLeft 192
		nsTop 76
		nsRight 257
		nsBottom 119
		sightAngle 40
		x 230
		y 70
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 89 90 91 92 93 94 95 96 97 98 99) ; tile1, tile2, tile3, tile4, tile5, tile6, ???, tile8, tile9, tile10, tile11
			(= theVerb 88) ; tile
		)
		(super doVerb: theVerb &rest)
	)
)

(instance putTileOnWall of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 190 131 self)
			)
			(1
				(gEgo setCel: 7 setLoop: 1 view: 7121 setCycle: CT 5 -1 self)
			)
			(2
				(gGkSound2 number: 709 setLoop: 1 play:)
				(gEgo setCycle: CT 0 -1 self)
				(switch register
					(89
						(gEgo put: 49) ; tile1
						(= [local21 2] local0)
						(= [local21 3] 1)
						(thirdTile setCel: 1 view: 710 show:)
					)
					(90
						(gEgo put: 51) ; tile2
						(= [local21 4] local0)
						(= [local21 5] 1)
						(thirdTile setCel: 2 view: 710 show:)
					)
					(91
						(gEgo put: 50) ; tile3
						(= [local21 6] local0)
						(= [local21 7] 1)
						(thirdTile setCel: 3 view: 710 show:)
					)
					(92
						(gEgo put: 53) ; tile4
						(= [local21 8] local0)
						(= [local21 9] 1)
						(thirdTile setCel: 4 view: 710 show:)
					)
					(93
						(gEgo put: 52) ; tile5
						(= [local21 10] local0)
						(= [local21 11] 1)
						(thirdTile setCel: 5 view: 710 show:)
					)
					(94
						(gEgo put: 55) ; tile6
						(= [local21 12] local0)
						(= [local21 13] 1)
						(thirdTile setCel: 6 view: 710 show:)
					)
					(96
						(gEgo put: 57) ; tile8
						(= [local21 16] local0)
						(= [local21 17] 1)
						(thirdTile setCel: 8 view: 710 show:)
					)
					(97
						(gEgo put: 56) ; tile9
						(= [local21 18] local0)
						(= [local21 19] 1)
						(thirdTile setCel: 9 view: 710 show:)
					)
					(98
						(gEgo put: 59) ; tile10
						(= [local21 20] local0)
						(= [local21 21] 1)
						(thirdTile setCel: 10 view: 710 show:)
					)
					(99
						(gEgo put: 58) ; tile11
						(= [local21 22] local0)
						(= [local21 23] 1)
						(thirdTile setCel: 11 view: 710 show:)
					)
				)
			)
			(3
				(gGkSound2 stop:)
				(if (not (IsFlag 459))
					(gMessager say: 5 88 0 1 self) ; "(SPEAKING TO HIMSELF, PUT A TILE ON A HOLE IN THE WALL)It fits."
				else
					(self cue:)
				)
			)
			(4
				(SetFlag 459)
				(if (tileCheck doit:)
					(gEgo getPoints: 134 3)
				)
				(gEgo normalize: 0 901)
				(gEgo ignoreActors:)
				(gGame handsOn:)
			)
		)
	)
)

(instance tileSpot of Feature
	(properties
		noun 5
		nsLeft 214
		nsTop 94
		nsRight 223
		nsBottom 105
		sightAngle 40
		x 219
		y 80
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 89 90 91 92 93 94 96 97 98 99) ; tile1, tile2, tile3, tile4, tile5, tile6, tile8, tile9, tile10, tile11
				(gGame handsOff:)
				(gEgo setScript: putTileOnWall 0 theVerb)
				(return 1)
			)
			((== theVerb 76) ; rod
				(gGame handsOff:)
				(gEgo setScript: tryKeyOnHole)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance exitNorth of Feature
	(properties
		noun 3
		nsLeft 53
		nsTop 47
		nsRight 94
		nsBottom 108
		sightAngle 40
		x 65
		y 20
	)
)

(instance vineFeat1 of Feature
	(properties
		noun 7
		nsTop 32
		nsRight 56
		nsBottom 46
		sightAngle 40
		x 5
		y 200
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 89 90 91 92 93 94 95 96 97 98 99) ; tile1, tile2, tile3, tile4, tile5, tile6, ???, tile8, tile9, tile10, tile11
			(= theVerb 88) ; tile
		)
		(if (== theVerb 8) ; Operate
			(cond
				((not local3)
					(gMessager say: 7 8 3) ; "Although he has a playful urge to swing on those vines, Gabriel would feel a bit childish doing so without a good reason."
					(return 1)
				)
				((== local0 6)
					(Load rsVIEW 714)
					(= local20 1)
					(gCurRoom setScript: vineSwing)
					(return 1)
				)
				((== local0 12)
					(gMessager say: 7 8 25) ; "Gabriel COULD swing on the vines to try to move that guard, but there aren't any vines in the proper positions in this room!"
					(return 1)
				)
				(else
					(gMessager say: 7 8 4) ; "Using the vines won't help Gabriel here!"
					(return 1)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance vineFeat2 of Feature
	(properties
		noun 7
		nsLeft 80
		nsTop 21
		nsRight 233
		nsBottom 44
		sightAngle 40
		x 150
		y 200
	)

	(method (doVerb theVerb)
		(vineFeat1 doVerb: theVerb &rest)
	)
)

(instance vineFeat3 of Feature
	(properties
		noun 7
		nsLeft 246
		nsTop 21
		nsRight 319
		nsBottom 145
		sightAngle 40
		x 310
		y 200
	)

	(method (doVerb theVerb)
		(vineFeat1 doVerb: theVerb &rest)
	)
)

(instance setUpRoom of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp1 0)
		(= temp2 0)
		(cond
			((== local0 9)
				(if (not (gEgo has: 60)) ; rod
					(snakeRod init:)
				)
			)
			((gCast contains: snakeRod)
				(snakeRod dispose:)
			)
		)
		(if (== local0 6)
			(outsideDoor init:)
			(if (gCast contains: torch1)
				(torch1 dispose: setCycle: 0)
			)
		else
			(if (gCast contains: outsideDoor)
				(outsideDoor dispose:)
			)
			(if (not (gCast contains: torch1))
				(torch1 init: setPri: 114 setCycle: Fwd)
			)
		)
		(if (== local0 7)
			(doorFrame init: fixPriority: 1 setPri: 60)
			(secretDoor setCel: (if local3 9 else 0) init:)
			(mural dispose:)
		else
			(if (not (gFeatures contains: mural))
				(mural init:)
			)
			(if (gCast contains: doorFrame)
				(doorFrame dispose:)
			)
			(if (gCast contains: secretDoor)
				(secretDoor dispose:)
			)
			(mural noun: 2)
		)
		(= temp7 (* (- local0 1) 4))
		(vine1 x: [local53 temp7] y: 150 setLoop: [local53 (+ temp7 1)])
		(vine2 x: [local53 (+ temp7 2)] y: 150 setLoop: [local53 (+ temp7 3)])
		(for ((= temp0 2)) (< temp0 25) ((+= temp0 2))
			(if (== [local21 temp0] local0)
				(cond
					((not temp1)
						(aTile setCel: (/ temp0 2))
						(= temp1 1)
						(if [local21 (+ temp0 1)]
							(aTile view: 710 posn: 217 98 show:)
						else
							(aTile view: 7100 posn: 209 137 show:)
						)
					)
					((not temp2)
						(= temp2 1)
						(secondTile setCel: (/ temp0 2))
						(if [local21 (+ temp0 1)]
							(secondTile view: 710 posn: 217 98 show:)
						else
							(secondTile view: 7100 posn: 23 128 show:)
						)
					)
					(else
						(thirdTile setCel: (/ temp0 2))
						(thirdTile view: 710 posn: 217 98 show:)
					)
				)
			)
		)
		(cond
			((not local3)
				(= temp0 (* (mod local0 3) 2))
				(guard1
					setCel: 0
					setLoop: 0
					view: (+ 704 temp0)
					posn: [local47 temp0] [local47 (+ temp0 1)]
				)
				(if (== ((gCurRoom obstacles:) size:) 2)
					((gCurRoom obstacles:) delete: local9)
					(local9 dispose:)
				)
				(= temp3 (- (guard1 x:) 20))
				(= temp5 (+ (guard1 x:) 20))
				(= temp4 (- (guard1 y:) 10))
				(= temp6 (+ (guard1 y:) 5))
				(if (== (guard1 view:) 706)
					(+= temp5 10)
				)
				(if (== (guard1 view:) 704)
					(-= temp4 5)
					(-= temp5 5)
					(+= temp3 5)
				)
				(gCurRoom
					addObstacle:
						(= local9
							((Polygon new:)
								type: PBarredAccess
								init:
									temp3
									temp4
									temp5
									temp4
									temp5
									temp6
									temp3
									temp6
								yourself:
							)
						)
				)
			)
			((and local8 (== local1 local0))
				(= local16 1)
				(guard1 setScript: backTrack)
			)
			((== local0 7)
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				((gCurRoom obstacles:) delete: local10)
				(local10 dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 252 146 227 138 278 138 278 132 279 123 196 128 182 120 171 120 164 111 85 111 81 72 69 72 58 110 37 110 34 115 25 117 3 145
							yourself:
						)
				)
				(LoadMany rsVIEW 715 709 7161 7162 717 718 7171)
				(gEgo setScript: wolfCartoon)
			)
			((or (> local7 local0) (== (+ local7 11) local0))
				(guard1 setMotion: 0)
				(if (gCast contains: guard2)
					(guard2 setMotion: 0 dispose:)
				)
				(if (gCast contains: guard3)
					(guard3 setMotion: 0 dispose:)
				)
				(guard1 setScript: wrongWay)
			)
			(else
				(guard1 setMotion: 0)
				(if (gCast contains: guard2)
					(guard2 setMotion: 0 dispose:)
				)
				(if (gCast contains: guard3)
					(guard3 setMotion: 0 dispose:)
				)
				(guard1 setScript: rightWay)
			)
		)
		(= local1 local7)
	)
)

(instance rodCode of Code
	(properties)

	(method (doit param1)
		(Load rsVIEW 7131)
		(cond
			(local3
				(gMessager say: 12 76 4) ; "It's too late for that now! The stones can't be deactivated that way!"
			)
			((and (!= param1 3) [local21 (+ (* param1 2) 1)])
				(gGame handsOff:)
				(gCurRoom setScript: tryKeyOnTile 0 12)
			)
			((not [local21 (+ (* param1 2) 1)])
				(gMessager say: 12 76 5) ; "Using the rod on the stone while it's on the floor doesn't seem quite right."
			)
			((and (== param1 3) (not (tileCheck doit:)))
				(gGame handsOff:)
				(gCurRoom setScript: tryKeyOnTile 0 13)
			)
			((and (== param1 3) (tileCheck doit:))
				(Load rsVIEW 7132)
				(gGame handsOff:)
				(gCurRoom setScript: keyWorks 0 14)
			)
		)
	)
)

(instance tileCheck of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= temp0 1)
		(for ((= temp1 2)) (< temp1 25) ((+= temp1 2))
			(if (!= [local21 temp1] (/ temp1 2))
				(= temp0 0)
			)
		)
		(return temp0)
	)
)

(instance stuffArray of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(for ((= temp0 2)) (< temp0 23) ((+= temp0 2))
			(switch temp0
				(2
					(= temp1 ((ScriptID 701) tileLoc1:)) ; Africa
				)
				(4
					(= temp1 ((ScriptID 701) tileLoc2:)) ; Africa
				)
				(6
					(= temp1 ((ScriptID 701) tileLoc3:)) ; Africa
				)
				(8
					(= temp1 ((ScriptID 701) tileLoc4:)) ; Africa
				)
				(10
					(= temp1 ((ScriptID 701) tileLoc5:)) ; Africa
				)
				(12
					(= temp1 ((ScriptID 701) tileLoc6:)) ; Africa
				)
				(14
					(continue)
				)
				(16
					(= temp1 ((ScriptID 701) tileLoc8:)) ; Africa
				)
				(18
					(= temp1 ((ScriptID 701) tileLoc9:)) ; Africa
				)
				(20
					(= temp1 ((ScriptID 701) tileLoc10:)) ; Africa
				)
				(22
					(= temp1 ((ScriptID 701) tileLoc11:)) ; Africa
				)
			)
			(if (> temp1 100)
				(= [local21 temp0] (mod temp1 100))
				(= [local21 (+ temp0 1)] 1)
			else
				(= [local21 temp0] temp1)
				(= [local21 (+ temp0 1)] 0)
			)
		)
	)
)

(instance stuffProperties of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(for ((= temp0 2)) (< temp0 23) ((+= temp0 2))
			(switch temp0
				(2
					((ScriptID 701) tileLoc1: [local21 temp0]) ; Africa
					(if [local21 (+ temp0 1)]
						((ScriptID 701) ; Africa
							tileLoc1: (+ ((ScriptID 701) tileLoc1:) 100) ; Africa
						)
					)
				)
				(4
					((ScriptID 701) tileLoc2: [local21 temp0]) ; Africa
					(if [local21 (+ temp0 1)]
						((ScriptID 701) ; Africa
							tileLoc2: (+ ((ScriptID 701) tileLoc2:) 100) ; Africa
						)
					)
				)
				(6
					((ScriptID 701) tileLoc3: [local21 temp0]) ; Africa
					(if [local21 (+ temp0 1)]
						((ScriptID 701) ; Africa
							tileLoc3: (+ ((ScriptID 701) tileLoc3:) 100) ; Africa
						)
					)
				)
				(8
					((ScriptID 701) tileLoc4: [local21 temp0]) ; Africa
					(if [local21 (+ temp0 1)]
						((ScriptID 701) ; Africa
							tileLoc4: (+ ((ScriptID 701) tileLoc4:) 100) ; Africa
						)
					)
				)
				(10
					((ScriptID 701) tileLoc5: [local21 temp0]) ; Africa
					(if [local21 (+ temp0 1)]
						((ScriptID 701) ; Africa
							tileLoc5: (+ ((ScriptID 701) tileLoc5:) 100) ; Africa
						)
					)
				)
				(12
					((ScriptID 701) tileLoc6: [local21 temp0]) ; Africa
					(if [local21 (+ temp0 1)]
						((ScriptID 701) ; Africa
							tileLoc6: (+ ((ScriptID 701) tileLoc6:) 100) ; Africa
						)
					)
				)
				(14
					(continue)
				)
				(16
					((ScriptID 701) tileLoc8: [local21 temp0]) ; Africa
					(if [local21 (+ temp0 1)]
						((ScriptID 701) ; Africa
							tileLoc8: (+ ((ScriptID 701) tileLoc8:) 100) ; Africa
						)
					)
				)
				(18
					((ScriptID 701) tileLoc9: [local21 temp0]) ; Africa
					(if [local21 (+ temp0 1)]
						((ScriptID 701) ; Africa
							tileLoc9: (+ ((ScriptID 701) tileLoc9:) 100) ; Africa
						)
					)
				)
				(20
					((ScriptID 701) tileLoc10: [local21 temp0]) ; Africa
					(if [local21 (+ temp0 1)]
						((ScriptID 701) ; Africa
							tileLoc10: (+ ((ScriptID 701) tileLoc10:) 100) ; Africa
						)
					)
				)
				(22
					((ScriptID 701) tileLoc11: [local21 temp0]) ; Africa
					(if [local21 (+ temp0 1)]
						((ScriptID 701) ; Africa
							tileLoc11: (+ ((ScriptID 701) tileLoc11:) 100) ; Africa
						)
					)
				)
			)
		)
	)
)

(instance tileInset of Inset
	(properties
		view 61
		x 98
		y 37
		disposeNotOnMe 1
		modNum 710
		noun 12
	)

	(method (init param1 param2 param3)
		(switch param3
			(1
				(snakeView view: 62)
			)
			(2
				(snakeView view: 63)
			)
			(3
				(snakeView view: 64)
			)
			(4
				(snakeView view: 65)
			)
			(5
				(snakeView view: 66)
			)
			(6
				(snakeView view: 67)
			)
			(7
				(snakeView view: 68)
			)
			(8
				(snakeView view: 69)
			)
			(9
				(snakeView view: 691)
			)
			(10
				(snakeView view: 692)
			)
			(11
				(snakeView view: 693)
			)
			(12
				(snakeView view: 694)
			)
		)
		(super init: param1 rm710 1)
		(snakeView setPri: 15 init:)
		(UpdatePlane plane)
		(FrameOut)
	)

	(method (doVerb)
		(gMessager say: 12 7 8) ; "An etched stone is on the wall."
		(return 1)
	)

	(method (dispose)
		(snakeView dispose:)
		(super dispose:)
	)
)

(instance snakeView of View
	(properties
		x 15
		y 13
		view 62
	)
)

