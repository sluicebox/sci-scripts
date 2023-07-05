;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use ScrollerWindow)
(use Str)
(use IconBar)
(use File)
(use Game)
(use Actor)
(use System)

(public
	rm45 0
)

(local
	local0
	local1 = 1
	local2
)

(procedure (localproc_0)
	(textScroller addString: (local2 data:) 2308 24 1)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 (param1 cel:))
	(param1 cel: param2)
	(UpdateScreenItem param1)
	(FrameOut)
	(= temp2 1)
	(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
		(temp0 localize: (ScriptID 0 11)) ; overlayPlane
		(cond
			((param1 onMe: temp0)
				(if (== (param1 cel:) temp1)
					(param1 cel: param2)
					(= temp2 1)
					(UpdateScreenItem param1)
					(FrameOut)
				)
			)
			((!= (param1 cel:) temp1)
				(param1 cel: temp1)
				(= temp2 0)
				(UpdateScreenItem param1)
				(FrameOut)
			)
		)
		(temp0 dispose:)
	)
	(temp0 dispose:)
	(param1 cel: temp1)
	(UpdateScreenItem param1)
	(return temp2)
)

(instance rm45 of Room
	(properties
		picture 9800
		style 0
	)

	(method (init &tmp temp0 temp1)
		(super init: &rest)
		(gGame handsOff:)
		(textScroller
			init: scrollBar scrollBarUpIcon scrollBarDownIcon
			yourself:
		)
		(= local0 (Str new: 132))
		(= local2 (Str new: 132))
		(= temp1 (Str newWith: 128 gCurSaveDir))
		(temp1 cat: {pdoco.txt})
		((= temp0 (File new:)) name: (KString 8 (temp1 data:)) open: 1) ; StrDup
		(temp1 dispose:)
		(while (temp0 readString: local0 132)
			(local0 cat: {\n})
			(local2 cat: local0)
			(++ local1)
		)
		(localproc_0)
		(temp0 dispose:)
		(textScroller maxItems: 1)
		(textScroller scrollTo: 0)
		(scrollBar rePosn: 16 1)
		(textScroller show:)
		(sExit init: show:)
		(gPrints add: textScroller)
		(= style 0)
		(gGame handsOn:)
	)
)

(instance sExit of View
	(properties
		x 29
		y 10
		view 9905
		loop 5
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb)
		(if (localproc_1 self 1)
			(gPrints delete: textScroller)
			(textScroller dispose:)
			(gCurRoom newRoom: 91) ; saveRest
		)
	)
)

(class ScrollButton of IconI
	(properties
		pDirection 0
	)

	(method (select param1 &tmp temp0 temp1 temp2)
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(= cel (= temp1 1))
					(UpdateScreenItem self)
					(FrameOut)
					(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(temp0 localize: plane)
						(cond
							((self onMe: temp0)
								(if (not temp1)
									(= cel (= temp1 1))
									(UpdateScreenItem self)
									(FrameOut)
								)
								(if pDirection
									1
									(textScroller scrollTo: 2)
								else
									(textScroller scrollTo: 4)
								)
								(textScroller updateThumb:)
							)
							(temp1
								(= cel (= temp1 0))
								(UpdateScreenItem self)
								(FrameOut)
							)
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
					(if (== temp1 1)
						(= cel 0)
						(UpdateScreenItem self)
						(FrameOut)
					)
					(if
						(and
							(= temp2 (gGame script:))
							(temp2 isKindOf: Unknown_Class_18)
						)
						(cond
							(
								(and
									(== (temp2 nextItem:) self)
									(!=
										(temp2 nextAction:)
										((gTheIconBar helpIconItem:) message:)
									)
								)
								(temp2 cue:)
							)
							((not temp1)
								(return 0)
							)
							(else
								(temp2 report:)
								(return 0)
							)
						)
					)
					temp1
				)
				(else
					(if
						(and
							(= temp2 (gGame script:))
							(temp2 isKindOf: Unknown_Class_18)
						)
						(if
							(and
								(== (temp2 nextItem:) self)
								(!=
									(temp2 nextAction:)
									((gTheIconBar helpIconItem:) message:)
								)
							)
							(temp2 cue:)
						else
							(temp2 report:)
							(return 0)
						)
					)
					1
				)
			)
		)
	)
)

(instance scrollBarUpIcon of ScrollButton
	(properties
		priority 255
		fixPriority 1
		mainView 9934
		mainLoop 2
		pDirection 1
	)
)

(instance scrollBarDownIcon of ScrollButton
	(properties
		y 113
		priority 255
		fixPriority 1
		mainView 9934
		mainLoop 1
	)
)

(instance scrollBar of WindowScrollBar
	(properties
		priority 250
		fixPriority 1
		view 9934
		thumbView 9934
		thumbCel 1
		minPosn 16
		maxPosn 105
	)
)

(instance textScroller of ScrollerWindow
	(properties
		font 2308
		nsLeft 29
		nsTop 40
		nsRight 270
		nsBottom 168
		maxItems 512
	)
)

