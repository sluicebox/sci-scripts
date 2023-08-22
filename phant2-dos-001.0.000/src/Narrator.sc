;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64984)
(include sci.sh)
(use Main)
(use WriteFeature)
(use System)

(class Narrator of Obj
	(properties
		ticks 0
		caller 0
		message 0
		textView 0
	)

	(method (init)
		(& state $0003)
		(super init:)
	)

	(method (dispose)
		(if (& state $0004)
			(PrintDebug {Disposing of active talker!\n})
			(SetDebug self)
			(self done: 1)
		)
		(&= state $fffb)
		(&= state $fffc)
		(super dispose:)
	)

	(method (display param1)
		(textView setText: param1 setSize: init:)
	)

	(method (doit)
		(if (not (& state $0004))
			(PrintDebug {Inactive Talker receiving doit\n})
			(SetDebug self)
		)
		(if (== ticks -1)
			(return)
		)
		(if
			(and
				(> (- gGameTime ticks) 0)
				(if (& gMsgType $0002)
					(==
						-1
						(DoAudio
							audPOSITION
							(message modNum:)
							(message noun:)
							(message verb:)
							(message case:)
							(message sequence:)
						)
					)
				else
					1
				)
			)
			(self done: 0)
		)
	)

	(method (done param1)
		((gUser hogs:) pop:)
		(gCast delete: self)
		(if textView
			(textView dispose:)
		)
		(DoAudio
			audSTOP
			(message modNum:)
			(message noun:)
			(message verb:)
			(message case:)
			(message sequence:)
		)
		(if caller
			(Cue new: caller (if argc param1 else 0))
		)
		(= caller (= message (= ticks 0)))
		(&= state $fffb)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (not (& state $0004))
			(PrintDebug {Inactive Talker receiving an event\n})
			(SetDebug self)
		)
		(= temp4 (= temp3 0))
		(= temp0 (event type:))
		(= temp1 (event modifiers:))
		(= temp2 (event message:))
		(cond
			((& temp0 evMOUSERELEASE)
				(= temp4 1)
				(if (& temp1 emSHIFT)
					(= temp3 1)
				)
			)
			((& temp0 evKEYUP)
				(if (== temp2 KEY_RETURN)
					(= temp4 1)
				)
				(if (== temp2 KEY_ESCAPE)
					(= temp4 (= temp3 1))
				)
			)
			((& temp0 $0040) ; joyDown
				(= temp4 1)
			)
		)
		(if temp4
			(self done: temp3)
		)
		(event claimed: self)
	)

	(method (say param1 param2)
		(if (not (& state $0003))
			(self init:)
		)
		(if (& state $0004)
			(PrintDebug {Active Talker receiving SAY\n})
			(SetDebug self)
		)
		(= message param1)
		(= caller (if (and (> argc 1) param2) param2))
		(if (& gMsgType $0001)
			(self startText: param1)
		)
		(if (& gMsgType $0002)
			(self startAudio: param1)
		)
		(if (not (or (& gMsgType $0001) (& gMsgType $0002)))
			(PrintDebug {Narrator cannot say message\n})
			(SetDebug self)
		)
		(+= ticks gGameTime)
		(gCast add: self)
		((gUser hogs:) push: self 0)
		(|= state $0004)
	)

	(method (startText param1 &tmp temp0)
		(= temp0 (param1 size:))
		(= ticks (Max 120 (* temp0 gTextSpeed)))
		(self display: param1)
		(return ticks)
	)

	(method (startAudio param1)
		(= ticks
			(DoAudio
				audPLAY
				(param1 modNum:)
				(param1 noun:)
				(param1 verb:)
				(param1 case:)
				(param1 sequence:)
			)
		)
		(++ ticks)
	)
)

