;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 995)
(include sci.sh)
(use Main)
(use Interface)
(use IconBar)
(use Window)
(use System)

(local
	yesI
)

(class InvI of IconI
	(properties
		view 0
		loop 0
		cel 0
		nsTop 0
		cursor 8
		message 4
		signal 0
		description 0
		owner 0
		script 0
		value 0
	)

	(method (onMe event)
		(return (and (super onMe: event) (not (& signal $0004))))
	)

	(method (highlight tOrF &tmp t l b r sColor)
		(if (== highlightColor -1)
			(return)
		)
		(= sColor (if (and argc tOrF) highlightColor else lowlightColor))
		(= t (- nsTop 2))
		(= l (- nsLeft 2))
		(= b (+ nsBottom 1))
		(= r (+ nsRight 1))
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
		normalHeading 38
		heading 0
		empty 39
		curScore {Score: %d out of %d}
		showScore 1
		iconBarInvItem 0
		okButton 0
		selectIcon 0
	)

	(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 [temp21 40] [temp61 20])
		(= temp0 (= temp1 (= temp2 (= temp3 (= temp4 (= temp5 0))))))
		(for
			((= temp8 (gInventory first:)))
			temp8
			((= temp8 (gInventory next: temp8)))
			
			(if ((= temp9 (NodeValue temp8)) isKindOf: InvI)
				(if (temp9 ownedBy: param1)
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
			(GetMessage 98 0 normalHeading @temp21)
			(GetMessage 98 0 empty @temp61)
			(StrCat @temp21 @temp61)
			(Print @temp21 #icon 813 0 0)
			(return 0)
		)
		(if (> (* (= temp16 (Sqrt temp0)) temp16) temp0)
			(-- temp16)
		)
		(if (> temp16 3)
			(= temp16 3)
		)
		(= yesI (/ temp0 temp16))
		(if (< (* temp16 yesI) temp0)
			(++ yesI)
		)
		(= temp10 (Max (+ 4 temp5) (* yesI (+ 4 temp2))))
		(= temp11 (* temp16 (+ 4 temp1)))
		(= temp12 (/ (- 190 temp11) 2))
		(= temp13 (/ (- 320 temp10) 2))
		(= temp14 (+ temp12 temp11))
		(= temp15 (+ temp13 temp10))
		(if (gInventory window:)
			((gInventory window:)
				top: temp12
				left: temp13
				right: temp15
				bottom: temp14
				open:
			)
		)
		(= temp20 yesI)
		(if temp0
			(= temp18
				(+
					2
					(if ((gInventory window:) respondsTo: #yOffset)
						((gInventory window:) yOffset:)
					)
				)
			)
			(= temp19
				(= temp17
					(+
						4
						(if ((gInventory window:) respondsTo: #xOffset)
							((gInventory window:) xOffset:)
						)
					)
				)
			)
			(for
				((= temp8 (gInventory first:)))
				temp8
				((= temp8 (gInventory next: temp8)))
				
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
							(= temp20 yesI)
							(+= temp18 temp1)
							(= temp17 temp19)
						)
					else
						(= temp17 (temp9 nsLeft:))
						(= temp18 (temp9 nsTop:))
					)
					(temp9 show:)
					(if (== temp9 param2)
						(temp9 highlight:)
					)
				)
			)
		)
		(= temp17
			(/
				(-
					(- ((gInventory window:) right:) ((gInventory window:) left:))
					temp5
				)
				2
			)
		)
		(= temp11 (- ((gInventory window:) bottom:) ((gInventory window:) top:)))
		(= temp18 32767)
		(for
			((= temp8 (gInventory first:)))
			temp8
			((= temp8 (gInventory next: temp8)))
			
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
		(= gInventory self)
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
					(localproc_0
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
		(gGame setCursor: gTheCursor 1)
		(MoveCursor
			(+ (theIcon nsLeft:) (/ (- (theIcon nsRight:) (theIcon nsLeft:)) 2))
			(- (theIcon nsBottom:) 3)
		)
		(self highlight: theIcon)
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
		(gGame setCursor: gTheCursor 1)
		(MoveCursor
			(+ (theIcon nsLeft:) (/ (- (theIcon nsRight:) (theIcon nsLeft:)) 2))
			(- (theIcon nsBottom:) 3)
		)
		(self highlight: theIcon)
	)

	(procedure (localproc_1 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
		(= temp3
			(+ (/ (- (param1 nsRight:) (param1 nsLeft:)) 2) (param1 nsLeft:))
		)
		(= temp2 param2)
		(while (>= (Abs (- temp2 param3)) 4)
			(if
				(= temp0
					(self
						firstTrue:
							#onMe
							((= temp1 (Event new:)) x: temp3 y: temp2 yourself:)
					)
				)
				(temp1 dispose:)
				(return temp0)
			)
			(temp1 dispose:)
			(if (< param2 param3)
				(+= temp2 4)
			else
				(-= temp2 4)
			)
		)
	)

	(method (doit &tmp thisIcon event evtType evtMsg [node 3] newIcon eO oldPort [keyInvoked 100])
		(while ((= event (Event new:)) type:)
			(event dispose:)
		)
		(event dispose:)
		(= event 0)
		(while (= event (Event new:))
			(if (& state $0020)
				(= oldPort 0)
				(event localize:)
				(if gFastCast
					(gFastCast handleEvent: event)
					(event dispose:)
					(continue)
				)
				(if
					(and
						curIcon
						(not (event modifiers:))
						(!= curIcon selectIcon)
						(or
							(== (event type:) evMOUSEBUTTON)
							(and
								(== (event type:) evKEYBOARD)
								(== (event message:) KEY_RETURN)
								(= oldPort 1)
							)
							(and (== (event type:) evJOYDOWN) (= oldPort 1))
						)
						(or
							(!= curIcon helpIconItem)
							(& (helpIconItem signal:) $0010)
						)
					)
					(event type: evVERB message: (curIcon message:))
				)
				(MapKeyToDir event)
				(cond
					((and (== (= evtMsg (event type:)) evMOUSEBUTTON) (event modifiers:))
						(self advanceCurIcon:)
						(event claimed: 1)
					)
					(
						(and
							(== evtMsg evNULL)
							(= thisIcon (self firstTrue: #onMe event))
							(!= thisIcon highlightedIcon)
						)
						(self highlight: thisIcon)
					)
					(
						(or
							(== evtMsg evMOUSEBUTTON)
							(and (== evtMsg evKEYBOARD) (== (event message:) KEY_RETURN))
							(== evtMsg evJOYDOWN)
						)
						(if
							(and
								(IsObject highlightedIcon)
								(self select: highlightedIcon (== evtMsg evMOUSEBUTTON))
							)
							(cond
								((== highlightedIcon okButton)
									(break)
								)
								((== highlightedIcon helpIconItem)
									(if (& state $0800)
										(self noClickHelp:)
									else
										(if (!= (highlightedIcon cursor:) -1)
											(gGame
												setCursor:
													(helpIconItem cursor:)
											)
										)
										(if helpIconItem
											(helpIconItem
												signal:
													(|
														(helpIconItem signal:)
														$0010
													)
											)
										)
									)
								)
								(else
									(= curIcon highlightedIcon)
									(gGame setCursor: (curIcon cursor:) 1)
								)
							)
						)
					)
					((& evtMsg $0040) ; direction
						(switch (event message:)
							(JOY_RIGHT
								(self advance:)
							)
							(JOY_LEFT
								(self retreat:)
							)
							(JOY_UP
								(if
									(and
										highlightedIcon
										(= thisIcon
											(localproc_1
												highlightedIcon
												(- (highlightedIcon nsTop:) 1)
												0
											)
										)
									)
									(self highlight: thisIcon 1)
								else
									(self retreat:)
								)
							)
							(JOY_DOWN
								(if
									(and
										highlightedIcon
										(= thisIcon
											(localproc_1
												highlightedIcon
												(+
													(highlightedIcon nsBottom:)
													1
												)
												(window bottom:)
											)
										)
									)
									(self highlight: thisIcon 1)
								else
									(self advance:)
								)
							)
						)
					)
					((== evtMsg evKEYBOARD)
						(switch (event message:)
							(KEY_TAB
								(self advance:)
							)
							(KEY_SHIFTTAB
								(self retreat:)
							)
						)
					)
					(
						(and
							(== evtMsg evVERB)
							(= thisIcon (self firstTrue: #onMe event))
						)
						(cond
							((== (event message:) JOY_DOWNLEFT)
								(if (and thisIcon (thisIcon helpStr:))
									(GetMessage 98 0 (thisIcon helpStr:) @keyInvoked)
									(if (gSystemWindow respondsTo: #eraseOnly)
										(= newIcon (gSystemWindow eraseOnly:))
										(gSystemWindow eraseOnly: 1)
										(Print @keyInvoked #icon 813 0 0)
										(gSystemWindow eraseOnly: newIcon)
									else
										(Print @keyInvoked #icon 813 0 0)
									)
								)
								(helpIconItem
									signal: (& (helpIconItem signal:) $ffef)
								)
								(gGame setCursor: 8)
							)
							((== thisIcon okButton)
								(breakif (super select: thisIcon))
							)
							((not (thisIcon isKindOf: InvI))
								(if (self select: thisIcon (not oldPort))
									(= curIcon thisIcon)
									(gGame setCursor: (curIcon cursor:) 1)
								)
							)
							(curIcon
								(if (gSystemWindow respondsTo: #eraseOnly)
									(= newIcon (gSystemWindow eraseOnly:))
									(gSystemWindow eraseOnly: 1)
								)
								(if (curIcon isKindOf: InvI)
									(thisIcon
										doVerb:
											(curIcon message:)
											(self indexOf: curIcon)
									)
								else
									(thisIcon doVerb: (event message:))
								)
								(if (gSystemWindow respondsTo: #eraseOnly)
									(gSystemWindow eraseOnly: newIcon)
								)
							)
						)
					)
				)
			else
				(break)
			)
			(event dispose:)
		)
		(event dispose:)
		(self hide:)
	)

	(method (hide)
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
			(if (curIcon cursor:)
				(gGame setCursor: (curIcon cursor:) 1)
			)
		)
	)

	(method (advanceCurIcon &tmp theIcon)
		(for
			((= theIcon (self at: (mod (+ (self indexOf: curIcon) 1) size))))
			(or (theIcon isKindOf: InvI) (& (theIcon signal:) $0006))
			((= theIcon (self at: (mod (+ (self indexOf: theIcon) 1) size))))
		)
		(= curIcon theIcon)
		(gGame setCursor: (curIcon cursor:) 1)
	)
)

