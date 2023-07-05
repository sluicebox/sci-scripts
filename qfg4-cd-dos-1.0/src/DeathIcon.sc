;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use DText)
(use Plane)
(use Str)
(use Array)
(use IconBar)
(use Actor)
(use System)

(public
	EgoDead 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
	local5
)

(procedure (EgoDead param1 param2 param3 param4 &tmp [temp0 2])
	(gGlory handsOff:)
	(Palette 2 66 85 100) ; PalIntensity
	(gCast eachElementDo: #perform (ScriptID 90 0) 1) ; ZCode
	((ScriptID 0 21) doit: 100) ; statusCode
	(UpdatePlane ((gCurRoom plane:) back: 0 picture: -1 yourself:))
	(if (>= argc 1)
		(= local0 param1)
		(if (>= argc 2)
			(if param2
				(= local1 param2)
			else
				(= local1 gCurRoomNum)
			)
			(if (>= argc 3)
				(= local2 param3)
				(if (>= argc 4)
					(= local4 param4)
				)
			else
				(= local2 937)
			)
		else
			(= local1 gCurRoomNum)
			(= local2 937)
		)
	else
		(= local2 937)
		(= local1 26)
		(= local0 1)
	)
	(deathIconView view: local2)
	(gSounds eachElementDo: #fade 0 1 5 1)
	(DeathControls init: show: dispose:)
)

(class DeathIcon of IconI
	(properties
		nsTop 15
		view 935
		loop 5
		signal 257
		highlightColor 255
		text 0
		value 0
		text1 0
		text2 0
		hiText 0
	)

	(method (dispose)
		(text dispose:)
		(DeleteScreenItem self)
		(= hiText (= text2 (= text1 (= text 0))))
		(DisposeClone self)
	)

	(method (init &tmp temp0)
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
		(&= signal $fff7)
		((DeathControls deathCast:) add: self)
		(= plane deathPlane)
		(AddScreenItem self)
	)

	(method (onMe param1)
		(return
			(and (< nsLeft (param1 x:) nsRight) (< nsTop (param1 y:) nsBottom))
		)
	)

	(method (select param1 &tmp temp0 temp1 temp2)
		(if
			(if (and argc param1 (& signal $0001))
				(= cel (= temp1 1))
				(UpdateScreenItem self)
				(FrameOut)
				(while (!= ((= temp0 ((gUser curEvent:) new:)) type:) 2)
					(temp0 localize: deathPlane)
					(cond
						((self onMe: temp0)
							(if (not temp1)
								(= cel (= temp1 1))
								(UpdateScreenItem self)
								(FrameOut)
							)
						)
						(temp1
							(= cel (= temp1 0))
							(UpdateScreenItem self)
							(FrameOut)
						)
					)
				)
				(if (== temp1 1)
					(= cel 0)
					(UpdateScreenItem self)
					(FrameOut)
				)
				temp1
			else
				1
			)
			(DeathControls state: (& (DeathControls state:) $ffdf))
			(return 1)
		else
			(return 0)
		)
	)

	(method (show &tmp temp0 temp1)
		(= temp1 (IntArray with: 0 0 0 0))
		(TextSize (temp1 data:) (text data:) 300 0)
		(= nsRight (+ nsLeft (temp1 at: 2) 24))
		(+= nsTop 5)
		(= nsBottom (+ nsTop (temp1 at: 3) 10))
		(= x (+ nsLeft 17))
		(= y (+ nsTop 15))
		(= cel 0)
		(UpdateScreenItem self)
		(if (not text1)
			(= text1
				((myDText new:)
					posn: (+ nsLeft 27) (+ nsTop 9)
					text: (text data:)
					font: 300
					fore: 92
					back: 254
					skip: 254
					setSize:
					setPri: 252
					init: (DeathControls deathCast:)
					yourself:
				)
			)
		)
		(if (not text2)
			(= text2
				((myDText new:)
					posn: (+ nsLeft 26) (+ nsTop 8)
					text: (text data:)
					font: 300
					fore: 86
					back: 254
					skip: 254
					setSize:
					setPri: 253
					init: (DeathControls deathCast:)
					yourself:
				)
			)
		)
		(if (not hiText)
			(= hiText
				((myDText new:)
					posn: (+ nsLeft 26) (+ nsTop 8)
					text: (text data:)
					font: 300
					fore: 86
					back: 254
					skip: 254
					setSize:
					setPri: 0
					init: (DeathControls deathCast:)
					yourself:
				)
			)
		)
		(temp1 dispose:)
	)

	(method (highlight param1)
		(text2 setPri: 0)
		(hiText setPri: 254)
		(= cel (if param1 2 else 0))
		(UpdateScreenItem self)
		(UpdateScreenItem text2)
		(UpdateScreenItem hiText)
		(FrameOut)
	)
)

(class DeathControls of IconBar
	(properties
		state 0
		deathCast 0
	)

	(method (select param1 param2)
		(return
			(if (param1 select: (and (>= argc 2) param2))
				(if (not (& (param1 signal:) $0002))
					(= curIcon param1)
				)
				1
			)
		)
	)

	(method (advanceCurIcon))

	(method (swapCurIcon))

	(method (init &tmp temp0 temp1)
		(= local5 0)
		(if (not deathCast)
			(= deathCast (Cast new:))
		else
			(SetDebug deathCast)
		)
		(= plane deathPlane)
		(deathPlane
			priority: (+ (GetHighPlanePri) 1)
			picture: -2
			init: 35 25 285 175 35 25 285 175
			setBitmap: 935 0 0 1
			addCast: deathCast
		)
		(self add: deathIconView)
		(deathIconTitle text: (Str new:))
		(Message msgGET local1 0 100 local0 2 ((deathIconTitle text:) data:))
		(self add: deathIconTitle)
		(deathIconText text: (Str new:))
		(Message msgGET local1 0 100 local0 1 ((deathIconText text:) data:))
		(self add: deathIconText)
		(deathIconRestore text: (Str new:))
		(Message msgGET 26 1 0 3 1 ((deathIconRestore text:) data:)) ; "Restore"
		(self add: deathIconRestore)
		(deathIconRestart text: (Str new:))
		(Message msgGET 26 1 0 4 1 ((deathIconRestart text:) data:)) ; "Restart"
		(self add: deathIconRestart)
		(deathIconQuit text: (Str new:))
		(Message msgGET 26 1 0 5 1 ((deathIconQuit text:) data:)) ; "Quit"
		(self add: deathIconQuit)
		(self eachElementDo: #init self)
		(= temp1 (gTheIconBar getCursor:))
		(temp1 view: 999 loop: 0 cel: 0)
		(gGlory setCursor: temp1)
		(gLongSong number: 106 setLoop: 1 play:)
	)

	(method (dispatchEvent event &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp2 (event type:))
		(= temp3 (event message:))
		(= temp5 (event claimed:))
		(if (= temp4 (self firstTrue: #onMe event))
			(= temp6 (temp4 signal:))
			(= temp7 (== temp4 helpIconItem))
		)
		(if
			(and
				(== (deathIconView view:) 976)
				(== (deathIconView cel:) (deathIconView lastCel:))
			)
			(deathIconView cel: 0)
		)
		(if
			(and
				local4
				(!= (deathIconView cel:) (deathIconView lastCel:))
				(== (++ local3) 4)
			)
			(= local3 0)
			(deathIconView setCel: (+ (deathIconView cel:) 1))
			(UpdateScreenItem deathIconView)
			(FrameOut)
		)
		(if (& temp2 $0010) ; direction
			(switch temp3
				(JOY_RIGHT
					(self advance:)
				)
				(JOY_DOWN
					(self advance:)
				)
				(JOY_LEFT
					(self retreat:)
				)
				(JOY_UP
					(self retreat:)
				)
			)
		else
			(switch temp2
				(evNULL
					(if temp4
						(if (!= temp4 highlightedIcon)
							(= oldMouseY 0)
							(self highlight: temp4)
						)
					else
						(self highlight: 0)
					)
				)
				(evMOUSEBUTTON
					(if (and temp4 (self select: temp4 1))
						(= temp5 (& temp6 $0040))
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
							(if (and temp4 (self select: temp4))
								(temp4 doit:)
								(= temp5 (& temp6 $0040))
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
			)
		)
		(return temp5)
	)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4)
		(gSounds pause:)
		(|= state $0020)
		(plane addCast: deathCast)
		(UpdatePlane plane)
		(= temp0 30)
		(= temp1 30)
		(for ((= temp2 (FirstNode elements))) temp2 ((= temp2 nextNode))
			(= nextNode (NextNode temp2))
			(if (not (= temp3 (NodeValue temp2)))
				(return)
			)
			(if (and (not (& (temp3 signal:) $0080)) (<= (temp3 nsRight:) 0))
				(temp3 show: temp0 temp1)
				(= temp0 (+ 20 (temp3 nsRight:)))
			else
				(temp3 show:)
			)
		)
		(self doit: hide:)
		(= highlightedIcon (= curIcon 0))
	)

	(method (highlight param1 param2)
		(if highlightedIcon
			(highlightedIcon highlight: 0)
		)
		(cond
			((not (= highlightedIcon param1)) 0)
			((& (param1 signal:) $0004)
				(= highlightedIcon 0)
			)
			(else
				(param1 highlight: 1)
				(if (and (>= argc 2) param2)
					(gGlory
						setCursor:
							gTheCursor
							1
							(+
								(param1 nsLeft:)
								(/ (- (param1 nsRight:) (param1 nsLeft:)) 2)
							)
							(- (param1 nsBottom:) 3)
					)
				)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(while (and (& state $0020) (= temp0 ((gUser curEvent:) new:)))
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
			(temp0 localize: plane)
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(if gCuees
				(gCuees eachElementDo: #doit)
			)
			(if (== temp1 32)
				(= temp1 4)
				(= temp2 (if (& temp3 $0003) 27 else 13))
				(= temp3 0)
				(temp0 type: temp1 message: temp2 modifiers: 0)
			)
			(MapKeyToDir temp0)
			(breakif (self dispatchEvent: temp0))
		)
	)

	(method (dispose)
		(plane deleteCast: self dispose:)
		(= deathCast (= plane 0))
		(if elements
			(DisposeList elements)
		)
		(= size (= elements 0))
		((deathIconTitle text:) dispose:)
		((deathIconText text:) dispose:)
		(gLongSong stop: signal: 0)
		(if local5
			(if (gGlory restore:)
				(self init: show: dispose:)
			else
				(DisposeClone self)
			)
		)
	)
)

(instance deathPlane of Plane
	(properties)

	(method (setBitmap param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0 (Cast new:))
		(self addCast: temp0)
		((= temp7 (View new:))
			view: param1
			loop: param2
			cel: param3
			posn: 0 0
			init: temp0
		)
		(= temp2 (CelWide param1 param2 param3))
		(= temp4 (CelHigh param1 param2 param3))
		(= temp1 (+ (- right left) 1))
		(= temp3 (+ (- bottom top) 1))
		(= temp5 (/ (* temp1 128) temp2))
		(= temp6 (/ (* temp3 128) temp4))
		(temp7 scaleSignal: 1 scaleX: temp5 scaleY: temp6)
		(UpdateScreenItem temp7)
	)
)

(instance deathIconView of DeathIcon
	(properties
		nsLeft 16
		nsTop 82
		x 40
		y 80
		priority 55
		view 937
		loop 0
	)

	(method (onMe)
		(return 0)
	)

	(method (dispose)
		(DeleteScreenItem self)
		(DisposeClone self)
	)

	(method (show)
		(= x (+ nsLeft 20))
		(= y (+ nsTop 20))
		(= loop (= cel 0))
		(UpdateScreenItem self)
	)
)

(instance deathIconTitle of DeathIcon
	(properties
		nsLeft 70
		nsTop 10
		x 8
		y 2
		priority 55
	)

	(method (init))

	(method (show &tmp temp0 temp1 temp2)
		(= temp1 (IntArray with: 0 0 0 0))
		(TextSize (temp1 data:) (text data:) 300 0)
		(= nsRight (+ nsLeft (temp1 at: 2) 24))
		(+= nsTop 5)
		(= nsBottom (+ nsTop (temp1 at: 3) 10))
		(= text1
			((myDText new:)
				posn: 25 (+ nsTop 3)
				text: (text data:)
				font: 300
				fore: 92
				back: 254
				skip: 254
				setSize: 230
				setPri: 254
				init: (DeathControls deathCast:)
				yourself:
			)
		)
		(= text2
			((myDText new:)
				posn: 24 (+ nsTop 2)
				text: (text data:)
				font: 300
				fore: 86
				back: 254
				skip: 254
				setSize: 230
				setPri: 255
				init: (DeathControls deathCast:)
				yourself:
			)
		)
		(temp1 dispose:)
	)

	(method (onMe)
		(return 0)
	)
)

(instance deathIconText of DeathIcon
	(properties
		nsLeft 70
		nsTop 23
		x 8
		y 2
		priority 55
	)

	(method (init))

	(method (show &tmp temp0 temp1)
		(= temp1 (IntArray with: 0 0 0 0))
		(TextSize (temp1 data:) (text data:) 0 0)
		(= nsRight (+ nsLeft (temp1 at: 2) 24))
		(+= nsTop 5)
		(= nsBottom (+ nsTop (temp1 at: 3) 10))
		(= x (+ nsLeft 17))
		(= y (+ nsTop 15))
		(= cel 0)
		(= text1
			((myDText new:)
				posn: (+ nsLeft 1) (+ nsTop 9)
				text: (text data:)
				font: 0
				fore: 92
				back: 254
				skip: 254
				setSize: 155
				setPri: 254
				init: (DeathControls deathCast:)
				yourself:
			)
		)
		(= text2
			((myDText new:)
				posn: nsLeft (+ nsTop 8)
				text: (text data:)
				font: 0
				fore: 86
				back: 254
				skip: 254
				setSize: 155
				setPri: 255
				init: (DeathControls deathCast:)
				yourself:
			)
		)
		(temp1 dispose:)
	)

	(method (onMe)
		(return 0)
	)
)

(instance deathIconRestore of DeathIcon
	(properties
		nsLeft 20
		nsTop 105
		x 8
		y 2
		priority 55
	)

	(method (select)
		(= local5 1)
		(DeathControls state: (& (DeathControls state:) $ffdf))
	)
)

(instance deathIconRestart of DeathIcon
	(properties
		nsLeft 90
		nsTop 105
		x 8
		y 2
		priority 55
	)

	(method (select)
		(DeathControls state: (& (DeathControls state:) $ffdf))
		(SetFlag 382)
	)
)

(instance deathIconQuit of DeathIcon
	(properties
		nsLeft 160
		nsTop 105
		x 8
		y 2
		priority 55
	)

	(method (select)
		(= gQuit 1)
		(DeathControls state: (& (DeathControls state:) $ffdf))
	)
)

(instance myDText of DText
	(properties)

	(method (dispose &tmp temp0 temp1)
		(= temp1 0)
		(if bitmap
			(= temp1 bitmap)
			(= bitmap 0)
		)
		(gCast delete: self)
		(if (self isNotHidden:)
			(DeleteScreenItem self)
		)
		(= temp0 (plane casts:))
		(temp0 eachElementDo: #delete self)
		(= plane 0)
		(DisposeClone self)
		(if temp1
			(Bitmap 1 temp1) ; Dispose
		)
	)
)

