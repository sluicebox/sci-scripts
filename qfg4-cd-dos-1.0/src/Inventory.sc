;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64995)
(include sci.sh)
(use Main)
(use Str)
(use Print)
(use IconBar)

(class InvI of IconI
	(properties
		view 0
		signal 0
		message 0
		owner 0
		script 0
		value 0
	)

	(method (init)
		(super init: &rest)
		(if (== cursorView -1)
			(self setCursor: mainView mainLoop mainCel)
		)
	)

	(method (onMe event)
		(return (and (not (& signal $0004)) (super onMe: event)))
	)

	(method (doVerb theVerb &tmp tut)
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun theVerb 0 1))
			(gMessager say: noun theVerb 0 0 0 modNum)
		)
		(if (and (= tut (gGlory script:)) (tut isKindOf: Unknown_Class_18))
			(cond
				((!= (tut nextItem:) self)
					(tut report: self)
				)
				((!= (tut nextAction:) theVerb)
					(tut report: theVerb)
				)
				(else
					(tut cue:)
				)
			)
		)
	)

	(method (highlight tOrF)
		(= cel (* 2 (if argc tOrF)))
		(UpdateScreenItem self)
	)

	(method (ownedBy who)
		(return (== owner who))
	)

	(method (moveTo who)
		(= owner who)
		(if (and value (== who gEgo))
			(gGlory changeScore: value)
			(= value 0)
		)
		(return self)
	)

	(method (getCursor)
		(return
			(if (== cursorLoop -1)
				cursorView
			else
				(invCursor initialize: self yourself:)
			)
		)
	)
)

(class Inv of IconBar
	(properties
		normalHeading {You are carrying:}
		heading 0
		empty {nothing!}
		okButton 0
		selectIcon 0
		owner 0
		iconBottom 0
		iconRight 0
		planeTop 0
		planeBottom 0
		planeLeft 0
		planeRight 0
		curIndex 0
		numRow 0
		numCol 0
		rowMargin 0
		colMargin 0
		itemWide 0
		itemHigh 0
		numIcon 0
	)

	(method (init &tmp node obj)
		(super init:)
		(for ((= node (self first:))) node ((= node (self next: node)))
			(if ((= obj (NodeValue node)) isKindOf: InvI)
				(DeleteScreenItem obj)
				(obj signal: (| (obj signal:) $0004))
			else
				(++ numIcon)
			)
		)
		(self drawIcons:)
	)

	(method (drawIcons &tmp obj atX node cHigh cWide)
		(= atX (= node (= obj (= cHigh (= cWide 0)))))
		(for ((= node (self first:))) node ((= node (self next: node)))
			(if (not ((= obj (NodeValue node)) isKindOf: InvI))
				(= cWide (CelWide (obj view:) (obj loop:) (obj cel:)))
				(+= iconRight cWide)
				(if
					(>
						(= cHigh
							(CelHigh (obj view:) (obj loop:) (obj cel:))
						)
						iconBottom
					)
					(= iconBottom cHigh)
				)
				(if (not (& (obj signal:) $0080))
					(obj
						x: atX
						y: 0
						nsLeft: atX
						nsTop: 0
						nsRight: (+ atX cWide)
						nsBottom: cHigh
					)
				)
				(= atX (+ (obj x:) cWide))
				(UpdateScreenItem obj)
			)
		)
		(if numCol
			(= iconRight (* (+ itemWide colMargin) numCol))
		)
	)

	(method (drawInvItems &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 3] temp9 temp10)
		(= temp4 0)
		(= temp0 10)
		(= temp1 (+ iconBottom 15))
		(= temp10 0)
		(= temp3 (self first:))
		(= temp9 0)
		(while (< temp9 curIndex)
			(if
				(and
					((= temp2 (NodeValue temp3)) isKindOf: InvI)
					(not (& (temp2 signal:) $0004))
				)
				(DeleteScreenItem temp2)
				(temp2 signal: (| (temp2 signal:) $0004))
			)
			(++ temp9)
			(= temp3 (self next: temp3))
		)
		(for ((= temp3 temp3)) temp3 ((= temp3 (self next: temp3)))
			(if
				(and
					((= temp2 (NodeValue temp3)) isKindOf: InvI)
					(== (temp2 owner:) owner)
				)
				(if
					(>
						(= temp5
							(CelHigh (temp2 view:) (temp2 loop:) (temp2 cel:))
						)
						temp4
					)
					(= temp4 temp5)
				)
				(temp2
					x: temp0
					y: temp1
					nsTop: temp1
					nsLeft: temp0
					nsRight:
						(+
							temp0
							(CelWide (temp2 view:) (temp2 loop:) (temp2 cel:))
						)
					nsBottom: (+ temp1 temp5)
				)
				(if (& (temp2 signal:) $0004)
					(temp2 signal: (& (temp2 signal:) $fffb))
					(AddScreenItem temp2)
				else
					(UpdateScreenItem temp2)
				)
				(if
					(>
						(+=
							temp0
							(+
								(CelWide
									(temp2 view:)
									(temp2 loop:)
									(temp2 cel:)
								)
								colMargin
							)
						)
						iconRight
					)
					(= temp0 10)
					(+= temp1 (+ itemHigh rowMargin))
					(if (>= (++ temp10) numRow)
						(break)
					)
				)
			)
		)
		(if temp3
			(for
				((= temp3 (self next: temp3)))
				temp3
				((= temp3 (self next: temp3)))
				
				(if
					(and
						((= temp2 (NodeValue temp3)) isKindOf: InvI)
						(not (& (temp2 signal:) $0004))
					)
					(DeleteScreenItem temp2)
					(temp2 signal: (| (temp2 signal:) $0004))
				)
			)
		)
		(if numRow
			(plane
				setRect:
					50
					50
					(+ 50 iconRight)
					(* (+ itemWide colMargin) numCol)
					1
			)
		else
			(plane setRect: 50 50 (+ 50 iconRight) (+ 10 temp1 iconBottom 5) 1)
		)
	)

	(method (ownedBy whom &tmp node obj)
		(for ((= node (FirstNode elements))) node ((= node nextNode))
			(= nextNode (NextNode node))
			(= obj (NodeValue node))
			(if (and (obj isKindOf: InvI) (obj ownedBy: whom))
				(return 1)
			)
		)
		(return 0)
	)

	(method (showSelf who)
		(gSounds pause:)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(if (not okButton)
			(= okButton (NodeValue (self first:)))
		)
		(= curIcon 0)
		(= owner (if argc who else gEgo))
		(if (not (self ownedBy: owner))
			(self carryingNothing:)
			(return 0)
		)
		(return (self show: doit: hide:))
	)

	(method (show)
		(|= state $0020)
		(gGlory setCursor: (self getCursor:))
		(plane priority: (+ (GetHighPlanePri) 1))
		(UpdatePlane plane)
		(self drawInvItems:)
		(return 1)
	)

	(method (hide &tmp theCurs node obj)
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
		)
		(for ((= node (FirstNode elements))) node ((= node nextNode))
			(= nextNode (NextNode node))
			(= obj (NodeValue node))
			(obj signal: (& (obj signal:) $ffdf))
			(if (and (obj isKindOf: InvI) (not (& (obj signal:) $0004)))
				(obj signal: (| (obj signal:) $0004))
				(DeleteScreenItem obj)
			)
		)
		(plane priority: -1)
		(UpdatePlane plane)
		(if (and curIcon (curIcon isKindOf: InvI))
			(if (not (gTheIconBar curInvIcon:))
				(gTheIconBar enableIcon: (gTheIconBar useIconItem:))
			)
			(gTheIconBar
				curIcon:
					((gTheIconBar useIconItem:)
						cursorView: (invCursor view:)
						cursorLoop: (invCursor loop:)
						cursorCel: (invCursor cel:)
						yourself:
					)
				curInvIcon: curIcon
			)
		)
	)

	(method (advance amount &tmp theIcon toMove highlightedNo nextIcon)
		(= toMove (if argc amount else 1))
		(= highlightedNo (self indexOf: highlightedIcon))
		(= nextIcon (+ toMove highlightedNo))
		(repeat
			(if
				(not
					(= theIcon
						(self
							at:
								(if (<= nextIcon size)
									nextIcon
								else
									(mod nextIcon (- size 1))
								)
						)
					)
				)
				(= theIcon (NodeValue (self first:)))
			)
			(if (not (& (theIcon signal:) $0004))
				(break)
			else
				(++ nextIcon)
			)
		)
		(self highlight: theIcon 1)
	)

	(method (retreat amount &tmp theIcon toMove highlightedNo nextIcon)
		(= toMove (if argc amount else 1))
		(= nextIcon (- (= highlightedNo (self indexOf: highlightedIcon)) toMove))
		(repeat
			(if (not (= theIcon (self at: nextIcon)))
				(= theIcon (NodeValue (self last:)))
			)
			(if (not (& (theIcon signal:) $0004))
				(break)
			else
				(-- nextIcon)
			)
		)
		(self highlight: theIcon 1)
	)

	(procedure (FindIcon hIcon y1 y2 &tmp thisIcon theY theX)
		(= theX (+ (/ (- (hIcon nsRight:) (hIcon x:)) 2) (hIcon x:)))
		(= theY y1)
		(while (>= (Abs (- theY y2)) 4)
			(if
				(= thisIcon
					(self
						firstTrue:
							#onMe
							(((gUser curEvent:) new:)
								x: theX
								y: theY
								yourself:
							)
					)
				)
				(return)
			)
			(if (< y1 y2)
				(+= theY 4)
			else
				(-= theY 4)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 [temp5 4] temp9 temp10 temp11)
		(= temp10 (Str newWith: 100 {}))
		(while ((= temp1 ((gUser curEvent:) new:)) type:)
		)
		(while (& state $0020)
			(= temp1 ((gUser curEvent:) new:))
			(= gMouseX (temp1 x:))
			(= gMouseY (temp1 y:))
			(= temp2 (temp1 type:))
			(= temp3 (temp1 message:))
			(= temp4 (temp1 modifiers:))
			(= temp9 0)
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
			(temp1 localize: plane)
			(if (gNarrator initialized:)
				(gNarrator doit:)
				(gNarrator handleEvent: temp1)
			else
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
				(if
					(and
						(= temp11 (gGlory script:))
						(temp11 isKindOf: Unknown_Class_18)
					)
					(temp11 doit:)
				)
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
								(gGlory setCursor: (self getCursor:))
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
							(gGlory setCursor: (self getCursor:))
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
											(FindIcon
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
											(FindIcon
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
									(gGlory setCursor: gNormalCursor)
									(continue)
								)
								(if (== temp0 okButton)
									(temp1 claimed: 1)
									(break)
								)
								(if (not (temp0 isKindOf: InvI))
									(if (self select: temp0 (not temp9))
										(= curIcon temp0)
										(gGlory setCursor: (self getCursor:))
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

	(method (carryingNothing)
		(Print addTextF: {%s %s} normalHeading empty init:)
		(return 0)
	)

	(method (setCurIndex amount &tmp index theDir numOwned obj idx)
		(= theDir (if (< amount 0) -1 else 1))
		(= numOwned 0)
		(= idx curIndex)
		(= numOwned 0)
		(while (and (< numOwned (Abs amount)) (< idx size) (>= idx 0))
			(+= idx theDir)
			(if
				(and
					(<= 0 idx (- size 1))
					((= obj (self at: idx)) isKindOf: InvI)
					(obj ownedBy: owner)
				)
				(++ numOwned)
			)
		)
		(if (< numOwned (Abs amount))
			(return)
		else
			(= curIndex idx)
		)
		(self drawInvItems:)
	)

	(method (setCurIndexTo index)
		(for
			((= curIndex index))
			(not ((self at: curIndex) ownedBy: owner))
			((++ curIndex))
		)
		(self drawInvItems:)
	)
)

(instance invCursor of IconBarCursor
	(properties)
)

