;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 112)
(include sci.sh)
(use Actor)

(class TalkerHead of Prop
	(properties
		client 0
		cycleCnt 0
		moveHead 0
		height 0
	)

	(method (init param1)
		(self client: param1)
		(self
			setMyView:
			setMyLoop:
			setMyHeight:
			cel: 0
			ignoreActors: 0
			setMyPosn:
			setPri: (+ (client priority:) 1)
		)
		(super init: &rest)
		(self hide:)
	)

	(method (setMyView)
		(self view: (+ (client view:) 520))
	)

	(method (setMyLoop)
		(self loop: (client loop:))
	)

	(method (setMyHeight)
		(self height: (CelHigh (client view:) (client loop:) (client cel:)))
	)

	(method (setMyPosn)
		(self posn: (client x:) (client y:) (client z:))
	)

	(method (doit &tmp temp0)
		(if (& signal $0008)
			(return)
		)
		(= temp0 (+ (client priority:) 1))
		(self setMyView: setMyLoop: setMyPosn: setPri: temp0)
		(super doit: &rest)
	)
)

