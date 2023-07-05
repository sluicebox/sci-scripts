;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 335)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	breathScript 0
)

(instance breathScript of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 335)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 331 2) setLoop: 6 setMotion: MoveTo 171 78 self) ; bartender
			)
			(1
				((ScriptID 331 2) ; bartender
					view: 337
					setLoop: 0
					cel: 0
					posn: 169 78
					setCycle: CT 5 1 self
				)
			)
			(2
				((ScriptID 331 3) hide:) ; smoke
				((ScriptID 331 4) number: (SoundFX 44) play:) ; barSound
				((ScriptID 331 1) loop: 2 cel: 0 setCycle: CT 6 1 self) ; DB
			)
			(3
				((ScriptID 331 1) setCycle: CT 9 1) ; DB
				((ScriptID 331 2) setCycle: End self) ; bartender
			)
			(4
				((ScriptID 331 1) setCycle: End self) ; DB
			)
			(5
				((ScriptID 331 1) loop: 3 cel: 0 posn: 159 47) ; DB
				(self cue:)
			)
			(6
				((ScriptID 331 4) number: (SoundFX 43) play:) ; barSound
				((ScriptID 331 1) ; DB
					posn: ((ScriptID 331 1) x:) (- ((ScriptID 331 1) y:) 3) ; DB, DB
					setCycle: CT (+ ((ScriptID 331 1) cel:) 1) 1 self ; DB
				)
			)
			(7
				(if (!= ((ScriptID 331 1) cel:) 12) ; DB
					(self changeState: 6)
				else
					(self cue:)
				)
			)
			(8
				((ScriptID 331 1) posn: 159 68 stopUpd:) ; DB
				((ScriptID 331 3) show:) ; smoke
				((ScriptID 331 2) cel: 2 setCycle: Beg self) ; bartender
			)
			(9
				((ScriptID 331 2) view: 336 setLoop: 1 cel: 0 stopUpd:) ; bartender
				(if (IsFlag 254)
					(gEgo loop: 3 cel: 0)
					((ScriptID 331 5) hide:) ; head
				)
				(= global336 0)
				(= global337 3)
				(HighPrint 335 0 83) ; "There ya go!"
				(self dispose:)
			)
		)
	)
)

