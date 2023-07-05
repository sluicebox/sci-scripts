;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63001)
(include sci.sh)
(use Main)
(use Plane)
(use Rectangle)
(use BorderWindow)
(use PolyEdit)
(use Feature)
(use TextField)
(use Button)
(use Jump)
(use Menu)
(use System)

(public
	invItems 0
	invCUPlane 1
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance selections of List
	(properties)
)

(instance invItems of Set
	(properties)

	(method (init)
		(super init: &rest)
		(self
			add:
				buttonI
				walletI
				cardKeyI
				candyI
				parentPhotoI
				xmasPhotoI
				sexyCardI
				bondageCardI
				harburgCardI
				orderlyKeyI
				screwdriverI
				dadLetterI
				lockerI
				paulKeyI
				hammerI
				folderI
				hairpinI
				paulBookI
				printoutI
				braceletI
				mailBundleI
				ratI
				laceI
				anagramI
				thereseNoteI
				paulSpeechI
				trevCardKeyI
				paperclipI
				extinguisherI
				alienFoodI
				alienI
				slimeI
				alien2I
				slime2I
				alienKeyI
				electricAlienI
				alien3I
				glopI
		)
	)
)

(class P2InvItem of Button
	(properties
		view 2
		verb -1
		helpText 0
		closePic -1
		myTarget -1
		hotVerb -1
		hotVerb2 -1
		draggable 0
	)

	(method (react))

	(method (update)
		(if (!= gCurRoomNum 900) ; mapRoom
			(super update: &rest)
		)
	)

	(method (addMe)
		(InvPlane addItem: self)
	)

	(method (moveX param1)
		(+= x param1)
	)

	(method (showMe)
		(return (== gVerb verb))
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(= value self)
	)

	(method (action)
		(= gVerb verb)
		((ScriptID 0 1) set: 999 ((ScriptID 0 4) lookup: gVerb) 0) ; p2Cursor, cursorLoopTable
		(self doit:)
	)

	(method (doHelp param1)
		(cond
			((or (not argc) param1)
				(if (not helpText)
					(= helpText (TextView new:))
					(helpText
						setText: 1 0 verb 0 1
						setSize:
						setPri: 500
						posn: (+ x 110) 326
						init:
					)
				)
			)
			(helpText
				(helpText dispose:)
				(= helpText 0)
			)
		)
	)

	(method (hilite)
		(if (< 0 x 380)
			(super hilite: &rest)
		)
	)

	(method (handleEvent event)
		(if (& evMOUSE (event type:))
			(event localize: plane)
			(if (self onMe: event)
				(self action:)
				(event claimed: self)
			)
		)
		(FrameOut)
		(event claimed:)
	)

	(method (doit)
		(if (< 0 x 380)
			(super doit: &rest)
		)
	)
)

(instance buttonI of P2InvItem
	(properties
		verb 1
	)
)

(instance walletI of P2InvItem
	(properties
		loop 1
		verb 5
		hotVerb 4
	)

	(method (showMe)
		(if (== gVerb verb)
			(= myTarget (Rectangle new: 96 42 196 168))
			(return 1)
		else
			(return 0)
		)
	)

	(method (react)
		(switch gVerb
			(6 ; cardKeyI
				(gEgo put: 2) ; cardKeyI
				(itemView view: 20001)
				(UpdateScreenItem itemView)
				(= hotVerb (= gVerb 4)) ; Do
				(gTheCursor set: 999 ((ScriptID 0 4) lookup: 4) 0) ; cursorLoopTable
				(FrameOut)
			)
			(else
				(itemView view: 20040)
				(UpdateScreenItem itemView)
				(= hotVerb (= gVerb 6)) ; cardKeyI
				((ScriptID 0 1) set: 999 ((ScriptID 0 4) lookup: 6) 0) ; p2Cursor, cursorLoopTable
				(FrameOut)
				(gEgo get: 2) ; cardKeyI
			)
		)
	)
)

(instance cardKeyI of P2InvItem
	(properties
		loop 2
		verb 6
	)
)

(instance candyI of P2InvItem
	(properties
		loop 3
		verb 7
	)
)

(instance parentPhotoI of P2InvItem
	(properties
		loop 4
		verb 9
	)
)

(instance xmasPhotoI of P2InvItem
	(properties
		loop 5
		verb 10
	)
)

(instance sexyCardI of P2InvItem
	(properties
		loop 6
		verb 11
		closePic 21006
	)
)

(instance bondageCardI of P2InvItem
	(properties
		loop 7
		verb 12
		closePic 21007
	)
)

(instance harburgCardI of P2InvItem
	(properties
		loop 8
		verb 13
	)
)

(instance orderlyKeyI of P2InvItem
	(properties
		loop 9
		verb 14
	)
)

(instance screwdriverI of P2InvItem
	(properties
		loop 10
		verb 15
		hotVerb 23
	)

	(method (showMe)
		(if (== gVerb verb)
			(= myTarget (Rectangle new: 87 42 231 238))
			(return 1)
		else
			(return 0)
		)
	)

	(method (react)
		(if (== gVerb 23) ; hammerI
			(if (!= myTarget -1)
				(myTarget dispose:)
				(= myTarget -1)
			)
			(itemView view: 20041)
			(UpdateScreenItem itemView)
			(FrameOut)
			(= gVerb 16) ; ???
			((ScriptID 0 1) set: 999 ((ScriptID 0 4) lookup: 16) 0) ; p2Cursor, cursorLoopTable
		)
	)
)

(instance dadLetterI of P2InvItem
	(properties
		loop 11
		verb 28
		closePic 21011
		draggable 747
	)
)

(instance lockerI of P2InvItem
	(properties
		loop 12
		verb 21
	)
)

(instance paulKeyI of P2InvItem
	(properties
		loop 13
		verb 14
	)
)

(instance hammerI of P2InvItem
	(properties
		loop 14
		verb 23
		hotVerb 15
	)

	(method (showMe)
		(if (== gVerb verb)
			(= myTarget (Rectangle new: 106 27 243 236))
			(return 1)
		else
			(return 0)
		)
	)

	(method (react)
		(if (== gVerb 15) ; screwdriverI
			(if (!= myTarget -1)
				(myTarget dispose:)
				(= myTarget -1)
			)
			(itemView view: 20041)
			(UpdateScreenItem itemView)
			(FrameOut)
			(= gVerb 16) ; ???
			((ScriptID 0 1) set: 999 ((ScriptID 0 4) lookup: 16) 0) ; p2Cursor, cursorLoopTable
		)
	)
)

(instance folderI of P2InvItem
	(properties
		loop 15
		verb 24
		closePic 20015
		draggable 823
	)
)

(instance hairpinI of P2InvItem
	(properties
		view 3
		verb 25
	)
)

(instance paulBookI of P2InvItem
	(properties
		view 3
		loop 1
		verb 27
		closePic 21017
	)
)

(instance printoutI of P2InvItem
	(properties
		view 3
		loop 2
		verb 3
		closePic 21018
	)
)

(instance braceletI of P2InvItem
	(properties
		view 3
		loop 3
		verb 2
	)
)

(instance mailBundleI of P2InvItem
	(properties
		view 3
		loop 4
		verb 30
	)
)

(instance ratI of P2InvItem
	(properties
		view 3
		loop 5
		verb 31
	)
)

(instance laceI of P2InvItem
	(properties
		view 3
		loop 6
		verb 32
	)
)

(instance anagramI of P2InvItem
	(properties
		view 3
		loop 7
		verb 33
	)
)

(instance thereseNoteI of P2InvItem
	(properties
		view 3
		loop 8
		verb 34
		closePic 21024
	)
)

(instance paulSpeechI of P2InvItem
	(properties
		view 3
		loop 9
		verb 35
		closePic 21025
		draggable 723
	)
)

(instance trevCardKeyI of P2InvItem
	(properties
		view 3
		loop 10
		verb 36
	)
)

(instance paperclipI of P2InvItem
	(properties
		view 3
		loop 11
		verb 37
	)
)

(instance extinguisherI of P2InvItem
	(properties
		view 3
		loop 12
		verb 38
	)
)

(instance alienFoodI of P2InvItem
	(properties
		view 3
		loop 13
		verb 39
	)
)

(instance alienI of P2InvItem
	(properties
		view 3
		loop 14
		verb 40
		hotVerb 150
		hotVerb2 144
	)

	(method (showMe)
		(if (== gVerb verb)
			(= myTarget (Rectangle new: 87 42 231 238))
			(return 1)
		else
			(return 0)
		)
	)

	(method (react)
		(switch gVerb
			(150 ; alien3I
				(if (!= myTarget -1)
					(myTarget dispose:)
					(= myTarget -1)
				)
				(itemView setScript: combineS)
			)
			(144 ; alien2I
				(itemView setScript: notS)
			)
		)
	)
)

(instance slimeI of P2InvItem
	(properties
		view 3
		loop 15
		verb 41
		hotVerb 145
	)

	(method (showMe)
		(if (== gVerb verb)
			(= myTarget (Rectangle new: 87 42 231 238))
			(return 1)
		else
			(return 0)
		)
	)

	(method (react)
		(switch gVerb
			(145 ; slime2I
				(if (!= myTarget -1)
					(myTarget dispose:)
					(= myTarget -1)
				)
				(itemView view: 20039)
				(gEgo put: 31 put: 33 get: 37) ; slimeI, slime2I, glopI
				(UpdateScreenItem itemView)
				(FrameOut)
				(= gVerb 151) ; glopI
				((ScriptID 0 1) set: 999 ((ScriptID 0 4) lookup: 151) 0) ; p2Cursor, cursorLoopTable
			)
			(else
				(super react: &rest)
			)
		)
	)
)

(instance alien2I of P2InvItem
	(properties
		view 3
		loop 16
		verb 144
		hotVerb 40
		hotVerb2 150
	)

	(method (showMe)
		(if (== gVerb verb)
			(= myTarget (Rectangle new: 87 42 231 238))
			(return 1)
		else
			(return 0)
		)
	)

	(method (react)
		(switch gVerb
			(40 ; alienI
				(itemView setScript: notS)
			)
			(150 ; alien3I
				(itemView setScript: dieS)
			)
		)
	)
)

(instance slime2I of P2InvItem
	(properties
		view 3
		loop 17
		verb 145
		hotVerb 41
	)

	(method (showMe)
		(if (== gVerb verb)
			(= myTarget (Rectangle new: 87 42 231 238))
			(return 1)
		else
			(return 0)
		)
	)

	(method (react)
		(switch gVerb
			(41 ; slimeI
				(if (!= myTarget -1)
					(myTarget dispose:)
					(= myTarget -1)
				)
				(itemView view: 20039)
				(gEgo put: 31 put: 33 get: 37) ; slimeI, slime2I, glopI
				(UpdateScreenItem itemView)
				(FrameOut)
				(= gVerb 151) ; glopI
				((ScriptID 0 1) set: 999 0) ; p2Cursor
			)
			(else
				(super react: &rest)
			)
		)
	)
)

(instance alienKeyI of P2InvItem
	(properties
		view 3
		loop 18
		verb 43
	)
)

(instance electricAlienI of P2InvItem
	(properties
		view 3
		loop 19
		verb 146
	)
)

(instance alien3I of P2InvItem
	(properties
		view 3
		loop 20
		verb 150
		hotVerb 40
		hotVerb2 144
	)

	(method (showMe)
		(if (== gVerb verb)
			(= myTarget (Rectangle new: 87 42 231 238))
			(return 1)
		else
			(return 0)
		)
	)

	(method (react)
		(switch gVerb
			(40 ; alienI
				(if (!= myTarget -1)
					(myTarget dispose:)
					(= myTarget -1)
				)
				(itemView setScript: combineS)
			)
			(144 ; alien2I
				(itemView setScript: dieS)
			)
		)
	)
)

(instance glopI of P2InvItem
	(properties
		view 3
		loop 21
		verb 151
	)
)

(class InvPlane of Plane
	(properties
		picture -2
		width 60000
		margin 2
		height 115
		enabled 1
		xOff 10
		yOff 76
		selectX 0
	)

	(method (init)
		(super init: &rest)
		(invItems init:)
		(selections init:)
		(self setPri: 2000)
	)

	(method (recalc param1 &tmp temp0)
		(if argc
			(= enabled param1)
		)
		(if (gEgo invSet:)
			(if (not (selections isEmpty:))
				(selections release: 1)
				((self cast:) flush:)
				(= selectX 0)
			)
			(cond
				(enabled
					((gEgo invSet:) eachElementDo: #addMe)
				)
				((and (<= 3006 gCurRoomNum 3008) (gEgo has: 2)) ; mainHallRoomENDGAME, mainHallRoomENDGAMEes, cardKeyI
					(cardKeyI addMe:)
				)
			)
		)
		(if (and (not (selections isEmpty:)) (> xOff 440))
			(lftButn init: (ScriptID 0 3)) ; botInterfacePlane
			(rtButn init: (ScriptID 0 3)) ; botInterfacePlane
		)
		(self update:)
	)

	(method (addItem param1)
		(if (selections isEmpty:)
			(= yOff 34)
			(= xOff 38)
		)
		(param1 cel: 0 posn: xOff yOff init: self)
		(selections add: param1)
		(+= xOff (+ margin 63))
		(return local0)
	)

	(method (scrollItems param1)
		(cond
			((>= (+ param1 selectX) 30) 0)
			((<= (+ xOff selectX param1) 380) 0)
			(else
				(+= selectX param1)
				(selections eachElementDo: #moveX param1)
				(selections eachElementDo: #update)
				(UpdatePlane self)
				(FrameOut)
			)
		)
	)
)

(class ScrollButton of Button
	(properties
		view 1
		delta 0
		moveDelay 25
	)

	(method (update)
		(if (!= gCurRoomNum 900) ; mapRoom
			(super update: &rest)
		)
	)

	(method (handleEvent event &tmp temp0)
		(event localize: plane)
		(if (and (= temp0 (self onMe: event)) (& (event type:) evMOUSEBUTTON))
			(InvPlane scrollItems: delta)
		)
		(self hilite: temp0)
	)
)

(instance lftButn of ScrollButton
	(properties
		x 102
		y 40
		loop 11
		delta 66
	)
)

(instance rtButn of ScrollButton
	(properties
		x 525
		y 40
		loop 10
		delta -66
	)
)

(instance invCUPlane of HotPlane
	(properties
		picture -2
	)

	(method (new)
		(if (or global233 (== gVerb 4)) ; Do
			(return 0)
		else
			(= global234 (Clone self))
			(global234 priority: (+ 1 (GetHighPlanePri)) init: 165 100 485 370)
			(backGround init: global234)
			(if (== (= local1 (invItems firstTrue: #showMe)) -1)
				(= local1 0)
			)
			(itemView
				view:
					(cond
						((and (== local1 mailBundleI) (!= gChapter 3)) 20042)
						((== gVerb 16) 20041) ; ???
						((== gVerb 43) 20034) ; alienKeyI
						((== gVerb 24) 20043) ; folderI
						((== gVerb 151) 20039) ; glopI
						(else
							(+ 20000 (invItems indexOf: local1))
						)
					)
				init: global234
			)
			(= gVerb 4) ; Do
			(gTheCursor set: 999 0)
			(cancelButton init: global234 1 272 10 307 42)
			(if (and local1 (!= (local1 closePic:) -1))
				(superCel init: global234)
			)
			(= global233 1)
			((gUser hogs:) push: global234 1)
			(return global234)
		)
	)

	(method (handleEvent event)
		(if (itemView script:)
			((itemView script:) doit:)
			(return 1)
		)
		(event localize: self)
		(cond
			(
				(and
					local1
					(!= (local1 myTarget:) -1)
					((local1 myTarget:) onMe: event)
				)
				(cond
					((& (event type:) evMOUSEBUTTON)
						(local1 react:)
					)
					(
						(and
							(not local2)
							(or
								(== (local1 hotVerb:) gVerb)
								(== (local1 hotVerb2:) gVerb)
							)
						)
						(= local2 1)
						(gTheCursor set: 999 ((ScriptID 0 4) lookup: gVerb) 1) ; cursorLoopTable
					)
				)
			)
			(local2
				(= local2 0)
				(gTheCursor set: 999 ((ScriptID 0 4) lookup: gVerb) 0) ; cursorLoopTable
			)
		)
		(if (and local1 (!= (local1 closePic:) -1) (superCel onMe: event))
			(superCel handleEvent: event)
		)
		(if (cancelButton onMe: event)
			(cancelButton handleEvent: event)
		)
		(if (event claimed:)
			(return 1)
		)
		(event localize: (ScriptID 0 3)) ; botInterfacePlane
		(cond
			((lftButn onMe: event)
				(lftButn handleEvent: event)
			)
			((rtButn onMe: event)
				(rtButn handleEvent: event)
			)
			(else
				(event globalize:)
				(if (InvPlane onMe: event)
					(event localize: InvPlane)
					((InvPlane cast:) eachElementDo: #handleEvent event)
				)
			)
		)
	)
)

(instance backGround of View
	(properties
		view 4010
	)

	(method (onMe)
		(return 0)
	)
)

(instance itemView of Prop
	(properties
		x 80
		y 40
		view 20001
	)

	(method (doit)
		(super doit: &rest)
		(UpdateScreenItem self)
		(FrameOut)
	)

	(method (onMe)
		(return 0)
	)
)

(instance cancelButton of Feature
	(properties)

	(method (handleEvent event)
		(if (& (event type:) evMOUSERELEASE)
			((gUser hogs:) pop:)
			(event claimed: 1)
			(= global233 0)
			(Send new: global234 8)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance superCel of View
	(properties
		x 242
		y 209
		view 4010
		loop 2
	)

	(method (init)
		(super init: &rest)
		(= plane global234)
		(= priority 2000)
	)

	(method (onMe param1)
		(return (and (< 239 (param1 x:) 304) (< 212 (param1 y:) 259)))
	)

	(method (handleEvent event)
		(if (& (event type:) evMOUSERELEASE)
			(event claimed: 1)
			((gUser hogs:) pop:)
			(= global233 0)
			(Send new: global234 8)
			(Send new: superCUPlane 5)
			(return 1)
		)
	)
)

(instance superCUPlane of HotPlane
	(properties)

	(method (new &tmp temp0)
		(= temp0 (Clone self))
		(temp0
			picture: (local1 closePic:)
			priority: (- ((ScriptID 0 2) priority:) 1) ; topInterfacePlane
			init:
				0
				70
				640
				(if (local1 draggable:)
					(+ (local1 draggable:) 70)
				else
					406
				)
		)
		(= gVerb 4) ; Do
		(if (local1 draggable:)
			(gTheCursor set: 999 46 0)
		else
			(gTheCursor set: 999 ((ScriptID 0 4) lookup: gVerb) 0) ; cursorLoopTable
		)
		(superExitButton init: temp0)
		((gUser hogs:) push: temp0 1)
		(return temp0)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(event localize: self)
		(if (superExitButton onMe: event)
			(superExitButton handleEvent: event)
			(return 1)
		)
		(event globalize:)
		(if (= temp1 (local1 draggable:))
			(cond
				((& (event type:) evMOUSERELEASE)
					(= local3 0)
					(gTheCursor set: 999 46 0)
				)
				(local3
					(if
						(and
							(!= local4 (event y:))
							(< (= temp0 (- (= local4 (event y:)) local3)) 0)
							(> temp0 (- 336 temp1))
						)
						(self setRect: 0 (+ 70 temp0) 640 406 1)
						(FrameOut)
					)
				)
				((& (event type:) evMOUSEBUTTON)
					(gTheCursor set: 999 46 1)
					(= local3 (- (event y:) (- inTop 70)))
				)
			)
		)
	)
)

(instance superExitButton of Button
	(properties
		x 560
		y 70
		view 4010
		loop 3
	)

	(method (init)
		(super init: &rest)
		(= target (Rectangle new: 564 72 627 120))
		(= priority 20000)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOUSERELEASE)
			(event claimed: 1)
			((gUser hogs:) pop:)
			(Send new: plane 8)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance dieS of Script
	(properties)

	(method (doit)
		(= gGameTime (+ gTickOffset (GetTime)))
		(super doit: &rest)
	)

	(method (changeState newState)
		(= state newState)
		(if (<= 1 state 44)
			(if (== newState 39)
				(((gThePlane cast:) itemList:) eachElementDo: #hide)
				(gCurRoom drawPic: 0)
				(gP2SoundFX play: 6002)
			)
			(if (== newState 20)
				(gP2SoundFX play: 6003)
			)
			(itemView cel: newState)
			(UpdateScreenItem itemView)
			(FrameOut)
			(= ticks 12)
		else
			(switch newState
				(0
					(gGame handsOff:)
					(Load 140 6002) ; WAVE
					(Load rsPIC 0)
					(FrameOut)
					(itemView view: 2930 loop: 0 cel: 0 posn: 8 9)
					(UpdateScreenItem itemView)
					(FrameOut)
					(= ticks 12)
				)
				(45
					((gUser hogs:) pop:)
					(itemView cel: 0 loop: 0 posn: 80 40)
					(= global233 0)
					(Send new: global234 8)
					(Send new: gCurRoom 280 999)
				)
			)
		)
	)
)

(instance combineS of Script
	(properties)

	(method (doit)
		(= gGameTime (+ gTickOffset (GetTime)))
		(super doit: &rest)
	)

	(method (changeState newState)
		(= state newState)
		(if (<= 1 state 58)
			(if (== newState 20)
				(gP2SoundFX play: 6003)
			)
			(itemView cel: newState)
			(UpdateScreenItem itemView)
			(FrameOut)
			(= ticks 32)
		else
			(switch newState
				(0
					(Load 140 6003) ; WAVE
					(gGame handsOff:)
					(itemView view: 2910 loop: 0 cel: 0 posn: 10 258)
					(UpdateScreenItem itemView)
					(FrameOut)
					(= ticks 12)
				)
				(59
					(gEgo put: 30 put: 36 get: 34) ; alienI, alien3I, alienKeyI
					(itemView cel: 0 loop: 0 view: 20034 posn: 80 40)
					(UpdateScreenItem itemView)
					(FrameOut)
					(= gVerb 43) ; alienKeyI
					((ScriptID 0 1) set: 999 ((ScriptID 0 4) lookup: 43) 0) ; p2Cursor, cursorLoopTable
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance notS of Script
	(properties)

	(method (doit)
		(= gGameTime (+ gTickOffset (GetTime)))
		(super doit: &rest)
	)

	(method (changeState newState)
		(= state newState)
		(if (<= 1 state 33)
			(itemView cel: newState)
			(if (== newState 20)
				(gP2SoundFX play: 6003)
			)
			(UpdateScreenItem itemView)
			(FrameOut)
			(= ticks 12)
		else
			(switch newState
				(0
					(gGame handsOff:)
					(= scratch (itemView view:))
					(itemView view: 2920 loop: 0 cel: 0 posn: 41 10)
					(UpdateScreenItem itemView)
					(FrameOut)
					(= ticks 12)
				)
				(34
					(itemView loop: 0 cel: 0 view: scratch posn: 80 40)
					(UpdateScreenItem itemView)
					(FrameOut)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

