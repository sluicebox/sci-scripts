;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64937)
(include sci.sh)
(use Main)
(use Print)
(use Cursor)
(use Tutorial)
(use User)
(use Actor)
(use System)

(public
	proc64937_0 0
)

(local
	local0
	local1 = -1
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 (IconBar size:)) ((++ temp0))
		(if (!= temp0 param1)
			(= temp1 (IconBarF at: temp0))
			(temp1 setCel: 2)
			(UpdateScreenItem temp1)
		)
		(= local1 2)
	)
	(FrameOut)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 (IconBar size:)) ((++ temp0))
		(= temp1 (IconBarF at: temp0))
		(temp1 setCel: 0)
		(UpdateScreenItem temp1)
	)
	(FrameOut)
	(= local1 -1)
)

(procedure (localproc_2 param1 &tmp temp0)
	(= temp0 (GetTime))
	(while (< (Abs (- (GetTime) temp0)) param1)
	)
)

(procedure (proc64937_0)
	(IconBarF isUp:)
)

(class IconI of View
	(properties
		signal 1
		type 16384
		message -1
		modifiers 0
		mainView 0
		mainLoop 0
		mainCel 0
		maskView 0
		maskLoop 0
		maskCel 0
		cursorView -1
		cursorLoop -1
		cursorCel -1
		highlightColor 0
		lowlightColor 0
		helpVerb 0
		object 0
		selector 0
	)

	(method (init)
		(= view mainView)
		(= loop mainLoop)
		(= cel mainCel)
		(super init: &rest)
	)

	(method (show iX iY &tmp [temp0 7])
		(|= signal $0020)
		(if argc
			(self posn: iX iY)
			(SetNowSeen self)
		)
		(if (& signal $0004)
			(self mask:)
		else
			(= view mainView)
			(= loop mainLoop)
			(= cel mainCel)
		)
	)

	(method (mask)
		(= view maskView)
		(= loop maskLoop)
		(= cel maskCel)
		(UpdateScreenItem self)
	)

	(method (highlight tOrF &tmp [temp0 5])
		(if (or (not (& signal $0020)) (== highlightColor -1))
			(return)
		)
		(= cel (* 2 (if argc tOrF)))
		(UpdateScreenItem self)
	)

	(method (select relVer &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp5 0)
		(if (!= (= temp3 (IconBar indexOf: self)) -1)
			(= temp4 (IconBarF at: temp3))
			(= temp5 1)
		)
		(return
			(cond
				((& signal $0004) 0)
				((and argc relVer (& signal $0001))
					(= temp6 cel)
					(= cel (= temp1 (+ cel 1)))
					(if temp5
						(temp4 setCel: 1)
						(UpdateScreenItem temp4)
					)
					(UpdateScreenItem self)
					(FrameOut)
					(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(temp0 localize: plane)
						(cond
							((self onMe: temp0)
								(if (not (mod temp1 2))
									(if temp5
										(temp4 setCel: 1)
										(UpdateScreenItem temp4)
									)
									(= cel (= temp1 (+ cel 1)))
									(UpdateScreenItem self)
									(FrameOut)
								)
							)
							((mod temp1 2)
								(if temp5
									(temp4 setCel: 0)
									(UpdateScreenItem temp4)
								)
								(= cel (= temp1 (- cel 1)))
								(UpdateScreenItem self)
								(FrameOut)
							)
						)
						(= temp7 0)
						(if (self onMe: temp0)
							(= temp7 1)
						)
						(temp0 dispose:)
					)
					(if
						(and
							temp7
							(!= self (ScriptID 14 1)) ; iconBGMusic
							(!= self (ScriptID 1115 0)) ; iconBGMusicF
						)
						(proc0_12 901)
					)
					(temp0 dispose:)
					(if (mod temp1 2)
						(-= cel 1)
						(if temp5
							(temp4 setCel: 0)
							(UpdateScreenItem temp4)
						)
						(UpdateScreenItem self)
						(FrameOut)
					)
					(if
						(and
							(= temp2 (gGame script:))
							(temp2 isKindOf: Tutorial)
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
					(mod temp1 2)
				)
				(else
					(if
						(and
							(= temp2 (gGame script:))
							(temp2 isKindOf: Tutorial)
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

	(method (setCursor viewOrObj theLoop theCel)
		(if (== argc 1)
			(= cursorView viewOrObj)
			(= cursorCel (= cursorLoop -1))
		else
			(= cursorView viewOrObj)
			(= cursorLoop theLoop)
			(= cursorCel theCel)
		)
	)

	(method (getCursor)
		(return
			(if (== cursorLoop -1)
				cursorView
			else
				(IconBarCursor initialize: self yourself:)
			)
		)
	)
)

(class IconBar of Set
	(properties
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
		plane 0
		state 1024
		y 0
	)

	(method (init &tmp [obj 2])
		(if (not plane)
			(= plane (gSystemPlane new:))
		)
		(plane back: 0 picture: -2 priority: -1 init: 0 0 200 100 addCast: self)
		(self eachElementDo: #init self)
		(plane setSize:)
		(plane priority: 1)
	)

	(method (dispose)
		(plane deleteCast: self)
		(if plane
			(plane dispose:)
		)
		(= plane 0)
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

	(method (noClickHelp &tmp event lastIcon thisIcon dlg)
		(= lastIcon (= thisIcon (= dlg 0)))
		(while (not ((= event ((gUser curEvent:) new:)) type:))
			(event localize: plane)
			(cond
				((= thisIcon (self firstTrue: #onMe event))
					(if (and (!= thisIcon lastIcon) (thisIcon helpVerb:))
						(= lastIcon thisIcon)
						(if dlg
							(dlg dispose:)
							(= dlg 0)
							(FrameOut)
						)
						(Print
							font: gUserFont
							back: 255
							width: 250
							addText:
								(thisIcon noun:)
								(thisIcon helpVerb:)
								0
								1
								0
								0
								(if (== (thisIcon modNum:) -1)
									0
								else
									(thisIcon modNum:)
								)
							modeless: 2
							init:
						)
						(= dlg (Print dialog:))
						(FrameOut)
					)
				)
				(dlg
					(dlg dispose:)
					(= dlg 0)
					(FrameOut)
				)
				(else
					(= lastIcon 0)
				)
			)
			(event dispose:)
		)
		(event dispose:)
		(gGame setCursor: gNormalCursor 1)
		(if dlg
			(dlg dispose:)
			(FrameOut)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(if (& state $0020)
			(event localize: plane)
		)
		(= temp1 (event type:))
		(= temp7 (self firstTrue: #onMe event))
		(if (& state $0004)
			(return)
		)
		(cond
			((and temp7 (== (IconBarF isUp:) 0))
				(return)
			)
			(
				(and
					(== temp1 evKEYBOARD)
					(or (== (event message:) KEY_ESCAPE) (== (event message:) KEY_DELETE))
					(IconBarF isUp:)
					(User controls:)
					(!= (gCurRoom number:) 975)
					(!= (gCurRoom number:) 3)
					(not temp7)
				)
				(gGame
					setCursor:
						999
						1
						(+
							(highlightedIcon nsLeft:)
							(/
								(-
									(highlightedIcon nsRight:)
									(highlightedIcon nsLeft:)
								)
								2
							)
						)
						(- (highlightedIcon nsBottom:) 3)
				)
			)
			((and (== temp1 evKEYBOARD) (== (event message:) KEY_TAB) temp7)
				(self advance:)
			)
			((and (== temp1 evKEYBOARD) (== (event message:) KEY_RETURN) temp7)
				(= local0 1)
				(self dispatchEvent: event)
				(= local0 0)
			)
			((and (not (gUser canControl:)) (> (event y:) 419))
				(cond
					(temp7
						(if (!= gTheCursor 999)
							(gGame setCursor: 999 1)
						)
					)
					((!= gTheCursor 997)
						(gGame setCursor: 997 1)
					)
				)
			)
			(
				(and
					(not (gUser canControl:))
					(< (event y:) 419)
					(!= gTheCursor 997)
				)
				(gGame setCursor: 997 1)
			)
		)
		(if (or (!= temp1 evMOUSEBUTTON) (and (== temp1 evMOUSEBUTTON) (not temp7) (> (event y:) 419)))
			(return)
		)
		(cond
			((& state $0004))
			(
				(and
					(self firstTrue: #onMe event)
					(or
						(and
							(not temp1)
							(& state $0400)
							(self shouldOpen: event)
							(not (= temp0 0))
						)
						(and
							(== temp1 evKEYBOARD)
							(or
								(== (event message:) KEY_RETURN)
								(== (event message:) KEY_DELETE)
							)
							(= temp0 1)
						)
						(== temp1 evMOUSEBUTTON)
					)
				)
				(= oldMouseX (event x:))
				(= oldMouseY (event y:))
				(= temp4 gTheCursor)
				(= temp5 curIcon)
				(= temp6 curInvIcon)
				(self show:)
				(if temp0
					(gGame
						setCursor:
							gTheCursor
							1
							(+
								(curIcon nsLeft:)
								(/ (- (curIcon nsRight:) (curIcon nsLeft:)) 2)
							)
							(- (curIcon nsBottom:) 3)
					)
				)
				(self doit: event)
				(= temp3
					(if (or (gUser canControl:) (gUser canInput:))
						(self getCursor:)
					else
						gWaitCursor
					)
				)
				(if temp0
					(gGame setCursor: temp3 1 oldMouseX oldMouseY)
				else
					(gGame
						setCursor:
							temp3
							1
							((event new:) x:)
							(Max (event y:) (+ 1 (plane top:)))
					)
				)
				(if (== temp3 gWaitCursor)
					(gGame setCursor: 997)
				)
			)
			((& temp1 evKEYBOARD)
				(switch (event message:)
					(KEY_RETURN
						(cond
							((not curIcon))
							((or (!= curIcon useIconItem) curInvIcon)
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
							(else
								(event type: evNULL)
							)
						)
					)
					(KEY_INSERT
						(if (gUser canControl:)
							(self swapCurIcon:)
						)
						(event claimed: 1)
					)
					(JOY_NULL
						(if (& (event type:) $0010) ; direction
							(self advanceCurIcon:)
							(event claimed: 1)
						)
					)
				)
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
					(curIcon
						(event
							type: (| (event type:) (curIcon type:))
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

	(method (disable theIconNumber &tmp i)
		(if argc
			(for ((= i 0)) (< i argc) ((++ i))
				(= [theIconNumber i] (self at: [theIconNumber i]))
			)
			(self disableIcon: theIconNumber &rest)
		else
			(self disableIcon:)
		)
	)

	(method (disableIcon theIcon &tmp i thisIcon)
		(if argc
			(for ((= i 0)) (< i argc) ((++ i))
				(= thisIcon [theIcon i])
				(thisIcon signal: (| (thisIcon signal:) $0004))
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
		)
	)

	(method (enable theIconNumber &tmp i)
		(if argc
			(for ((= i 0)) (< i argc) ((++ i))
				(= [theIconNumber i] (self at: [theIconNumber i]))
			)
			(self enableIcon: theIconNumber &rest)
		else
			(self enableIcon:)
		)
	)

	(method (enableIcon theIcon &tmp i thisIcon)
		(if argc
			(for ((= i 0)) (< i argc) ((++ i))
				(= thisIcon [theIcon i])
				(thisIcon signal: (& (thisIcon signal:) $fffb))
			)
		else
			(&= state $fffb)
		)
	)

	(method (show &tmp [temp0 3] temp3 temp4 temp5 temp6)
		(gSounds pause:)
		(|= state $0020)
		(gGame setCursor: gNormalCursor 1)
		(plane priority: 1)
		(UpdatePlane plane)
		(= temp3 0)
		(= temp4 y)
		(for ((= temp5 (KList 3 elements))) temp5 ((= temp5 nextNode)) ; FirstNode
			(= nextNode (KList 6 temp5)) ; NextNode
			(= temp6 (KList 8 temp5)) ; NodeValue
			(if (<= (temp6 nsRight:) 0)
				(temp6 show: temp3 temp4)
				(= temp3 (temp6 nsRight:))
			else
				(temp6 show:)
			)
		)
		(self highlight: curIcon)
	)

	(method (hide &tmp node obj)
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
			(for ((= node (KList 3 elements))) node ((= node nextNode)) ; FirstNode
				(= nextNode (KList 6 node)) ; NextNode
				(= obj (KList 8 node)) ; NodeValue
				(obj signal: (& (obj signal:) $ffdf))
			)
			(if
				(and
					(not (& state $0800))
					helpIconItem
					(& (helpIconItem signal:) $0010)
				)
				(helpIconItem signal: (& (helpIconItem signal:) $ffef))
			)
			(plane priority: -1)
			(UpdatePlane plane)
		)
	)

	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if argc
			(= temp0 param1)
		else
			(= temp0 ((gUser curEvent:) new:))
		)
		(while (and (& state $0020) temp0)
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
			(if gCuees
				(gCuees eachElementDo: #doit)
			)
			(if (and (= temp4 (gGame script:)) (temp4 isKindOf: Tutorial))
				(temp4 doit:)
			)
			(if (== temp1 32)
				(= temp1 4)
				(= temp2 (if (& temp3 $0003) 27 else 13))
				(= temp3 0)
				(temp0 type: temp1 message: temp2 modifiers: 0)
			)
			(temp0 localize: plane)
			(if
				(and
					(or (== temp1 1) (and (== temp1 4) (== temp2 13)))
					helpIconItem
					(& (helpIconItem signal:) $0010)
				)
				(temp0 type: 24576 message: (helpIconItem message:))
			)
			(MapKeyToDir temp0)
			(breakif (self dispatchEvent: temp0))
			(= temp0 ((gUser curEvent:) new:))
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(= temp1 (event x:))
		(= temp0 (event y:))
		(= temp2 (event type:))
		(= temp3 (event message:))
		(= temp5 (event claimed:))
		(= temp4 (self firstTrue: #onMe event))
		(= temp9 (IconBar indexOf: temp4))
		(= temp10 (IconBar firstTrue: #onMe event))
		(if temp4
			(= temp6 (temp4 signal:))
			(= temp7 (== temp4 helpIconItem))
		)
		(if (& temp2 $0010) ; direction
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
						((self shouldClose: event)
							(if
								(and
									(& state $0400)
									(or
										(not helpIconItem)
										(not (& (helpIconItem signal:) $0010))
									)
								)
								(= oldMouseY 419)
								(= temp5 1)
							)
						)
						((and temp4 (!= temp4 highlightedIcon))
							(= oldMouseY 419)
							(self highlight: temp4)
						)
					)
				)
				(evMOUSEBUTTON
					(if (and temp4 (self select: temp4 1))
						(if (and temp7 (not temp10))
							(gGame setCursor: (temp4 getCursor:) 1)
							(if (& state $0800)
								(self noClickHelp:)
							else
								(helpIconItem
									signal: (| (helpIconItem signal:) $0010)
								)
							)
						else
							(= temp5 (& temp6 $0040))
						)
						(if (temp4 object:)
							(gGame
								panelObj: (temp4 object:)
								panelSelector: (temp4 selector:)
							)
						)
						(if temp10
							(localproc_0 temp9)
						)
						(temp4 doit: event)
						(if temp10
							(localproc_1)
						)
					)
				)
				(evKEYBOARD
					(switch temp3
						(KEY_ESCAPE
							(= temp5 1)
						)
						(KEY_DELETE
							(= temp5 1)
						)
						(KEY_RETURN
							(if (not temp4)
								(= temp4 highlightedIcon)
							)
							(cond
								(
									(and
										temp4
										(== temp4 helpIconItem)
										(not temp10)
									)
									(gGame setCursor: 995)
									(if helpIconItem
										(helpIconItem
											signal:
												(| (helpIconItem signal:) $0010)
										)
									)
								)
								((and temp4 (self select: temp4))
									(if (temp4 object:)
										(gGame
											panelObj: (temp4 object:)
											panelSelector: (temp4 selector:)
										)
									)
									(if
										(and
											(!= temp9 -1)
											temp10
											(not (& (IconBar state:) $0004))
										)
										((IconBarF at: temp9) setCel: 1)
										(UpdateScreenItem (IconBarF at: temp9))
										(FrameOut)
										(localproc_2 15)
										(localproc_0 temp9)
										((IconBarF at: temp9) setCel: 0)
										(UpdateScreenItem (IconBarF at: temp9))
										(FrameOut)
									else
										((self at: (self indexOf: temp4))
											setCel: (+ (temp4 cel:) 1)
										)
										(UpdateScreenItem temp4)
										(FrameOut)
										(localproc_2 15)
										((self at: (self indexOf: temp4))
											setCel: (- (temp4 cel:) 1)
										)
										(UpdateScreenItem temp4)
										(FrameOut)
									)
									(temp4 doit: event)
									(if temp10
										(localproc_1)
									)
									(= temp5 (& temp6 $0040))
								)
							)
						)
						(KEY_SHIFTTAB
							(self retreat:)
						)
						(KEY_TAB
							(self advance:)
						)
					)
				)
				($6000 ; evVERB | evHELP
					(if (and temp4 (temp4 helpVerb:))
						(Print
							font: gUserFont
							back: -1
							fore: 0
							mode: 0
							margin: 13
							addBitmap: 917 0 0
							addText:
								(temp4 noun:)
								(temp4 helpVerb:)
								0
								1
								0
								0
								(temp4 modNum:)
							init:
						)
						(if (not (HaveMouse))
							(gGame setCursor: temp8) ; UNINIT
						)
					)
					(if helpIconItem
						(helpIconItem signal: (& (helpIconItem signal:) $ffef))
					)
					(gGame setCursor: gNormalCursor)
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
			(breakif (not (& (theIcon signal:) $0004)))
		)
		(self highlight: theIcon (& state $0020))
	)

	(method (retreat &tmp theIcon i)
		(for ((= i 1)) (<= i size) ((= i (mod (+ i 1) size)))
			(= theIcon
				(self at: (mod (- (self indexOf: highlightedIcon) i) size))
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
			(if highlightedIcon
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
						((theIcon plane:) left:)
					)
					(+ (- (theIcon nsBottom:) 3) ((theIcon plane:) top:))
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
		(gGame setCursor: (self getCursor:))
	)

	(method (swapCurIcon &tmp firstIcon)
		(cond
			((& state $0004)
				(return)
			)
			(
				(and
					(!= curIcon (= firstIcon (KList 8 (self first:)))) ; NodeValue
					(not (& (firstIcon signal:) $0004))
				)
				(= prevIcon curIcon)
				(= curIcon (KList 8 (self first:))) ; NodeValue
			)
			((and prevIcon (not (& (prevIcon signal:) $0004)))
				(= curIcon prevIcon)
			)
		)
		(gGame setCursor: (self getCursor:))
	)

	(method (shouldOpen event)
		(return
			(or
				(and (== (event type:) 0) (>= (event y:) 419))
				(and
					(== (event type:) 4)
					(OneOf (event message:) 27 21248)
				)
			)
		)
	)

	(method (shouldClose event)
		(return
			(or
				(and (== (event type:) 0) (< (event y:) 419))
				(and
					(== (event type:) 4)
					(OneOf (event message:) 27 21248)
				)
			)
		)
	)

	(method (getCursor)
		(return
			(if curIcon
				(curIcon getCursor:)
			else
				gNormalCursor
			)
		)
	)
)

(class IconBarCursor of Cursor
	(properties)

	(method (initialize theIcon)
		(= view (theIcon cursorView:))
		(= loop (theIcon cursorLoop:))
		(= cel (theIcon cursorCel:))
	)
)

(class IconBarF of Set
	(properties
		isUp 0
	)

	(method (init)
		(self
			add:
				(ScriptID 12 6) ; gameControlIconF
				(ScriptID 12 7) ; optionsIconF
				(ScriptID 12 8) ; scoreIconF
				(ScriptID 12 9) ; rulesIconF
				(ScriptID 12 10) ; moodIconF
				(ScriptID 12 11) ; quitIconF
		)
		(self eachElementDo: #init)
		(self eachElementDo: #setPri 1)
		(= isUp 1)
	)

	(method (dispose)
		(= isUp 0)
		(self release:)
		(super dispose:)
	)

	(method (enable)
		(= isUp 1)
	)

	(method (disable)
		(= isUp 0)
	)

	(method (darken &tmp temp0)
		(self eachElementDo: #cel 2)
		(if (== local1 2)
			((self at: 2) cel: 0)
		)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(UpdateScreenItem (self at: temp0))
			(FrameOut)
		)
		(= local1 -1)
	)

	(method (lighten &tmp temp0)
		(self eachElementDo: #cel 0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(UpdateScreenItem (self at: temp0))
			(FrameOut)
		)
		(= local1 -1)
	)
)

