;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 178)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	hereItIs 0
	egoWalk 1
	IAintDrinkinTHAT 2
)

(local
	local0
	local1
	local2
)

(instance hereItIs of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(if (and (IsFlag 20) local1)
			(DisposeScript 178)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= global189 7)
					(HandsOff)
				)
				((ScriptID 130 1) setCycle: Beg) ; jabirHead
				(= cycles 10)
			)
			(1
				((ScriptID 130 1) setLoop: 7) ; jabirHead
				((ScriptID 130 0) setLoop: 3 setCycle: End) ; Jabir
				(gTObj talkCue: self)
				(if (or (== global189 5) (== global189 7))
					(Talk 178 0 178 1) ; "I have brought you to water, habib. Drink, before the heat overcomes you."
				else
					(Talk 178 2 178 3) ; "I am happy to see you again! You were lucky to find this water without me."
				)
			)
			(2
				((ScriptID 130 0) setCycle: Beg self) ; Jabir
			)
			(3
				(if (or local1 (not (IsFlag 20)))
					(HandsOn)
				)
				(= local0 1)
				(client setScript: 0)
			)
		)
	)
)

(instance egoWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 20)
					(= cycles 20)
				else
					(self cue:)
				)
			)
			(1
				(gEgo illegalBits: 0 setMotion: MoveTo 80 80 self)
			)
			(2
				(Face gEgo (ScriptID 130 0)) ; Jabir
				(= local2 1)
				(if (and local0 (not (IsFlag 20)))
					(HandsOn)
				)
				(gEgo illegalBits: $8000)
				(client setScript: 0)
			)
		)
	)
)

(instance IAintDrinkinTHAT of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(if (or (and global169 local0) (not global169))
			(DisposeScript 178)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (not global169) (not global80))
					(HandsOff)
				)
				(gMuleObj
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 114 74 self
				)
			)
			(1
				(gMuleObj setMotion: MoveTo 120 105 self)
			)
			(2
				(gMuleObj view: 424 setLoop: 0 cel: 0 setCycle: CT 4 1 self)
			)
			(3
				(gMuleObj cel: 3)
				(= cycles 20)
			)
			(4
				(gMuleObj view: 424 setCycle: Beg self)
			)
			(5
				(gMuleObj view: 403 setLoop: 2 cel: 0)
				(= cycles 2)
			)
			(6
				(gMuleObj
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 30 108 self
				)
			)
			(7
				(gMuleObj setMotion: MoveTo 32 110 self)
			)
			(8
				(if (or local0 (not global169))
					(HandsOn)
				)
				(= local1 1)
				(gMuleObj
					setMotion: 0
					setCycle: 0
					illegalBits: $8000
					ignoreActors: 0
				)
				(client setScript: 0)
			)
		)
	)
)

