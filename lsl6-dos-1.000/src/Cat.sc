;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 976)
(include sci.sh)
(use Main)
(use Interface)
(use Actor)
(use System)

(class Cat of Actor
	(properties
		top -1
		left -1
		bottom -1
		right -1
		diagonal 0
		doCast 0
		outOfTouch 1
		caller 0
		active 0
		dx 0
		dy 0
	)

	(method (canBeHere)
		(return 1)
	)

	(method (findPosn)
		(return 1)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and active (== (event type:) evMOUSERELEASE))
				(= active 0)
				(event claimed: 1)
				(LocalToGlobal event)
				(self posn: (+ (event x:) dx) (+ (event y:) dy) z)
				(GlobalToLocal event)
				(if caller
					(caller cue: self)
				)
			)
			((MousedOn self event)
				(event claimed: 1)
				(self track: event)
			)
		)
	)

	(method (track event &tmp castOfOne)
		(LocalToGlobal event)
		(= dx (- x (event x:)))
		(= dy (- y (event y:)))
		(if doCast
			(= active 1)
		else
			((= castOfOne (Collect new:)) add: self)
			(while
				(and
					(!= 2 (event type:))
					(or outOfTouch (MousedOn self (event type: 1 yourself:)))
				)
				(self posn: (+ (event x:) dx) (+ (event y:) dy) z)
				(Animate (castOfOne elements:) 1)
				(GetEvent 32767 event)
			)
			(castOfOne release: dispose:)
			(if caller
				(caller cue: self)
			)
			(GlobalToLocal event)
		)
	)

	(method (doit &tmp event)
		(cond
			((not doCast)
				(= active 0)
			)
			(active
				(= event (gUser curEvent:))
				(self posn: (+ (event x:) dx) (+ (event y:) dy) z)
			)
		)
		(super doit:)
	)

	(method (posn theX theY theZ &tmp s)
		(if argc
			(= x theX)
			(if (>= argc 2)
				(= y theY)
				(if (>= argc 3)
					(= z theZ)
				)
			)
		)
		(= s (sign diagonal))
		(if (not (== -1 top bottom left right))
			(switch (Abs diagonal)
				(1
					(= y
						(+
							(if (> s 0) top else bottom)
							(/
								(* (- right x) (- bottom top) s)
								(- right left)
							)
						)
					)
				)
				(2
					(= x
						(+
							(if (> s 0) left else right)
							(/
								(* (- bottom y) (- right left) s)
								(- bottom top)
							)
						)
					)
				)
			)
			(= x (Max left (Min right x)))
			(= y (Max top (Min bottom y)))
		)
		(super posn: x y z)
	)
)

