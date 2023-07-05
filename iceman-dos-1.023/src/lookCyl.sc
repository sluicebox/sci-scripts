;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 318)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n828)
(use System)

(public
	lookCyl 0
	measureCyl 1
)

(procedure (localproc_0)
	(Print 318 2) ; "The diameter of the sheared cylinder is 1" and the hole for the cotter pin is 1/4". You can't tell how long it was because it has been sheared off."
	(SetScore subMarine 406 32 5)
)

(procedure (localproc_1)
	(Printf ; "The cylinder is %s" long."
		318
		3
		(switch (subMarine invStatus1:)
			(1 {3})
			(2 {4})
			(3 {6})
		)
	)
	(if (subMarine cylDiam:)
		(Printf ; "It has been milled to a diameter of %s."
			318
			4
			(switch (subMarine cylDiam:)
				(1 {1"})
				(2 {1.5"})
				(3 {2"})
			)
		)
	)
	(if (subMarine holeSize:)
		(Printf ; "It has a %s hole drilled near one end."
			318
			5
			(switch (subMarine holeSize:)
				(1 {1/32"})
				(2 {1/16"})
				(3 {1/8"})
				(4 {1/4"})
				(5 {1/2"})
				(6 {3/4"})
				(7 {1"})
			)
		)
	)
	(if (& (subMarine roomFlags:) $0004)
		(Print 318 6) ; "The rough edges have been ground smooth."
	else
		(Print 318 7) ; "It has rough edges."
	)
)

(instance lookCyl of Code
	(properties)

	(method (doit &tmp temp0)
		(if (not (gEgo has: 12)) ; Sub: Metal_Cylinder | Tunisia: Business_Card
			(Print 318 0) ; "You don't have a cylinder."
		else
			((gInventory at: 12) showSelf:) ; Sub: Metal_Cylinder | Tunisia: Business_Card
		)
		(DisposeScript 318)
	)
)

(instance measureCyl of Code
	(properties)

	(method (doit &tmp temp0)
		(cond
			((not (gEgo has: 12)) ; Sub: Metal_Cylinder | Tunisia: Business_Card
				(Print 318 0) ; "You don't have a cylinder."
			)
			((not (gEgo has: 13)) ; Sub: Vernier_Caliper | Tunisia: Food_Platter
				(Print 318 1) ; "You have nothing to measure it with."
			)
			((== (subMarine invStatus1:) 4)
				(localproc_0)
			)
			(else
				(localproc_1)
			)
		)
		(DisposeScript 318)
	)
)

