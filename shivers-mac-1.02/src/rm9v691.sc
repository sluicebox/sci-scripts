;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9691)
(include sci.sh)
(use Main)
(use n951)
(use Array)
(use Rev)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	rm9v691 0
)

(local
	local0
	local1
	local2
	[local3 32] = [9 9 7 -1 2 6 3 -1 4 5 2 2 4 5 8 8 0 0 6 -1 0 0 7 3 1 2 2 -1 1 8 8 -1]
	[local35 4] = [95 160 95 30]
	[local39 4] = [20 59 98 59]
	[local43 18] = [0 6 7 3 9 7 2 6 3 1 2 2 8 4 5 2 2 8]
	[local61 18] = [0 4 9 12 13 14 17 1 2 3 5 6 7 8 10 11 15 16]
	[local79 10] = [3 1 0 0 1 1 0 0 2 2]
	[local89 32]
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(= temp0 [local79 ((local1 at: param1) loop:)])
	(= temp1 (/ param2 8))
	(= temp2 (mod (/ param2 4) 2))
	(= temp3 (mod param2 4))
	(switch temp0
		(0
			(return (== [local89 param2] -1))
		)
		(1
			(return
				(and
					(== temp2 0)
					(== [local89 param2] -1)
					(== [local89 (+ param2 4)] -1)
				)
			)
		)
		(2
			(return
				(and
					(< temp3 3)
					(== [local89 param2] -1)
					(== [local89 (+ param2 1)] -1)
				)
			)
		)
		(3
			(return
				(and
					(== temp2 0)
					(< temp3 3)
					(== [local89 param2] -1)
					(== [local89 (+ param2 1)] -1)
					(== [local89 (+ param2 4)] -1)
					(== [local89 (+ param2 5)] -1)
				)
			)
		)
	)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1)
	(= temp0 [local79 ((local1 at: param1) loop:)])
	(= temp1 ((local1 at: param1) loop:))
	((local1 at: param1) pos: param2)
	(switch temp0
		(0
			(= [local89 param2] temp1)
		)
		(1
			(= [local89 param2] temp1)
			(= [local89 (+ param2 4)] temp1)
		)
		(2
			(= [local89 param2] temp1)
			(= [local89 (+ param2 1)] temp1)
		)
		(3
			(= [local89 param2] temp1)
			(= [local89 (+ param2 1)] temp1)
			(= [local89 (+ param2 4)] temp1)
			(= [local89 (+ param2 5)] temp1)
		)
	)
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1)
	(switch (= temp0 [local79 ((local1 at: param1) loop:)])
		(0
			(= [local89 param2] -1)
		)
		(1
			(= [local89 param2] -1)
			(= [local89 (+ param2 4)] -1)
		)
		(2
			(= [local89 param2] -1)
			(= [local89 (+ param2 1)] -1)
		)
		(3
			(= [local89 param2] -1)
			(= [local89 (+ param2 1)] -1)
			(= [local89 (+ param2 4)] -1)
			(= [local89 (+ param2 5)] -1)
		)
	)
)

(procedure (localproc_3 &tmp temp0)
	(for ((= temp0 0)) (< temp0 32) ((++ temp0))
		(if (!= [local89 temp0] [local3 temp0])
			(return 0)
		)
	)
	(return 1)
)

(instance rm9v691 of ShiversRoom
	(properties
		picture 9691
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(efExitBack init: 8)
		(pStar init:)
		(for ((= temp0 0)) (< temp0 32) ((++ temp0))
			(= [local89 temp0] -1)
		)
		(= local1 (IntArray new:))
		(for ((= temp0 0)) (< temp0 18) ((++ temp0))
			(local1 at: temp0 (vPiece new:))
			((local1 at: temp0) loop: [local43 temp0])
		)
		(= local2 (IntArray new:))
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(local2 at: temp0 (vBox new:))
			((local2 at: temp0) cel: temp0 init:)
		)
		(super init: &rest)
		(if (or (== gPrevRoomNum 990) (== gPrevRoomNum 992)) ; shiversOptions, viewingInv
			(= temp7 (File new:))
			(temp7 name: {shiversp.tmp})
			(temp7 open: 1)
			(for ((= temp0 0)) (< temp0 18) ((++ temp0))
				(= temp3 0)
				(= temp4 (/ (= temp2 (temp7 readWord:)) 8))
				(= temp5 (mod (/ temp2 4) 2))
				(= temp6 (mod temp2 4))
				(localproc_1 temp0 temp2)
				((local1 at: temp0)
					x: (+ [local35 temp4] (* temp6 18))
					y: (+ [local39 temp4] (* temp5 15))
					pos: temp2
					init:
				)
			)
			(temp7 close:)
		else
			(for ((= temp0 0)) (< temp0 18) ((++ temp0))
				(= temp1 [local61 temp0])
				(= temp3 0)
				(for
					((= temp2 (Random 0 31)))
					(not (localproc_0 temp1 temp2))
					((= temp2 (mod (+ temp2 1) 32)))
				)
				(= temp4 (/ temp2 8))
				(= temp5 (mod (/ temp2 4) 2))
				(= temp6 (mod temp2 4))
				(localproc_1 temp1 temp2)
				((local1 at: temp1)
					x: (+ [local35 temp4] (* temp6 18))
					y: (+ [local39 temp4] (* temp5 15))
					pos: temp2
					init:
				)
			)
		)
	)

	(method (newRoom newRoomNumber &tmp temp0 temp1 temp2)
		(if (or (== newRoomNumber 990) (== newRoomNumber 992)) ; shiversOptions, viewingInv
			(= temp2 (File new:))
			(temp2 name: {shiversp.tmp})
			(temp2 open: 2)
			(for ((= temp0 0)) (< temp0 18) ((++ temp0))
				(= temp1 (local1 at: temp0))
				(temp2 writeWord: (temp1 pos:))
			)
			(temp2 close:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 9690
	)

	(method (init)
		(self
			createPoly:
				0
				0
				20
				20
				243
				20
				243
				135
				20
				135
				20
				20
				0
				0
				0
				143
				263
				143
				263
				0
		)
		(super init: &rest)
	)
)

(instance vBox of View
	(properties
		priority 75
		fixPriority 1
		view 9693
		loop 10
	)
)

(instance pStar of Prop
	(properties
		priority 175
		fixPriority 1
		view 9693
		loop 11
		cycleSpeed 12
	)
)

(class vPiece of View
	(properties
		priority 100
		fixPriority 1
		view 9693
		pos 0
	)

	(method (init)
		(super init:)
		(gMouseDownHandler add: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (onMe)
		(if (== local0 self)
			(return 0)
		else
			(return (super onMe: &rest))
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12)
		(event localize: (self plane:))
		(if (and (self onMe: event) (not local0) (== (event type:) evMOUSEBUTTON))
			(= local0 self)
			(= temp8 (local1 indexOf: self))
			(= temp7 pos)
			(= temp12 -1)
			(self setPri: 255 1)
			(= temp0 x)
			(= temp1 y)
			(= temp4 (event x:))
			(= temp5 (event y:))
			(= temp6 0)
			(repeat
				(= temp2 (Event new:))
				(temp2 localize: (self plane:))
				(if (or (!= temp4 (temp2 x:)) (!= temp5 (temp2 y:)))
					(self posn: (- (temp2 x:) 9) (- (temp2 y:) 8))
					(UpdateScreenItem self)
					(FrameOut)
					(= temp6 1)
					(localproc_2 temp8 pos)
				)
				(if (== (temp2 type:) evMOUSERELEASE)
					(= temp3 (gCast firstTrue: #onMe temp2))
					(if temp6
						(if (and temp3 (>= (local2 indexOf: temp3) 0))
							(= temp9 (local2 indexOf: temp3))
							(= temp10 (/ (- (temp2 y:) [local39 temp9]) 15))
							(= temp12
								(+
									(= temp11
										(/ (- (temp2 x:) [local35 temp9]) 18)
									)
									(* 4 temp10)
									(* 8 temp9)
								)
							)
							(if (localproc_0 temp8 temp12)
								(localproc_1 temp8 temp12)
								(gSounds stop: 10901)
								(gSounds play: 10901 0 82 0)
								(= x (+ [local35 temp9] (* temp11 18)))
								(= y (+ [local39 temp9] (* temp10 15)))
								(= pos temp12)
								(if (localproc_3)
									(UpdateScreenItem self)
									(gCurRoom setScript: sIsSolved)
								)
							else
								(localproc_1 temp8 temp7)
								(gSounds stop: 10927)
								(gSounds play: 10927 0 82 0)
								(= x temp0)
								(= y temp1)
							)
						else
							(localproc_1 temp8 temp7)
							(gSounds stop: 10927)
							(gSounds play: 10927 0 82 0)
							(= x temp0)
							(= y temp1)
						)
					)
					(self setPri: 100 1)
					(= local0 0)
					(temp2 dispose:)
					(break)
				)
				(temp2 dispose:)
			)
			(self setPri: 100 1)
		)
	)
)

(instance sIsSolved of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc951_9 10928)
				(gSounds play: 10928 0 82 0)
				(pStar setCycle: Rev)
				(= seconds 3)
			)
			(1
				(pStar setCycle: Beg self)
			)
			(2
				(SetFlag 28)
				(proc951_15 6750)
				(gCurRoom newRoom: 9690) ; rm9v69
			)
		)
	)
)

