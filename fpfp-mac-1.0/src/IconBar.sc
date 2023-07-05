;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 937)
(include sci.sh)
(use Main)
(use Print)
(use Tutorial)
(use System)

(class IconI of Obj
	(properties
		view -1
		loop -1
		cel -1
		nsLeft 0
		nsTop -1
		nsRight 0
		nsBottom 0
		state 0
		cursor -1
		type 16384
		message -1
		modifiers 0
		signal 1
		maskView 0
		maskLoop 0
		maskCel 0
		highlightColor 0
		lowlightColor 0
		noun 0
		modNum 0
		helpVerb 0
		iconIndex -1
	)

	(method (show iX iY &tmp [temp0 7])
		(|= signal $0020)
		(if argc
			(= nsRight (+ (= nsLeft iX) (CelWide view loop cel)))
			(= nsBottom (+ (= nsTop iY) (CelHigh view loop cel)))
		else
			(= nsRight (+ nsLeft (CelWide view loop cel)))
			(= nsBottom (+ nsTop (CelHigh view loop cel)))
		)
		(DrawCel view loop cel nsLeft nsTop -1)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (mask))

	(method (onMe obj)
		(return
			(and
				(>= (obj x:) nsLeft)
				(>= (obj y:) nsTop)
				(<= (obj x:) nsRight)
				(<= (obj y:) nsBottom)
			)
		)
	)

	(method (highlight &tmp [temp0 5])
		(if (or (not (& signal $0020)) (== highlightColor -1))
			(return)
		)
	)

	(method (select relVer &tmp event whichCel tut)
		(return
			(cond
				((& signal $0004) 0)
				((and argc relVer (& signal $0001))
					(DrawCel view loop (= whichCel 1) nsLeft nsTop -1)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					(while (!= ((= event (Event new:)) type:) evMOUSERELEASE)
						(event localize:)
						(cond
							((self onMe: event)
								(if (not whichCel)
									(DrawCel
										view
										loop
										(= whichCel 1)
										nsLeft
										nsTop
										-1
									)
									(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
								)
							)
							(whichCel
								(DrawCel view loop (= whichCel 0) nsLeft nsTop -1)
								(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
							)
						)
						(event dispose:)
					)
					(event dispose:)
					(if (== whichCel 1)
						(DrawCel view loop 0 nsLeft nsTop -1)
						(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					)
					(if
						(and
							(= tut (gGame script:))
							(tut isKindOf: Tutorial)
						)
						(cond
							(
								(and
									(== (tut nextItem:) self)
									(!=
										(tut nextAction:)
										((gTheIconBar helpIconItem:) message:)
									)
								)
								(tut cue:)
							)
							((not whichCel)
								(return 0)
							)
							(else
								(tut report:)
								(return 0)
							)
						)
					)
					whichCel
				)
				(else
					(if
						(and
							(= tut (gGame script:))
							(tut isKindOf: Tutorial)
						)
						(if
							(and
								(== (tut nextItem:) self)
								(!=
									(tut nextAction:)
									((gTheIconBar helpIconItem:) message:)
								)
							)
							(tut cue:)
						else
							(tut report:)
							(return 0)
						)
					)
					1
				)
			)
		)
	)
)

(class IconBar of Set
	(properties
		height 0
		underBits 0
		oldMouseX 0
		oldMouseY 0
		curIcon 0
		highlightedIcon 0
		prevIcon 0
		curInvIcon 0
		useIconItem 0
		helpIconItem 0
		walkIconItem 0
		port 0
		window 0
		state 1024
		activateHeight 0
		y 0
		invLoop 1
		pri 15
		rgnDesc 0
	)

	(method (findIcon theVerb &tmp i thisIcon)
		(for ((= i 0)) (< i size) ((++ i))
			(= thisIcon (self at: i))
			(if (== (thisIcon message:) theVerb)
				(return thisIcon)
			)
		)
		(return 0)
	)

	(method (noClickHelp &tmp event lastIcon thisIcon tmpStr oldPort eO)
		(= lastIcon (= thisIcon 0))
		(= tmpStr (GetPort))
		(= oldPort (gSystemWindow eraseOnly:))
		(gSystemWindow eraseOnly: 1)
		(while (not ((= event ((gUser curEvent:) new:)) type:))
			(if (not (self isMemberOf: IconBar))
				(event localize:)
			)
			(Animate (gCast elements:) 0)
			(cond
				((= thisIcon (self firstTrue: #onMe event))
					(if (and (!= thisIcon lastIcon) (thisIcon helpVerb:))
						(= lastIcon thisIcon)
						(if gModelessDialog
							(gModelessDialog dispose:)
						)
						(Print
							font: gUserFont
							width: 250
							addText:
								(thisIcon noun:)
								(thisIcon helpVerb:)
								0
								1
								0
								0
								(thisIcon modNum:)
							modeless: 1
							init:
						)
						(SetPort tmpStr)
					)
				)
				(gModelessDialog
					(gModelessDialog dispose:)
				)
				(else
					(= lastIcon 0)
				)
			)
			(event dispose:)
		)
		(gSystemWindow eraseOnly: oldPort)
		(gGame setCursor: 999 1)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(SetPort tmpStr)
		(if (not (helpIconItem onMe: event))
			(self dispatchEvent: event)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 [temp4 3])
		(event localize:)
		(= temp1 (event type:))
		(cond
			((& state $0004))
			(
				(and
					(not temp1)
					(& state $0400)
					(<= -10 (event y:) height)
					(<= 0 (event x:) 320)
					(not (= temp0 0))
				)
				(event globalize:)
				(self doit:)
				(= temp3
					(if (or (gUser canControl:) (gUser canInput:))
						(curIcon cursor:)
					else
						gWaitCursor
					)
				)
				(self hide:)
			)
			((& temp1 evMOUSEBUTTON)
				(cond
					((& (event modifiers:) emSHIFT)
						(self advanceCurIcon:)
						(event claimed: 1)
					)
					((& (event modifiers:) emCTRL)
						(if (gUser canControl:)
							(self swapCurIcon:)
						)
						(event claimed: 1)
					)
					((IsObject curIcon)
						(event
							type: (curIcon type:)
							message:
								(if (== curIcon useIconItem)
									(curInvIcon message:)
								else
									(curIcon message:)
								)
						)
					)
				)
			)
		)
	)

	(method (disable theIconNumber &tmp i thisIcon)
		(if argc
			(for ((= i 0)) (< i argc) ((++ i))
				(= thisIcon
					(if (IsObject [theIconNumber i])
						[theIconNumber i]
					else
						(self at: [theIconNumber i])
					)
				)
				(thisIcon signal: (| (thisIcon signal:) $0004))
				(Platform 0 4 3 (thisIcon iconIndex:))
				(cond
					((== thisIcon curIcon)
						(self advanceCurIcon:)
					)
					((== thisIcon highlightedIcon)
						(self advance:)
					)
				)
			)
		else
			(|= state $0004)
			(Platform 0 4 3 -1)
		)
	)

	(method (enable theIconNumber &tmp i thisIcon)
		(if argc
			(for ((= i 0)) (< i argc) ((++ i))
				(= thisIcon
					(if (IsObject [theIconNumber i])
						[theIconNumber i]
					else
						(self at: [theIconNumber i])
					)
				)
				(thisIcon signal: (& (thisIcon signal:) $fffb))
				(Platform 0 4 2 (thisIcon iconIndex:))
			)
		else
			(&= state $fffb)
			(Platform 0 4 2 -1)
		)
	)

	(method (show)
		(gSounds pause:)
		(|= state $0020)
	)

	(method (hide &tmp [temp0 3])
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
			(gTheIconBar disable:)
		)
	)

	(method (doit &tmp event eType eMsg eMod tut)
		(while (and (& state $0020) (= event ((gUser curEvent:) new:)))
			(= eType (event type:))
			(= eMsg (event message:))
			(= eMod (event modifiers:))
			(Wait 1)
			(= gGameTime (+ gTickOffset (GetTime)))
			(if gSet
				(gSet eachElementDo: #doit)
			)
			(event localize:)
			(MapKeyToDir event)
			(breakif (self dispatchEvent: event))
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 51] temp57 temp58 temp59 temp60)
		(= temp1 (event x:))
		(= temp0 (event y:))
		(= temp2 (event type:))
		(= temp3 (event message:))
		(= temp5 (event claimed:))
		(if (= temp4 (self firstTrue: #onMe event))
			(= temp57 (temp4 cursor:))
			(= temp58 (temp4 signal:))
			(= temp59 (== temp4 helpIconItem))
		)
		(if (& temp2 $0040) ; direction
			(switch temp3
				(JOY_RIGHT
					(self advance:)
				)
				(JOY_LEFT
					(self retreat:)
				)
			)
		else
			(switch temp2
				(evNULL
					(cond
						((not (and (<= 0 temp0 (+ y height)) (<= 0 temp1 320)))
							(if
								(and
									(& state $0400)
									(or
										(not (IsObject helpIconItem))
										(not (& (helpIconItem signal:) $0010))
									)
								)
								(= oldMouseY 0)
								(= temp5 1)
							)
						)
						((and temp4 (!= temp4 highlightedIcon))
							(= oldMouseY 0)
							(self highlight: temp4)
						)
					)
				)
				(evMOUSEBUTTON
					(if (and temp4 (self select: temp4 1))
						(if temp59
							(if temp57
								(gGame setCursor: temp57)
							)
							(if (& state $0800)
								(self noClickHelp:)
							else
								(helpIconItem
									signal: (| (helpIconItem signal:) $0010)
								)
							)
						else
							(= temp5 (& temp58 $0040))
						)
						(temp4 doit:)
					)
				)
			)
		)
		(return temp5)
	)

	(method (advance &tmp theIcon i)
		(for ((= i 1)) (<= i size) ((= i (mod (+ i 1) size)))
			(= theIcon
				(self at: (mod (+ i (self indexOf: highlightedIcon)) size))
			)
			(if (not (IsObject theIcon))
				(= theIcon (NodeValue (self first:)))
			)
			(breakif (not (& (theIcon signal:) $0004)))
		)
		(self highlight: theIcon (& state $0020))
	)

	(method (retreat &tmp theIcon i)
		(for ((= i 1)) (<= i size) ((= i (mod (+ i 1) size)))
			(= theIcon
				(self at: (mod (- (self indexOf: highlightedIcon) i) size))
			)
			(if (not (IsObject theIcon))
				(= theIcon (NodeValue (self last:)))
			)
			(breakif (not (& (theIcon signal:) $0004)))
		)
		(self highlight: theIcon (& state $0020))
	)

	(method (select theIcon relVer)
		(return
			(if (theIcon select: (and (>= argc 2) relVer))
				(if (not (& (theIcon signal:) $0002))
					(= curIcon theIcon)
				)
				1
			)
		)
	)

	(method (highlight theIcon posnCursor &tmp sColor)
		(if (not (& (theIcon signal:) $0004))
			(if (IsObject highlightedIcon)
				(highlightedIcon highlight: 0)
			)
			(= highlightedIcon theIcon)
			(highlightedIcon highlight: 1)
		)
		(if (and (>= argc 2) posnCursor)
			(gGame
				setCursor:
					gTheCursor
					1
					(+
						(theIcon nsLeft:)
						(/ (- (theIcon nsRight:) (theIcon nsLeft:)) 2)
					)
					(- (theIcon nsBottom:) 3)
			)
		)
	)

	(method (advanceCurIcon &tmp theIcon i newIcon)
		(if (& state $0004)
			(return)
		)
		(= theIcon curIcon)
		(= i 0)
		(while
			(&
				((= theIcon (self at: (mod (+ (self indexOf: theIcon) 1) size)))
					signal:
				)
				$0006
			)
			(if (> i (+ 1 size))
				(return)
			else
				(++ i)
			)
		)
		(= curIcon theIcon)
		(gGame setCursor: (curIcon cursor:) 1)
	)

	(method (swapCurIcon &tmp firstIcon)
		(cond
			((& state $0004)
				(return)
			)
			(
				(and
					(!= curIcon (= firstIcon (NodeValue (self first:))))
					(not (& (firstIcon signal:) $0004))
				)
				(= prevIcon curIcon)
				(= curIcon (NodeValue (self first:)))
			)
			((and prevIcon (not (& (prevIcon signal:) $0004)))
				(= curIcon prevIcon)
			)
		)
		(gGame setCursor: (curIcon cursor:) 1)
	)
)

