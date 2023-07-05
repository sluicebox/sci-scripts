;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1013)
(include sci.sh)
(use Main)
(use RamaInterface)
(use SoundManager)
(use Button)
(use n1111)
(use VMDMovie)
(use DSelector)
(use DText)
(use Plane)
(use Str)
(use Inset)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	hubComputer 0
	proc1013_1 1
	proc1013_2 2
	proc1013_3 3
)

(local
	local0
	local1
)

(procedure (proc1013_3) ; UNUSED
	(if (IsFlag 14)
		((ScriptID 75 0) dispose:) ; InvInset
	)
	(SetFlag 94)
	(hubComputer init:)
)

(procedure (proc1013_1 &tmp temp0)
	(if (IsFlag 91)
		(proc1013_2)
	)
	(hubComputer dispose:)
	(ClearFlag 94)
)

(procedure (proc1013_2)
	(ClearFlag 91)
	(if ((hubComputer insetCast:) contains: playButn)
		(local0 close:)
		(playButn dispose:)
		(stopButn dispose:)
		(startView dispose:)
		(UpdatePlane (hubComputer plane:))
		(if (> global188 3)
			(endMovie plane: (hubComputer plane:) play:)
		)
	)
	(HelloManager dispose:)
)

(procedure (localproc_0)
	(SetFlag 91)
	(HelloManager init:)
)

(procedure (localproc_1 param1 &tmp temp0 temp1 temp2)
	(helloList
		init:
		addToFront:
			shigeruIntro
			davidIntro
			francescaIntro
			ottoIntro
			michaelIntro
			richardIntro
			reggieIntro
			irinaIntro
			nicoleIntro
	)
	(= temp1 (Str new: 50))
	(for ((= temp0 0)) (< temp0 (helloList size:)) ((++ temp0))
		(= temp2 ((helloList at: temp0) case:))
		(localproc_2 8 0 temp2 55 temp1)
		(param1 setText: temp1)
	)
	(temp1 dispose:)
	(param1 textList:)
)

(procedure (localproc_2 param1 param2 param3 param4 param5 &tmp temp0)
	(if (not (Message msgGET param4 param1 param2 param3 1))
		(return)
	)
	(= temp0 (Str new: 400))
	(Message msgGET param4 param1 param2 param3 1 (temp0 data:))
	(param5 copy: (temp0 data:))
	(while (Message msgNEXT (temp0 data:))
		(param5 cat: (temp0 data:))
	)
	(temp0 dispose:)
)

(procedure (localproc_3)
	(helloButton hide:)
	(theExitButton hide:)
)

(procedure (localproc_4)
	(helloButton show:)
	(theExitButton show:)
)

(instance hubComputer of Inset
	(properties)

	(method (init)
		(SoundManager pauseMusic: 1 10 20)
		(= priority (+ ((gCurRoom plane:) priority:) 4))
		(if (<= global188 3)
			(= picture 41)
		else
			(= picture 40)
		)
		(super init: &rest)
		(SetFlag 94)
		(helloButton plane: (self plane:) init:)
		(theExitButton plane: (self plane:) init:)
		(if (> global188 3)
			(logoCast init:)
			(logoPlane
				picture: -2
				priority: (+ ((self plane:) priority:) 2)
				init: 0 0 130 100
				posn: 0 0 (self plane:)
			)
			(logoPlane addCast: logoCast)
			(ISALogo init: logoCast)
			(UpdatePlane logoPlane)
		else
			(ISALogo init: (self insetCast:))
		)
		(gTheDoits add: ISALogo)
		(ISALogo setCycle: Fwd)
	)

	(method (drawInset)
		(if (!= picture -1)
			(plane drawPic: picture)
		)
		(if inView
			(plane setBitmap: inView 0)
		)
		(UpdatePlane plane)
		(FrameOut)
	)

	(method (dispose)
		(SoundManager pauseMusic: 0 10 20)
		(if (IsFlag 91)
			(proc1013_2)
		)
		(ClearFlag 94)
		(gTheDoits delete: ISALogo)
		(if (> global188 3)
			(logoCast dispose:)
			(logoPlane dispose:)
		)
		(super dispose: &rest)
	)
)

(class HelloManager of Obj
	(properties)

	(method (init)
		(super init: &rest)
		(= local0 0)
		(localproc_1 HelloChoices)
		(helloCast init:)
		(helloPlane
			picture: -2
			priority: (+ ((hubComputer plane:) priority:) 3)
			init: 0 0 249 300
			posn: 0 0 (hubComputer plane:)
		)
		(helloPlane addCast: helloCast)
		(HelloChoices init: helloCast)
		(localproc_3)
		(goodbyeButton init: helloCast)
		(listTitle init:)
		(scrollUpButn init: helloCast)
		(scrollDownButn init: helloCast)
		(UpdatePlane helloPlane)
	)

	(method (changeVidmail)
		(cond
			((== (HelloChoices lastCurrent:) (HelloChoices current:))
				(playButn doVerb: 2)
				(return)
			)
			(local0
				(local0 close:)
				(= local0 0)
			)
		)
		(= local0 (helloList at: (HelloChoices current:)))
		(hubComputer setScript: sBringUpVidmail)
	)

	(method (dispose)
		(helloList release:)
		(helloCast dispose:)
		(helloPlane dispose:)
		(if (<= global188 3)
			(hubComputer picture: 41 drawInset:)
		else
			(hubComputer picture: 40 drawInset:)
		)
		(localproc_4)
		(super dispose: &rest)
	)
)

(class HelloChoices of DSelector
	(properties
		back 0
		priority 200
		fixPriority 1
		font 1
		fore 228
		width 170
		length 7
		lastCurrent -1
	)

	(method (init)
		(= upButton (= downButton -1))
		(gExtMouseHandler add: self)
		(gKeyDownHandler add: self)
		(= x (= y (= nsLeft (= nsTop (= nsRight (= nsBottom 0))))))
		(self
			leading: 4
			width: 170
			current: -1
			lastCurrent: -1
			setSize: 1
			length: 7
			move: 15 89
		)
		(super init: helloCast &rest)
		(listPlane picture: -2 priority: (+ ((hubComputer plane:) priority:) 2))
		(UpdatePlane listPlane)
	)

	(method (setText param1 &tmp temp0 [temp1 2] temp3 temp4 temp5 temp6)
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
				(if (!= (= temp6 (temp3 indexOf: 85)) -1)
					(= temp5 226)
				else
					(= temp5 fore)
				)
				(textList
					add:
						((SelectorDText new:)
							font: font
							back: back
							skip: back
							fore: temp5
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

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gExtMouseHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((and (not (event type:)) (listPlane onMe: event))
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
				(event claimed: 1)
				(return)
			)
			((== (event type:) evMOUSEBUTTON)
				(event globalize:)
				(if (listPlane onMe: event)
					(event localize: listPlane)
					(if (= temp0 (textList firstTrue: #onMe event))
						(= lastCurrent current)
						(= current (textList indexOf: temp0))
						(self draw:)
						(HelloManager changeVidmail:)
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

	(method (draw &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (textList size:)
			(= temp3 (textList at: current))
			(= temp0 (KList 3 (textList elements:))) ; FirstNode
			(for ((= temp4 0)) temp0 ((++ temp4))
				(= temp1 (KList 6 temp0)) ; NextNode
				(= temp2 (KList 8 temp0)) ; NodeValue
				(= temp5 (Str new:))
				(temp5 copy: (temp2 text:))
				(temp2
					moveTo: 2 (+ 1 (* (- first temp4) -1 textHeight))
					fore:
						(cond
							((== temp3 temp2) 224)
							((!= (temp5 indexOf: 85) -1) 235)
							(else fore)
						)
					back:
						(cond
							((== temp3 temp2) back)
							((!= (temp5 indexOf: 85) -1) fore)
							(else back)
						)
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
		(if (helloCast contains: scrollUpButn)
			(scrollUpButn setActive:)
			(scrollDownButn setActive:)
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
				(HelloManager changeVidmail:)
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
				(HelloManager changeVidmail:)
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

(instance helloCast of Cast
	(properties)
)

(instance helloPlane of Plane
	(properties)
)

(instance logoCast of Cast
	(properties)
)

(instance logoPlane of Plane
	(properties)
)

(instance goodbyeButton of View
	(properties
		noun 114
		x 15
		y 57
		loop 2
		cel 5
		view 207
	)

	(method (init)
		(= case 7)
		(super init: &rest)
		(self setHotspot: 2)
		(&= signal $efff)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
				(RamaInterface displayOptionsText: 90 noun 0 case 1)
			)
			(2
				(butnSnd play:)
				(proc1013_2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance helloButton of View
	(properties
		noun 114
		loop 2
		cel 3
		view 207
	)

	(method (init)
		(= x 35)
		(= y 107)
		(= case 8)
		(super init: (hubComputer insetCast:) &rest)
		(self setHotspot: 2)
		(&= signal $efff)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(RamaInterface displayOptionsText: 90 noun 0 case 1)
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(butnSnd play:)
				(if (not (IsFlag 91))
					(localproc_0)
				else
					(if
						(and
							((hubComputer insetCast:) contains: playButn)
							(> global188 3)
						)
						(endMovie play:)
					)
					(proc1013_2)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theExitButton of View
	(properties
		noun 115
		loop 2
		cel 2
		view 207
	)

	(method (init)
		(= x (helloButton x:))
		(= y (+ (helloButton y:) 100))
		(super init: (hubComputer insetCast:) &rest)
		(self setHotspot: 2)
		(&= signal $efff)
		(= case 7)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(RamaInterface displayOptionsText: 90 noun 0 case 1)
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(butnSnd play:)
				(proc1013_1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance helloList of Set
	(properties)
)

(instance listTitle of DText
	(properties
		back 0
		case 87
		font 2207
		fore 228
	)

	(method (init &tmp temp0)
		(= temp0 (Str new:))
		(Message msgGET 55 6 0 case 1 (temp0 data:))
		(self
			x: 15
			y: 79
			text: (temp0 data:)
			setSize: 196
			skip: back
			plane: helloPlane
		)
		(super init: helloCast &rest)
	)
)

(instance scrollUpButn of Button
	(properties
		priority 254
		cel 1
		view 207
		fixPriority 1
		upLoop 0
		upCel 1
		downLoop 1
		doVerbCalled 1
	)

	(method (init)
		(= x (HelloChoices nsRight:))
		(= y (HelloChoices nsTop:))
		(super init: &rest)
		(self setActive: 0)
		(self setHotspot: 1)
	)

	(method (setActive param1 &tmp temp0)
		(cond
			(argc
				(super setActive: param1)
			)
			((> (= temp0 (HelloChoices first:)) 0)
				(super setActive: 1)
			)
			(else
				(super setActive: 0)
			)
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
				(if (> (HelloChoices first:) 0)
					(HelloChoices scrollUp: 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance scrollDownButn of Button
	(properties
		priority 255
		view 207
		fixPriority 1
		upLoop 0
		downLoop 1
		downCel 0
		doVerbCalled 1
	)

	(method (init)
		(= x (scrollUpButn x:))
		(= y (HelloChoices nsBottom:))
		(super init: &rest)
		(self setActive: 1)
		(self setHotspot: 1)
	)

	(method (setActive param1 &tmp temp0)
		(cond
			(argc
				(super setActive: param1)
			)
			(
				(<
					(= temp0 (+ (HelloChoices first:) (HelloChoices length:)))
					((HelloChoices textList:) size:)
				)
				(super setActive: 1)
			)
			(else
				(super setActive: 0)
			)
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
				(if
					(<
						(HelloChoices first:)
						(+
							(- ((HelloChoices textList:) size:) 1)
							(HelloChoices length:)
						)
					)
					(HelloChoices scrollDown: 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance playButn of Button
	(properties
		noun 98
		priority 255
		case 8
		cel 2
		view 207
		upLoop 0
		upCel 2
		downLoop 1
		downCel 2
	)

	(method (init)
		(= x 272)
		(= y 268)
		(= active 1)
		(= case 8)
		(super init: &rest)
		(self setHotspot: 1)
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
					(self setActive: 0)
					(stopButn setActive: 1)
					(local0 plane: (hubComputer plane:))
					(UpdatePlane (hubComputer plane:))
					(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
					(local0 play: self)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(self deleteHotspot:)
		(super dispose: &rest)
	)
)

(instance stopButn of Button
	(properties
		noun 99
		case 7
		cel 6
		view 207
		upLoop 0
		upCel 6
		downLoop 1
		downCel 6
	)

	(method (init)
		(= x (+ (playButn nsRight:) 25))
		(= y (playButn y:))
		(super init: &rest)
		(self setActive: 0)
		(self setHotspot: 1)
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
					(self setActive: 0)
					(switch (= temp0 (local0 getStatus:))
						(0)
						(2
							(local0 close:)
							(playButn setActive: 1)
							(self setActive: 0)
						)
						(4
							(local0 close:)
							(playButn setActive: 1)
							(self setActive: 0)
						)
						(5
							(local0 close:)
						)
						(else
							(PrintDebug {theVidmail has NO status!})
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sBringUpVidmail of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if
					(and
						(not ((hubComputer insetCast:) contains: playButn))
						(> global188 3)
					)
					(startMovie plane: (hubComputer plane:) play: self)
				else
					(= cycles 1)
				)
			)
			(2
				(hubComputer picture: 76 restore:)
				(= cycles 3)
			)
			(3
				(startView
					view: (local0 startPic:)
					init: (hubComputer insetCast:)
				)
				(playButn init: (hubComputer insetCast:))
				(stopButn init: (hubComputer insetCast:))
				(UpdatePlane (hubComputer plane:))
				(FrameOut)
				(= cycles 1)
			)
			(4
				(local0 plane: (hubComputer plane:) open:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance startMovie of VMDMovie
	(properties
		movieName 38420
		options 64
	)
)

(instance endMovie of VMDMovie
	(properties
		movieName 38999
		options 64
	)
)

(class HelloVMD of VMDMovie
	(properties
		x 281
		y 60
		case 0
		options 64
		startPic 0
		lastPic 0
	)

	(method (play)
		(|= waitEvents $0004)
		(self showCursor: 1)
		(super play: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3
				(playButn setActive: 1)
				(stopButn setActive: 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shigeruIntro of HelloVMD
	(properties
		case 78
		movieName 34011
		startPic 34010
	)
)

(instance ottoIntro of HelloVMD
	(properties
		case 79
		movieName 34021
		startPic 34020
	)
)

(instance reggieIntro of HelloVMD
	(properties
		case 80
		movieName 34031
		startPic 34030
	)
)

(instance davidIntro of HelloVMD
	(properties
		case 81
		movieName 34041
		startPic 34040
	)
)

(instance irinaIntro of HelloVMD
	(properties
		case 82
		movieName 34051
		startPic 34050
	)
)

(instance michaelIntro of HelloVMD
	(properties
		case 83
		movieName 34061
		startPic 34060
	)

	(method (play)
		(if (<= global188 3)
			(self cacheSize: 1000 preLoadPCT: 70)
		)
		(super play: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3
				(SetFlag 89)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance nicoleIntro of HelloVMD
	(properties
		case 84
		movieName 34071
		startPic 34070
	)
)

(instance richardIntro of HelloVMD
	(properties
		case 85
		movieName 34081
		startPic 34080
	)

	(method (play)
		(super play: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3
				(SetFlag 82)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance francescaIntro of HelloVMD
	(properties
		case 86
		movieName 34091
		startPic 34090
	)
)

(instance startView of View
	(properties
		x 251
		y 20
	)
)

(instance ISALogo of Prop
	(properties
		x 6
		y 44
		loop 3
		view 207
	)
)

(instance computerSnd of Sound ; UNUSED
	(properties
		number 1013
		flags 5
	)
)

(instance waveSnd of Sound ; UNUSED
	(properties
		number 1013
		flags 5
	)
)

(instance butnSnd of Sound
	(properties
		number 4003
		flags 5
	)
)

