;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 134)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Motion)
(use Menu)
(use Actor)
(use System)

(public
	egoDies 0
	monkDead 1
)

(instance oldOnes of Act
	(properties
		view 332
		signal 16384
		illegalBits 0
	)
)

(instance egoDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 23
					setLoop:
						(if (> (gEgo loop:) 1)
							(- (gEgo loop:) 2)
						else
							(gEgo loop:)
						)
					cel: 0
					setMotion: 0
					setScript: 0
					setCycle: End self
				)
			)
			(1
				(EgoDead 134 0) ; "Your skull is cracked, Your body dead, Your brains are gone, Your spirit fled, The Monk played tag Upon your head."
			)
		)
	)
)

(instance monkDead of Script
	(properties)

	(method (dispose)
		(oldOnes dispose: delete:)
		((ScriptID 111 1) dispose: delete:) ; monk1
		((ScriptID 111 2) dispose: delete:) ; monk2
		((ScriptID 111 3) dispose: delete:) ; monk3
		(super dispose:)
		((ScriptID 111 0) dispose:) ; monkAttack
		(DisposeScript 972)
		(DisposeScript 917)
		(DisposeScript 985)
		(DisposeScript 134)
	)

	(method (doit)
		(if (and (not global80) (!= state 8))
			(HandsOff)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(MenuBar state: 0)
				(global113
					view: 340
					setCel: -1
					setLoop: 0
					setMotion: 0
					setScript: 0
					setCycle: End self
				)
			)
			(1
				(Load rsSOUND 101)
				(gRegMusic stop: number: 24 loop: 1 play:)
				(if (!= (ScriptID 111 1) global113) ; monk1
					(((ScriptID 111 1) script:) changeState: 6) ; monk1
				)
				(if (!= (ScriptID 111 2) global113) ; monk2
					(((ScriptID 111 2) script:) changeState: 6) ; monk2
				)
				(if (!= (ScriptID 111 3) global113) ; monk3
					(((ScriptID 111 3) script:) changeState: 6) ; monk3
				)
				(= seconds 3)
			)
			(2
				(gTObj talkCue: self)
				(Talk 134 1) ; "Arrghh...in vino veritas..."
				(global113 ignoreActors: 1 illegalBits: 0)
			)
			(3
				(= global125 2)
				(Print 134 2 #time 4) ; "Well done, Arthur!"
				(gRmMusic number: 101 loop: -1 play:)
				(ClearFlag 48)
				(SetFlag 49)
				(= cycles 20)
			)
			(4
				(global113
					setScript: 0
					cycleSpeed: 2
					setLoop: 2
					ignoreActors: 1
					illegalBits: 0
					cel: 0
					setCycle: End
				)
				(oldOnes
					cycleSpeed: 3
					setLoop: 1
					posn: (- (global113 x:) 38) (- (global113 y:) 46)
					cel: 0
					setCycle: End self
					init:
				)
			)
			(5
				(oldOnes
					setLoop: 0
					setPri: 7
					cel: 0
					setStep: 2 1
					cycleSpeed: 1
					setCycle: Fwd
					ignoreActors:
					setMotion: MoveTo 143 98 self
				)
			)
			(6
				((ScriptID 111 4) ; madMonkFightingWindow
					title: {Old Ones}
					back: 5
					color: 11
					brBottom: 40
				)
				(gTObj talkCue: self)
				(Talk 134 3 134 4) ; "We are the Old Ones and you have killed the monk, our servant, the only servant we have had for centuries."
			)
			(7
				(oldOnes setLoop: 1 cel: 6 setCycle: Beg self)
				(gRmMusic fade:)
			)
			(8
				(gRegMusic number: 18 loop: -1 play:)
				(HandsOn)
				(MenuBar state: 1)
				(self dispose:)
			)
		)
	)
)

