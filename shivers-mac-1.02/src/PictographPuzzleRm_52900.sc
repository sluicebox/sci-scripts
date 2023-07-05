;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 52900)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(public
	PictographPuzzleRm 0
)

(local
	[local0 3] = [1 27 53]
	[local3 4] = [22 44 65 87]
	local7 = -1
	[local8 12]
	[local20 12] = [1 2 3 1 3 2 3 2 1 1 2 3]
	[local32 12] = [1 3 2 2 3 1 3 1 2 1 2 3]
	local44
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 12) ((++ temp0))
		(if (!= ([local8 temp0] loop:) [local32 temp0])
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_1 param1 param2 &tmp temp0)
	(= temp0 ([local8 param1] loop:))
	([local8 param1] loop: ([local8 param2] loop:))
	([local8 param2] loop: temp0)
)

(instance PictographPuzzleRm of ShiversRoom
	(properties)

	(method (init &tmp temp0 temp1)
		(= local44 0)
		(PictographBoard init:)
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			(= temp1 (Tile new:))
			(temp1
				init:
					(+ 90 [local0 (mod temp0 3)])
					(+ 42 [local3 (/ temp0 3)])
					[local20 temp0]
					0
					temp0
			)
			(= [local8 temp0] temp1)
		)
		(super init: &rest)
	)
)

(instance PictographBoard of View
	(properties
		x 90
		y 42
		priority 1
		fixPriority 1
		view 52900
	)
)

(class Tile of ShiversProp
	(properties
		priority 2
		fixPriority 1
		view 52900
		tileNum 0
	)

	(method (init param1 param2 param3 param4 param5)
		(= x param1)
		(= y param2)
		(= loop param3)
		(= cel param4)
		(= tileNum param5)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(if (and (self onMe: event) (& (event type:) evMOUSEBUTTON))
			(event claimed: 1)
			(gSounds play: 800 0 122 0)
			(cond
				((== local7 -1)
					(= cel 1)
					(= local7 tileNum)
				)
				((== local7 tileNum)
					(= cel 0)
					(= local7 -1)
				)
				(else
					(= cel 1)
					(localproc_1 local7 tileNum)
					(= local7 -1)
					(self setScript: DeselectTileScript)
					(if (localproc_0)
						(= local44 1)
					else
						(= local44 0)
					)
				)
			)
		)
	)
)

(instance DeselectTileScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(for ((= temp0 0)) (< temp0 12) ((++ temp0))
					([local8 temp0] cel: 0)
				)
				(= cycles 1)
			)
		)
	)
)

