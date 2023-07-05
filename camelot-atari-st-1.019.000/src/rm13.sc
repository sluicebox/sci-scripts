;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm13 0
)

(synonyms
	(skeleton person bone man guard skeleton body)
	(blackbird bird)
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(gTObj tWindow: treeWindow actor: 0)
	(Talk &rest)
)

(procedure (localproc_1)
	(gTObj tWindow: ravenWindow cSpeed: 2 actor: raven tLoop: 0)
	(Talk &rest)
)

(instance horseAlone of Act
	(properties)
)

(instance ravenWindow of SysWindow
	(properties
		color 12
		back 0
		title {Crow}
		brLeft 30
		brBottom 70
		brRight 250
	)
)

(instance treeWindow of SysWindow
	(properties
		color 14
		back 6
		title {Old Father Tree}
		brLeft 150
		brBottom 130
		brRight 310
	)
)

(instance rm13 of Rm
	(properties
		picture 13
	)

	(method (init)
		(super init:)
		(self setRegions: 102) ; forestPerilous
		(gTObj tWindow: ravenWindow cSpeed: 2 actor: raven init:)
		(= local1 (not (IsFlag 26)))
		(gEgo init:)
		(switch gPrevRoomNum
			(14
				(gEgo loop: 1 posn: 315 125 setMotion: MoveTo 290 125)
				(if (IsFlag 20)
					(gMuleObj posn: 318 135 loop: 1 setMotion: MoveTo 290 135)
				)
			)
			(else
				(gEgo loop: 1 posn: 195 188 setMotion: MoveTo 185 181)
				(if (IsFlag 20)
					(gMuleObj posn: 135 189 loop: 3 setMotion: MoveTo 135 150)
				)
			)
		)
		(if local1
			(raven init: posn: 113 76)
			(gCurRoom setScript: BirdScript)
		)
		(if (and (not (gEgo has: 5)) (not (IsFlag 25))) ; sleeve | elixir
			(sleeve init: setCycle: slowForward)
		)
		(proc0_13 32)
		(gAddToPics add: knight)
		(gAddToPics doit:)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((> (gEgo x:) 315)
				(gCurRoom newRoom: 14)
			)
			((> (gEgo y:) 190)
				(gCurRoom newRoom: 12)
			)
		)
	)

	(method (dispose)
		(getMushroom dispose:)
		(BirdScript dispose:)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			((and (== (event type:) evMOUSEBUTTON) (& (event modifiers:) emSHIFT))
				(cond
					((MouseClaimed raven event)
						(if (IsFlag 26)
							(Print 13 0) ; "That is one crow we can do without."
						else
							(Print 13 1) ; "Heed the words of the crow, for it is no ordinary bird. It is the voice of the Black Knight."
						)
					)
					((OnButton event 210 55 266 175)
						(Print 13 2) ; "'Tis a Father Tree. Sometimes, if you are worthy enough, such wise and ancient beings will even speak with you."
					)
					((OnButton event 122 109 133 130)
						(if (IsFlag 25)
							(Print 13 3) ; "Clearly, he was once a stout knight. Naught is left but a bit of armour, his bones picked clean by the crow."
						else
							(Print 13 4) ; "Clearly, he was once a stout knight. Naught is left but a bit of armour, his bones picked clean by the crow, and a bit of brightly colored silk."
						)
					)
					((OnButton event 102 77 133 130)
						(Print 13 5) ; "The rock juts from the heart of the forest like a jagged tooth. There is evil power within it."
					)
					((OnButton event 62 138 92 151)
						(Print 13 6) ; "These mushrooms are of the species Amanita Muscaria. They are very dangerous at the best of times, and said to cause madness or death."
					)
					(
						(or
							(OnButton event 159 128 173 134)
							(OnButton event 80 115 95 127)
						)
						(Print 13 7) ; "'Tis a rock."
					)
					(
						(or
							(OnButton event 25 7 294 64)
							(OnButton event 8 20 27 130)
							(OnButton event 31 58 50 107)
							(OnButton event 65 58 83 94)
							(OnButton event 135 7 177 185)
							(OnButton event 179 34 276 74)
						)
						(Print 13 8) ; "'Tis a tree."
					)
					(
						(or
							(OnButton event 282 110 310 157)
							(OnButton event 266 136 282 153)
							(OnButton event 9 152 24 169)
							(OnButton event 24 152 46 182)
							(OnButton event 46 162 56 182)
							(OnButton event 23 65 158 105)
							(OnButton event 172 165 158 105)
							(OnButton event 252 73 310 112)
						)
						(Print 13 9) ; "'Tis a bush."
					)
				)
			)
			((Said 'look[<around][/room,forest]')
				(cond
					((IsFlag 34)
						(Print 13 10) ; "The clearing is as you left it, but now, to your everlasting shame, this poor soul is no longer the only dead knight in the forest."
					)
					((IsFlag 35)
						(if (IsFlag 36)
							(Print 13 11) ; "I fear the lady may well have found her dead knight and it has brought her only grief. Alas, alas, this life is but a vale of tears."
						else
							(Print 13 12) ; "Little has changed, except for signs that your horse passed this way bearing Sir Gawaine back to Camelot."
						)
					)
					(else
						(Print 13 13) ; "You have reached the heart of the forest where its dark power dwells. It seems another unfortunate soul was here before you."
					)
				)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					((or (Said '/blackbird') (Said '//blackbird'))
						(if (IsFlag 26)
							(Print 13 0) ; "That is one crow we can do without."
						else
							(Print 13 1) ; "Heed the words of the crow, for it is no ordinary bird. It is the voice of the Black Knight."
						)
					)
					((Said '<(in,in)/knight,skeleton')
						(if (IsFlag 25)
							(Print 13 14) ; "Only his bare bones remain, rattling in their shell of iron."
						else
							(Print 13 15) ; "There is a piece of brightly colored silk tucked inside the armour."
						)
					)
					((Said '<below/knight,skeleton')
						(Print 13 16) ; "There is nothing to gain by that."
					)
					((Said '//knight<black')
						(Print 13 17) ; "He is the evil power that makes this forest so perilous."
					)
					((or (Said '/knight,skeleton') (Said '//knight,skeleton'))
						(if (IsFlag 25)
							(Print 13 3) ; "Clearly, he was once a stout knight. Naught is left but a bit of armour, his bones picked clean by the crow."
						else
							(Print 13 4) ; "Clearly, he was once a stout knight. Naught is left but a bit of armour, his bones picked clean by the crow, and a bit of brightly colored silk."
						)
					)
					((or (Said '/armor,armor') (Said '//armor,armor'))
						(Print 13 18) ; "Once it was fine metal, now it is rusted and useless."
					)
					(
						(or
							(Said '/silk,sleeve,bolt,sleeve')
							(Said '//silk,sleeve,bolt,sleeve')
						)
						(cond
							((not (IsFlag 25))
								(Print 13 19) ; "The piece of silk was a lady's sleeve, a token to wear into battle. We can only wonder what sad story was his, what favour he sought to win, and the sorrowful fate of the lady that may have awaited him with fading hope."
							)
							((gEgo has: 5) ; sleeve | elixir
								(event claimed: 0)
							)
							(else
								(Print 13 20) ; "You cannot see what is not there."
							)
						)
					)
					((or (Said '/amanita') (Said '//amanita'))
						(Print 13 21) ; "They are of the species Amanita Muscaria, a very dangerous mushroom at the best of times, said to cause madness or death."
						(Print 13 22) ; "But here in the Forest Perilous, they are doubly dangerous. For if you so much as touch these mushrooms, you will be compelled to eat them."
					)
					((or (Said '/blossom') (Said '//blossom'))
						(Print 13 23) ; "There are no flowers nearby--only mushrooms."
					)
					((Said '<below/boulder,slab')
						(Print 13 24) ; "It cannot be moved."
					)
					((or (Said '/slab,boulder') (Said '//slab,boulder'))
						(Print 13 25) ; "It juts from the heart of the forest like a jagged tooth. There is evil power within it."
					)
					((or (Said '/tree') (Said '//tree'))
						(Print 13 26) ; "Most of the trees here are quite ordinary, but this one hoary, leafless tree may well be the eldest of them all."
					)
					(
						(and
							(IsItemAt 5 16) ; sleeve | elixir
							(or (Said '/elayne,girl') (Said '//elayne,girl'))
						)
						(Print 13 27) ; "It will be a grievous moment when Lady Elayne find the remains of her beloved knight."
					)
				)
			)
			((Said 'get/sleeve,sleeve,silk,bolt')
				(cond
					((gEgo has: 5) ; sleeve | elixir
						(Print 13 28) ; "You already have a sleeve."
					)
					((IsFlag 25)
						(Print 13 29) ; "You cannot get what is not there."
					)
					((gEgo inRect: 92 132 155 142)
						(sleeve dispose:)
						(gEgo get: 5) ; sleeve | elixir
						(SetScore 0 0 1)
						(SetFlag 25)
						(Print 13 30 #draw) ; "Odd. Although this lady's sleeve has surely been here as long as the dead knight, it is as new as the day the lady wore it. There is magick involved here."
					)
					(else
						(Print 13 31) ; "Your arms are not quite that long."
					)
				)
			)
			((Said 'talk/blackbird')
				(if (and local1 (not local2))
					(BirdScript changeState: 2)
				else
					(Print 13 32) ; "He said all he needed to say. He will return nevermore."
				)
			)
			((Said 'talk/tree,dad')
				(cond
					((not (gEgo inRect: 120 100 320 200))
						(event claimed: 0)
					)
					((not local3)
						(localproc_0 13 33) ; "Who dares to speak to Old Father Tree? You are but a twinkle in time, mortal. Let me sleep the long and dreamless sleep of deep roots and sun on branch."
						(= local3 1)
						(SetScore 299 1 1)
					)
					(else
						(Print 13 34) ; "Do not disturb him further, Arthur. He is an old and weary tree."
					)
				)
			)
			((Said 'talk/knight,skeleton')
				(Print 13 35) ; "That would not be much of a conversation."
			)
			((Said 'greet')
				(if (and local1 (not local2))
					(BirdScript changeState: 2)
				else
					(Print 13 36) ; "If you are greeting the dead knight, I fear he has long since ceased to care about such things."
				)
			)
			((Said 'get,eat/amanita')
				(cond
					((not (gEgo inRect: 50 135 150 180))
						(Print 13 37) ; "They are dangerous. Leave them be."
					)
					((not local0)
						(Print 13 37) ; "They are dangerous. Leave them be."
						(++ local0)
					)
					(else
						(gEgo setScript: getMushroom)
					)
				)
			)
			((Said 'get,poke,pick/amanita')
				(cond
					((not (gEgo inRect: 50 135 150 180))
						(NotClose) ; "Perhaps you should move closer."
					)
					((not local0)
						(Print 13 38) ; "I warn you most strongly, the merest touch of these mushrooms will compel you to eat them with the most dire results."
						(++ local0)
					)
					(else
						(gEgo setScript: getMushroom)
					)
				)
			)
			((Said 'get/knight,skeleton')
				(Print 13 39) ; "There is no need to desecrate this poor dead knight."
			)
			((Said 'bury/knight,skeleton,skeleton')
				(Print 13 40) ; "Long has this unfortunate knight lain here, but you have not the time now to do him such a service."
			)
			((Said '*/knight')
				(Print 13 41) ; "This unfortunate knight is beyond your ability to help or hinder."
			)
			((Said 'get,strip,remove/armor')
				(Print 13 42) ; "The dead knight's armour is old and rusted and of no use to you."
			)
			((Said 'get/blackbird')
				(if local1
					(Print 13 43) ; "It would be futile to try."
				else
					(Print 13 44) ; "He is gone, as I would hope you noticed."
				)
			)
			((Said 'get,press,move,dislodge,remove/slab,boulder')
				(Print 13 45) ; "This stone would defy you. You are well advised to leave it alone."
			)
			((Said 'annihilate/boulder,slab')
				(Print 13 46) ; "That is beyond your power or mine."
			)
			((Said 'draw/blade')
				(Print 13 47) ; "The knight has been dead far too long to be a threat to you."
				(= global125 2)
			)
			(
				(or
					(Said 'give/rose,sleeve,silk,lodestone')
					(Said 'give/blackbird/rose,sleeve,silk,lodestone')
				)
				(if local1
					(localproc_1 13 48) ; "Rawk! I have no need for mortal toys."
				else
					(Print 13 49) ; "I doubt the dead knight has any interest in it."
				)
			)
			((Said 'help/knight')
				(Print 13 50) ; "He is long past help, Arthur."
			)
			((Said 'kill,cut,attack,hit,hit/blackbird')
				(if local1
					(localproc_1 13 51) ; "Rarawk! Try it if you dare. You will never touch me."
				else
					(Print 13 52) ; "The creature deserves it, but is not here for the attempt."
				)
			)
		)
	)
)

(instance BirdScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (== state 0) (< (gEgo x:) 170))
				(self changeState: 1)
			)
			((and (== state 1) (< (gEgo y:) 180))
				(self changeState: 2)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(= seconds 0)
				(localproc_1 13 53) ; "O Fool, you seek death by coming here. Turn back now or die!"
				(raven setCycle: Fwd)
			)
			(2
				(HandsOff)
				(= seconds 0)
				(raven setLoop: 1)
				(gTObj talkCue: self)
				(SetFlag 26)
				(localproc_1 13 54 13 55) ; "Hear me, then, O Brave Fool. The Black Knight is the greatest of all knights. None have beaten him. He is invincible. Even Sir Gawaine was grievously wounded."
			)
			(3
				(gGame setCursor: gNormalCursor (HaveMouse))
				(User canInput: 1)
				(raven setLoop: 0)
				(= seconds 2)
			)
			(4
				(raven setCycle: 0 setCel: 0)
				(= seconds 10)
			)
			(5
				(= local4 3)
				(self cue:)
			)
			(6
				(HandsOff)
				(= seconds 0)
				(gTObj talkCue: self)
				(switch local4
					(0
						(gTObj noWidth: 1)
						(localproc_1 13 56) ; "Fool."
					)
					(1
						(localproc_1 13 57) ; "Then you must turn back, for you cannot pass this way through the forest without facing the Black Knight."
					)
					(2
						(localproc_1 13 58) ; "Crawk! I shall delight in feeding on your bones when the Black Knight has finished with you! I shall pluck out your eyes and peck at your bloody heart!"
					)
					(else
						(localproc_1 13 59) ; "I have no time to waste on fools. Turn back now or face him and die."
					)
				)
			)
			(7
				(raven setLoop: 2 setCel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(8
				(raven
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo 160 (raven y:) self
				)
			)
			(9
				(HandsOn)
				(raven setMotion: MoveTo 180 (raven y:) self)
			)
			(10
				(raven setMotion: MoveTo 319 (- (raven y:) 10) self)
			)
			(11
				(raven dispose:)
				(= local1 0)
				(client setScript: 0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(not (>= 4 state 3))
					(or (Said 'are<where/>') (Said 'ask[/blackbird]/*>'))
				)
				(cond
					((or (Said '/grail') (Said '//grail'))
						(localproc_1 13 60) ; "Would I tell such a fool as you even if I knew?"
					)
					((or (Said '/gawain') (Said '//gawain'))
						(localproc_1 13 61) ; "He is a prisoner of the Black Knight and dies slowly of the wounds he received."
					)
					((or (Said '/lancelot,galahad') (Said '//lancelot,galahad'))
						(localproc_1 13 62) ; "I know nothing of this knight. Another fool like Gawaine and you, no doubt."
					)
					(else
						(event claimed: 1)
						(Print 13 63) ; "It will not answer. It is sent by the Black Knight to taunt you, nothing more."
					)
				)
			)
			((or (event claimed:) (not (>= 4 state 3)))
				(return)
			)
			(
				(and
					(User canInput:)
					(not (User controls:))
					(or
						(== (event type:) $0040) ; direction
						(and (== (event type:) evMOUSEBUTTON) (== (event modifiers:) $0000))
					)
				)
				(event claimed: 1)
				(Print 13 64) ; "You must answer the crow, Arthur."
			)
			((!= (event type:) evSAID) 0)
			((or (Said 'yes') (Said 'accept') (Said '/me/do,accept'))
				(SetScore 0 2 1)
				(= local4 0)
				(self changeState: 6)
			)
			((or (Said 'no') (Said '/refuse'))
				(= local4 1)
				(self changeState: 6)
			)
			((or (Said 'fuck') (Said 'eat/shit,me'))
				(= local4 2)
				(self changeState: 6)
			)
			(else
				(= local4 3)
				(event claimed: 1)
				(self changeState: 6)
			)
		)
	)
)

(instance knight of PV
	(properties
		y 130
		x 123
		view 113
		loop 4
		priority 9
		signal -16351
	)
)

(instance slowForward of Fwd
	(properties)

	(method (init)
		(= cycleCnt (Random 10 20))
		(super init: &rest)
	)

	(method (doit)
		(if cycleCnt
			(-- cycleCnt)
		else
			(super doit:)
			(= cycleCnt (Random 60 100))
		)
	)
)

(instance sleeve of Prop
	(properties
		view 113
	)

	(method (init)
		(super init:)
		(self loop: 5 cel: 0 setPri: 9 posn: 124 118 ignoreActors: 1)
	)
)

(instance raven of Act
	(properties
		yStep 5
		view 113
		illegalBits 0
		xStep 5
	)

	(method (init)
		(super init:)
		(self setPri: 10 ignoreActors: 1 ignoreHorizon: 1)
	)
)

(instance getMushroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsVIEW 12)
				(Load rsVIEW 401)
				(gEgo illegalBits: 0 setMotion: MoveTo 132 151 self)
			)
			(1
				(gEgo setMotion: MoveTo 128 151 self)
			)
			(2
				(if (!= global116 1)
					(= cycles 1)
				else
					(gEgo view: 13 cel: 4 setCycle: Beg self)
				)
			)
			(3
				(gEgo
					view: 3
					looper: 0
					loop: 3
					posn: 125 151
					setCycle: Walk
					setMotion: MoveTo 136 175 self
				)
				(if (== global116 1)
					(horseAlone
						view: 401
						posn: 128 151
						loop: 1
						ignoreActors: 0
						init:
					)
				)
			)
			(4
				(gEgo setPri: 15 setMotion: MoveTo 104 175 self)
			)
			(5
				(gEgo view: 12 cycleSpeed: 1 setLoop: 0 setCycle: End self)
			)
			(6
				(gEgo setLoop: 1 setCycle: Fwd)
				(= cycles 30)
			)
			(7
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(8
				(gEgo setLoop: 3 setCycle: Fwd)
				(= cycles 30)
			)
			(9
				(gEgo setLoop: 4 setCel: 0 setCycle: End self)
			)
			(10
				(EgoDead 13 65) ; "Of all the stubborn fools there be, I never saw such a fool as thee, You shall keep yon knight good company, And nourish the roots of Old Father Tree."
			)
		)
	)
)

