;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 560)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use DPath)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm560 0
)

(local
	seenMsg
	startingScore
	OB_counter
	destX
	theCounter
	killX
	[unused 2]
	lastLoop
	[string 120]
	[string2 66]
)

(instance rm560 of Rm
	(properties
		picture 560
		horizon -10
	)

	(method (init)
		(Load rsSOUND 4)
		(Load rsSOUND 561)
		(Load rsSCRIPT 964)
		(= destX 222)
		(= startingScore gScore)
		(super init:)
		(gAddToPics add: atpHorizon doit:)
		(aDot init:)
		(aRightBank init:)
		(aLeftBank init:)
		(aObstacle init:)
		(self setScript: RoomScript)
		(NormalEgo)
		(gEgo
			view: 561
			posn: 222 113
			setPri: 6
			setStep: 3 1
			setCycle: Fwd
			init:
		)
		(HandsOff)
		(gUser canControl: 1)
		(gMusic number: 560 loop: -1 priority: 9999 play:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 2) (< (aObstacle distanceTo: gEgo) 9))
			(self changeState: 6)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(== (event type:) evKEYBOARD)
				(== (event claimed:) 0)
				(== (event message:) KEY_F8)
				(< state 4)
			)
			(Print 560 0) ; "Skipping ahead..."
			(= gScore startingScore)
			(SetFlag 77) ; skippedLogRide
			(gCurRoom newRoom: 580)
			(return)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aObstacle hide:)
				(if (== (DotScript state:) 5)
					(self changeState: 4)
				else
					(= cycles (Random 5 10))
				)
			)
			(1
				(if (not (Random 0 2))
					(= destX (Random 200 235))
					(aLeftBank setMotion: MoveTo destX 92)
					(aRightBank setMotion: MoveTo destX 92 self)
				else
					(self cue:)
				)
				(if (and (not (Random 0 2)) (< DotScript 3))
					(= state -1)
				)
			)
			(2
				(if (> (= killX (Random 200 400)) 240)
					(= killX (gEgo x:))
				)
				(cond
					((< killX (- destX 5))
						(- killX 5)
					)
					((> killX (+ destX 5))
						(+ killX 5)
					)
				)
				(aObstacle
					posn: destX 89
					setLoop: (Random 0 lastLoop)
					cel: lastLoop
					setCycle: End
					show:
					setMotion: MoveTo killX (+ (gEgo y:) 5) self
				)
				(if (== (aObstacle loop:) 3)
					(-- lastLoop)
					(Print 560 1 #at -1 10) ; "Lookout, Patti! It's your worst nightmare!"
				)
			)
			(3
				(if (== (aObstacle loop:) 3)
					(Print 560 2 #at -1 10) ; "Children!!"
				)
				(gGame changeScore: lastLoop)
				(self changeState: 0)
			)
			(4
				(Print 560 3 #at -1 10) ; "You made it!"
				(gGame changeScore: (- 150 (- gScore startingScore)))
				(gGame changeScore: (- 150 (- gScore startingScore)))
				(= seconds 3)
			)
			(5
				(Print 560 4 #at -1 10) ; "But now what lies ahead?"
				(DisposeScript 964)
				(gMusic priority: 0)
				(gCurRoom newRoom: 580)
			)
			(6
				(= seconds (= cycles 0))
				(HandsOff)
				(aLeftBank setCel: 0)
				(aRightBank setCel: 0)
				(aDot setScript: 0 setMotion: 0 setCel: 0)
				(aObstacle hide:)
				(gEgo setLoop: 4 cel: 0 setCycle: End self)
			)
			(7
				(gMusic stop:)
				(Print 560 5 #at -1 10) ; "Oh, no!"
				(gSoundFX number: 4 loop: 1 play:)
				(aLog init:)
				(gEgo
					cycleSpeed: 0
					illegalBits: 0
					ignoreActors:
					setStep: 3 3
					setLoop: 5
					cel: 0
					setCycle: End self
					setMotion: MoveTo (aLeftBank x:) 100 self
				)
			)
			(8)
			(9
				(gSoundFX number: 561 loop: 1 play:)
				(gGame setScript: (ScriptID 40)) ; DyingScript
				((ScriptID 40) ; DyingScript
					caller: 563
					register: (Format @string 560 6) ; "Don't you just hate arcade games!"
					next: (Format @string2 560 7) ; "Insert Another Quarter"
				)
			)
		)
	)
)

(instance DotScript of Script
	(properties)

	(method (changeState newState)
		(ShowState self newState 2 2)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(= lastLoop 0)
				(aObstacle setStep: 2 2 cycleSpeed: 1)
				(aDot
					setMotion:
						DPath
						209
						179
						192
						183
						176
						186
						151
						187
						127
						186
						116
						182
						108
						182
						101
						179
						self
				)
			)
			(2
				(= lastLoop 1)
				(aObstacle setStep: 3 3 cycleSpeed: 0)
				(aDot
					setMotion:
						DPath
						93
						178
						78
						173
						66
						164
						55
						150
						51
						140
						41
						133
						36
						126
						36
						115
						35
						109
						29
						104
						31
						96
						35
						85
						38
						78
						self
				)
			)
			(3
				(= lastLoop 3)
				(aObstacle setStep: 4 4)
				(aDot
					setMotion:
						DPath
						35
						73
						39
						65
						45
						59
						48
						52
						56
						44
						67
						34
						78
						22
						self
				)
			)
			(4
				(aDot setMotion: DPath 86 15 100 9 109 4 112 -3 self)
			)
			(5
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance aDot of Actor
	(properties
		x 258
		y 188
		view 560
		cycleSpeed 1
		moveSpeed 1
	)

	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			setScript: DotScript
			setCycle: Fwd
			setLoop: 3
			setStep: 1 1
			setPri: 15
			illegalBits: 0
			ignoreActors:
		)
	)
)

(instance atpHorizon of PicView
	(properties
		x 223
		y 91
		view 560
		loop 1
		signal 16384
	)
)

(instance aLeftBank of Actor
	(properties
		x 222
		y 92
		view 560
	)

	(method (init)
		(super init:)
		(self
			setLoop: 0
			setCycle: Fwd
			setStep: 2 2
			illegalBits: 0
			ignoreActors:
		)
	)
)

(instance aRightBank of Actor
	(properties
		x 222
		y 92
		view 560
	)

	(method (init)
		(super init:)
		(self
			setLoop: 2
			setCycle: Fwd
			setStep: 2 2
			illegalBits: 0
			ignoreActors:
		)
	)
)

(instance aObstacle of Actor
	(properties
		x 222
		y 87
		view 562
	)

	(method (init)
		(super init:)
		(self setPri: 5 illegalBits: 0 ignoreActors:)
	)
)

(instance aLog of View
	(properties
		view 561
		loop 6
	)

	(method (init)
		(super init:)
		(self ignoreActors: setPri: 5 posn: (gEgo x:) (gEgo y:))
	)
)

