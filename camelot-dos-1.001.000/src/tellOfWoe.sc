;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 163)
(include sci.sh)
(use Main)
(use Rm57)
(use Motion)
(use System)

(public
	tellOfWoe 0
)

(instance tellOfWoe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gEgo inRect: 95 130 165 144)
					(gEgo setMotion: MoveTo (gEgo x:) 144 self)
				else
					(= cycles 1)
				)
			)
			(1
				(Face gEgo global185)
				(global187 hide:)
				(global188 hide:)
				(global185
					posn: (global185 x:) (global185 y:) 0
					setScript: paceBackAndForth
				)
				(proc57_4)
				(global185 view: 352)
				(gTObj talkCue: self actor: 0)
				(Talk 163 0 163 1 163 2 163 3) ; "What shall I do? What shall I do? I have been betrayed by Mari the wicked, Mari the vain. For my brief moment of weakness, I shall lose my beloved wife."
			)
			(2
				(global185
					setScript: 0
					setLoop: (if (> (global185 x:) 129) 3 else 2)
					setMotion: MoveTo 129 138 self
				)
			)
			(3
				(global185
					view: 353
					setLoop: 3
					cel: 0
					posn: (global185 x:) (global185 y:) 30
					setCycle: 0
					cycleSpeed: 0
					moveSpeed: 0
				)
				(global187 show:)
				(global188 show:)
				(client setScript: 0)
				(HandsOn)
				(DisposeScript 163)
			)
		)
	)
)

(instance paceBackAndForth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global185 view: 352 setCycle: Walk cycleSpeed: 1 moveSpeed: 1)
				(= cycles 1)
			)
			(1
				(global185 setLoop: 2 setMotion: MoveTo 160 138 self)
			)
			(2
				(global185 setLoop: 3 setMotion: MoveTo 100 138 self)
			)
			(3
				(self changeState: 1)
			)
		)
	)
)

