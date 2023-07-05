;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 52000)
(include sci.sh)
(use Main)

(public
	ObeliskPuzzleRm 0
)

(local
	[local0 3] = [25 50 100]
	[local3 3]
	[local6 6]
	local12
	[local13 3] = [2 4 6]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(if (!= ([local6 temp0] cel:) [local13 temp0])
			(return 0)
		)
	)
	(return 1)
)

(instance ObeliskPuzzleRm of ShiversRoom
	(properties)

	(method (init &tmp temp0 temp1)
		(super init: &rest)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(= temp1 (ObeliskPiece new:))
			(temp1 init: 125 [local0 temp0] temp0 [local3 temp0])
			(= [local6 temp0] temp1)
		)
	)

	(method (doit)
		(if (localproc_0)
			(= local12 1)
		else
			(= local12 0)
		)
		(super doit: &rest)
	)
)

(class ObeliskPiece of ShiversProp
	(properties
		x 180
		y 25
		priority 2
		fixPriority 1
		view 52000
		num 0
	)

	(method (init param1 param2 param3 param4 param5)
		(= x param1)
		(= y param2)
		(= loop param3)
		(= cel param4)
		(= num param5)
		(super init: &rest)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (and (self onMe: event) (& (event type:) evMOUSEBUTTON))
			(event claimed: 1)
			(gSounds play: 800 0 122 0)
			(if (== cel 7)
				(= cel 0)
			else
				(++ cel)
			)
			(= [local3 num] cel)
			(if (localproc_0)
				(= local12 1)
			else
				(= local12 0)
			)
		)
	)
)

