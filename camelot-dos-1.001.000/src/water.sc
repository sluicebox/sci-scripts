;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 145)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	water 0
)

(instance water of Prop
	(properties
		view 139
	)

	(method (dispose)
		(ClearFlag 82)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(SetFlag 102)
		(SetFlag 82)
		(self
			setLoop:
				(switch (Random 0 1)
					(0 2)
					(1 4)
				)
			posn: 0 1000
			ignoreActors: 1
			setScript: coolWater
		)
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
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said '/water')
							(Said '//water')
							(MouseClaimed self event)
						)
						(Print 145 0) ; "That shimmer looks suspiciously like water."
					)
					((or (Said '/delusion') (Said '//delusion'))
						(Print 145 1) ; "It is indeed an illusion, created by your own eyes in the heat and thirst of the moment."
					)
				)
			)
		)
	)
)

(instance coolWater of Script
	(properties)

	(method (doit)
		(if (and (< (gEgo distanceTo: water) 50) (== state 1))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (< (gEgo y:) 95)
					(= temp1 151)
				else
					(= temp1 75)
				)
				(if (< (gEgo x:) 160)
					(= temp0 (Random 160 290))
				else
					(= temp0 (Random 30 160))
				)
				(water
					setPri: 1
					posn: temp0 temp1
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(water setLoop: (+ (water loop:) 1) cel: 0 setCycle: Fwd)
			)
			(2
				(water setLoop: (- (water loop:) 1) cel: 3 setCycle: Beg self)
			)
			(3
				(ClearFlag 102)
				(water dispose: delete:)
				(DisposeScript 145)
			)
		)
	)
)

