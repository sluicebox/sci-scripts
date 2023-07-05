;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23601)
(include sci.sh)
(use Main)
(use n951)
(use Array)
(use Osc)
(use File)
(use Actor)
(use System)

(public
	JigsawPuzzleRm 0
)

(local
	[local0 154] = [-1 -1 1 2 2 3 3 3 3 -1 -1 -1 4 1 1 2 2 2 3 7 7 -1 -1 4 5 1 1 6 7 7 7 8 -1 -1 4 5 5 5 6 8 8 8 8 -1 -1 4 4 5 6 6 9 9 9 9 -1 10 10 10 11 11 6 12 12 9 13 13 14 10 10 15 11 11 16 12 12 12 13 14 15 15 15 18 11 16 17 17 13 13 14 14 15 18 18 18 16 19 17 17 17 24 14 20 20 18 16 16 19 19 19 23 24 20 20 21 21 21 21 21 22 19 23 24 24 20 25 25 25 22 22 22 23 23 24 26 26 27 27 25 25 28 22 28 23 -1 26 26 26 27 27 27 28 28 28 -1]
)

(instance JigsawPuzzleRm of ShiversRoom
	(properties)

	(method (doVerb &tmp temp0 temp1 temp2)
		(for ((= temp0 1)) (<= temp0 14) ((++ temp0))
			(for ((= temp1 1)) (<= temp1 11) ((++ temp1))
				(if
					(and
						(!= [local0 (- (+ temp1 (* (- temp0 1) 11)) 1)] -1)
						(!=
							[local0 (- (+ temp1 (* (- temp0 1) 11)) 1)]
							(Board get: temp0 temp1)
						)
					)
					(= temp2 1)
				)
			)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (init)
		(gKeyDownHandler add: self)
		(if (IsFlag 43)
			(gSounds play: 12316 0 90 0)
			(ClearFlag 43)
		)
		(gSounds fade: 22301 50 15 8 0 0)
		(super init: &rest)
		(spBackButton init:)
		(Jigsaw init:)
		(if (IsFlag 43)
			(gSounds play: 12316 0 90 0)
			(ClearFlag 43)
		)
	)

	(method (newRoom newRoomNumber &tmp temp0 temp1 temp2)
		(gSounds fade: 22301 82 15 8 0 0)
		(if (or (== newRoomNumber 990) (== newRoomNumber 992)) ; shiversOptions, viewingInv
			(= temp2 (File new:))
			(temp2 name: {shiversp.tmp})
			(temp2 open: 2)
			(for ((= temp0 1)) (<= temp0 28) ((++ temp0))
				(= temp1 (jsPieces at: (- temp0 1)))
				(temp2 writeWord: (temp1 loop:))
				(temp2 writeWord: (temp1 pieceNum:))
				(temp2 writeWord: (temp1 cel:))
				(temp2 writeWord: (temp1 x:))
				(temp2 writeWord: (temp1 y:))
				(temp2 writeWord: (temp1 onBoard:))
			)
			(temp2 close:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance spBackButton of ShiversProp
	(properties
		priority 15
		fixPriority 1
		view 23603
	)

	(method (doVerb)
		(gCurRoom setScript: sExitPuzzle)
	)
)

(class Jigsaw of Obj
	(properties)

	(method (init &tmp [temp0 4])
		(Board init: 82 19 1)
		(jsPieces init:)
		((View new:) view: 23602 init:)
		(super init: &rest)
	)
)

(class Board of View
	(properties
		x 82
		y 19
		fixPriority 1
		view 23602
		cel 1
		boardArray 0
		numSpaces 0
	)

	(method (init param1 param2 param3 &tmp temp0 temp1)
		(= x param1)
		(= y param2)
		(= priority param3)
		(= boardArray (IntArray new: 10))
		(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
			(boardArray at: temp0 (IntArray new: 13))
		)
		(for ((= temp0 1)) (<= temp0 11) ((++ temp0))
			(for ((= temp1 1)) (<= temp1 14) ((++ temp1))
				(if (== [local0 (- (+ temp0 (* (- temp1 1) 11)) 1)] -1)
					(self set: temp1 temp0 -1)
				else
					(self set: temp1 temp0 0)
				)
			)
		)
		(= numSpaces 154)
		(super init: &rest)
	)

	(method (set param1 param2 param3)
		((boardArray at: (- param2 1)) at: (- param1 1) param3)
	)

	(method (get param1 param2)
		((boardArray at: (- param2 1)) at: (- param1 1))
	)

	(method (place param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp4 (/ (CelHigh (param1 view:) (param1 loop:) (param1 cel:)) 7))
		(= temp5 (/ (CelWide (param1 view:) (param1 loop:) (param1 cel:)) 9))
		(for ((= temp0 0)) (< temp0 temp4) ((++ temp0))
			(for ((= temp1 0)) (< temp1 temp5) ((++ temp1))
				(= temp6 (+ (* temp1 18) 9))
				(= temp7 (+ (* temp0 18) 7))
				(if
					(!=
						(CelInfo
							4 ; GetPixel
							(param1 view:)
							(param1 loop:)
							(param1 cel:)
							temp6
							temp7
						)
						246
					)
					(= temp3 (+ (/ (- (param1 x:) (Board x:)) 9) temp1 1))
					(= temp2 (+ (/ (- (param1 y:) (Board y:)) 7) temp0 1))
					(Board set: temp2 temp3 (param1 pieceNum:))
				)
			)
		)
	)

	(method (remove param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(if (param1 onBoard:)
			(= temp4
				(/ (CelHigh (param1 view:) (param1 loop:) (param1 cel:)) 7)
			)
			(= temp5
				(/ (CelWide (param1 view:) (param1 loop:) (param1 cel:)) 9)
			)
			(for ((= temp0 0)) (< temp0 temp4) ((++ temp0))
				(for ((= temp1 0)) (< temp1 temp5) ((++ temp1))
					(= temp6 (+ (* temp1 18) 9))
					(= temp7 (+ (* temp0 18) 7))
					(if
						(!=
							(CelInfo
								4 ; GetPixel
								(param1 view:)
								(param1 loop:)
								(param1 cel:)
								temp6
								temp7
							)
							246
						)
						(= temp3 (+ (/ (- (param1 x:) (Board x:)) 9) temp1 1))
						(= temp2 (+ (/ (- (param1 y:) (Board y:)) 7) temp0 1))
						(Board set: temp2 temp3 0)
					)
				)
			)
		)
	)

	(method (canPlace param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp4 (/ (CelHigh (param1 view:) (param1 loop:) (param1 cel:)) 7))
		(= temp5 (/ (CelWide (param1 view:) (param1 loop:) (param1 cel:)) 9))
		(for ((= temp0 0)) (< temp0 temp4) ((++ temp0))
			(for ((= temp1 0)) (< temp1 temp5) ((++ temp1))
				(= temp6 (+ (* temp1 18) 9))
				(= temp7 (+ (* temp0 18) 9))
				(if
					(!=
						(CelInfo
							4 ; GetPixel
							(param1 view:)
							(param1 loop:)
							(param1 cel:)
							temp6
							temp7
						)
						246
					)
					(= temp3 (+ (/ (- (param1 x:) (Board x:)) 9) temp1 1))
					(= temp2 (+ (/ (- (param1 y:) (Board y:)) 7) temp0 1))
					(if (and (<= 1 temp2 14) (<= 1 temp3 11))
						(if (!= (Board get: temp2 temp3) 0)
							(return 0)
						)
					else
						(return 0)
					)
				)
			)
		)
		(return 1)
	)

	(method (isSolved &tmp temp0 temp1)
		(for ((= temp0 1)) (<= temp0 14) ((++ temp0))
			(for ((= temp1 1)) (<= temp1 11) ((++ temp1))
				(if
					(and
						(!= [local0 (- (+ temp1 (* (- temp0 1) 11)) 1)] -1)
						(!=
							[local0 (- (+ temp1 (* (- temp0 1) 11)) 1)]
							(self get: temp0 temp1)
						)
					)
					(return 0)
				)
			)
		)
		(return 1)
	)

	(method (dispose &tmp temp0)
		(for ((= temp0 0)) (<= temp0 10) ((++ temp0))
			((boardArray at: temp0) dispose:)
		)
		(boardArray dispose:)
		(super dispose: &rest)
	)
)

(class Piece of ShiversProp
	(properties
		priority 249
		view 23602
		pieceNum 0
		onBoard 0
	)

	(method (onMe param1 &tmp temp0 temp1)
		(param1 localize: plane)
		(if (super onMe: param1)
			(= temp0 (* (- (param1 x:) x) 2))
			(= temp1 (/ (* (- (param1 y:) y) 12) 5))
			(if
				(!=
					(CelInfo
						4 ; GetPixel
						(self view:)
						(self loop:)
						(self cel:)
						temp0
						temp1
					)
					246
				)
				(return 1)
			)
		)
		(return 0)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(event localize: plane)
		(if
			(and
				(self onMe: event)
				(& (event type:) evMOUSEBUTTON)
				(gUser canControl:)
			)
			(event claimed: 1)
			(= temp7 0)
			(self setPri: 255 1)
			(cond
				((< (= temp1 x) 1)
					(= temp1 1)
				)
				((> temp1 245)
					(= temp1 245)
				)
			)
			(cond
				((< (= temp2 y) 1)
					(= temp2 1)
				)
				((> temp2 125)
					(= temp2 125)
				)
			)
			(= temp5 (- (event x:) x))
			(= temp6 (- (event y:) y))
			(= temp0 (Event new:))
			(temp0 localize: gThePlane)
			(= temp4 (temp0 y:))
			(= temp3 (temp0 x:))
			(repeat
				(if (or (!= temp4 (temp0 y:)) (!= temp3 (temp0 x:)))
					(if (== temp7 0)
						(Board remove: self)
					)
					(= temp4 (temp0 y:))
					(= temp3 (temp0 x:))
					(self posn: (- temp3 temp5) (- temp4 temp6))
					(= temp7 1)
					(UpdateScreenItem self)
					(FrameOut)
				)
				(if (& (temp0 type:) evMOUSERELEASE)
					(gSounds stop: 12307)
					(gSounds stop: 12308)
					(if (== temp7 1)
						(= temp10
							(+
								(CelWide (self view:) (self loop:) (self cel:))
								x
							)
						)
						(= temp11
							(+
								(CelHigh (self view:) (self loop:) (self cel:))
								y
							)
						)
						(if
							(or
								(Board onMe: (+ x 3) y)
								(Board onMe: temp10 temp11)
							)
							(+= x 3)
							(= x (* (/ x 9) 9))
							(= y (/ (* (/ (* y 12) 90) 90) 12))
							(+= x 1)
							(+= y 4)
							(self setPri: -1)
							(UpdateScreenItem self)
							(FrameOut)
							(if (Board canPlace: self)
								(Board place: self)
								(= onBoard 1)
								(gSounds play: 12308 0 82 0)
							else
								(= x temp1)
								(= y temp2)
								(if onBoard
									(Board place: self)
								)
								(gSounds play: 12314 0 82 0)
							)
							(UpdateScreenItem self)
							(FrameOut)
							(if (Board isSolved:)
								(gCurRoom setScript: sPuzzleSolved)
							)
							(break)
						)
						(= temp10
							(+
								(CelWide (self view:) (self loop:) (self cel:))
								x
							)
						)
						(= temp11
							(+
								(CelHigh (self view:) (self loop:) (self cel:))
								y
							)
						)
						(if
							(and
								(<= 4 x 245)
								(<= 1 y 125)
								(not
									(and (<= 82 temp10 181) (<= 19 temp11 124))
								)
							)
							(gSounds play: 12308 0 82 0)
							(= onBoard 0)
							(break)
						)
						(= x temp1)
						(= y temp2)
						(if onBoard
							(Board place: self)
						)
						(gSounds play: 12314 0 82 0)
						(break)
					)
					(if (== onBoard 0)
						(= temp8 (+ x (/ (CelWide view loop cel) 2)))
						(= temp9 (+ y (/ (* (CelHigh view loop cel) 10) 24)))
						(= cel (mod (+ cel 1) 4))
						(= x (- temp8 (/ (CelWide view loop cel) 2)))
						(= y (- temp9 (/ (* (CelHigh view loop cel) 10) 24)))
						(gSounds play: 12307 0 82 0)
						(UpdateScreenItem self)
						(FrameOut)
					)
					(break)
				)
				(temp0 dispose:)
				(= temp0 (Event new:))
				(temp0 localize: gThePlane)
			)
			(temp0 dispose:)
		else
			(super handleEvent: event &rest)
		)
	)
)

(class jsPieces of List
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(super init: &rest)
		(if (or (== gPrevRoomNum 990) (== gPrevRoomNum 992)) ; shiversOptions, viewingInv
			(= temp8 (File new:))
			(temp8 name: {shiversp.tmp})
			(temp8 open: 1)
			(for ((= temp0 1)) (<= temp0 28) ((++ temp0))
				(= temp1 (Piece new:))
				(temp1
					loop: (temp8 readWord:)
					pieceNum: (temp8 readWord:)
					cel: (temp8 readWord:)
					x: (temp8 readWord:)
					y: (temp8 readWord:)
					onBoard: (temp8 readWord:)
					init:
				)
				(self add: temp1)
				(if (Board canPlace: temp1)
					(Board place: temp1)
				)
			)
			(temp8 close:)
			(temp8 delete:)
		else
			(= temp2 4)
			(= temp3 2)
			(= temp5 0)
			(= temp6 (Random 14 16))
			(= temp7 5)
			(for ((= temp0 1)) (<= temp0 28) ((++ temp0))
				(= temp1 (Piece new:))
				(temp1
					loop: (+ (mod (+ (* temp7 temp0) temp6) 28) 1)
					pieceNum: (+ (mod (+ (* temp7 temp0) temp6) 28) 1)
					cel: (Random 0 3)
					init:
				)
				(while
					(>
						(CelHigh (temp1 view:) (temp1 loop:) (temp1 cel:))
						(CelWide (temp1 view:) (temp1 loop:) (temp1 cel:))
					)
					(temp1 cel: (mod (+ (temp1 cel:) 1) 4))
				)
				(= temp4
					(+ (CelWide (temp1 view:) (temp1 loop:) (temp1 cel:)) temp2)
				)
				(if
					(<
						temp5
						(+
							(CelHigh (temp1 view:) (temp1 loop:) (temp1 cel:))
							temp3
						)
					)
					(= temp5
						(+
							(CelHigh (temp1 view:) (temp1 loop:) (temp1 cel:))
							temp3
						)
					)
				)
				(cond
					((and (<= 81 temp4 181) (> temp3 19))
						(= temp2 182)
						(= temp4
							(+
								(CelWide
									(temp1 view:)
									(temp1 loop:)
									(temp1 cel:)
								)
								temp2
							)
						)
					)
					((> temp4 263)
						(= temp2 4)
						(= temp4
							(+
								(CelWide
									(temp1 view:)
									(temp1 loop:)
									(temp1 cel:)
								)
								temp2
							)
						)
						(= temp3 temp5)
						(= temp5 0)
					)
				)
				(temp1 x: temp2 y: temp3)
				(= temp2 temp4)
				(self add: temp1)
			)
		)
	)
)

(instance sPuzzleSolved of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 24)
				(gSounds play: 12313 0 82 0)
				(= seconds 2)
			)
			(1
				(gGame handsOn:)
				(proc951_15 6750)
				(gCurRoom newRoom: 23600) ; rm23v600
			)
		)
	)
)

(instance sExitPuzzle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spBackButton setCycle: Osc 1)
				(gSounds play: 12315 0 82 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 23600) ; rm23v600
			)
		)
	)
)

