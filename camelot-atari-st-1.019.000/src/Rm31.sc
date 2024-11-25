;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm31 0
)

(synonyms
	(bush tree)
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance iceWindow of SysWindow
	(properties
		color 7
		back 11
		title {Ice Maiden}
		brLeft 80
		brBottom 120
		brRight 300
	)
)

(instance flowers of View
	(properties
		y 131
		x 185
		view 131
	)
)

(instance sparkle of Prop
	(properties
		y 140
		x 255
		view 315
	)
)

(instance glow of Prop
	(properties
		y 105
		x 258
		view 36
	)
)

(instance Rm31 of Rm
	(properties
		picture 31
		style 2
	)

	(method (init)
		(Load rsVIEW 315)
		(Load rsVIEW 314)
		(Load rsVIEW 36)
		(super init:)
		(gEgo view: 0 init:)
		(iceMaiden init:)
		(sparkle ignoreActors: 1 init: cycleSpeed: 1 setCycle: Fwd)
		(flowers setPri: 12 init: stopUpd: addToPic:)
		(gRmMusic number: 55 loop: -1 play:)
		(gTObj tWindow: iceWindow cSpeed: 1 init:)
		(proc0_13 33)
		(gAddToPics doit:)
		(gCurRoom setScript: roomHappenins)
		(if (== gPrevRoomNum 32)
			(gEgo posn: 190 162 loop: 3)
			(if (IsFlag 67)
				(SetScore 0 1 15)
				(roomHappenins changeState: 11)
			else
				(roomHappenins changeState: 15)
			)
		else
			(roomHappenins changeState: 1)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((and (> (gEgo x:) 290) (not local1))
				(= local1 1)
				(= local0 1)
				(gEgo setScript: turnAround)
			)
			((and (< (gEgo y:) 108) (not local1))
				(= local1 1)
				(gEgo setScript: turnAround)
			)
		)
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
			(
				(or
					(Said 'talk/merlin')
					(Said 'ask/advice')
					(Said 'ask[/merlin]/advice')
				)
				(Print 31 0) ; "I can only tell you the name of each flower, if you ask about them. Beyond that, you must consult your Liber ex Doctrina."
			)
			((Said 'look<below/bush')
				(Print 31 1) ; "It grows from a bed of soil locked in ice."
			)
			((OnButton event 153 89 220 146)
				(Print 31 2) ; "Clearly, this Miraculous Bush of Flowers is the work of the Lady's sorcery, for it contains many different flowers upon the one bush."
			)
			(
				(Said
					'look/bush,almond,anemone,buttercup,chrysanthemum,cornflower,daffodil,forget-me-not,lilly,poppy,sunflower'
				)
				(cond
					((not (gEgo inRect: 137 154 245 170))
						(Print 31 3) ; "Move to where you can best see all the flowers."
					)
					((not local2)
						(Print 31 2) ; "Clearly, this Miraculous Bush of Flowers is the work of the Lady's sorcery, for it contains many different flowers upon the one bush."
					)
					(else
						(gTObj talkCue: 0)
						(Talk 31 4) ; "Very well. Let the test begin."
						(roomHappenins changeState: 9)
					)
				)
			)
			((Said 'talk,ask/merlin/bush,branch,leaf,dirt')
				(Print 31 5) ; "Clearly, the bush grows here only by the Ice Maiden's magicks, yet it looks like an ordinary bush in an ordinary patch of soil."
			)
			(
				(Said
					'talk,ask/merlin/blossom,almond,anemone,buttercup,chrysanthemum,cornflower,daffodil,forget-me-not,lilly,poppy,sunflower'
				)
				(Print 31 6) ; "These are all the flowers on the Miraculous Bush of Flowers:  almond blossom, anemone, buttercup, chrysanthemum, cornflower, daffodil, forget-me-not, lilly, poppy, and sunflower."
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
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '<around')
							(Said '/castle,chamber')
							(Said '//castle,chamber')
						)
						(Print 31 7) ; "In this glittering cave of ice, it is strange and wondrous to see a living thing. Yet there stands the Miraculous Bush of Flowers."
					)
					(
						(or
							(Said '/woman')
							(Said '//woman')
							(MouseClaimed iceMaiden event)
						)
						(Print 31 8) ; "She looks expectant, in a frosty sort of way."
					)
					((or (Said '/lancelot') (Said '//lancelot'))
						(Print 31 9) ; "He is in the pillar of ice and will remain there, unless you pass the Ice Maiden's test and free him."
					)
					((or (Said '/tunnel,cave') (Said '//tunnel,cave'))
						(Print 31 10) ; "It is dark and cold and uninviting."
					)
					((or (Said '/ice') (Said '//ice'))
						(Print 31 11) ; "All but the Bush is ice, formed from the frozen body of the lake by the Ice Maiden's magicks."
					)
					((or (Said '/stalactite') (Said '//stalactite'))
						(Print 31 12) ; "The inside of her palace is lined with stalagmites, stalactites and pillars of ice."
					)
					((Said '//language<blossom')
						(Print 31 13) ; "Please consult your Libera ex Doctrina."
					)
					((Said 'look/branch,leaf,dirt')
						(Print 31 14) ; "In every other respect, the bush is quite ordinary."
					)
					((Said 'look/blossom')
						(Print 31 15) ; "There are no less than ten flowers upon this bush."
					)
					((OnButton event 106 46 242 105)
						(Print 31 16) ; "The recesses of the ice palace fade into a shrouded glimmer of frozen shadow."
					)
				)
			)
			((Said 'get/ice,stalactite')
				(Print 31 17) ; "That would not help you much."
			)
			((or (Said 'deliver,save/lancelot') (Said 'win/freedom'))
				(Talk 31 18) ; "First, you must pass my test."
			)
			((Said 'smell')
				(Print 31 19) ; "The different flowers fill the air with their mingled fragrances."
			)
			((or (Said 'draw/blade') (Said 'kill,attack,annihilate/woman'))
				(switch local3
					(0
						(Talk 31 20) ; "Do you think to threaten ME with the very sword I gave you from my own hand? Once only will I tolerate this, or you will suffer the fate of Launcelot."
						(= global125 2)
					)
					(else
						(Talk 31 21) ; "You should have heeded my warning!"
						(gCurRoom setScript: iceEgo)
					)
				)
				(++ local3)
			)
			((Said 'give/copper,dirham,dinar,moneybag,coin')
				(Talk 31 22) ; "Money is meaningless to me."
			)
		)
	)
)

(instance roomHappenins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(sparkle hide:)
				(gEgo posn: 330 170 setMotion: MoveTo 250 170)
				(iceMaiden
					view: 314
					setCycle: Walk
					setLoop: 1
					posn: 320 165
					setMotion: MoveTo 255 140 self
				)
			)
			(2
				(iceMaiden view: 315 setLoop: 2 cel: 0 setCycle: 0)
				(sparkle show:)
				(gEgo setMotion: 0)
				(Face gEgo iceMaiden)
				(= seconds 2)
			)
			(3
				(Talk 31 23) ; "When you are ready for the test, we shall begin."
				(HandsOn)
				(= seconds 40)
			)
			(4
				(Talk 31 24) ; "Come, Pendragon. My patience is not without limit. If you will not look at the Bush and take this test, I will send you from here."
				(= seconds 20)
			)
			(5
				(HandsOff)
				(gTObj talkCue: self)
				(Talk 31 25) ; "It would seem that your courage has failed you. Farewell, then."
			)
			(6
				(glow
					view: 36
					setLoop: 0
					setPri: (- (gEgo priority:) 1)
					cycleSpeed: 2
					ignoreActors:
					posn: (+ (gEgo x:) 2) (gEgo y:)
					setCycle: Fwd
					init:
				)
				(= cycles 15)
			)
			(7
				(gSFX number: (proc0_20 57) play:)
				(gEgo
					view: 36
					setLoop: 1
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(8
				(glow hide:)
				(gEgo hide:)
				(gCurRoom newRoom: 25)
			)
			(9
				(= seconds 0)
				(SetScore 0 2 5)
				(gEgo setScript: walkToBush)
			)
			(10 0)
			(11
				(HandsOff)
				(iceMaiden
					view: 315
					setLoop: 2
					cel: 0
					setCycle: 0
					posn: 255 140
				)
				(gEgo setLoop: 3)
				(= cycles 3)
			)
			(12
				(gEgo setLoop: 0)
				(gTObj talkCue: self)
				(Talk 31 26) ; "You are worthy of the great legends that will live on in your name. Come with me."
			)
			(13
				(gEgo setMotion: MoveTo 320 170 self)
				(iceMaiden
					view: 314
					setCycle: Walk
					setLoop: 0
					setMotion: MoveTo 320 160
				)
				(sparkle hide:)
			)
			(14
				(gCurRoom newRoom: 30)
			)
			(15
				(HandsOff)
				(iceMaiden view: 315 setLoop: 2 cel: 0 posn: 255 140)
				(gEgo setLoop: 0)
				(= cycles 2)
			)
			(16
				(gCurRoom setScript: 0 setScript: iceEgo)
			)
		)
	)
)

(instance icicle of Prop
	(properties)
)

(instance iceEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if global124
					(= global124 0)
					(= global125 0)
					(gEgo view: 4 setScript: 0 setCycle: Beg)
				)
				(gSFX number: (proc0_20 39) loop: 1 play:)
				(= cycles 3)
			)
			(1
				(icicle
					view: 37
					setLoop: 0
					posn: (gEgo x:) (+ (gEgo y:) 4)
					cycleSpeed: 1
					init:
					setCycle: End self
				)
			)
			(2
				(gSFX stop:)
				(= seconds 5)
			)
			(3
				(Print 31 27) ; "As icy fingers seize your spine And coldness numbs your brain You wish instead in battle hot You nobly had been slain."
				(Print 31 28) ; "Alas, your ears are filled with ice You hear not my sad refrain, A frozen statue of despair In winter's hard domain."
				(EgoDead)
			)
		)
	)
)

(instance iceMaiden of Act
	(properties
		view 315
		loop 2
	)

	(method (handleEvent event)
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
			(
				(or
					(Said 'talk[/woman]')
					(Said 'ask//riddle,test')
					(Said 'start,get,pass/test')
					(Said 'deliver/lancelot')
				)
				(if local2
					(Talk 31 4) ; "Very well. Let the test begin."
					(gTObj talkCue: 0)
					(roomHappenins changeState: 9)
				else
					(= local2 1)
					(gEgo setScript: bigTalk)
				)
			)
			(
				(or
					(Said 'adjust,yes')
					(Said '/me/adjust')
					(Said '/me/accept')
					(Said 'accept')
				)
				(if local2
					(Talk 31 4) ; "Very well. Let the test begin."
					(gTObj talkCue: 0)
					(roomHappenins changeState: 9)
				else
					(gEgo setScript: bigTalk)
				)
			)
			((Said 'love//shield<my<are')
				(HandsOff)
				(roomHappenins changeState: 6)
			)
			(
				(Said
					'get,pick,cut/bush,branch,leaf,blossom,dirt,almond,anemone,buttercup,chrysanthemum,cornflower,daffodil,forget-me-not,lilly,poppy,sunflower'
				)
				(switch local4
					(0
						(Talk 31 29) ; "Do not touch the Miraculous Bush of Flowers. You may revel in the sight and scent of it, but it is mine alone to touch."
					)
					(1
						(Talk 31 30) ; "I warn you most sternly, do not pursue this or I will punish you."
					)
					(else
						(gEgo setScript: iceEgo)
					)
				)
				(++ local4)
			)
			((Said 'talk/language,blossom')
				(Talk 31 31) ; "To speak the Language of the Flowers means simply to know the special meaning that belongs to each flower, what thought or emotion is associated with it."
			)
			((Said 'cut,annihilate/ice,column')
				(Talk 31 32) ; "No weapon made, not even Excaliber, can shatter this ice formed by my will."
			)
			((Said 'give/rose')
				(if (gEgo has: 4) ; rose | apple | green_apple
					(Talk 31 33) ; "I will not touch it, for it has Gwenhyver's spell upon it."
				else
					(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
				)
			)
			((Said 'give/key,lodestone,sleeve')
				(Talk 31 34) ; "Nay, keep it. I have no use for such a thing."
			)
			(
				(or
					(Said 'talk,ask[/woman]>')
					(Said 'tell[/me]>')
					(Said 'are<where>')
				)
				(cond
					((or (Said '/grail') (Said '//grail'))
						(Talk 31 35) ; "Did you not listen? Go to Jerusalem, I said."
					)
					((or (Said '/lancelot') (Said '//lancelot'))
						(Talk 31 36) ; "You are here to free Launcelot.....if you dare."
					)
					((or (Said '/gawain,galahad') (Said '//gawain,galahad'))
						(Talk 31 37) ; "He did not come here. Therefore I know nothing of him."
					)
					((or (Said '/bush') (Said '//bush'))
						(Talk 31 38) ; "It is my Miraculous Bush of Flowers. Go look closely upon the one side that is in bloom."
					)
					(else
						(event claimed: 1)
						(Talk 31 39) ; "Merlin is your advisor, not I."
					)
				)
			)
			((Said 'kiss[/woman]')
				(Print 31 40) ; "Your lips would stick."
			)
			((Said 'hug,fuck/woman')
				(Print 31 41) ; "She is frigidly disinterested."
			)
		)
	)
)

(instance turnAround of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local0
					(Talk 31 42) ; "That way is closed to you now, unless you can speak the Language of the Flowers and free Launcelot."
				else
					(Talk 31 43) ; "You may not pass that way."
				)
				(= cycles 20)
			)
			(1
				(if local0
					(gEgo setMotion: MoveTo 280 (gEgo y:))
				else
					(gEgo setMotion: MoveTo (gEgo x:) 115)
				)
				(= cycles 10)
			)
			(2
				(HandsOn)
				(= local0 0)
				(= local1 0)
				(client setScript: 0)
			)
		)
	)
)

(instance bigTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not local2)
					(= local2 1)
					(gTObj talkCue: self)
					(Talk 31 44) ; "You will hear me out first."
				else
					(= cycles 1)
				)
			)
			(1
				(gTObj talkCue: self)
				(Talk 31 45 31 46) ; "To free Launcelot, you must speak the Language of the Flowers. I will pose three riddles. You must give me the name of the flower that solves each riddle."
			)
			(2
				(gTObj talkCue: self)
				(Talk 31 47 31 48) ; "But I will not force this upon you. Recite the Message of the Rose and I will send you safely away, though Launcelot will not go free."
			)
			(3
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance walkToBush of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				(cond
					((< (gEgo y:) 134)
						(self cue:)
					)
					((< (gEgo y:) 148)
						(self changeState: 3)
					)
					((< (gEgo y:) 165)
						(self changeState: 4)
					)
					(else
						(self changeState: 5)
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo 148 (gEgo y:) self)
			)
			(2
				(gEgo setMotion: MoveTo 148 142 self)
			)
			(3
				(gEgo setMotion: MoveTo 133 (gEgo y:) self)
			)
			(4
				(gEgo setMotion: MoveTo (gEgo x:) 165 self)
			)
			(5
				(gEgo setMotion: MoveTo 190 165 self)
			)
			(6
				(gEgo illegalBits: $8000 loop: 3)
				(= seconds 3)
			)
			(7
				(gCurRoom newRoom: 32)
			)
		)
	)
)

