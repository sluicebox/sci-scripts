;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use n128)
(use eRoom)
(use Interface)
(use Avoid)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	Rm30 0
)

(synonyms
	(woman woman)
	(lancelot man friend knight prisoner)
)

(local
	local0
	local1
	local2
	local3
)

(instance iceMaiden of Act
	(properties
		y 100
		x 170
		view 315
		loop 2
	)
)

(instance sparkle of Prop
	(properties
		y 100
		x 170
		view 315
	)
)

(instance lancelot of Act
	(properties
		y 106
		x 254
		view 312
		loop 1
		priority 7
		signal 16
	)
)

(instance iceSheet of Prop
	(properties
		y 106
		x 252
		view 312
		priority 7
		signal 16
	)
)

(instance glow of Prop
	(properties
		y 105
		x 258
		view 312
		priority 8
		signal 16
	)
)

(instance heart of Prop
	(properties
		y 100
		x 174
		z 30
		view 315
		loop 6
		cycleSpeed 1
	)
)

(instance spell of Act
	(properties
		y 75
		x 180
		view 315
		loop 3
		priority 8
		signal 16
		illegalBits 0
	)
)

(instance iceWindow of SysWindow
	(properties
		color 7
		back 11
		title {Ice Maiden}
		brLeft 30
		brBottom 70
		brRight 300
	)
)

(instance Rm30 of eRoom
	(properties
		picture 30
	)

	(method (init)
		(self style: (if (== gPrevRoomNum 29) 4 else 3))
		(Load rsVIEW 36)
		(Load rsVIEW 315)
		(Load rsVIEW 314)
		(Load rsVIEW 312)
		(Load rsVIEW 70)
		(super init:)
		(iceMaiden init:)
		(= global119 0)
		(sparkle ignoreActors: 1 init: cycleSpeed: 1 setCycle: Fwd)
		(gEgo view: 0 init:)
		(switch gPrevRoomNum
			(31
				(self enterRoom: -10 100 40 100)
				(Load rsSOUND 53)
				(Load rsSOUND 56)
				(Load rsSOUND 57)
				(gCurRoom setScript: solvedRiddles)
			)
			(else
				(self enterRoom: 170 235 170 180)
			)
		)
		(gTObj tWindow: iceWindow init:)
		(gRmMusic number: 55 loop: -1 play:)
		(if (not (IsFlag 65))
			(lancelot init: stopUpd:)
			(iceSheet init: stopUpd:)
		)
		(proc0_13 33)
		(gAddToPics doit:)
	)

	(method (newRoom newRoomNumber)
		(gRmMusic stop:)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(cond
			((or global80 (self goingOut:) (self comingIn:)) 0)
			((and (gEgo inRect: 80 70 200 100) (not local2))
				(= local2 1)
				(gEgo setScript: turnAround)
			)
			((and (< (gEgo x:) 50) (not local2))
				(= local2 1)
				(= local3 1)
				(gEgo setScript: turnAround)
			)
			((> (gEgo y:) 185)
				(gEgo illegalBits: 0)
				(self leaveRoom: (if local1 25 else 29) (gEgo x:) 235)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((or (Said '/girl') (Said '[*]/girl') (Said '[*]//girl'))
				(Talk 30 0) ; "Gwenhyver is a girl. I am far more than that."
			)
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
				(Print 30 1) ; "Remember that finding the Grail is but half the task. You must also be worthy to possess it."
			)
			((and (not (IsFlag 66)) (Said 'help/woman[<ice]'))
				(Talk 30 2) ; "Nothing can help, save the return of the object of power which was stolen from me."
			)
			((Said 'want<you<do<what')
				(Talk 30 3) ; "That which enables me to feel warmth and love, such as the hopeless love I have for Sir Launcelot."
			)
			((and (IsFlag 66) (Said 'get,rob/heart'))
				(Print 30 4) ; "Only the Old Ones had the power to do that."
			)
			((Said 'talk[/woman]')
				(cond
					((IsFlag 66)
						(Talk 30 5 30 6 30 7) ; "Having told you what I know of the Grail, there is but one more boon you can desire of me -- the life of Sir Launcelot."
					)
					((gEgo has: 7) ; crystal_heart | charcoal | helm
						(Talk 30 8 30 9) ; "I sense that you possess something that belongs to me. Give it to me and I will tell you what even Merlin does not know -- where to search for the Grail."
					)
					(else
						(gEgo setScript: tpOut)
					)
				)
			)
			((Said 'talk,ask/lancelot')
				(Talk 30 10) ; "He cannot answer you. I have sealed his heartless lips forever, unless you choose to win his freedom."
			)
			((Said 'greet')
				(gTObj noWidth: 1)
				(Talk 30 11) ; "Blessed be."
			)
			((Said 'get/ice,stalactite')
				(Print 30 12) ; "That would not help you much."
			)
			(
				(or
					(Said 'get,deliver,deliver,help,save/lancelot')
					(Said 'win/freedom')
					(Said 'get/test')
					(Said 'ask<to/woman/lancelot<deliver')
				)
				(if (not (IsFlag 66))
					(Talk 30 13) ; "Launcelot will never go free, unless you find and return the object of power that was stolen from me."
				else
					(gCurRoom setScript: gotoFlowerRoom)
				)
			)
			((Said 'melt/ice')
				(Print 30 14) ; "You do not have the means."
			)
			((Said 'cut,annihilate/ice,column')
				(Talk 30 15) ; "No weapon made, not even Excaliber, can shatter this ice formed by my will."
			)
			((Said 'give/copper,dirham,dinar,moneybag,coin')
				(Talk 30 16) ; "Money is meaningless to me."
			)
			((and (gEgo has: 4) (Said 'give/rose')) ; rose | apple | green_apple
				(Talk 30 17) ; "I will not touch it, for it has Gwenhyver's spell upon it."
			)
			((Said 'give/key,lodestone,sleeve')
				(Talk 30 18) ; "Nay, keep it. I have no use for such a thing."
			)
			((Said 'show/heart')
				(cond
					((not (gEgo has: 7)) ; crystal_heart | charcoal | helm
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					(
						(and
							(not (gEgo inRect: 75 100 270 145))
							(not (gEgo inRect: 190 81 266 105))
						)
						(NotClose) ; "Perhaps you should move closer."
					)
					(else
						(Talk 30 19) ; "Aye, that is my heart and contains much of my power. Give it to me and I shall tell you where to search for the Grail."
					)
				)
			)
			((Said 'bargain/heart/lancelot')
				(Talk 30 20) ; "To free Launcelot will require first my good will. Do not anger me with attempts at bargaining."
			)
			((Said 'bargain/*/lancelot')
				(Talk 30 21) ; "He is worth far more than that to me."
			)
			((Said 'give/*/lancelot')
				(Talk 30 22) ; "He can accept nothing while frozen in ice."
			)
			((Said 'use,give/heart')
				(cond
					((not (gEgo has: 7)) ; crystal_heart | charcoal | helm
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					(
						(and
							(not (gEgo inRect: 75 100 270 145))
							(not (gEgo inRect: 190 81 266 105))
						)
						(NotClose) ; "Perhaps you should move closer."
					)
					(else
						(SetScore 0 0 10)
						(iceMaiden setScript: giveHeart)
					)
				)
			)
			(
				(or
					(Said 'talk,ask[/woman]>')
					(Said 'tell[/me]>')
					(Said 'are<where>')
				)
				(cond
					((or (Said '/object,power') (Said '//object,power'))
						(if (IsFlag 66)
							(Talk 30 23) ; "I thank you again for the return of the crystal heart, for much of my power is invested within it."
						else
							(Talk 30 24) ; "If you can return it to me, you will win my help."
						)
					)
					((or (Said '/coldness') (Said '//coldness'))
						(Talk 30 25) ; "The ice and cold reflects my mood of late."
					)
					((Said '//test')
						(if (not (IsFlag 66))
							(Talk 30 13) ; "Launcelot will never go free, unless you find and return the object of power that was stolen from me."
						else
							(gCurRoom setScript: gotoFlowerRoom)
						)
					)
					((Said '//excaliber')
						(Talk 30 26) ; "I gave you Excaliber because it is a sword worthy of a king. Now make sure you are a king worthy of the sword."
					)
					((or (Said '/grail') (Said '//grail'))
						(if (IsFlag 66)
							(Talk 30 27) ; "Did you not listen? Go to Jerusalem, I said."
						else
							(Talk 30 28) ; "Bring me the object of power that was stolen from me, and I will tell you where to search."
						)
					)
					((or (Said '/lancelot') (Said '//lancelot'))
						(if (IsFlag 66)
							(Talk 30 29) ; "You have but to leave and I will keep Launcelot here, far from Gwenhyver. I will not harm him, but you will be free of him."
						else
							(Talk 30 30) ; "Launcelot is my prisoner because he has spurned my love and given his heart to your wife, Gwenhyver. You should thank me, Pendragon, for thus removing your rival for her love."
						)
					)
					((or (Said '/gawain,galahad') (Said '//gawain,galahad'))
						(Talk 30 31) ; "He did not come here. Therefore I know nothing of him."
					)
					(else
						(event claimed: 1)
						(Talk 30 32) ; "Merlin is your advisor, not I."
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
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '/castle,chamber')
							(Said '//castle,chamber')
						)
						(Print 30 33) ; "Here stands the Ice Maiden, a cold and unloving manifestation of the Lady of the Lake. Near her is Sir Launcelot, imprisoned in ice."
					)
					((Said '//jerusalem,boat,port')
						(if (IsFlag 66)
							(Print 30 34) ; "To reach Jerusalem, you must take ship to the port nearest it in that part of the world."
						else
							(event claimed: 0)
						)
					)
					((or (Said '/tunnel,cave') (Said '//tunnel,cave'))
						(Print 30 35) ; "It is dark and cold and uninviting."
					)
					(
						(or
							(Said '/woman')
							(Said '//woman')
							(MouseClaimed iceMaiden event)
						)
						(Print 30 36) ; "She looks quite frigid. But if you are to free Launcelot, you must find a way to win her good will."
					)
					((or (Said '/lancelot') (Said '//lancelot'))
						(Print 30 37) ; "He is caught in a living death, spellbound in a frozen limbo."
					)
					((or (Said '/ice') (Said '//ice'))
						(Print 30 38) ; "Everything is ice, formed from the frozen body of the lake by the Ice Maiden's magicks."
					)
					((or (Said '/column') (Said '//column'))
						(Print 30 39) ; "Your good friend and heroic knight, Sir Launcelot, is frozen inside a pillar of ice."
					)
					((or (Said '/stalactite') (Said '//stalactite'))
						(Print 30 40) ; "The inside of her palace is lined with stalagmites, stalactites and pillars of ice."
					)
					((OnButton event 106 7 154 95)
						(Print 30 41) ; "These unyielding pillars of ice were formed by the Ice Maiden's will."
					)
					((OnButton event 226 6 286 105)
						(if (IsFlag 65)
							(Print 30 42) ; "This ice pillar no longer holds the frozen body of Launcelot."
						else
							(Print 30 43) ; "Sir Launcelot is imprisoned in a living death within this pillar of ice."
						)
					)
					((OnButton event 90 22 168 91)
						(Print 30 44) ; "The recesses of the ice palace fade into a shrouded glimmer of frozen shadow."
					)
				)
			)
			((Said 'kiss/woman')
				(Print 30 45) ; "Your lips would stick."
			)
			((Said 'hug,fuck/woman')
				(Print 30 46) ; "She is frigidly disinterested."
			)
			((or (Said 'draw/blade') (Said 'kill,attack,annihilate/woman'))
				(switch local0
					(0
						(Talk 30 47) ; "Do you think to threaten ME with the very sword I gave you from my own hand? Once only will I tolerate this, or you will suffer the fate of Launcelot."
						(= global125 2)
					)
					(else
						(self setScript: iceEgo)
					)
				)
				(++ local0)
			)
		)
	)
)

(instance gotoFlowerRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
				(Talk 30 48) ; "You are a noble man, Pendragon. But we will see how true is your desire to save Launcelot when you are put to the test. Follow me."
			)
			(1
				(if
					(and
						(< (gEgo x:) (+ (iceMaiden x:) 5))
						(< (gEgo y:) 115)
					)
					(gEgo setMotion: MoveTo (gEgo x:) 120 self)
				else
					(self cue:)
				)
			)
			(2
				(iceMaiden
					view: 314
					setLoop: 1
					setCycle: Walk
					ignoreActors: 1
					setMotion:
						MoveTo
						(if (> (iceMaiden x:) (gEgo x:))
							(- (gEgo x:) 20)
						else
							150
						)
						110
						self
				)
				(sparkle hide:)
				(gEgo setAvoider: (Avoid new:))
				(if (> (- (gEgo x:) (iceMaiden x:)) 20)
					(gEgo setMotion: MoveTo 100 120)
				)
			)
			(3
				(iceMaiden setMotion: MoveTo -5 110)
				(gEgo setMotion: MoveTo 10 120 self)
			)
			(4
				(HandsOn)
				(gCurRoom newRoom: 31)
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
				(gTObj talkCue: self)
				(Talk 30 49) ; "You should have heeded my warning!"
			)
			(1
				(gSFX stop: number: (proc0_20 39) loop: 1 play:)
				(= cycles 2)
			)
			(2
				(icicle
					view: 37
					setLoop: 0
					posn: (gEgo x:) (+ (gEgo y:) 4)
					init:
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(gSFX stop:)
				(= seconds 5)
			)
			(4
				(Print 30 50) ; "As icy fingers seize your spine And coldness numbs your brain You wish instead in battle hot You nobly had been slain."
				(Print 30 51) ; "Alas, your ears are filled with ice You hear not my sad refrain, A frozen statue of despair In winter's hard domain."
				(EgoDead)
			)
		)
	)
)

(instance solvedRiddles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(sparkle hide:)
				(iceMaiden
					view: 314
					posn: 20 110
					setCycle: Walk
					setMotion: MoveTo 170 110 self
				)
				(gEgo posn: 0 130 setMotion: MoveTo 140 130)
			)
			(1
				(sparkle posn: 170 110 show:)
				(iceMaiden view: 315 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(2
				(sparkle loop: 1)
				(gSFX number: (proc0_20 56) loop: 1 play:)
				(spell
					init:
					ignoreActors:
					illegalBits: 0
					setLoop: 3
					cycleSpeed: 2
					setStep: 6 2
					setCycle: End self
					setMotion: MoveTo 250 65
				)
			)
			(3
				(spell setLoop: 4 setCycle: Fwd setMotion: MoveTo 250 65 self)
			)
			(4
				(spell dispose:)
				(gSFX number: (proc0_20 53) loop: 1 play:)
				(iceSheet setCycle: End self)
			)
			(5
				(iceSheet setLoop: 2 setCel: 0 setCycle: End self)
			)
			(6
				(iceMaiden setLoop: 2 setCycle: Beg self)
			)
			(7
				(sparkle loop: 0)
				(lancelot setCycle: End self)
			)
			(8
				(Talk 30 52) ; "I shall return you to Camelot!"
				(= seconds 4)
			)
			(9
				(iceMaiden setCycle: End self)
			)
			(10
				(sparkle loop: 1)
				(lancelot setPri: (+ (lancelot priority:) 1))
				(glow
					view: 36
					setLoop: 0
					setPri: (- (lancelot priority:) 1)
					cycleSpeed: 2
					setCycle: Fwd
					ignoreActors:
					init:
				)
				(= cycles 20)
			)
			(11
				(gSFX number: (proc0_20 57) loop: 1 play:)
				(glow dispose:)
				(lancelot setLoop: 3 setCel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(12
				(SetScore 0 2 50)
				(SetFlag 65)
				(lancelot dispose:)
				(glow dispose:)
				(= seconds 2)
			)
			(13
				(iceMaiden setCycle: Beg self)
			)
			(14
				(sparkle loop: 0)
				(gTObj talkCue: self)
				(Talk 30 53) ; "I have freed Sir Launcelot and sent him back to Camelot, but your journey goes on. Farewell, King Arthur, and may you overcome every obstacle with the same wit and courage you have shown here."
			)
			(15
				(gEgo illegalBits: 0)
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
			(16
				(glow dispose:)
				(gSFX number: (proc0_20 57) play:)
				(gEgo
					view: 36
					setLoop: 1
					cycleSpeed: 1
					cel: 0
					setCycle: End self
				)
			)
			(17
				(glow dispose:)
				(= cycles 5)
			)
			(18
				(gCurRoom newRoom: 25)
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
				(if local3
					(Talk 30 54) ; "You may not pass that way, Pendragon, unless I lead you there."
				else
					(Talk 30 55) ; "You may not pass that way."
				)
				(= cycles 20)
			)
			(1
				(gEgo ignoreActors: 1)
				(if local3
					(gEgo setMotion: MoveTo 90 (gEgo y:))
				else
					(gEgo setMotion: MoveTo (gEgo x:) 105)
				)
				(= cycles 20)
			)
			(2
				(gEgo ignoreActors: 0)
				(= local3 0)
				(= local2 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance tpOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
				(Talk 30 56 30 57) ; "I sense the presence of Merlin. But I know that which he does not -- where to search for the Grail. But to win my help, you must find and return an object of power that was stolen from me."
			)
			(1
				(solvedRiddles start: 15)
				(gEgo setScript: solvedRiddles)
			)
		)
	)
)

(instance giveHeart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: illegalBits: 0)
				(cond
					((gEgo inRect: 190 81 266 105)
						(gEgo setMotion: MoveTo 200 105 self)
					)
					((< (gEgo y:) 107)
						(gEgo setMotion: MoveTo (gEgo x:) 107 self)
					)
					(else
						(gEgo setMotion: MoveTo 200 105 self)
					)
				)
			)
			(1
				(if (== (gEgo x:) 200)
					(self cue:)
				else
					(gEgo
						setLoop: (if (< (gEgo x:) 200) 0 else -1)
						setMotion: MoveTo 200 105 self
					)
				)
			)
			(2
				(gEgo view: 70 setLoop: 0 cel: 0 cycleSpeed: 1 setCycle: End)
				(iceMaiden setLoop: 5 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(3
				(gEgo setCycle: Beg)
				(heart init: setLoop: 6 cel: 0 setCycle: Fwd)
				(= cycles 16)
			)
			(4
				(heart setLoop: 7 cel: 0)
				(= cycles 16)
			)
			(5
				(heart setLoop: 8 cel: 0)
				(= cycles 16)
			)
			(6
				(heart dispose:)
				(gEgo
					setLoop: -1
					view: 0
					loop: 1
					cel: 1
					cycleSpeed: 0
					ignoreActors: 0
					illegalBits: $8000
					setCycle: Walk
				)
				(SetFlag 66)
				(PutItem 7 30) ; crystal_heart | charcoal | helm
				(iceMaiden setLoop: 2 cel: 0)
				(gTObj talkCue: self)
				(Talk 30 58 30 59 30 60) ; "Blessed be! For this greatest of all gifts, I will give you the gift of knowledge in return."
			)
			(7
				(= local1 1)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

