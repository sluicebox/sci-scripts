;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 116)
(include sci.sh)
(use Main)
(use ADRoom)
(use Actor)
(use System)

(public
	rm116 0
)

(local
	local0
	[local1 16]
	local17
	local18
	local19
	local20
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2)
	(if (& (t1 signal:) $0008)
		(= temp0 (= temp2 0))
		(= temp1 1)
		(while (< temp2 16)
			(if (> temp0 3)
				(= temp0 0)
				(++ temp1)
			)
			([local1 temp2]
				show:
				x: (+ param1 (* 37 temp0))
				y: (+ (- param2 31) (* 31 temp1))
				stopUpd:
			)
			(++ temp0)
			(++ temp2)
		)
		(Animate (gCast elements:) 0)
	)
)

(procedure (localproc_1 &tmp temp0)
	(if (not (& (t1 signal:) $8000))
		(for ((= temp0 0)) (< temp0 15) ((++ temp0))
			([local1 temp0] dispose:)
		)
		(blankSpot dispose:)
		(Animate (gCast elements:) 0)
	)
)

(procedure (localproc_2 &tmp temp0) ; UNUSED
	(if (not (& (t1 signal:) $0008))
		(for ((= temp0 0)) (< temp0 16) ((++ temp0))
			([local1 temp0] hide:)
		)
		(Animate (gCast elements:) 0)
	)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(++ local17)
	(for ((= temp0 0)) (< temp0 16) ((++ temp0))
		(if (!= ((= temp2 [local1 temp0]) node:) ([local1 temp0] correctPosn:))
			(= temp3 (gCast firstTrue: #perform restoreCode (+ temp0 1)))
			(blankSpot swapNode: temp2 temp3 calibrate:)
			(= temp4 (temp2 x:))
			(= temp5 (temp2 y:))
			(temp2 x: (temp3 x:))
			(temp2 y: (temp3 y:))
			(temp3 x: temp4)
			(temp3 y: temp5)
			(temp2 forceUpd:)
			(for ((= temp1 0)) (< temp1 16) ((++ temp1))
				(if (!= temp1 (- ([local1 temp1] correctPosn:) 1))
					(return 1)
				)
			)
		)
	)
	(SetFlag 98)
	(gCurRoom setScript: finishPuzzle)
	(return 0)
)

(class TilePiece of View
	(properties
		view 825
		priority 15
		signal 16400
		correctPosn 0
		blankTile 0
		node 0
	)

	(method (init param1)
		(super init: &rest)
		(= [local1 local0] self)
		(self blankTile: param1 node: (+= local0 1) hide:)
	)

	(method (doVerb theVerb invItem &tmp temp0)
		(switch theVerb
			(7 ; Do
				(if (and blankTile (self check:))
					(self move:)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (check)
		(OneOf
			node
			(blankTile nTile:)
			(blankTile sTile:)
			(blankTile eTile:)
			(blankTile wTile:)
		)
	)

	(method (move &tmp [temp0 2] temp2 temp3)
		(= temp2 x)
		(= temp3 y)
		(= x (blankTile x:))
		(= y (blankTile y:))
		(blankTile x: temp2)
		(blankTile y: temp3)
		(self forceUpd:)
		(gLongSong2 number: 955 loop: 1 play:)
		(blankTile swapNode: self blankTile calibrate:)
		(if (self checkPosn:)
			(Animate (gCast elements:) 0)
			(self cue:)
		)
	)

	(method (checkPosn &tmp temp0)
		(for ((= temp0 0)) (< temp0 15) ((++ temp0))
			(if (!= ([local1 temp0] node:) ([local1 temp0] correctPosn:))
				(return 0)
			)
		)
		(return 1)
	)

	(method (cue)
		(SetFlag 98)
		(gCurRoom setScript: finishPuzzle)
	)
)

(class BlankSpot of TilePiece
	(properties
		nTile 0
		sTile 0
		wTile 0
		eTile 0
	)

	(method (calibrate)
		(= nTile
			(if (< node 5)
				0
			else
				(- node 4)
			)
		)
		(= sTile
			(if (> node 12)
				0
			else
				(+ node 4)
			)
		)
		(= eTile
			(if (OneOf node 4 8 12 16)
				0
			else
				(+ node 1)
			)
		)
		(= wTile
			(if (OneOf node 1 5 9 13)
				0
			else
				(- node 1)
			)
		)
	)

	(method (swapNode param1 param2 &tmp temp0 temp1)
		(= temp0 (param1 node:))
		(= temp1 (param2 node:))
		(= [local1 (- temp0 1)] param2)
		(= [local1 (- temp1 1)] param1)
		(param1 node: temp1)
		(param2 node: temp0)
	)
)

(instance rm116 of ADRoom
	(properties
		picture 420
	)

	(method (init)
		(super init:)
		(gGame handsOn:)
		(= local18 (gTheIconBar height:))
		(= local19 (gTheIconBar activateHeight:))
		(= local20 (gTheIconBar y:))
		(gTheIconBar
			disable: 0 1 3 4 5 6 7 8 9
			height: -100
			activateHeight: -100
			y: -100
		)
		(t10 init: blankSpot)
		(t7 init: blankSpot)
		(t15 init: blankSpot)
		(t5 init: blankSpot)
		(t9 init: blankSpot)
		(t12 init: blankSpot)
		(t4 init: blankSpot)
		(t2 init: blankSpot)
		(t13 init: blankSpot)
		(t8 init: blankSpot)
		(t6 init: blankSpot)
		(t14 init: blankSpot)
		(t1 init: blankSpot)
		(t3 init: blankSpot)
		(t11 init: blankSpot)
		(mixedPic init: setOnMeCheck: 1 4)
		(blankSpot init: 0)
		(blankSpot calibrate:)
		(localproc_0 84 29)
		(helpButton init: stopUpd:)
	)

	(method (doVerb)
		(gGame handsOn:)
		(gTheIconBar
			curIcon: (gTheIconBar walkIconItem:)
			activateHeight: local19
			y: local20
			height: local18
		)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

(instance finishPuzzle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 434 3)
				(= cycles 2)
			)
			(1
				(gMessager say: 1 0 3 0 self) ; "The box opens! There's a bundle of letters inside. They appear to be love letters...from Ben to Deborah!"
			)
			(2
				(localproc_1)
				(mixedPic setLoop: 2)
				(gEgo get: 30 put: 29) ; Love_Letters, Puzzle_Box
				(= seconds 3)
			)
			(3
				(gGame handsOn:)
				(gTheIconBar
					curIcon: (gTheIconBar walkIconItem:)
					activateHeight: local19
					y: local20
					height: local18
				)
				(= cycles 2)
			)
			(4
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance mixedPic of View
	(properties
		x 69
		y 160
		view 825
		signal 16400
	)
)

(instance t1 of TilePiece
	(properties
		loop 1
		correctPosn 1
	)
)

(instance t2 of TilePiece
	(properties
		loop 1
		cel 1
		correctPosn 2
	)
)

(instance t3 of TilePiece
	(properties
		loop 1
		cel 2
		correctPosn 3
	)
)

(instance t4 of TilePiece
	(properties
		loop 1
		cel 3
		correctPosn 4
	)
)

(instance t5 of TilePiece
	(properties
		loop 1
		cel 4
		correctPosn 5
	)
)

(instance t6 of TilePiece
	(properties
		loop 1
		cel 5
		correctPosn 6
	)
)

(instance t7 of TilePiece
	(properties
		loop 1
		cel 6
		correctPosn 7
	)
)

(instance t8 of TilePiece
	(properties
		loop 1
		cel 7
		correctPosn 8
	)
)

(instance t9 of TilePiece
	(properties
		loop 1
		cel 8
		correctPosn 9
	)
)

(instance t10 of TilePiece
	(properties
		loop 1
		cel 9
		correctPosn 10
	)
)

(instance t11 of TilePiece
	(properties
		loop 1
		cel 10
		correctPosn 11
	)
)

(instance t12 of TilePiece
	(properties
		loop 1
		cel 11
		correctPosn 12
	)
)

(instance t13 of TilePiece
	(properties
		loop 1
		cel 12
		correctPosn 13
	)
)

(instance t14 of TilePiece
	(properties
		loop 1
		cel 13
		correctPosn 14
	)
)

(instance t15 of TilePiece
	(properties
		loop 1
		cel 14
		correctPosn 15
	)
)

(instance blankSpot of BlankSpot
	(properties
		cel 1
		correctPosn 16
	)
)

(instance helpButton of View
	(properties
		x 143
		y 166
		view 829
	)

	(method (doVerb)
		(if (not (IsFlag 98))
			(gLongSong2 number: 955 setLoop: 1 play:)
			(localproc_3)
		)
	)
)

(instance restoreCode of Code
	(properties)

	(method (doit param1 param2)
		(return
			(and
				(or (param1 isKindOf: TilePiece) (param1 isKindOf: BlankSpot))
				(== param2 (param1 correctPosn:))
			)
		)
	)
)

