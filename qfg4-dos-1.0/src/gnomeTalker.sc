;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 67)
(include sci.sh)
(use GloryTalker)
(use Motion)
(use Actor)
(use System)

(public
	gnomeTalker 0
)

(local
	local0
)

(instance gnomeTalker of GloryTalker
	(properties
		x 5
		y 5
		talkWidth 135
		view 246
		textX 150
		textY 5
	)

	(method (init)
		(super init: gnomeMouth 0 gnomeEyes gnomeFrame &rest)
		(sceptre init:)
		(gnomeBrow init: cycleSpeed: 12 setScript: sDoGnome)
	)

	(method (hide)
		(sceptre hide:)
		(gnomeBrow hide: setScript: 0)
		(super hide:)
	)

	(method (showAgain)
		(sceptre show:)
		(gnomeBrow show: setScript: sDoGnome)
		(super showAgain:)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(gnomeBrow dispose:)
			(sceptre dispose:)
		)
		(super dispose: param1)
	)
)

(instance gnomeFrame of View
	(properties
		view 246
	)
)

(instance gnomeMouth of Prop
	(properties
		x 79
		y 45
		view 246
		loop 1
	)
)

(instance gnomeEyes of Prop
	(properties
		x 94
		y 41
		view 246
		loop 2
	)
)

(instance gnomeBrow of Prop
	(properties
		x 92
		y 30
		priority 255
		fixPriority 1
		view 246
		loop 3
	)
)

(instance sceptre of Prop
	(properties
		x 2
		y 37
		priority 255
		fixPriority 1
		view 246
		loop 4
		cycleSpeed 9
	)
)

(instance sDoGnome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 6))
			)
			(1
				(if register
					(gnomeBrow setLoop: 3 1 setCel: 0 setCycle: End)
					(sceptre setCycle: End)
					(= register 0)
				else
					(gnomeBrow setLoop: 3 1 setCel: 0 setCycle: Beg)
					(sceptre setCycle: Beg)
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

