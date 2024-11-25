;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 201)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	comeWithMe 0
	moveForMule 1
)

(local
	local0
)

(instance comeWithMe of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 201)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 130 0) setCycle: CT 4 1 self) ; Jabir
			)
			(1
				(= cycles 10)
			)
			(2
				((ScriptID 130 0) setCycle: End self) ; Jabir
			)
			(3
				((ScriptID 130 1) show:) ; jabirHead
				(gTObj talkCue: self)
				(Talk 201 0) ; "Truly you are a hardy man to have come so far. But you need water!  Waste no time. Follow me at once."
			)
			(4
				((ScriptID 130 1) dispose:) ; jabirHead
				((ScriptID 130 0) setCycle: Beg self) ; Jabir
			)
			(5
				(gTObj endTalk:)
				((ScriptID 130 0) ; Jabir
					view: 389
					setCycle: Walk
					setLoop: -1
					setMotion: MoveTo 150 235 self
				)
			)
			(6
				(HandsOn)
				(SetFlag 116)
				((ScriptID 130 0) dispose:) ; Jabir
			)
		)
	)
)

(instance moveForMule of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 201)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 (gMuleObj cycler:))
				(gMuleObj cycler: 0)
				(gEgo setMotion: MoveTo 210 105 self)
			)
			(1
				(Face gEgo gMuleObj)
				(gMuleObj cycleSpeed: 2 setPri: 15 setCycle: Beg self)
			)
			(2
				(gMuleObj
					view: 403
					illegalBits: 0
					ignoreActors: 1
					cycleSpeed: 0
					xStep: 5
					loop: 1
					cel: 0
					cycler: local0
					setMotion: MoveTo 195 111 self
				)
			)
			(3
				(= local0 0)
				(gMuleObj setMotion: MoveTo 200 144 self)
			)
			(4
				(gMuleObj setMotion: MoveTo 148 147 self)
			)
			(5
				(HandsOn)
				(gMuleObj
					setPri: -1
					xStep: 3
					ignoreActors: 0
					illegalBits: $9000
					setMotion: MoveTo 65 150 self
				)
			)
			(6
				(gMuleObj setMotion: 0)
				(client setScript: 0)
			)
		)
	)
)

