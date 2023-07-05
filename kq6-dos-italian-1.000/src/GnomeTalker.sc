;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1037)
(include sci.sh)
(use Main)
(use Kq6Talker)
(use n913)
(use Actor)
(use System)

(public
	Gnomes 36
	GSmell 61
	GSound 65
	GTaste 66
	GTouch 67
	GSight 68
)

(class GnomeTalker of Kq6Talker
	(properties
		extra 0
	)

	(method (init param1 param2 param3 param4)
		(if argc
			(= bust param1)
			(if (>= argc 2)
				(= eyes param2)
				(if (>= argc 3)
					(= mouth param3)
					(if (and raving (>= argc 4))
						(= extra param4)
					)
				)
			)
		)
		(if (and (== gMsgType 2) argc (IsObject param1))
			(self x: 59 y: 15)
		)
		(self setSize:)
		(super init:)
	)

	(method (doit)
		(if (and raving extra)
			(DrawCel
				(extra view:)
				(extra loop:)
				(extra cel:)
				(+ (extra nsLeft:) nsLeft)
				(+ (extra nsTop:) nsTop)
				-1
			)
		)
		(super doit:)
	)

	(method (setSize)
		(= nsLeft x)
		(= nsTop y)
		(= nsRight
			(+
				nsLeft
				(Max
					(if view
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
					(and
						(IsObject extra)
						(+
							(extra nsLeft:)
							(CelWide (extra view:) (extra loop:) (extra cel:))
						)
					)
				)
			)
		)
		(= nsBottom
			(+
				nsTop
				(Max
					(if view
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
					(and
						(IsObject extra)
						(+
							(extra nsTop:)
							(CelHigh (extra view:) (extra loop:) (extra cel:))
						)
					)
				)
			)
		)
	)

	(method (show &tmp temp0)
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
		(if (and extra raving)
			(DrawCel
				(extra view:)
				(extra loop:)
				(extra cel:)
				(+ (extra nsLeft:) nsLeft)
				(+ (extra nsTop:) nsTop)
				-1
			)
		)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(PicNotValid temp0)
	)
)

(instance Gnomes of GnomeTalker
	(properties
		x 3
		y 5
		view 8930
		talkWidth 208
		textX 86
		textY 6
		raveName {GNOMES}
	)

	(method (init)
		(super init: tBust 0 tMouth &rest)
	)
)

(instance GSmell of GnomeTalker
	(properties
		x 3
		y 5
		view 8931
		talkWidth 208
		textX 86
		textY 8
		raveName {SMELL}
	)

	(method (init)
		(if (IsFlag 59)
			(super init: tSmellBust 0 tSmellMouth &rest)
		else
			(super init: tSmellBust 0 tSmellMouth tSmellPin &rest)
		)
	)
)

(instance GSound of GnomeTalker
	(properties
		x 3
		y 5
		view 8932
		talkWidth 208
		textX 86
		textY 8
		raveName {SOUND}
	)

	(method (init)
		(if (IsFlag 59)
			(super init: tSoundBust 0 tSoundMouth &rest)
		else
			(super init: tSoundBust 0 tSoundMouth tSoundMuffs &rest)
		)
	)
)

(instance GTaste of GnomeTalker
	(properties
		x 3
		y 5
		view 8933
		talkWidth 208
		textX 86
		textY 8
		raveName {TASTE}
	)

	(method (init)
		(super init: tTasteBust 0 tTasteMouth &rest)
	)
)

(instance GTouch of GnomeTalker
	(properties
		x 3
		y 5
		view 8934
		talkWidth 208
		textX 86
		textY 8
		raveName {TOUCH}
	)

	(method (init)
		(if (IsFlag 59)
			(super init: tTouchBust 0 tTouchMouth &rest)
		else
			(super init: tTouchBust 0 tTouchMouth tTouchGloves &rest)
		)
	)
)

(instance GSight of GnomeTalker
	(properties
		x 3
		y 5
		view 8935
		talkWidth 208
		textX 86
		textY 8
		raveName {SIGHT}
	)

	(method (init)
		(if (IsFlag 59)
			(super init: tSightBust tSightEyes tSightMouth 0 &rest)
		else
			(super init: tSightBust tSightLids tSightMouth 0 &rest)
		)
	)
)

(instance tSmellBust of Prop
	(properties
		view 8931
	)
)

(instance tSmellEyes of Prop ; UNUSED
	(properties
		nsTop 15
		nsLeft 12
		view 8931
		loop 1
	)
)

(instance tSmellMouth of Prop
	(properties
		nsTop 36
		nsLeft 21
		view 8931
		loop 1
	)
)

(instance tSmellPin of Prop
	(properties
		nsTop 15
		nsLeft 26
		view 8931
		loop 3
	)
)

(instance tSoundBust of Prop
	(properties
		view 8932
	)
)

(instance tSoundEyes of Prop ; UNUSED
	(properties
		nsTop 15
		nsLeft 20
		view 8932
		loop 1
	)
)

(instance tSoundMouth of Prop
	(properties
		nsTop 29
		nsLeft 31
		view 8932
		loop 1
	)
)

(instance tSoundMuffs of Prop
	(properties
		nsTop 20
		nsLeft 19
		view 8932
		loop 3
	)
)

(instance tTasteBust of Prop
	(properties
		view 8933
	)
)

(instance tTasteEyes of Prop ; UNUSED
	(properties
		nsTop 8
		nsLeft 20
		view 8933
		loop 1
	)
)

(instance tTasteMouth of Prop
	(properties
		nsTop 20
		nsLeft 9
		view 8933
		loop 1
	)
)

(instance tTouchBust of Prop
	(properties
		view 8934
	)
)

(instance tTouchEyes of Prop ; UNUSED
	(properties
		nsTop 2
		nsLeft 16
		view 8934
		loop 1
	)
)

(instance tTouchMouth of Prop
	(properties
		nsTop 16
		nsLeft 23
		view 8934
		loop 1
	)
)

(instance tTouchGloves of Prop
	(properties
		nsTop 28
		nsLeft 8
		view 8934
		loop 3
	)
)

(instance tSightBust of Prop
	(properties
		view 8935
	)
)

(instance tSightEyes of Prop
	(properties
		nsTop 20
		nsLeft 22
		view 8935
		loop 1
	)
)

(instance tSightLids of Prop
	(properties
		nsTop 19
		nsLeft 21
		view 8935
		loop 3
	)
)

(instance tSightMouth of Prop
	(properties
		nsTop 30
		nsLeft 33
		view 8935
		loop 2
	)
)

(instance tBust of Prop
	(properties
		view 8930
	)
)

(instance tMouth of Prop
	(properties
		nsTop 22
		nsLeft 11
		view 8930
		loop 1
	)
)

