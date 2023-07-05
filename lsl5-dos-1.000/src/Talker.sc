;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 928)
(include sci.sh)
(use Main)
(use Interface)
(use RandCycle)
(use Actor)
(use System)

(class RTRandCycle of RandCycle
	(properties)

	(method (doit &tmp theTime)
		(if (> count (= theTime (GetTime)))
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
			(= count (+ (GetTime) theTime))
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
	)

	(method (init bustView prop syncedProp modNum charNum msgNum dWD whoCares &tmp pnv)
		(if argc
			(= bust bustView)
			(if (>= argc 2)
				(= eyes prop)
				(if (>= argc 3)
					(= mouth syncedProp)
					(if (>= argc 7)
						(= disposeWhenDone dWD)
						(if (>= argc 8)
							(= caller whoCares)
						)
					)
				)
			)
		)
		(++ gTalkersOnScreen)
		(self setSize:)
		(if (>= argc 4)
			(self say: modNum charNum msgNum disposeWhenDone caller)
		)
	)

	(method (setSize)
		(= nsRight
			(+
				nsLeft
				(Max
					(CelWide view loop cel)
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
					(CelHigh view loop cel)
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

	(method (say modNum charNum msgNum dWD whoCares)
		(gTheIconBar disable:)
		(if (>= argc 4)
			(= disposeWhenDone dWD)
			(if (>= argc 5)
				(= caller whoCares)
			)
		)
		(if global83
			(self startAudio: modNum charNum msgNum)
		else
			(self startText: modNum charNum msgNum)
		)
		((if (IsObject gFastCast)
				gFastCast
			else
				(= gFastCast (EventHandler new:))
			)
			add: self
		)
		(+= ticks (+ 60 (GetTime)))
	)

	(method (startText param1 param2 &tmp [temp0 500] temp500 temp501)
		(if viewInPrint
			(= temp500
				(if useFrame
					loop
				else
					(bust loop:)
				)
			)
			(Format @temp0 param1 param2)
			(= ticks (Max 180 (/ (* global155 (StrLen @temp0)) 2)))
			(if mouth
				(mouth setCycle: RTRandCycle ticks)
			)
			(if eyes
				(eyes setCycle: RTRandCycle ticks)
			)
			(Print
				@temp0
				#at
				(- nsLeft 3)
				(- nsTop 3)
				#dispose
				#title
				name
				#icon
				view
				temp500
				cel
			)
		else
			(self show:)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(Format @temp0 param1 param2)
			(= ticks (Max 180 (/ (* global155 (StrLen @temp0)) 2)))
			(if mouth
				(mouth setCycle: RTRandCycle ticks)
			)
			(if eyes
				(eyes setCycle: RTRandCycle ticks)
			)
			(if (> (+ x talkWidth) 318)
				(= temp501 (- 318 x))
			else
				(= temp501 talkWidth)
			)
			(Print @temp0 #at x y #dispose #title name #width temp501)
		)
	)

	(method (startAudio theKeys &tmp temp0)
		(self show:)
		(= temp0 theKeys)
		(DoAudio audWPLAY temp0)
		(if mouth
			(mouth setCycle: Unknown_Class_40 temp0)
		)
		(= ticks (DoAudio audPLAY temp0))
		(if eyes
			(eyes setCycle: RTRandCycle ticks)
		)
	)

	(method (cycle obj &tmp theCel)
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
		(if (> (GetTime) ticks)
			(self dispose: disposeWhenDone)
			(return)
		)
		(if eyes
			(self cycle: eyes)
		)
		(if mouth
			(self cycle: mouth)
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
		(-- gTalkersOnScreen)
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
		)
		(if caller
			(= toCue caller)
			(= caller 0)
			(toCue cue:)
		)
		(DisposeClone self)
	)
)

