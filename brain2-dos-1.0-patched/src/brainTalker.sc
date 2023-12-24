;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use Talker)
(use Sync)
(use Actor)

(public
	brainTalker 0
)

(local
	local0
	local1
)

(instance brainTalker of Talker
	(properties
		x 238
		y 119
		view 32
		talkWidth 224
		font 999
		color 2
		back 44
		textX -233
		textY 156
	)

	(method (init)
		(= local0 (GetPort))
		(SetPort 0)
		(= bust watchBust)
		(= mouth watchMouth)
		(= local1 0)
		(super init: &rest)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(= gMsgType 1)
		)
		(super dispose: param1 &rest)
		(DoAudio audSTOP)
		(SetPort local0)
	)

	(method (say)
		(if (DoSound sndGET_AUDIO_CAPABILITY)
			(= gMsgType 2)
		)
		(super say: &rest)
		(if (and (DoSound sndGET_AUDIO_CAPABILITY) global132)
			(-= ticks 60)
		)
	)

	(method (startAudio param1 param2 param3 param4 param5)
		(if (not local1)
			(self show:)
		)
		(= ticks (DoAudio audPLAY param1 param2 param3 param4 param5))
		(if mouth
			(mouth setCycle: MouthSync param1 param2 param3 param4 param5)
		)
		(if (and eyes (not (eyes cycler:)))
			(eyes setCycle: Blink blinkSpeed)
		)
	)

	(method (doit)
		(if
			(and
				(!= ticks -1)
				(> (- gGameTime ticks) 0)
				(if global83
					(== (DoAudio audPOSITION) -1)
				else
					1
				)
			)
			(cond
				((not global132)
					(self dispose: disposeWhenDone)
					(return 0)
				)
				((not local1)
					(++ local1)
					(self startAudio: 20 2 9 0 (+ global133 1))
					(+= ticks (+ gTickOffset (GetTime)))
				)
				((== local1 1)
					(++ local1)
					(self startAudio: 20 3 9 0 global132)
					(+= ticks (+ gTickOffset (GetTime)))
				)
				(else
					(self dispose: disposeWhenDone)
					(return 0)
				)
			)
		)
		(if mouth
			(self cycle: mouth)
		)
		(return 1)
	)

	(method (hide &tmp temp0 temp1)
		(= temp1 (GetPort))
		(SetPort 0)
		(Graph grRESTORE_BOX underBits)
		(= underBits 0)
		(Graph
			grUPDATE_BOX
			(self nsTop:)
			(self nsLeft:)
			(self nsBottom:)
			(self nsRight:)
			1
		)
		(SetPort temp1)
		(if (and gTheIconBar (not global122))
			(gTheIconBar enable:)
		)
	)
)

(instance watchBust of Prop
	(properties
		nsTop 16
		nsLeft 14
		view 32
		cel 1
	)
)

(instance watchMouth of Prop
	(properties
		nsTop 28
		nsLeft 28
		view 32
		loop 1
	)
)

