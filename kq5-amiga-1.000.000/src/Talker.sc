;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 928)
(include sci.sh)
(use Main)
(use Interface)
(use Sync)
(use RandCycle)
(use Actor)
(use System)

(class RTRandCycle of RandCycle
	(properties)

	(method (doit &tmp theTime)
		(if (> count (= theTime (GetTime)))
			(if
				(or
					(> (- theTime cycleCnt) (client cycleSpeed:))
					(== theTime (/ count 2))
				)
				(client cel: (self nextCel:))
				(= cycleCnt (GetTime))
			)
		else
			(client cel: 0)
			(self cycleDone:)
		)
	)

	(method (nextCel &tmp temp0)
		(return
			(if (or (<= (Random 1 10) 8) (!= (client cel:) 0))
				0
			else
				(- (NumCels client) 1)
			)
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
		(self show:)
		(if (>= argc 4)
			(self say: modNum charNum msgNum disposeWhenDone caller)
		)
	)

	(method (show &tmp pnv)
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
		(if gFastCast
			(gFastCast add: self)
		else
			(= gFastCast (EventHandler new:))
			(gFastCast name: {fastCast} add: self)
		)
		(+= ticks (+ 60 (GetTime)))
	)

	(method (startText param1 param2 &tmp [temp0 500])
		(Format @temp0 param1 param2)
		(= ticks (* 5 (StrLen @temp0)))
		(if mouth
			(mouth setCycle: RTRandCycle ticks)
		)
		(if eyes
			(eyes setCycle: RTRandCycle ticks)
		)
		(Print @temp0 #at x y #dispose)
	)

	(method (startAudio theKeys &tmp temp0 [temp1 10])
		(= temp0 theKeys)
		(DoAudio audWPLAY temp0)
		(if mouth
			(mouth setCycle: MouthSync temp0)
		)
		(= ticks (DoAudio audPLAY temp0))
		(if eyes
			(eyes setCycle: RTRandCycle ticks)
		)
		(if global100
			(Display
				(Format @temp1 928 0 temp0) ; "%d"
				dsCOORD
				(+ nsLeft 15)
				(+ nsTop 3)
				dsFONT
				999
				dsCOLOR
				1
			)
		)
	)

	(method (cycle obj &tmp theCel)
		(if (and obj (obj cycler:))
			(= theCel (obj cel:))
			(if (> (GetTime) (- ticks 50))
				(obj setCel: (if (== obj eyes) 0 else 4))
			else
				((obj cycler:) doit:)
			)
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
		(if (> (GetTime) (- ticks 10))
			(mouth setCel: 4)
			(if (and (> (GetTime) ticks) (== (DoAudio audPOSITION) -1))
				(self dispose: disposeWhenDone)
				(return)
			)
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
				(& (event type:) evMOUSEBUTTON)
				(& (event type:) evVERB)
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
	)

	(method (dispose dWD &tmp toCue)
		(gFastCast delete: self release:)
		(gFastCast dispose:)
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

