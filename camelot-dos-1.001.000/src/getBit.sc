;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 187)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Motion)
(use User)
(use Menu)
(use System)

(public
	getBit 0
)

(instance getBit of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'get,capture,kill,attack,annihilate/adder')
				(= global125 1)
			)
			((Said 'draw/blade')
				(event claimed: 0)
			)
			(else
				(Print 187 0 #at -1 30) ; "Arthur! Defend yourself!"
				(event claimed: 1)
			)
		)
	)

	(method (doit)
		(if (and (== (gSFX prevSignal:) -1) (== state 5))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				((ScriptID 47 1) ; theCobra
					ignoreActors:
					illegalBits: 0
					setCycle: Walk
					setLoop:
						(cond
							((<= 176 (gEgo x:) 223) 0)
							((<= 224 (gEgo x:) 272) 1)
							((<= (gEgo x:) 175) 1)
							((>= (gEgo x:) 273) 0)
						)
					posn:
						(cond
							((<= 176 (gEgo x:) 223) 128)
							((<= 224 (gEgo x:) 272) 326)
							((<= (gEgo x:) 175) 224)
							((>= (gEgo x:) 273) 230)
						)
						133
					init:
				)
				(self cue:)
			)
			(1
				(Face gEgo (ScriptID 47 1)) ; theCobra
				(if (or (<= 176 (gEgo x:) 223) (>= (gEgo x:) 273))
					((ScriptID 47 1) ; theCobra
						setMotion: MoveTo (- (gEgo x:) 25) (gEgo y:) self
					)
				else
					((ScriptID 47 1) ; theCobra
						setMotion: MoveTo (+ (gEgo x:) 25) (gEgo y:) self
					)
				)
			)
			(2
				(HandsOff)
				(= global124 0)
				(MenuBar state: 0)
				(gSFX number: 75 loop: 1 priority: 5 play:)
				(gRmMusic stop:)
				(gRegMusic stop:)
				((ScriptID 47 1) ; theCobra
					setLoop:
						(switch ((ScriptID 47 1) loop:) ; theCobra
							(0 2)
							(1 3)
						)
					setCycle: End self
				)
			)
			(3
				((ScriptID 47 1) setCycle: Beg self) ; theCobra
				(if (gEgo script:)
					(gEgo setScript: 0)
				)
				(gEgo
					view: 23
					setLoop:
						(if (> (gEgo loop:) 1)
							(- (gEgo loop:) 2)
						else
							(gEgo loop:)
						)
					cel: 0
					setCycle: End
				)
			)
			(4
				((ScriptID 47 1) ; theCobra
					y: (+ ((ScriptID 47 1) y:) 8) ; theCobra
					setLoop: (+ ((ScriptID 47 1) loop:) 2) ; theCobra
					cel: 0
					setCycle: End
				)
				(= cycles 15)
			)
			(5
				(Print 187 1 #dispose) ; "Did I not warn you? This valley may truly be called a dead end, especially for you."
			)
			(6
				(clr)
				(EgoDead)
			)
		)
	)
)

