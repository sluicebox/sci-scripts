;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2000)
(include sci.sh)
(use Main)
(use BalloonTalker)
(use TalkerWindow)
(use BalloonWindow)
(use Print)
(use Talker)
(use Actor)
(use System)

(public
	pepperHeadTalk 0
	setUpPepper 1
	pepperBalloon 2
	PepperTalker 3
)

(local
	local0
	local1
)

(instance pepperHeadTalk of Talker
	(properties
		talkWidth 120
		color 15
		back 41
		view 2000
		textX 130
	)

	(method (dispose)
		(= gSystemWindow local0)
		(super dispose: &rest)
		(Animate (gCast elements:) 0)
	)

	(method (init)
		(= local0 gSystemWindow)
		(= gSystemWindow TalkerWindow)
		(super init: 0 0 pepperEyes pepperFrame &rest)
	)
)

(instance pepperFrame of View
	(properties
		x 9
		y 14
		loop 3
		priority 15
		signal 24592
	)
)

(instance pepperEyes of Prop
	(properties
		loop 2
		priority 15
		signal 24592
	)
)

(instance PepperTalker of BalloonTalker
	(properties
		talkWidth 0
	)

	(method (init &tmp temp0)
		((ScriptID 895 0) setMotion: 0) ; pepper
		(cond
			((== global194 48)
				(pepperMouth view: 2000)
			)
			((!= talkLoop -1)
				(if (OneOf talkLoop 0 1 2)
					(= temp0 2001)
				else
					(= temp0 2009)
				)
				(pepperMouth
					view: temp0
					x: ((ScriptID 895 0) x:) ; pepper
					y: ((ScriptID 895 0) y:) ; pepper
					loop: talkLoop
					cycleSpeed: cSpeed
					scaleSignal: ((ScriptID 895 0) scaleSignal:) ; pepper
					scaleX: ((ScriptID 895 0) scaleX:) ; pepper
					scaleY: ((ScriptID 895 0) scaleY:) ; pepper
				)
				(self priority: ((ScriptID 895 0) priority:)) ; pepper
			)
			(
				(and
					(== ((ScriptID 895 0) loop:) 8) ; pepper
					(OneOf ((ScriptID 895 0) cel:) 0 1 2 4 5) ; pepper
					(== ((ScriptID 895 0) view:) 800) ; pepper
				)
				(if (OneOf ((ScriptID 895 0) cel:) 0 1 2) ; pepper
					(= temp0 2001)
				else
					(= temp0 2009)
				)
				(pepperMouth
					view: temp0
					x: ((ScriptID 895 0) x:) ; pepper
					y: ((ScriptID 895 0) y:) ; pepper
					loop: ((ScriptID 895 0) cel:) ; pepper
					cycleSpeed: cSpeed
					scaleSignal: ((ScriptID 895 0) scaleSignal:) ; pepper
					scaleX: ((ScriptID 895 0) scaleX:) ; pepper
					scaleY: ((ScriptID 895 0) scaleY:) ; pepper
				)
				(self priority: ((ScriptID 895 0) priority:)) ; pepper
			)
			(
				(and
					(== ((ScriptID 895 0) loop:) 8) ; pepper
					(OneOf ((ScriptID 895 0) cel:) 0 1 2 4 5) ; pepper
					(== ((ScriptID 895 0) view:) 790) ; pepper
				)
				(if (OneOf ((ScriptID 895 0) cel:) 0 1 2) ; pepper
					(= temp0 2002)
				else
					(= temp0 2010)
				)
				(pepperMouth
					view: temp0
					x: ((ScriptID 895 0) x:) ; pepper
					y: ((ScriptID 895 0) y:) ; pepper
					loop: ((ScriptID 895 0) cel:) ; pepper
					cycleSpeed: cSpeed
					scaleSignal: ((ScriptID 895 0) scaleSignal:) ; pepper
					scaleX: ((ScriptID 895 0) scaleX:) ; pepper
					scaleY: ((ScriptID 895 0) scaleY:) ; pepper
				)
				(self priority: ((ScriptID 895 0) priority:)) ; pepper
			)
			(else
				(pepperMouth view: 2000)
			)
		)
		(self posnBalloon: (ScriptID 895 0)) ; pepper
		(if (!= (pepperMouth view:) 2000)
			((ScriptID 895 0) hide:) ; pepper
			(= hidden 1)
		)
		(super init: pepperMouth 0 0 0 &rest)
	)

	(method (posnBalloon param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp4 150)
		(= x (param1 x:))
		(= y (param1 y:))
		(SetNowSeen param1)
		(= temp0 (param1 nsTop:))
		(= temp1 (param1 nsLeft:))
		(= temp2 (param1 nsBottom:))
		(= temp3 (param1 nsRight:))
		(cond
			((+ winX winY))
			((<= x 130)
				(if (<= y 92)
					(= x (- temp3 10))
					(= y (+ temp0 30))
					(= tailPosn 3)
				else
					(= x (- temp3 10))
					(= y (+ temp0 5))
					(= tailPosn 0)
				)
				(+= x offX)
				(+= y offY)
				(= temp4 150)
			)
			((<= x 173)
				(if (<= y 92)
					(= x (- temp3 10))
					(= y (+ temp0 30))
					(= tailPosn 3)
				else
					(= x (- temp3 10))
					(= y (+ temp0 5))
					(= tailPosn 0)
				)
				(+= x offX)
				(+= y offY)
				(= temp4 130)
			)
			(else
				(if (<= y 92)
					(= x (- temp1 145))
					(= y (+ temp0 30))
					(= tailPosn 4)
				else
					(= x (- temp1 145))
					(= y (+ temp0 5))
					(= tailPosn 1)
				)
				(+= x offX)
				(+= y offY)
				(= temp4 150)
			)
		)
		(if (or (not talkWidth) (not forceWidth))
			(= talkWidth temp4)
		)
	)

	(method (say)
		(if (and dontUpd (not hidden))
			((ScriptID 895 0) stopUpd:) ; pepper
		)
		(super say: &rest)
	)

	(method (dispose)
		(pepperMouth view: 2000)
		(if hidden
			((ScriptID 895 0) show:) ; pepper
			(= hidden 0)
		)
		(Animate (gCast elements:) 0)
		(super dispose: &rest)
		(if ((ScriptID 895 0) cycler:) ; pepper
			((ScriptID 895 0) startUpd:) ; pepper
		)
	)
)

(instance pepperMouth of TalkerMouth
	(properties
		view 0
		signal 24576
	)
)

(instance setUpPepper of Code
	(properties)

	(method (doit param1)
		(if (== gCurRoomNum 530)
			(= local1 1)
		)
		(switch param1
			(1
				(pepperHeadTalk view: 3001 x: 46 y: 86)
				(pepperFrame view: 3001)
				(pepperEyes view: 3001 x: 63 y: 73)
			)
			(12
				(pepperHeadTalk view: 3002 y: 84)
				(if local1
					(pepperHeadTalk textX: -155 textY: 10 x: 210 talkWidth: 135)
				else
					(pepperHeadTalk x: 45)
				)
				(pepperFrame view: 3002 x: (if local1 174 else 9))
				(pepperEyes view: 3002 x: (if local1 228 else 63) y: 71)
			)
			(23
				(pepperHeadTalk view: 3003 x: (if local1 229 else 64) y: 73)
				(if local1
					(pepperHeadTalk textX: -155 textY: 10 talkWidth: 135)
				)
				(pepperFrame view: 3003 x: (if local1 173 else 9) y: 14)
				(pepperEyes view: 3003 x: (if local1 208 else 43) y: 52)
			)
		)
	)
)

(instance pepperBalloon of Talker
	(properties
		x 60
		y 10
		talkWidth 140
		view 2000
	)

	(method (init)
		(Load rsVIEW 914)
		(Load rsVIEW 915)
		(super init: &rest)
	)

	(method (display param1 &tmp temp0 [temp1 4] temp5 temp6 temp7)
		(cond
			((< (gEgo x:) 105)
				(= temp5 2)
				(= temp6 5)
			)
			((< (gEgo x:) 195)
				(= temp5 3)
				(= temp6 0)
			)
			(else
				(= temp5 1)
				(= temp6 0)
			)
		)
		(cond
			((<= (gEgo y:) 60)
				(= temp7 5)
			)
			((<= (gEgo y:) 100)
				(= temp7 60)
			)
			((<= (gEgo y:) 115)
				(= temp7 80)
			)
			((<= (gEgo y:) 150)
				(= temp7 100)
			)
			(else
				(= temp7 128)
			)
		)
		(TextSize @temp1 param1 0 talkWidth)
		((= temp0 (BalloonWindow new:))
			x: x
			y: y
			height: (- [temp1 2] [temp1 0])
			width: (- [temp1 3] [temp1 1])
			tailCel: temp5
			tailOffset: temp6
			tailScale: temp7
		)
		((Print new:)
			window: temp0
			font: 0
			width: talkWidth
			title: 0
			modeless: 1
			addText: param1
			init:
		)
	)
)

