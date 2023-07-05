;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm060 0
)

(instance rm060 of Rm
	(properties
		picture 60
		horizon 77
		east 61
		south 66
	)

	(method (init &tmp [temp0 50])
		(HandsOn)
		(self setRegions: 600) ; ortega
		(Load rsVIEW 96)
		(super init:)
		(bigBub init:)
		(smallBub init:)
		(switch gPrevRoomNum
			(61
				(gEgo posn: 317 (gEgo y:) init:)
			)
			(66
				(gEgo
					posn:
						(if (< (gEgo x:) 125)
							125
						else
							(gEgo x:)
						)
						187
					init:
				)
			)
		)
		(TheMenuBar draw:)
		(SL enable:)
	)

	(method (newRoom newRoomNumber)
		(if (not script)
			(if global256
				(++ global593)
			)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit &tmp temp0 [temp1 50])
		(super doit:)
		(if (not (gCurRoom script:))
			(cond
				(
					(or
						(== (= temp0 (gEgo onControl:)) 3)
						(== temp0 2)
						(== temp0 7)
					)
					(gEgo setPri: 3 posn: (gEgo x:) (- (gEgo y:) 2))
					(= global180 1)
				)
				((or (== temp0 5) (== temp0 13))
					(gEgo setPri: 5 posn: (- (gEgo x:) 6) (gEgo y:))
					(= global180 1)
				)
				((== temp0 9)
					(gEgo setPri: 7 posn: (gEgo x:) (- (gEgo y:) 2))
					(= global180 1)
				)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look/bubble')
			(Print 60 0) ; "Gas vents beneath the lava occasionally form thick bubbles that last but a moment."
		)
	)
)

(instance BigBubble of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 2))
			)
			(1
				(bigBub
					posn: (Random 14 320) (Random 132 194)
					setCycle: End self
				)
			)
			(2
				(bigBub setCel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance SmallBubble of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(smallBub
					posn: (Random 143 320) (Random 81 106)
					setCycle: End self
				)
			)
			(2
				(smallBub setCel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance bigBub of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 96
			setLoop: 0
			setCel: 0
			setPri: 2
			setScript: BigBubble
			ignoreActors: 1
		)
	)
)

(instance smallBub of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 96
			setLoop: 1
			setCel: 0
			setPri: 2
			setScript: SmallBubble
			ignoreActors: 1
		)
	)
)

