;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 199)
(include sci.sh)
(use Main)
(use Interface)
(use tahiti)
(use n824)
(use RFeature)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	danceRm 0
)

(local
	local0
	local1
)

(instance danceRm of Rm
	(properties
		picture 199
	)

	(method (init)
		(super init:)
		(Load rsVIEW 199)
		(Load rsVIEW 699)
		(Load rsVIEW 499)
		(Load rsVIEW 299)
		(gEgo
			view: 699
			posn: 163 111
			xStep: 5
			yStep: 3
			setAvoider: Avoid
			viewer: egoDanceViewer
			loop: 3
			init:
		)
		(armKBP init:)
		(armGP init:)
		(armP init:)
		(footP init:)
		((= local0 (ScriptID 309 0)) ; agent
			posn: 173 95
			view: 299
			setCycle: Walk
			ignoreActors: 0
			xStep: 5
			yStep: 3
			viewer: agentDanceViewer
			loop: 2
			setAvoider: Avoid
			init:
		)
		(husbandPV cel: (& (tahiti flags:) $0001))
		(if (& (tahiti flags:) $0002)
			(barPerson4PV cel: 3 x: 161 y: 38)
		else
			(barPerson4PV cel: 2)
		)
		(gAddToPics
			add:
				barPerson1PV
				barPerson2PV
				barPerson3PV
				barPerson4PV
				barPerson5PV
				barPerson6PV
				keyBoardPV
				keyboardistPV
				guitaristPV
				manInChairPV
				ladyInChairPV
				guitarist2PV
				flowersPV
				tablePV
				husbandPV
				topTablePV
			eachElementDo: #init
			doit:
		)
		(proc824_0)
		(self setRegions: 300 setScript: barDanceS) ; tahiti
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== (gEgo onControl: 1) 4096)
				(!= (self script:) quitScript)
			)
			(self setScript: quitScript)
		)
	)
)

(instance barDanceS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(barDanceSong number: (proc0_5 7) play:)
				(gEgo setScript: danceScript)
			)
			(1
				(armP setCycle: 0)
				(footP setCycle: 0)
				(armGP setCycle: 0)
				(armKBP setCycle: 0)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (== (barDanceSong prevSignal:) -1))
			(= cycles 1)
		)
	)
)

(instance agentDanceMoveTo of MoveTo
	(properties)

	(method (init param1 param2 param3)
		(local0
			heading:
				(GetAngle (local0 x:) (local0 y:) (gEgo x:) (gEgo y:))
			view: 299
		)
		(super init: param1 param2 param3)
	)

	(method (dispose)
		(client
			heading:
				(GetAngle (local0 x:) (local0 y:) (gEgo x:) (gEgo y:))
			view: 499
		)
		(DirLoop client (client heading:))
		(super dispose:)
	)

	(method (onTarget)
		(return
			(and (< (Abs (- (client x:) x)) 7) (< (Abs (- (client y:) y)) 5))
		)
	)

	(method (doit)
		(super doit:)
		(if (self onTarget:)
			(self motionCue:)
		)
	)
)

(instance egoDanceViewer of Code
	(properties)

	(method (doit)
		(gEgo view: (if (gEgo mover:) 199 else 699))
	)
)

(instance agentDanceViewer of Code
	(properties)

	(method (doit)
		(local0 view: (if (local0 mover:) 299 else 499))
	)
)

(instance danceMoveTo of MoveTo
	(properties)

	(method (onTarget)
		(return
			(and (< (Abs (- (client x:) x)) 7) (< (Abs (- (client y:) y)) 5))
		)
	)

	(method (doit)
		(super doit:)
		(if (self onTarget:)
			(self motionCue:)
		)
	)
)

(instance danceScript of Script
	(properties
		register 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(local0
					setCycle: Fwd
					observeControl: -16384
					setScript: agentsDanceS
				)
				(gEgo setCycle: Fwd moveSpeed: 1 observeControl: 16384)
				(= cycles 2)
			)
			(1
				(= start state)
				(if
					(or
						(== (gEgo mover:) local1)
						(>= (Abs (- register (GetTime 1))) 10) ; SysTime12
					)
					(if (Random 0 3)
						(gEgo heading: (Random 0 360))
						(if (gEgo looper:)
							((gEgo looper:) doit: gEgo (gEgo looper:))
						else
							(DirLoop gEgo (gEgo heading:))
						)
					else
						(gEgo
							setMotion:
								danceMoveTo
								(Random 130 180)
								(Random 105 135)
						)
					)
					(= local1 (gEgo mover:))
					(= register (GetTime 1)) ; SysTime12
					(local0 cue:)
				)
				(= cycles (Random 10 40))
			)
			(2
				(if (and (== (barDanceSong prevSignal:) -1) (not global55))
					(client setScript: quitScript)
				else
					(self init:)
				)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'exit,sit,stop,quit[/dancing]')
					(Said 'exit[/floor<dance]')
					(Said 'dancing<stop')
				)
				(barDanceSong fade:)
				(self setScript: quitScript)
			)
			(
				(or
					(Said 'buy,order/drink,(tai<mai)[/woman,stacy]')
					(Said 'buy,order/drink,(tai<mai)<woman,stacy')
				)
				(Print 199 0) ; "Wait till we sit down."
			)
			((Said 'hold,hug,kiss[/woman,stacy]')
				(Print 199 1) ; "That's a little hard to do at the moment."
			)
			((Said 'dance[/woman,stacy]')
				(Print 199 2) ; "You already are!"
			)
			((Said 'look<around')
				(Print 199 3) ; "Some dance floor!"
			)
			((Said 'ask/woman/date')
				(Print 199 4) ; "Maybe. If you're lucky."
			)
		)
	)
)

(instance quitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(barDanceSong fade:)
				(gEgo setMotion: 0)
				(= cycles 15)
			)
			(1
				(gEgo ignoreControl: 16384 moveSpeed: 0)
				(gCurRoom newRoom: 11) ; hotelBar
			)
		)
	)
)

(instance agentsDanceS of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(= register (gEgo mover:))
		(switch (= state newState)
			(0
				(if register
					(= temp0 ((gEgo mover:) x:))
					(= temp1 ((gEgo mover:) y:))
					(cond
						((< temp0 110)
							(= temp0 110)
						)
						((> temp0 220)
							(= temp0 220)
						)
					)
					(cond
						((< temp1 110)
							(= temp1 110)
						)
						((> temp1 170)
							(= temp1 170)
						)
					)
				else
					(= temp0 (gEgo x:))
					(= temp1 (gEgo y:))
				)
				(local0
					setMotion:
						agentDanceMoveTo
						(+ temp0 (SinMult (gEgo heading:) 30))
						(- temp1 (/ (* (CosMult (gEgo heading:) 30) 2) 3))
				)
				(= cycles 35)
			)
			(1
				(self init:)
			)
		)
	)
)

(instance barPerson1PV of RPicView
	(properties
		y 47
		x 93
		view 399
		priority 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/!*]')
				(Print 199 5) ; "A woman sitting at the bar blows a smoke ring."
			)
		)
	)
)

(instance barPerson2PV of RPicView
	(properties
		y 59
		x 309
		view 399
		loop 1
		priority 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/!*]')
				(Print 199 6) ; "A local having a drink."
			)
		)
	)
)

(instance barPerson3PV of RPicView
	(properties
		y 46
		x 124
		view 399
		cel 1
		priority 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/!*]')
				(Print 199 7) ; "A man sitting at the bar."
			)
		)
	)
)

(instance barPerson4PV of RPicView
	(properties
		y 45
		x 162
		view 399
		cel 2
		priority 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/!*]')
				(if (== cel 2)
					(Print 199 8) ; "A young lady with a flirtatious smile winks at you."
				else
					(Print 199 9) ; "An empty bar stool."
				)
			)
		)
	)
)

(instance barPerson5PV of RPicView
	(properties
		y 38
		x 195
		view 399
		cel 3
		priority 0
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/!*]')
				(Print 199 9) ; "An empty bar stool."
			)
		)
	)
)

(instance barPerson6PV of RPicView
	(properties
		y 46
		x 255
		view 399
		loop 2
		priority 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/!*]')
				(Print 199 6) ; "A local having a drink."
			)
		)
	)
)

(instance keyBoardPV of RPicView
	(properties
		y 143
		x 17
		view 99
		loop 2
		priority 14
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/keyboard]')
				(Print 199 10) ; "This electric piano is one hot keyboard."
			)
			((Said 'look[<at]/band')
				(Print 199 11) ; "The hottest little band going, "Reggie-Bob and the Gnats," performing for your dancing pleasure."
			)
			((Said 'talk/band')
				(switch (Random 0 3)
					(0
						(Print 199 12) ; "They're too busy a-picking and a-grinning."
					)
					(1
						(Print 199 13) ; "They don't talk when they're hammin' and jammin'."
					)
					(2
						(Print 199 14) ; "Come on now, not in the middle of this good song."
					)
					(3
						(Print 199 15) ; "These dudes are gettin' down! They're not going to stop and crank up a conversation."
					)
				)
			)
		)
	)
)

(instance armKBP of Prop
	(properties
		y 114
		x 7
		view 99
		loop 1
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: 15 isExtra:)
	)
)

(instance keyboardistPV of RPicView
	(properties
		y 161
		x 4
		view 99
		priority 14
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/man]')
				(Print 199 16) ; "This is Reggie Bob on the keyboards."
			)
			((Said 'talk[/man]')
				(Print 199 17) ; "Reggie is so into it that his fingers do his talking."
			)
		)
	)
)

(instance armGP of Prop
	(properties
		y 82
		x 15
		view 99
		loop 7
		priority 14
		signal 16
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self isExtra:)
	)
)

(instance guitaristPV of RPicView
	(properties
		y 118
		x 12
		view 99
		loop 6
		priority 14
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/man,player<guitar]')
				(Print 199 18) ; "This is Mark, playing his famous RD-Artist."
			)
			((Said 'talk[/man]')
				(Print 199 19) ; "The stuff he's puttin' out right now doesn't allow him any time to talk."
			)
		)
	)
)

(instance manInChairPV of RPicView
	(properties
		y 198
		x 215
		view 599
		loop 3
		priority 15
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/man]')
				(Print 199 20) ; "This is Chris Hoyt, programmer of KQ4 and now The Colonel's Bequest."
			)
		)
	)
)

(instance ladyInChairPV of RPicView
	(properties
		y 198
		x 289
		view 599
		loop 2
		priority 15
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/woman[<blond]]')
				(Print 199 21) ; "This girl is with a date."
			)
		)
	)
)

(instance flowersPV of RPicView
	(properties
		y 164
		x 248
		view 599
		loop 1
		priority 15
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/flower,centerpiece]')
				(Print 199 22) ; "There are flowers on the table."
			)
		)
	)
)

(instance tablePV of RPicView
	(properties
		y 189
		x 252
		view 599
		priority 14
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/table]')
				(Print 199 23) ; "This is the table."
			)
		)
	)
)

(instance guitarist2PV of RPicView
	(properties
		y 135
		x 42
		view 99
		loop 3
		priority 14
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/man]')
				(Print 199 24) ; "This is Paul on guitar."
			)
		)
	)
)

(instance armP of Prop
	(properties
		y 96
		x 48
		view 99
		loop 4
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: 14 isExtra:)
	)
)

(instance footP of Prop
	(properties
		y 135
		x 47
		view 99
		loop 5
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: 15 isExtra:)
	)
)

(instance barDanceSong of Sound
	(properties
		number 7
		loop -1
	)

	(method (play)
		(= prevSignal 0)
		(armP setCycle: Fwd)
		(footP setCycle: Fwd)
		(armGP setCycle: Fwd)
		(armKBP setCycle: Fwd)
		(super play: &rest)
	)
)

(instance husbandPV of RPicView
	(properties
		y 81
		x 300
		view 599
		loop 4
		priority 4
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/man]')
				(Print 199 25) ; "This is a local having a drink with his wife."
			)
		)
	)
)

(instance topTablePV of RPicView
	(properties
		y 79
		x 314
		view 599
		loop 5
		priority 4
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/table]')
				(if (husbandPV cel:)
					(Print 199 26) ; "A big Samoan is at this table with his wife."
				else
					(Print 199 27) ; "This is the table with the blonde."
				)
			)
		)
	)
)

