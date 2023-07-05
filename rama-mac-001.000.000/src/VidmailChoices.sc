;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 55)
(include sci.sh)
(use Main)
(use thighComputer)
(use n056)
(use InvInitialize)
(use SaveManager)
(use RamaInterface)
(use Button)
(use AutoMapProp)
(use n1111)
(use VMDMovie)
(use DSelector)
(use DText)
(use Plane)
(use Str)
(use Array)
(use Sound)
(use Actor)
(use System)

(public
	VidmailChoices 0
	savedVidMail 1
	proc55_2 2
	proc55_3 3
	proc55_4 4
	proc55_5 5
	ChoiceManager 6
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
	[local10 43]
	[local53 322] = [0 0 51 0 0 0 0 1 5 52 1 1 0 0 2 0 0 1 2 0 0 3 0 0 1 3 0 0 4 0 0 1 4 0 0 5 11 53 1 5 0 0 6 0 0 1 6 0 0 7 0 0 1 7 0 0 8 0 0 1 8 0 0 9 0 0 1 9 0 0 10 0 0 1 10 0 0 11 17 54 1 11 0 0 12 0 0 1 12 0 0 13 0 0 1 13 0 0 14 0 0 1 14 0 0 15 0 0 1 15 0 0 16 0 0 1 16 0 0 17 18 55 2 17 0 0 18 19 56 1 19 35011 35010 19 22 57 3 21 38031 38030 20 0 0 3 67 38711 38710 21 0 0 3 68 38621 38620 22 23 58 3 22 38521 38520 23 24 59 2 23 0 0 24 25 60 3 24 38461 38460 25 26 61 3 25 38831 38830 26 27 62 1 26 38051 38050 27 28 69 2 50 0 0 28 29 70 1 65 38541 38540 29 30 71 3 66 0 0 30 31 72 2 75 0 38835 31 32 73 2 76 0 0 32 33 74 2 77 0 0 33 34 89 2 88 0 0 34 35 63 3 27 38011 38010 35 36 63 3 28 38121 38120 36 37 63 3 29 38411 38410 37 38 63 3 30 38471 38470 38 39 63 3 31 38421 38420 39 40 63 3 32 0 38480 40 41 63 3 33 38431 38430 41 42 63 3 34 38311 38310 42 43 63 3 35 38441 38440 43 44 63 3 36 38151 38150 44 45 63 3 37 38211 38210 45 46 63 3 38 38221 38220]
	local375
)

(procedure (proc55_3 param1 &tmp temp0)
	(cond
		((== param1 -1)
			(= temp0 (VidmailChoices current:))
			(VidmailChoices dispose:)
			(VidmailChoices init: global189 1 temp0)
			(return)
		)
		((IsFlag 12)
			(ChoiceManager dispose:)
			(ChoiceManager init: param1)
			(= global189 param1)
			(return)
		)
		((IsFlag 14)
			((ScriptID 75 0) dispose:) ; InvInset
		)
		((AutoMapInset curMapInset:)
			(proc44_4)
		)
	)
	(= global189 param1)
	(if (>= param1 34)
		(sPlayIncomingMessage register: param1)
		(if (gGame script:)
			((gGame script:) setScript: sPlayIncomingMessage)
		else
			(gGame setScript: sPlayIncomingMessage)
		)
		(return)
	)
	(if (not (IsFlag 1))
		(proc90_1)
	)
	(proc44_5)
	(ChoiceManager init: param1)
	(SetFlag 12)
)

(procedure (proc55_4 &tmp temp0)
	(ClearFlag 12)
	(ChoiceManager dispose:)
	(proc44_6)
)

(procedure (proc55_2 param1 &tmp temp0)
	(return
		(switch (proc70_7 param1)
			(18 17)
			(19 18)
			(20 19)
			(21 22)
			(22 23)
			(23 24)
			(24 25)
			(25 26)
			(26 27)
			(27 28)
			(28 30)
			(29 31)
			(30 32)
			(else 0)
		)
	)
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp3 (Str new: 50))
	(= temp2 (Str new: 50))
	(= temp6 (Str new: 50))
	(= temp1 (Str new: 50))
	(localproc_2 param2)
	(for ((= temp0 0)) (< temp0 (vidmailList size:)) ((++ temp0))
		(= temp4 ((vidmailList at: temp0) case:))
		(localproc_1 1 0 temp4 55 temp3)
		(if (and (< param2 34) (!= temp4 64))
			(localproc_1 11 0 temp4 55 temp2)
			(localproc_1 11 0 0 55 temp6)
			(if
				(and
					(OneOf ((vidmailList at: temp0) vidmailNum:) 23 27 32)
					(!= (proc70_9 31) 55)
					(!= (proc70_9 32) 55)
				)
				(proc56_0 temp2 temp1)
			else
				(temp1 copy: (temp2 data:))
			)
			(temp6 cat: (temp1 data:))
			(temp3 cat: (temp6 data:))
		)
		(param1 setText: temp3)
	)
	(temp6 dispose:)
	(temp2 dispose:)
	(temp1 dispose:)
	(temp3 dispose:)
	(param1 textList:)
)

(procedure (localproc_1 param1 param2 param3 param4 param5 &tmp temp0 [temp1 2] temp3)
	(= temp3 1)
	(if (not (Message msgGET param4 param1 param2 param3 1))
		(return)
	)
	(= temp0 (Str new:))
	(Message msgGET param4 param1 param2 param3 1 (temp0 data:))
	(param5 copy: (temp0 data:))
	(while (Message msgGET param4 param1 param2 param3 (++ temp3) (temp0 data:))
		(param5 cat: (temp0 data:))
	)
	(temp0 dispose:)
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp5 (* (= temp0 param1) 7))
	(listTitle case: [local53 (+ temp5 2)])
	(cond
		(temp0
			(= temp1 [local53 (+ temp5 1)])
			(for ((= temp2 temp0)) (< temp2 temp1) ((++ temp2))
				(if (== [local53 (+ (= temp5 (* temp2 7)) 3)] 2)
					(= temp4 (DocReader new:))
				else
					(= temp4 (VMItem new:))
				)
				(temp4 vidmailNum: temp2 case: [local53 (+ temp5 4)])
				(if (not (proc55_5 temp2))
					(savedVidMail
						addToEnd: ((VMNumber new:) vidmailNum: temp2 yourself:)
					)
				)
				(if (not (localproc_3 temp2))
					(vidmailList add: temp4)
				)
			)
		)
		((savedVidMail isEmpty:)
			(= temp4 ((VMItem new:) case: 64 yourself:))
			(vidmailList add: temp4)
		)
		(else
			(for ((= temp2 0)) (< temp2 (savedVidMail size:)) ((++ temp2))
				(if
					(==
						[local53
							(+
								(= temp5
									(*
										(= temp3
											((savedVidMail at: temp2)
												vidmailNum:
											)
										)
										7
									)
								)
								3
							)
						]
						2
					)
					(= temp4 (DocReader new:))
				else
					(= temp4 (VMItem new:))
				)
				(temp4 vidmailNum: temp3 case: [local53 (+ temp5 4)])
				(if (not (localproc_3 temp3))
					(vidmailList addToFront: temp4)
				)
			)
		)
	)
)

(procedure (localproc_3 param1 &tmp temp0)
	(if (not (vidmailList isEmpty:))
		(for ((= temp0 0)) (< temp0 (vidmailList size:)) ((++ temp0))
			(if (== ((vidmailList at: temp0) vidmailNum:) param1)
				(return 1)
			)
		)
	)
	(return 0)
)

(procedure (proc55_5 param1 &tmp temp0)
	(if (not (savedVidMail isEmpty:))
		(for ((= temp0 0)) (< temp0 (savedVidMail size:)) ((++ temp0))
			(if (== ((savedVidMail at: temp0) vidmailNum:) param1)
				(return 1)
			)
		)
	)
	(return 0)
)

(instance docPlane of Plane
	(properties)
)

(instance docCast of Cast
	(properties)
)

(class DocReader of DText
	(properties
		fore 217
		back 0
		font 2207
		vidmailNum 0
		startPic 0
		length 22
	)

	(method (close)
		(docCast release: self)
		(DeleteScreenItem self)
		(docCast dispose:)
		(docPlane dispose:)
		(= local2 0)
		(= local1 0)
	)

	(method (setup)
		(if (== vidmailNum 30)
			(= startPic 38835)
		else
			(= startPic 78)
		)
		(= type 2)
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(if (== vidmailNum 30)
			(= local2 1)
			(= local1 1)
		)
		(= temp0 (Str new:))
		(= temp1 (Str new:))
		(localproc_1 7 0 case 55 temp0)
		(if
			(and
				(OneOf vidmailNum 23 27 32)
				(!= (proc70_9 31) 55)
				(!= (proc70_9 32) 55)
			)
			(proc56_0 temp0 temp1)
		else
			(temp1 copy: (temp0 data:))
		)
		(= temp2 (IntArray with: 0 0 0 0))
		(Text 0 (temp2 data:) (temp1 data:) font 315)
		(= local3 (temp2 at: 3))
		(= local0 0)
		(Text 0 (temp2 data:) {M} font 0)
		(= local4 (* (= temp3 (temp2 at: 3)) length))
		(= local5 (- 62 local3))
		(temp2 dispose:)
		(docCast init:)
		(docPlane
			picture: -2
			priority: (+ ((ScriptID 44 0) plane:) 1) ; thighComputer
			init: 285 62 600 (+ local3 62) 285 62 600 (- (+ 62 local4) 4)
			addCast: docCast
		)
		(self
			x: 0
			y:
				(if local2
					(+= local0 local4)
				else
					local0
				)
			text: (temp1 data:)
			setSize: 315
		)
		(super init: docCast &rest)
		(if local2
			(+= local5 local4)
			(startView priority: (+ (self priority:) 5) init: docCast x: 0 y: 0)
			(UpdateScreenItem startView)
			(UpdateScreenItem self)
			(FrameOut)
		)
	)

	(method (handleEvent event)
		(if (and (== (event type:) evNULL) (self onMe: event))
			(gTheCursor setTempCursor:)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)
)

(class VMItem of VMDMovie
	(properties
		x 0
		y 0
		options 64
		vidmailNum 0
		case 0
		startPic 0
		finishPic 0
		type 0
	)

	(method (setup &tmp temp0)
		(= movieName [local53 (+ (= temp0 (* vidmailNum 7)) 5)])
		(= startPic [local53 (+ temp0 6)])
		(= type [local53 (+ temp0 3)])
		(switch type
			(1
				(= x 241)
				(= y 60)
			)
			(3
				(= x 313)
				(= y 60)
			)
		)
		(if
			(and
				(<= global188 3)
				(OneOf vidmailNum 18 19 20 21 24 26 35 36 42)
			)
			(switch vidmailNum
				(18
					(self cacheSize: 1000 preLoadPCT: 50)
				)
				(19
					(self cacheSize: 600 preLoadPCT: 80)
				)
				(20
					(self cacheSize: 800 preLoadPCT: 80)
				)
				(21
					(self cacheSize: 1200 preLoadPCT: 90)
				)
				(24
					(self cacheSize: 1000 preLoadPCT: 70)
				)
				(26
					(self cacheSize: 1000 preLoadPCT: 100)
				)
				(35
					(self cacheSize: 1500 preLoadPCT: 100)
				)
				(36
					(self cacheSize: 1000 preLoadPCT: 100)
				)
				(42
					(self cacheSize: 1000 preLoadPCT: 100)
				)
			)
		else
			(self cacheSize: 512 preLoadPCT: 100)
		)
		(self open:)
	)

	(method (init)
		(super init: &rest)
	)

	(method (play)
		(if (not local8)
			(|= waitEvents $0004)
			(self showCursor: 1)
			(stopButn setActive: 1)
		else
			(self showCursor: 0)
			(= waitEvents 3)
		)
		(super play: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3
				(if (not local8)
					(playButn setActive: 1)
					(stopButn setActive: 0)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class VidmailChoices of DSelector
	(properties
		priority 200
		fixPriority 1
		font 1
		length 5
		width 160
		fore 227
		back 0
		leading 3
		lastCurrent -1
	)

	(method (needScrollBar)
		(return (> (textList size:) length))
	)

	(method (init param1 param2 param3)
		(= local6 0)
		(localproc_0 self param1)
		(= upButton (= downButton -1))
		(gExtMouseHandler add: self)
		(gKeyDownHandler add: self)
		(= x (= y (= nsLeft (= nsTop (= nsRight (= nsBottom 0))))))
		(if (and (>= argc 2) param2)
			(if (and (>= argc 3) param3)
				(= current param3)
			else
				(= current 0)
			)
		else
			(= current -1)
		)
		(= lastCurrent -1)
		(self leading: 3 width: 160 setSize: 1 length: 5 move: 0 42)
		(super init: choiceCast &rest)
		(listPlane picture: -2 priority: (- (listPlane priority:) 2))
		(UpdatePlane listPlane)
		(if (!= current -1)
			(self draw:)
			(ChoiceManager changeVidmail:)
		)
	)

	(method (dispose)
		(gExtMouseHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((and (not (event type:)) (listPlane onMe: event))
				(event claimed: 1)
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			((== (event type:) evMOUSEBUTTON)
				(event globalize:)
				(if (listPlane onMe: event)
					(event localize: listPlane)
					(if (= temp0 (textList firstTrue: #onMe event))
						(= lastCurrent current)
						(= current (textList indexOf: temp0))
						(self draw:)
						(ChoiceManager changeVidmail:)
					)
				)
				(event localize: plane)
			)
			((and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				(event claimed: 1)
				(if (!= current -1)
					(if (< current first)
						(self scrollUp: 0 1)
					else
						(self scrollDown: 0 1)
					)
				)
			)
			((& (event type:) $0014) ; direction | evKEYBOARD
				(switch (event message:)
					(JOY_DOWN
						(event claimed: 1)
						(self scrollDown: 1 1)
					)
					(JOY_UP
						(self scrollUp: 1 1)
						(event claimed: 1)
					)
					(else
						(event claimed: 0)
					)
				)
				(event claimed:)
				(return)
			)
		)
		(if (event claimed:)
			(return self)
		)
	)

	(method (draw &tmp temp0 temp1 temp2 temp3 temp4)
		(if (textList size:)
			(= temp3 (textList at: current))
			(= temp0 (KList 3 (textList elements:))) ; FirstNode
			(for ((= temp4 0)) temp0 ((++ temp4))
				(= temp1 (KList 6 temp0)) ; NextNode
				(= temp2 (KList 8 temp0)) ; NodeValue
				(temp2
					moveTo: 2 (+ 1 (* (- first temp4) -1 textHeight))
					fore: (if (== temp3 temp2) 224 else fore)
					back: (if (== temp3 temp2) back else back)
					draw:
				)
				(UpdateScreenItem temp2)
				(= temp0 temp1)
			)
		)
		(if gSaveFileSelText
			(gSaveFileSelText dispose:)
			(= gSaveFileSelText 0)
		)
		(if (>= (- (textList size:) 1) current 0)
			(= gSaveFileSelText (Str with: ((textList at: current) text:)))
		)
		(if (choiceCast contains: scrollUpButn)
			(scrollUpButn setActive:)
			(scrollDownButn setActive:)
		)
	)

	(method (setText param1 &tmp temp0 [temp1 2] temp3 temp4)
		(if (and (not param1) textList)
			(textList dispose:)
			(= textList 0)
		)
		(if (not textList)
			(= textList ((Cast new:) name: {DSList} add: yourself:))
		)
		(if param1
			(= temp3 (Str new:))
			(for
				((= temp0 0))
				(and (< temp0 argc) (< (textList size:) 250))
				((++ temp0))
				
				(temp3 copy: [param1 temp0])
				(textList
					add:
						((SelectorDText new:)
							font: font
							back: back
							skip: back
							fore: fore
							text: (KArray 8 (temp3 data:)) ; ArrayDup
							setSize: (- width 4)
							yourself:
						)
				)
			)
			(temp3 dispose:)
			(if (not length)
				(= length argc)
			)
			(if listPlane
				(listPlane addCast: textList)
				(textList eachElementDo: #init textList)
			)
		)
	)

	(method (scrollDown param1 param2 &tmp temp0)
		(= temp0 (if argc param1 else 1))
		(if (and (>= argc 2) param2)
			(if
				(>=
					(= current (+ (= lastCurrent current) param1))
					(textList size:)
				)
				(= current (- (textList size:) 1))
			)
			(cond
				((>= current (+ first length))
					(= first (- current (- length 1)))
				)
				((< current first)
					(= first current)
				)
			)
			(self draw:)
			(UpdatePlane listPlane)
			(FrameOut)
			(if (or (== param1 0) (!= lastCurrent current))
				(ChoiceManager changeVidmail:)
			)
		else
			(if (<= (+ first length temp0) (textList size:))
				(+= first temp0)
			)
			(self draw:)
			(UpdatePlane listPlane)
			(FrameOut)
		)
	)

	(method (scrollUp param1 param2 &tmp temp0)
		(= temp0 (if argc param1 else 1))
		(if (and (>= argc 2) param2)
			(if (< (= current (- (= lastCurrent current) param1)) 0)
				(= current 0)
			)
			(cond
				((>= current (+ first length))
					(= first (- current (- length 1)))
				)
				((< current first)
					(= first current)
				)
			)
			(self draw:)
			(UpdatePlane listPlane)
			(FrameOut)
			(if (or (!= lastCurrent current) (== param1 0))
				(ChoiceManager changeVidmail:)
			)
		else
			(if (< (- first param1) 0)
				(= first 0)
			else
				(-= first param1)
			)
			(self draw:)
			(UpdatePlane listPlane)
			(FrameOut)
		)
	)

	(method (setNSRect param1 param2 param3 param4)
		(= nsLeft param1)
		(= nsTop param2)
		(= nsRight param3)
		(= nsBottom param4)
		(= length (/ nsBottom textHeight))
	)
)

(instance choicesPlane of Plane
	(properties)

	(method (handleEvent event)
		(cond
			((and extMH (extMH handleEvent: event))
				(event claimed: 1)
				(return)
			)
			((and (== (event type:) evNULL) (self onMe: event))
				(gTheCursor setTempCursor:)
				(event claimed: 1)
				(return)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance choiceCast of Cast
	(properties)
)

(class ChoiceManager of Obj
	(properties
		vidnumber 0
	)

	(method (init param1)
		(= vidnumber param1)
		(super init: &rest)
		(= local9 0)
		(= local6 0)
		(choiceCast init:)
		(choicesPlane
			name: {theChoicesPlane}
			picture: -2
			priority: (- (GetHighPlanePri) 1)
			init: 10 40 209 300
			posn: 10 40 ((ScriptID 44 0) plane:) ; thighComputer
		)
		(choicesPlane addCast: choiceCast)
		(VidmailChoices init: vidnumber 0)
		(listTitle plane: choicesPlane init: choiceCast)
		(theReturnButton plane: choicesPlane init: choiceCast)
		(if (VidmailChoices needScrollBar:)
			(scrollUpButn init: choiceCast)
			(scrollDownButn init: choiceCast)
		)
		(gGame handsOn:)
		(UpdatePlane choicesPlane)
	)

	(method (changeVidmail)
		(cond
			((and local6 (== (local6 case:) 64))
				(return)
			)
			((== (VidmailChoices lastCurrent:) (VidmailChoices current:))
				(if (local6 isKindOf: VMItem)
					(playButn doVerb: 2)
				)
				(return)
			)
			(local6
				(local6 close:)
				(= local6 0)
			)
		)
		(= local6 (vidmailList at: (VidmailChoices current:)))
		(if (!= (local6 case:) 64)
			((ScriptID 44 0) setScript: sBringUpVidmail) ; thighComputer
		)
	)

	(method (dispose)
		(if (((ScriptID 44 0) insetCast:) contains: playButn) ; thighComputer
			(local6 close:)
			(playButn dispose:)
			(stopButn dispose:)
			(startView dispose:)
			(UpdatePlane ((ScriptID 44 0) plane:)) ; thighComputer
		)
		(if (((ScriptID 44 0) insetCast:) contains: nextButn) ; thighComputer
			(nextButn dispose:)
			(UpdatePlane ((ScriptID 44 0) plane:)) ; thighComputer
		)
		(if (and local6 (!= (local6 case:) 64))
			(local6 close:)
			(if (> global188 3)
				(endMovie plane: ((ScriptID 44 0) plane:) play:) ; thighComputer
			)
		)
		(if (<= global188 3)
			(((ScriptID 44 0) plane:) drawPic: 41) ; thighComputer
		else
			(((ScriptID 44 0) plane:) drawPic: 40) ; thighComputer
		)
		(UpdatePlane ((ScriptID 44 0) plane:)) ; thighComputer
		(= local6 0)
		(vidmailList release:)
		(choiceCast dispose:)
		(choicesPlane dispose:)
		(super dispose: &rest)
	)

	(method (serialize param1 &tmp [temp0 2] temp2 temp3 temp4 temp5)
		(if (and argc param1)
			(if (vidmailList size:)
				(vidmailList dispose:)
			)
			(if (savedVidMail size:)
				(savedVidMail dispose:)
			)
			(= temp2 (SaveManager readWord:))
			(for ((= temp3 0)) (< temp3 temp2) ((++ temp3))
				((= temp4 (VMNumber new:)) vidmailNum: (SaveManager readWord:))
				(savedVidMail add: temp4)
			)
		else
			(SaveManager writeWord: (savedVidMail size:))
			(for ((= temp3 0)) (< temp3 (savedVidMail size:)) ((++ temp3))
				(SaveManager writeWord: ((savedVidMail at: temp3) vidmailNum:))
			)
		)
	)
)

(instance savedVidMail of List
	(properties)
)

(instance vidmailList of List
	(properties)
)

(instance nextButn of Button
	(properties
		noun 119
		case 8
		priority 255
		view 207
		upLoop 0
		downLoop 1
		downCel 0
	)

	(method (init)
		(if (> local3 local4)
			(= x 287)
			(= y 284)
			(= active 1)
			(= case 8)
			(&= signal $efff)
			(super init: &rest)
			(gExtMouseHandler addToFront: self)
			(self setHotspot: 1)
			(prevButn init: ((ScriptID 44 0) insetCast:)) ; thighComputer
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if active
					(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
				)
			)
			(2
				(if (and (> local0 local5) active)
					(butnSnd play:)
					(-= local0 local4)
					(local6 y: local0)
					(if (and local2 local1)
						(= local1 0)
						(startView hide:)
					)
					(UpdateScreenItem local6)
					(FrameOut)
					(if (<= (- local0 local4) local5)
						(self setActive: 0)
					)
				)
				(prevButn setActive: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(prevButn dispose:)
		(gExtMouseHandler delete: self)
		(super dispose: &rest)
	)
)

(instance prevButn of Button
	(properties
		noun 120
		case 8
		priority 255
		view 207
		cel 1
		upLoop 0
		upCel 1
		downLoop 1
	)

	(method (init)
		(= x (+ (nextButn nsRight:) 10))
		(= y (nextButn nsTop:))
		(= active 0)
		(= case 8)
		(&= signal $efff)
		(super init: &rest)
		(gExtMouseHandler addToFront: self)
		(self setHotspot: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if active
					(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
				)
			)
			(2
				(if (and (< local0 local4) active)
					(if (>= (+= local0 local4) local4)
						(= local0 local4)
						(if local2
							(startView show:)
							(= local1 1)
						)
						(self setActive: 0)
					)
					(butnSnd play:)
					(local6 y: local0)
					(UpdateScreenItem local6)
					(FrameOut)
				)
				(nextButn setActive: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gExtMouseHandler delete: self)
		(super dispose: &rest)
	)
)

(instance startView of View
	(properties)

	(method (init)
		(= view (local6 startPic:))
		(self posn: (- (local6 x:) 30) (- (local6 y:) 40))
		(super init: &rest)
	)
)

(instance startMovie of VMDMovie
	(properties
		movieName 38420
	)
)

(instance endMovie of VMDMovie
	(properties
		movieName 38999
		options 64
	)
)

(instance listTitle of DText
	(properties
		case 51
		fore 227
		back 0
		font 2207
	)

	(method (init &tmp temp0)
		(= temp0 (Str new:))
		(Message msgGET 55 6 0 case 1 (temp0 data:))
		(self x: 0 y: 32 text: (temp0 data:) skip: back setSize: 196)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (== (event type:) evNULL) (self onMe: event))
			(gTheCursor setTempCursor:)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)
)

(instance theReturnButton of View
	(properties
		noun 92
		y 12
		view 207
		loop 2
		cel 5
	)

	(method (init)
		(super init: choiceCast &rest)
		(self setHotspot: 2)
		(&= signal $efff)
		(= case 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(RamaInterface displayOptionsText: 90 noun 0 case 1)
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(butnSnd play:)
				(if (IsFlag 12)
					(proc55_4)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance scrollUpButn of Button
	(properties
		priority 254
		fixPriority 1
		view 207
		cel 1
		upLoop 0
		upCel 1
		downLoop 1
		doVerbCalled 1
	)

	(method (init &tmp temp0 temp1)
		(= x (VidmailChoices nsRight:))
		(= temp1 (VidmailChoices nsTop:))
		(= temp0 (VidmailChoices nsBottom:))
		(= y temp1)
		(&= signal $efff)
		(super init: &rest)
		(self setHotspot: 1)
		(self setActive: 0)
		(gExtMouseHandler addToFront: self)
	)

	(method (setActive param1 &tmp temp0)
		(cond
			(argc
				(super setActive: param1)
			)
			((> (= temp0 (VidmailChoices first:)) 0)
				(super setActive: 1)
			)
			(else
				(super setActive: 0)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(switch theVerb
			(1
				(if active
					(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
				)
			)
			(2
				(if (> (= temp0 (VidmailChoices first:)) 0)
					(VidmailChoices scrollUp: 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gExtMouseHandler delete: self)
		(super dispose: &rest)
	)
)

(instance scrollDownButn of Button
	(properties
		priority 255
		fixPriority 1
		view 207
		upLoop 0
		downLoop 1
		downCel 0
		doVerbCalled 1
	)

	(method (init &tmp temp0 temp1)
		(= x (scrollUpButn x:))
		(= y (= temp1 (VidmailChoices nsBottom:)))
		(&= signal $efff)
		(super init: &rest)
		(self setActive: 1)
		(self setHotspot: 1)
		(gExtMouseHandler addToFront: self)
	)

	(method (setActive param1 &tmp temp0)
		(cond
			(argc
				(super setActive: param1)
			)
			(
				(<
					(= temp0
						(+ (VidmailChoices first:) (VidmailChoices length:))
					)
					((VidmailChoices textList:) size:)
				)
				(super setActive: 1)
			)
			(else
				(super setActive: 0)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(if active
					(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
				)
			)
			(2
				(if
					(<
						(= temp0
							(+ (VidmailChoices first:) (VidmailChoices length:))
						)
						((VidmailChoices textList:) size:)
					)
					(VidmailChoices scrollDown: 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gExtMouseHandler delete: self)
		(super dispose: &rest)
	)
)

(instance playButn of Button
	(properties
		noun 98
		case 8
		priority 255
		view 207
		cel 2
		upLoop 0
		upCel 2
		downLoop 1
		downCel 2
	)

	(method (init)
		(switch (local6 type:)
			(1
				(= x 287)
				(= y 250)
			)
			(3
				(= x 357)
				(= y 250)
			)
			(else
				(PrintDebug {wrong type of vidmail for playButn!!!})
			)
		)
		(= active 1)
		(= case 8)
		(&= signal $efff)
		(super init: &rest)
		(self setHotspot: 1)
		(plane addExtMH: self)
	)

	(method (cue)
		(self setActive: 1)
		(stopButn setActive: 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if active
					(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
				)
			)
			(2
				(if active
					(butnSnd play:)
					(self setActive: 0)
					(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
					(stopButn setActive: 1)
					(local6 play: self)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(plane deleteExtMH: self)
		(super dispose: &rest)
	)
)

(instance stopButn of Button
	(properties
		noun 99
		case 8
		view 207
		cel 6
		upLoop 0
		upCel 6
		downLoop 1
		downCel 6
	)

	(method (init)
		(= x (+ (playButn nsRight:) 50))
		(= y (playButn y:))
		(super init: &rest)
		(self setActive: 0)
		(self setHotspot: 1)
		(plane addExtMH: self)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(if active
					(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
				)
			)
			(2
				(if active
					(butnSnd play:)
					(self setActive: 0)
					(local6 close:)
					(playButn setActive: 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(plane deleteExtMH: self)
		(super dispose: &rest)
	)
)

(instance sBringUpVidmail of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local8 1)
				(gGame handsOff:)
				(local6 setup:)
				(= seconds 1)
			)
			(1
				(if (and (== local9 0) (> global188 3))
					(((ScriptID 44 0) plane:) drawPic: 40) ; thighComputer
					(startMovie plane: ((ScriptID 44 0) plane:) play: self) ; thighComputer
				else
					(if (((ScriptID 44 0) insetCast:) contains: playButn) ; thighComputer
						(playButn dispose:)
						(stopButn dispose:)
						(startView dispose:)
					)
					(if (((ScriptID 44 0) insetCast:) contains: nextButn) ; thighComputer
						(nextButn dispose:)
					)
					(UpdatePlane ((ScriptID 44 0) plane:)) ; thighComputer
					(= cycles 1)
				)
			)
			(2
				(gGame handsOff:)
				(= local9 (local6 type:))
				(switch (local6 type:)
					(2
						(if (!= (((ScriptID 44 0) plane:) picture:) 76) ; thighComputer
							(((ScriptID 44 0) plane:) drawPic: 76) ; thighComputer
						)
					)
					(1
						(if (!= (((ScriptID 44 0) plane:) picture:) 75) ; thighComputer
							(((ScriptID 44 0) plane:) drawPic: 75) ; thighComputer
						)
					)
					(3
						(if (!= (((ScriptID 44 0) plane:) picture:) 77) ; thighComputer
							(((ScriptID 44 0) plane:) drawPic: 77) ; thighComputer
						)
					)
				)
				(UpdatePlane ((ScriptID 44 0) plane:)) ; thighComputer
				(FrameOut)
				(= cycles 1)
			)
			(3
				(local6 init:)
				(if (!= (local6 type:) 2)
					(if (not (((ScriptID 44 0) insetCast:) contains: playButn)) ; thighComputer
						(playButn init: ((ScriptID 44 0) insetCast:)) ; thighComputer
						(stopButn init: ((ScriptID 44 0) insetCast:)) ; thighComputer
					)
					(startView init: ((ScriptID 44 0) insetCast:)) ; thighComputer
				else
					(nextButn init: ((ScriptID 44 0) insetCast:)) ; thighComputer
				)
				(UpdatePlane ((ScriptID 44 0) plane:)) ; thighComputer
				(FrameOut)
				(= local8 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPlayIncomingMessage of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 1)
				(= cycles 2)
			)
			(1
				(incomingSnd play: self)
			)
			(2
				(if (not (IsFlag 1))
					(proc90_1)
				)
				(= cycles 2)
			)
			(3
				(proc44_5)
				(ChoiceManager init: register)
				(SetFlag 12)
				((ScriptID 44 0) setScript: sPlayRealTime) ; thighComputer
				(self dispose:)
			)
		)
	)
)

(instance sGoToMorgue of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc90_2)
				(= cycles 1)
			)
			(1
				(gCurRoom newRoom: 95) ; morgue
				(self dispose:)
			)
		)
	)
)

(instance sPlayRealTime of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 (vidmailList at: 0))
				(local6 setup:)
				(if (<= global188 3)
					(((ScriptID 44 0) plane:) drawPic: 41) ; thighComputer
					(= cycles 2)
				else
					(((ScriptID 44 0) plane:) drawPic: 40) ; thighComputer
					(startMovie plane: ((ScriptID 44 0) plane:) play: self) ; thighComputer
				)
			)
			(1
				(= local9 (local6 type:))
				(= local375 (local6 vidmailNum:))
				(((ScriptID 44 0) plane:) drawPic: 77) ; thighComputer
				(UpdatePlane ((ScriptID 44 0) plane:)) ; thighComputer
				(FrameOut)
				(= cycles 1)
			)
			(2
				(startView init: ((ScriptID 44 0) insetCast:)) ; thighComputer
				(UpdatePlane ((ScriptID 44 0) plane:)) ; thighComputer
				(FrameOut)
				(= cycles 1)
			)
			(3
				(local6 play: self)
			)
			(4
				(gGame handsOn:)
				(= local8 0)
				(startView dispose:)
				(proc55_4)
				(= cycles 1)
			)
			(5
				(if (or (== local375 40) (== local375 39))
					(gGame setScript: sGoToMorgue)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(class VMNumber of Obj
	(properties
		vidmailNum 0
	)
)

(instance computerSnd of Sound ; UNUSED
	(properties
		flags 5
		number 1013
	)
)

(instance butnSnd of Sound
	(properties
		flags 5
		number 4003
	)
)

(instance incomingSnd of Sound
	(properties
		flags 5
		number 1014
	)
)

