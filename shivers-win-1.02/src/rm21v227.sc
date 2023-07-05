;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21227)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v227 0
)

(instance rm21v227 of ShiversRoom
	(properties)

	(method (init &tmp temp0)
		(SetFlag 0)
		(SetFlag 1)
		(SetFlag 6)
		(SetFlag 9)
		(SetFlag 10)
		(SetFlag 11)
		(SetFlag 14)
		(SetFlag 17)
		(SetFlag 18)
		(SetFlag 21)
		(SetFlag 22)
		(SetFlag 23)
		(SetFlag 24)
		(SetFlag 26)
		(SetFlag 28)
		(SetFlag 30)
		(SetFlag 31)
		(SetFlag 58)
		(SetFlag 64)
		(SetFlag 65)
		(SetFlag 82)
		(SetFlag 79)
		(SetFlag 69)
		(SetFlag 70)
		(SetFlag 71)
		(SetFlag 72)
		(SetFlag 73)
		(SetFlag 70)
		(for ((= temp0 0)) (< temp0 6) ((+= temp0 1))
			(= [global328 temp0] [global334 temp0])
		)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 21030
	)

	(method (init)
		(self createPoly: 0 0 262 0 262 144 0 144 0 0)
		(= nextRoom gPrevRoomNum)
		(super init: &rest)
	)
)

