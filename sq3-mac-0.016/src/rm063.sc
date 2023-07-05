;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63)
(include sci.sh)
(use Main)
(use Game)
(use Menu)

(public
	rm063 0
)

(instance rm063 of Rm
	(properties
		picture 63
		east 64
		south 67
	)

	(method (init &tmp [temp0 50])
		(HandsOn)
		(self setRegions: 600) ; ortega
		(super init:)
		(TheMenuBar draw:)
		(SL enable:)
		(switch gPrevRoomNum
			(64
				(gEgo posn: 317 (gEgo y:) init:)
			)
			(67
				(gEgo posn: 80 187 init:)
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
					(gEgo setPri: 3 posn: (gEgo x:) (- (gEgo y:) 6))
					(= global180 1)
				)
				((or (== temp0 5) (== temp0 7))
					(gEgo setPri: 5 posn: (- (gEgo x:) 6) (gEgo y:))
					(= global180 1)
				)
				((or (== temp0 9) (== temp0 11))
					(gEgo setPri: 1 posn: (gEgo x:) (- (gEgo y:) 6))
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

