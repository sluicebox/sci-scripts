;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 69)
(include sci.sh)
(use Main)
(use GloryTalker)
(use Motion)
(use Actor)
(use System)

(public
	craniumTalker 0
)

(instance craniumTalker of GloryTalker
	(properties
		talkWidth 150
		textX 140
		textY 5
	)

	(method (init)
		(super init: craniumMouth 0 craniumEyes craniumFrame &rest)
		(craniumThumbs init:)
		(craniumBrow init: setScript: sDoBrow)
	)

	(method (hide)
		(craniumThumbs hide:)
		(craniumBrow hide: setScript: 0)
		(super hide:)
	)

	(method (showAgain)
		(craniumThumbs show:)
		(craniumBrow show: setScript: sDoBrow)
		(super showAgain:)
	)

	(method (dispose param1)
		(if
			(and
				(or (not argc) param1)
				(or
					(not (IsFlag 147))
					(and gTeller (!= (gTeller talker:) self))
				)
			)
			(craniumThumbs dispose:)
			(craniumBrow dispose:)
		)
		(super dispose: param1)
	)
)

(instance craniumFrame of View
	(properties
		view 376
	)
)

(instance craniumMouth of Prop
	(properties
		x 46
		y 63
		view 376
		loop 1
	)
)

(instance craniumEyes of Prop
	(properties
		x 55
		y 49
		view 376
		loop 2
	)
)

(instance craniumBrow of Prop
	(properties
		x 49
		y 37
		view 376
		loop 3
		cel 1
	)
)

(instance craniumThumbs of Prop
	(properties
		x 47
		y 126
		view 376
		loop 4
		cel 1
	)
)

(instance sDoBrow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 4))
			)
			(1
				(if register
					(craniumThumbs setCycle: End)
					(craniumBrow setCycle: End)
					(= register 0)
				else
					(craniumThumbs setCycle: Beg)
					(craniumBrow setCycle: Beg)
					(= register 1)
				)
				(= seconds 4)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

