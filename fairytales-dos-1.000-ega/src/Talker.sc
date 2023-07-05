;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 928)
(include sci.sh)
(use Main)
(use n010)
(use Interface)
(use Sync)
(use Osc)
(use RandCycle)
(use Actor)
(use System)

(class RTRandCycle of RandCycle
	(properties)

	(method (doit &tmp theTime)
		(if (u> (- (= theTime (GetTime)) cycleCnt) (client cycleSpeed:))
			(client cel: (self nextCel:))
			(= cycleCnt (GetTime))
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

(class eyeOsc of Osc
	(properties)

	(method (init)
		(super init: &rest)
		(client cycleSpeed: (Random 100 200))
		(= cycleCnt (GetTime))
	)

	(method (nextCel &tmp temp0)
		(cond
			((<= (- (= temp0 (GetTime)) cycleCnt) (client cycleSpeed:))
				(return (client cel:))
			)
			((and (== (client cel:) 1) (< cycleDir 0))
				(client cycleSpeed: (Random 150 400))
				(return 0)
			)
			((not (client cel:))
				(client cycleSpeed: 6)
				(return (= cycleDir 1))
			)
			(else
				(= cycleCnt (GetTime))
				(return (+ (client cel:) cycleDir))
			)
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

	(method (show &tmp temp0 temp1)
		(= temp1 (GetPort))
		(SetPort 0)
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
			(= underBits (Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 3))
		)
		(Graph grFILL_BOX nsTop nsLeft nsBottom nsRight 2 -1 15)
		(= temp0 (PicNotValid))
		(PicNotValid 1)
		(DrawCel view loop cel nsLeft nsTop -1)
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
				0
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
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(PicNotValid temp0)
		(SetPort temp1)
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

	(method (startText param1 param2 &tmp temp0 temp1 [temp2 500])
		(= temp1 (GetPort))
		(SetPort 0)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(Format @temp2 param1 param2)
		(= ticks 30000)
		(if mouth
			(mouth setCycle: RTRandCycle ticks)
		)
		(if eyes
			(eyes setCycle: eyeOsc)
		)
		(proc10_24 gUserFont @temp2)
		(if (> global228 16)
			(Print @temp2 #at x y #width 240 #dispose)
		else
			(Print @temp2 #at x y #dispose)
		)
		(SetPort temp1)
	)

	(method (startAudio theKeys &tmp temp0)
		(= temp0 theKeys)
		(DoAudio audWPLAY temp0)
		(if mouth
			(mouth setCycle: MouthSync temp0)
		)
		(= ticks (DoAudio audPLAY temp0))
	)

	(method (cycle obj &tmp theCel str)
		(= str (GetPort))
		(SetPort 0)
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
		(SetPort str)
	)

	(method (doit &tmp temp0)
		(= temp0 (GetPort))
		(SetPort 0)
		(if eyes
			(self cycle: eyes)
		)
		(if mouth
			(self cycle: mouth)
		)
		(SetPort temp0)
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

	(method (hide &tmp temp0)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grRESTORE_BOX underBits)
		(= underBits 0)
		(Graph grREDRAW_BOX nsTop nsLeft nsBottom nsRight)
		(SetPort temp0)
	)

	(method (dispose dWD &tmp temp0 temp1)
		(if (== global149 self)
			(= global149 (= global148 0))
		)
		(= temp1 (GetPort))
		(SetPort 0)
		(if (and (IsObject gFastCast) (gFastCast contains: self))
			(gFastCast delete: self)
			(if (gFastCast isEmpty:)
				(gFastCast dispose:)
				(= gFastCast 0)
			)
		)
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
			(= temp0 caller)
			(= caller 0)
			(temp0 cue:)
		)
		(DisposeClone self)
		(SetPort temp1)
	)
)

