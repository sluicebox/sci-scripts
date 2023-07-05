;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 108)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use SaveManager)
(use Compass)
(use n1111)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	matrixPuzzle 0
)

(local
	local0 = 6
	local1 = 55
	local2
	local3
	local4
	[local5 330] = [18 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 24 1 3500 0 15 70 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 20 0 0 0 0 0 0 0 0 0 0 0 0 26 4 3500 0 18 71 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 27 8 3500 0 21 130 0 0 0 0 0 0 19 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 25 2 3500 0 0 74 0 0 0 0 0 0 21 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 28 16 3500 0 3 75 29 32 3500 0 6 76 22 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 30 64 3500 0 9 77 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 31 128 3500 0 12 78 23 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 32 256 3500 0 24 72 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 33 512 3500 0 27 73]
	[local335 18] = [0 0 0 0 354 14 0 0 255 113 354 113 0 0 255 212 354 212]
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(= temp3 param1)
	(= temp0 (= temp2 -1))
	(= temp1 0)
	(while (< temp3 (+ param2 1))
		(if (not (IsFlag [local5 (* [global217 temp3] local1)]))
			(if (== temp0 -1)
				(= temp0 [global217 temp3])
				(= temp1 [global210 temp3])
			)
			(if (!= temp2 -1)
				(= [global217 temp2] [global217 temp3])
				(= [global210 temp2] [global210 temp3])
			)
			(= temp2 temp3)
		)
		(++ temp3)
	)
	(if (!= temp2 -1)
		(= [global217 temp2] temp0)
		(= [global210 temp2] temp1)
	)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2)
	(= temp0 (* [global217 local2] local1))
	(gCurRoom drawPic: (+ [global217 local2] 3500))
	(= temp1 (+ temp0 1))
	(for ((= temp2 0)) (< temp1 (+ temp0 local1)) ((++ temp2))
		(if (or (not [local5 temp1]) (IsFlag [local5 temp1]))
			(cond
				((and [local5 temp1] (not [local5 (+ temp1 1)])) 0)
				((!= [local5 (+ temp1 2)] 0)
					((MatrixPiece new:)
						init:
							[local335 (* temp2 2)]
							[local335 (+ (* temp2 2) 1)]
							temp2
							[local5 (+ temp1 4)]
					)
				)
				(else 0)
			)
		else
			(gCurRoom noun: 11)
			((MissingMatrixPiece new:)
				allowedVerb: [local5 (+ temp1 5)]
				puzzlePieceIndex: temp1
				pieceNo: temp2
				plane: global116
				init: [local335 (* temp2 2)] [local335 (+ (* temp2 2) 1)]
			)
		)
		(+= temp1 local0)
	)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2)
	(= temp0 (* [global217 local2] local1))
	(= temp2 1)
	(for ((= temp1 (+ temp0 1))) (< temp1 (+ temp0 local1)) ((+= temp1 local0))
		(if (and [local5 temp1] (not (IsFlag [local5 temp1])))
			(= temp2 0)
		)
	)
	(return temp2)
)

(instance matrixPuzzle of CloseupLocation
	(properties
		modNum 206
	)

	(method (init &tmp temp0 temp1)
		(= noun 0)
		(gGame handsOff:)
		(Load rsAUDIO 6001)
		(Load rsAUDIO 6002)
		(Load rsAUDIO 6102)
		(super init: 62)
		(self edgeE: 0 edgeW: 0 edgeN: 0)
		(switch gPrevRoomNum
			(4000 ; bkPorch
				(= global122 (ScriptID 206 0)) ; bangkokRegion
				(self setRegions: 206) ; bangkokRegion
				(= local2 2)
				(= heading 0)
			)
			(4031 ; bkElev1
				(= global122 (ScriptID 213 0)) ; BangkokInsideRegion
				(self setRegions: 213) ; BangkokInsideRegion
				(= local2 3)
				(= heading 0)
			)
			(4131 ; bkElev2
				(= global122 (ScriptID 213 0)) ; BangkokInsideRegion
				(self setRegions: 213) ; BangkokInsideRegion
				(= local2 4)
				(= heading 180)
			)
			(3001 ; london_1
				(= global122 (ScriptID 209 0)) ; londonRegion
				(self setRegions: 209) ; londonRegion
				(= local2 0)
				(= heading 0)
			)
			(3007 ; london_7
				(= global122 (ScriptID 212 0)) ; londonInsideRegion
				(self setRegions: 212) ; londonInsideRegion
				(= local2 1)
				(= heading 0)
			)
			(3022 ; london_12
				(= global122 (ScriptID 212 0)) ; londonInsideRegion
				(self setRegions: 212) ; londonInsideRegion
				(= local2 5)
				(= heading 270)
			)
			(else
				(= local2 0)
				(= heading 0)
			)
		)
		(Compass update:)
		(if (== [global217 local2] -1)
			(= [global217 2] 2)
			(= [global217 0] 0)
			(= [global217 1] 1)
			(= temp0 3)
			(= temp1 (Random 3 5))
			(while (< temp0 6)
				(if (or (== [global217 temp0] -1) (== [global217 temp0] temp1))
					(if (== [global217 temp0] -1)
						(= [global217 temp0] temp1)
						(if (== temp0 5)
							(break)
						)
					)
					(= temp0 2)
					(= temp1 (Random 3 5))
				else
					(++ temp0)
				)
				0
			)
		)
		(localproc_1)
		(RemapColors 2 236 60) ; ByPercent
		(puzzleDoor init:)
	)

	(method (newRoom)
		(if local3
			(gGame handsOff:)
			(self setScript: doorClose self)
		else
			(super newRoom: &rest)
		)
	)

	(method (dispose)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (cue)
		(global117 eachElementDo: #perform clearPuzzle)
		(gCurRoom newRoom: gPrevRoomNum)
	)

	(method (serialize param1)
		(if param1
			(super serialize: param1)
			(= local3 (SaveManager readWord:))
		else
			(super serialize: param1)
			(SaveManager writeWord: local3)
		)
	)
)

(instance doorOpens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(doorSound number: 6001 loop: 1 play:)
				(puzzleDoor setMotion: MoveTo (puzzleDoor x:) 301 self)
			)
			(1
				(= local3 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doorClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(doorSound number: 6002 loop: 1 play:)
				(puzzleDoor setMotion: MoveTo (puzzleDoor x:) 0 self)
			)
			(2
				(= local3 0)
				(self dispose:)
			)
		)
	)
)

(instance failedPuzzle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: doorClose self)
			)
			(1
				(global117 eachElementDo: #perform clearPuzzle)
				((global116 theFtrs:) eachElementDo: #perform clearMissingPiece)
				(= cycles 2)
			)
			(2
				(localproc_0 0 1)
				(localproc_0 2 5)
				(= cycles 2)
			)
			(3
				(localproc_1)
				(= cycles 2)
			)
			(4
				(gCurRoom setScript: doorOpens)
			)
		)
	)
)

(instance openDoors of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(SemiCircleDoorOpen play: 127 self)
			)
			(1
				1
				(gGame handsOn:)
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance rightPiece of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wrongPiece of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(if (>= (++ [global210 local2]) 2)
			(= [global210 local2] 0)
			(gCurRoom setScript: failedPuzzle)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				1
				(rejectPieceSound play:)
				(= temp0 (proc70_6 (+ 49 ((local4 patternView:) cel:))))
				(local4 dispose:)
				(= local4 0)
				(gGame handsOn:)
				(gTheCursor setInvCursor: temp0)
				(self dispose:)
			)
		)
	)
)

(instance puzzleDoor of Actor
	(properties
		priority 100
		x 81
		loop 2
		view 3500
		yStep 6
		fixPriority 1
		moveSpeed 3
	)

	(method (init)
		(if local3
			(self y: 301)
			(super init: global117)
			(gGame handsOn:)
		else
			(self y: 0)
			(super init: global117)
			(self setScript: doorOpens)
		)
	)
)

(class MatrixPiece of View
	(properties
		priority 10
		loop 1
		view 3500
		fixPriority 1
		patternView 0
	)

	(method (init param1 param2 param3 param4)
		(self cel: param3)
		(self posn: param1 param2)
		(super init: global117)
		((= patternView (MatrixPiecePattern new:))
			cel: param4
			posn: (+ param1 11) (+ param2 6)
			init: global117
		)
	)

	(method (dispose)
		(global117 delete: patternView)
		(patternView dispose:)
		(= patternView 0)
		(super dispose: &rest)
	)
)

(class MatrixPiecePattern of View
	(properties
		priority 10
		view 3500
		fixPriority 1
	)
)

(class MissingMatrixPiece of Feature
	(properties
		priority 10
		fixPriority 1
		allowedVerb 0
		puzzlePieceIndex 0
		pieceNo 0
	)

	(method (init param1 param2)
		(= x param1)
		(= y param2)
		(= nsLeft param1)
		(= nsBottom (+ (= nsTop param2) 90))
		(= nsRight (+ param1 90))
		(super init: &rest)
		(self setHotspot: 70 71 130 72 73 74 75 76 77 78 47 38)
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2)
		(if (or (puzzleDoor mover:) (not local3))
			(return)
		)
		(switch theVerb
			(1
				(super doVerb: theVerb)
			)
			(38
				(gunkedPieceSound play:)
			)
			(else
				(if (= temp2 (gTheCursor invItem:))
					(proc70_3)
				else
					(return)
				)
				(if (== theVerb allowedVerb)
					(SetFlag [local5 puzzlePieceIndex])
					((MatrixPiece new:)
						init: x y pieceNo [local5 (+ puzzlePieceIndex 4)]
					)
					(gCurRoom setScript: rightPiece)
					(if (localproc_2)
						(SetFlag 35)
						(if [local5 (= temp0 (* [global217 local2] local1))]
							(SetFlag [local5 temp0])
						)
						(switch gPrevRoomNum
							(4000 ; bkPorch
								(SetFlag 34)
								(gCurRoom setScript: openDoors)
							)
							(4031 ; bkElev1
								(SetFlag 36)
								(gCurRoom newRoom: gPrevRoomNum)
							)
							(4131 ; bkElev2
								(SetFlag 37)
								(gCurRoom newRoom: gPrevRoomNum)
							)
							(3001 ; london_1
								(SetFlag 98)
								(gCurRoom setScript: openDoors)
							)
							(3007 ; london_7
								(SetFlag 99)
								(gCurRoom setScript: openDoors)
							)
							(3022 ; london_12
								(SetFlag 100)
								(gCurRoom setScript: openDoors)
							)
							(else 0)
						)
					)
				else
					((= local4 (MatrixPiece new:))
						init: x y pieceNo (- (proc70_7 temp2) 49)
					)
					(gCurRoom setScript: wrongPiece)
				)
				(placePieceSound play:)
				(FrameOut)
			)
		)
	)
)

(instance clearPuzzle of Code
	(properties)

	(method (doit param1)
		(if (and param1 (param1 isKindOf: MatrixPiece))
			(param1 dispose:)
		)
	)
)

(instance clearMissingPiece of Code
	(properties)

	(method (doit param1)
		(if (and param1 (param1 isKindOf: MissingMatrixPiece))
			(param1 dispose:)
		)
	)
)

(instance doorSound of Sound
	(properties
		flags 5
	)
)

(instance placePieceSound of Sound
	(properties
		number 3500
		flags 5
	)
)

(instance rejectPieceSound of Sound
	(properties
		number 3501
		flags 5
	)
)

(instance gunkedPieceSound of Sound
	(properties
		number 3502
		flags 5
	)
)

(instance SemiCircleDoorOpen of Sound
	(properties
		number 3100
		flags 5
	)
)

