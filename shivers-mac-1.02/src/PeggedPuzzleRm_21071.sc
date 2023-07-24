;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21071)
(include sci.sh)
(use Main)
(use n951)
(use Osc)
(use Actor)
(use System)

(public
	PeggedPuzzleRm 0
)

(local
	local0
	local1
	[local2 7] = [0 21 41 62 83 103 123]
	[local9 7] = [-1 16 33 50 67 84 102]
	[local16 49] = [-1 -1 1 2 3 -1 -1 -1 -1 4 5 6 -1 -1 7 8 9 10 11 12 13 14 15 16 0 17 18 19 20 21 22 23 24 25 26 -1 -1 27 28 29 -1 -1 -1 -1 30 31 32 -1 -1]
	[local65 49] = [-1 -1 1 2 3 -1 -1 -1 -1 4 5 6 -1 -1 7 8 9 10 11 12 13 14 15 16 0 17 18 19 20 21 22 23 24 25 26 -1 -1 27 28 29 -1 -1 -1 -1 30 31 32 -1 -1]
)

(procedure (localproc_0 param1 param2)
	(return [local16 (+ (* param1 7) param2)])
)

(procedure (localproc_1 param1 param2 param3)
	(if (!= (localproc_0 param1 param2) -1)
		(= [local16 (+ (* param1 7) param2)] param3)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_2 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp0 (param1 row:))
	(= temp1 (param1 col:))
	(if (and (== temp0 param2) (== temp1 param3))
		(param1 posn: (+ [local2 param3] 60) (+ [local9 param2] 10))
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
	(if (not local1)
		(= local1 1)
	)
	(localproc_1 temp4 temp5 0)
	(localproc_1 temp0 temp1 0)
	(localproc_1 param2 param3 (param1 pegNum:))
	(param1
		posn: (+ [local2 param3] 60) (+ [local9 param2] 10)
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
		(= [local16 temp0] [local65 temp0])
	)
	(Pegs dispose:)
	(Pegs init:)
)

(instance PeggedPuzzleRm of ShiversRoom
	(properties)

	(method (init)
		(efExitBack init: 8)
		(super init: &rest)
		(gNormalCursor show:)
		(PeggedBoard init: 0 0 1)
		(Pegs init:)
		(ResetGame init:)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 21070
	)

	(method (init)
		(self
			createPoly: 0 0 0 142 262 142 262 0 1 0 20 3 20 141 237 141 236 3 20 3
		)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance PeggedBoard of View
	(properties
		fixPriority 1
		view 21071
	)

	(method (init param1 param2 param3 &tmp temp0)
		(= x param1)
		(= y param2)
		(= priority param3)
		(super init: &rest)
	)
)

(class ResetGame of ShiversProp
	(properties
		x 120
		y 130
		priority 10
		fixPriority 1
		view 21071
		loop 4
		cell 0
		row 0
		col 0
		pegNum 0
	)

	(method (doVerb)
		(if local1
			(self setScript: sReset)
		)
	)
)

(instance sReset of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Pegs dispose:)
				(gSounds stop: 12104)
				(gSounds play: 12103 0 122 self)
				(ResetGame setCycle: Osc 1)
				(for ((= temp0 0)) (< temp0 49) ((++ temp0))
					(= [local16 temp0] [local65 temp0])
				)
			)
			(1
				(proc951_9 12117)
				(gSounds play: 12117 0 82 0)
				(Pegs init:)
				(= cycles 1)
			)
			(2
				(= local1 0)
				(UpdatePlane gThePlane)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(class Peg of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 21071
		row 0
		col 0
		pegNum 0
	)

	(method (doit &tmp [temp0 2])
		(if (== local0 pegNum)
			(= x (- gMouseX 37))
			(= y (- gMouseY 15))
			(UpdateScreenItem self)
			(FrameOut)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(event localize: gThePlane)
		(cond
			((and (self onMe: event) (& (event type:) evMOUSEBUTTON) (== local0 0))
				(event claimed: 1)
				(gNormalCursor hide:)
				(= local0 pegNum)
				(= priority 11)
				(gSounds stop: 12104)
				(gSounds play: 12104 0 122 0)
			)
			((and (& (event type:) evMOUSEBUTTON) (== local0 pegNum))
				(= temp1 (/ (- (event x:) 60) 21))
				(= temp0 (/ (- (event y:) 10) 17))
				(if
					(and
						(PeggedBoard onMe: (event x:) (event y:))
						(localproc_2 self temp0 temp1)
					)
					(gSounds stop: 12104)
					(gSounds play: 12104 0 122 0)
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
						x: (+ [local2 temp1] 60)
						y: (+ [local9 temp0] 10)
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
					(SetFlag 21)
					(proc951_15 6750)
					(gSounds stop: 12104)
					(gSounds play: 12118 0 122 0)
				)
				(= seconds 2)
			)
			(2
				(gCurRoom newRoom: 21070) ; rm21v070
				(self dispose:)
			)
		)
	)
)

