;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use DText)
(use Plane)
(use Str)
(use Array)
(use IconBar)
(use User)
(use Actor)
(use System)

(public
	Teller 0
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
)

(class TellerIcon of IconI
	(properties
		nsTop 15
		view 935
		loop 5
		signal 257
		highlightColor 255
		myHandle 0
		value 0
		myTeller 0
		text1 0
		text2 0
		highText 0
	)

	(method (dispose)
		(myHandle dispose:)
		(DeleteScreenItem self)
		(= highText (= text2 (= text1 (= myHandle 0))))
		(DisposeClone self)
	)

	(method (init)
		(&= signal $fff7)
		(local3 add: self)
		(= plane tellerPlane)
		(AddScreenItem self)
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
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
					(temp0 localize: tellerPlane)
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
			(= temp2 (Str copy: {Say Goodbye}))
			(if (myHandle compare: temp2)
				(= local0 1)
				(ClearFlag 51)
			)
			(temp2 dispose:)
			(myTeller iconValue: value)
			((myTeller theControls:)
				state: (& ((myTeller theControls:) state:) $ffdf)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (show &tmp temp0 temp1)
		(= temp1 (IntArray with: 0 0 0 0))
		(TextSize (temp1 data:) (myHandle data:) (myTeller font:) 0)
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
					text: (myHandle data:)
					font: (myTeller font:)
					fore: 92
					back: 254
					skip: 254
					setSize:
					setPri: 253
					init: local3
					yourself:
				)
			)
		)
		(if (not highText)
			(= highText
				((myDText new:)
					posn: 25 (+ nsTop 8)
					text: (myHandle data:)
					font: (myTeller font:)
					fore: 97
					back: 254
					skip: 254
					setSize:
					setPri: 0
					init: local3
					yourself:
				)
			)
		)
		(if (not text2)
			(= text2
				((myDText new:)
					posn: 25 (+ nsTop 8)
					text: (myHandle data:)
					font: (myTeller font:)
					fore: 86
					back: 254
					skip: 254
					setSize:
					setPri: 254
					init: local3
					yourself:
				)
			)
		)
		(temp1 dispose:)
	)

	(method (highlight param1)
		(if param1
			(highText priority: 255)
			(= cel 2)
		else
			(highText priority: 0)
			(= cel 0)
		)
		(UpdateScreenItem highText)
		(UpdateScreenItem self)
		(FrameOut)
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

(instance intList of List
	(properties)

	(method (dispose)
		(if elements
			(DisposeList elements)
		)
		(= size (= elements 0))
		(DisposeClone self)
	)
)

(class Teller of Obj
	(properties
		curNoun 0
		sayNoun 0
		verb 0
		modNum 0
		stack 0
		curList 0
		client 0
		iconValue 0
		theControls 0
		title 0
		window 0
		loopMenu 1
		tellCursor 0
		font 300
		rootNoun 0
		actionVerb 0
		nextTeller 0
		parentTeller 0
		talker 0
		thiefSign 1
	)

	(method (init param1 param2 param3 param4 param5)
		(if
			(and
				((= client param1) actions:)
				((client actions:) isKindOf: Teller)
			)
			((client actions:) nextTeller: self)
			(= parentTeller (client actions:))
		else
			((= client param1) actions: self)
			(= parentTeller 0)
		)
		(if (> argc 1)
			(= modNum param2)
			(if (> argc 2)
				(= sayNoun param3)
				(if (> argc 3)
					(= verb param4)
				)
			)
		else
			(= modNum gCurRoomNum)
		)
		((= stack (intList new:))
			addToFront:
				(if (== argc 5)
					(= rootNoun (= curNoun param5))
				else
					(= curNoun (client noun:))
					(= rootNoun (client noun:))
				)
		)
		(if (not actionVerb)
			(= actionVerb 2)
		)
	)

	(method (dispose)
		(if stack
			(stack dispose:)
			(= stack 0)
		)
		(cond
			(nextTeller
				(if parentTeller
					(parentTeller nextTeller: nextTeller)
					(nextTeller parentTeller: parentTeller)
				)
			)
			(parentTeller
				(parentTeller nextTeller: 0)
			)
			(client
				(client actions: 0)
			)
		)
		(super dispose:)
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((== theVerb actionVerb)
				(= tellCursor (gTheCursor view:))
				(= local4 (gTheCursor loop:))
				(= local5 (gTheCursor cel:))
				(= temp0 (gTheIconBar getCursor:))
				(temp0 view: 999 loop: 0 cel: 0)
				(gGlory setCursor: temp0)
				(SetFlag 51)
				(SetFlag 50)
				(= local6 (User canInput:))
				(= local7 (User canControl:))
				(User canControl: 0 canInput: 0)
				(while (not (self respond:))
				)
				(if (not loopMenu)
					(gGlory
						setCursor:
							(IconBarCursor
								view: tellCursor
								loop: local4
								cel: local5
								yourself:
							)
					)
				)
			)
			((and nextTeller (nextTeller isKindOf: Teller))
				(nextTeller doVerb: theVerb)
			)
			(else
				(client doVerb: theVerb)
			)
		)
		(return 1)
	)

	(method (respond &tmp temp0 temp1)
		(= iconValue 0)
		(self buildCaseList: showCases:)
		(if curList
			(curList dispose:)
			(= curList 0)
		)
		(while (((gUser curEvent:) new:) type:)
		)
		(cond
			((or (not iconValue) (== iconValue -999))
				(self clean:)
				(return 1)
			)
			((== iconValue 999)
				(FrameOut)
				(stack delete: curNoun)
				(= curNoun (stack at: 0))
				(self respond:)
			)
			(else
				(if (== iconValue 55537)
					(if local1
						(gMessager say: 0 178 0 0 self modNum)
					else
						(gMessager say: 3 0 15 0 self 23) ; "You adopt the traditional Thief Sign position, wiggling the fingers of your right hand and rubbing your belly with your left hand."
					)
				else
					(self sayMessage:)
				)
				(if
					(and
						(Message msgSIZE modNum curNoun verb iconValue 2)
						(>
							(= temp0
								(Message 4 modNum curNoun verb iconValue 2) ; msgREF_NOUN
							)
							-1
						)
					)
					(= curNoun temp0)
					(stack addToFront: curNoun)
				)
				(return 1)
			)
		)
	)

	(method (sayMessage param1)
		((User curEvent:) claimed: 1)
		(switch argc
			(0
				(gMessager say: sayNoun verb iconValue 0 self modNum)
			)
			(1
				(gMessager say: sayNoun verb [param1 0] 0 self modNum)
			)
			(2
				(gMessager say: sayNoun [param1 0] [param1 1] 0 self modNum)
			)
			(else
				(gMessager say: [param1 0] [param1 1] [param1 2] 0 self modNum)
			)
		)
	)

	(method (buildCaseList &tmp temp0)
		(if curList
			(curList dispose:)
		)
		(= curList (intList new:))
		(for ((= temp0 0)) (< temp0 150) ((++ temp0))
			(if (Message msgGET modNum curNoun verb temp0 (self getSeqNum:))
				(curList add: temp0)
			)
		)
	)

	(method (showCases param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 [temp7 3] temp10 temp11 temp12 temp13)
		(= local3 (Cast new:))
		(= local2 self)
		(= temp13 0)
		(= temp12 150)
		(= temp1 0)
		(= temp3 12)
		(= temp6 0)
		(= temp2 0)
		(= theControls tellerControls)
		(if (not (theControls plane:))
			(theControls plane: tellerPlane)
		)
		(if title
			(+= temp3 15)
		)
		(for ((= temp0 0)) (< temp0 (curList size:)) ((++ temp0))
			(= temp4 1)
			(for ((= temp1 0)) (and temp4 (< temp1 argc)) ((+= temp1 2))
				(if
					(and
						(== (curList at: temp0) [param1 temp1])
						(not [param1 (+ temp1 1)])
					)
					(= temp4 0)
				)
			)
			(if temp4
				(= temp13 1)
				(= temp5 (curList at: temp0))
				(= temp11 (self getSeqNum: temp5))
				(if
					(not
						(= temp10 (Message msgSIZE modNum curNoun verb temp5 temp11))
					)
					(break)
				)
				(= temp2 (TellerIcon new:))
				(temp2 myHandle: (Str new: temp10))
				(if (> (= temp10 (+ (* temp10 7) 20)) temp12)
					(= temp12 temp10)
				)
				(Message
					msgGET
					modNum
					curNoun
					verb
					temp5
					temp11
					((temp2 myHandle:) data:)
				)
				(temp2 value: temp5 nsTop: temp3 myTeller: self)
				(theControls add: temp2)
				(++ temp6)
				(+= temp3 15)
			)
		)
		(if (not temp2)
			(client doVerb: 2)
			(theControls dispose:)
			(return -999)
		)
		(if (== client gEgo)
			(gEgo useSkill: 13 10) ; communication
			(if
				(and
					(or [gEgoStats 8] [gEgoStats 9]) ; stealth, pick locks
					thiefSign
					(== curNoun rootNoun)
				)
				(if (Message msgSIZE modNum 0 178 0 1)
					(= local1 1)
				else
					(= local1 0)
				)
				(= temp2 (TellerIcon new:))
				(= temp10 (Message msgSIZE 23 0 0 15 1)) ; "Make Thief Sign"
				(temp2 myHandle: (Str new: (+ temp10 1)))
				(Message msgGET 23 0 0 15 1 ((temp2 myHandle:) data:)) ; "Make Thief Sign"
				(temp2 nsTop: temp3 myTeller: self value: 55537)
				(theControls add: temp2)
				(+= temp3 15)
			)
		)
		((= temp2 (TellerIcon new:)) nsTop: temp3 myTeller: self)
		(if (not (== curNoun rootNoun))
			(= temp10 (Message msgSIZE 23 0 0 2 1)) ; "Something Else"
			(temp2 myHandle: (Str new: (+ temp10 1)))
			(Message msgGET 23 0 0 2 1 ((temp2 myHandle:) data:)) ; "Something Else"
			(temp2 value: 999)
		else
			(= temp10 (Message msgSIZE 23 0 0 3 1)) ; "Enough Already"
			(temp2 myHandle: (Str new: (+ temp10 1)))
			(Message msgGET 23 0 0 3 1 ((temp2 myHandle:) data:)) ; "Enough Already"
			(temp2 value: -999)
		)
		(theControls add: temp2)
		((theControls plane:)
			left:
				(-
					(if talker
						(if (> (talker x:) 100) 10 else 150)
					else
						(- 160 (/ temp12 2))
					)
					10
				)
			top: (- 55 (* 7 temp6))
			right:
				(+
					(if talker
						(if (> (talker x:) 100) 150 else 310)
					else
						(+ 160 (/ temp12 2))
					)
					10
				)
			bottom: (- (+ 110 temp3) (* 7 temp6))
		)
		(if (and talker temp13)
			(if (not (IsFlag 148))
				(SetFlag 148)
				(gCast eachElementDo: #perform (ScriptID 90 0) 1) ; ZCode
				(if (not (== gCurRoomNum 470))
					((ScriptID 0 21) doit: 100) ; statusCode
					(UpdatePlane
						((gCurRoom plane:) back: 0 picture: -1 yourself:)
					)
					(FrameOut)
				)
				(talker show:)
				(gTalkers delete: talker)
			)
			(= gTeller self)
			(SetFlag 147)
		)
		(return (theControls init: show: dispose:))
	)

	(method (getSeqNum)
		(return 1)
	)

	(method (cue)
		(if (!= (gTheCursor view:) 999)
			(= tellCursor (gTheCursor view:))
			(= local4 (gTheCursor loop:))
			(= local5 (gTheCursor cel:))
			(gGlory
				setCursor: (IconBarCursor view: 999 loop: 0 cel: 0 yourself:)
			)
		)
		(if local0
			(= local0 0)
			(= gTeller 0)
			(self clean:)
			(return)
		)
		(if loopMenu
			(self respond:)
		else
			(self clean:)
		)
	)

	(method (clean)
		(ClearFlag 51)
		(ClearFlag 50)
		(if local6
			(User canInput: 1)
		)
		(if local7
			(User canControl: 1)
		)
		(switch tellCursor
			(941
				(gTheIconBar curIcon: (gTheIconBar at: 1))
			)
			(942
				(gTheIconBar curIcon: (gTheIconBar at: 2))
			)
			(943
				(gTheIconBar curIcon: (gTheIconBar at: 3))
			)
		)
		(gGlory
			setCursor:
				(IconBarCursor
					view: tellCursor
					loop: local4
					cel: local5
					yourself:
				)
		)
		(if talker
			(= gTeller 0)
			(ClearFlag 147)
			(talker dispose: 1)
			(if (not (== gCurRoomNum 470))
				((gCurRoom plane:) drawPic: (gCurRoom picture:) (gCurRoom style:))
			)
			(if (IsFlag 148)
				(ClearFlag 148)
				(gCast eachElementDo: #perform (ScriptID 90 0) 0) ; ZCode
				((ScriptID 0 21) doit:) ; statusCode
			)
		)
	)
)

(instance tellerControls of IconBar
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

	(method (init)
		(plane
			priority: (+ (GetHighPlanePri) 1)
			picture: -2
			init:
			setInsetRect:
				(plane left:)
				(plane top:)
				(plane right:)
				(plane bottom:)
			setBitmap: 935 0 0 1
		)
		(self eachElementDo: #init self)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp1 (event x:))
		(= temp0 (event y:))
		(= temp2 (event type:))
		(= temp3 (event message:))
		(= temp5 (event claimed:))
		(= temp4 (self firstTrue: #onMe event))
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
					(if temp4
						(self select: temp4 1)
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
								(= temp5 (& temp6 $0040)) ; UNINIT
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

	(method (show &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(gSounds pause:)
		(|= state $0020)
		(plane addCast: local3)
		(UpdatePlane plane)
		(if (local2 title:)
			(= temp5 (Message msgGET 23 0 0 (local2 title:) 1))
			(= temp4 (Str new: (+ temp5 1)))
			(Message msgGET 23 0 0 (local2 title:) 1 (temp4 data:))
			((myDText new:)
				posn: 16 21
				text: (temp4 data:)
				font: (local2 font:)
				fore: 92
				back: 254
				skip: 254
				setSize:
				init: local3
			)
			((myDText new:)
				posn: 15 20
				text: (temp4 data:)
				font: (local2 font:)
				fore: 86
				back: 254
				skip: 254
				setSize:
				setPri: 255
				init: local3
			)
		else
			(= temp4 0)
		)
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
		(= local2 0)
		(= highlightedIcon (= curIcon 0))
		(if temp4
			(temp4 dispose:)
		)
	)

	(method (highlight param1 param2)
		(if (and highlightedIcon (highlightedIcon isKindOf: TellerIcon))
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
			(= temp1 (temp0 type:))
			(= temp2 (temp0 message:))
			(= temp3 (temp0 modifiers:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
			(if (== temp1 32)
				(= temp1 4)
				(= temp2 (if (& temp3 $0003) 27 else 13))
				(= temp3 0)
				(temp0 type: temp1 message: temp2 modifiers: 0)
			)
			(temp0 localize: plane)
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
		(DisposeClone self)
	)
)

(instance tellerPlane of Plane
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
		(if (< temp1 250)
			(= temp5 (/ (* temp1 128) temp2))
		else
			(= temp5 (* (/ (* (/ temp1 2) 128) temp2) 2))
		)
		(= temp6 (/ (* temp3 128) temp4))
		(temp7 scaleSignal: 1 scaleX: temp5 scaleY: temp6)
		(UpdateScreenItem temp7)
	)
)

