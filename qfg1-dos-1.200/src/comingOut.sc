;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 168)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	comingOut 0
)

(instance comingOut of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 168)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 301 6) stop: number: 50 play:) ; innMusic
				(HandsOff)
				(if (or (== global340 1) (== global341 1))
					((ScriptID 301 2) view: 304 startUpd:) ; shema
				)
				((ScriptID 301 2) setMotion: MoveTo 192 99 self) ; shema
			)
			(1
				((ScriptID 301 2) loop: 2) ; shema
				((ScriptID 301 5) loop: 2 cel: 0 setCycle: End self) ; swDoor
			)
			(2
				((ScriptID 301 2) setMotion: MoveTo 192 122 self) ; shema
				(SetFlag 301)
			)
			(3
				((ScriptID 301 5) setCycle: Beg self) ; swDoor
				((ScriptID 301 2) setMotion: MoveTo 130 144) ; shema
			)
			(4
				((ScriptID 301 5) loop: 1 cel: 0) ; swDoor
				(= cycles 2)
			)
			(5
				((ScriptID 301 5) cel: 2) ; swDoor
				(= cycles 2)
			)
			(6
				((ScriptID 301 5) cel: 0) ; swDoor
				(= cycles 1)
			)
			(7
				((ScriptID 301 5) cel: 1) ; swDoor
				(= cycles 1)
			)
			(8
				((ScriptID 301 5) cel: 0 stopUpd:) ; swDoor
				(= cycles 14)
			)
			(9
				((ScriptID 301 2) loop: 2 ignoreActors: 0) ; shema
				(= cycles 2)
			)
			(10
				(if (and (!= global340 1) (!= global341 1))
					(HighPrint 168 0) ; "I am Shema. Allow me to serve you, Wanderer from Afar. Do you wish food or drink?"
					(= global114 50)
					(HandsOn)
					(User canControl: 0)
				else
					(HighPrint 168 1) ; "I bring you that which you ordered. May it please and satisfy you."
					(cond
						((== global340 1)
							(= global340 2)
							(= global341 2)
						)
						((== global341 1)
							(= global341 2)
						)
					)
					(self cue:)
				)
			)
			(11
				((ScriptID 301 2) view: 303) ; shema
				((View new:)
					view: 301
					loop: 5
					cel: 2
					posn: 130 131
					init:
					ignoreActors:
					setPri: 12
					stopUpd:
				)
				(if (== global340 2)
					((ScriptID 301 7) ignoreActors: setPri: 12 init: stopUpd:) ; food
				)
				(HighPrint 168 2) ; "You thank Shema and pay her."
				(SetFlag 112)
				(= cycles 5)
			)
			(12
				((ScriptID 301 2) setScript: (ScriptID 169 0)) ; shema, goingIn
			)
		)
	)
)

