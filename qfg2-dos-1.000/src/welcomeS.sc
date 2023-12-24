;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 163)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Talker)
(use Motion)
(use System)

(public
	welcomeS 0
	enterS 1
	enterAward 2
	enterEOF 3
	enterHelpNeeded 4
	enterHelpDone 5
	enterCongrats 6
)

(local
	[str1 50]
	[str2 50]
)

(procedure (RandomEnterMsg)
	(switch (Random 0 4)
		(0
			(Say (ScriptID 160 1) welcomeS 163 0) ; "So, Hero of Spielburg, you think you want to go practice some? I could use workout.", uhura
		)
		(1
			(Say (ScriptID 160 1) welcomeS 163 1) ; "My spear arm is getting tired of just holding Simba. Good thing for you, too, if we practice today.", uhura
		)
		(2
			(Say (ScriptID 160 1) welcomeS 163 2) ; "Today is good day for fighting practice. Every day is good day for practice.", uhura
		)
		(3
			(Say (ScriptID 160 1) welcomeS 163 3) ; "Looks like you need to get some more practice today. You be getting plenty good.", uhura
		)
		(4
			(Say (ScriptID 160 1) welcomeS 163 4) ; "It is good for Simba to watch us practice. He will need to learn soon enough.", uhura
		)
	)
)

(instance welcomeS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo (ScriptID 160 3)) ; uhuraBody
				(cond
					((IsFlag 177) ; fUhuraEnterMsg
						(RandomEnterMsg)
					)
					((== gDay 1)
						(Say (ScriptID 160 1) self 163 5 163 6) ; "Ah, the hero of the Kattas! You have some reputation already, to hear merchants talk. If you are as good as they say you are, then you must be plenty good.", uhura
					)
					((== gDay 2)
						(Say (ScriptID 160 1) self 163 7) ; "Ah, this be the new Hero, Rakeesh.", uhura
					)
					((and (== gElementalState 1) (<= 5 gDay 6))
						(Say (ScriptID 160 1) self 163 8) ; "The Fire Elemental be plenty hard to fight. Maybe the city burn down unless someone get it stopped.", uhura
					)
					((<= 9 gDay 10)
						(if (< gElementalState 4)
							(Say (ScriptID 160 1) self 163 9) ; "My spear not do much to Air Elemental near palace. Maybe you can do something to stop it.", uhura
						else
							(Say (ScriptID 160 1) self 163 10) ; "Rakeesh, he say that you stop the Air Elemental. Now you are even bigger Hero in Shapeir.", uhura
						)
					)
					((== gDay 11)
						(Say (ScriptID 160 1) self 163 11) ; "Rakeesh not be here today, Hero. He be speaking with Sultan. They talk about more Elementals coming down soon.", uhura
					)
					((== gDay 13)
						(if (== gElementalState 6)
							(Say (ScriptID 160 1) self 163 12) ; "That Earth Elemental be plenty tough, but you sure be tougher.", uhura
						else
							(Say (ScriptID 160 1) self 163 13) ; "If you not stop that Earth Elemental today, I think maybe it get too tough to stop.", uhura
						)
					)
					(else
						(RandomEnterMsg)
					)
				)
			)
			(1
				(if (and (== gDay 2) (not (IsFlag 177))) ; fUhuraEnterMsg
					(Face gEgo (ScriptID 160 4)) ; rakeeshBody
					(Say (ScriptID 160 2) self 163 14) ; "You are most welcome in Shapeir. The sultan has been seeking a Hero since the forces of Dark Magic overwhelmed Raseir.", rakeesh
				else
					(self dispose:)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance enterS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo (ScriptID 160 3)) ; uhuraBody
				(Say (ScriptID 160 1) self 163 15) ; "It's good sometimes to have Simba with Rakeesh. Hard to feel like strong warrior when feeding baby. Maybe you and I do some practice with weapons today.", uhura
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance enterAward of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo (ScriptID 160 2)) ; rakeesh
				(Say (ScriptID 160 2) self 163 16) ; "You have saved the city with your courage and your resourcefulness. The land of Shapeir is indebted to you. By order of the Sultan, Harun Al-Rashid, I have been asked to give you this reward for your actions.", rakeesh
			)
			(1
				(gEgo setMotion: MoveTo 200 170 self)
			)
			(2
				(Face gEgo (ScriptID 160 2)) ; rakeesh
				(= cycles 14)
			)
			(3
				(gEgo setMotion: MoveTo 220 180 self)
			)
			(4
				(HighPrint 163 17) ; "Rakeesh gives you the 50 dinar reward."
				(gEgo get: 2 50) ; Dinar
				(SolvePuzzle 610 3)
				(SkillUsed 14 50) ; honor
				(self cue:)
			)
			(5
				(Face gEgo (ScriptID 160 2)) ; rakeesh
				(Say (ScriptID 160 2) self 163 18) ; "We are all truly fortunate that you came to this land.", rakeesh
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance enterEOF of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: welcomeS self)
			)
			(1
				(Face gEgo (ScriptID 160 3)) ; uhuraBody
				(switch gDay
					(13
						(Say (ScriptID 160 1) self 163 19) ; "This note was left here for you.", uhura
					)
					(14
						(Say (ScriptID 160 1) self 163 20) ; "This be stuck to the door with knife. I think maybe you should find better place to pass notes.", uhura
					)
					(15
						(Say (ScriptID 160 1) self 163 21) ; "This time the note be stuck to the door with an old sword. Tell your friend I will show him where to stick it the next time.", uhura
					)
				)
			)
			(2
				(gEgo setMotion: MoveTo 220 165 self)
			)
			(3
				(Face gEgo (ScriptID 160 3)) ; uhuraBody
				(= cycles 14)
			)
			(4
				(gEgo setMotion: MoveTo 230 180 self)
			)
			(5
				(switch gDay
					(13
						(Format @str1 163 22) ; "."
					)
					(14
						(Format @str1 163 23) ; "and small torn spot."
					)
					(15
						(Format @str1 163 24) ; "and large torn spot."
					)
				)
				(Format @str2 163 25 @str1) ; "You read the crumpled paper with the nearly illegible scrawl%s"
				(HighPrint @str2)
				(self cue:)
			)
			(6
				(switch gDay
					(13
						(HighPrint 163 26) ; "If you know what's good for you, you will obey orders. We will leave them here. If you don't follow them, you'll be sorry. We are watching you."
					)
					(14
						(HighPrint 163 27) ; "Tomorrow night is your last night. You'll get your final orders then. Be seeing you."
					)
					(15
						(HighPrint 163 28) ; "At nightfall tonight, go to the door at the end of "Darb of Rafir". Obey, or you'll regret it."
					)
				)
				(self cue:)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance enterHelpNeeded of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(or
						(== gDay 2)
						(and (== gElementalState 5) (== gOrigHeroType 0))
					)
					(Face gEgo (ScriptID 160 2)) ; rakeesh
					(Say (ScriptID 160 2) self 163 29) ; "It seems that Shapeir again needs your skills. No one else in this city can handle such a magical being.", rakeesh
				else
					(self changeState: 3)
				)
			)
			(1
				(Face gEgo (ScriptID 160 3)) ; uhuraBody
				(Say (ScriptID 160 1) self 163 30 163 31) ; "If your leg had not failed you this morning, Rakeesh, the elemental would be gone.", uhura
			)
			(2
				(Face gEgo (ScriptID 160 2)) ; rakeesh
				(Say (ScriptID 160 2) self 163 32 163 33) ; "I'm afraid I have not the power to deal with the Elemental now. It will require your skills and magic to overcome the thing, oh Defeater of Elementals.", rakeesh
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance enterHelpDone of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: welcomeS self)
			)
			(1
				(Face gEgo (ScriptID 160 3)) ; uhuraBody
				(Say (ScriptID 160 1) self 163 34) ; "I hear you be plenty good and beat the elemental. You be some Hero, for sure. It was no little honor, being able to use Rakeesh's sword. I will be giving it back, if you will be giving it to me.", uhura
			)
			(2
				(StartTimer (ScriptID 160 5) 15) ; responseTimer
				(self dispose:)
			)
		)
	)
)

(instance enterCongrats of HandsOffScript
	(properties)

	(method (changeState newState &tmp [str 100])
		(switch (= state newState)
			(0
				(Face gEgo (ScriptID 160 2)) ; rakeesh
				(Say (ScriptID 160 2) self 163 35) ; "So, Hero, not being content with having merely saved the city, I see that you are about to attempt to save the land of Shapeir as well.", rakeesh
			)
			(1
				(cond
					((== gHeroType 3) ; Paladin
						(Say (ScriptID 160 2) self 163 36) ; "The light shines brightly within you. You have so far managed to walk the narrow line between Honor and Necessity. May your deeds continue to shine, and not be dulled by the darkness you will soon encounter.", rakeesh
					)
					((== gHeroType 0) ; Fighter
						(Say (ScriptID 160 2) self 163 37) ; "You have proven yourself both brave and resourceful by your actions.", rakeesh
					)
					((== gHeroType 2) ; Thief
						(Say (ScriptID 160 2) self 163 38) ; "When first we met, I could feel there was dark within you. Now I can see that the light is stronger, if you will only let it be so. It is a narrow path between darkness and light, and you will always walk that tightrope in your soul.", rakeesh
					)
					((== gHeroType 1) ; Magic User
						(Say (ScriptID 160 2) self 163 39) ; "I have seldom met one with such Power and so much wisdom and courage as you have shown. Few users of Magic dare face what you have faced to protect this city.", rakeesh
					)
				)
			)
			(2
				(Say (ScriptID 160 2) self 163 40 163 41) ; "The journey you are about to make is to a very dark and dangerous place. The foe you will face is very powerful in the ways of magic.", rakeesh
			)
			(3
				(Say (ScriptID 160 2) self (Format @str 163 42 @gUserName)) ; rakeesh, "All of us in this city will be hoping for your safety, for all know of the seriousness of your mission. May fortune smile upon you, %s."
			)
			(4
				(Face gEgo (ScriptID 160 3)) ; uhuraBody
				(Say (ScriptID 160 1) self 163 43) ; "Keep your weapon handy, Hero, and don't let your enemies get you. You and I maybe practice some more when you get back.", uhura
			)
			(5
				(if (== gOrigHeroType 0)
					(Face gEgo (ScriptID 160 2)) ; rakeesh
					(Say (ScriptID 160 2) self 163 44) ; "If you will permit it, my friend, perhaps you and I could practice with weapons before you go. I happen to know some skills with weapons that might help you on your mission.", rakeesh
				else
					(self cue:)
				)
			)
			(6
				(self dispose:)
			)
		)
	)
)

