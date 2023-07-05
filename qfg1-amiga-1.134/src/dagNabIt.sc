;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use Interface)
(use n341)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	dagNabIt 0
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
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19 = 5
	local20
	local21 = 5
	local22 = 7
	[local23 12]
	local35
	local36
	[local37 50]
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6)
	(return
		(and
			(<= param3 param1)
			(< param1 param5)
			(<= param4 param2)
			(< param2 param6)
		)
	)
)

(procedure (localproc_1 param1 param2 param3 param4)
	(Display
		(Format @local37 340 0 param1) ; "%d"
		dsCOORD
		param3
		param4
		dsALIGN
		alLEFT
		dsFONT
		999
		dsCOLOR
		param2
		dsBACKGROUND
		0
		dsWIDTH
		18
	)
)

(procedure (localproc_2)
	(= local8 (Random 40 100))
	(= local9 (Random 85 100))
)

(procedure (localproc_3)
	(while (>= (-- local35) 0)
		([local23 local35] dispose:)
	)
	(= local35 0)
)

(procedure (localproc_4 &tmp temp0 temp1)
	(= local10 (+ local8 (* 6 (- (local1 cel:) 7))))
	(= local11 (+ local9 (* -8 (local0 cel:))))
	(= temp0 (/ (- 100 [gEgoStats 4]) 4)) ; luck
	(TrySkill 4 0 0) ; luck
	(if (and (TrySkill 10 0 0) (> temp0 6)) ; throwing
		(= temp0 6)
	)
	(+= local10 (- (= temp1 (Random 0 temp0)) (/ temp0 2)))
	(if temp0
		(+= local11 (- (Random 0 temp0) (/ temp0 2)))
	)
)

(procedure (localproc_5 &tmp temp0 temp1)
	(if (< (= temp0 (- local20 (+ global300 (* local16 3)))) 6)
		(= temp0 6)
	)
	(if (>= global269 100)
		(= temp0 (Random 2 5))
	)
	(= local10 (+ 70 (- (= temp1 (Random 0 temp0)) (/ temp0 2))))
	(-= temp0 temp1)
	(= local11 (+ 45 (- (Random 0 temp0) (/ temp0 2))))
)

(procedure (localproc_6 param1)
	(cond
		((< param1 0)
			(= param1 0)
		)
		((> param1 11)
			(= param1 11)
		)
	)
	(= local21 param1)
	(local0 setCel: local21 stopUpd:)
)

(procedure (localproc_7 param1)
	(cond
		((< param1 0)
			(= param1 0)
		)
		((> param1 14)
			(= param1 14)
		)
	)
	(= local22 param1)
	(local1 setCel: local22 stopUpd:)
)

(instance dagNabIt of Rm
	(properties
		picture 340
		style 7
	)

	(method (dispose)
		(SL code: gStatusCode)
		(super dispose:)
	)

	(method (init)
		(super init: &rest)
		(Load rsVIEW 340)
		(Load rsVIEW 341)
		(Load rsSOUND (SoundFX 31))
		(Load rsSOUND (SoundFX 29))
		(Load rsSOUND (SoundFX 30))
		(SolvePuzzle 643 3 2)
		(SL code: dagStatus enable:)
		((View new:)
			view: 341
			loop: 0
			cel: 0
			posn: 70 45
			ignoreActors:
			setPri: 0
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 341
			loop: 1
			cel: 0
			posn: 68 183
			ignoreActors:
			setPri: 13
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 341
			loop: 2
			cel: 0
			posn: 183 180
			ignoreActors:
			setPri: 1
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 341
			loop: 2
			cel: 1
			posn: 272 180
			ignoreActors:
			setPri: 1
			init:
			stopUpd:
			addToPic:
		)
		((= local5 (View new:))
			view: 341
			loop: 5
			cel: 0
			ignoreActors:
			posn: 27 178
			setPri: 14
			init:
		)
		((= local6 (View new:))
			view: 341
			loop: 5
			cel: 1
			ignoreActors:
			posn: 110 178
			setPri: 14
			init:
		)
		(dagMusic number: (SoundFX 31) init:)
		(self setScript: dagnabitScript)
		(gKeyHandler addToFront: dagnabitScript)
		(gDirHandler addToFront: dagnabitScript)
		(gMouseHandler addToFront: dagnabitScript)
	)
)

(instance dagnabitScript of Script
	(properties)

	(method (init)
		(= local19 5)
		((= local0 (View new:))
			view: 341
			loop: 3
			cel: local21
			posn: 160 178
			ignoreActors:
			setPri: 2
			init:
			stopUpd:
		)
		((= local1 (View new:))
			view: 341
			loop: 4
			cel: local22
			posn: 272 178
			ignoreActors:
			setPri: 2
			init:
			stopUpd:
		)
		(localproc_2)
		((= local2 (Prop new:))
			view: 340
			setLoop: 2
			cel: 0
			posn: 900 0
			setPri: 6
			ignoreActors:
			init:
			stopUpd:
		)
		((= local3 (Act new:))
			view: 340
			setLoop: 0
			cel: 0
			posn: 900 100
			setPri: 4
			ignoreActors:
			ignoreHorizon:
			init:
			stopUpd:
		)
		((= local4 (Act new:))
			view: 340
			setLoop: 6
			cel: 0
			posn: 900 200
			setPri: 7
			ignoreActors:
			init:
			stopUpd:
		)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(= temp0 (event message:))
		(if (super handleEvent: event)
			(return 1)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(if local17
					(event claimed: 1)
					(= temp1 (event x:))
					(= temp2 (event y:))
					(cond
						((localproc_0 temp1 temp2 33 17 107 76)
							(self cue:)
						)
						((localproc_0 temp1 temp2 149 154 176 166)
							(localproc_6 (- local21 1))
						)
						((localproc_0 temp1 temp2 189 154 218 166)
							(localproc_6 (+ local21 1))
						)
						((localproc_0 temp1 temp2 238 150 250 162)
							(localproc_7 (- local22 1))
						)
						((localproc_0 temp1 temp2 294 150 305 162)
							(localproc_7 (+ local22 1))
						)
						((localproc_0 temp1 temp2 155 172 211 180)
							(localproc_6 (/ (- temp1 160) 4))
						)
						((localproc_0 temp1 temp2 245 163 298 180)
							(localproc_7 (/ (- temp1 249) 3))
						)
					)
				)
			)
			(evKEYBOARD
				(cond
					((== KEY_QUESTION temp0)
						(event claimed: 1)
						(proc341_0)
					)
					((and local17 (== KEY_RETURN temp0))
						(event claimed: 1)
						(self cue:)
					)
				)
			)
			(evSAID
				(cond
					((Said 'stop,end,done,quit,done')
						(gCurRoom newRoom: 332)
					)
					(
						(or
							(Said 'ask//game,dagnabit,play,rule')
							(Said 'help,rule')
						)
						(proc341_0)
					)
					((Said 'bet,play,start')
						(HighPrint 340 1) ; "Let's finish this game first."
					)
				)
			)
			($0040 ; direction
				(event claimed: 1)
				(if local17
					(switch (event message:)
						(JOY_UP
							(localproc_6 (+ local21 1))
						)
						(JOY_DOWN
							(localproc_6 (- local21 1))
						)
						(JOY_RIGHT
							(localproc_7 (+ local22 1))
						)
						(JOY_LEFT
							(localproc_7 (- local22 1))
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(repeat
					(cond
						(
							(<=
								(= local19
									(GetNumber
										{"How much will you bet?"}
										local19
									)
								)
								0
							)
							(HighPrint 340 2) ; "If you don't bet, you can't play."
							(gCurRoom newRoom: 332)
							(return)
						)
						((> local19 50)
							(HighPrint 340 3) ; "Now, let's not get carried away."
						)
						((not (Purchase local19))
							(HighPrint 340 4) ; "Hey! This is cash on the table. You can't bet what you don't have."
						)
						(else
							(break)
						)
					)
				)
				(if (>= global269 100)
					(HighPrint 340 5) ; "So, you think you're pretty hot stuff, eh? Well, we'll see about that."
				)
				(++ global300)
				(= local16 (= local12 (= local14 (= local15 0))))
				(= local20 (- (Random 60 90) local19))
				(= local35 0)
				(localproc_1 local14 14 47 173)
				(localproc_1 local15 11 73 173)
				(self cue:)
			)
			(1
				(HandsOff)
				(= local13 0)
				(= local18 1)
				(localproc_2)
				(self setScript: blinkScript)
			)
			(2
				(localproc_3)
				(self setScript: throwScript)
				(self cue:)
			)
			(3
				(local2 cel: 0 posn: local8 local9 forceUpd:)
				(local4
					setLoop: 6
					cel: 0
					posn: local8 local9
					setPri: 7
					forceUpd:
				)
				(HandsOn)
				(= local17 1)
			)
			(4
				(= local17 0)
				(HandsOff)
				(localproc_4)
				(script changeState: 1)
			)
			(5
				(localproc_1 local14 14 47 173)
				(if (< (++ local13) 3)
					(localproc_2)
					(self changeState: 3)
				else
					(local2 posn: 900 0)
					(self cue:)
				)
			)
			(6
				(local5 show:)
				(local6 hide:)
				(= local18 0)
				(= local13 0)
				(localproc_2)
				(self setScript: blinkScript)
			)
			(7
				(self setScript: throwScript)
				(self cue:)
			)
			(8
				(local2 cel: 0 posn: local8 local9 forceUpd:)
				(= cycles 20)
			)
			(9
				(localproc_5)
				(++ local16)
				(script changeState: 1)
			)
			(10
				(localproc_1 local15 11 73 173)
				(if (< (++ local13) 3)
					(self changeState: 8)
				else
					(local6 show:)
					(local2 posn: 900 0)
					(++ local12)
					(= cycles 5)
				)
			)
			(11
				(if (< local12 3)
					(self changeState: 1)
				else
					(self cue:)
				)
			)
			(12
				(HandsOn)
				(cond
					((> local14 local15)
						(gEgo get: 1 (+ local19 local19)) ; silver
						(HighPrint 340 6) ; "You got me that time. Say, you're pretty tough!"
						(if (>= local19 25)
							(SolvePuzzle 644 5 2)
						)
						(+= global269 local19)
					)
					((< local14 local15)
						(HighPrint 340 7) ; "Looks like I won that one. Must have gotten lucky."
						(-= global269 local19)
					)
					(else
						(gEgo get: 1 local19) ; silver
						(if (<= local19 25)
							(HighPrint 340 8) ; "It's a tie. Let's double the wager."
							(+= local19 local19)
						else
							(HighPrint 340 9) ; "Hey, nice game. It's a tie."
						)
					)
				)
				(localproc_3)
				(Print 340 10) ; "Shall we play again?"
				(self setScript: askPlayAgain self)
			)
			(13
				(if local7
					(self changeState: 0)
				else
					(gCurRoom newRoom: 332)
				)
			)
		)
	)
)

(instance askPlayAgain of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((!= (event type:) evSAID))
			((Said 'yes,please,play')
				(= local7 1)
				(self dispose:)
			)
			((Said 'no,stop,quit')
				(= local7 0)
				(self dispose:)
			)
			(else
				(event claimed: 1)
				(HighPrint 340 11) ; "Just answer the question. Shall we play again?"
			)
		)
	)
)

(instance throwScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0)
			(1
				(= local36 gSpeed)
				(gGame setSpeed: 0)
				(local2 cycleSpeed: 2 setCycle: CT 2 1 self)
				(if local18
					(local4 cycleSpeed: 2 setCycle: CT 2 1)
				)
			)
			(2
				(local2 cycleSpeed: 0 setCycle: End self)
				(if local18
					(local4 cycleSpeed: 0 setCycle: End)
				)
				(dagMusic number: (SoundFX 31) play:)
			)
			(3
				(local2 stopUpd:)
				(if local18
					(local4 posn: 900 200 stopUpd:)
				)
				(local3
					posn: local8 local9
					setPri: 4
					setLoop: (if local18 4 else 0)
					cel: 0
					cycleSpeed: 0
					moveSpeed: 0
					ignoreActors:
					ignoreControl: -1
					setCycle: End self
					setMotion: MoveTo local10 (+ local11 1)
				)
			)
			(4
				(local3
					setPri: 3
					setLoop: (if local18 5 else 1)
					cel: 0
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Fwd
					setMotion: MoveTo local10 local11 self
				)
			)
			(5
				(local3 posn: 900 100 stopUpd:)
				(local2 cel: 0 forceUpd: stopUpd:)
				((= [local23 local35] (View new:))
					view: 340
					loop: (if local18 7 else 3)
					cel: 3
					posn: local10 local11
					ignoreActors:
					setPri: 1
					init:
					stopUpd:
				)
				(++ local35)
				(dagMusic stop:)
				(dagMusic
					number:
						(if local18
							(SoundFX 29)
						else
							(SoundFX 30)
						)
					play:
				)
				(= temp0
					(cond
						((< local10 65) 0)
						((> local10 75) 2)
						(else 1)
					)
				)
				(= local10 (+ (* (- local10 70) 2) 229))
				(= local11 (+ (* (- local11 45) 2) 61))
				((= [local23 local35] (View new:))
					view: 340
					loop: (if local18 7 else 3)
					cel: temp0
					posn: local10 local11
					ignoreActors:
					setPri: 1
					init:
					stopUpd:
				)
				(++ local35)
				(= temp1
					(switch (OnControl CONTROL local10 local11)
						(2 1)
						(4 2)
						(8 3)
						(16 4)
						(else 0)
					)
				)
				(if local18
					(+= local14 temp1)
				else
					(+= local15 temp1)
				)
				(gGame setSpeed: local36)
				(client cue:)
			)
		)
	)
)

(instance blinkScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(= temp0 (if local18 local5 else local6))
		(switch (= state newState)
			(0
				(= register 3)
				(self cue:)
			)
			(1
				(temp0 hide:)
				(if (not (-- register))
					(self changeState: 3)
				)
				(= cycles 6)
			)
			(2
				(temp0 show:)
				(= state 0)
				(= cycles 6)
			)
			(3
				(client cue:)
			)
		)
	)
)

(instance dagMusic of Sound
	(properties
		number 31
	)
)

(instance dagStatus of Code
	(properties)

	(method (doit param1)
		(Format param1 340 12 gScore) ; "Dag-Nab-It [score %d of 500]"
	)
)

