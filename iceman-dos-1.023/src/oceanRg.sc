;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 308)
(include sci.sh)
(use Main)
(use Interface)
(use n821)
(use ForwardCounter)
(use Chase)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	oceanRg 0
)

(instance oceanRg of Rgn
	(properties)

	(method (init)
		(super init: &rest)
		(= initialized 0)
		(Load rsVIEW 517)
		(if (not script)
			(self setScript: dieScript)
		)
		(seaGull init:)
		(gEgo setStep: 1 1 setCycle: treadWaterCycle)
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 8 15 16)) ; HutSwimRm, tahitiOcean2, beachSwimRm
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(if (script state:)
			(HandsOn)
		)
		(gEgo setStep: 3 2)
		(super dispose:)
	)
)

(instance dieScript of Script
	(properties
		seconds 60
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(switch (gEgo loop:)
					(0
						(gEgo setMotion: MoveTo 310 (gEgo y:))
					)
					(1
						(gEgo setMotion: MoveTo 10 (gEgo y:))
					)
					(3
						(gEgo setMotion: MoveTo (gEgo x:) 10)
					)
					(2
						(gEgo setMotion: MoveTo (gEgo x:) 180)
					)
				)
				(= cycles 25)
			)
			(2
				(gEgo
					view: 617
					setLoop: 1
					setMotion: 0
					setCycle: ForwardCounter 3 self
				)
			)
			(3
				(gEgo setLoop: 0 setCycle: End self)
			)
			(4
				(gEgo dispose:)
				(= cycles 5)
			)
			(5
				(EgoDead 907 2 0 308 0) ; "You've overestimated your strength and can't tread water any longer."
			)
		)
	)
)

(instance treadWaterCycle of Fwd
	(properties)

	(method (doit)
		(if (client isStopped:)
			(client view: 517)
		else
			(client view: 217)
		)
		(super doit: &rest)
	)
)

(instance seaGull of Act
	(properties
		y -20
		x -20
		view 15
	)

	(method (init)
		(super init:)
		(self
			setStep: 6 4
			setCycle: Walk
			illegalBits: 0
			ignoreHorizon: 1
			ignoreActors: 1
			setPri: 15
			setScript: seaGullFliesScript
		)
	)

	(method (dispose)
		(self posn: -20 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/bird,gull]>')
				(cond
					((Said 'look[<at]')
						(Print 308 1) ; "A common Tahitian seagull."
					)
					((Said 'kill')
						(Print 308 2) ; "If you could only catch him..."
					)
					((Said 'catch')
						(Print 308 3) ; "If you could, you'd probably kill him."
					)
				)
			)
		)
	)
)

(instance seaGullFliesScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 10))
			)
			(1
				(self
					setScript:
						(if (Random 0 1)
							seaGullFliesEastScript
						else
							seaGullFliesWestScript
						)
						self
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance seaGullFliesEastScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(seaGull setLoop: 0 posn: -20 72 setMotion: MoveTo 168 89 self)
			)
			(1
				(if (and (> 280 (gEgo x:) (+ (seaGull x:) 20)) 1)
					(self setScript: peckEastScript self)
				else
					(seaGull setMotion: MoveTo 340 72 self)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance seaGullFliesWestScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(seaGull setLoop: 1 posn: 340 72 setMotion: MoveTo 168 89 self)
			)
			(1
				(if (and (< 40 (gEgo x:) (- (seaGull x:) 30)) 1)
					(self setScript: peckWestScript self)
				else
					(seaGull setMotion: MoveTo -20 72 self)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance peckWestScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(seaGull setMotion: Chase gEgo 30 self)
			)
			(1
				(User canControl: 0 canInput: 0)
				(seaGull
					setMotion:
						MoveTo
						(+ (gEgo x:) 10)
						(- (gEgo y:) 10)
						self
				)
			)
			(2
				(= register (gEgo mover:))
				(gEgo mover: 0 view: 617 setLoop: 1 setCycle: Fwd)
				(seaGull setLoop: 3 setCycle: ForwardCounter 5 self)
			)
			(3
				(HandsOn)
				(gEgo
					view: 217
					setLoop: -1
					setMotion: register
					setCycle: treadWaterCycle
				)
				(seaGull
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo -20 72 self
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance peckEastScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(seaGull setMotion: Chase gEgo 30 self)
			)
			(1
				(User canControl: 0 canInput: 0)
				(seaGull
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(- (gEgo y:) 10)
						self
				)
			)
			(2
				(= register (gEgo mover:))
				(gEgo mover: 0 view: 617 setLoop: 1 setCycle: Fwd)
				(seaGull setLoop: 2 setCycle: ForwardCounter 5 self)
			)
			(3
				(HandsOn)
				(gEgo
					view: 217
					setLoop: -1
					setMotion: register
					setCycle: treadWaterCycle
				)
				(seaGull
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 340 72 self
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

