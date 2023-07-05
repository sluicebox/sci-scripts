;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 928)
(include sci.sh)
(use Main)
(use EcoFeature)
(use EcoDialog)
(use Sync)
(use RandCycle)
(use System)

(class RTRandCycle of RandCycle
	(properties)

	(method (doit &tmp theTime)
		(if (or (> count (= theTime (GetTime))) (== count -1))
			(if (> (- theTime cycleCnt) (client cycleSpeed:))
				(client cel: (self nextCel:))
				(= cycleCnt (GetTime))
			)
		else
			(client cel: 0)
			(self cycleDone:)
		)
	)

	(method (init obj theTime whoCares)
		(super init: obj)
		(client cel: 0)
		(= cycleCnt (GetTime))
		(if (>= argc 2)
			(if (!= theTime -1)
				(= count (+ (GetTime) theTime))
			else
				(= count -1)
			)
			(if (>= argc 3)
				(= caller whoCares)
			)
		else
			(= count -1)
		)
	)
)

(class EcoTalker of EcoProp
	(properties
		bust 0
		eyes 0
		mouth 0
		ticks 0
		disposeWhenDone 1
		caller 0
		useFrame 0
		talkWidth 318
		viewInPrint 0
		cueVal 0
		modeless 0
		killIt 0
		charNum 0
		keepWindow 0
		cycleEyes 1
		tNoun 0
		curVolume -1
	)

	(method (init param1 param2 param3 param4 param5 param6 param7 param8 param9 param10 &tmp temp0)
		(if argc
			(= bust param1)
			(if (>= argc 2)
				(= eyes param2)
				(if (>= argc 3)
					(= mouth param3)
					(if (>= argc 4)
						(= tNoun param4)
						(if (>= argc 8)
							(= disposeWhenDone param8)
							(if (>= argc 9)
								(= caller param9)
								(if (>= argc 10)
									(= modNum param10)
								)
							)
						)
					)
				)
			)
		)
		(self setSize:)
		(if (>= argc 4)
			(self say: param5 param6 param7)
		)
	)

	(method (setSize)
		(= nsRight
			(+
				nsLeft
				(Max
					(if (!= view -1)
						(CelWide view loop cel)
					else
						0
					)
					(and
						(IsObject bust)
						(+
							(bust nsLeft:)
							(CelWide (bust view:) (bust loop:) (bust cel:))
						)
					)
					(and
						(IsObject eyes)
						(+
							(eyes nsLeft:)
							(CelWide (eyes view:) (eyes loop:) (eyes cel:))
						)
					)
					(and
						(IsObject mouth)
						(+
							(mouth nsLeft:)
							(CelWide (mouth view:) (mouth loop:) (mouth cel:))
						)
					)
				)
			)
		)
		(= nsBottom
			(+
				nsTop
				(Max
					(if (!= view -1)
						(CelHigh view loop cel)
					else
						0
					)
					(and
						(IsObject bust)
						(+
							(bust nsTop:)
							(CelHigh (bust view:) (bust loop:) (bust cel:))
						)
					)
					(and
						(IsObject eyes)
						(+
							(eyes nsTop:)
							(CelHigh (eyes view:) (eyes loop:) (eyes cel:))
						)
					)
					(and
						(IsObject mouth)
						(+
							(mouth nsTop:)
							(CelHigh (mouth view:) (mouth loop:) (mouth cel:))
						)
					)
				)
			)
		)
	)

	(method (show &tmp temp0)
		(if (== view -1)
			(return)
		)
		(if (not underBits)
			(= underBits (Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1))
		)
		(= temp0 (PicNotValid))
		(PicNotValid 1)
		(if bust
			(DrawCel
				(bust view:)
				(bust loop:)
				(bust cel:)
				(+ (bust nsLeft:) nsLeft)
				(+ (bust nsTop:) nsTop)
				-1
			)
		)
		(if eyes
			(DrawCel
				(eyes view:)
				(eyes loop:)
				(eyes cel:)
				(+ (eyes nsLeft:) nsLeft)
				(+ (eyes nsTop:) nsTop)
				-1
			)
		)
		(if mouth
			(DrawCel
				(mouth view:)
				(mouth loop:)
				(mouth cel:)
				(+ (mouth nsLeft:) nsLeft)
				(+ (mouth nsTop:) nsTop)
				-1
			)
		)
		(DrawCel view loop cel nsLeft nsTop -1)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(PicNotValid temp0)
	)

	(method (say param1 param2 param3 &tmp temp0)
		(if (not gModelessDialog)
			(gTheIconBar disable:)
		)
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (& gMsgType $0002)
			(= curVolume (gGame masterVolume:))
			(if (>= (gGame masterVolume:) 4)
				(gGame masterVolume: (- curVolume 4))
			)
		)
		(cond
			((> param3 72)
				(-= param3 72)
				(cond
					((== global251 1)
						(= param2 2)
					)
					((== global251 2)
						(= param2 1)
					)
				)
			)
			((> param3 36)
				(-= param3 36)
				(= param2 global251)
			)
		)
		(if (& gMsgType $0001)
			(self startText: param1 param2 param3)
		)
		(if (& gMsgType $0002)
			(self startAudio: param1 param2 param3)
		)
		(cond
			(modeless
				(gMouseDownHandler addToFront: self)
				(gKeyDownHandler addToFront: self)
				(gTheDoits add: self)
			)
			((IsObject gFastCast)
				(gFastCast add: self)
			)
			(else
				((= gFastCast (EventHandler new:)) add: self)
			)
		)
		(+= ticks (+ 60 gGameTime))
		(if (and (not modeless) gFastCast)
			(while gFastCast
				(gFastCast eachElementDo: #doit)
				(if (and ((= temp0 (Event new:)) type:) gFastCast)
					(gFastCast firstTrue: #handleEvent temp0)
				)
				(if temp0
					(temp0 dispose:)
				)
				(= gGameTime (+ gTickOffset (GetTime)))
				(gSounds eachElementDo: #check)
			)
		)
		(return 1)
	)

	(method (startText param1 param2 param3 &tmp [temp0 500] temp500)
		(Message msgGET modNum tNoun param1 param2 param3 @temp0)
		(= ticks (* 5 (= temp500 (StrLen @temp0))))
		(self show:)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(self display: @temp0)
		(if mouth
			(mouth setCycle: RTRandCycle ticks)
		)
		(if eyes
			(eyes setCycle: RTRandCycle (if cycleEyes -1 else ticks))
		)
		(if (not keepWindow)
			(= ticks (Max 100 (* 2 temp500)))
		)
	)

	(method (display)
		(= x (+ nsRight 15))
		(= y nsTop)
		(proc821_1 &rest 64 x y 111 77 name)
	)

	(method (startAudio param1 param2 param3)
		(self show:)
		(if mouth
			(mouth setCycle: MouthSync modNum tNoun param1 param2 param3)
			(if (not (mouth cycler:))
				(mouth setCycle: RTRandCycle)
			)
		)
		(if (and eyes (not (eyes cycler:)))
			(eyes setCycle: RTRandCycle (if cycleEyes -1 else ticks))
		)
		(= ticks (DoAudio audPLAY modNum tNoun param1 param2 param3))
	)

	(method (cycle param1 &tmp temp0 [temp1 100])
		(if (and param1 (param1 cycler:))
			(= temp0 (param1 cel:))
			((param1 cycler:) doit:)
			(if (!= temp0 (param1 cel:))
				(DrawCel
					(param1 view:)
					(param1 loop:)
					(param1 cel:)
					(+ (param1 nsLeft:) nsLeft)
					(+ (param1 nsTop:) nsTop)
					-1
				)
				(param1
					nsRight:
						(+
							(param1 nsLeft:)
							(CelWide
								(param1 view:)
								(param1 loop:)
								(param1 cel:)
							)
						)
				)
				(param1
					nsBottom:
						(+
							(param1 nsTop:)
							(CelHigh
								(param1 view:)
								(param1 loop:)
								(param1 cel:)
							)
						)
				)
				(Graph
					grUPDATE_BOX
					(+ (param1 nsTop:) nsTop)
					(+ (param1 nsLeft:) nsLeft)
					(+ (param1 nsBottom:) nsTop)
					(+ (param1 nsRight:) nsLeft)
					1
				)
			)
		)
	)

	(method (doit)
		(cond
			(killIt
				(= killIt 0)
				(self dispose: disposeWhenDone)
			)
			(
				(and
					(> (- gGameTime ticks) 0)
					(if (& gMsgType $0002)
						(== (DoAudio audPOSITION) -1)
					else
						1
					)
					(or (not keepWindow) (not (& gMsgType $0001)))
				)
				(self cue:)
				(return 0)
			)
		)
		(if mouth
			(self cycle: mouth)
		)
		(if eyes
			(self cycle: eyes)
		)
		(return 1)
	)

	(method (handleEvent event)
		(cond
			((event claimed:))
			((== ticks -1)
				(return 0)
			)
			(else
				(switch (event type:)
					(evJOYDOWN
						(= cueVal 0)
					)
					(evMOUSEBUTTON
						(= cueVal (& (event modifiers:) emSHIFT))
					)
					(evKEYBOARD
						(= cueVal (== (event message:) KEY_ESCAPE))
					)
				)
				(if
					(and
						(or
							(& (event type:) $4101) ; evVERB | evJOYDOWN | evMOUSEBUTTON
							(and
								(& (event type:) evKEYBOARD)
								(OneOf (event message:) KEY_RETURN KEY_ESCAPE)
							)
						)
						(not killIt)
					)
					(self cue:)
				)
			)
		)
	)

	(method (cue)
		(if (not modeless)
			(gTheDoits add: self)
		)
		(= killIt 1)
		(if (& gMsgType $0002)
			(gGame masterVolume: curVolume)
		)
		(if (and gFastCast (gFastCast contains: self))
			(gFastCast delete: self)
			(if (gFastCast isEmpty:)
				(gFastCast dispose:)
				(= gFastCast 0)
			)
		)
	)

	(method (hide)
		(Graph grRESTORE_BOX underBits)
		(= underBits 0)
		(Graph grREDRAW_BOX nsTop nsLeft nsBottom nsRight)
		(gTheIconBar enable:)
	)

	(method (dispose param1 &tmp temp0)
		(if (and mouth (mouth cycler:))
			(if ((mouth cycler:) respondsTo: #cue)
				((mouth cycler:) cue:)
			)
			(mouth setCycle: 0)
		)
		(if (or (not argc) param1)
			(if modeless
				(gMouseDownHandler delete: self)
				(gKeyDownHandler delete: self)
			)
			(if eyes
				(eyes setCycle: 0)
			)
			(self hide:)
			(= modNum -1)
		)
		(if (& gMsgType $0002)
			(DoAudio audSTOP)
		)
		(if (and param1 gModelessDialog)
			(gModelessDialog dispose:)
		)
		(gTheDoits delete: self)
		(Animate (gCast elements:) 0)
		(if caller
			(= temp0 caller)
			(= caller 0)
			(temp0 cue: cueVal)
		)
		(= cueVal 0)
		(DisposeClone self)
	)
)

(class EcoNarrator of EcoTalker
	(properties
		x -1
		y -1
		talkWidth 0
		charNum 99
		keepWindow 1
		eraseOnly 0
		origNarNum 0
		inInv 0
		store 0
		isStored 0
	)

	(method (init param1 param2 param3 param4 param5 param6)
		(= eraseOnly (or eraseOnly (gSystemWindow eraseOnly:)))
		(if (>= argc 5)
			(= caller param5)
			(if (>= argc 6)
				(= modNum param6)
			)
		)
		(if
			(and
				(not (== (= origNarNum param1) (+ global250 1)))
				(>= param4 100)
			)
			(+= param1 1)
			(-= param4 100)
		)
		(= tNoun param1)
		(super say: param2 param3 param4)
	)

	(method (doit)
		(cond
			(killIt
				(= killIt 0)
				(self dispose: disposeWhenDone)
			)
			(
				(and
					(> (- gGameTime ticks) 0)
					(if (& gMsgType $0002)
						(== (DoAudio audPOSITION) -1)
					else
						1
					)
					(or (not keepWindow) (not (& gMsgType $0001)))
				)
				(if isStored
					(= isStored (= store 0))
				)
				(self cue:)
				(return 0)
			)
		)
		(if mouth
			(self cycle: mouth)
		)
		(if eyes
			(self cycle: eyes)
		)
		(return 1)
	)

	(method (handleEvent event)
		(cond
			((event claimed:))
			((== ticks -1)
				(return 0)
			)
			(else
				(switch (event type:)
					(evJOYDOWN
						(= cueVal 0)
					)
					(evMOUSEBUTTON
						(= cueVal (& (event modifiers:) emSHIFT))
					)
					(evKEYBOARD
						(= cueVal (== (event message:) KEY_ESCAPE))
					)
				)
				(if
					(or
						(& (event type:) $4101) ; evVERB | evJOYDOWN | evMOUSEBUTTON
						(and
							(& (event type:) evKEYBOARD)
							(OneOf (event message:) KEY_RETURN KEY_ESCAPE)
						)
					)
					(if isStored
						(= isStored (= store 0))
					)
					(if (not killIt)
						(self cue:)
					)
				)
			)
		)
	)

	(method (cue)
		(if (not inInv)
			(gTheDoits add: self)
		)
		(= killIt 1)
		(if (& gMsgType $0002)
			(gGame masterVolume: curVolume)
		)
		(if (and gFastCast (gFastCast contains: self) (not store))
			(gFastCast delete: self)
			(if (gFastCast isEmpty:)
				(gFastCast dispose:)
				(= gFastCast 0)
			)
		)
		(if inInv
			(= killIt 0)
			(self dispose: disposeWhenDone)
		)
	)

	(method (startText param1 param2 param3 &tmp [temp0 500] temp500)
		(Message msgGET modNum tNoun param1 param2 param3 @temp0)
		(= ticks (* 5 (= temp500 (StrLen @temp0))))
		(self show:)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(self display: @temp0)
		(if (not keepWindow)
			(= ticks (Max 240 (* 8 temp500)))
		)
	)

	(method (display &tmp temp0)
		(= temp0 (gSystemWindow eraseOnly:))
		(gSystemWindow eraseOnly: eraseOnly)
		(proc821_1 &rest 64 x y 111 77 name)
		(gSystemWindow eraseOnly: temp0)
	)

	(method (startAudio param1 param2 param3)
		(= ticks (DoAudio audPLAY modNum tNoun param1 param2 param3))
	)

	(method (posn param1 param2)
		(if (>= argc 1)
			(= x param1)
			(if (>= argc 2)
				(= y param2)
			)
		)
	)

	(method (dispose param1 &tmp temp0 temp1)
		(if store
			(= killIt 0)
			(= isStored 1)
			(self init: tNoun 0 0 store caller modNum)
		)
		(if killIt
			(= killIt 0)
		)
		(= tNoun origNarNum)
		(= origNarNum 0)
		(= y (= x -1))
		(= eraseOnly (= modNum (= talkWidth 0)))
		(if (and mouth (mouth cycler:))
			(if ((mouth cycler:) respondsTo: #cue)
				((mouth cycler:) cue:)
			)
			(mouth setCycle: 0)
		)
		(if (or (not argc) param1)
			(if eyes
				(eyes setCycle: 0)
			)
			(self hide:)
			(= modNum -1)
		)
		(if (and gModelessDialog (or param1 (& gMsgType $0001)))
			(gModelessDialog dispose:)
		)
		(if (& gMsgType $0002)
			(DoAudio audSTOP)
		)
		(if (not inInv)
			(gTheDoits delete: self)
			(Animate (gCast elements:) 0)
		)
		(if caller
			(= temp1 caller)
			(= caller 0)
			(temp1 cue: cueVal)
		)
		(= cueVal 0)
		(DisposeClone self)
	)
)

