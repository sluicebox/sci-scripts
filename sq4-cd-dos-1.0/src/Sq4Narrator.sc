;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 817)
(include sci.sh)
(use Main)
(use Sq4Dialog)
(use Talker)
(use Sync)
(use Actor)
(use System)

(class Sq4Narrator of Narrator
	(properties
		noun 100
		returnVal 0
		returnVal1 0
		returnVal2 0
		returnVal3 0
		nMsgType -1
		oldMsgType 0
		tpType 0
	)

	(method (say)
		(if (> nMsgType -1)
			(= oldMsgType gMessageMode)
			(= gMessageMode (if (== oldMsgType 1) 1 else nMsgType))
		)
		(super say: &rest)
	)

	(method (default)
		(self
			returnVal:
				0
				returnVal1
				0
				returnVal2
				0
				returnVal3
				0
				nMsgType
				-1
				oldMsgType
				0
				x
				-1
				y
				-1
				caller
				0
				modNum
				-1
				disposeWhenDone
				1
				ticks
				0
				talkWidth
				0
				keepWindow
				0
				modeless
				0
				font
				0
				talkerNum
				99
				cueVal
				0
				initialized
				0
				showTitle
				0
				msgList
				0
				curVolume
				0
				saveCursor
				0
				voiceRate
				0
		)
	)

	(method (startText param1 param2 param3 param4 param5 param6)
		(if (< argc 2)
			(= param6 0)
		)
		(= tpType param6)
		(super startText: param1 param2 param3 param4 param5 tpType &rest)
	)

	(method (display &tmp [temp0 100])
		(switch tpType
			(1
				(= returnVal (Display &rest dsSAVEPIXELS 114)) ; p_dispose
			)
			(2
				(= returnVal (proc0_12 &rest 111))
			)
			(else
				(proc816_1 &rest 111)
			)
		)
	)

	(method (dispose)
		(if (and (> nMsgType -1) (== nMsgType gMessageMode))
			(= gMessageMode oldMsgType)
		)
		(switch tpType
			(1
				(if returnVal
					(Display 817 0 dsRESTOREPIXELS returnVal)
					(if returnVal1
						(Display 817 0 dsRESTOREPIXELS returnVal1)
						(if returnVal2
							(Display 817 0 dsRESTOREPIXELS returnVal2)
							(if returnVal3
								(Display 817 0 dsRESTOREPIXELS returnVal3)
							)
						)
					)
				)
			)
			(2
				(if returnVal
					(proc0_12 returnVal)
					(if returnVal1
						(proc0_12 returnVal1)
						(if returnVal2
							(proc0_12 returnVal2)
							(if returnVal3
								(proc0_12 returnVal3)
							)
						)
					)
				)
			)
		)
		(super dispose: &rest)
	)
)

(class FaceTalker of Sq4Narrator
	(properties
		disposeWhenDone 0
		talkWidth 318
		modeless 1
		bust 0
		eyes 0
		mouth 0
		viewInPrint 0
		textX 0
		textY 0
		blinkSpeed 100
		finalMouth 4
		sChannel 0
	)

	(method (init param1 param2 param3)
		(if argc
			(= bust param1)
			(if (>= argc 2)
				(= eyes param2)
				(if (>= argc 3)
					(= mouth param3)
				)
			)
		)
		(super init:)
	)

	(method (show)
		(if bust
			(bust show:)
		)
		(if eyes
			(eyes show:)
		)
		(if mouth
			(mouth show:)
		)
	)

	(method (startText param1 param2 param3 param4 param5 param6 &tmp temp0)
		(if (not viewInPrint)
			(self show:)
		)
		(= temp0
			(super startText: param1 param2 param3 param4 param5 param6 &rest)
		)
		(if mouth
			(mouth setCycle: RTRandCycle (* 3 temp0))
		)
		(if (and eyes (not (eyes cycler:)))
			(eyes setCycle: Blink blinkSpeed)
		)
		(return temp0)
	)

	(method (startAudio param1)
		(self show:)
		(if mouth
			(mouth setCycle: MouthSync modNum talkerNum 0 param1 1)
		)
		(super startAudio: param1 &rest)
		(if (and eyes (not (eyes cycler:)))
			(eyes setCycle: Blink blinkSpeed)
		)
	)

	(method (hide)
		(if bust
			(bust hide:)
		)
		(if eyes
			(eyes hide:)
		)
		(if mouth
			(mouth hide:)
		)
	)

	(method (dispose param1)
		(if (and mouth (!= finalMouth -1))
			(mouth cel: 4)
		)
		(if (and mouth (mouth cycler:))
			(if ((mouth cycler:) respondsTo: #cue)
				((mouth cycler:) cue:)
			)
			(mouth setCycle: 0)
		)
		(if eyes
			(eyes setCycle: 0 cel: 0)
		)
		(if (or (not argc) param1)
			(self hide:)
		)
		(super dispose: param1)
	)
)

(class Sq4Talker of Talker
	(properties
		cycleSpeed 30
		talkWidth 0
		bustLoop 0
		mouthLoop 1
		eyeLoop 2
		number 0
		mouthOffsetX 0
		mouthOffsetY 0
		eyeOffsetX 0
		eyeOffsetY 0
		client 0
		limitToScreen 1
		sChannel 0
		tStyle 0
		returnVal 0
		returnVal1 0
		returnVal2 0
		returnVal3 0
		nMsgType -1
		oldMsgType 0
		tpType 0
	)

	(method (init param1)
		(if argc
			(self client: param1)
		)
		(super init: &rest)
		(self loop: bustLoop initTopLeft:)
		(if (> bustLoop -1)
			((= bust (Prop new:))
				name: {bust}
				view: view
				loop: bustLoop
				nsLeft: 0
				nsTop: 0
			)
		)
		(if (> eyeLoop -1)
			((= eyes (Prop new:))
				name: {eyes}
				view: view
				loop: eyeLoop
				nsLeft: eyeOffsetX
				nsTop: eyeOffsetY
			)
		)
		(if (> mouthLoop -1)
			((= mouth (Prop new:))
				name: {mouth}
				view: view
				loop: mouthLoop
				nsLeft: mouthOffsetX
				nsTop: mouthOffsetY
			)
		)
		(self setSize:)
		(self modifyNS:)
		(= initialized 1)
	)

	(method (say)
		(if (> nMsgType -1)
			(= gMessageMode
				(if (not (& (= oldMsgType gMessageMode) $0002))
					(& $fffd nMsgType)
				else
					nMsgType
				)
			)
		)
		(super say: &rest)
	)

	(method (modifyNS &tmp temp0 temp1 temp2)
		(= temp0 (- nsBottom nsTop))
		(= temp1 (- nsRight nsLeft))
		(cond
			((< tStyle 666)
				(self
					nsLeft:
						(Min (Max 10 nsLeft) (- 319 (+ 10 temp1)))
					nsTop:
						(if (or (== tStyle 5) (== tStyle 4))
							(- (self nsTop:) (/ temp0 2))
						else
							(Min
								(Max 10 nsTop)
								(- 189 (+ 10 temp0))
							)
						)
				)
			)
			(limitToScreen
				(self
					nsLeft: (Min (Max 0 nsLeft) (- 319 temp1))
					nsTop: (Min (Max 0 nsTop) (- 189 temp0))
				)
			)
		)
		(self nsRight: (+ nsLeft temp1) nsBottom: (+ nsTop temp0))
	)

	(method (initTopLeft)
		(cond
			((< tStyle 6)
				(switch tStyle
					(0
						(self x: 0 y: 0)
					)
					(1
						(self x: 319 y: 0)
					)
					(2
						(self x: 0 y: 189)
					)
					(3
						(self x: 319 y: 189)
					)
					(4
						(self x: 0 y: 94)
					)
					(5
						(self x: 319 y: 94)
					)
				)
			)
			((not (or nsTop nsLeft))
				(self x: 159 y: 0)
			)
		)
	)

	(method (startText param1 param2 param3 param4 param5 param6 &tmp temp0)
		(if (< argc 2)
			(= param6 0)
		)
		(= tpType param6)
		(= talkWidth
			(super startText: param1 param2 param3 param4 param5 tpType &rest)
		)
	)

	(method (display &tmp temp0 temp1)
		(cond
			((OneOf tStyle 0 4 2)
				(= temp1 (= textX (+ nsRight 10)))
				(= textY (+ nsTop 3))
			)
			((OneOf tStyle 1 5 3)
				(= textX 3)
				(= temp1 (+ (- nsRight nsLeft) 10))
				(= textY (+ nsTop 3))
			)
		)
		(if (> (+ temp1 talkWidth) 320)
			(= temp0 (- 320 temp1))
		else
			(= temp0 talkWidth)
		)
		(proc816_1 &rest 67 temp0 64 textX textY 111)
	)

	(method (dispose &tmp temp0)
		(if (and (> nMsgType -1) (== nMsgType gMessageMode))
			(= gMessageMode oldMsgType)
		)
		(switch tpType
			(1
				(if returnVal
					(Display returnVal)
					(if returnVal1
						(Display returnVal1)
						(if returnVal2
							(Display returnVal2)
							(if returnVal3
								(Display returnVal3)
							)
						)
					)
				)
			)
			(2
				(if returnVal
					(proc0_12 returnVal)
					(if returnVal1
						(proc0_12 returnVal1)
						(if returnVal2
							(proc0_12 returnVal2)
							(if returnVal3
								(proc0_12 returnVal3)
							)
						)
					)
				)
			)
		)
		(if disposeWhenDone
			(if bust
				(bust dispose: delete:)
				(= bust 0)
			)
			(if eyes
				(eyes dispose: delete:)
				(= eyes 0)
			)
			(if mouth
				(mouth dispose: delete:)
				(= mouth 0)
			)
		)
		(super dispose: &rest)
	)
)

(class Sq4GlobalNarrator of Sq4Narrator
	(properties
		defaultOnDispose 1
	)

	(method (dispose)
		(super dispose: &rest)
		(if defaultOnDispose
			(self default:)
		)
	)
)

