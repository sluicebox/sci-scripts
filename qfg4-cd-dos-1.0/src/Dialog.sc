;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64922)
(include sci.sh)
(use Main)
(use Array)
(use System)

(class Dialog of Set
	(properties
		text 0
		font 0
		theItem 0
		nsLeft 0
		nsTop 0
		nsRight 0
		nsBottom 0
		ticks 0
		caller 0
		plane 0
		eatTheMice 0
		lastTicks 0
		mouseHiliting 0
		margin 4
		modeless 0
		onScreen 0
	)

	(method (init pri &tmp p)
		(= p
			(if argc
				pri
			else
				(+ (GetHighPlanePri) 1)
			)
		)
		(plane
			priority: p
			init: nsLeft nsTop nsRight nsBottom
			addCast: self
		)
		(if ticks
			(+= ticks (+ (GetTime) gTickOffset))
		)
		(self eachElementDo: #init self)
	)

	(method (doit def &tmp event ret done checked)
		(= gGameTime (+ gTickOffset (GetTime)))
		(= done 0)
		(if theItem
			(theItem hilite: 0)
		)
		(= theItem
			(if (and argc def)
				def
			else
				(self firstTrue: #checkState 1)
			)
		)
		(FrameOut)
		(if theItem
			(theItem hilite: 1)
		)
		(if (not theItem)
			(= eatTheMice gEatMice)
			(= lastTicks (GetTime))
		else
			(= eatTheMice 0)
		)
		(= ret 0)
		(while (not ret)
			(= gGameTime (+ gTickOffset (GetTime)))
			(self eachElementDo: #cycle)
			(= event ((Event new:) localize: plane))
			(if eatTheMice
				(-- eatTheMice)
				(if (== (event type:) 1)
					(event type: 0)
				)
				(while (== lastTicks (GetTime))
				)
				(= lastTicks (GetTime))
			)
			(if mouseHiliting
				(self eachElementDo: #perform checkHiliteCode self event)
			)
			(if (event type:)
				(= ret (self handleEvent: event))
			)
			(event dispose:)
			(if (or (= checked (self check:)) (!= modeless 0))
				(if (and checked (!= modeless 0))
					(self dispose:)
				)
				(break)
			)
			(FrameOut)
		)
		(return ret)
	)

	(method (check)
		(if ticks
			(return (> (- gGameTime ticks) 0))
		)
	)

	(method (dispose &tmp theCaller)
		(self eachElementDo: #dispose release:)
		(plane deleteCast: self)
		(= theItem 0)
		(= theCaller caller)
		(super dispose:)
		(if theCaller
			(theCaller cue:)
		)
	)

	(method (advance &tmp obj node)
		(if theItem
			(theItem hilite: 0)
			(= node (self contains: theItem))
			(repeat
				(if (not (= node (self next: node)))
					(= node (self first:))
				)
				(= theItem (NodeValue node))
				(if (& (theItem state:) $0001)
					(break)
				)
			)
			(theItem hilite: 1)
			(if (not (HaveMouse))
				(gGlory
					setCursor:
						gTheCursor
						1
						(+
							(theItem nsLeft:)
							(/ (- (theItem nsRight:) (theItem nsLeft:)) 2)
						)
						(- (theItem nsBottom:) 3)
				)
			)
		)
	)

	(method (retreat &tmp obj node)
		(if theItem
			(theItem hilite: 0)
			(= node (self contains: theItem))
			(repeat
				(if (not (= node (self prev: node)))
					(= node (self last:))
				)
				(= theItem (NodeValue node))
				(if (& (theItem state:) $0001)
					(break)
				)
			)
			(theItem hilite: 1)
			(if (not (HaveMouse))
				(gGlory
					setCursor:
						gTheCursor
						1
						(+
							(theItem nsLeft:)
							(/ (- (theItem nsRight:) (theItem nsLeft:)) 2)
						)
						(- (theItem nsBottom:) 3)
				)
			)
		)
	)

	(method (handleEvent event &tmp ret eType eMsg)
		(if (& (event type:) $0010) ; direction
			(switch (event message:)
				(JOY_DOWN
					(event type: evKEYBOARD message: KEY_DOWN)
				)
				(JOY_UP
					(event type: evKEYBOARD message: KEY_UP)
				)
				(JOY_LEFT
					(event type: evKEYBOARD message: KEY_LEFT)
				)
				(JOY_RIGHT
					(event type: evKEYBOARD message: KEY_RIGHT)
				)
			)
		)
		(= eType (event type:))
		(= eMsg (event message:))
		(if (= ret (self firstTrue: #handleEvent event))
			(if (not (ret checkState: 2))
				(if theItem
					(theItem hilite: 0)
				)
				((= theItem ret) hilite: 1)
				(ret doit:)
				(= ret 0)
			else
				(return ret)
			)
		else
			(= eType (event type:))
			(= eMsg (event message:))
			(= ret 0)
			(cond
				(
					(and
						(or (== eType $0020) (and (== eType evKEYBOARD) (== eMsg KEY_RETURN))) ; joyUp
						theItem
						(theItem checkState: 1)
					)
					(= ret theItem)
					(event claimed: 1)
				)
				((and (== eType evKEYBOARD) (== eMsg KEY_ESCAPE))
					(event claimed: 1)
					(= ret -1)
				)
				(
					(and
						(not (self firstTrue: #checkState 1))
						(or
							(and (== eType evKEYBOARD) (== eMsg KEY_RETURN))
							(OneOf eType evMOUSEBUTTON $0020) ; joyUp
						)
					)
					(event claimed: 1)
					(= ret -2)
				)
				((and (== eType evKEYBOARD) (OneOf eMsg KEY_TAB KEY_RIGHT KEY_DOWN))
					(event claimed: 1)
					(self advance:)
				)
				((and (== eType evKEYBOARD) (OneOf eMsg KEY_SHIFTTAB KEY_LEFT KEY_UP))
					(event claimed: 1)
					(self retreat:)
				)
			)
		)
		(return ret)
	)

	(method (move h v)
		(+= nsLeft h)
		(+= nsTop v)
		(+= nsRight h)
		(+= nsBottom v)
		(if onScreen
			(if (< nsLeft 0)
				(+= nsRight (- 0 nsLeft))
				(= nsLeft 0)
			)
			(if (> nsRight 320)
				(+= nsLeft (- 320 nsRight))
				(= nsRight 320)
			)
			(if (< nsTop 0)
				(+= nsBottom (- 0 nsTop))
				(= nsTop 0)
			)
			(if (> nsBottom 200)
				(+= nsTop (- 200 nsBottom))
				(= nsBottom 200)
			)
		)
		(if plane
			(plane setRect: nsLeft nsTop nsRight nsBottom 1)
		)
	)

	(method (moveTo h v)
		(self move: (- h nsLeft) (- v nsTop))
	)

	(method (center onPlane &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6)
		(cond
			(argc
				(= temp2 (onPlane left:))
				(= temp3 (onPlane top:))
				(= temp4 (onPlane right:))
				(= temp5 (onPlane bottom:))
			)
			((or (not gCurRoom) (not (gCurRoom plane:)))
				(= temp2 (gThePlane left:))
				(= temp3 (gThePlane top:))
				(= temp4 (gThePlane right:))
				(= temp5 (gThePlane bottom:))
			)
			((= temp6 (gCurRoom plane:))
				(= temp2 (temp6 left:))
				(= temp3 (temp6 top:))
				(= temp4 (temp6 right:))
				(= temp5 (temp6 bottom:))
			)
			(else
				(return)
			)
		)
		(self
			moveTo:
				(+ temp2 (/ (- (- temp4 temp2) (- nsRight nsLeft)) 2))
				(+ temp3 (/ (- (- temp5 temp3) (- nsBottom nsTop)) 2))
		)
	)

	(method (setSize &tmp node obj r)
		(= r (IntArray with: 0 0 0 0))
		(if text
			(TextSize (r data:) text font 0)
			(= nsLeft (r at: 0))
			(= nsTop (r at: 1))
			(= nsRight (r at: 2))
			(= nsBottom (r at: 3))
		else
			(= nsBottom (= nsRight (= nsTop (= nsLeft 0))))
		)
		(r dispose:)
		(for ((= node (self first:))) node ((= node (self next: node)))
			(= obj (NodeValue node))
			(if (< (obj nsLeft:) nsLeft)
				(= nsLeft (obj nsLeft:))
			)
			(if (< (obj nsTop:) nsTop)
				(= nsTop (obj nsTop:))
			)
			(if (> (obj nsRight:) nsRight)
				(= nsRight (obj nsRight:))
			)
			(if (> (obj nsBottom:) nsBottom)
				(= nsBottom (obj nsBottom:))
			)
		)
		(+= nsRight margin)
		(+= nsBottom margin)
		(if plane
			(plane setRect: nsLeft nsTop nsRight nsBottom)
		)
	)
)

(instance checkHiliteCode of Code
	(properties)

	(method (doit who dlg event)
		(if
			(and
				(& (who state:) $0001)
				(who onMe: event)
				(not (& (who state:) $0008))
			)
			((dlg theItem:) hilite: 0)
			(dlg theItem: who)
			(who hilite: 1)
		)
	)
)

(class Controls of List
	(properties)

	(method (draw)
		(self eachElementDo: #setSize)
		(self eachElementDo: #draw)
	)

	(method (handleEvent event &tmp cont)
		(if (event claimed:)
			(return 0)
		)
		(if
			(and
				(= cont (self firstTrue: #handleEvent event))
				(not (cont checkState: 2))
			)
			(cont doit:)
			(= cont 0)
		)
		(return cont)
	)
)

