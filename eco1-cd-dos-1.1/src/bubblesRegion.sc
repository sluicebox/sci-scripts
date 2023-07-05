;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
(include sci.sh)
(use Main)
(use EcoFeature)
(use Motion)
(use Game)
(use System)

(public
	bubblesRegion 0
)

(local
	[local0 8] = [9 -10 -12 -10 14 -18 0 0]
	[local8 8] = [-13 -13 -4 -21 -2 -3 -18 -18]
)

(class bubblesRegion of Rgn
	(properties
		seconds 6
		lastSeconds 0
	)

	(method (init)
		(super init: &rest)
		(bubbles init:)
	)

	(method (doit &tmp temp0)
		(if seconds
			(= temp0 (GetTime 1)) ; SysTime12
			(if (!= lastSeconds temp0)
				(= lastSeconds temp0)
				(if (not (-- seconds))
					(= seconds 6)
					(if
						(and
							(not (& (gEgo signal:) $0008))
							(OneOf (gEgo view:) 802 805)
						)
						(bubbles cue:)
					)
				)
			)
		)
		(super doit:)
	)

	(method (newRoom)
		(= initialized (= keep 0))
		(super newRoom: &rest)
	)
)

(instance bubbles of EcoProp
	(properties
		view 807
		cel 6
		signal 24576
	)

	(method (cue &tmp temp0)
		(if (== (gEgo view:) 802)
			(self
				setLoop: (not (OneOf (gEgo loop:) 1 4 7))
				x: (+ (gEgo x:) [local0 (gEgo loop:)])
				y: (- (+ (gEgo y:) [local8 (gEgo loop:)]) (gEgo z:))
			)
		else
			(self
				setLoop: (= temp0 (not (OneOf (gEgo loop:) 1 5 7)))
				x: (+ (- (gEgo x:) 7) (* (not temp0) 14))
				y: (- (+ (gEgo y:) -17) (gEgo z:))
			)
		)
		(self setPri: (gEgo priority:) cel: 0 setCycle: End)
	)
)

