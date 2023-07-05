;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 138)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	headEmUp_MoveEmOut 0
)

(local
	[local0 5]
	[local5 5]
	[local10 5] = [111 124 128 105 114]
	[local15 5] = [139 141 133 132 127]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(= [local0 temp0] (aSheep new:))
		(= [local5 temp0] (aSheepScript new:))
		([local0 temp0]
			setLoop: (+ (mod temp0 2) 1)
			cel: 0
			ignoreActors:
			posn: [local10 temp0] [local15 temp0]
			init:
			illegalBits: 0
			setCycle: Fwd
			setScript: [local5 temp0] 0 temp0
		)
	)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(if [local0 temp0]
			([local0 temp0]
				setMotion: 0
				setCycle: 0
				setScript: 0
				dispose:
				delete:
			)
			(= [local0 temp0] 0)
		)
	)
)

(instance sheepHerder of Act
	(properties
		y 123
		x 128
		yStep 1
		view 346
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(Said 'look/lamb,flock,animal')
					(Said 'ask/merlin/lamb,flock,animal')
					(MouseClaimed [local0 0] event)
					(MouseClaimed [local0 1] event)
					(MouseClaimed [local0 2] event)
					(MouseClaimed [local0 3] event)
					(MouseClaimed [local0 4] event)
				)
				(Print 138 0) ; "What utterly stupid animals they are!"
			)
			(
				(or
					(Said 'look/girl,woman,herder')
					(Said 'ask/merlin/girl,woman,herder')
					(MouseClaimed sheepHerder event)
				)
				(Print 138 1) ; "Aye, the woman is herding away her sheep. What utterly stupid animals they are."
			)
			((Said 'talk,ask[/girl,woman,herder]')
				(Print 138 2) ; "She shows not the least interest in talking to you."
			)
			((Said 'talk,ask[/lamb,flock,animal]')
				(Print 138 3) ; "Sheep are the most brainless creatures upon the face of the earth. That does not bode well for someone who wants to talk to them."
			)
		)
	)
)

(instance aSheep of Act
	(properties
		yStep 1
		view 346
		loop 1
	)
)

(instance aSheepScript of Script
	(properties)

	(method (doit)
		(if (not (client mover:))
			(switch (Random 0 1)
				(0
					(client
						setMotion: MoveTo (+ (client x:) 6) (+ (client y:) 12)
					)
				)
				(1
					(client
						setMotion: MoveTo (- (client x:) 2) (+ (client y:) 10)
					)
				)
			)
		)
		(super doit:)
	)
)

(instance headEmUp_MoveEmOut of Script
	(properties)

	(method (dispose)
		(localproc_1)
		(sheepHerder setCycle: 0 dispose: delete:)
		(super dispose:)
		(DisposeScript 138)
	)

	(method (init)
		(super init: &rest)
		(sheepHerder init:)
		(localproc_0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sheepHerder setCycle: Fwd setMotion: MoveTo 142 183 self)
			)
			(1
				(sheepHerder setMotion: MoveTo 155 240 self)
			)
			(2
				(client setScript: 0)
			)
		)
	)
)

