;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 928)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use RandCycle)
(use Actor)
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

(class Talker of Prop
	(properties
		bust 0
		eyes 0
		mouth 0
		ticks 0
		disposeWhenDone 1
		caller 0
		viewInPrint 0
		useFrame 0
		talkWidth 318
		charNum 0
		modNum -1
		keepWindow 0
		cycleEyes 1
	)

	(method (init param1 param2 param3 param4 param5 param6 param7 &tmp temp0)
		(if argc
			(= bust param1)
			(if (>= argc 2)
				(= eyes param2)
				(if (>= argc 3)
					(= mouth param3)
					(if (>= argc 5)
						(= disposeWhenDone param5)
						(if (>= argc 6)
							(= caller param6)
							(if (>= argc 7)
								(= modNum param7)
							)
						)
					)
				)
			)
		)
		(self setSize:)
		(if (>= argc 4)
			(self say: param4 disposeWhenDone caller)
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

	(method (show &tmp pnv)
		(if (== view -1)
			(return)
		)
		(if (not underBits)
			(= underBits (Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1))
		)
		(= pnv (PicNotValid))
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
		(PicNotValid pnv)
	)

	(method (say param1 param2 param3)
		(gTheIconBar disable:)
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (>= argc 2)
			(= disposeWhenDone param2)
			(if (>= argc 3)
				(= caller param3)
			)
		)
		(if global83
			(self startAudio: param1)
		else
			(self startText: param1)
		)
		((if (IsObject gFastCast)
				gFastCast
			else
				(= gFastCast (EventHandler new:))
			)
			add: self
		)
		(+= ticks (+ 60 gGameTime))
	)

	(method (startText param1 &tmp [temp0 500] temp500)
		(proc932_8 charNum modNum param1 @temp0)
		(= ticks (* 5 (= temp500 (StrLen @temp0))))
		(if viewInPrint
			(self display: @temp0)
		else
			(self show:)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(self display: @temp0)
		)
		(if mouth
			(mouth setCycle: RTRandCycle ticks)
		)
		(if eyes
			(eyes setCycle: RTRandCycle (if cycleEyes -1 else ticks))
		)
		(if (not keepWindow)
			(= ticks (Max 240 (* 8 temp500)))
		)
	)

	(method (display &tmp temp0 temp1)
		(if viewInPrint
			(= temp0
				(if useFrame
					loop
				else
					(bust loop:)
				)
			)
			(Print
				&rest
				#at
				(- nsLeft 3)
				(- nsTop 3)
				#dispose
				#title
				name
				#icon
				view
				temp0
				cel
			)
		else
			(if (> (+ x talkWidth) 318)
				(= temp1 (- 318 x))
			else
				(= temp1 talkWidth)
			)
			(Print &rest #at x y #dispose #title name #width temp1)
		)
	)

	(method (startAudio &tmp temp0)
		(self show:)
		(= temp0 modNum)
		(DoAudio audWPLAY temp0)
		(if mouth
			(mouth setCycle: Unknown_Class_38 temp0)
		)
		(= ticks (DoAudio audPLAY temp0))
		(if eyes
			(eyes setCycle: RTRandCycle (if cycleEyes -1 else ticks))
		)
	)

	(method (cycle obj &tmp theCel [str 100])
		(if (and obj (obj cycler:))
			(= theCel (obj cel:))
			((obj cycler:) doit:)
			(if (!= theCel (obj cel:))
				(DrawCel
					(obj view:)
					(obj loop:)
					(obj cel:)
					(+ (obj nsLeft:) nsLeft)
					(+ (obj nsTop:) nsTop)
					-1
				)
				(obj
					nsRight:
						(+
							(obj nsLeft:)
							(CelWide
								(obj view:)
								(obj loop:)
								(obj cel:)
							)
						)
				)
				(obj
					nsBottom:
						(+
							(obj nsTop:)
							(CelHigh
								(obj view:)
								(obj loop:)
								(obj cel:)
							)
						)
				)
				(Graph
					grUPDATE_BOX
					(+ (obj nsTop:) nsTop)
					(+ (obj nsLeft:) nsLeft)
					(+ (obj nsBottom:) nsTop)
					(+ (obj nsRight:) nsLeft)
					1
				)
			)
		)
	)

	(method (doit)
		(if
			(and
				(not keepWindow)
				(> gGameTime ticks)
				(< (- gGameTime ticks) 28672)
			)
			(self dispose: disposeWhenDone)
			(return)
		)
		(if mouth
			(self cycle: mouth)
		)
		(if eyes
			(self cycle: eyes)
		)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(return)
		)
		(if
			(or
				(& (event type:) $4101) ; evVERB | evJOYDOWN | evMOUSEBUTTON
				(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
			)
			(event claimed: 1)
			(self dispose: disposeWhenDone)
		)
	)

	(method (hide)
		(Graph grRESTORE_BOX underBits)
		(= underBits 0)
		(Graph grREDRAW_BOX nsTop nsLeft nsBottom nsRight)
		(gTheIconBar enable:)
	)

	(method (dispose dWD &tmp toCue)
		(gFastCast release: dispose:)
		(= gFastCast 0)
		(if (or (not argc) dWD)
			(if (and mouth (mouth cycler:))
				(if ((mouth cycler:) respondsTo: #cue)
					((mouth cycler:) cue:)
				)
				(mouth setCycle: 0)
			)
			(cond
				(global83
					(DoAudio audSTOP)
				)
				(gModelessDialog
					(gModelessDialog dispose:)
				)
			)
			(if eyes
				(eyes setCycle: 0)
			)
			(self hide:)
			(= modNum -1)
		)
		(if caller
			(= toCue caller)
			(= caller 0)
			(toCue cue:)
		)
		(DisposeClone self)
	)
)

(class Narrator of Talker
	(properties
		x -1
		y -1
		view -1
		talkWidth 0
		charNum 99
		keepWindow 1
		msgs 0
		eraseOnly 0
	)

	(method (init param1 param2)
		(= eraseOnly (or eraseOnly (gSystemWindow eraseOnly:)))
		(if (>= argc 2)
			(= caller param2)
		)
		(super init: 0 0 0 param1 1 caller &rest)
	)

	(method (store param1 &tmp temp0)
		(for ((= temp0 0)) (<= temp0 (- argc 1)) ((++ temp0))
			(= msgs (or msgs (List new:)))
			(msgs addToEnd: [param1 temp0])
		)
	)

	(method (display &tmp temp0)
		(= temp0 (gSystemWindow eraseOnly:))
		(gSystemWindow eraseOnly: eraseOnly)
		(super display: &rest)
		(gSystemWindow eraseOnly: temp0)
	)

	(method (posn param1 param2)
		(if (>= argc 1)
			(= x param1)
			(if (>= argc 2)
				(= y param2)
			)
		)
	)

	(method (dispose &tmp temp0)
		(if (IsObject msgs)
			(if (msgs size:)
				(self init: (= temp0 (msgs at: 0)))
				(msgs delete: temp0)
				(return)
			else
				(msgs dispose:)
				(= msgs 0)
			)
		)
		(= y (= x -1))
		(= eraseOnly (= modNum (= talkWidth 0)))
		(super dispose: &rest)
	)
)

