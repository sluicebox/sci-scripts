;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	lizard 0
)

(local
	local0
	local1
)

(instance lizard of Act
	(properties
		yStep 4
		view 39
		loop 6
		xStep 6
	)

	(method (dispose)
		(ClearFlag 82)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(SetFlag 103)
		(SetFlag 82)
		(= global136 1)
		(self
			posn: 0 1000
			illegalBits: 0
			ignoreActors: 1
			setScript: startLizard
		)
		(= local0 30)
	)
)

(instance startLizard of Script
	(properties)

	(method (doit)
		(cond
			((> local0 1)
				(-- local0)
			)
			((== local0 1)
				(= local0 0)
				(lizard setScript: scurry)
			)
		)
		(super doit:)
	)
)

(instance scurry of Script
	(properties)

	(method (doit)
		(if (and (== global125 4) (== (gEgo cel:) 5))
			(Print 140 0) ; "You missed. A large, heavy sword is not the best method for this, perhaps."
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'are<where>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said '/lizard,reptile,creature')
							(Said '//lizard,reptile,creature')
							(MouseClaimed lizard event)
						)
						(Print 140 1) ; "Fast little devils, are they not?"
					)
					((or (Said '/adder') (Said '//adder'))
						(Print 140 2) ; "If you mean the legged creature that scurried past, it was a lizard."
					)
				)
			)
			((Said 'get,capture,eat,kill[/lizard,reptile]')
				(if (not (IsFlag 98))
					(Print 140 3) ; "It is not worth the effort...unless you are well and truly desperate enough."
				else
					(Face gEgo lizard)
					(if (< (- (gEgo y:) 30) (lizard y:) (+ (gEgo y:) 30))
						(cond
							(local1
								(if (> (gEgo x:) (lizard x:))
									(HandsOff)
									(gEgo setScript: (ScriptID 143 1)) ; missIt
								else
									(Print 140 4) ; "This lizard is moving too fast for you."
								)
							)
							((> (- (lizard x:) (gEgo x:)) 50)
								(HandsOff)
								(gEgo setScript: (ScriptID 143 0)) ; catchIt
							)
							(else
								(Print 140 4) ; "This lizard is moving too fast for you."
							)
						)
					else
						(Print 140 5) ; "The lizard is too far away."
					)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(if (== (gEgo view:) 0)
					(if (> (gEgo x:) 160)
						(= temp1 325)
						(= temp2 -5)
						(= temp0 7)
					else
						(= local1 1)
						(= temp1 -5)
						(= temp2 325)
						(= temp0 6)
					)
					(if (> (gEgo y:) 95)
						(= temp3 75)
					else
						(= temp3 150)
					)
				else
					(if (> (gEgo x:) 160)
						(= local1 1)
						(= temp1 -5)
						(= temp2 325)
						(= temp0 6)
					else
						(= temp1 325)
						(= temp2 -5)
						(= temp0 7)
					)
					(if (> (gEgo y:) 95)
						(= temp3 155)
					else
						(= temp3 78)
					)
				)
				(lizard
					setCycle: Fwd
					posn: temp1 temp3
					setLoop: temp0
					setMotion: MoveTo temp2 temp3 self
				)
			)
			(1
				(if (and (IsFlag 98) (== (Random 1 3) 1))
					(SetFlag 100)
				)
				(ClearFlag 103)
				(lizard dispose: delete:)
				(DisposeScript 140)
			)
		)
	)
)

