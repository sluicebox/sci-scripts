;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 83)
(include sci.sh)
(use Main)
(use PuzzleBar)
(use DText)
(use Str)
(use Array)
(use User)
(use Actor)
(use System)

(public
	trap 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(procedure (localproc_0 param1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 (+ argc 1)) ((++ temp0))
		(local3 at: (+ temp0 1) [param1 temp0])
	)
)

(procedure (localproc_1 param1 &tmp temp0)
	(if (== param1 1)
		(return 1)
	)
	(for ((= temp0 0)) (< temp0 31) ((++ temp0))
		(if
			(or
				(== (& (local3 at: temp0) $00ff) param1)
				(== (>> (local3 at: temp0) $0008) param1)
			)
			(return temp0)
		)
	)
)

(procedure (localproc_2 param1 &tmp temp0)
	(FrameOut)
	(while (not (OneOf (((User curEvent:) new:) type:) 4 1 32))
		(= gGameTime (+ gTickOffset (GetTime)))
		(gSounds eachElementDo: #check)
		(gSounds eachElementDo: #doit)
	)
	(if (== param1 -1)
		(if (IsFlag 27)
			(gEgo solvePuzzle: 407 2)
			(SetFlag 33)
		else
			(gEgo solvePuzzle: 406 2)
			(SetFlag 27)
		)
	)
	(trap state: (& (trap state:) $ffdf))
)

(procedure (localproc_3 param1 &tmp temp0 temp1)
	(= temp0 0)
	(if (IsFlag 27)
		(switch param1
			(8
				(= temp0 8)
			)
			(21
				(= temp0 9)
			)
		)
	else
		(switch gHeroType
			(1 ; Magic User
				(switch param1
					(10
						(= temp0 4)
					)
					(13
						(= temp0 6)
					)
					(15
						(= temp0 5)
					)
				)
			)
			(2 ; Thief
				(switch param1
					(12
						(= temp0 10)
						(= temp1 1)
					)
					(19
						(= temp0 7)
					)
					(21
						(= temp0 5)
					)
				)
			)
			(else
				(switch param1
					(14
						(= temp0 9)
					)
					(23
						(= temp0 5)
					)
				)
			)
		)
	)
	(if temp0
		(if ((trap puzzleCast:) contains: screenView)
			(screenView dispose:)
		)
		(screenView loop: temp0 x: 11 y: 31)
		(screenView init: (trap puzzleCast:))
	)
)

(instance trap of PuzzleBar
	(properties)

	(method (helpYou)
		(gMessager say: 17 9 0 local6 0)
		(if (== local6 5)
			(SetFlag 27)
			(localproc_2)
		else
			(++ local6)
		)
	)

	(method (init)
		(= local6 1)
		(= local5 0)
		(= local4 (IntArray new: 128))
		(= local3 (IntArray new: 31))
		(super init:)
		(self add: screen yesButton noButton anUpButton)
	)

	(method (setPlane)
		(= usePlane 1)
		(plane
			bitmap: 0
			priority: (+ (GetHighPlanePri) 1)
			init:
			setRect: 82 40 250 190
			setBitmap: 935 0 0 1
			addCast: puzzleCast
		)
	)

	(method (giveYou)
		(gMessager say: 4 4 24) ; "You don't have anything you can use on the T.R.A.P."
	)

	(method (dispose)
		(local3 dispose:)
		(local4 dispose:)
		(super dispose: &rest)
	)

	(method (resetPuzzle &tmp temp0)
		(if (IsFlag 109)
			(= temp0 (Str new:))
			(Message msgGET 380 4 6 27 1 (temp0 data:)) ; "Thank you. Your Antwerp has now been processed."
			((= local5 (myDText new:))
				text: (temp0 data:)
				posn: 18 40
				font: gSmallFont
				mode: 1
				setSize: 110
				fore: 98
				init: (trap puzzleCast:)
				yourself:
			)
			(FrameOut)
			(while (not (OneOf (((User curEvent:) new:) type:) 4 1 32))
				(= gGameTime (+ gTickOffset (GetTime)))
				(gSounds eachElementDo: #check)
				(gSounds eachElementDo: #doit)
			)
			(temp0 dispose:)
			(local5 dispose:)
			(= local5 0)
		)
		(= local2 local1)
		(= local1 1)
		(if (IsFlag 27)
			(= local0 18)
			(localproc_0
				770
				0
				1029
				1543
				2057
				2571
				0
				0
				3085
				3599
				4113
				0
				0
				4627
				0
				0
				0
				5141
				5655
				6169
				0
				0
				0
				6683
				0
				7197
				0
				0
				-1
			)
		else
			(switch gHeroType
				(1 ; Magic User
					(= local0 16)
					(localproc_0
						770
						0
						1029
						1543
						0
						2057
						0
						0
						2571
						3085
						0
						0
						3599
						0
						4113
						4627
						0
						0
						-1
					)
				)
				(2 ; Thief
					(= local0 17)
					(localproc_0
						770
						0
						1029
						1543
						0
						2057
						2571
						0
						0
						3085
						3599
						4113
						0
						0
						0
						0
						4627
						0
						5141
						0
						5910
						0
						5656
						-1
					)
				)
				(else
					(= local0 14)
					(localproc_0
						770
						0
						1029
						0
						1543
						0
						2057
						0
						2571
						0
						3085
						0
						3599
						0
						4113
						4627
						5141
						0
						5655
						0
						0
						0
						-1
					)
				)
			)
		)
		(Message msgGET 380 6 6 local0 1 (local4 data:))
		((= local5 (myDText new:))
			text: (local4 data:)
			posn: 18 40
			font: gSmallFont
			fore: 98
			setSize: 110
			mode: 1
			init: puzzleCast
			yourself:
		)
		(= local2 local1)
		(= local1 1)
		(if (not (IsFlag 383))
			(self setScript: introScript)
			(SetFlag 383)
		)
	)
)

(instance introScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (& gMsgType $0001)
					(= local7 1)
				else
					(|= gMsgType $0001)
				)
				(if (& gMsgType $0002)
					(^= gMsgType $0002)
					(= local8 1)
				)
				(gMessager say: 6 6 26 0 self) ; "Welcome to the Transcendental Receiving Animal Processor."
			)
			(2
				(if (not local7)
					(^= gMsgType $0001)
				)
				(if local8
					(|= gMsgType $0002)
				)
				(self dispose:)
			)
		)
	)
)

(instance yesButton of TextIcon
	(properties
		nsLeft 10
		nsTop 111
		x 10
		y 111
		view 384
		loop 1
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(if local5
				(local5 dispose:)
				(= local5 0)
			)
			(Message
				msgGET
				380
				6
				6
				local0
				(= temp0 (>> (local3 at: local1) $0008))
				(local4 data:)
			)
			(localproc_3 temp0)
			((= local5 (myDText new:))
				text: (local4 data:)
				posn: 18 40
				font: gSmallFont
				setSize: 110
				mode: 1
				fore:
					(if (or (== (local3 at: temp0) -1) (not (local3 at: temp0)))
						98
					else
						98
					)
				init: (trap puzzleCast:)
				yourself:
			)
			(if (OneOf (local3 at: temp0) 0 -1)
				(localproc_2 (local3 at: temp0))
			else
				(= local2 local1)
				(= local1 temp0)
			)
		)
	)
)

(instance noButton of TextIcon
	(properties
		nsLeft 105
		nsTop 111
		x 105
		y 111
		view 384
		loop 2
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(if local5
				(local5 dispose:)
				(= local5 0)
			)
			(Message
				msgGET
				380
				6
				6
				local0
				(= temp0 (& (local3 at: local1) $00ff))
				(local4 data:)
			)
			(localproc_3 temp0)
			((= local5 (myDText new:))
				text: (local4 data:)
				posn: 18 40
				font: gSmallFont
				mode: 1
				setSize: 110
				fore:
					(if (or (== (local3 at: temp0) -1) (not (local3 at: temp0)))
						98
					else
						98
					)
				init: (trap puzzleCast:)
				yourself:
			)
			(if (OneOf (local3 at: temp0) 0 -1)
				(localproc_2 (local3 at: temp0))
			else
				(= local2 local1)
				(= local1 temp0)
			)
		)
	)
)

(instance anUpButton of TextIcon
	(properties
		nsLeft 58
		nsTop 111
		x 58
		y 111
		view 384
		loop 3
	)

	(method (select)
		(if (super select: &rest)
			(if local5
				(local5 dispose:)
				(= local5 0)
			)
			(Message msgGET 380 6 6 local0 local2 (local4 data:))
			(localproc_3 local2)
			((= local5 (myDText new:))
				text: (local4 data:)
				posn: 18 40
				font: gSmallFont
				fore: 98
				setSize: 110
				mode: 1
				init: (trap puzzleCast:)
				yourself:
			)
			(= local1 local2)
			(= local2 (localproc_1 local1))
		)
	)
)

(instance screen of TextIcon
	(properties
		nsLeft 8
		nsTop 28
		x 8
		y 28
		view 384
	)

	(method (highlight))

	(method (select))
)

(instance screenView of View
	(properties
		view 384
	)
)

(instance myDText of DText
	(properties)

	(method (dispose &tmp temp0 temp1)
		(= temp1 0)
		(if bitmap
			(= temp1 bitmap)
			(= bitmap 0)
		)
		(gCast delete: self)
		(if (self isNotHidden:)
			(DeleteScreenItem self)
		)
		(= temp0 (plane casts:))
		(temp0 eachElementDo: #delete self)
		(= plane 0)
		(DisposeClone self)
		(if temp1
			(Bitmap 1 temp1) ; Dispose
		)
	)
)

