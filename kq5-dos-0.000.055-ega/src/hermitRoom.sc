;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use Interface)
(use Waters)
(use RandCycle)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	hermitRoom 0
)

(local
	[local0 18] = [277 113 80 278 154 80 277 188 80 400 0 80 400 0 80 400 0 80]
	local18 = 1
)

(instance hermitRoom of Rm
	(properties
		picture 46
	)

	(method (dispose)
		(DisposeScript 751)
		(DisposeScript 401)
		(super dispose:)
	)

	(method (init)
		(Load rsSCRIPT 751)
		(proc0_24 128 624 626 628 623 625 26)
		(Load rsSCRIPT 751)
		(gGlobalSound number: 7 loop: -1 vol: 127 play:)
		(gEgo init: hide:)
		((gEgo head:) hide:)
		(hermit init: hide:)
		(HandsOff)
		(super init:)
		(if (== global361 46)
			(movingBoat init: ignoreActors:)
			(sail
				posn: (- (movingBoat x:) 10) (movingBoat y:)
				setCycle: Fwd
				ignoreActors:
				cycleSpeed: 30
				init:
			)
		)
		(chimney setCycle: Fwd cycleSpeed: 3 init:)
		(if (!= global81 3)
			(chimney setCycle: 0)
			(sail setCycle: 0)
		)
		(if (not (IsFlag 56))
			(= global320 100)
			(= global321 140)
			(gCurRoom setRegions: 202) ; owl
			(global322 setScript: myRotate)
		)
		(hermit
			view: 628
			setLoop: 1
			cel: 0
			cycleSpeed: 2
			posn: 148 146
			setPri: 10
			init:
		)
		(self setScript: cartoon2)
	)
)

(instance myRotate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global322 view: 138 loop: 2 setCycle: End self)
			)
			(1
				(global322 view: 137 loop: 8 cycleSpeed: 50 setCycle: RandCycle)
			)
			(2
				(client setScript: 0)
			)
		)
	)
)

(instance egoHeadMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gEgo head:) loop: (Random 4 6))
				(-- state)
				(= cycles 5)
			)
		)
	)
)

(instance cartoon2 of Script
	(properties)

	(method (doit)
		(super doit:)
		(sail posn: (- (movingBoat x:) 10) (movingBoat y:))
		(if (and (== state 4) (== (gGlobalSound3 prevSignal:) -1))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 624
					posn: 120 148
					normal: 1
					ignoreActors: 1
					illegalBits: 0
					setPri: -1
					init:
				)
				(hermit
					view: 626
					setCycle: Walk
					cycleSpeed: 0
					setLoop: -1
					ignoreActors: 1
					posn: 90 148
					illegalBits: 0
					show:
					init:
				)
				(= cycles 1)
			)
			(1
				(hermit setMotion: MoveTo 175 148)
				(= cycles 30)
			)
			(2
				(gEgo
					show:
					setCycle: End self
					setLoop: 13
					setMotion: MoveTo 130 148 self
				)
			)
			(3
				((gEgo head:) show:)
				(gEgo
					show:
					view: 0
					setCycle: Walk
					setMotion: MoveTo 130 148 self
				)
			)
			(4
				(gEgo setLoop: 0 setMotion: MoveTo 160 160)
				(hermit view: 628 setLoop: 2)
				(arm
					posn: (- (hermit x:) 5) (- (hermit y:) 32)
					setPri: (+ (hermit priority:) 1)
					loop: 1
					setCycle: CT 8 1
					init:
				)
				(gGlobalSound3 number: 821 loop: 1 vol: 127 play:)
			)
			(5
				(arm setCycle: End)
				(hermit setLoop: 2)
				(= seconds 5)
			)
			(6
				(mermaid
					init:
					setLoop: 8
					cycleSpeed: 2
					posn: 275 155
					setCycle: End self
				)
			)
			(7
				(mermaid setLoop: 7 cycleSpeed: 3 setCycle: Fwd)
				(= cycles 1)
			)
			(8
				(mouth
					init:
					setCycle: RandCycle
					setPri: (+ (hermit priority:) 1)
					cycleSpeed: 2
					posn: (+ (hermit x:) 3) (- (hermit y:) 37)
				)
				(PrintDC 110 0 #at 10 10 #dispose) ; "Pearl, this man needs your help. He needs you to lead him to Mordack's island. It's a real 'mergency. Mordack's holdin' his family hostage."
				(= seconds 10)
			)
			(9
				(mouth setCycle: 0)
				(cls)
				(= seconds 3)
			)
			(10
				(mouth setCycle: RandCycle)
				(PrintDC 110 1 #at 10 10 #dispose) ; "Pearl cain't speak human talk but she's agreed to help you. Just get on into your boat and folla her."
				(= seconds 7)
			)
			(11
				(mouth setCycle: 0)
				(cls)
				((gEgo head:) setCel: 1 setScript: egoHeadMove)
				(if (not (IsFlag 56))
					(PrintDC 110 2 #at 100 10 #dispose) ; "Cedric and I want to thank you for all your help, Mr....uh?"
					(= seconds 6)
				else
					(PrintDC 110 3 #at 100 10 #dispose) ; "I want to thank you for all your help, Mr....uh?"
					(= seconds 6)
				)
			)
			(12
				((gEgo head:) setCel: 1 loop: 4 setScript: 0)
				(mouth setCycle: RandCycle)
				(cls)
				(PrintDC 110 4 #at 10 10 #dispose) ; "Don't worry about who I am. You just get on over to that there island and take care of your family."
				(= seconds 7)
			)
			(13
				(mouth setCycle: 0)
				(cls)
				((gEgo head:) setCel: 1 setScript: egoHeadMove)
				(if (not (IsFlag 56))
					(PrintDC 110 5 #at 100 10 #dispose) ; "Aye, aye, sir. We're off. Come on, Cedric."
					(= seconds 6)
				else
					(PrintDC 110 6 #at 100 10 #dispose) ; "Aye, aye, sir. I'm off."
					(= seconds 4)
				)
			)
			(14
				((gEgo head:) setCel: -1 setScript: 0)
				(cls)
				(mermaid setLoop: 10 cycleSpeed: 2 setCycle: End self)
			)
			(15
				(gEgo
					view: 0
					setCycle: Walk
					setLoop: -1
					setPri: 14
					illegalBits: 0
					ignoreActors:
					normal: 0
					setMotion: MoveTo 180 164 self
				)
			)
			(16
				(gEgo setMotion: MoveTo 215 175 self)
				(sail setPri: 15)
			)
			(17
				((gEgo head:) hide:)
				(gEgo
					view: 615
					loop: 2
					cycleSpeed: 2
					setPri: 14
					cel: 0
					setCycle: End self
				)
			)
			(18
				(gEgo
					setLoop: 3
					posn: (+ (gEgo x:) 31) (gEgo y:)
					setCycle: Fwd
				)
				(= seconds 2)
			)
			(19
				(gEgo
					posn: (gEgo x:) (- (gEgo y:) 18)
					setLoop: 0
					setCycle: End self
				)
				(mouth dispose:)
				(hermit
					view: 626
					setCycle: Walk
					setLoop: 1
					cycleSpeed: 0
					ignoreActors: 1
					setMotion: MoveTo 90 144
				)
				(arm hide:)
			)
			(20
				(gEgo setLoop: 1 cycleSpeed: 2 setCycle: End self)
				(movingBoat setStep: 1 1 setMotion: MoveTo 400 (movingBoat y:))
				(gEgo
					moveSpeed: (movingBoat moveSpeed:)
					setStep: 1 1
					setMotion: MoveTo 400 (gEgo y:)
				)
			)
			(21
				(gEgo
					view: 618
					setPri: 14
					loop: 4
					posn: (+ (gEgo x:) 20) (+ (gEgo y:) 2)
				)
				(if (not (hermit mover:))
					(door setCycle: Beg init:)
					(gGlobalSound3 number: 124 vol: 50 loop: 1 play:)
				)
				(= seconds 5)
			)
			(22
				(gEgo setMotion: 0)
				(movingBoat setMotion: 0)
				(sail setMotion: 0)
				(if (not (IsFlag 56))
					(global322
						view: 138
						setLoop: 6
						cycleSpeed: 0
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(23
				(gCurRoom newRoom: 113) ; hermit4
			)
		)
	)
)

(instance hermit of Act
	(properties
		signal 1
	)
)

(instance Hhead of Prop ; UNUSED
	(properties
		view 628
		signal 16384
	)
)

(instance mermaid of Act
	(properties
		view 624
		signal 1
	)
)

(instance surf of Waters ; UNUSED
	(properties
		view 623
		priority 1
		signal 24624
	)

	(method (getLoop)
		(= x [local0 pos])
		(= y [local0 (++ pos)])
		(= cel [local0 (++ pos)])
	)

	(method (saveLoop)
		(= [local0 pos] cel)
		(++ pos)
	)

	(method (doit)
		(super doit:)
		(if (and (== loop 0) (== cel 0))
			(if local18
				(= cycCnt 50)
			)
			(= local18 0)
		else
			(= local18 1)
		)
	)
)

(instance movingBoat of Act
	(properties
		y 173
		x 300
		view 618
		cel 1
		priority -1
		signal 1
	)
)

(instance chimney of Prop
	(properties
		y 70
		x 18
		z 20
		view 625
		loop 2
	)
)

(instance sail of Act
	(properties
		z 15
		view 618
		loop 2
	)
)

(instance door of Prop
	(properties
		y 147
		x 113
		view 625
	)
)

(instance arm of Prop
	(properties
		view 628
	)
)

(instance mouth of Prop
	(properties
		view 624
		loop 15
	)
)

