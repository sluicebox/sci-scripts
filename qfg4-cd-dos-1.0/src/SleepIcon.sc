;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use DeathIcon)
(use PuzzleBar)
(use DText)
(use Plane)
(use Str)
(use Array)
(use IconBar)
(use Actor)
(use System)

(public
	proc7_0 0
	doSleep 2
	showTime 3
	fixTime 4
	egoRests 5
	advanceTime 6
	egoSleeps 7
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
)

(procedure (proc7_0 param1 &tmp temp0 temp1)
	(if (OneOf gCurRoomNum 330)
		(= global402 param1)
		((= temp1 (Event new:)) type: evMOUSEBUTTON message: KEY_g)
		(if (not (gMouseDownHandler handleEvent: temp1))
			(gRegions handleEvent: temp1)
		)
		(temp1 dispose:)
	else
		(egoRests init: param1 1)
	)
)

(instance doSleep of Code
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp3 1)
		(= temp2 0)
		(= temp1 ((gTheIconBar getCursor:) view:))
		(= local2 120)
		(sleepControls init: show: dispose:)
		(= temp5 (gTheIconBar getCursor:))
		(temp5 view: local7 loop: local8 cel: local9)
		(gGlory setCursor: temp5)
		(switch local1
			(1
				(proc7_0 10)
			)
			(2
				(proc7_0 30)
			)
			(3
				(proc7_0 60)
			)
			(4
				(if
					(OneOf
						gCurRoomNum
						440
						270
						330
						350
						740
						730
						530
						535
						541 ; swamp1
						542 ; swamp2
						543 ; swamp3
						545
					)
					((= temp0 (Event new:)) type: evMOUSEBUTTON message: KEY_h)
					(= temp3 0)
					(if (not (gMouseDownHandler handleEvent: temp0))
						(gRegions handleEvent: temp0)
					)
					(temp0 dispose:)
					(= temp2 1)
				else
					(egoSleeps init: 7 0)
				)
			)
			(5
				(= temp2 1)
			)
		)
		(return temp2)
	)
)

(instance egoSleeps of Code
	(properties)

	(method (init param1 param2 &tmp temp0 temp1 [temp2 60])
		(if
			(OneOf
				gCurRoomNum
				440
				270
				330
				350
				740
				730
				530
				535
				541 ; swamp1
				542 ; swamp2
				543 ; swamp3
				545
			)
			(= global137 0)
			(= temp1 gClock)
			(switch argc
				(0
					(fixTime init: 5)
				)
				(1
					(fixTime init: param1)
				)
				(else
					(fixTime init: param1 param2)
				)
			)
			(= temp0 (/ (mod (- (+ gClock 3600) temp1) 3600) 150))
			(= [gEgoStats 18] (gEgo maxStamina:)) ; stamina
			(if
				(and
					(not
						(gEgo
							takeDamage:
								(- (/ (* temp0 (gEgo maxHealth:)) 16))
						)
					)
					(IsFlag 14)
				)
				(EgoDead 27 28 977 1 912) ; "You are completely strychnine by poison. No curare for you now. Next time, take some poison cure pills before it's too late."
				(return)
			)
			(= [gEgoStats 19] (gEgo maxMana:)) ; mana
			(if (and (> temp1 gClock) (IsFlag 11))
				(NextDay)
			)
			(ClearFlag 8)
			(= global440 0)
			(= global449 0)
			(= global453 0)
			(= global454 0)
			((ScriptID 0 21) doit:) ; statusCode
			(cond
				((< temp0 2)
					(gMessager say: 0 0 12 1 0 7) ; "You awaken as the sun begins to rise, but you feel as though you haven't slept at all."
				)
				((< argc 3)
					(gMessager say: 0 0 3 1 0 7) ; "You awaken as the sun begins to rise."
				)
			)
		else
			(gMessager say: 3 6 11 0 0 7) ; "This would not be a good place to sleep."
		)
	)
)

(instance showTime of Code
	(properties)

	(method (init &tmp temp0 temp1 temp2)
		(= temp0 gDay)
		(if (or (!= gTime 6) (> gClock 500))
			(++ temp0)
		)
		(if (>= (= temp2 gClock) 2780)
			(-= temp2 3600)
			(= local5 1)
		)
		(if (<= temp2 820)
			(+= temp2 1800)
			(= local5 1)
		)
		(= local3 (/ (-= temp2 1800) 16))
		(= local4 (Abs (/ temp2 48)))
		(+= local3 81)
		(timePanel init: show: dispose:)
	)
)

(instance fixTime of Code
	(properties)

	(method (init param1 param2 &tmp temp0 temp1)
		(= temp1 gClock)
		(if (>= argc 1)
			(= gClock (* 150 param1))
			(= global124 (GetTime 1)) ; SysTime12
			(if (>= argc 2)
				(+= gClock (/ (* 150 param2) 60))
			)
		)
		(= temp0 gTime)
		(cond
			((< (^ gClock $0001) 300)
				(= gTime 6)
			)
			((< (^ gClock $0001) 750)
				(= gTime 7)
			)
			((< (^ gClock $0001) 1200)
				(= gTime 0)
			)
			((< (^ gClock $0001) 1650)
				(= gTime 1)
			)
			((< (^ gClock $0001) 2100)
				(= gTime 2)
			)
			((< (^ gClock $0001) 2550)
				(= gTime 3)
			)
			((< (^ gClock $0001) 3000)
				(= gTime 4)
			)
			((< (^ gClock $0001) 3450)
				(= gTime 5)
			)
			(else
				(= gTime 6)
			)
		)
		(if (< gClock temp1)
			(NextDay)
		)
		(proc0_16)
		(if (and (== gTime 6) (!= temp0 6))
			(if (== (++ global137) 1)
				(gMessager say: 0 0 6 1 0 7) ; "You are getting tired."
			else
				(gMessager say: 0 0 7 1 0 7) ; "You are exhausted from lack of sleep."
			)
		)
	)
)

(instance egoRests of Code
	(properties)

	(method (init param1 param2)
		(= global106 gDay)
		(= global105 gClock)
		(gEgo
			useStamina: (- param1)
			useMana: (- (/ param1 5))
			takeDamage: (- (/ (+ param1 5) 15))
		)
		(if param2
			(if (IsFlag 14)
				(gMessager say: 0 0 13 1 0 7) ; "After some rest, you feel worse than before."
			else
				(gMessager say: 0 0 9 1 0 7) ; "After some rest, you feel better."
			)
		)
		(advanceTime init: 0 param1)
	)
)

(instance advanceTime of Code
	(properties)

	(method (init param1 param2 &tmp temp0)
		(switch argc
			(1
				(= temp0 (+ gClock (* 150 param1)))
			)
			(2
				(= temp0 (+ gClock (* 150 param1) (/ (* 150 param2) 60)))
			)
		)
		(^= temp0 $0001)
		(if
			(or
				(and (< gClock 1100) (> temp0 1200))
				(and (< gClock 2500) (or (> temp0 2600) (< temp0 gClock)))
			)
			(gEgo eatMeal:)
		)
		(fixTime init: (/ temp0 150) (/ (* (mod temp0 150) 60) 150))
	)
)

(class SleepIcon of IconI
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
		(local6 add: self)
		(= plane sleepPlane)
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
					(temp0 localize: sleepPlane)
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
			(sleepControls state: (& (sleepControls state:) $ffdf))
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
					posn: 26 (+ nsTop 9)
					text: (text data:)
					font: 300
					fore: 92
					back: 254
					skip: 254
					setSize:
					setPri: 253
					init: local6
					yourself:
				)
			)
		)
		(if (not text2)
			(= text2
				((myDText new:)
					posn: 25 (+ nsTop 8)
					text: (text data:)
					font: 300
					fore: 86
					back: 254
					skip: 254
					setSize:
					setPri: 254
					init: local6
					yourself:
				)
			)
		)
		(if (not hiText)
			(= hiText
				((myDText new:)
					posn: 25 (+ nsTop 8)
					text: (text data:)
					font: 300
					fore: 86
					back: 254
					skip: 254
					setSize:
					setPri: 0
					init: local6
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

(instance sleepControls of IconBar
	(properties
		state 0
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
		(= local6 (Cast new:))
		(= plane sleepPlane)
		(sleepPlane
			priority: (+ (GetHighPlanePri) 1)
			picture: -2
			init: 80 30 240 160
			setBitmap: 935 0 0 1
			addCast: local6
		)
		(sleepIconPrompt text: (Str new:))
		(Message msgGET 7 2 0 1 1 ((sleepIconPrompt text:) data:)) ; "Rest for how long?"
		(self add: sleepIconPrompt)
		(sleepIcon10 text: (Str new:))
		(Message msgGET 7 2 0 0 1 ((sleepIcon10 text:) data:)) ; "10 minutes"
		(self add: sleepIcon10)
		(sleepIcon30 text: (Str new:))
		(Message msgGET 7 2 0 0 2 ((sleepIcon30 text:) data:)) ; "30 minutes"
		(self add: sleepIcon30)
		(sleepIcon60 text: (Str new:))
		(Message msgGET 7 2 0 0 3 ((sleepIcon60 text:) data:)) ; "60 minutes"
		(self add: sleepIcon60)
		(if gNight
			(sleepIconMorn text: (Str new:))
			(Message msgGET 7 2 0 0 4 ((sleepIconMorn text:) data:)) ; "Sleep until morning"
			(self add: sleepIconMorn)
		)
		(sleepIconLater text: (Str new:))
		(Message msgGET 7 2 0 0 5 ((sleepIconLater text:) data:)) ; "Rest later"
		(sleepIconLater nsTop: (if gNight 85 else 70))
		(self add: sleepIconLater)
		(self eachElementDo: #init self)
		(= local7 (gTheCursor view:))
		(= local8 (gTheCursor loop:))
		(= local9 (gTheCursor cel:))
		(= temp1 (gTheIconBar getCursor:))
		(temp1 view: 999 loop: 0 cel: 0)
		(gGlory setCursor: temp1)
	)

	(method (dispatchEvent event &tmp [temp0 2] temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp2 (event type:))
		(= temp3 (event message:))
		(= temp5 (event claimed:))
		(if (= temp4 (self firstTrue: #onMe event))
			(= temp6 (temp4 signal:))
			(= temp7 (== temp4 helpIconItem))
		)
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
		(return temp5)
	)

	(method (show &tmp temp0 temp1 temp2 temp3 [temp4 2])
		(gSounds pause:)
		(|= state $0020)
		(plane addCast: local6)
		(UpdatePlane plane)
		(= temp0 30)
		(= temp1 5)
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
		(= plane 0)
		(if elements
			(DisposeList elements)
		)
		(= size (= elements 0))
		((sleepIconPrompt text:) dispose:)
		(proc0_16)
		(DisposeClone self)
	)
)

(instance sleepPlane of Plane
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

(instance sleepIconPrompt of SleepIcon
	(properties
		nsLeft 2
		nsTop 5
		x 8
		y 2
		priority 55
	)

	(method (init)
		(= nsTop 5)
		(= nsLeft 2)
	)

	(method (show &tmp temp0 temp1)
		(= temp1 (IntArray with: 0 0 0 0))
		(TextSize (temp1 data:) (text data:) 300 0)
		(= nsRight (+ nsLeft (temp1 at: 2) 24))
		(= nsBottom (+ nsTop (temp1 at: 3) 10))
		(= x (+ nsLeft 17))
		(= y (+ nsTop 15))
		(= cel 0)
		(= text1
			((myDText new:)
				posn: 26 (+ nsTop 9)
				text: (text data:)
				font: 300
				fore: 92
				back: 254
				skip: 254
				setSize:
				setPri: 254
				init: local6
				yourself:
			)
		)
		(= text2
			((myDText new:)
				posn: 25 (+ nsTop 8)
				text: (text data:)
				font: 300
				fore: 86
				back: 254
				skip: 254
				setSize:
				setPri: 255
				init: local6
				yourself:
			)
		)
		(temp1 dispose:)
	)

	(method (highlight)
		(return 0)
	)

	(method (select)
		(return 0)
	)
)

(instance sleepIcon10 of SleepIcon
	(properties
		nsLeft 2
		nsTop 25
		x 8
		y 2
		priority 55
	)

	(method (init)
		(= nsTop 25)
		(= nsLeft 2)
		(super init: &rest)
	)

	(method (select)
		(= local1 1)
		(sleepControls state: (& (sleepControls state:) $ffdf))
	)
)

(instance sleepIcon30 of SleepIcon
	(properties
		nsLeft 2
		nsTop 40
		x 8
		y 2
		priority 55
	)

	(method (init)
		(= nsTop 40)
		(= nsLeft 2)
		(super init: &rest)
	)

	(method (select)
		(= local1 2)
		(sleepControls state: (& (sleepControls state:) $ffdf))
	)
)

(instance sleepIcon60 of SleepIcon
	(properties
		nsLeft 2
		nsTop 55
		x 8
		y 2
		priority 55
	)

	(method (init)
		(= nsTop 55)
		(= nsLeft 2)
		(super init: &rest)
	)

	(method (select)
		(= local1 3)
		(sleepControls state: (& (sleepControls state:) $ffdf))
	)
)

(instance sleepIconMorn of SleepIcon
	(properties
		nsLeft 2
		nsTop 70
		x 8
		y 2
		priority 55
	)

	(method (init)
		(= nsTop 70)
		(= nsLeft 2)
		(super init: &rest)
	)

	(method (select)
		(= local1 4)
		(sleepControls state: (& (sleepControls state:) $ffdf))
	)
)

(instance sleepIconLater of SleepIcon
	(properties
		nsLeft 2
		nsTop 85
		x 8
		y 2
		priority 55
	)

	(method (init)
		(= nsLeft 2)
		(super init: &rest)
	)

	(method (select)
		(= local1 5)
		(sleepControls state: (& (sleepControls state:) $ffdf))
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

(instance timePanel of PuzzleBar
	(properties
		state 0
	)

	(method (advance))

	(method (addIcons))

	(method (setPlane)
		(= usePlane 1)
		(plane
			priority: (+ (GetHighPlanePri) 1)
			init:
			bitmap: 0
			setRect: 72 40 258 132
			setBitmap: 935 0 0 1
			addCast: puzzleCast
		)
	)

	(method (dispatchEvent event)
		(if (OneOf (event type:) evMOUSEBUTTON evKEYBOARD)
			(timePanel state: (& (timePanel state:) $ffdf))
			(return 1)
		else
			(super dispatchEvent: event)
		)
	)

	(method (init &tmp temp0 temp1)
		(super init: &rest)
		(= temp1 0)
		(if local5
			(= temp1 3)
		)
		(self
			add:
				((timeIcon new:)
					nsLeft: 12
					x: 12
					nsTop: 6
					y: 6
					cel: 0
					loop: (+ 1 temp1)
					setPri: 250
					init: self
					yourself:
				)
		)
		(self
			add:
				((timeIcon new:)
					nsLeft: (+ local3 12)
					x: (+ local3 12)
					nsTop: (+ local4 6)
					y: (+ local4 6)
					cel: 0
					loop: (+ 2 temp1)
					setPri: 251
					init: self
					yourself:
				)
		)
		(self
			add:
				((timeIcon new:)
					nsLeft: 12
					x: 12
					nsTop: 6
					y: 6
					cel: 0
					loop: temp1
					setPri: 252
					init: self
					yourself:
				)
		)
		(self
			add:
				(daysIcon
					nsLeft: 12
					x: 12
					nsTop: 74
					y: 70
					cel: 0
					loop: 6
					init: self
					yourself:
				)
		)
	)
)

(instance timeIcon of TextIcon
	(properties
		view 938
		loop 6
	)

	(method (highlight))

	(method (select)
		(timePanel state: (& (timePanel state:) $ffdf))
	)
)

(instance daysIcon of TextIcon
	(properties
		view 938
	)

	(method (highlight))

	(method (show &tmp temp0 temp1 temp2)
		(UpdateScreenItem self)
		(= temp0 (Str new: 30))
		(= temp1 (Str new: 7))
		(Message msgGET 7 0 0 10 1 (temp0 data:)) ; "It's day"
		(temp1 format: {%d} gDay)
		(temp0 cat: temp1)
		(= text
			((myDText new:)
				x: 20
				y: 72
				text: (temp0 data:)
				font: 300
				fore: 92
				back: 254
				skip: 254
				setSize:
				setPri: 253
				init: (timePanel puzzleCast:)
				yourself:
			)
		)
		(= textType
			((myDText new:)
				x: 19
				y: 71
				text: (temp0 data:)
				font: 300
				fore: 0
				back: 254
				skip: 254
				setSize:
				setPri: 254
				init: (timePanel puzzleCast:)
				yourself:
			)
		)
		(temp0 dispose:)
		(temp1 dispose:)
	)
)

