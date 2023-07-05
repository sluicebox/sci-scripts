;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 165)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	shameensIntro 0
	shameenClaps 1
)

(instance shameensIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 10)
			)
			(1
				(if (and (!= gPrevRoomNum 0) (not (IsFlag 89)))
					((ScriptID 301 1) cycleSpeed: 1 setCycle: End self) ; shameen
				else
					(HandsOn)
					(ClearFlag 300)
					((ScriptID 301 1) setScript: (ScriptID 301 3)) ; shameen, lickIt
				)
			)
			(2
				(SetFlag 300)
				((ScriptID 301 1) stopUpd:) ; shameen
				(HighPrint 165 0) ; "Welcome! Welcome, traveler, to the Hero's Tale Inn! I am Shameen, at your service. May you find what you seek here."
				(HandsOn)
				(= cycles 100)
			)
			(3
				((ScriptID 301 1) cel: 2 setCycle: Beg self) ; shameen
			)
			(4
				(ClearFlag 300)
				((ScriptID 301 1) stopUpd: setScript: (ScriptID 301 3)) ; shameen, lickIt
				(DisposeScript 165)
			)
		)
	)
)

(instance shameenClaps of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 165)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 300)
					(self cue:)
				else
					((ScriptID 301 1) setCycle: CT 2 1 self) ; shameen
				)
			)
			(1
				(SetFlag 300)
				((ScriptID 301 1) setLoop: 5 cel: 0 cycleSpeed: 2 setCycle: Fwd) ; shameen
				(= cycles 12)
			)
			(2
				((ScriptID 301 1) ; shameen
					setLoop: 4
					cel: 2
					cycleSpeed: 0
					setCycle: 0
					stopUpd:
				)
				(= cycles 50)
			)
			(3
				((ScriptID 301 1) setCycle: Beg self) ; shameen
			)
			(4
				(ClearFlag 300)
				((ScriptID 301 1) stopUpd: setScript: (ScriptID 301 3)) ; shameen, lickIt
			)
		)
	)
)

