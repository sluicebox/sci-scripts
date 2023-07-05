;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 61)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Menu)
(use Actor)

(public
	rm061 0
)

(instance rm061 of Rm
	(properties
		picture 61
		horizon 77
		east 62
		south 67
		west 60
	)

	(method (init &tmp [temp0 50])
		(HandsOn)
		(self setRegions: 600) ; ortega
		(Load rsVIEW 90)
		(bloop init:)
		(super init:)
		(switch gPrevRoomNum
			(60
				(gEgo posn: 2 (gEgo y:) init:)
			)
			(62
				(gEgo
					view: 0
					cel: (gEgo cel:)
					loop: (gEgo loop:)
					posn: 317 (gEgo y:)
					init:
				)
			)
			(66
				(gEgo posn: 80 187 init:)
			)
			(67
				(gEgo posn: 240 187 init:)
			)
		)
		(TheMenuBar draw:)
		(SL enable:)
	)

	(procedure (localproc_0 param1) ; UNUSED
		(if (== (gCurRoom script:) 0)
			(switch (gEgo edgeHit:)
				(1
					(if (< (gEgo x:) 159)
						(= param1 60)
					else
						(= param1 61)
					)
				)
				(2
					(= param1 61)
				)
				(3
					(= param1 66)
				)
			)
			(if global256
				(++ global593)
			)
			(super newRoom: param1)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== script 0)
			(if (== 3 (gEgo edgeHit:))
				(if (< (gEgo x:) 159)
					(= newRoomNumber 66)
				else
					(= newRoomNumber 67)
				)
			)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if
			(and
				(== (gCurRoom script:) 0)
				(or (== (= temp0 (gEgo onControl:)) 5) (== temp0 4))
			)
			(gEgo setPri: 4 posn: (gEgo x:) (- (gEgo y:) 6))
			(= global180 1)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
	)
)

(instance bloop of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 90
			setLoop: 0
			setCel: 0
			cycleSpeed: 3
			posn: 303 14
			setCycle: Fwd
			ignoreActors:
		)
	)
)

