;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 995)
(include sci.sh)
(use Main)
(use Print)
(use IconBar)
(use Window)
(use System)

(local
	numCols
)

(class InvI of IconI
	(properties
		view 0
		loop 0
		cel 0
		nsTop 0
		cursor 999
		message 0
		signal 0
		owner 0
		script 0
		value 0
	)

	(method (onMe event)
		(return (and (super onMe: event) (not (& signal $0004))))
	)

	(method (doVerb theVerb)
		(if (not modNum)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun theVerb 0 1))
			(InspectObj 1)
			(gMessager say: noun theVerb 0 0 0 modNum)
		else
			(InspectObj 2)
		)
	)

	(method (highlight tOrF &tmp t l b r sColor)
		(if (== highlightColor -1)
			(return)
		)
		(= sColor (if (and argc tOrF) highlightColor else lowlightColor))
		(= t nsTop)
		(= l nsLeft)
		(= b nsBottom)
		(= r nsRight)
		(Graph grDRAW_LINE t l t r sColor -1 -1)
		(Graph grDRAW_LINE t r b r sColor -1 -1)
		(Graph grDRAW_LINE b r b l sColor -1 -1)
		(Graph grDRAW_LINE b l t l sColor -1 -1)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) (+ nsBottom 2) (+ nsRight 2) 1)
	)

	(method (show &tmp [temp0 4])
		(DrawCel view loop cel nsLeft nsTop -1)
	)

	(method (ownedBy id)
		(return (== owner id))
	)

	(method (moveTo id)
		(= owner id)
		(if (and value (== id gEgo))
			(gGame changeScore: value)
			(= value 0)
		)
		(return self)
	)
)

(class Inv of IconBar
	(properties
		normalHeading {You are carrying:}
		heading 0
		empty {nothing!}
		iconBarInvItem 0
		okButton 0
		selectIcon 0
	)

	(method (drawInvWindow whom selection &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 [temp22 50] temp72)
		(= temp0 (= temp1 (= temp2 (= temp3 (= temp4 (= temp5 0))))))
		(for ((= temp8 (self first:))) temp8 ((= temp8 (self next: temp8)))
			(if ((= temp9 (NodeValue temp8)) isKindOf: InvI)
				(if (temp9 ownedBy: whom)
					(temp9 signal: (& (temp9 signal:) $fffb))
					(++ temp0)
					(if
						(>
							(= temp6
								(CelWide
									(temp9 view:)
									(temp9 loop:)
									(temp9 cel:)
								)
							)
							temp2
						)
						(= temp2 temp6)
					)
					(if
						(>
							(= temp7
								(CelHigh
									(temp9 view:)
									(temp9 loop:)
									(temp9 cel:)
								)
							)
							temp1
						)
						(= temp1 temp7)
					)
				else
					(temp9 signal: (| (temp9 signal:) $0004))
				)
			else
				(++ temp3)
				(+= temp5 (CelWide (temp9 view:) (temp9 loop:) (temp9 cel:)))
				(if
					(>
						(= temp7
							(CelHigh (temp9 view:) (temp9 loop:) (temp9 cel:))
						)
						temp4
					)
					(= temp4 temp7)
				)
			)
		)
		(if (not temp0)
			(= temp72 (Print new:))
			(temp72 addTextF: {%s %s} normalHeading empty init:)
			(return 0)
		)
		(if (> (* (= temp16 (Sqrt temp0)) temp16) temp0)
			(-- temp16)
		)
		(if (> temp16 3)
			(= temp16 3)
		)
		(= numCols (/ temp0 temp16))
		(if (< (* temp16 numCols) temp0)
			(++ numCols)
		)
		(= temp10 (Max (+ 4 temp5) (* numCols (+ 4 temp2))))
		(= temp11 (* temp16 (+ 4 temp1)))
		(= temp12 (/ (- 190 temp11) 2))
		(= temp13 (/ (- 320 temp10) 2))
		(= temp14 (+ temp12 temp11))
		(= temp15 (+ temp13 temp10))
		(if (= temp21 (self window:))
			(temp21 top: temp12 left: temp13 right: temp15 bottom: temp14 open:)
		)
		(= temp20 numCols)
		(if temp0
			(= temp18
				(+
					2
					(if (temp21 respondsTo: #yOffset)
						(temp21 yOffset:)
					)
				)
			)
			(= temp19
				(= temp17
					(+
						4
						(if (temp21 respondsTo: #xOffset)
							(temp21 xOffset:)
						)
					)
				)
			)
			(for ((= temp8 (self first:))) temp8 ((= temp8 (self next: temp8)))
				(if
					(and
						(not (& ((= temp9 (NodeValue temp8)) signal:) $0004))
						(temp9 isKindOf: InvI)
					)
					(if (not (& (temp9 signal:) $0080))
						(temp9
							nsLeft:
								(+
									temp17
									(/
										(-
											temp2
											(= temp6
												(CelWide
													(temp9 view:)
													(temp9 loop:)
													(temp9 cel:)
												)
											)
										)
										2
									)
								)
							nsTop:
								(+
									temp18
									(/
										(-
											temp1
											(= temp7
												(CelHigh
													(temp9 view:)
													(temp9 loop:)
													(temp9 cel:)
												)
											)
										)
										2
									)
								)
						)
						(temp9
							nsRight: (+ (temp9 nsLeft:) temp6)
							nsBottom: (+ (temp9 nsTop:) temp7)
						)
						(if (-- temp20)
							(+= temp17 temp2)
						else
							(= temp20 numCols)
							(+= temp18 temp1)
							(= temp17 temp19)
						)
					else
						(= temp17 (temp9 nsLeft:))
						(= temp18 (temp9 nsTop:))
					)
					(temp9 show:)
					(if (== temp9 selection)
						(temp9 highlight:)
					)
				)
			)
		)
		(= temp17 (/ (- (- (temp21 right:) (temp21 left:)) temp5) 2))
		(= temp11 (- (temp21 bottom:) (temp21 top:)))
		(= temp18 32767)
		(for ((= temp8 (self first:))) temp8 ((= temp8 (self next: temp8)))
			(if (not ((= temp9 (NodeValue temp8)) isKindOf: InvI))
				(= temp6 (CelWide (temp9 view:) (temp9 loop:) (temp9 cel:)))
				(= temp7 (CelHigh (temp9 view:) (temp9 loop:) (temp9 cel:)))
				(if (not (& (temp9 signal:) $0080))
					(if (== temp18 32767)
						(= temp18 (- temp11 temp7))
					)
					(temp9
						nsLeft: temp17
						nsTop: temp18
						nsBottom: temp11
						nsRight: (+ temp17 temp6)
					)
				)
				(= temp17 (+ (temp9 nsLeft:) temp6))
				(= temp18 (temp9 nsTop:))
				(temp9 signal: (& (temp9 signal:) $fffb) show:)
			)
		)
		(return 1)
	)

	(method (init)
		(= heading normalHeading)
	)

	(method (ownedBy whom)
		(self firstTrue: #ownedBy whom)
	)

	(method (showSelf whom)
		(gSounds pause:)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(if (gTheIconBar height:)
			(gTheIconBar hide:)
		)
		(if (not window)
			(= window (SysWindow new:))
		)
		(if (window window:)
			(window dispose:)
			(= window 0)
		)
		(if (not okButton)
			(= okButton (NodeValue (self first:)))
		)
		(= curIcon 0)
		(if (self show: (if argc whom else gEgo))
			(self doit:)
		)
	)

	(method (show who &tmp pnv diw)
		(gGame
			setCursor:
				(if curIcon
					(curIcon cursor:)
				else
					(selectIcon cursor:)
				)
		)
		(= pnv (PicNotValid))
		(PicNotValid 0)
		(|= state $0020)
		(if
			(not
				(= diw
					(self
						drawInvWindow:
							(if argc who else gEgo)
							(gTheIconBar curIcon:)
					)
				)
			)
			(&= state $ffdf)
		)
		(PicNotValid pnv)
		(return diw)
	)

	(method (advance amount &tmp theIcon toMove highlightedNo nextIcon)
		(= toMove (if argc amount else 1))
		(= highlightedNo (self indexOf: highlightedIcon))
		(= nextIcon (+ toMove highlightedNo))
		(repeat
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
			(if (not (IsObject theIcon))
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
			(= theIcon (self at: nextIcon))
			(if (not (IsObject theIcon))
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
		(= theX
			(+ (/ (- (hIcon nsRight:) (hIcon nsLeft:)) 2) (hIcon nsLeft:))
		)
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

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 [temp5 2] temp7 temp8 temp9 [temp10 50])
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
			(temp1 localize:)
			(= gGameTime (+ gTickOffset (GetTime)))
			(if
				(and
					curIcon
					(not temp4)
					(!= curIcon selectIcon)
					(or
						(== temp2 1)
						(and (== temp2 4) (== temp3 13) (= temp9 1))
						(and (== temp2 256) (= temp9 1))
					)
				)
				(if (& (helpIconItem signal:) $0010)
					(temp1 type: 24576 message: (helpIconItem message:))
				else
					(temp1 type: 16384 message: (curIcon message:))
				)
			)
			(MapKeyToDir temp1)
			(= temp2 (temp1 type:))
			(= temp3 (temp1 message:))
			(if gSet
				(gSet eachElementDo: #doit)
			)
			(if (gTheDoits size:)
				(gTheDoits eachElementDo: #doit firstTrue: #handleEvent temp1)
			)
			(cond
				((temp1 claimed:))
				(gModelessDialog)
				(else
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
								(== temp2 256)
							)
							(if
								(and
									(IsObject highlightedIcon)
									(self select: highlightedIcon (== temp2 1))
								)
								(if (== highlightedIcon okButton)
									(temp1 claimed: 1)
									(break)
								)
								(if (== highlightedIcon helpIconItem)
									(if (!= (highlightedIcon cursor:) -1)
										(gGame
											setCursor: (helpIconItem cursor:)
										)
									)
									(if (and (& state $0800) (== temp2 1))
										(self noClickHelp:)
										(continue)
									)
									(if helpIconItem
										(helpIconItem
											signal:
												(| (helpIconItem signal:) $0010)
										)
									)
									(continue)
								)
								(= curIcon highlightedIcon)
								(gGame setCursor: (curIcon cursor:))
							)
						)
						((& temp2 $0040)
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
													(-
														(highlightedIcon nsTop:)
														1
													)
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
														(highlightedIcon
															nsBottom:
														)
														1
													)
													(window bottom:)
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
							)
						)
						(
							(and
								(& temp2 $4000)
								(= temp0 (self firstTrue: #onMe temp1))
							)
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
											@temp10
										)
									)
									(if (gSystemWindow respondsTo: #eraseOnly)
										(= temp7 (gSystemWindow eraseOnly:))
										(gSystemWindow eraseOnly: 1)
										(Prints @temp10)
										(gSystemWindow eraseOnly: temp7)
									else
										(Prints @temp10)
									)
								)
								(helpIconItem
									signal: (& (helpIconItem signal:) $ffef)
								)
								(gGame setCursor: 999)
								(continue)
							)
							(if (== temp0 okButton)
								(temp1 claimed: 1)
								(break)
							)
							(if (not (temp0 isKindOf: InvI))
								(if (self select: temp0 (not temp9))
									(= curIcon temp0)
									(gGame setCursor: (curIcon cursor:))
									(if (== temp0 helpIconItem)
										(if (and (& state $0800) (not temp9))
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
								(if (gSystemWindow respondsTo: #eraseOnly)
									(= temp7 (gSystemWindow eraseOnly:))
									(gSystemWindow eraseOnly: 1)
								)
								(if (curIcon isKindOf: InvI)
									(temp0 doVerb: (curIcon message:))
								else
									(temp0 doVerb: (temp1 message:))
								)
								(if (gSystemWindow respondsTo: #eraseOnly)
									(gSystemWindow eraseOnly: temp7)
								)
							)
						)
					)
				)
			)
		)
		(self hide:)
	)

	(method (hide &tmp theCurs)
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
		)
		(if window
			(window dispose:)
		)
		(if (and (IsObject curIcon) (curIcon isKindOf: InvI))
			(if (not (gTheIconBar curInvIcon:))
				(gTheIconBar enable: (gTheIconBar useIconItem:))
			)
			(gTheIconBar
				curIcon:
					((gTheIconBar useIconItem:)
						cursor: (curIcon cursor:)
						yourself:
					)
				curInvIcon: curIcon
			)
			(if (= theCurs ((gTheIconBar curIcon:) cursor:))
				(gGame setCursor: theCurs)
			)
		)
	)
)

