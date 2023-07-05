;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 183)
(include sci.sh)
(use Main)
(use Interface)
(use Follow)
(use Motion)
(use System)

(public
	thanksBuddy 0
	hireMe 1
	payAttempt 2
	followMe 3
	dodgeHim 4
)

(instance thanksBuddy of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 183)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
				(Talk 183 0) ; "Excellent! Let us waste no time! Follow me."
			)
			(1
				((ScriptID 130 1) hide:) ; jabirHead
				((ScriptID 130 0) ; Jabir
					view: 389
					setLoop: -1
					cycleSpeed: 0
					illegalBits: 0
					setCycle: Walk
				)
				(if (gEgo inRect: 90 167 125 189)
					((ScriptID 130 0) ; Jabir
						setMotion: MoveTo 150 ((ScriptID 130 0) y:) self ; Jabir
					)
				else
					(self cue:)
				)
			)
			(2
				(if (gEgo inRect: 90 167 125 189)
					((ScriptID 130 0) setMotion: MoveTo 165 185 self) ; Jabir
				else
					((ScriptID 130 0) setMotion: MoveTo 113 185 self) ; Jabir
				)
			)
			(3
				(gCurRoom goingOut: 1)
				((ScriptID 130 0) setMotion: MoveTo 118 235) ; Jabir
				(if (and (< (gEgo y:) 160) (< (gEgo x:) 196))
					(gEgo setMotion: MoveTo 200 (gEgo y:) self)
				else
					(self cue:)
				)
			)
			(4
				(gMuleObj setMotion: Follow gEgo 40)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 185 235 self
				)
			)
			(5
				(self dispose:)
				(gCurRoom newRoom: 37)
			)
		)
	)
)

(instance hireMe of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 183)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 130 0) setCycle: End self) ; Jabir
			)
			(1
				(gTObj talkCue: self)
				(Talk 183 1 183 2) ; "I knew you must come this way, and see, I have gotten here before you and waited."
			)
			(2
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance payAttempt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
				(Talk 183 3 183 4) ; "I thank you, habib. You need not pay me until we reach Jerusalem."
			)
			(1
				(= global189 2)
				((ScriptID 130 0) setScript: thanksBuddy) ; Jabir
			)
		)
	)
)

(instance followMe of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 183)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 130 0) setCycle: End self) ; Jabir
			)
			(1
				(gTObj talkCue: self)
				(Talk 183 5) ; "It is a hard climb. Rest here, if you like. I shall wait for you just ahead."
			)
			(2
				((ScriptID 130 1) hide:) ; jabirHead
				((ScriptID 130 0) ; Jabir
					view: 389
					setLoop: -1
					cycleSpeed: 0
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 118 235 self
				)
			)
			(3
				(= global189 0)
				(client setScript: 0 dispose:)
			)
		)
	)
)

(instance dodgeHim of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 183)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 130 1) hide:) ; jabirHead
				((ScriptID 130 0) ; Jabir
					view: 399
					ignoreActors: 1
					illegalBits: 0
					cycleSpeed: 0
					setCycle: Walk
					setStep: 8 5
					setLoop: 0
					setMotion: MoveTo 150 ((ScriptID 130 0) y:) self ; Jabir
				)
			)
			(1
				((ScriptID 130 0) setLoop: 2 setMotion: MoveTo 170 235 self) ; Jabir
			)
			(2
				(Print 183 6) ; "Jabir liked not the sound of your steel being drawn."
				(HandsOn)
				(SetFlag 125)
				(client setScript: 0 dispose:)
			)
		)
	)
)

