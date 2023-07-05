;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 52100)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(public
	PeggedPuzzleRm 0
)

(local
	local0
	[local1 7] = [9 26 43 61 78 95 113]
	[local8 7] = [8 23 37 52 66 81 96]
	[local15 49] = [-1 -1 1 2 3 -1 -1 -1 -1 4 5 6 -1 -1 7 8 9 10 11 12 13 14 15 16 0 17 18 19 20 21 22 23 24 25 26 -1 -1 27 28 29 -1 -1 -1 -1 30 31 32 -1 -1]
	[local64 49] = [-1 -1 1 2 3 -1 -1 -1 -1 4 5 6 -1 -1 7 8 9 10 11 12 13 14 15 16 0 17 18 19 20 21 22 23 24 25 26 -1 -1 27 28 29 -1 -1 -1 -1 30 31 32 -1 -1]
)

(procedure (localproc_0 param1 param2)
	(return [local15 (+ (* param1 7) param2)])
)

(procedure (localproc_1 param1 param2 param3)
	(if (!= (localproc_0 param1 param2) -1)
		(= [local15 (+ (* param1 7) param2)] param3)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_2 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp0 (param1 row:))
	(= temp1 (param1 col:))
	(if (and (== temp0 param2) (== temp1 param3))
		(param1 posn: (+ [local1 param3] 70) (+ [local8 param2] 30))
		(return 1)
	)
	(= temp4 temp0)
	(= temp5 temp1)
	(= temp2 (- temp0 param2))
	(= temp3 (- temp1 param3))
	(cond
		((< temp2 0)
			(*= temp2 -1)
			(= temp4 (- param2 1))
		)
		((> temp2 0)
			(= temp4 (+ param2 1))
		)
	)
	(cond
		((< temp3 0)
			(*= temp3 -1)
			(= temp5 (- param3 1))
		)
		((> temp3 0)
			(= temp5 (+ param3 1))
		)
	)
	(if
		(or
			(!= (localproc_0 param2 param3) 0)
			(and (!= temp0 param2) (!= temp1 param3))
			(and (!= temp2 2) (!= temp2 0))
			(and (!= temp3 2) (!= temp3 0))
			(< (localproc_0 temp4 temp5) 1)
		)
		(return 0)
	)
	(= temp6 (Pegs firstTrue: #find (localproc_0 temp4 temp5)))
	(Pegs delete: temp6)
	(temp6 dispose:)
	(localproc_1 temp4 temp5 0)
	(localproc_1 temp0 temp1 0)
	(localproc_1 param2 param3 (param1 pegNum:))
	(param1
		posn: (+ [local1 param3] 70) (+ [local8 param2] 30)
		row: param2
		col: param3
	)
	(return 1)
)

(procedure (localproc_3)
	(if (and (== (Pegs size:) 1) (> (localproc_0 3 3) 0))
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_4 &tmp temp0) ; UNUSED
	(= local0 0)
	(for ((= temp0 0)) (< temp0 49) ((++ temp0))
		(= [local15 temp0] [local64 temp0])
	)
	(Pegs dispose:)
	(Pegs init:)
)

(instance PeggedPuzzleRm of ShiversRoom
	(properties)

	(method (init)
		(super init: &rest)
		(gNormalCursor show:)
		(PeggedBoard init: 70 30 1)
		(Pegs init:)
	)
)

(instance PeggedBoard of View
	(properties
		fixPriority 1
		view 52100
	)

	(method (init param1 param2 param3 &tmp temp0)
		(= x param1)
		(= y param2)
		(= priority param3)
		(super init: &rest)
	)
)

(class Peg of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 52100
		row 0
		col 0
		pegNum 0
	)

	(method (doit &tmp [temp0 2])
		(if (== local0 pegNum)
			(= x (- gMouseX 27))
			(= y (- gMouseY 7))
			(UpdateScreenItem self)
			(FrameOut)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			((and (self onMe: event) (& (event type:) evMOUSEBUTTON) (== local0 0))
				(event claimed: 1)
				(gNormalCursor hide:)
				(= local0 pegNum)
				(= priority 11)
				(gSounds stop: 800)
				(gSounds play: 800 0 122 0)
			)
			((and (& (event type:) evMOUSEBUTTON) (== local0 pegNum))
				(= temp1 (/ (- (event x:) 70) 17))
				(= temp0 (/ (- (event y:) 30) 15))
				(if
					(and
						(PeggedBoard onMe: (event x:) (event y:))
						(localproc_2 self temp0 temp1)
					)
					(gSounds stop: 800)
					(gSounds play: 800 0 122 0)
					(= priority 10)
					(= local0 0)
					(gNormalCursor show:)
					(UpdateScreenItem self)
					(FrameOut)
					(if (localproc_3)
						(gCurRoom setScript: WonScript)
					)
				)
			)
		)
	)

	(method (find param1)
		(if (== param1 pegNum)
			(return self)
		else
			(return 0)
		)
	)
)

(instance Pegs of Collect
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(for ((= temp1 0)) (< temp1 7) ((++ temp1))
				(if (> (= temp3 (localproc_0 temp0 temp1)) 0)
					(= temp2 (Peg new:))
					(temp2
						pegNum: temp3
						loop: 1
						row: temp0
						col: temp1
						x: (+ [local1 temp1] 70)
						y: (+ [local8 temp0] 30)
					)
					(temp2 init:)
					(self add: temp2)
				)
			)
		)
		(super init: &rest)
	)
)

(instance WonScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if (localproc_3)
					(gSounds stop: 800)
					(gSounds play: 521 0 122 0)
				)
				(= seconds 10)
			)
			(2
				(gCurRoom newRoom: 2000) ; rm2v0
			)
		)
	)
)

