;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 324)
(include sci.sh)
(use Main)
(use Teller)
(use System)

(public
	heroTeller 0
	domovoiTeller 1
)

(instance heroTeller of Teller
	(properties)

	(method (init param1 param2 param3)
		(super
			init:
				param2
				param3
				17
				128
				(switch param1
					(1 6)
					(2 7)
					(3 4)
					(4 5)
					(5 24)
					(6 11)
					(7 12)
					(8 15)
					(9 8)
					(10
						(if (OneOf gTime 4 5) 10 else 9)
					)
					(11
						(if (OneOf gTime 4 5) 16 else 15)
					)
					(12
						(if (OneOf gTime 4 5) 14 else 13)
					)
					(13 2)
					(15 3)
					(16 1)
				)
		)
	)
)

(instance domovoiTeller of Teller
	(properties
		title 1
	)

	(method (init param1 param2 param3)
		(super
			init:
				param2
				param3
				17
				148
				(switch param1
					(3 4)
					(13 2)
					(15 3)
				)
		)
		(= talker (ScriptID 72 0)) ; domovoiTalker
	)

	(method (respond)
		(super respond: &rest)
		(if (or (not iconValue) (== iconValue -999))
			(cond
				((and (>= gTime 6) (not (IsFlag 128)) (not (IsFlag 136)))
					(SetFlag 128)
				)
				(
					(and
						(>= gTime 6)
						(IsFlag 128)
						(not (IsFlag 135))
						(>= gDay (+ gPrevDomoTalkDayNumber 1))
						(not (IsFlag 138))
					)
					(SetFlag 135)
				)
				(
					(and
						(>= gTime 6)
						(IsFlag 128)
						(IsFlag 138)
						(not (IsFlag 163))
					)
					(SetFlag 139)
				)
			)
			(= gPrevDomoTalkDayNumber gDay)
		)
		(return 1)
	)
)

