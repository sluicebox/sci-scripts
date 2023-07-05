;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64919)
(include sci.sh)
(use System)

(class Rect of Obj
	(properties
		left 0
		top 0
		right 0
		bottom 0
	)

	(method (with &tmp rect)
		(= rect (self new:))
		(rect set: &rest)
		(return rect)
	)

	(method (set t l b r)
		(= left l)
		(= top t)
		(= right r)
		(= bottom b)
		(return self)
	)

	(method (init)
		(self set: 0 0 0 0)
		(return self)
	)

	(method (copy r &tmp dest)
		(if (& -info- $8000)
			(= dest (self new:))
		else
			(= dest self)
		)
		(dest
			set: (r top:) (r left:) (r bottom:) (r right:)
		)
	)

	(method (moveTo x y)
		(+= bottom (- y top))
		(+= right (- x left))
		(= top y)
		(= left x)
		(return self)
	)

	(method (moveBy dx dy)
		(self moveTo: (+ left dx) (+ top dy))
	)

	(method (center r)
		(self
			moveTo:
				(+ (r left:) (/ (- (r width:) (self width:)) 2))
				(+ (r top:) (/ (- (r height:) (self height:)) 2))
		)
	)

	(method (centerIn r)
		(self
			moveTo:
				(+ (r left:) (/ (- (r width:) (self width:)) 2))
				(+ (r top:) (/ (- (r height:) (self height:)) 2))
		)
	)

	(method (centerOn cx cy)
		(self
			moveTo:
				(- cx (/ (self width:) 2))
				(- cy (/ (self height:) 2))
		)
	)

	(method (width w)
		(if argc
			(= right (+ left w))
		)
		(return (- right left))
	)

	(method (widen dw)
		(+= right dw)
		(self width:)
	)

	(method (height h)
		(if argc
			(= bottom (+ top h))
		)
		(return (- bottom top))
	)

	(method (heighten dh)
		(+= bottom dh)
		(self width:)
	)

	(method (expand dx dy)
		(-= left dx)
		(-= top dy)
		(+= right dx)
		(+= bottom dy)
		(return self)
	)

	(method (contract dx dy)
		(self expand: (- dx) (- dy))
	)

	(method (contains r yc)
		(return
			(cond
				((== argc 2)
					(and
						(<= top yc (- bottom 1))
						(<= left r (- right 1))
					)
				)
				((and (r respondsTo: #x) (r respondsTo: #y))
					(self contains: (r x:) (r y:))
				)
				((and (<= top (r top:)) (>= bottom (r bottom:)))
					(and (<= left (r left:)) (>= right (r right:)))
				)
			)
		)
	)

	(method (intersects r)
		(return
			(not
				(or
					(< (r right:) left)
					(< (r bottom:) top)
					(> (r left:) right)
					(> (r top:) bottom)
				)
			)
		)
	)

	(method (intersection r)
		(if (self intersects: r)
			(= top (Max top (r top:)))
			(= left (Max left (r left:)))
			(= bottom (Min bottom (r bottom:)))
			(= right (Min right (r right:)))
		else
			(self init:)
		)
		(return self)
	)

	(method (union r)
		(= top (Min top (r top:)))
		(= left (Min left (r left:)))
		(= bottom (Max bottom (r bottom:)))
		(= right (Max right (r right:)))
		(return self)
	)

	(method (isEmpty)
		(return (and (== top bottom) (== left right)))
	)

	(method (sizeToStr &tmp t l r)
		(= t top)
		(= l left)
		(self moveTo: l t)
		(return self)
	)

	(method (sizeToCel)
		(= bottom (+ top (CelHigh &rest)))
		(= right (+ left (CelWide &rest)))
		(return self)
	)

	(method (celRect &tmp r)
		(= r
			(if (== self Rect)
				(self new:)
			else
				self
			)
		)
	)

	(method (mousedOn event evtType theMods &tmp t)
		(= t (if (== argc 1) 1 else evtType))
		(cond
			((!= (event type:) t) 0)
			((and (>= argc 3) theMods (== (& (event modifiers:) theMods) 0)) 0)
			(else
				(self contains: (event x:) (event y:))
			)
		)
	)

	(method (keyIn))

	(method (howFar targetRect &tmp targetX targetY startX startY)
		(switch targetRect
			(0
				(= targetX [targetRect 1])
				(= targetY [targetRect 2])
				(= startX (self midPixel: 1))
				(= startY (self midPixel: 2))
			)
			(-1
				(= targetX ([targetRect 1] left:))
				(= targetY ([targetRect 1] top:))
				(= startX (self left:))
				(= startY (self top:))
			)
			(else
				(= targetX (targetRect midPixel: 1))
				(= targetY (targetRect midPixel: 2))
				(= startX (self midPixel: 1))
				(= startY (self midPixel: 2))
			)
		)
		(GetDistance startX startY targetX targetY)
	)

	(method (midPixel axis)
		(switch axis
			(1
				(return (/ (+ left right) 2))
			)
			(78
				(return (/ (- right left) 2))
			)
			(2
				(return (/ (+ top bottom) 2))
			)
			(206
				(return (/ (- bottom top) 2))
			)
			(else
				(return 0)
			)
		)
	)
)

