;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 105)
(include sci.sh)
(use Game)

(class InvisibleWindow of SysWindow
	(properties
		type 129
		underBits 0
		-oldPort- 0
	)

	(method (open)
		(= -oldPort- (GetPort))
		(SetPort 0)
		(if underBits
			(= underBits (Graph grSAVE_BOX top (- left 1) bottom right 3))
		)
		(Graph grFILL_BOX top (- left 1) bottom (- right 3) 2 0 0)
		(= type 129)
		(super open:)
	)

	(method (dispose)
		(SetPort 0)
		(if underBits
			(Graph grRESTORE_BOX underBits)
			(Graph grUPDATE_BOX top (- left 1) bottom right 1)
		)
		(DisposeWindow window)
		(SetPort -oldPort-)
		(DisposeClone self)
	)
)

