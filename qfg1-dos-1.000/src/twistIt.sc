;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 805)
(include sci.sh)
(use Main)
(use Rev)
(use Follow)
(use Motion)
(use Actor)
(use System)

(public
	twistIt 0
	spinAcross 1
	spinOnTree 2
	swimRight 3
	swimLeft 4
	twister 5
	tumbler 6
	swimmer 7
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance twister of Act
	(properties)
)

(instance tumbler of Act
	(properties)
)

(instance swimmer of Act
	(properties)
)

(instance twistIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(twister
					view: 64
					setLoop: 0
					setPri: 12
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					posn: 155 -10
					cycleSpeed: 1
					setCycle: Fwd
					startUpd:
					setMotion: MoveTo 200 50 self
				)
				(= local0 (twister x:))
				(= local1 (twister y:))
			)
			(1
				(= local2 local0)
				(= local3 local1)
				(= local0 (Random 20 300))
				(= local1 (Random 10 130))
				(twister setCycle: (if (> local0 local2) Fwd else Rev))
				(if (IsFlag 164)
					(twister setMotion: Follow gEgo 30)
				else
					(twister setMotion: MoveTo local0 local1 self)
				)
			)
			(2
				(if
					(or
						(< ((ScriptID 805 5) x:) 30) ; twister
						(> ((ScriptID 805 5) x:) 290) ; twister
						(< ((ScriptID 805 5) y:) 20) ; twister
					)
					(self cue:)
				else
					(self changeState: 1)
				)
			)
			(3
				(twister
					setMotion:
						MoveTo
						(cond
							((< ((ScriptID 805 5) y:) 20) ; twister
								(twister x:)
							)
							((< ((ScriptID 805 5) x:) 30) -20) ; twister
							((> ((ScriptID 805 5) x:) 290) 340) ; twister
						)
						(if (< ((ScriptID 805 5) y:) 20) ; twister
							-10
						else
							(twister y:)
						)
						self
				)
			)
			(4
				(-- global320)
				(twister stopUpd: setScript: 0)
			)
		)
	)
)

(instance spinAcross of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tumbler
					view: 64
					setLoop: 8
					setPri: 7
					setStep: 5 3
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					posn: -15 (Random 40 110)
					setCycle: Fwd
					startUpd:
				)
				(if (IsFlag 164)
					(tumbler setMotion: Follow gEgo 30)
				else
					(tumbler setMotion: MoveTo 345 (Random 0 80) self)
				)
			)
			(1
				(-- global320)
				(tumbler stopUpd: setScript: 0)
			)
		)
	)
)

(instance spinOnTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tumbler
					view: 64
					setLoop: 8
					setStep: 5 3
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					posn: 253 -10
					setCel: 0
					setMotion: MoveTo 253 39
					startUpd:
				)
				(= cycles 35)
			)
			(1
				(++ local4)
				(tumbler setCel: -1 setCycle: End self)
			)
			(2
				(if (> local4 (Random 2 4))
					(tumbler setCycle: Fwd)
					(if (IsFlag 164)
						(tumbler setMotion: Follow gEgo 30)
					else
						(tumbler setMotion: MoveTo -15 (Random 40 110) self)
					)
				else
					(self changeState: 1)
				)
			)
			(3
				(-- global320)
				(tumbler stopUpd: setScript: 0)
			)
		)
	)
)

(instance swimRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(swimmer
					view: 64
					setStep: 6 4
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					setLoop: 1
					cycleSpeed: 1
					setCycle: Fwd
					posn: -15 (Random 25 65)
					startUpd:
				)
				(if (IsFlag 164)
					(swimmer setMotion: Follow gEgo 30)
				else
					(swimmer setMotion: MoveTo 350 (Random 85 125) self)
				)
			)
			(1
				(-- global320)
				(swimmer stopUpd: setScript: 0)
			)
		)
	)
)

(instance swimLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(swimmer
					view: 64
					setStep: 6 4
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					setLoop: 2
					cycleSpeed: 1
					setCycle: Fwd
					posn: 325 (Random -10 10)
					startUpd:
				)
				(if (IsFlag 164)
					(swimmer setMotion: Follow gEgo 30)
				else
					(swimmer
						setMotion: MoveTo (Random 115 145) (Random 55 85) self
					)
				)
			)
			(1
				(swimmer setMotion: MoveTo (Random 30 65) -10 self)
			)
			(2
				(-- global320)
				(swimmer stopUpd: setScript: 0)
			)
		)
	)
)

