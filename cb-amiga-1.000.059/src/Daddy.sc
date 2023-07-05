;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 412)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	Daddy 0
)

(instance Daddy of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(gCast contains: daddyBow)
				(== (daddyBow cel:) (- (NumCels daddyBow) 2))
			)
			(daddyBow posn: 140 105 setCel: (daddyBow lastCel:))
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 412)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= global190 1)
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(daddyBow
					setLoop: 2
					posn: (+ temp0 6) (- temp1 47)
					setPri: 15
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 140 105 self
					init:
				)
				(gEgo stopUpd:)
			)
			(1
				(= cycles 13)
			)
			(2
				(daddyBow hide: dispose: delete:)
				(= cycles 2)
			)
			(3
				(if (not (IsFlag 41))
					(= global213 26)
					(Say 1 412 0) ; "Remember what I taught you about interrogation, Laura? Don't forget to ask questions. If you "ask Lillian about Gloria," you might get more information about Gloria, or at least how Lillian FEELS about her. That sort of information could be very useful."
					(SetFlag 41)
				)
				(= cycles 1)
			)
			(4
				(if (not (IsFlag 42))
					(= global213 26)
					(Say 1 412 1) ; "One important tool a good detective uses besides asking questions of people is to selectively reveal information to THEM and listen to their response. If you "tell Gloria about Fifi," you may receive additional information about Fifi, or at least what Gloria THINKS of her."
					(SetFlag 42)
				)
				(= cycles 1)
			)
			(5
				(if (not (IsFlag 43))
					(= global213 26)
					(Say 1 412 2) ; "Honey, if you've found any items you're confused about, or would like more information about, try "showing" it to the others. They may reveal more information about it to you."
					(SetFlag 43)
				)
				(= cycles 1)
			)
			(6
				(= global213 12)
				(Say 0 412 3) ; "Thanks, Daddy!"
				(gEgo startUpd:)
				(= global190 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance daddyBow of Act
	(properties
		view 925
		signal 16384
		illegalBits 0
	)
)

