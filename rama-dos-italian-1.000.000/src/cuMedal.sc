;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1204)
(include sci.sh)
(use InvInitialize)
(use SpinProp)
(use Actor)

(public
	cuMedal 0
)

(instance cuMedal of MultiProp
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(super init: &rest)
		(self setPri: 200)
		(if (and (= temp0 (proc70_6 47)) (temp0 ownedBy: -2))
			0
		else
			(= temp0 0)
		)
		(if (and (= temp1 (proc70_6 37)) (temp1 ownedBy: -2))
			0
		else
			(= temp1 0)
		)
		(if (and (= temp2 (proc70_6 104)) (temp2 ownedBy: -2))
			0
		else
			(= temp2 0)
		)
		(if (and (= temp3 (proc70_6 1)) (temp3 ownedBy: -2))
			0
		else
			(= temp3 0)
		)
		(cond
			((and temp0 temp1 temp2 temp3)
				(= view 20255)
			)
			((and (not temp0) (not temp1) (not temp2) (not temp3))
				(= view 20254)
			)
			(else
				(= view 20254)
				(if temp0
					(self
						addSegment:
							(litLens name: {MazeCtlrLens} init: yourself:)
					)
				)
				(if temp1
					(self
						addSegment:
							((litLens new:)
								name: {HumanLens}
								loop: 1
								init:
								yourself:
							)
					)
				)
				(if temp2
					(self
						addSegment:
							((litLens new:)
								name: {OctoLens}
								loop: 2
								init:
								yourself:
							)
					)
				)
				(if temp3
					(self
						addSegment:
							((litLens new:)
								name: {AvRingLens}
								loop: 3
								init:
								yourself:
							)
					)
				)
			)
		)
	)
)

(instance litLens of Prop
	(properties
		view 20256
	)

	(method (init)
		(self
			cel: 0
			posn: (cuMedal x:) (cuMedal y:)
			setPri: (+ (cuMedal priority:) 1)
		)
		(super init: &rest)
	)
)

