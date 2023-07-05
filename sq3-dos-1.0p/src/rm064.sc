;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm064 0
)

(instance rm064 of Rm
	(properties
		picture 64
		south 68
		west 63
	)

	(method (init &tmp [temp0 50])
		(HandsOn)
		(self setRegions: 600) ; ortega
		(Load rsVIEW 90)
		(spew1 init:)
		(super init:)
		(TheMenuBar draw:)
		(SL enable:)
		(switch gPrevRoomNum
			(63
				(gEgo posn: 2 (gEgo y:) init:)
			)
			(68
				(gEgo posn: (gEgo x:) 187 init:)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== script 0)
			(if global256
				(++ global593)
			)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (== (gCurRoom script:) 0)
			(cond
				((or (== (= temp0 (gEgo onControl:)) 3) (== temp0 2))
					(gEgo setPri: 3 posn: (gEgo x:) (- (gEgo y:) 3))
					(= global180 1)
				)
				((or (== temp0 5) (== temp0 7))
					(gEgo setPri: 3 posn: (+ (gEgo x:) 6) (gEgo y:))
					(= global180 1)
				)
				((or (== temp0 9) (== temp0 13))
					(gEgo setPri: 5 posn: (+ (gEgo x:) 10) (gEgo y:))
					(= global180 1)
				)
				((or (== temp0 17) (== temp0 25))
					(gEgo setPri: 7 posn: (+ (gEgo x:) 6) (gEgo y:))
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
	)
)

(instance SpewScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(spew1 setCycle: End self)
			)
			(2
				(spew2 init: setCycle: End self)
				(spew1 setCel: 0)
			)
			(3
				(spew2 dispose:)
				(self changeState: 0)
			)
		)
	)
)

(instance spew1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 90
			setLoop: 3
			setCel: 0
			cycleSpeed: 1
			posn: 112 21
			setScript: SpewScript
			ignoreActors:
		)
	)
)

(instance spew2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 90
			setLoop: 4
			setCel: 0
			cycleSpeed: 1
			posn: 196 0
			ignoreActors:
		)
	)
)

