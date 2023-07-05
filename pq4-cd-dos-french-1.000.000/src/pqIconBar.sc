;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use TransPlane)
(use Plane)
(use Print)
(use IconBar)
(use Cursor)
(use Tutorial)
(use System)

(public
	pqIconBar 0
	walkCursor 1
	theArrowCursor 2
	theInvisCursor 3
)

(local
	local0
	local1
	local2
	local3
)

(instance walkCursor of Cursor
	(properties
		view 991
	)
)

(instance lookCursor of Cursor
	(properties
		view 992
	)
)

(instance doCursor of Cursor
	(properties
		view 993
	)
)

(instance talkCursor of Cursor
	(properties
		view 994
	)
)

(instance exitCursor of Cursor
	(properties
		view 995
	)
)

(instance theArrowCursor of Cursor
	(properties
		view 999
	)
)

(instance theInvisCursor of Cursor
	(properties
		view 996
	)
)

(instance helpCursor of Cursor
	(properties
		view 989
	)
)

(class PqIconItem of IconI
	(properties
		masker 0
	)

	(method (hide param1)
		(cond
			(param1
				(if (self isNotHidden:)
					(DeleteScreenItem self)
					(if masker
						(masker hide: 1)
					)
					(|= signal $0008)
				)
			)
			((not (self isNotHidden:))
				(AddScreenItem self)
				(if masker
					(masker hide: 0)
				)
				(&= signal $fff7)
			)
		)
	)

	(method (show param1 param2)
		(if (not (self isNotHidden:))
			(if (and (& signal $0004) (not masker))
				((= masker (dudView new:))
					mainView: maskView
					mainLoop: maskLoop
					mainCel: maskCel
					x: x
					y: y
					ignoreActors:
					fixPriority: 1
					priority: (+ priority 10)
					init: pqIconBar
					hide:
				)
			)
			(return)
		)
		(|= signal $0020)
		(if argc
			(self posn: param1 param2)
			(SetNowSeen self)
		)
		(if (& signal $0004)
			(if masker
				(UpdateScreenItem self)
				(UpdateScreenItem masker)
			else
				(self mask:)
			)
		else
			(UpdateScreenItem self)
			(if masker
				(masker dispose:)
				(= masker 0)
			)
		)
	)

	(method (mask)
		((= masker (dudView new:))
			mainView: maskView
			mainLoop: maskLoop
			mainCel: maskCel
			x: x
			y: y
			ignoreActors:
			fixPriority: 1
			priority: (+ priority 10)
			init: pqIconBar
		)
		(UpdateScreenItem self)
		(UpdateScreenItem masker)
	)
)

(instance dudView of IconI
	(properties)

	(method (onMe)
		(return 0)
	)

	(method (hide param1)
		(cond
			(param1
				(if (self isNotHidden:)
					(DeleteScreenItem self)
					(|= signal $0008)
				)
			)
			((not (self isNotHidden:))
				(AddScreenItem self)
				(&= signal $fff7)
			)
		)
	)

	(method (init)
		(self setCursor: gNormalCursor)
		(super init: &rest)
		(|= signal $0006)
	)

	(method (mask))

	(method (show))
)

(instance iconWalk of PqIconItem
	(properties
		noun 10
		modNum 0
		state 16384
		y 167
		priority 300
		fixPriority 1
		type 20480
		message 3
		mainView 981
		maskView 981
		maskLoop 13
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= maskView (= mainView 10981))
			(= y 169)
		)
		(|= signal $0041)
		(self setCursor: walkCursor)
		(= x 0)
		(super init: &rest)
		(self hide: 1)
	)
)

(instance iconLook of PqIconItem
	(properties
		noun 8
		modNum 0
		y 167
		priority 300
		fixPriority 1
		message 1
		mainView 981
		mainLoop 2
		maskView 981
		maskLoop 13
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= maskView (= mainView 10981))
			(= y 169)
		)
		(|= signal $0001)
		(self setCursor: lookCursor)
		(= x
			(-
				(+
					(iconWalk x:)
					(CelWide
						(iconWalk mainView:)
						(iconWalk mainLoop:)
						(iconWalk mainCel:)
					)
				)
				1
			)
		)
		(super init: &rest)
		(self hide: 1)
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconDo of PqIconItem
	(properties
		noun 4
		modNum 0
		y 167
		priority 300
		fixPriority 1
		message 4
		mainView 981
		mainLoop 3
		maskView 981
		maskLoop 13
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= maskView (= mainView 10981))
			(= y 169)
		)
		(|= signal $0001)
		(self setCursor: doCursor)
		(= x
			(-
				(+
					(iconLook x:)
					(CelWide
						(iconLook mainView:)
						(iconLook mainLoop:)
						(iconLook mainCel:)
					)
				)
				1
			)
		)
		(super init: &rest)
		(self hide: 1)
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconTalk of PqIconItem
	(properties
		noun 9
		modNum 0
		y 167
		priority 300
		fixPriority 1
		message 2
		mainView 981
		mainLoop 4
		maskView 981
		maskLoop 13
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= maskView (= mainView 10981))
			(= y 169)
		)
		(|= signal $0001)
		(self setCursor: talkCursor)
		(= x
			(-
				(+
					(iconDo x:)
					(CelWide
						(iconDo mainView:)
						(iconDo mainLoop:)
						(iconDo mainCel:)
					)
				)
				1
			)
		)
		(super init: &rest)
		(self hide: 1)
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconUse of PqIconItem
	(properties
		noun 11
		modNum 0
		y 167
		priority 300
		fixPriority 1
		message 0
		mainView 981
		mainLoop 7
		maskView 981
		maskLoop 13
		cursorView 999
		helpVerb 9
	)

	(method (hide param1)
		(if local2
			(local2 hide: param1)
		)
		(super hide: param1)
	)

	(method (show &tmp temp0)
		(cond
			((= temp0 (gTheIconBar curInvIcon:))
				(if local2
					(if (== local3 temp0)
						(super show:)
						(return)
					else
						(= local3 temp0)
						(local2 dispose:)
					)
				else
					(= local3 temp0)
				)
				(= local2
					((dudView new:)
						mainView: (temp0 view:)
						mainLoop: (temp0 loop:)
						mainCel: (temp0 cel:)
						view: (temp0 view:)
						loop: (temp0 loop:)
						cel: (temp0 cel:)
						x: 0
						y: 0
						init: pqIconBar
						yourself:
					)
				)
				(local2
					x: (+ x (Abs (local2 nsLeft:)) 3)
					y: (+ y (Abs (local2 nsTop:)))
					signal: (| (local2 signal:) $4000)
					fixPriority: 1
					priority: (+ priority 5)
				)
				(if (self isNotHidden:)
					(UpdateScreenItem local2)
				else
					(local2 hide:)
				)
			)
			(local2
				(local2 dispose:)
				(= local2 0)
			)
		)
		(super show:)
	)

	(method (init)
		(if (IsHiRes)
			(= maskView (= mainView 10981))
			(= y 169)
		)
		(|= signal $0041)
		(self setCursor: gNormalCursor)
		(= x
			(-
				(+
					(iconTalk x:)
					(CelWide
						(iconTalk mainView:)
						(iconTalk mainLoop:)
						(iconTalk mainCel:)
					)
				)
				1
			)
		)
		(super init: &rest)
		(self hide: 1)
	)
)

(instance iconInv of PqIconItem
	(properties
		noun 7
		modNum 0
		y 167
		priority 300
		fixPriority 1
		type 0
		message 0
		mainView 981
		mainLoop 5
		maskView 981
		maskLoop 13
		cursorView 999
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= maskView (= mainView 10981))
			(= y 169)
		)
		(|= signal $0003)
		(self setCursor: gNormalCursor)
		(= x
			(-
				(+
					(iconUse x:)
					(CelWide
						(iconUse mainView:)
						(iconUse mainLoop:)
						(iconUse mainCel:)
					)
				)
				1
			)
		)
		(super init: &rest)
		(self hide: 1)
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(if (== gCurRoomNum 230)
				(gInventory showSelf: 230)
			else
				(gEgo showInv:)
			)
			(if (gTheIconBar locked:)
				(gTheIconBar show: 1)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconControl of PqIconItem
	(properties
		noun 3
		modNum 0
		y 167
		priority 300
		fixPriority 1
		message 0
		mainView 981
		mainLoop 6
		maskView 981
		maskLoop 13
		maskCel 2
		cursorView 999
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= maskView (= mainView 10981))
			(= y 169)
		)
		(|= signal $0043)
		(self setCursor: gNormalCursor)
		(= x
			(-
				(+
					(iconMap x:)
					(CelWide
						(iconMap mainView:)
						(iconMap mainLoop:)
						(iconMap mainCel:)
					)
				)
				1
			)
		)
		(super init: &rest)
		(self hide: 1)
	)

	(method (select param1 &tmp temp0 temp1 temp2)
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(= temp1 1)
					(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(temp0 localize: plane)
						(cond
							((self onMe: temp0)
								(if (not temp1)
									(= temp1 1)
								)
							)
							(temp1
								(= temp1 0)
							)
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
					(if (== temp1 1)
						(gTheIconBar state: (| (gTheIconBar state:) $4000) hide:)
						((ScriptID 9) init: show: doit: dispose:) ; pqGameControls
						(gTheIconBar state: (& (gTheIconBar state:) $bfff) show: 0)
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
					temp1
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
)

(instance iconHelp of PqIconItem
	(properties
		noun 6
		modNum 0
		y 167
		priority 300
		fixPriority 1
		message 9
		mainView 981
		mainLoop 8
		maskView 981
		maskCel 1
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= maskView (= mainView 10981))
			(= y 169)
		)
		(|= signal $0003)
		(self setCursor: helpCursor)
		(= x
			(-
				(+
					(iconControl x:)
					(CelWide
						(iconControl mainView:)
						(iconControl mainLoop:)
						(iconControl mainCel:)
					)
				)
				1
			)
		)
		(super init: &rest)
		(self hide: 1)
	)

	(method (mask))
)

(instance iconMap of PqIconItem
	(properties
		noun 15
		modNum 0
		y 167
		priority 300
		fixPriority 1
		message 0
		mainView 981
		mainLoop 9
		maskView 981
		maskLoop 13
		maskCel 1
		cursorView 989
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= maskView (= mainView 10981))
			(= y 169)
		)
		(|= signal $0003)
		(self setCursor: gNormalCursor)
		(= x
			(-
				(+
					(iconInv x:)
					(CelWide
						(iconInv mainView:)
						(iconInv mainLoop:)
						(iconInv mainCel:)
					)
				)
				1
			)
		)
		(super init: &rest)
		(self hide: 1)
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(gCurRoom newRoom: 17) ; MapRoom
			(return 1)
		else
			(return 0)
		)
	)
)

(instance iconToggle of PqIconItem
	(properties
		noun 16
		modNum 0
		y 167
		priority 300
		fixPriority 1
		message 9
		mainView 981
		mainLoop 10
		maskView 981
		maskCel 1
		cursorView 989
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= maskView (= mainView 10981))
		)
		(|= signal $0003)
		(self setCursor: gNormalCursor)
		(= x
			(-
				(+
					(iconHelp x:)
					(CelWide
						(iconHelp mainView:)
						(iconHelp mainLoop:)
						(iconHelp mainCel:)
					)
				)
				2
			)
		)
		(super init: &rest)
		(self hide: 1)
	)

	(method (mask))

	(method (select param1 &tmp temp0 temp1 temp2)
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(temp0 dispose:)
					)
					(if (self onMe: temp0)
						(if cel
							(= cel 0)
							(gTheIconBar locked: 0)
						else
							(= cel 1)
							(gTheIconBar locked: 1)
						)
					)
					(temp0 dispose:)
					(UpdateScreenItem self)
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
							((not temp1) ; UNINIT
								(return 0)
							)
							(else
								(temp2 report:)
								(return 0)
							)
						)
					)
					temp1 ; UNINIT
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
)

(instance narratorBox of IconI
	(properties
		noun 5
		y 153
		priority 250
		fixPriority 1
		message 50
		mainView 981
		mainLoop 14
		maskView 981
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= mainView 10981)
		)
		(|= signal $0047)
		(self setCursor: gNormalCursor)
		(super init: &rest)
	)

	(method (show)
		(UpdateScreenItem self)
	)

	(method (onMe))

	(method (mask))
)

(instance backGround of IconI
	(properties
		noun 5
		y 166
		priority 250
		fixPriority 1
		message 50
		mainView 981
		mainLoop 12
		maskView 981
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= maskView (= mainView 10983))
		)
		(|= signal $0047)
		(self setCursor: gNormalCursor)
		(super init: &rest)
	)

	(method (show)
		(UpdateScreenItem self)
	)

	(method (onMe))

	(method (mask))
)

(instance namePlate of PqIconItem
	(properties
		noun 5
		x 28
		y 172
		priority 300
		fixPriority 1
		message 50
		mainView 981
		mainLoop 11
		maskView 981
		maskLoop 14
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= maskView (= mainView 10983))
		)
		(|= signal $0047)
		(self setCursor: gNormalCursor)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)

	(method (mask))

	(method (show))
)

(instance iconExit of IconI ; UNUSED
	(properties
		noun 5
		priority 300
		message 50
		mainView 981
		mainLoop 15
		maskView 981
		maskLoop 14
		helpVerb 9
	)

	(method (init)
		(if (IsHiRes)
			(= maskView (= mainView 10981))
		)
		(|= signal $0041)
		(self setCursor: exitCursor)
		(super init: &rest)
	)

	(method (select)
		(if (super select: &rest)
			(gTheIconBar hide:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance myPlane of Plane
	(properties
		priority 1
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (> temp1 (if (or local1 (pqIconBar locked:)) 165 else 190)))
	)
)

(class pqIconBar of IconBar
	(properties
		y 153
		locked 0
	)

	(method (init)
		(self
			add:
				iconWalk
				iconLook
				iconDo
				iconTalk
				iconUse
				iconInv
				iconMap
				iconControl
				iconHelp
				iconToggle
				backGround
				namePlate
		)
		(if (IsHiRes)
			(self add: narratorBox)
		)
		(= plane myPlane)
		(super init:)
		(plane priority: 1 setRect: 0 0 319 199)
		(self
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			curIcon: iconWalk
			useIconItem: iconUse
			helpIconItem: iconHelp
			walkIconItem: iconWalk
			disableIcon: iconUse
			enableIcon: iconControl
			state: 3072
		)
	)

	(method (enable)
		(super enable: &rest)
		(self show: 0)
	)

	(method (disable)
		(super disable: &rest)
		(self show: 0)
	)

	(method (show param1 &tmp [temp0 7])
		(if (and argc (not param1))
			(if (and (not (& state $4004)) locked)
				(namePlate hide: 1)
				(iconWalk hide: 0)
				(iconLook hide: 0)
				(iconDo hide: 0)
				(iconTalk hide: 0)
				(iconUse hide: 0)
				(iconInv hide: 0)
				(iconMap hide: 0)
				(iconControl hide: 0)
				(iconHelp hide: 0)
				(iconToggle hide: 0)
			)
			(self eachElementDo: #show)
			(UpdatePlane plane)
			(return)
		)
		(if (& state $0004)
			(return)
		)
		(gSounds pause:)
		(|= state $0020)
		(if (not locked)
			(namePlate hide: 1)
			(iconWalk hide: 0)
			(iconLook hide: 0)
			(iconDo hide: 0)
			(iconTalk hide: 0)
			(iconUse hide: 0)
			(iconInv hide: 0)
			(iconMap hide: 0)
			(iconControl hide: 0)
			(iconHelp hide: 0)
			(iconToggle hide: 0)
		)
		(self eachElementDo: #show)
		(self highlight: curIcon)
		(UpdatePlane plane)
	)

	(method (shouldOpen param1)
		(return
			(or
				(and (== (param1 type:) 0) (plane onMe: param1))
				(and
					(== (param1 type:) 4)
					(OneOf (param1 message:) 27 21248)
				)
			)
		)
	)

	(method (shouldClose param1)
		(return
			(or
				(and (== (param1 type:) 0) (not (plane onMe: param1)))
				(and
					(== (param1 type:) 4)
					(OneOf (param1 message:) 27 21248)
				)
			)
		)
	)

	(method (advanceCurIcon &tmp temp0 temp1 temp2)
		(if (& state $0004)
			(return)
		)
		(= temp0 curIcon)
		(= temp1 0)
		(while
			(or
				(&
					((= temp0 (self at: (mod (+ (self indexOf: temp0) 1) size)))
						signal:
					)
					$0006
				)
				(== temp0 iconHelp)
			)
			(if (> temp1 (+ 1 size))
				(return)
			else
				(++ temp1)
			)
		)
		(= curIcon temp0)
		(gGame setCursor: (self getCursor:))
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp1 (event type:))
		(cond
			((or (& state $0004) (& state $4000)))
			((gTalkers size:))
			(
				(and
					(not temp1)
					(& state $0400)
					(self shouldOpen: event)
					(not (= temp0 0))
				)
				(event claimed: 1)
				(SetCursor -2)
				(= global156 1)
				(= local1 1)
				(= oldMouseX (event x:))
				(= oldMouseY (event y:))
				(= temp4 (gGame setCursor: gTheArrowCursor 1))
				(= temp5 curIcon)
				(= temp6 curInvIcon)
				(self show: 1)
				(self doit:)
				(= local1 0)
				(= temp3
					(if (or (gUser canControl:) (gUser canInput:))
						(curIcon getCursor:)
					else
						gWaitCursor
					)
				)
				(cond
					(temp0
						(gGame setCursor: temp3 1)
					)
					((or (!= curIcon temp5) (!= temp6 curInvIcon))
						(gGame setCursor: temp3 1)
					)
					(else
						(gGame setCursor: temp4 1)
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
					(curIcon
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

	(method (hide &tmp temp0 temp1)
		(if (or (not locked) (& state $4000))
			(namePlate hide: 0)
			(iconWalk hide: 1)
			(iconLook hide: 1)
			(iconDo hide: 1)
			(iconTalk hide: 1)
			(iconUse hide: 1)
			(iconInv hide: 1)
			(iconMap hide: 1)
			(iconControl hide: 1)
			(iconHelp hide: 1)
			(iconToggle hide: 1)
		)
		(if (& state $0020)
			(gSounds pause: 0)
			(&= state $ffdf)
			(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 nextNode))
				(= nextNode (NextNode temp0))
				(= temp1 (NodeValue temp0))
				(temp1 signal: (& (temp1 signal:) $ffdf))
			)
			(if
				(and
					(not (& state $0800))
					helpIconItem
					(& (helpIconItem signal:) $0010)
				)
				(helpIconItem signal: (& (helpIconItem signal:) $ffef))
			)
		)
		(FrameOut)
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

