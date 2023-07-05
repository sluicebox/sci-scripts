;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 809)
(include sci.sh)
(use Actor)

(public
	pDoor 0
	pDrips 1
	pGrapnel 2
	pRope 3
)

(instance pDoor of Prop
	(properties
		x 166
		y 161
		priority 185
		fixPriority 1
		view 801
		loop 1
		signal 16385
	)
)

(instance pDrips of Prop
	(properties
		view 804
		detailLevel 2
	)
)

(instance pGrapnel of Prop
	(properties
		x 230
		y 122
		view 8
		loop 6
		signal 16385
	)
)

(instance pRope of Prop
	(properties
		x 283
		y 55
		view 50
	)
)

