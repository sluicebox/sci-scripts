;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use SpeakWindow)
(use Print)
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
	[local9 70] = [0 0 0 1 0 5 0 7 0 3 0 2 0 6 0 8 0 4 0 10 0 25 0 24 22 1 22 2 22 3 22 4 22 5 22 6 22 7 22 8 22 9 22 10 0 17 0 18 0 21 0 11 0 14 0 22 0 23 0 26 0 27 0 28 0 29 0 30 0 31]
	[local79 6]
	local85
	local86
	[local87 18] = [28 27 26 26 25 26 26 26 27 28 27 27 29 27 28 26 27 27]
	[local105 18] = [28 30 26 30 27 27 30 28 27 28 29 26 31 30 29 28 30 28]
	[local123 18] = [30 27 26 30 25 26 26 26 27 28 27 27 29 27 28 26 27 27]
)

(instance characterPrint of Print
	(properties)

	(method (init)
		(if (& gMsgType $0002)
			(local5 startAudio: local0 1 local2 0 local4)
		)
		(super init:)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if
			(and
				(== gMsgType 2)
				(or (== (DoAudio audPOSITION) local8) (== (DoAudio audPOSITION) -1))
				(not local7)
				local3
				[local79 local85]
			)
			(DoAudio audSTOP)
			(if (== local85 4)
				(= temp0 (* local3 2))
				(= local7 1)
			else
				(= local86 1)
				(= temp0 (* [local79 local85] 2))
				(= [local79 local85] 0)
			)
			(DoAudio audWPLAY local0 1 [local9 temp0] 0 [local9 (+ temp0 1)])
			((local5 face:)
				setCycle:
					MouthSync
					local0
					1
					[local9 temp0]
					0
					[local9 (+ temp0 1)]
			)
			(local5 startAudio: local0 1 [local9 temp0] 0 [local9 (+ temp0 1)])
		)
		(if (gATalker size:)
			(Animate (gATalker elements:) 1)
		)
	)
)

(class Character of View
	(properties
		loop 2
		priority 6
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
		(= priority 6)
		(DrawCel view loop cel offsetX offsetY priority)
		(= nsTop offsetY)
		(= nsLeft offsetX)
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
	)

	(method (show)
		(return 0)
	)

	(method (posn param1 param2)
		(if (>= argc 2)
			(= offsetY (- (= y param2) [local105 view]))
		)
		(if (>= argc 1)
			(= x param1)
			(if (== loop 2)
				(= offsetX (- param1 [local87 view]))
			else
				(= offsetX (- param1 [local123 view]))
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
			(face startUpd: loop: (+ 4 (- loop 2)) setScript: charScript init:)
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
			(face startUpd: loop: (+ 6 (- loop 2)) setScript: charScript init:)
		)
	)

	(method (say param1 param2 param3 param4 param5 param6 param7 param8 &tmp temp0 temp1 [temp2 502] temp504 temp505 [temp506 4] temp510)
		(= global108 0)
		(= whoGetsCued 0)
		(if (>= argc 8)
			(= whoGetsCued param8)
		)
		(face setScript: 0)
		(= local5 self)
		(if (<= 100 global193 800)
			(= local7 0)
			(= local86 0)
			(= [local79 4] 999)
			(= [local79 5]
				(= [local79 3]
					(= [local79 2] (= [local79 1] (= [local79 0] 0)))
				)
			)
			(= local85 4)
			(if (and (== param1 -1) (> argc 2))
				(= local0 (+ view 1000))
				(= local1 1)
				(= local2 [local9 (= temp510 (* param3 2))])
				(= local3 1)
				(= local4 [local9 (+ temp510 1)])
				(= local85 0)
				(if (>= argc 4)
					(= [local79 0] param4)
				)
				(if (>= argc 5)
					(= [local79 1] param5)
				)
				(if (>= argc 6)
					(= [local79 2] param6)
				)
				(if (>= argc 7)
					(= [local79 3] param7)
				)
			else
				(if (== param1 1000)
					(= local0 (= param1 (+ view 1000)))
				else
					(= local0 param1)
				)
				(if param2
					(= local1 param2)
				)
				(= local2 param3)
				(= local3 (if (>= argc 4) param4 else 0))
				(= local4 (if (>= argc 5) param5 else 1))
				(= global108 (if (>= argc 6) param6 else 0))
				(= temp504 (if (>= argc 7) param7 else 0))
			)
			(if (and (not temp504) (Random 0 5))
				(= global108 0)
			)
			(cond
				((== param1 -1)
					(Format @temp2 param2)
				)
				((and (>= param1 1000) (!= local2 23))
					(Message msgGET 1020 1 local2 local3 local4 @temp2)
				)
				(else
					(if (not param2)
						(= param2 (+ view 1))
					)
					(Message msgGET param1 param2 local2 local3 local4 @temp2)
				)
			)
			(if (and (DoSound sndGET_AUDIO_CAPABILITY) global454 (>= local0 1000))
				(= gMsgType 2)
				(= global83 1)
			else
				(= gMsgType 1)
				(= global83 0)
			)
			(if active
				(self startText: @temp2)
			else
				(= temp0 (GetPort))
				(SetPort 0)
				(TextSize @[temp506 0] temp2 2107 0)
				(Print width: [temp506 3] font: 2107 addText: @temp2 init:)
				(SetPort temp0)
			)
			(if global108
				(= global108 0)
			)
			(proc0_1)
		)
	)

	(method (startAudio param1 param2 param3 param4 param5)
		(= local8 (DoAudio audWPLAY param1 param2 param3 param4 param5))
		(DoAudio audPLAY param1 param2 param3 param4 param5)
		(if local86
			(++ local85)
		)
	)

	(method (startText param1 &tmp [temp0 400] [temp400 4] temp404 temp405 temp406 temp407 temp408)
		(= temp404 (Format @temp0 param1))
		(= local6 0)
		(self setLen: (StrLen @temp0))
		(if (== view 3)
			(face cel: 9)
		)
		(face loop: (+ 0 (- loop 2)) show: startUpd: init:)
		(if (& gMsgType $0001)
			(if (< (= temp407 (* (StrLen @temp0) 4)) 40)
				(= temp407 40)
			)
			(face setCycle: RandCycle temp407 self 1)
		else
			(SpeakWindow alternate: 1)
			(face setCycle: MouthSync local0 local1 local2 0 local4)
		)
		(gATalker release:)
		(gATalker add: face)
		(SpeakWindow speakObj: self)
		(TextSize @[temp400 0] temp404 gUserFont 0)
		(Characters eachElementDo: #stop self)
		(proc0_1)
		(= temp408 (characterPrint width:))
		(if (not global109)
			(characterPrint width: [temp400 3])
			(if (< [temp400 3] 60)
				(characterPrint width: 80)
			)
		else
			(characterPrint width: global109)
		)
		(= temp405 gSystemWindow)
		((= gSystemWindow SpeakWindow) color: 0 back: 7)
		(= temp406 (GetPort))
		(SetPort 0)
		(characterPrint
			font: gUserFont
			ticks: holdTalk
			mode: 1
			addText: temp404
			init:
		)
		(SetPort temp406)
		(SpeakWindow alternate: 0)
		(characterPrint width: temp408)
		(= gSystemWindow temp405)
		(gATalker delete: face)
		(if global108
			(self global108:)
		else
			(face setCycle: 0 hide: forceUpd:)
			(if whoGetsCued
				(whoGetsCued cue:)
			)
		)
	)

	(method (setLen param1)
		(if (< param1 1)
			(= param1 1)
		)
		(if global83
			(= holdTalk (+ (/ (* param1 60) 20) 240))
		else
			(= holdTalk (+ (/ (* param1 60) 20) (* global386 60)))
			(if (== global386 15)
				(= holdTalk 29998)
			)
		)
		(/= holdTalk 60)
		(if (< holdTalk 3)
			(= holdTalk 3)
		)
	)

	(method (cue)
		(face cel: 0 forceUpd: setCycle: 0)
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

