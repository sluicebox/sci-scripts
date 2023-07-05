;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Talker)

(class PriorityTalker of Talker
	(properties
		priority 15
		priBits 0
	)

	(method (hide)
		(Graph grRESTORE_BOX underBits)
		(= underBits 0)
		(Graph grRESTORE_BOX priBits)
		(= priBits 0)
		(Graph grREDRAW_BOX nsTop nsLeft nsBottom nsRight)
		(if gTheIconBar
			(gTheIconBar enable:)
		)
	)

	(method (dispose param1)
		(if (and mouth underBits)
			(mouth cel: 0)
			(DrawCel
				(mouth view:)
				(mouth loop:)
				0
				(+ (mouth nsLeft:) nsLeft)
				(+ (mouth nsTop:) nsTop)
				priority
			)
		)
		(if (and mouth (mouth cycler:))
			(if ((mouth cycler:) respondsTo: #cue)
				((mouth cycler:) cue:)
			)
			(mouth setCycle: 0)
		)
		(if (or (not argc) param1)
			(if (and eyes underBits)
				(eyes setCycle: 0 cel: 0)
				(DrawCel
					(eyes view:)
					(eyes loop:)
					0
					(+ (eyes nsLeft:) nsLeft)
					(+ (eyes nsTop:) nsTop)
					priority
				)
			)
			(self hide:)
		)
		(super dispose: param1)
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
					priority
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

	(method (show &tmp temp0)
		(if (not underBits)
			(= underBits (Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1))
		)
		(if (not priBits)
			(= priBits (Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 2))
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
				priority
			)
		)
		(if eyes
			(DrawCel
				(eyes view:)
				(eyes loop:)
				(eyes cel:)
				(+ (eyes nsLeft:) nsLeft)
				(+ (eyes nsTop:) nsTop)
				priority
			)
		)
		(if mouth
			(DrawCel
				(mouth view:)
				(mouth loop:)
				(mouth cel:)
				(+ (mouth nsLeft:) nsLeft)
				(+ (mouth nsTop:) nsTop)
				priority
			)
		)
		(DrawCel view loop cel nsLeft nsTop priority)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(PicNotValid temp0)
	)
)

