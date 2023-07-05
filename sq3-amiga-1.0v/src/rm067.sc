;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 67)
(include sci.sh)
(use Main)
(use Game)
(use Menu)

(public
	rm067 0
)

(instance rm067 of Rm
	(properties
		picture 67
		horizon 77
		north 62
		east 68
		south 70
		west 66
	)

	(method (init &tmp [temp0 50])
		(HandsOn)
		(self setRegions: 600) ; ortega
		(super init:)
		(switch gPrevRoomNum
			(61
				(gEgo posn: (+ (gCurRoom horizon:) 2) 80 init:)
			)
			(62
				(gEgo
					view: 0
					cel: (gEgo cel:)
					loop: (gEgo loop:)
					init:
				)
			)
			(63
				(gEgo posn: 240 80 init:)
			)
			(66
				(gEgo posn: 2 (gEgo y:) init:)
			)
			(68
				(gEgo posn: 317 (gEgo y:) init:)
			)
			(70
				(gEgo posn: (gEgo x:) 187 init:)
			)
		)
		(TheMenuBar draw:)
		(SL enable:)
	)

	(method (newRoom newRoomNumber)
		(if (== script 0)
			(if (== 1 (gEgo edgeHit:))
				(if (< (gEgo x:) 105)
					(= newRoomNumber 61)
				)
				(if (> (gEgo x:) 210)
					(= newRoomNumber 63)
				)
			)
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
					(gEgo setPri: 7 posn: (gEgo x:) (+ (gEgo y:) 2))
					(= global180 1)
				)
				((== temp0 9)
					(gEgo setPri: 7 posn: (gEgo x:) (- (gEgo y:) 2))
					(= global180 1)
				)
				((or (== temp0 5) (== temp0 7))
					(gEgo setPri: 5 posn: (gEgo x:) (+ (gEgo y:) 2))
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

