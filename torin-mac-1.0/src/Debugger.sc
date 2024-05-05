;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64014)
(include sci.sh)
(use Main)
(use EditablePolygon)
(use TPSound)
(use Interface)
(use Str)
(use Array)
(use Print)
(use Polygon)
(use WalkieTalkie)
(use Motion)
(use File)
(use Actor)
(use System)

(public
	Debugger 0
	GetUnsigned 1
)

(local
	dumpFileNum
	polyBitmap
	polyBitmapPlane
	oCurrentObject
	nLastRobot
)

(procedure (GetUnsigned string default &tmp theLine theVal)
	(= theLine (Str new:))
	(if (> argc 1)
		(theLine format: {%hu} default)
	)
	(= theVal
		(if (GetInput theLine 5 string)
			(theLine asInteger:)
		else
			-1
		)
	)
	(theLine dispose:)
	(return theVal)
)

(procedure (PrintView aView &tmp retval xOrg yOrg xLoc yLoc xOff yOff maxChars viewStr viewVal loopStr loopVal celStr celVal xStr xVal yStr yVal priStr priVal headingStr headingVal titleStr scalePercentStr scaleVal saveScaleVal scalerStr)
	(= maxChars 10)
	(= titleStr (Str newWith: 10 {}))
	(= viewStr (Str newWith: maxChars {}))
	(= loopStr (Str newWith: maxChars {}))
	(= celStr (Str newWith: maxChars {}))
	(= xStr (Str newWith: maxChars {}))
	(= yStr (Str newWith: maxChars {}))
	(= headingStr (Str newWith: maxChars {}))
	(= priStr (Str newWith: maxChars {}))
	(= scalePercentStr (Str newWith: maxChars {}))
	(= scalerStr (Str newWith: maxChars {}))
	(titleStr
		format:
			{instance (%hu) %s of %s}
			aView
			((aView -super-:) name:)
			(aView name:)
	)
	(viewStr format: {%hu} (aView view:))
	(loopStr format: {%d} (aView loop:))
	(celStr format: {%d} (aView cel:))
	(xStr format: {%d} (aView x:))
	(yStr format: {%d} (aView y:))
	(priStr format: {%d} (aView priority:))
	(= saveScaleVal (/ (* 100 (aView scaleY:)) 128))
	(scalePercentStr format: {%d} saveScaleVal)
	(= xOff
		(+ (= xLoc (CelWide (aView view:) (aView loop:) (aView cel:))) 50)
	)
	(= yLoc 0)
	(= yOff 12)
	(= xOrg (CelInfo 0 (aView view:) (aView loop:) (aView cel:))) ; GetOrigX
	(= yOrg (CelInfo 1 (aView view:) (aView loop:) (aView cel:))) ; GetOrigY
	(Print
		y: 20
		fore: 235
		back: 227
		skip: 0
		font: gUserFont
		addTitle: titleStr
		addIcon: (aView view:) (aView loop:) (aView cel:) xOrg yOrg
		addText: {view} xLoc yLoc
		addEdit: viewStr maxChars xOff yLoc
		addText: {loop} xLoc (+= yLoc yOff)
		addEdit: loopStr maxChars xOff yLoc
		addText: {cel} xLoc (+= yLoc yOff)
		addEdit: celStr maxChars xOff yLoc
		addText: {x} xLoc (+= yLoc yOff)
		addEdit: xStr maxChars xOff yLoc
		addText: {y} xLoc (+= yLoc yOff)
		addEdit: yStr maxChars xOff yLoc
		addText: {priority} xLoc (+= yLoc yOff)
		addEdit: priStr maxChars xOff yLoc
		addText: {Scale %} xLoc (+= yLoc yOff)
		addEdit: scalePercentStr maxChars xOff yLoc
	)
	(if (aView isKindOf: Actor)
		(headingStr format: {%d} (aView heading:))
		(Print
			addText: {heading} xLoc (+= yLoc yOff)
			addEdit: headingStr maxChars xOff yLoc
		)
		(if (aView scaler:)
			(scalerStr
				format:
					{Scaler %d__%d__%d__%d}
					((aView scaler:) frontSize:)
					((aView scaler:) backSize:)
					((aView scaler:) frontY:)
					((aView scaler:) backY:)
			)
			(Print addText: scalerStr xLoc (+= yLoc yOff))
		else
			(Print addText: {No scaler} xLoc (+= yLoc yOff))
		)
	)
	(if (= retval (Print init:))
		(= viewVal (viewStr asInteger:))
		(= loopVal (loopStr asInteger:))
		(= celVal (celStr asInteger:))
		(= xVal (xStr asInteger:))
		(= yVal (yStr asInteger:))
		(= priVal (priStr asInteger:))
		(= scaleVal (scalePercentStr asInteger:))
		(if (aView isKindOf: Actor)
			(rotateActorTo aView (headingStr asInteger:))
		)
		(aView
			view: viewVal
			setLoop: loopVal
			setCel: celVal
			posn: xVal yVal
			setPri: priVal
		)
		(if (!= scaleVal saveScaleVal)
			(aView setScalePercent: scaleVal)
		)
	)
	(titleStr dispose:)
	(viewStr dispose:)
	(loopStr dispose:)
	(celStr dispose:)
	(xStr dispose:)
	(yStr dispose:)
	(headingStr dispose:)
	(priStr dispose:)
	(scalePercentStr dispose:)
	(scalerStr dispose:)
	(return retval)
)

(procedure (blinkView aView &tmp i)
	(DeleteScreenItem aView)
	(FrameOut)
	(for ((= i 250)) i ((-- i))
		(cond
			((== 50 i)
				(DeleteScreenItem aView)
			)
			((== 100 i)
				(AddScreenItem aView)
			)
			((== 150 i)
				(DeleteScreenItem aView)
			)
			((== 200 i)
				(AddScreenItem aView)
			)
		)
		(FrameOut)
	)
	(AddScreenItem aView)
	(FrameOut)
)

(procedure (getCurrent aList aType px py)
	(if
		(and
			(or (not oCurrentObject) (not (oCurrentObject isKindOf: aType)))
			(= oCurrentObject (findClosest aList aType px py))
		)
		(blinkView oCurrentObject)
	)
	(return oCurrentObject)
)

(procedure (findClosest aList aType px py &tmp curObj closestItem closestDistance distance i)
	(= closestDistance 32764)
	(= closestItem 0)
	(for ((= i (aList first:))) i ((= i (aList next: i)))
		(= curObj (KList 8 i)) ; NodeValue
		(if
			(and
				(curObj isKindOf: aType)
				(<
					(= distance (GetDistance px py (curObj x:) (curObj y:)))
					closestDistance
				)
			)
			(= closestItem curObj)
			(= closestDistance distance)
		)
	)
	(return closestItem)
)

(procedure (rotateActor anActor angle &tmp newAngle)
	(for ((= newAngle (+ angle (anActor heading:)))) (> newAngle 360) ((-= newAngle 360))
	)
	(while (< newAngle 0)
		(+= newAngle 360)
	)
	(anActor setHeading: newAngle)
)

(procedure (rotateActorTo anActor angle &tmp newAngle)
	(for ((= newAngle angle)) (> newAngle 360) ((-= newAngle 360))
	)
	(while (< newAngle 0)
		(+= newAngle 360)
	)
	(anActor setHeading: newAngle)
)

(procedure (useEventOnPlane event &tmp curNode aPlane evtPlane)
	(FrameOut)
	(= evtPlane gThePlane)
	(for
		((= curNode (gPlanes next: (gPlanes first:))))
		curNode
		((= curNode (gPlanes next: curNode)))
		
		(= aPlane (KList 8 curNode)) ; NodeValue
		(if (aPlane onMe: event)
			(= evtPlane aPlane)
			(break)
		)
	)
	(event localize: evtPlane)
	(event claimed: 1)
	(return evtPlane)
)

(instance debugSound of TPSound
	(properties)
)

(class Debugger of Code
	(properties)

	(method (dispose)
		(if polyBitmap
			(DeletePolygon polyBitmap polyBitmapPlane)
			(= polyBitmap 0)
		)
		(gOEventHandler unregisterGlobalHandler: self)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(gOEventHandler registerGlobalHandler: self)
		(= polyBitmap 0)
	)

	(method (handleEvent event &tmp tmpX tmpY evt obj i t str num node nextNode p curObj smallX largeX smallY largeY curInv curHigh curWide cnt highest theItem aView eventPlane celTmp loopTmp)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(KEY_QUESTION
						(event claimed: 1)
						(Prints
							{ ALT-Drag - drag&scale cast member around screen\nCTRL-LShft-Click - make nearest cast member current\nCTRL-Click - mouse coordinates\nCTRL-Arrow - move current view 1 pixel\n_ALT-A_____- add animation/view\n_ALT-B_____- caputure BMP\n_ALT-C_____- show Cast info\n_ALT-D_____- show current view info\n_ALT-E_____- show Ego\n_ALT-F_____- edit Features\n_ALT-G_____- show/set/clear Flag\n_ALT-H_____- show features and obstacles\n_ALT-I_____- get Inventory Item\n_ALT-J_____- load a pic\n_ALT-K_____- blinK current view\n_ALT-L_____- error logging\n_ALT-P_____- edit Polygons\n_ALT-R_____- show Room info\n_ALT-S_____- scaler tool on current actor\n_ALT-T_____- teleport\n_ALT-U_____- handsOn\n_ALT-X_____- exit the Game\n_ALT-Y_____- show room polygons\nDELETE_____- delete current object\n8__________- Rotate current (actor) right\n2__________- Rotate current (actor) left\n4__________- Decrease current (prop) cel\n6__________- Increase current (prop) cel\n1__________- Decrease current (prop) loop\n3__________- Increase current (prop) loop\nCTRL-G_____- Give ego necessary items for room\nCTRL-R_____- Play a robot\nCTRL-D_____- test a sounD\n}
						)
					)
					(KEY_DELETE
						(= eventPlane (useEventOnPlane event))
						(if
							(not
								(= theItem
									(getCurrent
										(eventPlane getMainCast:)
										Actor
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(if (not (KString 7 (theItem name:) {temp})) ; StrCmp
							(theItem dispose:)
							(= oCurrentObject 0)
						)
					)
					(KEY_2
						(= eventPlane (useEventOnPlane event))
						(if
							(not
								(= theItem
									(getCurrent
										(eventPlane getMainCast:)
										Actor
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(rotateActor theItem 45)
						(UpdateScreenItem theItem)
					)
					(KEY_8
						(= eventPlane (useEventOnPlane event))
						(if
							(not
								(= theItem
									(getCurrent
										(eventPlane getMainCast:)
										Actor
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(rotateActor theItem -45)
						(UpdateScreenItem theItem)
					)
					(KEY_6
						(= eventPlane (useEventOnPlane event))
						(if
							(not
								(= theItem
									(getCurrent
										(eventPlane getMainCast:)
										Prop
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(= celTmp (theItem cel:))
						(if (< (theItem cel:) (theItem lastCel:))
							(theItem cel: (+ (theItem cel:) 1))
						else
							(theItem cel: 0)
						)
						(PrintDebug {Cur Cel: %d} (theItem cel:))
						(UpdateScreenItem theItem)
					)
					(KEY_4
						(= eventPlane (useEventOnPlane event))
						(if
							(not
								(= theItem
									(getCurrent
										(eventPlane getMainCast:)
										Prop
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(= celTmp (theItem cel:))
						(if (> (theItem cel:) 0)
							(theItem cel: (- (theItem cel:) 1))
						else
							(theItem cel: (theItem lastCel:))
						)
						(PrintDebug {Cur Cel: %d} (theItem cel:))
						(UpdateScreenItem theItem)
					)
					(KEY_3
						(= eventPlane (useEventOnPlane event))
						(if
							(not
								(= theItem
									(getCurrent
										(eventPlane getMainCast:)
										Prop
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(= loopTmp (theItem loop:))
						(if (< (theItem loop:) (theItem lastLoop:))
							(theItem loop: (+ (theItem loop:) 1))
						else
							(theItem loop: 0)
						)
						(PrintDebug {Cur Loop: %d} (theItem loop:))
						(UpdateScreenItem theItem)
					)
					(KEY_1
						(= eventPlane (useEventOnPlane event))
						(if
							(not
								(= theItem
									(getCurrent
										(eventPlane getMainCast:)
										Prop
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(= loopTmp (theItem loop:))
						(if (> (theItem loop:) 0)
							(theItem loop: (- (theItem loop:) 1))
						else
							(theItem loop: (theItem lastLoop:))
						)
						(PrintDebug {Cur Loop: %d} (theItem loop:))
						(UpdateScreenItem theItem)
					)
					(KEY_LEFT
						(if (!= (event modifiers:) emCTRL)
							(return)
						)
						(= eventPlane (useEventOnPlane event))
						(if
							(not
								(= theItem
									(getCurrent
										(eventPlane getMainCast:)
										View
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(theItem posn: (- (theItem x:) 1) (theItem y:))
						(PrintDebug {CurPos: %d, %d} (theItem x:) (theItem y:))
						(UpdateScreenItem theItem)
					)
					(KEY_RIGHT
						(if (!= (event modifiers:) emCTRL)
							(return)
						)
						(= eventPlane (useEventOnPlane event))
						(if
							(not
								(= theItem
									(getCurrent
										(eventPlane getMainCast:)
										View
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(theItem posn: (+ (theItem x:) 1) (theItem y:))
						(PrintDebug {CurPos: %d, %d} (theItem x:) (theItem y:))
						(UpdateScreenItem theItem)
					)
					(KEY_UP
						(if (!= (event modifiers:) emCTRL)
							(return)
						)
						(= eventPlane (useEventOnPlane event))
						(if
							(not
								(= theItem
									(getCurrent
										(eventPlane getMainCast:)
										View
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(theItem posn: (theItem x:) (- (theItem y:) 1))
						(PrintDebug {CurPos: %d, %d} (theItem x:) (theItem y:))
						(UpdateScreenItem theItem)
					)
					(KEY_DOWN
						(if (!= (event modifiers:) emCTRL)
							(return)
						)
						(= eventPlane (useEventOnPlane event))
						(if
							(not
								(= theItem
									(getCurrent
										(eventPlane getMainCast:)
										View
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(theItem posn: (theItem x:) (+ (theItem y:) 1))
						(PrintDebug {CurPos: %d, %d} (theItem x:) (theItem y:))
						(UpdateScreenItem theItem)
					)
					(KEY_ALT_a
						(= eventPlane (useEventOnPlane event))
						(if
							(and
								(= num (GetUnsigned {View #?}))
								(ResCheck rsVIEW num)
							)
							((= aView (Actor new:))
								name: {temp}
								x: (event x:)
								y: (event y:)
								view: num
								setCel: 0
								setLoop: 0
								cycleSpeed: (gEgo cycleSpeed:)
								moveSpeed: (gEgo moveSpeed:)
								scaleX: 0
								scaleY: 0
								scaleSignal: 0
								setScale: 0
								priority: 110
								fixPriority: 0
								setCycle: Walk
								init: eventPlane
							)
							(= oCurrentObject aView)
							(UpdateScreenItem aView)
							(FrameOut)
						else
							(Prints {That is not a valid view.})
						)
					)
					(KEY_ALT_b
						(= eventPlane (useEventOnPlane event))
						(while
							(and
								(< dumpFileNum 999)
								(= t (Str format: {TP%03d.BMP} dumpFileNum))
								(FileIO fiEXISTS (t data:))
							)
							(++ dumpFileNum)
						)
						(if (< dumpFileNum 999)
							(SaveScreen (t data:))
							(Printf {Screen saved as\n___%s} (t data:))
						else
							(Prints
								{Sorry, no can do. How did you get so many files?}
							)
						)
					)
					(KEY_ALT_c
						(= eventPlane (useEventOnPlane event))
						(if ((eventPlane getMainCast:) size:)
							(for
								((= i ((eventPlane getMainCast:) first:)))
								i
								((= i ((eventPlane getMainCast:) next: i)))
								
								(= obj (KList 8 i)) ; NodeValue
								(if (not (PrintView obj))
									(break)
								)
							)
						else
							(Prints {No One Home!})
							(return)
						)
					)
					(KEY_ALT_d
						(= eventPlane (useEventOnPlane event))
						(if
							(not
								(= theItem
									(getCurrent
										(eventPlane getMainCast:)
										View
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(PrintView theItem)
					)
					(KEY_ALT_e
						(= eventPlane (useEventOnPlane event))
						(if
							((eventPlane getMainCast:)
								contains: (gUser alterEgo:)
							)
							(PrintView (gUser alterEgo:))
						else
							(Prints {no ego!})
							(return)
						)
					)
					(KEY_ALT_f
						(= eventPlane (useEventOnPlane event))
						(if (not (gFeatures size:))
							(PEditor init: 1 eventPlane)
						else
							(PEditor init: 0 eventPlane)
						)
						(for
							((= i 0))
							(< i (gFeatures size:))
							((++ i))
							
							(= obj (gFeatures at: i))
							(if (obj onMeCheck:)
								(if ((obj onMeCheck:) isKindOf: List)
									(for
										((= p 0))
										(< p ((obj onMeCheck:) size:))
										((++ p))
										
										(= node
											((obj onMeCheck:) at: p)
										)
										(PEditor addPolygon: node)
									)
								else
									(PEditor addPolygon: (obj onMeCheck:))
								)
								((PEditor at: (- (PEditor size:) 1))
									name: (obj name:)
								)
							)
						)
						(PEditor show: 1 scratch: 1)
						(FrameOut)
						(PEditor doit:)
						(= obj (Str new: 33))
						(= curObj (Str new: 33))
						(curObj format: {%hu.fea} gCurRoomNum)
						(Print
							addTitle: {Output File Name:}
							addEdit: obj 12 0 0 curObj
							init:
						)
						(FrameOut)
						(poly_pol name: (obj data:) open: 0)
						(poly_pol
							writeString: {;***************************\0d\n}
						)
						(= str 0)
						(if (PEditor size:)
							(= str (Str newWith: 5 {}))
							(for
								((= node (KList 3 (PEditor elements:)))) ; FirstNode
								node
								((= node nextNode))
								
								(= nextNode (KList 6 node)) ; NextNode
								(= curObj (KList 8 node)) ; NodeValue
								(poly_pol writeString: {\0d\n})
								(poly_pol writeString: {(instance })
								(poly_pol writeString: (curObj name:))
								(poly_pol writeString: { of Feature\0d\n})
								(poly_pol writeString: {\t(properties\0d\n})
								(poly_pol writeString: {\t\tx})
								(= smallX (= smallY 32767))
								(= largeX (= largeY 0))
								(for
									((= i 0))
									(< i (curObj size:))
									((++ i))
									
									(curObj indexToCoor: i)
									(if (< (curObj currentX:) smallX)
										(= smallX (curObj currentX:))
									)
									(if (> (curObj currentX:) largeX)
										(= largeX (curObj currentX:))
									)
									(if (< (curObj currentY:) smallY)
										(= smallY (curObj currentY:))
									)
									(if (> (curObj currentY:) largeY)
										(= largeY (curObj currentY:))
									)
								)
								(= tmpX (+ (/ (- largeX smallX) 2) smallX))
								(= tmpY (+ (/ (- largeY smallY) 2) smallY))
								(poly_pol writeString: {\t\t\t\t})
								(str format: {%d} tmpX)
								(poly_pol writeString: (str data:))
								(poly_pol writeString: {\0d\n})
								(poly_pol writeString: {\t\ty})
								(poly_pol writeString: {\t\t\t\t})
								(str format: {%d} tmpY)
								(poly_pol writeString: (str data:))
								(poly_pol writeString: {\t)\0d\n})
								(poly_pol writeString: {\t(method (init)\0d\n})
								(poly_pol
									writeString: {\t\t(self setPolygon:\0d\n}
								)
								(curObj writeToFile: poly_pol)
								(poly_pol writeString: {\t\t)\0d\n})
								(poly_pol
									writeString: {\t\t(super init: &rest)\0d\n}
								)
								(poly_pol writeString: {\t)\0d\n})
								(poly_pol writeString: {);})
								(poly_pol writeString: (curObj name:))
								(poly_pol writeString: {\0d\n})
							)
						)
						(poly_pol close:)
						(if str
							(str dispose:)
						)
						(obj dispose:)
						(PEditor scratch: 0 dispose:)
					)
					(KEY_ALT_g
						(= eventPlane (useEventOnPlane event))
						(= str (Str newWith: 75 {}))
						(Print
							font: gUserFont
							y: 100
							addTextF: {Flag num (max %d)} 233
							addEdit: str 5 50
							init:
						)
						(if (>= (= i (str asInteger:)) 233)
							(Prints {Flag too large, ignoring})
							(return)
						)
						(str dispose:)
						(switch
							(Print
								font: gUserFont
								y: 50
								addTextF:
									(if ((ScriptID 64017 0) test: i) ; oFlags
										{flag %d is SET}
									else
										{flag %d is CLEARED}
									)
									i
								addButton: 1 { set } 0 12
								addButton: 2 {clear} 0 26
								addButton: -1 {cancel} 0 40
								init:
							)
							(1
								((ScriptID 64017 0) set: i) ; oFlags
							)
							(2
								((ScriptID 64017 0) clear: i) ; oFlags
							)
						)
					)
					(JOY_LEFT
						(= eventPlane (useEventOnPlane event))
						(if (and gCurRoom (gCurRoom respondsTo: #gimme))
							(gCurRoom gimme:)
						)
					)
					(KEY_ALT_h
						(= eventPlane (useEventOnPlane event))
						(PEditor init: 1 eventPlane)
						(if (gCurRoom obstacles:)
							(PEditor readPolygonsFromList: (gCurRoom obstacles:))
						)
						(for
							((= i 0))
							(< i (gFeatures size:))
							((++ i))
							
							(= obj (gFeatures at: i))
							(if (obj onMeCheck:)
								(if ((obj onMeCheck:) isKindOf: List)
									(for
										((= p 0))
										(< p ((obj onMeCheck:) size:))
										((++ p))
										
										(= node
											((obj onMeCheck:) at: p)
										)
										(PEditor addPolygon: node)
									)
								else
									(PEditor addPolygon: (obj onMeCheck:))
								)
								((PEditor at: (- (PEditor size:) 1))
									name: (obj name:)
								)
							)
						)
						(PEditor show: dispose:)
					)
					(KEY_ALT_i
						(= eventPlane (useEventOnPlane event))
						(gGame setCursor: (ScriptID 64006 0) 1) ; oSysCursor
						(repeat
							(= curHigh (= curWide (= highest 0)))
							(Print font: gSmallFont)
							(for
								((= cnt 0))
								(<
									cnt
									(((ScriptID 64001 0) oAllHandledItems:) ; oInvHandler
										size:
									)
								)
								((++ cnt))
								
								(if
									(not
										(= curInv
											(((ScriptID 64001 0) ; oInvHandler
													oAllHandledItems:
												)
												at: cnt
											)
										)
									)
								else
									(breakif (>= cnt 150))
									(Print
										addButton:
											cnt
											(curInv name:)
											curWide
											curHigh
									)
									((Print dialog:) setSize:)
									(if (> curHigh 250)
										(= highest curHigh)
										(= curHigh 0)
										(= curWide
											(-
												((Print dialog:) nsRight:)
												((Print dialog:) nsLeft:)
											)
										)
									else
										(+= curHigh 14)
									)
								)
							)
							(Print
								addButton:
									cnt
									{Exit}
									curWide
									(if highest highest else curHigh)
							)
							(breakif (== (= theItem (Print init:)) cnt))
							(gEgo
								get:
									(((ScriptID 64001 0) oAllHandledItems:) ; oInvHandler
										at: theItem
									)
							)
						)
						(Print font: gUserFont)
					)
					(KEY_ALT_j
						(= eventPlane (useEventOnPlane event))
						(if
							(and
								(!=
									(= num
										(GetUnsigned
											{Pic #?}
											(gCurRoom picture:)
										)
									)
									-1
								)
								(ResCheck rsPIC num)
							)
							(gCurRoom picture: num)
							(gCurRoom drawPic: num)
							(FrameOut)
						else
							(Printf
								{Picture number %hu not available}
								num
							)
						)
					)
					(KEY_ALT_k
						(= eventPlane (useEventOnPlane event))
						(if (not oCurrentObject)
							(return)
						)
						(blinkView oCurrentObject)
					)
					(KEY_ALT_l
						((ScriptID 64952 0) doit:) ; sysLogger
					)
					(KEY_ALT_p
						(= eventPlane (useEventOnPlane event))
						(if
							(or
								(not (gCurRoom obstacles:))
								(not ((gCurRoom obstacles:) size:))
							)
							(PEditor init: 1 eventPlane)
						else
							(PEditor init: 0 eventPlane)
						)
						(if (gCurRoom obstacles:)
							(PEditor readPolygonsFromList: (gCurRoom obstacles:))
						)
						(PEditor doit:)
						(= obj (Str new: 13))
						(= curObj (Str new: 13))
						(curObj format: {%hu.pol} gCurRoomNum)
						(Print
							addTitle: {Output File Name:}
							addEdit: obj 12 0 0 curObj
							init:
						)
						(FrameOut)
						(poly_pol name: (obj data:) open: 0)
						(poly_pol writeString: {\t\t;********************\0d\n})
						(poly_pol writeString: {\t\t(curRoom addObstacle:\0d\n})
						(if (PEditor size:)
							(PEditor eachElementDo: #writeToFile poly_pol)
							(if (gCurRoom obstacles:)
								((gCurRoom obstacles:) dispose:)
								(gCurRoom obstacles: 0)
							)
							(for
								((= node (KList 3 (PEditor elements:)))) ; FirstNode
								node
								((= node nextNode))
								
								(= nextNode (KList 6 node)) ; NextNode
								(= curObj (KList 8 node)) ; NodeValue
								(gCurRoom
									addObstacle:
										((Polygon new:)
											type: (curObj type:)
											size: (curObj size:)
											dynamic: 1
											points:
												((IntArray new:)
													copy: (curObj points:)
												)
											yourself:
										)
								)
							)
						)
						(poly_pol writeString: {\t\t)\0d\n})
						(poly_pol close:)
						(obj dispose:)
						(PEditor dispose:)
					)
					(KEY_ALT_r
						(= eventPlane (useEventOnPlane event))
						(Printf
							{name: %s\nnumber: %hu\npicture: %hu\nstyle: %d\nhorizon: %d\nnorth: %d\nsouth: %d\neast: %d\nwest: %d\nscript: %s }
							(gCurRoom name:)
							gCurRoomNum
							(gCurRoom picture:)
							(gCurRoom style:)
							(gCurRoom horizon:)
							(gCurRoom north:)
							(gCurRoom south:)
							(gCurRoom east:)
							(gCurRoom west:)
							(if (gCurRoom script:)
								((gCurRoom script:) name:)
							else
								{..none..}
							)
							78
							120
						)
					)
					(KEY_ALT_s
						(= eventPlane (useEventOnPlane event))
						(if
							(not
								(= theItem
									(getCurrent
										(eventPlane getMainCast:)
										Actor
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						((ScriptID 64012 0) init: theItem eventPlane doit: dispose:) ; scalerCode
					)
					(KEY_MENU
						(= eventPlane (useEventOnPlane event))
						(if
							(and
								(> (= num (GetUnsigned {Robot #?} nLastRobot)) 0)
								(ResCheck 150 num) ; ROBOT
							)
							(= nLastRobot num)
							(event localize: (gCurRoom plane:))
							(= gAutoRobot
								((WalkieTalkie new:)
									x: (event x:)
									y: (event y:)
									init: 0 num 0
									start:
									yourself:
								)
							)
						else
							(Printf {Robot number %hu not available} num)
						)
					)
					(JOY_DOWNRIGHT
						(= eventPlane (useEventOnPlane event))
						(= i (GetNumber {setLoop?}))
						(= obj (GetUnsigned {which sound number?}))
						(debugSound setLoop: i number: obj play:)
					)
					(KEY_ALT_t
						(= gbTeleport 1)
						(gCurRoom newRoom: 61100) ; roPickAChapter
					)
					(KEY_ALT_u
						(= eventPlane (useEventOnPlane event))
						(gGame handsOn:)
					)
					(KEY_ALT_x
						(= eventPlane (useEventOnPlane event))
						(= gQuit 1)
					)
					(KEY_ALT_y
						(= eventPlane (useEventOnPlane event))
						(cond
							(polyBitmap 0)
							((gCurRoom obstacles:)
								(= polyBitmapPlane eventPlane)
								(= polyBitmap
									(AddPolygon polyBitmapPlane (gCurRoom obstacles:))
								)
							)
							(else
								(Prints
									{Sorry, this room has no polygons.}
								)
							)
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(evMOUSEBUTTON
				(switch (event modifiers:)
					(emCTRL
						(= eventPlane (useEventOnPlane event))
						(PrintDebug { local: %d/%d} (event x:) (event y:))
						(event globalize:)
						(PrintDebug {global: %d/%d} (event x:) (event y:))
					)
					(emALT
						(= eventPlane (useEventOnPlane event))
						(if
							(not
								(= theItem
									(findClosest
										(eventPlane getMainCast:)
										View
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(blinkView theItem)
						(= oCurrentObject theItem)
						(gEgo setMotion: 0)
						(while (!= ((= evt (Event new:)) type:) evMOUSERELEASE)
							(evt localize: eventPlane)
							(theItem posn: (evt x:) (evt y:))
							(if
								(and
									(RespondsTo theItem #scaler)
									(theItem scaler:)
								)
								((theItem scaler:) doit:)
							)
							(UpdateScreenItem theItem)
							(FrameOut)
							(evt dispose:)
						)
						(PrintDebug
							{; %s (#%d)\nposn: %d %d}
							(theItem name:)
							theItem
							(theItem x:)
							(theItem y:)
						)
						(evt dispose:)
					)
					($0007 ; emCTRL | emSHIFT
						(= eventPlane (useEventOnPlane event))
						(if
							(not
								(= theItem
									(findClosest
										(eventPlane getMainCast:)
										View
										(event x:)
										(event y:)
									)
								)
							)
							(return)
						)
						(blinkView theItem)
						(= oCurrentObject theItem)
					)
				)
			)
		)
	)
)

(instance poly_pol of File
	(properties
		name {poly.pol}
	)
)

