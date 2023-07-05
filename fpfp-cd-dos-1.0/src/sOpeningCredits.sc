;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(public
	sOpeningCredits 0
)

(local
	local0
	local1
	local2
	[local3 16] = [790 790 791 792 793 794 795 796 796 796 796 797 797 797 798 799]
	[local19 16] = [1 2 1 1 1 1 1 1 2 3 4 1 2 3 1 1]
	local35
	local36
)

(instance sOpeningCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(= local35 [local3 global132])
				(= local36 [local19 global132])
				(creditTitle
					view: local35
					setCel: 0
					setPri: 15
					setStep: 5 5
					setScale: 10
					setScale:
					init:
					hide:
				)
				(= cycles 1)
			)
			(2
				(for ((= local0 10)) (< local0 81) ((+= local0 12))
					(Animate (gCast elements:) 1)
					(creditTitle scaleX: local0 scaleY: local0 show:)
				)
				(= cycles 1)
			)
			(3
				(creditTitle stopUpd:)
				(creditView
					view: local35
					setCel: local36
					setPri: 15
					setStep: 5 5
					setScale: 10
					setScale:
					init:
					hide:
				)
				(= cycles 1)
			)
			(4
				(for ((= local1 10)) (< local1 81) ((+= local1 12))
					(Animate (gCast elements:) 1)
					(creditView scaleX: local1 scaleY: local1 show:)
				)
				(= cycles 1)
			)
			(5
				(++ global132)
				(= ticks 180)
			)
			(6
				(creditTitle startUpd:)
				(for ((= local0 81)) (> local0 1) ((-= local0 12))
					(Animate (gCast elements:) 1)
					(creditTitle scaleX: local0 scaleY: local0 show:)
					(creditView scaleX: local0 scaleY: local0)
				)
				(= cycles 1)
			)
			(7
				(creditView dispose:)
				(creditTitle dispose:)
				(UnLoad 128 local35)
				(if (>= global132 15)
					(ClearFlag 52)
				)
				(self dispose:)
			)
		)
	)
)

(instance creditTitle of Actor
	(properties
		x 160
		y 200
		z 115
		noun 1
		view 790
		priority 14
		signal 20496
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 4 2) ; Look, Do, Talk
			(gMessager say: noun theVerb 0 0 0 32)
		else
			(gMessager say: noun 0 1 0 0 32) ; "The credits aren't in need of anything you've got."
		)
	)
)

(instance creditView of Actor
	(properties
		x 160
		y 200
		z 87
		noun 2
		view 790
		priority 14
		signal 20496
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 1 4 2) ; Look, Do, Talk
			(gMessager say: noun theVerb 0 0 0 32)
		else
			(gMessager say: noun 0 1 0 0 32) ; "That person doesn't want what you're offering. What an ungrateful wretch!"
		)
	)
)

