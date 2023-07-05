;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64981)
(include sci.sh)
(use Main)
(use Array)
(use User)
(use Menu)
(use System)

(class HotRectangle of Code
	(properties
		left 0
		top 0
		right 0
		bottom 0
	)

	(method (doit)
		(User doit:)
	)

	(method (setPlane param1 &tmp temp0)
		(= temp0 (if (and argc param1) param1 else gThePlane))
		(+= left (temp0 left:))
		(+= top (temp0 top:))
		(+= right (temp0 left:))
		(+= bottom (temp0 top:))
	)

	(method (setRect param1 param2 param3 param4)
		(if (== argc 4)
			(= left param1)
			(= top param2)
			(= right param3)
			(= bottom param4)
		else
			(= left ((param1 target:) left:))
			(= top ((param1 target:) top:))
			(= right ((param1 target:) right:))
			(= bottom ((param1 target:) bottom:))
			(self setPlane: (param1 plane:))
		)
		(return self)
	)

	(method (setScale)
		(<<= left $0001)
		(<<= right $0001)
		(= top (/ (* top 12) 5))
		(= bottom (/ (* bottom 12) 5))
	)
)

(class HotRectangleSet of Set
	(properties
		points 0
		active 0
	)

	(method (dispose)
		(self deactivate: 1)
		(super dispose: &rest)
	)

	(method (activate)
		(if (not active)
			(if (not size)
				(return 0)
			)
			(if (not points)
				(self buildPoints:)
			)
			(SetHotRectangles size (points data:))
			(= active 1)
		)
		(return 1)
	)

	(method (buildPoints &tmp temp0 temp1 temp2)
		(if active
			(return -1)
		)
		(if points
			(points dispose:)
		)
		(= points (IntArray new: 0))
		(= temp0 0)
		(for ((= temp1 (self first:))) temp1 ((= temp1 (self next: temp1)))
			(= temp2 (KList 8 temp1)) ; NodeValue
			(points
				at:
					temp0
					(temp2 left:)
					(temp2 top:)
					(temp2 right:)
					(temp2 bottom:)
			)
			(+= temp0 4)
		)
		(return size)
	)

	(method (check &tmp temp0 temp1)
		(= temp0 (Event new: 1024))
		(= temp1
			(if (temp0 type:)
				(temp0 message:)
			else
				-2
			)
		)
		(User doit:)
		(temp0 dispose:)
	)

	(method (deactivate param1)
		(if active
			(SetHotRectangles (= active 0))
		)
		(if (and argc param1 points)
			(points dispose:)
			(= points 0)
		)
	)

	(method (handleEvent event)
		(if elements
			((self at: event) doit:)
		)
	)
)

