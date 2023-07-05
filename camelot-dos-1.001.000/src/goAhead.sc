;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 105)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	goAhead 0
	pullKnife 1
)

(instance goAhead of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 105)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 130 0) setLoop: 3 setCycle: End) ; Jabir
				(gTObj talkCue: self)
				(Talk 105 0 105 1) ; "Come, come. Have a drink."
			)
			(1
				((ScriptID 130 0) setCycle: Beg self) ; Jabir
			)
			(2
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance pullKnife of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 105)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSFX number: 102 priority: 5 loop: 1 play:)
				((ScriptID 130 0) ; Jabir
					setLoop: 0
					cel: 2
					cycleSpeed: 0
					setCycle: Beg self
				)
			)
			(1
				((ScriptID 130 0) view: 394 setLoop: 0 setCycle: End self) ; Jabir
			)
			(2
				(gTObj talkCue: self)
				(Talk 105 2) ; "So, you will not drink, foreign dog?"
			)
			(3
				(SetFlag 123)
				(client setScript: 0)
			)
		)
	)
)

