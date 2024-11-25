;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use Interface)
(use Follow)
(use Grooper)
(use Motion)
(use System)

(public
	greetingScript 0
)

(instance greetingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 25 1) ; captain
					init:
					setCycle: Walk
					setLoop: Grooper
					posn: 138 116
					illegalBits: 0
					setMotion: MoveTo 112 127 self
				)
				(gEgo view: 232 illegalBits: 0 setMotion: MoveTo 96 131 self)
			)
			(1)
			(2
				(Print 390 0) ; "Just as you enter the control room, the Captain greets you."
				(Print 390 1) ; "Welcome aboard, Commander Westland!"
				(Print 390 2) ; "Your credentials are admirable," he beams, "We're proud to have you as part of this team."
				(Print 390 3) ; "Rambling on he says, "The success of this mission depends on how fast we can move!""
				((ScriptID 25 1) setMotion: MoveTo 174 100 self) ; captain
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: Follow (ScriptID 25 1) ; captain
				)
			)
			(3
				((ScriptID 25 1) heading: 230) ; captain
				(((ScriptID 25 1) looper:) ; captain
					doit: (ScriptID 25 1) ((ScriptID 25 1) heading:) self ; captain, captain
				)
			)
			(4
				(Print 390 4) ; "Commander Westland," he says, "by now you have both reviewed the documentation and familiarized yourself with the operation of the control board."
				(Print 390 5) ; ""The training you received at submarine school will come into play now," he says."
				(Print 390 6) ; "Have a seat at the controls, John, it's time you learn to drive this baby."
				(Print 390 7) ; "I'll give you every command as we get underway."
				(Print 390 8) ; "Believe me, John," he continues, "by the time this mission is over, I guarantee you'll be an expert!"
				((ScriptID 25 1) setMotion: MoveTo 217 100 self) ; captain
				(gEgo illegalBits: 0 setMotion: MoveTo 182 82 self)
			)
			(5)
			(6
				(gEgo setScript: (ScriptID 25 2)) ; sitControlPanelScript
			)
		)
	)

	(method (dispose)
		(gEgo illegalBits: $8000)
		(super dispose:)
		(DisposeScript 390)
	)
)

