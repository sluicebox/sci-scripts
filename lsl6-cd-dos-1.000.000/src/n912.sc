;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 912)
(include sci.sh)
(use System)

(class Class_912_0 of Obj
	(properties
		state 0
	)

	(method (draw)
		(= state 1)
		(DrawMenuBar 1)
	)

	(method (hide)
		(DrawMenuBar 0)
	)

	(method (add)
		(AddMenu &rest)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 0)
		(if state
			(= temp1 (Joystick 12 30))
			(= temp0 (MenuSelect event &rest))
			(Joystick 12 temp1)
		)
		(return temp0)
	)
)

