;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use Plane)
(use IconBar)
(use User)
(use System)

(public
	PuzzleBar 0
	TextIcon 1
	pHelp 2
	pExit 3
)

(local
	local0
)

(procedure (localproc_0 &tmp temp0)
	(while ((= temp0 ((gUser curEvent:) new:)) type:)
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(class TextIcon of IconI
	(properties
		cel 2
		signal 129
		highlightColor 7
		owner 0
		value 0
		value2 0
		value3 0
		font 999
		text 0
		textColor 50
		textType 0
		downClick 0
		upClick 0
		upClickOff 0
	)

	(method (doAction1))

	(method (doAction2))

	(method (init param1 &tmp temp0)
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
		(= owner param1)
		(&= signal $fff7)
		((owner puzzleCast:) add: self)
		(= plane (owner plane:))
		(AddScreenItem self)
	)

	(method (show)
		(|= signal $0020)
		(UpdateScreenItem self)
	)

	(method (onMe param1 param2)
		(return (and (< nsLeft param1 nsRight) (< nsTop param2 nsBottom)))
	)

	(method (highlight param1)
		(= cel (if param1 0 else 2))
		(UpdateScreenItem self)
		(FrameOut)
	)

	(method (select param1 &tmp temp0 temp1)
		(return
			(if (and argc param1 (& signal $0001))
				(= cel (= temp1 1))
				(UpdateScreenItem self)
				(FrameOut)
				(while (!= ((= temp0 ((gUser curEvent:) new:)) type:) 2)
					(temp0 localize: plane)
					(cond
						((self onMe: (temp0 x:) (temp0 y:))
							(if (not temp1)
								(= cel (= temp1 1))
								(UpdateScreenItem self)
								(FrameOut)
							)
						)
						(temp1
							(= cel (= temp1 0))
							(UpdateScreenItem self)
							(FrameOut)
						)
					)
				)
				(if (== temp1 1)
					(= cel 0)
					(UpdateScreenItem self)
					(FrameOut)
				)
				temp1
			else
				1
			)
		)
	)
)

(class PuzzleBar of IconBar
	(properties
		puzzleCast 0
		script 0
		eventX 0
		eventY 0
		picture 0
		noHands 0
		oldCursor 0
		cursorView 0
		cursorLoop 0
		cursorCel 0
		usePlane 0
	)

	(method (resetPuzzle)
		(self eachElementDo: #show)
	)

	(method (init)
		(gEgo useSkill: 1 50) ; intelligence
		(= gPuzzleBar self)
		(= puzzleCast (Cast new:))
		(puzzleCast add:)
		(= plane puzzlePlane)
		(self add: setPlane: addIcons:)
	)

	(method (addIcons)
		(self add: pHelp pExit pBag)
	)

	(method (setPlane)
		(= usePlane 1)
		(plane bitmap: 0)
		(plane
			priority: (+ (GetHighPlanePri) 1)
			init:
			setRect: 82 40 250 175
			setBitmap: 935 0 0 1
			addCast: puzzleCast
		)
	)

	(method (giveYou)
		(gMessager say: 27 0 0 0 0 0) ; "You aren't carrying anything that will help you with this puzzle."
	)

	(method (helpYou)
		(gMessager say: 27 0 40 0 0 0) ; "Sorry, you are on your own!"
	)

	(method (dispose)
		(if script
			(script dispose:)
			(= script 0)
		)
		(if puzzleCast
			(puzzleCast dispose:)
			(= puzzleCast 0)
		)
		(plane deleteCast: self dispose:)
		(= plane 0)
		(if elements
			(DisposeList elements)
		)
		(= size (= elements 0))
		(DisposeClone self)
	)

	(method (show &tmp [temp0 3] temp3)
		(= highlightedIcon (= curIcon 0))
		(|= state $0020)
		(UpdatePlane plane)
		(if picture
			(plane drawPic: picture)
		)
		(if usePlane
			(pExit
				cel: 2
				nsLeft:
					(= temp3
						(+
							(- 75 (/ (CelWide (pExit view:) (pExit loop:) 0) 2))
							5
						)
					)
				x: temp3
			)
			(pBag
				cel: 2
				nsLeft:
					(= temp3
						(+ (- 150 (CelWide (pBag view:) (pBag loop:) 0)) 2)
					)
				x: temp3
			)
		)
		(self eachElementDo: #init self)
		(cond
			((not curIcon) 0)
			((HaveMouse)
				(self changeCursor: gTheCursor)
			)
			(else
				(self
					changeCursor: gTheCursor
					changeCursor:
						(+
							(curIcon nsLeft:)
							(/ (- (curIcon nsRight:) (curIcon nsLeft:)) 2)
						)
						(- (curIcon nsBottom:) 3)
				)
			)
		)
		(localproc_0)
		(self resetPuzzle:)
		(self doit: hide:)
		(return 1)
	)

	(method (hide)
		(if (& state $0020)
			(&= state $ffdf)
		)
		(if picture
			(gCurRoom drawPic: (gCurRoom picture:) 0)
		)
		(= usePlane 0)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(while (and (& state $0020) (= temp0 ((gUser curEvent:) new:)))
			(= gGameTime (+ gTickOffset (GetTime)))
			(puzzleCast doit:)
			(FrameOut)
			(temp0 localize: plane)
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(if (== temp1 32)
				(temp0 type: 4 message: 13)
			)
			(MapKeyToDir temp0)
			(if noHands
				(temp0 type: 0)
			)
			(breakif (self dispatchEvent: temp0))
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 [temp5 2])
		(if script
			(script doit:)
		)
		(if gDoMotionCue
			(= gDoMotionCue 0)
			(puzzleCast eachElementDo: #motionCue)
		)
		(if gCuees
			(gCuees eachElementDo: #doit)
		)
		(if (not (gTalkers isEmpty:))
			(repeat
				(gTalkers eachElementDo: #doit firstTrue: #handleEvent event)
				(= gGameTime (+ gTickOffset (GetTime)))
				(gSounds eachElementDo: #check)
				(FrameOut)
				(breakif (gTalkers allTrue: #isModeless 2))
				((User curEvent:) new:)
			)
			(event claimed: 1)
			(return 0)
		)
		(if (not (gPrints isEmpty:))
			(repeat
				(gPrints eachElementDo: #doit firstTrue: #handleEvent event)
				(= gGameTime (+ gTickOffset (GetTime)))
				(gSounds eachElementDo: #check)
				(FrameOut)
				(breakif (gPrints allTrue: #isModeless 2))
				((User curEvent:) new:)
			)
			(event claimed: 1)
			(return 0)
		)
		(gSounds eachElementDo: #check)
		(= eventX (event x:))
		(= eventY (event y:))
		(= temp1
			(if noHands
				0
			else
				(event type:)
			)
		)
		(= temp2 (event message:))
		(= temp4 (event claimed:))
		(= temp3 (self firstTrue: #onMe eventX eventY))
		(if (and (!= highlightedIcon temp3) (not noHands))
			(self highlight: temp3)
		)
		(event dispose:)
		(switch temp1
			(0
				(= temp4 0)
			)
			(1
				(if
					(and
						temp3
						(self select: temp3 1)
						(= temp4 (& (temp3 signal:) $0040))
					)
					(&= state $ffdf)
				)
			)
		)
		(return temp4)
	)

	(method (setScript param1)
		(if script
			(script dispose:)
		)
		(if param1
			(param1 init: self &rest)
		)
	)

	(method (highlight param1 param2)
		(if highlightedIcon
			(highlightedIcon highlight: 0)
		)
		(cond
			((not (= highlightedIcon param1)) 0)
			((& (param1 signal:) $0004)
				(= highlightedIcon 0)
			)
			(noHands 0)
			(else
				(param1 highlight: 1)
				(if (and (>= argc 2) param2)
					(self changeCursor: gTheCursor)
				)
			)
		)
	)

	(method (changeCursor param1 param2 param3 &tmp temp0 temp1)
		(= temp0 (= temp1 (gTheIconBar getCursor:)))
		(switch argc
			(0
				(return temp0)
			)
			(1
				(self cursorView: param1)
				(self cursorLoop: 0)
				(self cursorCel: 0)
				(temp1 view: param1)
				(temp1 loop: 0)
				(temp1 cel: 0)
				(gGlory setCursor: temp1)
			)
			(2
				(SetCursor param1 param2)
			)
			(3
				(self cursorView: param1)
				(self cursorLoop: param2)
				(self cursorCel: param3)
				(SetCursor cursorView cursorLoop cursorCel &rest)
			)
		)
		(return temp0)
	)

	(method (eachElementDo param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 nextNode))
			(= nextNode (NextNode temp0))
			(= temp1 (NodeValue temp0))
			(= temp2 nextNode)
			(temp1 param1: &rest)
			(= nextNode temp2)
		)
	)
)

(instance puzzlePlane of Plane
	(properties
		left 82
		top 40
		right 250
		bottom 175
		picture -2
	)
)

(instance pHelp of TextIcon
	(properties
		nsLeft 8
		nsTop 8
		x 9
		y 8
		view 936
	)

	(method (init)
		(super init: &rest)
		(self setPri: 100)
	)

	(method (select)
		(if (super select: &rest)
			(gPuzzleBar helpYou:)
		)
	)
)

(instance pExit of TextIcon
	(properties
		nsTop 8
		y 8
		view 936
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 100)
	)

	(method (select)
		(if (super select: &rest)
			(gPuzzleBar state: (& (gPuzzleBar state:) $ffdf))
		)
	)
)

(instance pBag of TextIcon
	(properties
		nsTop 8
		y 8
		view 936
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 100)
	)

	(method (select)
		(if (super select: &rest)
			(gPuzzleBar giveYou:)
		)
	)
)

