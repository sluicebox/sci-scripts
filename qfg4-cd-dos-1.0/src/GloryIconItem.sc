;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 58)
(include sci.sh)
(use Main)
(use Str)
(use Print)
(use IconBar)
(use Cursor)
(use Inventory)

(class GloryIconItem of IconI
	(properties
		modNum 0
	)

	(method (ownedBy)
		(return 0)
	)
)

(class SliderIcon of GloryIconItem
	(properties
		theSlider 0
	)

	(method (updateSlider))
)

(class NumInvItem of InvI
	(properties
		modNum 16
		signal 2
		helpVerb 1
		amount 0
		chestAmout 0
	)

	(method (loseItem)
		(self owner: gCurRoomNum amount: 0)
	)

	(method (roomGets &tmp temp0 temp1)
		(if (== gCurRoomNum 330)
			(++ chestAmout)
			(-- amount)
			(if (not amount)
				(= owner 0)
			)
			(= temp1 (ScriptID 36 1)) ; invItem
			(temp1 signal: (| (temp1 signal:) $0008))
			(DeleteScreenItem temp1)
		)
	)

	(method (highlight))

	(method (cue)
		(gInventory update:)
	)

	(method (init)
		(= lowlightColor -1)
		(super init: &rest)
		(self setCursor: Cursor)
	)

	(method (moveTo param1)
		(self
			signal: (| (self signal:) $0004)
			nsLeft: 0
			nsRight: 0
			nsTop: 0
			nsBottom: 0
		)
		(super moveTo: param1)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(= temp0 (Str new:))
		(= temp1 (Str new:))
		(cond
			((== theVerb 1) ; Look
				(if (> amount 1)
					(Message msgGET 16 0 theVerb 1 1 (temp1 data:))
					(Message msgGET 16 noun theVerb 0 1 (temp0 data:))
					(Print
						addTextF: (temp1 data:) (temp0 data:) amount value
						y: 165
						init:
					)
				else
					(Message msgGET 16 0 theVerb 2 1 (temp1 data:))
					(Message msgGET 16 noun theVerb 0 1 (temp0 data:))
					(Print
						addTextF: (temp1 data:) (temp0 data:) value
						y: 165
						init:
					)
				)
				(Print addText: noun theVerb 0 2 0 0 16 y: 165 init:)
			)
			((== theVerb 4) ; Do
				(super doVerb: theVerb)
			)
			((Message msgGET 16 noun theVerb 0 1 (temp0 data:))
				(Print addText: (temp0 data:) y: 165 init:)
			)
			(else
				(Print addText: 0 0 11 1 0 0 16 y: 165 init:) ; "Nothing much happens."
			)
		)
		(temp0 dispose:)
		(temp1 dispose:)
	)

	(method (select)
		(cond
			((== (gInventory owner:) gEgo)
				(if (super select: &rest)
					(Cursor view: view loop: loop cel: cel)
				)
			)
			((super select: &rest)
				(Cursor view: view loop: loop cel: cel)
			)
		)
	)
)

(class QGInv of Inv
	(properties
		normalHeading 9
		empty 27
		theSlider 0
		iconMargin 0
		invLeft 15
		totalRow 0
		currentRow 0
		interval 0
	)

	(method (ownedBy &tmp temp0 temp1)
		(if (== owner gEgo)
			(return 1)
		else
			(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 nextNode))
				(= nextNode (NextNode temp0))
				(= temp1 (NodeValue temp0))
				(if (and (temp1 isKindOf: InvI) (temp1 chestAmout:))
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (getInvNum &tmp temp0 temp1 temp2)
		(= temp1 0)
		(if (== owner gEgo)
			(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
				(if
					(and
						((= temp2 (NodeValue temp0)) isKindOf: InvI)
						(temp2 amount:)
					)
					(++ temp1)
				)
			)
		else
			(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
				(if
					(and
						((= temp2 (NodeValue temp0)) isKindOf: InvI)
						(temp2 chestAmout:)
					)
					(++ temp1)
				)
			)
		)
		(if (= totalRow (/ temp1 numCol))
			(= interval (/ 59 totalRow))
		else
			(= interval 60)
		)
	)

	(method (drawIcons &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp2 (= temp0 (= temp3 (= temp4 0))))
		(= temp1 0)
		(for ((= temp2 (self first:))) temp2 ((= temp2 (self next: temp2)))
			(if (not ((= temp0 (NodeValue temp2)) isKindOf: InvI))
				(= temp4 (CelWide (temp0 view:) (temp0 loop:) (temp0 cel:)))
				(+= iconRight temp4)
				(if
					(and
						(>
							(= temp3
								(CelHigh
									(temp0 view:)
									(temp0 loop:)
									(temp0 cel:)
								)
							)
							iconBottom
						)
						(not (& (temp0 signal:) $0080))
					)
					(= iconBottom temp3)
				)
				(if (not (& (temp0 signal:) $0080))
					(temp0
						x: temp1
						y: 0
						nsLeft: temp1
						nsTop: 0
						nsRight: (+ temp1 temp4)
						nsBottom: temp3
					)
				)
				(= temp1 (+ (temp0 x:) temp4))
				(UpdateScreenItem temp0)
			)
		)
		(-= iconRight 34)
	)

	(method (drawInvItems &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(= temp4 0)
		(= temp0 invLeft)
		(= temp1 (+ iconBottom 15))
		(= temp9 (= temp8 0))
		(= temp3 (self first:))
		(= temp7 0)
		(while (< temp7 curIndex)
			(if
				(and
					((= temp2 (NodeValue temp3)) isKindOf: InvI)
					(not (& (temp2 signal:) $0004))
				)
				(DeleteScreenItem temp2)
				(temp2 signal: (| (temp2 signal:) $0004))
			)
			(++ temp7)
			(= temp3 (self next: temp3))
		)
		(if (== owner gEgo)
			(for ((= temp3 temp3)) temp3 ((= temp3 (self next: temp3)))
				(if
					(and
						((= temp2 (NodeValue temp3)) isKindOf: InvI)
						(temp2 amount:)
					)
					(if
						(>
							(= temp5
								(CelHigh
									(temp2 view:)
									(temp2 loop:)
									(temp2 cel:)
								)
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
								(CelWide
									(temp2 view:)
									(temp2 loop:)
									(temp2 cel:)
								)
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
						(or
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
							(>= (++ temp9) numCol)
						)
						(= temp9 0)
						(= temp0 invLeft)
						(+= temp1 (+ itemHigh rowMargin))
						(if (>= (++ temp8) numRow)
							(break)
						)
					)
				)
			)
		else
			(for ((= temp3 temp3)) temp3 ((= temp3 (self next: temp3)))
				(if
					(and
						((= temp2 (NodeValue temp3)) isKindOf: InvI)
						(temp2 chestAmout:)
					)
					(if
						(>
							(= temp5
								(CelHigh
									(temp2 view:)
									(temp2 loop:)
									(temp2 cel:)
								)
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
								(CelWide
									(temp2 view:)
									(temp2 loop:)
									(temp2 cel:)
								)
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
						(or
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
							(>= (++ temp9) numCol)
						)
						(= temp9 0)
						(= temp0 invLeft)
						(+= temp1 (+ itemHigh rowMargin))
						(if (>= (++ temp8) numRow)
							(break)
						)
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
	)

	(method (show)
		(|= state $0020)
		(gGlory setCursor: (self getCursor:))
		(plane priority: (+ (GetHighPlanePri) 1))
		(self drawInvItems:)
		(plane
			setRect:
				planeLeft
				planeTop
				(+ planeLeft iconRight)
				(+
					planeTop
					iconBottom
					iconMargin
					(* (+ itemHigh rowMargin) numRow)
				)
		)
		(UpdatePlane plane)
		(return 1)
	)

	(method (setCurIndex param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp1 (if (< param1 0) -1 else 1))
		(= temp2 0)
		(= temp4 curIndex)
		(= temp2 0)
		(while (and (< temp2 (Abs param1)) (< temp4 size) (>= temp4 0))
			(+= temp4 temp1)
			(if
				(and
					(<= 0 temp4 (- size 1))
					((= temp3 (self at: temp4)) isKindOf: InvI)
					(temp3 ownedBy: owner)
				)
				(++ temp2)
			)
		)
		(if (< temp2 (Abs param1))
			(return)
		else
			(= curIndex temp4)
		)
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
			(= gMouseX (temp1 x:))
			(= gMouseY (temp1 y:))
			(= temp2 (temp1 type:))
			(= temp3 (temp1 message:))
			(= temp4 (temp1 modifiers:))
			(= temp9 0)
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
			(temp1 localize: plane)
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
							(gGlory setCursor: (highlightedIcon getCursor:) 1)
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
											(+ (highlightedIcon nsBottom:) 1)
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
												(| (helpIconItem signal:) $0010)
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
		(temp10 dispose:)
	)
)

