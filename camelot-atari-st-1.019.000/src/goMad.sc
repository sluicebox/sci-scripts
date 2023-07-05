;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 132)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Motion)
(use System)

(public
	goMad 0
	monkActions 1
)

(local
	local0
)

(instance madMonkWin of SysWindow
	(properties
		color 15
		back 6
		title { Mad Monk }
		brLeft 100
		brBottom 320
		brRight 300
	)
)

(instance goMad of Script
	(properties)

	(method (doit)
		(if (gCurRoom goingOut:)
			(gTObj actor: 0 talkCue: 0 endTalk:)
			(client setScript: 0)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 62)
				(gEgo setMotion: 0)
				(gRmMusic number: 22 loop: 1 play:)
				(gMadMonk view: 337 loop: 2 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(if (>= global135 1)
					(self cue:)
				else
					(gTObj
						actor: gMadMonk
						tWindow: madMonkWin
						tLoop: 3
						talkCue: self
					)
					(switch global207
						(0
							(Talk 132 0) ; "Thief! Robber! You come seeking treasure, but you will find only death!"
						)
						(1
							(Talk 132 1) ; "Thief! Dog of a bandit! I should have known at once from your evil face!"
						)
						(2
							(Talk 132 2) ; "So! You have revealed yourself, enemy, as I knew you would!"
						)
					)
					(= global135 1)
				)
			)
			(2
				(if (>= global135 2)
					(self cue:)
				else
					(gTObj
						actor: gMadMonk
						tWindow: madMonkWin
						tLoop: 3
						talkCue: self
					)
					(switch global207
						(0
							(Talk 132 3) ; "The power is mine! Mine! I will never share it!"
						)
						(1
							(Talk 132 4) ; "But you will never rob me, you devil!"
						)
						(2
							(Talk 132 5) ; "Thief! Robber! You will never leave here alive!"
						)
					)
					(= global135 2)
				)
			)
			(3
				(gMadMonk setLoop: 2 setCel: 0)
				(ClearFlag 62)
				(SetFlag 48)
				(= global201 0)
				(self dispose:)
			)
		)
	)
)

(instance monkActions of Script
	(properties)

	(method (doit)
		(cond
			((or (IsFlag 62) (IsFlag 48)) 0)
			(
				(and
					(or (== state 0) (== state 1))
					(< (gEgo distanceTo: gMadMonk) 120)
				)
				(self changeState: 2)
			)
			((and (== state 4) (> (gEgo distanceTo: gMadMonk) 180))
				(self changeState: 1)
			)
			((and (> state 2) global124)
				(= global207 2)
				(self setScript: goMad self)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global201 gCurRoomNum)
				(gMadMonk setLoop: 0 cel: 0)
				(if (or (IsFlag 62) global124)
					(= state 4)
					(gMadMonk setScript: goMad self)
				)
			)
			(1
				(gMadMonk setLoop: 0 cel: 2 setCycle: Beg)
			)
			(2
				(gMadMonk cycleSpeed: 1 setCycle: End self)
			)
			(3
				(= cycles 4)
			)
			(4
				(gTObj actor: gMadMonk tLoop: 7)
				(if
					(and
						(not (IsFlag 57))
						(not (IsFlag 48))
						(not (IsFlag 62))
					)
					(SetFlag 57)
					(if (not (gCurRoom comingIn:))
						(gEgo setMotion: 0)
					)
					(gTObj talkCue: 0)
					(if (not (IsFlag 63))
						(SetFlag 63)
						(Talk 132 6) ; "Greetings, stranger. Welcome to Glastonbury Tor."
					)
				)
			)
			(5
				(gCurRoom notify:)
				(self dispose:)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((or (event claimed:) (IsFlag 48))
				(return)
			)
			((Said 'draw/blade')
				(if
					(and
						(not (IsFlag 48))
						(not (IsFlag 62))
						(< (gEgo distanceTo: gMadMonk) 120)
					)
					(= global207 2)
					(self setScript: goMad self)
				else
					(event claimed: 0)
				)
			)
			((IsFlag 62)
				(Print 132 7) ; "Arthur. The monk IS mad!"
				(event claimed: 1)
			)
		)
		(cond
			((!= state 4)
				(cond
					(
						(or
							(Said 'greet,give,fuck')
							(Said 'talk,ask,tell[/doug,man]')
						)
						(Print 132 8) ; "He does not answer yet. Try getting a bit closer."
					)
					((Said 'ask,talk,are,tell')
						(event claimed: 0)
					)
				)
			)
			((Said 'greet')
				(Talk 132 9) ; "I have made you welcome, though I wonder what your purpose may be, you with armour, shield and sword."
			)
			((Said '/me/arthur,king')
				(Talk 132 10) ; "Well, la-dee-da. And I am the Emperor of Rome."
			)
			((Said 'give/rose')
				(if (gEgo has: 4) ; rose | apple | green_apple
					(Talk 132 11) ; "That rose smells of woman's magick. I will not touch it."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'give/sleeve')
				(if (gEgo has: 5) ; sleeve | elixir
					(Talk 132 12) ; "I know that sleeve well. It tells me that you are a great warrior, but less wise than you could be."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((or (Said 'talk[/doug,man][/!*]') (Said 'ask//doug,you,yourself'))
				(if local0
					(Talk 132 13) ; "Men in armour make me nervous. Go away."
				else
					(= local0 1)
					(Talk 132 14) ; "As you can see, I am but an old, poor, helpless monk seeking enlightenment through solitude. I am amazed you have passed the riddle stones, for your own face betrays no great intelligence."
				)
			)
			((or (Said 'talk,ask[/doug,man]>') (Said 'are<where>'))
				(cond
					(
						(or
							(Said '/arimathea,grail,heart')
							(Said '//arimathea,grail,heart')
						)
						(= global207 0)
						(self setScript: goMad self)
					)
					((or (Said '/key,spring') (Said '//key,spring'))
						(= global207 1)
						(self setScript: goMad self)
					)
					((or (Said '/riddle,slab,poet') (Said '//riddle,slab,poet'))
						(Talk 132 15) ; "They were once five poets, but the witch turned them to stone. Had you heard their poetry, you would understand why."
					)
					((or (Said '/sleeve') (Said '//sleeve'))
						(Talk 132 16) ; "I will only say that there is someone who wants it a great deal more than I."
					)
					((or (Said '/altar,druid') (Said '//altar,druid'))
						(Talk 132 17) ; "The altar is ancient and has been here since the Druids worshipped upon this hill."
					)
					(
						(or
							(Said '/spirit,ghost,(ones[<old])')
							(Said '//spirit,ghost,(ones[<old])')
						)
						(Talk 132 18) ; "They tell wondrous secrets, but only to me."
					)
					((or (Said '/hidden') (Said '//hidden'))
						(Talk 132 19) ; "I will never reveal my secrets!"
					)
					(
						(or
							(Said '/incantation,entrapment')
							(Said '//incantation,entrapment')
						)
						(Talk 132 20) ; "I cannot fathom what you mean, pilgrim."
					)
					(
						(or
							(Said '/glastenbury,ruin,glastenbury')
							(Said '//glastenbury,ruin,glastenbury')
						)
						(Talk 132 21) ; "It is a ruined, desolate, lonely place. You cannot be enjoying it, so go away."
					)
					(
						(or
							(Said '/belief,command,chapel,god')
							(Said '//belief,command,chapel,god')
						)
						(Talk 132 22 132 23 132 24) ; "I believe that I shall live forever."
					)
					((or (Said '/chant,music') (Said '//chant,music'))
						(SetFlag 321)
						(Talk 132 25) ; "Do you hear the chanting? Aye, day and night they chant, the ghosts of the Old Ones. I am never free of it."
					)
					(
						(or
							(Said '/solitude,enlightenment,loneliness')
							(Said '//solitude,enlightenment,loneliness')
						)
						(Talk 132 26) ; "When I am left alone, I can seek enlightenment. If you wish to help me attain that exalted state, you will go away."
					)
					(else
						(Talk 132 27) ; "I did not become a monk just so I could stand around answering your questions all day."
						(event claimed: 1)
					)
				)
			)
			((Said 'listen')
				(SetFlag 321)
				(Talk 132 25) ; "Do you hear the chanting? Aye, day and night they chant, the ghosts of the Old Ones. I am never free of it."
			)
			((Said 'give/lodestone')
				(if (gEgo has: 2) ; lodestone
					(Talk 132 28) ; "I have no use for such a trinket."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((or (Said 'fuck') (Said 'eat/shit,me'))
				(Talk 132 29) ; "I should have expected no less from an armed barbarian."
			)
		)
	)
)

