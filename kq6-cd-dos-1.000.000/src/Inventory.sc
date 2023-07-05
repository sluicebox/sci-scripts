;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 995)
(include sci.sh)
(use Main)
(use Print)
(use IconBar)
(use Tutorial)
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
		modNum -1
		owner 0
		script 0
		value 0
	)

	(method (onMe event)
		(return (and (super onMe: event) (not (& signal $0004))))
	)

	(method (doVerb theVerb &tmp tut)
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun theVerb 0 1))
			(gMessager say: noun theVerb 0 0 0 modNum)
		)
		(if (and (= tut (gGame script:)) (tut isKindOf: Tutorial))
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
		normalHeading {You are carrying:}
		heading 0
		empty {nothing!}
		iconBarInvItem 0
		okButton 0
		selectIcon 0
	)

	(method (drawInvWindow whom selection &tmp numOwned tallestInv widestInv numIcons tallestIcon iconBarWidth cWide cHigh node obj invW invH iTop iLeft iBottom iRight numRows atX atY firstX i invWin [buffer 50])
		(= global170 0)
		(= numOwned (= tallestInv (= widestInv (= numIcons (= tallestIcon (= iconBarWidth 0))))))
		(for ((= node (self first:))) node ((= node (self next: node)))
			(if ((= obj (NodeValue node)) isKindOf: InvI)
				(if (obj ownedBy: whom)
					(obj signal: (& (obj signal:) $fffb))
					(++ numOwned)
					(if
						(>
							(= cWide
								(CelWide
									(obj view:)
									(obj loop:)
									(obj cel:)
								)
							)
							widestInv
						)
						(= widestInv cWide)
					)
					(if
						(>
							(= cHigh
								(CelHigh
									(obj view:)
									(obj loop:)
									(obj cel:)
								)
							)
							tallestInv
						)
						(= tallestInv cHigh)
					)
				else
					(obj signal: (| (obj signal:) $0004))
				)
			else
				(++ numIcons)
				(+= iconBarWidth (CelWide (obj view:) (obj loop:) (obj cel:)))
				(if
					(>
						(= cHigh
							(CelHigh (obj view:) (obj loop:) (obj cel:))
						)
						tallestIcon
					)
					(= tallestIcon cHigh)
				)
			)
		)
		(if (not numOwned)
			(Print addTextF: {%s %s} normalHeading empty init:)
			(return 0)
		)
		(if (> (* (= numRows (Sqrt numOwned)) numRows) numOwned)
			(-- numRows)
		)
		(if (> numRows 3)
			(= numRows 3)
		)
		(= numCols (/ numOwned numRows))
		(if (< (* numRows numCols) numOwned)
			(++ numCols)
		)
		(= invW (Max (+ 4 iconBarWidth) (* numCols (+ 4 widestInv))))
		(= invH (* numRows (+ 4 tallestInv)))
		(= iTop (/ (- 190 invH) 2))
		(= iLeft (/ (- 320 invW) 2))
		(= iBottom (+ iTop invH))
		(= iRight (+ iLeft invW))
		(if (= invWin (self window:))
			(invWin top: iTop left: iLeft right: iRight bottom: iBottom open:)
		)
		(= i numCols)
		(if numOwned
			(= atY
				(+
					2
					(if (invWin respondsTo: #yOffset)
						(invWin yOffset:)
					)
				)
			)
			(= firstX
				(= atX
					(+
						4
						(if (invWin respondsTo: #xOffset)
							(invWin xOffset:)
						)
					)
				)
			)
			(for ((= node (self first:))) node ((= node (self next: node)))
				(if
					(and
						(not (& ((= obj (NodeValue node)) signal:) $0004))
						(obj isKindOf: InvI)
					)
					(if (not (& (obj signal:) $0080))
						(obj
							nsLeft:
								(+
									atX
									(/
										(-
											widestInv
											(= cWide
												(CelWide
													(obj view:)
													(obj loop:)
													(obj cel:)
												)
											)
										)
										2
									)
								)
							nsTop:
								(+
									atY
									(/
										(-
											tallestInv
											(= cHigh
												(CelHigh
													(obj view:)
													(obj loop:)
													(obj cel:)
												)
											)
										)
										2
									)
								)
						)
						(obj
							nsRight: (+ (obj nsLeft:) cWide)
							nsBottom: (+ (obj nsTop:) cHigh)
						)
						(if (-- i)
							(+= atX widestInv)
						else
							(= i numCols)
							(+= atY tallestInv)
							(= atX firstX)
						)
					else
						(= atX (obj nsLeft:))
						(= atY (obj nsTop:))
					)
					(obj show:)
					(if (== obj selection)
						(obj highlight:)
					)
				)
			)
		)
		(= atX (/ (- (- (invWin right:) (invWin left:)) iconBarWidth) 2))
		(= invH (- (invWin bottom:) (invWin top:)))
		(= atY 32767)
		(for ((= node (self first:))) node ((= node (self next: node)))
			(if (not ((= obj (NodeValue node)) isKindOf: InvI))
				(obj nsTop: 0)
				(= cWide (CelWide (obj view:) (obj loop:) (obj cel:)))
				(= cHigh (CelHigh (obj view:) (obj loop:) (obj cel:)))
				(if (not (& (obj signal:) $0080))
					(if (== atY 32767)
						(= atY (- invH cHigh))
					)
					(obj
						nsLeft: atX
						nsTop: atY
						nsBottom: invH
						nsRight: (+ atX cWide)
					)
				)
				(= atX (+ (obj nsLeft:) cWide))
				(= atY (obj nsTop:))
				(obj signal: (& (obj signal:) $fffb) show:)
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

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 [temp5 2] temp7 temp8 temp9 [temp10 50] temp60)
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
			(if global170
				(temp1 claimed: 1)
				(= global170 0)
				(break)
			)
			(if gSet
				(gSet eachElementDo: #doit)
			)
			(if (and (= temp60 (gGame script:)) (temp60 isKindOf: Tutorial))
				(temp60 doit:)
			)
			(if gFastCast
				(gFastCast eachElementDo: #doit)
				(= gGameTime (+ gTickOffset (GetTime)))
				(if gFastCast
					(gFastCast handleEvent: temp1)
				)
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
									(gGame setCursor: (helpIconItem cursor:))
								)
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
							(27
								(break)
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
									(if (& state $0800)
										(self noClickHelp:)
										(continue)
									)
									(helpIconItem
										signal: (| (helpIconItem signal:) $0010)
									)
								)
							)
							(continue)
						)
						(if curIcon
							(temp1 claimed: 1)
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

