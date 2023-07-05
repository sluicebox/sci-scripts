;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 169)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use System)

(public
	goingIn 0
)

(instance goingIn of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 169)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 112)
				(SetFlag 111)
				(User canInput: 1)
				((ScriptID 301 2) ignoreActors: setMotion: MoveTo 192 114 self) ; shema
			)
			(1
				((ScriptID 301 2) loop: 3) ; shema
				(self cue:)
			)
			(2
				((ScriptID 301 5) loop: 0 cel: 0 setCycle: End self) ; swDoor
			)
			(3
				((ScriptID 301 2) setMotion: MoveTo 192 99 self) ; shema
			)
			(4
				(ClearFlag 111)
				((ScriptID 301 5) setCycle: Beg self) ; swDoor
				((ScriptID 301 2) setMotion: MoveTo 155 99) ; shema
			)
			(5
				(ClearFlag 301)
				((ScriptID 301 5) loop: 1 cel: 0) ; swDoor
				(= cycles 2)
			)
			(6
				((ScriptID 301 5) cel: 1) ; swDoor
				(= cycles 2)
			)
			(7
				((ScriptID 301 5) cel: 0) ; swDoor
				(= cycles 1)
			)
			(8
				((ScriptID 301 5) cel: 2) ; swDoor
				(= cycles 1)
			)
			(9
				(ClearFlag 112)
				((ScriptID 301 5) cel: 0 stopUpd:) ; swDoor
				((ScriptID 301 2) stopUpd: setScript: 0) ; shema
			)
		)
	)
)

