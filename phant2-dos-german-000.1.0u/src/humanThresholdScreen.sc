;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3000)
(include sci.sh)
(use Main)
(use AlienLine)
(use MenuList)
(use nExit)
(use n63002)
(use P2View)
(use LineSelector)
(use DItem)
(use Plane)
(use Str)
(use Rectangle)
(use BorderWindow)
(use PolyEdit)
(use Menu)
(use System)

(public
	humanThresholdScreen 0
)

(local
	local0
	local1
	local2 = 10
	local3
	local4
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 param1) ((++ temp0))
		(= temp1 (GetTime))
		(while (== temp1 (GetTime))
		)
	)
)

(class RefreshRoom of P2Room
	(properties)

	(method (refresh))
)

(instance humanThresholdScreen of RefreshRoom
	(properties
		picture 3000
	)

	(method (init)
		(Load 140 3000) ; WAVE
		(= local2 10)
		(= local0 (List new:))
		(super init: &rest)
		(gGame handsOn:)
		(if (not (IsFlag 1005))
			(while (not (= local1 (AlienPassWordWindow new: {ROSETTE})))
				(AlienPasswordError new:)
			)
			(if (== local1 -1)
				(gCurRoom newRoom: 9000) ; threshCompRm
				(gGame handsOff:)
				(return 0)
			)
		)
		(SetFlag 1005)
		(gGame handsOff:)
		(CommentPicker init:)
		(= south 0)
		(TalkPlane init:)
		(yesB init:)
		(noB init:)
		(whenB init:)
		(howB init:)
		(whyB init:)
		(exitB init:)
		(typeLine init: 0 0 (CommentPicker findLine: global245))
	)

	(method (dispose)
		(if (!= local1 -1)
			(TalkPlane dispose:)
			(CommentPicker dispose:)
		)
		(local0 release:)
		(local0 dispose:)
		(typeLine dispose:)
		(playSound dispose:)
		(super dispose: &rest)
	)
)

(instance talkToAliensF of P2View ; UNUSED
	(properties
		x 350
		y 200
		scene 6511
		doneFlag 741
		nextRoom 9000
	)
)

(class AlienButton of DItem
	(properties
		exitDir -1
	)

	(method (seesVerb param1)
		(if (== param1 4)
			(return 1)
		else
			(return 0)
		)
	)

	(method (update)
		(if (not (not (& state $0001)))
			(= cel 0)
			(if (not (not (& state $0002)))
				(= cel 0)
			)
			(if (not (not (& state $0020)))
				(= cel 1)
			)
		else
			(= cel 0)
		)
		(super update: &rest)
	)

	(method (isOn)
		(self isHot: 1)
		(|= state $0200)
	)

	(method (isOff)
		(self isHot: 0)
		(&= state $fdff)
	)

	(method (action &tmp temp0)
		(= temp0 (CommentPicker findLine: global245))
		(if (temp0 threadDone:)
			(switch (++ global244)
				(2
					(= global245 15)
					(CommentPicker dispose:)
					(CommentPicker init:)
					((talkSelector items:) addMsg:)
					(= temp0 (CommentPicker findLine: global245))
					(typeLine init: 0 0 temp0)
				)
				(3
					(= global245 37)
					(SetFlag 580)
					(typeLine init: 0 0 temp0)
				)
				(4
					(SetFlag 764)
					(typeLine init: 0 0 temp0)
				)
			)
		else
			(typeLine init: 0 0 temp0)
		)
	)

	(method (handleEvent event)
		(if (& state $1000)
			(super handleEvent: event)
		)
		(event claimed:)
	)

	(method (isHot &tmp temp0)
		(if (super isHot: &rest)
			(= temp0 (gUser curEvent:))
			(temp0 localize: gThePlane)
			(if (self onMe: temp0)
				(|= state $0002)
			)
		)
		(return (& state $1000))
	)
)

(instance yesB of AlienButton
	(properties
		x 581
		y 82
		view 3000
	)

	(method (init)
		(if (CommentPicker isBtnHot: 1)
			(self isOn:)
		else
			(self isOff:)
		)
		(super init: &rest)
	)

	(method (action)
		(gGame handsOff:)
		(CommentPicker doit: 1)
		((talkSelector items:) addMsg:)
		(super action:)
	)
)

(instance noB of AlienButton
	(properties
		x 581
		y 116
		view 3000
		loop 1
	)

	(method (init)
		(if (CommentPicker isBtnHot: 2)
			(self isOn:)
		else
			(self isOff:)
		)
		(super init: &rest)
	)

	(method (action)
		(gGame handsOff:)
		(CommentPicker doit: 2)
		((talkSelector items:) addMsg:)
		(super action:)
	)
)

(instance whenB of AlienButton
	(properties
		x 581
		y 150
		view 3000
		loop 2
	)

	(method (init)
		(if (CommentPicker isBtnHot: 3)
			(self isOn:)
		else
			(self isOff:)
		)
		(super init: &rest)
	)

	(method (action)
		(gGame handsOff:)
		(CommentPicker doit: 3)
		((talkSelector items:) addMsg:)
		(super action:)
	)
)

(instance howB of AlienButton
	(properties
		x 581
		y 184
		view 3000
		loop 3
	)

	(method (init)
		(if (CommentPicker isBtnHot: 4)
			(self isOn:)
		else
			(self isOff:)
		)
		(super init: &rest)
	)

	(method (action)
		(gGame handsOff:)
		(CommentPicker doit: 4)
		((talkSelector items:) addMsg:)
		(super action:)
	)
)

(instance whyB of AlienButton
	(properties
		x 581
		y 218
		view 3000
		loop 4
	)

	(method (init)
		(if (CommentPicker isBtnHot: 5)
			(self isOn:)
		else
			(self isOff:)
		)
		(super init: &rest)
	)

	(method (action)
		(gGame handsOff:)
		(CommentPicker doit: 5)
		((talkSelector items:) addMsg:)
		(super action:)
	)
)

(instance exitB of AlienButton
	(properties
		x 581
		y 252
		view 3000
		loop 5
	)

	(method (init)
		(self isOn:)
		(super init: &rest)
	)

	(method (action)
		(gGame handsOff:)
		(switch gChapter
			(4
				(if (IsFlag 580)
					(= global209 6511)
				)
			)
			(5
				(if (IsFlag 764)
					(= global209 6511)
				)
			)
		)
		(gCurRoom newRoom: 9000) ; threshCompRm
	)
)

(class TalkPlane of HotPlane
	(properties
		picture -2
		pageArea 0
	)

	(method (init &tmp temp0)
		(= pageArea (Rectangle new: 10 16 460 255))
		(self setPri: (+ 1 (GetHighPlanePri)))
		(super init: 30 100 510 370)
		(talkSelector init: self)
	)

	(method (dispose)
		(pageArea dispose:)
		(= pageArea 0)
		(talkSelector dispose:)
		(super dispose: &rest)
	)

	(method (done)
		(Send new: self 8)
	)

	(method (handleEvent event param2)
		(event localize: self)
		(if (or (!= argc 2) (!= param2 self))
			(super handleEvent: event)
			(return)
		)
		(if (pageArea onMe: event)
			(talkSelector doit: (event x:) (event y:))
		else
			(talkSelector doit: 0)
		)
	)
)

(class TalkList of List
	(properties
		scrollBar -1
		back 3
		manager 0
		fore 176
		font 7001
		width -1
		yPos 0
		bossPlane -1
	)

	(method (new param1 param2 &tmp temp0)
		(= temp0 (super new:))
		(if argc
			(temp0 manager: param1)
			(temp0 bossPlane: param2)
		)
		(return temp0)
	)

	(method (init)
		(super init:)
		(= width 451)
		(= yPos 16)
		(self addMsg:)
	)

	(method (addMsg &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (CommentPicker getVerb:))
		(= temp1 (CommentPicker getCase:))
		(if (Message msgGET 8900 1 temp0 temp1 1)
			((= temp2 (alienItem new: TalkPlane))
				setText: 8900 1 temp0 temp1 1
				setSize: self
				posn: 10 yPos
				init: bossPlane
			)
			(+= yPos (temp2 celHeight:))
			(self addToFront: temp2)
			(manager autoScroll: (temp2 numLines:))
			(= temp5 ((self value: (self first:)) y:))
			(for ((= temp4 0)) (< temp4 (temp2 numLines:)) ((++ temp4))
				((= temp3 (blankText new: TalkPlane))
					setText: { }
					setSize: self
				)
				(temp3 scratch: 450)
				(if (> (temp2 numLines:) 10)
					(if (== temp4 1)
						(temp3 scratch: 200)
					)
					(if (<= 2 temp4 11)
						(temp3 scratch: 105)
					)
					(if (> temp4 11)
						(temp3 scratch: 190)
					)
				)
				(temp3 posn: 10 (+ temp5 (* temp4 (talkSelector lineHeight:))))
				(temp3 init: bossPlane)
				(temp3 setPri: 1000 show:)
				(local0 addToEnd: temp3)
			)
		)
	)

	(method (dispose)
		(= manager 0)
		(super dispose:)
	)
)

(class talkSelector of MultiLineSelector
	(properties
		pageSize 20
		lineHeight 12
		topLineNum 0
	)

	(method (init param1 &tmp temp0)
		((= items (TalkList new: self param1)) init:)
		(items eachElementDo: #init param1)
		(self cue: 0)
		(super init:)
	)

	(method (autoScroll param1)
		(+= numLines param1)
		(if (> numLines pageSize)
			(self cue: param1)
		else
			(self cue: 0)
		)
	)

	(method (cue &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp2 (List new:))
		(= temp3 0)
		(for ((= temp0 0)) (< temp0 (items size:)) ((++ temp0))
			(if (> (+= temp3 ((items at: temp0) numLines:)) pageSize)
				(temp2 add: (items at: temp0))
			)
		)
		(if (temp2 size:)
			(for ((= temp0 0)) (< temp0 (temp2 size:)) ((++ temp0))
				(items delete: (temp2 at: temp0))
			)
			(temp2 eachElementDo: #dispose)
		)
		(temp2 release: dispose:)
		(= temp3 0)
		(for ((= temp0 (items last:))) temp0 ((= temp0 (items prev: temp0)))
			(= temp1 (items value: temp0))
			(temp1 y: (+ 16 (* lineHeight temp3)))
			(+= temp3 (temp1 numLines:))
			(if (temp1 isVisible:)
				(temp1 update:)
			else
				(temp1 show:)
			)
		)
	)

	(method (dispose)
		(= topLineNum 0)
		(super dispose:)
	)
)

(instance alienItem of SelectItem
	(properties
		bulletView 3000
		bulletLoop 6
	)

	(method (handleEvent event)
		(event claimed:)
	)
)

(instance blankText of SelectItem
	(properties
		back 133
		bulletView 0
		bulletLoop 0
		fore 133
	)

	(method (handleEvent event)
		(event claimed:)
	)
)

(instance playSound of Script
	(properties)

	(method (cue)
		(= ticks (Random 5 30))
		(gP2SoundFX play: 3000)
	)
)

(instance typeLine of Script
	(properties)

	(method (dispose)
		(= register 0)
		(super dispose: &rest)
	)

	(method (init)
		(super init: &rest)
		(playSound init:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local3 0)
				(= local4 0)
				(if (local0 size:)
					(= local4 (local0 value: (local0 first:)))
					(= local3 (local4 x:))
					(= ticks 1)
				else
					(self dispose:)
					(playSound dispose:)
				)
			)
			(1
				(+= local3 (Random 10 15))
				(local4 x: local3)
				(if (< local3 (local4 scratch:))
					(-- state)
				)
				(= ticks (Random 1 3))
			)
			(2
				(local0 delete: local4)
				(local4 dispose:)
				(if (local0 size:)
					(= state -1)
				)
				(= ticks 1)
			)
			(3
				(playSound dispose:)
				(yesB isHot: (register yesHot:))
				(noB isHot: (register noHot:))
				(whenB isHot: (register whenHot:))
				(howB isHot: (register howHot:))
				(whyB isHot: (register whyHot:))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(class AlienPWWCursor of View
	(properties
		view 3001
		loop 5
		myWindow 0
	)

	(method (new &tmp temp0)
		(= temp0 (super new:))
		(temp0 init: &rest)
		(return temp0)
	)

	(method (init param1)
		(= myWindow param1)
		(self
			posn:
				(+ (myWindow x:) 115 (* 9 (((myWindow pwStars:) data:) size:)))
				(- (myWindow y:) 83)
		)
		(super init: (param1 plane:))
		(self setPri: 1001)
	)

	(method (doit &tmp temp0)
		(= temp0 (GetTime))
		(while (== (GetTime) temp0)
		)
		(if (not (-- local2))
			(= local2 10)
			(if cel
				(= cel 0)
			else
				(= cel 1)
			)
		)
		(if (myWindow pwStars:)
			(self
				posn:
					(+
						(myWindow x:)
						115
						(* 9 (((myWindow pwStars:) data:) size:))
					)
					(- (myWindow y:) 83)
					1
			)
		)
		(self update:)
		(super doit:)
	)
)

(class AlienPassWordWindow of View
	(properties
		x 170
		y 254
		view 3001
		bV 0
		okB 0
		cncB 0
		pwStars 0
		pw 0
		curPw 0
		pwCursor 0
	)

	(method (new param1 &tmp temp0 temp1 temp2)
		(= temp0 (super new:))
		((= temp2 (Plane new:))
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
			setPri: (+ (GetHighPlanePri) 1) 1
			drawPic: -2
		)
		(temp0 pw: (Str format: {%s} param1) init: temp2)
		(= temp1
			(cond
				((not ((temp0 curPw:) weigh: (temp0 pw:))) 1)
				((not ((temp0 curPw:) weigh: {~cancel~})) -1)
				(else 0)
			)
		)
		(temp0 dispose:)
		(temp2 dispose:)
		(return temp1)
	)

	(method (init param1)
		(gTheCursor set: 999 1 0)
		(self setPri: 1000)
		(super init: param1)
		(= okB (Rectangle new: 199 212 285 237))
		(= cncB (Rectangle new: 352 212 438 237))
		(self addTarget: okB addTarget: cncB)
		(= curPw (Str format: {}))
		(= pwStars (Stack new:))
		(= pwCursor (AlienPWWCursor new: self))
		((gUser hogs:) push: self 1)
		(gUser doit:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if
			(and
				(& (event type:) evKEYBOARD)
				(or
					(OneOf (= temp1 (event message:)) JOY_UPLEFT KEY_SPACE)
					(<= KEY_a temp1 KEY_z)
					(<= KEY_A temp1 KEY_Z)
					(<= KEY_0 temp1 KEY_9)
				)
				(<= (curPw size:) 16)
			)
			(cond
				((== (event message:) JOY_UPLEFT)
					(if (curPw size:)
						(= temp2 (curPw getLeft: (- (curPw size:) 1)))
						(curPw dispose:)
						(= curPw temp2)
						(if (= temp0 (pwStars peek:))
							(pwStars pop:)
							(temp0 dispose:)
						)
					)
				)
				((<= (curPw size:) 15)
					(if (<= KEY_a temp1 KEY_z)
						(-= temp1 32)
					)
					(= temp2 (Str format: {%c} temp1))
					(curPw cat: temp2)
					(temp2 dispose:)
					((= temp0 (View new:))
						view: 3001
						loop: 4
						cel: 0
						init: plane
						setPri: 1001
						posn: (+ x 115 (* 9 ((pwStars data:) size:))) (- y 75) 1
					)
					(pwStars push: temp0)
				)
			)
		else
			(if
				(and
					(& (event type:) evKEYBOARD)
					(OneOf (event message:) KEY_RETURN KEY_ESCAPE)
				)
				((gUser hogs:) pop:)
				(if (== (event message:) KEY_ESCAPE)
					(curPw dispose:)
					(= curPw (Str format: {}))
				)
				(if bV
					(bV dispose:)
					(= bV 0)
				)
			else
				(event globalize: localize: plane)
				(cond
					((and bV (& (event type:) evMOUSERELEASE))
						(localproc_0 10)
						(if (bV onMe: event)
							((gUser hogs:) pop:)
							(if (== (bV loop:) 2)
								(curPw dispose:)
								(= curPw (Str format: {~cancel~}))
							)
						)
						(bV dispose:)
						(= bV 0)
					)
					((& (event type:) evMOUSEBUTTON)
						(cond
							((okB onMe: event)
								(= bV (View new:))
								(bV
									view: 3001
									loop: 1
									posn: 199 210
									setPri: 1001
									init: plane
								)
							)
							((cncB onMe: event)
								(= bV (View new:))
								(bV
									view: 3001
									loop: 2
									posn: 352 210
									setPri: 1001
									init: plane
								)
							)
						)
					)
				)
			)
			(pwStars doit:)
			(pwCursor doit:)
			(FrameOut)
			(event claimed: self)
			(return)
		)
	)

	(method (dispose)
		((pwStars data:) release:)
		(pwStars dispose:)
		(curPw dispose:)
		(pw dispose:)
		(target dispose:)
		(if bV
			(bV dispose:)
		)
		(super dispose: &rest)
	)
)

(class AlienPasswordError of View
	(properties
		x 140
		y 221
		view 3001
		loop 3
		okbV 0
	)

	(method (new &tmp temp0 temp1)
		(= temp0 (super new:))
		((= temp1 (Plane new:))
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
			setPri: (+ (GetHighPlanePri) 1) 1
			drawPic: -2
		)
		(temp0 init: temp1)
		(temp1 dispose:)
	)

	(method (init)
		(super init: &rest)
		(self addTarget: (Rectangle new: 276 175 362 200))
		((gUser hogs:) push: self 1)
		(gUser doit:)
	)

	(method (handleEvent event)
		(event globalize: localize: plane)
		(cond
			((and (target onMe: event) (& (event type:) evMOUSEBUTTON) (not okbV))
				((= okbV (View new:))
					view: 3001
					loop: 1
					cel: 0
					init: plane
					posn: 276 175
					setPri: 1001
					update:
				)
			)
			(
				(or
					(and okbV (& (event type:) evMOUSERELEASE))
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(localproc_0 10)
				(if okbV
					(okbV dispose:)
				)
				((gUser hogs:) pop:)
				(event claimed: self)
				(gCurRoom refresh:)
				(self dispose:)
			)
		)
		(FrameOut)
		(event claimed:)
	)

	(method (dispose)
		(if target
			(target dispose:)
			(= target 0)
		)
		(super dispose: &rest)
	)
)

