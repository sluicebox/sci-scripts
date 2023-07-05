;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 302)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use n003)
(use HandsOffScript)
(use Talker)
(use LoadMany)
(use Motion)
(use System)

(public
	beggar 0
	beggarSpeech 1
)

(local
	[beggarGenList 33] = [1 2 3 0 0 0 0 0 0 0 0 4 5 0 6 0 0 0 7 0 8 9 10 11 12 13 14 0 15 0 16 0 17]
	[beggarSpecList 10] = [18 '//effendi' 19 '//paladin' 20 '//labor' 21 '//begging,beggar' 0 0]
)

(instance beggar of Talker
	(properties
		x 202
		y 99
		description {a street beggar}
		lookStr {The beggar is bawling for Dinars (but he might settle for Centimes).}
		view 308
		loop 1
		signal 16384
		illegalBits 0
		tLoop 1
		myName '//shihhad,beggar'
		title {Beggar:}
		color 15
		back 6
		msgFile 308
	)

	(method (init)
		(super init:)
		(LoadMany rsTEXT 308)
		(gCurRoom saveIllegal: (| (gCurRoom saveIllegal:) $0400))
	)

	(method (atGen what)
		(return [beggarGenList what])
	)

	(method (atSpec what)
		(return [beggarSpecList what])
	)

	(method (handleEvent event)
		(cond
			((Said 'give/[/beggar,shihhad]>')
				(cond
					((not (< (gEgo distanceTo: beggar) 60))
						(HighPrint 302 0) ; "You're not close enough to the beggar."
						(event claimed: 1)
					)
					((Said '/alm,alm,cent')
						(giveToBeggar doit: 1 0)
					)
					((Said '/dinar,gold')
						(giveToBeggar doit: 100 0)
					)
					((Said '/food')
						(giveToBeggar doit: 0 1)
					)
					((Said '/*')
						(HighPrint 302 1) ; "He doesn't need it."
						(event claimed: 1)
					)
					(else
						(MoreSpecific)
						(event claimed: 1)
					)
				)
			)
			((super handleEvent: event) 0)
		)
		(event claimed:)
	)
)

(instance beggarSpeech of HandsOffScript
	(properties)

	(method (changeState)
		(beggar loop: 0 cel: 0 setCycle: End beggar state: -1)
		(Say beggar self 302 2) ; "Centime for the poor, Effendi? Centime for the poor?"
	)

	(method (cue)
		(beggar loop: 1 cel: 0)
		(self dispose:)
	)
)

(instance giveToBeggar of Script
	(properties)

	(method (doit qty &tmp doBow)
		(= doBow 0)
		(cond
			(qty
				(switch (CheckFunds qty)
					(2
						(= doBow 1)
						(GiveMoney qty)
					)
					(1
						(Say beggar 302 3) ; "Alas, Effendi, money from the land of Spielburg is of no use to such as I. You need to exchange it for the coin of our realm."
					)
					(else
						(HighPrint 302 4) ; "You haven't any to give."
					)
				)
			)
			([gInvNum 3] ; Food
				(gEgo put: 3) ; Food
				(= doBow 1)
			)
			(else
				(HighPrint 302 5) ; "You have no food for even yourself."
			)
		)
		(if doBow
			(beggar loop: 2 cel: 0 setCycle: End beggar cycleSpeed: 5 state: -1)
			(if (IsFlag 619)
				(SolvePuzzle 679 5 3)
			else
				(SolvePuzzle 619 3)
			)
			(cond
				((>= qty 100)
					(SkillUsed 14 (/ qty 4)) ; honor
					(Say beggar self 302 6) ; "What a wonder! Is it a dream? Oh, Effendi, there is no end to your goodness."
				)
				((> qty 0)
					(SkillUsed 14 (/ qty 4)) ; honor
					(Say beggar self 302 7) ; "Thank you, thank you, Effendi. You shame me with your kindness."
				)
				(else
					(SkillUsed 14 10) ; honor
					(Say beggar self 302 8) ; "Forgive me, Effendi. I am not worthy of your kindness."
				)
			)
		)
	)

	(method (cue)
		(beggar loop: 1 cel: 0 cycleSpeed: 0)
	)
)

