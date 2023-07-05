;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use n117)
(use n128)
(use Interface)
(use Rev)
(use Save)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm16 0
)

(synonyms
	(carving lettering)
	(crone crone woman)
	(base altar)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance witchWindow of SysWindow
	(properties
		color 14
		back 5
		title {Forest Witch}
		brLeft 140
		brBottom 65
		brRight 310
	)
)

(instance sparkle of Prop
	(properties)
)

(instance rm16 of Rm
	(properties
		picture 16
	)

	(method (init)
		(super init:)
		(self setRegions: 102) ; forestPerilous
		(gEgo init:)
		(proc0_13 32)
		(gAddToPics doit:)
		(= local0 1)
		(if (not (IsFlag 29))
			(gRmMusic number: 35 loop: -1 play:)
			(Load rsVIEW 21)
			(Load rsVIEW 116)
			(Load rsSOUND 37)
			(witch
				view: 336
				setLoop: 0
				setCel: 255
				posn: 173 80
				setPri: 6
				ignoreActors:
				illegalBits: 0
				init:
			)
			(gTObj
				tLoop: 2
				tWindow: witchWindow
				cSpeed: 1
				actor: witch
				init:
			)
		else
			(gAddToPics add: runes doit:)
		)
		(gEgo setScript: EnterRoom)
	)

	(method (doit)
		(super doit:)
		(cond
			(
				(or
					(and (< (gEgo x:) 15) (> (gEgo y:) 150))
					(> (gEgo y:) 190)
				)
				(gCurRoom newRoom: 15)
			)
			(
				(or
					(and (< (gEgo x:) 15) (< (gEgo y:) 75))
					(< (gEgo y:) 10)
				)
				(gCurRoom newRoom: 17)
			)
		)
	)

	(method (handleEvent event)
		(if (and (== (event type:) evMOUSEBUTTON) (& (event modifiers:) emSHIFT))
			(cond
				((and (gCast contains: witch) (MouseClaimed witch event))
					(Print 16 0 #at 100 120) ; "Beware, Arthur! I like not the look of this old hag who stands upon the pedestal."
				)
				((and (IsFlag 29) (OnButton event 159 75 190 84))
					(Print 16 1 #icon 115 0 0) ; "These are runes of a very ancient type, probably a warning or incantation."
				)
				((OnButton event 149 75 200 106)
					(if (IsFlag 29)
						(Print 16 2 #at 100 120) ; "An inscription in runes has appeared upon the pedestal where the witch stood."
					else
						(Print 16 3 #at 100 120) ; "The forest witch stands upon a pedestal of some kind. I cannot say what purpose it may have had, though it does seem to be covered in badly weathered carvings."
					)
				)
				(
					(or
						(OnButton event 115 50 131 74)
						(OnButton event 183 46 194 66)
						(OnButton event 242 68 253 96)
					)
					(Print 16 4 #at 100 120) ; "This small stone was once a man, but will never be so again."
				)
				(
					(or
						(OnButton event 8 6 311 66)
						(OnButton event 270 25 311 183)
						(OnButton event 38 135 311 183)
						(OnButton event 8 6 22 150)
					)
					(Print 16 5 #at 100 120) ; "These large standing stones are megaliths. It means simply 'big stone'."
				)
			)
		)
		(cond
			((event claimed:)
				(return)
			)
			(
				(and
					local1
					(not (User controls:))
					(User canInput:)
					(or
						(== (event type:) $0040) ; direction
						(and (== (event type:) evMOUSEBUTTON) (== (event modifiers:) $0000))
					)
				)
				(event claimed: 1)
				(Talk 16 6) ; "Ye shall never move again, unless ye offer me what I desire."
			)
			(
				(or
					(Said 'talk/merlin')
					(Said 'ask/advice')
					(Said 'ask[/merlin]/advice')
				)
				(cond
					((IsFlag 44)
						(Print 16 7 #at 100 120) ; "Do not be daunted. This reads to me more like an instruction than an incantation. Let your own wits serve you."
					)
					((IsFlag 29)
						(Print 16 8 #at 100 120) ; "The runes might be important. If you ask, I could translate them."
					)
					(else
						(Print 16 9 #at 100 120) ; "You had best think of something to satisfy the old hag."
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
					(
						(or
							(Said 'look[<around][/room,forest]')
							(Said '//room,forest')
						)
						(if (IsFlag 29)
							(Print 16 10) ; "There is no danger within this stone circle now that the witch is gone. Alas, that her previous victims could not be freed."
						else
							(Print 16 11 #at 100 120) ; "There is terrible power in this old hag. She is a forest witch drawing upon the powers within this stone circle."
						)
					)
					((Said '<between,through/slab')
						(Print 16 12 #at 100 120) ; "The foliage has crept back from these stones, but it is difficult to see what lies beyond."
					)
					((Said '<below/slab,base')
						(Print 16 13 #at 100 120) ; "Though human hands once placed these stones, your two hands will not move them."
					)
					((Said '<above/slab,circle,cromlech,dolmen,trilithon')
						(Print 16 14 #at 100 120) ; "You are not tall enough to do that."
					)
					((Said '<up')
						(Print 16 15 #at 100 120) ; "The sky is open overhead. Not a single tree grows close enough to overhang this stone circle."
					)
					((Said '<down')
						(if (and (gEgo inRect: 120 90 215 130) (IsFlag 29))
							(Print 16 2 #at 100 120) ; "An inscription in runes has appeared upon the pedestal where the witch stood."
						else
							(event claimed: 0)
						)
					)
					((or (Said '/ass') (Said '//ass'))
						(if (IsFlag 20)
							(Print 16 16 #at 100 120) ; "Evidently, she has decided to follow you again."
						else
							(event claimed: 0)
						)
					)
					((or (Said '/crone') (Said '//crone'))
						(if (IsFlag 29)
							(Print 16 17 #at 100 120) ; "Happily, you have set her free. The witch will not plague this forest again."
						else
							(Print 16 0 #at 100 120) ; "Beware, Arthur! I like not the look of this old hag who stands upon the pedestal."
						)
					)
					(
						(or
							(Said '/man,(slab<little)')
							(Said '//man,(slab<little)')
						)
						(Print 16 18 #at 100 120) ; "Those three small stones were once men, but will never be so again."
					)
					((or (Said '/girl') (Said '//girl'))
						(if (IsFlag 29)
							(Print 16 19) ; "I fear the lovely lady's search for her beloved knight will end in misery and she will weep o'er his bones."
						else
							(Print 16 20 #at 100 120) ; "Do you call this ugly and withered old crone a girl? Truly, you have been in this forest too long."
						)
					)
					((or (Said '/base') (Said '//base'))
						(if (IsFlag 29)
							(if (gEgo inRect: 120 90 215 130)
								(Print 16 2 #at 100 120) ; "An inscription in runes has appeared upon the pedestal where the witch stood."
							else
								(NotClose) ; "Perhaps you should move closer."
							)
						else
							(Print 16 3 #at 100 120) ; "The forest witch stands upon a pedestal of some kind. I cannot say what purpose it may have had, though it does seem to be covered in badly weathered carvings."
						)
					)
					(
						(or
							(Said '/carving,incantation')
							(Said '//carving,incantation')
						)
						(if (and (IsFlag 29) (gEgo inRect: 120 90 215 130))
							(Print 16 1 #icon 115 0 0) ; "These are runes of a very ancient type, probably a warning or incantation."
						else
							(NotClose) ; "Perhaps you should move closer."
						)
					)
					((or (Said '/circle') (Said '//circle'))
						(Print 16 21 #at 100 120) ; "This circle of standing stones must be at the very edge of the Forest Perilous. But it has no henge, for a henge is a circular embankment."
					)
					((or (Said '/monolith') (Said '//monolith'))
						(Print 16 22 #at 100 120) ; "There is no monolith, but there are many megaliths."
					)
					((or (Said '/slab') (Said '//slab'))
						(cond
							((and (gEgo inRect: 120 90 215 130) (IsFlag 29))
								(Print 16 2 #at 100 120) ; "An inscription in runes has appeared upon the pedestal where the witch stood."
							)
							((gEgo inRect: 85 60 300 120)
								(Print 16 18 #at 100 120) ; "Those three small stones were once men, but will never be so again."
							)
							(else
								(Print 16 23 #at 100 120) ; "The large standing stones are megaliths. It means simply 'big stone'."
							)
						)
					)
					((or (Said '/column') (Said '//column'))
						(Print 16 24 #at 100 120) ; "They are not pillars, they are standing stones. Unlike a cromlech or dolmen, these are arranged in a circle."
					)
					(
						(or
							(Said '/lintel,entrance,gate,door,exit')
							(Said '//lintel,entrance,gate,door,exit')
						)
						(Print 16 25 #at 100 120) ; "These standing stones have but one entrance which is a trilithon: two upright stones with a capstone or lintel-stone over the top of them."
					)
					((or (Said '/trilithon') (Said '//trilithon'))
						(Print 16 26 #at 100 120) ; "It means 'three stones' and is a structure of two upright stones capped by a lintel-stone."
					)
					((or (Said '/dolmen') (Said '//dolmen'))
						(Print 16 27) ; "Dolmen comes from two Bretogne words: 'tol' meaning 'table' and 'men' meaning 'stone'. It refers to a tomb made of upright stones covered by a slab for a roof, then covered over with soil to make a mound."
					)
					((or (Said '/cromlech') (Said '//cromlech'))
						(Print 16 28) ; "Cromlech comes from the Welsh words: 'crom' meaning 'bent' and 'llech' meaning 'flat'. It refers to a tomb made of upright stones covered by a slab for a roof, then covered over with soil to make a mound."
					)
					((or (Said '/boulder,boulder') (Said '//boulder,boulder'))
						(Print 16 29 #at 100 120) ; "These are not natural rocks, as should be obvious. They are standing stones arranged in a circle."
					)
					((or (Said '/poet') (Said '//poet'))
						(Print 16 30) ; "I regret I know nothing that would help you."
					)
				)
			)
			(
				(or
					(Said 'use/enchantment')
					(Said 'kill,complete/carving,incantation')
					(Said 'get/instruction')
				)
				(if (IsFlag 29)
					(Print 16 31 #at 100 120) ; "I cannot. You must rely upon your own wits."
				else
					(Talk 16 32) ; "Cease prattling and give me what I desire."
				)
			)
			((Said 'give,use,show/sleeve,bolt,silk')
				(cond
					((IsFlag 29)
						(Print 16 33 #at 100 120) ; "Betimes I worry about you, Arthur. You set the Lady Elayne free, remember?"
					)
					((gEgo has: 5) ; sleeve | elixir
						(SetScore 0 0 5 2 1)
						(witch setScript: metamorphisis)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'deliver,help/man')
				(Print 16 34) ; "Alas, you cannot."
			)
			((Said 'talk/girl')
				(if (IsFlag 29)
					(Print 16 35) ; "The Lady Elayne seemed much too overjoyed to listen, did she not? Nor would you have taken much pleasure in telling her the sad fate of her beloved knight."
				else
					(Talk 16 36) ; "I know not to whom ye would speak, but ye had best deal with me if ye wish to pass this circle."
				)
			)
			((Said 'climb,(get<on)/base')
				(if (IsFlag 29)
					(Print 16 37 #at 100 120) ; "You will see nothing special from there. You would only obscure the runes carved upon the top of the pedestal."
				else
					(Talk 16 38) ; "Ye must deal with me first!"
				)
			)
			((Said 'read/carving,base,slab,incantation')
				(if (IsFlag 29)
					(Print 16 39 #icon 115 0 0) ; "The runes on the pedestal say this..."
					(Print 16 40 #icon 115 0 0 #at -1 30) ; "Five poets bold Did come astray. Five standing stones Now bar the way. Of limbs bereft, Yet voice I left. To pass through the middle You must ask for......."
					(Print 16 41) ; "Alas, it fades out here. The last flurry of magick which caused it to appear must not have been enough to bring out the full inscription."
					(SetFlag 44)
					(SetScore 250 1 1)
				else
					(Print 16 42) ; "I see no writing here."
				)
			)
			((Said 'get>')
				(cond
					((Said '/crone')
						(if (IsFlag 29)
							(Print 16 43 #at 100 120) ; "There is nothing left of her, fortunately."
						else
							(Talk 16 44) ; "And how do ye propose to do that, arrogant one?"
						)
					)
					((Said '/girl')
						(if (IsFlag 29)
							(Print 16 45 #at 100 120) ; "That is not what you came here to do. Remember your mission."
						else
							(Talk 16 46) ; "I care naught for what ye desire. Give me what I desire."
						)
					)
					((Said '/carving,slab,base')
						(Print 16 47 #at 100 120) ; "That is beyond your strength."
					)
					((IsFlag 29)
						(event claimed: 1)
						(Print 16 48 #at 100 120) ; "Too late to think of that."
					)
				)
			)
		)
	)
)

(instance witch of Act
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((== (gEgo view:) 31) 0)
			(local1
				(if local3
					(HandsOff)
					(gEgo setMotion: 0 setScript: TurnToStone)
				else
					0
				)
			)
			((and local0 (gEgo inRect: 45 70 320 200))
				(= local1 1)
				(= local0 0)
				(witch setScript: Freeze)
			)
			((& (gEgo onControl: 1) $4000)
				(= local1 1)
				(= local0 0)
				(witch setScript: Freeze)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((Said 'greet')
				(if (IsFlag 29)
					(event claimed: 0)
				else
					(Talk 16 49) ; "I care nothing for pretty words. If ye wish to pass, ye must give me what I desire."
				)
			)
			((Said 'move/base')
				(Print 16 47 #at 100 120) ; "That is beyond your strength."
			)
			((Said 'talk[/crone]')
				(if (IsFlag 29)
					(Print 16 50 #at 100 120) ; "Betimes I worry about you, Arthur. You set her free, remember?"
				else
					(Talk 16 51 16 52) ; "Ye shall not pass through this circle unless ye give me what I desire."
				)
			)
			((IsFlag 29) 0)
			((Said 'give,use,show>')
				(cond
					((Said '/sleeve,bolt,silk')
						(cond
							((IsFlag 29)
								(Print 16 33 #at 100 120) ; "Betimes I worry about you, Arthur. You set the Lady Elayne free, remember?"
							)
							((gEgo has: 5) ; sleeve | elixir
								(SetScore 0 0 5 2 1)
								(witch setScript: metamorphisis)
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((IsFlag 29)
						(event claimed: 0)
					)
					((Said '/coin,coin,dinar,dirham,copper')
						(if (not (DoPurse))
							(Talk 16 53) ; "King of paupers! Ye offer nothing."
						else
							(Talk 16 54) ; "If ye would buy a safe passage, ye must offer nothing less than an entire purse."
							(proc0_18)
						)
					)
					((Said '/moneybag')
						(if (or global120 global121 global122)
							(Talk 16 55) ; "For this, I shall let ye pass."
							(PutItem 3) ; purse
							(= global122 (= global121 (= global120 0)))
							(SetMenu 1281 112 0)
							(gEgo setScript: GiveToWitch)
						else
							(Talk 16 53) ; "King of paupers! Ye offer nothing."
						)
					)
					((Said '/me')
						(Talk 16 56) ; "Ye think ye be a grand prize, but ye do not be what I most desire."
					)
					((Said '/rose')
						(if (gEgo has: 4) ; rose | apple | green_apple
							(PutItem 4) ; rose | apple | green_apple
							(Talk 16 57) ; "Ye be a fool to part with this gift of love, but for it I shall let ye pass."
							(gEgo setScript: GiveToWitch)
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said '/lodestone')
						(if (gEgo has: 2) ; lodestone
							(PutItem 2) ; lodestone
							(Talk 16 58) ; "For this magical stone, I shall let ye pass."
							(gEgo setScript: GiveToWitch)
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said '/heart')
						(if (gEgo has: 7) ; crystal_heart | charcoal | helm
							(PutItem 7) ; crystal_heart | charcoal | helm
							(Talk 16 59) ; "Ye part with the very heart of the Lady of the Lake, but for this gift I shall let ye pass."
							(gEgo setScript: GiveToWitch)
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said '/key')
						(if (gEgo has: 6) ; iron_key | broom | grail
							(PutItem 6) ; iron_key | broom | grail
							(Talk 16 55) ; "For this, I shall let ye pass."
							(gEgo setScript: GiveToWitch)
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said '/ass,pack,water,food,clothes,blanket')
						(if (IsFlag 20)
							(Talk 16 60) ; "Ye please me not with this offer."
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said '/charger,gear')
						(if (!= global116 0)
							(Talk 16 60) ; "Ye please me not with this offer."
						else
							(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
						)
					)
					((Said '/blade,shield,armor')
						(Talk 16 60) ; "Ye please me not with this offer."
					)
				)
			)
			((Said 'bargain/*')
				(Talk 16 61) ; "Seek ye not to bargain with me. I take, I do not give."
			)
			(
				(or
					(Said 'ask[/crone]/desire')
					(Said 'want<you<do<what')
					(Said 'do<what/desire<you')
				)
				(Talk 16 62) ; "If ye be so cunning a knight, ye shall know."
			)
			((or (Said 'ask[/crone]>') (Said '(are<where)/*>'))
				(cond
					(
						(or
							(Said '/gawain,lancelot,galahad,grail')
							(Said '//gawain,lancelot,galahad,grail')
						)
						(Talk 16 63) ; "I care nothing for the petty doings of men. Give me what I desire or ye shall suffer."
					)
					((Said '//(slab<little),man')
						(Talk 16 64 16 65) ; "Look all ye want, mortal man. These three by me, see ye them? Once they too were men."
					)
					(else
						(event claimed: 1)
						(Talk 16 32) ; "Cease prattling and give me what I desire."
					)
				)
			)
			((Said 'get>')
				(cond
					((Said '/moneybag,coin,coin,dinar,dirham,copper')
						(cond
							((not (IsItemAt 3)) ; purse
								(Print 16 66) ; "You cannot get back what you have not given."
								67
								100
								120
							)
							(local2
								(gEgo setScript: TurnToStone)
							)
							(else
								(Talk 16 67) ; "Seek to take back what ye have given and ye shall be stone before ye can blink."
								(= local2 1)
							)
						)
					)
					((Said '/heart')
						(if (not (IsItemAt 7)) ; crystal_heart | charcoal | helm
							(Print 16 68 #at 100 120) ; "But she does not have it."
						else
							(Talk 16 69) ; "What ye have given, ye have lost."
						)
					)
					((Said '/rose')
						(if (not (IsItemAt 4)) ; rose | apple | green_apple
							(Print 16 68 #at 100 120) ; "But she does not have it."
						else
							(Talk 16 69) ; "What ye have given, ye have lost."
						)
					)
					((Said '/lodestone')
						(if (not (IsItemAt 2)) ; lodestone
							(Print 16 68 #at 100 120) ; "But she does not have it."
						else
							(Talk 16 69) ; "What ye have given, ye have lost."
						)
					)
					((Said '/key')
						(if (not (IsItemAt 6)) ; iron_key | broom | grail
							(Print 16 68 #at 100 120) ; "But she does not have it."
						else
							(Talk 16 69) ; "What ye have given, ye have lost."
						)
					)
				)
			)
			((Said 'smell')
				(if (IsFlag 29)
					(event claimed: 0)
				else
					(Talk 16 70) ; "It is ye who smell of warm blood and mortal flesh. Ye reek of life. I shall like ye better when ye smell of cold stone."
				)
			)
			((Said 'help/crone')
				(if (IsFlag 29)
					(event claimed: 0)
				else
					(Print 16 71 #at 100 120) ; "I think it is you who needs the help."
				)
			)
			((Said 'help/girl')
				(if (IsFlag 29)
					(Print 16 72 #at 100 120) ; "It is a good thought, Arthur, but your mission is far more important."
				else
					(Print 16 71 #at 100 120) ; "I think it is you who needs the help."
				)
			)
			((Said 'kill,attack/crone')
				(if (IsFlag 29)
					(event claimed: 0)
				else
					(Talk 16 73) ; "Try it if ye dare, arrogant one."
				)
			)
			((Said 'kiss,hug,fuck/crone')
				(if (IsFlag 29)
					(event claimed: 0)
				else
					(Print 16 74 #at 100 120) ; "What a disgusting notion."
				)
			)
			((Said 'fuck')
				(if (IsFlag 29)
					(event claimed: 0)
				else
					(= local4 1)
					(gEgo setScript: TurnToStone)
				)
			)
			((Said 'draw/blade')
				(cond
					((not (gCast contains: witch))
						(event claimed: 0)
					)
					((not (IsFlag 46))
						(SetFlag 46)
						(= global125 2)
						(Talk 16 75) ; "Put up thy sword! Put it away this instant or ye shall become stone!"
					)
					(else
						(= global125 2)
						(= local3 1)
						(gEgo setScript: TurnToStone)
					)
				)
			)
		)
	)
)

(instance EnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch gPrevRoomNum
					(17
						(gEgo
							posn: 15 60
							loop: 0
							setMotion: MoveTo 55 68 self
						)
						(if (IsFlag 20)
							(gMuleObj setScript: muleActions)
						)
					)
					(else
						(gEgo
							posn: 15 180
							loop: 0
							setMotion: MoveTo 35 170 self
						)
						(if (IsFlag 20)
							(gMuleObj setScript: muleActions)
						)
					)
				)
			)
			(1
				(HandsOn)
				(if (IsFlag 42)
					(= cycles 1)
				else
					(Print 16 0 #at 100 120) ; "Beware, Arthur! I like not the look of this old hag who stands upon the pedestal."
					(SetFlag 42)
				)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance Freeze of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(HandsOff)
				(gRmMusic number: 38 loop: -1 play:)
				(gTObj talkCue: self)
				(Talk 16 76) ; "Halt! Ye shall not pass me unhindered, king though ye be."
			)
			(1
				(if (!= (gEgo loop:) 0)
					(gEgo
						setMotion: MoveTo (+ (gEgo x:) 1) (gEgo y:) self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(if local0
					(gTObj talkCue: self)
					(Talk 16 77) ; "Aye, rage if you will, but until ye give me what I desire, ye shall not move another step."
				else
					(= cycles 1)
				)
			)
			(3
				(gTObj talkCue: self)
				(Talk 16 78) ; "And if ye give me not what I desire, a stone ye shall be."
			)
			(4
				(gGame setCursor: gNormalCursor (HaveMouse))
				(HandsOn)
				(User canControl: 0)
				(witch setScript: 0)
			)
		)
	)
)

(instance metamorphisis of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local1 1)
				(gTObj tLoop: 0 talkCue: self cSpeed: 0)
				(Talk 16 79) ; "Aye! Aye! That is what I most desire! Bring it here at once!"
			)
			(1
				(gEgo setMotion: MoveTo 135 110 self)
			)
			(2
				(gRmMusic fade:)
				(PutItem 5) ; sleeve | elixir
				(gEgo setMotion: MoveTo 160 110 self)
			)
			(3
				(witch setLoop: 3 cel: 1)
				(= local6 (gEgo looper:))
				(gEgo looper: 0)
				(= seconds 3)
			)
			(4
				(gEgo
					setLoop: 0
					setCycle: Rev
					setMotion: MoveTo (- (gEgo x:) 10) (gEgo y:) self
				)
			)
			(5
				(gEgo setLoop: -1 looper: local6 setCycle: Walk)
				(DisposeScript 969)
				(witch cycleSpeed: 2 setCycle: End self)
				(gRmMusic number: 37 loop: 2 play:)
			)
			(6
				(witchWindow
					title: {Lady Elayne}
					brLeft: 200
					brRight: 310
					brBottom: 105
					color: 15
				)
				(gTObj tLoop: 5 cSpeed: 1 talkCue: self)
				(Talk 16 80 16 81 16 82) ; "Bless you, valiant knight! I am the Lady Elayne, transformed into the forest witch by a hideous spell cast upon me by the Black Knight."
			)
			(7
				(witch
					setLoop: 4
					setCel: 0
					cycleSpeed: 0
					setCycle: Walk
					setMotion: JumpTo 144 92 self
				)
			)
			(8
				(DisposeScript 991)
				(witch setStep: 4 3 setPri: -1 setMotion: MoveTo 125 90 self)
			)
			(9
				(witch setMotion: MoveTo 0 190 self)
			)
			(10
				(sparkle
					view: 116
					loop: 0
					cel: 0
					posn: 173 105 22
					ignoreActors: 1
					init:
					setCycle: End self
				)
			)
			(11
				(sparkle loop: 1 cel: 0 posn: 176 105 21 setCycle: Fwd)
				(= cycles 20)
			)
			(12
				(gAddToPics add: runes doit:)
				(= cycles 20)
			)
			(13
				(sparkle dispose:)
				(gRmMusic fade:)
				(witch setScript: 0)
				(witch dispose:)
				(SetFlag 29)
				(HandsOn)
			)
		)
	)
)

(instance GiveToWitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local1 1)
				(= local0 0)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 135 110 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 170 110 self)
			)
			(2
				(= seconds 4)
			)
			(3
				(gTObj noWidth: 1 talkCue: self)
				(Talk 16 83) ; "Now be gone!"
			)
			(4
				(gEgo setMotion: MoveTo 110 110 self)
			)
			(5
				(HandsOn)
				(= local1 0)
				(gEgo illegalBits: -32768 ignoreActors: 0 setScript: 0)
			)
		)
	)
)

(instance TurnToStone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
				(cond
					(local3
						(= local3 0)
						(if global124
							(= global124 0)
							(= global125 0)
							(gEgo
								view: (if (== global116 1) 56 else 5)
								setCycle: Beg
							)
						)
						(Talk 16 84) ; "No man can best me with cold steel. Pay the price for thy arrogance."
					)
					(local4
						(Talk 16 85) ; "A tongue so foul should never utter another vowel!"
					)
					(else
						(Talk 16 86) ; "Ye have not given me what I desire. Stone ye shall be for all eternity!"
					)
				)
			)
			(1
				(witch setLoop: 1 setCycle: End self)
				(if (!= (gEgo loop:) 0)
					(gEgo
						setMotion: MoveTo (+ (gEgo x:) 1) (gEgo y:) self
					)
				)
			)
			(2
				(witch setCycle: Beg)
				(if (== global116 1)
					(gEgo setLoop: 0)
				else
					(gEgo setLoop: 1)
				)
				(gEgo view: 21 cel: 0 cycleSpeed: 3 setCycle: End self)
				(gRmMusic number: (proc0_20 39) loop: 1 play:)
			)
			(3
				(gRmMusic stop:)
				(= seconds 4)
			)
			(4
				(Print 16 87 #at 70 120 #width 200) ; "Defeated by an ugly crone, From mortal man to standing stone, With sun and rain upon you blown,"
				(Print 16 88 #at 40 120 #width 230) ; "Through carven locks the wind shall moan, Here you will be through years unknown, And slowly crumble when time has flown."
				(EgoDead)
			)
		)
	)
)

(instance muleActions of Script
	(properties)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(17
				(gMuleObj loop: 0 posn: 15 50 setMotion: MoveTo 55 60)
			)
			(else
				(gMuleObj loop: 0 posn: 15 190 setMotion: MoveTo 35 180)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((gEgo inRect: 111 0 320 200)
				(if (!= state 1)
					(self changeState: 1)
				)
			)
			((gEgo inRect: 0 75 110 125)
				(if (!= state 2)
					(self changeState: 2)
				)
			)
			((gEgo inRect: 0 0 65 74)
				(if (!= state 3)
					(self changeState: 3)
				)
			)
			((and (gEgo inRect: 0 126 110 200) (!= state 4))
				(self changeState: 4)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gMuleObj setMotion: MoveTo 160 115)
			)
			(2
				(gMuleObj setMotion: MoveTo 95 120)
			)
			(3
				(gMuleObj setMotion: MoveTo 55 65)
			)
			(4
				(gMuleObj setMotion: MoveTo 35 180)
			)
		)
	)
)

(instance runes of PV
	(properties
		y 105
		x 173
		z 20
		view 116
		loop 2
	)
)

