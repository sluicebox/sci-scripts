;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 405)
(include sci.sh)
(use Motion)
(use Actor)

(class MoveProp of Prop
	(properties)

	(method (init param1 param2 param3 param4 param5)
		(= view param1)
		(= loop param2)
		(= cel 0)
		(= x param3)
		(= y param4)
		(= cycleSpeed param5)
		(super init:)
		(self setCycle: Fwd)
	)
)

