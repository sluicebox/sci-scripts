;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use Interface)
(use n814)
(use Print)
(use Feature)
(use LoadMany)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm340 0
)

(local
	local0 = 60
	local1 = 52
	local2
	local3
	local4 = 61
	local5 = 61
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
	local20 = 1
	local21 = 5
	local22
	local23 = 5
	local24 = 7
	[local25 12]
	local37
	local38
	[local39 50]
)

(procedure (localproc_0)
	(gCurRoom drawPic: 340)
	(forcePanel init: addToPic:)
	(anglePanel init: addToPic:)
	(= local20 1)
	(scoreBoard
		init:
		signal: 16384
		setLoop: 1
		setCel: 0
		forceUpd:
		startUpd:
		addToPic:
	)
	(= local4 61)
	(= local5 61)
	(= local16 0)
	(forceGauge setCel: 5)
	(angleGauge setCel: 7)
	(localproc_1 local16 local0)
)

(procedure (localproc_1 param1 param2)
	(Display 340 0 dsCOORD 277 168 dsALIGN alLEFT dsFONT 2107 dsCOLOR 0 dsBACKGROUND 0)
	(if (< param1 10)
		(Display
			(Format @local39 340 1 param1) ; "0%d"
			dsCOORD
			277
			168
			dsALIGN
			alLEFT
			dsFONT
			2107
			dsCOLOR
			param2
			dsBACKGROUND
			0
		)
	else
		(Display
			(Format @local39 340 2 param1) ; "%d"
			dsCOORD
			277
			168
			dsALIGN
			alLEFT
			dsFONT
			2107
			dsCOLOR
			param2
			dsBACKGROUND
			0
		)
	)
)

(procedure (localproc_2)
	(= local10 (Random 100 229))
	(= local11 (Random 189 203))
)

(procedure (localproc_3)
	(while (>= (-- local37) 0)
		([local25 local37] dispose:)
	)
	(= local37 0)
)

(procedure (localproc_4 &tmp temp0 temp1)
	(= local12 (+ local10 (* 12 (- (angleGauge cel:) 7))))
	(= local13 (+ local11 (* -8 (forceGauge cel:))))
	(= temp0 (/ (- 100 [gEgoStats 4]) 4)) ; luck
	(TrySkill 4 0 0) ; luck
	(if (and (TrySkill 10 0 0) (> temp0 6)) ; throwing
		(= temp0 6)
	)
	(+= local12 (- (= temp1 (Random 0 temp0)) (/ temp0 2)))
	(if temp0
		(+= local13 (- (Random 0 temp0) (/ temp0 2)))
	)
	(= local13 (+ (= local13 (- 135 (* (forceGauge cel:) 10))) (- 203 local11)))
)

(procedure (localproc_5 &tmp temp0 temp1)
	(if (< (= temp0 (- local22 (+ global269 (* local18 3)))) 6)
		(= temp0 6)
	)
	(if (>= global248 100)
		(= temp0 (Random 2 5))
	)
	(= local12 (+ 159 (- (= temp1 (Random 0 temp0)) (/ temp0 2))))
	(-= temp0 temp1)
	(if (< (= local13 (+ 76 (- (Random 0 temp0) (/ temp0 2)))) local10)
		(angleGauge cel: (Random 0 6))
	else
		(angleGauge cel: (Random 8 14))
	)
	(forceGauge cel: (Random 0 11))
	(= local13 (- (= local13 (- 135 (* (forceGauge cel:) 10))) (- 203 local11)))
)

(procedure (localproc_6 param1) ; UNUSED
	(cond
		((< param1 0)
			(= param1 0)
		)
		((> param1 11)
			(= param1 11)
		)
	)
	(= local23 param1)
	(forceGauge cel: local23 stopUpd:)
)

(procedure (localproc_7 param1) ; UNUSED
	(cond
		((< param1 0)
			(= param1 0)
		)
		((> param1 14)
			(= param1 14)
		)
	)
	(= local24 param1)
	(angleGauge cel: local24 stopUpd:)
)

(instance dagTimer of Timer
	(properties)
)

(instance rm340 of Rm
	(properties
		noun 4
		picture 340
		style 7
	)

	(method (dispose)
		(= global451 0)
		(gTheIconBar enable: 1 5 9)
		(super dispose:)
	)

	(method (init)
		(super init: &rest)
		(LoadMany rsVIEW 340 339 341)
		(LoadMany rsSOUND (SoundFX 31) (SoundFX 29) (SoundFX 30))
		(SolvePuzzle 643 3 2)
		(scoreBoard init: stopUpd: addToPic:)
		(forcePanel init: addToPic:)
		(anglePanel init: addToPic:)
		(turnMarker init:)
		(dagMusic number: (SoundFX 31) init:)
		(gTheIconBar disable: 1 5)
		(self setScript: dagnabitScript)
		(theBoard init:)
		(angleF init:)
		(forceF init:)
		(bead init: hide:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(dagTimer dispose: delete:)
	)
)

(instance dagnabitScript of Script
	(properties)

	(method (init)
		(forceGauge init: cel: local23)
		(angleGauge init: cel: local24)
		(localproc_2)
		(hand init:)
		(thrownKnife init:)
		(super init: &rest)
	)

	(method (changeState newState &tmp [temp0 20])
		(if local20
			(localproc_1 local16 local0)
		else
			(localproc_1 local17 local1)
		)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 30)
			)
			(1
				(= local21 (GetNumber {"How much will you bet?"} local21))
				(= ticks 180)
			)
			(2
				(cond
					((<= local21 0)
						(client setScript: backToGuild)
						(return)
					)
					((> local21 51)
						(gMessager say: 2 0 8) ; "Now, let's not get carried away."
						(self changeState: 0)
					)
					((not (HaveMoney local21))
						(gMessager say: 2 0 7) ; "Hey! This is cash on the table. You can't bet what you don't have."
						(self changeState: 0)
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(if (>= global248 100)
					(gMessager say: 2 0 3) ; "So, you think you're pretty hot stuff, eh? Well, we'll see about that."
				)
				(++ global269)
				(= local18 (= local14 (= local16 (= local17 0))))
				(= local22 (- (Random 60 90) local21))
				(= local37 0)
				(= seconds 2)
			)
			(4
				(= local20 1)
				(HandsOff)
				(gTheIconBar disable: 9)
				(= local15 0)
				(localproc_2)
				(if (!= (turnMarker cel:) 0)
					(turnMarker setCycle: Beg self)
				else
					(= cycles 2)
				)
			)
			(5
				(localproc_3)
				(self setScript: throwScript)
				(self cue:)
			)
			(6
				(hand cel: 0 posn: local10 local11 forceUpd:)
				(HandsOn)
				(gTheIconBar disable: 1 5 9)
				(= local19 1)
			)
			(7
				(= local19 0)
				(HandsOff)
				(localproc_4)
				(script changeState: 1)
			)
			(8
				(if (< (++ local15) 3)
					(localproc_2)
					(self changeState: 6)
				else
					(hand posn: 900 0)
					(self cue:)
				)
			)
			(9
				(= local20 0)
				(= local15 0)
				(localproc_2)
				(turnMarker setCycle: End self)
			)
			(10
				(self setScript: throwScript)
				(self cue:)
			)
			(11
				(hand cel: 0 posn: local10 local11 forceUpd:)
				(= cycles 20)
			)
			(12
				(localproc_5)
				(++ local18)
				(script changeState: 1)
			)
			(13
				(if (< (++ local15) 3)
					(self changeState: 11)
				else
					(hand posn: 900 0)
					(++ local14)
					(= cycles 5)
				)
			)
			(14
				(if (< local14 3)
					(self changeState: 4)
				else
					(gTheIconBar enable: 9)
					(self cue:)
				)
			)
			(15
				(HandsOn)
				(gTheIconBar disable: 1 5)
				(cond
					((> local16 local17)
						(gMessager say: 2 0 2 0 self) ; "You got me that time. Say, you're pretty tough!"
						(if (>= local21 25)
							(SolvePuzzle 644 5 2)
						)
						(+= global248 local21)
					)
					((< local16 local17)
						(gMessager say: 2 0 6 0 self) ; "Looks like I won that one. Must have gotten lucky."
						(-= global248 local21)
					)
					((<= local21 25)
						(gMessager say: 2 0 5 0 self) ; "It's a tie. Let's double the wager."
						(+= local21 local21)
					)
					(else
						(gMessager say: 2 0 1 0 self) ; "Hey, nice game. It's a tie."
					)
				)
			)
			(16
				(cond
					((> local16 local17)
						(gEgo get: 0 local21) ; silver
						(gEgo get: 0 local21) ; silver
						(self cue:)
					)
					((< local16 local17)
						(self cue:)
					)
					(else
						(gEgo get: 0 local21) ; silver
					)
				)
			)
			(17
				(localproc_3)
				(if
					(Print
						addText: 4 0 11 1 0 0 340 ; "Shall we play again?"
						addButton: 1 4 0 12 1 0 30 340 ; "Yes"
						addButton: 0 4 0 10 1 0 60 340 ; "No"
						init:
					)
					(localproc_0)
					(= cycles 2)
				else
					(gCurRoom setScript: leavinBoard)
				)
			)
			(18
				(self changeState: 1)
			)
		)
	)
)

(instance leavinBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
			)
			(1
				(gCurRoom drawPic: 0 6 newRoom: 332)
			)
		)
	)
)

(instance throwScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(hand view: (if local20 340 else 339))
				(thrownKnife view: (if local20 340 else 339))
			)
			(1
				(= local9 0)
				(= local8 0)
				(= local38 gSpeed)
				(gGame setSpeed: 0)
				(hand
					view: (if local20 340 else 339)
					cycleSpeed: 2
					setCycle: CT 2 1 self
				)
			)
			(2
				(hand cycleSpeed: 0 setCycle: CT 9 1 self)
				(dagMusic number: (SoundFX 31) play:)
			)
			(3
				(hand setCel: 10 stopUpd:)
				(thrownKnife
					view: (if local20 340 else 339)
					posn: (+ local10 1) (- local11 90)
					setPri: 4
					setLoop: 0
					setCel: 1
					cycleSpeed: 0
					moveSpeed: 0
					ignoreActors:
					illegalBits: 0
					setCycle: End self
					setMotion: MoveTo local12 local13
				)
			)
			(4
				(thrownKnife
					setPri: 3
					setLoop: 1
					cel: 0
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo local12 local13 self
				)
			)
			(5
				(thrownKnife posn: 1000 1000 stopUpd:)
				(hand setCel: 0)
				(dagMusic stop:)
				(dagMusic
					number:
						(if local20
							(SoundFX 29)
						else
							(SoundFX 30)
						)
					play:
				)
				(cond
					((> local12 (+ local10 10))
						(= temp0 0)
					)
					((< local12 (- local10 10))
						(= temp0 2)
					)
					(else
						(= temp0 1)
					)
				)
				((= [local25 local37] (View new:))
					view: (if local20 340 else 339)
					loop: 3
					cel: temp0
					posn: local12 local13
					ignoreActors:
					setPri: 1
					init:
					stopUpd:
					onMeCheck: -32768
				)
				(++ local37)
				(= local3
					(switch (OnControl CONTROL local12 local13)
						(2 1)
						(4 2)
						(8 3)
						(16 4)
						(else 0)
					)
				)
				(if local20
					(+= local16 local3)
				else
					(+= local17 local3)
				)
				(gGame setSpeed: local38)
				(cond
					((and local20 local3)
						(= cycles 2)
					)
					((and (not local20) local3)
						(++ state)
						(= cycles 2)
					)
					(else
						(client cue:)
					)
				)
			)
			(6
				(-- state)
				(if local3
					(localproc_1 local16 local0)
					(= local6 local4)
					(= local7 181)
					(bead show: setLoop: 6 setCel: 1 cue:)
				else
					(client cue:)
				)
			)
			(7
				(-- state)
				(if local3
					(localproc_1 local17 local1)
					(= local6 local5)
					(= local7 170)
					(bead show: setLoop: 6 setCel: 0 cue:)
				else
					(client cue:)
				)
			)
		)
	)
)

(instance dagMusic of Sound
	(properties
		number 31
	)
)

(instance theBoard of Feature
	(properties
		x 159
		y 75
		noun 5
		nsTop 3
		nsLeft 70
		nsBottom 148
		nsRight 249
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local19
					(dagnabitScript cue:)
				)
			)
			(1 ; Look
				(gMessager say: 5 1) ; "That's the "Dag-Nab-It" board."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance forceF of Feature
	(properties
		x 34
		y 139
		nsTop 128
		nsBottom 157
		nsRight 63
		sightAngle 40
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(forceGauge doVerb: theVerb)
	)
)

(instance angleF of Feature
	(properties
		x 284
		y 137
		nsTop 124
		nsLeft 262
		nsBottom 151
		nsRight 307
		sightAngle 40
	)

	(method (doVerb theVerb)
		(angleGauge doVerb: theVerb)
	)
)

(instance forceGauge of View
	(properties
		x 12
		y 132
		nsTop 130
		nsLeft 7
		nsBottom 152
		nsRight 62
		view 341
		loop 3
		priority 2
		signal 26640
	)

	(method (doit &tmp temp0 [temp1 2])
		(super doit:)
		(if (and local8 (> gMouseY 135) (< gMouseY 158))
			(= temp0 (+ (- gMouseX (mod gMouseX 4)) 4))
			(self setCel: (/ (- temp0 8) 4) stopUpd:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local8 (not local8))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance anglePanel of View
	(properties
		x 259
		y 18
		z -100
		noun 1
		nsTop 111
		nsLeft 255
		nsBottom 153
		nsRight 312
		view 341
		loop 2
		cel 1
		priority 1
		signal 26640
	)

	(method (doVerb theVerb &tmp [temp0 30])
		(switch theVerb
			(4 ; Do
				(gMessager say: 1 4) ; "Place hand on red dot."
			)
			(1 ; Look
				(++ local1)
				(gMessager say: 1 1) ; "Affects where knife goes."
			)
			(2 ; Talk
				(++ local0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance angleGauge of View
	(properties
		x 284
		y 128
		nsTop 124
		nsLeft 263
		nsBottom 150
		nsRight 308
		view 341
		loop 4
		priority 2
		signal 26640
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (and local9 (> gMouseX 254) (> gMouseY 130) (< gMouseY 158))
			(= temp0 (+ (- (-= gMouseX 255) (mod gMouseX 3)) 3))
			(self setCel: (/ (- temp0 8) 3) stopUpd:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(++ local1)
				(gMessager say: 1 1) ; "Affects where knife goes."
			)
			(4 ; Do
				(= local9 (not local9))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance scoreBoard of View
	(properties
		x 257
		y 157
		view 341
		loop 1
		priority 13
		signal 26640
	)
)

(instance forcePanel of View
	(properties
		x 10
		y 18
		z -100
		noun 3
		nsTop 110
		nsLeft 6
		nsBottom 152
		nsRight 63
		view 341
		loop 2
		priority 1
		signal 26640
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 3 4) ; "Place hand on slider."
			)
			(1 ; Look
				(gMessager say: 3 1) ; "Affects how far knife flies."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance turnMarker of Prop
	(properties
		x 23
		y 169
		view 341
		loop 5
		priority 13
		signal 26640
		cycleSpeed 10
	)
)

(instance thrownKnife of Actor
	(properties
		x 900
		y 100
		view 340
		priority 4
		signal 26640
	)
)

(instance hand of Prop
	(properties
		x 1000
		y 1000
		view 340
		loop 2
		priority 14
		signal 30736
	)

	(method (init)
		(= global451 1340)
		(PalVary pvCHANGE_TARGET 1340)
		(AssertPalette 340)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 4 0 9) ; "It's your hand."
			)
			(4 ; Do
				(theBoard doVerb: 4)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bead of Actor
	(properties
		x 1000
		y 170
		yStep 4
		view 341
		loop 6
		cel 1
		priority 14
		signal 26640
		xStep 4
		moveSpeed 0
	)

	(method (cue)
		(super cue:)
		(switch (++ local2)
			(1
				(self setPri: (- (hand priority:) 1) posn: 259 local7)
				(hand posn: 229 203)
				(dagTimer setCycle: self 3)
			)
			(2
				(self setMotion: MoveTo local6 local7 self)
			)
			(3
				(if local20
					(+= local4 4)
				else
					(+= local5 4)
				)
				(-- local3)
				(self setPri: (hand priority:))
				(dagTimer setCycle: self 2)
			)
			(4
				(DrawCel
					(self view:)
					(self loop:)
					(self cel:)
					(self nsLeft:)
					(self nsTop:)
					(self priority:)
				)
				(dagTimer setCycle: self 2)
			)
			(5
				(hand stopUpd:)
				(= local2 0)
				(self hide:)
				(throwScript cue:)
			)
		)
	)
)

(instance backToGuild of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 2 0 4 1 self) ; "If you don't bet, you can't play."
			)
			(1
				(gCurRoom newRoom: 332)
			)
		)
	)
)

