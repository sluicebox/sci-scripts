;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n316)
(use n821)
(use LoadMany)
(use SmoothLooper)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scubaCycle 0
)

(local
	[local0 9] = [87 176 268 364 466 577 700 839 1000]
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
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
)

(procedure (localproc_0 param1 param2)
	(localproc_2
		(+ (* local10 190) (- 190 (gEgo y:)))
		(+ (* local9 320) (gEgo x:))
		(+ (* param2 190) (- 190 local20))
		(+ (* param1 320) local19)
	)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1)
	(= temp0 (+ (* (- param1 local9) 320) (- local19 (gEgo x:))))
	(= temp1 (+ (* (- param2 local10) 190) (- local20 (gEgo y:))))
	(= temp0 (/ (+ temp0 50) 100))
	(= temp1 (/ (+ temp1 50) 100))
	(if (and (< -130 temp0 130) (< -130 temp1 130))
		(return (* (Sqrt (+ (* temp0 temp0) (* temp1 temp1))) 75))
	else
		(return 9999)
	)
)

(procedure (localproc_2 param1 param2 param3 param4 &tmp temp0)
	(= temp0 (localproc_3 param1 param2 param3 param4))
	(cond
		((< (- param3 param1) 0)
			(if (<= (- param4 param2) 0)
				(+= temp0 180)
			else
				(= temp0 (- 180 temp0))
			)
		)
		((< (- param4 param2) 0)
			(= temp0 (- 360 temp0))
		)
	)
	(return temp0)
)

(procedure (localproc_3 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (Abs (- param3 param1)))
	(if (<= (= temp1 (Abs (- param4 param2))) temp0)
		(while (< 32 temp1)
			(/= temp1 2)
			(/= temp0 2)
		)
		(if (< (= temp2 (/ (* 1000 temp1) temp0)) 100)
			(= temp3 (/ (* temp1 57) temp0))
		else
			(= temp3 (localproc_4 temp2))
		)
	else
		(= temp3 (- 90 (localproc_3 param2 param1 param4 param3)))
	)
	(return temp3)
)

(procedure (localproc_4 param1 &tmp temp0)
	(for ((= temp0 0)) (< [local0 temp0] param1) ((++ temp0))
	)
	(return
		(+
			(* 5 temp0)
			(/
				(* 5 (- param1 [local0 (- temp0 1)]))
				(- [local0 temp0] [local0 (- temp0 1)])
			)
		)
	)
)

(procedure (localproc_5)
	(if
		(and
			(not (* (- local11 local9) (- local12 local10)))
			(or
				(== (+ (- local11 local9) (- local12 local10)) 1)
				(== (+ (- local11 local9) (- local12 local10)) -1)
			)
		)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_6)
	(if (and (== local11 local9) (== local12 local10))
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_7 param1 param2 param3 param4)
	(= param2 (- 450 param2))
	(= param4 (- 450 param4))
	(= local15 (/ (+ (CosMult param2 param1) 160) 320))
	(= local16 (/ (+ (SinMult param2 param1) 95) 190))
	(= local17 (/ (+ (CosMult param4 param3) 160) 320))
	(= local18 (/ (+ (SinMult param4 param3) 95) 190))
)

(instance scubaCycle of Rm
	(properties
		picture 51
	)

	(method (dispose)
		(soundBubbles dispose:)
		(DisposeScript 314)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(HandsOn)
		(LoadMany rsVIEW 54 952 151 152 953 155)
		(LoadMany rsSOUND 56 73)
		(gEgo
			cycleSpeed: 2
			loop: 3
			setLoop: -1
			setLoop: scubaLooper
			ignoreHorizon: 1
			init:
		)
		(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
			(= local28 1)
			(gEgo view: 54)
			(scubaLooper vNormal: 54 vChangeDir: 55)
			(headingGaugeProp
				init:
				setPri: 14
				ignoreActors: 1
				setScript: showGauge
				stopUpd:
			)
		else
			(= local28 5)
			(gEgo view: 154)
			(scubaLooper vNormal: 154 vChangeDir: 254)
		)
		(cond
			((== gPrevRoomNum 50) ; launchDiver
				(gEgo
					loop: 1
					posn: 315 100
					xStep: 3
					yStep: 2
					setMotion: MoveTo -5 100
				)
			)
			((== gPrevRoomNum 47) ; tunaPierRm
				(gEgo loop: 2 posn: 155 5 setMotion: MoveTo 155 200)
			)
			(else
				(gEgo
					posn: (gEgo x:) 5
					setMotion: MoveTo (gEgo x:) 200
				)
			)
		)
		(air init: ignoreActors: setPri: 15)
		(if (<= (/ global102 800) 0)
			(air hide:)
		)
		(bubbles init:)
		(soundBubbles
			number: (proc0_5 66)
			init:
			owner: self
			play: egosBubbleScript
		)
		(gauge init: setPri: 15 ignoreActors: addToPic:)
		(= local24 1)
		(= local29 1)
		(gGame changeScore: -3)
		(switch gPrevRoomNum
			(47 ; tunaPierRm
				(gGame changeScore: -17)
				(= local9 12)
				(= local10 6)
			)
			(57 ; westDeadEndRm
				(= local9 0)
				(= local10 6)
			)
			(56 ; caveEntranceRm
				(= local9 1)
				(= local10 6)
			)
			(55 ; shore2Rm
				(= local9 2)
				(= local10 6)
			)
			(53 ; antiSubNetRm
				(= local9 3)
				(= local10 6)
			)
			(54 ; shoreRm
				(= local9 4)
				(= local10 6)
			)
			(61 ; tunisBeachRm
				(= local9 5)
				(= local10 6)
			)
			(58 ; eastDeadEndRm
				(= local9 6)
				(= local10 6)
			)
			(else
				(gGame changeScore: 3)
				(= local24 0)
				(= local25 0)
				(= local29 0)
				(= local9 0)
				(= local10 0)
			)
		)
		(localproc_7
			(subMarine dist1:)
			(subMarine head1:)
			(subMarine dist2:)
			(subMarine head2:)
		)
		(= local11 -8)
		(= local12 3)
		(= local13 3)
		(= local14 7)
		(= local19 160)
		(= local20 95)
		(= west (= east (= north (= south 999))))
		(if
			(and
				(== gPrevRoomNum 50) ; launchDiver
				(not
					(and
						(& (subMarine roomFlags:) $0020)
						(& (subMarine roomFlags:) $0040)
						(& (subMarine roomFlags:) $0080)
					)
				)
			)
			(= local30 1)
			(= local31 250)
		)
	)

	(method (newRoom)
		(switch (gEgo edgeHit:)
			(1
				(++ local10)
				(gEgo y: 185)
			)
			(3
				(-- local10)
				(gEgo y: 0)
			)
			(2
				(++ local9)
				(gEgo x: 0)
			)
			(4
				(-- local9)
				(gEgo x: 315)
			)
		)
		(gEgo illegalBits: -32768)
		(if (and (== local10 local14) (<= (- local13 3) local9 (+ local13 9)))
			(gGame changeScore: 2)
			(switch (- local9 local13)
				(9
					(gGame changeScore: 20)
					(super newRoom: 47) ; tunaPierRm
				)
				(3
					(super newRoom: 58) ; eastDeadEndRm
				)
				(2
					(super newRoom: 61) ; tunisBeachRm
				)
				(1
					(super newRoom: 54) ; shoreRm
				)
				(0
					(gGame changeScore: 3)
					(super newRoom: 53) ; antiSubNetRm
				)
				(-1
					(super newRoom: 55) ; shore2Rm
				)
				(-2
					(super newRoom: 56) ; caveEntranceRm
				)
				(-3
					(super newRoom: 57) ; westDeadEndRm
				)
			)
		else
			(bubbles hide:)
			(if local26
				(plastic hide:)
			)
			(cond
				(local24
					(gCurRoom drawPic: 51)
				)
				((localproc_5)
					(gCurRoom drawPic: 51)
					(cond
						((and (== local9 local11) (== local10 (- local12 1)))
							(gAddToPics add: rigNorth doit:)
							(cond
								(local21
									(gEgo y: 80)
								)
								((< (gEgo y:) 80)
									(gEgo y: 80)
								)
							)
						)
						((and (== local10 local12) (== local9 (- local11 1)))
							(gAddToPics
								add: pilingRightFT pilingRightFB pilingRightB
								doit:
							)
							(gEgo observeControl: 16)
							(if local26
								(plastic posn: 289 155 show:)
							)
							(if local21
								(gEgo x: 220)
							)
						)
						((and (== local10 local12) (== local9 (+ local11 1)))
							(gAddToPics
								add: pilingLeftFT pilingLeftFB pilingLeftB
								doit:
							)
							(gEgo observeControl: 16384)
							(if local21
								(gEgo x: 35)
							)
						)
					)
					(= local21 0)
				)
				((localproc_6)
					(= local21 1)
					(gCurRoom drawPic: 52)
					(= local25 1)
					(if local26
						(plastic posn: 69 160 show:)
					)
					(switch (gEgo edgeHit:)
						(1
							(gEgo y: 185)
						)
						(3
							(gEgo y: 70)
						)
						(2
							(gEgo x: 97)
							(if (< (gEgo y:) 70)
								(gEgo y: 70)
							)
						)
						(4
							(gEgo x: 283)
							(if (< (gEgo y:) 70)
								(gEgo y: 70)
							)
						)
					)
					(if local27
						(= local27 0)
						(gEgo setScript: setExplosive)
					)
				)
				(else
					(if (and (== local15 local9) (== local16 local10))
						(= local25 1)
					)
					(if (and (== local17 local9) (== local18 local10))
						(= local29 1)
						(= local25 0)
					)
					(gCurRoom drawPic: 51)
				)
			)
			(gauge init: setPri: 15 addToPic:)
			(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
				(headingGaugeProp
					init:
					setPri: 14
					ignoreActors: 1
					setScript: showGauge
					stopUpd:
				)
			)
		)
	)

	(method (doit)
		(if local30
			(if local31
				(-- local31)
			else
				(= local30 0)
				(gEgo setScript: loseDiver)
			)
		)
		(cond
			((< 0 global102)
				(-= global102 local28)
				(if (< 0 (/ global102 800))
					(air setCel: (- 10 (/ global102 800)))
				else
					(air hide:)
				)
				(if (and (== local21 1) (< (gEgo y:) 70))
					(gEgo edgeHit: 1)
				)
				(if
					(and
						(< (gEgo y:) 80)
						(== local11 local9)
						(== local12 (+ local10 1))
					)
					(gEgo edgeHit: 1)
				)
			)
			((not (gEgo script:))
				(gEgo setScript: outOfAir)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((super handleEvent: event))
			((Said '[adjust,adjust]/bomb')
				(cond
					((not (gEgo has: 3)) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
						(Print 51 0) ; "You don't have any explosives."
					)
					(local26
						(Print 51 1) ; "You've placed the explosive device and the timer has been activated."
					)
					(else
						(gEgo setScript: setExplosive)
					)
				)
			)
			((Said 'look[<at]/bomb')
				(cond
					((not (gEgo has: 3)) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
						(Print 51 0) ; "You don't have any explosives."
					)
					(local26
						(Print 51 1) ; "You've placed the explosive device and the timer has been activated."
					)
					(else
						(Print 51 2) ; "You have a small pack of very powerfull, plastic explosive."
					)
				)
			)
			((Said 'look[<at]/timer')
				(cond
					((gEgo has: 3) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
						(Print 51 3) ; "A small digital timer for triggering explosives."
					)
					((proc316_1 self 3)
						(Print 51 4) ; "You don't have time."
					)
					(else
						(Print 51 5) ; "You don't have a timer."
					)
				)
			)
			((Said 'look[<at]/target')
				(cond
					(local25
						(Printf ; "Harbor = %d DEGREES ,%d YARDS"
							51
							6
							(localproc_0 local17 local18)
							(localproc_1 local17 local18)
						)
					)
					(local29
						(Print 51 7) ; "Your inertia device has been reset to zero once you have reached you destination."
					)
					(else
						(Printf ; "Oil rig = %d DEGREES ,%d YARDS"
							51
							8
							(localproc_0 local15 local16)
							(localproc_1 local15 local16)
						)
					)
				)
			)
			((Said 'look[<at]/instrument,pod')
				(Print 51 9) ; "This is the only information you have."
			)
			((Said 'examine,look[<at]/gear,scuba,coat,wetsuit,equipment')
				(Print 51 10) ; "Typical scuba gear."
			)
		)
	)
)

(instance scubaLooper of SmoothLooper
	(properties
		vNormal 54
		vChangeDir 55
	)
)

(instance rigNorth of PV
	(properties
		y 100
		x 160
		view 952
		priority 3
		signal 16384
	)
)

(instance pilingRightFT of PV
	(properties
		y 140
		x 294
		view 952
		loop 6
		priority 14
		signal 16384
	)
)

(instance pilingRightFB of PV
	(properties
		y 189
		x 293
		view 952
		loop 6
		cel 1
		priority 9
		signal 16384
	)
)

(instance pilingRightB of PV
	(properties
		y 189
		x 255
		view 952
		loop 4
		priority 1
		signal 16384
	)
)

(instance pilingLeftFT of PV
	(properties
		y 139
		x 24
		view 952
		loop 7
		priority 14
		signal 16384
	)
)

(instance pilingLeftFB of PV
	(properties
		y 189
		x 25
		view 952
		loop 7
		cel 1
		priority 9
		signal 16384
	)
)

(instance pilingLeftB of PV
	(properties
		y 189
		x 62
		view 952
		loop 5
		priority 1
		signal 16384
	)
)

(instance air of Prop
	(properties
		y 8
		x 5
		z 2
		view 54
		loop 6
		cel 9
	)
)

(instance gauge of Prop
	(properties
		y 11
		x 22
		z 1
		view 54
		loop 5
		priority 15
	)
)

(instance bubbles of Act
	(properties
		yStep 3
		view 54
		loop 4
	)

	(method (init)
		(self
			setCycle: Walk
			setLoop: 4
			ignoreActors:
			illegalBits: 0
			setScript: egosBubbleScript
		)
		(super init:)
		(self hide:)
	)
)

(instance soundBubbles of Sound
	(properties
		number 66
		priority 1
		loop -1
	)
)

(instance soundExplosion of Sound
	(properties
		number 73
		priority 10
	)
)

(instance egosBubbleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(bubbles
					x:
						(switch (gEgo loop:)
							(0
								(+ (gEgo x:) 8)
							)
							(1
								(- (gEgo x:) 8)
							)
							(else
								(gEgo x:)
							)
						)
					y: (- (gEgo y:) 5)
					show:
					setPri: (gEgo priority:)
					setMotion: MoveTo (gEgo x:) 5 self
				)
			)
			(2
				(bubbles hide:)
				(= cycles 2)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance outOfAir of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(EgoDead 157 0 1 51 11) ; "Forced to the surface because your air ran out, you were captured."
				else
					(EgoDead 157 0 1 51 12) ; "You were forced to the surface because your air ran out. The dive vehicle would have extended your range."
				)
			)
		)
	)
)

(instance headingGaugeProp of Prop
	(properties
		y 30
		x 262
		view 151
	)
)

(instance headingGauge of Code
	(properties)

	(method (doit &tmp [temp0 3])
		(cond
			(local25
				(= local22 (localproc_0 local17 local18))
				(= local23 (mod (localproc_1 local17 local18) 10000))
			)
			(local29
				(= local22 0)
				(= local23 0)
			)
			(else
				(= local22 (localproc_0 local15 local16))
				(= local23 (mod (localproc_1 local15 local16) 10000))
			)
		)
		(Display 51 13 dsCOORD 219 17 dsCOLOR 8 dsALIGN alRIGHT dsWIDTH 25 dsFONT 30) ; "888"
		(Display
			(Format @temp0 51 14 local22) ; "%d"
			dsCOORD
			219
			17
			dsCOLOR
			14
			dsALIGN
			alRIGHT
			dsWIDTH
			25
			dsFONT
			30
		)
		(Display 51 13 dsCOORD 267 17 dsCOLOR 8 dsALIGN alRIGHT dsWIDTH 25 dsFONT 30) ; "888"
		(Display
			(Format @temp0 51 14 local23) ; "%d"
			dsCOORD
			267
			17
			dsCOLOR
			14
			dsALIGN
			alRIGHT
			dsWIDTH
			25
			dsFONT
			30
		)
	)
)

(instance showGauge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(headingGauge doit:)
			)
		)
	)
)

(instance setExplosive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local26 1)
				(cond
					((localproc_6)
						(Print 51 15) ; "You look for a good spot to place the explosives."
						(gEgo
							illegalBits: 0
							setMotion: MoveTo 184 (gEgo y:) self
						)
					)
					((and (== local10 local12) (== local9 (- local11 1)))
						(= local27 1)
						(gEgo
							illegalBits: 0
							setMotion:
								MoveTo
								300
								(if (< (gEgo y:) 70)
									70
								else
									(gEgo y:)
								)
								self
						)
					)
					((and (== local10 local12) (== local9 (+ local11 1)))
						(= local27 1)
						(gEgo
							illegalBits: 0
							setMotion:
								MoveTo
								20
								(if (< (gEgo y:) 70)
									70
								else
									(gEgo y:)
								)
								self
						)
					)
					(else
						(= local26 0)
						(Print 51 16) ; "You're not near enough to the oil rig."
						(HandsOn)
						(self dispose:)
					)
				)
			)
			(1
				(cond
					((localproc_6)
						(gEgo setMotion: MoveTo 184 176 self)
					)
					((and (== local10 local12) (== local9 (- local11 1)))
						(gEgo setMotion: MoveTo 330 (gEgo y:))
					)
					((and (== local10 local12) (== local9 (+ local11 1)))
						(gEgo setMotion: MoveTo -5 (gEgo y:))
					)
				)
			)
			(2
				(gEgo setMotion: MoveTo 70 170 self)
			)
			(3
				(gEgo
					view: 152
					viewer: 0
					setLoop: 0
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(DV_3X
						init:
						view: 155
						setLoop: 8
						setCel: 1
						setPri: (gEgo priority:)
						ignoreActors:
						posn: (- (gEgo x:) 28) (- (gEgo y:) 3)
					)
				)
			)
			(4
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(5
				(plastic
					init:
					view: 152
					setLoop: 3
					setCel: 0
					ignoreActors:
					setPri: 9
					posn: 69 155
				)
				(gEgo setCycle: Beg self)
			)
			(6
				(Print 51 17) ; "You start the timer."
				(gEgo setLoop: 0 setCel: 4 setCycle: Beg self)
				(gGame changeScore: 1)
				(gEgo put: 3 gCurRoomNum) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
			)
			(7
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(DV_3X dispose:)
				)
				(gEgo
					view: (if (gEgo has: 6) 54 else 154) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					loop: 1
					setLoop: -1
					cel: 5
					setCycle: Walk
					cycleSpeed: 2
					illegalBits: -32768
				)
				(if (not global132)
					(gEgo xStep: 6)
				)
				(soundBubbles dispose:)
				(client setScript: blowUp)
				(HandsOn)
			)
		)
	)
)

(instance blowUp of Script
	(properties)

	(method (cue param1)
		(if (== param1 soundExplosion)
			(egosBubbleScript cue:)
			(switch (soundExplosion signal:)
				(60
					(self cue:)
				)
				(70
					(if script
						(script cue:)
					else
						(self cue:)
					)
				)
			)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(soundExplosion number: (proc0_5 73) play: blowUp)
			)
			(1
				(cond
					(
						(or
							(and (== local10 local12) (== local9 (- local11 1)))
							(localproc_6)
						)
						(HandsOff)
						(self setScript: blowUp1)
					)
					((localproc_5)
						(HandsOff)
						(self setScript: blowUp2)
					)
					(else
						(cond
							((< local9 (- local11 1))
								(= temp0 324)
								(= temp1 88)
							)
							((< (+ local11 1) local9)
								(= temp0 -4)
								(= temp1 88)
							)
							((< (+ local12 1) local10)
								(= temp0 142)
								(= temp1 194)
							)
							((< local10 (- local12 1))
								(= temp0 142)
								(= temp1 -4)
							)
						)
						(plastic
							view: 953
							setLoop: 0
							setCel: 0
							posn: temp0 temp1
							show:
							setCycle: CT 2 1 self
						)
					)
				)
			)
			(2
				(plastic hide:)
				(= local24 1)
				(ShakeScreen 30)
				(= seconds 2)
			)
			(3
				(soundExplosion dispose:)
				(soundBubbles init: owner: self play: egosBubbleScript)
				(gEgo xStep: 3)
				(client setScript: 0)
			)
		)
	)
)

(instance blowUp1 of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (- (gEgo x:) 3) (gEgo y:) self)
				(= local24 1)
				(plastic
					view: 953
					setLoop: 0
					setCel: 0
					setPri: 15
					show:
					setCycle: End
				)
			)
			(1
				(= temp0
					(/
						(- (gEgo x:) (plastic x:))
						(Abs (- (gEgo x:) (plastic x:)))
					)
				)
				(= temp1
					(/
						(- (gEgo y:) (plastic y:))
						(Abs (- (gEgo y:) (plastic y:)))
					)
				)
				(ShakeScreen 10)
				(gEgo
					view: 152
					setLoop: 1
					setCel: 0
					xStep: 7
					yStep: 7
					illegalBits: 0
					setCycle: Fwd
					setMotion:
						MoveTo
						(+ (gEgo x:) (* temp0 80))
						(+ (gEgo y:) (* temp1 40))
				)
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(DV_3X
						init:
						view: 152
						setLoop: 4
						setCel: 0
						ignoreActors:
						illegalBits: 0
						posn: (- (gEgo x:) 28) (- (gEgo y:) 3)
						setCycle: Fwd
						setMotion:
							MoveTo
							(+ (gEgo x:) (* temp0 90))
							(+ (gEgo y:) (* temp1 70))
					)
				)
				(= seconds 4)
			)
			(2
				(soundExplosion dispose:)
				(EgoDead 926 1 0 51 18) ; "Your next assignment is as a crash test dummy for GM."
			)
		)
	)
)

(instance blowUp2 of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (- (gEgo x:) 3) (gEgo y:) self)
				(= local24 1)
				(cond
					((== local12 local10)
						(plastic x: -1 y: 100)
					)
					((== local12 (+ local10 1))
						(plastic x: 155 y: 80)
					)
					(else
						(plastic x: 155 y: 191)
					)
				)
				(plastic
					view: 953
					setLoop: 0
					setCel: 0
					setPri: 15
					show:
					setCycle: End
				)
			)
			(1
				(= temp0
					(/
						(- (gEgo x:) (plastic x:))
						(Abs (- (gEgo x:) (plastic x:)))
					)
				)
				(= temp1
					(/
						(- (gEgo y:) (plastic y:))
						(Abs (- (gEgo y:) (plastic y:)))
					)
				)
				(ShakeScreen 10)
				(gEgo
					view: 152
					setLoop: 1
					setCel: 0
					xStep: 7
					yStep: 7
					illegalBits: 0
					setCycle: Fwd
					setMotion:
						MoveTo
						(+ (gEgo x:) (* temp0 80))
						(+ (gEgo y:) (* temp1 50))
				)
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(DV_3X
						init:
						view: 152
						setLoop: 4
						setCel: 0
						ignoreActors:
						illegalBits: 0
						posn: (- (gEgo x:) 28) (- (gEgo y:) 3)
						setCycle: Fwd
						setMotion:
							MoveTo
							(+ (gEgo x:) (* temp0 90))
							(+ (gEgo y:) (* temp1 80))
					)
				)
				(= seconds 4)
			)
			(2
				(soundExplosion dispose:)
				(EgoDead 926 1 0 51 18) ; "Your next assignment is as a crash test dummy for GM."
			)
		)
	)
)

(instance DV_3X of Act
	(properties
		name {DV-3X}
		yStep 5
		view 152
		xStep 5
	)
)

(instance plastic of Prop
	(properties)
)

(instance loseDiver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo has: 6) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
					(HandsOff)
					(gEgo
						setMotion: MoveTo (- (gEgo x:) 3) (gEgo y:) self
					)
				else
					(self dispose:)
				)
			)
			(1
				(gEgo put: 6 view: 152 setLoop: 0 setCel: 1 viewer: 0) ; Tahiti: Earring | Sub: Diver | Tunisia: Key
				(= local28 5)
				(DV_3X
					init:
					view: 152
					setLoop: 4
					setCel: 0
					setPri: (gEgo priority:)
					ignoreActors: 1
					illegalBits: 0
					posn: (- (gEgo x:) 28) (- (gEgo y:) 3)
					cycleSpeed: 4
					setCycle: Fwd
					setMotion: MoveTo (- (gEgo x:) 28) 200 self
				)
			)
			(2
				(scubaLooper vNormal: 154 vChangeDir: 254)
				(gEgo
					view: 154
					loop: 1
					setLoop: -1
					setLoop: scubaLooper
					forceUpd:
				)
				(DV_3X dispose:)
				(= cycles 2)
			)
			(3
				(HandsOn)
				(cond
					((not (& (subMarine roomFlags:) $0020))
						(Print 51 19) ; "You should have checked the DV-3X. A missing washer has caused the diver to malfunction."
					)
					((not (& (subMarine roomFlags:) $0040))
						(Print 51 20) ; "Although you suppiled a missing washer, you forgot to put a nut on the washer."
					)
					(else
						(Print 51 21) ; "You did not tighten the nut properly and now you are without the diver."
					)
				)
				(self dispose:)
			)
		)
	)
)

