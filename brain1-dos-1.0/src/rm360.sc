;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use dummyClient)
(use Interface)
(use Feature)
(use LoadMany)
(use Sound)
(use Game)
(use Actor)
(use System)

(public
	rm360 0
)

(local
	local0
	local1
	local2
	local3
	[local4 80] = [0 0 36 0 70 0 115 0 156 0 188 0 231 0 272 0 0 31 25 36 68 28 117 26 159 33 187 32 226 34 281 26 0 64 33 63 68 76 112 68 148 77 189 66 240 59 276 69 0 103 24 117 -1 -1 -1 -1 159 114 200 111 240 112 276 112 0 141 34 143 -1 -1 -1 -1 157 148 192 146 234 150 271 152]
	[local84 8] = [64 114 119 114 64 152 119 152]
	[local92 320] = [0 0 37 0 75 0 117 0 152 0 194 0 233 0 277 0 0 35 31 33 78 34 120 32 154 32 191 38 238 32 280 35 0 76 34 73 73 77 117 72 153 76 197 73 235 76 277 71 0 110 34 109 80 109 113 112 154 107 193 109 233 107 280 111 0 147 33 153 80 152 119 151 154 150 199 150 239 150 279 150 17 0 58 0 97 0 136 0 176 0 215 0 254 0 295 0 14 30 55 39 96 38 134 32 174 32 214 31 256 31 294 36 16 75 55 74 94 77 135 71 177 76 218 75 257 74 296 74 13 113 59 108 94 111 141 108 172 109 212 110 256 110 299 112 12 154 55 153 99 151 138 151 172 153 220 145 253 147 299 152 12 17 60 17 93 14 139 16 172 14 212 15 254 13 299 17 12 56 52 57 94 58 139 52 172 58 220 50 253 52 299 57 18 90 58 94 94 95 136 95 176 89 215 90 254 94 295 89 17 127 56 129 95 128 138 130 174 127 215 126 256 126 294 131 17 167 56 172 96 168 136 171 177 171 218 170 257 169 296 169 0 13 39 16 79 13 119 18 155 12 193 14 233 12 280 16 0 56 33 56 73 58 120 59 160 55 199 54 239 55 279 56 0 89 35 95 78 95 116 95 159 89 194 90 233 94 277 95 0 127 34 133 74 134 120 124 153 127 191 134 238 124 280 130 0 166 35 172 79 169 117 170 154 171 197 169 235 171 277 166]
	[local412 4] = [374 377 379 378]
	local416
	local417
	local418
)

(procedure (localproc_0)
	(backFeat init:)
	(boxingGloves init:)
	(guitar init:)
	(unicycle init:)
	(bowArrow init:)
	(roundTable init:)
	(bowlingBall init:)
	(sword init:)
	(magTable init:)
	(magHat init:)
	(cards init:)
	(ship init:)
	(helmet init:)
	(theMask init:)
	(caneStand init:)
	(block init:)
	(bear init:)
	(fan init:)
	(clown init:)
	(wand init:)
	(wig init:)
	(scarf init:)
)

(procedure (localproc_1 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (param1 x:))
	(= temp1 (param1 y:))
	(= temp2 (+ temp0 (param1 width:)))
	(return
		(not
			(or
				(<= (= temp3 (+ temp1 (param1 height:))) param3)
				(>= temp1 param5)
				(<= temp2 param2)
				(>= temp0 param4)
			)
		)
	)
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp0 (+ (param1 x:) (/ (param1 width:) 2)))
	(= temp1 (+ (param1 y:) (/ (param1 height:) 2)))
	(= temp2 (param2 x:))
	(= temp3 (param2 y:))
	(= temp4 (+ temp2 (param2 width:)))
	(= temp5 (+ temp3 (param2 height:)))
	(return (and (<= temp2 temp0 temp4) (<= temp3 temp1 temp5)))
)

(instance rm360 of Rm
	(properties
		lookStr {You are in a room formed out of a giant jigsaw puzzle.__It looks incomplete.}
		picture 361
		style 7
		south 320
	)

	(method (init)
		(LoadMany rsVIEW 360 370 371 372 373)
		(LoadMany rsSOUND 59 61 380 912 964)
		(super init: &rest)
		(if (not (IsFlag 7))
			(= local0 global114)
			(switch global114
				(0
					(= local416 puzzle)
				)
				(else
					(= local416 hardPuzzle)
				)
			)
			(gCMusic number: 360 setLoop: -1 flags: 1 play:)
			(local416 init:)
			(= local417 1)
			(if (not (IsFlag 46))
				(proc5_9 360 0) ; "This room looks incomplete. Since we rarely forget to finish a painting before shipping a game, it must be up to you to put the pieces of this puzzle together."
				(proc5_9 360 1) ; "You can get puzzle pieces by clicking the Hand on the chest. Click a piece anywhere on the screen to place it. Pick up a piece by clicking on it, or several pieces by dragging the mouse across them. You can put pieces aside by clicking them on the chest opening."
				(SetFlag 46)
			)
		else
			(gCurRoom
				lookStr:
					{It's amazing how smoothly the puzzle pieces fit together. The room now looks so real that you feel you could almost reach out and open the painted door on the back wall.}
			)
			(= local417 1)
			(= local1 1)
			(= local416 puzzle)
			(if (!= gPrevRoomNum 380) ; rmCode
				(gCMusic number: 380 flags: 1 play:)
			)
			(puzzle init:)
			(backDoor init:)
			(localproc_0)
		)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(if local417
			(local416 dispose:)
		)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(if (!= (= temp0 (event type:)) evVERB)
			(= local418 (!= temp0 evMOUSEBUTTON))
		)
		(if
			(and
				(& (gTheIconBar state:) $0004)
				(!= temp0 evVERB)
				(not (event claimed:))
				(not (event modifiers:))
				(or (and (== temp0 evKEYBOARD) (== (event message:) KEY_RETURN)) (== temp0 evMOUSEBUTTON))
			)
			(event
				type: ((gTheIconBar curIcon:) type:)
				message: ((gTheIconBar curIcon:) message:)
			)
		)
		(if
			(and
				(or
					(event claimed:)
					(!= (event type:) evVERB)
					(not ((local416 placedList:) handleEvent: event))
				)
				(== (event type:) evVERB)
			)
			(switch (event message:)
				(JOY_UPRIGHT
					(if (not (IsFlag 7))
						(Print 360 2 #icon 361 0 0)
					)
				)
			)
			(super handleEvent: event)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (GameIsRestarting)
			((local416 placedList:) eachElementDo: #show)
		)
	)
)

(class RubberBand of Obj
	(properties
		startX 0
		startY 0
		underLine1 0
		underLine2 0
		underLine3 0
		underLine4 0
		oldEndX 0
		oldEndY 0
	)

	(method (init param1 param2)
		(super init: &rest)
		(= startX (= oldEndX param1))
		(= startY (= oldEndY param2))
	)

	(method (dispose)
		(self restoreLines:)
		(super dispose:)
	)

	(method (restoreLines)
		(if underLine1
			(Graph grRESTORE_BOX underLine4)
			(Graph grRESTORE_BOX underLine3)
			(Graph grRESTORE_BOX underLine2)
			(Graph grRESTORE_BOX underLine1)
			(Graph grUPDATE_BOX startY startX (+ oldEndY 1) (+ oldEndX 1) 1)
			(= underLine1 0)
		)
	)

	(method (doit param1 param2)
		(self restoreLines:)
		(if (<= param1 startX)
			(= param1 (+ startX 2))
		)
		(if (<= param2 startY)
			(= param2 (+ startY 2))
		)
		(self drawBox: startY startX param2 param1)
		(= oldEndX param1)
		(= oldEndY param2)
	)

	(method (drawBox param1 param2 param3 param4)
		(= underLine1
			(Graph grSAVE_BOX (- param1 1) (- param2 1) (+ param1 2) (+ param4 2) 1)
		)
		(= underLine2
			(Graph grSAVE_BOX (- param1 1) (- param4 1) (+ param3 2) (+ param4 2) 1)
		)
		(= underLine3
			(Graph grSAVE_BOX (- param3 1) (- param2 1) (+ param3 1) (+ param4 1) 1)
		)
		(= underLine4
			(Graph grSAVE_BOX (- param1 1) (- param2 1) (+ param3 1) (+ param2 1) 1)
		)
		(Graph grDRAW_LINE param1 param2 param1 param4 0 -1 -1)
		(Graph grDRAW_LINE param1 param4 param3 param4 0 -1 -1)
		(Graph grDRAW_LINE param3 param2 param3 param4 0 -1 -1)
		(Graph grDRAW_LINE param1 param2 param3 param2 0 -1 -1)
		(Graph grUPDATE_BOX (- param1 1) (- param2 1) (+ param3 1) (+ param4 1) 1)
	)
)

(class VObject of Obj
	(properties
		view 0
		loop 0
		cel 0
		x 0
		y 0
	)

	(method (posn param1 param2)
		(= x param1)
		(= y param2)
	)

	(method (show)
		(DrawCel view loop cel x y 15)
	)

	(method (hide &tmp temp0 temp1)
		(= temp0 (self width:))
		(= temp1 (self height:))
		(Graph grFILL_BOX y x (+ y temp1) (+ x temp0) 1 198)
		(Graph grUPDATE_BOX y x (+ y temp1) (+ x temp0))
	)

	(method (onMe param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (param1 x:))
		(= temp1 (param1 y:))
		(= temp2 x)
		(= temp4 y)
		(= temp3 (+ temp2 (self width:)))
		(= temp5 (+ temp4 (self height:)))
		(return (and (<= temp2 temp0 temp3) (<= temp4 temp1 temp5)))
	)

	(method (intersect param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0 x)
		(= temp1 y)
		(= temp2 (+ x (self width:)))
		(= temp3 (+ y (self height:)))
		(= temp4 (param1 x:))
		(= temp5 (param1 y:))
		(= temp6 (+ (param1 x:) (param1 width:)))
		(= temp7 (+ (param1 y:) (param1 height:)))
		(return
			(not
				(or
					(<= temp3 temp5)
					(>= temp1 temp7)
					(<= temp2 temp4)
					(>= temp0 temp6)
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(== (event type:) evVERB)
					(== (event message:) JOY_RIGHT)
					(self onMe: event)
				)
				(event claimed: 1)
			)
		)
	)

	(method (width)
		(CelWide view loop cel)
	)

	(method (height)
		(CelHigh view loop cel)
	)
)

(class PuzPiece of VObject
	(properties
		trueXPos 0
		trueYPos 0
		xAnchorOff 0
		yAnchorOff 0
		value 0
		client 0
	)

	(method (posn param1 param2)
		(super posn: param1 param2)
		(if (== self (local416 curPiece:))
			((local416 pView:) posn: x y)
		)
	)

	(method (doit param1 param2 &tmp temp0 temp1)
		(if (not ((local416 dragList:) size:))
			(-= param1 (/ (self width:) 2))
			(-= param2 (/ (self height:) 2))
		)
		(if (== self (= temp1 (local416 curPiece:)))
			(self posn: param1 param2)
		else
			(self posn: (+ param1 xAnchorOff) (+ param2 yAnchorOff))
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(cond
			((IsFlag 7) 0)
			((event claimed:)
				(return 1)
			)
			((local416 curPiece:)
				(return 0)
			)
			((or (!= (event type:) evVERB) (not (self onMe: event))))
			((== (event message:) JOY_RIGHT)
				((= local2 (RubberBand new:)) init: (event x:) (event y:))
				(= temp2 (event x:))
				(= temp3 (event y:))
				(if (not local418)
					(while (!= ((= temp1 (Event new:)) type:) evMOUSERELEASE)
						(temp1 localize:)
						(if (or (!= temp2 (temp1 x:)) (!= temp3 (temp1 y:)))
							(= temp2 (temp1 x:))
							(= temp3 (temp1 y:))
							(local2 doit: temp2 temp3)
						)
						(temp1 dispose:)
					)
					(temp1 dispose:)
				)
				(self hide:)
				(= temp4 (local2 startX:))
				(= temp5 (local2 startY:))
				(= temp6 (local2 oldEndX:))
				(= temp7 (local2 oldEndY:))
				(local416 pickPiece: self)
				(local416 getDragList: temp4 temp5 temp6 temp7)
				(event claimed: 1)
			)
			((== (event message:) JOY_UPRIGHT)
				(proc5_9 360 3) ; "This is a jigsaw puzzle piece."
				(event claimed: 1)
			)
		)
	)

	(method (addToIntSet param1 param2)
		(if (self intersect: param2)
			(param1 add: self)
		)
	)

	(method (hide)
		(super hide:)
		(local416 drawIntPieces: self)
	)

	(method (quickHide)
		(super hide:)
	)
)

(class RPuzzle of Obj
	(properties
		curPiece 0
		notPlacedList 0
		placedList 0
		dragList 0
		pView 0
		oldX 0
		oldY 0
		dragBits 0
		xExtentOff 0
		yExtentOff 0
		numPieces 0
	)

	(method (getNewPiece param1 param2 &tmp temp0)
		(if (= temp0 (notPlacedList size:))
			(gTheIconBar disable:)
			(= curPiece (notPlacedList at: (Random 0 (- temp0 1))))
			(-= param1 (/ (curPiece width:) 2))
			(-= param2 (/ (curPiece height:) 2))
			(curPiece posn: param1 param2)
			(self assignToView:)
			(gGame setCursor: 202 1)
		else
			(proc5_9 360 4) ; "The box is empty."
		)
	)

	(method (placePiece param1 param2 &tmp temp0 temp1)
		(gTheIconBar enable:)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		(= temp1 placedList)
		(if (dragList contains: curPiece)
			(curPiece
				posn:
					(+ param1 (curPiece xAnchorOff:))
					(+ param2 (curPiece yAnchorOff:))
			)
			(if
				(or
					(localproc_2 curPiece (temp1 at: 0))
					(localproc_2 curPiece (temp1 at: 1))
					(localproc_2 curPiece (temp1 at: 2))
					(localproc_2 curPiece (temp1 at: 3))
				)
				(self depositPiece:)
				(return)
			)
		)
		(if (<= (curPiece y:) 0)
			(curPiece y: 0)
		)
		(if
			(<=
				(= temp0
					(GetDistance
						(curPiece x:)
						(curPiece y:)
						(curPiece trueXPos:)
						(curPiece trueYPos:)
					)
				)
				8
			)
			(curPiece posn: (curPiece trueXPos:) (curPiece trueYPos:))
			(gCMusic2 number: 964 flags: 1 setVol: 127 setLoop: 1 play:)
		)
		(self clearView:)
		(curPiece show:)
		(notPlacedList delete: curPiece)
		(placedList add: curPiece)
		(= curPiece 0)
		(placePieceSound play:)
		(if (self testForDone:)
			(gCMusic number: 380 setLoop: -1 flags: 1 play:)
			(proc5_0 7 local0)
			(Print 360 5) ; "Congratulations! You've managed to put the room back together. It is just the sort of room you (and Dr. Brain) like, filled with all kinds of toys. You can now see a door in the back of the room."
			(gEgo get: 25)
			(gCurRoom
				lookStr:
					{It's amazing how smoothly the puzzle pieces fit together. The room now looks so real that you feel you could almost reach out and open the painted door on the back wall.}
			)
			(= local1 1)
			(backDoor init:)
			(localproc_0)
		)
	)

	(method (pickPiece param1)
		(gTheIconBar disable:)
		(= curPiece param1)
		(self assignToView:)
		(curPiece hide:)
		(placedList delete: curPiece)
		(notPlacedList add: curPiece)
		(gGame setCursor: 202 1)
	)

	(method (drawIntPieces param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp6 0)
		((= temp0 (Set new:)) add:)
		(placedList eachElementDo: #addToIntSet temp0 param1)
		(= temp1 0)
		(= temp2 (dragList size:))
		(while (< temp1 temp2)
			(placedList eachElementDo: #addToIntSet temp0 (dragList at: temp1))
			(++ temp1)
		)
		(temp0 delete: param1)
		(= temp4 (temp0 size:))
		(for ((= temp3 0)) (< temp3 temp4) ((++ temp3))
			(= temp5 (temp0 at: temp3))
			(temp5 show:)
			(if (temp5 isKindOf: box)
				(= temp6 1)
			)
		)
		(if temp6
			(placedList eachElementDo: #show)
		)
		(temp0 release: dispose:)
	)

	(method (depositPiece)
		(gTheIconBar enable:)
		(curPiece x: -100 y: -100)
		(self clearView:)
		(= curPiece 0)
		(depositPieceSound play:)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
	)

	(method (assignToView)
		(pView
			view: (curPiece view:)
			loop: (curPiece loop:)
			cel: (curPiece cel:)
			x: (curPiece x:)
			y: (curPiece y:)
			setPri: 15
		)
	)

	(method (clearView)
		(pView x: -100 y: -100)
		(Animate (gCast elements:) 0)
	)

	(method (getDragList param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(if (u>= (= temp10 (* (- param3 param1) (- param4 param2))) 16000)
			(local2 dispose:)
			(curPiece hide:)
			(proc5_9 360 6) ; "Please drag fewer pieces at a time. Memory isn't free, you know!"
			(return)
		)
		(= temp2 (curPiece x:))
		(= temp4 (+ (= temp3 (curPiece y:)) (curPiece height:)))
		(= temp5 (+ temp2 (curPiece width:)))
		(if (not (or (< (- param3 param1) 4) (< (- param4 param2) 4)))
			(for ((= temp0 0)) (< temp0 ((self placedList:) size:)) ((++ temp0))
				(= temp1 (placedList at: temp0))
				(if
					(and
						(!= curPiece temp1)
						(!= (temp1 view:) 360)
						(localproc_1 temp1 param1 param2 param3 param4)
					)
					(temp1
						xAnchorOff: (- (temp1 x:) (curPiece x:))
						yAnchorOff: (- (temp1 y:) (curPiece y:))
					)
					(placedList delete: temp1)
					(-- temp0)
					(notPlacedList add: temp1)
					(dragList add: temp1)
					(= temp6 (temp1 x:))
					(= temp7 (temp1 y:))
					(= temp8 (+ temp6 (temp1 width:)))
					(= temp9 (+ temp7 (temp1 height:)))
					(if (< temp6 temp2)
						(= temp2 temp6)
					)
					(if (< temp7 temp3)
						(= temp3 temp7)
					)
					(if (> temp9 temp4)
						(= temp4 temp9)
					)
					(if (> temp8 temp5)
						(= temp5 temp8)
					)
				)
			)
			(= xExtentOff (- (curPiece x:) temp2))
			(= yExtentOff (- (curPiece y:) temp3))
			(local2 restoreLines:)
			(curPiece hide:)
			(if (dragList size:)
				(gGame
					setCursor:
						202
						1
						(= oldX (+ temp2 (/ (- temp5 temp2) 2)))
						(= oldY (+ temp3 (/ (- temp4 temp3) 2)))
				)
				(dragList eachElementDo: #quickHide)
				(theView hide:)
				(placedList eachElementDo: #show)
				(= dragBits (Graph grSAVE_BOX temp3 temp2 temp4 temp5 1))
				(dragList eachElementDo: #show)
				(curPiece show:)
				(pView show:)
				(local2
					startX: temp2
					startY: temp3
					oldEndX: temp5
					oldEndY: temp4
				)
			else
				(local2 dispose:)
			)
		else
			(local2 dispose:)
		)
		(curPiece hide:)
	)

	(method (placeDragList param1 &tmp temp0 temp1 temp2)
		(= temp1 (curPiece x:))
		(= temp2 (curPiece y:))
		(Graph grRESTORE_BOX (self dragBits:))
		(Graph
			grUPDATE_BOX
			(local2 startY:)
			(local2 startX:)
			(local2 oldEndY:)
			(local2 oldEndX:)
			1
		)
		(local2 dispose:)
		(if (== param1 0)
			(self placePiece: 0 0)
		else
			(self depositPiece:)
		)
		(for ((= temp0 0)) (< temp0 (dragList size:)) ((++ temp0))
			(= curPiece (dragList at: temp0))
			(switch param1
				(0
					(self placePiece: temp1 temp2)
				)
				(1
					(self depositPiece:)
				)
			)
		)
		(dragList release:)
	)

	(method (testForDone &tmp temp0 temp1)
		(if (== (placedList size:) (+ numPieces 4))
			(for ((= temp0 0)) (< temp0 (+ numPieces 4)) ((++ temp0))
				(= temp1 (placedList at: temp0))
				(if
					(and
						(!= (temp1 view:) 360)
						(or
							(!= (temp1 x:) (temp1 trueXPos:))
							(!= (temp1 y:) (temp1 trueYPos:))
						)
					)
					(return 0)
				)
			)
			(return 1)
		)
	)

	(method (savePlacedPieces &tmp temp0 temp1 temp2 temp3 temp4 [temp5 3] temp8 temp9)
		(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
			(= [global210 temp0] 0)
		)
		(= temp1 (placedList size:))
		(= temp8 0)
		(if (> temp1 0)
			(SetFlag 8)
		)
		(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
			(= temp9 -32768)
			(= temp2 (placedList at: temp0))
			(if
				(and
					(== (temp2 x:) (temp2 trueXPos:))
					(== (temp2 y:) (temp2 trueYPos:))
				)
				(= temp3 (/ (temp2 value:) 16))
				(= temp4 (mod (temp2 value:) 16))
				(>>= temp9 temp4)
				(|= [global210 temp3] temp9)
			)
		)
	)

	(method (isAlreadySaved param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0 -32768)
		(= temp1 (/ (= temp3 (param1 value:)) 16))
		(= temp2 (mod temp3 16))
		(>>= temp0 temp2)
		(return (& [global210 temp1] temp0))
	)

	(method (dispose)
		(self savePlacedPieces:)
		(notPlacedList eachElementDo: #dispose release: dispose:)
		(placedList eachElementDo: #dispose release: dispose:)
		(dragList eachElementDo: #dispose release: dispose:)
		(super dispose: &rest)
	)
)

(class PuzProp of Prop
	(properties
		client 0
	)
)

(instance theView of PuzProp
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 [temp9 2])
		(super doit: &rest)
		(if (= temp4 (client curPiece:))
			(= temp1 (Event new: $ffff)) ; evPEEK | evALL_EVENTS
			(temp1 localize:)
			(= temp2 (temp1 x:))
			(= temp3 (temp1 y:))
			(temp1 dispose:)
			(= temp5 (client oldX:))
			(= temp6 (client oldY:))
			(if (or (!= temp5 temp2) (!= temp6 temp3))
				(= temp7 (- temp2 temp5))
				(= temp8 (- temp3 temp6))
				(if (IsObject local2)
					(if
						(or
							(< (+ temp7 (local2 startX:)) 1)
							(< (+ temp8 (local2 startY:)) 2)
							(> (+ temp7 (local2 oldEndX:)) 318)
							(> (+ temp8 (local2 oldEndY:)) 198)
						)
						(= temp7 0)
						(= temp8 0)
					)
					(Graph grRESTORE_BOX (client dragBits:))
					(Graph
						grUPDATE_BOX
						(local2 startY:)
						(local2 startX:)
						(local2 oldEndY:)
						(local2 oldEndX:)
						1
					)
					(local2 startX: (+ temp7 (local2 startX:)))
					(local2 startY: (+ temp8 (local2 startY:)))
					(local2 oldEndX: (+ temp7 (local2 oldEndX:)))
					(local2 oldEndY: (+ temp8 (local2 oldEndY:)))
					(client
						dragBits:
							(Graph
								grSAVE_BOX
								(local2 startY:)
								(local2 startX:)
								(local2 oldEndY:)
								(local2 oldEndX:)
								1
							)
					)
					(temp4
						doit:
							(+ (client xExtentOff:) (local2 startX:))
							(+ (client yExtentOff:) (local2 startY:))
					)
					((client dragList:)
						eachElementDo:
							#doit
							(+ (client xExtentOff:) (local2 startX:))
							(+ (client yExtentOff:) (local2 startY:))
					)
					((client dragList:) eachElementDo: #show)
					((client curPiece:) show:)
				else
					(temp4 doit: temp2 temp3)
				)
				(client oldX: temp2)
				(client oldY: temp3)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 3] temp3)
		(= temp3 (client placedList:))
		(if
			(and
				(not (event claimed:))
				(== (event type:) evVERB)
				(== (event message:) JOY_RIGHT)
				(client curPiece:)
				(not ((temp3 at: 0) handleEvent: event))
			)
			(if ((client dragList:) size:)
				(client placeDragList: 0)
			else
				(client placePiece:)
			)
			(event claimed: 1)
		)
	)
)

(instance puzzle of RPuzzle
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 103] temp111 [temp112 4])
		(super init: &rest)
		(if (== global170 -1)
			(= global170 global114)
		)
		((= notPlacedList (List new:)) add:)
		((= dragList (List new:)) add:)
		((= placedList (EventHandler new:)) add:)
		((= pView theView) view: 370 posn: -100 -100 init:)
		(= numPieces 36)
		(pView client: self)
		(= temp111 (= temp0 (= temp7 0)))
		(= temp4 0)
		(for ((= temp1 0)) (< temp1 5) ((++ temp1))
			(for ((= temp2 0)) (< temp2 8) ((++ temp2))
				(if (!= [local4 (* (= temp3 (+ (* 8 temp1) temp2)) 2)] -1)
					(= temp6 (+ temp3 temp3))
					((= temp5 (PuzPiece new:))
						x: -100
						y: -100
						view: (+ temp0 (if (mod temp1 2) 372 else 370))
						loop: (/ temp3 16)
						cel: (/ temp2 2)
						trueXPos: [local4 temp6]
						trueYPos: [local4 (+ temp6 1)]
						client: self
						value: temp4 species
					)
					(if (IsFlag 7)
						(temp5 x: (temp5 trueXPos:) y: (temp5 trueYPos:) show:)
					)
					(if
						(and
							(== global170 global114)
							(self isAlreadySaved: temp5)
						)
						(temp5 posn: (temp5 trueXPos:) (temp5 trueYPos:) show:)
						(placedList add: temp5)
					else
						(notPlacedList add: temp5)
					)
					(++ temp4)
				else
					(= temp6 (+ temp7 temp7))
					((= temp5 (box new:))
						x: [local84 temp6]
						y: [local84 (+ temp6 1)]
						view: 360
						loop: 0
						cel: temp7
						client: self
						init:
					)
					(placedList addToFront: temp5)
					(temp5 show:)
					(++ temp7)
				)
				(= temp0 (- 1 temp0))
				(++ temp111)
			)
		)
		(= global170 global114)
	)
)

(instance hardPuzzle of RPuzzle
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 [temp12 103] temp115 [temp116 4])
		(super init: &rest)
		(if (== global170 -1)
			(= global170 global114)
		)
		((= notPlacedList (List new:)) add:)
		((= dragList (List new:)) add:)
		((= placedList (EventHandler new:)) add:)
		((= pView theView) view: 370 posn: -100 -100 init:)
		(pView client: self)
		(= numPieces 148)
		(for ((= temp2 0)) (< temp2 4) ((++ temp2))
			(= temp10 (+ temp2 temp2))
			((= temp9 (box new:))
				x: [local84 temp10]
				y: [local84 (+ temp10 1)]
				view: 360
				loop: 4
				cel: temp2
				init:
				show:
				client: self
			)
			(placedList addToFront: temp9)
		)
		(= temp115 (= temp3 (= temp11 0)))
		(= temp8 0)
		(for ((= temp7 0)) (< temp7 4) ((++ temp7))
			(for ((= temp4 0)) (< temp4 5) ((++ temp4))
				(for ((= temp5 0)) (< temp5 8) ((++ temp5))
					(= temp10 (= temp6 (* 2 temp115)))
					(if
						(not
							(OneOf
								temp115
								34
								35
								74
								75
								106
								107
								114
								115
								146
								147
								154
								155
							)
						)
						((= temp9 (PuzPiece new:))
							x: [local92 temp10]
							y: [local92 (+ temp10 1)]
							view: [local412 temp7]
							loop: temp4
							cel: temp5
							trueXPos: [local92 temp10]
							trueYPos: [local92 (+ temp10 1)]
							client: self
							init:
							value: temp8
						)
						(= temp0 (temp9 x:))
						(= temp1 (temp9 y:))
						(cond
							(
								(and
									(== global114 1)
									(or
										(== temp1 0)
										(== temp0 0)
										(>= temp1 166)
										(>= temp0 290)
									)
								)
								(temp9 show:)
								(placedList add: temp9)
							)
							(
								(and
									(== global114 global170)
									(self isAlreadySaved: temp9)
								)
								(placedList add: temp9)
								(temp9 show:)
							)
							(else
								(notPlacedList add: temp9)
							)
						)
						(++ temp8)
					)
					(++ temp115)
				)
			)
		)
		(= global170 global114)
	)
)

(instance placePieceSound of Sound
	(properties
		flags 1
		number 59
	)
)

(instance depositPieceSound of Sound
	(properties
		flags 1
		number 61
	)
)

(instance backDoor of Prop
	(properties
		x 94
		y 48
		description {back door}
		sightAngle 180
		view 360
		loop 1
		priority 15
		signal 16
	)

	(method (onMe)
		(return 0)
	)
)

(instance backFeat of Feature
	(properties
		nsLeft 84
		nsBottom 68
		nsRight 157
		description {back door}
		onMeCheck 4096
		lookStr {This door is labelled with the mysterious phrase "Doce Omor".}
	)

	(method (doVerb theVerb)
		(if (== theVerb 3)
			(gCMusic2 number: 912 flags: 1 setVol: 127 setLoop: 1 play:)
			(backDoor cel: 1)
			(Animate (gCast elements:) 0)
			(gCurRoom newRoom: 380) ; rmCode
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(class box of PuzPiece
	(properties
		view 360
		x 67
		y 114
		onMeCheck 2
	)

	(method (onMe param1)
		(return
			(or
				(& $0002 (OnControl CONTROL (param1 x:) (param1 y:)))
				(and
					(== (param1 message:) 2)
					(& $0200 (OnControl CONTROL (param1 x:) (param1 y:)))
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0 [temp1 2] temp3)
		(= temp0 1)
		(cond
			((event claimed:))
			((not (self onMe: event))
				(= temp0 0)
			)
			((!= (event type:) evVERB))
			(local1
				(switch (event message:)
					(JOY_UPRIGHT
						(proc5_9 360 7) ; "You look in vain, but find nothing except a 1981 Prince Charles and Lady Diana picture calendar with popups. You decide you can do without that."
					)
					(JOY_RIGHT
						(proc5_9 360 8) ; "Sorry, but the chest has been nailed to the floor by one of Dr. Brain's paranoid former assistants."
					)
				)
			)
			((== (event message:) JOY_UPRIGHT)
				(++ local3)
				(cond
					((== ((client notPlacedList:) size:) 0)
						(proc5_9 360 4) ; "The box is empty."
					)
					((== local3 1)
						(proc5_9 360 9) ; "This chest contains a stack of puzzle pieces and your long-missing car keys."
					)
					((== local3 2)
						(proc5_9 360 10) ; "Oh, sorry, my mistake. Your car keys weren't in the box after all. You must have left them somewhere else."
					)
					(else
						(proc5_9 360 1) ; "You can get puzzle pieces by clicking the Hand on the chest. Click a piece anywhere on the screen to place it. Pick up a piece by clicking on it, or several pieces by dragging the mouse across them. You can put pieces aside by clicking them on the chest opening."
					)
				)
			)
			((!= (event message:) JOY_RIGHT)
				(proc5_9 360 11) ; "That won't work here."
			)
			((client curPiece:)
				(if (= temp3 ((client dragList:) size:))
					(client placeDragList: 1)
				else
					(client depositPiece:)
				)
			)
			(else
				(client getNewPiece: (event x:) (event y:))
			)
		)
		(if temp0
			(event claimed: 1)
		)
		(event claimed:)
	)
)

(instance guitar of Feature
	(properties
		nsTop 8
		nsLeft 7
		nsBottom 68
		nsRight 82
		description {Spanish guitar}
		onMeCheck 16
		lookStr {It's a beautifully hand-crafted Spanish guitar.}
	)
)

(instance unicycle of Feature
	(properties
		nsTop 21
		nsLeft 23
		nsBottom 147
		nsRight 83
		description {unicycle}
		onMeCheck 32
		lookStr {You can't be a clown without a unicycle.}
	)
)

(instance bowArrow of Feature
	(properties
		nsTop 60
		nsBottom 145
		nsRight 37
		description {bow and arrows}
		onMeCheck 8
		lookStr {These would be useful on a visit to Sherwood Forest.}
	)
)

(instance roundTable of Feature
	(properties
		nsTop 140
		nsBottom 189
		nsRight 45
		description {round table}
		onMeCheck 4
		lookStr {This is an elemental table, borrowed from Aziza in Quest for Glory II: Trial By Fire, (Actually, this is a cheap plug for another of Corey's computer games.)}
	)
)

(instance bowlingBall of Feature
	(properties
		nsTop 83
		nsLeft 145
		nsBottom 141
		nsRight 183
		description {bowling ball and pin}
		onMeCheck 8
		lookStr {Dr. Brain's experiment with magnetizing his bowling ball and the headpin almost worked. But he got caught (or, rather, the pin did!)}
	)
)

(instance sword of Feature
	(properties
		nsTop 63
		nsLeft 180
		nsBottom 148
		nsRight 250
		description {sword and shield}
		onMeCheck 16
		lookStr {Dr. Brain bought these in Spielburg, but decided that he was more interested in being a scientist than a Hero. Of course, you can do both. (Watch out, another cheap plug coming up!). All you have to do is buy "Quest for Glory I: So You Want To Be A Hero!"}
	)
)

(instance magTable of Feature
	(properties
		nsTop 120
		nsLeft 170
		nsBottom 189
		nsRight 319
		description {magician's table}
		onMeCheck 2048
		lookStr {This table features a number of false compartments and other tricks useful to the aspiring amateur stage magician.}
	)
)

(instance magHat of Feature
	(properties
		nsTop 111
		nsLeft 264
		nsBottom 170
		nsRight 319
		description {magician's hat}
		onMeCheck 128
		lookStr {"Here, watch me pull a rabbit out of my hat!" On the other hand, maybe you'd better leave that for the professionals.}
	)
)

(instance cards of Feature
	(properties
		nsTop 172
		nsLeft 285
		nsBottom 189
		nsRight 319
		description {playing cards}
		onMeCheck 1024
		lookStr {On closer inspection, you discover that these cards have been marked. But why would anyone want to know which cards are "8"'s?}
	)
)

(instance ship of Feature
	(properties
		nsTop 35
		nsLeft 247
		nsBottom 80
		nsRight 319
		description {model ship}
		onMeCheck 4
		lookStr {Dr. Brain couldn't figure out how to fit this ship in a bottle.}
	)
)

(instance helmet of Feature
	(properties
		nsTop 20
		nsLeft 200
		nsBottom 80
		nsRight 255
		description {Roman helmet}
		onMeCheck 16384
		lookStr {Dr. Brain likes to wear this helmet on walks, especially when he's just Roman around.}
	)
)

(instance theMask of Feature
	(properties
		nsTop 35
		nsLeft 150
		nsBottom 75
		nsRight 185
		description {theatre mask}
		onMeCheck 256
		lookStr {This is a porcelain theater mask.}
	)
)

(instance caneStand of Feature
	(properties
		nsTop 58
		nsLeft 60
		nsBottom 127
		nsRight 84
		description {cane stand}
		onMeCheck 64
		lookStr {Dr. Brain keeps his favorite walking sticks, a sword cane and a sugar cane, in this stand.}
	)
)

(instance block of Feature
	(properties
		nsTop 8
		nsLeft 280
		nsBottom 30
		nsRight 308
		description {child's block}
		onMeCheck 8192
		lookStr {Dr. Brain much prefers alphabet blocks to mental blocks.}
	)
)

(instance boxingGloves of Feature
	(properties
		nsTop 5
		nsLeft 150
		nsBottom 45
		nsRight 183
		description {boxing gloves}
		onMeCheck 128
		lookStr {In his youth, Dr. Brain contended for the heavy-weight title as "Bear-Belly Brain". He lost.}
	)
)

(instance bear of Feature
	(properties
		nsLeft 250
		nsBottom 30
		nsRight 290
		description {teddy bear}
		onMeCheck 2048
		lookStr {It's unbearably cute.}
	)
)

(instance fan of Feature
	(properties
		nsLeft 210
		nsBottom 30
		nsRight 250
		description {hand fan}
		onMeCheck 1024
		lookStr {This is one of Dr. Brain's greatest fans.}
	)
)

(instance clown of Feature
	(properties
		nsLeft 285
		nsBottom 30
		nsRight 319
		description {clown}
		onMeCheck 4096
		lookStr {This clown doesn't seem to know which end is up.}
	)
)

(instance wand of Feature
	(properties
		nsTop 134
		nsLeft 222
		nsBottom 147
		nsRight 280
		description {magic wand}
		onMeCheck 256
		lookStr {Magicians use these wands to improve their spelling.}
	)
)

(instance wig of Feature
	(properties
		nsTop 88
		nsLeft 245
		nsBottom 140
		nsRight 280
		description {dummy head}
		onMeCheck 32
		lookStr {This head looks wigged-out.}
	)
)

(instance scarf of Feature
	(properties
		nsTop 77
		nsLeft 260
		nsBottom 121
		nsRight 319
		description {scarf}
		onMeCheck 64
		lookStr {It's a rabbit. No, it's a scarf! Saves on cleaning bills.}
	)
)

