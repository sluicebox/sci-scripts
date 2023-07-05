;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use SpeakWindow)
(use DSelector)
(use DEdit)
(use Str)
(use Array)
(use Print)
(use Dialog)
(use Messager)
(use Talker)
(use Sync)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	proc17_0 0
	proc17_1 1
	proc17_2 2
	proc17_3 3
	proc17_4 4
	proc17_5 5
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
	[local10 70] = [0 0 0 1 0 5 0 7 0 3 0 2 0 6 0 8 0 4 0 10 0 25 0 24 22 1 22 2 22 3 22 4 22 5 22 6 22 7 22 8 22 9 22 10 0 17 0 18 0 21 0 11 0 14 0 22 0 23 0 26 0 27 0 28 0 29 0 30 0 31]
	[local80 6]
	local86
	local87
	[local88 18] = [28 27 26 26 25 26 26 26 27 28 27 27 29 27 28 26 27 27]
	[local106 18] = [28 30 26 30 27 27 30 28 27 28 29 26 31 30 29 28 30 28]
	[local124 18] = [30 27 26 30 25 26 26 26 27 28 27 27 29 27 28 26 27 27]
	[local142 14] = [2 4 1 6 1 3 1 0 0 4 0 1 5 2]
	local156
	local157
	local158
)

(procedure (localproc_2) ; UNUSED
	(self eachElementDo: #smile)
)

(procedure (localproc_3) ; UNUSED
	(self eachElementDo: #frown)
)

(procedure (proc17_0)
	(Characters sleep:)
)

(procedure (proc17_1)
	(Characters wakeUp:)
)

(procedure (proc17_2 param1 &tmp temp0 temp1 temp2)
	(proc17_3)
	(if (and argc (== gCardGameScriptNumber 200))
		(= temp1 (param1 view:))
		(if (== (param1 oldMaidStage:) 1)
			(param1 view: (+ (param1 view:) 250))
		)
		(if (== (param1 oldMaidStage:) 2)
			(param1 view: (+ (param1 view:) 220))
		)
	)
	(gATalker release:)
	(for ((= temp0 0)) (< temp0 (Characters size:)) ((++ temp0))
		(= temp2 (Characters at: temp0))
		(if (temp2 active:)
			(temp2 setCel: 0)
			(gATalker add: temp2)
		)
	)
	(if (gATalker size:)
		(proc0_9 (gATalker elements:) 1)
	)
	(gATalker release:)
	(if (and argc (== gCardGameScriptNumber 200))
		(param1 view: temp1)
	)
)

(procedure (localproc_4 param1 &tmp temp0 temp1)
	(= temp1 0)
	(for ((= temp0 0)) (< temp0 param1) ((++ temp0))
		(+= temp1 [local142 temp0])
	)
	(return temp1)
)

(procedure (localproc_5 param1 &tmp temp0 temp1) ; UNUSED
	(= temp0 (+ (GetTime) param1))
	(while (> temp0 (GetTime))
	)
)

(procedure (proc17_3 &tmp temp0)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(if
			(and
				(== ((Characters at: temp0) script:) doHabit)
				((Characters at: temp0) active:)
			)
			(DoAudio audSTOP 1019 (+ local157 1) 0 0 local156)
			((Characters at: temp0) setScript: 0)
			((Characters at: temp0) cycleSpeed: 2 setCel: 0 setCycle: BlinkFwd)
			(((Characters at: temp0) face:) hide:)
			((Characters at: temp0) sshow:)
			(proc64996_0)
		)
	)
)

(procedure (proc17_4 &tmp temp0 temp1 temp2 temp3)
	(if (== gCardGameScriptNumber 6005)
		(return)
	)
	(= temp0
		(switch gCardGameScriptNumber
			(100 3)
			(200 3)
			(300 3)
			(400 1)
			(500 1)
			(1100 3)
			(700 3)
			(1300 1)
			(1200 1)
		)
	)
	(if (not (Random 0 2))
		((Characters at: (Random 0 (- temp0 1))) say: 1000 2 86 0 1)
		(if (and (== temp0 3) (<= (Random 1 20) 9))
			(= temp1 (localproc_6))
			((Characters at: temp1) say: 1000 2 171 0 (Random 3 4))
			(if (<= (Random 1 20) 12)
				(= temp2 (localproc_6 temp1))
				((Characters at: temp2) say: 1000 2 171 0 (Random 1 2))
				(if (not (Random 0 1))
					(= temp3 (localproc_6 temp1 temp2))
					((Characters at: temp3) say: 1000 2 86 0 4)
				else
					(= global920 1)
					(gChar1 say: 15 15 86 0 (Random 1 2))
				)
			)
		)
	)
)

(procedure (localproc_6 param1 param2 &tmp temp0)
	(switch argc
		(0
			(return (Random 0 2))
		)
		(1
			(switch param1
				(0
					(return (Random 1 2))
				)
				(1
					(return (* (Random 0 1) 2))
				)
				(2
					(return (Random 0 1))
				)
			)
		)
		(2
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				(if (and (!= temp0 param1) (!= temp0 param2))
					(return temp0)
				)
			)
		)
	)
)

(procedure (proc17_5 &tmp temp0 temp1)
	(= temp1
		(switch gCardGameScriptNumber
			(100 2)
			(200 2)
			(300 2)
			(400 0)
			(500 0)
			(1100 2)
			(700 2)
			(1300 0)
			(1200 0)
			(else
				(return)
			)
		)
	)
	(= temp0 (Characters at: (Random 0 temp1)))
	(if
		(and
			(== (temp0 oldMaidStage:) 0)
			(or
				(== (temp0 script:) doHabit)
				(== gCardGameScriptNumber 6005)
				(== temp0 (Characters whosSleeping:))
			)
		)
		(return)
	)
	(if
		(and
			(not (Characters firstTrue: #script))
			(== (temp0 oldMaidStage:) 0)
			(Characters habitsOn:)
			(> global896 2)
		)
		(temp0 prevCycler: (temp0 cycler:))
		(temp0 prevScript: (temp0 script:))
		(temp0 prevView: (temp0 view:))
		(temp0 prevLoop: (temp0 loop:))
		(temp0 prevCel: (temp0 cel:))
		(proc64996_0)
		(temp0 setScript: doHabit)
	)
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
			(if (<= 1000 local1 1012)
				(local6 startAudio: local1 2 local3 0 local5)
			else
				(local6 startAudio: local1 local2 local3 0 local5)
			)
		)
		(= ticks (+ 100 local9))
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
			(if (== local86 4)
				(= temp0 (* local4 2))
				(= local8 1)
			else
				(= local87 1)
				(= temp0 (* [local80 local86] 2))
				(= [local80 local86] 0)
			)
			(DoAudio audWPLAY local1 1 [local10 temp0] 0 [local10 (+ temp0 1)])
			(local6 setCel: 0)
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
)

(class Character of Prop
	(properties
		priority 6
		face 0
		charScript 0
		active 0
		holdTalk 1800
		gender 0
		whoGetsCued 0
		offsetX 0
		offsetY 0
		prevCycler 0
		prevScript 0
		prevView 0
		prevLoop 0
		prevCel 0
		fallingAsleep 0
		oldMaidStage 0
	)

	(method (sshow)
		(super show:)
	)

	(method (init)
		(= cel 0)
		(self
			setPri: 200
			view: view
			loop: loop
			cel: cel
			cycleSpeed: 2
			setCycle: BlinkFwd
		)
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

	(method (smile))

	(procedure (localproc_0 param1 param2) ; UNUSED
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

	(method (frown))

	(procedure (localproc_1 param1 param2) ; UNUSED
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

	(method (sayReg param1 param2 param3 param4 param5 param6 param7 param8)
		(if (== global896 0)
			(if (>= argc 8)
				(param8 cue:)
			)
			(return)
		)
		(cond
			((== global896 1)
				(= param5 2)
			)
			((== global896 2)
				(if (not (Random 0 3))
					(= param5 1)
				else
					(= param5 2)
				)
			)
			((not (Random 0 1))
				(= param5 1)
			)
			(else
				(= param5 2)
			)
		)
		(cond
			((>= argc 8)
				(self
					say: param1 param2 param3 param4 param5 param6 param7 param8
				)
			)
			((== argc 7)
				(self say: param1 param2 param3 param4 param5 param6 param7)
			)
			(else
				(self say: param1 param2 param3 param4 param5)
			)
		)
	)

	(method (say6 param1 param2 param3 param4 param5 param6 param7 param8)
		(if (== global896 0)
			(if (>= argc 8)
				(param8 cue:)
			)
			(return)
		)
		(cond
			((== global896 1)
				(= param5 (Random 4 6))
			)
			((== global896 2)
				(if (not (Random 0 3))
					(= param5 (Random 1 3))
				else
					(= param5 (Random 4 6))
				)
			)
			((not (Random 0 1))
				(= param5 (Random 1 3))
			)
			(else
				(= param5 (Random 4 6))
			)
		)
		(cond
			((>= argc 8)
				(self
					say: param1 param2 param3 param4 param5 param6 param7 param8
				)
			)
			((== argc 7)
				(self say: param1 param2 param3 param4 param5 param6 param7)
			)
			(else
				(self say: param1 param2 param3 param4 param5)
			)
		)
	)

	(method (sayPN param1 param2 param3 param4 param5 param6 param7 param8 &tmp temp0)
		(if (or (== global896 0) (== global896 1))
			(if (>= argc 8)
				(param8 cue:)
			)
			(return)
		)
		(if (or (== gCardGameScriptNumber 1200) (== gCardGameScriptNumber 1300))
			(cond
				((== param3 82)
					(if (== param5 5)
						(for
							((= temp0 (Random 1 5)))
							(== temp0 5)
							((= temp0 (Random 1 5)))
						)
						(= param5 temp0)
					)
				)
				((or (== param5 4) (== param5 5))
					(for
						((= temp0 (Random 1 5)))
						(or (== temp0 4) (== temp0 5))
						((= temp0 (Random 1 5)))
					)
					(= param5 temp0)
				)
			)
		)
		(cond
			((== global896 2)
				(cond
					((not (Random 0 1))
						(cond
							((>= argc 8)
								(self
									say:
										param1
										param2
										param3
										param4
										param5
										param6
										param7
										param8
								)
							)
							((== argc 7)
								(self
									say:
										param1
										param2
										param3
										param4
										param5
										param6
										param7
								)
							)
							(else
								(self say: param1 param2 param3 param4 param5)
							)
						)
					)
					((>= argc 8)
						(param8 cue:)
					)
				)
			)
			((>= argc 8)
				(self
					say: param1 param2 param3 param4 param5 param6 param7 param8
				)
			)
			((== argc 7)
				(self say: param1 param2 param3 param4 param5 param6 param7)
			)
			(else
				(self say: param1 param2 param3 param4 param5)
			)
		)
	)

	(method (say param1 param2 param3 param4 param5 param6 param7 param8 &tmp [temp0 2] temp2 [temp3 2] temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13)
		(= temp13 (User controls:))
		(proc17_3)
		(= global918 (GetTime))
		(= temp2 (Str new:))
		(= temp7 (IntArray new: 4))
		(= global108 0)
		(= temp10 0)
		(if (and (== gCardGameScriptNumber 200) (>= view 250) (<= view 263))
			(= temp10 1)
			(= temp9 view)
			(-= view 250)
		)
		(if (and (== gCardGameScriptNumber 200) (>= view 220) (<= view 233))
			(= temp10 1)
			(= temp9 view)
			(-= view 220)
		)
		(= whoGetsCued 0)
		(if (>= argc 8)
			(= whoGetsCued param8)
		)
		(face setScript: 0)
		(= local6 self)
		(if
			(or
				(<= 100 gCardGameScriptNumber 800)
				(<= 1200 gCardGameScriptNumber 1300)
				(== gCardGameScriptNumber 1100)
			)
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
				(= local2 2)
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
					(if global916
						(= local1 (= param1 (- view 400)))
					else
						(= local1 (= param1 (+ view 1000)))
					)
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
			(if (== param1 -1)
				(temp2 format: {%s} param2)
			else
				(if (not param2)
					(= param2 (+ view 1))
				)
				(Message msgGET param1 param2 local3 local4 local5 (temp2 data:))
			)
			(if (or (== global896 0) (== (DoSound sndGET_AUDIO_CAPABILITY) 0))
				(= gMsgType 1)
				(= local0 0)
			else
				(= gMsgType 2)
				(= local0 1)
			)
			(if local0
				(proc17_2 self)
				(Load rsHEAP 64929)
				(Load rsSCRIPT 64929)
				(self startAudio: local1 local2 local3 0 local5)
				(if (and temp10 (== oldMaidStage 2))
					(face view: temp9)
				else
					(face view: view)
				)
				(face
					loop: (+ (self loop:) 2)
					cel: 0
					show:
					posn: (self x:) (self y:)
					init:
					setPri: (+ (self priority:) 1)
					setCycle: MouthSync local1 local2 local3 0 local5
				)
				(gATalker release:)
				(gATalker add: face)
				(DisableCursor)
				(proc0_7)
				(proc0_15)
				(for
					((= temp11 (Event new:)))
					(and
						(!= (temp11 type:) evMOUSEBUTTON)
						(or
							(!= (temp11 type:) evKEYBOARD)
							(and
								(== (temp11 type:) evKEYBOARD)
								(<= 58 (/ (temp11 message:) 256) 70)
							)
						)
						(!= (DoAudio audPOSITION local1 local2 local3 0 local5) -1)
						(< (GetTime) local158)
					)
					((= temp11 (Event new:)))
					
					(if (face cycler:)
						((face cycler:) doit:)
					)
					(if (gATalker size:)
						(proc0_9 (gATalker elements:) 1)
					)
					(temp11 dispose:)
				)
				(if
					(or
						(== (temp11 type:) evMOUSEBUTTON)
						(and
							(== (temp11 type:) evKEYBOARD)
							(or
								(< (/ (temp11 message:) 256) 58)
								(> (/ (temp11 message:) 256) 70)
							)
						)
					)
					(DoAudio audSTOP local1 local2 local3 0 local5)
				)
				(temp11 dispose:)
				(if temp13
					(EnableCursor)
				)
				(gATalker delete: face)
				(face hide:)
				(if whoGetsCued
					(whoGetsCued cue:)
				)
			else
				(proc17_2 self)
				(self startText: temp2)
				(if whoGetsCued
					(whoGetsCued cue:)
				)
			)
			(if temp10
				(= view temp9)
			)
			(proc64996_0)
			(= global918 (GetTime))
			(= global920 0)
			(temp2 dispose:)
			(temp7 dispose:)
			(RedrawCast)
		)
	)

	(method (startAudio param1 param2 param3 param4 param5 &tmp temp0)
		(if (> (= temp0 (* (= temp0 (gGame masterVolume:)) 14)) 127)
			(= temp0 127)
		)
		(= local9 (DoAudio audWPLAY param1 param2 param3 param4 param5 1 temp0))
		(DoAudio audRESUME param1 param2 param3 param4 param5 1 temp0)
		(= local158 (+ (= local158 (+ (GetTime) local9)) 60))
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

	(method (startText param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 [temp9 2] temp11 temp12 temp13 temp14 [temp15 4] temp19 temp20 temp21 temp22 temp23)
		(= temp0 (Str new:))
		(= temp1 (IntArray new: 4))
		(= temp2 (temp0 format: {%s} param1))
		(= local7 0)
		(self setLen: (temp0 size:))
		(if (& gMsgType $0001)
			(if (< (= temp4 (* (temp0 size:) 5)) 60)
				(= temp4 60)
			)
		else
			(face loop: (+ 0 (- loop 2)) show: init:)
			(face setCycle: MouthSync local1 local2 local3 0 local5)
			(self startAudio: local1 local2 local3 0 local5)
		)
		(gATalker release:)
		(gATalker add: face)
		(SpeakWindow speakObj: self)
		(Characters eachElementDo: #stop self)
		(if (== (self oldMaidStage:) 0)
			(RedrawCast)
		)
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
		(if (< (self x:) 318)
			(= temp6 (+ (self x:) temp8))
		else
			(= temp6 360)
		)
		(if (and (> temp11 (Print y:)) 1)
			(self move: 0 (- temp11 (Print y:)))
		)
		(Print x: temp6)
		(= temp22 0)
		(cond
			((<= (temp0 size:) 30)
				(= temp19 0)
			)
			((<= (temp0 size:) 60)
				(= temp19 1)
			)
			((<= (temp0 size:) 110)
				(= temp19 2)
			)
			(else
				(= temp19 3)
			)
		)
		(if (< temp11 200)
			(Print y: temp11)
		)
		(if (>= (characterPrint width:) 205)
			(characterPrint width: 200)
		)
		(characterPrint width: 100)
		(if (>= temp13 300)
			(= temp20 1)
		else
			(= temp20 0)
		)
		(if (or (== global896 0) (== global920 1))
			(Print x: -1 y: -1)
			(= temp20 2)
		)
		(Print
			mode: 1
			fore: 0
			font: gUserFont
			ticks: (+ temp4 (* global899 20))
			margin: 10
			addBitmap: 20 0 temp19
		)
		(Text 0 (temp1 data:) (temp2 data:) gUserFont (Print width:) 0)
		(= temp21 (/ (- (Print width:) (temp1 at: 2)) 2))
		(= temp22
			(/
				(-
					(= temp23 (- (CelHigh 20 1 temp19) (* 2 (Print margin:))))
					(temp1 at: 3)
				)
				2
			)
		)
		(if (> (temp1 at: 3) 1)
			(Print addText: temp2 temp21 temp22 init:)
		)
		(characterPrint width: temp5)
		(= gSystemPlane temp3)
		(gATalker delete: face)
		(temp0 dispose:)
		(temp1 dispose:)
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

	(method (setChar param1 param2 &tmp temp0)
		(switch param1
			(1
				(= global463 param2)
				(if global896
					(= global466 0)
				else
					(= global466 4)
				)
				(gChar1 view: global463 active: 1 loop: global466)
				((gChar1 face:) view: global463 loop: global466)
				(= gSkill global469)
			)
			(2
				(= global464 param2)
				(if global896
					(= global467 0)
				else
					(= global467 4)
				)
				(gChar2 view: global464 active: 1 loop: global467)
				((gChar2 face:) view: global464 loop: global467)
				(= global197 global470)
			)
			(3
				(= global465 param2)
				(if global896
					(= global468 1)
				else
					(= global468 4)
				)
				(gChar3 view: global465 active: 1 loop: global468)
				((gChar3 face:) view: global465 loop: global468)
				(= global198 global471)
			)
		)
	)

	(method (sleep)
		(= prevView (self view:))
		(= prevLoop (self loop:))
		(= prevCel (self cel:))
		(if script
			(return 0)
		else
			(self setScript: sleepScript)
			(return 1)
		)
	)

	(method (wakeUp)
		(if (and script (== (script state:) 1))
			(while (== (script state:) 1)
				(script cue:)
			)
		)
		(self setScript: wakeUpScript)
	)
)

(class Characters of List
	(properties
		habitsOn 1
		whosSleeping 0
	)

	(method (sleep &tmp temp0 [temp1 3] temp4 temp5 temp6)
		(= whosSleeping 0)
		(= temp6
			(switch gCardGameScriptNumber
				(100 3)
				(200 3)
				(300 3)
				(400 1)
				(500 1)
				(1100 3)
				(700 3)
				(1300 1)
				(1200 1)
			)
		)
		(= temp0 0)
		(for ((= temp5 0)) (< temp5 temp6) ((++ temp5))
			(= temp4 ((self at: temp5) view:))
			(if
				(and
					(== ((self at: temp5) oldMaidStage:) 0)
					(or
						(== temp4 0)
						(== temp4 1)
						(== temp4 2)
						(== temp4 3)
						(== temp4 4)
						(== temp4 9)
						(== temp4 13)
						(== temp4 5)
					)
				)
				(= [temp1 temp0] (self at: temp5))
				(++ temp0)
			)
		)
		(if (and temp0 (not (self firstTrue: #script)))
			(= whosSleeping [temp1 (- (= temp5 (Random 1 temp0)) 1)])
			(if (whosSleeping sleep:)
				(return 1)
			else
				(return 0)
			)
		else
			(return 0)
		)
	)

	(method (wakeUp)
		(whosSleeping wakeUp:)
		(= whosSleeping 0)
	)

	(method (init &tmp temp0)
		(= habitsOn 1)
		(= global918 (GetTime))
		(for ((= temp0 0)) (< temp0 size) ((++ temp0))
			(if ((self at: temp0) active:)
				(((self at: temp0) face:)
					init:
					hide:
					setPri: (((self at: temp0) face:) priority:)
				)
			)
			((self at: temp0) script: 0)
		)
		(proc64996_0)
	)

	(method (laugh))

	(method (smile))

	(method (frown))

	(method (sayReg param1 param2 param3 param4 param5 param6 param7 param8)
		(if (== global896 0)
			(if (>= argc 8)
				(param8 cue:)
			)
			(return)
		)
		(cond
			((== global896 1)
				(= param5 2)
			)
			((== global896 2)
				(if (not (Random 0 3))
					(= param5 1)
				else
					(= param5 2)
				)
			)
			((not (Random 0 1))
				(= param5 1)
			)
			(else
				(= param5 2)
			)
		)
		(cond
			((>= argc 8)
				(self
					say: param1 param2 param3 param4 param5 param6 param7 param8
				)
			)
			((== argc 7)
				(self say: param1 param2 param3 param4 param5 param6 param7)
			)
			(else
				(self say: param1 param2 param3 param4 param5)
			)
		)
	)

	(method (sayPN param1 param2 param3 param4 param5 param6 param7 param8)
		(if (or (== global896 0) (== global896 1))
			(if (>= argc 8)
				(param8 cue:)
			)
			(return)
		)
		(cond
			((== global896 2)
				(cond
					((not (Random 0 1))
						(cond
							((>= argc 8)
								(self
									say:
										param1
										param2
										param3
										param4
										param5
										param6
										param7
										param8
								)
							)
							((== argc 7)
								(self
									say:
										param1
										param2
										param3
										param4
										param5
										param6
										param7
								)
							)
							(else
								(self say: param1 param2 param3 param4 param5)
							)
						)
					)
					((>= argc 8)
						(param8 cue:)
					)
				)
			)
			((>= argc 8)
				(self
					say: param1 param2 param3 param4 param5 param6 param7 param8
				)
			)
			((== argc 7)
				(self say: param1 param2 param3 param4 param5 param6 param7)
			)
			(else
				(self say: param1 param2 param3 param4 param5)
			)
		)
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

(class BlinkFwd of Cycle
	(properties
		nextTime 0
		nextBlink 0
	)

	(method (init)
		(= nextTime (GetTime))
		(= nextBlink (+ 120 (Random 0 120)))
		(super init: &rest)
	)

	(method (doit &tmp temp0)
		(cond
			((< (Abs (- (GetTime) nextTime)) nextBlink)
				(return)
			)
			((!= (client cel:) (= temp0 (self nextCel:)))
				(if (> temp0 clientLastCel)
					(self cycleDone:)
				else
					(client cel: temp0)
				)
			)
		)
	)

	(method (cycleDone)
		(client cel: 0)
		(= nextTime (GetTime))
		(= nextBlink (+ 120 (Random 0 120)))
	)
)

(instance sleepScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(client
					setPri: 200
					view: (+ 1700 (client view:))
					loop: (client loop:)
					cel: 0
					setCycle: 0
				)
				(= temp0 0)
				(= temp1 (GetTime))
				(while (<= temp0 (client lastCel:))
					(if (>= (Abs (- (GetTime) temp1)) 5)
						(client setCel: temp0)
						(FrameOut)
						(UpdateScreenItem client)
						(++ temp0)
						(= temp1 (GetTime))
					)
				)
				(client
					setPri: 200
					view: (+ 1700 (client prevView:))
					loop: (+ (client loop:) 2)
					cel: 0
					fallingAsleep: 0
					cycleSpeed: 5
					setCycle: SleepFwd
				)
				(= temp0 0)
				(= temp1 (GetTime))
				(while (<= temp0 (client lastCel:))
					(if (>= (Abs (- (GetTime) temp1)) 5)
						(client setCel: temp0)
						(FrameOut)
						(UpdateScreenItem client)
						(++ temp0)
						(= temp1 (GetTime))
					)
				)
				(client setCel: 0)
				(FrameOut)
				(UpdateScreenItem client)
				(self dispose:)
			)
		)
	)
)

(instance wakeUpScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(client
					setPri: 200
					view: (+ 1700 (client prevView:))
					loop: (+ (client loop:) 2)
					cel: 0
					setCycle: 0
				)
				(= temp0 0)
				(= temp1 (GetTime))
				(while (<= temp0 (client lastCel:))
					(if (>= (Abs (- (GetTime) temp1)) 5)
						(client setCel: temp0)
						(FrameOut)
						(UpdateScreenItem client)
						(++ temp0)
						(= temp1 (GetTime))
					)
				)
				(client
					setPri: 200
					view: (client prevView:)
					loop: (client prevLoop:)
					cel: (client prevCel:)
					cycleSpeed: 2
					init:
					setCycle: BlinkFwd
				)
				(client prevView: 0)
				(client prevCycler: 0)
				(client prevLoop: 0)
				(client prevCel: 0)
				(client prevScript: 0)
				(client setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance doHabit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local157 (client view:))
				(= local156 (Random 1 [local142 local157]))
				(if (== local157 0)
					(= local156 1)
				)
				(Load rsVIEW (+ 1500 (localproc_4 local157) (- local156 1)))
				(client setCycle: 0)
				(= ticks 1)
			)
			(1
				(gATalker release:)
				(gATalker add: (client face:))
				(client startAudio: 1019 (+ local157 1) 0 0 local156)
				((client face:)
					setPri: (+ (client priority:) 1)
					view: (+ 1500 (localproc_4 local157) (- local156 1))
					loop: (client loop:)
					cel: 0
					show:
					posn: (client x:) (client y:)
					setCycle: MouthSync 1019 (+ local157 1) 0 0 local156
					init:
				)
				(client hide:)
				(= ticks 1)
			)
			(2
				(= ticks 1)
			)
			(3
				(if (!= (DoAudio audPOSITION 1019 (+ local157 1) 0 0 local156) -1)
					(if ((client face:) cycler:)
						(((client face:) cycler:) doit:)
					)
					(if (gATalker size:)
						(proc0_9 (gATalker elements:) 1)
					)
					(-- state)
				)
				(= ticks 1)
			)
			(4
				(client sshow:)
				((client face:) hide:)
				(client setCel: 0)
				(= ticks 1)
			)
			(5
				(= ticks 10)
			)
			(6
				(gATalker delete: (client face:))
				(UnLoad 128 (+ 1500 (localproc_4 local157) (- local156 1)))
				(client
					setPri: 200
					view: (client prevView:)
					loop: (client prevLoop:)
					cel: (client prevCel:)
					cycleSpeed: 2
					setCycle: BlinkFwd
				)
				(if (== global896 0)
					(if (== gCardGameScriptNumber 1300)
						((Characters at: 0) setLoop: 4)
					else
						((Characters at: 0) setLoop: 4)
						((Characters at: 1) setLoop: 4)
						((Characters at: 2) setLoop: 4)
					)
				)
				(client prevView: 0)
				(client prevCycler: 0)
				(client prevLoop: 0)
				(client prevCel: 0)
				(client prevScript: 0)
				(client setScript: 0)
				(= ticks 1)
			)
		)
	)
)

(class SleepFwd of Cycle
	(properties
		nextTime 0
		nextSnore 0
	)

	(method (init &tmp temp0 temp1)
		(super init: &rest)
		(if (== (client view:) 1701)
			(= temp0 (Random 0 75))
			(= temp1 25)
		else
			(= temp0 (Random 0 120))
			(= temp1 150)
		)
		(= nextTime (GetTime))
		(= nextSnore (+ temp0 temp1))
	)

	(method (doit &tmp temp0 temp1)
		(cond
			((< (Abs (- (GetTime) nextTime)) nextSnore)
				(return)
			)
			((!= (client cel:) (= temp0 (self nextCel:)))
				(if (> temp0 clientLastCel)
					(self cycleDone:)
				else
					(client cel: temp0)
				)
			)
		)
	)

	(method (cycleDone &tmp temp0 temp1)
		(client cel: 0)
		(if (== (client view:) 1701)
			(= temp1 (Random 0 75))
			(= temp0 25)
		else
			(= temp1 (Random 0 120))
			(= temp0 150)
		)
		(= nextTime (GetTime))
		(= nextSnore (+ temp1 temp0))
	)
)

