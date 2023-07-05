;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 421)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use Motion)
(use System)

(public
	ManagerScript 0
)

(local
	punchCounter
	[string 40]
	[string2 22]
)

(instance ManagerScript of Script
	(properties)

	(method (changeState newState)
		(ShowState self newState 4 2)
		(switch (= state newState)
			(0
				(Load rsVIEW 423)
				(Load rsSOUND 6)
				(Load rsSOUND 3)
				(Load rsSOUND 12)
			)
			(1
				(Print 421 0) ; "Ignoring the "Authorized Personnel Only" sign on the stage door, you merrily bang away. Probably nothing will happen..."
				(gSomeObject setCycle: End self)
				(gMusic number: 6 loop: -1 play:)
			)
			(2
				(gSomeObject stopUpd:)
				(client setPri: 9 setCycle: Fwd posn: 33 143)
				(= seconds 3)
			)
			(3
				(Print 421 1 #at 10 5 #width 290) ; "Who in the hell do you think you are to knock on my stage door and disturb my show?" roars the burly stage manager. "How dare you!"
				(Print 421 2 #at -1 144) ; "(Oh, no, Larry! What have you done now?)"
				(client loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(gEgo hide:)
				(client loop: 2 cel: 0 setCycle: End self)
			)
			(5
				(Print 421 3 #at -1 10 #dispose) ; "Ouch!"
				(gGame setSpeed: 1)
				(= seconds 3)
			)
			(6
				(cls)
				(client
					loop: 3
					cycleSpeed: (Random 0 2)
					cel: 0
					setCycle: End self
				)
				(if (>= 10 (++ punchCounter))
					(-- state)
				)
			)
			(7
				(client loop: 4 cel: 0 setCycle: End self)
			)
			(8
				(gEgo
					view: 421
					setLoop: 5
					posn: 60 128
					setStep: 20 9
					setPri: 11
					setMotion: MoveTo 312 68 self
					show:
				)
				(gMusic stop: number: 3 loop: 1 play:)
				(client loop: 0 cel: 0 stopUpd:)
				(gCurRoom north: 0 east: 0)
			)
			(9
				(gMusic stop: number: 12 loop: 1 play:)
				(client hide:)
				(gSomeObject setCycle: Beg self)
			)
			(10
				(gGame setScript: (ScriptID 40)) ; DyingScript
				((ScriptID 40) ; DyingScript
					caller: 423
					register: (Format @string 421 4) ; "You know, indiscriminate knocking could well be the death of you..."
					next: (Format @string2 421 5) ; "That's you all over!"
				)
				(self dispose:)
			)
		)
	)
)

