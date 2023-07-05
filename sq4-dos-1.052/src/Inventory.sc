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
	[local0 3]
	local3
	local4
	local5
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20)
	(= temp0 (= temp1 (= temp2 (= temp3 (= temp4 (= temp5 0))))))
	(for ((= temp8 (gInventory first:))) temp8 ((= temp8 (gInventory next: temp8)))
		(cond
			(
				(and
					((= temp9 (NodeValue temp8)) isKindOf: InvI)
					(temp9 ownedBy: param1)
				)
				(temp9 signal: (& (temp9 signal:) $fffb))
				(++ temp0)
				(if
					(>
						(= temp6
							(CelWide (temp9 view:) (temp9 loop:) (temp9 cel:))
						)
						temp2
					)
					(= temp2 temp6)
				)
				(if
					(>
						(= temp7
							(CelHigh (temp9 view:) (temp9 loop:) (temp9 cel:))
						)
						temp1
					)
					(= temp1 temp7)
				)
			)
			((temp9 isMemberOf: IconI)
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
			(else
				(temp9 signal: (| (temp9 signal:) $0004))
			)
		)
	)
	(if (> (* (= temp16 (Sqrt temp0)) temp16) temp0)
		(-- temp16)
	)
	(if (> temp16 3)
		(= temp16 3)
	)
	(= local5 (/ temp0 temp16))
	(if (< (* temp16 local5) temp0)
		(++ local5)
	)
	(= temp10 (Max (+ 4 temp5) (* local5 (+ 4 temp2))))
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
	(= temp20 local5)
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
						(= temp20 local5)
						(+= temp18 temp1)
						(= temp17 temp19)
					)
				else
					(= temp17 (temp9 nsLeft:))
					(= temp18 (temp9 nsTop:))
				)
				(temp9 show:)
				(if (== temp9 param2)
					(gGame setCursor: 5 1)
					((= local3 temp9) highlight:)
					(= local4 temp8)
				)
			)
		)
	)
	(= temp17
		(/ (- (- ((gInventory window:) right:) ((gInventory window:) left:)) temp5) 2)
	)
	(for ((= temp8 (gInventory first:))) temp8 ((= temp8 (gInventory next: temp8)))
		(if (not ((= temp9 (NodeValue temp8)) isMemberOf: InvI))
			(= temp6 (CelWide (temp9 view:) (temp9 loop:) (temp9 cel:)))
			(= temp7 (CelHigh (temp9 view:) (temp9 loop:) (temp9 cel:)))
			(= temp11 (- ((gInventory window:) bottom:) ((gInventory window:) top:)))
			(temp9
				nsLeft: temp17
				nsTop: (- temp11 temp7)
				nsBottom: temp11
				nsRight: (+ temp17 temp6)
				signal: (& (temp9 signal:) $fffb)
				show:
			)
			(+= temp17 temp6)
		)
	)
)

(class InvI of IconI
	(properties
		view 0
		loop 0
		cel 0
		nsTop 0
		cursor 999
		message 3
		signal 0
		description 0
		owner 0
		script 0
		value 0
	)

	(method (onMe event)
		(return (and (super onMe: event) (not (& signal $0004))))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(Printf 995 0 description) ; "%s"
			)
		)
	)

	(method (highlight tOrF &tmp t l b r sColor)
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
		(if (and value (= id gEgo))
			(gGame changeScore: value)
			(= value 0)
		)
		(return self)
	)
)

(class Inv of IconBar
	(properties
		normalHeading {Roger is carrying:}
		heading 0
		empty {nothing!}
		curScore {Score: %d out of %d}
		showScore 1
		iconBarInvItem 0
		okButton 0
		selectIcon 0
	)

	(method (init)
		(= gInventory self)
		(= heading normalHeading)
	)

	(method (ownedBy whom)
		(self firstTrue: #ownedBy whom)
	)

	(method (showSelf &tmp [temp0 9])
		(gSounds pause:)
		(if (and global97 (global97 respondsTo: #stop))
			(global97 stop:)
		)
		(if (gNarrator height:)
			(gNarrator hide:)
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
		(gGame setCursor: (selectIcon cursor:))
		(self show: doit:)
	)

	(method (show)
		(|= state $0020)
		(localproc_0 gEgo (gNarrator curIcon:))
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
		(gGame
			setCursor:
				gTheCursor
				1
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
		(gGame
			setCursor:
				gTheCursor
				1
				(+ (theIcon nsLeft:) (/ (- (theIcon nsRight:) (theIcon nsLeft:)) 2))
				(- (theIcon nsBottom:) 3)
		)
		(self highlight: theIcon)
	)

	(method (doit &tmp temp0 temp1 temp2 [temp3 4] temp7)
		(while (= temp1 (Event new:))
			(if (& state $0020)
				(= temp7 0)
				(temp1 localize:)
				(if
					(and
						curIcon
						(not (temp1 modifiers:))
						(!= curIcon selectIcon)
						(or
							(== (temp1 type:) evMOUSEBUTTON)
							(and
								(== (temp1 type:) evKEYBOARD)
								(== (temp1 message:) KEY_RETURN)
								(= temp7 1)
							)
							(and (== (temp1 type:) evJOYDOWN) (= temp7 1))
						)
						(or
							(!= curIcon helpIconItem)
							(& (helpIconItem signal:) $0010)
						)
					)
					(temp1 type: evVERB message: (curIcon message:))
				)
				(MapKeyToDir temp1)
				(cond
					((and (== (= temp2 (temp1 type:)) evMOUSEBUTTON) (temp1 modifiers:))
						(self advanceCurIcon:)
						(temp1 claimed: 1)
					)
					(
						(and
							(== temp2 evNULL)
							(= temp0 (self firstTrue: #onMe temp1))
							(!= temp0 highlightedIcon)
						)
						(self highlight: temp0)
					)
					(
						(or
							(== temp2 evMOUSEBUTTON)
							(and (== temp2 evKEYBOARD) (== (temp1 message:) KEY_RETURN))
							(== temp2 evJOYDOWN)
						)
						(if
							(and
								(IsObject highlightedIcon)
								(self select: highlightedIcon (== temp2 evMOUSEBUTTON))
							)
							(cond
								((== highlightedIcon okButton)
									(break)
								)
								((== highlightedIcon helpIconItem)
									(if (!= (highlightedIcon cursor:) -1)
										(gGame
											setCursor: (helpIconItem cursor:)
										)
									)
									(if helpIconItem
										(helpIconItem
											signal:
												(| (helpIconItem signal:) $0010)
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
					((& temp2 $0040) ; direction
						(switch (temp1 message:)
							(JOY_RIGHT
								(self advance:)
							)
							(JOY_LEFT
								(self retreat:)
							)
							(JOY_UP
								(self retreat: local5)
							)
							(JOY_DOWN
								(self advance: local5)
							)
							(JOY_NULL
								(if (& temp2 evKEYBOARD)
									(self advanceCurIcon:)
								)
							)
						)
					)
					((== temp2 evKEYBOARD)
						(switch (temp1 message:)
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
							(== temp2 evVERB)
							(= temp0 (self firstTrue: #onMe temp1))
						)
						(cond
							((== (temp1 message:) JOY_DOWN)
								(if (and temp0 (temp0 helpStr:))
									(Printf 995 0 (temp0 helpStr:)) ; "%s"
								)
								(helpIconItem
									signal: (& (helpIconItem signal:) $ffef)
								)
								(gGame setCursor: 999)
							)
							((== temp0 okButton)
								(break)
							)
							((temp0 isMemberOf: IconI)
								(if (self select: temp0 (not temp7))
									(= curIcon temp0)
									(gGame setCursor: (curIcon cursor:) 1)
								)
							)
							(curIcon
								(if (curIcon isMemberOf: InvI)
									(temp0
										doVerb:
											(curIcon message:)
											(self indexOf: curIcon)
									)
								else
									(temp0 doVerb: (temp1 message:))
								)
							)
						)
					)
				)
			else
				(break)
			)
			(temp1 dispose:)
		)
		(temp1 dispose:)
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
		(if (and (IsObject curIcon) (curIcon isMemberOf: InvI))
			(gNarrator
				curIcon:
					((gNarrator useIconItem:)
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
		(= theIcon curIcon)
		(while
			((= theIcon (self at: (mod (+ (self indexOf: theIcon) 1) size)))
				isMemberOf: InvI
			)
		)
		(= curIcon theIcon)
		(gGame setCursor: (curIcon cursor:) 1)
	)
)

