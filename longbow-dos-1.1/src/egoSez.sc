;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 804)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use Inventory)
(use User)
(use System)

(public
	egoSez 0
)

(instance egoSez of Code
	(properties)

	(method (doit param1 param2)
		(switch param1
			(2
				(switch gDisguiseNum
					(5 ; abbey monk
						(Say 1804 1) ; "You'd think someone would see right through my disguise, but I guess it's the robe that makes the man."
					)
					(6 ; fens monk
						(Say 1804 2) ; "I pass quite well as a Fens Monk."
					)
					(4 ; yeoman
						(Say 1804 3) ; "I well like this yeoman disguise, for it lets me keep my bow in hand."
					)
					(1 ; beggar
						(Say 1804 6) ; "What a piteous beggar I make."
					)
					(2 ; jewler (no rouge)
						(Say 1804 4) ; "I look the part of a fairly prosperous merchant."
					)
					(else
						(Say 1804 5) ; "Aye, here I am."
					)
				)
			)
			(5
				(Say 1804 7) ; "He who talks too much, thinks too little."
			)
			(3
				(if (IsFlag 34)
					(if
						(or
							(OneOf
								gCurRoomNum
								360
								390
								400
								530
								550
								280
								290
								300
								310
								320
							)
							(and (== gCurRoomNum 350) (OneOf gDay 7 9))
						)
						(Say 1804 31) ; "This is not the time to display the Hand Code."
					else
						((ScriptID 213) doit:) ; handCode
					)
				else
					(switch gDisguiseNum
						(1 ; beggar
							(Say 1804 8) ; "These rags may not be much, but they're all I have."
						)
						(4 ; yeoman
							(Say 1804 9) ; "I can hardly run around without clothes."
						)
						(2 ; jewler (no rouge)
							(Say 1804 10) ; "These are all I have on at the moment."
						)
						(3 ; jewler (rouge)
							(Say 1804 10) ; "These are all I have on at the moment."
						)
						(5 ; abbey monk
							(Say 1804 11) ; "Take the robe off here? And me with naught a stitch of clothing underneath? I think not."
						)
						(6 ; fens monk
							(Say 1804 11) ; "Take the robe off here? And me with naught a stitch of clothing underneath? I think not."
						)
						(else
							(Say 1804 12) ; "I feel much the same as I did yesterday."
						)
					)
				)
			)
			(10
				(Say 1804 13) ; "My aim seems a bit off."
			)
			(4
				(switch param2
					(0
						(Say 1804 14) ; "I've no need to give money to myself."
					)
					(1
						(gEgo setScript: (ScriptID 5 0)) ; blowArbitrator
					)
					(5
						(Say 1804 15) ; "I prefer the sound of my horn."
					)
					(18
						(switch global115
							(0
								(= global115 1)
								(Say 1804 16) ; "The Ring that Commands Water slips easily onto my finger."
								((Inv at: 18) cel: 9 loop: 2) ; waterRing
							)
							(1
								(= global115 0)
								(Say 1804 17) ; "I'll remove the Ring that Commands Water and keep it hidden from sight for now."
								((Inv at: 18) cel: 2 loop: 2) ; waterRing
							)
							(2
								(Say 1804 18) ; "Some power keeps me from donning both rings at once. As Fulk warned me, their natures are in conflict and refuse to be worn at the same time by one man."
							)
						)
					)
					(10
						(switch global115
							(0
								(= global115 2)
								((Inv at: 10) cel: 8 loop: 2) ; fireRing
								(SetFlag 168)
								(Say 1804 19) ; "I feel the power of the Ring that Commands Fire upon my hand."
							)
							(2
								(= global115 0)
								(ClearFlag 168)
								(Say 1804 20) ; "I'll remove the Ring that Commands Fire and keep it out of sight until I need it."
								((Inv at: 10) cel: 11 loop: 0) ; fireRing
							)
							(1
								(Say 1804 18) ; "Some power keeps me from donning both rings at once. As Fulk warned me, their natures are in conflict and refuse to be worn at the same time by one man."
							)
						)
					)
					(8
						(if (OneOf gCurRoomNum 530 390 400)
							(Say 1804 32) ; "This isn't a safe place to use the jeweler's rouge on myself."
						else
							(if (== gDisguiseNum 3) ; jewler (rouge)
								(Say 1804 21) ; "I'll add a bit more rouge to keep up my disguise."
							else
								(= gDisguiseNum 3) ; jewler (rouge)
								(NormalEgo)
								(Say 1804 22) ; "There, a bit of rouge rubbed into my beard and onto my eyebrows will complete my disguise."
							)
							(if (== (++ global153) 4)
								(Say 1804 23) ; "That's the last of the jeweler's rouge. No need to hold the empty pot."
								(gEgo put: 8) ; rouge
							)
							(if (== global153 1)
								(SetScore 25)
							)
						)
					)
					(3
						(Say 1804 24) ; "It won't fit me."
					)
					(15
						(Say 1804 25) ; "I've already combed my hair today."
					)
					(11
						(if (IsFlag 31)
							(Say 1804 26) ; "I don't need ale at this moment."
						else
							(Say 1804 27) ; "I can't drink from it. It's empty."
						)
					)
					(12
						(gGame setScript: (ScriptID 853 1)) ; cursorPause
					)
					(13
						(Say 1804 28) ; "I can only wear one at a time."
					)
					(4
						(Say 1804 29) ; "I'd look rather silly netting myself."
					)
					(7
						(Say 1804 30) ; "This jewelry doesn't suit me. I'm not that sort of fellow."
					)
					(2
						(Say 1804 0) ; "I already have it."
					)
					(9
						(Say 1804 0) ; "I already have it."
					)
					(6
						(Say 1804 0) ; "I already have it."
					)
					(17
						(Say 1804 0) ; "I already have it."
					)
					(16
						(Say 1804 0) ; "I already have it."
					)
					(14
						(Say 1804 0) ; "I already have it."
					)
					(else
						(Ego doVerb: param1 &rest)
					)
				)
			)
			(else
				(Ego doVerb: param1 &rest)
			)
		)
		(DisposeScript 804)
	)
)

