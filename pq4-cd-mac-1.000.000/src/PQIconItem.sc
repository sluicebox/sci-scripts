;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use TransPlane)
(use Str)
(use Print)
(use IconBar)
(use Tutorial)
(use Inventory)
(use System)

(class PQIconItem of IconI
	(properties
		modNum 0
	)

	(method (ownedBy)
		(return 0)
	)

	(method (getCursor &tmp temp0)
		(= temp0 (super getCursor:))
		(if (temp0 hidden:)
			(temp0 hidden: 0)
		)
		(return temp0)
	)
)

(class PQInvItem of InvI
	(properties)

	(method (cue)
		(gInventory update:)
	)

	(method (getCursor &tmp temp0)
		(= temp0 (super getCursor:))
		(if (temp0 hidden:)
			(temp0 hidden: 0)
		)
		(return temp0)
	)

	(method (init)
		(= lowlightColor -1)
		(if (and 1 (IsHiRes))
			(+= mainView 2000)
		)
		(super init: &rest)
	)

	(method (highlight))

	(method (doVerb theVerb)
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun theVerb 0 1))
			(gMessager say: noun theVerb 0 0 0 modNum)
		else
			(gMessager say: 0 6 0 0 0 11) ; "Those two items don't go together."
		)
	)
)

(class PqInv of Inv
	(properties
		normalHeading 9
		empty 27
		theSlider 0
		ownedNum 0
		curLast 0
		numScroll 0
	)

	(method (init)
		(= curIndex 0)
		(super init: &rest)
	)

	(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1 temp2)
		(= temp2 (+ (/ (- (param1 nsRight:) (param1 x:)) 2) (param1 x:)))
		(= temp1 param2)
		(while (>= (Abs (- temp1 param3)) 4)
			(if
				(= temp0
					(self
						firstTrue:
							#onMe
							(((gUser curEvent:) new:)
								x: temp2
								y: temp1
								yourself:
							)
					)
				)
				(return)
			)
			(if (< param2 param3)
				(+= temp1 4)
			else
				(-= temp1 4)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 [temp5 4] temp9 temp10 temp11)
		(= temp10 (Str newWith: 100 {}))
		(while ((= temp1 ((gUser curEvent:) new:)) type:)
		)
		(while (& state $0020)
			(= temp1 ((gUser curEvent:) new:))
			(= temp2 (temp1 type:))
			(= temp3 (temp1 message:))
			(= temp4 (temp1 modifiers:))
			(= temp9 0)
			(temp1 localize: plane)
			(= gGameTime (+ (GetTime) gTickOffset))
			(if (not (gTalkers isEmpty:))
				(repeat
					(gTalkers eachElementDo: #doit)
					(gSounds eachElementDo: #check)
					(FrameOut)
					(temp1 new:)
					(= gGameTime (+ (GetTime) gTickOffset))
					(breakif
						(or
							(gTalkers isEmpty:)
							(gTalkers firstTrue: #handleEvent temp1)
						)
					)
				)
				(temp1 claimed: 1)
			)
			(FrameOut)
			(if
				(and
					curIcon
					(not temp4)
					(!= curIcon selectIcon)
					(or
						(== temp2 1)
						(and (== temp2 4) (== temp3 13) (= temp9 1))
						(and (== temp2 32) (= temp9 1))
					)
					(or
						(!= curIcon helpIconItem)
						(& (helpIconItem signal:) $0010)
					)
				)
				(temp1 type: 16384 message: (curIcon message:))
			)
			(MapKeyToDir temp1)
			(= temp2 (temp1 type:))
			(= temp3 (temp1 message:))
			(if gCuees
				(gCuees eachElementDo: #doit)
			)
			(if (and (= temp11 (gGame script:)) (temp11 isKindOf: Tutorial))
				(temp11 doit:)
			)
			(if (temp1 claimed:)
			else
				(if (and (== temp2 1) temp4)
					(self advanceCurIcon:)
					(temp1 claimed: 1)
					(continue)
				)
				(if
					(and
						(== temp2 0)
						(= temp0 (self firstTrue: #onMe temp1))
						(!= temp0 highlightedIcon)
					)
					(self highlight: temp0)
					(continue)
				)
				(cond
					(
						(or
							(== temp2 1)
							(and (== temp2 4) (== temp3 13))
							(== temp2 32)
						)
						(if
							(and
								highlightedIcon
								(self select: highlightedIcon (== temp2 1))
							)
							(if (== highlightedIcon okButton)
								(temp1 claimed: 1)
								(break)
							)
							(if (== highlightedIcon helpIconItem)
								(= curIcon highlightedIcon)
								(gGame setCursor: (self getCursor:))
								(if (& state $0800)
									(self noClickHelp:)
									(continue)
								)
								(if helpIconItem
									(helpIconItem
										signal: (| (helpIconItem signal:) $0010)
									)
								)
								(continue)
							)
							(= curIcon highlightedIcon)
							(gGame setCursor: (self getCursor:))
						)
					)
					((& temp2 $0010)
						(switch temp3
							(3
								(self advance:)
							)
							(7
								(self retreat:)
							)
							(1
								(if
									(and
										highlightedIcon
										(= temp0
											(localproc_0
												highlightedIcon
												(- (highlightedIcon nsTop:) 1)
												0
											)
										)
									)
									(self highlight: temp0 1)
								else
									(self retreat:)
								)
							)
							(5
								(if
									(and
										highlightedIcon
										(= temp0
											(localproc_0
												highlightedIcon
												(+
													(highlightedIcon nsBottom:)
													1
												)
												(plane bottom:)
											)
										)
									)
									(self highlight: temp0 1)
								else
									(self advance:)
								)
							)
							(0
								(if (& temp2 $0004)
									(self advanceCurIcon:)
								)
							)
						)
					)
					((== temp2 4)
						(switch temp3
							(9
								(self advance:)
							)
							(3840
								(self retreat:)
							)
							(27
								(break)
							)
						)
					)
					(else
						(if (& temp2 $4000)
							(if (= temp0 (self firstTrue: #onMe temp1))
								(if (& temp2 $2000)
									(if
										(and
											temp0
											(temp0 noun:)
											(Message
												msgGET
												(temp0 modNum:)
												(temp0 noun:)
												(temp0 helpVerb:)
												0
												1
												(temp10 data:)
											)
										)
										(Prints temp10)
									)
									(helpIconItem
										signal: (& (helpIconItem signal:) $ffef)
									)
									(gGame setCursor: gNormalCursor)
									(continue)
								)
								(if (== temp0 okButton)
									(temp1 claimed: 1)
									(break)
								)
								(if (not (temp0 isKindOf: InvI))
									(if (self select: temp0 (not temp9))
										(= curIcon temp0)
										(gGame setCursor: (self getCursor:))
										(if (== temp0 helpIconItem)
											(if (& state $0800)
												(self noClickHelp:)
												(continue)
											)
											(helpIconItem
												signal:
													(|
														(helpIconItem signal:)
														$0010
													)
											)
										)
									)
									(continue)
								)
								(if curIcon
									(if (curIcon isKindOf: InvI)
										(temp0 doVerb: (curIcon message:))
										(continue)
									)
								else
									(continue)
								)
							else
								(continue)
							)
						else
							(continue)
						)
						(temp0 doVerb: (temp1 message:))
					)
				)
			)
		)
		(temp10 dispose:)
	)

	(method (showSelf)
		(= curIndex 0)
		(theSlider y: (theSlider minY:))
		(UpdateScreenItem theSlider)
		(super showSelf: &rest)
	)

	(method (drawInvItems &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(= ownedNum (= temp8 (= temp9 (= temp6 0))))
		(= temp2 30)
		(= temp3 (+ iconBottom 30))
		(= temp0 numScroll)
		(for ((= temp5 (self first:))) temp5 ((= temp5 (self next: temp5)))
			(if ((= temp4 (NodeValue temp5)) isKindOf: InvI)
				(if (not (& (temp4 signal:) $0004))
					(DeleteScreenItem temp4)
					(temp4 signal: (| (temp4 signal:) $0004))
				)
				(if (== (temp4 owner:) owner)
					(++ ownedNum)
				)
			)
		)
		(theSlider
			interval:
				(/
					(- (theSlider maxY:) (theSlider minY:))
					(Max 1 (/ ownedNum numScroll))
				)
		)
		(= temp5 (self first:))
		(for ((= temp1 0)) temp5 ((++ temp1))
			(if
				(and
					(>= temp1 curIndex)
					((= temp4 (NodeValue temp5)) isKindOf: InvI)
					(== (temp4 owner:) owner)
				)
				(if
					(>
						(= temp7
							(CelHigh (temp4 view:) (temp4 loop:) (temp4 cel:))
						)
						temp6
					)
					(= temp6 temp7)
				)
				(temp4
					x: temp2
					y: temp3
					nsTop: temp3
					nsLeft: temp2
					nsRight:
						(+
							temp2
							(CelWide (temp4 view:) (temp4 loop:) (temp4 cel:))
						)
					nsBottom: (+ temp3 temp7)
				)
				(if (& (temp4 signal:) $0004)
					(temp4 signal: (& (temp4 signal:) $fffb))
					(AddScreenItem temp4)
				else
					(UpdateScreenItem temp4)
				)
				(if (>= (-- temp0) 0)
					(= curLast (self indexOf: temp4))
				)
				(+=
					temp2
					(+
						(CelWide (temp4 view:) (temp4 loop:) (temp4 cel:))
						colMargin
					)
				)
				(if (>= (++ temp9) numCol)
					(= temp9 0)
					(= temp2 30)
					(+= temp3 (+ itemHigh rowMargin))
					(if (>= (++ temp8) numRow)
						(break)
					)
				)
			)
			(= temp5 (self next: temp5))
		)
	)

	(method (setCurIndex param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 0)
		(if (== (= temp1 (if (< param1 0) -1 else 1)) 1)
			(= temp4 curLast)
		else
			(= temp4 curIndex)
		)
		(= temp2 0)
		(while (and (< temp2 (Abs param1)) (< temp4 size) (>= temp4 0))
			(+= temp4 temp1)
			(if
				(and
					(<= 0 temp4 (- size 1))
					((= temp3 (self at: temp4)) isKindOf: InvI)
					(temp3 ownedBy: owner)
				)
				(if (and (== temp1 1) (not temp0))
					(= temp0 1)
					(= curIndex temp4)
				)
				(if (== temp1 -1)
					(= curIndex temp4)
				)
				(++ temp2)
			)
		)
		(if temp2
			(self drawInvItems:)
		)
	)

	(method (update)
		(if
			(and
				curIcon
				(curIcon isKindOf: PQInvItem)
				(!= (curIcon owner:) owner)
			)
			(gGame setCursor: ((= curIcon selectIcon) getCursor:))
		)
		(self hide:)
		(FrameOut)
		(self showSelf:)
	)

	(method (setPlane param1 param2 param3)
		(plane
			left: (/ (- 320 (CelWide param1 param2 param3)) 2)
			top: (/ (- 153 (CelHigh param1 param2 param3)) 2)
			setBitmap: param1 param2 param3 0
		)
	)

	(method (noClickHelp &tmp temp0 temp1 temp2 temp3)
		(= temp1 (= temp2 (= temp3 0)))
		(= temp0 ((gUser curEvent:) new:))
		(while (not (temp0 type:))
			(if (not (self isMemberOf: IconBar))
				(temp0 localize: plane)
			)
			(cond
				((= temp2 (self firstTrue: #onMe temp0))
					(if (and (!= temp2 temp1) (temp2 helpVerb:))
						(= temp1 temp2)
						(if temp3
							(temp3 dispose:)
							(= temp3 0)
							(FrameOut)
						)
						(Print
							font: 4
							fore: 13
							width: 200
							shadowText: 1
							plane: TransPlane
							addText:
								(temp2 noun:)
								(temp2 helpVerb:)
								0
								1
								0
								0
								(if (== (temp2 modNum:) -1)
									0
								else
									(temp2 modNum:)
								)
							modeless: 2
							init:
						)
						(= temp3 (Print dialog:))
					)
				)
				(temp3
					(temp3 dispose:)
					(= temp3 0)
				)
				(else
					(= temp1 0)
				)
			)
			(FrameOut)
			(temp0 new:)
		)
		(temp0 claimed: 1)
		(if temp3
			(temp3 dispose:)
			(= temp3 0)
			(FrameOut)
		)
		(Print font: 4 width: 0 shadowText: 0 plane: 0 modeless: 0)
		(gGame setCursor: gNormalCursor 1)
	)
)

(class InvSlider of PQIconItem
	(properties
		minY 0
		maxY 0
		theUpArrow 0
		theDnArrow 0
		interval 0
		startY 0
	)

	(method (init)
		(= minY
			(-
				(+
					(theUpArrow y:)
					(CelHigh
						(theUpArrow mainView:)
						(theUpArrow mainLoop:)
						(theUpArrow mainCel:)
					)
				)
				1
			)
		)
		(= maxY (- (theDnArrow y:) (CelHigh mainView mainLoop mainCel)))
		(= startY minY)
		(super init: &rest)
	)

	(method (update param1)
		(+= y (* interval param1))
		(if (> y maxY)
			(= y maxY)
		)
		(if (< y minY)
			(= y minY)
		)
		(= startY y)
		(UpdateScreenItem self)
	)

	(method (select)
		(return 0)
	)
)

