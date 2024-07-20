;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use SpeakWindow)
(use DIcon)
(use DSelector)
(use DEdit)
(use DText)
(use Str)
(use Array)
(use Print)
(use Dialog)
(use Messager)
(use Talker)
(use Sync)
(use RandCycle)
(use Actor)
(use System)

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
	[local10 70] = [0 0 0 1 0 5 0 7 0 3 0 2 0 6 0 8 0 4 0 10 0 25 0 24 22 1 22 2 22 3 22 4 22 5 22 6 22 7 22 8 22 9 22 10 0 17 0 18 0 21 0 11 0 14 0 22 0 23 0 26 0 27 0 28 0 29 0 30 0 31]
	[local80 6]
	local86
	local87
	[local88 18] = [28 27 26 26 25 26 26 26 27 28 27 27 29 27 28 26 27 27]
	[local106 18] = [28 30 26 30 27 27 30 28 27 28 29 26 31 30 29 28 30 28]
	[local124 18] = [30 27 26 30 25 26 26 26 27 28 27 27 29 27 28 26 27 27]
)

(instance h5Narrator of Narrator
	(properties)
)

(class h5Messager of Messager
	(properties)

	(method (findTalker param1)
		(if (== param1 99)
			(return h5Narrator)
		else
			(super findTalker: param1)
		)
	)
)

(instance characterPrint of Print
	(properties)

	(method (init)
		(if (& gMsgType $0002)
			(local6 startAudio: local1 1 local3 0 local5)
		)
		(super init:)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if
			(and
				(== gMsgType 2)
				(or (== (DoAudio audPOSITION) local9) (== (DoAudio audPOSITION) -1))
				(not local8)
				local4
				[local80 local86]
			)
			(DoAudio audSTOP)
			(if (== local86 4)
				(= temp0 (* local4 2))
				(= local8 1)
			else
				(= local87 1)
				(= temp0 (* [local80 local86] 2))
				(= [local80 local86] 0)
			)
			(DoAudio audWPLAY local1 1 [local10 temp0] 0 [local10 (+ temp0 1)])
			((local6 face:)
				setCycle:
					MouthSync
					local1
					1
					[local10 temp0]
					0
					[local10 (+ temp0 1)]
			)
			(local6
				startAudio: local1 1 [local10 temp0] 0 [local10 (+ temp0 1)]
			)
		)
		(if (gATalker size:)
			(proc0_9 (gATalker elements:) 1)
		)
	)

	(method (showSelf &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if saveCursor
			(gGame setCursor: gNormalCursor)
		)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		((= plane
				(if plane
					(plane new:)
				else
					(gSystemPlane new:)
				)
			)
			picture: -2
		)
		(dialog
			plane: plane
			name: {PODialog}
			caller: self
			text: title
			ticks: ticks
			margin: margin
			modeless: modeless
			onScreen: onScreen
			init:
		)
		(if bitmap
			(dialog
				nsLeft: (bitmap nsLeft:)
				nsTop: (bitmap nsTop:)
				nsRight: (bitmap nsRight:)
				nsBottom: (bitmap nsBottom:)
			)
		else
			(dialog setSize:)
		)
		(if title
			((dialog plane:) setTitle: title)
			(dialog
				nsLeft: ((dialog plane:) left:)
				nsTop: ((dialog plane:) top:)
				nsRight: ((dialog plane:) right:)
				nsBottom: ((dialog plane:) bottom:)
			)
		)
		(dialog center:)
		(= temp2
			(if (== x -1)
				(dialog nsLeft:)
			else
				x
			)
		)
		(= temp3
			(if (== y -1)
				(dialog nsTop:)
			else
				y
			)
		)
		(dialog moveTo: temp2 temp3 eachElementDo: #updatePlane)
		(FrameOut)
		(if (== modeless 0)
			(gSounds pause: 1)
			(if (not (= temp0 first))
				(if
					(and
						(= temp0 (dialog firstTrue: #checkState 1))
						(not (dialog firstTrue: #checkState 2))
					)
					(temp0 state: (| (temp0 state:) $0002))
				)
			else
				(= temp0 (dialog at: temp0))
			)
			(= retValue (dialog doit: temp0))
			(switch retValue
				(-1
					(= retValue 0)
				)
				(-2
					(= retValue 1)
				)
				(0
					(= retValue 1)
				)
				(else
					(if (retValue object:)
						(gGame
							panelObj: (retValue object:)
							panelSelector: (retValue selector:)
						)
					)
					(cond
						((retValue isKindOf: DEdit)
							(= retValue (retValue text:))
						)
						((retValue isKindOf: DSelector)
							(= retValue (retValue getText:))
						)
						(else
							(= retValue (retValue value:))
						)
					)
				)
			)
			(if (and saveCursor gTheIconBar)
				(gGame setCursor: (gTheIconBar getCursor:))
			)
			(= temp5 retValue)
			(dialog dispose:)
			(return temp5)
		else
			(gPrints addToFront: self)
		)
	)

	(method (addText param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(if (== font -1)
			(= font gUserFont)
		)
		(= temp11 (if classText classText else DText))
		(if (> argc 3)
			(= temp0 [param1 0])
			(= temp1 [param1 1])
			(= temp2 [param1 2])
			(= temp3 (if [param1 3] [param1 3] else 1))
			(= temp4 0)
			(= temp5 0)
			(= temp6 gCurRoomNum)
			(if (>= argc 5)
				(= temp4 [param1 4])
				(if (>= argc 6)
					(= temp5 [param1 5])
					(if (>= argc 7)
						(= temp6 [param1 6])
					)
				)
			)
			(= temp7 (Str new:))
			(if
				(or
					(not (Message msgSIZE temp6 temp0 temp1 temp2 temp3))
					(not
						(Message msgGET temp6 temp0 temp1 temp2 temp3 (temp7 data:))
					)
				)
				(return 0)
			)
			(dialog
				add:
					(= temp9
						((temp11 new:)
							text: (temp7 data:)
							font: font
							mode: mode
							fore: fore
							back:
								(if (== back -1)
									(temp11 back:)
								else
									back
								)
							skip:
								(if (== skip -1)
									(temp11 skip:)
								else
									skip
								)
							setSize: width
							moveTo: (+ margin temp4) (+ margin temp5)
							yourself:
						)
					)
			)
		else
			(= temp4 0)
			(= temp5 0)
			(if (>= argc 2)
				(= temp4 [param1 1])
				(if (>= argc 3)
					(= temp5 [param1 2])
				)
			)
			(= temp7 (Str new:))
			(temp7 copy: (KString 9 [param1 0])) ; StrGetData
			(dialog
				add:
					(= temp9
						((temp11 new:)
							text: (temp7 data:)
							font: font
							mode: mode
							fore: fore
							back:
								(if (== back -1)
									(temp11 back:)
								else
									back
								)
							skip:
								(if (== skip -1)
									(temp11 skip:)
								else
									skip
								)
							setSize: (- width 11)
							moveTo: (+ margin temp4) (+ margin temp5)
							yourself:
						)
					)
			)
		)
		(temp7 data: 0 dispose:)
		(return temp9)
	)

	(method (addBitmap param1 param2 param3 param4 param5 param6 param7 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(if (not dialog)
			(= dialog (Dialog new:))
		)
		(= bitmap (DIcon new:))
		(dialog
			add:
				(bitmap
					view: param1
					loop: param2
					cel: param3
					moveTo: 0 0
					yourself:
				)
		)
		(= temp0 param4)
		(= temp2 param5)
		(= temp1 param6)
		(= temp3 param7)
		(bitmap nsLeft: param4)
		(bitmap nsTop: param5)
		(bitmap nsRight: param6)
		(bitmap nsBottom: param7)
		(= temp4 (CelWide (bitmap view:) (bitmap loop:) (bitmap cel:)))
		(= temp5 (CelHigh (bitmap view:) (bitmap loop:) (bitmap cel:)))
		(= temp6 (+ (- temp1 temp0) 1))
		(= temp7 (+ (- temp3 temp2) 1))
		(if (< temp6 250)
			(= temp8 (/ (* temp6 128) temp4))
		else
			(= temp8 (* (/ (* (/ temp6 2) 128) temp4) 2))
		)
		(= temp9 (/ (* temp7 128) temp5))
		(bitmap scaleSignal: 1 scaleX: temp8 scaleY: temp9)
		(return bitmap)
	)
)

(class Character of View
	(properties
		priority 6
		loop 2
		face 0
		charScript 0
		active 0
		holdTalk 1800
		gender 0
		whoGetsCued 0
		offsetX 0
		offsetY 0
	)

	(method (init)
		(= cel 0)
		(self setPri: 40)
		(self view: view)
		(self loop: loop)
		(self cel: cel)
		(face posn: offsetX offsetY)
		(= nsTop offsetY)
		(= nsLeft offsetX)
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
		(super init:)
	)

	(method (show)
		(return 0)
	)

	(method (posn param1 param2)
		(if (>= argc 2)
			(= offsetY (- (= y param2) [local106 view]))
		)
		(if (>= argc 1)
			(= x param1)
			(if (== loop 2)
				(= offsetX (- param1 [local88 view]))
			else
				(= offsetX (- param1 [local124 view]))
			)
		)
		(= nsTop offsetY)
		(= nsLeft offsetX)
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
		(face posn: param1 param2)
	)

	(method (stop param1)
		(if (and active (!= self param1))
			(face setCycle: 0 hide:)
		)
	)

	(method (smile param1 param2)
		(if active
			(charScript
				caller: (if (>= argc 2) param2 else whoGetsCued)
				register:
					(if (and argc param1)
						param1
					else
						(Random 35 55)
					)
			)
			(= whoGetsCued 0)
			(gAbsoluteCast add: face)
			(face loop: (+ 4 (- loop 2)) setScript: charScript init:)
		)
	)

	(method (laugh))

	(method (frown param1 param2)
		(if active
			(charScript
				caller: (if (>= argc 2) param2 else whoGetsCued)
				register:
					(if (and argc param1)
						param1
					else
						(Random 35 55)
					)
			)
			(= whoGetsCued 0)
			(gAbsoluteCast add: face)
			(face loop: (+ 6 (- loop 2)) setScript: charScript init:)
		)
	)

	(method (say param1 param2 param3 param4 param5 param6 param7 param8 &tmp [temp0 2] temp2 [temp3 2] temp5 temp6 temp7 temp8)
		(= temp2 (Str new:))
		(= temp7 (IntArray new: 4))
		(= global108 0)
		(= whoGetsCued 0)
		(if (>= argc 8)
			(= whoGetsCued param8)
		)
		(face setScript: 0)
		(= local6 self)
		(if (<= 100 gCardGameScriptNumber 800)
			(= local8 0)
			(= local87 0)
			(= [local80 4] 999)
			(= [local80 5]
				(= [local80 3]
					(= [local80 2] (= [local80 1] (= [local80 0] 0)))
				)
			)
			(= local86 4)
			(if (and (== param1 -1) (> argc 2))
				(= local1 (+ view 1000))
				(= local2 1)
				(= local3 [local10 (= temp8 (* param3 2))])
				(= local4 1)
				(= local5 [local10 (+ temp8 1)])
				(= local86 0)
				(if (>= argc 4)
					(= [local80 0] param4)
				)
				(if (>= argc 5)
					(= [local80 1] param5)
				)
				(if (>= argc 6)
					(= [local80 2] param6)
				)
				(if (>= argc 7)
					(= [local80 3] param7)
				)
			else
				(if (== param1 1000)
					(= local1 (= param1 (+ view 1000)))
				else
					(= local1 param1)
				)
				(if param2
					(= local2 param2)
				)
				(= local3 param3)
				(= local4 (if (>= argc 4) param4 else 0))
				(= local5 (if (>= argc 5) param5 else 1))
				(= global108 (if (>= argc 6) param6 else 0))
				(= temp5 (if (>= argc 7) param7 else 0))
			)
			(if (and (not temp5) (Random 0 5))
				(= global108 0)
			)
			(cond
				((== param1 -1)
					(temp2 format: {%s} param2)
				)
				((and (>= param1 1000) (!= local3 23))
					(Message msgGET 1020 1 local3 local4 local5 (temp2 data:))
				)
				(else
					(if (not param2)
						(= param2 (+ view 1))
					)
					(Message msgGET param1 param2 local3 local4 local5 (temp2 data:))
				)
			)
			(if (and (DoSound sndGET_AUDIO_CAPABILITY) global454 (>= local1 1000))
				(= gMsgType 2)
				(= local0 1)
			else
				(= gMsgType 1)
				(= local0 0)
			)
			(if active
				(self startText: temp2)
			else
				(self startText: temp2)
			)
			(if global108
				(= global108 0)
			)
			(temp2 dispose:)
			(temp7 dispose:)
			(RedrawCast)
		)
	)

	(method (startAudio param1 param2 param3 param4 param5)
		(= local9 (DoAudio audWPLAY param1 param2 param3 param4 param5))
		(DoAudio audPLAY param1 param2 param3 param4 param5)
		(if local87
			(++ local86)
		)
	)

	(method (move param1 param2)
		(characterPrint y: (+ (characterPrint y:) param2))
		(characterPrint x: (+ (characterPrint x:) param1))
	)

	(method (moveTo param1 param2)
		(self
			move: (- param1 (characterPrint x:)) (- param2 (characterPrint y:))
		)
	)

	(method (repos param1 param2)
		(characterPrint y: (+ (characterPrint y:) param2))
		(characterPrint x: (+ (characterPrint x:) param1))
	)

	(method (startText param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 [temp9 2] temp11 temp12 temp13 temp14 [temp15 3] temp18)
		(= temp0 (Str new:))
		(= temp2 (temp0 format: {%s} param1))
		(= local7 0)
		(self setLen: (temp0 size:))
		(if (== view 3)
			(face cel: 9)
		)
		(face loop: (+ 0 (- loop 2)) show: init:)
		(if (& gMsgType $0001)
			(if (< (= temp4 (* (temp0 size:) 4)) 40)
				(= temp4 40)
			)
			(face setCycle: RandCycle temp4 self 1)
		else
			(face setCycle: MouthSync local1 local2 local3 0 local5)
		)
		(gATalker release:)
		(gATalker add: face)
		(SpeakWindow speakObj: self)
		(Characters eachElementDo: #stop self)
		(RedrawCast)
		(= temp5 (characterPrint width:))
		(characterPrint width: (+ 12 (* 6 (temp0 size:))))
		(if (< (characterPrint width:) 26)
			(characterPrint width: 28)
		)
		(= temp3 gSystemPlane)
		(= temp12 (self nsTop:))
		(= temp11 (self nsBottom:))
		(= temp14 (self nsLeft:))
		(= temp13 (self nsRight:))
		(= temp7 (self nsTop:))
		(= temp8 (/ (CelWide (self view:) (self loop:) (self cel:)) 2))
		(if (< (self x:) 159)
			(= temp6 (+ (self x:) temp8))
		else
			(= temp6 160)
		)
		(if (> temp11 (characterPrint y:))
			(self move: 0 (- temp11 (characterPrint y:)))
		)
		(characterPrint x: temp6)
		(cond
			((<= (* 6 (temp0 size:)) 200)
				(= temp18 20)
			)
			((<= (* 6 (temp0 size:)) 400)
				(= temp18 30)
			)
			((<= (* 6 (temp0 size:)) 600)
				(= temp18 43)
			)
			((<= (* 6 (temp0 size:)) 800)
				(= temp18 50)
			)
			(else
				(= temp18 65)
			)
		)
		(if (>= (characterPrint width:) 205)
			(characterPrint width: 200)
		)
		(characterPrint
			mode: 1
			fore: 0
			font: gUserFont
			ticks: (+ 20 (/ holdTalk 2))
			addBitmap:
				20
				0
				0
				(characterPrint x:)
				(characterPrint y:)
				(+ (characterPrint x:) (characterPrint width:))
				(+ (characterPrint y:) temp18)
		)
		(characterPrint margin: 6 addText: temp2 init:)
		(characterPrint width: temp5)
		(= gSystemPlane temp3)
		(gATalker delete: face)
		(temp0 dispose:)
		(if global108
			(self global108:)
		else
			(face setCycle: 0 hide:)
			(if whoGetsCued
				(whoGetsCued cue:)
			)
		)
	)

	(method (setLen param1)
		(if (< param1 1)
			(= param1 1)
		)
		(if local0
			(= holdTalk (+ (/ (* param1 60) 20) 240))
		else
			(= holdTalk (+ (/ (* param1 60) 20) (* global386 60)))
			(if (== global386 15)
				(= holdTalk 29998)
			)
		)
		(if (< holdTalk 3)
			(= holdTalk 3)
		)
	)

	(method (cue)
		(face cel: 0 setCycle: 0)
	)
)

(class Characters of List
	(properties)

	(method (init &tmp temp0)
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if ((self at: temp0) active:)
				(((self at: temp0) face:)
					init:
					hide:
					setPri: (((self at: temp0) face:) priority:)
				)
			)
		)
	)

	(method (laugh))

	(method (smile)
		(self eachElementDo: #smile)
	)

	(method (frown)
		(self eachElementDo: #frown)
	)

	(method (say &tmp temp0 temp1 temp2 temp3)
		(= temp0 (+ (= temp0 0) ((= temp1 (self at: 0)) active:)))
		(if (> size 1)
			(= temp0
				(+
					(+= temp0 ((= temp2 (self at: 1)) active:))
					((= temp3 (self at: 2)) active:)
				)
			)
		)
		(switch temp0
			(2
				(switch (Random 0 1)
					(0
						(temp1 say: &rest)
					)
					(1
						(temp2 say: &rest)
					)
				)
			)
			(3
				(switch (Random 0 2)
					(0
						(temp1 say: &rest)
					)
					(1
						(temp2 say: &rest)
					)
					(2
						(temp3 say: &rest)
					)
				)
			)
			(else
				(temp1 say: &rest)
			)
		)
	)
)

